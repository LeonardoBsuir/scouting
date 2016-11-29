INSERT INTO role (role_id, type) VALUES (1, 'admin');
INSERT INTO role (role_id, type) VALUES (2, 'scout');
INSERT INTO role (role_id, type) VALUES (3, 'coach');
INSERT INTO role (role_id, type) VALUES (4, 'user');

INSERT INTO skills (skills_id, shooting, passing, dribbling, defence, speed, energy, stamina) VALUES (100, 80, 80, 80, 80, 80, 80, 80);
INSERT INTO skills (skills_id, shooting, passing, dribbling, defence, speed, energy, stamina) VALUES (101, 81, 81, 81, 80, 80, 80, 80);
INSERT INTO skills (skills_id, shooting, passing, dribbling, defence, speed, energy, stamina) VALUES (102, 41, 51, 81, 80, 84, 83, 80);
INSERT INTO skills (skills_id, shooting, passing, dribbling, defence, speed, energy, stamina) VALUES (103, 81, 54, 81, 80, 80, 83, 80);

INSERT INTO team (team_id, name, country, photo, skills_id) VALUES (100,'Manchester United','England', , 100);
INSERT INTO team (team_id, name, country, photo, skills_id) VALUES (101,'Manchester City','England', , 101);

INSERT INTO "user" (user_id, name, login, password, mail, photo, team_id, role_id) VALUES (1, 'admin', 'admin', 'admin', 'admin@mail.ru', '', null, 1);
INSERT INTO "user" (user_id, name, login, password, mail, photo, team_id, role_id) VALUES (2, 'vasili', 'vasya', 'vasya', 'vasya@mail.ru', '', 100, 2);

INSERT INTO player (player_id, first_name, last_name, "position", photo, birthdate, weight, height, salary, cost, foot, team_id, skills_id) VALUES (100, 'Antonio', 'Valencia', 'RB', '', NULL, 80, 174, 100, 25000000, 'right', 100, 103);
INSERT INTO player (player_id, first_name, last_name, "position", photo, birthdate, weight, height, salary, cost, foot, team_id, skills_id) VALUES (101, 'Kevin', 'De Bruyne', 'ACM', '', NULL, 75, 174, 200, 75000000, 'right', 101, 104);

INSERT INTO comment (comment_id, text, player_id, user_id) VALUES (1, 'lalalala', 100, 2);
INSERT INTO comment (comment_id, text, player_id, user_id) VALUES (2, 'norm', 101, 2);