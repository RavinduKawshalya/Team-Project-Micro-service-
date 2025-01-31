CREATE DATABASE event_scheduling;

USE event_scheduling;

CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    date DATE NOT NULL,
    location VARCHAR(150) NOT NULL,
    budget DECIMAL(10, 2)
);
