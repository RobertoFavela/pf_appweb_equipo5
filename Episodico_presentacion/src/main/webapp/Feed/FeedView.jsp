<%-- 
    Document   : FeedView
    Created on : 29 oct 2024, 12:04:13 a.m.
    Author     : favel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Style.css">
    <title>Página Principal</title>
</head>
<body>
    
    <header>
        <div class="icono-casa"><a href="/Inicio/index.html">🏠</a></div>
        <div class="usuario">😊Usuario</div>
    </header>

    <section class="agregadas-recientemente">
        <h2>Agregadas recientemente</h2>
        <div class="contenedor-series">
            <div class="serie">
                <div class="info">Star Wars<br>5 Temporadas<br>❤ 5K | 👁️ 25K</div>
            </div>
            <div class="serie"><a href="/PerfilSerie/perfilSerie.html"></a></div>
            <div class="serie"></div>
            <div class="serie"></div>
            <div class="serie"></div>
            <div class="serie"></div>
        </div>
    </section>

    <section class="mejor-calificadas">
        <h2>Mejor calificadas</h2>
        <div class="contenedor-series">
            <div class="serie"><a href="/PerfilSerie/perfilSerie.html"></a></div>
            <div class="serie"></div>
            <div class="serie"></div>
            <div class="serie"></div>
            <div class="serie"></div>
            <div class="serie"></div>
        </div>
    </section>

    <section class="resenas-recientes">
        <h2>Reseñas recientes</h2>
        <div class="resena">
            <div class="titulo-resena">📄 Título de reseña</div>
            <div class="info-resena">
                <div class="texto-resena">Este es un ejemplo de texto de la reseña. Aquí puedes agregar el contenido de la reseña más reciente.</div>
                <div class="imagen-resena">Imagen de serie</div>
            </div>
        </div>
    </section>
</body>
</html>

