INSERT INTO "role"(id,role_name) VALUES (1,'admin');
INSERT INTO "role"(id,role_name) VALUES (2,'client');

INSERT INTO "user"(id,username,password,email,created,updated,role_id) VALUES (1,'admin','$2a$10$twBO7G9nNZ1PGD93JzrOWuk5ZQP5OVGkozUN9OJ/fxpJek7moTDO2',
                                                                             'admin@gmail.com','2021-05-05 15:56:39','2021-05-05 15:56:39',1);

INSERT INTO "user"(id,username,password,email,created,updated,role_id) VALUES (2,'client','$2a$10$NtOOCOOy0tYaXyuzl6UA1eoKDMY8bioZatd7xWeGJ1LQkKgmYaiF2',
                                                                             'client@gmail.com','2021-05-05 15:56:39','2021-05-05 15:56:39',2);

INSERT INTO permission(id, permission_name) VALUES (1, 'read_user');
INSERT INTO permission(id, permission_name) VALUES (2, 'insert_user');

INSERT INTO role_permission(role_id, permission_id) VALUES(1,1);
INSERT INTO role_permission(role_id, permission_id) VALUES(1,2);
INSERT INTO role_permission(role_id, permission_id) VALUES(2,1);