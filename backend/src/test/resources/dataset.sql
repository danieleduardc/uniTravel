insert into ciudad values (1, "Armenia", "https://i.pinimg.com/originals/c2/05/2f/c2052fdeb705be24b21b46f85c989cd2.jpg");
insert into ciudad values (2, "Bogota","https://cloudfront-us-east-1.images.arcpublishing.com/infobae/JAAYCWLOQRHOTKSLAZAH37REYM.jpeg");
insert into ciudad values (3, "Cartagena", "https://cdn.colombia.com/images/v2/turismo/sitios-turisticos/cartagena/ciudad-cartagena-800.jpg");
insert into ciudad values (4, "Medellin","https://cdn.forbes.co/2020/09/Medell%C3%ADn-foto-ProColombia.jpg");
insert into ciudad values (5, "Cali", "https://upload.wikimedia.org/wikipedia/commons/4/4e/Santiago_de_Cali.jpg");

insert into cliente values ("123","julia@gmail.com","julia","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu",1);
insert into cliente values ("124","pedro@gmail.com","pedro","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu",2);
insert into cliente values ("125","luisa@gmail.com","luisa","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu",4);
insert into cliente values ("126","daniel@email.com","daniel","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu",3);
insert into cliente values ("127","karen@gmail.com","karen","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu",5);

insert into cliente_telefonos values ("123","1234567");
insert into cliente_telefonos values ("124","1234567");
insert into cliente_telefonos values ("125","2345678");
insert into cliente_telefonos values ("126","5456789");
insert into cliente_telefonos values ("127","988555");

insert into administrador_hotel values ("5455", "admin1@gmail.com", "Admin","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu");
insert into administrador_hotel values ("5456", "admin2@gmail.com", "Admin 2","GN8CYrWCS/3xsv16RHD4YQw3h6VeJzutXs6eYcOPcP7gDMWGjCDAIz7wHUvnUQqu");

insert into hotel values (1,"Servicios de alojamiento a los visitantes para su conford", "Calle 123", "Hotel 5H", 5, "87387378", "5455", 4);
insert into hotel values (2, "Proveen a los huéspedes de servicios de piscinas y guarderías","Calle 143", "mocawa", 4, "537387238", "5456", 2);
insert into hotel values (3, "Es un Hotel con manejo sostenible,del tema ambiental y cultural con arquitectura colombiana indígena","Carrera 153", "sonesta", 5, "0999433", "5455", 3);

insert into cama values (1,"sencilla");
insert into cama values (2,"doble");
insert into cama values (3,"matrimonial");

insert into habitacion values (101, 2, 75000, 1);
insert into habitacion values (102, 1, 85000, 1);
insert into habitacion values (302, 3, 56000, 2);
insert into habitacion values (303, 2, 58000, 2);
insert into habitacion values (201, 2, 110000, 3);
insert into habitacion values (202, 2, 120000, 3);

insert into cama_habitaciones values (2, 101);
insert into cama_habitaciones values (1, 102);
insert into cama_habitaciones values (3, 302);
insert into cama_habitaciones values (2, 303);
insert into cama_habitaciones values (2, 201);
insert into cama_habitaciones values (2, 202);

insert into caracteristica values (1, "spa","1");
insert into caracteristica values (2, "piscina","1");
insert into caracteristica values (3, "parqueo","1");
insert into caracteristica values (4, "asensor","1");
insert into caracteristica values (5, "wifi", "2");
insert into caracteristica values (6, "aire acondicionado","2");
insert into caracteristica values (7, "tv","2");
insert into caracteristica values (8, "cocina","2");

insert into hotel_caracteristicas values (1, 1);
insert into hotel_caracteristicas values (1, 2);
insert into hotel_caracteristicas values (1, 3);
insert into hotel_caracteristicas values (2, 1);
insert into hotel_caracteristicas values (2, 2);
insert into hotel_caracteristicas values (2, 4);
insert into hotel_caracteristicas values (3, 3);

insert into habitacion_caracteristicas values (101, 1);
insert into habitacion_caracteristicas values (101, 2);
insert into habitacion_caracteristicas values (101, 3);
insert into habitacion_caracteristicas values (102, 1);
insert into habitacion_caracteristicas values (102, 2);
insert into habitacion_caracteristicas values (302, 1);
insert into habitacion_caracteristicas values (302, 2);
insert into habitacion_caracteristicas values (302, 3);
insert into habitacion_caracteristicas values (303, 1);
insert into habitacion_caracteristicas values (303, 2);
insert into habitacion_caracteristicas values (303, 4);
insert into habitacion_caracteristicas values (201, 1);
insert into habitacion_caracteristicas values (201, 2);
insert into habitacion_caracteristicas values (201, 3);
insert into habitacion_caracteristicas values (202, 1);
insert into habitacion_caracteristicas values (202, 2);
insert into habitacion_caracteristicas values (202, 3);

insert into reserva values (1,"2","confirmada","2022-09-10","2022-09-05","2022-09-01",200000,"123");
insert into reserva values (2,"3","confirmada","2022-10-12","2022-10-05","2022-09-16",350000,"124");
insert into reserva values (3,"2","confirmada","2022-11-10","2022-11-05","2022-10-01",450000,"123");

insert into reserva_habitacion values (1, 70000, 101, 1);
insert into reserva_habitacion values (5, 60000, 102, 1);

insert into vuelo values (1,"avianca","programado", 1,2);
insert into vuelo values (2,"vivaAir","comfirmado", 3,5);

insert into silla values (1, 0, "A2", 100000, 1);
insert into silla values (2, 0, "B3", 100000, 2);

insert into aeropuerto values ("A1", "Carrera 1","Aeropuerto el Eden", 1);
insert into aeropuerto values ("A2", "Carrera 2","Aeropuerto Internacional El Dorado ", 2);
insert into aeropuerto values ("A3", "Carrera 3","Aeropuerto Matechana", 4);

insert into carro values ("ABC-123", 1, 4, 1, 2019, 250000, 1, "A1");
insert into carro values ("DEF-456", 1, 4, 1, 2019, 300000, 1, "A2");
insert into carro values ("GHI-789", 1, 6, 1, 2019, 150000, 1, "A3");




