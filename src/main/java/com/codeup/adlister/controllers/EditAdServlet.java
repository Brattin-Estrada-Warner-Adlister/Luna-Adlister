package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/edit-mads")
public class EditAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long adId = Long.parseLong(request.getParameter("editAd"));
        request.setAttribute("ad", DaoFactory.getAdsDao().findAdById(adId));
        request.getRequestDispatcher("/WEB-INF/edit-ads.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long id = Long.parseLong(request.getParameter("id"));
        Ad beforeAd = null;
        beforeAd = (Ad) DaoFactory.getAdsDao().findAdById(id);

        Ad editAd = new Ad(beforeAd.getId(), title, description);
        try {
            DaoFactory.getAdsDao().editAd(beforeAd, editAd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("ad",editAd);
        response.sendRedirect("/ads");
    }
}