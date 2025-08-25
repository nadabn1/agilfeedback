package agilefeedback.controller;

import agilefeedback.Dto.SmDto;
import agilefeedback.service.SmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sm")
@RequiredArgsConstructor
public class SmController {
    private final SmService smService;

    @GetMapping
    public List<SmDto> getAllSms() {
        return smService.getAllSms();
    }

    @GetMapping("/{id}")
    public SmDto getSmById(@PathVariable Long id) {
        return smService.getSmById(id);
    }

    @PostMapping
    public SmDto createSm(@RequestBody SmDto smDto) {
        return smService.createSm(smDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSm(@PathVariable Long id) {
        smService.deleteSm(id);
    }
}

