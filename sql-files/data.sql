

-- Insert sample product data into products table

ç

INSERT INTO products (
    product_id, product_name, description, price, discounted_price, quantity_available, date_added, live, in_stock, product_image_name
) VALUES (
             '123e4567-e89b-12d3-a456-426614174001',
             'Samsung Galaxy S24 Ultra',
             'Flagship Samsung Galaxy S24 Ultra with Snapdragon processor.',
             1299.99,
             1199.99,
             30,
             CURRENT_TIMESTAMP,
             TRUE,
             TRUE,
             'galaxyS24ultra.png'
         );

INSERT INTO products (
    product_id, product_name, description, price, discounted_price, quantity_available, date_added, live, in_stock, product_image_name
) VALUES (
             '223e4567-e89b-12d3-a456-426614174002',
             'Sony WH-1000XM5',
             'Noise-canceling wireless headphones from Sony.',
             399.99,
             349.99,
             100,
             CURRENT_TIMESTAMP,
             TRUE,
             TRUE,
             'sony_wh1000xm5.png'
         );

INSERT INTO products (
    product_id, product_name, description, price, discounted_price, quantity_available, date_added, live, in_stock, product_image_name
) VALUES (
             '323e4567-e89b-12d3-a456-426614174003',
             'Dell XPS 15',
             'Dell XPS 15 Laptop with Intel i7 and 16GB RAM.',
             1899.99,
             1699.99,
             20,
             CURRENT_TIMESTAMP,
             TRUE,
             TRUE,
             'dellxps15.png'
         );

INSERT INTO products (
    product_id, product_name, description, price, discounted_price, quantity_available, date_added, live, in_stock, product_image_name
) VALUES (
             '423e4567-e89b-12d3-a456-426614174004',
             'Apple Watch Series 9',
             'Apple Watch with new health monitoring features.',
             499.99,
             449.99,
             75,
             CURRENT_TIMESTAMP,
             TRUE,
             TRUE,
             'applewatch9.png'
         );
