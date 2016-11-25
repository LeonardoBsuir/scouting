CREATE TABLE role
(
    role_id BIGINT PRIMARY KEY NOT NULL,
    type VARCHAR(255)
);
CREATE TABLE skills
(
    skills_id BIGINT PRIMARY KEY NOT NULL,
    shooting BIGINT,
    passing BIGINT,
    dribbling BIGINT,
    defence BIGINT,
    speed BIGINT,
    energy BIGINT,
    stamina BIGINT
);
CREATE TABLE team
(
    team_id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    country VARCHAR(255),
    photo VARCHAR(255),
    skills_id BIGINT,
    FOREIGN KEY (skills_id) REFERENCES skills (skills_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX team_skills ON team (skills_id);

CREATE TABLE player
(
    player_id BIGINT PRIMARY KEY NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    position VARCHAR(255),
    photo VARCHAR(255),
    birthdate TIMESTAMP,
    weight BIGINT,
    height BIGINT,
    salary BIGINT,
    cost BIGINT,
    foot VARCHAR(50),
    team_id BIGINT,
    skills_id BIGINT,
    FOREIGN KEY (skills_id) REFERENCES skills (skills_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (team_id) REFERENCES team (team_id) ON UPDATE CASCADE
);
CREATE INDEX player_skills ON player (skills_id);
CREATE INDEX player_team ON player (team_id);

CREATE TABLE user
(
    user_id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255),
    mail VARCHAR(255),
    photo VARCHAR(255),
    team_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES role (role_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (team_id) REFERENCES team (team_id) ON UPDATE CASCADE
);
CREATE UNIQUE INDEX name ON user (name);
CREATE INDEX user_role ON user (role_id);
CREATE INDEX user_team ON user (team_id);
CREATE TABLE user_player
(
    user_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES player (player_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX up_player ON user_player (player_id);
CREATE INDEX up_user ON user_player (user_id);

CREATE TABLE comment
(
    comment_id BIGINT PRIMARY KEY NOT NULL,
    text VARCHAR(255),
    player_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (player_id) REFERENCES player (player_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX comment_player ON comment (player_id);
