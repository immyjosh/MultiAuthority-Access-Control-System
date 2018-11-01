/*
SQLyog Community v12.02 (32 bit)
MySQL - 5.5.29 : Database - sharedauthority
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sharedauthority` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sharedauthority`;

/*Table structure for table `capt` */

DROP TABLE IF EXISTS `capt`;

CREATE TABLE `capt` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `cont` varchar(200) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `capt` */

insert  into `capt`(`id`,`name`,`cont`) values (1,'1.jpg','polish'),(2,'2.jpg','past'),(3,'3.jpg','part'),(4,'4.jpg','when'),(5,'5.jpg','much'),(6,'6.jpg','seed'),(7,'7.jpg','soap'),(8,'8.jpg','glove'),(9,'9.jpg','sticky'),(10,'10.jpg','soap'),(11,'11.jpg','profit'),(12,'12.jpg','bent'),(13,'13.jpg','collar'),(14,'14.jpg','where'),(15,'15.jpg','weight'),(16,'16.jpg','again'),(17,'17.jpg','weight'),(18,'18.jpg','boat'),(19,'19.jpg','small'),(20,'20.jpg','profit');

/*Table structure for table `client_registration` */

DROP TABLE IF EXISTS `client_registration`;

CREATE TABLE `client_registration` (
  `C_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `C_First` varchar(200) DEFAULT NULL,
  `C_Second` varchar(200) DEFAULT NULL,
  `C_UserName` varchar(200) DEFAULT NULL,
  `C_Password` varchar(200) DEFAULT NULL,
  `C_Email` varchar(200) DEFAULT NULL,
  `C_Gender` varchar(200) DEFAULT NULL,
  `C_Country` varchar(200) DEFAULT NULL,
  `C_State` varchar(200) DEFAULT NULL,
  `C_City` varchar(200) DEFAULT NULL,
  `C_Status` varchar(100) DEFAULT NULL,
  `C_Owner` varchar(100) DEFAULT NULL,
  `T_Status` varchar(200) DEFAULT 'Not-active',
  `kk` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`C_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `client_registration` */

insert  into `client_registration`(`C_Id`,`C_First`,`C_Second`,`C_UserName`,`C_Password`,`C_Email`,`C_Gender`,`C_Country`,`C_State`,`C_City`,`C_Status`,`C_Owner`,`T_Status`,`kk`) values (1,'a','a','a','a','bhuvana.vlsa@gmail.com','male','india','tamilnadu','chennai','Active','1','Active','2559');

/*Table structure for table `clientupload` */

DROP TABLE IF EXISTS `clientupload`;

CREATE TABLE `clientupload` (
  `Co_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Co_ClientID` varchar(100) DEFAULT NULL,
  `Co_FileName` varchar(1000) DEFAULT NULL,
  `Co_File` varchar(10000) DEFAULT NULL,
  `Co_Math` varchar(10000) DEFAULT NULL,
  `Co_UpdFil` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`Co_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clientupload` */

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `sno` int(233) DEFAULT NULL,
  `id` int(233) DEFAULT NULL,
  `uname` varchar(233) DEFAULT NULL,
  `comments` varchar(233) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `comments` */

/*Table structure for table `dataowner_registration` */

DROP TABLE IF EXISTS `dataowner_registration`;

CREATE TABLE `dataowner_registration` (
  `D_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `D_First` varchar(200) DEFAULT NULL,
  `D_Second` varchar(200) DEFAULT NULL,
  `D_UserName` varchar(200) DEFAULT NULL,
  `D_Password` varchar(200) DEFAULT NULL,
  `D_Email` varchar(200) DEFAULT NULL,
  `D_Number` varchar(200) DEFAULT NULL,
  `D_Country` varchar(200) DEFAULT NULL,
  `D_Status` varchar(100) DEFAULT NULL,
  `D_Key` int(11) DEFAULT NULL,
  PRIMARY KEY (`D_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `dataowner_registration` */

insert  into `dataowner_registration`(`D_Id`,`D_First`,`D_Second`,`D_UserName`,`D_Password`,`D_Email`,`D_Number`,`D_Country`,`D_Status`,`D_Key`) values (1,'h','h','h','h','h@gmail.com','7098765432','india','Active',NULL);

/*Table structure for table `editfile` */

DROP TABLE IF EXISTS `editfile`;

CREATE TABLE `editfile` (
  `T_EditNo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `T_EditID` varchar(50) DEFAULT NULL,
  `T_EditName` varchar(50) DEFAULT NULL,
  `T_EditEmail` varchar(50) DEFAULT NULL,
  `T_EditCountry` varchar(50) DEFAULT NULL,
  `T_EditFileName` varchar(50) DEFAULT NULL,
  `T_EditFileLoc` varchar(1000) DEFAULT NULL,
  `T_EditRandomNo` varchar(100) DEFAULT NULL,
  `T_RandomKey` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`T_EditNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `editfile` */

insert  into `editfile`(`T_EditNo`,`T_EditID`,`T_EditName`,`T_EditEmail`,`T_EditCountry`,`T_EditFileName`,`T_EditFileLoc`,`T_EditRandomNo`,`T_RandomKey`) values (1,'1','h','h@gmail.com','india','BinaryExample.java','C:uploaduploaded-filesBinaryExample.java','71168','245'),(2,'1','h','h@gmail.com','india','achu.txt','C:uploaduploaded-filesachu.txt','87869','892'),(3,'1','h','h@gmail.com','india','achu.txt','C:uploaduploaded-filesachu.txt','104237','994');

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `uname` varchar(233) DEFAULT NULL,
  `photo` longblob,
  `photo_col` int(233) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `file` */

/*Table structure for table `friends` */

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `uname` varchar(233) DEFAULT NULL,
  `friends` varchar(233) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `friends` */

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(233) NOT NULL AUTO_INCREMENT,
  `uname` varchar(233) DEFAULT NULL,
  `sendto` varchar(233) DEFAULT NULL,
  `message` varchar(233) DEFAULT NULL,
  `privacy` int(233) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `message` */

/*Table structure for table `request` */

DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (
  `uname` varchar(233) DEFAULT NULL,
  `sendto` varchar(233) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `request` */

/*Table structure for table `server` */

DROP TABLE IF EXISTS `server`;

CREATE TABLE `server` (
  `S_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `S_Uid` varchar(100) DEFAULT NULL,
  `S_UserName` varchar(100) DEFAULT NULL,
  `S_Server` varchar(100) DEFAULT NULL,
  `S_Cost` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`S_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `server` */

insert  into `server`(`S_Id`,`S_Uid`,`S_UserName`,`S_Server`,`S_Cost`) values (1,'1','a','free','No Edit');

/*Table structure for table `shareby` */

DROP TABLE IF EXISTS `shareby`;

CREATE TABLE `shareby` (
  `sno` int(233) NOT NULL AUTO_INCREMENT,
  `id` int(233) DEFAULT NULL,
  `uname` varchar(233) DEFAULT NULL,
  `shareto` varchar(233) DEFAULT NULL,
  `privacy` int(233) DEFAULT NULL,
  `old` int(233) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shareby` */

/*Table structure for table `shared` */

DROP TABLE IF EXISTS `shared`;

CREATE TABLE `shared` (
  `id` int(233) NOT NULL AUTO_INCREMENT,
  `uname` varchar(233) DEFAULT NULL,
  `shared` longblob,
  `name` varchar(233) DEFAULT NULL,
  `date` varchar(233) DEFAULT NULL,
  `time` varchar(233) DEFAULT NULL,
  `type` varchar(233) DEFAULT NULL,
  `rates` int(233) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shared` */

/*Table structure for table `upload` */

DROP TABLE IF EXISTS `upload`;

CREATE TABLE `upload` (
  `ap_Id` int(11) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(250) DEFAULT NULL,
  `filename` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ap_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `upload` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

/*Table structure for table `viewfile` */

DROP TABLE IF EXISTS `viewfile`;

CREATE TABLE `viewfile` (
  `T_ViewNo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `T_ViewID` varchar(50) DEFAULT NULL,
  `T_ViewName` varchar(50) DEFAULT NULL,
  `T_ViewEmail` varchar(50) DEFAULT NULL,
  `T_ViewCountry` varchar(50) DEFAULT NULL,
  `T_ViewFileName` varchar(50) DEFAULT NULL,
  `T_ViewFileLoc` varchar(1000) DEFAULT NULL,
  `T_ViewRandomNo` varchar(100) DEFAULT NULL,
  `T_RandomKey` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`T_ViewNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `viewfile` */

insert  into `viewfile`(`T_ViewNo`,`T_ViewID`,`T_ViewName`,`T_ViewEmail`,`T_ViewCountry`,`T_ViewFileName`,`T_ViewFileLoc`,`T_ViewRandomNo`,`T_RandomKey`) values (1,'1','h','h@gmail.com','india','BinaryExample.java','C:uploaduploaded-filesBinaryExample.java','116962','245'),(2,'1','h','h@gmail.com','india','achu.txt','C:uploaduploaded-filesachu.txt','115538','892'),(3,'1','h','h@gmail.com','india','achu.txt','C:uploaduploaded-filesachu.txt','87854','994');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
