```sql
CREATE DATABASE IF NOT EXISTS studentinfo CHARACTER SET utf8;
USE studentinfo;

-- 学生表
CREATE TABLE t_student (
	sno INT PRIMARY KEY NOT NULL,
	sname varchar(20) NOT NULL,
	birthday date,
	gender char(2)
);
INSERT INTO t_student(sno, sname, birthday, gender) values 
(1, '张天师', '1998-08-06', '男'),
(2, '王祖贤', '1999-08-08', '女'),
(3, '迪丽热巴', '1997-07-21', '女');
SELECT * FROM t_student;

-- 课程表
CREATE TABLE t_course (
	cno INT PRIMARY KEY NOT NULL,
	cname VARCHAR(20) NOT NULL,
	tno int NOT NULL
);
INSERT INTO t_course values
(1, '语文', 1),
(2, '数学', 2),
(3, '英语', 3);
SELECT * FROM t_course;

-- 成绩表
CREATE TABLE t_sc (
	scno INT PRIMARY KEY NOT NULL,
	sno INT NOT NULL,
	cno int NOT NULL,
	score int
);
INSERT INTO t_sc values
(1, 1, 1, 88),
(2, 1, 2, 90),
(3, 1, 3, 78),
(4, 2, 1, 92),
(5, 2, 2, 80),
(6, 2, 3, 76),
(7, 3, 1, 75),
(8, 3, 2, 86),
(9, 3, 3, 98);
SELECT * FROM t_sc;

-- 教师表
CREATE TABLE t_teacher (
	tno INT PRIMARY KEY NOT NULL,
	tname VARCHAR(10) NOT NULL
);
INSERT INTO t_teacher VALUES 
(1, '语文老师'),
(2, '数学老师'),
(3, '英语老师');
SELECT * FROM t_teacher; 

```

