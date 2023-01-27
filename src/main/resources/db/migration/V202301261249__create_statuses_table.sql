CREATE TABLE statuses
(
    id   SERIAL,
    name CHARACTER VARYING(25) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO statuses (name)
VALUES ('PENDING'),
       ('BOOKED'),
       ('DECLINED');
