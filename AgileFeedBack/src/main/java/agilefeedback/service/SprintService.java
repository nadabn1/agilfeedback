package agilefeedback.service;


import agilefeedback.Dto.SprintDto;

public interface SprintService {
    SprintDto addSprintToBacklog(Long backlogId, SprintDto sprintDto);
    void deleteSprint(Long sprintId);
}
