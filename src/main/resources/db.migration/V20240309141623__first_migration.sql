CREATE TABLE my_user_entity (
                                       id serial4 NOT NULL,
                                       login varchar(255) NULL,
                                       "password" varchar(255) NULL,
                                       "role" int4 NULL,
                                       CONSTRAINT my_user_entity_pkey PRIMARY KEY (id)
);

CREATE TABLE post_entity (
                                    id serial4 NOT NULL,
                                    "date" date NULL,
                                    post_body varchar(255) NULL,
                                    post_name varchar(255) NULL,
                                    user_id int4 NULL,
                                    CONSTRAINT post_entity_pkey PRIMARY KEY (id),
                                    CONSTRAINT fks8i67e8kdvowo2ck91rx8vklo FOREIGN KEY (user_id) REFERENCES my_user_entity(id)
);

CREATE TABLE comment_entity (
                                       id serial4 NOT NULL,
                                       "comment" varchar(255) NULL,
                                       "date" date NULL,
                                       like_count int4 NOT NULL,
                                       user_id int4 NULL,
                                       post_id int4 NULL,
                                       CONSTRAINT comment_entity_pkey PRIMARY KEY (id),
                                       CONSTRAINT fk2f49kj0taulx21cyp60oh9mw5 FOREIGN KEY (user_id) REFERENCES my_user_entity(id),
                                       CONSTRAINT fk5q5av5arkm3of9b5n493p992p FOREIGN KEY (post_id) REFERENCES post_entity(id)
);

insert into my_user_entity (login, password, role) values ('user1', 123, 'ADMIN');
insert into my_user_entity (login, password, role) values ('user2', 123, 'USER');
insert into my_user_entity (login, password, role) values ('user3', 123, 'moderator');

insert into post_entity ("date", post_body, post_name, user_id) values ('08.03.2024 08:00', 'some admin text 1', 'header1a', 1);
insert into post_entity ("date", post_body, post_name, user_id) values ('09.03.2024 13:10', 'some user text 1', 'header1u', 2);
insert into post_entity ("date", post_body, post_name, user_id) values ('09.03.2024 14:15', 'some user text 2', 'header2u', 2);
insert into post_entity ("date", post_body, post_name, user_id) values ('11.03.2024 17:30', 'some user text 3', 'header3u', 2);
insert into post_entity ("date", post_body, post_name, user_id) values ('09.03.2024 22:10', 'some moderator text 1', 'header1m', 3);


insert into comment_entity (comment, user_id, post_id) values ('comment1', 2, 2);
insert into comment_entity (comment, user_id, post_id) values ('comment2', 2, 1);
insert into comment_entity (comment, user_id, post_id) values ('comment3', 2, 3);
