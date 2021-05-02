package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/delete")
public class DeleteAdServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        try {
            Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");
            if (loggedIn != null && loggedIn) {
                Long adId = Long.valueOf(request.getParameter("adId"));
                Ad ad = DaoFactory.getAdsDao().getAdById(adId);
                User user = (User) request.getSession().getAttribute("user");
                if (ad.getUserId() == user.getId()) {
                    request.setAttribute("ad", ad);
                }

                request.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request, response);

            } else response.sendRedirect("/login");
        } catch (IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            DaoFactory.getAdsDao().delete(id);
            response.sendRedirect("/ads");

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
}