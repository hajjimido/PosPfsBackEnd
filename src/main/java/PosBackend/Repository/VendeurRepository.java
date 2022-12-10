package PosBackend.Repository;

import PosBackend.Domain.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository


public interface VendeurRepository extends JpaRepository<Vendeur,String> {
}
