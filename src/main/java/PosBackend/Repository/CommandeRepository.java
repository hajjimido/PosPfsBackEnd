package PosBackend.Repository;

import PosBackend.Domain.Commande;
import PosBackend.Domain.Manager;
import PosBackend.Dto.commande.CommandeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,String> {

    List<Commande> findByVendeur_Manager_Entrepot_Id(String idEntrepot);
    List<Commande> findByVendeur_Manager(Manager manager);
}
