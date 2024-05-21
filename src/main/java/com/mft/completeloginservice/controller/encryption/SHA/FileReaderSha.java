package com.mft.completeloginservice.controller.encryption.SHA;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileReaderSha {

    public static byte[] checksum(String filePath , String algorithm){
        MessageDigest messageDigest;

        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        }catch (NoSuchAlgorithmException e){
            throw new IllegalArgumentException(e);
        }
        try (InputStream inputStream = new FileInputStream(filePath);

             DigestInputStream digestInputStream = new DigestInputStream(inputStream , messageDigest)){

          while (digestInputStream.read() != -1); //empty loop to clear the data

            messageDigest = digestInputStream.getMessageDigest();

        }catch (IOException e){
            throw new IllegalArgumentException(e);
        }
        return messageDigest.digest();
    }




    public static String shaBytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }


}
