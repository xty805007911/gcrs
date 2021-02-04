/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.6.48-log : Database - db_gcrs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_gcrs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_gcrs`;

/*Table structure for table `tb_avatar` */

DROP TABLE IF EXISTS `tb_avatar`;

CREATE TABLE `tb_avatar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `tb_avatar` */

insert  into `tb_avatar`(`id`,`url`,`name`,`create_time`,`enabled`) values 
(1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','动态小人','2020-12-31 15:01:12',1),
(15,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user-1.jpg','用户头像-女','2020-12-31 14:15:07',1),
(16,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user2.jpg','用户头像男','2020-12-31 14:19:31',1),
(17,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user3.jpg','头像男-简笔','2020-12-31 14:21:11',1);

/*Table structure for table `tb_chat` */

DROP TABLE IF EXISTS `tb_chat`;

CREATE TABLE `tb_chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `tb_chat` */

insert  into `tb_chat`(`id`,`from_user_id`,`to_user_id`,`message`,`create_time`) values 
(38,3,1,'111','2021-01-10 11:19:26'),
(39,3,1,'222','2021-01-10 11:19:29'),
(40,1,3,'333','2021-01-10 11:19:32'),
(41,1,3,'','2021-01-14 00:46:48'),
(42,1,3,'','2021-01-14 00:46:53'),
(43,1,4,'','2021-01-14 00:47:37'),
(44,1,4,'22','2021-01-14 00:48:30'),
(45,1,3,'1111','2021-01-14 12:58:18'),
(46,3,1,'1','2021-01-27 12:36:19'),
(47,3,1,'122','2021-01-27 12:36:26');

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL COMMENT '未接单、已接单、已完成、已取消',
  `user_id` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `point_x` float DEFAULT NULL,
  `point_y` float DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `receiver_name` varchar(16) DEFAULT NULL,
  `receiver_mobile` varchar(16) DEFAULT NULL,
  `content` varchar(30) DEFAULT NULL,
  `kg` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

insert  into `tb_order`(`id`,`order_code`,`create_time`,`status`,`user_id`,`address`,`point_x`,`point_y`,`start_time`,`end_time`,`receiver_name`,`receiver_mobile`,`content`,`kg`) values 
(45,'1LUAPLUH','2021-01-03 13:20:13','SUCCESS',3,'北臧村镇中心幼儿园',116.329,39.6871,'2021-01-03 13:20:13','2021-01-03 13:20:02','王','17303652621',NULL,22),
(46,'K9NCGQFN','2021-01-03 14:15:37','SUCCESS',3,'金融街融汇小区22#',116.33,39.681,'2021-01-03 14:15:37','2021-01-03 14:15:16','王','17303652621',NULL,22),
(50,'WCGUT80F','2021-01-04 13:09:07','SUCCESS',3,'jinrongjieronghui',116.33,39.6799,'2021-01-04 13:09:07','2021-01-04 13:09:04','王','17303652621',NULL,20),
(51,'GZFDPDHD','2021-01-04 13:26:39','SUCCESS',4,'新源时代',116.332,39.6945,'2021-01-04 13:26:39','2021-01-04 13:26:37','肖天宇','18910313705',NULL,22),
(52,'FQUAHSRW','2021-01-05 12:35:53','SUCCESS',3,'天宫院小区',116.329,39.6852,'2021-01-05 12:35:53','2021-01-05 12:35:43','','17303652621',NULL,NULL),
(53,'HLFVPF7H','2021-01-05 12:38:57','SUCCESS',4,'bast',116.285,39.6778,'2021-01-05 12:38:57','2021-01-05 12:38:54','肖天宇','18910313705',NULL,20),
(54,'BNB8XESM','2021-01-05 12:56:24','SUCCESS',3,'龙湖时代天街',116.331,39.6934,'2021-01-05 12:56:24','2021-01-05 12:56:16','王','17303652621',NULL,2),
(55,'OMMJLXZ8','2021-01-09 08:22:30','SUCCESS',4,'清源公园',116.321,39.7462,'2021-01-09 08:22:30','2021-01-09 08:22:27','xty','18910313705',NULL,2),
(56,'5MDQKCNZ','2021-01-09 08:39:09','SUCCESS',4,'北京市动物园',116.344,39.9434,'2021-01-09 08:39:09','2021-01-09 08:39:06','xty','18910313705',NULL,22),
(57,'SEROZP9S','2021-01-09 08:48:09','SUCCESS',4,'金融街融汇小区22#',116.329,39.6807,'2021-01-09 08:48:09','2021-01-09 08:48:06','xty','18910313705',NULL,22),
(58,'PMCZWH35','2021-01-09 08:54:26','SUCCESS',4,'北京南站',116.386,39.8695,'2021-01-09 08:54:26','2021-01-09 08:54:21','xty','18910313705',NULL,20),
(59,'2PYGWMCN','2021-01-09 09:08:01','SUCCESS',4,'心愿时代小区',116.333,39.6942,'2021-01-09 09:08:01','2021-01-09 09:07:53','xty','18910313705',NULL,20),
(60,'WOGRHNCN','2021-01-10 11:14:20','SENDING',3,'xniyuanxinduhui',116.327,39.6949,'2021-01-10 11:14:20','2021-01-10 11:14:15','wang','17303652621',NULL,20),
(61,'OI011JL4','2021-01-10 11:42:25','NOT_SEND',1,'北京市大兴区兴旺大街 黄村',116.34,39.7226,'2021-01-10 11:42:25','2021-01-10 11:42:22','xty','17303652621',NULL,1),
(62,'H6D0KAZ5','2021-01-15 05:21:28','NOT_SEND',4,'浙江水利水电学院',120.381,30.3214,'2021-01-15 05:21:28','2021-01-16 09:00:00','','13735826385',NULL,10);

/*Table structure for table `tb_order_rating` */

DROP TABLE IF EXISTS `tb_order_rating`;

CREATE TABLE `tb_order_rating` (
  `id` int(11) NOT NULL,
  `ratings` int(11) DEFAULT NULL COMMENT '评分',
  `content` varchar(1024) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `send_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_order_rating` */

/*Table structure for table `tb_order_send` */

DROP TABLE IF EXISTS `tb_order_send`;

CREATE TABLE `tb_order_send` (
  `id` int(11) NOT NULL COMMENT '和orderid一致',
  `send_id` int(11) DEFAULT NULL,
  `send_realname` varchar(16) DEFAULT NULL,
  `point_x` float DEFAULT NULL,
  `point_y` float DEFAULT NULL,
  `send_start_time` datetime DEFAULT NULL,
  `send_end_time` datetime DEFAULT NULL,
  `send_address` varchar(100) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_order_send` */

insert  into `tb_order_send`(`id`,`send_id`,`send_realname`,`point_x`,`point_y`,`send_start_time`,`send_end_time`,`send_address`,`status`) values 
(45,1,'肖天宇(接单)',116.33,39.68,'2021-01-03 13:23:45',NULL,NULL,'SUCCESS'),
(46,1,'肖天宇(接单)',116.33,39.6795,'2021-01-03 14:39:11',NULL,NULL,'SUCCESS'),
(50,1,'肖天宇(接单)',116.33,39.6792,'2021-01-04 13:20:38',NULL,NULL,'SUCCESS'),
(51,1,'肖天宇(接单)',116.33,39.6799,'2021-01-04 13:27:09',NULL,NULL,'SUCCESS'),
(52,1,'肖天宇(接单)',116.33,39.6795,'2021-01-05 12:45:34',NULL,NULL,'SUCCESS'),
(53,1,'肖天宇(接单)',116.33,39.6796,'2021-01-05 13:01:32',NULL,NULL,'SUCCESS'),
(54,1,'肖天宇(接单)',116.329,39.6793,'2021-01-09 08:25:35',NULL,NULL,'SUCCESS'),
(55,1,'肖天宇(接单)',116.33,39.679,'2021-01-09 08:23:18',NULL,NULL,'SUCCESS'),
(56,1,'肖天宇(接单)',116.329,39.6802,'2021-01-09 08:39:45',NULL,NULL,'SUCCESS'),
(57,1,'肖天宇(接单)',116.33,39.6795,'2021-01-09 08:49:50',NULL,NULL,'SUCCESS'),
(58,1,'肖天宇(接单)',116.33,39.6801,'2021-01-09 08:54:55',NULL,NULL,'SUCCESS'),
(59,1,'肖天宇(接单)',116.329,39.6793,'2021-01-09 09:09:06',NULL,NULL,'SUCCESS'),
(60,1,'肖天宇(接单)',116.33,39.6798,'2021-01-10 11:17:15',NULL,NULL,'NOT_SEND');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `code` varchar(16) DEFAULT NULL,
  `enabled` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`name`,`code`,`enabled`) values 
(1,'用户','roleuser','1'),
(2,'接单员','rolesend','1'),
(3,'管理员','roleadmin','1');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `realname` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`username`,`password`,`mobile`,`address`,`create_time`,`enabled`,`avatar`,`role_id`,`realname`) values 
(1,'肖天宇（接单）','1','13141309261','111','2020-12-26 14:09:11',1,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user3.jpg',2,'陈榆1'),
(2,'admin','1','admin','北京林业大学',NULL,1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',3,'管理员'),
(3,'王ML（客户）','1','17303652621','','2020-12-31 14:22:03',1,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user-1.jpg',1,'王ML(客户)'),
(4,'肖天宇(客户)','1','18910313705','西城区','2021-01-01 01:12:52',1,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user3.jpg',1,'陈榆(客户)'),
(5,'','1','send','',NULL,1,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',2,'接单chat-test'),
(6,NULL,'1','user','',NULL,1,'https://chart7appyyrzbzpa.ingress.ctbiyi.com/gcrs/user3.jpg',1,'用户chat-test');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
