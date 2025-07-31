package agilefeedback.service;


import agilefeedback.Dto.AdminDto;

import java.util.List;

public interface AdminService {
    List<AdminDto> getAllAdmins();
    AdminDto getAdminById(Long id);
    AdminDto createAdmin(AdminDto adminDto);
    void deleteAdmin(Long id);
}