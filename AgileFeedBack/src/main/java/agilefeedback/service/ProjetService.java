package agilefeedback.service;

import agilefeedback.Dto.ProjetDto;

import java.util.List;

public interface ProjetService {
    ProjetDto createProjet(ProjetDto projetDto);
    void deleteProjet(Long id);
    List<ProjetDto> getAllProjets();
}