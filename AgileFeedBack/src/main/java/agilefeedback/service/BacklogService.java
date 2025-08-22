package agilefeedback.service;


import agilefeedback.Dto.BacklogDto;

public interface BacklogService {
    BacklogDto createBacklogForProjet(Long projetId);
    BacklogDto getBacklogByProjet(Long projetId);
}
