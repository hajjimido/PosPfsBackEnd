package PosBackend.Service.Impl;

import PosBackend.Domain.Commande;
import PosBackend.Domain.Produit;
import PosBackend.Dto.commande.CommandeDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Mapper.CommandeMapper;
import PosBackend.Repository.CommandeRepository;
import PosBackend.Repository.ProduitRepository;
import PosBackend.Service.CommandeService;
import PosBackend.Service.ProduitService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final CommandeMapper commandeMapper;
    private final ProduitRepository produitRepository;
    private final CommandeRepository commandeRepository;
    private final ProduitService produitService;
    @Override
    @Transactional
    public Commande addCommande(CommandeDto commandeDto) {
        for(ProduitDto produitDto : commandeDto.getProduits()) {
            produitService.extractFromProduit(produitDto);
        }
        return commandeRepository.save(commandeMapper.toBo(commandeDto));
    }
}
