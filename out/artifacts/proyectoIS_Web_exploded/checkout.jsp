<%@page import="model.Detail"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Controller"%>
<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Revisión de productos</title>
<link rel="stylesheet" href="css/checkout.css">
</head>
<body>
	
	
	<section>
	
	<div id="info">
	<h1>Confirmación de pedido</h1>
		<%
			String[] info = Controller.getShop().getInfoClient(); 
			out.print("<h2> Nombre: " + info[0] + " " + info[1] +"</h2>"
					+ "<h2> Dirección: " + info[2] + "</h2>"
					+ "<h2> Número de factura: " + Controller.getShop().getIdBill() + "</h2>");
		%>
	</div>
		<table>
			<tbody>
				<tr>
					<td id="header">Nombre</td>
					<td id="header">Precio</td>
					<td id="header">Presentación</td>
					<td id="header">Unidades</td>
					<td id="header">Precio total</td>
				</tr>

				<%
						ArrayList<Detail> details = Controller.getShop().getDetailsPurchase();
						for (Detail detail : details) {
							Product product = Controller.getShop().productPurchase(detail.getIdProduct());
							out.print("<tr>"
							+ "<td>" + product.getName() + "</td>" 
							+ "<td>" + product.getCost() + "</td>" 
							+ "<td>" + product.getPresentation() + "</td>" 
							+ "<td>" + detail.getQuantity() + "</td>" 
							+ "<td>" + detail.calculateSubtotal() + "</td>"
							+ "</tr>");
						}
						%>

			</tbody>
		</table>
		
		<div id="prices">
		<%
			out.print("<h2>Subtotal: $" + Controller.getShop().getSubtotal() + "</h2>");
			out.print("<h2>Total: $" + Controller.getShop().getTotal() + "</h2>");
		%>
	</div>
	</section>
	
	<div id="buttons_foot">
		<form action="ConfirmPurchase" method="post">
			<button id="finish_button">Confirmar pedido</button>
		</form>
		<button id="finish_button"> <a href="catalog.jsp">Cancelar</a></button>
	</div>
</body>
</html>