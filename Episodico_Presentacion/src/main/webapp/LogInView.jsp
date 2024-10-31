<%-- 
    Document   : LogIn-view
    Created on : 28 oct 2024, 22:31:35
    Author     : tacot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="LogIn/Style.css">
        <title>Sing In</title>
    </head>
    <body>
        <div class="mainContainer">
            <h2>Iniciar Sesion</h2>
            <form action="LogInController" method="POST">
                <input type="hidden" name="InicioDeSesion" value="IniciarSesion">
                <div class="textbox">
                    <h4 for="usuario">Usuario:</h4>
                    <input type="text" name="txtUsuario" id="usuario" placeholder="Usuario" required>
                </div>
                <div class="textbox">
                    <h4 for="contraseña">Contraseña:</h4>
                    <input type="password" name="txtContrasena" id="contraseña" placeholder="Contraseña" required>
                </div>
                <button type="submit" class="btn">Iniciar Sesion</button>
            </form>
            <a href="/Registro/Registro.html">registro</a>
        </div>
    </body>
</html>
