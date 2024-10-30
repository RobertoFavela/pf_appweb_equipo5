<%-- 
    Document   : SeriesProfile
    Created on : 29 oct 2024, 12:00:19 a.m.
    Author     : favel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Perfil de Persona</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SeriesProfile/Style.css">
    <title>Perfil de Persona</title>
</head>
<body>
    <header>
        <div class="icono-casa"><a href="/Inicio/index.html">🏠</a></div>
        <div class="usuario">😊Usuario</div>
    </header>
    <div class="gridContainer">

        <div class="Perfilserie">
            <div class="foto-Perfilserie"></div>
            <div class="descripcion">
                <h2>Titulo de la serie</h2>
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Incidunt facere iste harum fuga corporis! Impedit laudantium illum consectetur, vitae quia fuga maiores aut nisi debitis itaque dicta amet tenetur ab fugit maxime corporis nulla commodi vero. Neque error quos eius libero. Vitae, accusantium! Magnam neque deleniti, reiciendis vitae laborum adipisci. Voluptatem eligendi dolorem at beatae doloribus harum tempora aliquid fugiat voluptatum a perspiciatis, laudantium minus amet quas qui quos. Qui dignissimos recusandae itaque maiores labore a quam in laborum! Error impedit, maiores ducimus omnis perspiciatis esse unde nulla eum, illo vero totam assumenda beatae minus deleniti atque facilis ad animi!</p>
            </div>
        </div>

        <div class="nueva-resena">
            <input type="text" placeholder="Escribe una reseña...">
            <button>➤</button>
        </div>

        <div class="resenas">
            <div class="resena">
                <h4>Nombre del usuario</h4>
                <div class="contenido-resena">
                    <p>Esta es una reseña escrita por una persona acerca de una serie...</p>
                    <div class="imagen-resena"></div>
                </div>
                <div class="rating">
                    ⭐⭐⭐⭐
                </div>
                <div class="acciones-resena">
                </div>
            </div>
        </div>

        <div class="similares">
            <h4>Favoritas</h4>
            <div class="serie-similar"></div>
            <div class="serie-similar"></div>
        </div>
    </div>
</body>
</html>

