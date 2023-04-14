create table worker (
    id identity primary key,
    name varchar (1000) not null check(char_length(name)>=2),
    birthday date check (birthday > date '1900-12-31'),
    level varchar not null check(level in('Trainee', 'Junior', 'Middle', 'Senior')),
    salary int check(salary >=100 and salary <=100000)
);


create table client (
    id identity primary key,
    name varchar (1000) not null check(char_length(name)>=2)
);


create table project (
    id identity primary key,
    client_id bigint,
    start_date date,
    finish_date date
);


create table project_worker (
    project_id bigint not null,
    worker_id bigint not null,
    foreign key(project_id) references project(id),
    foreign key(worker_id) references worker(id),
    primary key(project_id, worker_id)
);