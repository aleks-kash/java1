--liquibase formatted sql
--changeset alex-kash:insert-user-table

INSERT INTO `user` (user_name, user_email) VALUES ('Rick', 'rick683@gmail.com'),
                                         ('Morty', 'morty123@gmail.com');

--rollback DELETE FROM users WHERE id = 2;
