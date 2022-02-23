INSERT INTO tareas(id,nombre, descripcion, fecha_inicio, fecha_fin, duracion, priorizacion) VALUES (1,'test','test', '2022-02-25', '2022-02-26', 1,1);

INSERT INTO users(username,password,enabled) VALUES ('admin1','1234',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (1,'admin1','admin');

INSERT INTO equipo(id, nombre) VALUES (1, 'Test');