package org.lv326java.two.travelagency.servlets;

import org.lv326java.two.travelagency.entities.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Country> countryList = dbConnection.getAll();
//        request.setAttribute("countries", countryList);

        request.getRequestDispatcher("WEB-INF/pages/hotels.jsp").forward(request, response);

    }
}