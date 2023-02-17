ALTER TABLE bookings
    ADD CONSTRAINT bookings_admin_id_fkey FOREIGN KEY (admin_id) REFERENCES users (id);

ALTER TABLE bookings
    ADD CONSTRAINT bookings_room_id_fkey FOREIGN KEY (room_id) REFERENCES rooms (id);
