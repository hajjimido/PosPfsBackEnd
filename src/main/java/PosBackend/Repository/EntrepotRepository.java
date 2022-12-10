package PosBackend.Repository;

import PosBackend.Domain.Entrepot;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EntrepotRepository extends JpaRepository<Entrepot,String> {

    Optional<Entrepot> findByName(String name);
}
