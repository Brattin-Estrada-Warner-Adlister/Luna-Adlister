package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.EditServlet", urlPatterns = "/edit-profile")
public class EditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        long userId = Long.parseLong(request.getParameter("editUser"));
        try {
            request.setAttribute("user", DaoFactory.getUsersDao().findUserById(userId));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/edit-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String email = request.getParameter("email");

        User oldUser = (User) request.getSession().getAttribute("user");


        User editUser = new User(oldUser.getId(),userName,email,oldUser.getPassword());
        try {
            DaoFactory.getUsersDao().editUser(oldUser,editUser);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        request.getSession().setAttribute("user", editUser);
        response.sendRedirect("/profile");
    }
}
