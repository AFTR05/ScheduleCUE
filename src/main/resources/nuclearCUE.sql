-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nuclear_cue
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type_admin_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_admin_id` (`type_admin_id`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`type_admin_id`) REFERENCES `type_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curse`
--

DROP TABLE IF EXISTS `curse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curse` (
  `id` varchar(50) NOT NULL,
  `teacher_id` varchar(50) NOT NULL,
  `subject_id` varchar(50) NOT NULL,
  `program_id` varchar(50) NOT NULL,
  `duration_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `subject_id` (`subject_id`),
  KEY `program_id` (`program_id`),
  KEY `duration_id` (`duration_id`),
  CONSTRAINT `curse_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `curse_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `curse_ibfk_3` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  CONSTRAINT `curse_ibfk_4` FOREIGN KEY (`duration_id`) REFERENCES `duration` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curse`
--

LOCK TABLES `curse` WRITE;
/*!40000 ALTER TABLE `curse` DISABLE KEYS */;
/*!40000 ALTER TABLE `curse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curse_student`
--

DROP TABLE IF EXISTS `curse_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curse_student` (
  `student_id` varchar(50) NOT NULL,
  `curse_id` varchar(50) NOT NULL,
  KEY `student_id` (`student_id`),
  KEY `curse_id` (`curse_id`),
  CONSTRAINT `curse_student_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `curse_student_ibfk_2` FOREIGN KEY (`curse_id`) REFERENCES `curse` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curse_student`
--

LOCK TABLES `curse_student` WRITE;
/*!40000 ALTER TABLE `curse_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `curse_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duration`
--

DROP TABLE IF EXISTS `duration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duration` (
  `id` varchar(50) NOT NULL,
  `begin` time NOT NULL,
  `end` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duration`
--

LOCK TABLES `duration` WRITE;
/*!40000 ALTER TABLE `duration` DISABLE KEYS */;
/*!40000 ALTER TABLE `duration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duration_type`
--

DROP TABLE IF EXISTS `duration_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duration_type` (
  `id` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duration_type`
--

LOCK TABLES `duration_type` WRITE;
/*!40000 ALTER TABLE `duration_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `duration_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equitment_room`
--

DROP TABLE IF EXISTS `equitment_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equitment_room` (
  `id` varchar(50) NOT NULL,
  `air_conditioning` tinyint(1) NOT NULL,
  `projector` tinyint(1) NOT NULL,
  `fan` tinyint(1) NOT NULL,
  `camera` tinyint(1) NOT NULL,
  `board` tinyint(1) NOT NULL,
  `computer` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equitment_room`
--

LOCK TABLES `equitment_room` WRITE;
/*!40000 ALTER TABLE `equitment_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `equitment_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hour_interval`
--

DROP TABLE IF EXISTS `hour_interval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hour_interval` (
  `id` int NOT NULL AUTO_INCREMENT,
  `day` varchar(50) NOT NULL,
  `begin_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hour_interval`
--

LOCK TABLES `hour_interval` WRITE;
/*!40000 ALTER TABLE `hour_interval` DISABLE KEYS */;
/*!40000 ALTER TABLE `hour_interval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hour_room`
--

DROP TABLE IF EXISTS `hour_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hour_room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hour_interval_id` int NOT NULL,
  `room_id` varchar(50) NOT NULL,
  `curse_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hour_interval_id` (`hour_interval_id`),
  KEY `room_id` (`room_id`),
  KEY `curse_id` (`curse_id`),
  CONSTRAINT `hour_room_ibfk_1` FOREIGN KEY (`hour_interval_id`) REFERENCES `hour_interval` (`id`),
  CONSTRAINT `hour_room_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `hour_room_ibfk_3` FOREIGN KEY (`curse_id`) REFERENCES `curse` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hour_room`
--

LOCK TABLES `hour_room` WRITE;
/*!40000 ALTER TABLE `hour_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `hour_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modality`
--

DROP TABLE IF EXISTS `modality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modality` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modality`
--

LOCK TABLES `modality` WRITE;
/*!40000 ALTER TABLE `modality` DISABLE KEYS */;
/*!40000 ALTER TABLE `modality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `countSemester` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program_semester`
--

DROP TABLE IF EXISTS `program_semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program_semester` (
  `id` varchar(50) NOT NULL,
  `program_id` varchar(50) NOT NULL,
  `semester` int NOT NULL,
  `modality_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `program_id` (`program_id`),
  KEY `modality_id` (`modality_id`),
  CONSTRAINT `program_semester_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  CONSTRAINT `program_semester_ibfk_2` FOREIGN KEY (`modality_id`) REFERENCES `modality` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_semester`
--

LOCK TABLES `program_semester` WRITE;
/*!40000 ALTER TABLE `program_semester` DISABLE KEYS */;
/*!40000 ALTER TABLE `program_semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `capacity` int NOT NULL,
  `campus` varchar(50) NOT NULL,
  `equitment_room_id` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `equitment_room_id` (`equitment_room_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`equitment_room_id`) REFERENCES `equitment_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `program_semester_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `program_semester_id` (`program_semester_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`program_semester_id`) REFERENCES `program_semester` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `duration_type_id` varchar(50) NOT NULL,
  `type_subject_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `duration_type_id` (`duration_type_id`),
  KEY `type_subject_id` (`type_subject_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`duration_type_id`) REFERENCES `duration_type` (`id`),
  CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`type_subject_id`) REFERENCES `type_subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_interval`
--

DROP TABLE IF EXISTS `teacher_interval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_interval` (
  `teacher_id` varchar(50) NOT NULL,
  `hour_interval_id` int NOT NULL,
  KEY `teacher_id` (`teacher_id`),
  KEY `hour_interval_id` (`hour_interval_id`),
  CONSTRAINT `teacher_interval_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `teacher_interval_ibfk_2` FOREIGN KEY (`hour_interval_id`) REFERENCES `hour_interval` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_interval`
--

LOCK TABLES `teacher_interval` WRITE;
/*!40000 ALTER TABLE `teacher_interval` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_interval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_admin`
--

DROP TABLE IF EXISTS `type_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_admin` (
  `id` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_admin`
--

LOCK TABLES `type_admin` WRITE;
/*!40000 ALTER TABLE `type_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_subject`
--

DROP TABLE IF EXISTS `type_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_subject` (
  `id` varchar(50) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_subject`
--

LOCK TABLES `type_subject` WRITE;
/*!40000 ALTER TABLE `type_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-20 17:51:39
