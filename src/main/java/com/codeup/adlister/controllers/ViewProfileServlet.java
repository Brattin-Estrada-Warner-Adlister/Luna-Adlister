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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User)request.getSession().getAttribute("user");
        long userId = user.getId();
        Stream<Ad> userA =  DaoFactory.getAdsDao().all().stream().filter(ad -> ad.getUserId() == userId);
        ArrayList<Ad> userAds = userA.collect(Collectors.toCollection(ArrayList::new));
        for (Ad o : userAds) {
            System.out.println(o.getTitle());
        }
        System.out.println(userAds.size());
        request.setAttribute("userAds",userAds);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
<<<<<<< HEAD
}



// PRE-EXISTING CODE FROM FORK. BACKUP DUE TO ISSUES WITH ABOVE CODE.

//@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
//public class ViewProfileServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
//        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
//    }
//}
=======
}
>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
