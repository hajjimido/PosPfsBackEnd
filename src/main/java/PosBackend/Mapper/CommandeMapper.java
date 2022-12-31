package PosBackend.Mapper;

import PosBackend.Domain.Commande;
import PosBackend.Dto.commande.CommandeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande toBo(CommandeDto commandeDto);
    @Mapping(source = "vendeur.id",target = "idVendeur")
    CommandeDto toDto(Commande commande);
    List<CommandeDto> toDto(List<Commande> commandes);
    List<Commande> toBo(List<CommandeDto> commandes);
}
