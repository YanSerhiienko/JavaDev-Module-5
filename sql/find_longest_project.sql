select concat('Project ', id) as name, datediff(month, start_date, finish_date) as month_count from project
group by id
having month_count = (
select max (datediff(month, start_date, finish_date)) as month_count from project);