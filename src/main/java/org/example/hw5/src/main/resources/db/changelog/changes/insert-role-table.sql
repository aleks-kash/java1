--liquibase formatted sql
--changeset alex-kash:insert-role-table

INSERT INTO `role` (role_name) VALUES ('admin');
INSERT INTO `role` (role_name) VALUES ('user');

--rollback DELETE FROM roles WHERE id = 2;
