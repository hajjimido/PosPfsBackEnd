package PosBackend.utils;

import org.keycloak.representations.idm.CredentialRepresentation;

public interface PasswordUtils {

    static CredentialRepresentation createPermanentPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = getCredentialRepresentation(password);
        passwordCredentials.setTemporary(false);
        return passwordCredentials;
    }

    static CredentialRepresentation createTemporaryPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = getCredentialRepresentation(password);
        passwordCredentials.setTemporary(true);
        return passwordCredentials;
    }
    private static CredentialRepresentation getCredentialRepresentation(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }

}
