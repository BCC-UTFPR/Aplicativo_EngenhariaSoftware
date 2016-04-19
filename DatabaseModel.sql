SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Veiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Veiculo` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Veiculo` (
  `ID_Veiculo` INT NOT NULL AUTO_INCREMENT,
  `Ano` VARCHAR(45) NULL,
  `Quilometragem` VARCHAR(45) NULL,
  `Placa` VARCHAR(45) NULL,
  `Cor` VARCHAR(45) NULL,
  `Marca` VARCHAR(45) NULL,
  `Modelo` VARCHAR(45) NULL,
  `Categoria` VARCHAR(45) NULL,
  `Renavam` VARCHAR(45) NULL,
  `EstadoConservacao` MEDIUMTEXT NULL,
  `ComentariosAdicionais` MEDIUMTEXT NULL,
  PRIMARY KEY (`ID_Veiculo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Funcionario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `ID_Funcionario` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `NumeroRegistro` VARCHAR(45) NULL,
  `RG` VARCHAR(45) NULL,
  `CPF` VARCHAR(45) NULL,
  `CNH` VARCHAR(45) NULL,
  `ComentariosAdicionais` MEDIUMTEXT NULL,
  PRIMARY KEY (`ID_Funcionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Viagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Viagem` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Viagem` (
  `ID_Viagem` INT NOT NULL AUTO_INCREMENT,
  `DataSaida` VARCHAR(45) NULL,
  `DataChegada` VARCHAR(45) NULL,
  `QuilometragemSaida` VARCHAR(45) NULL,
  `QuilometragemChegada` VARCHAR(45) NULL,
  `RelatorioGastos` MEDIUMTEXT NULL,
  `RelatorioDanos` MEDIUMTEXT NULL,
  PRIMARY KEY (`ID_Viagem`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
