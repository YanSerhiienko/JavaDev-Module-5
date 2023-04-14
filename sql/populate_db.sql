insert into worker (name, birthday, level, salary) values 
('Max Pain', '1985-09-01', 'Senior', 8000), 
('Jango Frett', '1989-06-19', 'Middle', 5000),
('Optimus Prime', '1990-05-23', 'Senior', 9000),
('Boris Borisov', '1990-04-02', 'Junior', 900),
('Arnold Hey', '1998-08-17', 'Junior', 1200),
('Nicolas Cgae', '1970-02-06', 'Senior', 7000),
('John Snow', '1999-03-08', 'Middle', 5000),
('Kendrik Lamar', '1995-11-12', 'Middle', 4500),
('Tony Versetti', '1980-07-17', 'Middle', 4000),
('Scotty Doesntknow', '2004-02-20', 'Junior', 900);

insert into client(name) values 
('Bruce'),
('Alex'),
('Martha'),
('Leslie'),
('Akudama');

insert into project(client_id, start_date, finish_date) values 
(1, '2023-01-01', '2023-04-02'),
(2, '2023-07-01', '2023-08-02'),
(3, '2020-07-22', '2023-01-30'),
(3, '2021-09-21', '2023-09-21'),
(3, '2023-01-01', '2023-11-01'),
(4, '2024-12-12', '2028-08-08'),
(4, '2018-01-01', '2021-07-06'),
(5, '2023-01-01', '2029-11-03'),
(5, '2023-01-01', '2027-12-02'),
(5, '2023-01-01', '2026-10-01');

insert into project_worker(project_id, worker_id) values 
(1, 10),
(2, 9),
(3, 8),
(4, 7),
(5, 6),
(6, 5),
(7, 4),
(8, 3),
(8, 2),
(8, 1),
(9, 2),
(10, 1);