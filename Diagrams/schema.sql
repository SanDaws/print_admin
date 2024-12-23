-- MySQL Script generated by MySQL Workbench
-- Fri Nov 22 10:26:07 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bvnqfza1h7mjqp1cboja
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bvnqfza1h7mjqp1cboja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bvnqfza1h7mjqp1cboja` DEFAULT CHARACTER SET utf8 ;
USE `bvnqfza1h7mjqp1cboja` ;

-- -----------------------------------------------------
-- Table `bvnqfza1h7mjqp1cboja`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bvnqfza1h7mjqp1cboja`.`clients` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NOT NULL,
  `dir` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bvnqfza1h7mjqp1cboja`.`machines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bvnqfza1h7mjqp1cboja`.`machines` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(255) NOT NULL,
  `sn` VARCHAR(45) NOT NULL,
  `state` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `sn_UNIQUE` (`sn` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bvnqfza1h7mjqp1cboja`.`rentals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bvnqfza1h7mjqp1cboja`.`rentals` (
  `id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `state` TINYINT NULL,
  `clients_id` INT UNSIGNED NOT NULL,
  `machines_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rentals_machines_idx` (`machines_id` ASC) VISIBLE,
  INDEX `fk_rentals_clients1_idx` (`clients_id` ASC) VISIBLE,
  CONSTRAINT `fk_rentals_machines`
    FOREIGN KEY (`machines_id`)
    REFERENCES `bvnqfza1h7mjqp1cboja`.`machines` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rentals_clients1`
    FOREIGN KEY (`clients_id`)
    REFERENCES `bvnqfza1h7mjqp1cboja`.`clients` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
