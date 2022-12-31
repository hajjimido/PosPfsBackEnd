package PosBackend.Repository;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Produit;
import PosBackend.Domain.SharedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SharedProductRepository extends JpaRepository<SharedProduct,String> {
    Optional<SharedProduct> findByProduitAndEntrepot(Produit produit, Entrepot entrepot);
    Optional<List<SharedProduct>> findByEntrepot( Entrepot entrepot);
}
