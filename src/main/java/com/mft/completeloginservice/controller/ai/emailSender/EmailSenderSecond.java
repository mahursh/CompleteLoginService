package com.mft.completeloginservice.controller.ai.emailSender;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

import static com.mft.completeloginservice.controller.encryption.passwordGenerator.PassGenerator.passWordGenerator;

public class EmailSenderSecond {


    private static String senderEmail = "mahurshams94@gmail.com";
    private static String senderPassword = "kTQVffHXui4jwp8";
//    private static String recipientEmail = "recipient_email@example.com";
//    private String recipientUserName ;

//    private String generateNewPass(){
//        newPass = passWordGenerator();
//        return newPass;
//    }


    public static void sendEmail(String userEmail , String recipientUserName){

        String  newPass = passWordGenerator() ;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "mahurshams94.gmail.com");
        properties.put("mail.smtp.port", "587");



        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });


        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));




            message.setSubject("Your New Password");

            StringBuilder emailText = new StringBuilder();
            emailText.append("Hello dear" + recipientUserName+".\n");
            emailText.append("\t this is your new password: "+"\n\n");
            emailText.append(newPass);
            message.setText(emailText.toString());


            Transport.send(message);

            System.out.println("Email Was Sent Successfully . Pleas check Your Email.");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }

}
