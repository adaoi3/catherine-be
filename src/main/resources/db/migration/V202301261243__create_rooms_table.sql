DROP TABLE IF EXISTS rooms;

CREATE TABLE rooms
(
    id              BIGSERIAL,
    person_count    INTEGER NOT NULL,
    room_type_id    INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (room_type_id) REFERENCES room_types (id)
);

INSERT INTO rooms (person_count, room_type_id)
VALUES (2, 3);
