package PosBackend.Service;

import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;

public interface VendeurService {
    Vendeur createVendeur(VendeurCreateDto vendeurCreateDto);

    Vendeur valideVendeur(String id);
}
