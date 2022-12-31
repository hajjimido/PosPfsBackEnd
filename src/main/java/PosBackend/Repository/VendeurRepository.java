package PosBackend.Repository;

import PosBackend.Domain.Admin;
import PosBackend.Domain.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface VendeurRepository extends JpaRepository<Vendeur,String> {
    Optional<Vendeur> findByEmail(String email);
}
