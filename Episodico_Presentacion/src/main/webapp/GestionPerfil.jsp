<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="GestionUsuario/Style.css">
    <title>GestionPerfil</title>
</head>

<body>
    <div class="Feed">
        <header>
            <nav class="nav">
                <!-- Inicio -->
                <form action="InicioRController" method="post">
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
                <form action="#" method="post">
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

                <!-- Favoritas -->
                <form action="#" method="post">
                    <input type="hidden" name="rad" value="favoritas" class="radio">
                    <button type="submit" title="Favoritas" class="ul li">
                        <svg viewBox="0 0 24 24" fill="none" height="24" width="24" xmlns="http://www.w3.org/2000/svg"
                            aria-hidden="true" class="imgNav">
                            <path
                                d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="round" stroke="currentColor">
                            </path>
                        </svg>
                    </button>
                </form>

                <!-- Perfil -->
                <form action="UserRController" method="post">
                    <input type="hidden" name="perfil" value="perfil" class="radio">
                    <button type="submit" title="Perfil" class="ul li">
                        <svg viewBox="0 0 24 24" fill="none" height="24" width="24" xmlns="http://www.w3.org/2000/svg"
                            aria-hidden="true" class="imgNav">
                            <path
                                d="M10 19H5a1 1 0 0 1-1-1v-1a3 3 0 0 1 3-3h2m10 1a3 3 0 0 1-3 3m3-3a3 3 0 0 0-3-3m3 3h1m-4 3a3 3 0 0 1-3-3m3 3v1m-3-4a3 3 0 0 1 3-3m-3 3h-1m4-3v-1m-2.121 1.879-.707-.707m5.656 5.656-.707-.707m-4.242 0-.707.707m5.656-5.656-.707.707M12 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"
                                stroke-width="2" stroke-linejoin="round" stroke-linecap="square" stroke="currentColor">
                            </path>
                        </svg>
                    </button>
                </form>
            </nav>
        </header>

        <h2>
            Configuración de usuario
        </h2>

        <form action="GestionUsuario" method="post">

            <label for="nombreCompleto">Nombre Completo:</label>
            <label for="correo" class="der"  >Correo Electrónico:</label>

            <input type="text" id="nombreCompleto" name="nombreCompleto" class="izq" required>
            <input type="email" id="correo" name="correo" required>


            <label for="contrasenia" class="izq" >Contraseña:</label>
            <label for="telefono">Teléfono:</label>

            <input type="password" id="contrasenia" name="contrasenia" class="izq" required>
            <input type="tel" id="telefono" name="telefono" pattern="[0-9]{10}">


            <label for="ciudad" class="izq" >Ciudad:</label>
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>

            <select id="genero" name="genero" required class="izq">
                <option value="">Seleccione</option>
            </select>
            <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>


            <label for="genero">Género:</label>
            <label for="municipioId">Municipio:</label>
            <select id="genero" name="genero" required class="izq" >
                <option value="">Seleccione</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                <option value="Otro">Otro</option>
            </select>
            
            <select id="municipioId" name="municipioId"  required>
                <option value="">Seleccione</option>
                <option value="1">Municipio 1</option>
                <option value="2">Municipio 2</option>
            </select>


            <button type="submit" class="aceptar center">Modificar</button>
        </form>

</body>

</html>