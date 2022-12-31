package PosBackend.Api;

import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.produit.CreateSharedProduitDto;
import PosBackend.Service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RequestMapping("/produit")
@RequiredArgsConstructor
@RestController
public class ProduitController {
    private final ProduitService produitService;

    @PostMapping("/add")
    public void addCategorie(@RequestBody CreateProduitDto createProduitDto){
         produitService.addProduit(createProduitDto);

    }
    @DeleteMapping("/delete/{reference}")
    public ResponseEntity<String> deleteCategorie(@PathVariable String reference){
        return ResponseEntity.ok().body(produitService.deleteProduit(reference));

    }
    @PutMapping ("/update")
    public ResponseEntity<Produit> updateCategorie(@RequestBody ProduitDto produitDto){
        return ResponseEntity.ok().body(produitService.updateProduit(produitDto));

    }
    @GetMapping("/all")
    public ResponseEntity<List<ProduitDto>> getAllProduct(){
        return ResponseEntity.ok().body(produitService.getAllProduct());
    }
    @PostMapping("/addProduitToEntrepot")
    public void addProduitToEntrepot(@RequestBody CreateSharedProduitDto createSharedProduitDto){
        produitService.addProduitToEntrepot(createSharedProduitDto);
    }
    @DeleteMapping("/deleteProduitFromEntrepot/{sharedEntrepot}")
    public void deleteProduitFromEntrepot(@PathVariable(value = "sharedEntrepot" )String sharedEntrepot){
        produitService.deleteProduitFromEntrepot(sharedEntrepot);
    }
    @GetMapping("/{id}")
    public ProduitDto getProduitById(@PathVariable(value = "id" )String produitId){
         return  produitService.getProduitById(produitId);
    }
    @GetMapping("ref/{reference}")
    public ProduitDto getProduitByRef(@PathVariable(value = "reference" )String produitref){
        return  produitService.getProduitByRef(produitref);
    }
    
}
