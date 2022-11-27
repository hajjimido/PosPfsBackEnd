package PosBackend.Api;

import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Service.VendeurService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendeur")
public class VendeurController {
    private final VendeurService vendeurService;

    @PostMapping("/create")
    public ResponseEntity<Vendeur> create(@RequestBody VendeurCreateDto vendeurCreateDto){
        return ResponseEntity.ok().body(vendeurService.createVendeur(vendeurCreateDto));

    }

}
