INSERT INTO users (login, mail, first_name, middle_name, last_name, passwd) VALUES ('maskimko', 'maskimko@ukr.net', 'Maksym', 'Mykolayovych', 'Shkolnyi', 'pass');
INSERT INTO users (login, mail, first_name, middle_name, last_name, passwd) VALUES ('some1', 'some1@foo.bar.com.ua', 'John', 'Sebastian', 'Smith', 'pass');
INSERT INTO roles (name, description) VALUES ('administrator', 'Administrator users have extended privileges');
INSERT INTO roles (name, description) values ('customer', 'Regular user');
INSERT INTO device (description, mac_address, model, owner_id) VALUES ( 'Test device', '300', 'model', '1');

