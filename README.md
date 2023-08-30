# ShopOnline
Assignment_PRJ301
Database 
drop DATABASE shop_online;
CREATE DATABASE shop_online;
use shop_online;

CREATE TABLE admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE seller (
    seller_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    company_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    status BIT(1) DEFAULT 0
);

CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    img TEXT,
    price INT UNSIGNED  NOT NULL,
    quantity INT NOT NULL,
    quantity_sold INT UNSIGNED DEFAULT 0,
    category_id INT,
    seller_id INT,
    FOREIGN KEY (category_id) REFERENCES Category(category_id),
    FOREIGN KEY (seller_id) REFERENCES seller(seller_id)
);

CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    customer_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    status BIT(1) DEFAULT 0
);

CREATE TABLE shopping_cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE cart_item (
    cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
    cart_id INT,
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES shopping_cart(cart_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE order_table (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'pending',
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE order_item (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_table(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    customer_id INT,
    rating INT NOT NULL,
    comment TEXT,
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE discount (
  id INT NOT NULL AUTO_INCREMENT,
  code VARCHAR(255) NOT NULL,
  discount_amount INT,
  discount_percent DECIMAL(10,2),
  valid_from DATE NOT NULL,
  valid_to DATE NOT NULL,
  PRIMARY KEY (id)
);

-- Chèn giá trị vào bảng admin
INSERT INTO admin (username, password) VALUES ('admin1', 'password1');
INSERT INTO admin (username, password) VALUES ('admin2', 'password2');
INSERT INTO admin (username, password) VALUES ('admin3', 'password3');
INSERT INTO admin (username, password) VALUES ('admin4', 'password4');
INSERT INTO admin (username, password) VALUES ('admin5', 'password5');

-- Chèn giá trị vào bảng seller
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller1', 'password1', 'Company A', 'seller1@example.com', 1);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller2', 'password2', 'Company B', 'seller2@example.com', 0);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller3', 'password3', 'Company C', 'seller3@example.com', 1);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller4', 'password4', 'Company D', 'seller4@example.com', 0);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller5', 'password5', 'Company E', 'seller5@example.com', 1);

-- Chèn giá trị vào bảng Category
INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Clothing');
INSERT INTO category (name) VALUES ('Furniture');
INSERT INTO category (name) VALUES ('Books');
INSERT INTO category (name) VALUES ('Beauty');

-- Chèn giá trị vào bảng product
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Phone A', 'A great smartphone', 'img/phoneA.jpg', 500, 100, 1, 1);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Shirt B', 'Comfortable shirt', 'img/shirtB.jpg', 30, 200, 2, 2);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Sofa', 'Elegant sofa', 'img/sofa.jpg', 800, 50, 3, 3);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Book X', 'Bestseller novel', 'img/bookX.jpg', 15, 1000, 4, 4);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Perfume Y', 'Luxurious fragrance', 'img/perfumeY.jpg', 100, 300, 5, 5);

-- Chèn giá trị vào bảng customer
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer1', 'password1', 'Customer One', 'customer1@example.com', '123 Main St', 1);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer2', 'password2', 'Customer Two', 'customer2@example.com', '456 Elm St', 0);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer3', 'password3', 'Customer Three', 'customer3@example.com', '789 Oak St', 1);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer4', 'password4', 'Customer Four', 'customer4@example.com', '101 Pine St', 0);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer5', 'password5', 'Customer Five', 'customer5@example.com', '202 Maple St', 1);

-- Chèn giá trị vào bảng shopping_cart
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (1, 1);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (2, 2);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (3, 3);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (4, 4);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (5, 5);

-- Chèn giá trị vào bảng cart_item
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (1, 1, 2);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (2, 2, 3);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (3, 3, 1);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (4, 4, 2);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (5, 5, 1);

-- Chèn giá trị vào bảng order_table
INSERT INTO order_table (customer_id, total_amount, status) VALUES (1, 100, 'pending');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (2, 150, 'completed');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (3, 80, 'pending');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (4, 200, 'processing');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (5, 50, 'completed');

-- Chèn giá trị vào bảng order_item
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 1, 2);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 2, 3);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (3, 3, 1);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (4, 4, 2);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (5, 5, 1);

-- Chèn giá trị vào bảng review
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (1, 1, 4, 'Great phone!');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (2, 2, 5, 'Excellent shirt!');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (3, 3, 3, 'Nice sofa');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (4, 4, 4, 'Enjoyed the book');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (5, 5, 5, 'Lovely perfume');

