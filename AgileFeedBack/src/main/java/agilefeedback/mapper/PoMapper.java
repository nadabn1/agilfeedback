package agilefeedback.mapper;

import agilefeedback.Dto.PoDto;
import agilefeedback.model.PO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PoMapper {
    PoDto toDto(PO po);
    PO toEntity(PoDto poDto);
}
