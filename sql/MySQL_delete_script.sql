-- Delete data from all the tables
USE `jstudyplanner`;

DELETE FROM enrollment WHERE id != 0;
DELETE FROM course_availability WHERE id != 0;
DELETE FROM campus_management WHERE campus_fk != 0;
DELETE FROM user WHERE id != 1;
DELETE FROM major_compulsory_courses WHERE major_fk != 0;
DELETE FROM major WHERE id != 0;
DELETE FROM program_elective_courses WHERE program_fk != 0;
DELETE FROM program_core_courses WHERE program_fk != 0;
DELETE FROM program WHERE id != 0;
DELETE FROM prerequisite WHERE course != 0;
DELETE FROM course WHERE id != 0;
DELETE FROM campus WHERE id != 0;
DELETE FROM term WHERE id != 0;