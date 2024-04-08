/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.19-log : Database - bookmanagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bookmanagement`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `author` varchar(30) DEFAULT NULL,
  `classify` varchar(30) DEFAULT NULL,
  `descr` varchar(100) DEFAULT NULL,
  `price` double(10,1) DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`author`,`classify`,`descr`,`price`) values ('ST322','三体','刘慈欣','科幻小说','地球人类文明和三体文明的信息交流',39.9),('SGYY123','三国演义','罗贯中','经典文学','四大名著之一',30.0),('SK232','失控','凯文·凯利','社会科学','关于机器、系统、生物和社会的“大部头”',29.8),('GDDRQ253','孤独的人群','大卫·理斯曼','社会科学','讨论美国人社会性格的形成及演变',35.6),('FGL454','富国论','亚当·斯密','经济学','奠定了资本主义自由经济的理论基础',19.9),('XWZ342','小王子','安托万·德·圣-埃克苏佩里','经典文学','法国儿童文学短篇童话',19.9),('XLJ431','小逻辑','格奥尔格·黑格尔','哲学','它代表了形而上学和辩证法发展的高峰',39.9),('PFSJ121','平凡的世界','路遥','经典文学','表现了中国当代城乡社会生活',30.0),('CL454','查理九世','雷欧幻像 ','科幻小说','墨多多的谜境冒险 ',39.9),('MEJX234','梦的解析','西格蒙德·弗洛伊德','心理学','心理学理论著作',36.6),('SHZ432','水浒传','施耐庵','经典文学','四大名著之一',29.9),('HD121','海底两万里','儒勒·凡尔纳','经典文学','讲述鹦鹉螺号潜艇的故事',29.9),('FD323','疯癫与文明','米歇尔·福柯','社会科学','理性时代的疯狂史',25.6),('BLY123','白鹿原','陈忠实','现代文学','讲述白姓和鹿姓两大家族祖孙三代的恩怨纷争',26.6),('BNGD232','百年孤独','加西亚·马尔克斯','经典文学','再现拉丁美洲历史社会图景的鸿篇巨著',25.6),('SHKX342','社会科学','安东尼·吉登斯','社会科学','是吉登斯的社会理论纲领',27.0),('HLM235','红楼梦','曹雪芹','经典文学','四大名著之一',35.0),('CCL124','纯粹理性批判','伊曼努尔·康德','哲学','欧洲哲学史上一部具有转折意义的重要著作',19.8),('JJX121','经济学原理','N.格里高利·曼昆','经济学','介绍了经济学十大原理',16.8),('JJB434','经济表','弗朗斯瓦·魁奈','经济学','对社会资本的再生产和流通过程进行理论研究',29.5),('ZSL239','自杀论','埃米尔·迪尔凯姆','社会科学','批判了以个体心理学解释自杀现象的传统理论',30.4),('SHDSJ234','苏菲的世界','乔斯坦·贾德','哲学','西方哲学史的长篇小说',28.8),('XYJ123','西游记','吴承恩','经典文学','师徒四人取经之路',20.0),('ZBL123','资本论','卡尔·马克思','经济学','对资本主义进行了彻底的批判',19.4),('ZFZ334','追风筝的人','卡勒德·胡赛尼','经典文学','人性的背叛与救赎',29.9),('LBX121','鲁宾逊漂流记','丹尼尔·笛福','经典文学','自身生活荒岛28年',36.5);

/*Table structure for table `book_user` */

DROP TABLE IF EXISTS `book_user`;

CREATE TABLE `book_user` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `author` varchar(30) NOT NULL,
  `classify` varchar(30) NOT NULL,
  `descr` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `number` int(11) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  KEY `username` (`username`) USING BTREE,
  CONSTRAINT `book_user_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Data for the table `book_user` */

insert  into `book_user`(`id`,`name`,`author`,`classify`,`descr`,`price`,`number`,`username`) values ('ST322','三体','刘慈欣','科幻小说','地球人类文明和三体文明的信息交流',39.9,1,'zhangsan'),('SGYY123','三国演义','罗贯中','经典文学','四大名著之一',30,1,'zm'),('SK232','失控','凯文·凯利','社会科学','关于机器、系统、生物和社会的“大部头”',29.8,1,'zm'),('GDDRQ253','孤独的人群','大卫·理斯曼','社会科学','讨论美国人社会性格的形成及演变',35.6,1,'zm'),('XWZ342','小王子','安托万·德·圣-埃克苏佩里','经典文学','法国儿童文学短篇童话',19.9,1,'zm'),('PFSJ121','平凡的世界','路遥','经典文学','表现了中国当代城乡社会生活',30,1,'zm');

/*Table structure for table `controller` */

DROP TABLE IF EXISTS `controller`;

CREATE TABLE `controller` (
  `contname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`contname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Data for the table `controller` */

insert  into `controller`(`contname`,`password`) values ('管理员','zm123456');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`gender`,`email`,`telephone`) values ('zhangsan','123456qwe','男','2533694604@qq.com','13783239983'),('zm','zm123456','女','3339332352@qq.com','16692384383');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
