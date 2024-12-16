INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Groceries');

INSERT INTO product (name, price, category_id) VALUES ('Laptop', 1000.00, 1);
INSERT INTO product (name, price, category_id) VALUES ('Smartphone', 500.00, 1);
INSERT INTO product (name, price, category_id) VALUES ('Rice', 20.00, 2);

INSERT INTO inventory (stockLevel, product_id) VALUES (50, 1);
INSERT INTO inventory (stockLevel, product_id) VALUES (100, 2);
INSERT INTO inventory (stockLevel, product_id) VALUES (200, 3);
