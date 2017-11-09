USE `jstudyplanner`;

SELECT enrollment.id, user.first_name, user.last_name, 
	ca_fk, 
	campus.title,
	status 
FROM enrollment
INNER JOIN user ON enrollment.user_fk = user.id
JOIN course_availability ON course_availability.id = enrollment.ca_fk
JOIN campus ON campus.id = course_availability.campus_fk
ORDER BY user_fk