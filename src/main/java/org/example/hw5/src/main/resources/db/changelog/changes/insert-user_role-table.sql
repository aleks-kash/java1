--liquibase formatted sql
--changeset alex-kash:insert-user_role-table

INSERT INTO `user_role` VALUES (1,2);
INSERT INTO `user_role` VALUES (2, 1);

--rollback DROP TABLE user_role;