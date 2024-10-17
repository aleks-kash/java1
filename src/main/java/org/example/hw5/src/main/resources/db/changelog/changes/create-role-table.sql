--liquibase formatted sql
--changeset alex-kash:create-role-table
CREATE TABLE role (
    role_id BIGINT NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(255),

    PRIMARY KEY (role_id)
) ENGINE=InnoDB;


--rollback DROP TABLE roles;