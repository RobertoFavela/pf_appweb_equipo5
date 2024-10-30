<%-- 
    Document   : SingInView
    Created on : 28 oct 2024, 11:56:16 p.m.
    Author     : favel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Register/Style.css">
    <title>Registrarse</title>
</head>
<body>
    <div class="mainContainer">
        <h2>Registrarse</h2>
        <form action="RegisterController" method="POST">
            <input type="hidden" name="RegistrarUsuario" value="Registrarse">
            <div class="textbox">
                <label for="correo">Correo:</label>
                <input type="text" name="txtCorreo" placeholder="correo" required>
            </div>
            <div class="textbox">
                <label for="usuario">Nombre de usuario:</label>
                <input type="text" name="txtUsuario" placeholder="Nombre de usuario" required>
            </div>
            <div class="textbox">
                <label for="contra">Contraseña:</label>
                <input type="password" name="txtContra" placeholder="Contraseña" required>
            </div>
            <input type="submit" class="btnRegistro" name="RegistrarUsuario" value="Registrarse">
        </form>
    </div>
</body>
</html>


