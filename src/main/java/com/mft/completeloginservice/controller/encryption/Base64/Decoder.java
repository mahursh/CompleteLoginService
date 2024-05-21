package com.mft.completeloginservice.controller.encryption.Base64;

import java.util.Base64;

public class Decoder {
    public static String baseDecoder(String encodedPassword) {

        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String originalPassword = new String(decodedBytes);

        return originalPassword;
    }


}
