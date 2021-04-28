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

@WebServlet("/profile/edit")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("editUser"));//USER ID IN JSP
        User user = null;// GRABBING USER ID & IMPLEMENTING IT WITH getId FROM User Model THEN PASSING TO REF OBJECT
        try {
            user = DaoFactory.getUsersDao().findUserById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("user", user);// USER ATTRIBUTE IN OBJ

        req.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(req, resp);//FORWARD TO EDIT PROFILE
    }

    //TODO: Update the user username and email while maintaining the same ID and password:

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");// <------------------------- Pulling username user input from form on editProfile.jsp
        String email = req.getParameter("email");// <------------------------------- Pulling email user input from form on editProfile.jsp
        User user = (User) req.getSession().getAttribute("user");// <--------------- Pulling the currently logged in user object from session
        User updatedUser = new User();// <--------------------------------------------- Creating a new instance of user to set new values
        updatedUser.setUsername(username);// <----------------------------------------- Setting the new username to the user input
        updatedUser.setEmail(email);// <----------------------------------------------- Setting the new email to the user input
        updatedUser.setId(user.getId());// <------------------------------------------- Setting the user ID to the currently logged in user's ID
        updatedUser.setPassword(user.getPassword());// <------------------------------- Setting the password to the currently logged in user's password
        req.getSession().setAttribute("user", updatedUser);// <--------------------- Setting the new user as the current user

        boolean inputHasErrors = // <-------------------------------------------------- Checking that the form fields are not empty
                username.isEmpty()
                        || email.isEmpty();

        if (inputHasErrors) {
            resp.sendRedirect("/profile/edit");
            return;
        }
        try {
            DaoFactory.getUsersDao().editUser(updatedUser);// <------------------------------ Updating the database by passing the new user into the update method
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/profile");// <------------------------------------------ Sending the user back to their profile page
    }
}
