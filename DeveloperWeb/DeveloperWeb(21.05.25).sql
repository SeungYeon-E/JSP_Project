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
-- Current Database: `mvc`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mvc` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mvc`;

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

--
-- Current Database: `jsp_project`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jsp_project` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `jsp_project`;

--
-- Table structure for table `comment_item`
--

DROP TABLE IF EXISTS `comment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_item` (
  `USER_EMAIL` varchar(100) NOT NULL,
  `ITEM_I_NUM` int NOT NULL,
  `IC_NUM` int NOT NULL AUTO_INCREMENT,
  `IC_CONTENT` text,
  `IC_DELETE` datetime DEFAULT NULL,
  `IC_EDIT` datetime DEFAULT NULL,
  `IC_REGIST` datetime DEFAULT NULL,
  PRIMARY KEY (`IC_NUM`,`ITEM_I_NUM`,`USER_EMAIL`),
  KEY `fk_USER_has_TOOL_TOOL1_idx` (`ITEM_I_NUM`),
  KEY `fk_USER_has_TOOL_USER_idx` (`USER_EMAIL`),
  CONSTRAINT `fk_USER_has_TOOL_TOOL1` FOREIGN KEY (`ITEM_I_NUM`) REFERENCES `item` (`I_NUM`),
  CONSTRAINT `fk_USER_has_TOOL_USER` FOREIGN KEY (`USER_EMAIL`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=550 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_item`
--

