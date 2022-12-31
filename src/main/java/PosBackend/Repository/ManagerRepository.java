package PosBackend.Repository;

import PosBackend.Domain.Admin;
import PosBackend.Domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface ManagerRepository extends JpaRepository<Manager,String> {
    Optional<Manager> findByEmail(String email);

}
