-- MySQL dump 10.14  Distrib 5.5.47-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db_passi
-- ------------------------------------------------------
-- Server version	5.5.47-MariaDB-1~wheezy-log

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
-- Table structure for table `answerpoints`
--

DROP TABLE IF EXISTS `answerpoints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerpoints` (
  `answerpoint_id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_text` varchar(500) COLLATE utf8_swedish_ci NOT NULL,
  `instructor_comment` varchar(1000) COLLATE utf8_swedish_ci NOT NULL DEFAULT '',
  `instructor_rating` tinyint(4) NOT NULL DEFAULT '0',
  `image_url` varchar(80) COLLATE utf8_swedish_ci DEFAULT NULL,
  `answersheet_id` int(11) NOT NULL,
  `waypoint_id` int(11) NOT NULL,
  `option_id` int(11) NOT NULL,
  PRIMARY KEY (`answerpoint_id`),
  KEY `fk_answerpoints_answersheets` (`answersheet_id`),
  KEY `fk_answerpoints_waypoints` (`waypoint_id`),
  KEY `fk_answerpoints_options` (`option_id`),
  CONSTRAINT `fk_answerpoints_answersheets` FOREIGN KEY (`answersheet_id`) REFERENCES `answersheets` (`answersheet_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_answerpoints_options` FOREIGN KEY (`option_id`) REFERENCES `options` (`option_id`),
  CONSTRAINT `fk_answerpoints_waypoints` FOREIGN KEY (`waypoint_id`) REFERENCES `waypoints` (`waypoint_id`)
) ENGINE=InnoDB AUTO_INCREMENT=720 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerpoints`
--

LOCK TABLES `answerpoints` WRITE;
/*!40000 ALTER TABLE `answerpoints` DISABLE KEYS */;
INSERT INTO `answerpoints` VALUES (539,'Jfkfjgg','Kelvoton vastaus!',3,'13-5.jpg',115,13,37),(540,'Kfjgjhg','Mitä sikailua tämä on?',3,'14-5.jpg',115,14,41),(541,'C ku dkxjc','Terveydenhoitaja auttaa myös psyykkisissä ongelmissa 09-12.',3,'15-5.jpg',115,15,43),(547,'vob','Näköjään vintti on pimentynyt?',2,'11-5.jpg',117,11,32),(548,'ibibk','Suosittelen kytkemään valot päälle valokuvauksen ajaksi.',2,'12-5.jpg',117,12,34),(554,' tyt4','',0,'',119,83,246),(555,'hh','Ui juma',1,'92-5.jpg',120,92,273),(556,'jj\n','Jaaaapajaapa',2,'',120,93,276),(557,'vVB','moimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoimoim',2,'',121,9,25),(558,'jsjsjj','kjnbbnbnb',1,'',121,10,29),(559,'jjsjs','hhffhfhfh',3,'22-5.jpg',122,22,64),(560,'hSj','',0,'23-5.jpg',122,23,68),(561,'vzsj','',0,'24-5.jpg',122,24,71),(580,'ususua','',0,'140-5.jpg',127,140,418),(581,'yeue','',0,'141-5.jpg',127,141,421),(582,'ddhdhd\n','',0,'142-5.jpg',127,142,425),(583,'uwwu','',0,'143-5.jpg',127,143,429),(584,'dhdh','',0,'144-5.jpg',127,144,430),(585,'bsbs','dcd',1,'32-5.jpg',128,32,95),(586,'hh','bhbbb',3,'33-5.jpg',128,33,99),(587,'ggio','',0,'34-5.jpg',128,34,100),(588,'g','',0,'45-5.jpg',129,45,134),(594,'toimii','arvio 12',2,'1-13.jpg',131,1,1),(595,'toimii','hienoa',2,'2-13.jpg',131,2,5),(596,'hyvin hoidettu','',0,'3-13.jpg',131,3,7),(597,'korjattavaa','',0,'4-13.jpg',131,4,11),(598,'ei toimi','',0,'5-13.jpg',131,5,15),(604,'sillälailla','vtrf',2,'1-8.jpg',133,1,2),(605,'sillälailla','asdafdczcsafdsvds arv 11',3,'2-8.jpg',133,2,5),(606,'sillälailla','',0,'3-8.jpg',133,3,8),(607,'sillälailla','',0,'4-8.jpg',133,4,11),(608,'sillälailla','',0,'5-8.jpg',133,5,14),(670,'','',0,'78-5.jpg',155,78,232),(671,'','',0,'79-5.jpg',155,79,236),(672,'','',0,'80-5.jpg',155,80,240),(673,'Selostus','',0,'',156,30,88),(674,'Selostus ','',0,'',156,31,92),(675,'Selostus ','',0,'',156,32,96),(676,'','',0,'',156,33,97),(677,'Sep','1',2,'62-5.jpg',157,62,185),(678,'Dep','2',2,'63-5.jpg',157,63,187),(679,'Hep','3',3,'64-5.jpg',157,64,192),(680,'Ei','',0,'68-5.jpg',158,68,202),(681,'Eiei','',0,'69-5.jpg',158,69,206),(682,'Jaja','',0,'70-5.jpg',158,70,208),(683,'Cacaa','',0,'71-5.jpg',158,71,211),(684,'Caaa','',0,'72-5.jpg',158,72,216),(685,'jddh','',0,'1-9.jpg',159,1,1),(686,'jsjsj','',0,'2-9.jpg',159,2,5),(687,'jdjd','',0,'3-9.jpg',160,3,8),(688,'hahahah','',0,'4-9.jpg',160,4,11),(689,'jfjfjd','',0,'5-9.jpg',161,5,13),(690,'jjdjj','',0,'6-9.jpg',161,6,17),(691,'jdjdjzj','',0,'7-9.jpg',161,7,21),(692,'bzzb','',0,'16-9.jpg',162,16,46),(693,'jzjdjj','',0,'17-9.jpg',162,17,50),(694,'jsjh','',0,'18-9.jpg',162,18,54),(695,'jdgbzb','',0,'37-9.jpg',163,37,109),(696,'fjzzjj','',0,'38-9.jpg',163,38,114),(697,'jjzzj','',0,'39-9.jpg',163,39,116),(698,'djdj','',0,'73-9.jpg',164,73,217),(699,'jdjd','',0,'74-9.jpg',164,74,221),(700,'jddj','',0,'75-9.jpg',164,75,225),(701,'jdjz','',0,'76-9.jpg',164,76,228),(702,'seppo','',0,'77-9.jpg',164,77,230),(703,'Bj','',0,'16-5.jpg',165,16,46),(704,'Hhhhhhhh','',0,'17-5.jpg',165,17,50),(705,'Hhh','',0,'18-5.jpg',165,18,54),(706,'Nomia','',0,'3-5.jpg',166,3,7),(707,'Meh','',0,'4-5.jpg',166,4,12),(708,'Wanhaa1','',0,'3-12.jpg',167,3,7),(709,'Uutta','',0,'4-12.jpg',167,4,12),(710,'Vastaus','',0,'1-5.jpg',168,1,2),(711,'jsuu','',0,'2-5.jpg',168,2,4),(712,'jsjsjsj','',0,'37-12.jpg',169,37,111),(713,'ysysy','',0,'38-12.jpg',169,38,112),(714,'jdjudj','',0,'39-12.jpg',169,39,116),(715,'jsjsh','',0,'1-12.jpg',170,1,1),(716,'udydu','',0,'2-12.jpg',170,2,6),(717,'jdjj','',0,'16-12.jpg',171,16,46),(718,'jfjj','',0,'17-12.jpg',171,17,49),(719,'jxdjs','',0,'18-12.jpg',171,18,53);
/*!40000 ALTER TABLE `answerpoints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answersheets`
--

DROP TABLE IF EXISTS `answersheets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answersheets` (
  `answersheet_id` int(11) NOT NULL AUTO_INCREMENT,
  `planning` varchar(1000) COLLATE utf8_swedish_ci NOT NULL,
  `instructor_comment` varchar(1000) COLLATE utf8_swedish_ci DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `worksheet_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`answersheet_id`),
  KEY `fk_answersheets_worksheets` (`worksheet_id`),
  KEY `fk_answersheets_groups` (`group_id`),
  KEY `fk_answersheets_users` (`user_id`),
  CONSTRAINT `fk_answersheets_groups` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_answersheets_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_answersheets_worksheets` FOREIGN KEY (`worksheet_id`) REFERENCES `worksheets` (`worksheet_id`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answersheets`
