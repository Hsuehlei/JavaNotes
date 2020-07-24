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

-- 1. 查询编号为1的课程比编号为2的课程成绩高的学生的学号,姓名
SELECT stu.sno,stu.sname FROM t_student stu WHERE stu.sno = (
	SELECT sc1.sno FROM t_sc sc1,t_sc sc2 WHERE sc1.sno = sc2.sno AND (sc1.cno=1 AND sc2.cno=2) AND (sc1.score > sc2.score)
);

-- 2. 查询平均成绩大于70分的同学的学号和平均成绩.
SELECT sno,AVG(score) avgs FROM t_sc GROUP BY sno HAVING avgs>70;

-- 3. 查询所有同学的学号、姓名、选课数、总成绩。
SELECT stu.sno,stu.sname,COUNT(1) selcourse,SUM(score) FROM t_sc sc,t_student stu WHERE sc.sno = stu.sno GROUP BY sno;

-- 4. 查询姓李的老师的个数。
SELECT COUNT(1) FROM t_teacher WHERE tname LIKE '李%';

-- 5. 查询没学过“叶平”老师课的同学的学号、姓名
SELECT sno,sname FROM t_student WHERE sno NOT IN (
	SELECT DISTINCT sno FROM t_sc WHERE cno IN (
		SELECT cno FROM t_course WHERE tno = (
			SELECT tno FROM t_teacher WHERE tname='叶平'
		)
	)
);

-- 6. 查询学过 编号为1并且也学过编号为2课程的同学的学号、姓名.
SELECT sno,sname FROM t_student WHERE sno IN (
	SELECT sc1.sno FROM t_sc sc1,t_sc sc2 WHERE sc1.sno = sc2.sno AND sc1.cno=1 AND sc2.cno=2
);

-- 7. 查询所有课程成绩小于60分的同学的学号、姓名。
SELECT sno,sname FROM t_student where sno IN (
	SELECT sno FROM t_sc WHERE score<60
);

-- 8. 查询没有学全所有课的同学的学号、姓名。
-- SELECT sno,sname FROM t_student WHERE sno NOT IN (
-- 	SELECT DISTINCT sc1.sno FROM t_sc sc1,t_sc sc2,t_sc sc3 WHERE sc1.sno=sc2.sno=sc3.sno AND sc1.cno=1 AND sc2.cno=2 AND sc3.cno=3 
-- )
SELECT sno,sname FROM t_student WHERE sno IN (
	SELECT sno FROM t_sc GROUP BY sno HAVING COUNT(cno) < (SELECT COUNT(cno) FROM t_course)
);

-- 9. 查询至少学过学号为1的同学所学的任意一门课的 其他同学学号和姓名。
SELECT sno,sname FROM t_student WHERE sno IN (
	SELECT DISTINCT sno FROM t_sc WHERE cno IN (
		SELECT cno FROM t_sc WHERE sno=1
	)
);

-- 10. 查询和2号同学学习的课程完全相同的其他同学学号和姓名。
SELECT sno,sname FROM t_student WHERE sno IN (
	SELECT sno FROM t_sc WHERE cno NOT IN	(
		SELECT cno FROM t_sc WHERE sno=2
		) 
);		-- 如果选课数量少于2号同学且所选课程2号同学均已选，就无法查出

-- 11. 查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分。
SELECT cno,MAX(score),MIN(score) FROM t_sc GROUP BY cno;

-- 12. 查询不同老师所教不同课程平均分从高到低显示。
SELECT AVG(score) avgscore FROM t_sc GROUP BY cno ORDER BY avgscore DESC;

-- 13. 查询统计各科成绩，各分数段人数：课程ID，课程名称，【100-85】，【85-70】，【70-60】，【<60】


-- 14. 查询每门课程被选修的学生数量。
SELECT cno,COUNT(cno) FROM t_sc GROUP BY cno;

-- 15. 查询出只选修了一门课程的学生的学号和姓名
SELECT sno,sname FROM t_student WHERE sno IN (
	SELECT sno FROM t_sc GROUP BY sno HAVING COUNT(cno)=1
);

-- 16. 查询男生、女生人数
SELECT COUNT(1) FROM t_student GROUP BY gender;

-- 17. 查询同名同性学生名单，并统计同名人数。
SELECT COUNT(1) FROM t_student t1,t_student t2 WHERE t1.sno!=t2.sno AND t1.sname = t2.sname GROUP BY t1.sno=t2.sno;

-- 18. 查询1994年出生的学生名单
SELECT sname FROM t_student WHERE YEAR(birthday)=1994;

-- 19. 查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列。
SELECT AVG(score) avgscore FROM t_sc GROUP BY cno ORDER BY avgscore,cno DESC;

-- 20. 查询平均成绩都大于85的所有学生的学号，姓名和平均成绩
SELECT stu.sno,stu.sname FROM t_student stu WHERE stu.sno NOT IN ( 
	SELECT s.sno FROM t_sc s WHERE s.score<85 GROUP BY s.sno
)


-- 21. 查询课程名称为“数据库”且分数低于60的学生姓名和分数
-- 22. 查询所有学生的选课情况
-- 23. 查询不及格的课程，并按课程号从大到小排序。
-- 24. 查询课程编号为3且课程成绩在80分以上的学生的学号和姓名。
-- 25. 查询选修了课程的学生人数。
-- 26. 查询选修了“冯老师”所授课程的学生中，成绩最高的学生姓名及其成绩。
-- 27. 查询各个课程及相应的选修人数
-- 28. 查询每门课程的学生选修人数（超过10人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，查询结果按人数降序排列，若人数相同，按课程号升序排列
-- 29. 查询至少选修两门课程的学生学号。
-- 30. 查询全部学生都选修的课程的课程号和课程名。
-- 31. 查询两门以上不及格课程的同学的学号及其平均成绩。
-- 32. 删除学习“叶平”老师课的sc表记录。






















