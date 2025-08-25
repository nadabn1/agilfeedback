package agilefeedback.service;

import agilefeedback.Dto.ProjetDto;

import java.util.List;
import java.util.Optional;

public interface ProjetService {
    ProjetDto createProjet(ProjetDto projetDto);
    void deleteProjet(Long id);
    List<ProjetDto> getAllProjets();
    Optional<ProjetDto> getProjetById(Long id);
    ProjetDto updateProjet(Long id, ProjetDto projetDto);
}
