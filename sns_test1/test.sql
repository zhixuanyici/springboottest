/*
SQLyog Ultimate v8.32 
MySQL - 5.7.21-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生表ID',
  `student_name` varchar(30) DEFAULT NULL COMMENT '学生姓名',
  `student_number` varchar(16) DEFAULT NULL COMMENT '学生学号',
  `class_id` int(10) DEFAULT NULL COMMENT '所属班级编号',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`student_id`,`student_name`,`student_number`,`class_id`) values (1,'张三','00001',1),(2,'玩儿','5',4),(4,'大名','00004',1),(5,'大名1','000041',1),(6,'大名1','000041',1),(7,'大名1','000041',1),(8,'大名1','000041',1),(9,'大名2','000041',1),(10,'大名2','000041',1),(11,'大名2','000041',1),(12,'大名2','000041',1),(13,'大名2','000041',1),(14,'大名2','000041',1),(15,'大名2','000041',1),(16,'0','5554',2),(17,'aaa','5554',2),(18,'aaa','5554',2),(19,'aaa','5554',2),(20,'aaa','5554',2);

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `product_name` varchar(30) DEFAULT NULL COMMENT '产品名称',
  `product_type` int(10) DEFAULT NULL COMMENT '产品类型',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_product` */

insert  into `t_product`(`product_id`,`product_name`,`product_type`,`create_user`) values (1,'chanpin1',1,'zhangsan'),(2,'chanpin2',2,'zhangsan'),(3,'chanpin3',4,'lisi');

/*Table structure for table `test_account` */

DROP TABLE IF EXISTS `test_account`;

CREATE TABLE `test_account` (
  `accout_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `accout_name` varchar(20) DEFAULT NULL,
  `accout_money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`accout_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `test_account` */

insert  into `test_account`(`accout_id`,`accout_name`,`accout_money`) values (1,'wwwww','34.65');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
