package com.mft.completeloginservice.controller.encryption.Base64;

public class test {
    public static void main(String[] args) {
        String a = Encoder.baseEncoder("nfdfghjk");
        System.out.println(a);

        String b = Decoder.baseDecoder("bmZkZmdoams=");
        System.out.println(b);

    }
}
