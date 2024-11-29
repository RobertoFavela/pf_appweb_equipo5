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
/* 
CREATE TABLE Normal (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Administrador (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE
);
*/
CREATE TABLE Serie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    fechaEstreno DATE NOT NULL,
    genero VARCHAR(100) NOT NULL, 
    imagen BLOB NOT NULL
);

CREATE TABLE Post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fechaHoraCreacion DATETIME NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    contenido TEXT NOT NULL,
    fechaHoraEdicion DATETIME,
    usuario_id INT NOT NULL,
    serie_id INT NOT NULL, 
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (serie_id) REFERENCES Serie(id) ON DELETE CASCADE
);
/*
CREATE TABLE Anclado (
    id INT PRIMARY KEY,
    Admin_id INT NOT NULL, 
    FOREIGN KEY (id) REFERENCES Post(id) ON DELETE CASCADE,
    FOREIGN KEY (Admin_id) REFERENCES Administrador(id) ON DELETE CASCADE
);

CREATE TABLE Comun (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Post(id) ON DELETE CASCADE
);
*/
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
/*
INSERT INTO Estado (nombre) VALUES ('Ciudad de México');
INSERT INTO Municipio (nombre, estado_id) VALUES ('Cuauhtémoc', 1);

INSERT INTO Usuario (
    nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio_id
) 
VALUES (
    'Juan Pérez', 'juan.perez@example.com', 'password123', '5551234567', 'avatar_juan.jpg', 
    'Ciudad de México', '1990-05-15', 'Masculino', 1
);

INSERT INTO Normal (id) 
VALUES (LAST_INSERT_ID());

INSERT INTO Estado (nombre) VALUES ('Jalisco');
INSERT INTO Municipio (nombre, estado_id) VALUES ('Guadalajara', 2);

INSERT INTO Usuario (
    nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, municipio_id
) 
VALUES (
    'Ana López', 'ana.lopez@example.com', 'adminPass123', '3339876543', 'avatar_ana.jpg', 
    'Guadalajara', '1985-11-30', 'Femenino', 2
);

INSERT INTO Administrador (id) 
VALUES (LAST_INSERT_ID());

-- INSERT INTO Serie (titulo, descripcion, fechaEstreno, genero) 
-- VALUES ('Breaking Bad', 'Un profesor de química se convierte en un narcotraficante', '2008-01-20', 'Drama');

INSERT INTO Post (fechaHoraCreacion, titulo, contenido, usuario_id, serie_id, tipo) 
VALUES (NOW(), '¿Por qué Breaking Bad es tan buena?', 'Hablemos de los mejores episodios', 1, 1, 'Comun');

INSERT INTO Comentario (fechaHora, contenido, usuario_id, post_id) 
VALUES (NOW(), 'Me encanta la evolución de Walter White', 2, 1);*/

