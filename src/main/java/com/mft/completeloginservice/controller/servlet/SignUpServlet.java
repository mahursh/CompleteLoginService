package com.mft.completeloginservice.controller.servlet;

import com.mft.completeloginservice.model.entity.Person;
import com.mft.completeloginservice.model.entity.Role;
import com.mft.completeloginservice.model.entity.User;
import com.mft.completeloginservice.model.service.PersonService;
import com.mft.completeloginservice.model.service.RoleService;
import com.mft.completeloginservice.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import jakarta.persistence.EntityManager;

import java.io.IOException;

import static com.mft.completeloginservice.controller.encryption.Base64.Encoder.baseEncoder;

@WebServlet(name = "signUpServlet", value = "/signup.do")
@Slf4j
public class SignUpServlet extends HttpServlet {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Inject
    private User user;
//    @Inject
//    private Person person;
//    @Inject
//    private Role role;

    @Inject
    private UserService userService;
//    @Inject
//    private PersonService personService;
//    @Inject
//    private RoleService roleService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            String name = req.getParameter("name");
//            String family = req.getParameter("family");

//            person = Person
//                    .builder()
//                    .name(name)
//                    .family(family)
//                    .deleted(false)
//                    .build();


//            personService.save(person);
//            log.info("person saved");
//            resp.sendRedirect("/signup.do");


//            String roleName = req.getParameter("role");

//            role = Role.builder()
//                    .role(roleName)
//                    .deleted(false)
//                    .build();
//            roleService.save(role);
//            log.info("role saved");
//            resp.sendRedirect("/signup.do");


            String userName = req.getParameter("username");
            String password = req.getParameter("password");
//           String encodedPass = baseEncoder(password);

            user = User.builder()
                    .userName(userName)
                    .password(password)
                    .deleted(false)
//                    .person(person)
//                    .role(role)
                    .build();

            userService.save(user);
            log.info("user saved");
            resp.sendRedirect("/users.do");



        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }



}
