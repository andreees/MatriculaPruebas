/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.web.matriculaweb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;
/**
 *
 * @author Roy
 */
public final class Encryptor {

    private static MessageDigest digester;
    private final static Logger LOGGER = Logger.getLogger(Encryptor.class);

    private Encryptor() {
    }
    
    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
    }

    public static String encrypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Error String");
        }

        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString(0xFF & hash[i]));
            } else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }
}
