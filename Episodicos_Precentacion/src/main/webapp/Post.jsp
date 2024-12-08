<%-- Document : FeedView Created on : 29 oct 2024, 12:04:13 a.m. Author : favel --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Post/Style.css">
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
                    <form action="SeriesController" method="get">
                        <input type="hidden" name="rad" value="buscar " class="radio">
                        <button type="submit" title="Buscar" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                 xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
                            <path d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"
                                  stroke-width="2" stroke-linecap="round" stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    <!-- serie -->
                    <form action="Postcontroller" method="get">
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


            <h2>Nuestras Reseñas</h2>
            <section class="resenas-recientes">
                <c:if test="${not empty posts}">
                    <c:forEach var="post" items="${posts}">

                        <div class="resena">
                            <!-- Título de la reseña -->
                            <div class="titulo-resena">
                                <input type="text" name="id" id="id" class="id" value="${post.id}" readonly>
                                <h2 class="tipo">Post</h2>
                                <h2 class="titulo">${post.titulo}</h2>
                                <h4 class="nombre">${usuariosPorId[post.usuarioId]}</h4>
                                <h4 class="fecha">${post.fechaHoraCreacion}</h4>
                            </div>

                            <!-- Texto de la reseña -->
                            <div class="texto-resena">
                                <p>${post.contenido}</p>
                            </div>

                            <!-- Botón para eliminar reseña si es admin -->
                                <c:if test="${esAdmin}">
                                    <form action="Postcontroller" method="post" onsubmit="return confirm('¿Estás seguro de que deseas eliminar este post?');">
                                        <input type="hidden" name="accion" value="eliminar">
                                        <input type="hidden" name="id" value="${post.id}">
                                        <button type="submit" class="comentar">Eliminar</button>
                                    </form>

                                </c:if>
                            </form>

                            <!-- Nueva reseña -->
                            <form class="form" id="form-reseña" action="ComentarioController" method="POST" enctype="application/x-www-form-urlencoded">
                                <div class="titulo">Título</div>
                                <input type="text" name="txtTitulo" id="titulo-reseña" placeholder="Título de la película" class="input" required>

                                <div class="titulo">Reseña</div>
                                <textarea name="txtContenido" placeholder="Tu reseña" required></textarea>

                                <!-- Hidden field to pass post ID -->
                                <input type="hidden" name="postId" value="${post.id}">

                                <button type="submit" class="comentar">Comentar</button>
                            </form>


                        </div>

                        <c:if test="${not empty comentarioCollection}">
                            <!-- Comentarios del Post -->
                            <c:forEach var="comentario" items="${comentarioCollection}">
                                <div class="resena comentario">
                                    <div class="titulo-resena">
                                        <input type="text" name="id" id="id" class="id" value="${comentario.id}" readonly>
                                        <h2 class="tipo">Comentario</h2>
                                        <h4 class="fecha">${comentario.fechaHora}</h4>


                                    </div>
                                    <div class="texto-resena2">
                                        <p>${comentario.contenido}</p>
                                    </div>
                                    <form class="form" id="form-reseña" action="ResenaController" method="POST" enctype="application/x-www-form-urlencoded">
                                        <div class="titulo">Título</div>
                                        <input type="text" name="txtTitulo" id="titulo-reseña" placeholder="Título de la película" class="input" required>
                                        <div class="titulo">Reseña</div>
                                        <textarea name="txtContenido" placeholder="Tu reseña" required></textarea>
                                        <button type="submit" class="comentar">Comentar</button>
                                    </form>
                                </div>

                                <c:if test="${not empty comentario.comentarioCollection}">

                                    <!-- Comentarios de Comentarios -->
                                    <c:forEach var="subComentario" items="${comentario.comentarioCollection}">
                                        <div class="resena comentarioDecomentario">
                                            <div class="titulo-resena">
                                                <input type="text" name="id" id="id" class="id" value="${subComentario.id}"
                                                       readonly>
                                                <h2 class="tipo">Comentario de Comentario</h2>
                                                <h4 class="nombre">${subComentario.nombreUsuario}</h4>
                                                <h4 class="fecha">${subComentario.fechaHora}</h4>
                                            </div>
                                            <div class="texto-resena2">
                                                <p>${subComentario.contenido}</p>
                                            </div>
                                            <form class="form" id="form-reseña" action="ResenaController" method="POST" enctype="application/x-www-form-urlencoded">
                                                <div class="titulo">Título</div>
                                                <input type="text" name="txtTitulo" id="titulo-reseña" placeholder="Título de la película" class="input" required>
                                                <div class="titulo">Reseña</div>
                                                <textarea name="txtContenido" placeholder="Tu reseña" required></textarea>
                                                <button type="submit" class="comentar">Comentar</button>
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
    <script src="Post/EliminarPost.js"></script>

</html>