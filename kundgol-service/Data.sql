CREATE TABLE `kundgol_db`.`place` (
  `place_id` INT NOT NULL,
  `place_code` VARCHAR(10) UNIQUE NOT NULL,
  `place_name` VARCHAR(50) NOT NULL,
  `place_nameK` VARCHAR(50) NOT NULL,
  `created_by` INT NOT NULL,
  `created_date` TIMESTAMP NOT NULL,
  `updated_by` INT,
  `updated_date` TIMESTAMP,
  PRIMARY KEY (`place_id`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;
