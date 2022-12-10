package PosBackend.Service.Impl;


import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Enum.Role;
import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Dto.user.VendeurDto;
import PosBackend.Mapper.VendeurMapper;
import PosBackend.Repository.EntrepotRepository;
import PosBackend.Repository.ManagerRepository;
import PosBackend.Repository.VendeurRepository;
import PosBackend.Service.VendeurService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VendeurServiceImpl implements VendeurService {
    private final VendeurMapper vendeurMapper;
    private final VendeurRepository vendeurRepository;
    private final EntrepotRepository entrepotRepository;


    @Override
    public Vendeur createVendeur(VendeurCreateDto vendeurCreateDto) {
        Optional<Entrepot> entrepot =entrepotRepository.findByName(vendeurCreateDto.getNameEntrepot());
        if(entrepot.isEmpty() || entrepot.get().getManager()==null){

         throw new UserException("sorry cant create vendeur");

        }
        Vendeur vendeur=vendeurMapper.toBo(vendeurCreateDto);
        vendeur.setManager(entrepot.get().getManager());
        vendeur.setRole(Role.Vendeur);
        return vendeurRepository.save(vendeur);
    }

    @Override

    public Vendeur valideVendeur(String id) {
        Optional<Vendeur> vendeur = vendeurRepository.findById(id);
        if (vendeur.isEmpty()) {
            throw new UserException("sorry vendeur not found");
        }
        vendeur.get().setValide(true);
        return vendeurRepository.save(vendeur.get());
    }
   @Override
    public Vendeur getVendeur(String id){
        Vendeur vendeur = vendeurRepository.findById(id).orElseThrow(()->new UserException("Vendeur not found for this id : "+id));
        return vendeur;
    }

    @Override
    public List<VendeurDto> getAllVendeurs(){
        return vendeurMapper.toDto(vendeurRepository.findAll());
    }

    @Override
    public Vendeur deleteVendeur(String id){
        Vendeur vendeur = vendeurRepository.findById(id).orElseThrow(()->new UserException("Vendeur not found for this id : "+id));
        vendeurRepository.delete(vendeur);
        return vendeur;
    }

    @Override
    public Vendeur updateVendeur(String id, VendeurCreateDto vendeurCreateDto){
        Vendeur vendeur = vendeurRepository.findById(id).orElseThrow(() -> new UserException("Vendeur not found for this id : "+id));
        vendeur.setFirstName(vendeurCreateDto.getFirstName());
        vendeur.setLastName(vendeurCreateDto.getLastName());
        vendeur.setEmail(vendeurCreateDto.getEmail());
        vendeur.setPhone(vendeurCreateDto.getPhone());
        vendeur.setPassword(vendeurCreateDto.getPassword());
        vendeur.setId(vendeurCreateDto.getNameEntrepot());
        return vendeurRepository.save(vendeur);

    }

}
