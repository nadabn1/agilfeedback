package agilefeedback.service.Impl;


import agilefeedback.Dto.FeedbackDto;
import agilefeedback.mapper.FeedbackMapper;
import agilefeedback.model.Feedback;
import agilefeedback.repository.FeedbackRepository;
import agilefeedback.service.FeedbackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback entity = feedbackMapper.toEntity(feedbackDto);
        Feedback saved  = feedbackRepository.save(entity);
        return feedbackMapper.toDto(saved);
    }

    @Override
    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackRepository.findAll().stream().map(feedbackMapper::toDto).collect(Collectors.toList());
    }
}
