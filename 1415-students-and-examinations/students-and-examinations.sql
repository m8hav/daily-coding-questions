# Write your MySQL query statement below

SELECT
    stus.student_id,
    stus.student_name,
    subs.subject_name,
    COUNT(exams.subject_name) AS attended_exams
FROM
    students stus
    CROSS JOIN subjects subs
    LEFT JOIN examinations exams
        ON subs.subject_name = exams.subject_name
        AND stus.student_id = exams.student_id
GROUP BY stus.student_id, subs.subject_name
ORDER BY stus.student_id
;