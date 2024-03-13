CREATE TABLE my_user_entity (
                                id serial4 NOT NULL,
                                login varchar(50) NULL,
                                "password" varchar(255) NULL,
                                "role" varchar(50) NULL
);

CREATE TABLE post_entity (
                             id serial4 NOT NULL,
                             "date" date NULL,
                             post_body varchar(255) NULL,
                             post_name varchar(255) NULL,
                             user_id int4 NULL
);

CREATE TABLE comment_entity (
                                id serial4 NOT NULL,
                                "comment" varchar(255) NULL,
                                "date" date NULL,
                                like_count int4 NULL,
                                user_id int4 NULL,
                                post_id int4 NULL
);

insert into my_user_entity (login, password, role) values ('user1', '$e0801$V2wciHt3y2pd0UY2qWPaoLYwyQ+P9kpxwlNvJy8RsRJEjO9DpBWNct+hochy7B24E7mmLaR1bxt+RGnw1lQIaQ==$xG+9ozP4+mfH7d7ounzmNMOWpQn22VRXaHvWFwuBuCE=', 'ADMIN');
insert into my_user_entity (login, password, role) values ('user2', '$e0801$V2wciHt3y2pd0UY2qWPaoLYwyQ+P9kpxwlNvJy8RsRJEjO9DpBWNct+hochy7B24E7mmLaR1bxt+RGnw1lQIaQ==$xG+9ozP4+mfH7d7ounzmNMOWpQn22VRXaHvWFwuBuCE=', 'USER');
insert into my_user_entity (login, password, role) values ('user3', '$e0801$V2wciHt3y2pd0UY2qWPaoLYwyQ+P9kpxwlNvJy8RsRJEjO9DpBWNct+hochy7B24E7mmLaR1bxt+RGnw1lQIaQ==$xG+9ozP4+mfH7d7ounzmNMOWpQn22VRXaHvWFwuBuCE=', 'MODERATOR');

insert into post_entity (date, post_body, post_name, user_id) values ('2024-03-09', 'some admin text 1', 'header1a', 1);
insert into post_entity (date, post_body, post_name, user_id) values ('2024-03-09', 'some user text 1', 'header1u', 2);
insert into post_entity (date, post_body, post_name, user_id) values ('2024-03-08', 'some user text 2', 'header2u', 2);
insert into post_entity (date, post_body, post_name, user_id) values ('2024-03-10', 'some user text 3', 'header3u', 2);
insert into post_entity (date, post_body, post_name, user_id) values ('2024-03-09', 'some moderator text 1', 'header1m', 3);


insert into comment_entity (comment, date, like_count, user_id, post_id) values ('comment1','2024-03-11',0, 2, 2);
insert into comment_entity (comment, date, like_count, user_id, post_id) values ('comment2','2024-03-12',0, 2, 1);
insert into comment_entity (comment, date, like_count, user_id, post_id) values ('comment3','2024-03-11',0, 2, 3);

update comment_entity set like_count=(like_count+1) where id = 1;
update comment_entity set like_count=(like_count+1) where id = 1;
update comment_entity set like_count=(like_count+1) where id = 1;
update comment_entity set like_count=(like_count+1) where id = 2;
update comment_entity set like_count=(like_count+1) where id = 3;
update comment_entity set like_count=(like_count+1) where id = 3;