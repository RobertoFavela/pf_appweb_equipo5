<%-- Document : UserProfileView Created on : 28 oct 2024, 11:58:31 p.m. Author : favel --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Series/StyleSeriesProfile.css">
        <title>Perfil de Serie</title>
    </head>

    <body>
        <div class="Feed">
            <header>
                <nav class="nav">
                    <!-- Inicio -->
                    <form action="FeedController" method="get">
                        <input type="hidden" name="Inicio" value="Inicio" class="radio">
                        <button type="submit" title="Inicio" class="ul li ">
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
                        <input type="hidden" name="rad" value="favoritas" class="radio">
                        <button type="submit" title="Favoritas" class="ul li">
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
                        <input type="hidden" name="perfil" value="perfil" class="radio checked">
                        <button type="submit" title="Perfil" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav ">
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

            <div class="perfil">
                <img src="ImagenServlet?id=${serie.id}" class="serie-img-perfil">

                <div class="NombrePerfil">
                    <h2 name="txtNombre" >${serie.titulo}</h2>
                </div>
                <div>
                    <c:if test="${sda}">
                        <form action="" method="post">
                            <form action="" method="post">
                                <div class="imagen-resena">
                                    <h3 class="serie-titulo">${serie.titulo}</h3>
                                </div>
                                <button class="meGusta">
                                    <svg class="empty" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="32" height="32"><path fill="none" d="M0 0H24V24H0z"></path><path d="M16.5 3C19.538 3 22 5.5 22 9c0 7-7.5 11-10 12.5C9.5 20 2 16 2 9c0-3.5 2.5-6 5.5-6C9.36 3 11 4 12 5c1-1 2.64-2 4.5-2zm-3.566 15.604c.881-.556 1.676-1.109 2.42-1.701C18.335 14.533 20 11.943 20 9c0-2.36-1.537-4-3.5-4-1.076 0-2.24.57-3.086 1.414L12 7.828l-1.414-1.414C9.74 5.57 8.576 5 7.5 5 5.56 5 4 6.656 4 9c0 2.944 1.666 5.533 4.645 7.903.745.592 1.54 1.145 2.421 1.7.299.189.595.37.934.572.339-.202.635-.383.934-.571z"></path></svg>
                                    <svg class="filled" height="32" width="32" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0H24V24H0z" fill="none"></path><path d="M16.5 3C19.538 3 22 5.5 22 9c0 7-7.5 11-10 12.5C9.5 20 2 16 2 9c0-3.5 2.5-6 5.5-6C9.36 3 11 4 12 5c1-1 2.64-2 4.5-2z"></path></svg>
                                  </button>
                                  
                            </form>
                        </form>
                    </c:if>
                    <c:if test="${asd}">
                        <form action="" method="post">
                            <div class="imagen-resena">
                                <h3 class="serie-titulo">${serie.titulo}</h3>
                            </div>
                            <button class="meGusta">
                                <svg class="empty" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="32" height="32"><path fill="none" d="M0 0H24V24H0z"></path><path d="M16.5 3C19.538 3 22 5.5 22 9c0 7-7.5 11-10 12.5C9.5 20 2 16 2 9c0-3.5 2.5-6 5.5-6C9.36 3 11 4 12 5c1-1 2.64-2 4.5-2zm-3.566 15.604c.881-.556 1.676-1.109 2.42-1.701C18.335 14.533 20 11.943 20 9c0-2.36-1.537-4-3.5-4-1.076 0-2.24.57-3.086 1.414L12 7.828l-1.414-1.414C9.74 5.57 8.576 5 7.5 5 5.56 5 4 6.656 4 9c0 2.944 1.666 5.533 4.645 7.903.745.592 1.54 1.145 2.421 1.7.299.189.595.37.934.572.339-.202.635-.383.934-.571z"></path></svg>
                                <svg class="filled" height="32" width="32" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0H24V24H0z" fill="none"></path><path d="M16.5 3C19.538 3 22 5.5 22 9c0 7-7.5 11-10 12.5C9.5 20 2 16 2 9c0-3.5 2.5-6 5.5-6C9.36 3 11 4 12 5c1-1 2.64-2 4.5-2z"></path></svg>
                              </button>
                        </form>
                    </c:if>
                </div>
                
                <div class="descripcion">
                    <c:if test="${not empty serie.descripcion}">
                        <p>${serie.descripcion}</p>
                    </c:if>
                    <c:if test="${empty serie.descripcion}">
                        <p>Descripción no disponible.</p>
                    </c:if>
                </div>
            </div>

            <h2>Escribe una reseña</h2>

            <div class="nueva-resena">
                <form class="form" id="form-reseña" action="ResenaController" method="POST"
                      enctype="application/x-www-form-urlencoded">


                    <div class="titulo">Título</div>
                    <input type="text" name="txtTitulo" id="titulo-reseña" placeholder="Título de la película"
                           class="input" required>
                    <input type="hidden" name="txtNombre" value="${serie.titulo}">
                    <br>
                    <div class="titulo">Reseña</div>
                    <textarea name="txtContenido" placeholder="Tu reseña" required></textarea>

                    <br>

                    <button type="submit" class="aceptar">Aceptar</button>

                </form>
            </div>

            <h2>Similares</h2>
            <section class="favoritas">
                <c:forEach var="serieSimil" items="${seriesSimilares}">
                    <div class="contenedor-series-fav">
                        <form action="SerieProfileController" method="get" class="serie">
                            <input type="hidden" name="id" value="${serieSimil.id}">
                            <button class="serie">
                                <img src="ImagenServlet?id=${serieSimil.id}" class="serie-img-perfil">
                            </button>
                        </form>
                    </div>
                </c:forEach>
            </section>



            <h2>Tus Reseñas</h2>
            <section class="resenas-recientes">

                <c:if test="${not empty posts}">
                    <c:forEach var="post" items="${posts}">
                        <div class="resena">
                            <div class="titulo-resena">
                                <input type="text" name="id" id="id" class="id" value="${post.id}" readonly>
                                <h2 class="tipo">Post</h2>
                                <h2 class="titulo">${post.titulo}</h2>
                                <h4 class="fecha">${post.fechaHoraCreacion}</h4>
                            </div>
                            <div class="texto-resena">
                                <p>${post.contenido}</p>
                            </div>
                            <form action="" method="post">
                                <div class="imagen-resena">
                                    <h3 class="serie-titulo">${serie.titulo}</h3>
                                </div>
                                <button class="comentar">Comentar</button>
                            </form>
                        </div>
                        <c:if test="${not empty post.comentarioCollection}">
                            <c:forEach var="comentario" items="${post.comentarioCollection}">
                                <div class="resena">
                                    <div class="titulo-resena">
                                        <input type="text" name="id" id="id" class="id" value="${comentario.id}"
                                               readonly>
                                        <h2 class="tipo">Comentario</h2>
                                        <h4 class="fecha">${comentario.fechaHora}</h4>
                                    </div>
                                    <div class="texto-resena2">
                                        <p>${comentario.contenido}</p>
                                    </div>
                                    <form action="" method="post">
                                        <button class="comentar2">Comentar</button>
                                    </form>
                                </div>
                            </c:forEach>
                        </c:if>

                        <c:if test="${not empty comentario.comentarioCollection}">
                            <!-- Comentarios de Comentarios -->
                            <c:forEach var="subComentario" items="${comentario.comentarioCollection}">
                                <div class="resena comentarioDecomentario">
                                    <div class="titulo-resena">
                                        <input type="text" name="id" id="id" class="id"
                                               value="${subComentario.id}" readonly>
                                        <h2 class="tipo">Comentario de Comentario</h2>
                                        <h4 class="nombre">${subComentario.nombreUsuario}</h4>
                                        <h4 class="fecha">${subComentario.fechaHora}</h4>
                                    </div>
                                    <div class="texto-resena2">
                                        <p>${subComentario.contenido}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </c:if>
            </section>
        </div>
        <script src="Post/CrearPost.js" type="application/javascript"></script>
    </body>

</html>