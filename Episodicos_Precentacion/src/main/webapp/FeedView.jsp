
<%-- Document : FeedView Created on : 29 oct 2024, 12:04:13 a.m. Author : favel --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Feed/Style.css">
        <title>Página Principal</title>
    </head>

    <body>
        <div class="Feed">
            <header>
                <nav class="nav">
                    <!-- Inicio -->
                    <form action="FeedController" method="get">
                        <input type="hidden" name="Inicio" value="Inicio" class="radio checked">
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
                    <form action="#" method="post">
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

                    <!-- serie -->
                    <form action="SeriesController" method="post">
                        <input type="hidden" name="rad" value="serie" class="radio">
                        <button type="submit" title="serie" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
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

            <h2>Agregadas recientemente</h2>
            <section class="seccion">
                <div class="contenedor-series">
                    <c:if test="${not empty series}">
                        <c:forEach var="serie" items="${series}">
                            <form action="" method="post" class="serie">
                                <button class="serie">
                                    <img src="imagenSerie?imagen=${serie.imagen}" class="serie-img">
                                </button>
                            </form>
                        </c:forEach>
                    </c:if>
                </div>
            </section>

            <h2>Todas las series</h2>
            <section class="seccion">
                <div class="contenedor-series">
                    <c:if test="${not empty series}">
                        <c:forEach var="serie" items="${series}">
                            <form action="" method="post" class="serie">
                                <button class="serie">
                                    <img src="imagenSerie?imagen=${serie.imagen}" class="serie-img">
                                </button>
                            </form>
                        </c:forEach>
                    </c:if>
                </div>
            </section>


            <h2>Reseñas recientes</h2>
            <section class="resenas-recientes">
                <c:if test="${not empty posts}">
                    <c:forEach var="post" items="${posts}">

                        <div class="resena">
                            <div class="titulo-resena">
                                <input type="text" name="id" id="id" class="id" value="${post.id}" readonly>
                                <h2 class="tipo">Post</h2>
                                <h2 class="titulo">${post.titulo}</h2>
                                <h4 class="nombre">${post.nombreCompleto}</h4>
                                <h4 class="fecha">${post.fechaHoraCreacion}</h4>
                            </div>
                            <div class="texto-resena">
                                <p>${post.contenido}</p>
                            </div>
                            <form action="" method="post">
                                <div class="imagen-resena">
                                    <img src="${post.imagen}" class="serie-img" alt="${post.titulo}">
                                </div>
                                <button class="comentar">Comentar</button>
                            </form>
                        </div>

                        <c:if test="${not empty post.comentarioCollection}">
                            <!-- Comentarios del Post -->
                            <c:forEach var="comentario" items="${post.comentarioCollection}">
                                <div class="resena">
                                    <div class="titulo-resena">
                                        <input type="text" name="id" id="id" class="id" value="${comentario.id}" readonly>
                                        <h2 class="tipo">Comentario</h2>
                                        <h4 class="nombre">${comentario.nombreUsuario}</h4>
                                        <h4 class="fecha">${comentario.fechaHora}</h4>
                                    </div>
                                    <div class="texto-resena2">
                                        <p>${comentario.contenido}</p>
                                    </div>
                                    <form action="" method="post">
                                        <button class="comentar2">Comentar</button>
                                    </form>
                                </div>

                                <c:if test="${not empty comentario.comentarioCollection}">
                                    <!-- Comentarios de Comentarios -->
                                    <c:forEach var="subComentario" items="${comentario.comentarioCollection}">
                                        <div class="resena">
                                            <div class="titulo-resena">
                                                <input type="text" name="id" id="id" class="id" value="${subComentario.id}" readonly>
                                                <h2 class="tipo">Comentario de Comentario</h2>
                                                <h4 class="nombre">${subComentario.nombreUsuario}</h4>
                                                <h4 class="fecha">${subComentario.fechaHora}</h4>
                                            </div>
                                            <div class="texto-resena2">
                                                <p>${subComentario.contenido}</p>
                                            </div>
                                            <form action="" method="post">
                                                <button class="comentar2">Comentar</button>
                                            </form>
                                        </div>

                                    </c:forEach>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </c:if>
            </section>
        </div>
    </body>
</html>