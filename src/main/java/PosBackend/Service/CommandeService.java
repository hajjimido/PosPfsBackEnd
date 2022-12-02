package PosBackend.Service;

import PosBackend.Domain.Commande;
import PosBackend.Dto.commande.CommandeDto;

public interface CommandeService {
    Commande addCommande(CommandeDto commandeDto);
}
