package PosBackend.Domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

@JsonIgnoreProperties(value = {"vendeurs"},allowSetters = true)

public class Manager extends User{

    @OneToOne
    Entrepot entrepot;
    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    List<Vendeur> vendeurs;

    public Manager(String firstname, String lastname, String  email, String phone, String password,String username,Entrepot entrepot,List<Vendeur>vendeurs) {
        super(firstname,lastname,email,username,phone,null,password);
        this.entrepot=entrepot;
        this.vendeurs=vendeurs;
    }


}
