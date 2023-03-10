DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings
(
    id              BIGSERIAL,
    user_id         BIGINT,
    person_count    INTEGER NOT NULL,
    room_type_id    INTEGER NOT NULL,
    stay_time_start DATE    NOT NULL,
    stay_time_end   DATE    NOT NULL,
    booking_date    TIMESTAMP    NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (room_type_id) REFERENCES room_types (id)
);

INSERT INTO bookings (user_id, person_count, room_type_id, stay_time_start, stay_time_end,
                     booking_date)
VALUES (2, 3, 1, '2023-01-22', '2023-01-27', '2023-01-20 19:10:25');
