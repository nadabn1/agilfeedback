package agilefeedback.service.Impl;


import agilefeedback.Dto.AdminDto;
import agilefeedback.mapper.AdminMapper;
import agilefeedback.model.Admin;
import agilefeedback.repository.AdminRepository;
import agilefeedback.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    public List<AdminDto> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(adminMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto getAdminById(Long id) {
        return adminMapper.toDto(adminRepository.findById(id).orElseThrow());
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = adminMapper.toEntity(adminDto);
        return adminMapper.toDto(adminRepository.save(admin));
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}