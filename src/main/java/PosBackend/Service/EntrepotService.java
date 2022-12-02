package PosBackend.Service;

import PosBackend.Domain.Entrepot;
import PosBackend.Dto.entrepot.EntrepotDto;

public interface EntrepotService {
    Entrepot createEntrepot(EntrepotDto entrepotDto);
}
