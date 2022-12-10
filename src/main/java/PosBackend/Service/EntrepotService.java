package PosBackend.Service;

import PosBackend.Domain.Entrepot;
import PosBackend.Dto.entrepot.EntrepotDto;

import java.util.List;

public interface EntrepotService {
    Entrepot createEntrepot(EntrepotDto entrepotDto);

    List<Entrepot> getAllEntrepot();

    List<Entrepot> getAllEntrepotNonAtribué();

    List<Entrepot> getAllEntrepotAtribué();
}
