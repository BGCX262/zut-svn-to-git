ALTER TABLE `models`.`post` CHANGE COLUMN `owner` `account_id` INT(11) NOT NULL  
, DROP INDEX `owner` 
, ADD INDEX `account_id` (`account_id` ASC) ;