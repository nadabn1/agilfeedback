package agilefeedback.mapper;

import agilefeedback.Dto.RoleDto;
import agilefeedback.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto toDto(Role role);
    Role toEntity(RoleDto roleDto);
}