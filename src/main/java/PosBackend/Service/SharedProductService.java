package PosBackend.Service;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.ProduitDto;

import java.util.List;

public interface SharedProductService {
    void addProductToEnrepot(Entrepot entrepot, Produit produit,int capacité);

    void deleteSharedProduct(String sharedProduct);
    List<ProduitDto> getProduitsByEntrepot(Entrepot entrepot);
}
