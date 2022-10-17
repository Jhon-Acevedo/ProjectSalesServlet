package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmPurchase
 */
@WebServlet("/ConfirmPurchase")
public class ConfirmPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPurchase() {
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
		
		Controller.getShop().updateProduct();
		Controller.getShop().updateList();
		
		PrintWriter out;
	    out = response.getWriter();
	    response.setContentType("text/html");
	    out.println("<html>");
		out.println("<head> <title>Confirmación de pedido</title>"
				+ "<link rel=\"stylesheet\" href=\"css/login.css\">");
        out.println("</head>");
		out.println("<body>");
		out.println("<section id=\"container\">"
				+ "<label>Confirmación de pedido exitosa: sus productos llegarán muy pronto a su casa</label>"
				+ "<button><a href=\"catalog.jsp\">Regresar al catálogo</a></button>"
				+ "</section>");
        out.println("</body></html>");
	}

}
