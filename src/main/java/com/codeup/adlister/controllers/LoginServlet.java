package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
<<<<<<< HEAD
=======

>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = request.getParameter("redirect");
        request.setAttribute("redirect",redirect);

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        String redirect = request.getParameter("redirect");

        if (user == null) {
            response.sendRedirect("/login?alert=true");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
<<<<<<< HEAD
            request.getSession().setAttribute("loggedIn", true);
=======
            if ("create".equalsIgnoreCase(redirect)) {
                response.sendRedirect("/ads/create");
            } else {
                response.sendRedirect("/profile");
            }
>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
            request.getSession().setAttribute("user", user);
        } else {
            response.sendRedirect("/login");
        }
    }
}