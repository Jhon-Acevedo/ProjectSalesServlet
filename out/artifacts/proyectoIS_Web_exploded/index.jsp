<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="css/login.css">--%>
    <style>
        <%@include file="/css/login.css" %>
    </style>
</head>
<body>
<%--<section id="container">--%>
<%--    <h1>BIENVENIDO</h1>--%>
<%--    <form action="VerifyUser" method="post">--%>
<%--        <div class="input">--%>
<%--            <label for="usuario">Usuario</label> <input--%>
<%--                placeholder="Ingresar Usuario" type="text" name="user" required>--%>
<%--        </div>--%>
<%--        <div class="input">--%>
<%--            <label for="password">Contraseña</label> <input--%>
<%--                placeholder="Ingresar contraseña" type="password" name="password"--%>
<%--                required>--%>
<%--        </div>--%>

<%--        <button id="button_send">Enviar</button>--%>
<%--    </form>--%>
<%--</section>--%>
<section class="pt-5 pb-5 mt-0 align-items-center d-flex bg-dark"
         style="min-height: 100vh; background-size: cover; background-image: url(https://source.unsplash.com/D6Tu_L3chLE);">
    <div class="container-fluid">
        <div class="row  justify-content-center align-items-center d-flex-row text-center h-100">
            <div class="col-12 col-md-4 col-lg-3   h-50 ">
                <div class="card shadow">
                    <div class="card-body mx-auto">
                        <h4 class="card-title mt-3 text-center">Iniciar Sesion</h4>
                        <br>
                        <p class="text-center">Bienvenido A ver si ahorra</p>
                        <form action="VerifyUser" method="post">
                            <div class="mb-3">
                                <input id="username" name="user" type="text" placeholder="Usuario" required
                                       class="form-control rounded-pill border-0 shadow-sm px-4"/>
                            </div>
                            <div class="mb-3">
                                <input id="password" name="password" type="password" placeholder="Password" required
                                       class="form-control rounded-pill border-0 shadow-sm px-4 text-primary"/>
                            </div>
                            <div class="d-grid gap-2 mt-2">
                                <button type="submit"  class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm"> Login </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

</body>
</html>