-- Chèn giá trị vào bảng discount
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('DISCOUNT10', 10, NULL, '2023-08-01', '2023-08-31');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('SUMMER20', NULL, 20, '2023-07-01', '2023-09-30');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('FALL15', 15, NULL, '2023-09-15', '2023-11-30');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('HOLIDAY25', 25, NULL, '2023-12-01', '2023-12-31');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('SPRING10', 10, NULL, '2024-03-01', '2024-05-31');

-- Chèn giá trị vào bảng admin
INSERT INTO admin (username, password) VALUES ('admin6', 'password6');
INSERT INTO admin (username, password) VALUES ('admin7', 'password7');
INSERT INTO admin (username, password) VALUES ('admin8', 'password8');
INSERT INTO admin (username, password) VALUES ('admin9', 'password9');
INSERT INTO admin (username, password) VALUES ('admin10', 'password10');

-- Chèn giá trị vào bảng seller
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller6', 'password6', 'Company F', 'seller6@example.com', 1);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller7', 'password7', 'Company G', 'seller7@example.com', 0);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller8', 'password8', 'Company H', 'seller8@example.com', 1);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller9', 'password9', 'Company I', 'seller9@example.com', 0);
INSERT INTO seller (username, password, company_name, email, status) VALUES ('seller10', 'password10', 'Company J', 'seller10@example.com', 1);

-- Chèn giá trị vào bảng Category
INSERT INTO category (name) VALUES ('Appliances');
INSERT INTO category (name) VALUES ('Toys');
INSERT INTO category (name) VALUES ('Jewelry');
INSERT INTO category (name) VALUES ('Sporting Goods');
INSERT INTO category (name) VALUES ('Home Decor');

-- Chèn giá trị vào bảng product
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Microwave', 'High-quality microwave', 'img/microwave.jpg', 150, 80, 6, 6);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Toy Car', 'Remote-controlled car', 'img/toyCar.jpg', 25, 150, 7, 7);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Necklace', 'Elegant necklace', 'img/necklace.jpg', 200, 40, 8, 8);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Soccer Ball', 'Official soccer ball', 'img/soccerBall.jpg', 20, 100, 9, 9);
INSERT INTO product (name, description, img, price, quantity, category_id, seller_id) VALUES ('Candle Holder', 'Decorative candle holder', 'img/candleHolder.jpg', 10, 250, 10, 10);

-- Chèn giá trị vào bảng customer
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer6', 'password6', 'Customer Six', 'customer6@example.com', '303 Willow St', 1);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer7', 'password7', 'Customer Seven', 'customer7@example.com', '404 Birch St', 0);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer8', 'password8', 'Customer Eight', 'customer8@example.com', '505 Cedar St', 1);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer9', 'password9', 'Customer Nine', 'customer9@example.com', '606 Pine St', 0);
INSERT INTO customer (username, password, customer_name, email, address, status) VALUES ('customer10', 'password10', 'Customer Ten', 'customer10@example.com', '707 Maple St', 1);

-- Chèn giá trị vào bảng shopping_cart
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (6, 6);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (7, 7);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (8, 8);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (9, 9);
INSERT INTO shopping_cart (cart_id, customer_id) VALUES (10, 10);

-- Chèn giá trị vào bảng cart_item
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (6, 6, 3);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (7, 7, 2);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (8, 8, 1);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (9, 9, 4);
INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (10, 10, 2);

-- Chèn giá trị vào bảng order_table
INSERT INTO order_table (customer_id, total_amount, status) VALUES (6, 75, 'processing');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (7, 50, 'completed');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (8, 120, 'pending');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (9, 95, 'completed');
INSERT INTO order_table (customer_id, total_amount, status) VALUES (10, 30, 'processing');

-- Chèn giá trị vào bảng order_item
INSERT INTO order_item (order_id, product_id, quantity) VALUES (6, 6, 2);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (7, 7, 3);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (8, 8, 1);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (9, 9, 2);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (10, 10, 1);

-- Chèn giá trị vào bảng review
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (6, 6, 4, 'Good microwave');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (7, 7, 5, 'Awesome toy car');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (8, 8, 3, 'Nice necklace');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (9, 9, 4, 'Great soccer ball');
INSERT INTO review (product_id, customer_id, rating, comment) VALUES (10, 10, 5, 'Beautiful candle holder');

-- Chèn giá trị vào bảng discount
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('DISCOUNT20', 20, NULL, '2024-01-01', '2024-01-31');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('SPRING25', 25, NULL, '2024-04-01', '2024-04-30');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('SUMMER15', 15, NULL, '2024-06-01', '2024-06-30');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('FALL10', 10, NULL, '2024-09-01', '2024-09-30');
INSERT INTO discount (code, discount_amount, discount_percent, valid_from, valid_to) VALUES ('WINTER30', 30, NULL, '2024-12-01', '2024-12-31');

select * from customer;
