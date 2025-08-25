package agilefeedback.service;

import agilefeedback.Dto.FeedbackDto;
import java.util.List;

public interface FeedbackService {
    FeedbackDto createFeedback(FeedbackDto feedbackDto);
    List<FeedbackDto> getAllFeedbacks();
}
