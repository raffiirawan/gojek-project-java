CREATE DATABASE IF NOT EXISTS gojek_app;
USE gojek_app;

DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    saldo DECIMAL(10,2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    pickup_location VARCHAR(255),
    destination VARCHAR(255),
    vehicle_type VARCHAR(50) NOT NULL,
    fare DECIMAL(10,2),
    status ENUM('pending', 'completed', 'cancelled') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (username, email, password, saldo)
VALUES
    ('demo_user', 'demo@example.com', 'password123', 150000.00);

INSERT INTO transactions (user_id, pickup_location, destination, vehicle_type, fare, status)
VALUES
    (1, 'Jl. Merdeka No.1', 'Mall Grand Indonesia', 'GoRide', 25000.00, 'completed'),
    (1, 'Kantor Pusat', 'Bandara Soekarno-Hatta', 'GoCar', 120000.00, 'completed');
