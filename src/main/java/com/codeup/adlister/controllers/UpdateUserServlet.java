package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update", urlPatterns = "/update")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) {
        try {
            Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");

            if (loggedIn != null && loggedIn) {
                request.getRequestDispatcher("/WEB-INF/users/update.jsp").forward(request, response);
                return;
            }
            response.sendRedirect("/login");
        } catch (IOException | ServletException e) {
            System.out.printf("ERROR: %s\n", e);
        }
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            boolean valid = !String.valueOf(id).isEmpty() ||
                    !username.isEmpty() ||
                    !email.isEmpty() ||
                    !password.isEmpty();
            if (!valid) {
                response.sendRedirect("/update?alert=true");
                return;
            }
            User user = new User(
                    id, username, email, password
            );
            DaoFactory.getUsersDao().updateUser(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");

        } catch (IOException e) {
            System.out.printf("ERROR: %s\n", e);
        }

    }
}
