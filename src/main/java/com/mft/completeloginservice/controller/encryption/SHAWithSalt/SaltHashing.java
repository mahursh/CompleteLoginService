package com.mft.completeloginservice.controller.encryption.SHAWithSalt;

import com.mft.completeloginservice.controller.encryption.SHA.ConsoleInputSha;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import static com.mft.completeloginservice.controller.encryption.SHA.ConsoleInputSha.shaBytesToHex;


public class SaltHashing {
    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];

        new SecureRandom().nextBytes(nonce);
        return nonce;
    }


    public static void main(String[] args) {

        // get a 16 bytes random salt.
        byte[] salt = getRandomNonce(16);
        byte[] pText = "Hello World".getBytes(StandardCharsets.UTF_8);


        // combine two byte arrays
        byte[] input = ByteBuffer.allocate(salt.length + pText.length).put(salt).put(pText).array();


        // no salt, SHA3-256
        shaBytesToHex(ConsoleInputSha.digest(pText,"SHA3-256"));


        // 16 bytes salt, SHA3-256
        shaBytesToHex(ConsoleInputSha.digest(input,"SHA3-256"));
    }
}
