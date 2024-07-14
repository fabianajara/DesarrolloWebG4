/*Crear el schema*/
CREATE SCHEMA homeaway; 
USE homeaway;

/*Creacion de Usuarios*/
create user 'AdminHomeAway'@'%' identified by 'contra123'; 
grant all privileges on homeaway.* to 'AdminHomeAway'@'%'; 
flush privileges;

/* Creacion de tablas */
-- Tabla Usuario
CREATE TABLE homeaway.Usuario (
    usuario_id INT NOT NULL AUTO_INCREMENT,
    usuario_tipo VARCHAR(50),
    nombre VARCHAR(100),
    email VARCHAR(100),
    contrasena VARCHAR(100),
    telefono VARCHAR(20),
    usuario_imagen VARCHAR(1024),
    PRIMARY KEY (usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Propiedad
CREATE TABLE homeaway.Propiedad (
    propiedad_id INT NOT NULL AUTO_INCREMENT,
    propiedad_usuario INT,
    nombre VARCHAR(100),
    descripcion TEXT,
    propiedad_tipo VARCHAR(50),
    num_habitaciones INT,
    num_banos INT,
    capacidad INT,
    precio_noche DECIMAL(10, 2),
    ubicacion VARCHAR(200),
    disponibilidad boolean,
    calificacion DECIMAL(3, 1),
    propiedad_imagen VARCHAR(1024),
    PRIMARY KEY (propiedad_id),
    FOREIGN KEY (propiedad_usuario) REFERENCES homeaway.Usuario(usuario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Resena
CREATE TABLE homeaway.Resena (
    resena_id INT NOT NULL AUTO_INCREMENT,
    usuario_id INT,
    propiedad_id INT,
    calificacion DECIMAL(3, 1),
    comentario TEXT,
    fecha DATE,
    PRIMARY KEY (resena_id),
    FOREIGN KEY (usuario_id) REFERENCES homeaway.Usuario(usuario_id),
    FOREIGN KEY (propiedad_id) REFERENCES homeaway.Propiedad(propiedad_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Fotos_Propiedad
CREATE TABLE homeaway.Foto_Propiedad (
    foto_id INT NOT NULL AUTO_INCREMENT,
    propiedad_id INT,
    ruta_imagen VARCHAR(1024),
    PRIMARY KEY (foto_id),
    FOREIGN KEY (propiedad_id) REFERENCES homeaway.Propiedad(propiedad_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla Reserva
CREATE TABLE homeaway.Reserva (
    id_reserva INT NOT NULL AUTO_INCREMENT,
    id_usuario INT,
    id_propiedad INT,
    fecha_entrada DATE,
    fecha_salida DATE,
    num_huéspedes INT,
    precio_total DECIMAL(10, 2),
    estado VARCHAR(20),
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_reserva),
    FOREIGN KEY (id_usuario) REFERENCES homeaway.Usuario(usuario_id),
    FOREIGN KEY (id_propiedad) REFERENCES homeaway.Propiedad(propiedad_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* Inserts predeterminados */
-- Inserts en la tabla Usuario
INSERT INTO homeaway.Usuario (usuario_tipo, nombre, email, contrasena, telefono, usuario_imagen)
VALUES ('Cliente', 'Juan Pérez', 'juan@example.com', 'contraseña123', '1234567890', 'https://img.freepik.com/foto-gratis/chico-guapo-seguro-posando-contra-pared-blanca_176420-32936.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1720828800&semt=sph');
INSERT INTO homeaway.Usuario (usuario_tipo, nombre, email, contrasena, telefono, usuario_imagen)
VALUES ('Anfitrión', 'María González', 'maria@example.com', 'clave456', '9876543210', 'https://img.freepik.com/foto-gratis/retrato-hermoso-mujer-joven-posicion-pared-gris_231208-10760.jpg');
INSERT INTO homeaway.Usuario (usuario_tipo, nombre, email, contrasena, telefono, usuario_imagen)
VALUES ('Cliente', 'Carlos Martínez', 'carlos@example.com', 'pwd789', '555666777', 'https://concepto.de/wp-content/uploads/2018/08/persona-e1533759204552.jpg');

-- Inserts en la tabla Propiedad
INSERT INTO homeaway.Propiedad (propiedad_usuario, nombre, descripcion, propiedad_tipo, num_habitaciones, num_banos, capacidad, precio_noche, ubicacion, disponibilidad, calificacion, propiedad_imagen)
VALUES (2, 'Casa de playa', 'Hermosa casa frente al mar', 'Casa', 3, 2, 6, 150.00, 'Playa Paradiso', true, 4.5, 'https://decofilia.com/wp-content/uploads/2023/05/como-decorar-casas-de-playa-00.jpg');
INSERT INTO homeaway.Propiedad (propiedad_usuario, nombre, descripcion, propiedad_tipo, num_habitaciones, num_banos, capacidad, precio_noche, ubicacion, disponibilidad, calificacion, propiedad_imagen)
VALUES (2, 'Apartamento céntrico', 'Ideal para turistas en el corazón de la ciudad', 'Apartamento', 2, 1, 4, 100.00, 'Centro Urbano', true, 4.2, 'https://a0.muscache.com/im/pictures/miso/Hosting-1035641818891250209/original/211dce23-5224-4e24-8b42-253c90a59671.png?im_w=720');
INSERT INTO homeaway.Propiedad (propiedad_usuario, nombre, descripcion, propiedad_tipo, num_habitaciones, num_banos, capacidad, precio_noche, ubicacion, disponibilidad, calificacion, propiedad_imagen)
VALUES (2, 'Casa rural', 'Entorno tranquilo rodeado de naturaleza', 'Casa', 4, 3, 8, 200.00, 'Montañas Verdes', true, 4.8, 'https://www.apartamentoslatorre.com/wp-content/uploads/2016/10/Apartamentos-Rurales-La-Torre-casas-peque%C3%B1as-600x388.jpg');

-- Inserts en la tabla Resena
INSERT INTO homeaway.Resena (usuario_id, propiedad_id, calificacion, comentario, fecha)
VALUES (1, 1, 4.8, 'Excelente lugar para unas vacaciones relajantes', '2024-08-16');
INSERT INTO homeaway.Resena (usuario_id, propiedad_id, calificacion, comentario, fecha)
VALUES (1, 2, 4.5, 'Muy cómodo y bien ubicado', '2024-09-03');
INSERT INTO homeaway.Resena (usuario_id, propiedad_id, calificacion, comentario, fecha)
VALUES (3, 3, 5.0, 'Increíble experiencia en la naturaleza', '2024-08-28');

-- Inserts en la tabla Foto_Propiedad
INSERT INTO homeaway.Foto_Propiedad (propiedad_id, ruta_imagen)
VALUES (1, 'https://images.adsttc.com/media/images/5a58/a650/f197/cc1f/8600/0173/newsletter/S3_CDS--5.jpg?1515759173');
INSERT INTO homeaway.Foto_Propiedad (propiedad_id, ruta_imagen)
VALUES (1, 'https://images.adsttc.com/media/images/5a58/a630/f197/cc1f/8600/0172/medium_jpg/S3_CDS--3.jpg?1515759141');
INSERT INTO homeaway.Foto_Propiedad (propiedad_id, ruta_imagen)
VALUES (1, 'https://images.adsttc.com/media/images/5a58/a61f/f197/cc25/0900/02af/medium_jpg/S3_CDS--00.jpg?1515759124');

-- Inserts en la tabla Reserva
INSERT INTO homeaway.Reserva (id_usuario, id_propiedad, fecha_entrada, fecha_salida, num_huéspedes, precio_total, estado)
VALUES (1, 1, '2024-09-01', '2024-09-07', 4, 900.00, 'confirmada');
INSERT INTO homeaway.Reserva (id_usuario, id_propiedad, fecha_entrada, fecha_salida, num_huéspedes, precio_total, estado)
VALUES (1, 2, '2024-09-10', '2024-09-15', 2, 500.00, 'confirmada');
INSERT INTO homeaway.Reserva (id_usuario, id_propiedad, fecha_entrada, fecha_salida, num_huéspedes, precio_total, estado)
VALUES (3, 3, '2024-08-20', '2024-08-22', 6, 1200.00, 'confirmada');
