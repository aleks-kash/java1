--liquibase formatted sql
--changeset alex-kash:create-user-table
CREATE TABLE user (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255),
    user_email VARCHAR(255),

    PRIMARY KEY (user_id)
) ENGINE=InnoDB;


--rollback DROP TABLE users;