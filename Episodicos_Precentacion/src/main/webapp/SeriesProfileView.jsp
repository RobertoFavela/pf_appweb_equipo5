<%-- Document : SeriesProfile Created on : 29 oct 2024, 12:00:19 a.m. Author : favel --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Perfil de Serie</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Series/StyleSeriesProfile.css">
    </head>

    <body>

        <div class="Feed">

            <header>
                <nav class="nav">
                    <!-- Inicio -->
                    <form action="FeedController" method="get">
                        <input type="hidden" name="Inicio" value="Inicio" class="radio">
                        <button type="submit" title="Inicio" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3..org/2000/svg" aria-hidden="true" class=" imgNav">
                            <path
                                d="m4 12 8-8 8 8M6 10.5V19a1 1 0 0 0 1 1h3v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h3a1 1 0 0 0 1-1v-8.5"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="round"
                                stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    <!-- Buscar -->
                    <form action="SeriesController" method="get">
                        <input type="hidden" name="rad" value="buscar " class="radio">
                        <button type="submit" title="Buscar" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
                            <path d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z" stroke-width="2"
                                  stroke-linecap="round" stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    <!-- Favoritas -->
                    <form action="Postcontroller" method="get">
                        <input type="hidden" name="rad" value="Series" class="radio checked">
                        <button type="submit" title="Series" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav ">
                            <path
                                d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="round"
                                stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    <!-- Perfil -->
                    <form action="UserProfileController" method="get">
                        <input type="hidden" name="perfil" value="perfil" class="radio">
                        <button type="submit" title="perfil" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
                            <path
                                d="M10 19H5a1 1 0 0 1-1-1v-1a3 3 0 0 1 3-3h2m10 1a3 3 0 0 1-3 3m3-3a3 3 0 0 0-3-3m3 3h1m-4 3a3 3 0 0 1-3-3m3 3v1m-3-4a3 3 0 0 1 3-3m-3 3h-1m4-3v-1m-2.121 1.879-.707-.707m5.656 5.656-.707-.707m-4.242 0-.707.707m5.656-5.656-.707.707M12 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="square"
                                stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>
                </nav>
            </header>

            <body>

                <div class="Feed">


                    <!-- Información principal de la serie -->
                    <div class="perfil">
                        <div class="foto-perfil">
                            <!-- <img src="{serie.imagenUrl}" alt="{serie.titulo}" class="serie-img-perfil"> -->
                        </div>
                        <div class="NombrePerfil">
                            <h2>${serie.titulo}</h2> <!-- Título dinámico -->
                        </div>
                        <div class="descripcion">
                            <p>${serie.descripcion}</p> <!-- Descripción dinámica -->
                        </div>
                    </div>

                    <c:if test="${!esAdmin}">
                        <h2>Escribe una reseña</h2>
                        <div class="nueva-resena">
                            <form class="form" id="form-reseña" action="ResenaController" method="POST" enctype="application/x-www-form-urlencoded">


                                <div class="titulo">Título</div>
                                <input type="text" name="txtTitulo" id="titulo-reseña" placeholder="Título de la película" class="input" required>

                                <div class="titulo">Nombre de serie</div>
                                <input type="text" name="txtNombre" id="nombre-reseña" placeholder="Nombre de la serie" class="input" required>

                                <div class="titulo">Reseña</div>
                                <textarea name="txtContenido" placeholder="Tu reseña" required></textarea>

                                <br>

                                <button type="submit" class="aceptar">Aceptar</button>

                            </form>
                        </div>
                    </c:if>

                    <!-- Series similares 
                    <h2 class="fav">Similares</h2>
                    <section class="favoritas">
                        <div class="contenedor-series-fav">
                            <:forEach var="similar" items="{serie.similares}">
                                <div class="serie">
                                    <div class="info">{similar.titulo}</div>
                                     <img src="{similar.imagenUrl}" alt="{similar.titulo}" class="serie-img"> 
                                    <form action="SerieProfileController" method="get">
                                        <input type="hidden" name="id" value="{similar.id}">
                                        <button type="submit">Ver Perfil</button>
                                    </form>
                                </div>
                            </:forEach>
                        </div>
                    </section>

                    
                    <!-- Reseñas de usuarios 
                    <h2>Reseñas</h2>
                    <section class="resenas-recientes">
                        <:forEach var="resena" items="{serie.resenas}">
                            <div class="resena">
                                <div class="titulo-resena">📄 {resena.titulo}</div>
                                <div class="texto-resena">
                                    <p>{resena.contenido}</p>
                                </div>
                                <div class="imagen-resena">
                    <!-- <img src="{serie.imagenUrl}" alt="{serie.titulo}" class="serie-img"> 
                </div>
            </div>
        </:forEach>
    </section>
                    -->
                </div>
            </body>

</html>