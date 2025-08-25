// agilefeedback/service/Impl/SprintServiceImpl.java
package agilefeedback.service.Impl;

import agilefeedback.Dto.SprintDto;
import agilefeedback.mapper.SprintMapper;
import agilefeedback.model.Backlog;
import agilefeedback.model.Sprint;
import agilefeedback.model.Enum.StatutSprint;
import agilefeedback.repository.BacklogRepository;
import agilefeedback.repository.SprintRepository;
import agilefeedback.service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;
    private final BacklogRepository backlogRepository;
    private final SprintMapper sprintMapper;

    @Override
    public SprintDto addSprintToBacklog(Long backlogId, SprintDto sprintDto) {
        Backlog backlog = backlogRepository.findById(backlogId)
                .orElseThrow(() -> new RuntimeException("Backlog introuvable"));

        Sprint sprint = sprintMapper.toEntity(sprintDto);
        sprint.setBacklog(backlog);

        return sprintMapper.toDto(sprintRepository.save(sprint));
    }

    @Override
    public void deleteSprint(Long sprintId) {
        sprintRepository.deleteById(sprintId);
    }

    @Override
    public SprintDto updateStatus(Long sprintId, StatutSprint statut) {
        Sprint s = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint introuvable"));
        s.setStatut(statut);
        Sprint saved = sprintRepository.save(s);
        SprintDto dto = sprintMapper.toDto(saved);


        return dto;
    }
}
