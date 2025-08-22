package agilefeedback.controller;


import agilefeedback.Dto.SprintDto;
import agilefeedback.service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sprints")
@RequiredArgsConstructor
public class SprintController {

    private final SprintService sprintService;

    @PostMapping("/backlog/{backlogId}")
    public SprintDto addSprint(@PathVariable Long backlogId, @RequestBody SprintDto sprintDto) {
        return sprintService.addSprintToBacklog(backlogId, sprintDto);
    }

    @DeleteMapping("/{sprintId}")
    public void deleteSprint(@PathVariable Long sprintId) {
        sprintService.deleteSprint(sprintId);
    }
}
