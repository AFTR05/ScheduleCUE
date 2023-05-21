-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 21-05-2023 a las 02:48:29
-- Versión del servidor: 8.0.33
-- Versión de PHP: 8.1.18

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
  `password` varchar(50) NOT NULL,
  `type_admin_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curse`
--

CREATE TABLE `curse` (
  `id` varchar(50) NOT NULL,
  `teacher_id` varchar(50) NOT NULL,
  `subject_id` varchar(50) NOT NULL,
  `program_id` varchar(50) NOT NULL,
  `duration_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curse_student`
--

CREATE TABLE `curse_student` (
  `student_id` varchar(50) NOT NULL,
  `curse_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duration`
--

CREATE TABLE `duration` (
  `id` varchar(50) NOT NULL,
  `begin` time NOT NULL,
  `end` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hour_room`
--

CREATE TABLE `hour_room` (
  `id` int NOT NULL,
  `hour_interval_id` int NOT NULL,
  `room_id` varchar(50) NOT NULL,
  `curse_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `countSemester` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `program`
--

INSERT INTO `program` (`id`, `name`, `faculty`, `countSemester`) VALUES
('ADE', 'Administracion de empresas', 'Ciencias administrativas', 7),
('CIV', 'Ingeniería civil', 'Ingeniería', 9),
('DER', 'Derecho', 'Ciencias sociales y juridicas', 8),
('ENF', 'Enfermeria', 'Ciencias de la salud', 9),
('IND', 'Ingeniería industrial', 'Ingeniería ', 8),
('MDC', 'Marketing digital y comunicacion estrategica', 'Ciencias administrativas', 9),
('MED', 'Medicina', 'Ciencias medicas', 12),
('PSI', 'Psicologia', 'Ciencias humanas y de la educacion', 8),
('SOFT', 'Ingeniería de software ', 'Ingeniería ', 8),
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE `student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `program_semester_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subject`
--

CREATE TABLE `subject` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `duration_type_id` varchar(50) NOT NULL,
  `type_subject_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher`
--

CREATE TABLE `teacher` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher_interval`
--

CREATE TABLE `teacher_interval` (
  `teacher_id` varchar(50) NOT NULL,
  `hour_interval_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
-- Indices de la tabla `curse`
--
ALTER TABLE `curse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `program_id` (`program_id`),
  ADD KEY `duration_id` (`duration_id`);

--
-- Indices de la tabla `curse_student`
--
ALTER TABLE `curse_student`
  ADD KEY `student_id` (`student_id`),
  ADD KEY `curse_id` (`curse_id`);

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
  ADD KEY `curse_id` (`curse_id`);

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
-- Indices de la tabla `teacher_interval`
--
ALTER TABLE `teacher_interval`
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
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `hour_room`
--
ALTER TABLE `hour_room`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`type_admin_id`) REFERENCES `type_admin` (`id`);

--
-- Filtros para la tabla `curse`
--
ALTER TABLE `curse`
  ADD CONSTRAINT `curse_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `curse_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `curse_ibfk_3` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  ADD CONSTRAINT `curse_ibfk_4` FOREIGN KEY (`duration_id`) REFERENCES `duration` (`id`);

--
-- Filtros para la tabla `curse_student`
--
ALTER TABLE `curse_student`
  ADD CONSTRAINT `curse_student_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `curse_student_ibfk_2` FOREIGN KEY (`curse_id`) REFERENCES `curse` (`id`);

--
-- Filtros para la tabla `hour_room`
--
ALTER TABLE `hour_room`
  ADD CONSTRAINT `hour_room_ibfk_1` FOREIGN KEY (`hour_interval_id`) REFERENCES `hour_interval` (`id`),
  ADD CONSTRAINT `hour_room_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `hour_room_ibfk_3` FOREIGN KEY (`curse_id`) REFERENCES `curse` (`id`);

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
-- Filtros para la tabla `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`duration_type_id`) REFERENCES `duration_type` (`id`),
  ADD CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`type_subject_id`) REFERENCES `type_subject` (`id`);

--
-- Filtros para la tabla `teacher_interval`
--
ALTER TABLE `teacher_interval`
  ADD CONSTRAINT `teacher_interval_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `teacher_interval_ibfk_2` FOREIGN KEY (`hour_interval_id`) REFERENCES `hour_interval` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
