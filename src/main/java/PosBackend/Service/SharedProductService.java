package PosBackend.Service;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Produit;

public interface SharedProductService {
    void addProductToEnrepot(Entrepot entrepot, Produit produit,int capacité);

    void deleteSharedProduct(String sharedProduct);
}
