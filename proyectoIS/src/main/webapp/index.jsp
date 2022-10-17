<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<section id="container">
		<h1>BIENVENIDO</h1>
		<form action="VerifyUser" method="post">
			<div class="input">
				<label for="usuario">Usuario</label> <input
					placeholder="Ingresar Usuario" type="text" name="user" required>
			</div>
			<div class="input">
				<label for="password">Contraseña</label> <input
					placeholder="Ingresar contraseña" type="password" name="password"
					required>
			</div>
                
            <button id="button_send">Enviar</button>
		</form>
	</section>
</body>
</html>