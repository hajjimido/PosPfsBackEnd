package PosBackend.Service.Impl;

import PosBackend.Domain.Commande;
import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.commande.CommandeDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Mapper.CommandeMapper;
import PosBackend.Repository.CommandeRepository;
import PosBackend.Repository.ProduitRepository;
import PosBackend.Repository.VendeurRepository;
import PosBackend.Service.CommandeService;
import PosBackend.Service.ManagerService;
import PosBackend.Service.ProduitService;
import PosBackend.advice.Exception.UserException;
import PosBackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final CommandeMapper commandeMapper;
    private final ProduitRepository produitRepository;
    private final VendeurRepository vendeurRepository;
    private final CommandeRepository commandeRepository;
    private final ProduitService produitService;
    private final ManagerService managerService;
    @Override
    @Transactional
    public Commande addCommande(CommandeDto commandeDto) {
        for(ProduitDto produitDto : commandeDto.getProduits()) {
            produitService.extractFromProduit(produitDto);
        }
        Commande commande= commandeMapper.toBo(commandeDto);
        Optional<Vendeur> vendeur=vendeurRepository.findById(commandeDto.getIdVendeur());
        if (vendeur.isPresent()) {
            commande.setVendeur(vendeur.get());
            return commandeRepository.save(commande);
        }
        throw new UserException("sorry cant create commande");

    }

    @Override
    public List<CommandeDto> getCommandes() {
        return commandeMapper.toDto(commandeRepository.findAll());
    }

    @Override
    public List<CommandeDto> getCommandesInEntrepot(String idEntrepot) {
        return commandeMapper.toDto(commandeRepository.findByVendeur_Manager_Entrepot_Id(idEntrepot));
    }

    @Override
    public void deleteCommande(String id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public List<CommandeDto> getManagerConnectedCommandes() {
        String emailManager= SecurityUtils.getUserEmail().get();
        Manager manager=managerService.findManagerByEmail(emailManager);
         return commandeMapper.toDto(commandeRepository.findByVendeur_Manager(manager));

    }
}
