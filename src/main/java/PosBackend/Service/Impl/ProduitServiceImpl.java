package PosBackend.Service.Impl;

import PosBackend.Domain.Categorie;
import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.produit.CreateSharedProduitDto;
import PosBackend.Mapper.ProduitMapper;
import PosBackend.Repository.CategorieRepository;
import PosBackend.Repository.EntrepotRepository;
import PosBackend.Repository.ProduitRepository;
import PosBackend.Service.ProduitService;
import PosBackend.Service.SharedProductService;
import PosBackend.advice.Exception.UserException;
import PosBackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private final CategorieRepository categorieRepository;
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    private final SharedProductService sharedProductService;
    private final EntrepotRepository entrepotRepository;
    @Override
    public void addProduit(CreateProduitDto createProduitDto) {
        Optional<Categorie> categorie=categorieRepository.findByNameCategorie(createProduitDto.getNameCategorie());
        if(categorie.isEmpty()){
            throw new UserException("sorry cant create produit");
        }
        Produit produit=produitMapper.toBo(createProduitDto);
        produit.setCategorie(categorie.get());
        produitRepository.save(produit);
        if(createProduitDto.getEntrepotDto()!=null) {

            Optional<Entrepot>  entrepot=entrepotRepository.findByName(createProduitDto.getEntrepotDto());
            if (entrepot.isEmpty()) {
                throw new UserException("sorry cant create produit");
            }
            CreateSharedProduitDto createSharedProduitDto=new CreateSharedProduitDto(createProduitDto.getReference(),createProduitDto.getEntrepotDto(),createProduitDto.getQuantite());
            addProduitToEntrepot(createSharedProduitDto);

        }

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
        Optional<Produit> produit=produitRepository.findByreference(produitDto.getId());
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

    @Override
    public List<ProduitDto> getAllProduct() {
        return produitMapper.toDto(produitRepository.findAll());
    }

    @Override
    public void addProduitToEntrepot(CreateSharedProduitDto createSharedProduitDto) {
        Optional<Produit> produit=produitRepository.findByreference(createSharedProduitDto.getReference());
        Optional<Entrepot> entrepot=entrepotRepository.findByName(createSharedProduitDto.getNameEntrepot());
        if(produit.isEmpty()  ){
            throw new UserException("sorry shared this product ,product not found");
        }
        if( entrepot.isEmpty() ){
            throw new UserException("sorry shared this product ,entrepot not found");
        }


        sharedProductService.addProductToEnrepot(entrepot.get(),produit.get(), createSharedProduitDto.getCapacite());


    }

    @Override
    public void deleteProduitFromEntrepot(String sharedProductinEntrepot) {
        sharedProductService.deleteSharedProduct(sharedProductinEntrepot);
    }

    @Override
    public ProduitDto getProduitById(String produitId) {
        Optional<Produit> produit=produitRepository.findById(produitId);
        return  produitMapper.toDto(produit.get());

    }

    @Override
    public ProduitDto getProduitByRef(String produitref) {
        Optional<Produit> produit=produitRepository.findByreference(produitref);
        return  produitMapper.toDto(produit.get());
    }

    private Produit updateProduitQuantite(Produit produit,int quantiteToSoustract) {
        if (produit.getQuantite() >= quantiteToSoustract){
            produit.setQuantite(produit.getQuantite() - quantiteToSoustract);
        return produit;
    }
        throw new UserException("sorry en pas la quantites de produit demandé du produit "+produit.getReference() );
    }
}
