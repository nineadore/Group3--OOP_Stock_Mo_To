-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `currentstock`
--

DROP TABLE IF EXISTS `currentstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currentstock` (
  `productcode` varchar(45) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`productcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currentstock`
--

LOCK TABLES `currentstock` WRITE;
/*!40000 ALTER TABLE `currentstock` DISABLE KEYS */;
INSERT INTO `currentstock` VALUES ('prod1',146),('prod10',1),('prod11',2),('prod2',100),('prod3',202),('prod4',172),('prod5',500),('prod6',500),('prod7',10),('prod8',20),('prod9',1);
/*!40000 ALTER TABLE `currentstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `customercode` varchar(45) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=309 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (301,'vip1','Trisha Lopez','Quezon City','9818562354'),(302,'vip2','Ivan Mercado','Makati','9650245489'),(303,'std1','Erika Santos','Manila','9236215622'),(306,'vip3','Paolo Cruz','Pasig','9826546182'),(308,'std2','Danica Reyes','Taguig','9854612478');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `productcode` varchar(45) NOT NULL,
  `productname` varchar(45) NOT NULL,
  `costprice` double NOT NULL,
  `sellprice` double NOT NULL,
  `brand` varchar(45) NOT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `productcode_UNIQUE` (`productcode`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (111,'prod1','Laptop',85000,90000,'Dell'),(112,'prod2','Laptop',70000,72000,'HP'),(113,'prod3','Mobile',60000,64000,'Apple'),(114,'prod4','Mobile',50000,51000,'Samsung'),(121,'prod5','Charger',2000,2100,'Apple'),(122,'prod6','Mouse',1700,1900,'Dell'),(128,'prod7','Power Adapter',3000,3500,'Dell'),(129,'prod8','Smart Watch',15000,17000,'Apple'),(130,'prod9','Mobile',30000,35000,'Apple'),(131,'prod10','Phone',12000,15000,'Vivo'),(132,'prod11','Phone',15000,20000,'Vivo');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseinfo`
--

DROP TABLE IF EXISTS `purchaseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchaseinfo` (
  `purchaseID` int NOT NULL AUTO_INCREMENT,
  `suppliercode` varchar(45) NOT NULL,
  `productcode` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `quantity` int NOT NULL,
  `totalcost` double NOT NULL,
  PRIMARY KEY (`purchaseID`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseinfo`
--

LOCK TABLES `purchaseinfo` WRITE;
/*!40000 ALTER TABLE `purchaseinfo` DISABLE KEYS */;
INSERT INTO `purchaseinfo` VALUES (1001,'sup1','prod1','Wed Jan 14 00:15:19 IST 2021',10,850000),(1002,'sup1','prod6','Wed Jan 14 00:15:19 IST 2021',20,34000),(1003,'sup2','prod3','Wed Jan 14 00:15:19 IST 2021',5,300000),(1004,'sup2','prod5','Wed Jan 14 00:15:19 IST 2021',5,10000),(1005,'sup3','prod2','Wed Jan 14 00:15:19 IST 2021',2,140000),(1006,'sup4','prod4','Wed Jan 14 00:15:19 IST 2021',2,100000),(1009,'sup2','prod3','Wed Sep 01 04:11:13 IST 2021',2,120000),(1010,'sup1','prod7','Wed Sep 01 04:25:06 IST 2021',10,30000),(1011,'sup2','prod8','Fri Sep 03 00:00:00 IST 2021',20,300000);
/*!40000 ALTER TABLE `purchaseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesinfo`
--

DROP TABLE IF EXISTS `salesinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesinfo` (
  `salesid` int NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `productcode` varchar(45) NOT NULL,
  `customercode` varchar(45) NOT NULL,
  `quantity` int NOT NULL,
  `revenue` double NOT NULL,
  `soldby` varchar(45) NOT NULL,
  PRIMARY KEY (`salesid`)
) ENGINE=InnoDB AUTO_INCREMENT=2013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesinfo`
--

LOCK TABLES `salesinfo` WRITE;
/*!40000 ALTER TABLE `salesinfo` DISABLE KEYS */;
INSERT INTO `salesinfo` VALUES (2001,'Fri Jan 16 23:12:40 IST 2021','prod1','vip1',3,270000,'stduser1'),(2002,'Fri Jan 16 23:12:40 IST 2021','prod2','vip2',2,144000,'stduser1'),(2003,'Fri Jan 16 23:12:40 IST 2021','prod3','std1',1,64000,'aduser1'),(2004,'Fri Jan 16 23:12:40 IST 2021','prod4','std2',5,255000,'aduser1'),(2006,'Thu Aug 05 17:29:36 IST 2021','prod1','vip1',2,180000,'root'),(2007,'Fri Aug 06 00:00:00 IST 2021','prod4','std1',1,51000,'aduser1'),(2008,'Fri Aug 06 02:41:28 IST 2021','prod7','std1',1,3500,'aduser1'),(2009,'Sat Aug 07 00:00:00 IST 2021','prod7','std1',5,17500,'aduser1'),(2010,'Thu Aug 12 00:00:00 IST 2021','prod4','vip3',2,102000,'root'),(2011,'Sun Aug 15 23:08:51 IST 2021','prod7','vip2',10,35000,'root'),(2012,'Thu Aug 26 15:17:48 IST 2021','prod4','vip3',5,255000,'aduser1');
/*!40000 ALTER TABLE `salesinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `suppliercode` varchar(45) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=409 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (401,'sup1','Dell Inc.','Las Piñas','9800560001'),(402,'sup2','iWorld Stores','San Juan','9800560041'),(403,'sup3','Samsung Appliances','Antipolo','9546521234'),(404,'sup4','Hewlett-Packard','San Pablo','9555202215'),(407,'sup5','UrbanThreads Co.','Caloocan','9555203300'),(408,'sup6','Shelby Company Ltd.','Batangas','9696969696');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogs`
--

DROP TABLE IF EXISTS `userlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userlogs` (
  `username` varchar(45) NOT NULL,
  `in_time` varchar(45) NOT NULL,
  `out_time` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogs`
--

LOCK TABLES `userlogs` WRITE;
/*!40000 ALTER TABLE `userlogs` DISABLE KEYS */;
INSERT INTO `userlogs` VALUES ('aduser1','2021-09-01T04:46:55.125709800','2021-09-01T04:47:01.801381'),('root','2021-09-01T05:02:43.010014','2021-09-01T05:02:50.224787400'),('stduser1','2021-09-01T05:04:57.690182100','2021-09-01T05:05:04.294274300'),('root','2021-09-01T05:05:12.269897600','2021-09-01T05:05:16.866792500'),('root','2021-09-01T05:10:08.728527600','2021-09-01T05:10:16.926883100'),('root','2021-09-01T06:19:09.326477200','2021-09-01T06:19:21.641620900'),('emp1','2021-09-01T06:19:34.536411800','2021-09-01T06:19:43.517392100'),('root','2021-09-01T06:19:46.811400900','2021-09-01T06:20:10.879660700'),('root','2021-09-01T14:59:48.661066400','2021-09-01T15:02:09.761864900'),('root','2021-09-01T15:09:02.964317400','2021-09-01T15:09:14.141324800'),('root','2021-09-01T15:09:27.889908500','2021-09-01T15:09:48.262387'),('root','2021-09-01T15:38:48.557639300','2021-09-01T15:40:00.527183800'),('root','2021-09-01T15:40:22.622326','2021-09-01T15:41:06.461438500'),('root','2021-09-01T15:44:26.195028100','2021-09-01T15:44:33.071448800'),('root','2021-09-02T01:42:52.417989900','2021-09-02T01:42:55.226675900'),('root','2021-09-02T01:43:12.226339400','2021-09-02T01:43:15.818776'),('aduser1','2021-09-03T02:12:41.021781900','2021-09-03T02:19:11.829873500'),('aduser1','2025-06-12T16:45:47.076518900','2025-06-12T16:47:04.926589400'),('root','2025-06-12T16:47:17.441258600','2025-06-12T16:48:24.702495500'),('aduser1','2025-06-12T16:48:35.169398900','2025-06-12T16:51:27.656863'),('root','2025-06-12T16:51:41.679684','2025-06-12T16:51:47.634332200'),('aduser1','2025-06-12T16:53:35.071088100','2025-06-12T16:54:21.087623600'),('aduser1','2025-06-12T16:54:35.916016300','2025-06-12T16:59:26.648833500'),('root','2025-06-12T16:59:31.032535900','2025-06-12T17:15:57.648262900'),('root','2025-06-12T17:16:01.833500500','2025-06-12T17:16:09.361011200'),('root','2025-06-13T15:33:22.023709200','2025-06-13T15:42:22.974965800'),('cutie123','2025-06-13T15:42:33.210847100','2025-06-13T15:42:40.397072100'),('cutie123','2025-06-13T15:55:21.594513','2025-06-13T15:55:30.763824800'),('cutie123','2025-06-13T15:58:19.947911800','2025-06-13T15:58:36.689736600'),('cutie123','2025-06-13T16:13:12.837339800','2025-06-13T16:13:19.194196800'),('root','2025-06-13T16:15:04.557000200','2025-06-13T16:16:16.807489700'),('root','2025-06-13T16:17:25.060237700','2025-06-13T16:17:38.498963500'),('root','2025-06-13T16:21:02.581038','2025-06-13T16:21:17.960524800'),('cutie123','2025-06-13T16:22:06.290719900','2025-06-13T16:22:23.329227'),('root','2025-06-13T16:22:53.087360','2025-06-13T16:23:05.517962600'),('root','2025-06-13T16:24:25.877429100','2025-06-13T16:24:30.159859400'),('root','2025-06-13T16:24:45.974544900','2025-06-13T16:25:32.646545'),('root','2025-06-13T16:26:26.321692700','2025-06-13T16:26:45.413273700'),('root','2025-06-13T16:27:42.623445800','2025-06-13T16:27:48.372087100'),('root','2025-06-13T16:28:05.484323','2025-06-13T16:28:08.854268800'),('root','2025-06-13T16:29:05.993113200','2025-06-13T16:29:11.624605200'),('root','2025-06-13T16:29:30.263274300','2025-06-13T16:29:33.681992800'),('root','2025-06-13T16:35:45.053663900','2025-06-13T16:36:05.638549400'),('root','2025-06-13T16:37:45.987652400','2025-06-13T16:38:03.998576300'),('root','2025-06-13T16:38:19.910077800','2025-06-13T16:38:24.394464600'),('root','2025-06-13T16:38:44.043372100','2025-06-13T16:38:49.888728700'),('root','2025-06-13T16:39:59.172116100','2025-06-13T16:40:07.948426300'),('root','2025-06-13T16:50:21.062268100','2025-06-13T16:50:31.142007600'),('root','2025-06-13T16:59:03.624464800','2025-06-13T16:59:21.996119800'),('root','2025-06-13T17:01:37.956523900','2025-06-13T17:02:17.044112500'),('root','2025-06-13T17:03:59.373238200','2025-06-13T17:05:49.950445100'),('root','2025-06-13T17:06:46.419888700','2025-06-13T17:14:43.616580800'),('root','2025-06-13T17:15:24.273177600','2025-06-13T17:19:09.428818'),('root','2025-06-13T17:28:33.257522800','2025-06-13T17:28:59.133720600'),('root','2025-06-13T17:32:03.026431900','2025-06-13T17:32:28.008303200'),('root','2025-06-13T17:32:58.867710400','2025-06-13T17:33:35.460598100'),('root','2025-06-13T17:34:22.347841100','2025-06-13T17:34:28.955996500'),('root','2025-06-13T17:35:31.978206200','2025-06-13T17:35:52.801161900'),('root','2025-06-13T17:37:17.404668600','2025-06-13T17:37:51.770441300'),('root','2025-06-13T15:15:23.358871200','2025-06-13T17:42:45.284504700'),('root','2025-06-13T17:45:04.001533400','2025-06-13T17:46:46.435825300'),('root','2025-06-13T17:47:46.850773','2025-06-13T17:48:43.799265100'),('emp1','2025-06-13T17:48:51.243124','2025-06-13T17:49:15.920575100'),('root','2025-06-13T17:49:27.839042500','2025-06-13T17:49:52.463002800');
/*!40000 ALTER TABLE `userlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `usertype` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (17,'Raziela Calapatia','Cavite','9650786717','raziela34','dbadpass','ADMINISTRATOR'),(18,'Kharel Acierto','Laguna','9660654785','kharel12','dbstdpass','EMPLOYEE'),(20,'Janine Adores','Valenzuela','9876543210','janine09','root','ADMINISTRATOR'),(29,'Angelo Dondonayos','Mandaluyong','1122334455','angelo56','emp1','EMPLOYEE'),(31,'Sophia Balatbat','Manila','9171667390','sophia78','cutie123','ADMINISTRATOR'),(32,'Micka Soriano','Laguna','9270497014','micka90','aki123','ADMINISTARTOR');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'inventory'
--

--
-- Dumping routines for database 'inventory'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-14 15:20:35
