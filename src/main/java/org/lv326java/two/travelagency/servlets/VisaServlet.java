package org.lv326java.two.travelagency.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VisaServlet")
public class VisaServlet extends HttpServlet {


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//TODO check if user exist, his log and pswd (role) and redirect to his page (users or admins)
//
            request.getRequestDispatcher("WEB-INF/pages/search.jsp").forward(request, response);

//
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/visa.jsp").forward(request, response);
        }

}