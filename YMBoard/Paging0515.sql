CREATE DATABASE  IF NOT EXISTS `eclipse` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eclipse`;
-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: eclipse
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `paging`
--

DROP TABLE IF EXISTS `paging`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paging` (
  `no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `writer` varchar(45) DEFAULT NULL,
  `content` text,
  `date` datetime DEFAULT NULL,
  `filePath` text,
  PRIMARY KEY (`no`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paging`
--

LOCK TABLES `paging` WRITE;
/*!40000 ALTER TABLE `paging` DISABLE KEYS */;
INSERT INTO `paging` VALUES (1,'첫글이네요','윤재필','1빠!','2021-05-13 22:07:10',NULL),(2,'반갑습니다','차은우','특히 조효경씨 반가워요','2021-05-13 22:09:03',NULL),(3,'엉엉','이승연','엉엉엉','2021-05-13 22:09:13',NULL),(4,'화성에 갈끄니끄아','멜론머스크','근데 차는 빗코로 안팔거임 ㅋㅋ','2021-05-13 22:09:43',NULL),(5,'아직도 도지 안샀어?','멜론머스크','빨리사 내가 팔게','2021-05-13 22:09:55',NULL),(6,'여기 뭐하는게시판이죠?','윤재필','잡글이 많네','2021-05-13 22:10:11',NULL),(7,'더이상 쓸 말이 없는데요','윤재필','데이터는 더넣어야되네','2021-05-13 22:10:26',NULL),(8,'시라도 한편 쓸까요?','윤재필','쓸줄모르는구나','2021-05-13 22:11:12',NULL),(9,'나는 천재야','조효경','나는 천재니까','2021-05-13 22:11:26',NULL),(10,'저 충정도 살아요','최지연','살살안다뤄주시면 드랍합니다','2021-05-13 22:12:17',NULL),(11,'자물쇠좀 해주세요','박재원','이쁜 이미지루다가','2021-05-13 22:12:45',NULL),(12,'정처기 필기 합격 후기','오성아','교과서 위주로 했어요','2021-05-13 22:13:38',NULL),(13,'아 진짜 쓸거없는데 이제','윤재필','몇개쨰지 이개ㅔ','2021-05-13 22:13:54',NULL),(14,'아이디어가 고갈되가요','윤재필','그냥 아무글이나 복사할걸','2021-05-13 22:14:19',NULL),(15,'20개는 만들어야하는데','윤재필','그래도 반은넘게했다','2021-05-13 22:14:23',NULL),(16,'내용은 상관있...네 ','윤재필','잘 들어가나 확인해야지...','2021-05-13 22:14:48',NULL),(17,'ㅋㅋㄹㅃㅃ','윤재필','ㅋㅋㄹㅃㅃ','2021-05-13 22:15:05',NULL),(18,'효경누나 메이플함','윤재필','삽고수임','2021-05-13 22:15:15',NULL),(19,'디자인 너무 힘들었어요','윤재필','다들너무잘해','2021-05-13 22:15:28',NULL),(20,'롤할사람','이상혁','챌린저 미만이랑은 안함','2021-05-13 22:15:44',NULL),(21,'경계값 분석을 위해 ','윤재필','게시글수는 딱 안맞춥니다','2021-05-13 22:16:21',NULL),(22,'거의다 왔다','윤재필','22개째','2021-05-13 22:16:31',NULL),(23,'Wellcome^^','한경호','줌 들어오세요','2021-05-13 22:17:21','save/송가인1.jpg');
/*!40000 ALTER TABLE `paging` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-15  0:03:43
