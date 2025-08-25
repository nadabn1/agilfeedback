package agilefeedback.service.Impl;

import agilefeedback.Dto.ProjetDto;
import agilefeedback.mapper.ProjetMapper;
import agilefeedback.model.Projet;
import agilefeedback.repository.ProjetRepository;
import agilefeedback.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;
    private final ProjetMapper projetMapper;

    @Override
    public List<ProjetDto> getAllProjets() {
        return projetRepository.findAll()
                .stream()
                .map(projetMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProjetDto> getProjetById(Long id) {
        return projetRepository.findById(id).map(projetMapper::toDto);
    }

    @Override
    public ProjetDto createProjet(ProjetDto projetDto) {
        Projet entity = projetMapper.toEntity(projetDto);
        Projet saved = projetRepository.save(entity);
        return projetMapper.toDto(saved);
    }

    @Override
    @Transactional
    public ProjetDto updateProjet(Long id, ProjetDto projetDto) {
        Projet existing = projetRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Projet not found with id=" + id));

        // ✅ Update "in-place" via MapStruct
        projetMapper.updateEntityFromDto(projetDto, existing);

        // sécurité : on force l'id
        existing.setId(id);

        Projet saved = projetRepository.save(existing);
        return projetMapper.toDto(saved);
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }
}
