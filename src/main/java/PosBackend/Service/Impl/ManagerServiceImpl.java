package PosBackend.Service.Impl;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Enum.Role;
import PosBackend.Domain.Manager;
import PosBackend.Domain.SharedProduct;
import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurDto;
import PosBackend.Mapper.ManagerMapper;
import PosBackend.Mapper.ProduitMapper;
import PosBackend.Repository.EntrepotRepository;
import PosBackend.Repository.ManagerRepository;
import PosBackend.Service.ManagerService;
import PosBackend.Service.SharedProductService;
import PosBackend.Service.UserService;
import PosBackend.advice.Exception.UserException;
import PosBackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.*;



@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final UserService userService;
    private  final ManagerRepository managerRepository;
    private final EntrepotRepository entrepotRepository;
    private final ManagerMapper managerMapper;
    private final SharedProductService sharedProductService;

    @Override
    public Manager findManagerByEmail(String email) {
        System.out.println(email+"hhh");
        Optional<Manager> manager= managerRepository.findByEmail(email);
        if(manager.isPresent()){
            return manager.get();
        }
        else throw new UserException("manager not found");
    }

    @Override
    public Manager createManager(ManagerCreateDto managerCreateDto)  {
        Optional<Entrepot> entrepot=entrepotRepository.findByName(managerCreateDto.getNameEntrepot());
        if(entrepot.isEmpty()){
            throw new UserException("sorry cant create Manager");
        }

        Manager manager=managerMapper.toBo(managerCreateDto);
        manager.setRole(Role.MANAGER);
        manager.setEntrepot(entrepot.get());
        manager.setPassword("12345678");

        //userService.saveUserInProviderWithPermanentPassword(manager);
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
    public List<VendeurDto> getVendeursByManagerConnected() {
       String managerEmail= SecurityUtils.getUserEmail().get();
        Manager manager =findManagerByEmail(managerEmail);
        return managerMapper.toDto(manager).getVendeurs();
    }

    @Override
    public List<ProduitDto> getProduitByManagerConnected() {
        String managerEmail= SecurityUtils.getUserEmail().get();
        Manager manager =findManagerByEmail(managerEmail);

        return sharedProductService.getProduitsByEntrepot(manager.getEntrepot());
    }

    @Override
    public EntrepotDto getEntrepotByManagerConnected() {
        String managerEmail= SecurityUtils.getUserEmail().get();
        Manager manager =findManagerByEmail(managerEmail);

        return managerMapper.toDto(manager).getEntrepot();
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
