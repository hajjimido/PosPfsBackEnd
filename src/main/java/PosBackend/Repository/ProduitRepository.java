package PosBackend.Repository;

import PosBackend.Domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,String> {
    Optional<Produit> findByreference(String reference);
}
