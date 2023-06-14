-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 14-06-2023 a las 02:07:14
-- Versión del servidor: 8.0.33
-- Versión de PHP: 8.1.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nuclear_cue`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrator`
--

CREATE TABLE `administrator` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type_admin_id` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `administrator`
--

INSERT INTO `administrator` (`id`, `name`, `email_address`, `password`, `type_admin_id`, `active`) VALUES
('321', 'Orion', 'gordo@cue.edu.co', '$argon2id$v=19$m=1024,t=1,p=1$Xe291alNqFAbnV3pnvjxaQ$7o6tkz2ayB5S77512PJq1iiFDjSjiLGhYPhtBflWu7w', 'COL', 1),
('951', 'JUan', 'jposada@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$bIPbQwMvKMi2fOUFDofUHg$7Zp/9Sr9Wv+wlkIbbvzTgozywzdu+91cPUOuxtGnj8A', 'COO', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `course`
--

CREATE TABLE `course` (
  `id` varchar(50) NOT NULL,
  `teacher_id` varchar(50) NOT NULL,
  `subject_id` varchar(50) NOT NULL,
  `program_id` varchar(50) NOT NULL,
  `duration_id` varchar(50) NOT NULL,
  `equitment_room_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `course`
--

INSERT INTO `course` (`id`, `teacher_id`, `subject_id`, `program_id`, `duration_id`, `equitment_room_id`) VALUES
('matetri-IND-943', '943', 'matetri', 'IND', '2023-06-18-2023-06-17', 'SCP'),
('Programacion 5AOB-SOFT-943', '943', 'Programacion 5AOB', 'SOFT', '2023-06-11-2023-07-09', 'SCP'),
('ProgramacionAsignaturas obligatorias-SOFT-741', '741', 'ProgramacionAsignaturas obligatorias', 'SOFT', '2023-06-09-2023-07-01', 'SCP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duration`
--

CREATE TABLE `duration` (
  `id` varchar(50) NOT NULL,
  `begin` datetime NOT NULL,
  `end` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `duration`
--

INSERT INTO `duration` (`id`, `begin`, `end`) VALUES
('2023-06-06-2023-12-06', '2023-06-06 00:00:00', '2023-12-06 00:00:00'),
('2023-06-09-2023-07-01', '2023-06-09 00:00:00', '2023-07-01 00:00:00'),
('2023-06-11-2023-07-09', '2023-06-11 00:00:00', '2023-07-09 00:00:00'),
('2023-06-15-2023-06-30', '2023-06-15 00:00:00', '2023-06-30 00:00:00'),
('2023-06-15-2023-11-17', '2023-06-15 00:00:00', '2023-11-17 00:00:00'),
('2023-06-17-2023-10-19', '2023-06-17 00:00:00', '2023-10-19 00:00:00'),
('2023-06-18-2023-06-17', '2023-06-18 00:00:00', '2023-06-17 00:00:00'),
('2023-07-05-2023-12-08', '2023-07-05 00:00:00', '2023-12-08 00:00:00'),
('semestral', '2023-01-25 00:00:00', '2023-05-25 00:00:00'),
('trimestral', '2023-03-25 00:00:00', '2023-05-25 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duration_type`
--

CREATE TABLE `duration_type` (
  `id` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `weeks` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `duration_type`
--

INSERT INTO `duration_type` (`id`, `type`, `weeks`) VALUES
('SEM', 'Semestral', 6),
('TRI', 'Trimestral', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equitment_room`
--

CREATE TABLE `equitment_room` (
  `id` varchar(50) NOT NULL,
  `air_conditioning` tinyint(1) NOT NULL,
  `projector` tinyint(1) NOT NULL,
  `fan` tinyint(1) NOT NULL,
  `camera` tinyint(1) NOT NULL,
  `board` tinyint(1) NOT NULL,
  `computer` tinyint(1) NOT NULL,
  `lab` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `equitment_room`
--

INSERT INTO `equitment_room` (`id`, `air_conditioning`, `projector`, `fan`, `camera`, `board`, `computer`, `lab`) VALUES
('ALLNOC', 1, 1, 1, 1, 1, 0, 0),
('LAB', 0, 1, 1, 1, 1, 0, 1),
('SCA', 1, 1, 1, 0, 1, 0, 0),
('SCNP', 0, 0, 1, 1, 1, 0, 0),
('SCP', 0, 1, 1, 1, 1, 0, 0),
('SN', 0, 0, 1, 0, 1, 0, 0),
('SS', 1, 1, 0, 1, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hour_interval`
--

CREATE TABLE `hour_interval` (
  `id` int NOT NULL,
  `day` varchar(50) NOT NULL,
  `begin_time` time NOT NULL,
  `end_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `hour_interval`
--

INSERT INTO `hour_interval` (`id`, `day`, `begin_time`, `end_time`) VALUES
(18, 'Lunes', '06:00:00', '16:00:00'),
(19, 'Viernes', '12:00:00', '19:00:00'),
(20, 'Jueves', '09:00:00', '20:00:00'),
(21, 'Miércoles', '06:00:00', '02:00:00'),
(22, 'Miércoles', '06:00:00', '12:00:00'),
(23, 'Lunes', '06:00:00', '08:00:00'),
(24, 'Jueves', '15:00:00', '22:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hour_room`
--

CREATE TABLE `hour_room` (
  `id` int NOT NULL,
  `hour_interval_id` int NOT NULL,
  `room_id` varchar(50) NOT NULL,
  `course_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `hour_room`
--

INSERT INTO `hour_room` (`id`, `hour_interval_id`, `room_id`, `course_id`) VALUES
(1, 23, '104ASede alcazar', 'matetri-IND-943'),
(2, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(3, 23, '104ASede alcazar', 'matetri-IND-943'),
(4, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(5, 23, '104ASede alcazar', 'matetri-IND-943'),
(6, 23, '104ASede alcazar', 'matetri-IND-943'),
(7, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(8, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(9, 23, '104ASede alcazar', 'matetri-IND-943'),
(10, 23, '104ASede alcazar', 'matetri-IND-943'),
(11, 23, '104ASede alcazar', 'matetri-IND-943'),
(12, 23, '104ASede alcazar', 'matetri-IND-943'),
(13, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(14, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(15, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(16, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(17, 23, '104ASede alcazar', 'matetri-IND-943'),
(18, 23, '104ASede alcazar', 'matetri-IND-943'),
(19, 23, '104ASede alcazar', 'matetri-IND-943'),
(20, 23, '104ASede alcazar', 'matetri-IND-943'),
(21, 23, '104ASede alcazar', 'matetri-IND-943'),
(22, 23, '104ASede alcazar', 'matetri-IND-943'),
(23, 23, '104ASede alcazar', 'matetri-IND-943'),
(24, 23, '104ASede alcazar', 'matetri-IND-943'),
(25, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(26, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(27, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(28, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(29, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(30, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(31, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(32, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(33, 23, '104ASede alcazar', 'matetri-IND-943'),
(34, 23, '104ASede alcazar', 'matetri-IND-943'),
(35, 23, '104ASede alcazar', 'matetri-IND-943'),
(36, 23, '104ASede alcazar', 'matetri-IND-943'),
(37, 23, '104ASede alcazar', 'matetri-IND-943'),
(38, 23, '104ASede alcazar', 'matetri-IND-943'),
(39, 23, '104ASede alcazar', 'matetri-IND-943'),
(40, 23, '104ASede alcazar', 'matetri-IND-943'),
(41, 23, '104ASede alcazar', 'matetri-IND-943'),
(42, 23, '104ASede alcazar', 'matetri-IND-943'),
(43, 23, '104ASede alcazar', 'matetri-IND-943'),
(44, 23, '104ASede alcazar', 'matetri-IND-943'),
(45, 23, '104ASede alcazar', 'matetri-IND-943'),
(46, 23, '104ASede alcazar', 'matetri-IND-943'),
(47, 23, '104ASede alcazar', 'matetri-IND-943'),
(48, 23, '104ASede alcazar', 'matetri-IND-943'),
(49, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(50, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(51, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(52, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(53, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(54, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(55, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(56, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(57, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(58, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(59, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(60, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(61, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(62, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(63, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943'),
(64, 23, '104ASede alcazar', 'Programacion 5AOB-SOFT-943');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modality`
--

CREATE TABLE `modality` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `modality`
--

INSERT INTO `modality` (`id`, `name`) VALUES
('DIA', 'Diurno'),
('NOC', 'Nocturno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `program`
--

CREATE TABLE `program` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `faculty` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `count_semester` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `program`
--

INSERT INTO `program` (`id`, `name`, `faculty`, `count_semester`) VALUES
('ADE', 'Administracion de empresas', 'Ciencias administrativas', 7),
('CIV', 'Ingeniería civil', 'Ingeniería', 9),
('DER', 'Derecho', 'Ciencias sociales y juridicas', 8),
('ENF', 'Enfermeria', 'Ciencias de la salud', 9),
('IND', 'Ingeniería industrial', 'Ingeniería ', 8),
('MDC', 'Marketing digital y comunicacion estrategica', 'Ciencias administrativas', 9),
('MED', 'Medicina', 'Ciencias medicas', 12),
('PSI', 'Psicologia', 'Ciencias humanas y de la educacion', 8),
('SOFT', 'Ingeniería de software', 'Ingeniería ', 8),
('TUR', 'Tecnologia en gestion del turismo cultural y de naturaleza', 'Ciencias administrativas', 4),
('VET', 'Medicina veterinaria y zootecnia', 'Ciencias medicas', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `program_semester`
--

CREATE TABLE `program_semester` (
  `id` varchar(50) NOT NULL,
  `program_id` varchar(50) NOT NULL,
  `semester` int NOT NULL,
  `modality_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `program_semester`
--

INSERT INTO `program_semester` (`id`, `program_id`, `semester`, `modality_id`) VALUES
('1', 'ADE', 1, 'DIA'),
('ADENOC3', 'ADE', 3, 'NOC'),
('DERDIA1', 'DER', 1, 'DIA'),
('DERNOC3', 'DER', 3, 'NOC'),
('INDNOC1', 'IND', 1, 'NOC'),
('SOFTDIA3', 'SOFT', 3, 'DIA'),
('SOFTDIA5', 'SOFT', 5, 'DIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

CREATE TABLE `room` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `capacity` int NOT NULL,
  `campus` varchar(50) NOT NULL,
  `equitment_room_id` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`id`, `name`, `capacity`, `campus`, `equitment_room_id`, `active`) VALUES
('103B-P', '103B', 50, '-P', 'SN', 1),
('104ASede alcazar', '104A', 20, 'Sede alcazar', 'SCP', 1),
('105A-P', '105A', 30, '-P', 'SN', 1),
('174ASede alcazar', '174A', 20, 'Sede alcazar', 'SCP', 1),
('205Sede alcazar', '205', 20, 'Sede alcazar', 'SCP', 0),
('3002-C', '3002', 20, '-C', 'SCP', 1),
('302-C', '302', 20, '-C', 'SCP', 1),
('343223', 'Juan', 10, '-P', 'SCNP', 1),
('Sala de sistemas 1-P', 'Sala de sistemas 1', 45, '-P', 'SS', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE `student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `program_semester_id` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`id`, `name`, `email_address`, `password`, `program_semester_id`, `active`) VALUES
('123', 'Gerardo', 'gerardin@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$pvFifCvy2lsZBg9wkCNG+A$wKC4+LOJVJa8sFfCez6johYNezHkPHzv2RzryBXbfYQ', 'SOFTDIA3', 1),
('564213458', 'Valeria', 'val@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$bzxpWKczlrUETab/RuZwMg$cXR/bQ38nRR+YnjGCPkIhrB8qrem4ODzvximm1TeD6A', 'DERDIA1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student_course`
--

CREATE TABLE `student_course` (
  `student_id` varchar(50) NOT NULL,
  `course_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `student_course`
--

INSERT INTO `student_course` (`student_id`, `course_id`) VALUES
('564213458', 'matetri-IND-943'),
('564213458', 'ProgramacionAsignaturas obligatorias-SOFT-741'),
('123', 'ProgramacionAsignaturas obligatorias-SOFT-741'),
('564213458', 'Programacion 5AOB-SOFT-943'),
('123', 'Programacion 5AOB-SOFT-943');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subject`
--

CREATE TABLE `subject` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `duration_type_id` varchar(50) NOT NULL,
  `type_subject_id` varchar(50) NOT NULL,
  `count_semanal_hours` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `subject`
--

INSERT INTO `subject` (`id`, `name`, `duration_type_id`, `type_subject_id`, `count_semanal_hours`) VALUES
('2', 'Catedra', 'TRI', 'AOB', 2),
('Base de datosAOB', 'Base de datos', 'SEM', 'AOB', 4),
('matetri', 'Matemáticas básicas', 'SEM', 'CBU', 2),
('Programacion 5AOB', 'Programacion 5', 'TRI', 'AOB', 2),
('ProgramacionAsignaturas obligatorias', 'Programacion', 'TRI', 'AOB', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher`
--

CREATE TABLE `teacher` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `email_address`, `password`, `active`) VALUES
('741', 'Sebastian', 'seb@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$BjI5BxNr6aAC2dfGS7AT7g$WCVP++dcs5HgU454LGBKSAtX+RvrdOvucT92KzP9EuQ', 0),
('8', 'Ocho', 'ocho@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$tFZUJV3KlnN7lrmgfTplCQ$PvDOjSBM3SYOudDBoZT4LfOKZTrFbfMNdbyMJBkhrns', 1),
('943', 'Nico', 'nic@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$E7vV/JV7e6DIUUS4BOx/Cw$W/ohsQodmFIZHJNGRJ9jZ9pSY0E12FQoXrIlN2DfSIE', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher_hour_interval`
--

CREATE TABLE `teacher_hour_interval` (
  `teacher_id` varchar(50) NOT NULL,
  `hour_interval_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `teacher_hour_interval`
--

INSERT INTO `teacher_hour_interval` (`teacher_id`, `hour_interval_id`) VALUES
('943', 18),
('943', 19),
('943', 20),
('943', 22),
('8', 18),
('8', 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_admin`
--

CREATE TABLE `type_admin` (
  `id` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `type_admin`
--

INSERT INTO `type_admin` (`id`, `type`) VALUES
('COL', 'Coordinación de laboratorios'),
('COO', 'Coordinación de programas'),
('DEC', 'Decanatura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_subject`
--

CREATE TABLE `type_subject` (
  `id` varchar(50) NOT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `type_subject`
--

INSERT INTO `type_subject` (`id`, `type`) VALUES
('AEL', 'Asignatura electiva'),
('AOB', 'Asignaturas obligatorias'),
('AOP', 'Asignaturas optativas'),
('CBU', 'Ciclo básico universitario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type_admin_id` (`type_admin_id`);

--
-- Indices de la tabla `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `program_id` (`program_id`),
  ADD KEY `duration_id` (`duration_id`),
  ADD KEY `equitment_room_id` (`equitment_room_id`);

--
-- Indices de la tabla `duration`
--
ALTER TABLE `duration`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `duration_type`
--
ALTER TABLE `duration_type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `equitment_room`
--
ALTER TABLE `equitment_room`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `hour_interval`
--
ALTER TABLE `hour_interval`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `hour_room`
--
ALTER TABLE `hour_room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hour_interval_id` (`hour_interval_id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indices de la tabla `modality`
--
ALTER TABLE `modality`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `program_semester`
--
ALTER TABLE `program_semester`
  ADD PRIMARY KEY (`id`),
  ADD KEY `program_id` (`program_id`),
  ADD KEY `modality_id` (`modality_id`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equitment_room_id` (`equitment_room_id`);

--
-- Indices de la tabla `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `program_semester_id` (`program_semester_id`);

--
-- Indices de la tabla `student_course`
--
ALTER TABLE `student_course`
  ADD KEY `student_id` (`student_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indices de la tabla `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `duration_type_id` (`duration_type_id`),
  ADD KEY `type_subject_id` (`type_subject_id`);

--
-- Indices de la tabla `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `teacher_hour_interval`
--
ALTER TABLE `teacher_hour_interval`
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `hour_interval_id` (`hour_interval_id`);

--
-- Indices de la tabla `type_admin`
--
ALTER TABLE `type_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `type_subject`
--
ALTER TABLE `type_subject`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `hour_interval`
--
ALTER TABLE `hour_interval`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `hour_room`
--
ALTER TABLE `hour_room`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`type_admin_id`) REFERENCES `type_admin` (`id`);

--
-- Filtros para la tabla `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  ADD CONSTRAINT `course_ibfk_4` FOREIGN KEY (`duration_id`) REFERENCES `duration` (`id`),
  ADD CONSTRAINT `equitment_room_id` FOREIGN KEY (`equitment_room_id`) REFERENCES `equitment_room` (`id`);

--
-- Filtros para la tabla `hour_room`
--
ALTER TABLE `hour_room`
  ADD CONSTRAINT `hour_room_ibfk_1` FOREIGN KEY (`hour_interval_id`) REFERENCES `hour_interval` (`id`),
  ADD CONSTRAINT `hour_room_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `hour_room_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

--
-- Filtros para la tabla `program_semester`
--
ALTER TABLE `program_semester`
  ADD CONSTRAINT `program_semester_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  ADD CONSTRAINT `program_semester_ibfk_2` FOREIGN KEY (`modality_id`) REFERENCES `modality` (`id`);

--
-- Filtros para la tabla `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`equitment_room_id`) REFERENCES `equitment_room` (`id`);

--
-- Filtros para la tabla `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`program_semester_id`) REFERENCES `program_semester` (`id`);

--
-- Filtros para la tabla `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

--
-- Filtros para la tabla `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`duration_type_id`) REFERENCES `duration_type` (`id`),
  ADD CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`type_subject_id`) REFERENCES `type_subject` (`id`);

--
-- Filtros para la tabla `teacher_hour_interval`
--
ALTER TABLE `teacher_hour_interval`
  ADD CONSTRAINT `teacher_hour_interval_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `teacher_hour_interval_ibfk_2` FOREIGN KEY (`hour_interval_id`) REFERENCES `hour_interval` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
