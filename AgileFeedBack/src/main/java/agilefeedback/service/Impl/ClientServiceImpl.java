package agilefeedback.service.Impl;


import agilefeedback.Dto.ClientDto;
import agilefeedback.mapper.ClientMapper;
import agilefeedback.model.Client;
import agilefeedback.repository.ClientRepository;
import agilefeedback.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDto(client);
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) throw new RuntimeException("Client not found");
        clientRepository.deleteById(id);
    }
}
