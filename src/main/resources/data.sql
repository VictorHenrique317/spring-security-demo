INSERT INTO Roles(role) VALUES('ADMIN');
INSERT INTO Roles(role) VALUES('ADMIN_TRAINEE');
INSERT INTO Roles(role) VALUES('STUDENT');

INSERT INTO Authorities(authority) VALUES('student:read');
INSERT INTO Authorities(authority) VALUES('student:write');
INSERT INTO Authorities(authority) VALUES('course:read');
INSERT INTO Authorities(authority) VALUES('course:write');

INSERT INTO Users(username, password, role_id) VALUES('linda', '$2a$10$diycX9Eet/jG1GE/TZOZguuyDxOwTezYbl6fkqFwBQuXFhUnWq4n2', 1);
INSERT INTO Users(username, password, role_id) VALUES('tom', '$2a$10$diycX9Eet/jG1GE/TZOZguuyDxOwTezYbl6fkqFwBQuXFhUnWq4n2', 2);
INSERT INTO Users(username, password, role_id) VALUES('annasmith', '$2a$10$diycX9Eet/jG1GE/TZOZguuyDxOwTezYbl6fkqFwBQuXFhUnWq4n2', 3);

INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(1, 1);
INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(1, 2);
INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(1, 3);
INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(1, 4);

INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(2, 1);
INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(2, 3);

INSERT INTO Authorities_per_role(role_id, authority_id) VALUES(3, 1);