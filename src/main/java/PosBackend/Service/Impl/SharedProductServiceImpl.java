package PosBackend.Service.Impl;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Produit;
import PosBackend.Domain.SharedProduct;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Mapper.ProduitMapper;
import PosBackend.Repository.SharedProductRepository;
import PosBackend.Service.SharedProductService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SharedProductServiceImpl implements SharedProductService {
    private final SharedProductRepository sharedProductRepository;
    private final ProduitMapper produitMapper;

    @Override
    public void addProductToEnrepot(Entrepot entrepot, Produit produit,int capacite) {
        SharedProduct sharedProduct;
        Optional<SharedProduct> optionalSharedProduct=sharedProductRepository.findByProduitAndEntrepot(produit,entrepot);
       if(optionalSharedProduct.isPresent()) {
           sharedProduct=optionalSharedProduct.get();
           if (sharedProduct.getCapacite() + capacite <= produit.getQuantite()) {
               sharedProduct.setCapacite(sharedProduct.getCapacite() + capacite);
               sharedProductRepository.save(sharedProduct);
           } else throw new UserException("sorry can not shared product you don t have enouph capacity ");
       }
       else {
           sharedProduct=new SharedProduct();
           sharedProduct.setProduit(produit);
           sharedProduct.setEntrepot(entrepot);
           sharedProduct.setCapacite(capacite);
           sharedProductRepository.save(sharedProduct);
       }

    }

    @Override
    public void deleteSharedProduct(String sharedProduct) {
        sharedProductRepository.deleteById(sharedProduct);

    }

    @Override
    public List<ProduitDto> getProduitsByEntrepot(Entrepot entrepot) {
        Optional<List<SharedProduct>> sharedProducts= sharedProductRepository.findByEntrepot(entrepot);
        if(sharedProducts.isEmpty()){
            throw new UserException("sorry c ant find produit in stock");
        }
        List<ProduitDto> produitDtoList=new ArrayList<>();
        for(SharedProduct sharedProduct:sharedProducts.get()){
            produitDtoList.add(produitMapper.toDto(sharedProduct.getProduit()));
        }
        return produitDtoList;
    }

}
