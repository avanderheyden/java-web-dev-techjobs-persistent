## Part 1: Test it with SQL
SELECT * FROM job;
## Part 2: Test it with SQL
SELECT names
FROM employer;

## Part 3: Test it with SQL
DROP TABLE job;

## Part 4: Test it with SQL
SELECT name, description
FROM skill
WHERE skills_id in job_skills is not null;