package PosBackend.Mapper;

import PosBackend.Domain.Client;
import PosBackend.Dto.user.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toBo(ClientDto clientDto);
    ClientDto toDto(Client client);
}
