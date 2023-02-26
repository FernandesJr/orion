INSERT INTO TB_ADDRESS (state, city, district, street, number, complement, cep) VALUES ('pernambuco', 'belo jardim', 'centro', 'floriano peixoto', 80, 'terreio', '55150-010');

INSERT INTO TB_ADDRESS (state, city, district, street, number, complement, cep) VALUES ('pernambuco', 'belo jardim', 'são pedro', 'josé welligton santos', 19, 'casa', '55155-380');
INSERT INTO TB_ADDRESS (state, city, district, street, number, complement, cep) VALUES ('pernambuco', 'belo jardim', 'centro', 'coronel assunção', 102, 'terreio', '55155-000');

INSERT INTO TB_CLINIC (cnpj, name, address_id) VALUES ('49.387.859-0001-94', 'ceslab', 1);

INSERT INTO TB_ROLE (authority) VALUES ('ROLE_ADMIN');
INSERT INTO TB_ROLE (authority) VALUES ('ROLE_DOCTOR');

INSERT INTO TB_USER (email, password, active) VALUES ('admin@orion.com', '123', 1);
INSERT INTO TB_USER (email, password, active) VALUES ('geovanna@orion.com', '123', 1);

INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 2);

INSERT INTO TB_CLINIC_USER(id_clinic, id_user) VALUES (1, 1);
INSERT INTO TB_CLINIC_USER(id_clinic, id_user) VALUES (1, 2);

INSERT INTO TB_PATIENT(cpf, name, date_birth, phone, clinic_id, address_id) VALUES ('109.854.034-46', 'gilberto fernandes', '1993-01-13', '81992213546', 1, 2);
INSERT INTO TB_PATIENT(cpf, name, date_birth, phone, clinic_id, address_id) VALUES ('123.456.789-11', 'joão da silva', '1994-04-08', '81999545874', 1, 3);
INSERT INTO TB_PATIENT(cpf, name, date_birth, phone, clinic_id, address_id) VALUES ('111.222.333-44', 'maria das dores', '1976-04-12', '81978542584', 1, 3);
