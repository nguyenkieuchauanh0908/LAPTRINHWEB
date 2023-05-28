package vn.iotstar.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.User;

public class CsrfTokenGenerator {

    public static String generateToken() throws NoSuchAlgorithmException {
        // Generate a random string of characters.
        byte[] randomBytes = new byte[16];
        new SecureRandom().nextBytes(randomBytes);

        // Hash the random string using a secure hash function.
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(randomBytes);
        // Return the hash value as the CSRF token.
        return new String(hash);
    }
}
