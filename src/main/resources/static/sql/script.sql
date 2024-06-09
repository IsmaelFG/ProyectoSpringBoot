CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    edad INT,
    direccion VARCHAR(255),
    fecha_alta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_baja DATETIME DEFAULT NULL
);

INSERT INTO usuarios (usuario, clave, nombre, apellido1, apellido2, edad, direccion, fecha_alta, fecha_baja) VALUES
('usuario1', 'clave1', 'Nombre1', 'Apellido1-1', 'Apellido1-2', 30, 'Direccion1', NOW(), NULL),
('usuario2', 'clave2', 'Nombre2', 'Apellido2-1', 'Apellido2-2', 25, 'Direccion2', NOW(), NULL),
('usuario3', 'clave3', 'Nombre3', 'Apellido3-1', 'Apellido3-2', 40, 'Direccion3', NOW(), NULL),
('usuario4', 'clave4', 'Nombre4', 'Apellido4-1', 'Apellido4-2', 35, 'Direccion4', NOW(), NULL),
('usuario5', 'clave5', 'Nombre5', 'Apellido5-1', 'Apellido5-2', 28, 'Direccion5', NOW(), NULL),
('usuario6', 'clave6', 'Nombre6', 'Apellido6-1', 'Apellido6-2', 32, 'Direccion6', NOW(), NULL),
('usuario7', 'clave7', 'Nombre7', 'Apellido7-1', 'Apellido7-2', 29, 'Direccion7', NOW(), NULL),
('usuario8', 'clave8', 'Nombre8', 'Apellido8-1', 'Apellido8-2', 27, 'Direccion8', NOW(), NULL),
('usuario9', 'clave9', 'Nombre9', 'Apellido9-1', 'Apellido9-2', 33, 'Direccion9', NOW(), NULL),
('usuario10', 'clave10', 'Nombre10', 'Apellido10-1', 'Apellido10-2', 26, 'Direccion10', NOW(), NULL);
