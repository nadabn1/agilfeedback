package agilefeedback.service;

import agilefeedback.Dto.ClientDto;
import java.util.List;

public interface ClientService {
    List<ClientDto> getAllClients();
    ClientDto getClientById(Long id);
    ClientDto createClient(ClientDto clientDto);
    void deleteClient(Long id);
}
