package com.mft.completeloginservice.controller.exception;

public class NoContentException extends Exception {
    private String message;


    public NoContentException() {
        message = "No Content Found";
    }

    public NoContentException(String message) {
        this.message = message;
    }


}
