-- Write your query below
select DISTINCT on (student_id) student_id, exam_id, score from exam_results
order by student_id, score DESC, exam_id;