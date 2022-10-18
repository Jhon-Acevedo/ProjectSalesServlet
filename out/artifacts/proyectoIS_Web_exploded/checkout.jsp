<%@page import="model.Detail" %>
<%@page import="model.Product" %>
<%@page import="java.util.ArrayList" %>
<%@page import="controller.Controller" %>
<%@page import="model.Client" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Revisión de productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <Style>
        <%@include file="css/checkout.css" %>
    </Style>
</head>
<body>


<section id=body_infos>
    <div>
        <h1 id="titleCatalog">Confirmación de pedido</h1>
        <%
            String[] info = Controller.getShop().getInfoClient();
            out.print("<div class=\"d-flex justify-content-start\"> <h3 class='title-name'> Nombre del usuario: </h3>" + "<h3>" + " " + info[0] + " " + info[1] + "</h3> </div>"
                    + "<div class=\"d-flex justify-content-start\"> <h3 class='title-name'> Dirección de envio: </h3> " + "<h3>" + info[2] + "</h3></div>"
                    + "<div class=\"d-flex justify-content-start\"> <h3 class='title-name'> Número de factura: </h3>" + "<h3>" + Controller.getShop().getIdBill() + "</h3></div>");
        %>
    </div>
</section>


<%
    out.print("<section id='section-table'>");
    out.print("<table class='table'>"
            + "<thead>"
            + "<tr>"
            + "<th scope='col' class='bg-success'>Nombre</th>"
            + "<th scope='col' class='bg-success'>Precio</th>"
            + "<th scope='col' class='bg-success'>Presentación</th>"
            + "<th scope='col' class='bg-success'>Unidades</th>"
            + "<th scope='col' class='bg-success'>Precio total</th>"
            + "</tr>"
            + "</thead>"
            + "<tbody>");
    ArrayList<Detail> details = Controller.getShop().getDetailsPurchase();
    for (Detail detail : details) {
        Product product = Controller.getShop().productPurchase(detail.getIdProduct());
        out.print("<tr>"
                + "<th scope='row'>" + product.getName() + "</th>"
                + "<td>" + product.getCost() + "</td>"
                + "<td>" + product.getPresentation() + "</td>"
                + "<td>" + detail.getQuantity() + "</td>"
                + "<td>" + detail.calculateSubtotal() + "</td>"
                + "</tr>");
    }
    out.print("</tbody>");
    out.print("</table>");
    out.print("</section>");
%>

<section id="total">
    <%
        out.print("<hr>");
        out.print("<p class=\"text-right\">Subtotal: $" + Controller.getShop().getSubtotal() + "</p>");
        out.print("<hr>");
        out.print("<p class=\"text-right\">Total (IVA 19%): $" + Controller.getShop().getTotal() + "</p>");
    %>
</section>

<section id="section-pay">
    <div class="m-0 vh-100 eow justify-content-center align-items-center">
        <div class="col-auto p-5 text-center">
            <form action="ConfirmPurchase" method="post">
                <button id="btn-buy">Confirmar pedido</button>
                <button id="btn-cancel"><a href="catalog.jsp">Cancelar</a></button>
            </form>
        </div>
    </div>
</section>


<%--boostrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
</script>

</body>
</html>