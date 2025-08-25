package agilefeedback.controller;

import agilefeedback.Dto.BacklogDto;
import agilefeedback.service.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/backlogs")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;

    @PostMapping("/projet/{projetId}")
    public BacklogDto createBacklog(@PathVariable Long projetId) {
        return backlogService.createBacklogForProjet(projetId);
    }

    @GetMapping("/projet/{projetId}")
    public BacklogDto getBacklogByProjet(@PathVariable Long projetId) {
        return backlogService.getBacklogByProjet(projetId);
    }
}
