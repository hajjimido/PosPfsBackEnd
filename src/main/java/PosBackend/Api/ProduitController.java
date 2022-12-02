package PosBackend.Api;

import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/produit")
@RequiredArgsConstructor
@RestController
public class ProduitController {
    private final ProduitService produitService;

    @PostMapping("/add")
    public ResponseEntity<Produit> addCategorie(@RequestBody CreateProduitDto createProduitDto){
        return ResponseEntity.ok().body(produitService.addProduit(createProduitDto));

    }
    @DeleteMapping("/delete/{reference}")
    public ResponseEntity<String> deleteCategorie(@PathVariable String reference){
        return ResponseEntity.ok().body(produitService.deleteProduit(reference));

    }
    @PutMapping ("/update")
    public ResponseEntity<Produit> updateCategorie(@RequestBody ProduitDto produitDto){
        return ResponseEntity.ok().body(produitService.updateProduit(produitDto));

    }
    
}
