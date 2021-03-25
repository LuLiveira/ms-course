INSERT INTO user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO user (name, email, password) VALUES ('Lucas Silva', 'lcsd.lucas@gmail.com', '$2a$10$0zGth/Pje/fXsOdBTpPYSuAXUy7kEYCQ8GrmvwL8Sf65x.GvRYBei');

INSERT INTO role (name) VALUES ('ROLE_OPERATOR');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_x_role (user_id, role_id) VALUES (1, 1);

INSERT INTO user_x_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_x_role (user_id, role_id) VALUES (2, 2);

INSERT INTO user_x_role (user_id, role_id) VALUES (3, 1);