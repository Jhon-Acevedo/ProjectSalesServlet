package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shop;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyUser() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String user = String.valueOf(request.getParameter("user"));
        String password = String.valueOf(request.getParameter("password"));
        Shop shop = Controller.getShop();
        boolean verify = shop.verifyClient(user, password);
        RequestDispatcher dispatcher = null;
        if (verify) {
            dispatcher = request.getRequestDispatcher("/catalog.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("index.jsp");
            System.out.println("status: " + request.getAttribute("status"));
        }
        dispatcher.forward(request, response);
    }
}
