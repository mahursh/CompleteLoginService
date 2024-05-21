package com.mft.completeloginservice.controller.encryption.MD5;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ConsoleInputMD5 {
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] digest(byte[] input) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw  new IllegalArgumentException(e);
        }
        byte[] result = messageDigest.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b: bytes) {
            stringBuilder.append(String.format("%20x" , b));

        }
        return stringBuilder.toString();
    }


}