create table if not exists elementos
(
	id int not null constraint pk_elementos primary key,
	tipo varchar(50),
	marca varchar(30),
	equiposAsociado int,
	constraint Fk_Equipo_Asociado foreign key(equiposAsociado) references equipos(id_equipo)
);

create table if not exists novedades
(
	id int not null constraint pk_novedades primary key,
	fechaDeRegistro date,
	idReferencia varchar (50),
	reporte varchar(50)

);

create table if not exists roles 
(
	codigo varchar(30),
	nombre varchar(30) not null constraint pk_roles primary key
);

create table if not exists laboratorios
(
    nombre varchar(50) not null constraint pk_laboratorio primary key,
	activo boolean,
	fechaCreacion date,
	fechaCierre date
);

//equipos

create table if not exists equipos
(
    id int not null constraint pk_equipos primary key,
    referencia varchar(30),
    marca 	varchar(50),
    serial 	varchar(50),
    disponible boolean,
	laboratorioAsociado varchar(50),
	constraint fk_Lab_Asociado foreign key(laboratorioAsociado) referencia laboratorios(nombre)
);

//usuarios
create table if not exists usuarios 
(
	correo varchar(50) not null constraint pk_equipos primary key,
	rol varchar(50),
	clave varchar(30),
	nombre varchar(50),
	apellido varchar(30),
	estado varchar(30)

);
