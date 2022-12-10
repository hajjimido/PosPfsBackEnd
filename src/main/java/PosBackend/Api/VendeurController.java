package PosBackend.Api;


import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;

import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Dto.user.VendeurDto;
import PosBackend.Service.VendeurService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendeur")
public class VendeurController {
    private final VendeurService vendeurService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Vendeur> getVendeur(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(vendeurService.getVendeur(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Vendeur> create(@RequestBody VendeurCreateDto vendeurCreateDto){
        return ResponseEntity.ok().body(vendeurService.createVendeur(vendeurCreateDto));

    }
    @PostMapping("/valide/{id}")
    public ResponseEntity<Vendeur> valide(@PathVariable String id){
        return ResponseEntity.ok().body(vendeurService.valideVendeur(id));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Vendeur> deleteVendeur(@PathVariable(value = "id") String id){
        return ResponseEntity.ok().body(vendeurService.deleteVendeur(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vendeur> updateVendeur(@PathVariable(value = "id") String id, @RequestBody VendeurCreateDto updatedVendeur){
        return ResponseEntity.ok().body(vendeurService.updateVendeur(id,updatedVendeur));
    }
    @GetMapping("/all")
    public ResponseEntity<List<VendeurDto>> getAllVendeurs(){
        return ResponseEntity.ok().body(vendeurService.getAllVendeurs());
    }



}
