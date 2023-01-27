DROP TABLE IF EXISTS public.users_roles;

CREATE TABLE users_roles
(
    user_id BIGINT REFERENCES users (id),
    role_id INTEGER REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO users_roles
VALUES (1, 1),
       (2, 2);
