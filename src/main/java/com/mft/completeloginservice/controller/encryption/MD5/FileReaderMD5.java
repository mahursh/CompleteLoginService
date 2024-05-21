package com.mft.completeloginservice.controller.encryption.MD5;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileReaderMD5 {
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] checksum(String filePath) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        try (InputStream inputStream = new FileInputStream(filePath);
             DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest)) {
            while (digestInputStream.read() != -1) ; //empty loop to clear the data
            messageDigest = digestInputStream.getMessageDigest();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return messageDigest.digest();
    }


    public static String md5BytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


}
