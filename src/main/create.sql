CREATE TABLE IF NOT EXISTS product (
    id int,
    name varchar(25),
    description varchar(256),
    price float,
    type varchar(1)
);

INSERT INTO product (
                     id,
                     name,
                     description,
                     price
                     ) VALUES (
                               '01',
                               'Plain T-shirt',
                               'Color: white',
                               '99,99'
                              );