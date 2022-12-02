package PosBackend.Api;

import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Service.VendeurService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendeur")
public class VendeurController {
    private final VendeurService vendeurService;

    @PostMapping("/create")
    public ResponseEntity<Vendeur> create(@RequestBody VendeurCreateDto vendeurCreateDto){
        return ResponseEntity.ok().body(vendeurService.createVendeur(vendeurCreateDto));

    }
    @PostMapping("/valide/{id}")
    public ResponseEntity<Vendeur> valide(@PathVariable String id){
        return ResponseEntity.ok().body(vendeurService.valideVendeur(id));

    }


}
