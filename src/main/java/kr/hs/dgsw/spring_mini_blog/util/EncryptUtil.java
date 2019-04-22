package kr.hs.dgsw.spring_mini_blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    public static String encryptString(String password) {
        String encrypted = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes(), 0, password.getBytes().length);

            encrypted = new BigInteger(1, messageDigest.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            Logger logger = LoggerFactory.getLogger(EncryptUtil.class);
            logger.warn(e.getMessage());
        }
        return encrypted;
    }
}
