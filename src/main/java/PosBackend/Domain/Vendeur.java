package PosBackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(value = {"commandes"},allowSetters = true)
@Entity
public class Vendeur extends User {

    @Column(columnDefinition = "boolean default false")
    boolean valide;
    @OneToMany
    List<Commande> commandes;

    @ManyToOne
    Manager manager;
    public Vendeur(String firstname, String lastname, String  email, String username,String phone, String password,Manager manager) {
        super(firstname,lastname,email ,username,phone,null,password);
        this.manager=manager;
    }




}
