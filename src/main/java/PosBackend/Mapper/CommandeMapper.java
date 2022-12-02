package PosBackend.Mapper;

import PosBackend.Domain.Commande;
import PosBackend.Dto.commande.CommandeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande toBo(CommandeDto commandeDto);
    CommandeDto toDto(Commande commande);
}
