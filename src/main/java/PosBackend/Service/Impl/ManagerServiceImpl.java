package PosBackend.Service.Impl;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Mapper.ManagerMapper;
import PosBackend.Repository.EntrepotRepository;
import PosBackend.Repository.ManagerRepository;
import PosBackend.Service.ManagerService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private  final ManagerRepository managerRepository;
    private final EntrepotRepository entrepotRepository;
    private final ManagerMapper managerMapper;

    @Override
    public Manager createManager(ManagerCreateDto managerCreateDto) {
        Optional<Entrepot> entrepot=entrepotRepository.findById(managerCreateDto.getIdEntrepot());
        if(entrepot.isEmpty()){
            throw new UserException("sorry cant create Vendeur");
        }
        Manager manager=managerMapper.toBo(managerCreateDto);
        manager.setEntrepot(entrepot.get());

        return managerRepository.save(manager);
    }





}