--

LOCK TABLES `answersheets` WRITE;
/*!40000 ALTER TABLE `answersheets` DISABLE KEYS */;
INSERT INTO `answersheets` VALUES (115,'Halvin f k c b ','','2016-11-01 12:44:15',5,1,5),(117,' j8vj8vj','','2016-11-01 13:11:35',4,1,5),(119,'ybyj','','2016-11-08 10:51:24',27,1,5),(120,'yy','','2016-11-08 11:54:11',37,1,5),(121,'juauw','','2016-11-08 12:04:08',3,1,5),(122,'jsjauau','','2016-11-08 12:37:32',8,1,5),(127,'ysyaay','','2016-11-10 12:33:57',52,1,5),(128,'naks','','2016-11-10 13:10:08',11,1,5),(129,'v','','2016-11-10 13:16:10',15,1,5),(131,'toimii','','2016-11-15 10:09:05',1,3,13),(133,'sillälailla','','2016-11-15 15:55:32',1,2,8),(155,'Täytä t. Vilkku','','2016-11-22 10:28:12',22,1,5),(156,'suunnitelmia','','2016-11-22 10:33:09',10,1,5),(157,'JsjsJjsjdk','','2016-11-22 10:46:25',18,1,5),(158,'Juu','','2016-11-22 10:52:59',20,1,5),(159,'dkkddk','','2016-11-22 13:18:01',1,2,9),(160,'ysyh','','2016-11-22 13:35:55',2,3,9),(161,'jjj','','2016-11-22 13:38:34',3,1,9),(162,'jsjsj','','2016-11-22 13:45:53',6,1,9),(163,'kfk','','2016-11-22 13:47:07',12,1,9),(164,'jdsj','','2016-11-22 13:54:20',21,1,9),(165,'Hhhhh','','2016-11-22 14:12:27',6,1,5),(166,'Ergo','','2016-11-22 14:17:36',2,3,5),(167,'Wanhaa','','2016-11-24 07:31:19',2,3,12),(168,'Tämä on suunnitelma','','2016-11-24 08:28:30',1,1,5),(169,'jdjdjsj','','2016-11-24 09:49:50',12,3,12),(170,'hdjdj','','2016-11-24 10:02:49',1,3,12),(171,'ujdjsjs','','2016-11-24 10:04:10',6,3,12);
/*!40000 ALTER TABLE `answersheets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(80) COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Ammatin työkykyvalmiudet'),(2,'Toiminta- ja työkykyä edistävä liikunta'),(3,'Terveysosaaminen'),(4,'Harrastuneisuus ja yhteistyötaidot'),(5,'Työkykyvalmiuksien vahvistaminen');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distros`
--

DROP TABLE IF EXISTS `distros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distros` (
  `group_id` int(11) NOT NULL,
  `worksheet_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`,`worksheet_id`),
  KEY `fk_distros_worksheets` (`worksheet_id`),
  CONSTRAINT `fk_distros_groups` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_distros_worksheets` FOREIGN KEY (`worksheet_id`) REFERENCES `worksheets` (`worksheet_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distros`
--

LOCK TABLES `distros` WRITE;
/*!40000 ALTER TABLE `distros` DISABLE KEYS */;
INSERT INTO `distros` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(3,10),(3,11),(3,12),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(3,21),(3,22),(36,1),(36,2),(36,3),(36,4),(36,5),(36,6),(36,7),(36,8),(36,9),(36,10),(36,11),(36,12),(36,13),(36,14),(36,15),(36,16),(36,17),(36,18),(36,19),(36,20),(36,21),(36,22);
/*!40000 ALTER TABLE `distros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(80) COLLATE utf8_swedish_ci NOT NULL,
  `group_key` varchar(20) COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'Puualan perustutkinto, Stadin ammattiopisto','kampiakseli'),(2,'Tieto- ja tietoliikennetekniikan perustutkinto, Stadin ammattiopisto','guru'),(3,'Autoalan perustutkinto, Omnian ammattiopisto: AUTB6','kauppias'),(36,'Micaro\'s Elite Group','possessiivisuffiksi');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`),
  KEY `fk_members_groups` (`group_id`),
  CONSTRAINT `fk_members_groups` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_members_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (2,1),(2,2),(2,3),(3,2),(4,3),(5,1),(5,2),(5,3),(5,36),(6,1),(7,1),(8,2),(9,1),(9,2),(9,3),(10,2),(11,3),(12,3),(13,3),(14,1),(14,2),(14,3),(22,2),(28,36);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `options` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_text` varchar(255) COLLATE utf8_swedish_ci NOT NULL,
  `waypoint_id` int(11) NOT NULL,
  PRIMARY KEY (`option_id`),
  KEY `fk_options_waypoints` (`waypoint_id`),
  CONSTRAINT `fk_options_waypoints` FOREIGN KEY (`waypoint_id`) REFERENCES `waypoints` (`waypoint_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (1,'Erittäin yleinen',1),(2,'Kohtalaisen yleinen',1),(3,'Harvinainen',1),(4,'Erittäin yleinen',2),(5,'Kohtalaisen yleinen',2),(6,'Harvinainen',2),(7,'Raskas',3),(8,'Kohtalaisen raskas',3),(9,'Kevyt',3),(10,'Raskas',4),(11,'Kohtalaisen raskas',4),(12,'Kevyt',4),(13,'Paljon valmistelua',5),(14,'Jonkun verran valmistelua',5),(15,'Vähän tai ei lainkaan valmistelua',5),(16,'Tehdään yksin',6),(17,'Tehdään työkaverin tai asiakkaan kanssa',6),(18,'Yksin ja muiden kanssa',6),(19,'Paljon asioita',7),(20,'Jonkun verran asioita',7),(21,'Vähän asioita',7),(22,'Ok',8),(23,'Korjattavaa',8),(24,'Selkeitä puutteita',8),(25,'Ok',9),(26,'Korjattavaa',9),(27,'Selkeitä puutteita',9),(28,'Ok',10),(29,'Korjattavaa',10),(30,'Selkeitä puutteita',10),(31,'Ok',11),(32,'Korjattavaa',11),(33,'Selkeitä puutteita',11),(34,'Ok',12),(35,'Korjattavaa',12),(36,'Selkeitä puutteita',12),(37,'Jatkuvasti',13),(38,'Melko usein',13),(39,'Harvemmin',13),(40,'Jatkuvasti',14),(41,'Melko usein',14),(42,'Harvemmin',14),(43,'Jatkuvasti',15),(44,'Melko usein',15),(45,'Harvemmin',15),(46,'Alle 3 tuntia',16),(47,'3-5 tuntia',16),(48,'Yli 5 tuntia',16),(49,'Alle 3 tuntia',17),(50,'3-5 tuntia',17),(51,'Yli 5 tuntia',17),(52,'Alle 3 tuntia',18),(53,'3-5 tuntia',18),(54,'Yli 5 tuntia',18),(55,'Huippu hyvin!',19),(56,'Vähän jäi parannettavaa',19),(57,'Huonosti, yritän uudelleen',19),(58,'Huippu hyvin!',20),(59,'Vähän jäi parannettavaa',20),(60,'Huonosti, yritän uudelleen',20),(61,'Huippu hyvin!',21),(62,'Vähän jäi parannettavaa',21),(63,'Huonosti, yritän uudelleen',21),(64,'Huippu hyvin!',22),(65,'Vähän jäi parannettavaa',22),(66,'Huonosti, yritän uudelleen',22),(67,'Huippu hyvin!',23),(68,'Vähän jäi parannettavaa',23),(69,'Huonosti, yritän uudelleen',23),(70,'Hyvä fiilis',24),(71,'Kohtalainen fiilis',24),(72,'Huono fiilis',24),(73,'Hyvä fiilis',25),(74,'Kohtalainen fiilis',25),(75,'Huono fiilis',25),(76,'Hyvä fiilis',26),(77,'Kohtalainen fiilis',26),(78,'Huono fiilis',26),(79,'Paljon',27),(80,'Jonkun verran',27),(81,'Ei yhtään',27),(82,'Paljon',28),(83,'Jonkun verran',28),(84,'Ei yhtään',28),(85,'Paljon',29),(86,'Jonkun verran',29),(87,'Ei yhtään',29),(88,'Suuri',30),(89,'Kohtalainen',30),(90,'Pieni',30),(91,'Suuri',31),(92,'Kohtalainen',31),(93,'Pieni',31),(94,'Pieni',32),(95,'Kohtalainen',32),(96,'Suuri',32),(97,'Pieni',33),(98,'Kohtalainen',33),(99,'Suuri',33),(100,'Suuri',34),(101,'Kohtalainen',34),(102,'Pieni',34),(103,'Suuri',35),(104,'Kohtalainen',35),(105,'Pieni',35),(106,'Suuri',36),(107,'Kohtalainen',36),(108,'Pieni',36),(109,'Aurinko',37),(110,'Kilpi',37),(111,'Sydän',37),(112,'Aurinko',38),(113,'Kilpi',38),(114,'Sydän',38),(115,'Aurinko',39),(116,'Kilpi',39),(117,'Sydän',39),(118,'Kyllä',40),(119,'Kohtalaisen helppoa',40),(120,'Ei',40),(121,'Kyllä',41),(122,'Kohtalaisen helppoa',41),(123,'Ei',41),(124,'Kyllä',42),(125,'Kohtalaisen helppoa',42),(126,'Ei',42),(127,'Tottkai on!',43),(128,'Vähän olisi parannettavaa',43),(129,'Ei se kyllä ole',43),(130,'Tottkai on!',44),(131,'Vähän olisi parannettavaa',44),(132,'Ei se kyllä ole',44),(133,'Tottkai on!',45),(134,'Vähän olisi parannettavaa',45),(135,'Ei se kyllä ole',45),(136,'Tottkai on!',46),(137,'Vähän olisi parannettavaa',46),(138,'Ei se kyllä ole',46),(139,'Tottkai on!',47),(140,'Vähän olisi parannettavaa',47),(141,'Ei se kyllä ole',47),(142,'Kyllä',48),(143,'Jossain määrin',48),(144,'En lainkaan',48),(145,'Kyllä',49),(146,'Jossain määrin',49),(147,'En lainkaan',49),(148,'Kyllä',50),(149,'Jossain määrin',50),(150,'En lainkaan',50),(151,'Kyllä',51),(152,'Jossain määrin',51),(153,'En lainkaan',51),(154,'Hyvä fiilis',52),(155,'Kohtalainen fiilis',52),(156,'Huono fiilis',52),(157,'Hyvä fiilis',53),(158,'Kohtalainen fiilis',53),(159,'Huono fiilis',53),(160,'Hyvä fiilis',54),(161,'Kohtalainen fiilis',54),(162,'Huono fiilis',54),(163,'Hyvä fiilis',55),(164,'Kohtalainen fiilis',55),(165,'Huono fiilis',55),(166,'Hyvä fiilis',56),(167,'Kohtalainen fiilis',56),(168,'Huono fiilis',56),(169,'Tärkeä',57),(170,'Jokseenkin tärkeä',57),(171,'Ei kovin tärkeä',57),(172,'Tärkeä',58),(173,'Jokseenkin tärkeä',58),(174,'Ei kovin tärkeä',58),(175,'Tärkeä',59),(176,'Jokseenkin tärkeä',59),(177,'Ei kovin tärkeä',59),(178,'Tärkeä',60),(179,'Jokseenkin tärkeä',60),(180,'Ei kovin tärkeä',60),(181,'Tärkeä',61),(182,'Jokseenkin tärkeä',61),(183,'Ei kovin tärkeä',61),(184,'Erittäin tärkeä',62),(185,'Kohtalaisen tärkeä',62),(186,'Vähän tai ei lainkaan tärkeä',62),(187,'Erittäin tärkeä',63),(188,'Kohtalaisen tärkeä',63),(189,'Vähän tai ei lainkaan tärkeä',63),(190,'Erittäin tärkeä',64),(191,'Kohtalaisen tärkeä',64),(192,'Vähän tai ei lainkaan tärkeä',64),(193,'Todella viihtyisä!',65),(194,'Melko viihtyisä',65),(195,'Ihan ok',65),(196,'Todella viihtyisä!',66),(197,'Melko viihtyisä',66),(198,'Ihan ok',66),(199,'Katastrofi!',67),(200,'Melko paha',67),(201,'Vähän parannettavaa',67),(202,'Kyllä, sopiva',68),(203,'Ei, vaatisi enemmän aikaa',68),(204,'Ei, ajankäyttöä tulisi vähentää',68),(205,'Kyllä, sopiva',69),(206,'Ei, vaatisi enemmän aikaa',69),(207,'Ei, ajankäyttöä tulisi vähentää',69),(208,'Kyllä, sopiva',70),(209,'Ei, vaatisi enemmän aikaa',70),(210,'Ei, ajankäyttöä tulisi vähentää',70),(211,'Kyllä, sopiva',71),(212,'Ei, vaatisi enemmän aikaa',71),(213,'Ei, ajankäyttöä tulisi vähentää',71),(214,'Kyllä, sopiva',72),(215,'Ei, vaatisi enemmän aikaa',72),(216,'Ei, ajankäyttöä tulisi vähentää',72),(217,'Kyllä, täysin',73),(218,'Kyllä, osittain',73),(219,'En',73),(220,'Kyllä, täysin',74),(221,'Kyllä, osittain',74),(222,'En',74),(223,'Kyllä, täysin',75),(224,'Kyllä, osittain',75),(225,'En',75),(226,'Kyllä, täysin',76),(227,'Kyllä, osittain',76),(228,'En',76),(229,'Kyllä, täysin',77),(230,'Kyllä, osittain',77),(231,'En',77),(232,'Hyvä fiilis',78),(233,'Kohtalainen fiilis',78),(234,'Huono fiilis',78),(235,'Hyvä fiilis',79),(236,'Kohtalainen fiilis',79),(237,'Huono fiilis',79),(238,'Hyvä fiilis',80),(239,'Kohtalainen fiilis',80),(240,'Huono fiilis',80);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roles` (`role_id`),
  CONSTRAINT `fk_user_role_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,2),(2,2),(3,2),(4,2),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(22,1),(28,2),(29,2),(30,2),(31,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_swedish_ci NOT NULL,
  `password` varchar(80) COLLATE utf8_swedish_ci NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `firstname` varchar(40) COLLATE utf8_swedish_ci NOT NULL,
  `lastname` varchar(60) COLLATE utf8_swedish_ci NOT NULL,
  `email` varchar(80) COLLATE utf8_swedish_ci NOT NULL,
  `phone` varchar(40) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$08$S9tlOY2cVu7fRsbDcmib9OP27Qc7lVMwgeVb2Clw0MnmFf6eavXJa',1,'admin','admin','admin@admin','0123456789'),(2,'tuuti','$2a$08$wHneaZa499czVFjMJ4zb6OMCThaY/F9LdivDHnxwfUcokatPEmmU2',1,'Tuulikki','Terävä','tuulikki.terava@stadia.fi','0443356898'),(3,'annol','$2a$08$bdfvwjrdSI8LE6sIynExXOQ8bgvju0g9wD.hjbtQg8ixvTktZYfMC',1,'Anneli','Ollinen','anneli.ollinen@hus.fi','0446558332'),(4,'raisi','$2a$08$MjOQcJDprWYohyw42YrQgeKajEUwlbQQHRrRc/w83rqmfDdFnz2m.',1,'Raimo','Silander','raimo.silander@slk.fi','0504452336'),(5,'jaapa','$2a$08$Rr1NT1jmnlP67S7zmsHsPeApfCxvqkLJybwzDdeJsB.3SL9BEiidq',1,'Jaakko','Pavunvarsi','jaakko.pavunvarsi@gmail.com','0443365885'),(6,'timri','$2a$08$A6dBjnQo4ahyt9SXvlhriuqMkDDXp3EX08MEhYwpooWaANOnGdYwu',1,'Timo','Rissanen','timo.rissanen@outlook.com','0412552335'),(7,'juses','$2a$08$ureV/2ZXwTtnsz4oobThLeyTxJ.oeWEnom5w3ePzpPKowjEVmNtmy',1,'Jussi','Eskola','jussi.eskola@yahoo.com','0413365297'),(8,'siiny','$2a$08$lJ0aUR8jn/pUeA9MLSHEdeIhqu8VeSsB.2C8B0QeBC4IbqhuWA3Tq',1,'Siiri','Nygrén','siiri.nygren@gmail.com','0502544865'),(9,'maita','$2a$08$X9fufG4.sD04wy9Oqu.XP.rurfZJ8kkr45v6TKmvtBzBq99Z9ZVDi',1,'Maija','Talkanen','maija.talkanen@outlook.com','0505587669'),(10,'johpo','$2a$08$VjQm7wwMumXqMLeGH3H1H.OnB4JoLlD/68ch98.cj.rDZCc3qZCsG',1,'Johanna','Pohjola','johanna.pohjola@welho.com','0448665979'),(11,'tuuma','$2a$08$LJ/7P3XnDtFMWhRn/p2LaudCC0W97HlQRiT5uTWs2euTbDCKreV4.',1,'Tuure','Malvajärvi','tuurema@hotmail.com','0412636968'),(12,'pekor','$2a$08$aYqFCxC3JtmeksPu/JPRL.mw7ZyI5wk7eATRCI5KvaDBpEuJnU4ky',1,'Pekka','Orimus','pekka.orimus@welho.com','0505856896'),(13,'joola','$2a$08$OyCKjN.z4U5as7zyvDkbROk//eRm42n6B4Hq4wgLdXo07SO8QRgDu',1,'Joonas','Laasanen','joonas.laasanen@gmail.com','0442578692'),(14,'jlaine','$2a$08$SDpgeU59wY57zVs3O7aGPec2lCx8RY6.2au6KTCq6g6u01paChLbS',1,'Jaakko','Laine','jaakko.laine@gmail.com','0449370944'),(22,'kiira','$2a$08$O8.voB157anJpsfC7clz3u/fkDELCz3ukYBKvsLxT.2lFY6e9ct1O',1,'Kiira','Rantala','kiira@rantala.fi','0503665896'),(28,'micaro','$2a$10$JN/5VFtK6O/Yvxw50h2e7e8pzXTdZxaGM74OlJNk.aUn8Fh4eJHXO',1,'Mika','Ropponen','mika.ropponen@gmail.com','0123456789'),(29,'nicou','$2a$10$ePVgBbKE1q6PqawpXWXeoeo0K4R4HBnaTD7n9CksZfFAGnbB3WPWm',1,'Nico','Hagelberg','nico.hagelberg@myy.haaga-helia.fi','0401234567'),(30,'jtjuslin','$2a$10$DaPtcSuCk8kMsctc12xYIuJwkGu6Im4jCQTKQAN4jVXfeLXtbVmwO',1,'Jukka','Juslin','jukka.juslin@haaga-helia.fi','0405209879'),(31,'VarvaraZ','$2a$10$vly5vKiafTk1UrSx6j1O2.zJ7d.v4VYPFM.kueMrO106hUewPDuWi',1,'Varvara','Zhilibovskaya','a1500868@myy.haaga-helia.fi','0452697550');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waypoints`
--

DROP TABLE IF EXISTS `waypoints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waypoints` (
  `waypoint_id` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(1000) COLLATE utf8_swedish_ci NOT NULL,
  `photo_enabled` tinyint(4) NOT NULL DEFAULT '0',
  `worksheet_id` int(11) NOT NULL,
  PRIMARY KEY (`waypoint_id`),
  KEY `fk_waypoints_worksheets` (`worksheet_id`),
  CONSTRAINT `fk_waypoints_worksheets` FOREIGN KEY (`worksheet_id`) REFERENCES `worksheets` (`worksheet_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waypoints`
--

LOCK TABLES `waypoints` WRITE;
/*!40000 ALTER TABLE `waypoints` DISABLE KEYS */;
INSERT INTO `waypoints` VALUES (1,'Tilanne. Arvioi tilanteen yleisyyttä. Kuvaile ohjeita tilanteessa toimimiseen. Ota kuva työympäristöstä.',1,1),(2,'Tilanne. Arvioi tilanteen yleisyyttä. Kuvaile ohjeita tilanteessa toimimiseen. Ota kuva työympäristöstä.',1,1),(3,'Työtehtävä. Arvioi työtehtävän kuormitusta. Kuinka ehkäiset haitallista kuormitusta? Ota kuva työtilanteesta tai työympäristöstä.',1,2),(4,'Työtehtävä. Arvioi työtehtävän kuormitusta. Kuinka ehkäiset haitallista kuormitusta? Ota kuva työtilanteesta tai työympäristöstä.',1,2),(5,'Arvioi valmistelujen määrää. Mitä ohjeita antaisit siihen? Ota kuva ohjeiden tueksi.',1,3),(6,'Arvioi toteutuvaihetta. Mitä ohjeita antaisit siihen? Ota kuva ohjeiden tueksi.',1,3),(7,'Arvioi lopetusvaiheiden määrää. Mitä ohjeita antaisit siihen? Ota kuva ohjeiden tueksi.',1,3),(8,'Arvioi ja kuvaile turvallisuustasoa. Ota kuva kohteesta.',1,4),(9,'Arvioi ja kuvaile turvallisuustasoa. Ota kuva kohteesta.',1,4),(10,'Arvioi ja kuvaile turvallisuustasoa. Ota kuva kohteesta.',1,4),(11,'Arvioi ja kuvaile turvallisuustasoa. Ota kuva kohteesta.',1,4),(12,'Arvioi ja kuvaile turvallisuustasoa. Ota kuva kohteesta.',1,4),(13,'Työväline. Arvioi käytön määrää. Kerro käyttöohjeet. Ota kuva.',1,5),(14,'Työväline. Arvioi käytön määrää. Kerro käyttöohjeet. Ota kuva.',1,5),(15,'Työväline. Arvioi käytön määrää. Kerro käyttöohjeet. Ota kuva.',1,5),(16,'Ensimmäinen tilanne: Arvioi kuluva aika päivässä. Kuinka asentoa voi parantaa, voiko istumista vähentää? Lataa kuva.',1,6),(17,'Toinen tilanne: Arvioi kuluva aika päivässä. Kuinka asentoa voi parantaa, voiko istumista vähentää? Lataa kuva.',1,6),(18,'Kolmas tilanne: Arvioi kuluva aika päivässä. Kuinka asentoa voi parantaa, voiko istumista vähentää? Lataa kuva.',1,6),(19,'Maanantain suunnitelma: Arvioi, miten suunnitelma toteutui. Miten mielestäsi onnistuit? Ota kuva.',1,7),(20,'Tiistain suunnitelma: Arvioi, miten suunnitelma toteutui. Miten mielestäsi onnistuit? Ota kuva.',1,7),(21,'Keskiviikon suunnitelma: Arvioi, miten suunnitelma toteutui. Miten mielestäsi onnistuit? Ota kuva.',1,7),(22,'Torstain suunnitelma: Arvioi, miten suunnitelma toteutui. Miten mielestäsi onnistuit? Ota kuva.',1,7),(23,'Perjantain suunnitelma: Arvioi, miten suunnitelma toteutui. Miten mielestäsi onnistuit? Ota kuva.',1,7),(24,'Ensimmäine tapa liikkua: Arvioi fiiliksiäsi. Miksi valitsit tämän tavan liikkua? Ota kuva.',1,8),(25,'Toinen tapa liikkua: Arvioi fiiliksiäsi. Miksi valitsit tämän tavan liikkua? Ota kuva.',1,8),(26,'Kolmas tapa liikkua: Arvioi fiiliksiäsi. Miksi valitsit tämän tavan liikkua? Ota kuva.',1,8),(27,'Ensimmäinen kerta: Tunsitko muutoksia? Millaista taukoliikkumista kokeilit ja missä? Ota kuva',1,9),(28,'Toinen kerta: Tunsitko muutoksia? Millaista taukoliikkumista kokeilit ja missä? Ota kuva',1,9),(29,'Kolmas kerta: Tunsitko muutoksia? Millaista taukoliikkumista kokeilit ja missä? Ota kuva',1,9),(30,'Onnistumista tukeva asia 1. Arvioi vaikutusta ja perustele valintasi.',0,10),(31,'Onnistumista tukeva asia 2. Arvioi vaikutusta ja perustele valintasi.',0,10),(32,'Epäonnistumiseen liittyvä asia 1. Arvioi vaikutusta ja perustele valintasi.',0,10),(33,'Epäonnistumiseen liittyvä asia 2. Arvioi vaikutusta ja perustele valintasi.',0,10),(34,'Tilanne 1: Arvioi ensin alkogolin roolia tilanteessa. Pohdi sitten syitä alkoholin käytölle kyseisessä tilanteessa.',0,11),(35,'Tilanne 2: Arvioi ensin alkogolin roolia tilanteessa. Pohdi sitten syitä alkoholin käytölle kyseisessä tilanteessa.',0,11),(36,'Tilanne 3: Arvioi ensin alkogolin roolia tilanteessa. Pohdi sitten syitä alkoholin käytölle kyseisessä tilanteessa.',0,11),(37,'Suojatekijä 1: Valitse suojatekijälle hymiö. Kuvaile suojatekijää. Ota kuva mielenterveyden käden osasta, johon se liittyy.',1,12),(38,'Suojatekijä 2: Valitse suojatekijälle hymiö. Kuvaile suojatekijää. Ota kuva mielenterveyden käden osasta, johon se liittyy.',1,12),(39,'Suojatekijä 3: Valitse suojatekijälle hymiö. Kuvaile suojatekijää. Ota kuva mielenterveyden käden osasta, johon se liittyy.',1,12),(40,'Päätös 1. Arvioi, onko päätöksen toteuttaminen helppoa? Kerro, miten toteutuat päätöksesi. Kuvaa päätökseen liittyvä asia.',1,13),(41,'Päätös 2. Arvioi, onko päätöksen toteuttaminen helppoa? Kerro, miten toteutuat päätöksesi. Kuvaa päätökseen liittyvä asia.',1,13),(42,'Päätös 3. Arvioi, onko päätöksen toteuttaminen helppoa? Kerro, miten toteutuat päätöksesi. Kuvaa päätökseen liittyvä asia.',1,13),(43,'Päivä. Onko tarjottimesi lautasmallin mukainen? Kerro, mitä puuttuu tai mitä on liikaa? Ota kuva annoksestasi.',1,14),(44,'Päivä. Onko tarjottimesi lautasmallin mukainen? Kerro, mitä puuttuu tai mitä on liikaa? Ota kuva annoksestasi.',1,14),(45,'Päivä. Onko tarjottimesi lautasmallin mukainen? Kerro, mitä puuttuu tai mitä on liikaa? Ota kuva annoksestasi.',1,14),(46,'Päivä. Onko tarjottimesi lautasmallin mukainen? Kerro, mitä puuttuu tai mitä on liikaa? Ota kuva annoksestasi.',1,14),(47,'Päivä. Onko tarjottimesi lautasmallin mukainen? Kerro, mitä puuttuu tai mitä on liikaa? Ota kuva annoksestasi.',1,14),(48,'Arvostan - arvokenttä. Olisitko valmis muuttamaan tämän arvokenttäsi sisältöä? Pohdi omien arvojesi hyötyjä ja haittoja eri tilanteissa.',0,15),(49,'Hyväksyn - arvokenttä. Olisitko valmis muuttamaan tämän arvokenttäsi sisältöä? Pohdi omien arvojesi hyötyjä ja haittoja eri tilanteissa.',0,15),(50,'Siedän - arvokenttä. Olisitko valmis muuttamaan tämän arvokenttäsi sisältöä? Pohdi omien arvojesi hyötyjä ja haittoja eri tilanteissa.',0,15),(51,'Vaikea selittää - arvokenttä. Olisitko valmis muuttamaan tämän arvokenttäsi sisältöä? Pohdi omien arvojesi hyötyjä ja haittoja eri tilanteissa.',0,15),(52,'kulttuuritapahtuma. Arvioi fiiliksiä, kuvaile tapahtumaa ja kokeumuksiasi. Ota kuva.',1,16),(53,'kulttuuritapahtuma. Arvioi fiiliksiä, kuvaile tapahtumaa ja kokeumuksiasi. Ota kuva.',1,16),(54,'kulttuuritapahtuma. Arvioi fiiliksiä, kuvaile tapahtumaa ja kokeumuksiasi. Ota kuva.',1,16),(55,'kulttuuritapahtuma. Arvioi fiiliksiä, kuvaile tapahtumaa ja kokeumuksiasi. Ota kuva.',1,16),(56,'kulttuuritapahtuma. Arvioi fiiliksiä, kuvaile tapahtumaa ja kokeumuksiasi. Ota kuva.',1,16),(57,'Sääntö 1. Arvioi säännön tärkeyttä turvallisuuden kannalta. Perustele, miksi valitsit tämän säännön.',0,17),(58,'Sääntö 2. Arvioi säännön tärkeyttä turvallisuuden kannalta. Perustele, miksi valitsit tämän säännön.',0,17),(59,'Sääntö 3. Arvioi säännön tärkeyttä turvallisuuden kannalta. Perustele, miksi valitsit tämän säännön.',0,17),(60,'Sääntö 4. Arvioi säännön tärkeyttä turvallisuuden kannalta. Perustele, miksi valitsit tämän säännön.',0,17),(61,'Sääntö 5. Arvioi säännön tärkeyttä turvallisuuden kannalta. Perustele, miksi valitsit tämän säännön.',0,17),(62,'Arvo 1. Kuinka tärkeänä pidät tätä arvoa. Kuvaile, miten arvo näkyy ihmisten toiminnassa ja asenteissa?',1,18),(63,'Arvo 2. Kuinka tärkeänä pidät tätä arvoa. Kuvaile, miten arvo näkyy ihmisten toiminnassa ja asenteissa?',1,18),(64,'Arvo 3. Kuinka tärkeänä pidät tätä arvoa. Kuvaile, miten arvo näkyy ihmisten toiminnassa ja asenteissa?',1,18),(65,'Paikka, jossa viihdyn. Arvioi paikka. Mikä tekee siitä viihtyisän? Ota kuva.',1,19),(66,'Paikka, jossa viihdyn. Arvioi paikka. Mikä tekee siitä viihtyisän? Ota kuva.',1,19),(67,'Paikka, jota haluaisin muuttaa. Arvioi paikka. Miten tekisit tästä viihtyisämmän? Ota kuva.',1,19),(68,'Nukkuminen ja ruokailu. Oliko tuntimäärä sopiva? Miten voisit muuttaa ajankäyttöäsi?',1,20),(69,'Opiskelu ja työ. Oliko tuntimäärä sopiva? Miten voisit muuttaa ajankäyttöäsi?',1,20),(70,'Liikunta. Oliko tuntimäärä sopiva? Miten voisit muuttaa ajankäyttöäsi?',1,20),(71,'Harrastukset ja vapaa-aika. Oliko tuntimäärä sopiva? Miten voisit muuttaa ajankäyttöäsi?',1,20),(72,'Sosiaaliset suhteet. Oliko tuntimäärä sopiva? Miten voisit muuttaa ajankäyttöäsi?',1,20),(73,'Nukkuminen ja ruokailu. Saavutitko tavoitteen? Mikä esti tai mahdollisti sen? Mitä voisit tehdä eri tavalla? Ota kuva.',1,21),(74,'Opiskelu ja työ. Mikä esti tai mahdollisti sen? Mitä voisit tehdä eri tavalla? Ota kuva.',1,21),(75,'Liikunta. Mikä esti tai mahdollisti sen? Mitä voisit tehdä eri tavalla? Ota kuva.',1,21),(76,'Harrastukset ja vapaa-aika. Mikä esti tai mahdollisti sen? Mitä voisit tehdä eri tavalla? Ota kuva.',1,21),(77,'Sosiaaliset suhteet. Mikä esti tai mahdollisti sen? Mitä voisit tehdä eri tavalla? Ota kuva.',1,21),(78,'Kokeile kehonhuoltoa. Arvioi fiiliksiäsi. Perustele, miksi tämä sopii alallasi? Ota kuva.',1,22),(79,'Nauti terveellinen lounas. Arvioi fiiliksiäsi. Kuvaile lounaasi ja perustele sen terveellisyys. Ota kuva.',1,22),(80,'Kokeile tyhyvinvointia tukevaa keinoa vapaa-ajalla. Arvioi fiiliksiäsi. Kuvaile keinoa tarkemmin. Ota kuva.',1,22);
/*!40000 ALTER TABLE `waypoints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worksheets`
--

DROP TABLE IF EXISTS `worksheets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worksheets` (
  `worksheet_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `header` varchar(100) COLLATE utf8_swedish_ci NOT NULL,
  `preface` varchar(1000) COLLATE utf8_swedish_ci NOT NULL,
  `planning` varchar(1000) COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`worksheet_id`),
  KEY `fk_worksheets_categories` (`category_id`),
  CONSTRAINT `fk_worksheets_categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worksheets`
--

LOCK TABLES `worksheets` WRITE;
/*!40000 ALTER TABLE `worksheets` DISABLE KEYS */;
INSERT INTO `worksheets` VALUES (1,1,'Asiakastilanteet','Monissa ammateissa työskennellään asiakkaiden tai potilaiden kanssa. Esimerkkejä ovat asiakaspalveluun liittyvät tilanteet, tavaroiden tai palveluiden myyminen sekä asiakkaiden neuvomiseen tai reklamaatioihin liittyvät tilanteet. Sosiaali- ja terveysalalla työskennellään puolestaan usein päivittäin potilaiden kanssa eri tilanteissa. Ammattitaitoon kuuluu, että työntekijä osaa vaikuttaa asiakastilanteiden sujuvuuteen, onnistumiseen ja turvallisuuteen.','Kuvaile kaksi esimerkkiä erityyppisistä asiakastilanteista omalla ammattialallasi. Numeroi valintasi 1-2. '),(2,1,'Ergonomia','Ergonomian avulla työ, työvälineet ja työympäristö sopeutetaan vastaamaan ihmisen ominaisuuksia ja tarpeita. Kiinnittämällä huomiota ergonomiaan ennaltaehkäiset työtapaturmia ja haitallista kuormitusta työssä. Fyysiseen ergonomiaan liittyy oikeiden työmenetelmien (esim. työasennot, nostot, työvälineiden käyttö) ja apuvälineiden käyttö sekä työympäristön suunnittelu. Lisätietoa ja vinkkejä: http://www.ttl.fi/fi/ergonomia/tyon_fyysisia_kuormitustekijoita/sivut/default.aspx','Kirjoita ja numeroi alapuolelle kaksi työtehtävää omalta alaltasi, joissa mielestäsi kannattaa kiinnittää huomiota työergonomiaan haitallisen kuormituksen ehkäisemiseksi.'),(3,1,'Ohjeiden laatiminen','Kuvittele itsesi tilanteeseen, jossa opastat uutta työntekijää työtehtävän suorittamiseen. Hyvä ohjeistus vastaa mm. seuraaviin kysymyksiin: Millaisia etukäteisvalmisteluja kannattaa tehdä (tarkistukset, säädöt, työvälineiden esille ottaminen, työympäristön järjestely ym.)? Mitkä ovat oikeat työmenetelmät, kuinka ennaltaehkäistään ongelmia ja tapaturmia? Mitä tulee ottaa huomioon mahdollisen asiakkaan tai potilaan kanssa? Mitä asioita tulee tehdä työtehtävän jälkeen (työvälineiden huolto, työtuloksen tarkistukset ym.)?','Valitse yksi työtehtävä omalta ammattialaltasi ja kirjoita se alapuolelle. '),(4,1,'Turvallisuuskävely','Jokainen ammattilainen huolehtii työturvallisuudesta työpaikalla. On tärkeää tunnistaa ja torjua työhön liittyviä vaaroja. Turvallisuuskävelyssä kierretään työympäristön kannalta tärkeitä paikkoja ja arvioidaan turvallisuustasoa. Toteuta yksin tai ryhmässä turvallisuuskävely oppilaitoksessa. Suunnitelkaa etukäteen reitti ja toteutusajankohta. Esittäkää suunnitelma opettajalle ennen toteuttamista. ','Kirjoita turvallisuuskävelyn kohteet (5 paikkaa) ja reitti alapuolelle.'),(5,1,'Työväline esittely','Erilaisten työvälineiden, apuvälineiden ja suojainten käyttö kuuluu ammattitaitoon. Seuraavaksi pääset kuvailemaan keskeisiä ammattialasi työvälineitä- ja laitteita sekä laatimaan periaatteet niiden käyttöön. ','Valitse kolme omalla ammattialallasi käytössäsi olevaa työvälinettä, konetta, tai laitetta. Kirjoita niiden nimet alapuolelle. Numeroi valintasi 1-3. Voit tehdä valintasi työpaikalta, työssäoppimispaikalta tai oppilaitoksen työsalista.'),(6,2,'Istu oikein','Istuminen on huonoksi kropalle. Varsinkin, jos istuu koko päivän töissä ja jatkaa istumista kotona, istumisen aiheuttamat vaivat ilmaantuvat varmasti. Liiallisen istumisen aiheuttamia oireita voi helpottaa istumalla oikein. Tarkista Smart Movesin sivuilta vinkkejä oikeisiin istuma-asentoihin. Pohdi tyypillisiä tilanteita vapaa-ajalta tai ammattialasi työtehtävistä, joissa istutaan. Pyydä kaveria ottamaan kuva kun istut ja kiinnitä huomiota oikeaan istumisasentoon. ','Kirjoita tähän kolme tyypillistä tilannetta ammattialaltasi, jolloin istutaan:'),(7,2,'Liikutko sinä riittävästi?','Liikunta edistää terveyttä ja auttaa jaksamaan aamusta iltaan, liikutko sinä riittävästi? Testaa UKK-instituutin liikuntapiirakan avulla liikutko riittävästi. Suunnittele itsellesi sen jälkeen seuraavan jakson ajaksi liikuntasuunnitelma, jossa liikuntasuositus täyttyy. Suunnitelman tekemiseen apua saat apua Smart moves -sivustolta. Tee viikkosuunnitelma maanantaista perjantaihin liikkumisellesi. Toteuta sen jälkeen liikuntasuunnitelmasi: Pidä liikuntapäiväkirjaa pohjautuen suunnitelmaasi viikon ajan. Lisää joka päivälle jokin kuva liikuntahetkestäsi.','Viikkosuunnitelmani liikkumiselle. Mitä teet eri päivinä? (ma-pe):'),(8,2,'Oma tapa liikkua','Pohdi juuri sinulle sopivia ja mieluisia tapoja liikkua. Liikkuminen voi olla ohjattu harrastus, itsenäistä treenaamista tai rentoa ajanviettoa kavereiden kesken. Käy kokeilemassa seuraavan kuukauden aikana kolmea erilaista tapaa liikkua. Nappaa selfie, kun olet liikkumassa. Perustele lyhyesti, miksi valitsit tämän tavan liikkua ja millä fiiliksillä tutustuit siihen.','Kolme liikkumisen tapaa, joihin aion kuukauden aikana tutustua:'),(9,2,'Taukoliikuntaa','Taukoliikunta saa veren virtaamaan paikalla oleviin lihaksiin, virkistää ja auttaa keskittymään paremmin. Taukoliikunnan ottaminen omiin rutiineihin on myös työelämän kannalta suositeltavaa: pidät työkyvystäsi huolta, kun ehkäiset etukäteen huonojen työasentojen ja työn kropalle aiheuttamaa rasitusta. Taukoliikunta on myös helppoa ja nopeaa, se ei vaadi kuin muutaman minuutin venyttelyyn ja esimerkiksi selän oikaisemiseen. Tee viikon aikana vähintään 3 kertaa välitunneilla tai oppitunnin aikana jotakin aktiivista toimintaa. Kuvaile mitä teit ja arvioi fiiliksiäsi. ','Mitä hyötyä taukoliikunnasta on kropalle ja jaksaminen? Mieti kolme asiaa'),(10,3,'Juominen ja biletys','Bileissä tutustutaan uusiin ihmisiin, vahvistetaan jo olemassa olevia ystävyyssuhteita ja pidetään hauskaa. Alkoholia käytetään usein tunnelman nostattamiseen ja monet kokevat, että alkoholi helpottaa kanssakäymistä. Samoja asioita voi saavuttaa ja kokea tietenkin myös ilman alkoholia. Biletyksellä on siis monta tehtävää. Pohdi tässä tehtävässä, mitkä asiat vaikuttavat bileiden onnistumiseen tai epäonnistumiseen. ','Mieti ja numeroi kaksi asiaa, jotka vaikuttavat bileiden onnistumiseen sekä kaksi asiaa, jotka vaikuttavat niiden epäonnistumiseen. '),(11,3,'Juominen ja sosiaaliset suhteet','Alkoholin käyttö on taitolaji. Tee sosiaalisen vastuun testi EHYT ry:n Taitolaji-sivuilla. Jos et käytä alkoholia, tee testi kuvitteellisesti. Testin avulla voi pohtia oman alkoholinkäytön vaikutuksia muihin ihmisiin. Tulosta ei tarvitse lähettää kenellekään, se on itsellesi oman pohdinnan tueksi.','Kuvaile kolme tilannetta, joissa ihmiset yleensä käyttävät alkoholia.'),(12,3,'Mielen hyvinvoinnin suojatekijät','Mielen hyvinvoinnin voimavaroja kertyy, kun pitää huolta jaksamisestaan ja tekee niitä asioita, joista tykkää. Mielen hyvinvointia voikin edistää vahvistamalla sen suojatekijöitä. Suojatekijöitä ovat esimerkiksi liikkuminen, hyvät kaverisuhteet, perhe ja ystävät, kivat harrastukset, opiskelu, asioista puhuminen, omien tunteiden ilmaiseminen ja turvallinen koti ja ympäristö. Mieti omia suojatekijöitäsi. Pohdintaan saat vinkkejä Mielenterveysseuran Selviytyjän purjeet – mallista tai Mielenterveyden käsi –malleista (google: mielenterveysseura, selviytyjän purjeet, mielenterveyden käsi).','Kirjoita alapuolelle kolme asiaa, jotka ovat omia suojatekijöitäsi. '),(13,3,'Pieni päätös päivässä','Pienillä teoilla voi valtavasti vaikuttaa omaan hyvinvointiinsa. Se voi olla päätös kävellä koulumatkat, kasvisten lisääminen ruokavalioon tai päätös nukkua kunnon yöunet. Vinkkejä pieniin päätöksiin löydät Yksi elämä -hankkeiden Pieni päätös päivässä -verkkosivulta.  Tutustu Pieniä päätöksiä -sivuston Faktat-osioon. Alavalikosta voit valita kategorioita, joissa on vinkkejä ja faktoja asioista, joilla voit parantaa hyvinvointiasi. Lue läpi liikunta, ravinto ja stressi -kategoriat ja niiden faktat. ','Kirjoita alle faktojen perusteella kolme pientä päätöstä, joiden avulla voit parantaa hyvinvointiasi. '),(14,3,'Syö hyvin','Mietitkö koskaan, mitä on lautasellasi? Ruualla on suuri merkitys hyvinvoinnillesi. Ei ole yhtä oikeaa tapaa syödä hyvin. Tärkeää on kuitenkin monipuolisuus sekä kasvisten syöminen. Lautasmallin avulla ruokamäärät säilyvät kohtuullisina ja terveellisen ruokavalion periaatteet toteutuvat. Lautasmallin mukaan lounaassa tulisi olla puolet kasviksia, ¼ perunaa, riisiä tai pastaa ja ¼ lihaa tai kalaa. Linkki: http://tervekoululainen.fi/elementit/ravinto/arkiruokailu/lautasmalli','Seuraa lounasruokailuasi viiden päivän ajan. Ota kuva jokaisena päivänä ruoka-annoksestasi ja arvioi sen terveellisyyttä. Kuvaile alapuolelle, missä yleensä käyt syömässä ma-pe.'),(15,4,'Arvot ja asenteet','Ihmisen asenteita ja arvoja voidaan jakaa neljään arvokenttään. ”Arvostan” arvokenttä sisältää ihmisiin liittyvät asiat, ominaisuudet ja toimintatavat, joita pidämme tärkeinä ja joita kunnioitamme. ”Hyväksyn” alueella on asioita, joita pidämme ”ihan ok” juttuina, mutta emme erityisesti arvosta. ”Sietämisen” kenttä sisältää asioita, jotka hyväksymme, mutta emme koe hyvänä. ”Vaikea sietää” alueella on asioita, joiden sietäminen on meille vaikeampaa. Pääset seuraavaksi laatimaan oman arvokenttäsi.','Kuvaile omaa arvokenttääsi. Kirjoita alapuolelle jokaiseen arvokenttään jokin asia, ilmiö ominaisuus tai toimintatapa ihmisiin liittyen. '),(16,4,'Kulttuuripassi','Kulttuurista saa iloa ja vaihtelua arkeen. Kulttuuriaktiviteetteihin kuuluu mm. elokuvissa käynti, bändin keikat tai taidenäyttelyissä käynti. Tässä tehtäväkortissa kokeilet kulttuuriaktiviteetteja. Vieraile vähintään viidessä eri kulttuuritapahtumassa. Keräät niistä liput talteen, ota kuvia ja dokumentoi jollain tavalla osallistumisesi opettajallesi. ','Suunnittele missä kulttuuritapahtumissa käyt ja kirjoita ja numeroi ne alapuolelle. Esim. valokuva- ja taidenäyttely, konsertit, bändin keikka, kulttuuritapahtuma, festari, elokuvissa käynti.'),(17,4,'Ryhmän rakentaminen','Oppilaitoksessa toimitaan monenlaisissa ryhmissä, kuten kaveriryhmissä tai erilaisissa opiskeluryhmissä. Ryhmässä toimimisen taitoja kannattaa harjoitella, sillä harva työskentelee työssä, jossa ei joudu toisten ihmisten kanssa tekemisiin.  Ryhmän ilmapiiri, luottamus ja avoimuus rakentavat omalta osaltaan ryhmän turvallisuutta. Onkin hyvä, että ryhmässä olisi säännöt, jotta kaikki tietävät, miten ryhmässä ollaan ja toimitaan.','Kirjoita ja numeroi omalle opiskeluryhmällesi viiden kohdan säännöt alapuolelle ja tee sitten tehtävä. '),(18,4,'Suomalaisuus','Jokaisella yhteisöllä on sen toimintaa ohjaavia arvoja. Arvot näkyvät ihmisten toiminnassa ja ajattelutavoissa. Myös arvot voivat muuttua ajan kuluessa. Omien arvojen ja asenteiden taustojen ymmärtäminen on ensi askel erilaisuuden ymmärtämiseen. ','Etsi netistä kirjoituksia suomalaisista arvoista. Kirjoita ja numeroi alapuolelle kolme suomalaisuuteen liittyvää arvoa. Etsi netistä myös suomalaisuuteen liittyviä kuvia ja liitä ne vastauksiisi.'),(19,4,'Viihtyisä oppilaitos','Oppilaitoksen viihtyisyyden lisäämiseksi tarvitaan opiskelijoiden ideoita, ajatuksia ja mielipiteitä. Oppilaitoksessasi on monia asioita, jotka tekevät siitä viihtyisän - ja samalla löytyy varmasti myös parannettavaa. Samat asiat pätevät myös työpaikalla. Työntekijät voivat esittää ideoita työympäristön kehittämiseksi. Seuraavaksi pääset miettimään omia kehittämisehdotuksiasi oppilaitokseesi.','Kirjoita ja numeroi alapuolelle kaksi paikkaa, joissa viihdyt eniten oppilaitoksessasi. Kirjoita sen jälkeen esimerkki paikasta, jonka haluaisit muuttaa viihtyisämmäksi. '),(20,5,'Mihin käytät aikaasi: Ensimmäinen osa','Hyvään päivään kuuluu riittävä lepo ja nukkuminen, terveellinen ruokailu, mielekkäät harrastukset, ihmissuhteiden hoitaminen ja sopiva määrä liikkumista. Yhdessä nämä antavat energiaa sekä työhön, että vapaa-ajan viettoon. Pidä samalla kuvapäiväkirjaa ajankäyttöösi liittyen. Kuva voi liittyä eri tavoin päivääsi ja siihen liittyvin asioihin (esim. selfie, tavarat, ympäristö, kellonaika ym.)','Arvioi, kuinka monta tuntia käytät päivässä seuraaviin asioihin 1) Nukkuminen ja ruokailu 2) Opiskelu ja/tai työ 3) Liikunta 4) Harrastukset ja vapaa-aika 5) Sosiaaliset suhteet. Seuraa ajankäyttöäsi seuraavan vuorokauden ajan ja täytä tehtäväkortin loppuosa.'),(21,5,'Mihin käytät aikasi: Toinen osa','Olet tehnyt aiemmin kortin ajankäytöstäsi. Aseta itsellesi sen pohjalta uudet ajankäytön tavoitteet. Seuraa toteutuvatko tavoitteet seuraavan vuorokauden aikana ja onnistuitko muuttamaan tottumuksiasi? Pidä samalla kuvapäiväkirjaa ajankäyttöösi liittyen. Kuva voi liittyä eri tavoin päivääsi ja siihen liittyvin asioihin (esim. tavarat, ympäristö, kellonaika ym.)','Kirjoita alapuolelle itsellesi tuntitavoitteet seuraaviin toimintoihin: 1) Nukkuminen ja ruokailu 2) Opiskelu ja/tai työ 3) Liikunta 4) Harrastukset ja vapaa-aika 5) Sosiaaliset suhteet'),(22,5,'Työhyvinvointia tukevat keinot ','Työhyvinvointia tukevien keinojen käyttö on osa ammattitaitoasi. Pystyt vahvistamaan työhyvinvointiasi monella tavoin. Tässä tehtäväkortissa keskityt kehonhuoltoon, ravintoon ja vapaa-ajan merkitykseen. Tutustu näihin työhyvinvoinnin keinoihin etukäteen www.alpo.fi. ','Kuvaile alapuolelle ammattialallesi sopiva taukojumppa/venyttely, terveellinen lounas ja yksi työhyvinvointia tukeva keino vapaa-ajalle. ');
/*!40000 ALTER TABLE `worksheets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-24 13:29:52
