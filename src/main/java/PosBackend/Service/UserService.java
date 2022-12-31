package PosBackend.Service;

import PosBackend.Domain.User;
import PosBackend.Dto.user.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {

   void saveUserInProviderWithPermanentPassword(User user);


}
