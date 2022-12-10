package PosBackend.Service;


import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Dto.user.VendeurDto;

import java.util.List;

public interface VendeurService {
    Vendeur createVendeur(VendeurCreateDto vendeurCreateDto);

    Vendeur valideVendeur(String id);

    Vendeur deleteVendeur(String id);

    Vendeur updateVendeur(String id, VendeurCreateDto vendeurCreateDto);

    Vendeur getVendeur(String id);

    List<VendeurDto> getAllVendeurs();

}
