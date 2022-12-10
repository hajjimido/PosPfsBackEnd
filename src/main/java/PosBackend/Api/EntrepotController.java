package PosBackend.Api;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.entreprise.EntrepriseDto;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Service.EntrepotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entrepot")
public class EntrepotController {
    private final EntrepotService entrepotService;

    @PostMapping("/create")
    public ResponseEntity<Entrepot> create(@RequestBody EntrepotDto entrepotDto){
        return ResponseEntity.ok().body(entrepotService.createEntrepot(entrepotDto));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Entrepot>> getEntrepots(){
        return ResponseEntity.ok().body(entrepotService.getAllEntrepot());
    }
    @GetMapping("/nonAttribue")
    public ResponseEntity<List<Entrepot>> getEntrepotsNonAtrribué(){
        return ResponseEntity.ok().body(entrepotService.getAllEntrepotNonAtribué());
    }
    @GetMapping("/attribue")
    public ResponseEntity<List<Entrepot>> getEntrepotsAtrribué(){
        return ResponseEntity.ok().body(entrepotService.getAllEntrepotAtribué());
    }
}
