package agilefeedback.mapper;

import agilefeedback.Dto.RoleDto;
import agilefeedback.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role role);
    Role toEntity(RoleDto roleDto);
}
