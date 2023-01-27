DROP TABLE IF EXISTS room_types CASCADE;

CREATE TABLE room_types
(
    id   SERIAL,
    name CHARACTER VARYING(25) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO room_types (name)
VALUES ('STANDARD'),
       ('DELUXE'),
       ('SUITE');
