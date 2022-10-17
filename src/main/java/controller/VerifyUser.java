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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String user = String.valueOf(request.getParameter("user"));
		String password = String.valueOf(request.getParameter("password"));
		
		Shop shop = Controller.getShop();
		boolean verify = shop.verifyClient(user, password);
	    
		if(verify) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/catalog.jsp");
	        dispatcher.forward(request, response);
		}else {
			PrintWriter out;
		    out = response.getWriter();
		    response.setContentType("text/html");
		    out.println("<html>");
			out.println("<head> <title>Error de validación</title>"
					+ "<link rel=\"stylesheet\" href=\"css/login.css\">");
            out.println("</head>");
			out.println("<body>");
			out.println("<section id=\"container\">"
					+ "<label>Datos incorrectos</label>"
					+ "<button><a href=\"index.jsp\">Intentar de nuevo</a></button>"
					+ "</section>");
            out.println("</body></html>");
		}
	}
}
