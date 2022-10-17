<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="controller.Controller"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/catalog.css">
<meta charset="UTF-8">
<title>Catálogo</title>
</head>
<body>

	<section id="head">
		<ul>
			<li><a href="index.jsp">Cerrar Sesión</a></li>
		</ul>
	</section>

	<section id="body_info">

		<h1>Catálogo de Productos</h1>

		<section>
			<table>
				<tbody>
					<tr>
						<td id="header">Nombre</td>
						<td id="header">Precio</td>
						<td id="header">Unidades disponibles</td>
						<td id="header">Cantidad</td>
						<td id="header">¿Comprar?</td>
					</tr>

					<%
					ArrayList<Product> products = Controller.getShop().getProducts();
					for (Product product : products) {
						out.print("<tr>");
						out.print("<form action=\"AddPurchase\" method=\"post\"");
						out.print("<td> <input id=\"input_id\" name=\"id\" readonly=\"readonly\" value=\"" + product.getId() + "\"> </td>"
						+ "<td>" + product.getName() + "</td>" + "<td>" + product.getCost() + "</td>" + "<td>" + product.getStock()
						+ "</td>" + "<td> <input name=\"quantity\" type=\"number\" max=\"" + product.getStock()
						+ "\" min=\"1\" value=\"1\"></td>" + "<td><button>Comprar</button> </td>");
						out.print("</form>");
						out.print("</tr>");
					}
					%>

				</tbody>
			</table>
		</section>

		<form action="FinishPurchase" method="post">
			<button id="finish_button">Revisar productos</button>
		</form>
	</section>
</body>
</html>