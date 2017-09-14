SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `csms` ;
CREATE SCHEMA IF NOT EXISTS `csms` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `csms` ;

-- -----------------------------------------------------
-- Table `csms`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`user` ;

CREATE TABLE IF NOT EXISTS `csms`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `sex` TINYINT NULL COMMENT '0 male ;1 femail',
  `age` INT NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `number` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `create_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `csms`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`role` ;

CREATE TABLE IF NOT EXISTS `csms`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL,
  `role_desc` VARCHAR(45) NULL,
  `create_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `csms`.`user_role_rel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`user_role_rel` ;

CREATE TABLE IF NOT EXISTS `csms`.`user_role_rel` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `rel_role_idx` (`role_id` ASC),
  CONSTRAINT `rel_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `csms`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `rel_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `csms`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `csms`.`type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`type` ;

CREATE TABLE IF NOT EXISTS `csms`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NULL,
  `type_desc` VARCHAR(45) NULL,
  `create_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `csms`.`user_type_rel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`user_type_rel` ;

CREATE TABLE IF NOT EXISTS `csms`.`user_type_rel` (
  `user_id` INT NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `type_id`),
  INDEX `fk_tu_type_idx` (`type_id` ASC),
  CONSTRAINT `fk_tu_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `csms`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tu_type`
    FOREIGN KEY (`type_id`)
    REFERENCES `csms`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `csms`.`creation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`creation` ;

CREATE TABLE IF NOT EXISTS `csms`.`creation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL,
  `path` VARCHAR(45) NULL,
  `create_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `csms`.`security`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `csms`.`security` ;

CREATE TABLE IF NOT EXISTS `csms`.`security` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_number` VARCHAR(45) NULL,
  `user_password` VARCHAR(45) NULL,
  `update_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
