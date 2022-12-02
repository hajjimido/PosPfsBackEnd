package PosBackend.Service.Impl;

import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Mapper.VendeurMapper;
import PosBackend.Repository.ManagerRepository;
import PosBackend.Repository.VendeurRepository;
import PosBackend.Service.VendeurService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VendeurServiceImpl implements VendeurService {
    private final VendeurMapper vendeurMapper;
    private final VendeurRepository vendeurRepository;
    private final ManagerRepository managerRepository;


    @Override
    public Vendeur createVendeur(VendeurCreateDto vendeurCreateDto) {
        Optional<Manager> manager =managerRepository.findById(vendeurCreateDto.getIdManager());
        if(manager.isEmpty() ){
         throw new UserException("sorry cant create Vendeur");
        }
        Vendeur vendeur=vendeurMapper.toBo(vendeurCreateDto);

        vendeur.setManager(manager.get());
        return vendeurRepository.save(vendeur);
    }

    @Override
    public Vendeur valideVendeur(String id) {
      Optional<Vendeur> vendeur=  vendeurRepository.findById(id);
      if(vendeur.isEmpty()){
          throw new UserException("sorry vendeur not found");
      }
      vendeur.get().setValide(true);
      return vendeurRepository.save(vendeur.get());
    }

}
