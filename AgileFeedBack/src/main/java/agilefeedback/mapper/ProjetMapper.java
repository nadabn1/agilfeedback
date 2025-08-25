package agilefeedback.mapper;


import agilefeedback.Dto.ProjetDto;
import agilefeedback.model.Projet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjetMapper {
    ProjetDto toDto(Projet projet);
    Projet toEntity(ProjetDto projetDto);
    void updateEntityFromDto(ProjetDto dto, @MappingTarget Projet entity);
}

