package PosBackend.Service.Impl;

import PosBackend.Config.AdminManagementBuilder;
import PosBackend.Domain.User;
import PosBackend.Dto.user.UserDto;
import PosBackend.Mapper.UserMapper;
import PosBackend.Service.UserService;
import PosBackend.advice.Exception.UserException;
import PosBackend.utils.PasswordUtils;
import PosBackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AdminManagementBuilder admin;





    @Override
    public void saveUserInProviderWithPermanentPassword(User userBo)  {
        CredentialRepresentation credential = PasswordUtils
                .createPermanentPasswordCredentials(userBo.getPassword());
        saveUserInProvider(userBo, credential);
    }




    private void saveUserInProvider(User userBo, CredentialRepresentation credential)  {
        UserRepresentation user = new UserRepresentation();
        user.setEmail(userBo.getEmail());
        user.setFirstName(userBo.getFirstName());
        user.setLastName(userBo.getLastName());
        user.setUsername(userBo.getUsername());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);
        admin.getUsersResource().list().add(user);
        Response response=admin.getUsersResource().create(user);
        addRoleToUser(response,userBo.getEmail(), userBo.getRole().name());

    }
    public void addRoleToUser(Response response,String email, String roleName) {

        String userId = CreatedResponseUtil.getCreatedId(response);
        UserResource user = admin.getUsersResource()
                .get(userId);
        List<RoleRepresentation> roleToAdd = new ArrayList<>();
        roleToAdd.add(admin.getRealmResource()
                .roles()
                .get(roleName)
                .toRepresentation());
        user.roles().realmLevel().add(roleToAdd);
    }
    private UserRepresentation findByEmailInProvider(String email) {
        return admin.getUsersResource().search(email, true).get(0);
    }
}
