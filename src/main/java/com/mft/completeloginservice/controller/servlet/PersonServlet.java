package com.mft.completeloginservice.controller.servlet;

import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@ServletSecurity(value = @HttpConstraint(
        rolesAllowed = {"admin"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(
                        value = "GET",
                        rolesAllowed = {"admin"}
                )
        }
)


@WebServlet(name = "personServlet", value = "/person.do")
public class PersonServlet extends HttpServlet {
}
