package PosBackend.Service;


import PosBackend.Domain.Commande;
import PosBackend.Dto.commande.CommandeDto;

import java.util.List;

public interface CommandeService {
    Commande addCommande(CommandeDto commandeDto);

    List<CommandeDto> getCommandes();
    List<CommandeDto> getCommandesInEntrepot(String idEntrepot);

    void deleteCommande(String id);

    List<CommandeDto> getManagerConnectedCommandes();
}
