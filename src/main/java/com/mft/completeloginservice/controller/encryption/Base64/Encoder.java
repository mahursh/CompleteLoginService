package com.mft.completeloginservice.controller.encryption.Base64;


import java.util.Base64;

public class Encoder {
    public static String baseEncoder(String originalPassword) {
// **first way:

        //**casting the string that user puts as original password to byte array:
        //byte[] passwordInput = originalPassword.getBytes();

        //**encoding the byte array:
        //String encodedPassword = Base64.getEncoder().encodeToString(passwordInput);

// **second way:

        String encodedPassword = Base64.getEncoder().encodeToString(originalPassword.getBytes());
        return encodedPassword;

    }



    public static String baseEncoderNoPadding(String originalPassword){

        String encodedPassword = Base64
                .getEncoder()
                .withoutPadding()
                .encodeToString(originalPassword.getBytes());
        return encodedPassword;
    }



}
