package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

<<<<<<< HEAD
import javax.servlet.ServletException;
=======
>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
<<<<<<< HEAD

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/profile/delete")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        DaoFactory.getUsersDao().deleteUser(user.getId());
        response.sendRedirect("/logout");
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/delete-profile")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long userId = Long.parseLong(request.getParameter("userId"));

        DaoFactory.getUsersDao().deleteUser(userId);
        response.sendRedirect("/register");
>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
    }
}