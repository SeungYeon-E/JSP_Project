CREATE DATABASE  IF NOT EXISTS `mvc` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mvc`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: mvc
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `mvc_board`
--

DROP TABLE IF EXISTS `mvc_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mvc_board` (
  `bId` int unsigned NOT NULL AUTO_INCREMENT,
  `bName` varchar(12) DEFAULT NULL,
  `bTitle` varchar(100) DEFAULT NULL,
  `bContent` text,
  `bDate` date DEFAULT NULL,
  PRIMARY KEY (`bId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvc_board`
--

LOCK TABLES `mvc_board` WRITE;
/*!40000 ALTER TABLE `mvc_board` DISABLE KEYS */;
INSERT INTO `mvc_board` VALUES (1,'zz','zz','zz',NULL),(3,'ddddd','ddddd','ddddd','2021-05-12'),(4,'333','333','333','2021-05-12'),(5,'하하하','이렇게 하는거는','복붙만잘하면되네...ㅎㅎ\r\ndhdh\r\n\r\ndlfjsdklf\r\nasdfasdf','2021-05-23'),(6,'안녕','안녕','안녕','2021-05-12'),(7,'이게','이게','이게','2021-05-12'),(8,'에라이','이런','큰일','2021-05-12'),(9,'에라이','이런','큰일','2021-05-12'),(10,'홍길동','첫인사','안녕하세요\r\n\r\n왜안될까요','2021-05-12'),(11,'qwe','qwe1','qwe2','2021-05-13'),(12,'asd','asd1','asd2','2021-05-13'),(13,'zxc','zxc1','zxc2','2021-05-13'),(14,'rty','rty1','rty2','2021-05-13'),(15,'fgh','fgh2','fgh3','2021-05-13'),(16,'vbn','vbn1','vbn2','2021-05-13'),(17,'yui','yui1','yui2','2021-05-13'),(18,'uio','uio1','uio2','2021-05-13'),(19,'jkl','jkl1','jkl2','2021-05-20'),(20,'bnm','bnm1','bnm2','2021-05-13'),(21,'hgf','hfg1','fg2','2021-05-13');
/*!40000 ALTER TABLE `mvc_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 12:10:07
