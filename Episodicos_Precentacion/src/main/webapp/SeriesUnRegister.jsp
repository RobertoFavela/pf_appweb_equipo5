<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Series/Style.css">
        <title>Document</title>
    </head>

    <body>
        <div class="Feed">
            <header>
                <nav class="nav">
                    <!-- Inicio -->
                    <form action="FeedController" method="get">
                        <input type="hidden" name="Inicio" value="Inicio" class="radio checked">
                        <button type="submit" title="Inicio" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24" xmlns="http://www.w3..org/2000/svg"
                                 aria-hidden="true" class=" imgNav">
                            <path
                                d="m4 12 8-8 8 8M6 10.5V19a1 1 0 0 0 1 1h3v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h3a1 1 0 0 0 1-1v-8.5"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="round" stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    <!-- Buscar -->
                    <form action="SeriesController" method="get">
                        <input type="hidden" name="rad" value="buscar " class="radio">
                        <button type="submit" title="Buscar" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24" xmlns="http://www.w3.org/2000/svg"
                                 aria-hidden="true" class="imgNav">
                            <path d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z" stroke-width="2"
                                  stroke-linecap="round" stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    <!-- Series -->
                    <form action="" method="get">
                        <input type="hidden" name="rad" value="Series" class="radio">
                        <button type="submit" title="Series" class="ul li">
                            <svg viewBox="0 0 24 24" fill="none" height="24" width="24" xmlns="http://www.w3.org/2000/svg"
                                 aria-hidden="true" class="imgNav">
                            <path
                                d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="round" stroke="currentColor">
                            </path>
                            </svg>
                        </button>
                    </form>

                    
                </nav>
            </header>


            <section class="Admin">
                <c:if test="${esAdmin}">
                    <form action="GestionSerieController" method="get">
                        <button class="btn" type="submit">
                            <h2>Gestor de series</h2>
                        </button>
                    </form>
                </c:if>
            </section>


            <!-- Barra de busqueda -->
            <section>
                <form action="SeriesController" method="post">
                    <input type="text" name="titulo" placeholder="Buscar por titulo..." required class=>
                    <button type="submit" class="aceptar">Buscar</button>
                </form>
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
        </div>
    </body>
</html>