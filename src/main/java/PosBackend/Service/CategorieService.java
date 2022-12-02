package PosBackend.Service;

import PosBackend.Domain.Categorie;
import PosBackend.Dto.categorie.CategorieDto;

public interface CategorieService {
    Categorie addCategorie(CategorieDto categorieDto);
    String deleteCategorie(String name);
    Categorie updateCategorie(CategorieDto categorieDto);
}
