package agilefeedback.service.Impl;

import agilefeedback.Dto.SmDto;
import agilefeedback.mapper.SmMapper;
import agilefeedback.repository.SmRepository;
import agilefeedback.service.SmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SmServiceImpl implements SmService {
    private final SmRepository smRepository;
    private final SmMapper smMapper;

    @Override
    public List<SmDto> getAllSms() {
        return smRepository.findAll().stream().map(smMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SmDto getSmById(Long id) {
        return smMapper.toDto(smRepository.findById(id).orElseThrow());
    }

    @Override
    public SmDto createSm(SmDto smDto) {
        return smMapper.toDto(smRepository.save(smMapper.toEntity(smDto)));
    }

    @Override
    public void deleteSm(Long id) {
        smRepository.deleteById(id);
    }
}
