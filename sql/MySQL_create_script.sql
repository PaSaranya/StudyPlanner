-- delimiter $$

-- Create database user
CREATE USER `jstudyplanner`@`localhost` IDENTIFIED BY 'myPassword';

-- Create the database
CREATE DATABASE IF NOT EXISTS `jstudyplanner`/*!40100 DEFAULT CHARACTER SET utf8 */;

-- Create account and grant permission. Make sure that you use the same credentials in your application settings.
GRANT ALL ON `jstudyplanner`.* TO `jstudyplanner`@`localhost`;

USE `jstudyplanner`;

-- Create tables ----------------------------
-- campus
CREATE  TABLE IF NOT EXISTS `campus` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(45) NOT NULL ,
  `title` VARCHAR(255) NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 0,
  `address` VARCHAR(255) NULL ,
  `phone` VARCHAR(255) NULL ,
  `description` VARCHAR(4000) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) );

-- course
CREATE  TABLE IF NOT EXISTS `course` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(45) NOT NULL ,
  `title` VARCHAR(255) NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 0 ,
  `description` VARCHAR(4000) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) );

-- program
CREATE  TABLE IF NOT EXISTS `program` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(45) NOT NULL ,
  `title` VARCHAR(255) NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 0,
  `description` VARCHAR(4000) NULL ,
  `career` VARCHAR(45) NULL ,
  `number_of_courses` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) );

-- major
CREATE TABLE IF NOT EXISTS `major` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `title` varchar(255) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 0,
  `description` varchar(4000) DEFAULT NULL,
  `program_fk` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `m_program_idx` (`program_fk`),
  CONSTRAINT `m_program` FOREIGN KEY (`program_fk`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- term
CREATE  TABLE IF NOT EXISTS `term` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `year` INT UNSIGNED NOT NULL ,
  `number` INT UNSIGNED NOT NULL ,
  `start_date` DATE NULL ,
  `finish_date` DATE NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) );

