INSERT INTO TB_ROLE (authority) VALUES ('ROLE_ADMIN');
INSERT INTO TB_ROLE (authority) VALUES ('ROLE_DOCTOR');

INSERT INTO TB_USER (email, password, active) VALUES ('admin@orion.com', '123', 1);
INSERT INTO TB_USER (email, password, active) VALUES ('geovanna@orion.com', '123', 2);
INSERT INTO TB_USER (email, password, active) VALUES ('joao@orion.com', '123', 3);

INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 2);