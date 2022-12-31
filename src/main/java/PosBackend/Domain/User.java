package PosBackend.Domain;

import PosBackend.Domain.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Data

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@JsonIgnoreProperties(value = {"roles","password"},allowSetters = true)
public class User extends AbstractEntite{
    String firstName;
    String lastName;
    @Column(unique = true)
    String email;
    String username;

    String phone;

    @Enumerated(EnumType.STRING)
   Role role;

    @Transient
    String password;



}
