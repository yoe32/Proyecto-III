-- MySQL Script generated by MySQL Workbench
-- 07/25/15 22:44:00
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bitchneldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bitchneldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bitchneldb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bitchneldb` ;

-- -----------------------------------------------------
-- Table `bitchneldb`.`restaurant_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`restaurant_profile` (
  `restaurant_profile_id` INT NOT NULL AUTO_INCREMENT,
  `restaurant_name` VARCHAR(45) NOT NULL,
  `restaurant_email` VARCHAR(45) NOT NULL,
  `restaurant_password` VARCHAR(45) NOT NULL,
  `restaurant_description` MEDIUMTEXT NULL,
  `restaurant_province` VARCHAR(45) NOT NULL,
  `restaurant_location` VARCHAR(45) NULL,
  `restaurant_phone1` INT NOT NULL,
  `restaurant_phone2` INT NULL,
  `restaurant_phone3` INT NULL,
  `restaurant_schedule` MEDIUMTEXT NULL,
  `restaurant_img` LONGBLOB NULL,
  `restaurant_creation_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`restaurant_profile_id`),
  UNIQUE INDEX `restaurant_id_UNIQUE` (`restaurant_profile_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bitchneldb`.`user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`user_profile` (
  `user_id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `user_email` VARCHAR(45) NULL,
  `user_password` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bitchneldb`.`restaurant_gallery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`restaurant_gallery` (
  `restaurant_gallery_id` INT NOT NULL AUTO_INCREMENT,
  `restaurant_profile_id` INT NOT NULL,
  `restaurant_picture` LONGBLOB NULL,
  `restaurant_picture_name` VARCHAR(45) NULL,
  PRIMARY KEY (`restaurant_gallery_id`),
  INDEX `fk_restaurant_gallery_restaurant_profile1_idx` (`restaurant_profile_id` ASC),
  CONSTRAINT `fk_restaurant_gallery_restaurant_profile1`
    FOREIGN KEY (`restaurant_profile_id`)
    REFERENCES `bitchneldb`.`restaurant_profile` (`restaurant_profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bitchneldb`.`restaurant_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`restaurant_product` (
  `restaurant_product_id` INT NOT NULL AUTO_INCREMENT,
  `restaurant_profile_id` INT NOT NULL,
  `restaurant_product` VARCHAR(45) NOT NULL,
  `product_description` VARCHAR(45) NOT NULL,
  `product_price` VARCHAR(45) NULL,
  `product_img` LONGBLOB NULL,
  PRIMARY KEY (`restaurant_product_id`),
  INDEX `fk_menu_product_restaurant_profile1_idx` (`restaurant_profile_id` ASC),
  CONSTRAINT `fk_menu_product_restaurant_profile1`
    FOREIGN KEY (`restaurant_profile_id`)
    REFERENCES `bitchneldb`.`restaurant_profile` (`restaurant_profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bitchneldb`.`restaurant_event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`restaurant_event` (
  `restaurant_event_id` INT NOT NULL,
  `restaurant_profile_id` INT NOT NULL,
  `event_name` VARCHAR(45) NULL,
  `event_description` MEDIUMTEXT NULL,
  `event_contact` VARCHAR(15) NULL,
  PRIMARY KEY (`restaurant_event_id`),
  INDEX `fk_restaurant_event_restaurant_profile1_idx` (`restaurant_profile_id` ASC),
  CONSTRAINT `fk_restaurant_event_restaurant_profile1`
    FOREIGN KEY (`restaurant_profile_id`)
    REFERENCES `bitchneldb`.`restaurant_profile` (`restaurant_profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bitchneldb`.`user_favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`user_favorite` (
  `user_favorite_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `restaurant_profile_id` INT NOT NULL,
  INDEX `fk_user_favorite_user_profile1_idx` (`user_id` ASC),
  INDEX `fk_user_favorite_restaurant_profile1_idx` (`restaurant_profile_id` ASC),
  PRIMARY KEY (`user_favorite_id`),
  CONSTRAINT `fk_user_favorite_user_profile1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bitchneldb`.`user_profile` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_favorite_restaurant_profile1`
    FOREIGN KEY (`restaurant_profile_id`)
    REFERENCES `bitchneldb`.`restaurant_profile` (`restaurant_profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bitchneldb`.`restaurant_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bitchneldb`.`restaurant_order` (
  `restaurant_order_id` INT NOT NULL,
  PRIMARY KEY (`restaurant_order_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
