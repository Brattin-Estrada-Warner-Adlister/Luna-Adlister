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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.codeup.adlister.dao.DaoFactory.getAdsDao;

@WebServlet(name = "controllers.SearchAdsServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchAds = request.getParameter("search");
        List<Ad> foundAds = null;

        try {
            foundAds = DaoFactory.getAdsDao().searchAdsFromResults(searchAds);
            request.setAttribute("ads", foundAds);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request, response);
        System.out.println("These are the ads that we found");

    }
}