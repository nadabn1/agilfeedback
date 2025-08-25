package agilefeedback.service;

import agilefeedback.Dto.SmDto;

import java.util.List;

public interface SmService {
    List<SmDto> getAllSms();
    SmDto getSmById(Long id);
    SmDto createSm(SmDto smDto);
    void deleteSm(Long id);
}
