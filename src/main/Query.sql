create user 'springuser@localhost' identified by 'password';
grant all on db_example.* to 'springuser@localhost';
set password for springuser = 'password';

SET GLOBAL time_zone = '+3:00';

GRANT ALL PRIVILEGES ON *.* TO 'springuser'@'%' WITH GRANT OPTION;


INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES ('Egor', 'Perehodko', 5, 'Programmer', MALE, 1998-05-26)