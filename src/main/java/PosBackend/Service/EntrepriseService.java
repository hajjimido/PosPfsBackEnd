package PosBackend.Service;

import PosBackend.Domain.Entreprise;
import PosBackend.Dto.entreprise.EntrepriseDto;

public interface EntrepriseService {
    Entreprise createEntrepriseWithAdmin(EntrepriseDto entrepriseDto);
}
