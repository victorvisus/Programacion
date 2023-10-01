CREATE TABLE IF NOT EXISTS test.tipo_usuarios (
  idTipoUsr INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTipoUsr));

  CREATE TABLE IF NOT EXISTS test.usuarios (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  nickName VARCHAR(30) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(45) NOT NULL,
  idTipoUsr INT NULL DEFAULT NULL COMMENT '\'sala | artista\'\\nALTER TABLE usuarios ADD CONSTRAINT tipoUser_VAL CHECK (nombredatospersonales IN (\'Sala\',\'Artista\'));',
  PRIMARY KEY (idUsuario),
  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE,
  UNIQUE INDEX nickName_UNIQUE (nickName ASC) INVISIBLE,
  INDEX idTipoUsr_idx (idTipoUsr ASC) VISIBLE,
  CONSTRAINT idTipoUsr_usuarios
    FOREIGN KEY (idTipoUsr)
    REFERENCES test.tipo_usuarios (idTipoUsr));

INSERT INTO test.tipo_usuarios (nombre) VALUES ("Sala");
INSERT INTO test.tipo_usuarios (nombre) VALUES ("Artista");

CREATE TABLE IF NOT EXISTS test.salas (
  idSala INT NOT NULL AUTO_INCREMENT,
  nombreSala VARCHAR(45) NOT NULL,
  idUsuario INT NOT NULL,
  PRIMARY KEY (idSala),
  UNIQUE INDEX idSala_UNIQUE (idSala ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS test.artistas (
  idArtista INT NOT NULL AUTO_INCREMENT,
  nombreArtista VARCHAR(45) NOT NULL,
  idUsuario INT NOT NULL,
  PRIMARY KEY (idArtista),
  UNIQUE INDEX idArtista_UNIQUE (idArtista ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS test.datospersonales (
  idDatosPersonales INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL DEFAULT NULL,
  apellido VARCHAR(45) NULL DEFAULT NULL,
  direccion VARCHAR(45) NULL DEFAULT NULL,
  localidad VARCHAR(45) NOT NULL,
  idUsuario INT NOT NULL,
  PRIMARY KEY (idDatosPersonales));

CREATE TABLE IF NOT EXISTS test.eventos (
  idEventos INT NOT NULL AUTO_INCREMENT,
  idArtista INT NOT NULL,
  idSala INT NOT NULL,
  Fecha_evento DATE NOT NULL,
  Ciudad VARCHAR(45) NOT NULL,
  PRIMARY KEY (idEventos),
  INDEX idArtista_idx (idArtista ASC) VISIBLE,
  INDEX idSala_idx (idSala ASC) VISIBLE,
  CONSTRAINT idArtistaEvento_eventos
    FOREIGN KEY (idArtista)
    REFERENCES test.artistas (idArtista)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT idSalaEvento_eventos
    FOREIGN KEY (idSala)
    REFERENCES test.salas (idSala)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

 /* INSERTAR USUARIOS INVITADOS */ 
INSERT INTO test.usuarios(nickName, password, email, idTipoUsr) VALUES ("invitadoSala", "0c0438a2d770051789cbafdd47fe25a9d7f74587", "sala@mail.com", 1);
INSERT INTO test.usuarios(nickName, password, email, idTipoUsr) VALUES ("invitadoArtista", "0c0438a2d770051789cbafdd47fe25a9d7f74587", "artista@mail.com", 2);

INSERT INTO test.datospersonales(nombre, apellido, direccion, localidad, idUsuario) VALUES ("nombreInvitadoSala", "apeInvitado Sala", "dirInvitado Sala", "Zaragoza",
	(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoSala" AND email = "sala@mail.com"));
INSERT INTO test.salas(nombreSala, idUsuario) VALUES ("nombreSala",
	(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoSala" AND email = "sala@mail.com"));

INSERT INTO test.datospersonales(nombre, apellido, direccion, localidad, idUsuario) VALUES ("nombreInvitadoArtista", "apeInvitado Artista", "dirInvitado Artista", "Madrid",
	(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoArtista" AND email = "artista@mail.com"));
INSERT INTO test.artistas(nombreArtista, idUsuario) VALUES ("nombreArtista",
	(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoArtista" AND email = "artista@mail.com"));