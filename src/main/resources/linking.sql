CREATE DATABASE  IF NOT EXISTS `linking` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `linking`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: linking
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `appraise_user_grade_table`
--

DROP TABLE IF EXISTS `appraise_user_grade_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appraise_user_grade_table` (
  `id` int(11) NOT NULL,
  `ug_1` varchar(255) DEFAULT NULL,
  `ug_10` varchar(255) DEFAULT NULL,
  `ug_11` varchar(255) DEFAULT NULL,
  `ug_12` varchar(255) DEFAULT NULL,
  `ug_13` varchar(255) DEFAULT NULL,
  `ug_14` varchar(255) DEFAULT NULL,
  `ug_15` varchar(255) DEFAULT NULL,
  `ug_16` varchar(255) DEFAULT NULL,
  `ug_17` varchar(255) DEFAULT NULL,
  `ug_18` varchar(255) DEFAULT NULL,
  `ug_19` varchar(255) DEFAULT NULL,
  `ug_2` varchar(255) DEFAULT NULL,
  `ug_20` varchar(255) DEFAULT NULL,
  `ug_21` varchar(255) DEFAULT NULL,
  `ug_22` varchar(255) DEFAULT NULL,
  `ug_23` varchar(255) DEFAULT NULL,
  `ug_24` varchar(255) DEFAULT NULL,
  `ug_25` varchar(255) DEFAULT NULL,
  `ug_26` varchar(255) DEFAULT NULL,
  `ug_27` varchar(255) DEFAULT NULL,
  `ug_28` varchar(255) DEFAULT NULL,
  `ug_29` varchar(255) DEFAULT NULL,
  `ug_3` varchar(255) DEFAULT NULL,
  `ug_30` varchar(255) DEFAULT NULL,
  `ug_31` varchar(255) DEFAULT NULL,
  `ug_32` varchar(255) DEFAULT NULL,
  `ug_33` varchar(255) DEFAULT NULL,
  `ug_34` varchar(255) DEFAULT NULL,
  `ug_35` varchar(255) DEFAULT NULL,
  `ug_36` varchar(255) DEFAULT NULL,
  `ug_37` varchar(255) DEFAULT NULL,
  `ug_38` varchar(255) DEFAULT NULL,
  `ug_39` varchar(255) DEFAULT NULL,
  `ug_4` varchar(255) DEFAULT NULL,
  `ug_40` varchar(255) DEFAULT NULL,
  `ug_41` varchar(255) DEFAULT NULL,
  `ug_42` varchar(255) DEFAULT NULL,
  `ug_43` varchar(255) DEFAULT NULL,
  `ug_44` varchar(255) DEFAULT NULL,
  `ug_45` varchar(255) DEFAULT NULL,
  `ug_46` varchar(255) DEFAULT NULL,
  `ug_47` varchar(255) DEFAULT NULL,
  `ug_48` varchar(255) DEFAULT NULL,
  `ug_49` varchar(255) DEFAULT NULL,
  `ug_5` varchar(255) DEFAULT NULL,
  `ug_50` varchar(255) DEFAULT NULL,
  `ug_51` varchar(255) DEFAULT NULL,
  `ug_6` varchar(255) DEFAULT NULL,
  `ug_7` varchar(255) DEFAULT NULL,
  `ug_8` varchar(255) DEFAULT NULL,
  `ug_9` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appraise_user_grade_table`
--



--
-- Table structure for table `appraise_user_table`
--

DROP TABLE IF EXISTS `appraise_user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appraise_user_table` (
  `id` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `is_apprise` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appraise_user_table`
--

LOCK TABLES `appraise_user_table` WRITE;
/*!40000 ALTER TABLE `appraise_user_table` DISABLE KEYS */;
INSERT INTO `appraise_user_table` VALUES (1,0,0,'周博'),(2,0,0,'赵书振'),(3,0,0,'侯兰'),(4,0,0,'廖顶超'),(5,0,0,'郭晓敏'),(6,0,0,'秦旭'),(7,0,0,'陈磊'),(8,0,0,'张佩衡'),(9,0,0,'吴真其'),(10,0,0,'吕佳俊'),(11,0,0,'王彦钧'),(12,0,0,'董浩楠'),(13,0,0,'高睿'),(14,0,0,'韩潇逸'),(15,0,0,'彭景'),(16,0,0,'吴昱君'),(17,0,0,'叶想林'),(18,0,0,'闫继龙'),(19,0,0,'袁欢'),(20,0,0,'林小渝'),(21,2,0,'王定旺'),(22,0,0,'李然康'),(23,0,0,'黄博文'),(24,0,0,'王子越'),(25,0,0,'刘雨婷'),(26,0,0,'黄宁宁'),(27,0,0,'王韬'),(28,0,0,'姬广恒'),(29,0,0,'伍万杰'),(30,2,0,'赵富佳'),(31,1,0,'张玺'),(32,1,0,'卢宁'),(33,1,0,'王强'),(34,1,0,'孟则霖'),(35,1,0,'郑磊'),(36,1,0,'彭健彪'),(37,1,0,'张丹阳'),(38,1,0,'汪博'),(39,1,0,'史文强'),(40,1,0,'程翠萍'),(41,1,0,'赵飞燕'),(42,1,0,'杨哲'),(43,1,0,'方明星'),(44,1,0,'宋德江'),(45,1,0,'吴万滴'),(46,1,0,'笪程'),(47,1,0,'张龙'),(48,1,0,'杨菁菁'),(49,1,0,'何柏村'),(50,1,0,'李世伟'),(51,1,0,'吴圣华');
/*!40000 ALTER TABLE `appraise_user_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (13);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'11','111'),(2,'22','222'),(3,'33','333'),(4,'44','444'),(5,'55','555');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-17 14:15:07
