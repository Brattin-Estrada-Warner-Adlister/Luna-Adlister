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
import java.sql.SQLException;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/edit")
public class EditAdServlet extends HttpServlet {
    Ad ad;
    long adId;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedAd = request.getPathInfo();
        try {
            adId = Long.parseLong(selectedAd.substring(1));
            ad = DaoFactory.getAdsDao().getAdById(adId);
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(adId);
        String title_update = request.getParameter("title");
        String description_update = request.getParameter("description");

        ad.setId(adId);
        ad.setTitle(title_update);
        ad.setDescription(description_update);
        DaoFactory.getAdsDao().editAd(ad);

        response.sendRedirect("/profile");
    }
}
//@WebServlet("/edit")
//public class EditAdServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long id = Long.parseLong(req.getParameter("edit"));
//        Ad ad = DaoFactory.getAdsDao().getAdById(id);
//        req.setAttribute("ad", ad);
//
//        req.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long id = Long.parseLong(req.getParameter("edit"));
//        String updateTitle = req.getParameter("new_title");
//        String updateDescription = req.getParameter("new_description");
//        Ad updateAd = new Ad();
//        updateAd.setTitle(updateTitle);
//        updateAd.setDescription(updateDescription);
//        updateAd.setId(id);
//        boolean inputHasErrors =
//                updateTitle.isEmpty() || updateDescription.isEmpty();
//
//        if (inputHasErrors) {
//            resp.sendRedirect("/edit");
//            return;
//        }
//        DaoFactory.getAdsDao().editAd(updateAd);
//
//        resp.sendRedirect("/profile");
//
//    }
//}
//

//@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
//public class EditAdServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
//            try {
//                Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");
//                if(loggedIn != null && loggedIn){
//                    Long adId = Long.valueOf(request.getParameter("adId"));
//                    Ad ad = DaoFactory.getAdsDao().getAdById(adId);
//                    User user = (User)request.getSession().getAttribute("user");
//                    if(ad.getUserId() ==  user.getId()){
//                        request.setAttribute("ad", ad);
//                    }
//
//                    request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
//
//                }
//                else response.sendRedirect("/login");
//            } catch(IOException | ServletException ex) {
//                System.out.printf("ERROR: %s\n", ex);
//            }
//        }
//
//
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            try {
//                long id = Long.parseLong(request.getParameter("id"));
//                long userId = Long.parseLong(request.getParameter("userId"));
//                String title = request.getParameter("title") == null ? "" : request.getParameter("title");
//                String description = request.getParameter("description") == null ? "" : request.getParameter("description");
//
//                boolean inValid =
//                        Long.toString(id).equals("") || Long.toString(userId).equals("") ||
//                                title.equals("") ||
//                                description.equals("");
//                if (!inValid) {
//                    Ad afterAd = new Ad(id, userId, title, description);
//                    Ad beforeAd = null;
//                    DaoFactory.getAdsDao().editAd(Ad beforeAd, Ad afterAd);
//                    response.sendRedirect("/profile");
//                    return;
//                }
//                    response.sendRedirect("/ads/edit?alert=true&adId=" + id);
//
//                } catch(IOException ex){
//                    System.out.printf("ERROR: %s\n", ex);
//                }
//            }
//        }