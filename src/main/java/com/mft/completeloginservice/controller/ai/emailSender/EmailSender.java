package com.mft.completeloginservice.controller.ai.emailSender;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class EmailSender {


    public static void main(String[] args) {

        // اطلاعات حساب ایمیل فرستنده
        String senderEmail = "your_email@gmail.com";
        String senderPassword = "your_password";

        // اطلاعات گیرنده
        String recipientEmail = "recipient_email@example.com";

        // تنظیمات برای ارتباط با سرور SMTP
        java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // ایجاد جلسه ارتباط با سرور SMTP با استفاده از اطلاعات فرستنده
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // ایجاد یک پیام ایمیل
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

            //باید یه کد رندوم بفرستم و سیوش کنم تا وقتی کاربر خواست وارد بشه ورودیو باهاش مقایسه کنم

            message.setSubject("عنوان ایمیل");
            message.setText("متن ایمیل");

            // ارسال ایمیل
            Transport.send(message);

            System.out.println("ایمیل با موفقیت ارسال شد.");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }
}
