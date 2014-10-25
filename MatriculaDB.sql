SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `matriculadb` DEFAULT CHARACTER SET utf8 ;
USE `matriculadb` ;

-- -----------------------------------------------------
-- Table `matriculadb`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`curso` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`curso` (
  `idcurso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `codigo` VARCHAR(50) NULL,
  `creditos` INT NULL,
  `requisitos` VARCHAR(100) NULL,
  `ciclo` INT NULL,
  PRIMARY KEY (`idcurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`seccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`seccion` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`seccion` (
  `idseccion` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(50) NULL,
  `profesor` VARCHAR(50) NULL,
  `idcurso` INT NOT NULL,
  PRIMARY KEY (`idseccion`),
  INDEX `fk_seccion_curso1_idx` (`idcurso` ASC),
  CONSTRAINT `fk_seccion_curso1`
    FOREIGN KEY (`idcurso`)
    REFERENCES `matriculadb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`clase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`clase` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`clase` (
  `idclase` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(50) NULL,
  `dia` VARCHAR(50) NULL,
  `horaInicio` INT NULL,
  `horaFin` INT NULL,
  `tipoClase` VARCHAR(50) NULL,
  `idseccion` INT NOT NULL,
  PRIMARY KEY (`idclase`),
  INDEX `fk_clase_seccion` (`idseccion` ASC),
  CONSTRAINT `fk_idseccion`
    FOREIGN KEY (`idseccion`)
    REFERENCES `matriculadb`.`seccion` (`idseccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(50) NULL,
  `clave` VARCHAR(50) NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`alumno` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`alumno` (
  `idalumno` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(100) NULL,
  `apellidos` VARCHAR(100) NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idalumno`),
  INDEX `alumno_usuario` (`idusuario` ASC),
  CONSTRAINT `fk_alumno_idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `matriculadb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`matricula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`matricula` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`matricula` (
  `idmatricula` INT NOT NULL AUTO_INCREMENT,
  `horamatricula` INT NULL,
  `fechamatricula` DATE NULL,
  `idcurso` INT NOT NULL,
  `idalumno` INT NOT NULL,
  PRIMARY KEY (`idmatricula`),
  INDEX `matricula_alumno` (`idalumno` ASC),
  INDEX `matricula_curso` (`idcurso` ASC),
  CONSTRAINT `fk_matricula_idalumno`
    FOREIGN KEY (`idalumno`)
    REFERENCES `matriculadb`.`alumno` (`idalumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_idcurso`
    FOREIGN KEY (`idcurso`)
    REFERENCES `matriculadb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`administrador` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`administrador` (
  `idadministrador` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(100) NULL,
  `apellidos` VARCHAR(100) NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idadministrador`),
  INDEX `administrador_usuario` (`idusuario` ASC),
  CONSTRAINT `fk_administrador_idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `matriculadb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matriculadb`.`solicitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matriculadb`.`solicitud` ;

CREATE TABLE IF NOT EXISTS `matriculadb`.`solicitud` (
  `idsolicitud` INT NOT NULL AUTO_INCREMENT,
  `motivo` VARCHAR(1000) NULL,
  `idalumno` INT NOT NULL,
  PRIMARY KEY (`idsolicitud`),
  INDEX `solicitud_alumno` (`idalumno` ASC),
  CONSTRAINT `fk_solicitud_idalumno`
    FOREIGN KEY (`idalumno`)
    REFERENCES `matriculadb`.`alumno` (`idalumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `matriculadb`.`usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `matriculadb`;
INSERT INTO `matriculadb`.`usuario` (`idusuario`, `usuario`, `clave`) VALUES (1, 'hwong', '027e4180beedb29744413a7ea6b84a42');
INSERT INTO `matriculadb`.`usuario` (`idusuario`, `usuario`, `clave`) VALUES (2, 'rtaza', 'd4c285227493531d0577140a1ed03964');
INSERT INTO `matriculadb`.`usuario` (`idusuario`, `usuario`, `clave`) VALUES (3, 'epalomino', '6d6354ece40846bf7fca65dfabd5d9d4');
INSERT INTO `matriculadb`.`usuario` (`idusuario`, `usuario`, `clave`) VALUES (4, 'abaquerizo', '231badb19b93e44f47da1bd64a8147f2');
INSERT INTO `matriculadb`.`usuario` (`idusuario`, `usuario`, `clave`) VALUES (5, 'cpalma', '6f597c1ddab467f7bf5498aad1b41899');

COMMIT;


-- -----------------------------------------------------
-- Data for table `matriculadb`.`alumno`
-- -----------------------------------------------------
START TRANSACTION;
USE `matriculadb`;
INSERT INTO `matriculadb`.`alumno` (`idalumno`, `nombres`, `apellidos`, `idusuario`) VALUES (1, 'Roy', 'Taza', 2);
INSERT INTO `matriculadb`.`alumno` (`idalumno`, `nombres`, `apellidos`, `idusuario`) VALUES (2, 'Andres', 'Baquerizo', 4);
INSERT INTO `matriculadb`.`alumno` (`idalumno`, `nombres`, `apellidos`, `idusuario`) VALUES (3, 'Cesar', 'Palma', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `matriculadb`.`administrador`
-- -----------------------------------------------------
START TRANSACTION;
USE `matriculadb`;
INSERT INTO `matriculadb`.`administrador` (`idadministrador`, `nombres`, `apellidos`, `idusuario`) VALUES (1, 'Henry', 'Wong', 1);
INSERT INTO `matriculadb`.`administrador` (`idadministrador`, `nombres`, `apellidos`, `idusuario`) VALUES (2, 'Eduardo', 'Palomino', 3);

COMMIT;

