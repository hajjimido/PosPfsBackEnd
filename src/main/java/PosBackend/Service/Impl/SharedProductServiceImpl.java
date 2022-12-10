package PosBackend.Service.Impl;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Produit;
import PosBackend.Domain.SharedProduct;
import PosBackend.Repository.SharedProductRepository;
import PosBackend.Service.SharedProductService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SharedProductServiceImpl implements SharedProductService {
    private final SharedProductRepository sharedProductRepository;

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
}
