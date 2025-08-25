package agilefeedback.controller;

import agilefeedback.Dto.InviteRequest;
import agilefeedback.model.FeedbackInvite;
import agilefeedback.service.FeedbackInviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/feedback")
@RequiredArgsConstructor
public class AdminFeedbackInviteController {

    private final FeedbackInviteService inviteService;

    @PostMapping("/invite")
    public ResponseEntity<?> invite(@RequestBody InviteRequest req) {
        FeedbackInvite inv = inviteService.createAndSendInvite(req);
        String link = "http://localhost:4200/feedback/" + inv.getToken(); // front par défaut (override via prop)
        return ResponseEntity.ok(Map.of(
                "token", inv.getToken(),
                "link", link,
                "expiresAt", inv.getExpiresAt()
        ));
    }
}
