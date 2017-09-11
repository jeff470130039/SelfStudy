SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `shop` ;
CREATE SCHEMA IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `shop` ;

-- -----------------------------------------------------
-- Table `shop`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`user` ;

CREATE TABLE IF NOT EXISTS `shop`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `img` VARCHAR(45) NULL,
  `create_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`goods_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`goods_type` ;

CREATE TABLE IF NOT EXISTS `shop`.`goods_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`goods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`goods` ;

CREATE TABLE IF NOT EXISTS `shop`.`goods` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` INT NULL,
  `price` INT NULL,
  `desc` VARCHAR(255) NULL,
  `amount` INT NULL,
  `create_date` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_goods_type_idx` (`type` ASC),
  CONSTRAINT `fk_goods_type`
    FOREIGN KEY (`type`)
    REFERENCES `shop`.`goods_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`shoping_car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`shoping_car` ;

CREATE TABLE IF NOT EXISTS `shop`.`shoping_car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `goods_id` INT NULL,
  `amount` INT NULL,
  `create_date` DATE NULL,
  `status` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`img`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`img` ;

CREATE TABLE IF NOT EXISTS `shop`.`img` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `path` VARCHAR(255) NULL,
  `type` INT NULL COMMENT '1 user head img\n2 goods img',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`goods_img_rel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`goods_img_rel` ;

CREATE TABLE IF NOT EXISTS `shop`.`goods_img_rel` (
  `goods_id` INT NOT NULL,
  `img_id` INT NOT NULL,
  PRIMARY KEY (`goods_id`, `img_id`),
  INDEX `fk_goods_img_rel_img_id_idx` (`img_id` ASC),
  CONSTRAINT `fk_goods_id`
    FOREIGN KEY (`goods_id`)
    REFERENCES `shop`.`goods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_goods_img_rel_img_id`
    FOREIGN KEY (`img_id`)
    REFERENCES `shop`.`img` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
