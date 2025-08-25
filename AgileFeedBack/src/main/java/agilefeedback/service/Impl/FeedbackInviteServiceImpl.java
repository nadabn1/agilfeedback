package agilefeedback.service.Impl;


import agilefeedback.Dto.*;
import agilefeedback.model.Feedback;
import agilefeedback.model.FeedbackInvite;
import agilefeedback.repository.FeedbackInviteRepository;
import agilefeedback.repository.FeedbackRepository;
import agilefeedback.service.FeedbackInviteService;
import agilefeedback.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service @Transactional
public class FeedbackInviteServiceImpl implements FeedbackInviteService {

    private final FeedbackInviteRepository inviteRepo;
    private final FeedbackRepository feedbackRepo;
    private final MailService mailService;

    @Value("${app.frontend.publicFormBase:http://localhost:4200/feedback}")
    private String publicFormBase;

    public FeedbackInviteServiceImpl(FeedbackInviteRepository inviteRepo, FeedbackRepository feedbackRepo, MailService mailService) {
        this.inviteRepo = inviteRepo;
        this.feedbackRepo = feedbackRepo;
        this.mailService = mailService;
    }

    @Override
    public ValidateResponse validateToken(String token) {
        var opt = inviteRepo.findByToken(token);
        if (opt.isEmpty()) return new ValidateResponse(false, "invalid", null, null);
        var inv = opt.get();
        if (inv.getUsedAt() != null) return new ValidateResponse(false, "used", inv.getClientFullName(), inv.getClientId());
        if (inv.getExpiresAt() != null && Instant.now().isAfter(inv.getExpiresAt()))
            return new ValidateResponse(false, "expired", inv.getClientFullName(), inv.getClientId());
        return new ValidateResponse(true, "ok", inv.getClientFullName(), inv.getClientId());
    }

    @Override
    public FeedbackDto consumeAndCreateFeedback(FeedbackSubmitDto dto) {
        var inv = inviteRepo.findByToken(dto.getToken()).orElseThrow(() -> new IllegalArgumentException("invalid"));
        if (inv.getUsedAt() != null) throw new IllegalStateException("used");
        if (inv.getExpiresAt() != null && Instant.now().isAfter(inv.getExpiresAt()))
            throw new IllegalStateException("expired");

        var f = new Feedback();
        f.setType(dto.getType());
        f.setCommentaire(dto.getCommentaire());
        f.setClientId(inv.getClientId());
        f.setClientFullName(inv.getClientFullName());
        feedbackRepo.save(f);

        inv.setUsedAt(Instant.now());
        inviteRepo.save(inv);

        var out = new FeedbackDto();
        out.setId(f.getId());
        out.setType(f.getType());
        out.setCommentaire(f.getCommentaire());
        out.setClientId(f.getClientId());
        out.setClientFullName(f.getClientFullName());
        return out;
    }

    @Override
    public FeedbackInvite createAndSendInvite(InviteRequest request) {
        String token = UUID.randomUUID().toString().replace("-", "");
        while (inviteRepo.existsByToken(token)) {
            token = UUID.randomUUID().toString().replace("-", "");
        }

        var inv = new FeedbackInvite();
        inv.setToken(token);
        inv.setClientId(request.getClientId());
        inv.setProjetId(request.getProjetId());
        inv.setEmail(request.getEmail());
        inv.setClientFullName(request.getClientFullName());
        int days = request.getDaysValid() == null ? 7 : request.getDaysValid();
        inv.setExpiresAt(Instant.now().plus(days, ChronoUnit.DAYS));
        inviteRepo.save(inv);

        String linkBase = publicFormBase.endsWith("/") ? publicFormBase : publicFormBase + "/";
        String link = linkBase + token;

        String name = request.getClientFullName() == null || request.getClientFullName().isBlank()
                ? "cher client" : request.getClientFullName();

        String html = """
            <div style="font-family:Arial,sans-serif;line-height:1.5">
              <h2>Votre avis nous intéresse</h2>
              <p>Bonjour %s,</p>
              <p>Merci de remplir ce court formulaire :</p>
              <p><a href="%s" style="background:#4b4bd6;color:#fff;padding:10px 14px;border-radius:8px;text-decoration:none">Donner mon feedback</a></p>
              <p style="color:#555">Si vous n'êtes pas concerné, ignorez cet email.</p>
            </div>
        """.formatted(name, link);

        mailService.sendHtml(request.getEmail(), "Votre avis nous intéresse", html);
        return inv;
    }
}

