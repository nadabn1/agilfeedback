package agilefeedback.mapper;


import agilefeedback.Dto.BacklogDto;
import agilefeedback.model.Backlog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BacklogMapper {
    @Mapping(source = "projet.id", target = "projetId")
    BacklogDto toDto(Backlog backlog);

    @Mapping(source = "projetId", target = "projet.id")
    Backlog toEntity(BacklogDto backlogDto);
}
