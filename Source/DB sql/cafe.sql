-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cafe
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `UserID` varchar(45) DEFAULT NULL,
  `Contents` varchar(100) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('Ice','아메리카노(아이스, 샷추가), 딸기우유라떼(아이스), 카라멜크로넛(해당없음)',11500,0,12),('Kim','아메리카노(아이스, 샷추가), 딸기우유라떼(아이스), 쿠키크로넛(해당없음)',11500,1,13),('Kim','꿀아메리카노(샷추가)',3000,1,14);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Manager` tinyint(1) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('aa','aa',NULL,NULL,'aa'),('aa1','aa1',2,NULL,'aa1'),('abcd','abcd',2,'esy3pTKT9zk:APA91bG8PPiYZ0RHjUMm-VOQZiTwBlXn8KriFmVlrmmft5UIHqCcHH0v2igsvxqz-cZdocZWTl77Zvc_vHSXGOLU1y9QmemwWFcw9-DwqEvOc7mnjvgkK5c-gscOA4kKFU84Rb-QX5tr','abcd'),('Admin','password',1,'dds4PjYPgBs:APA91bFWtr4U1mYAUFwBXO9jPjxVV_FY0-dXP0dt7Nez5eEuBmHQdjZi4myOM-GJ15eH4p2u8YmwoARMA5KYcJmLkMSxaQzdkvJgN0JLJPpDlFxE3KQNnYBzxZuju81UuXWfnJynx5Gr',NULL),('Americano','123123',2,'esy3pTKT9zk:APA91bG8PPiYZ0RHjUMm-VOQZiTwBlXn8KriFmVlrmmft5UIHqCcHH0v2igsvxqz-cZdocZWTl77Zvc_vHSXGOLU1y9QmemwWFcw9-DwqEvOc7mnjvgkK5c-gscOA4kKFU84Rb-QX5tr','abcd@naver.com'),('Gachon','123123',2,'esy3pTKT9zk:APA91bG8PPiYZ0RHjUMm-VOQZiTwBlXn8KriFmVlrmmft5UIHqCcHH0v2igsvxqz-cZdocZWTl77Zvc_vHSXGOLU1y9QmemwWFcw9-DwqEvOc7mnjvgkK5c-gscOA4kKFU84Rb-QX5tr','Gachon@gmail.com'),('Ice','123123',2,'esy3pTKT9zk:APA91bG8PPiYZ0RHjUMm-VOQZiTwBlXn8KriFmVlrmmft5UIHqCcHH0v2igsvxqz-cZdocZWTl77Zvc_vHSXGOLU1y9QmemwWFcw9-DwqEvOc7mnjvgkK5c-gscOA4kKFU84Rb-QX5tr','Ice@naver.com'),('Kim','123123',2,'esy3pTKT9zk:APA91bG8PPiYZ0RHjUMm-VOQZiTwBlXn8KriFmVlrmmft5UIHqCcHH0v2igsvxqz-cZdocZWTl77Zvc_vHSXGOLU1y9QmemwWFcw9-DwqEvOc7mnjvgkK5c-gscOA4kKFU84Rb-QX5tr','Kim@naver.com'),('kkk','kkk',2,'dds4PjYPgBs:APA91bFWtr4U1mYAUFwBXO9jPjxVV_FY0-dXP0dt7Nez5eEuBmHQdjZi4myOM-GJ15eH4p2u8YmwoARMA5KYcJmLkMSxaQzdkvJgN0JLJPpDlFxE3KQNnYBzxZuju81UuXWfnJynx5Gr','kkk@g.com'),('psps','123123',2,'esy3pTKT9zk:APA91bG8PPiYZ0RHjUMm-VOQZiTwBlXn8KriFmVlrmmft5UIHqCcHH0v2igsvxqz-cZdocZWTl77Zvc_vHSXGOLU1y9QmemwWFcw9-DwqEvOc7mnjvgkK5c-gscOA4kKFU84Rb-QX5tr','psps@psps');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-21 22:37:57
