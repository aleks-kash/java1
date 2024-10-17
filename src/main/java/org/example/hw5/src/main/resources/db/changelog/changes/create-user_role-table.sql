--liquibase formatted sql
--changeset alex-kash:create-user_role-table

CREATE TABLE user_role (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,

    CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES user (user_id),
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES role (role_id),
    CONSTRAINT uc_user_role UNIQUE (user_id, role_id)
);

--rollback DROP TABLE user_role;