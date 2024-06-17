-- 3A

select d.name as department_name, count(distinct c.id)
from department d, course c
where d.id = c.deptid
group by d.id
order by count(c.id), d.name; 

-- 3B

select c.name, count(sc.studentId)
from course c, studentcourse sc
where c.id = sc.courseId
group by c.id
order by count(sc.studentId) desc, c.name asc;

-- 3C1

select c.name
from course c
where c.id not in (select distinct courseid from facultycourse)
order by c.name asc;

-- 3C2

select c.name, count(sc.studentId) as student_count
from course c, studentcourse sc
where c.id not in (select distinct courseid from facultycourse)
	and c.id = sc.courseId
group by c.id
order by student_count desc, c.name asc;

-- 3D

select count(distinct sc.studentId) as Students, year(sc.startDate) as Year
from studentcourse sc
group by Year
order by Year asc, Students desc;

-- 3E

select sc.startDate, count(distinct sc.studentId) as students
from studentcourse sc
where month(sc.startDate) = 8
group by sc.startDate
order by startDate asc, students asc;

-- 3F

select s.firstname, s.lastname, count(sc.courseId) as course_count
from student s, studentcourse sc, course c
where s.id = sc.studentId
	and sc.courseId = c.id
    and c.deptId = s.majorId
group by s.id
order by course_count desc, firstname asc, lastname asc;

-- 3G

select s.firstname, s.lastname, format(avg(sc.progress),1) as avg_progress
from student s, studentcourse sc
where s.id = sc.studentId
group by s.id
having avg_progress < 50
order by avg_progress desc, s.firstname asc, s.lastname asc;

-- 3H1

select format(avg(round(sc.progress, 1)), 1) as avg_progress, c.name
from course c, studentcourse sc
where c.id = sc.courseId
group by c.id
order by avg_progress desc, c.name asc;

-- 3H2

select c.name, format(avg(sc.progress),1) as avg_progress
from course c, studentcourse sc
where c.id = sc.courseId
group by c.id
order by avg_progress desc, c.name asc
limit 1;

-- 3H3 FOR EACH = GROUP BY

select f.firstname, f.lastname, format(avg(sc.progress),1) as avg_progress
from faculty f, facultycourse fc, studentcourse sc
where f.id = fc.facultyId
	and fc.courseId = sc.courseId
group by f.id
order by avg_progress desc;

-- 3I

select s.firstname, s.lastname,
	CASE
		WHEN min(progress) < 40 THEN 'F'
        WHEN min(progress) < 50 THEN 'D'
        WHEN min(progress) < 60 THEN 'C'
        WHEN min(progress) < 70 THEN 'B'
        ELSE 'A'
	END as min_grade,
    CASE
		WHEN max(progress) < 40 THEN 'F'
        WHEN max(progress) < 50 THEN 'D'
        WHEN max(progress) < 60 THEN 'C'
        WHEN max(progress) < 70 THEN 'B'
        ELSE 'A'
	END as max_grade
from student s, studentcourse sc
where s.id = sc.studentid
group by s.id
order by min_grade desc, max_grade desc, s.firstname asc, s.lastname asc;