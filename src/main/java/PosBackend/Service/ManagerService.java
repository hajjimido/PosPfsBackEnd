package PosBackend.Service;

import PosBackend.Domain.Manager;
import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurDto;


import java.util.List;
import java.util.Map;

public interface ManagerService {

    Manager findManagerByEmail(String email);

    Manager createManager(ManagerCreateDto managerCreateDto);

    Manager deleteManager(String id);

    Manager updateManager(String id,ManagerCreateDto managerCreateDto);

    Manager getManager(String id);

    List<ManagerDto> getAllManagers();

    List<VendeurDto> getVendeursByManagerConnected();
    List<ProduitDto> getProduitByManagerConnected();

    EntrepotDto getEntrepotByManagerConnected();
}
