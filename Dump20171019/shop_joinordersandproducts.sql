-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `joinordersandproducts`
--

DROP TABLE IF EXISTS `joinordersandproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `joinordersandproducts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `orders_id` bigint(20) DEFAULT NULL,
  `products_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2930F82CD1427CCF` (`orders_id`),
  KEY `FK2930F82C58D3830` (`products_id`),
  CONSTRAINT `FK2930F82C58D3830` FOREIGN KEY (`products_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK2930F82CD1427CCF` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joinordersandproducts`
--

LOCK TABLES `joinordersandproducts` WRITE;
/*!40000 ALTER TABLE `joinordersandproducts` DISABLE KEYS */;
INSERT INTO `joinordersandproducts` VALUES (1,1,71,2),(2,1,71,1),(3,1,72,2),(4,1,72,1),(5,1,73,2),(6,2,73,1),(7,2,73,1),(8,2,74,1),(9,1,74,2),(10,2,75,1),(11,2,75,2),(12,1,76,1),(13,1,76,2),(14,1,76,3),(15,4,77,1),(16,1,78,1),(17,1,78,2),(18,1,79,1),(19,1,79,2),(20,1,80,1),(21,1,80,2),(22,1,80,5),(23,1,81,2),(24,1,81,3),(25,1,81,5),(26,1,82,2),(27,1,82,3),(28,1,82,4),(29,8,83,1),(30,1,84,2),(31,1,84,5),(32,1,85,3),(33,1,85,4),(34,1,86,1),(35,1,86,2),(36,1,86,3),(37,1,87,2),(38,1,87,3),(39,4,88,1),(40,1,88,2),(41,1,88,4),(42,2,89,1),(43,1,89,2),(44,2,89,4),(45,1,89,5),(46,3,90,1),(47,1,90,2),(48,1,90,3),(49,1,90,4),(50,1,90,5),(51,3,91,1),(52,3,91,2),(53,2,92,1),(54,3,92,2),(55,2,93,1),(56,3,93,2),(57,3,94,1),(58,2,94,2),(59,3,95,1),(60,2,95,2),(61,5,96,1),(62,2,96,3),(63,2,96,5),(64,2,97,1),(65,3,97,3),(66,2,97,5),(67,4,98,1),(68,1,98,5),(69,4,99,1),(70,2,99,4),(71,2,100,1),(72,2,100,2),(73,3,101,1),(74,1,101,4),(75,2,101,5),(76,2,102,1),(77,2,102,2),(78,2,102,3);
/*!40000 ALTER TABLE `joinordersandproducts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-19 12:58:15
