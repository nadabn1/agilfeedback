package agilefeedback.mapper;

import agilefeedback.Dto.AdminDto;
import agilefeedback.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminMapper {
    AdminDto toDto(Admin admin);
    Admin toEntity(AdminDto adminDto);
}
