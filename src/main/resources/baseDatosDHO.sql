CREATE DATABASE IF NOT EXISTS dho
DEFAULT CHARACTER SET utf8mb4;
USE dho;
CREATE TABLE IF NOT EXISTS Hotel(
hotel_id INT,
PRIMARY KEY(hotel_id)
);

CREATE TABLE IF NOT EXISTS Habitaciones(
habitacion_id INT,
tipo_habitacion VARCHAR(150),
hotel_id INT,
PRIMARY KEY(habitacion_id),
CONSTRAINT FK_hotel_id_1
FOREIGN KEY(hotel_id)
REFERENCES Hotel(hotel_id)
);

CREATE TABLE IF NOT EXISTS Estancia(
estancia_id INT,
habitacion_id INT,
cliente_id INT,
hotel_id INT,
fecha_inicio DATE,
fecha_fin DATE,
PRIMARY KEY(estancia_id),
CONSTRAINT FK_hotel_id_2
FOREIGN KEY(hotel_id)
REFERENCES Hotel(hotel_id)
);

CREATE TABLE IF NOT EXISTS Factura(
factura_id INT,
estancia_id INT,
cliente_id INT,
habitacion_id INT,
fecha_factura DATE,
precio INT,
pagado BOOLEAN,
tipo_factura VARCHAR(150),
PRIMARY KEY(factura_id),
CONSTRAINT FK_estancia_id_1
FOREIGN KEY(estancia_id)
REFERENCES Estancia(estancia_id)
);
CREATE TABLE IF NOT EXISTS Servicios(
servicios_id INT,
estancia_id INT,
cliente_id INT,
lugar VARCHAR(150),
fecha_factura DATE,
hora TIME,
tipo_servicio VARCHAR(150),
PRIMARY KEY(servicios_id),
CONSTRAINT FK_estancia_id_3
FOREIGN KEY(estancia_id)
REFERENCES Estancia(estancia_id)
);


CREATE TABLE IF NOT EXISTS Cobros(
cobros_id INT,
estancia_id INT,
cliente_id INT,
habitacion_id INT,
fecha_factura DATE,
precio INT,
pagado BOOLEAN,
tipo_factura VARCHAR(150),
PRIMARY KEY(cobros_id),
CONSTRAINT FK_estancia_id_2
FOREIGN KEY(estancia_id)
REFERENCES Estancia(estancia_id)
);

CREATE TABLE IF NOT EXISTS Incidencia(
incidencia_id INT,
descripcion VARCHAR(150),
lugar_incidencia VARCHAR(150),
fecha_incidencia DATE,
tipo_incidencia VARCHAR(150),
PRIMARY KEY(incidencia_id)
);

CREATE TABLE IF NOT EXISTS Tarea(
tarea_id INT,
incidencia_id INT,
empleado_id INT,
#Descripcion de la incidencia
descripcion VARCHAR(150),
#Lugar de la incidencia
lugar_tarea VARCHAR(150),
#False=No terminado, True=Terminado
estado BOOLEAN,
fecha_tarea DATE,
#tipo_incidencia
tipo_tarea VARCHAR(150),
PRIMARY KEY(tarea_id),
CONSTRAINT FK_incidencia_id
FOREIGN KEY(incidencia_id)
REFERENCES Incidencia(incidencia_id)
);
