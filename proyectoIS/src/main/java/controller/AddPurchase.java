package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Detail;
import model.Product;

/**
 * Servlet implementation class AddPurchase
 */
@WebServlet("/AddPurchase")
public class AddPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPurchase() {
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
		
		int id = Integer.valueOf(request.getParameter("id"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		ArrayList<Product> products = Controller.getShop().getProducts();
		Product productSel = null;
		ArrayList<Detail> shoppingCar = Controller.shop.getShoppingCar();
		
		for (Product product: products) {
			if(id == product.getId()) {
				productSel = product;
				int i = productSel.getStock() - quantity;
				productSel.setStock(i);
				break;
			}
		}
		
		if(quantity < productSel.getStock()) {
			shoppingCar.add(new Detail(Controller.shop.generateIdDetail(), id, -1, quantity, productSel.getCost()));
		}
		
		PrintWriter out;
	    out = response.getWriter();
	    response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Producto agregado al carrito');");
        out.println("location='catalog.jsp';");
        out.println("</script>");
	}

}
