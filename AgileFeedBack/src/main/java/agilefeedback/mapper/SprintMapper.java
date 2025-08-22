package agilefeedback.mapper;


import agilefeedback.Dto.SprintDto;
import agilefeedback.model.Sprint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SprintMapper {
    @Mapping(source = "backlog.id", target = "backlogId")
    SprintDto toDto(Sprint sprint);

    @Mapping(source = "backlogId", target = "backlog.id")
    Sprint toEntity(SprintDto sprintDto);
}
