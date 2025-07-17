package agilefeedback.service;


import agilefeedback.Dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();
    RoleDto getRoleById(Long id);
    RoleDto createRole(RoleDto roleDto);
    RoleDto updateRole(Long id, RoleDto roleDto);
    void deleteRole(Long id);
}