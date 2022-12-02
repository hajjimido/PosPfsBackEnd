package PosBackend.Service;

import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    Manager createManager(ManagerCreateDto managerCreateDto);

    Manager deleteManager(String id);

    Manager updateManager(String id,ManagerCreateDto managerCreateDto);

    Manager getManager(String id);

    List<Manager> getAllManagers();

}
