CREATE DATABASE SeriesDB;
USE SeriesDB;

CREATE TABLE Estado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Municipio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado_id INT NOT NULL,
    FOREIGN KEY (estado_id) REFERENCES Estado(id)
);

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(150) NOT NULL,
    descripcion VARCHAR(255),
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasenia VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    avatar VARCHAR(255),
    ciudad VARCHAR(100),
    fechaNacimiento DATE,
    genero ENUM('Masculino', 'Femenino', 'Otro'),
    municipio_id INT,
    FOREIGN KEY (municipio_id) REFERENCES Municipio(id),
    DTYPE VARCHAR(31)
);
CREATE TABLE Normal (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE
);
CREATE TABLE Administrador (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Serie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    fechaEstreno DATE NOT NULL,
    genero VARCHAR(100) NOT NULL, 
    imagen LONGBLOB NOT NULL
);

CREATE TABLE Post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fechaHoraCreacion DATETIME,
    titulo VARCHAR(255) NOT NULL,
    contenido TEXT,
    fechaHoraEdicion DATETIME,
    usuario_id INT,
    serie_id INT, 
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (serie_id) REFERENCES Serie(id) ON DELETE CASCADE,
    DTYPE VARCHAR(31)
);
CREATE TABLE Comentario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fechaHora DATETIME NOT NULL,
    contenido TEXT NOT NULL,
    usuario_id INT NOT NULL,
    post_id INT NOT NULL,
    comentario_padre_id INT, 
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES Post(id) ON DELETE CASCADE,
    FOREIGN KEY (comentario_padre_id) REFERENCES Comentario(id) ON DELETE CASCADE
);
CREATE TABLE Comun (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Post(id) ON DELETE CASCADE
);
CREATE TABLE Anclado (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Post(id) ON DELETE CASCADE
);
