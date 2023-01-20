DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users
(
    id         SERIAL,
    first_name CHARACTER VARYING(25)  NOT NULL,
    last_name  CHARACTER VARYING(25)  NOT NULL,
    login      CHARACTER VARYING(25)  NOT NULL UNIQUE,
    password   CHARACTER VARYING(100) NOT NULL,
    email      CHARACTER VARYING(30)  NOT NULL,
    birth_date       DATE                   NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (first_name, last_name, login, password, email, birth_date)
VALUES ('admin', 'admin', 'admin', '$2a$05$sMCxkxnvPTeXSAqFG8IiW.2w.Gie/NPli.zpnRcZLX17hc254mIOm',
        'admin@admin', '2007-11-11');

INSERT INTO users (first_name, last_name, login, password, email, birth_date)
VALUES ('manager', 'manager', 'manager', '$2a$05$ieDTzIMI/SGPpqpcaZY4TunKDBTV.mce5Ih7rmm2YWFw7jIYe6vFO',
        'manager@manager', '2007-11-11');

INSERT INTO users (first_name, last_name, login, password, email, birth_date)
VALUES ('user', 'user', 'user', '$2a$05$iokZ0qcOD6iTURnPAnnDte6q9D4M.BGop.ykYCBkNUIfVz5e6789u',
        'user@user', '2007-11-11');
