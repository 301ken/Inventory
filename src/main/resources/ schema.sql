CREATE TABLE category (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DOUBLE NOT NULL,
                         category_id BIGINT,
                         FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE inventory (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           stockLevel INT NOT NULL,
                           product_id BIGINT,
                           FOREIGN KEY (product_id) REFERENCES product(id)
);
