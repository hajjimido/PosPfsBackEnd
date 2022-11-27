package PosBackend.Service;

import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;

public interface ManagerService {

    Manager createManager(ManagerCreateDto managerCreateDto);
}
