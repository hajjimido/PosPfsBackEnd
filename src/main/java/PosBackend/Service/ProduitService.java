package PosBackend.Service;

import PosBackend.Domain.Produit;

import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;

public interface ProduitService {
    Produit addProduit(CreateProduitDto createProduitDto);
    String deleteProduit(String reference);
    Produit updateProduit(ProduitDto createProduitDto);
    void extractFromProduit(ProduitDto produitFromCommande);
}
