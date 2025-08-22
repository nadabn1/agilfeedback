package agilefeedback.service.Impl;


import agilefeedback.Dto.BacklogDto;
import agilefeedback.mapper.BacklogMapper;
import agilefeedback.model.Backlog;
import agilefeedback.model.Projet;
import agilefeedback.repository.BacklogRepository;
import agilefeedback.repository.ProjetRepository;
import agilefeedback.service.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService {

    private final BacklogRepository backlogRepository;
    private final ProjetRepository projetRepository;
    private final BacklogMapper backlogMapper;

    @Override
    public BacklogDto createBacklogForProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        Backlog backlog = new Backlog();
        backlog.setProjet(projet);

        return backlogMapper.toDto(backlogRepository.save(backlog));
    }

    @Override
    public BacklogDto getBacklogByProjet(Long projetId) {
        Backlog backlog = backlogRepository.findByProjetId(projetId);
        if (backlog == null) throw new RuntimeException("Backlog introuvable");
        return backlogMapper.toDto(backlog);
    }
}
