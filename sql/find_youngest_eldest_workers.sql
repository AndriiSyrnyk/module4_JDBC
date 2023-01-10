SELECT 'YOUNGEST' AS type, name, birthday
FROM worker
WHERE birthday = (
	SELECT MAX(birthday) 
	FROM worker
)
UNION
SELECT 'ELDEST' AS type, name, birthday
FROM worker
WHERE birthday = (
	SELECT MIN(birthday) 
	FROM worker
);