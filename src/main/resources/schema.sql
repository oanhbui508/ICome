CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         price DECIMAL NOT NULL,
                         brand VARCHAR(50),
                         color VARCHAR(20)
);

CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100),
                          facebook_id VARCHAR(100) UNIQUE
);

CREATE TABLE activity_log (
                              id SERIAL PRIMARY KEY,
                              customer_id INTEGER REFERENCES customer(id),
                              activity TEXT,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cart (
                      id SERIAL PRIMARY KEY,
                      customer_id INTEGER REFERENCES customer(id)
);

CREATE TABLE cart_item (
                           id SERIAL PRIMARY KEY,
                           cart_id INTEGER REFERENCES cart(id),
                           product_id INTEGER REFERENCES product(id),
                           quantity INTEGER NOT NULL
);
