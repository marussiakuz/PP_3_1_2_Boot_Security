insert into roles (role_name) values ('ROLE_ADMIN');
insert into roles (role_name) values ('ROLE_USER');

insert into users (age, email, user_name, last_name, user_password) values (30, 'admin@gmail.com', 'admin', 'adminskii', '$2a$10$7mbnp8pNOBQFngPN/CdDT.H/eMJ4zfjorglwChXNilCtOF0M14Es6');
insert into users (age, email, user_name, last_name, user_password) values (50, 'user@gmail.com', 'user', 'userevich', '$2a$10$8mOVqDFoLGqE9wHd/FnrV.fF1i7eQb9txn2pLkRMbmtLrsDbTXysu');
insert into users (age, email, user_name, last_name, user_password) values (20, 'msk@gmail.com', 'karim', 'remeykov', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (22, 'piter@outlook.com', 'nikki', 'rusich', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (54, 'cat@yandex.ru', 'vasya', 'vasin', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (36, 'free@mail.ru', 'evrey', 'russ', 'ADMIN');
insert into users (age, email, user_name, last_name, user_password) values (31, 'yaya@gmail.com', 'mark', 'familiev', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (18, 'netut@yandex.ru', 'hululu', 'martirosyan', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (23, 'prosto@mail.ru', 'helen', 'genkova', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (55, 'vmesto@gmail.com', 'alex', 'cattov', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (63, 'zachem@yandex.ru', 'fedya', 'fedin', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (27, 'kukubarash@mail.ru', 'frik', 'usov', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (33, 'time@gmail.com', 'neon', 'fioletov', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (44, 'bez@mail.ru', 'armen', 'menov', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (33, 'e@yandex.ru', 'marsel', 'frantsuzov', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (37, 'letto@outlook.com', 'lusya', 'lusikova', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (41, 'zzzz@gmail.com', 'obama', 'blackov', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (47, 'truba@yandex.ru', 'trump', 'trumpov', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (44, 'freddy@gmail.com', 'unknown', 'dvortsov', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (32, 'fro@yandex.ru', 'petya', 'petin', 'REGISTERED');
insert into users (age, email, user_name, last_name, user_password) values (19, 'gm@mail.ru', 'limon', 'apelsinov', 'GUEST');
insert into users (age, email, user_name, last_name, user_password) values (17, 'java@gmail.com', 'nik', 'nikov', 'GUEST');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (1, 2);
insert into users_roles (user_id, role_id) values (2, 2);

