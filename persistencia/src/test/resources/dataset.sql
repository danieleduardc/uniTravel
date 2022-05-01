insert into cliente values ("123","julia@gmail.com","julia","qwe1",null);
insert into cliente values ("124","pedro@gmail.com","pedro","qwe2",null);
insert into cliente values ("125","luisa@gmail.com","luisa","qwe3",null);


insert into administrador_hotel values ("5455", "admin1@gmail.com", "Admin 1","sdh728");
insert into administrador_hotel values ("5456", "admin2@gmail.com", "Admin 2","sdh722");

insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Bogota");
insert into ciudad values (3, "Cali");

insert into hotel values (1, "Calle 123", "Hotel 5H", 5, "87387378", "5455", 1);
insert into hotel values (2, "Calle 143", "mocawa", 4, "537387238", "5456", 2);
insert into hotel values (3, "Carrera 153", "sonesta", 5, "0999433", "5455", 3);

insert into habitacion values (1, 2, 75000, 1);
insert into habitacion values (2, 3, 56000, 2);
insert into habitacion values (3, 2, 110000, 3);

insert into cama values (1,"King");
insert into cama values (2,"Queen");
insert into cama values (3,"Double");
insert into cama values (4,"Single");

insert into cama_habitaciones values (1, 1);
insert into cama_habitaciones values (2, 1);
insert into cama_habitaciones values (3, 2);
insert into cama_habitaciones values (4, 2);

insert into caracteristica values (1, "wifi");
insert into caracteristica values (2, "aire acondicionado");
insert into caracteristica values (3, "tv");
insert into caracteristica values (4, "cocina");

insert into habitacion_caracteristicas values (1, 1);
insert into habitacion_caracteristicas values (2, 2);
insert into habitacion_caracteristicas values (3, 1);

insert into reserva values (1,"2","confirmada","2022-09-10","2022-09-05","2022-09-01",200000,"123");
insert into reserva values (2,"3","confirmada","2022-10-07","2022-10-12","2022-09-30",350000,"124");

insert into reserva_habitacion values (1, 70000, 1, 1);
insert into reserva_habitacion values (2, 90000, 3, 2);

insert into vuelo values ("A324","avianca","programado", 1,2);
insert into vuelo values ("A325","vivaAir","comfirmado", 1,3);

insert into silla values ("1","IZ23",125000,"A324");
insert into silla values ("2","DR23",230000,"A325");

insert into reserva_silla values (1, 125000,1,"1");
insert into reserva_silla values (2, 230000,2,"2");


