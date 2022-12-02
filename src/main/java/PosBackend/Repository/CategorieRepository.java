package PosBackend.Repository;

import PosBackend.Domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,String>{
    Optional<Categorie> findByNameCategorie(String nameCategorie);
}
