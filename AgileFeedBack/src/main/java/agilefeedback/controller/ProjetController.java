package agilefeedback.controller;

import agilefeedback.Dto.ProjetDto;
import agilefeedback.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/projets")
@RequiredArgsConstructor
public class ProjetController {

    private final ProjetService projetService;

    @PostMapping
    public ProjetDto createProjet(@RequestBody ProjetDto projetDto) {
        return projetService.createProjet(projetDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
    }

    @GetMapping
    public List<ProjetDto> getAllProjets() {
        return projetService.getAllProjets();
    }
}
