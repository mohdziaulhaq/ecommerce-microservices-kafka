CREATE TABLE IF NOT EXISTS products (
                                        product_id CHAR(36) PRIMARY KEY,
    product_name VARCHAR(255),
    description VARCHAR(10000),
    price DOUBLE,
    discounted_price DOUBLE,
    quantity_available BIGINT,
    date_added TIMESTAMP,
    live BOOLEAN,
    in_stock BOOLEAN,
    product_image_name VARCHAR(255)
    );