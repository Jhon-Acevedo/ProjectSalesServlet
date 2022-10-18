<%--<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>--%>
<%@page import="controller.Controller" %>
<%@page import="model.Product" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        <%@include file="/css/catalog.css" %>
    </style>
    <title>Catálogo</title>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-right">
            <li class="li-sesion"><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span>Cerrar sesión</a>
            </li>
        </ul>
    </div>
</nav>


<section id="body_info">

    <h1 id="titleCatalog">Catálogo de Productos</h1>
    <section>
        <%
            out.print("<table class='table'>");
            out.print("<thead>");
            out.print("<tr>");
            out.print("<th scope='col' class='bg-success'>ID</th>");
            out.print("<th scope='col' class='bg-success'>Nombre</th>");
            out.print("<th scope='col' class='bg-success'>Precio</th>");
            out.print("<th scope='col' class='bg-success'>Unidades disponibles</th>");
            out.print("<th scope='col' class='bg-success'>Cantidad</th>");
            out.print("<th scope='col' class='bg-success'>Comprar</th>");
            out.print("</tr>");
            out.print("</thead>");
            out.print("<tbody>");

            ArrayList<Product> products = Controller.getShop().getProducts();
            for (Product product : products) {
                out.print("<tr>");
                out.print("<form action='AddPurchase' method='post'>");
                out.print("<th scope=" + "'row'>" + "<input id=\"input_id\" name=\"id\" readonly=\"readonly\" value=\"" + product.getId() + "\"> </th>");
                out.print("<td>" + product.getName() + "</td>"
                        + "<td>" + product.getCost() + "</td>"
                        + "<td>" + product.getStock() + "</td>"
                        + "<td> <input name=\"quantity\" type=\"number\" max=\"" + product.getStock()
                        + "\" min=\"1\" value=\"1\"></td>" + "<td><button>Comprar</button> </td>");
                out.print("</form>");
                out.print("</tr>");
            }
            out.print("</tbody>");
            out.print("</table>");
        %>
    </section>
<%--    <form action="FinishPurchase" method="post">--%>
<%--        <button type="button" id="finish_button" class="btn btn-success">Revisar Productos</button>--%>
<%--    </form>--%>
    <form action="FinishPurchase" method="post" id="formFinish">
        <button id="finish_button">Revisar productos</button>
    </form>
</section>

<%--boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
</script>

</body>
</html>