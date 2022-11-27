package PosBackend.Mapper;

import PosBackend.Domain.Entrepot;
import PosBackend.Dto.entrepot.EntrepotDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntrepotMapper {
    Entrepot toBo(EntrepotDto entrepotDto);
    EntrepotDto toDto(Entrepot entrepot);
}
