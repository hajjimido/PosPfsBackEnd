package PosBackend.Domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Vendeur extends User {

    @Column(columnDefinition = "boolean default false")
    boolean valide;
    @ManyToOne
    Manager manager;
    public Vendeur(String firstname, String lastname, String  email, String phone, String password,Manager manager) {
        super(firstname,lastname,email,phone,null,password);
        this.manager=manager;
    }




}
