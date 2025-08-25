// src/main/java/agilefeedback/controller/SprintController.java
package agilefeedback.controller;

import agilefeedback.Dto.SprintDto;
import agilefeedback.model.Enum.StatutSprint;
import agilefeedback.service.SprintService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sprints")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
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

    // ⬇️⬇️⬇️  AJOUTER ÇA
    @PatchMapping("/{sprintId}/status")
    public SprintDto updateStatus(@PathVariable Long sprintId, @RequestBody UpdateStatusBody body) {
        return sprintService.updateStatus(sprintId, body.getStatut());
    }

    @Data
    public static class UpdateStatusBody {
        private StatutSprint statut; // NOT_STARTED | IN_PROGRESS | COMPLETED | CANCELLED
    }
}
