USE `jstudyplanner`;

SELECT course_availability.id, campus.title, term.year, term.number, course.title, 
	course_availability.enabled
FROM course_availability
INNER JOIN campus ON campus.id = course_availability.campus_fk
JOIN term ON term.id = course_availability.term_fk
JOIN course ON course.id = course_availability.course_fk