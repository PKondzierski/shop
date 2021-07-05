INSERT INTO "role"(id,role_name) VALUES (1,'admin');
INSERT INTO "role"(id,role_name) VALUES (2,'client');
INSERT INTO "role"(id,role_name) VALUES (3,'shop assistant');

INSERT INTO "user"(id,username,password,email,created,updated,role_id) VALUES (1,'admin','$2a$10$twBO7G9nNZ1PGD93JzrOWuk5ZQP5OVGkozUN9OJ/fxpJek7moTDO2',
                                                                             'admin@gmail.com','2021-05-05 15:56:39','2021-05-05 15:56:39',1);
INSERT INTO "user"(id,username,password,email,created,updated,role_id) VALUES (2,'client','$2a$10$NtOOCOOy0tYaXyuzl6UA1eoKDMY8bioZatd7xWeGJ1LQkKgmYaiF2',
                                                                             'client@gmail.com','2021-05-05 15:56:39','2021-05-05 15:56:39',2);
INSERT INTO "user"(id,username,password,email,created,updated,role_id) VALUES (3,'shopAssistant','$2a$10$VhAMsTPiif6tgDmQut5nh.MLdid89EW6AUoK2Bp9YL6Mgpv35X35S',
                                                                               'shopAssistant@gmail.com','2021-05-07 19:51:39','2021-05-07 19:51:39',3);
INSERT INTO permission(id, permission_name) VALUES (1, 'read_user');
INSERT INTO permission(id, permission_name) VALUES (2, 'insert_user');
INSERT INTO permission(id, permission_name) VALUES (3, 'insert_product');
INSERT INTO permission(id, permission_name) VALUES (4, 'read_product');

INSERT INTO role_permission(role_id, permission_id) VALUES(1,1);
INSERT INTO role_permission(role_id, permission_id) VALUES(1,2);
INSERT INTO role_permission(role_id, permission_id) VALUES(1,3);
INSERT INTO role_permission(role_id, permission_id) VALUES(1,4);
INSERT INTO role_permission(role_id, permission_id) VALUES(2,4);
INSERT INTO role_permission(role_id, permission_id) VALUES(3,4);
INSERT INTO role_permission(role_id, permission_id) VALUES(3,3);

INSERT INTO product_class(id, name) VALUES(1,'smartphone');
INSERT INTO product_class(id, name) VALUES(2,'landline phone');
INSERT INTO product_class(id, name) VALUES(3,'monitor');

INSERT INTO product(id, name, created, updated, product_class_id, retail_price, wholesale_price, quantity, discount, image_path)
VALUES
(1,'Samsung Galaxy s20', '2021-05-08 16:54:39', '2021-05-08 20:54:39', 1, 3599.99, 3100.00, 5, 0,'Samsung_Galaxy_s20.png'),
(2,'Xiaomi Mi 11 Ultra', '2021-05-08 16:54:39', '2021-05-08 16:54:39', 1, 2299.99, 2000.00, 1, 15,'Xiaomi_M1_11_Ultra.png'),
(3,'Panasonic Dect KX-TG2512 PDM', '2021-05-08 16:54:39', '2021-05-08 16:54:39', 2, 139.99, 120.00, 10, 0,'Panasonic_Dect_KX-TG2512_PDM.png'),
(4,'Philips 328e1ca/00', '2021-05-08 16:54:39', '2021-05-08 16:54:39', 3, 1499.99, 1200.00, 2, 0,'philips_328e1ca00.png');

INSERT INTO category(id,name)
VALUES
(1,'Phones'),
(2,'Mobile phones'),
(3,'Smartphone'),
(4,'Landline phones'),
(5,'Peripheral devices'),
(6,'Monitors');

INSERT INTO product_category(product_id, category_id)
VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(3,1),
(3,4),
(4,5),
(4,6);

INSERT INTO specification(id,name)
VALUES
(1,'diagonal'),
(2,'weight'),
(3,'length'),
(4,'width'),
(5,'thickness'),
(6,'HDMI 2.0'),
(7,'DP 1.4'),
(8,'Type of device'),
(9,'Android');

INSERT INTO product_specification(product_id, specification_id, value_int, value_varchar, value_date)
VALUES
(1,1,6,'inch',null),
(1,2,250,'gram',null),
(1,3,240,'mm',null),
(1,4,100,'mm',null),
(1,5,20,'mm',null),
(1,8,null,'smartphone',null),
(1,9,10.1,null,null),
(2,1,5,'inch',null),
(2,2,220,'gram',null),
(2,3,230,'mm',null),
(2,4,80,'mm',null),
(2,5,15,'mm',null),
(2,8,null,'smartphone',null),
(2,9,8.0,null,null),
(3,2,900,'gram',null),
(3,3,40,'cm',null),
(3,4,20,'cm',null),
(3,5,20,'cm',null),
(3,8,null,'Corded phone',null),
(4,1,24,'inch',null),
(4,2,2,'kg',null),
(4,5,40,'mm',null),
(4,6,null,'TAK',null),
(4,7,null,'TAK',null),
(4,8,null,'Monitor',null);

INSERT INTO description(product_id, title, description, image_path, sequence_number)
VALUES
(1,'The biggest one','We offer you, the biggest smarthone that You can get. His size allow You to comfortable watch films.','Large_screen.png',1),
(1,'Intel core i5','First phone which provides the fastest processor availability on market','Intel_core_i5.png',2),
(2,'Intuitive menu','You will not be lost anytime while using our interface','Intuitive_menu.png',1),
(2,'High-capacity battery','Did you have any problems with your battery? With our new power managment system battery drain very slow.','high_capacity_battery.png',2),
(2,'High-capacity battery','Did you have any problems with your battery? With our new power managment system battery drain very slow.','high_capacity_battery.png',2),
(3,'Old fashion','Do you like old fashion phones? We introduce this type of phone with new technology inside','old_fashion.png',1),
(4,'Flicker-Free technology','Are you getting bored while watching screen? Flicker free technology will solve it!','flicker-free_technology.png',1);

INSERT INTO product_history(product_id, name, retail_price, wholesale_price, inserted) VALUES(1,'Galaxy s20',3799.99, 3100.00,'2021-05-08 20:54:39');

