package PosBackend.Service.Impl;


import PosBackend.Domain.Categorie;
import PosBackend.Dto.categorie.CategorieDto;
import PosBackend.Mapper.CategorieMapper;
import PosBackend.Repository.CategorieRepository;
import PosBackend.Service.CategorieService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository categorieRepository;
    private final CategorieMapper categorieMapper;
    @Override
    public Categorie addCategorie(CategorieDto categorieDto) {
        return categorieRepository.save(categorieMapper.toBo(categorieDto));
    }

    @Override
    public String deleteCategorie(String name) {
        Optional<Categorie> categorie=categorieRepository.findByNameCategorie(name);
        if(categorie.isEmpty()){
            throw new UserException("sorry categorie not found");
        }
        categorieRepository.delete(categorie.get());
        return "categorie deleted";

    }

    @Override
    public Categorie updateCategorie(CategorieDto categorieDto) {
        Optional<Categorie> categorie=categorieRepository.findByNameCategorie(categorieDto.getNameCategorie());
        if(categorie.isEmpty()){
            throw new UserException("sorry categorie not found");
        }
        return categorieRepository.save(categorieMapper.toBo(categorieDto));
    }



}
