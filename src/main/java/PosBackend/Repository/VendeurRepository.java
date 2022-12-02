package PosBackend.Repository;

import PosBackend.Domain.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendeurRepository extends JpaRepository<Vendeur,String> {
}
