insert into cliente values ("123","julia@gmail.com","julia","qwe1",1);
insert into cliente values ("124","pedro@gmail.com","pedro","qwe2",2);
insert into cliente values ("125","luisa@gmail.com","luisa","qwe3",4);
insert into cliente values ("126","daniel@email.com","daniel","qwe4",3);
insert into cliente values ("127","karen@gmail.com","karen","qwe5",5);

insert into cliente_telefonos values ("123","1234567");
insert into cliente_telefonos values ("125","1234567");
insert into cliente_telefonos values ("124","2345678");
insert into cliente_telefonos values ("125","5456789");
insert into cliente_telefonos values ("126","988555");
insert into cliente_telefonos values ("127","8895552");

insert into administrador_hotel values ("5455", "admin1@gmail.com", "Admin 1","sdh728");
insert into administrador_hotel values ("5456", "admin2@gmail.com", "Admin 2","sdh722");

insert into ciudad values (1, "Armenia", "http://www.nuestro.cl/wp-content/uploads/2018/10/Colombia-Travel-%E2%80%93-City-of-Armenia.jpg");
insert into ciudad values (2, "Bogota","");
insert into ciudad values (3, "Cali", "");
insert into ciudad values (4, "Cartagena", "");
insert into ciudad values (5, "Medellin","");

insert into hotel values (1,"Es un edificio planificado y acondicionado para otorgar servicios de alojamiento a las personas y que permite a los visitantes sus desplazamientos", "Calle 123", "Hotel 5H", 5, "87387378", "5455", 4);
insert into hotel values (2, "Proveen a los huéspedes de servicios adicionales como restaurantes, piscinas y guarderías.","Calle 143", "mocawa", 4, "537387238", "5456", 2);
insert into hotel values (3, "Es un Hotel con manejo sostenible, especialmente en el tema ambiental y cultural construido con arquitectura colombiana indígena","Carrera 153", "sonesta", 5, "0999433", "5455", 3);

insert into habitacion values (101, 2, 75000, 1);
insert into habitacion values (102, 1, 85000, 1);
insert into habitacion values (302, 3, 56000, 2);
insert into habitacion values (303, 2, 58000, 2);
insert into habitacion values (201, 2, 110000, 3);
insert into habitacion values (202, 2, 120000, 3);

insert into cama values (1,"sencilla");
insert into cama values (2,"doble");
insert into cama values (3,"matrimonial");

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

insert into reserva_habitacion values (1, 70000, 1, 1);
insert into reserva_habitacion values (5, 60000, 1, 1);
insert into reserva_habitacion values (4, 30000, 2, 3);
insert into reserva_habitacion values (2, 90000, 3, 2);

insert into vuelo values ("A324","avianca","programado", 1,2);
insert into vuelo values ("A325","vivaAir","comfirmado", 1,3);

insert into silla values (1,"IZ23",125000,"A324");
insert into silla values (2,"DR23",230000,"A325");

insert into reserva_silla values (01, 125000,1,1);
insert into reserva_silla values (01, 230000,2,2);

