-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Servidor: sql7.freesqldatabase.com
-- Tiempo de generación: 02-06-2023 a las 01:12:22
-- Versión del servidor: 5.5.62-0ubuntu0.14.04.1
-- Versión de PHP: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sql7622470`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Album`
--

CREATE TABLE `Album` (
  `ID_Album` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `LaunchDate` date NOT NULL,
  `Price` float NOT NULL,
  `FK_IDartist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Album`
--

INSERT INTO `Album` (`ID_Album`, `Name`, `LaunchDate`, `Price`, `FK_IDartist`) VALUES
(1, 'Nothing was the same', '2013-09-24', 20, 1),
(2, 'If You´re Reading This It´s Too Late', '2015-02-12', 24.99, 1),
(3, 'Honestly,NeverMind', '2022-06-17', 29.99, 1),
(4, 'Thriller', '1982-11-30', 29.99, 6),
(5, 'Off the Wall', '1979-08-10', 24.99, 6),
(6, 'Nevermind', '1991-09-26', 34.99, 7),
(7, 'Bad', '1987-08-31', 34.99, 6),
(8, 'Bleach', '1989-06-01', 19.99, 7),
(9, 'In Utero', '1993-09-21', 19.99, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Album_FormatType`
--

CREATE TABLE `Album_FormatType` (
  `ID_Album` int(11) NOT NULL,
  `ID_FormatType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Album_FormatType`
--

INSERT INTO `Album_FormatType` (`ID_Album`, `ID_FormatType`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Artists`
--

CREATE TABLE `Artists` (
  `ID_Artist` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Artists`
--

INSERT INTO `Artists` (`ID_Artist`, `Name`) VALUES
(1, 'Drake'),
(2, '21 Savage'),
(3, 'Lil Wayne'),
(4, 'Travis Scott'),
(5, 'PARTYNEXTDOOR'),
(6, 'Michael Jackson'),
(7, 'Nirvana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Artists_Songs`
--

CREATE TABLE `Artists_Songs` (
  `ID_Song` int(11) NOT NULL,
  `ID_Artist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Artists_Songs`
--

INSERT INTO `Artists_Songs` (`ID_Song`, `ID_Artist`) VALUES
(14, 1),
(14, 2),
(23, 1),
(23, 5),
(24, 1),
(24, 5),
(25, 3),
(25, 1),
(28, 1),
(28, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FormatType`
--

CREATE TABLE `FormatType` (
  `ID_FormatType` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `FormatType`
--

INSERT INTO `FormatType` (`ID_FormatType`, `Name`) VALUES
(1, 'Digital'),
(2, 'CD'),
(3, 'Vinil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Songs`
--

CREATE TABLE `Songs` (
  `ID_Song` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Duration` varchar(255) NOT NULL,
  `FK_IDAlbum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Songs`
--

INSERT INTO `Songs` (`ID_Song`, `Name`, `Duration`, `FK_IDAlbum`) VALUES
(1, 'Intro', '0:36', 3),
(2, 'Falling Back', '4:26', 3),
(3, 'Texts Go Green', '5:08', 3),
(4, 'Currents', '2:37', 3),
(5, 'A Keeper', '2:53', 3),
(6, 'Calling My Name', '2:09', 3),
(7, 'Sticky', '4:03', 3),
(8, 'Massive', '5:36', 3),
(9, 'Flight´s Booked', '4:14', 3),
(10, 'Overdrive', '3:22', 3),
(11, 'Down Hill', '4:10', 3),
(12, 'Tie That Binds', '5:36', 3),
(13, 'Liability', '3:57', 3),
(14, 'Jimmy Cooks', '3:38', 3),
(15, 'Legend', '4:01', 2),
(16, 'Energy', '3:01', 2),
(17, '10 Bands', '2:57', 2),
(18, 'Know Yourself', '4:35', 2),
(19, 'No Tellin´', '5:10', 2),
(20, 'Madonna', '2:57', 2),
(21, '6 God', '3:00', 2),
(22, 'Star67', '4:54', 2),
(23, 'Preach', '3:56', 2),
(24, 'Wednesday Night Interlude', '3:32', 2),
(25, 'Used To', '4:28', 2),
(26, '6 Man', '2:47', 2),
(27, 'Now & Forever', '4:41', 2),
(28, 'Company', '4:12', 2),
(29, 'You & The 6', '4:24', 2),
(30, 'Jungle', '5:20', 2),
(31, '6PM In New York', '4:43', 2),
(33, 'Tuscan Leather', '6:06', 1),
(34, 'Furthest Thing', '4:27', 1),
(35, 'Started From the Bottom', '2:54', 1),
(36, 'Wu-Tang Forever', '3:37', 1),
(37, 'Own It', '4:11', 1),
(38, 'Worst Behavior', '4:30', 1),
(39, 'From Time', '5:22', 1),
(40, 'Hold On, We´re Going Home', '3:47', 1),
(41, 'Connect', '4:56', 1),
(42, 'The Language', '3:44', 1),
(43, '305 To My City', '4:15', 1),
(44, 'Too Much', '4:21', 1),
(45, 'Poun Cake/Paris Morton Music 2', '7:12', 1),
(46, 'Wanna Be Startin´ Somethin´', '6:03', 4),
(47, 'Baby Be Mine', '4:20', 4),
(48, 'The Girl Is Mine', '3:42', 4),
(49, 'Thriller', '5:57', 4),
(50, 'Beat it', '4:18', 4),
(51, 'Billie Jean', '4:54', 4),
(52, 'Human Nature', '4:06', 4),
(53, 'P.Y.T(Pretty Young Thing)', '3:59', 4),
(54, 'The Lady in My Life', '5:00', 4),
(55, 'Don´t Stop `Til You Get Enough', '6:05', 5),
(56, 'Rock With You', '3:40', 5),
(57, 'Workin´ Day and Night', '5:13', 5),
(58, 'Get on the Floor', '4:37', 5),
(59, 'Off the Wall', '4:06', 5),
(60, 'Girlfriend', '3:04', 5),
(61, 'She´s Out of My Life', '3:38', 5),
(62, 'I Can´t Help It', '4:29', 5),
(63, 'It´s the Falling in Love', '3:47', 5),
(64, 'Burn This Disco Out', '3:41', 5),
(65, 'Serve The Servants', '3:37', 9),
(66, 'Scentless Apprentice', '3:48', 9),
(67, 'Heart-Shaped Box', '4:41', 9),
(68, 'Rape Me', '2:50', 9),
(69, 'Frances Farmer Will Have Her Revenge On Seattle', '4:10', 9),
(70, 'Dumb', '2:31', 9),
(71, 'Very Ape', '1:55', 9),
(72, 'Milk It', '3:54', 9),
(73, 'Pennyroyal Tea', '3:38', 9),
(74, 'Radio Friendly Unit Shifter', '4:51', 9),
(75, 'Tourette´s', '1:35', 9),
(76, 'All Apologies', '3:53', 9),
(77, 'Bad', '4:07', 7),
(78, 'The Way You Make Me Feel', '4:58', 7),
(79, 'Speed Demon', '4:02', 7),
(80, 'Liberian Girl', '3:52', 7),
(81, 'Just Good Friends', '4:06', 7),
(82, 'Another Part of Me', '3:54', 7),
(83, 'Man in the Mirror', '5:18', 7),
(84, 'I Just Can´t Stop Loving You', '4:11', 7),
(85, 'Dirty Diana', '4:40', 7),
(86, 'Smooth Criminal', '4:17', 7),
(87, 'Leave Me Alone', '4:40', 7),
(88, 'Blew', '2:54', 8),
(89, 'Floyd The Barber', '2:18', 8),
(90, 'About A Girl', '2:48', 8),
(91, 'School', '2:42', 8),
(92, 'Love Buzz', '3:35', 8),
(93, 'Paper Cuts', '4:06', 8),
(94, 'Negative Creep', '2:55', 8),
(95, 'Scoff', '4:10', 8),
(96, 'Swap Meet', '3:03', 8),
(97, 'Mr.Moustache', '3:23', 8),
(98, 'Sifting', '5:22', 8),
(99, 'Big Cheese', '3:42', 8),
(100, 'Downer', '1:43', 8),
(101, 'Smells Like Teen Spirit', '5:01', 6),
(102, 'In Bloom', '4:15', 6),
(103, 'Come As You Are', '3:38', 6),
(104, 'Breed', '3:04', 6),
(105, 'Lithium', '4:17', 6),
(106, 'Polly', '2:53', 6),
(107, 'Territorial Pissings', '2:22', 6),
(108, 'Drain You', '3:43', 6),
(109, 'Lounge Act', '2:36', 6),
(110, 'Stay Away', '3:31', 6),
(111, 'On A Plain', '3:14', 6),
(112, 'Something In The Way', '3:52', 6),
(113, 'Endless,Nameless', '6:43', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `User`
--

CREATE TABLE `User` (
  `ID_User` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `User`
--

INSERT INTO `User` (`ID_User`, `Name`, `LastName`, `Password`, `Email`) VALUES
(7, 'Enric', 'Sanchez', '12345678P', 'm@.com'),
(8, 'Miriam', 'mura', '123456789P', 'miriammura@gmail.com'),
(9, 'tet', 'tete', '123456789P', 'enricmontoya@gmail.com'),
(10, 'enric', 'sanchez', '123456789P', 'enricmontoya@gmail.com'),
(11, 'Enric', 'Sanchez', '17Dejulio2004', 'enricmontoya@gmail.com'),
(12, 'Enric', 'Sanchez', '123456789P', 'enricmontoya@gmail.com'),
(13, 'Enric', 'Sanchezx', '123456789P', 'enricmontoya@gmail.com'),
(14, 'Joel', 'Aguilera', '123456789J', 'jaguilera@gmail.com'),
(15, 'joan', 'Carcelle', '123456789J', 'jcarcelle@gmail.com'),
(16, 'Blas', 'Martos', '123456789M', 'bmartos@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Album`
--
ALTER TABLE `Album`
  ADD PRIMARY KEY (`ID_Album`),
  ADD KEY `FK_IDArtists` (`FK_IDartist`);

--
-- Indices de la tabla `Album_FormatType`
--
ALTER TABLE `Album_FormatType`
  ADD KEY `FK_IDAlbum` (`ID_Album`),
  ADD KEY `FK_FormatType` (`ID_FormatType`);

--
-- Indices de la tabla `Artists`
--
ALTER TABLE `Artists`
  ADD PRIMARY KEY (`ID_Artist`);

--
-- Indices de la tabla `Artists_Songs`
--
ALTER TABLE `Artists_Songs`
  ADD KEY `FK_IDSongs` (`ID_Song`),
  ADD KEY `FK_IDartist` (`ID_Artist`);

--
-- Indices de la tabla `FormatType`
--
ALTER TABLE `FormatType`
  ADD PRIMARY KEY (`ID_FormatType`);

--
-- Indices de la tabla `Songs`
--
ALTER TABLE `Songs`
  ADD PRIMARY KEY (`ID_Song`),
  ADD KEY `Fk_Album` (`FK_IDAlbum`);

--
-- Indices de la tabla `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`ID_User`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Album`
--
ALTER TABLE `Album`
  MODIFY `ID_Album` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `Artists`
--
ALTER TABLE `Artists`
  MODIFY `ID_Artist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `FormatType`
--
ALTER TABLE `FormatType`
  MODIFY `ID_FormatType` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Songs`
--
ALTER TABLE `Songs`
  MODIFY `ID_Song` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT de la tabla `User`
--
ALTER TABLE `User`
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Album`
--
ALTER TABLE `Album`
  ADD CONSTRAINT `FK_IDArtists` FOREIGN KEY (`FK_IDartist`) REFERENCES `Artists` (`ID_Artist`);

--
-- Filtros para la tabla `Album_FormatType`
--
ALTER TABLE `Album_FormatType`
  ADD CONSTRAINT `FK_FormatType` FOREIGN KEY (`ID_FormatType`) REFERENCES `FormatType` (`ID_FormatType`),
  ADD CONSTRAINT `FK_IDAlbum` FOREIGN KEY (`ID_Album`) REFERENCES `Album` (`ID_Album`);

--
-- Filtros para la tabla `Artists_Songs`
--
ALTER TABLE `Artists_Songs`
  ADD CONSTRAINT `FK_IDartist` FOREIGN KEY (`ID_Artist`) REFERENCES `Artists` (`ID_Artist`),
  ADD CONSTRAINT `FK_IDSongs` FOREIGN KEY (`ID_Song`) REFERENCES `Songs` (`ID_Song`);

--
-- Filtros para la tabla `Songs`
--
ALTER TABLE `Songs`
  ADD CONSTRAINT `Fk_Album` FOREIGN KEY (`FK_IDAlbum`) REFERENCES `Album` (`ID_Album`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