-- user. One table for all types of users. User type is defined by utype
CREATE  TABLE IF NOT EXISTS `user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `utype` VARCHAR(10) NOT NULL COMMENT 'admin,staff,student' ,
  `email` VARCHAR(255) NOT NULL ,
  `username` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(1000) NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 0,
  `first_name` VARCHAR(65) NOT NULL ,
  `last_name` VARCHAR(65) NOT NULL ,
  `phone` VARCHAR(45) NULL ,
  `student_type` VARCHAR(45) NULL ,
  `major_id` INT UNSIGNED NULL ,
  `campus_id` INT UNSIGNED NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) ,
  INDEX `major_idx` (`major_id` ASC) ,
  INDEX `campus_idx` (`campus_id` ASC) ,
  CONSTRAINT `major`
    FOREIGN KEY (`major_id` )
    REFERENCES `major` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `campus`
    FOREIGN KEY (`campus_id` )
    REFERENCES `campus` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- campus_management. Many-to-many relationship between user(staff) and campus
CREATE TABLE IF NOT EXISTS `campus_management` (
  `campus_fk` int(10) unsigned NOT NULL,
  `user_fk` int(10) unsigned NOT NULL,
  KEY `campus_idx` (`campus_fk`),
  KEY `staff_idx` (`user_fk`),
  CONSTRAINT `cm_campus`
	FOREIGN KEY (`campus_fk`)
	REFERENCES `campus` (`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
  CONSTRAINT `cm_user`
	FOREIGN KEY (`user_fk`)
	REFERENCES `user` (`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

-- prerequisite. Many-to-many relationship course-course
CREATE TABLE IF NOT EXISTS `prerequisite` (
  `course` INT UNSIGNED NOT NULL ,
  `prerequisite` INT UNSIGNED NOT NULL ,
  INDEX `prereq_course_idx` (`course` ASC) ,
  INDEX `prereq_prerequisite_idx` (`prerequisite` ASC) ,
  CONSTRAINT `prereq_course`
    FOREIGN KEY (`course` )
    REFERENCES `course` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prereq_prerequisite`
    FOREIGN KEY (`prerequisite` )
    REFERENCES `course` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- compulsoryCourses. Many-to-many relationship major-course
CREATE TABLE IF NOT EXISTS `major_compulsory_courses` (
  `major_fk` INT UNSIGNED NOT NULL ,
  `course_fk` INT UNSIGNED NOT NULL ,
  INDEX `major_compulsory_major_idx` (`major_fk` ASC) ,
  INDEX `major_compulsory_course_idx` (`course_fk` ASC) ,
  CONSTRAINT `major_compulsory_major`
    FOREIGN KEY (`major_fk` )
    REFERENCES `major` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `major_compulsory_course`
    FOREIGN KEY (`course_fk` )
    REFERENCES `course` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- coreCourses. Many-to-many relationship program-course
CREATE TABLE IF NOT EXISTS `program_core_courses` (
  `program_fk` INT(10) UNSIGNED NOT NULL ,
  `course_fk` INT(10) UNSIGNED NOT NULL ,
  INDEX `program_core_program_idx` (`program_fk` ASC) ,
  INDEX `program_core_course_idx` (`course_fk` ASC) ,
  CONSTRAINT `program_core_program`
    FOREIGN KEY (`program_fk` )
    REFERENCES `program` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `program_core_course`
    FOREIGN KEY (`course_fk` )
    REFERENCES `course` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- electiveCourses. Many-to-many relationship program-course
CREATE TABLE IF NOT EXISTS `program_elective_courses` (
  `program_fk` INT(10) UNSIGNED NOT NULL,
  `course_fk` INT(10) UNSIGNED NOT NULL,
  KEY `major_elective_major_idx` (`program_fk`),
  KEY `major_elective_course_idx` (`course_fk`),
  CONSTRAINT `program_elective_course`
	FOREIGN KEY (`course_fk`) 
	REFERENCES `course` (`id`) 
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION,
  CONSTRAINT `program_elective_major` 
	FOREIGN KEY (`program_fk`) 
	REFERENCES `program` (`id`) 
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION
);

-- CourseAvailability. 3 table many-to-many relationship term-course-campus
CREATE TABLE IF NOT EXISTS `course_availability` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `term_fk` INT UNSIGNED NOT NULL ,
  `course_fk` INT UNSIGNED NOT NULL ,
  `campus_fk` INT UNSIGNED NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) ,
  INDEX `ca_term_idx` (`term_fk` ASC) ,
  INDEX `ca_course_idx` (`course_fk` ASC) ,
  INDEX `ca_campus_idx` (`campus_fk` ASC) ,
  CONSTRAINT `ca_term`
    FOREIGN KEY (`term_fk` )
    REFERENCES `term` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ca_course`
    FOREIGN KEY (`course_fk` )
    REFERENCES `course` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ca_campus`
    FOREIGN KEY (`campus_fk` )
    REFERENCES `campus` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- enrollment. 2 many-to-many relationships
CREATE TABLE IF NOT EXISTS `enrollment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ca_fk` INT UNSIGNED NOT NULL ,
  `user_fk` INT UNSIGNED NOT NULL ,
  `status` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `enr_ca_idx` (`ca_fk` ASC) ,
  INDEX `enrollment_user_idx` (`user_fk` ASC) ,
  CONSTRAINT `enrollment_ca`
    FOREIGN KEY (`ca_fk` )
    REFERENCES `course_availability` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `enrollment_user`
    FOREIGN KEY (`user_fk` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- There should be one initial admin account to manage all other accounts. This account cannot be deleted
INSERT INTO `user` (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (1, 'admin', 'admin@jstudyplanner.com', 'admin', 'admin', 1, 'admin first name', 'admin last name', '00000000', NULL, NULL, NULL );


