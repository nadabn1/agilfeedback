package agilefeedback.controller;

import agilefeedback.Dto.FeedbackDto;
import agilefeedback.Dto.FeedbackSubmitDto;
import agilefeedback.Dto.ValidateResponse;
import agilefeedback.service.FeedbackInviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/feedback")
@RequiredArgsConstructor
public class PublicFeedbackInviteController {

    private final FeedbackInviteService inviteService;

    @GetMapping("/validate/{token}")
    public ResponseEntity<ValidateResponse> validate(@PathVariable String token) {
        return ResponseEntity.ok(inviteService.validateToken(token));
    }

    @PostMapping("/consume")
    public ResponseEntity<FeedbackDto> consume(@RequestBody FeedbackSubmitDto dto) {
        return ResponseEntity.ok(inviteService.consumeAndCreateFeedback(dto));
    }
}
