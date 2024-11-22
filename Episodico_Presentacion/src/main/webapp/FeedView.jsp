<!-- <%-- 
    Document   : FeedView
    Created on : 29 oct 2024, 12:04:13 a.m.
    Author     : favel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Feed/style.css">
    <title>Página Principal</title>
</head>

<body>
    <div class="Feed">
        <header>
            <div id="nav">
                <form action="#">
                    <ul class="ul">
                        <input checked="" name="rad" class="radio" id="Inicio" type="radio" />
                        <label for="choose1">
                            <li class="li">
                                <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                    xmlns="http://www.w3..org/2000/svg" aria-hidden="true" class="imgNav">
                                    <path
                                        d="m4 12 8-8 8 8M6 10.5V19a1 1 0 0 0 1 1h3v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h3a1 1 0 0 0 1-1v-8.5"
                                        stroke-width="2" stroke-linejoin="round" stroke-linecap="round"
                                        stroke="currentColor">
                                    </path>
                                </svg>
                            </li>
                        </label>
                        <input class="radio" name="rad" id="choose2" type="radio" />
                        <label for="choose2">
                            <li class="li">
                                <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                    xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
                                    <path d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z" stroke-width="2"
                                        stroke-linecap="round" stroke="currentColor">
                                    </path>
                                </svg>
                            </li>
                        </label>
                        <input class="radio" name="rad" id="choose3" type="radio" />
                        <label for="choose3">
                            <li class="li">
                                <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                    xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
                                    <path
                                        d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z"
                                        stroke-width="2" stroke-linejoin="round" stroke-linecap="round"
                                        stroke="currentColor">
                                    </path>
                                </svg>
                            </li>
                        </label>
                        <input class="radio" name="rad" id="choose4" type="radio" />
                        <label for="choose4">
                            <li class="li">
                                <svg viewBox="0 0 24 24" fill="none" height="24" width="24"
                                    xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="imgNav">
                                    <path
                                        d="M10 19H5a1 1 0 0 1-1-1v-1a3 3 0 0 1 3-3h2m10 1a3 3 0 0 1-3 3m3-3a3 3 0 0 0-3-3m3 3h1m-4 3a3 3 0 0 1-3-3m3 3v1m-3-4a3 3 0 0 1 3-3m-3 3h-1m4-3v-1m-2.121 1.879-.707-.707m5.656 5.656-.707-.707m-4.242 0-.707.707m5.656-5.656-.707.707M12 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"
                                        stroke-width="2" stroke-linejoin="round" stroke-linecap="square"
                                        stroke="currentColor">
                                    </path>
                                </svg>
                            </li>
                        </label>
                    </ul>
                </form>
            </div>

        </header>

        <h2>Agregadas recientemente</h2>
        <section class="seccion">

            <div class="contenedor-series">
                <div class="serie">
                    <div class="info">Star Wars<br>5 Temporadas<br>❤ 5K | 👁️ 25K</div>
                </div>
                <div class="serie"><a href="/PerfilSerie/perfilSerie.html"></a></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
            </div>
        </section>

        <h2>Mejor calificadas</h2>
        <section class="seccion">

            <div class="contenedor-series">
                <div class="serie"><a href="/PerfilSerie/perfilSerie.html"></a></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
                <div class="serie"></div>
            </div>
        </section>

        <h2>Reseñas recientes</h2>
        <section class="resenas-recientes">

            <div class="resena">
                <div class="titulo-resena">📄 Título de reseña</div>
                <div class="info-resena">
                    <div class="texto-resena">Este es un ejemplo de texto de la reseña. Aquí puedes agregar el contenido
                        de
                        la reseña más reciente.</div>
                    <div class="imagen-resena">Imagen de serie</div>
                </div>
            </div>
        </section>
    </div>
</body>

</html>