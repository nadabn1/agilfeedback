package agilefeedback.mapper;

import agilefeedback.Dto.SmDto;
import agilefeedback.model.Sm;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SmMapper {
    SmDto toDto(Sm sm);
    Sm toEntity(SmDto smDto);
}

