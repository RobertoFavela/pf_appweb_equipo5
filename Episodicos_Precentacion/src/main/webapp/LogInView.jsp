<%-- 
    Document   : LogIn-view
    Created on : 28 oct 2024, 22:31:35
    Author     : tacot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login y Registro</title>
        <link rel="stylesheet" href="LogIn/Style.css">
    </head>
    <body>
        <div class="contenedor" id="contenedor">
            <div class="panel-logo" id="panel-logo">
                <img src="LogIn/logo.png" alt="Episodico" class="logo">
                <p>Rankea tus series favoritas!</p>
            </div>

            <div class="panel-formulario">
                <!-- Formulario de inicio de sesión -->
                <form id="formulario-inicio" class="formulario activo" action="LogInController" method="POST">
                    <input type="hidden" name="AccionIniciarSesion" value="IniciarSesion">
                    <h2>Iniciar sesión</h2>
                    <label for="email-inicio">E-mail:</label>
                    <input type="email" id="email-inicio" placeholder="Correo electrónico" name="txtUsuario" required>
                    <label for="password-inicio">Contraseña:</label>
                    <input type="password" id="password-inicio" placeholder="Contraseña" name="txtContrasena" required>
                    <button type="submit">Ingresar</button>
                    <p id="textoEspecial">¿No tienes cuenta? <span id="mostrar-registro">Regístrate</span></p>
                </form>


                <!-- Formulario de registro -->
                <form id="formulario-registro" class="formulario" action="RegisterController" method="POST">
                    <h2>Registrarse</h2>
                    <input type="hidden" name="accion" value="RegistrarUsuario">
                    <label for="email-registro">E-mail:</label>
                    <input type="email" name="txtCorreo" id="email-registro" placeholder="Correo electrónico" required>
                    <label for="nombre-registro">Nombre de usuario:</label>
                    <input type="text" name="txtUsuario" id="nombre-registro" placeholder="Nombre de usuario" required>
                    <label for="password-registro">Contraseña:</label>
                    <input type="password" name="txtContra" id="password-registro" placeholder="Contraseña" required>
                    <button type="submit">Aceptar</button>
                    <p id="textoEspecial">¿Ya tienes cuenta? <span id="mostrar-inicio">Inicia sesión</span></p>
                </form>
            </div>
        </div>
        <script src="LogIn/scriptMovimiento.js"></script>
    </body>
</html>
