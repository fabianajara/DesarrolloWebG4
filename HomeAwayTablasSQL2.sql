/*Crear el schema*/
CREATE SCHEMA homeaway; 
USE homeaway;

/*Creacion de Usuarios*/
create user 'AdminHomeAway'@'%' identified by 'contra123'; 
grant all privileges on homeaway.* to 'AdminHomeAway'@'%'; 
flush privileges;

/* Creación de tablas */
-- Tabla Rol
CREATE TABLE homeaway.Rol (
    id_rol INT NOT NULL AUTO_INCREMENT,
    nombre_rol VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_rol)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Usuario
CREATE TABLE homeaway.Usuario (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    id_rol INT,
    nombre VARCHAR(100),
    email VARCHAR(100),
    contrasena VARCHAR(100),
    telefono VARCHAR(20),
    usuario_imagen VARCHAR(1024),
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_rol) REFERENCES homeaway.Rol(id_rol)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Alojamiento
CREATE TABLE homeaway.Alojamiento (
    id_alojamiento INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    alojamiento_tipo VARCHAR(50),
    num_habitaciones INT,
    num_banos INT,
    capacidad INT,
    precio_noche DECIMAL(10, 2),
    ubicacion VARCHAR(255),
    calificacion DECIMAL(3, 2),
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN,
    FOREIGN KEY (id_usuario) REFERENCES homeaway.Usuario(id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Disponibilidad
CREATE TABLE homeaway.Disponibilidad (
    id_disponibilidad INT AUTO_INCREMENT PRIMARY KEY,
    id_alojamiento INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    FOREIGN KEY (id_alojamiento) REFERENCES homeaway.Alojamiento(id_alojamiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Resena
CREATE TABLE homeaway.Resena (
    id_resena INT NOT NULL AUTO_INCREMENT,
    id_usuario INT,
    id_alojamiento INT,
    calificacion DECIMAL(3, 1),
    comentario VARCHAR(200),
    fecha DATE,
    PRIMARY KEY (id_resena),
    FOREIGN KEY (id_usuario) REFERENCES homeaway.Usuario(id_usuario),
    FOREIGN KEY (id_alojamiento) REFERENCES homeaway.Alojamiento(id_alojamiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Foto_Alojamiento
CREATE TABLE homeaway.Foto_Alojamiento (
    id_foto INT NOT NULL AUTO_INCREMENT,
    id_alojamiento INT,
    ruta_imagen VARCHAR(1024),
    PRIMARY KEY (id_foto),
    FOREIGN KEY (id_alojamiento) REFERENCES homeaway.Alojamiento(id_alojamiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Reserva
CREATE TABLE homeaway.Reserva (
    id_reserva INT NOT NULL AUTO_INCREMENT,
    id_usuario INT,
    id_alojamiento INT,
    fecha_entrada DATE,
    fecha_salida DATE,
    num_huespedes INT,
    precio_total DECIMAL(10, 2),
    estado VARCHAR(20),
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_reserva),
    FOREIGN KEY (id_usuario) REFERENCES homeaway.Usuario(id_usuario),
    FOREIGN KEY (id_alojamiento) REFERENCES homeaway.Alojamiento(id_alojamiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* Inserts predeterminados */
-- Inserts en la tabla rol
INSERT INTO homeaway.Rol (nombre_rol) VALUES ('Cliente');
INSERT INTO homeaway.Rol (nombre_rol) VALUES ('Anfitrion');
INSERT INTO homeaway.Rol (nombre_rol) VALUES ('Administrador');

-- Inserts en la tabla Usuario
INSERT INTO homeaway.Usuario (id_rol, nombre, email, contrasena, telefono, usuario_imagen)
VALUES (1, 'Juan Pérez', 'juan@example.com', 'contraseña123', '1234567890', 'https://img.freepik.com/foto-gratis/chico-guapo-seguro-posando-contra-pared-blanca_176420-32936.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1720828800&semt=sph');
INSERT INTO homeaway.Usuario (id_rol, nombre, email, contrasena, telefono, usuario_imagen)
VALUES (2, 'María González', 'maria@example.com', 'clave456', '9876543210', 'https://img.freepik.com/foto-gratis/retrato-hermoso-mujer-joven-posicion-pared-gris_231208-10760.jpg');
INSERT INTO homeaway.Usuario (id_rol, nombre, email, contrasena, telefono, usuario_imagen)
VALUES (1, 'Carlos Martínez', 'carlos@example.com', 'pwd789', '555666777', 'https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg');

-- Inserts en la tabla Alojamiento
INSERT INTO homeaway.Alojamiento (id_usuario, nombre, descripcion, alojamiento_tipo, num_habitaciones, num_banos, capacidad, precio_noche, ubicacion, calificacion, ruta_imagen, activo)
VALUES (2, 'Casa de playa', 'Hermosa casa frente al mar', 'Casa', 3, 2, 6, 150.00, 'Playa Paradiso', 4.5, 'https://decofilia.com/wp-content/uploads/2023/05/como-decorar-casas-de-playa-00.jpg', true);
INSERT INTO homeaway.Alojamiento (id_usuario, nombre, descripcion, alojamiento_tipo, num_habitaciones, num_banos, capacidad, precio_noche, ubicacion, calificacion, ruta_imagen, activo)
VALUES (2, 'Apartamento céntrico', 'Ideal para turistas en el corazón de la ciudad', 'Apartamento', 2, 1, 4, 100.00, 'Centro Urbano', 4.2, 'https://a0.muscache.com/im/pictures/miso/Hosting-1035641818891250209/original/211dce23-5224-4e24-8b42-253c90a59671.png?im_w=720', true);
INSERT INTO homeaway.Alojamiento (id_usuario, nombre, descripcion, alojamiento_tipo, num_habitaciones, num_banos, capacidad, precio_noche, ubicacion, calificacion, ruta_imagen, activo)
VALUES (2, 'Casa rural', 'Entorno tranquilo rodeado de naturaleza', 'Casa', 4, 3, 8, 200.00, 'Montañas Verdes', 4.8, 'https://www.apartamentoslatorre.com/wp-content/uploads/2016/10/Apartamentos-Rurales-La-Torre-casas-peque%C3%B1as-600x388.jpg', true);

-- Inserts en la tabla Resena
INSERT INTO homeaway.Resena (id_usuario, id_alojamiento, calificacion, comentario, fecha)
VALUES (1, 1, 4.8, 'Excelente lugar para unas vacaciones relajantes', '2024-08-16');
INSERT INTO homeaway.Resena (id_usuario, id_alojamiento, calificacion, comentario, fecha)
VALUES (1, 2, 4.5, 'Muy cómodo y bien ubicado', '2024-09-03');
INSERT INTO homeaway.Resena (id_usuario, id_alojamiento, calificacion, comentario, fecha)
VALUES (3, 3, 5.0, 'Increíble experiencia en la naturaleza', '2024-08-28');

-- Inserts en la tabla Foto_Alojamiento
INSERT INTO homeaway.Foto_Alojamiento (id_alojamiento, ruta_imagen)
VALUES (1, 'https://images.adsttc.com/media/images/5a58/a650/f197/cc1f/8600/0173/newsletter/S3_CDS--5.jpg?1515759173');
INSERT INTO homeaway.Foto_Alojamiento (id_alojamiento, ruta_imagen)
VALUES (1, 'https://images.adsttc.com/media/images/5a58/a630/f197/cc1f/8600/0172/medium_jpg/S3_CDS--3.jpg?1515759141');
INSERT INTO homeaway.Foto_Alojamiento (id_alojamiento, ruta_imagen)
VALUES (1, 'https://images.adsttc.com/media/images/5a58/a61f/f197/cc25/0900/02af/medium_jpg/S3_CDS--00.jpg?1515759124');

-- Inserts en la tabla Reserva
INSERT INTO homeaway.Reserva (id_usuario, id_alojamiento, fecha_entrada, fecha_salida, num_huespedes, precio_total, estado)
VALUES (1, 1, '2024-09-01', '2024-09-07', 4, 900.00, 'confirmada');
INSERT INTO homeaway.Reserva (id_usuario, id_alojamiento, fecha_entrada, fecha_salida, num_huespedes, precio_total, estado)
VALUES (1, 2, '2024-09-10', '2024-09-15', 2, 500.00, 'confirmada');
INSERT INTO homeaway.Reserva (id_usuario, id_alojamiento, fecha_entrada, fecha_salida, num_huespedes, precio_total, estado)
VALUES (3, 3, '2024-08-20', '2024-08-22', 6, 1200.00, 'confirmada');


select * from alojamiento;

drop schema homeaway;
drop user AdminHomeAway;
drop table propiedad;
drop table alojamiento;