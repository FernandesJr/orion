INSERT INTO TB_ADDRESS (state, city, district, street, number, complement, cep) VALUES ('pernambuco', 'belo jardim', 'centro', 'floriano peixoto', 80, 'terreio', '55150-010');

INSERT INTO TB_ADDRESS (state, city, district, street, number, complement, cep) VALUES ('pernambuco', 'belo jardim', 'são pedro', 'josé welligton santos', 19, 'casa', '55155-380');
INSERT INTO TB_ADDRESS (state, city, district, street, number, complement, cep) VALUES ('pernambuco', 'belo jardim', 'centro', 'coronel assunção', 102, 'terreio', '55155-000');

INSERT INTO TB_CLINIC (cnpj, name, address_id, active) VALUES ('49.387.859/0001-94', 'ceslab', 1, 1);

INSERT INTO TB_ROOM (clinic_id, number, start_appointments, finish_appointments, active) VALUES (1, 1, '06:00:00', '17:00:00', 1);
INSERT INTO TB_ROOM (clinic_id, number, start_appointments, finish_appointments, active) VALUES (1, 2, '06:00:00', '17:00:00', 1);

INSERT INTO TB_ROLE (authority) VALUES ('ROLE_ADMIN');
INSERT INTO TB_ROLE (authority) VALUES ('ROLE_DOCTOR');

INSERT INTO TB_USER (email, password, active) VALUES ('admin@orion.com', '$2a$10$hxTNhyNJCeli0j8vbxd0augO8xXWyoF8DTlKGe9AQnBzi160eYmeu', 1);
INSERT INTO TB_USER (email, password, active) VALUES ('geovanna@orion.com', '$2a$10$hxTNhyNJCeli0j8vbxd0augO8xXWyoF8DTlKGe9AQnBzi160eYmeu', 1);

INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 2);

INSERT INTO TB_CLINIC_USER(clinic_id, user_id) VALUES (1, 1);
INSERT INTO TB_CLINIC_USER(clinic_id, user_id) VALUES (1, 2);

INSERT INTO TB_PATIENT (cpf, name, date_birth, phone, clinic_id, address_id) VALUES ('109.854.034-46', 'gilberto fernandes', '1993-01-13', '81992213546', 1, 2);
INSERT INTO TB_PATIENT (cpf, name, date_birth, phone, clinic_id, address_id) VALUES ('123.456.789-11', 'joão da silva', '1994-04-08', '81999545874', 1, 3);
INSERT INTO TB_PATIENT (cpf, name, date_birth, phone, clinic_id, address_id) VALUES ('111.222.333-44', 'maria das dores', '1976-04-12', '81978542584', 1, 3);

INSERT INTO TB_SPECIALTY (title, description) VALUES ('citologista', null);
INSERT INTO TB_SPECIALTY (title, description) VALUES ('clínica geral', null);
INSERT INTO TB_SPECIALTY (title, description) VALUES ('nutrição', null);
INSERT INTO TB_SPECIALTY (title, description) VALUES ('psicologia', null);
INSERT INTO TB_SPECIALTY (title, description) VALUES ('ginecologia', null);

INSERT INTO TB_DOCTOR (name, council_number, user_id) VALUES ('geovanna samara', '13514', 2);

INSERT INTO TB_DOCTOR_SPECIALTY (doctor_id, specialty_id) VALUES (1, 1);

INSERT INTO TB_ADMIN (name, user_id) VALUES ('gilberto fernandes', 1);

INSERT INTO TB_SCHEDULING (start, finish, room_id, completed) VALUES ('2023-03-13T07:30:00', '2023-03-13T08:30:00', 1, false);
INSERT INTO TB_SCHEDULING (start, finish, room_id, completed) VALUES ('2023-03-13T13:30:00', '2023-03-13T08:30:00', 1, true);
INSERT INTO TB_SCHEDULING (start, finish, room_id, completed) VALUES ('2023-03-13T14:30:00', '2023-03-13T08:30:00', 1, true);

INSERT INTO TB_APPOINTMENT (doctor_id, patient_id, date, status, complaint_main ,anamnese, scheduling_id) VALUES (1, 3, TIMESTAMP WITH TIME ZONE '2023-02-27T15:50:07Z', 'appointment', 'Dores em tal parte do corpo','O paciente tem isso e aquilo', 1);
