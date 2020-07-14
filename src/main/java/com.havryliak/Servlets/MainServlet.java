package com.havryliak.Servlets;

import com.havryliak.DAO.RoomDAO;
import com.havryliak.DAO.Room_Roomer_DAO;
import com.havryliak.DAO.RoomerDAO;
import com.havryliak.Model.Room;
import com.havryliak.Model.Roomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class MainServlet {

    private RoomerDAO rd = new RoomerDAO();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    System.out.println("1");
                    break;
                case "/list":
                    roomerList(request, response);
                    break;
                default:
                    System.out.println("2");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void roomerList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Roomer> listRoomer = rd.getAll();
        request.setAttribute("listRoomer", listRoomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    /*private void insertRoomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Roomer newRoomer = new Roomer(name, email, country);
        rd.add(newRoomer);
        response.sendRedirect("list");
    }*/
}
