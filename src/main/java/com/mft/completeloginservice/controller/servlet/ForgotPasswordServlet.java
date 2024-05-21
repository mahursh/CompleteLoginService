package com.mft.completeloginservice.controller.servlet;

import com.mft.completeloginservice.model.entity.User;
import com.mft.completeloginservice.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mft.completeloginservice.controller.ai.emailSender.EmailSenderSecond.sendEmail;

@WebServlet(name = "forgotServlet", value = "/forgot.do")
public class ForgotPasswordServlet extends HttpServlet {

    @Inject
    private User user;
    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String username = "test";
        try {

           User user = userService.findEmailByUserName(username);
           if (user != null){
              String email = user.getEmail();
              sendEmail(email,username);

              resp.getWriter().write("Email Was Sent Successfully . Pleas check Your Email.");

           }else{

               resp.sendRedirect("jsp/signUp.jsp");
               resp.getWriter().write("There Is No Account With <"+username+"> UserName . Please Check Again. ");

           }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
