package PosBackend.Service;


import PosBackend.Domain.Produit;

import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.produit.CreateSharedProduitDto;

import java.util.List;

public interface ProduitService {
        void addProduit(CreateProduitDto createProduitDto);
        String deleteProduit(String reference);
        Produit updateProduit(ProduitDto createProduitDto);
        void extractFromProduit(ProduitDto produitFromCommande);

        List<ProduitDto> getAllProduct();

    void addProduitToEntrepot(CreateSharedProduitDto createSharedProduitDto);
    void deleteProduitFromEntrepot(String sharedEntrepot );

    ProduitDto getProduitById(String produitId);

    ProduitDto getProduitByRef(String produitref);
}
