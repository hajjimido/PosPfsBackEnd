package PosBackend.Api;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.entreprise.EntrepriseDto;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Service.EntrepotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entrepot")
public class EntrepotController {
    private final EntrepotService entrepotService;

    @PostMapping("/create")
    public ResponseEntity<Entrepot> create(@RequestBody EntrepotDto entrepotDto){
        return ResponseEntity.ok().body(entrepotService.createEntrepot(entrepotDto));

    }
}
