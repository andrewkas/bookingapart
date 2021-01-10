INSERT INTO m_role (id, role_name) VALUES (3, 'ROLE_ADMIN');
INSERT INTO m_role (id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO m_role (id, role_name) VALUES (2, 'ROLE_MODERATOR');

INSERT INTO m_user (id, name, surname, e_mail, birth_date, created, changed, login, password, gender, role_id) VALUES (9, 'Vasya', 'Pupkin', 'string@mail.ru', '2020-12-28', '2020-12-29 00:13:53.797000', '2020-12-29 00:13:53.797000', 'loginVasya', '$2a$10$ib7FYTTcWf0FR1g9K8d7oem9apNJgKNoAOswHmN4HMLPn0w4.4OMW', 'MALE', 1);
INSERT INTO m_user (id, name, surname, e_mail, birth_date, created, changed, login, password, gender, role_id) VALUES (13, 'Valya', 'Pekun', 'valya@mail.ru', '1994-12-14', '2020-12-29 00:13:53.797000', '2020-12-29 00:13:53.797000', 'loginValya', '$2a$10$ib7FYTTcWf0FR1g9K8d7oem9apNJgKNoAOswHmN4HMLPn0w4.4OMW', 'FEMALE', 1);
INSERT INTO m_user (id, name, surname, e_mail, birth_date, created, changed, login, password, gender, role_id) VALUES (14, 'Rostik', 'Rostkov', 'rosti@mail.ru', '2000-06-28', '2020-12-29 00:13:53.797000', '2020-12-29 00:13:53.797000', 'loginRostix', '$2a$10$ib7FYTTcWf0FR1g9K8d7oem9apNJgKNoAOswHmN4HMLPn0w4.4OMW', 'MALE', 1);
INSERT INTO m_user (id, name, surname, e_mail, birth_date, created, changed, login, password, gender, role_id) VALUES (15, 'Liliya', 'Basanova', 'lilu@google.com', '1998-01-08', '2021-01-03 11:13:14.000000', '2021-01-03 11:13:17.000000', 'loginLilu', '$2a$10$ib7FYTTcWf0FR1g9K8d7oem9apNJgKNoAOswHmN4HMLPn0w4.4OMW', 'FEMALE', 1);
INSERT INTO m_user (id, name, surname, e_mail, birth_date, created, changed, login, password, gender, role_id) VALUES (16, 'Leonid', 'Rushev', 'lyonia@google.com', '1998-01-06', '2021-01-03 11:13:14.000000', '2021-01-03 11:13:17.000000', 'loginLeonid', '$2a$10$ib7FYTTcWf0FR1g9K8d7oem9apNJgKNoAOswHmN4HMLPn0w4.4OMW', 'MALE', 1);
INSERT INTO m_user (id, name, surname, e_mail, birth_date, created, changed, login, password, gender, role_id) VALUES (21, 'Natalia', 'Cassandra', 'email@mail.ru', '2021-01-10', '2021-01-10 10:37:56.328000', '2021-01-10 10:37:56.328000', 'loginNata', '$2a$10$fsXXIdwwczETOWadK/yvLunMTxHOOFTroyjRD3eMkv.xLTbMQft9.', 'FEMALE', 1);

INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (7, 'Seri', 'Verter', '+3456789342', 'str@mail.ru', '2020-12-29 22:13:49.962000', '2020-12-29 22:13:49.962000', 'loginSeri', '$2a$10$uqsCr9tPJItbAR7X2GV24u7PAgCGpnZlfZ1tSvI.Cull9F3UMTVAe', 2);
INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (6, 'Riki', 'Tiki', '+3752999999', 'riki@mail.ru', '2020-12-26 23:49:08.325000', '2020-12-26 23:49:08.325000', 'loginRiki', '$2a$10$uqsCr9tPJItbAR7X2GV24u7PAgCGpnZlfZ1tSvI.Cull9F3UMTVAe', 2);
INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (5, 'Dimas', 'Malikov', '+375298765423', 'dimal@mail.ru', '2020-12-26 22:38:15.105000', '2020-12-26 22:38:15.105000', 'loginDima', '$2a$10$uqsCr9tPJItbAR7X2GV24u7PAgCGpnZlfZ1tSvI.Cull9F3UMTVAe', 2);
INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (3, 'Fedya', 'Hirsh', '+375298765432', 'fedya@mail.ru', '2020-12-16 22:01:15.000000', '2020-12-16 22:01:18.000000', 'loginFedya', '$2a$10$uqsCr9tPJItbAR7X2GV24u7PAgCGpnZlfZ1tSvI.Cull9F3UMTVAe', 2);
INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (2, 'Kiril', 'Nemanov', '+375335552211', 'kir@tut.by', '2020-12-16 22:00:06.000000', '2020-12-16 22:00:11.000000', 'loginKiril', '$2a$10$uqsCr9tPJItbAR7X2GV24u7PAgCGpnZlfZ1tSvI.Cull9F3UMTVAe', 2);
INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (8, 'Andrew', 'Kas', '+375297625142', 'c_a_s@list.ru', '2021-01-08 09:32:57.589000', '2021-01-08 09:32:57.589000', 'loginAndrew', '$2a$10$GpIVvlZW3p/yraJ6IbEKBeFHqhdDCsSOVBYcGA90Cz/yMf8GnDg0i', 3);
INSERT INTO m_landlord (id, name, surname, phone, e_mail, created, changed, login, password, role_id) VALUES (9, 'Vera', 'Kobleva', '+375296762345', 'vera@tut.by', '2020-12-16 22:00:06.000000', '2020-12-16 22:00:11.000000', 'loginVera', '$2a$10$uqsCr9tPJItbAR7X2GV24u7PAgCGpnZlfZ1tSvI.Cull9F3UMTVAe', 2);

INSERT INTO m_address (id, country, city, location) VALUES (4, 'BELARUS', 'MINSK', 'Horuzhei str. 54');
INSERT INTO m_address (id, country, city, location) VALUES (1, 'BELARUS', 'HRODNA', 'Sovietskaya str.');
INSERT INTO m_address (id, country, city, location) VALUES (2, 'BELARUS', 'MINSK', 'Nezavisimosti aven.64');
INSERT INTO m_address (id, country, city, location) VALUES (3, 'RUSSIA', 'MOSCOW', 'Novyj Arbat aven.43');
INSERT INTO m_address (id, country, city, location) VALUES (5, 'UKRAINE', 'KYIV', 'Hreschatyk str. 5');

INSERT INTO m_apart (id, type, apart_name, address_id, guest_number, area, cost_per_day, landlord_id, status, created, changed) VALUES (5, 'BASEMENT_APART', 'Drug', 1, 4, 50, 40, 6, 'AVAILABLE', '2021-01-09 20:57:19.000000', '2021-01-09 20:57:22.000000');
INSERT INTO m_apart (id, type, apart_name, address_id, guest_number, area, cost_per_day, landlord_id, status, created, changed) VALUES (3, 'LOFT_APART', 'hata', 5, 4, 78, 110, 7, 'AVAILABLE', '2020-12-16 22:11:24.000000', '2020-12-16 22:11:28.000000');
INSERT INTO m_apart (id, type, apart_name, address_id, guest_number, area, cost_per_day, landlord_id, status, created, changed) VALUES (1, 'COMMUNAL_APART', 'u_babuli', 3, 2, 15, 200, 2, 'AVAILABLE', '2020-12-16 22:11:24.000000', '2020-12-16 22:11:28.000000');
INSERT INTO m_apart (id, type, apart_name, address_id, guest_number, area, cost_per_day, landlord_id, status, created, changed) VALUES (2, 'STUDIO', '12poverh', 2, 3, 56, 90, 3, 'AVAILABLE', '2020-12-16 22:11:24.000000', '2020-12-16 22:11:28.000000');
INSERT INTO m_apart (id, type, apart_name, address_id, guest_number, area, cost_per_day, landlord_id, status, created, changed) VALUES (4, 'PENTHOUSE', 'VEronika', 4, 6, 150, 150, 8, 'AVAILABLE', '2021-01-09 20:55:11.000000', '2021-01-09 20:55:17.000000');


INSERT INTO m_additionally (id, additionally) VALUES (4, 'TV_SET');
INSERT INTO m_additionally (id, additionally) VALUES (2, 'TERRASE');
INSERT INTO m_additionally (id, additionally) VALUES (3, 'WIFI');
INSERT INTO m_additionally (id, additionally) VALUES (18, 'PHONE');

INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (2, 1, 2);
INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (3, 1, 3);
INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (5, 2, 2);
INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (7, 3, 2);
INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (8, 3, 3);
INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (9, 4, 2);
INSERT INTO l_apart_additionally (id, apart_id, additionally_id) VALUES (10, 4, 4);

INSERT INTO m_booking (id, apart_id, user_id, date_from, date_to, price, created, changed) VALUES (4, 5, 9, '2021-01-10', '2021-01-13', 120, '2021-01-10 16:07:56.682000', '2021-01-10 16:07:56.701000');