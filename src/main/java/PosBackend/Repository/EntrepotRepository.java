package PosBackend.Repository;

import PosBackend.Domain.Entrepot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepotRepository extends JpaRepository<Entrepot,String> {
}
