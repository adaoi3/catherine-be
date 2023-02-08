UPDATE rooms
SET capacity = 2,
    room_type_id = 1
WHERE id = 1;

INSERT INTO rooms (capacity, room_type_id)
VALUES (2, 1),
       (2, 1),
       (2, 1),
       (3, 2),
       (3, 2),
       (3, 2),
       (3, 2),
       (4, 2),
       (4, 2),
       (4, 2),
       (4, 2),
       (5, 3),
       (5, 3),
       (5, 3),
       (5, 3);
