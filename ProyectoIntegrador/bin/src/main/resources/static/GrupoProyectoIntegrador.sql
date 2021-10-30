create database bdProyectoIntegrador;
use bdProyectoIntegrador;
#drop table usuario;

create table usuario(
idUsuario int primary key not null auto_increment,
nombres varchar(255) not null,
apaterno varchar(45) not null,
amaterno varchar(45) not null,
fechaNacimiento date ,
fechaRegistro timestamp  default CURRENT_TIMESTAMP,
email varchar(45) not null,
celular varchar(15) ,
direccion varchar(45) ,
dni varchar(8) not null,
login varchar(45) not null,
password varchar(45)   not null
);

insert into usuario 
value(default,'Juanito','Perez','Limaña','2006-10-12',default,'juanito@gmail.com','998877665','Av. España','12345678','juanito','123');

select*from usuario;
/*=)===============================0*/
create table genero (
idGenero int primary key not null auto_increment,
nombre varchar(250)
);
create table pelicula (
idPelicula int primary key not null auto_increment,
nombre varchar(250),
duracion varchar(20),
idioma varchar(100),
director varchar(100),
restinccion varchar(50),
idGenero int,
foreign key (idGenero) references genero (idGenero)
);

insert into genero values(null,'Accion');
insert into genero values(null,'Animacion');
insert into genero values(null,'Drama');
insert into genero values(null,'Aventura');
insert into genero values(null,'Suspenso');
insert into genero values(null,'Terror');
select*from genero;

insert into pelicula values(null,'Ainbo La Guerrera del Amazonas','1hrs 30min','Doblada','Jose Zelada','APT',2);
select*from pelicula;


create table ciudad(
idCiudad int primary key not null auto_increment,
nombre varchar(30) not null
);
insert into ciudad values(null,'Trujillo');
insert into ciudad values(null,'Cajamarca');
insert into ciudad values(null,'Cusco');

create table cine(
idCine int primary key not null auto_increment,
nombre varchar(50) not null,
idCiudad int not null,
foreign key (idCiudad) references ciudad (idCiudad)
);
alter table cine
add column direccion varchar(100) not null;

insert into cine values(null,'CineTrujillo',1);
insert into cine values(null,'CineCajamarca',2,'Av .Huascar');

#select*from cine  inne


create table sala(
idSala int primary key not null auto_increment,
nombre varchar(25) not null
);
insert into sala values(null,'Sala 1');
insert into sala values(null,'Sala 2');
insert into sala values(null,'Sala 3');
select*from sala;

create table asiento(
idAsiento int primary key not null auto_increment,
codigo char(3) not null
);
insert into asiento values(null,'A1');
insert into asiento values(null,'A2');
insert into asiento values(null,'A3');
select*from asiento;


create table estado(
 idEstado int primary key not null auto_increment,
descripcion varchar(15) not null
);
insert into estado values(null,'ocupado');
insert into estado values(null,'disponible');
select*from estado ;

create table pago(
idPago int primary key not null auto_increment,
descripcion varchar(12)
);
insert into estado values(null,'PayPal');
select*from pago;

drop table boleto;
create table boleto(
idBoleto int primary key not null auto_increment,
persona varchar(20) not null,
precio double not null
);
insert into boleto values(null,'Niños',15.0);
insert into boleto values(null,'General',17.50);
insert into boleto values(null,'Mayores de 60 años',20);
select*from boleto;



create table cine_sala(
idCine int not null,
idSala int not null,
primary key (idCine,idSala),
foreign key (idCine) references cine (idCine),
foreign key (idSala) references Sala (idSala)
);
insert into cine_sala values(1,1);
insert into cine_sala values(1,2);
insert into cine_sala values(1,3);
select*from cine_sala;


# De apartir de aqui no lo ejecute porque me 
#falta definir como implementar el esatdo de asientos

create table sala_asiento(
idAsiento int not null,
idSala int not null,
idEstado int not null,
primary key(idSala,idAsiento),
foreign key (idAsiento) references  asiento (idAsiento),
foreign key (idSala) references  sala (idSala),
foreign key (idEstado) references estado(idEstado)
);

create table cartelera(
idCartelera int primary key not null auto_increment,
idPelicula int not null,
idCine int not null,
fecha varchar(12),
hora varchar(12),
descripcion varchar(12),
foreign key (idCine) references cine (idCine),
foreign key (idPelicula) references pelicula (idPelicula)
);

create table compra(
idCompra int primary key not null auto_increment,
idUsuario int not null,
idCartelera int not null,
idPago int not null,
fechaRegistro timestamp  default CURRENT_TIMESTAMP,
foreign key (idCartelera) references cartelera(Cartelera),
foreign key (idPago) references pago (idPago),
foreign key (idUsuario) references compra(idUsuario)
);
create table detalle_compra(
idCompra int not null,
idBoleto int not null,
cantidad int,
primary key(idCompra,idBoleto),
foreign key (idCompra) references compra(idCompra),
foreign key (idBoleto) references pago (idPago)
);

