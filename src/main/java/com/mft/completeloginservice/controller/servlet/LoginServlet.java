package com.mft.completeloginservice.controller.servlet;

import com.mft.completeloginservice.controller.session.SessionManager;
import com.mft.completeloginservice.model.entity.User;
import com.mft.completeloginservice.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {

    @Inject
    private User user;
    @Inject
    private UserService userService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            String rememberMe = req.getParameter("rememberMe");
//            String role = req.getParameter("role");

            user = userService.findByUserNameAndPassword(userName, password);
            if (user != null) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", user);

                SessionManager.addHttpSession(httpSession);
                if(rememberMe!= null){
                   Cookie usernameCookie =new Cookie("username" , userName);
                   Cookie passwordCookie =new Cookie("password" , password);

                   resp.addCookie(usernameCookie);
                   resp.addCookie(passwordCookie);

                    req.getRequestDispatcher("index.jsp").forward(req,resp);


                }

//                if (user.getRole() == ){
//                    resp.sendRedirect("jsp/admin/adminPanel.jsp");
//                }else {
//                    resp.sendRedirect("/jsp/personPanel.jsp");
//
//                }

            }else {
                resp.sendRedirect("jsp/login.jsp");
                resp.getWriter().write("Invalid Username and Password");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
