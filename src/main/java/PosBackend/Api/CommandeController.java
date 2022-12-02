package PosBackend.Api;

import PosBackend.Domain.Commande;
import PosBackend.Dto.commande.CommandeDto;
import PosBackend.Service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commande")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody CommandeDto commandeDto){
        return ResponseEntity.ok().body(commandeService.addCommande(commandeDto));

    }

}
