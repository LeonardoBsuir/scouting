-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.27-enterprise-commercial-advanced-log - MySQL Enterprise Server - Advanced Edition (Commercial)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.3.0.5004
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Дамп данных таблицы scouting.comment: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`comment_id`, `text`, `player_id`, `user_id`) VALUES
	(1, 'lalalala', 100, 2),
	(2, 'norm', 101, 2);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- Дамп данных таблицы scouting.player: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` (`player_id`, `first_name`, `last_name`, `position`, `photo`, `birthdate`, `weight`, `height`, `salary`, `cost`, `foot`, `team_id`, `skills_id`) VALUES
	(100, 'Antonio', 'Valencia', 'RB', 'app/assets/img/Valencia.png', '1990-08-04 22:41:18', 80, 174, 100, 25000000, 'right', 100, 103),
	(101, 'Kevin', 'De Bruyne', 'ACM', 'app/assets/img/De_Bruyne.png', '1991-06-28 00:00:00', 75, 174, 200, 75000000, 'right', 101, 102),
	(102, 'David', 'Silva', 'ACM', 'app/assets/img/Silva.png', '1986-01-08 22:41:22', 75, 170, 200, 25000000, 'left', 101, 104),
	(103, 'Zlatan', 'Ibrahimovich', 'ST', 'app/assets/img/Ibra.png', '1981-10-03 22:41:23', 90, 190, 220, 25000000, 'right', 100, 105),
	(104, 'Alexis', 'Sanchez', 'FW', 'app/assets/img/Sanchez.png', '1988-12-19 22:41:24', 80, 178, 220, 80000000, 'right', 102, 106),
	(107, 'Eden', 'Hazard', 'LM', 'app/assets/img/hazard.png', '1991-01-07 00:00:00', 80, 173, 220, 70000000, 'right', 104, 117),
	(108, 'Hector', 'Bellerin', 'RB', 'app/assets/img/bel.png', '1995-04-19 00:00:00', 78, 180, 100, 50000000, 'right', 102, 118),
	(109, 'Olivier', 'Giroud', 'ST', 'app/assets/img/giroud.png', '1986-09-30 00:00:00', 85, 190, 150, 20000000, 'left', 102, 119),
	(110, 'Nicolas', 'Otamendi', 'CB', 'app/assets/img/ota.png', '1988-02-12 00:00:00', 82, 183, 190, 30000000, 'right', 101, 120),
	(111, 'Paul', 'Pogba', 'CM', 'app/assets/img/pogba.png', '1991-04-15 00:00:00', 84, 191, 250, 105000000, 'right', 100, 121),
	(112, 'Diego', 'Costa', 'ST', 'app/assets/img/costa.png', '1988-10-07 00:00:00', 81, 188, 200, 40000000, 'right', 104, 122),
	(113, 'David', 'Luiz', 'CB', 'app/assets/img/luiz.png', '1987-04-22 01:00:00', 84, 189, 180, 50000000, 'right', 104, 123);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;

-- Дамп данных таблицы scouting.role: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`, `type`) VALUES
	(1, 'admin'),
	(2, 'scout'),
	(3, 'coach'),
	(4, 'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Дамп данных таблицы scouting.skills: ~17 rows (приблизительно)
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` (`skills_id`, `shooting`, `passing`, `dribbling`, `defence`, `speed`, `energy`, `stamina`) VALUES
	(98, 81, 82, 80, 76, 83, 81, 80),
	(99, 86, 85, 84, 77, 82, 81, 83),
	(100, 80, 83, 82, 75, 80, 83, 81),
	(101, 77, 82, 80, 81, 81, 82, 81),
	(102, 80, 90, 81, 80, 84, 83, 80),
	(103, 81, 75, 81, 82, 80, 83, 80),
	(104, 81, 78, 81, 80, 80, 83, 80),
	(105, 81, 87, 81, 70, 80, 83, 80),
	(106, 84, 87, 85, 65, 82, 81, 80),
	(107, 86, 87, 90, 45, 87, 80, 80),
	(117, 87, 87, 90, 68, 84, 80, 85),
	(118, 76, 83, 80, 85, 90, 87, 87),
	(119, 85, 78, 75, 78, 78, 76, 75),
	(120, 70, 80, 78, 84, 80, 82, 85),
	(121, 80, 87, 85, 75, 82, 84, 84),
	(122, 86, 85, 83, 78, 84, 85, 85),
	(123, 85, 85, 80, 85, 80, 78, 80);
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;

-- Дамп данных таблицы scouting.team: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` (`team_id`, `name`, `country`, `photo`, `skills_id`) VALUES
	(100, 'Manchester United', 'England', 'app/assets/img/Manchester_United.png', 100),
	(101, 'Manchester City', 'England', 'app/assets/img/Manchester_City.png', 101),
	(102, 'Arsenal', 'England', 'app/assets/img/Arsenal.png', 98),
	(104, 'Chelsea', 'England', 'app/assets/img/Chelsea.png', 99);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;

-- Дамп данных таблицы scouting.user: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `name`, `login`, `password`, `mail`, `photo`, `team_id`, `role_id`) VALUES
	(1, 'admin', 'admin', 'admin', 'admin@mail.ru', '', NULL, 1),
	(2, 'vasili', 'vasya', 'vasya', 'vasya@mail.ru', 'app/assets/img/vasya.png', 100, 2),
	(3, 'Jose Mourinho', 'jose', 'jose', 'jose@mail.ru', 'app/assets/img/jose.png', 100, 3),
	(4, 'Pep Guardiola', 'pep', 'pep', 'pep@mail.ru', 'app/assets/img/pep.png', 101, 3),
	(5, 'Arsen Wenger', 'ars', 'ars', 'ars@mail.ru', 'app/assets/img/ars.png', 102, 3),
	(7, 'fdh', 'fd', 'fd', 'gd', 'app/assets/img/undefined.png', 102, 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Дамп данных таблицы scouting.user_player: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `user_player` DISABLE KEYS */;
INSERT INTO `user_player` (`user_id`, `player_id`) VALUES
	(4, 104),
	(3, 107),
	(2, 101),
	(3, 101),
	(7, 101),
	(4, 107);
/*!40000 ALTER TABLE `user_player` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
