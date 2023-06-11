INSERT INTO teams (name)
VALUES ('Korea'),
       ('Thailand'),
       ('Mongolia'),
       ('Cameroon'),
       ('Guinea'),
       ('Senegal'),
       ('Argentina'),
       ('Brazil'),
       ('Mexico'),
       ('England'),
       ('Italy'),
       ('Germany'),
       ('Nekketsu FC');

INSERT INTO computer_teams (power, team_formation, team_id)
VALUES (2, '_2_1_2', 1),  -- Korea
       (1, '_1_2_2', 2),  -- Thailand
       (3, '_2_1_2', 3),  -- Mongolia
       (5, '_2_1_2', 4),  -- Cameroon
       (2, '_2_1_2', 5),  -- Guinea
       (3, '_1_2_2', 6),  -- Senegal
       (5, '_1_2_2', 7),  -- Argentina
       (6, '_1_2_2', 8),  -- Brazil
       (2, '_2_2_1', 9),  -- Mexico
       (4, '_1_2_2', 10), -- England
       (6, '_1_2_2', 11), -- Italy
       (6, '_1_2_2', 12); -- Germany

INSERT INTO nekketsu_teams (team_id)
VALUES (13);

INSERT INTO players (name, number, player_position, team_id)
VALUES
-- Korea
('Chon-Il', 1, 'MF', 1),
('Yong-Dok', 2, 'FW', 1),
('Man-Su', 3, 'FW', 1),
('Ming-Ho', 4, 'DF', 1),
('Yong-Su', 5, 'DF', 1),
('Sun-Chol', 6, 'GK', 1),
-- Thailand
('Pumipon', 1, 'MF', 2),
('Tonchoi', 2, 'FW', 2),
('Saketto', 3, 'FW', 2),
('Pipun', 4, 'MF', 2),
('Tanin', 5, 'DF', 2),
('Chachai', 6, 'GK', 2),
-- Mongolia
('Jorukin', 1, 'MF', 3),
('Ajuru', 2, 'FW', 3),
('Gazan', 3, 'FW', 3),
('Montoku', 4, 'DF', 3),
('Furuchin', 5, 'DF', 3),
('Ishimuto', 6, 'GK', 3),
-- Cameroon
('Warioba', 1, 'MF', 4),
('Da Costa', 2, 'FW', 4),
('Obango', 3, 'FW', 4),
('Mugabe', 4, 'DF', 4),
('Kunjara', 5, 'DF', 4),
('Jawara', 6, 'GK', 4),
-- Guinea
('Nuguema', 1, 'MF', 5),
('Mabui', 2, 'FW', 5),
('Mugabe', 3, 'FW', 5),
('Mobutu', 4, 'DF', 5),
('Soguro', 5, 'DF', 5),
('Ade', 6, 'GK', 5),
-- Senegal
('Rumunba', 1, 'MF', 6),
('Uenba', 2, 'FW', 6),
('Nujoma', 3, 'FW', 6),
('Nujeri', 4, 'MF', 6),
('Obenjo', 5, 'DF', 6),
('Munjara', 6, 'GK', 6),
-- Argentina
('Latorre', 1, 'MF', 7),
('Escobar', 2, 'FW', 7),
('Sergio', 3, 'FW', 7),
('Olivares', 4, 'MF', 7),
('Barba', 5, 'DF', 7),
('Higuita', 6, 'GK', 7),
-- Brazil
('Dias', 1, 'MF', 8),
('Saravia', 2, 'FW', 8),
('Mendoca', 3, 'FW', 8),
('Bunho', 4, 'MF', 8),
('Santos', 5, 'DF', 8),
('Rodrigues', 6, 'GK', 8),
-- Mexico
('Aviles', 1, 'MF', 9),
('Aguinaga', 2, 'FW', 9),
('Gonzalez', 3, 'MF', 9),
('Salazar', 4, 'DF', 9),
('Tavallos', 5, 'DF', 9),
('Enrico', 6, 'GK', 9),
-- England
('David', 1, 'MF', 10),
('Nigel', 2, 'FW', 10),
('Mark', 3, 'FW', 10),
('Martin', 4, 'MF', 10),
('Henry', 5, 'DF', 10),
('Andy', 6, 'GK', 10),
-- Italy
('Rafaello', 1, 'MF', 11),
('Ricardo', 2, 'FW', 11),
('Giorgio', 3, 'FW', 11),
('Luca', 4, 'MF', 11),
('Giuseppe', 5, 'DF', 11),
('Giovanni', 6, 'GK', 11),
-- Germany
('Eckert', 1, 'MF', 12),
('Helmer', 2, 'FW', 12),
('Lidor', 3, 'FW', 12),
('Wernicke', 4, 'MF', 12),
('Schultz', 5, 'DF', 12),
('Bremmer', 6, 'GK', 12),
-- Nekketsu FC
('Kunio', 9, 'MF', 13),
('Yoritsune', 8, 'FW', 13),
('Saji', 10, 'FW', 13),
('Horibata', 2, 'DF', 13),
('Iwakabe', 3, 'DF', 13),
('Genei', 1, 'GK', 13),
('Ugajin', 4, 'DF', 13),
('Onitake', 5, 'MF', 13),
('Kumon', 6, 'DF', 13),
('Kaizuki', 7, 'MF', 13),
('Tsunewo', 11, 'FW', 13),
('Carlos', 12, 'GK', 13);

INSERT INTO users (login, role, password)
VALUES
('admin', 'ADMIN', '$2y$10$H4QgXRRKrwTjWha6EDLvOO2sOM763QbRHoKxLTH48zzYbywuYcfqa');
