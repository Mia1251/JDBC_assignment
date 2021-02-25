use todoit;

insert into person (person_id, first_name, last_name) values(0, "Maria", "Svensson");
insert into person (person_id, first_name, last_name) values(0, "Andreas", "Svensson");
insert into person (person_id, first_name, last_name) values(0,"Ingrid", "Svensson");
insert into person (person_id, first_name, last_name) values(0, "Christer", "Svensson");
insert into person (person_id, first_name, last_name) values(0, "Inger", "Holgersson");
insert into person (person_id, first_name, last_name) values(0, "Henric", "Thompsson");
insert into person (person_id, first_name, last_name) values(0, "Emma", "Holgersson");
insert into person (person_id, first_name, last_name) values(0, "Fredrik", "Holgersson");
insert into person (person_id, first_name, last_name) values(0, "Adelina", "Holgersson");
insert into person (person_id, first_name, last_name) values(0, "Mehrdad", "Javan");
insert into person (person_id, first_name, last_name) values(0, "Asha", "Joseph");

select * from person;

insert into todo_item (todo_id, title, description, deadline, done, assignee_id) values(0, "Teacher", "Teach students", "2021-05-05", true, 10);
insert into todo_item (todo_id, title, description, deadline, done, assignee_id) values(0, "Student", "Learn Java", "2021-05-05", false, 1);
insert into todo_item (todo_id, title, description, deadline, done, assignee_id) values(0, "Engineer", "Make drawings", "2021-12-31", true, 6);
insert into todo_item (todo_id, title, description, deadline, done, assignee_id) values(0, "Tank driver", "Drive a petrol truck", "2025-06-11", false, 4);
insert into todo_item (todo_id, title, description, deadline, done, assignee_id) values(0, "Repairman", "Works in a garage", "2026-11-16", true, 2);
insert into todo_item (todo_id, title, description, deadline, done) values(0, "Farmworker", "Works on a farm", "2024-10-15", true);

select * from todo_item;
