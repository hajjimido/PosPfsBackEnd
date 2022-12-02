package PosBackend.Service;

import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.VendeurCreateDto;

import java.util.List;

public interface VendeurService {
    Vendeur createVendeur(VendeurCreateDto vendeurCreateDto);

    Vendeur deleteVendeur(String id);

    Vendeur updateVendeur(String id, VendeurCreateDto vendeurCreateDto);

    Vendeur getVendeur(String id);

    List<Vendeur> getAllVendeurs();
}
