CREATE TABLE teams
(
    id   smallserial PRIMARY KEY,
    name varchar(11) NOT NULL
);

CREATE TABLE computer_teams
(
    id             smallserial PRIMARY KEY,
    power          smallint   NOT NULL,
    team_formation varchar(6) NOT NULL,
    team_id        smallint   NOT NULL REFERENCES teams (id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
);

CREATE TABLE nekketsu_teams
(
    id      smallserial PRIMARY KEY,
    team_id smallint NOT NULL REFERENCES teams (id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
);

CREATE TABLE players
(
    id              smallserial PRIMARY KEY,
    name            VARCHAR(9) NOT NULL,
    number          smallint   NOT NULL,
    player_position varchar(2) NOT NULL,
    team_id         smallint   NOT NULL REFERENCES teams (id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
);

CREATE TABLE nekketsu_team_starting_lineups
(
    id             smallserial PRIMARY KEY,
    team_formation VARCHAR(6) NOT NULL,
    captain_id     smallint   NOT NULL REFERENCES players (id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
);

CREATE TABLE nekketsu_team_starting_lineups_players
(
    nekketsu_team_starting_lineup_id smallint NOT NULL REFERENCES nekketsu_team_starting_lineups (id),
    player_id                        smallint NOT NULL REFERENCES players (id),
    PRIMARY KEY (nekketsu_team_starting_lineup_id, player_id)
);

CREATE TABLE championships
(
    id                               smallserial PRIMARY KEY,
    name                             VARCHAR(100) NOT NULL,
    nekketsu_team_starting_lineup_id smallint REFERENCES nekketsu_team_starting_lineups (id)
);
