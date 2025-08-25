// src/main/java/agilefeedback/service/SprintService.java
package agilefeedback.service;

import agilefeedback.Dto.SprintDto;
import agilefeedback.model.Enum.StatutSprint;

public interface SprintService {
    SprintDto addSprintToBacklog(Long backlogId, SprintDto sprintDto);
    void deleteSprint(Long sprintId);


    SprintDto updateStatus(Long sprintId, StatutSprint statut);
}
