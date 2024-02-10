CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    stock NUMERIC,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);