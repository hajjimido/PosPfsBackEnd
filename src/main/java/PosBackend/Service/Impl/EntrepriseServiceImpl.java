package PosBackend.Service.Impl;

import PosBackend.Domain.Entreprise;
import PosBackend.Dto.entreprise.EntrepriseDto;
import PosBackend.Mapper.EntrepriseMapper;
import PosBackend.Repository.EntrepriseRepository;
import PosBackend.Service.EntrepriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseMapper entrepriseMapper;
    private final EntrepriseRepository entrepriseRepository;

    @Override
    public Entreprise createEntrepriseWithAdmin(EntrepriseDto entrepriseDto) {
        return entrepriseRepository.save(entrepriseMapper.toBo(entrepriseDto)) ;
    }
}
