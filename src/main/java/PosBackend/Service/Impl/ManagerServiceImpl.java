package PosBackend.Service.Impl;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Enum.Role;
import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Mapper.ManagerMapper;
import PosBackend.Repository.EntrepotRepository;
import PosBackend.Repository.ManagerRepository;
import PosBackend.Service.ManagerService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.*;



@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private  final ManagerRepository managerRepository;
    private final EntrepotRepository entrepotRepository;
    private final ManagerMapper managerMapper;

    @Override
    public Manager createManager(ManagerCreateDto managerCreateDto) {
        Optional<Entrepot> entrepot=entrepotRepository.findByName(managerCreateDto.getNameEntrepot());
        if(entrepot.isEmpty()){

            throw new UserException("sorry cant create Manager");

        }

        Manager manager=managerMapper.toBo(managerCreateDto);
        manager.setRole(Role.Manager);
        manager.setEntrepot(entrepot.get());

        return managerRepository.save(manager);
    }

    @Override
    public Manager getManager(String id){
        Manager manager = managerRepository.findById(id).orElseThrow(()->new UserException("Manager not found for this id : "+id));
        return manager;
    }

    @Override
    public List<ManagerDto> getAllManagers(){
       return managerMapper.toDto(managerRepository.findAll());


    }

    @Override
    public Manager deleteManager(String id){
        Manager manager = managerRepository.findById(id).orElseThrow(()->new UserException("Manager not found for this id : "+id));
        managerRepository.delete(manager);
        return manager;
    }

    @Override
    public Manager updateManager(String id, ManagerCreateDto managerCreateDto){
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new UserException("Manager not found for this id"));
        manager.setFirstName(managerCreateDto.getFirstName());
        manager.setLastName(managerCreateDto.getLastName());
        manager.setEmail(managerCreateDto.getEmail());
        manager.setPhone(managerCreateDto.getPhone());
        manager.setPassword(managerCreateDto.getPassword());
        manager.setId(managerCreateDto.getNameEntrepot());
        return managerRepository.save(manager);
    }


}
