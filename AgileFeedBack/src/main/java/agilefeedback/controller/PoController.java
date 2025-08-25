package agilefeedback.controller;

import agilefeedback.Dto.PoDto;
import agilefeedback.service.PoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/po")
@RequiredArgsConstructor
public class PoController {
    private final PoService poService;

    @GetMapping
    public List<PoDto> getAllPos() {
        return poService.getAllPos();
    }

    @GetMapping("/{id}")
    public PoDto getPoById(@PathVariable Long id) {
        return poService.getPoById(id);
    }

    @PostMapping
    public PoDto createPo(@RequestBody PoDto poDto) {
        return poService.createPo(poDto);
    }

    @DeleteMapping("/{id}")
    public void deletePo(@PathVariable Long id) {
        poService.deletePo(id);
    }
}
