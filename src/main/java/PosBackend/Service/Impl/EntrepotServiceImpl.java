package PosBackend.Service.Impl;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Entreprise;
import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Mapper.EntrepotMapper;
import PosBackend.Repository.EntrepotRepository;
import PosBackend.Repository.EntrepriseRepository;
import PosBackend.Service.EntrepotService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrepotServiceImpl implements EntrepotService {
    private final EntrepotRepository entrepotRepository;
    private final EntrepotMapper entrepotMapper;
    private final EntrepriseRepository entrepriseRepository;


    @Override
    public Entrepot createEntrepot(EntrepotDto entrepotDto) {
        Optional<Entreprise> entreprise=entrepriseRepository.findById(entrepotDto.getIdEntreprise());
        if(!entreprise.isPresent())
        {
            throw new UserException("cant create entrepot");
        }
            Entrepot entrepot = entrepotMapper.toBo(entrepotDto);
            entrepot.setEntreprise(entreprise.get());

            return entrepotRepository.save(entrepot);

    }

}
