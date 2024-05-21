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

@WebServlet(name = "usersServlet", value = "/users.do")
public class UsersServlet extends HttpServlet {

    @Inject
    private User user ;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("userList" ,userService.findAll() );
            // TODO: if not null
            req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
            userService.findAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
