-- MySQL dump 10.13  Distrib 9.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: coach_service_db
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE  IF NOT EXISTS `coach_service_db`;
USE `coach_service_db`;

--
-- Table structure for table `booking_details`
--

DROP TABLE IF EXISTS `booking_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_details` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `discount_amount` decimal(15,2) DEFAULT NULL,
  `discount_percent` decimal(5,2) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `status` enum('BOOKED','CANCELLED','CHECKED_IN','USED') NOT NULL,
  `booking_id` binary(16) NOT NULL,
  `seat_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkbcan6ybv86uappnh0qtdmvas` (`booking_id`),
  KEY `FKgphl9xdom8314je7ajy36ov2h` (`seat_id`),
  CONSTRAINT `FKgphl9xdom8314je7ajy36ov2h` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`),
  CONSTRAINT `FKkbcan6ybv86uappnh0qtdmvas` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_details`
--

LOCK TABLES `booking_details` WRITE;
/*!40000 ALTER TABLE `booking_details` DISABLE KEYS */;
INSERT INTO `booking_details` VALUES (_binary '7  s \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'USED',_binary '7  R s ',_binary 'LP & ^ \0\ '),(_binary '7 ;̺s \0 ','2025-11-06 01:14:06.000000',NULL,NULL,700000.00,'USED',_binary '7  غs \0\ ',_binary 'Lg2 ^ \0 '),(_binary '7 C s \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'USED',_binary '7  R s ',_binary 'LR] ^ \0 k'),(_binary '7 Id s \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,700000.00,'USED',_binary '7    s\ ',_binary 'L_\'պ^ \0 k\0'),(_binary '7 _s s \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'USED',_binary '7 Ӻs \0 ',_binary 'LP\0  ^ \0\ '),(_binary '7 e  s ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'BOOKED',_binary '7   s ',_binary 'LX  ^ \0\ '),(_binary '7 p` s \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'CHECKED_IN',_binary '7  s \0\ ',_binary 'LX  ^ \0\ '),(_binary '7 t  s ','2025-11-06 01:14:06.000000',NULL,NULL,700000.00,'BOOKED',_binary '7  غs \0\ ',_binary 'Lg4  ^ \0\ '),(_binary '7 u s \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'USED',_binary '7  R s ',_binary 'LR  ^ \0\ '),(_binary '7   s ','2025-11-06 01:14:06.000000',NULL,NULL,700000.00,'USED',_binary '7  Ӻs \0\ ',_binary 'Lf t ^ \0\ '),(_binary '7  8 s ','2025-11-06 01:14:06.000000',NULL,NULL,700000.00,'BOOKED',_binary '7  غs \0\ ',_binary 'Lf t ^ \0\ '),(_binary '7  ; s ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'CHECKED_IN',_binary '7 Ӻs \0 ',_binary 'LP & ^ \0\ '),(_binary '7  s s ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'CHECKED_IN',_binary '7 Ӻs \0 ',_binary 'LR] ^ \0 k'),(_binary '7  Ѻs \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'USED',_binary '7  s \0\ ',_binary 'LYZ6 ^ \0 '),(_binary '7  ݺs \0\ ','2025-11-06 01:14:06.000000',NULL,NULL,700000.00,'CHECKED_IN',_binary '7 t׺s \0 ',_binary 'L_\'պ^ \0 k\0'),(_binary '7   s \0','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'USED',_binary '7  R s ',_binary 'LP\0  ^ \0\ '),(_binary '7    s\ ','2025-11-06 01:14:06.000000',NULL,NULL,800000.00,'CHECKED_IN',_binary '7  s \0\ ',_binary 'LY*1 ^ \0 ');
/*!40000 ALTER TABLE `booking_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_details_seq`
--

DROP TABLE IF EXISTS `booking_details_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_details_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_details_seq`
--

LOCK TABLES `booking_details_seq` WRITE;
/*!40000 ALTER TABLE `booking_details_seq` DISABLE KEYS */;
INSERT INTO `booking_details_seq` VALUES (1);
/*!40000 ALTER TABLE `booking_details_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` binary(16) NOT NULL,
  `booking_code` varchar(20) NOT NULL,
  `buyer_email` varchar(100) DEFAULT NULL,
  `buyer_name` varchar(100) NOT NULL,
  `buyer_phone` varchar(20) NOT NULL,
  `cancel_reason` varchar(255) DEFAULT NULL,
  `canceled_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_id` binary(16) DEFAULT NULL,
  `payment_method` enum('BANK_TRANSFER','CARD','CASH','ONLINE') DEFAULT NULL,
  `payment_status` enum('PAID','REFUNDED','UNPAID') DEFAULT NULL,
  `seat_count` int NOT NULL,
  `staff_id` binary(16) NOT NULL,
  `status` enum('CANCELLED','COMPLETED','CONFIRMED','PAID','PENDING','REFUNDED') NOT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `dropoff_stop_id` binary(16) NOT NULL,
  `pickup_stop_id` binary(16) NOT NULL,
  `trip_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKq97166k18hklq6ls46osbrftx` (`booking_code`),
  KEY `FKac8x9j9fvoh3rq1jl1ff23q3b` (`dropoff_stop_id`),
  KEY `FKi8lkesiu24j1hapsw7uaybdep` (`pickup_stop_id`),
  KEY `FK76g5jpvf8bcqejvp5d2vgrnjb` (`trip_id`),
  CONSTRAINT `FK76g5jpvf8bcqejvp5d2vgrnjb` FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`),
  CONSTRAINT `FKac8x9j9fvoh3rq1jl1ff23q3b` FOREIGN KEY (`dropoff_stop_id`) REFERENCES `stops` (`id`),
  CONSTRAINT `FKi8lkesiu24j1hapsw7uaybdep` FOREIGN KEY (`pickup_stop_id`) REFERENCES `stops` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (_binary '7  s \0\ ','BK451621','user49375@gmail.com','Tran Thi B','0179435088',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7 $ s \0\ ','BANK_TRANSFER','PAID',3,_binary '7 $6 s \0\ ','PENDING',2400000.00,'2025-11-06 01:14:06.000000',_binary 'L >  ^ ',_binary 'L 建^ \0 ',_binary ' dºi \0 '),(_binary '7   s ','BK439483','user54543@gmail.com','Do Van E','0466689286',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7 %  s ','ONLINE','UNPAID',1,_binary '7 %  s ','PAID',800000.00,'2025-11-06 01:14:06.000000',_binary 'L
+ ^ \0\ ',_binary 'L 建^ \0 ',_binary ' X˺i \0 '),(_binary '7 Ӻs \0 ','BK073803','user93930@gmail.com','Do Van E','0601893530',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7 .t s \0\ ','CARD','PAID',3,_binary '7 .  s ','PAID',2400000.00,'2025-11-06 01:14:06.000000',_binary 'L ) ^ \0\ ',_binary 'L 建^ \0 ',_binary ' k i \0\ '),(_binary '7 t׺s \0 ','BK556808','user20167@gmail.com','Pham Thi D','0176268281',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7   s \0','CARD','UNPAID',1,_binary '7   s ','PAID',700000.00,'2025-11-06 01:14:06.000000',_binary 'L 建^ \0 ',_binary 'L *ɺ^ \0 ',_binary 'd  Ӻi \0\ '),(_binary '7  R s ','BK951081','user76739@gmail.com','Ngo Thi K','0654738966',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7    s\ ','BANK_TRANSFER','UNPAID',4,_binary '7    s\ ','PAID',3200000.00,'2025-11-06 01:14:06.000000',_binary 'L >  ^ ',_binary 'L
+ ^ \0\ ',_binary ' y  h '),(_binary '7  Ӻs \0\ ','BK694449','user96215@gmail.com','Bui Thi H','0775525132',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7    s\ ','CASH','REFUNDED',1,_binary '7  ƺs \0\ ','CONFIRMED',700000.00,'2025-11-06 01:14:06.000000',_binary 'L jк^ \0 ',_binary 'L  u ^ ',_binary 'd  z i '),(_binary '7  غs \0\ ','BK865718','user6064@gmail.com','Bui Thi H','0413533161',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7   s ','CASH','PAID',3,_binary '7  7 s ','CONFIRMED',2100000.00,'2025-11-06 01:14:06.000000',_binary 'L e9 ^ \0\ ',_binary 'L 建^ \0 ',_binary 'd  # i '),(_binary '7    s\ ','BK012486','user61305@gmail.com','Nguyen Van A','0369925161',NULL,NULL,'2025-11-06 01:14:06.000000',_binary '7 \r  s ','CARD','PAID',1,_binary '7 \r  s ','PAID',700000.00,'2025-11-06 01:14:06.000000',_binary 'L  u ^ ',_binary 'L jк^ \0 ',_binary 'd    i\ ');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings_seq`
--

DROP TABLE IF EXISTS `bookings_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings_seq`
--

LOCK TABLES `bookings_seq` WRITE;
/*!40000 ALTER TABLE `bookings_seq` DISABLE KEYS */;
INSERT INTO `bookings_seq` VALUES (1);
/*!40000 ALTER TABLE `bookings_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinces`
--

DROP TABLE IF EXISTS `provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provinces` (
  `id` binary(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKdalikev902uvkpwn632apqe1k` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces`
--

LOCK TABLES `provinces` WRITE;
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
INSERT INTO `provinces` VALUES (_binary ' +> |ϓX  (!',_binary '','01','2025-10-28 21:35:38.637007','Thành phố Hà Nội',NULL),(_binary ' +> r    Y)7',_binary '','19','2025-10-28 21:35:38.643289','Tỉnh Thái Nguyên',NULL),(_binary ' +> r Vcp ƛ \0',_binary '','14','2025-10-28 21:35:38.643289','Tỉnh Sơn La',NULL),(_binary ' +> r`   Ne% ',_binary '','12','2025-10-28 21:35:38.643289','Tỉnh Lai Châu',NULL),(_binary ' +> t \ZY   =r\0',_binary '','22','2025-10-28 21:35:38.643289','Tỉnh Quảng Ninh',NULL),(_binary ' +> y  *  n ',_binary '','11','2025-10-28 21:35:38.643289','Tỉnh Điện Biên',NULL),(_binary ' +> z0      \nR',_binary '','20','2025-10-28 21:35:38.643289','Tỉnh Lạng Sơn',NULL),(_binary ' +> z` 0 /W ) ',_binary '','04','2025-10-28 21:35:38.643289','Tỉnh Cao Bằng',NULL),(_binary ' +> _ )x\n  \"',_binary '','15','2025-10-28 21:35:38.643289','Tỉnh Lào Cai',NULL),(_binary ' +> Ź1g ',_binary '','08','2025-10-28 21:35:38.643289','Tỉnh Tuyên Quang',NULL),(_binary ' +> p  R ͼ  ;',_binary '','80','2025-10-28 21:35:38.648159','Tỉnh Tây Ninh',NULL),(_binary ' +> q ʚt !e\0',_binary '','31','2025-10-28 21:35:38.648159','Thành phố Hải Phòng',NULL),(_binary ' +> q  D  R* \0',_binary '','68','2025-10-28 21:35:38.648159','Tỉnh Lâm Đồng',NULL),(_binary ' +> s     t   ',_binary '','40','2025-10-28 21:35:38.648159','Tỉnh Nghệ An',NULL),(_binary ' +> sC  o f ',_binary '','79','2025-10-28 21:35:38.648159','Thành phố Hồ Chí Minh',NULL),(_binary ' +> sg   ̎Fw',_binary '','24','2025-10-28 21:35:38.648159','Tỉnh Bắc Ninh',NULL),(_binary ' +> t\n DJ O *',_binary '','92','2025-10-28 21:35:38.648159','Thành phố Cần Thơ',NULL),(_binary ' +> tA   Q ) ',_binary '','37','2025-10-28 21:35:38.648159','Tỉnh Ninh Bình',NULL),(_binary ' +> tѤ ԕH \\',_binary '','56','2025-10-28 21:35:38.648159','Tỉnh Khánh Hòa',NULL),(_binary ' +> uN + l?% \0',_binary '','44','2025-10-28 21:35:38.648159','Tỉnh Quảng Trị',NULL),(_binary ' +> v    |    ',_binary '','51','2025-10-28 21:35:38.648159','Tỉnh Quảng Ngãi',NULL),(_binary ' +> x    a   ',_binary '','33','2025-10-28 21:35:38.648159','Tỉnh Hưng Yên',NULL),(_binary ' +> x  B  3  ',_binary '','96','2025-10-28 21:35:38.648159','Tỉnh Cà Mau',NULL),(_binary ' +> x  H  $  ;',_binary '','42','2025-10-28 21:35:38.648159','Tỉnh Hà Tĩnh',NULL),(_binary ' +> xM ;S&Pk<o',_binary '','46','2025-10-28 21:35:38.648159','Thành phố Huế',NULL),(_binary ' +> y     _ ',_binary '','66','2025-10-28 21:35:38.648159','Tỉnh Đắk Lắk',NULL),(_binary ' +> yw  N   \0\0',_binary '','75','2025-10-28 21:35:38.648159','Tỉnh Đồng Nai',NULL),(_binary ' +> z  ?   H ',_binary '','48','2025-10-28 21:35:38.648159','Thành phố Đà Nẵng',NULL),(_binary ' +> zʝ  =  ',_binary '','25','2025-10-28 21:35:38.648159','Tỉnh Phú Thọ',NULL),(_binary ' +> {J    m {',_binary '','38','2025-10-28 21:35:38.648159','Tỉnh Thanh Hóa',NULL),(_binary ' +> ~  6 @0  ',_binary '','86','2025-10-28 21:35:38.648159','Tỉnh Vĩnh Long',NULL),(_binary ' +> ~    HBz  ',_binary '','52','2025-10-28 21:35:38.648159','Tỉnh Gia Lai',NULL),(_binary ' +> ~N Kl  D  ',_binary '','91','2025-10-28 21:35:38.648159','Tỉnh An Giang',NULL),(_binary ' +> N  }M5~  ',_binary '','82','2025-10-28 21:35:38.648159','Tỉnh Đồng Tháp',NULL);
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinces_seq`
--

DROP TABLE IF EXISTS `provinces_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provinces_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces_seq`
--

LOCK TABLES `provinces_seq` WRITE;
/*!40000 ALTER TABLE `provinces_seq` DISABLE KEYS */;
INSERT INTO `provinces_seq` VALUES (1);
/*!40000 ALTER TABLE `provinces_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_stops`
--

DROP TABLE IF EXISTS `route_stops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_stops` (
  `active` bit(1) NOT NULL,
  `allow_dropoff` bit(1) NOT NULL,
  `allow_pickup` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_bus_station` bit(1) NOT NULL,
  `stop_order` int NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `route_id` binary(16) NOT NULL,
  `stop_id` binary(16) NOT NULL,
  PRIMARY KEY (`route_id`,`stop_id`),
  KEY `FKjmssq6w9xpsvupp2x407s43i2` (`stop_id`),
  CONSTRAINT `FK63y33daxb1qs5nbnkuicbpkej` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`),
  CONSTRAINT `FKjmssq6w9xpsvupp2x407s43i2` FOREIGN KEY (`stop_id`) REFERENCES `stops` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_stops`
--

LOCK TABLES `route_stops` WRITE;
/*!40000 ALTER TABLE `route_stops` DISABLE KEYS */;
INSERT INTO `route_stops` VALUES (_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',5,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L ) ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',7,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L
+ ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',6,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L % ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',1,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L >  ^ '),(_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',3,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L jк^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',4,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L 建^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:28:04.000000',_binary '',2,'2025-11-05 23:28:04.000000',_binary '  c \0\ ',_binary 'L    ^\ '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',3,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L *ɺ^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',4,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L = ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',1,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L e9 ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',6,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L jк^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',5,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L |R ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',7,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L 建^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:37:53.000000',_binary '',2,'2025-11-05 23:37:53.000000',_binary 'Nm  c \0 ',_binary 'L  u ^ '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',5,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L *ɺ^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',4,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L = ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',7,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L e9 ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',2,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L jк^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',3,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L |R ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',1,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L 建^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:36:40.000000',_binary '',6,'2025-11-05 23:36:40.000000',_binary 'c4 \' c \0\ ',_binary 'L  u ^ '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',3,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L ) ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',1,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L
+ ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',2,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L % ^ \0\ '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',7,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L >  ^ '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',5,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L jк^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',4,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L 建^ \0 '),(_binary '',_binary '',_binary '','2025-11-05 23:31:53.000000',_binary '',6,'2025-11-05 23:31:53.000000',_binary '  : b \0',_binary 'L    ^\ ');
/*!40000 ALTER TABLE `route_stops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `id` binary(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `code` varchar(50) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `distance_km` double DEFAULT NULL,
  `estimated_duration_minutes` int DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `end_stop_id` binary(16) NOT NULL,
  `start_stop_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKa9rxiut5x5syhn30p1e5uxfn5` (`code`),
  KEY `FK6qio0otbp4s6o868ifgw4awcv` (`end_stop_id`),
  KEY `FKtcytdgrfs6kql81lex9u4wm66` (`start_stop_id`),
  CONSTRAINT `FK6qio0otbp4s6o868ifgw4awcv` FOREIGN KEY (`end_stop_id`) REFERENCES `stops` (`id`),
  CONSTRAINT `FKtcytdgrfs6kql81lex9u4wm66` FOREIGN KEY (`start_stop_id`) REFERENCES `stops` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (_binary '  c \0\ ',_binary '','HCM-HN','2025-11-05 23:18:39.000000',1800,288,'TH HCM - Hà Nội','2025-11-05 23:18:39.000000',_binary 'L >  ^ ',_binary 'L
+ ^ \0\ '),(_binary 'Nm  c \0 ',_binary '','CM-QN','2025-11-05 23:20:12.000000',1200,200,'Cà Mau - Quảng Ngãi','2025-11-05 23:20:12.000000',_binary 'L e9 ^ \0\ ',_binary 'L 建^ \0 '),(_binary 'c4 \' c \0\ ',_binary '','QN-CM','2025-11-05 23:20:47.000000',1200,200,'Quảng Ngãi - Cà Mau','2025-11-05 23:20:47.000000',_binary 'L 建^ \0 ',_binary 'L e9 ^ \0\ '),(_binary '  : b \0',_binary '','HN-HCM','2025-11-05 23:17:50.000000',1800,288,'Hà Nội - TP HCM','2025-11-05 23:17:50.000000',_binary 'L
+ ^ \0\ ',_binary 'L >  ^ ');
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes_seq`
--

DROP TABLE IF EXISTS `routes_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes_seq`
--

LOCK TABLES `routes_seq` WRITE;
/*!40000 ALTER TABLE `routes_seq` DISABLE KEYS */;
INSERT INTO `routes_seq` VALUES (1);
/*!40000 ALTER TABLE `routes_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deck_number` int DEFAULT NULL,
  `seat_code` varchar(10) NOT NULL,
  `status` enum('ACTIVE','INACTIVE','MAINTENANCE') NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `vehicle_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8pt16nqlsq4xjel55rymxlja6` (`vehicle_id`),
  CONSTRAINT `FK8pt16nqlsq4xjel55rymxlja6` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES (_binary '  PA\ pq ;E\"L>\ ','2025-11-06 01:42:13.007539',1,'24','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ p  Y  D ; ','2025-11-06 01:42:13.007539',1,'17','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ q \  \ \ \ ','2025-11-06 01:42:13.007539',1,'07','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ q\ B\  \ \ n\ ','2025-11-06 01:42:13.007539',1,'25','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ q\ \ I9 \  ','2025-11-06 01:42:13.007539',1,'35','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ r`  I sh|F','2025-11-06 01:42:13.007539',1,'05','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ r    \ \ F<','2025-11-06 01:42:13.007539',1,'36','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ r  ɡ\ rC\ ','2025-11-06 01:42:13.007539',1,'14','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ r  \      ','2025-11-06 01:42:13.007539',1,'38','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ tE &\ ٝ& \ ','2025-11-06 01:42:13.007539',1,'39','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ u@ W\ B\'%\ ','2025-11-06 01:42:13.007539',1,'19','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ u  ,s b\ <','2025-11-06 01:42:13.007539',1,'30','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ u\ @қ \ 2C','2025-11-06 01:42:13.007539',1,'20','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ v  G&\0\ \ j','2025-11-06 01:42:13.007539',1,'37','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ v  ( f   ','2025-11-06 01:42:13.007539',1,'31','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ v  a   z3E','2025-11-06 01:42:13.007539',1,'16','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ wQ    \ ̟ ','2025-11-06 01:42:13.007539',1,'02','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ xy L\\5  ͐','2025-11-06 01:42:13.007539',1,'33','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ x  NYS
F1','2025-11-06 01:42:13.007539',1,'32','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ yV ? |  w|','2025-11-06 01:42:13.007539',1,'04','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ z; wA\ \ hX','2025-11-06 01:42:13.007539',1,'01','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ z\ G\ p 1A<','2025-11-06 01:42:13.007539',1,'28','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ z\ aXE\ s >','2025-11-06 01:42:13.007539',1,'13','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ z\  h  \ F\ ','2025-11-06 01:42:13.007539',1,'18','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ {.  - E\ \ ','2025-11-06 01:42:13.007539',1,'29','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ {k \  r\ <\ ','2025-11-06 01:42:13.007539',1,'08','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ |@  -\ /\ \ ','2025-11-06 01:42:13.007539',1,'27','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ |å)\     {','2025-11-06 01:42:13.007539',1,'15','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ }] 6Q<n
','2025-11-06 01:42:13.007539',1,'12','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ }~ [\ ˊ  \ ','2025-11-06 01:42:13.007539',1,'03','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ }  \ \  3#','2025-11-06 01:42:13.007539',1,'11','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ }  L  Ga','2025-11-06 01:42:13.007539',1,'40','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ ~   ܳ Wb\ ','2025-11-06 01:42:13.007539',1,'34','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ ~D \ a \ lQ','2025-11-06 01:42:13.007539',1,'10','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ ~    \   \ ','2025-11-06 01:42:13.007539',1,'06','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ ~  c \ C\ $','2025-11-06 01:42:13.007539',1,'09','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ ~ć  \\\ .(e','2025-11-06 01:42:13.007539',1,'21','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ # h\n=j\ g','2025-11-06 01:42:13.007539',1,'26','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ _  [\ #8- ','2025-11-06 01:42:13.007539',1,'22','ACTIVE',NULL,_binary 'LM
 ^ \0\ '),(_binary '  PA\ t  S\ \ y','2025-11-06 01:42:13.007539',1,'23','ACTIVE',NULL,_binary 'LM
 ^ \0\ ');
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats_seq`
--

DROP TABLE IF EXISTS `seats_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats_seq`
--

LOCK TABLES `seats_seq` WRITE;
/*!40000 ALTER TABLE `seats_seq` DISABLE KEYS */;
INSERT INTO `seats_seq` VALUES (1);
/*!40000 ALTER TABLE `seats_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stops`
--

DROP TABLE IF EXISTS `stops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stops` (
  `id` binary(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `address` varchar(511) DEFAULT NULL,
  `allow_dropoff` bit(1) NOT NULL,
  `allow_pickup` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_bus_station` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `province_id` binary(16) DEFAULT NULL,
  `ward_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtemjkpyf5qm5aw68gbqxwvm9v` (`province_id`),
  KEY `FK8h5781df6ohnp3m5cgbvmpbi3` (`ward_id`),
  CONSTRAINT `FK8h5781df6ohnp3m5cgbvmpbi3` FOREIGN KEY (`ward_id`) REFERENCES `wards` (`id`),
  CONSTRAINT `FKtemjkpyf5qm5aw68gbqxwvm9v` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stops`
--

LOCK TABLES `stops` WRITE;
/*!40000 ALTER TABLE `stops` DISABLE KEYS */;
INSERT INTO `stops` VALUES (_binary '  I\ Px  ܭN3x\ |',_binary '','292 Đinh Bộ Lĩnh, Bình Thạnh, TP.HCM',_binary '',_binary '','2025-11-06 01:42:12.965179',_binary '','Bến xe Miền Đông',NULL,_binary ' +> sC  o f ',_binary ' +>  q gR  :g'),(_binary '  Ju wx _o5f ,',_binary '','Số 1, Đường Trung Tâm, Quận 1, TP.HCM',_binary '',_binary '','2025-11-06 01:42:12.969456',_binary '','Bến xe Trung Tâm',NULL,_binary ' +> sC  o f ',_binary ' +>  q gR  :g');
/*!40000 ALTER TABLE `stops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stops_seq`
--

DROP TABLE IF EXISTS `stops_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stops_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stops_seq`
--

LOCK TABLES `stops_seq` WRITE;
/*!40000 ALTER TABLE `stops_seq` DISABLE KEYS */;
INSERT INTO `stops_seq` VALUES (1);
/*!40000 ALTER TABLE `stops_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trips` (
  `id` binary(16) NOT NULL,
  `actual_arrival_time` datetime(6) DEFAULT NULL,
  `actual_departure_time` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `driver` binary(16) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `scheduled_arrival_time` datetime(6) DEFAULT NULL,
  `scheduled_departure_time` datetime(6) NOT NULL,
  `status` enum('CANCELLED','COMPLETED','DELAYED','ONGOING','SCHEDULED') NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `route_id` binary(16) NOT NULL,
  `vehicle_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm7ci3blm9wj2k0d94chu18y7s` (`route_id`),
  KEY `FKqahsaodjirbk4if91c9bfnlgg` (`vehicle_id`),
  CONSTRAINT `FKm7ci3blm9wj2k0d94chu18y7s` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`),
  CONSTRAINT `FKqahsaodjirbk4if91c9bfnlgg` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES (_binary ' y  h ',NULL,NULL,'2025-11-05 23:54:20.000000',_binary ' z h \0\ ','',800000.00,'2025-11-04 14:00:00.000000','2025-11-06 14:00:00.000000','SCHEDULED','2025-11-05 23:54:20.000000',_binary '  : b \0',_binary 'LM
 ^ \0\ '),(_binary ' X˺i \0 ',NULL,NULL,'2025-11-06 00:01:36.000000',_binary ' Y+ i \0\ ','',800000.00,'2025-11-04 14:00:00.000000','2025-11-06 14:00:00.000000','SCHEDULED','2025-11-06 00:01:36.000000',_binary '  c \0\ ',_binary 'LX  ^ \0\ '),(_binary ' dºi \0 ',NULL,NULL,'2025-11-06 00:01:36.000000',_binary ' d׺i \0 ','',800000.00,'2025-11-07 14:00:00.000000','2025-11-09 14:00:00.000000','SCHEDULED','2025-11-06 00:01:36.000000',_binary '  : b \0',_binary 'LX  ^ \0\ '),(_binary ' k i \0\ ',NULL,NULL,'2025-11-06 00:01:36.000000',_binary ' k i \0\ ','',800000.00,'2025-11-07 14:00:00.000000','2025-11-09 14:00:00.000000','SCHEDULED','2025-11-06 00:01:36.000000',_binary '  c \0\ ',_binary 'LM
 ^ \0\ '),(_binary 'd  # i ',NULL,NULL,'2025-11-06 00:03:47.000000',_binary 'd  J i ','',700000.00,'2025-11-07 14:00:00.000000','2025-11-09 10:00:00.000000','SCHEDULED','2025-11-06 00:03:47.000000',_binary 'c4 \' c \0\ ',_binary 'Lf  ^ \0\ '),(_binary 'd  z i ',NULL,NULL,'2025-11-06 00:03:47.000000',_binary 'd    i\ ','',700000.00,'2025-11-04 14:00:00.000000','2025-11-06 10:00:00.000000','SCHEDULED','2025-11-06 00:03:47.000000',_binary 'Nm  c \0 ',_binary 'Lf  ^ \0\ '),(_binary 'd  Ӻi \0\ ',NULL,NULL,'2025-11-06 00:03:47.000000',_binary 'd   i \0','',700000.00,'2025-11-07 14:00:00.000000','2025-11-09 10:00:00.000000','SCHEDULED','2025-11-06 00:03:47.000000',_binary 'Nm  c \0 ',_binary 'L_ ^ \0 k'),(_binary 'd    i\ ',NULL,NULL,'2025-11-06 00:03:47.000000',_binary 'd   i \0','',700000.00,'2025-11-04 14:00:00.000000','2025-11-06 10:00:00.000000','SCHEDULED','2025-11-06 00:03:47.000000',_binary 'c4 \' c \0\ ',_binary 'L_ ^ \0 k');
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips_seq`
--

DROP TABLE IF EXISTS `trips_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trips_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips_seq`
--

LOCK TABLES `trips_seq` WRITE;
/*!40000 ALTER TABLE `trips_seq` DISABLE KEYS */;
INSERT INTO `trips_seq` VALUES (1);
/*!40000 ALTER TABLE `trips_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `id` binary(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `active_seat_count` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `license_plate` varchar(20) NOT NULL,
  `seat_capacity` int NOT NULL,
  `status` enum('ACTIVE','INACTIVE','MAINTENANCE') NOT NULL,
  `vehicle_type` enum('BED','LIMOUSINE','SEAT') NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9vovnbiegxevdhqfcwvp2g8pj` (`license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (_binary 'LM
 ^ \0\ ',_binary '',40,'2025-11-05 22:44:21.000000','59BH 01',40,'ACTIVE','SEAT','2025-11-05 22:44:21.000000'),(_binary 'LX  ^ \0\ ',_binary '',40,'2025-11-05 22:44:21.000000','59BH 02',40,'ACTIVE','SEAT','2025-11-05 22:44:21.000000'),(_binary 'L_ ^ \0 k',_binary '',40,'2025-11-05 22:44:21.000000','59BH 03',40,'ACTIVE','SEAT','2025-11-05 22:44:21.000000'),(_binary 'Lf  ^ \0\ ',_binary '',40,'2025-11-05 22:44:21.000000','59BH 04',40,'ACTIVE','SEAT','2025-11-05 22:44:21.000000'),(_binary 'Ll   ^ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 05',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'Lro˺^ \0 k\0',_binary '',40,'2025-11-05 22:44:22.000000','59BH 06',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'Lx/  ^ \0\ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 07',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L~  ^ \0\ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 08',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L ݺ^ \0 ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 09',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L < ^ \0\ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 014',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L j^ ^ \0\ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 013',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L  + ^ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 011',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L  } ^ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 010',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L  ~ ^ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 015',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000'),(_binary 'L  غ^ \0\ ',_binary '',40,'2025-11-05 22:44:22.000000','59BH 012',40,'ACTIVE','SEAT','2025-11-05 22:44:22.000000');
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles_seq`
--

DROP TABLE IF EXISTS `vehicles_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles_seq`
--

LOCK TABLES `vehicles_seq` WRITE;
/*!40000 ALTER TABLE `vehicles_seq` DISABLE KEYS */;
INSERT INTO `vehicles_seq` VALUES (1);
/*!40000 ALTER TABLE `vehicles_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wards`
--

DROP TABLE IF EXISTS `wards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wards` (
  `id` binary(16) NOT NULL,
  `active` bit(1) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `province_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKntapeoauvvkx36nfnwsfhmo8` (`code`),
  KEY `FKbwfs5nhey1leef1v5ydhb45j2` (`province_id`),
  CONSTRAINT `FKbwfs5nhey1leef1v5ydhb45j2` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wards`
--

LOCK TABLES `wards` WRITE;
/*!40000 ALTER TABLE `wards` DISABLE KEYS */;
INSERT INTO `wards` VALUES (_binary ' +>  q gR  :g',_binary '','79001','2025-10-28 21:35:38.766539','Quận 1',NULL,_binary ' +> sC  o f '),(_binary ' +>  x  D 1߯|',_binary '','79002','2025-10-28 21:35:38.767111','Quận 3',NULL,_binary ' +> sC  o f ');
/*!40000 ALTER TABLE `wards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wards_seq`
--

DROP TABLE IF EXISTS `wards_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wards_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wards_seq`
--

LOCK TABLES `wards_seq` WRITE;
/*!40000 ALTER TABLE `wards_seq` DISABLE KEYS */;
INSERT INTO `wards_seq` VALUES (1);
/*!40000 ALTER TABLE `wards_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coach_service_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-06  2:10:30
