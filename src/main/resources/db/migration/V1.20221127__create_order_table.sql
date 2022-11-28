create table order_entity {
    id INT primary key,
    create_at TIMESTAMP not null
}

create table order_product {
    id INT primary key,
    product_id varchar(100) not null,
    quantity INT not null,
    price FLOAT,
    order_id INT not null,
    FOREIGN KEY (order_id)
          REFERENCES order_entity (id)
}