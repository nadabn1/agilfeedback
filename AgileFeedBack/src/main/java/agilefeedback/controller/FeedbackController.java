package agilefeedback.controller;

import agilefeedback.Dto.FeedbackDto;
import agilefeedback.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public FeedbackDto createFeedback(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.createFeedback(feedbackDto);
    }

    @GetMapping
    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
}