LOCK TABLES `comment_item` WRITE;
/*!40000 ALTER TABLE `comment_item` DISABLE KEYS */;
INSERT INTO `comment_item` VALUES ('aaa@naver.com',1,1,'좋아요',NULL,NULL,'2021-05-19 00:00:00'),('bbb@naver.com',1,2,'최고ㅋㅋ',NULL,'2021-05-23 20:20:22','2021-05-20 00:00:00'),('aaa@naver.com',2,3,'ㅋㅋ',NULL,NULL,'2021-05-20 00:00:00'),('bbb@naver.com',2,4,'와우',NULL,NULL,'2021-05-20 00:00:00'),('aaa@naver.com',1,5,'이거도 써바야지',NULL,NULL,'2021-05-21 16:18:40'),('aaa@naver.com',1,6,'ㅂㅂㅂㅂ','2021-05-22 13:05:02',NULL,'2021-05-21 17:16:18'),('aaa@naver.com',1,7,'진짜 사고싶다...ㅋㅋㅋㅋㅋ',NULL,'2021-05-22 16:01:37','2021-05-21 17:31:29'),('aaa@naver.com',1,8,'aaaaaaa','2021-05-22 11:08:52',NULL,'2021-05-21 18:42:45'),('aaa@naver.com',1,9,'왜....ㅎㅎ','2021-05-22 15:59:07','2021-05-22 15:58:07','2021-05-22 13:05:18'),('aaa@naver.com',1,10,'오예ㅋㅋㅋ',NULL,'2021-05-22 17:58:50','2021-05-22 16:05:44'),('aaa@naver.com',1,11,'오예ㄹㄹ',NULL,'2021-05-22 16:06:00','2021-05-22 16:05:48'),('aaa@naver.com',1,12,'오예',NULL,NULL,'2021-05-22 16:06:00'),('aaa@naver.com',1,13,'ui도 끝인가',NULL,'2021-05-22 17:59:03','2021-05-22 16:59:40'),('aaa@naver.com',1,14,'그렇게 해도 된다고??',NULL,NULL,'2021-05-22 23:52:03'),('aaa@naver.com',1,15,'ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ',NULL,'2021-05-23 18:06:43','2021-05-23 18:06:32'),('aaa@naver.com',1,16,'엥/////',NULL,'2021-05-23 18:07:20','2021-05-23 18:06:43'),('aaa@naver.com',1,17,'ㅋㅋㅋㅋㅋdhk....댓글입력하고 수정하면 왜....한번더하는거야reload해서그런가',NULL,'2021-05-23 18:09:18','2021-05-23 18:07:20'),('aaa@naver.com',1,18,'이러지말자...ㅋㅋ',NULL,'2021-05-23 18:11:06','2021-05-23 18:10:43'),('aaa@naver.com',1,19,'이러지말자...',NULL,NULL,'2021-05-23 18:11:06'),('aaa@naver.com',1,20,'너무 힘들다',NULL,NULL,'2021-05-23 18:14:11'),('aaa@naver.com',1,524,'얼마인가요?',NULL,NULL,'2021-05-23 18:22:12'),('aaa@naver.com',1,525,'제발.....ㅋㅋㅋ',NULL,'2021-05-23 18:42:46','2021-05-23 18:24:23'),('aaa@naver.com',1,526,'와......우ㅋㅋㅋㅋㅋ',NULL,'2021-05-23 18:43:13','2021-05-23 18:43:02'),('aaa@naver.com',1,527,'와......우',NULL,NULL,'2021-05-23 18:43:13'),('aaa@naver.com',1,528,'제발...!!!!!!!!!!!!!!!!',NULL,NULL,'2021-05-23 18:55:09'),('aaa@naver.com',1,529,'왜...........ㅋㅋ',NULL,'2021-05-23 18:55:40','2021-05-23 18:55:34'),('aaa@naver.com',1,530,'왜...........',NULL,NULL,'2021-05-23 18:55:41'),('aaa@naver.com',1,531,'이제 되겠지.....',NULL,NULL,'2021-05-23 19:11:10'),('aaa@naver.com',1,532,'될거야..................................',NULL,NULL,'2021-05-23 19:13:44'),('aaa@naver.com',1,533,'너무 힘들다',NULL,NULL,'2021-05-23 19:18:43'),('aaa@naver.com',1,534,'ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ',NULL,NULL,'2021-05-23 19:19:21'),('aaa@naver.com',1,535,'ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ',NULL,NULL,'2021-05-23 19:19:53'),('aaa@naver.com',1,536,'너무 힘들다',NULL,NULL,'2021-05-23 19:23:31'),('aaa@naver.com',1,537,'너무 힘들다',NULL,NULL,'2021-05-23 19:24:05'),('aaa@naver.com',1,538,'???',NULL,NULL,'2021-05-23 19:24:14'),('aaa@naver.com',1,539,'ㅋㅋㅋ',NULL,NULL,'2021-05-23 19:28:32'),('aaa@naver.com',1,540,'진짜 사고싶다',NULL,NULL,'2021-05-23 19:51:13'),('aaa@naver.com',1,541,'이번엔 성공하자ㅋㅋㅋㅋ',NULL,'2021-05-23 20:18:04','2021-05-23 20:17:18'),('aaa@naver.com',1,542,'너무 힘들다',NULL,NULL,'2021-05-23 20:18:10'),('aaa@naver.com',1,543,'???',NULL,NULL,'2021-05-23 20:18:21'),('aaa@naver.com',1,544,'뭐여',NULL,NULL,'2021-05-23 20:18:29'),('aaa@naver.com',1,545,'너무 힘들다',NULL,NULL,'2021-05-23 20:18:34'),('aaa@naver.com',1,546,'ㅋㅋㅋㅋ이제되는건가',NULL,NULL,'2021-05-23 20:20:13'),('aaa@naver.com',1,547,'','2021-05-23 23:39:56',NULL,'2021-05-23 20:22:08'),('aaa@naver.com',1,548,'ㅋㅋㅋㅋ','2021-05-23 23:39:53',NULL,'2021-05-23 20:24:51'),('aaa@naver.com',1,549,'zzzzzz','2021-05-23 23:39:48','2021-05-23 23:39:44','2021-05-23 23:39:38');
/*!40000 ALTER TABLE `comment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_notice`
--

DROP TABLE IF EXISTS `comment_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_notice` (
  `USER_EMAIL` varchar(100) NOT NULL,
  `NOTICE_N_NUM` int NOT NULL,
  `NC_DELETE` datetime DEFAULT NULL,
  `NC_EDIT` datetime DEFAULT NULL,
  `NC_REGIST` datetime DEFAULT NULL,
  `NC_CONTENT` text,
  `NC_NUM` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`NC_NUM`),
  KEY `fk_USER_has_NOTICE1_NOTICE1_idx` (`NOTICE_N_NUM`),
  KEY `fk_USER_has_NOTICE1_USER1_idx` (`USER_EMAIL`),
  CONSTRAINT `fk_USER_has_NOTICE1_NOTICE1` FOREIGN KEY (`NOTICE_N_NUM`) REFERENCES `notice` (`N_NUM`),
  CONSTRAINT `fk_USER_has_NOTICE1_USER1` FOREIGN KEY (`USER_EMAIL`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_notice`
--

LOCK TABLES `comment_notice` WRITE;
/*!40000 ALTER TABLE `comment_notice` DISABLE KEYS */;
INSERT INTO `comment_notice` VALUES ('aaa@naver.com',1,'2021-05-24 01:51:10','2021-05-24 01:51:02','2021-05-24 01:50:49','zzzzzzzzzzz',1),('aaa@naver.com',1,NULL,'2021-05-24 02:02:28','2021-05-24 02:00:29','aaaaazzzz',2),('aaa@naver.com',1,'2021-05-24 02:02:43',NULL,'2021-05-24 02:02:37','asadasd',3);
/*!40000 ALTER TABLE `comment_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_tip`
--

DROP TABLE IF EXISTS `comment_tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_tip` (
  `USER_EMAIL` varchar(100) NOT NULL,
  `TIP_T_NUM` int NOT NULL,
  `TC_NUM` int NOT NULL AUTO_INCREMENT,
  `TC_CONTENT` text,
  `TC_DELETE` datetime DEFAULT NULL,
  `TC_EDIT` datetime DEFAULT NULL,
  `TC_REGIST` datetime DEFAULT NULL,
  PRIMARY KEY (`TC_NUM`),
  KEY `fk_USER_has_TIP_TIP1_idx` (`TIP_T_NUM`),
  KEY `fk_USER_has_TIP_USER1_idx` (`USER_EMAIL`),
  CONSTRAINT `fk_USER_has_TIP_TIP1` FOREIGN KEY (`TIP_T_NUM`) REFERENCES `tip` (`T_NUM`),
  CONSTRAINT `fk_USER_has_TIP_USER1` FOREIGN KEY (`USER_EMAIL`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_tip`
--

LOCK TABLES `comment_tip` WRITE;
/*!40000 ALTER TABLE `comment_tip` DISABLE KEYS */;
INSERT INTO `comment_tip` VALUES ('aaa@naver.com',1,1,'gggggㅋㅋㅋ',NULL,'2021-05-24 00:49:33','2021-05-24 00:43:10'),('bbb@naver.com',1,2,'정말힘들다',NULL,NULL,'2021-05-24 00:44:23'),('aaa@naver.com',1,3,'싱기해',NULL,NULL,'2021-05-24 00:50:15');
/*!40000 ALTER TABLE `comment_tip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `I_NUM` int NOT NULL AUTO_INCREMENT,
  `I_TITLE` varchar(45) DEFAULT NULL,
  `I_CONTENT` text,
  `I_IMAGE` varchar(100) DEFAULT NULL,
  `I_CATEGORY` varchar(45) DEFAULT NULL,
  `I_HITS` int DEFAULT NULL,
  PRIMARY KEY (`I_NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'맥북','오늘 소개할 물건은 맥북입니다.','macBook.png','물건',1),(2,'맥북에어','오늘 소개할 물건은<br/><img_id=macBook.png><br/><img_id=macBook2.png><br/>입니다.','macBook.png,macBook2.png','물건',0),(3,'맥북프로','오늘 소개할 물건은<br/><img_id=macBook.png><br/><img_id=macBook2.png><br/>입니다.','macBook.png,macBook2.png','물건',0);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `N_NUM` int NOT NULL AUTO_INCREMENT,
  `N_TITLE` varchar(45) DEFAULT NULL,
  `N_CONTENT` text,
  `N_HITS` int DEFAULT NULL,
  PRIMARY KEY (`N_NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'공지입니다','오늘은 왜 잠이 안오는지 정말 신기하네',2);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip`
--

DROP TABLE IF EXISTS `tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tip` (
  `T_NUM` int NOT NULL AUTO_INCREMENT,
  `T_TITLE` varchar(45) DEFAULT NULL,
  `T_CONTENT` text,
  `T_IMAGE` varchar(100) DEFAULT NULL,
  `T_CATEGORY` varchar(45) DEFAULT NULL,
  `T_HITS` int DEFAULT NULL,
  PRIMARY KEY (`T_NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip`
--

LOCK TABLES `tip` WRITE;
/*!40000 ALTER TABLE `tip` DISABLE KEYS */;
INSERT INTO `tip` VALUES (1,'맥북에어','오늘 소개할 물건은<br/><img_id=macBook.png><br/><img_id=macBook2.png><br/>입니다.','macBook.png,macBook2.png','물건',0);
/*!40000 ALTER TABLE `tip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `EMAIL` varchar(100) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `PWD` varchar(45) NOT NULL,
  `ADRESS` varchar(100) DEFAULT NULL,
  `TEL` varchar(20) DEFAULT NULL,
  `GIT` varchar(100) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `DELETEDATE` datetime DEFAULT NULL,
  `ADMIN` int DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aaa@naver.com','홍길동','1234','경기도 화성시','010-2222-3333','aaa','2021-05-21 00:00:00',NULL,0),('admin','관리자','1234','서울','01011112222','admin','2021-05-18 00:00:00',NULL,1),('bbb@naver.com','이춘자','1234','강원도','010-8888-9999','bbb','2021-05-18 00:00:00',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `write_item`
--

DROP TABLE IF EXISTS `write_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `write_item` (
  `USER_EMAIL` varchar(100) NOT NULL,
  `ITEM_I_NUM` int NOT NULL,
  `IW_DELETE` datetime DEFAULT NULL,
  `IW_EDIT` datetime DEFAULT NULL,
  `IW_REGIST` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_I_NUM`,`USER_EMAIL`),
  KEY `fk_USER_has_ITEM_ITEM1_idx` (`ITEM_I_NUM`),
  KEY `fk_USER_has_ITEM_USER1_idx` (`USER_EMAIL`),
  CONSTRAINT `fk_USER_has_ITEM_ITEM1` FOREIGN KEY (`ITEM_I_NUM`) REFERENCES `item` (`I_NUM`),
  CONSTRAINT `fk_USER_has_ITEM_USER1` FOREIGN KEY (`USER_EMAIL`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `write_item`
--

LOCK TABLES `write_item` WRITE;
/*!40000 ALTER TABLE `write_item` DISABLE KEYS */;
INSERT INTO `write_item` VALUES ('aaa@naver.com',1,'2021-05-23 23:38:58','2021-05-25 01:34:04','2021-05-21 00:00:00'),('aaa@naver.com',2,NULL,'2021-05-25 01:33:29','2021-05-21 00:00:00'),('bbb@naver.com',3,NULL,NULL,'2021-05-21 00:00:00');
/*!40000 ALTER TABLE `write_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `write_notice`
--

DROP TABLE IF EXISTS `write_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `write_notice` (
  `USER_EMAIL` varchar(100) NOT NULL,
  `NOTICE_N_NUM` int NOT NULL,
  `NW_DELETE` varchar(45) DEFAULT NULL,
  `NW_EDIT` varchar(45) DEFAULT NULL,
  `NW_REGIST` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`NOTICE_N_NUM`),
  KEY `fk_USER_has_NOTICE_NOTICE1_idx` (`NOTICE_N_NUM`),
  KEY `fk_USER_has_NOTICE_USER1_idx` (`USER_EMAIL`),
  CONSTRAINT `fk_USER_has_NOTICE_NOTICE1` FOREIGN KEY (`NOTICE_N_NUM`) REFERENCES `notice` (`N_NUM`),
  CONSTRAINT `fk_USER_has_NOTICE_USER1` FOREIGN KEY (`USER_EMAIL`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `write_notice`
--

LOCK TABLES `write_notice` WRITE;
/*!40000 ALTER TABLE `write_notice` DISABLE KEYS */;
INSERT INTO `write_notice` VALUES ('admin',1,NULL,NULL,'2021-05-24');
/*!40000 ALTER TABLE `write_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `write_tip`
--

DROP TABLE IF EXISTS `write_tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `write_tip` (
  `USER_EMAIL` varchar(100) NOT NULL,
  `TIP_T_NUM` int NOT NULL,
  `TW_DELETE` datetime DEFAULT NULL,
  `TW_EDIT` datetime DEFAULT NULL,
  `TW_REGIST` datetime DEFAULT NULL,
  PRIMARY KEY (`TIP_T_NUM`),
  KEY `fk_USER_has_TIP_TIP2_idx` (`TIP_T_NUM`),
  KEY `fk_USER_has_TIP_USER2_idx` (`USER_EMAIL`),
  CONSTRAINT `fk_USER_has_TIP_TIP2` FOREIGN KEY (`TIP_T_NUM`) REFERENCES `tip` (`T_NUM`),
  CONSTRAINT `fk_USER_has_TIP_USER2` FOREIGN KEY (`USER_EMAIL`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `write_tip`
--

LOCK TABLES `write_tip` WRITE;
/*!40000 ALTER TABLE `write_tip` DISABLE KEYS */;
INSERT INTO `write_tip` VALUES ('aaa@naver.com',1,'2021-05-24 00:42:51',NULL,'2021-05-21 00:00:00');
/*!40000 ALTER TABLE `write_tip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 12:08:43
