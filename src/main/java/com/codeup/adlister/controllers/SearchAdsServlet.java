package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean loggedIn = (Boolean)request.getSession().getAttribute("loggedIn");

        if(loggedIn == null || !loggedIn) {
            response.sendRedirect("/login");
        }
        response.sendRedirect("/ads");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> filteredList = new ArrayList<>();
        String searchTerm = request.getParameter("searchTerm");
            filteredList = DaoFactory.getAdsDao().searchAds(searchTerm);
            System.out.println(filteredList.size());
            request.getSession().setAttribute("filtered", filteredList);
        response.sendRedirect("/ads");
    }
}