package com.mft.completeloginservice.controller.exception;

public class AccessDeniedException extends Exception{

   private String message;

    public AccessDeniedException(){
       message = "Access Denied !";
   }
   public AccessDeniedException(String message){
       this.message = message;
   }
}
