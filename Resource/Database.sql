CREATE DATABASE resource_booking;

USE resource_booking;

CREATE TABLE resources (
    id INT AUTO_INCREMENT PRIMARY KEY,
    resource_name VARCHAR(100) NOT NULL,
    resource_type ENUM('VENUE', 'EQUIPMENT', 'OTHER') NOT NULL,
    booking_date DATE NOT NULL
);

INSERT INTO resources (resource_name, resource_type, booking_date)
VALUES 
('Conference Room', 'VENUE', '2025-01-28'),
('Projector', 'EQUIPMENT', '2025-01-29'),
('Miscellaneous Items', 'OTHER', '2025-01-30');

SELECT * FROM resources;
