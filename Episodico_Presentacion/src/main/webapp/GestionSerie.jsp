<!-- <%-- 
    Document   : SeriesProfile
    Created on : 29 oct 2024, 12:00:19 a.m.
    Author     : favel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Perfil de Persona</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="GestionSerie/style.css">
    <title>Perfil de Serie</title>
</head>
<body>
    <div class="Feed">
        <header>
            <div id="nav">
                <form action="#">
                    <ul class="ul">
                        <input checked="" name="rad" class="radio" id="Inicio" type="radio" />
                        <label for="Inicio">
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
        <h2>Gestionar serie</h2>
        <section class="gestionar-serie">
            <div class="botones">
                <button class="btn agregar-btn" id="btn-agregar">
                    <div class="add-icon"></div>
                    <div class="btn-txt">Agregar</div>
                </button>
                <button class="btn mod-btn" id="btn-mod">
                    <div class="modify-icon"></div>
                    <div class="btn-txt">Modificar</div>
                </button>
                <button class="btn ele-btn" id="btn-ele">
                    <div class="delete-icon"></div>
                    <div class="btn-txt">Eliminar</div>
                </button>
            </div>

            <form id="form-serie" class="form-serie" action="/gestionarSerie" method="POST">
                <label for="nombre">Nombre de la Serie:</label>
                <input type="text" id="nombre" name="nombre" placeholder="Ej: Stranger Things" required>

                <div id="extras">
                    <label for="descripcion">Descripción:</label>
                    <textarea id="descripcion" name="descripcion" placeholder="Agrega una breve descripción..." rows="5"></textarea>

                    <label for="genero">Género:</label>
                    <select id="genero" name="genero">
                        <option value="accion">Acción</option>
                        <option value="drama">Drama</option>
                        <option value="comedia">Comedia</option>
                        <option value="terror">Terror</option>
                        <option value="fantasia">Fantasía</option>
                        <option value="documental">Documental</option>
                    </select>

                    <label for="lanzamiento">Año de Lanzamiento:</label>
                    <input type="number" id="lanzamiento" name="lanzamiento" min="1900" max="2100">

                    <label for="portada">Imagen de Portada:</label>
                    <input type="file" id="portada" name="portada" accept="image/*">
                </div>

                <div class="form-btn">
                    <button type="submit" class="btn-guardar">Guardar</button>
                    <button type="reset" class="btn-limpiar">Limpiar</button>
                </div>
            </form>
        </section>
    </div>

    <script src="GestionSerie/script.js"></script>

    </div>
</body>
</html>

