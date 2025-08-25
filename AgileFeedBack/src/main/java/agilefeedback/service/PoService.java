package agilefeedback.service;

import agilefeedback.Dto.PoDto;

import java.util.List;

public interface PoService {
    List<PoDto> getAllPos();
    PoDto getPoById(Long id);
    PoDto createPo(PoDto poDto);
    void deletePo(Long id);
}
