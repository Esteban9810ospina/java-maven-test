/*
SQLyog Community v8.71 
MySQL - 5.5.45 : Database - migracion
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`migracion` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `migracion`;

/*Table structure for table `fqs_IpAutorizada` */

DROP TABLE IF EXISTS `fqs_IpAutorizada`;

CREATE TABLE `fqs_IpAutorizada` (
  `id_ip` int(11) NOT NULL AUTO_INCREMENT,
  `ip_usuario` int(11) DEFAULT NULL,
  `ip` varchar(20) NOT NULL,
  PRIMARY KEY (`id_ip`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `fqs_IpAutorizada` */

insert  into `fqs_IpAutorizada`(`id_ip`,`ip_usuario`,`ip`) values (1,1,'172.16.1.219');
insert  into `fqs_IpAutorizada`(`id_ip`,`ip_usuario`,`ip`) values (2,2,'172.16.1.244');

/*Table structure for table `fqs_accionbd` */

DROP TABLE IF EXISTS `fqs_accionbd`;

CREATE TABLE `fqs_accionbd` (
  `i_accionbd` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(20) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  `i_contador` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`i_accionbd`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_accionbd` */

insert  into `fqs_accionbd`(`i_accionbd`,`c_nombre`,`c_descripcion`,`i_contador`) values (1,'CONSULTA','CONSULTA',1);
insert  into `fqs_accionbd`(`i_accionbd`,`c_nombre`,`c_descripcion`,`i_contador`) values (2,'ADICION','ADICION',1);
insert  into `fqs_accionbd`(`i_accionbd`,`c_nombre`,`c_descripcion`,`i_contador`) values (3,'MODIFICACION','MODIFICACION',1);
insert  into `fqs_accionbd`(`i_accionbd`,`c_nombre`,`c_descripcion`,`i_contador`) values (4,'BORRADO','BORRADO',1);
insert  into `fqs_accionbd`(`i_accionbd`,`c_nombre`,`c_descripcion`,`i_contador`) values (5,'ADMINISTRACION','ADMINISTRACION',1);
insert  into `fqs_accionbd`(`i_accionbd`,`c_nombre`,`c_descripcion`,`i_contador`) values (6,'REPORTE','REPORTE',1);

/*Table structure for table `fqs_auditoria` */

DROP TABLE IF EXISTS `fqs_auditoria`;

CREATE TABLE `fqs_auditoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_fecha` datetime NOT NULL,
  `i_idusuario` int(11) DEFAULT NULL,
  `c_ip` varchar(20) DEFAULT NULL,
  `c_evento` varchar(1001) DEFAULT NULL,
  `c_resultado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`t_fecha`),
  KEY `fk_auditoria_usuario` (`i_idusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=3566 DEFAULT CHARSET=latin1;

/*Data for the table `fqs_auditoria` */

insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3565,'2015-10-30 15:42:44',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3564,'2015-10-30 15:42:12',1,'172.16.1.219','Inicio de sesión','Usuario Suspendido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3150,'2015-10-14 15:24:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3151,'2015-10-14 15:28:00',NULL,'127.0.0.1','Inicio de sesión','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3152,'2015-10-14 15:31:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3153,'2015-10-14 15:36:02',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3154,'2015-10-14 15:38:53',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3155,'2015-10-14 15:55:48',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3156,'2015-10-14 16:00:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3157,'2015-10-14 16:03:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3158,'2015-10-14 16:23:46',NULL,'127.0.0.1','Inicio de sesión','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3159,'2015-10-14 16:30:38',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3160,'2015-10-14 16:42:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3161,'2015-10-14 16:46:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3162,'2015-10-14 16:48:38',1,'172.16.1.108','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3163,'2015-10-14 16:49:19',1,'172.16.1.108','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3164,'2015-10-14 17:02:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3165,'2015-10-14 17:15:12',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3166,'2015-10-14 17:19:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3167,'2015-10-14 17:32:44',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3168,'2015-10-14 17:36:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3169,'2015-10-14 17:37:07',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3170,'2015-10-14 17:37:51',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3171,'2015-10-14 17:40:09',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3172,'2015-10-14 17:40:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3173,'2015-10-14 17:46:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3174,'2015-10-14 17:47:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3175,'2015-10-14 18:01:26',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3176,'2015-10-14 18:14:17',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3177,'2015-10-14 18:16:01',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3178,'2015-10-14 18:33:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3179,'2015-10-14 18:38:29',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3180,'2015-10-14 18:51:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3181,'2015-10-15 09:19:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3182,'2015-10-15 09:21:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3183,'2015-10-15 09:21:15',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3184,'2015-10-15 09:27:24',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3185,'2015-10-15 09:28:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3186,'2015-10-15 09:35:27',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3187,'2015-10-15 09:42:10',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3188,'2015-10-15 09:42:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3189,'2015-10-15 09:44:40',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3190,'2015-10-15 09:46:41',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3191,'2015-10-15 09:48:16',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3192,'2015-10-15 09:49:45',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3193,'2015-10-15 09:52:18',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3194,'2015-10-15 10:07:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3195,'2015-10-15 10:10:35',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3196,'2015-10-15 10:11:48',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3197,'2015-10-15 10:14:59',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3198,'2015-10-15 10:15:57',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3199,'2015-10-15 10:16:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3200,'2015-10-15 10:48:13',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3201,'2015-10-15 10:52:36',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3202,'2015-10-15 10:53:32',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3203,'2015-10-15 10:54:13',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3204,'2015-10-15 10:54:33',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3205,'2015-10-15 10:57:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3206,'2015-10-15 10:58:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3207,'2015-10-15 10:59:18',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3208,'2015-10-15 11:03:13',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3209,'2015-10-15 11:04:14',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3210,'2015-10-15 11:04:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3211,'2015-10-15 11:04:44',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3212,'2015-10-15 11:05:33',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3213,'2015-10-15 11:05:35',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3214,'2015-10-15 11:05:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3215,'2015-10-15 11:39:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3216,'2015-10-15 11:52:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3217,'2015-10-15 11:59:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3218,'2015-10-15 12:12:13',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3219,'2015-10-15 12:13:17',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3220,'2015-10-15 12:16:18',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3221,'2015-10-15 12:20:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3222,'2015-10-15 12:21:24',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3223,'2015-10-15 12:21:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3224,'2015-10-15 12:23:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3225,'2015-10-15 12:25:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3226,'2015-10-15 12:31:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3227,'2015-10-15 12:34:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3228,'2015-10-15 12:35:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3229,'2015-10-15 12:37:15',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3230,'2015-10-15 12:38:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3231,'2015-10-15 12:40:55',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3232,'2015-10-15 12:43:29',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3233,'2015-10-15 12:45:33',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3234,'2015-10-15 12:52:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3235,'2015-10-15 12:54:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3236,'2015-10-15 15:19:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3237,'2015-10-15 15:22:30',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3238,'2015-10-15 16:08:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3239,'2015-10-15 16:10:14',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3240,'2015-10-15 16:15:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3241,'2015-10-15 16:46:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3242,'2015-10-15 16:49:20',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3243,'2015-10-15 17:08:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3244,'2015-10-15 17:11:10',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3245,'2015-10-15 17:12:48',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3246,'2015-10-15 17:14:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3247,'2015-10-15 17:15:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3248,'2015-10-15 17:34:35',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3249,'2015-10-15 17:57:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3250,'2015-10-15 18:24:41',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3251,'2015-10-15 18:25:31',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3252,'2015-10-15 18:27:45',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3253,'2015-10-15 18:28:30',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3254,'2015-10-15 18:32:12',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3255,'2015-10-15 18:33:31',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3256,'2015-10-15 18:35:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3257,'2015-10-15 18:37:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3258,'2015-10-15 18:37:46',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3259,'2015-10-15 18:42:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3260,'2015-10-15 18:45:36',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3261,'2015-10-15 18:46:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3262,'2015-10-15 18:47:28',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3263,'2015-10-15 18:49:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3264,'2015-10-15 18:50:20',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3265,'2015-10-15 18:50:45',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3266,'2015-10-16 09:56:00',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3267,'2015-10-16 10:57:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3268,'2015-10-16 10:57:41',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3269,'2015-10-16 11:01:35',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3270,'2015-10-16 11:15:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3271,'2015-10-16 11:17:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3272,'2015-10-16 11:40:30',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3273,'2015-10-16 11:44:08',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3274,'2015-10-16 11:50:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3275,'2015-10-16 11:53:15',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3276,'2015-10-16 11:59:36',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3277,'2015-10-16 12:56:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3278,'2015-10-16 13:04:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3279,'2015-10-16 14:24:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3280,'2015-10-16 14:49:30',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3281,'2015-10-16 15:22:41',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3282,'2015-10-16 15:24:00',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3283,'2015-10-16 15:26:24',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3284,'2015-10-16 15:28:02',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3285,'2015-10-16 15:37:02',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3286,'2015-10-16 15:37:20',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3287,'2015-10-16 15:39:53',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3288,'2015-10-16 15:56:45',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3289,'2015-10-16 15:58:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3290,'2015-10-16 15:59:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3291,'2015-10-16 16:02:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3292,'2015-10-16 16:25:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3293,'2015-10-16 16:28:51',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3294,'2015-10-16 17:55:15',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3295,'2015-10-16 18:02:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3296,'2015-10-19 08:30:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3297,'2015-10-19 08:33:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3298,'2015-10-19 08:40:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3299,'2015-10-19 08:48:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3300,'2015-10-19 08:48:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3301,'2015-10-19 09:08:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3302,'2015-10-19 09:12:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3303,'2015-10-19 09:18:02',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3304,'2015-10-19 09:20:57',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3305,'2015-10-19 09:21:31',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3306,'2015-10-19 09:26:09',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3307,'2015-10-19 09:28:01',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3308,'2015-10-19 09:29:40',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3309,'2015-10-19 09:36:14',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3310,'2015-10-19 09:42:31',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3311,'2015-10-19 09:42:38',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3312,'2015-10-19 09:43:04',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3313,'2015-10-19 09:45:17',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3314,'2015-10-19 09:45:46',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3315,'2015-10-19 09:46:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3316,'2015-10-19 09:47:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3317,'2015-10-19 09:49:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3318,'2015-10-19 09:49:41',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3319,'2015-10-19 09:51:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3320,'2015-10-19 09:52:26',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3321,'2015-10-19 10:00:40',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3322,'2015-10-19 10:01:27',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3323,'2015-10-19 10:02:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3324,'2015-10-19 10:06:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3325,'2015-10-19 10:09:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3326,'2015-10-19 10:11:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3327,'2015-10-19 10:11:28',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3328,'2015-10-19 10:30:09',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3329,'2015-10-19 10:31:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3330,'2015-10-19 10:32:27',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3331,'2015-10-19 10:32:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3332,'2015-10-19 10:35:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3333,'2015-10-19 10:35:57',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3334,'2015-10-19 10:37:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3335,'2015-10-19 10:40:16',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3336,'2015-10-19 10:43:08',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3337,'2015-10-19 10:46:08',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3338,'2015-10-19 10:47:55',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3339,'2015-10-19 10:48:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3340,'2015-10-19 10:49:16',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3341,'2015-10-19 10:49:37',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3342,'2015-10-19 10:50:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3343,'2015-10-19 11:11:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3344,'2015-10-19 11:12:40',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3345,'2015-10-19 11:14:57',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3346,'2015-10-19 11:19:27',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3347,'2015-10-19 11:19:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3348,'2015-10-19 11:20:48',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3349,'2015-10-19 11:21:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3350,'2015-10-19 11:23:35',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3351,'2015-10-19 11:24:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3352,'2015-10-19 11:25:13',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3353,'2015-10-19 11:28:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3354,'2015-10-19 11:29:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3355,'2015-10-19 11:33:09',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3356,'2015-10-19 11:46:44',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3357,'2015-10-19 11:48:08',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3358,'2015-10-19 11:49:48',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3359,'2015-10-19 11:49:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3360,'2015-10-19 11:50:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3361,'2015-10-19 11:53:46',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3362,'2015-10-19 11:58:40',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3363,'2015-10-19 12:02:45',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3364,'2015-10-19 12:05:01',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3365,'2015-10-19 12:06:02',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3366,'2015-10-19 12:13:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3367,'2015-10-19 12:17:55',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3368,'2015-10-19 12:18:36',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3369,'2015-10-19 12:20:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3370,'2015-10-19 12:22:39',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3371,'2015-10-19 12:25:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3372,'2015-10-19 12:27:31',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3373,'2015-10-19 12:29:04',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3374,'2015-10-19 12:31:29',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3375,'2015-10-19 12:33:33',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3376,'2015-10-19 12:37:27',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3377,'2015-10-19 12:37:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3378,'2015-10-19 12:38:58',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3379,'2015-10-19 12:40:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3380,'2015-10-19 12:43:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3381,'2015-10-19 14:17:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3382,'2015-10-19 14:17:59',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3383,'2015-10-19 14:21:16',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3384,'2015-10-19 14:25:14',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3385,'2015-10-19 14:28:57',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3386,'2015-10-19 14:29:39',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3387,'2015-10-19 14:33:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3388,'2015-10-19 14:36:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3389,'2015-10-19 14:38:57',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3390,'2015-10-19 14:44:53',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3391,'2015-10-19 14:50:17',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3392,'2015-10-19 14:54:31',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3393,'2015-10-19 15:04:08',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3394,'2015-10-19 15:07:11',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3395,'2015-10-19 15:13:27',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3396,'2015-10-19 15:22:17',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3397,'2015-10-19 15:22:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3398,'2015-10-19 15:26:19',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3399,'2015-10-19 15:29:06',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3400,'2015-10-19 15:50:19',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3401,'2015-10-19 15:50:35',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3402,'2015-10-19 15:51:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3403,'2015-10-19 15:52:26',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3404,'2015-10-19 16:02:26',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3405,'2015-10-19 16:06:38',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3406,'2015-10-19 16:07:16',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3407,'2015-10-19 16:08:10',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3408,'2015-10-19 16:10:07',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3409,'2015-10-19 16:32:07',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3410,'2015-10-19 16:33:14',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3411,'2015-10-19 16:35:46',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3412,'2015-10-19 16:40:04',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3413,'2015-10-19 16:41:22',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3414,'2015-10-19 16:42:32',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3415,'2015-10-19 16:42:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3416,'2015-10-19 16:50:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3417,'2015-10-19 16:56:48',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3418,'2015-10-19 17:07:31',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3419,'2015-10-19 17:10:41',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3420,'2015-10-19 17:15:11',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3421,'2015-10-19 17:15:17',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3422,'2015-10-19 17:18:12',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3423,'2015-10-19 17:18:33',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3424,'2015-10-19 17:32:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3425,'2015-10-19 17:34:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3426,'2015-10-19 17:39:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3427,'2015-10-19 17:40:21',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3428,'2015-10-19 18:08:10',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3429,'2015-10-19 18:33:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3430,'2015-10-19 18:35:51',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3431,'2015-10-19 18:39:45',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3432,'2015-10-20 09:10:14',1,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3433,'2015-10-20 09:11:01',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3434,'2015-10-20 12:58:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3435,'2015-10-20 12:59:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3436,'2015-10-20 13:58:11',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3437,'2015-10-20 14:17:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3438,'2015-10-20 15:25:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3439,'2015-10-20 17:39:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3440,'2015-10-20 18:16:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3441,'2015-10-20 18:21:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3442,'2015-10-20 18:28:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3443,'2015-10-21 08:58:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3444,'2015-10-21 09:30:15',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3445,'2015-10-21 09:38:23',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3446,'2015-10-21 09:44:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3447,'2015-10-21 10:12:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3448,'2015-10-21 10:39:03',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3449,'2015-10-21 10:45:50',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3450,'2015-10-21 10:53:24',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3451,'2015-10-21 11:04:51',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3452,'2015-10-21 11:10:40',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3453,'2015-10-21 11:17:34',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3454,'2015-10-21 12:13:38',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3455,'2015-10-21 12:14:18',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3456,'2015-10-22 12:26:08',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3457,'2015-10-22 12:45:07',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3458,'2015-10-22 12:55:28',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3459,'2015-10-22 13:04:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3460,'2015-10-27 09:31:24',2,'172.16.1.244','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3461,'2015-10-27 09:35:21',2,'172.16.1.244','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3462,'2015-10-27 09:36:22',2,'172.16.1.244','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3463,'2015-10-27 09:39:39',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3464,'2015-10-27 09:46:55',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3465,'2015-10-27 09:49:56',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3466,'2015-10-27 09:50:02',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3467,'2015-10-27 09:50:08',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3468,'2015-10-27 09:50:08',2,'172.16.1.244','Usuario bloqueado por intentos fallidos de acceso al sistema','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3469,'2015-10-27 09:53:29',2,'172.16.1.244','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3470,'2015-10-27 09:59:06',2,'172.16.1.244','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3471,'2015-10-27 09:59:51',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3472,'2015-10-27 09:59:59',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3473,'2015-10-27 10:00:12',2,'172.16.1.244','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3474,'2015-10-27 10:11:44',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3475,'2015-10-27 10:11:48',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3476,'2015-10-27 10:11:51',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3477,'2015-10-27 10:11:51',2,'172.16.1.244','Usuario bloqueado por intentos fallidos de acceso al sistema','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3478,'2015-10-27 10:12:35',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3479,'2015-10-27 10:12:39',2,'172.16.1.244','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3480,'2015-10-27 14:27:26',1,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3481,'2015-10-27 14:27:36',1,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3482,'2015-10-27 15:17:12',1,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3483,'2015-10-27 15:17:49',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3484,'2015-10-27 16:37:40',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3485,'2015-10-27 16:38:39',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3486,'2015-10-27 16:48:09',1,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3487,'2015-10-27 16:48:22',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3488,'2015-10-27 17:02:50',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3489,'2015-10-27 17:04:06',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3490,'2015-10-27 17:06:11',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3491,'2015-10-27 17:10:37',NULL,'172.16.1.219','Inicio de sesión','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3492,'2015-10-27 17:11:30',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3493,'2015-10-27 17:15:02',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3494,'2015-10-27 17:17:57',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3495,'2015-10-27 17:18:02',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3496,'2015-10-27 17:18:04',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3497,'2015-10-27 17:19:17',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3498,'2015-10-27 17:20:04',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3499,'2015-10-27 17:20:04',2,'172.16.1.219','Usuario bloqueado por intentos fallidos de acceso al sistema','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3500,'2015-10-27 17:25:06',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3501,'2015-10-27 17:25:25',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3502,'2015-10-27 17:25:47',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3503,'2015-10-27 17:26:05',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3504,'2015-10-27 17:26:44',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3505,'2015-10-27 17:26:59',2,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3506,'2015-10-27 17:26:59',2,'172.16.1.219','Usuario bloqueado por intentos fallidos de acceso al sistema','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3507,'2015-10-27 17:31:19',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3508,'2015-10-27 17:39:36',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3509,'2015-10-27 17:43:45',2,'172.16.1.219','Inicio de sesión','Usuario Bloqueado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3510,'2015-10-27 17:43:59',2,'172.16.1.219','Inicio de sesión','Usuario Bloqueado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3511,'2015-10-27 17:45:31',2,'172.16.1.219','Inicio de sesión','Usuario Desactivado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3512,'2015-10-27 17:45:59',2,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3513,'2015-10-28 09:17:00',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3514,'2015-10-28 14:36:07',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3515,'2015-10-28 14:38:18',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3516,'2015-10-28 14:42:34',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3517,'2015-10-28 14:50:38',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3518,'2015-10-28 14:58:53',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3519,'2015-10-28 15:03:44',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3520,'2015-10-28 15:08:36',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3521,'2015-10-28 15:13:51',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3522,'2015-10-28 15:22:29',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3523,'2015-10-28 15:43:43',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3524,'2015-10-28 16:01:36',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3525,'2015-10-28 17:26:18',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3526,'2015-10-28 17:35:05',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3527,'2015-10-28 17:57:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3528,'2015-10-29 08:26:56',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3529,'2015-10-29 09:59:31',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3530,'2015-10-29 10:08:35',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3531,'2015-10-29 10:08:57',1,'172.16.1.219','Inicio de sesión','Usuario Bloqueado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3532,'2015-10-29 10:46:32',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3533,'2015-10-29 12:02:47',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3534,'2015-10-29 12:03:30',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3535,'2015-10-29 12:11:49',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3536,'2015-10-29 12:12:10',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3537,'2015-10-29 12:12:42',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3538,'2015-10-29 12:25:17',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3539,'2015-10-29 12:27:34',1,'127.0.0.1','Inicio de sesión','Usuario Suspendido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3540,'2015-10-29 12:28:03',1,'127.0.0.1','Inicio de sesión','Usuario Suspendido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3541,'2015-10-29 12:28:16',1,'127.0.0.1','Inicio de sesión','Usuario Eliminado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3542,'2015-10-29 12:33:00',1,'127.0.0.1','Inicio de sesión','Usuario Suspendido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3543,'2015-10-29 12:45:26',1,'127.0.0.1','Inicio de sesión','Usuario Suspendido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3544,'2015-10-29 12:45:52',1,'127.0.0.1','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3545,'2015-10-29 15:04:26',NULL,'172.16.1.219','Inicio de sesión','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3546,'2015-10-29 15:04:50',1,'172.16.1.219','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3547,'2015-10-29 15:05:24',1,'172.16.1.219','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3548,'2015-10-29 15:18:45',NULL,'127.0.0.1','Inicio de sesión','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3549,'2015-10-29 15:21:27',NULL,'127.0.0.1','Inicio de sesión','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3550,'2015-10-29 18:22:44',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3551,'2015-10-29 18:22:57',1,'127.0.0.1','Usuario bloqueado por intentos fallidos de acceso al sistema','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3552,'2015-10-29 18:23:28',1,'127.0.0.1','Inicio de sesión','Usuario Bloqueado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3553,'2015-10-29 18:24:08',1,'127.0.0.1','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3554,'2015-10-29 18:24:32',NULL,'127.0.0.1','Intento fallido de acceso al sistema','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3555,'2015-10-30 10:08:14',1,'172.16.1.219','Inicio de sesión','Usuario Suspendido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3556,'2015-10-30 10:09:41',2,'172.16.1.178','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3557,'2015-10-30 10:12:33',2,'172.16.1.178','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3558,'2015-10-30 10:12:33',NULL,'172.16.1.178','Intento fallido de acceso al sistema','Captcha inválido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3559,'2015-10-30 10:12:57',2,'172.16.1.178','Intento fallido de acceso al sistema','Fallido');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3560,'2015-10-30 10:12:57',2,'172.16.1.178','Usuario bloqueado por intentos fallidos de acceso al sistema','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3561,'2015-10-30 10:13:20',2,'172.16.1.178','Inicio de sesión','Usuario Bloqueado');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3562,'2015-10-30 10:14:22',2,'172.16.1.178','Inicio de sesión','Exitoso');
insert  into `fqs_auditoria`(`id`,`t_fecha`,`i_idusuario`,`c_ip`,`c_evento`,`c_resultado`) values (3563,'2015-10-30 10:26:37',2,'172.16.1.178','Inicio de sesión','Exitoso');

/*Table structure for table `fqs_festivo` */

DROP TABLE IF EXISTS `fqs_festivo`;

CREATE TABLE `fqs_festivo` (
  `d_fecha` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`d_fecha`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_festivo` */

insert  into `fqs_festivo`(`d_fecha`) values ('1990-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-05-21');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-09-11');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-09-18');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-09-19');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-11-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1991-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-02-28');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-02-29');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-04-17');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-04-18');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-05-21');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-09-11');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-09-18');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-09-19');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-10-12');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1992-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-04-09');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-04-10');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-05-21');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-06-10');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-06-29');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-09-11');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-09-18');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-09-19');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-10-12');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-11-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1993-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-01-10');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-03-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-04-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-05-16');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-06-06');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-06-13');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-07-04');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-08-15');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-10-17');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-11-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-11-14');
insert  into `fqs_festivo`(`d_fecha`) values ('1994-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-01-09');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-03-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-04-13');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-04-14');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-05-29');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-06-19');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-06-26');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-07-03');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-08-21');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-10-16');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-11-06');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-11-13');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1995-12-29');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-01-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-03-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-04-04');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-04-05');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-05-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-06-10');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-06-17');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-07-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-08-19');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-10-14');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-11-04');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-11-11');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-12-24');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1996-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-01-06');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-03-24');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-03-27');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-03-28');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-05-12');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-06-02');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-06-09');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-06-30');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-08-18');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-10-13');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-11-03');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-11-17');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-12-24');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1997-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-01-12');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-03-23');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-04-09');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-04-10');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-05-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-06-15');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-06-22');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-06-29');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-08-17');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-10-12');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-11-02');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-11-16');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-12-24');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1998-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-01-11');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-03-22');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-04-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-04-02');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-05-17');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-06-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-06-14');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-07-05');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-08-16');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-10-18');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-11-01');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-11-15');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-12-24');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-12-29');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-12-30');
insert  into `fqs_festivo`(`d_fecha`) values ('1999-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-01-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-01-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-03-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-04-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-04-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-06-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-06-26');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-07-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-08-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-10-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-11-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-11-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2000-12-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-01-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-03-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-04-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-04-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-05-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-05-28');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-06-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-06-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-07-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-08-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-10-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-11-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-11-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2001-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-01-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-03-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-03-28');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-03-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-05-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-06-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-06-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-07-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-08-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-10-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-11-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-11-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2002-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-01-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-03-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-04-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-04-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-06-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-06-23');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-06-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-08-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-10-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-11-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-11-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2003-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-01-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-03-22');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-04-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-04-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-05-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-06-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-06-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-07-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-08-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-10-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-11-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-11-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2004-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-01-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-03-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-03-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-03-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-05-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-05-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-06-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-07-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-08-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-10-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-11-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-11-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2005-12-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-01-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-03-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-04-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-04-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-05-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-06-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-06-26');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-07-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-08-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-10-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-11-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-11-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2006-12-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-01-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-03-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-04-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-04-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-05-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-06-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-06-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-07-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-08-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-10-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-11-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-11-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2007-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-01-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-03-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-03-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-03-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-05-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-05-26');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-06-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-06-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-08-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-10-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-11-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-11-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2008-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-01-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-03-23');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-04-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-04-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-05-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-06-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-06-22');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-06-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-08-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-10-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-11-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-11-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2009-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-01-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-01-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-01-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-03-22');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-04-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-04-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-04-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-05-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-06-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-06-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-07-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-08-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-10-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-11-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-11-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2010-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-01-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-03-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-04-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-04-22');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-06-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-06-27');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-07-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-08-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-10-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-11-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-11-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2011-12-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-01-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-03-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-04-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-04-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-05-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-06-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-06-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-07-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-08-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-10-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-11-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-11-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2012-12-31');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-01-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-03-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-03-28');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-03-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-05-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-06-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-06-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-07-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-08-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-10-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-11-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-11-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2013-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-01-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-03-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-04-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-04-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-06-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-06-23');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-06-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-08-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-10-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-11-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-11-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2014-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-01-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-03-23');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-04-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-04-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-05-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-06-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-06-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-06-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-08-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-10-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-11-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-11-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2015-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-01-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-03-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-03-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-03-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-05-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-05-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-06-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-07-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-08-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-10-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-11-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-11-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2016-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-01-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-03-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-04-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-04-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-05-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-06-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-06-26');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-07-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-08-21');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-11-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-11-13');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2017-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-01-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-03-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-03-30');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-05-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-06-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-06-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-07-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-08-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-10-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-11-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-11-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2018-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-01-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-03-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-04-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-04-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-06-03');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-06-24');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-07-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-08-19');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-10-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-11-04');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-11-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2019-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-01-06');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-03-23');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-04-09');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-04-10');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-05-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-06-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-06-22');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-06-29');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-08-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-10-12');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-11-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-11-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2020-12-25');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-01-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-01-11');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-03-22');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-04-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-04-02');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-05-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-05-17');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-06-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-06-14');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-07-05');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-07-20');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-08-07');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-08-16');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-10-18');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-11-01');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-11-15');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-12-08');
insert  into `fqs_festivo`(`d_fecha`) values ('2021-12-25');

