/*Populated hobbit*/
INSERT INTO hobbits (id, first_Name, last_Name ) VALUES (1, 'Frodo', 'Baggins');
INSERT INTO hobbits (id, first_Name, last_Name ) VALUES (2, 'Bilbo', 'Baggins');
INSERT INTO hobbits (id, first_Name, last_Name ) VALUES (3, 'Penelope', 'Baggins');
/*Populated user, userprofile*/
INSERT INTO profiles (id, birth, phone) VALUE (1, '1022-09-17', '123455');
INSERT INTO profiles (id, birth, phone) VALUE (2, '1546-09-17', '765866');

INSERT INTO users (id, first_name, last_name, user_profile_id) VALUE (1, 'Frodo', 'Baggins', 1);
INSERT INTO users (id, first_name, last_name, user_profile_id) VALUE (2, 'Bilbo', 'Baggins', 2);