package agilefeedback.service.Impl;

import agilefeedback.Dto.PoDto;
import agilefeedback.mapper.PoMapper;
import agilefeedback.repository.PoRepository;
import agilefeedback.service.PoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PoServiceImpl implements PoService {
    private final PoRepository poRepository;
    private final PoMapper poMapper;

    @Override
    public List<PoDto> getAllPos() {
        return poRepository.findAll().stream().map(poMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PoDto getPoById(Long id) {
        return poMapper.toDto(poRepository.findById(id).orElseThrow());
    }

    @Override
    public PoDto createPo(PoDto poDto) {
        return poMapper.toDto(poRepository.save(poMapper.toEntity(poDto)));
    }

    @Override
    public void deletePo(Long id) {
        poRepository.deleteById(id);
    }
}

