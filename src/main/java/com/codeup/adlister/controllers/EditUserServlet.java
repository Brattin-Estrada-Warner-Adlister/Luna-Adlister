package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.EditUserServlet", urlPatterns = "/users/edit")
public class EditUserServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");

            if (loggedIn != null && loggedIn) {
                request.getRequestDispatcher("/WEB-INF/users/edit.jsp").forward(request, response);
                return;
            }
            response.sendRedirect("/login");
        } catch (IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {

        Long id = Long.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("HERE");

        User updatedUser = new User();
        updatedUser.setUsername(username);
        updatedUser.setEmail(email);
        updatedUser.setId(user.getId());
        request.getSession().setAttribute("user", user);
        boolean valid =
                username.isEmpty() ||
                email.isEmpty();


        if (valid) {
            response.sendRedirect("/login");
            return;
        }

        try {
            DaoFactory.getUsersDao().editUser(updatedUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/profile");

    }
}

