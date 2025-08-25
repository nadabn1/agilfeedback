package agilefeedback.mapper;

import agilefeedback.Dto.FeedbackDto;
import agilefeedback.model.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    FeedbackDto toDto(Feedback e);
    Feedback toEntity(FeedbackDto d);
}
