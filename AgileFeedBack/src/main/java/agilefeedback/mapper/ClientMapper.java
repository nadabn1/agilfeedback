package agilefeedback.mapper;

import agilefeedback.Dto.ClientDto;
import agilefeedback.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client e);
    Client toEntity(ClientDto d);
}
