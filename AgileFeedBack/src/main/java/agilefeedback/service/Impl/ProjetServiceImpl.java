package agilefeedback.service.Impl;

import agilefeedback.Dto.ProjetDto;
import agilefeedback.mapper.ProjetMapper;
import agilefeedback.model.Projet;
import agilefeedback.repository.ProjetRepository;
import agilefeedback.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;
    private final ProjetMapper projetMapper;

    @Override
    public ProjetDto createProjet(ProjetDto projetDto) {
        Projet projet = projetMapper.toEntity(projetDto);
        return projetMapper.toDto(projetRepository.save(projet));
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public List<ProjetDto> getAllProjets() {
        return projetRepository.findAll()
                .stream()
                .map(projetMapper::toDto)
                .collect(Collectors.toList());
    }
}
