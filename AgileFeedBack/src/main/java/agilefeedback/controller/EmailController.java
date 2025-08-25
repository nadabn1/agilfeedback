package agilefeedback.controller;

import agilefeedback.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/emailsender")
@RestController
public class EmailController {

    private final MailService emailService;
    public EmailController(MailService emailService) { this.emailService = emailService; }

    @GetMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestParam String to,
                                            @RequestParam String subject,
                                            @RequestParam String body) {
        emailService.sendEmail(to, subject, body);
        return ResponseEntity.ok("email envoyé avec succès (plain text).");
    }

    @PostMapping("/sendHtml")
    public ResponseEntity<String> sendHtml(@RequestBody SendHtmlRequest req) {
        emailService.sendHtml(req.to, req.subject, req.html);
        return ResponseEntity.ok("email envoyé avec succès (HTML).");
    }

    public static class SendHtmlRequest {
        public String to;
        public String subject;
        public String html;
    }
}
