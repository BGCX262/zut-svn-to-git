CREATE  TABLE `models`.`password_recovery` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `account_id` INT(11) NOT NULL ,
  `token` VARCHAR(64) NOT NULL ,
  `ip_address` VARCHAR(128) NOT NULL ,
  `activated` TINYINT(1) NULL DEFAULT '0' ,
  `created_at` TIMESTAMP NOT NULL ,
  `modified_at` VARCHAR(45) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) ,
  INDEX `account_id` (`account_id` ASC) ,
  UNIQUE INDEX `token_UNIQUE` (`token` ASC) );