/*Table structure for table `fqs_logusuariosadmin` */

DROP TABLE IF EXISTS `fqs_logusuariosadmin`;

CREATE TABLE `fqs_logusuariosadmin` (
  `c_usuario` varchar(30) NOT NULL DEFAULT '',
  `dt_horaingreso` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `c_paginaingreso` varchar(30) NOT NULL DEFAULT '',
  `c_ipingresa` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_logusuariosadmin` */

/*Table structure for table `fqs_modsistema` */

DROP TABLE IF EXISTS `fqs_modsistema`;

CREATE TABLE `fqs_modsistema` (
  `i_modulosistema` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(30) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`i_modulosistema`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_modsistema` */

insert  into `fqs_modsistema`(`i_modulosistema`,`c_nombre`,`c_descripcion`) values (0,'SPIVI','Sistema de Valoración');
insert  into `fqs_modsistema`(`i_modulosistema`,`c_nombre`,`c_descripcion`) values (2,'modulo - digitador','.....');
insert  into `fqs_modsistema`(`i_modulosistema`,`c_nombre`,`c_descripcion`) values (10,'modulo operador','modulo');

/*Table structure for table `fqs_opcionmodulo` */

DROP TABLE IF EXISTS `fqs_opcionmodulo`;

CREATE TABLE `fqs_opcionmodulo` (
  `i_opcionmodulo` int(11) NOT NULL DEFAULT '0',
  `i_modulosistema` int(11) NOT NULL,
  `i_codigopagina` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(30) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  `i_estado` int(11) NOT NULL DEFAULT '0',
  `i_orden` int(11) NOT NULL DEFAULT '0',
  `i_opciondepende` int(11) DEFAULT NULL,
  PRIMARY KEY (`i_opcionmodulo`),
  KEY `FK_pagina` (`i_codigopagina`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `fqs_opcionmodulo` */

insert  into `fqs_opcionmodulo`(`i_opcionmodulo`,`i_modulosistema`,`i_codigopagina`,`c_nombre`,`c_descripcion`,`i_estado`,`i_orden`,`i_opciondepende`) values (1,0,0,'Demandas','--',1,1,NULL);
insert  into `fqs_opcionmodulo`(`i_opcionmodulo`,`i_modulosistema`,`i_codigopagina`,`c_nombre`,`c_descripcion`,`i_estado`,`i_orden`,`i_opciondepende`) values (2,0,0,'Ingreso de demandas','--',1,2,1);
insert  into `fqs_opcionmodulo`(`i_opcionmodulo`,`i_modulosistema`,`i_codigopagina`,`c_nombre`,`c_descripcion`,`i_estado`,`i_orden`,`i_opciondepende`) values (3,0,0,'Carga masiva de formularios',NULL,0,0,1);

/*Table structure for table `fqs_pagina` */

DROP TABLE IF EXISTS `fqs_pagina`;

CREATE TABLE `fqs_pagina` (
  `i_codigopagina` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(100) DEFAULT NULL,
  `c_descripcion` varchar(100) DEFAULT NULL,
  `c_subtitulo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`i_codigopagina`),
  KEY `idx_fqs_pagina1` (`c_nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_pagina` */

insert  into `fqs_pagina`(`i_codigopagina`,`c_nombre`,`c_descripcion`,`c_subtitulo`) values (0,'com.framework.common.ui.content.BienvenidaContent','Inicio1','-');

/*Table structure for table `fqs_parametro` */

DROP TABLE IF EXISTS `fqs_parametro`;

CREATE TABLE `fqs_parametro` (
  `i_parametro` int(10) NOT NULL DEFAULT '0',
  `i_tipodato` tinyint(4) NOT NULL DEFAULT '0',
  `c_valor` varchar(255) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  `c_nombre` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`i_parametro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_parametro` */

insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (3000,1,'50','Max Registros en el log','Max Registros en el log');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (15000,1,'2','Número de intentos fallidos','autenticacionIntentosFallidosBloqueo');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (15001,1,'30','Tiempo máximo de inactividad','autenticacionTiempoDeslogueoInactividad');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (15006,1,'0','Restricción en el uso de claves anteriores a','passwordHistorialRestriccion');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (15008,1,'0','Tiempo Minimo cambio contraseñas','passwordTiempoMinimoCambio');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (15009,1,'360','expiraciòn clave','passwordTiempoExpiracion');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (15015,0,'en_US','Locale Global de la Aplicación','locale');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (20000,1,'false','Se valida IP unica o no','IpValida');
insert  into `fqs_parametro`(`i_parametro`,`i_tipodato`,`c_valor`,`c_descripcion`,`c_nombre`) values (20001,1,'true','Mostrar Captcha','Captcha');

/*Table structure for table `fqs_perfil` */

DROP TABLE IF EXISTS `fqs_perfil`;

CREATE TABLE `fqs_perfil` (
  `i_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `c_nombre` char(20) NOT NULL DEFAULT '',
  `dt_horainisesion` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `dt_horafinsesion` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `c_descripcion` char(100) DEFAULT NULL,
  PRIMARY KEY (`i_perfil`),
  UNIQUE KEY `UK_Nombre` (`c_nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=5689 DEFAULT CHARSET=utf8;

/*Data for the table `fqs_perfil` */

insert  into `fqs_perfil`(`i_perfil`,`c_nombre`,`dt_horainisesion`,`dt_horafinsesion`,`c_descripcion`) values (1,'Inicio','2002-10-31 00:00:00','2020-12-31 23:59:59','Administradores Sistema');
insert  into `fqs_perfil`(`i_perfil`,`c_nombre`,`dt_horainisesion`,`dt_horafinsesion`,`c_descripcion`) values (5688,'Digitador','2014-07-15 00:00:00','2014-07-15 16:00:00','Digitador');
insert  into `fqs_perfil`(`i_perfil`,`c_nombre`,`dt_horainisesion`,`dt_horafinsesion`,`c_descripcion`) values (4,'Consulta','2015-09-08 00:00:00','2014-07-15 11:59:59','Consulta');
insert  into `fqs_perfil`(`i_perfil`,`c_nombre`,`dt_horainisesion`,`dt_horafinsesion`,`c_descripcion`) values (2,'Superusuario','2015-09-08 00:00:00','1000-01-01 00:00:00','Supervisor');
insert  into `fqs_perfil`(`i_perfil`,`c_nombre`,`dt_horainisesion`,`dt_horafinsesion`,`c_descripcion`) values (3,'Test','1000-01-01 00:00:00','1000-01-01 00:00:00','Prueba');

/*Table structure for table `fqs_permiso` */

DROP TABLE IF EXISTS `fqs_permiso`;

CREATE TABLE `fqs_permiso` (
  `i_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `i_perfil` int(11) NOT NULL DEFAULT '0',
  `i_opcionmodulo` int(11) DEFAULT NULL,
  `dt_horainipermiso` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `dt_horafinpermiso` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `c_descripcion` char(100) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`i_permiso`),
  KEY `FK_perfil` (`i_perfil`),
  KEY `FK_opcion_modulo` (`i_opcionmodulo`)
) ENGINE=MyISAM AUTO_INCREMENT=3124 DEFAULT CHARSET=utf8;

/*Data for the table `fqs_permiso` */

insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (1,1,1,'2003-12-31 00:00:00','2016-12-31 00:00:00','----');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (2,1,2,'2003-12-31 00:00:00','2010-12-31 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (3,1,3,'2003-12-31 00:00:00','2010-12-31 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (4,1,4,'2003-12-31 00:00:00','2010-12-31 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (5,1,19,'2003-12-31 00:00:00','2010-12-31 00:00:00','--');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (106,2,1,'2003-12-31 00:00:00','2016-12-31 00:00:00','----');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (3123,3,38,'1000-01-01 00:00:00','1000-01-01 00:00:00','Prueba');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (8,1,116,'2003-12-31 00:00:00','2010-12-31 00:00:00','perfil1');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (9,1,5000,'1000-01-01 00:00:00','1000-01-01 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (10,1,10,'2003-12-31 00:00:00','2020-12-31 00:00:00','Martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (11,1,11,'2003-12-31 00:00:00','2020-12-31 00:00:00','Ingreso de las Ofertas');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (14,1,20,'2003-12-31 00:00:00','2020-12-31 00:00:00','Reportes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (15,1,21,'2003-12-31 00:00:00','2020-12-31 00:00:00','Reporte Pantalla');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (12,1,12,'2003-12-31 00:00:00','2020-12-31 00:00:00','Seleccionar Martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (13,1,13,'2003-12-31 00:00:00','2020-12-31 00:00:00','Suspender Sesión');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (16,1,22,'2003-12-31 00:00:00','2020-12-31 00:00:00','mantenedores');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (17,1,23,'2003-12-31 00:00:00','2020-12-31 00:00:00','Forma Pago');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (18,1,24,'2003-12-31 00:00:00','2020-12-31 00:00:00','SCB');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (19,1,25,'2013-12-31 00:00:00','2020-12-31 00:00:00','Vendedor');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (20,1,27,'2003-12-31 00:00:00','2020-12-31 00:00:00','Reporte Adjudicacion');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (31,1,28,'2003-12-31 00:00:00','2020-12-31 00:00:00','Martillo Mant');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (32,1,29,'2003-12-31 00:00:00','2020-12-31 00:00:00','Postores');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (33,1,30,'2003-12-31 00:00:00','2020-12-31 00:00:00','Vendedor-martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (34,1,31,'2003-12-31 00:00:00','2020-12-31 00:00:00','Ofertas permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (35,1,32,'2003-12-31 00:00:00','2020-12-31 00:00:00','Carga Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (36,1,33,'2003-12-31 00:00:00','2020-12-31 00:00:00','Carga Archivo Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (37,1,34,'2003-12-31 00:00:00','2020-12-31 00:00:00','Validar Archivo Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (38,1,35,'2003-12-31 00:00:00','2020-12-31 00:00:00','Procesar Archivo Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (39,1,36,'2003-12-31 00:00:00','2020-12-31 00:00:00','Tipo de documento');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (40,1,37,'2013-12-31 00:00:00','2020-12-31 00:00:00','Gestión de sesiones');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (41,1,38,'1000-01-01 00:00:00','2010-12-31 00:00:00','Adjudicación');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (42,1,14,'2013-12-31 00:00:00','2020-12-31 00:00:00','Validación de ofertas');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (43,1,39,'1000-01-01 00:00:00','1000-01-01 00:00:00','Interfaz 62');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (46,1,42,'1000-01-01 00:00:00','1000-01-01 00:00:00','Interfaz 62');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (44,1,40,'1000-01-01 00:00:00','1000-01-01 00:00:00','Reporte de Precios');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (45,1,41,'1000-01-01 00:00:00','1000-01-01 00:00:00','Comprobante compradores');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (100,5688,11,'2014-07-15 00:00:00','2014-07-15 16:00:00','Ingreso de Ofertas');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (101,5688,14,'2014-07-15 00:00:00','2014-07-15 16:00:00','Validación de Ofertas');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (102,5688,12,'2014-07-15 00:00:00','2014-07-15 16:00:00','Seleccionar Martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (104,5688,10,'2014-07-15 00:00:00','2014-07-15 16:00:00','MARTILLO');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (48,1,44,'2014-01-01 00:00:00','2024-01-01 00:00:00','Reporte auditoria');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (105,4,20,'2015-09-08 00:00:00','2014-07-15 11:59:59','Reportes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (107,2,2,'2003-12-31 00:00:00','2010-12-31 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (108,2,3,'2003-12-31 00:00:00','2010-12-31 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (109,2,4,'2003-12-31 00:00:00','2010-12-31 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (110,2,19,'2003-12-31 00:00:00','2010-12-31 00:00:00','--');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (111,2,115,'2003-12-31 00:00:00','2010-12-31 00:00:00','no');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (112,2,116,'2003-12-31 00:00:00','2010-12-31 00:00:00','perfil1');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (113,2,5000,'1000-01-01 00:00:00','1000-01-01 00:00:00',NULL);
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (114,2,10,'2003-12-31 00:00:00','2020-12-31 00:00:00','Martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (115,2,11,'2003-12-31 00:00:00','2020-12-31 00:00:00','Ingreso de las Ofertas');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (116,2,20,'2003-12-31 00:00:00','2020-12-31 00:00:00','Reportes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (117,2,21,'2003-12-31 00:00:00','2020-12-31 00:00:00','Reporte Pantalla');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (118,2,12,'2003-12-31 00:00:00','2020-12-31 00:00:00','Seleccionar Martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (119,2,13,'2003-12-31 00:00:00','2020-12-31 00:00:00','Suspender SesiÃ³n');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (120,2,22,'2003-12-31 00:00:00','2020-12-31 00:00:00','mantenedores');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (121,2,23,'2003-12-31 00:00:00','2020-12-31 00:00:00','Forma Pago');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (122,2,24,'2003-12-31 00:00:00','2020-12-31 00:00:00','SCB');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (123,2,25,'2013-12-31 00:00:00','2020-12-31 00:00:00','Vendedor');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (124,2,27,'2003-12-31 00:00:00','2020-12-31 00:00:00','Reporte Adjudicacion');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (125,2,28,'2003-12-31 00:00:00','2020-12-31 00:00:00','Martillo Mant');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (126,2,29,'2003-12-31 00:00:00','2020-12-31 00:00:00','Postores');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (127,2,30,'2003-12-31 00:00:00','2020-12-31 00:00:00','Vendedor-martillo');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (128,2,31,'2003-12-31 00:00:00','2020-12-31 00:00:00','Ofertas permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (129,2,32,'2003-12-31 00:00:00','2020-12-31 00:00:00','Carga Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (130,2,33,'2003-12-31 00:00:00','2020-12-31 00:00:00','Carga Archivo Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (131,2,34,'2003-12-31 00:00:00','2020-12-31 00:00:00','Validar Archivo Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (132,2,35,'2003-12-31 00:00:00','2020-12-31 00:00:00','Procesar Archivo Ofertas Permanentes');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (133,2,36,'2003-12-31 00:00:00','2020-12-31 00:00:00','Tipo de documento');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (134,2,37,'2013-12-31 00:00:00','2020-12-31 00:00:00','GestiÃ³n de sesiones');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (135,2,38,'1000-01-01 00:00:00','2010-12-31 00:00:00','AdjudicaciÃ³n');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (136,2,14,'2013-12-31 00:00:00','2020-12-31 00:00:00','ValidaciÃ³n de ofertas');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (137,2,39,'1000-01-01 00:00:00','1000-01-01 00:00:00','Interfaz 62');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (138,2,42,'1000-01-01 00:00:00','1000-01-01 00:00:00','Interfaz 62');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (139,2,40,'1000-01-01 00:00:00','1000-01-01 00:00:00','Reporte de Precios');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (140,2,41,'1000-01-01 00:00:00','1000-01-01 00:00:00','Comprobante compradores');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (141,2,43,'2014-01-01 00:00:00','2024-01-01 00:00:00','Tabla auditoria');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (142,2,44,'2014-01-01 00:00:00','2024-01-01 00:00:00','Reporte auditoria');
insert  into `fqs_permiso`(`i_permiso`,`i_perfil`,`i_opcionmodulo`,`dt_horainipermiso`,`dt_horafinpermiso`,`c_descripcion`) values (143,2,26,'2014-01-01 00:00:00','2024-01-01 00:00:00','');

/*Table structure for table `fqs_tabauditada` */

DROP TABLE IF EXISTS `fqs_tabauditada`;

CREATE TABLE `fqs_tabauditada` (
  `i_tabauditada` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(30) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`i_tabauditada`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `fqs_tabauditada` */

insert  into `fqs_tabauditada`(`i_tabauditada`,`c_nombre`,`c_descripcion`) values (0,'fqs_tipoplazo','tabla tipo plazos');
insert  into `fqs_tabauditada`(`i_tabauditada`,`c_nombre`,`c_descripcion`) values (1,'va_parametro','Parametros');
insert  into `fqs_tabauditada`(`i_tabauditada`,`c_nombre`,`c_descripcion`) values (2,'h_calemisor','Calificación Emisor');
insert  into `fqs_tabauditada`(`i_tabauditada`,`c_nombre`,`c_descripcion`) values (3,'fqs_titulo','Titulos RF');

/*Table structure for table `fqs_usuario` */

DROP TABLE IF EXISTS `fqs_usuario`;

CREATE TABLE `fqs_usuario` (
  `i_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `c_tipo_identificacion` char(2) DEFAULT 'CC',
  `c_identificacion` varchar(20) DEFAULT NULL,
  `c_nombre` varchar(20) DEFAULT '',
  `c_apellidos` varchar(20) DEFAULT '',
  `c_direccion` varchar(20) DEFAULT '',
  `c_telefono` varchar(20) DEFAULT '',
  `c_email` varchar(30) DEFAULT NULL,
  `c_login` varchar(20) DEFAULT '',
  `c_contrasena` varchar(100) DEFAULT '',
  `dt_ultimologin` datetime DEFAULT NULL,
  `i_empresa` int(11) unsigned DEFAULT '0',
  `i_usuario_padre` int(11) DEFAULT '0',
  `c_estado` char(1) NOT NULL DEFAULT 'A',
  `f_ult_cambio_clave` date DEFAULT NULL,
  `i_numsesiones` int(11) DEFAULT '0',
  `i_usuariosupvisor` int(11) DEFAULT NULL,
  `c_proceso` char(2) DEFAULT 'N',
  `f_ult_cambio_reintento` datetime DEFAULT NULL,
  `sesion` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`i_usuario`),
  UNIQUE KEY `UK_Login` (`c_login`),
  UNIQUE KEY `UK_Identificacion` (`c_identificacion`,`c_tipo_identificacion`),
  KEY `IDX_Estado` (`c_estado`)
) ENGINE=MyISAM AUTO_INCREMENT=255 DEFAULT CHARSET=utf8;

/*Data for the table `fqs_usuario` */

insert  into `fqs_usuario`(`i_usuario`,`c_tipo_identificacion`,`c_identificacion`,`c_nombre`,`c_apellidos`,`c_direccion`,`c_telefono`,`c_email`,`c_login`,`c_contrasena`,`dt_ultimologin`,`i_empresa`,`i_usuario_padre`,`c_estado`,`f_ult_cambio_clave`,`i_numsesiones`,`i_usuariosupvisor`,`c_proceso`,`f_ult_cambio_reintento`,`sesion`) values (1,'CC','111','Administrador','Bvc','Pruebas Bvc','1234','MRuiz@bvc.com.co','boca','dyCrHn1IbOYw/N7BLYurbg==','2015-10-30 15:42:44',0,0,'A','2015-09-24',0,NULL,'N','2015-10-29 18:24:10',1);
insert  into `fqs_usuario`(`i_usuario`,`c_tipo_identificacion`,`c_identificacion`,`c_nombre`,`c_apellidos`,`c_direccion`,`c_telefono`,`c_email`,`c_login`,`c_contrasena`,`dt_ultimologin`,`i_empresa`,`i_usuario_padre`,`c_estado`,`f_ult_cambio_clave`,`i_numsesiones`,`i_usuariosupvisor`,`c_proceso`,`f_ult_cambio_reintento`,`sesion`) values (2,'CC','123','pruebas','pruebas','Pruebas Bvc','1111','Pruebas Bvc','pruebas','dyCrHn1IbOYw/N7BLYurbg==','2015-10-30 10:26:37',0,0,'A','2015-09-24',0,NULL,'N','2015-10-30 10:12:57',0);

/*Table structure for table `fqs_usuario_has_fqs_perfil` */

DROP TABLE IF EXISTS `fqs_usuario_has_fqs_perfil`;

CREATE TABLE `fqs_usuario_has_fqs_perfil` (
  `fqs_usuario_i_usuario` int(11) NOT NULL,
  `fqs_perfil_i_perfil` int(11) NOT NULL,
  `c_proceso` char(1) DEFAULT 'N',
  PRIMARY KEY (`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`),
  KEY `FK_usr_rol_perfil` (`fqs_perfil_i_perfil`),
  KEY `FK_usr_rol_usuario` (`fqs_usuario_i_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `fqs_usuario_has_fqs_perfil` */

insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (1,1,'S');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (2,1,'N');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (248,1,'N');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (249,1,'N');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (250,1,'N');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (251,1,'N');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (253,1,'N');
insert  into `fqs_usuario_has_fqs_perfil`(`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`,`c_proceso`) values (254,2,'N');

/*Table structure for table `fqs_usuario_password_historial` */

DROP TABLE IF EXISTS `fqs_usuario_password_historial`;

CREATE TABLE `fqs_usuario_password_historial` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `i_usuario` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  `i_usuario_modificador` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario` (`i_usuario`),
  KEY `FK_modificador` (`i_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `fqs_usuario_password_historial` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
