package PosBackend.Service.Impl;

import PosBackend.Domain.Categorie;
import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Mapper.ProduitMapper;
import PosBackend.Repository.CategorieRepository;
import PosBackend.Repository.ProduitRepository;
import PosBackend.Service.ProduitService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private final CategorieRepository categorieRepository;
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;
    @Override
    public Produit addProduit(CreateProduitDto createProduitDto) {
        Optional<Categorie> categorie=categorieRepository.findByNameCategorie(createProduitDto.getNameCatgorie());
        if(categorie.isEmpty()){
            throw new UserException("sorry cant create produit");
        }
        Produit produit=produitMapper.toBo(createProduitDto);
       produit.setCategorie(categorie.get());

        return produitRepository.save(produit);
    }

    @Override
    public String deleteProduit(String reference) {
        Optional<Produit> produit=produitRepository.findByreference(reference);
        if(produit.isEmpty()){
            throw new UserException("sorry produit not found");
        }
        produitRepository.delete(produit.get());
        return "categorie deleted";
    }

    @Override
    public Produit updateProduit(ProduitDto produitDto) {
        Optional<Produit> produit=produitRepository.findByreference(produitDto.getReference());
        if(produit.isEmpty()){
            throw new UserException("sorry produit not found");
        }
        return produitRepository.save(produitMapper.toBo(produitDto));
    }

    @Override
    public void extractFromProduit(ProduitDto produitFromCommande) {
        Optional<Produit> produit=produitRepository.findById(produitFromCommande.getId());
        if(produit.isEmpty()){
            throw new UserException("sorry produit not found");

        }
        else {
           produitRepository.save(updateProduitQuantite(produit.get(),produitFromCommande.getQuantite()));
        }
    }
    private Produit updateProduitQuantite(Produit produit,int quantiteToSoustract) {
        if (produit.getQuantite() >= quantiteToSoustract){
            produit.setQuantite(produit.getQuantite() - quantiteToSoustract);
        return produit;
    }
        throw new UserException("sorry en pas la quantites de produit demandé du produit "+produit.getReference() );
    }
}
