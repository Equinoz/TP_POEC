-- MariaDB dump 10.19  Distrib 10.6.5-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	10.6.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `black_list`
--

DROP TABLE IF EXISTS `black_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `black_list` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa1eke8k55bevjqd15wx5q9ugn` (`client_id`),
  CONSTRAINT `FKa1eke8k55bevjqd15wx5q9ugn` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `black_list`
--

LOCK TABLES `black_list` WRITE;
/*!40000 ALTER TABLE `black_list` DISABLE KEYS */;
INSERT INTO `black_list` VALUES (2,6),(5,9);
/*!40000 ALTER TABLE `black_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `abonnement` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Dupont',0),(2,'Duchemin',1),(3,'Durand',1),(4,'Dumesnil',0),(5,'Legrand',0),(6,'Hook',1),(7,NULL,NULL),(8,'HookDeRetour',1),(9,'HookDeRetour3',1),(10,'Luke Skywalker',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `durée` bigint(20) DEFAULT NULL,
  `Producteur` varchar(100) DEFAULT NULL,
  `Réalisateur` varchar(100) DEFAULT NULL,
  `PEGI` varchar(100) DEFAULT NULL,
  `date_diffusion` date NOT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `lien_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`film_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Resident Evil : Bienvenue à Raccoon City',6420000000000,'Johannes Roberts','Constantin films','12','2021-11-24','Horreur','https://fr.web.img3.acsta.net/pictures/21/10/19/17/59/4466537.jpg'),(2,'Haut et Fort',6060000000000,'Nabil Ayouch',NULL,'3','2021-11-17','Drame','https://fr.web.img5.acsta.net/pictures/21/07/13/17/40/0679940.jpg'),(3,'On est fait pour s’entendre',5580000000000,'Pascal Elbé',NULL,'3','2021-11-17','Romance','https://fr.web.img2.acsta.net/pictures/21/10/12/10/55/0748351.jpg'),(4,'Affamés',5100000000000,'Scott Cooper',NULL,'12','2021-11-17','Horreur','https://images-na.ssl-images-amazon.com/images/S/pv-target-images/839ac2e53197ff1ac32b1ac6a1cc9c90b5c39a91630d328bed43ddbb81210b8f._RI_V_TTW_.jpg'),(5,'Amants',4920000000000,'Nicole Garcia',NULL,'3','2021-11-17','Thriller','https://fr.web.img6.acsta.net/pictures/21/06/18/15/59/3916836.jpg'),(6,'Les Bodin\'s en Thaïlande',4740000000000,'Frédéric Forestier',NULL,'3','2021-11-17','Comédie','http://www.les-bodins.fr/IMG/arton1039.jpg?1633012569'),(7,'Star Wars : La revanche des Siths',10800000000000,NULL,NULL,NULL,'3910-01-27','Science fiction','https://fr.web.img3.acsta.net/medias/nmedia/18/35/53/23/18423997.jpg'),(8,'Star Wars',10800000000000,'George Lucas',NULL,'12+','1970-01-03','Science fiction','https://fr.web.img3.acsta.net/medias/nmedia/18/35/41/62/18422602.jpg'),(9,'Star Wars',10800000000000,'George Lucas',NULL,'3+','1970-01-03','Science fiction','https://fr.web.img3.acsta.net/medias/nmedia/18/35/83/29/20017378.jpg');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `réservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `scéance_id` int(11) NOT NULL,
  `nombre_places` int(11) NOT NULL,
  `Réduction` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`réservation_id`),
  KEY `réservation_FK` (`scéance_id`) USING BTREE,
  KEY `réservation_FK_1` (`client_id`) USING BTREE,
  CONSTRAINT `reservation_FK` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `reservation_FK_1` FOREIGN KEY (`scéance_id`) REFERENCES `sceance` (`scéance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,1,4,5,'0'),(2,7,4,3,'0'),(3,5,11,2,'0'),(4,3,17,3,'0'),(5,4,12,1,'1'),(6,6,5,3,'1'),(7,7,4,3,'0'),(14,7,4,3,'0'),(15,1,4,5,NULL),(16,1,4,5,NULL),(17,1,1,1,NULL),(18,1,1,3,NULL),(19,10,7,3,NULL);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salle` (
  `salle_id` int(11) NOT NULL AUTO_INCREMENT,
  `capacité` int(11) NOT NULL,
  `numéro_salle` int(11) NOT NULL,
  `équipement_3D` tinyint(1) NOT NULL,
  `cinemas_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`salle_id`),
  KEY `salle_FK` (`cinemas_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle`
--

LOCK TABLES `salle` WRITE;
/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` VALUES (1,100,1,1,NULL),(2,50,2,0,NULL),(3,70,3,1,NULL),(4,70,4,0,NULL),(5,50,5,0,NULL),(6,70,6,0,NULL);
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sceance`
--

DROP TABLE IF EXISTS `sceance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sceance` (
  `scéance_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `horaire_scéance` datetime DEFAULT NULL,
  `durée_réclams` bigint(20) DEFAULT NULL,
  `prix` int(11) NOT NULL,
  `salle_id` int(11) NOT NULL,
  `occupation` int(11) DEFAULT NULL,
  `VOSTFR` tinyint(1) DEFAULT NULL,
  `place_restante` int(11) NOT NULL,
  PRIMARY KEY (`scéance_id`),
  KEY `scéance_FK` (`film_id`) USING BTREE,
  KEY `scéance_FK_1` (`salle_id`) USING BTREE,
  CONSTRAINT `sceance_FK` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`),
  CONSTRAINT `sceance_FK_1` FOREIGN KEY (`salle_id`) REFERENCES `salle` (`salle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sceance`
--

LOCK TABLES `sceance` WRITE;
/*!40000 ALTER TABLE `sceance` DISABLE KEYS */;
INSERT INTO `sceance` VALUES (1,1,'2021-12-01 17:00:00',900000000000,9,1,100,1,0),(2,1,'2021-11-20 19:45:00',900000000000,9,1,100,0,0),(3,1,'2021-11-19 22:00:00',900000000000,9,1,50,0,0),(4,2,'2022-01-11 12:00:00',600000000000,9,3,60,0,0),(5,2,'2021-11-19 18:10:00',600000000000,9,3,40,1,0),(6,2,'2021-11-19 19:45:00',600000000000,9,3,45,1,0),(7,3,'2021-11-19 15:45:00',900000000000,9,2,35,0,0),(8,3,'2021-11-19 20:00:00',900000000000,9,2,45,0,0),(9,3,'2021-11-19 22:10:00',900000000000,9,2,30,0,0),(10,4,'2021-11-19 15:45:00',600000000000,9,4,20,0,0),(11,4,'2021-11-19 17:55:00',600000000000,9,4,45,1,0),(12,4,'2021-11-19 20:05:00',600000000000,9,4,65,0,0),(13,4,'2021-11-19 22:15:00',600000000000,9,4,50,0,0),(14,5,'2021-11-19 15:55:00',900000000000,9,1,20,0,0),(15,5,'2021-11-19 17:50:00',900000000000,9,1,30,0,0),(16,5,'2021-11-19 20:05:00',900000000000,9,5,40,0,0),(17,5,'2021-11-19 22:15:00',900000000000,9,5,40,0,0),(18,6,'2021-11-19 15:45:00',900000000000,9,6,43,0,0),(19,6,'2021-11-19 17:55:00',900000000000,9,6,54,0,0),(20,6,'2021-11-19 20:05:00',900000000000,9,6,60,0,0),(21,6,'2021-11-19 22:15:00',900000000000,9,6,32,0,0),(22,1,'2022-01-19 17:55:00',NULL,5,3,0,0,0);
/*!40000 ALTER TABLE `sceance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-27 16:10:18
