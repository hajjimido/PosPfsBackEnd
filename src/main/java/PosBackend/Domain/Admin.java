package PosBackend.Domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Admin extends User{
    @OneToOne(mappedBy = "admin")
    Entreprise entreprise;

    public Admin(String firstname, String lastname, String  email, String phone, String password,Entreprise entreprise) {
        super(firstname,lastname,email,phone,null,password);
    }
}
