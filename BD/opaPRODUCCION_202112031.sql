-- MySQL dump 10.13  Distrib 5.5.49, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: opa
-- ------------------------------------------------------
-- Server version	5.5.49-enterprise-commercial-advanced-log

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
-- Table structure for table `Diccionarios_DiasLetras`
--

DROP TABLE IF EXISTS `Diccionarios_DiasLetras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Diccionarios_DiasLetras` (
  `EntidadDeNegociosID` int(11) NOT NULL AUTO_INCREMENT,
  `LetraDia` varchar(50) NOT NULL,
  `NombreUsuarioIdCreacion` int(11) NOT NULL,
  `FechaCreacion` datetime NOT NULL,
  `NombreUsuarioIdModificacion` int(11) NOT NULL,
  `FechaModificacion` datetime NOT NULL,
  PRIMARY KEY (`EntidadDeNegociosID`),
  UNIQUE KEY `Uk_Parametrizacion` (`LetraDia`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Diccionarios_DiasLetras`
--

LOCK TABLES `Diccionarios_DiasLetras` WRITE;
/*!40000 ALTER TABLE `Diccionarios_DiasLetras` DISABLE KEYS */;
INSERT INTO `Diccionarios_DiasLetras` VALUES (1,'Primero',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(2,'Dos',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(3,'Tres',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(4,'Cuatro',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(5,'Cinco',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(6,'Seis',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(7,'Siete',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(8,'Ocho',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(9,'Nueve',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(10,'Diez',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(11,'Once',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(12,'Doce',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(13,'Trece',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(14,'Catorce',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(15,'Quince',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(16,'Dieciseis',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(17,'Diecisiete',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(18,'Dieciocho',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(19,'Diecinueve',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(20,'Veinte',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(21,'Veintiuno',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(22,'Veintidos',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(23,'Veintitres',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(24,'Veinticuatro',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(25,'Veinticinco',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(26,'Veintiseis',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(27,'Veintisiste',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(28,'Veintiocho',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(29,'Veintinueve',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(30,'Treinta',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42'),(31,'Treinta y uno',1,'2016-02-19 18:14:42',1,'2016-02-19 18:14:42');
/*!40000 ALTER TABLE `Diccionarios_DiasLetras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_CrearAceptacion`
--

DROP TABLE IF EXISTS `au_CrearAceptacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_CrearAceptacion` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `EntidadDeNegociosID` int(11) NOT NULL,
  `ClaseAcciones` varchar(20) NOT NULL,
  `ConOfeVen` varchar(15) NOT NULL,
  `TextoUno` varchar(600) NOT NULL,
  `TextoDos` varchar(600) NOT NULL,
  `ExistePreacuerdo` char(1) DEFAULT NULL,
  `CodScb` decimal(15,0) NOT NULL,
  `NombreSCB` varchar(100) NOT NULL,
  `RepresentanteLegal` varchar(50) NOT NULL,
  `NombreRazonSocial` varchar(60) NOT NULL,
  `NumAcciones` decimal(15,0) NOT NULL,
  `VenCon` char(1) DEFAULT NULL,
  `TipDocumento` int(11) NOT NULL,
  `NumNitDoc` varchar(20) NOT NULL,
  `NumVer` decimal(1,0) DEFAULT NULL,
  `EspFid` varchar(3) NOT NULL,
  `CtaInv` decimal(8,0) NOT NULL,
  `NombreUsuarioIdCreacion` int(11) NOT NULL,
  `FechaCreacion` datetime NOT NULL,
  `NombreUsuarioIdModificacion` int(11) NOT NULL,
  `FechaModificacion` datetime NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Ingresado',
  `PorcentajeComision` decimal(6,3) DEFAULT '0.000',
  `observacion` varchar(200) DEFAULT NULL,
  `c_usuario_sistema_ultima_mod` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT NULL,
  `c_tipo_modificacion` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `au_usuario_bd` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT 'current_user()',
  `au_fecha_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `au_tipo_accion` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_CrearAceptacion`
--

LOCK TABLES `au_CrearAceptacion` WRITE;
/*!40000 ALTER TABLE `au_CrearAceptacion` DISABLE KEYS */;
INSERT INTO `au_CrearAceptacion` VALUES (1,1,'Ordinarias','61584','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JUAN MANUEL ISAZA PIEROTTI',15,'0',1,'6227877',NULL,'',993617,560,'2021-05-12 09:14:00',560,'2021-05-12 09:14:00','Ingresado',15.000,NULL,'hitrespa','root@localhost','2021-05-12 14:14:00','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-12 14:14:00','INSERCION REGISTRO'),(2,2,'Ordinarias','62107','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','ALFREDO  MARIN JARAMILLO',200,'0',1,'16640923',NULL,'',2215099,560,'2021-05-13 10:55:55',560,'2021-05-13 10:55:55','Ingresado',6.599,NULL,'hitrespa','root@localhost','2021-05-13 15:55:55','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 15:55:55','INSERCION REGISTRO'),(3,3,'Ordinarias','4852','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','Alejandro Garay Sarasti','Gilberto Rivera Correa',677,'1',1,'2401018',NULL,'',215255,573,'2021-05-13 12:33:00',573,'2021-05-13 12:33:00','Ingresado',2.335,NULL,'arrivera','root@localhost','2021-05-13 17:33:00','Ingreso Demanda - Insercin','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:33:00','INSERCION REGISTRO'),(4,4,'Ordinarias','62306','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','OSCAR HUMBERTO PALACIOS OSSA',253,'0',1,'14881057',NULL,'',2215798,560,'2021-05-14 09:09:28',560,'2021-05-14 09:09:28','Ingresado',5.217,NULL,'hitrespa','root@localhost','2021-05-14 14:09:28','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 14:09:28','INSERCION REGISTRO'),(5,5,'Ordinarias','216480','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','CAMACHO PALACIOS OSCAR DARIO',2625,'0',1,'80040326',NULL,'',1756726,571,'2021-05-19 11:47:56',571,'2021-05-19 11:47:56','Ingresado',0.260,NULL,'cayala','root@localhost','2021-05-19 16:47:56','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-19 16:47:56','INSERCION REGISTRO'),(6,6,'Ordinarias','213860','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','URIBE VILLAQUIRAN SEBASTIAN BERNARDO',202,'0',1,'1144064186',NULL,'',1786712,571,'2021-05-20 11:39:18',571,'2021-05-20 11:39:18','Ingresado',0.000,NULL,'cayala','root@localhost','2021-05-20 16:39:18','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 16:39:18','INSERCION REGISTRO'),(7,7,'Ordinarias','12685544','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,2,'CORREDORES DAVIVIENDA S.A.COMISIONISTA DE BOLSA','Mauricio Garcia Osorio','LUZ ELENA OCHOA SIERRA',13139,'0',1,'32076968',NULL,'',2113730,582,'2021-05-21 11:59:38',582,'2021-05-21 11:59:38','Ingresado',0.500,NULL,'dgomez','root@localhost','2021-05-21 16:59:38','Ingreso Demanda - Insercin','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:59:38','INSERCION REGISTRO'),(8,8,'Ordinarias','64851','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','CESAR ALBERTO VALENCIA ZUNIGA',656,'0',1,'72250666',NULL,'',2215926,560,'2021-05-21 12:21:10',560,'2021-05-21 12:21:10','Ingresado',2.012,NULL,'hitrespa','root@localhost','2021-05-21 17:21:10','Ingreso Demanda - Insercin','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:21:10','INSERCION REGISTRO'),(9,9,'Ordinarias','64981','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','SERGIO  ZAPATA LARROTTA',55,'0',1,'7557564',NULL,'',901823,560,'2021-05-21 12:25:22',560,'2021-05-21 12:25:22','Ingresado',15.000,NULL,'hitrespa','root@localhost','2021-05-21 17:25:22','Ingreso Demanda - Insercin','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:25:22','INSERCION REGISTRO'),(10,10,'Ordinarias','65022','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JORGE ALBERTO ESCOBAR GOMEZ',191,'0',1,'70125561',NULL,'',106415,560,'2021-05-21 12:27:41',560,'2021-05-21 12:27:41','Ingresado',6.910,NULL,'hitrespa','root@localhost','2021-05-21 17:27:41','Ingreso Demanda - Insercin','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:27:41','INSERCION REGISTRO'),(11,11,'Ordinarias','65340','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JUAN RAFAEL BAYTER POSADA',2521,'0',1,'71598574',NULL,'',196118,560,'2021-05-24 09:38:13',560,'2021-05-24 09:38:13','Ingresado',0.300,NULL,'hitrespa','root@localhost','2021-05-24 14:38:13','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:13','INSERCION REGISTRO'),(12,12,'Ordinarias','65487','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JORGE LUIS OREJUELA POTES',3,'0',1,'16607549',NULL,'',1850658,560,'2021-05-24 09:38:13',560,'2021-05-24 09:38:13','Ingresado',15.000,NULL,'hitrespa','root@localhost','2021-05-24 14:38:13','Ingreso Demanda - Archivo','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:13','INSERCION REGISTRO');
/*!40000 ALTER TABLE `au_CrearAceptacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_InterfazBackOffice`
--

DROP TABLE IF EXISTS `au_InterfazBackOffice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_InterfazBackOffice` (
  `consecutivoIDR` int(11) DEFAULT NULL,
  `fechaGeneracion` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_InterfazBackOffice`
--

LOCK TABLES `au_InterfazBackOffice` WRITE;
/*!40000 ALTER TABLE `au_InterfazBackOffice` DISABLE KEYS */;
INSERT INTO `au_InterfazBackOffice` VALUES (1,'2021-05-27');
/*!40000 ALTER TABLE `au_InterfazBackOffice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_IpAutorizada`
--

DROP TABLE IF EXISTS `au_IpAutorizada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_IpAutorizada` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `id_ip` int(11) NOT NULL DEFAULT '0',
  `ip_usuario` int(11) DEFAULT NULL,
  `ip` varchar(20) NOT NULL,
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT NULL,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  `au_usuario_bd` varchar(45) DEFAULT 'current_user()',
  `au_fecha_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `au_tipo_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_IpAutorizada`
--

LOCK TABLES `au_IpAutorizada` WRITE;
/*!40000 ALTER TABLE `au_IpAutorizada` DISABLE KEYS */;
INSERT INTO `au_IpAutorizada` VALUES (1,2303,561,'190.26.11.237','asalgado','root@localhost','2021-05-06 16:35:54','Ingreso IP - Inserción','root@localhost','2021-05-07 21:44:09','BORRADO REGISTRO'),(2,2304,561,'190.242.39.136','asalgado','root@localhost','2021-05-06 16:35:54','Ingreso IP - Inserción','root@localhost','2021-05-07 21:44:09','BORRADO REGISTRO'),(3,2332,568,'190.26.11.237','cvargasp','root@localhost','2021-05-07 19:33:46','Ingreso IP - Inserción','root@localhost','2021-05-07 21:44:09','BORRADO REGISTRO'),(4,2334,570,'190.143.111.130','esouza','root@localhost','2021-05-10 22:48:30','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 22:48:30','INSERCIÓN REGISTRO'),(5,2335,570,'201.245.161.224','esouza','root@localhost','2021-05-10 22:48:30','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 22:48:30','INSERCIÓN REGISTRO'),(6,2336,571,'190.143.111.130','mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:31:37','INSERCIÓN REGISTRO'),(7,2337,571,'201.245.161.224','mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:31:37','INSERCIÓN REGISTRO'),(8,2338,572,'190.143.111.130','mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:33:21','INSERCIÓN REGISTRO'),(9,2339,572,'201.245.161.224','mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:33:21','INSERCIÓN REGISTRO'),(10,2340,573,'190.131.244.230','kpanader','root@localhost','2021-05-11 16:51:14','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:51:14','INSERCIÓN REGISTRO'),(11,2341,574,'190.242.36.50','kpanader','root@localhost','2021-05-11 16:54:13','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:54:13','INSERCIÓN REGISTRO'),(12,2342,575,'190.131.240.114','esouza','root@localhost','2021-05-11 22:10:29','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 22:10:29','INSERCIÓN REGISTRO'),(13,2343,575,'190.216.157.114','esouza','root@localhost','2021-05-11 22:10:29','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 22:10:29','INSERCIÓN REGISTRO'),(14,2344,575,'190.131.252.99','esouza','root@localhost','2021-05-11 22:10:29','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 22:10:29','INSERCIÓN REGISTRO'),(15,2340,573,'190.131.244.230','kpanader','root@localhost','2021-05-11 16:51:14','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:23:25','BORRADO REGISTRO'),(16,2345,573,'190.131.244.230','kpanader','root@localhost','2021-05-13 17:23:25','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:23:25','INSERCIÓN REGISTRO'),(17,2346,576,'190.131.197.10','esouza','root@localhost','2021-05-14 21:24:26','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 21:24:26','INSERCIÓN REGISTRO'),(18,2347,576,'190.131.197.11','esouza','root@localhost','2021-05-14 21:24:26','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 21:24:26','INSERCIÓN REGISTRO'),(19,2348,577,'190.131.197.10','cblanco','root@localhost','2021-05-20 13:45:23','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 13:45:23','INSERCIÓN REGISTRO'),(20,2349,578,'190.131.197.10','cblanco','root@localhost','2021-05-20 14:34:18','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:34:18','INSERCIÓN REGISTRO'),(21,2350,579,'190.131.197.10','cblanco','root@localhost','2021-05-20 14:39:01','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:39:01','INSERCIÓN REGISTRO'),(22,2351,580,'190.131.197.10','cblanco','root@localhost','2021-05-20 14:47:01','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:47:01','INSERCIÓN REGISTRO'),(23,2294,559,'201.221.124.8','asalgado','root@localhost','2021-05-06 00:10:15','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','BORRADO REGISTRO'),(24,2295,559,'201.221.125.136','asalgado','root@localhost','2021-05-06 00:10:15','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','BORRADO REGISTRO'),(25,2296,559,'200.1.175.202','asalgado','root@localhost','2021-05-06 00:10:15','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','BORRADO REGISTRO'),(26,2352,559,'201.221.124.8','esouza','root@localhost','2021-05-21 15:13:24','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','INSERCIÓN REGISTRO'),(27,2353,559,'201.221.125.136','esouza','root@localhost','2021-05-21 15:13:24','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','INSERCIÓN REGISTRO'),(28,2354,559,'192.151.179.180','esouza','root@localhost','2021-05-21 15:13:24','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','INSERCIÓN REGISTRO'),(29,2352,559,'201.221.124.8','esouza','root@localhost','2021-05-21 15:13:24','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','BORRADO REGISTRO'),(30,2353,559,'201.221.125.136','esouza','root@localhost','2021-05-21 15:13:24','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','BORRADO REGISTRO'),(31,2354,559,'192.151.179.180','esouza','root@localhost','2021-05-21 15:13:24','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','BORRADO REGISTRO'),(32,2355,559,'201.221.124.8','esouza','root@localhost','2021-05-21 15:25:08','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','INSERCIÓN REGISTRO'),(33,2356,559,'201.221.125.136','esouza','root@localhost','2021-05-21 15:25:08','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','INSERCIÓN REGISTRO'),(34,2357,559,'192.151.179.180','esouza','root@localhost','2021-05-21 15:25:08','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','INSERCIÓN REGISTRO'),(35,2358,581,'186.155.241.196','esouza','root@localhost','2021-05-21 16:01:59','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:01:59','INSERCIÓN REGISTRO'),(36,2359,581,'190.131.201.70','esouza','root@localhost','2021-05-21 16:01:59','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:01:59','INSERCIÓN REGISTRO'),(37,2360,581,'190.242.96.250','esouza','root@localhost','2021-05-21 16:01:59','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:01:59','INSERCIÓN REGISTRO'),(38,2361,582,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:17:31','INSERCIÓN REGISTRO'),(39,2362,582,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:17:31','INSERCIÓN REGISTRO'),(40,2363,582,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:17:31','INSERCIÓN REGISTRO'),(41,2364,583,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:28:32','INSERCIÓN REGISTRO'),(42,2365,583,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:28:32','INSERCIÓN REGISTRO'),(43,2366,583,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:28:32','INSERCIÓN REGISTRO'),(44,2367,584,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:30:45','INSERCIÓN REGISTRO'),(45,2368,584,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:30:45','INSERCIÓN REGISTRO'),(46,2369,584,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:30:45','INSERCIÓN REGISTRO'),(47,2370,585,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:32:49','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:32:49','INSERCIÓN REGISTRO'),(48,2371,585,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:32:49','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:32:49','INSERCIÓN REGISTRO'),(49,2372,585,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:32:49','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:32:49','INSERCIÓN REGISTRO'),(50,2373,586,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:34:40','INSERCIÓN REGISTRO'),(51,2374,586,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:34:40','INSERCIÓN REGISTRO'),(52,2375,586,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:34:40','INSERCIÓN REGISTRO'),(53,2376,587,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:36:19','INSERCIÓN REGISTRO'),(54,2377,587,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:36:19','INSERCIÓN REGISTRO'),(55,2378,587,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:36:19','INSERCIÓN REGISTRO'),(56,2355,559,'201.221.124.8','esouza','root@localhost','2021-05-21 15:25:08','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','BORRADO REGISTRO'),(57,2356,559,'201.221.125.136','esouza','root@localhost','2021-05-21 15:25:08','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','BORRADO REGISTRO'),(58,2357,559,'192.151.179.180','esouza','root@localhost','2021-05-21 15:25:08','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','BORRADO REGISTRO'),(59,2379,559,'201.221.124.8','esouza','root@localhost','2021-05-21 16:38:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','INSERCIÓN REGISTRO'),(60,2380,559,'201.221.125.136','esouza','root@localhost','2021-05-21 16:38:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','INSERCIÓN REGISTRO'),(61,2381,559,'192.151.179.180','esouza','root@localhost','2021-05-21 16:38:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','INSERCIÓN REGISTRO'),(62,2382,588,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:14','INSERCIÓN REGISTRO'),(63,2383,588,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:14','INSERCIÓN REGISTRO'),(64,2384,588,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:14','INSERCIÓN REGISTRO'),(65,2370,585,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:32:49','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','BORRADO REGISTRO'),(66,2371,585,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:32:49','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','BORRADO REGISTRO'),(67,2372,585,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:32:49','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','BORRADO REGISTRO'),(68,2385,585,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:43:35','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','INSERCIÓN REGISTRO'),(69,2386,585,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:43:35','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','INSERCIÓN REGISTRO'),(70,2387,585,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:43:35','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','INSERCIÓN REGISTRO'),(71,2385,585,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:43:35','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','BORRADO REGISTRO'),(72,2386,585,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:43:35','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','BORRADO REGISTRO'),(73,2387,585,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:43:35','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','BORRADO REGISTRO'),(74,2388,585,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:48:22','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','INSERCIÓN REGISTRO'),(75,2389,585,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:48:22','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','INSERCIÓN REGISTRO'),(76,2390,585,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:48:22','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','INSERCIÓN REGISTRO'),(77,2379,559,'201.221.124.8','esouza','root@localhost','2021-05-21 16:38:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','BORRADO REGISTRO'),(78,2380,559,'201.221.125.136','esouza','root@localhost','2021-05-21 16:38:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','BORRADO REGISTRO'),(79,2381,559,'192.151.179.180','esouza','root@localhost','2021-05-21 16:38:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','BORRADO REGISTRO'),(80,2391,559,'201.221.124.8','esouza','root@localhost','2021-05-21 17:05:55','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','INSERCIÓN REGISTRO'),(81,2392,559,'201.221.125.136','esouza','root@localhost','2021-05-21 17:05:55','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','INSERCIÓN REGISTRO'),(82,2393,559,'201.221.124.121','esouza','root@localhost','2021-05-21 17:05:55','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','INSERCIÓN REGISTRO'),(83,2316,565,'201.221.124.8','evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','BORRADO REGISTRO'),(84,2317,565,'201.221.125.136','evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','BORRADO REGISTRO'),(85,2318,565,'200.1.175.202','evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','BORRADO REGISTRO'),(86,2394,565,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:12:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','INSERCIÓN REGISTRO'),(87,2395,565,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:12:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','INSERCIÓN REGISTRO'),(88,2396,565,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:12:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','INSERCIÓN REGISTRO'),(89,2313,564,'201.221.124.8','evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','BORRADO REGISTRO'),(90,2314,564,'201.221.125.136','evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','BORRADO REGISTRO'),(91,2315,564,'200.1.175.202','evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','BORRADO REGISTRO'),(92,2397,564,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:13:18','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','INSERCIÓN REGISTRO'),(93,2398,564,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:13:18','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','INSERCIÓN REGISTRO'),(94,2399,564,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:13:18','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','INSERCIÓN REGISTRO'),(95,2297,560,'201.221.124.8','evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','BORRADO REGISTRO'),(96,2298,560,'201.221.125.136','evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','BORRADO REGISTRO'),(97,2299,560,'200.1.175.202','evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','BORRADO REGISTRO'),(98,2400,560,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:14:40','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','INSERCIÓN REGISTRO'),(99,2401,560,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:14:40','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','INSERCIÓN REGISTRO'),(100,2402,560,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:14:40','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','INSERCIÓN REGISTRO'),(101,2319,566,'201.221.124.8','evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','BORRADO REGISTRO'),(102,2320,566,'201.221.125.136','evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','BORRADO REGISTRO'),(103,2321,566,'200.1.175.202','evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','BORRADO REGISTRO'),(104,2403,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:14:52','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','INSERCIÓN REGISTRO'),(105,2404,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:14:52','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','INSERCIÓN REGISTRO'),(106,2405,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:14:52','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','INSERCIÓN REGISTRO'),(107,2403,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:14:52','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','BORRADO REGISTRO'),(108,2404,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:14:52','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','BORRADO REGISTRO'),(109,2405,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:14:52','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','BORRADO REGISTRO'),(110,2406,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:15:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','INSERCIÓN REGISTRO'),(111,2407,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:15:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','INSERCIÓN REGISTRO'),(112,2408,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:15:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','INSERCIÓN REGISTRO'),(113,2406,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:15:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','BORRADO REGISTRO'),(114,2407,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:15:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','BORRADO REGISTRO'),(115,2408,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:15:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','BORRADO REGISTRO'),(116,2409,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:15:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','INSERCIÓN REGISTRO'),(117,2410,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:15:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','INSERCIÓN REGISTRO'),(118,2411,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:15:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','INSERCIÓN REGISTRO'),(119,2409,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:15:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','BORRADO REGISTRO'),(120,2410,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:15:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','BORRADO REGISTRO'),(121,2411,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:15:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','BORRADO REGISTRO'),(122,2412,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:24:11','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','INSERCIÓN REGISTRO'),(123,2413,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:24:11','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','INSERCIÓN REGISTRO'),(124,2414,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:24:11','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','INSERCIÓN REGISTRO'),(125,2400,560,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:14:40','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','BORRADO REGISTRO'),(126,2401,560,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:14:40','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','BORRADO REGISTRO'),(127,2402,560,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:14:40','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','BORRADO REGISTRO'),(128,2415,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:13:56','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','INSERCIÓN REGISTRO'),(129,2416,560,'201.221.125.1','evelasquez','root@localhost','2021-05-24 14:13:56','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','INSERCIÓN REGISTRO'),(130,2417,560,'200.1.175.24','evelasquez','root@localhost','2021-05-24 14:13:56','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','INSERCIÓN REGISTRO'),(131,2415,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:13:56','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','BORRADO REGISTRO'),(132,2416,560,'201.221.125.1','evelasquez','root@localhost','2021-05-24 14:13:56','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','BORRADO REGISTRO'),(133,2417,560,'200.1.175.24','evelasquez','root@localhost','2021-05-24 14:13:56','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','BORRADO REGISTRO'),(134,2418,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:24:16','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','INSERCIÓN REGISTRO'),(135,2419,560,'201.221.125.1','evelasquez','root@localhost','2021-05-24 14:24:16','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','INSERCIÓN REGISTRO'),(136,2420,560,'200.1.175.24','evelasquez','root@localhost','2021-05-24 14:24:16','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','INSERCIÓN REGISTRO'),(137,2418,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:24:16','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','BORRADO REGISTRO'),(138,2419,560,'201.221.125.1','evelasquez','root@localhost','2021-05-24 14:24:16','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','BORRADO REGISTRO'),(139,2420,560,'200.1.175.24','evelasquez','root@localhost','2021-05-24 14:24:16','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','BORRADO REGISTRO'),(140,2421,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:30:51','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','INSERCIÓN REGISTRO'),(141,2422,560,'201.221.125.136','evelasquez','root@localhost','2021-05-24 14:30:51','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','INSERCIÓN REGISTRO'),(142,2423,560,'200.1.175.202','evelasquez','root@localhost','2021-05-24 14:30:51','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','INSERCIÓN REGISTRO'),(143,2421,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:30:51','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','BORRADO REGISTRO'),(144,2422,560,'201.221.125.136','evelasquez','root@localhost','2021-05-24 14:30:51','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','BORRADO REGISTRO'),(145,2423,560,'200.1.175.202','evelasquez','root@localhost','2021-05-24 14:30:51','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','BORRADO REGISTRO'),(146,2424,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:35:27','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','INSERCIÓN REGISTRO'),(147,2425,560,'201.221.124.8','evelasquez','root@localhost','2021-05-24 14:35:27','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','INSERCIÓN REGISTRO'),(148,2426,560,'200.1.175.202','evelasquez','root@localhost','2021-05-24 14:35:27','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','INSERCIÓN REGISTRO'),(149,2397,564,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:13:18','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','BORRADO REGISTRO'),(150,2398,564,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:13:18','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','BORRADO REGISTRO'),(151,2399,564,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:13:18','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','BORRADO REGISTRO'),(152,2427,564,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:38:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','INSERCIÓN REGISTRO'),(153,2428,564,'201.221.124.8','evelasquez','root@localhost','2021-05-24 14:38:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','INSERCIÓN REGISTRO'),(154,2429,564,'200.1.175.202','evelasquez','root@localhost','2021-05-24 14:38:54','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','INSERCIÓN REGISTRO'),(155,2358,581,'186.155.241.196','esouza','root@localhost','2021-05-21 16:01:59','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','BORRADO REGISTRO'),(156,2359,581,'190.131.201.70','esouza','root@localhost','2021-05-21 16:01:59','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','BORRADO REGISTRO'),(157,2360,581,'190.242.96.250','esouza','root@localhost','2021-05-21 16:01:59','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','BORRADO REGISTRO'),(158,2430,581,'186.155.241.196','asalgado','root@localhost','2021-05-24 17:29:14','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','INSERCIÓN REGISTRO'),(159,2431,581,'190.131.201.70','asalgado','root@localhost','2021-05-24 17:29:14','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','INSERCIÓN REGISTRO'),(160,2432,581,'190.242.96.250','asalgado','root@localhost','2021-05-24 17:29:14','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','INSERCIÓN REGISTRO'),(161,2098,530,'190.242.39.136','esouza','root@localhost','2020-11-10 17:31:39','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-01 17:46:45','BORRADO REGISTRO'),(162,2433,530,'190.242.39.136','asalgado','root@localhost','2021-12-01 17:46:45','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-01 17:46:45','INSERCIÓN REGISTRO'),(163,2326,89,'192.168.128.141','esouza','root@localhost','2021-05-07 14:55:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','BORRADO REGISTRO'),(164,2327,89,'192.168.94.129','esouza','root@localhost','2021-05-07 14:55:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','BORRADO REGISTRO'),(165,2328,89,'190.242.39.136','esouza','root@localhost','2021-05-07 14:55:07','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','BORRADO REGISTRO'),(166,2434,89,'192.168.128.141','asalgado','root@localhost','2021-12-03 19:54:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','INSERCIÓN REGISTRO'),(167,2435,89,'192.168.94.129','asalgado','root@localhost','2021-12-03 19:54:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','INSERCIÓN REGISTRO'),(168,2436,89,'190.242.39.136','asalgado','root@localhost','2021-12-03 19:54:12','Ingreso IP - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','INSERCIÓN REGISTRO'),(169,2437,589,'192.168.94.129','asalgado','root@localhost','2021-12-03 19:57:18','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:57:18','INSERCIÓN REGISTRO'),(170,2438,589,'190.242.39.136','asalgado','root@localhost','2021-12-03 19:57:18','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:57:18','INSERCIÓN REGISTRO'),(171,2439,590,'192.168.94.129','lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:06:24','INSERCIÓN REGISTRO'),(172,2440,590,'190.242.39.136','lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso IP - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:06:24','INSERCIÓN REGISTRO');
/*!40000 ALTER TABLE `au_IpAutorizada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_Parametrizacion`
--

DROP TABLE IF EXISTS `au_Parametrizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_Parametrizacion` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `EntidadDeNegociosID` int(11) NOT NULL COMMENT 'Llave primaria de la tabla',
  `UsuarioID` int(11) NOT NULL COMMENT 'Campo llave de negocio entre Parametrizaci�n y Usuario',
  `FechaIniOperacion` date NOT NULL COMMENT 'Campo para la fecha de inicio de la operaci�n',
  `HoraIniOperacion` time NOT NULL COMMENT 'Campo para la hora de inicio de la operaci�n',
  `FechaFinOperacion` date NOT NULL COMMENT 'Campo para la fecha de finalizaci�n de la operaci�n',
  `HoraFinOperacion` time NOT NULL COMMENT 'Campo para la hora de finalizaci�n de la operaci�n',
  `MinAccionesObjOferta` decimal(15,0) NOT NULL COMMENT 'Campo para el n�mero minimo de acciones',
  `MaxAccionesObjOferta` decimal(15,0) NOT NULL COMMENT 'Campo para el n�mero maximo de acciones',
  `NombreRazonSocial` varchar(50) NOT NULL COMMENT 'Campo para el nombre o razon social',
  `PrecioAceptaciones` decimal(16,2) NOT NULL COMMENT 'Campo para el percio de las aceptaciones',
  `NumeroAceptacion` int(11) NOT NULL COMMENT 'Campo para el n�mero o consecutivo',
  `TextoUno` varchar(600) NOT NULL COMMENT 'Campo para el texto 1',
  `TextoDos` varchar(600) NOT NULL COMMENT 'Campo para el texto 2',
  `ExistePreacuerdo` tinyint(1) NOT NULL COMMENT 'Campo si existe � no preacuerdo',
  `CantReporte` decimal(2,0) NOT NULL COMMENT 'Campo para la cantidad de reportes',
  `Nanotecnico` varchar(20) DEFAULT NULL COMMENT 'Campo para el nanot�cnico',
  `ClaseAcciones` varchar(20) DEFAULT NULL COMMENT 'Campo para las clases de acciones',
  `CantUsuariosOpe` decimal(2,0) DEFAULT NULL COMMENT 'Campo para la cantidad de operadores ',
  `NombreUsuarioIdCreacion` int(11) NOT NULL COMMENT 'Usuario quien crea el registro',
  `FechaCreacion` datetime NOT NULL COMMENT 'Fecha en la que se creo el nuevo registro',
  `NombreUsuarioIdModificacion` int(11) NOT NULL COMMENT 'Usuario quien modifica el registro',
  `FechaModificacion` datetime NOT NULL COMMENT 'Fecha en la que se realizo la ultima actualizaci�n',
  `TodoONada` tinyint(1) NOT NULL,
  `ActivarCargaMasiva` tinyint(1) NOT NULL,
  `TipoDocumentoOferente` int(11) NOT NULL COMMENT 'Tipo de documento del comprador',
  `NumeroDocumentoOferente` varchar(15) NOT NULL COMMENT 'N�mero de documento del oferente',
  `DVOferente` varchar(1) NOT NULL COMMENT 'D�gito de verificaci�n del oferente',
  `EFOferente` varchar(3) DEFAULT NULL COMMENT 'Especial fiduciario del oferente',
  `CuentaDecevalOferente` int(8) NOT NULL COMMENT 'Cuenta Deceval del Oferente',
  `SCBOferente` int(11) NOT NULL COMMENT 'SCB que representa al oferente',
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT NULL,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  `HoraIniOperacionCarga` time DEFAULT NULL,
  `HoraFinOperacionCarga` time DEFAULT NULL,
  `Accionesnegociadas` varchar(20) DEFAULT NULL,
  `TxtBoletinInformativo` varchar(700) DEFAULT NULL,
  `au_usuario_bd` varchar(45) DEFAULT 'current_user()',
  `au_fecha_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `au_tipo_accion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COMMENT='-- =============================================\nAuthor: Leonard Willian Prens Herrera\nCreate date: 15-02-2016\nDescription: Tabla Diccionario Parametrizacion de los usuarios.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_Parametrizacion`
--

LOCK TABLES `au_Parametrizacion` WRITE;
/*!40000 ALTER TABLE `au_Parametrizacion` DISABLE KEYS */;
INSERT INTO `au_Parametrizacion` VALUES (1,1,448,'2021-05-07','09:00:00','2021-05-07','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-06 17:55:16',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-06 22:55:16','Ingreso Parametro - Inserción','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:55:16','INSERCI? REGISTRO'),(2,1,448,'2021-05-07','09:00:00','2021-05-07','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-06 17:55:19',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-06 22:55:19','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:55:19','ACTUALIZACI? REGISTRO'),(3,1,448,'2021-05-07','09:00:00','2021-05-07','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-06 17:55:21',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-06 22:55:21','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:55:21','ACTUALIZACI? REGISTRO'),(4,1,448,'2021-05-07','09:00:00','2021-05-07','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 14:44:47',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 19:44:47','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:44:47','ACTUALIZACI? REGISTRO'),(5,1,448,'2021-05-07','14:00:00','2021-05-07','15:15:00',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 14:48:40',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 19:48:40','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:48:40','ACTUALIZACI? REGISTRO'),(6,1,448,'2021-05-07','14:00:00','2021-05-07','15:15:00',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 14:54:28',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 19:54:28','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:54:28','ACTUALIZACI? REGISTRO'),(7,1,448,'2021-05-07','14:00:00','2021-05-07','15:15:00',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,0,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 14:55:54',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 19:55:54','Actualizar Parametro - Actualización','14:00:00','15:15:00','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:55:54','ACTUALIZACI? REGISTRO'),(8,1,448,'2021-05-07','14:00:00','2021-05-07','15:15:00',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 15:40:36',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 20:40:36','Actualizar Parametro - Actualización','14:00:00','15:15:00','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:40:36','ACTUALIZACI? REGISTRO'),(9,1,448,'2021-05-10','09:00:00','2021-05-24','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 15:56:16',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 20:56:16','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:56:16','ACTUALIZACI? REGISTRO'),(10,1,448,'2021-05-10','09:00:00','2021-05-24','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A.  que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 15:56:25',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 20:56:25','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:56:25','ACTUALIZACI? REGISTRO'),(11,1,448,'2021-05-10','09:00:00','2021-05-24','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,448,'2021-05-06 17:55:16',448,'2021-05-07 17:38:41',1,1,4,'444444100','5','',2209266,10,'cvargas','root@localhost','2021-05-07 22:38:41','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 de 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 22:38:41','ACTUALIZACI? REGISTRO'),(12,1,89,'2021-12-03','09:00:00','2021-12-04','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,0,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,89,'2021-05-06 17:55:16',89,'2021-12-03 15:02:00',1,1,4,'444444100','5','',2209266,10,'lmuneton','root@localhost','2021-12-03 20:02:00','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 de 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:02:00','ACTUALIZACI? REGISTRO');
/*!40000 ALTER TABLE `au_Parametrizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_adjudicacion`
--

DROP TABLE IF EXISTS `au_adjudicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_adjudicacion` (
  `i_id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `i_id_adjudicacion` int(11) DEFAULT NULL,
  `i_id_aceptacion` int(11) DEFAULT NULL,
  `i_acciones_adjudicadas` double(15,0) DEFAULT NULL,
  `d_precio` decimal(15,2) DEFAULT NULL,
  `d_monto` decimal(17,2) DEFAULT NULL,
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT NULL,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  `au_usuario_bd` varchar(45) DEFAULT 'current_user()',
  `au_fecha_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `au_tipo_accion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`i_id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_adjudicacion`
--

LOCK TABLES `au_adjudicacion` WRITE;
/*!40000 ALTER TABLE `au_adjudicacion` DISABLE KEYS */;
INSERT INTO `au_adjudicacion` VALUES (1,1,1,15,9850.00,147750.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(2,2,2,200,9850.00,1970000.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(3,3,3,677,9850.00,6668450.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(4,4,4,253,9850.00,2492050.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(5,5,5,2625,9850.00,25856250.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(6,6,6,202,9850.00,1989700.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(7,7,7,13139,9850.00,129419150.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(8,8,8,656,9850.00,6461600.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(9,9,9,55,9850.00,541750.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(10,10,10,191,9850.00,1881350.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(11,11,11,2521,9850.00,24831850.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO'),(12,12,12,3,9850.00,29550.00,'cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:49:51','INSERCI? REGISTRO');
/*!40000 ALTER TABLE `au_adjudicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_diccionario`
--

DROP TABLE IF EXISTS `au_diccionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_diccionario` (
  `id_palabra` int(99) NOT NULL AUTO_INCREMENT,
  `palabra` varchar(500) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `usuario_modificacion` varchar(50) DEFAULT NULL,
  `au_fecha_modificacion` timestamp NULL DEFAULT NULL,
  `au_usuario` varchar(50) DEFAULT NULL,
  `au_tipo_modificacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_palabra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_diccionario`
--

LOCK TABLES `au_diccionario` WRITE;
/*!40000 ALTER TABLE `au_diccionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `au_diccionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_formapago`
--

DROP TABLE IF EXISTS `au_formapago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_formapago` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `i_id_aceptacion` int(11) DEFAULT NULL,
  `PorcentajeEfectivoAsignado` int(3) DEFAULT NULL,
  `MontoEfectivoAsignado` decimal(26,2) DEFAULT NULL,
  `PorcentajeTitulosAsignado` int(3) DEFAULT NULL,
  `MontoTitulosAsignado` decimal(26,2) DEFAULT NULL,
  `CantidadAccionesPago` bigint(20) DEFAULT NULL,
  `MontoTitulosFinal` decimal(26,2) DEFAULT NULL,
  `SaldoMontoTitulos` decimal(26,2) DEFAULT NULL,
  `MontoEfectivoFinal` decimal(26,2) DEFAULT NULL,
  `au_usuario_bd` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT 'current_user()',
  `au_fecha_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `au_tipo_accion` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_formapago`
--

LOCK TABLES `au_formapago` WRITE;
/*!40000 ALTER TABLE `au_formapago` DISABLE KEYS */;
/*!40000 ALTER TABLE `au_formapago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_interfaz20`
--

DROP TABLE IF EXISTS `au_interfaz20`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_interfaz20` (
  `consecutivo` int(9) DEFAULT NULL,
  `fechaGeneracion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_interfaz20`
--

LOCK TABLES `au_interfaz20` WRITE;
/*!40000 ALTER TABLE `au_interfaz20` DISABLE KEYS */;
INSERT INTO `au_interfaz20` VALUES (0,'2019-10-02'),(0,'2019-10-02');
/*!40000 ALTER TABLE `au_interfaz20` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_reporteUsuario`
--

DROP TABLE IF EXISTS `au_reporteUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_reporteUsuario` (
  `i_id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `i_id_reporte` int(11) NOT NULL,
  `i_num_reporte` int(11) DEFAULT NULL,
  `i_id_usuario` int(11) DEFAULT NULL,
  `fecha` varchar(20) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`i_id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_reporteUsuario`
--

LOCK TABLES `au_reporteUsuario` WRITE;
/*!40000 ALTER TABLE `au_reporteUsuario` DISABLE KEYS */;
INSERT INTO `au_reporteUsuario` VALUES (1,1,1,560,'2021-05-12'),(2,2,1,560,'2021-05-13'),(3,3,1,560,'2021-05-14'),(4,4,1,571,'2021-05-19'),(5,5,1,571,'2021-05-20'),(6,6,1,582,'2021-05-21'),(7,7,1,560,'2021-05-21'),(8,8,1,581,'2021-05-21'),(9,9,1,560,'2021-05-24'),(10,10,1,581,'2021-05-24');
/*!40000 ALTER TABLE `au_reporteUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_reporteadjudicacion`
--

DROP TABLE IF EXISTS `au_reporteadjudicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_reporteadjudicacion` (
  `consecutivo` int(11) DEFAULT NULL,
  `fechaGeneracion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_reporteadjudicacion`
--

LOCK TABLES `au_reporteadjudicacion` WRITE;
/*!40000 ALTER TABLE `au_reporteadjudicacion` DISABLE KEYS */;
INSERT INTO `au_reporteadjudicacion` VALUES (1,'2021-05-27');
/*!40000 ALTER TABLE `au_reporteadjudicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `au_usuario`
--

DROP TABLE IF EXISTS `au_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `au_usuario` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `i_usuario` int(11) NOT NULL DEFAULT '0',
  `c_tipo_identificacion` varchar(3) DEFAULT NULL,
  `c_identificacion` varchar(20) DEFAULT NULL,
  `c_nombre` varchar(50) DEFAULT '',
  `c_apellidos` varchar(50) DEFAULT '',
  `c_direccion` varchar(20) DEFAULT '',
  `c_telefono` varchar(20) DEFAULT '',
  `c_email` varchar(100) DEFAULT NULL,
  `c_login` varchar(20) DEFAULT '',
  `c_contrasena` varchar(100) DEFAULT '',
  `dt_ultimologin` datetime DEFAULT NULL,
  `i_empresa` int(11) unsigned DEFAULT '0',
  `i_usuario_padre` int(11) DEFAULT '0',
  `c_estado` varchar(10) NOT NULL DEFAULT 'Activo',
  `f_ult_cambio_clave` date DEFAULT NULL,
  `i_numsesiones` int(11) DEFAULT '0',
  `i_usuariosupvisor` int(11) DEFAULT NULL,
  `c_proceso` char(2) DEFAULT 'N',
  `f_ult_cambio_reintento` datetime DEFAULT NULL,
  `sesion` tinyint(1) DEFAULT '0',
  `i_cod_agente` int(11) DEFAULT NULL,
  `ty_cambiocontrasena` tinyint(1) DEFAULT '0',
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultimo_modificacion` timestamp NULL DEFAULT NULL,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  `au_usuario_bd` varchar(45) DEFAULT 'current_user()',
  `au_fecha_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `au_tipo_accion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=MyISAM AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_usuario`
--

LOCK TABLES `au_usuario` WRITE;
/*!40000 ALTER TABLE `au_usuario` DISABLE KEYS */;
INSERT INTO `au_usuario` VALUES (1,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','XLzHbhgNdHisUoo3sHSVLQ==','2021-05-04 16:47:39',0,0,'A','2021-04-06',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:47:39','ACTUALIZACION REGISTRO'),(2,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','FZyWO/WI7PgeriB8YfNs1w==','2021-05-04 16:47:39',0,0,'A','2021-05-04',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:48:07','ACTUALIZACION REGISTRO'),(3,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','p7SQ3HzziyeP6/SRu8Pf2A==','2020-12-10 16:19:08',0,0,'A','2020-12-10',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:50:12','ACTUALIZACION REGISTRO'),(4,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','p7SQ3HzziyeP6/SRu8Pf2A==','2020-12-10 16:19:08',0,0,'A','2020-12-10',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:51:19','ACTUALIZACION REGISTRO'),(5,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','dINycK6e/ItWFWlxSud23Q==','2020-12-10 16:19:08',0,0,'A','2021-05-04',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:51:19','ACTUALIZACION REGISTRO'),(6,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','dINycK6e/ItWFWlxSud23Q==','2020-12-10 16:19:08',0,0,'A','2021-05-04',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:53:37','ACTUALIZACION REGISTRO'),(7,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','dINycK6e/ItWFWlxSud23Q==','2021-05-04 16:54:01',0,0,'A','2021-05-04',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 21:54:01','ACTUALIZACION REGISTRO'),(8,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','dINycK6e/ItWFWlxSud23Q==','2021-05-04 16:54:01',0,0,'A','2021-05-04',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-04 22:26:53','ACTUALIZACION REGISTRO'),(9,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','NHSXFQWInpSFfFasUXZTBw==','2021-05-05 12:27:33',0,0,'A','2021-03-10',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 17:27:33','ACTUALIZACION REGISTRO'),(10,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-05 12:27:33',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 17:28:20','ACTUALIZACION REGISTRO'),(11,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','b1SFxJESc9qMI8KxJ3GDgw==','2021-05-05 12:36:37',0,0,'A','2020-11-24',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 17:36:37','ACTUALIZACION REGISTRO'),(12,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-05 12:36:37',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 17:36:59','ACTUALIZACION REGISTRO'),(13,558,'CC','43749812','Maria Sorelli','Uribe Ramirez',NULL,NULL,'suribe@globalcdb.com','suribe','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,51,0,'esouza','root@localhost','2021-05-05 17:37:55','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 17:37:55','INSERCION REGISTRO'),(14,558,'CC','43749812','Maria Sorelli','Uribe Ramirez',NULL,NULL,'suribe@globalcdb.com','suribe','SopWXS9I9ma8xEaS+EVs/g==',NULL,0,0,'A','2021-05-05',0,NULL,'N',NULL,0,51,0,'esouza','root@localhost','2021-05-05 17:37:55','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 17:37:55','ACTUALIZACION REGISTRO'),(15,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','FZyWO/WI7PgeriB8YfNs1w==','2021-05-05 18:48:33',0,0,'A','2021-05-04',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-05 23:48:33','ACTUALIZACION REGISTRO'),(16,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,10,0,'asalgado','root@localhost','2021-05-06 00:10:15','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 00:10:15','INSERCION REGISTRO'),(17,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','ts9EkKzm4yZppN759FQ7RQ==',NULL,0,0,'A','2021-05-05',0,NULL,'N',NULL,0,10,0,'asalgado','root@localhost','2021-05-06 00:10:15','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 00:10:15','ACTUALIZACION REGISTRO'),(18,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','ts9EkKzm4yZppN759FQ7RQ==','2021-05-06 08:34:59',0,0,'A','2021-05-05',0,NULL,'N',NULL,0,10,0,'asalgado','root@localhost','2021-05-06 00:10:15','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 13:34:59','ACTUALIZACION REGISTRO'),(19,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-06 08:34:59',0,0,'A','2021-05-06',0,NULL,'N',NULL,0,10,0,'asalgado','root@localhost','2021-05-06 00:10:15','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 13:35:43','ACTUALIZACION REGISTRO'),(20,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 13:41:32','INSERCION REGISTRO'),(21,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-06',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 13:41:32','ACTUALIZACION REGISTRO'),(22,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','FZyWO/WI7PgeriB8YfNs1w==','2021-05-06 11:11:13',0,0,'A','2021-05-04',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 16:11:13','ACTUALIZACION REGISTRO'),(23,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-05 12:36:37',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 16:12:00','ACTUALIZACION REGISTRO'),(24,561,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargasp','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asalgado','root@localhost','2021-05-06 16:35:54','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 16:35:54','INSERCION REGISTRO'),(25,561,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargasp','ts9EkKzm4yZppN759FQ7RQ==',NULL,0,0,'A','2021-05-06',0,NULL,'N',NULL,0,2,0,'asalgado','root@localhost','2021-05-06 16:35:54','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 16:35:54','ACTUALIZACION REGISTRO'),(26,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','FZyWO/WI7PgeriB8YfNs1w==','2021-05-06 11:36:53',0,0,'A','2021-05-04',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 16:36:53','ACTUALIZACION REGISTRO'),(27,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-06 17:10:08',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:10:08','ACTUALIZACION REGISTRO'),(28,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','FZyWO/WI7PgeriB8YfNs1w==','2021-05-06 17:10:51',0,0,'A','2021-05-04',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:10:51','ACTUALIZACION REGISTRO'),(29,562,'CC','79296043','Jesus Elias','Baracaldo Rojas',NULL,NULL,'jesus.baracaldo@itau.co','jbaracaldo','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,4,0,'asalgado','root@localhost','2021-05-06 22:20:42','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:20:42','INSERCION REGISTRO'),(30,562,'CC','79296043','Jesus Elias','Baracaldo Rojas',NULL,NULL,'jesus.baracaldo@itau.co','jbaracaldo','oWawmiVAYf5r+KMmVVXBrA==',NULL,0,0,'A','2021-05-06',0,NULL,'N',NULL,0,4,0,'asalgado','root@localhost','2021-05-06 22:20:42','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:20:42','ACTUALIZACION REGISTRO'),(31,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-06 17:10:08',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:22:23','ACTUALIZACION REGISTRO'),(32,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-06 17:10:08',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:22:53','ACTUALIZACION REGISTRO'),(33,561,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargasp','ts9EkKzm4yZppN759FQ7RQ==','2021-05-06 17:23:28',0,0,'A','2021-05-06',0,NULL,'N',NULL,0,2,0,'asalgado','root@localhost','2021-05-06 16:35:54','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:23:28','ACTUALIZACION REGISTRO'),(34,561,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargasp','fradazLeR6VlbGlfVkqhNw==','2021-05-06 17:23:28',0,0,'A','2021-05-06',0,NULL,'N',NULL,0,2,0,'asalgado','root@localhost','2021-05-06 16:35:54','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:24:19','ACTUALIZACION REGISTRO'),(35,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-06 17:25:01',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-06 22:25:01','ACTUALIZACION REGISTRO'),(36,562,'CC','79296043','Jesus Elias','Baracaldo Rojas',NULL,NULL,'jesus.baracaldo@itau.co','jbaracaldo','oWawmiVAYf5r+KMmVVXBrA==','2021-05-07 07:42:44',0,0,'A','2021-05-06',0,NULL,'N',NULL,0,4,0,'asalgado','root@localhost','2021-05-06 22:20:42','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 12:42:44','ACTUALIZACION REGISTRO'),(37,562,'CC','79296043','Jesus Elias','Baracaldo Rojas',NULL,NULL,'jesus.baracaldo@itau.co','jbaracaldo','ecCtCR1sIF76E1VT9iyuow==','2021-05-07 07:42:44',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,4,0,'asalgado','root@localhost','2021-05-06 22:20:42','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 12:43:24','ACTUALIZACION REGISTRO'),(38,563,'CC','39548480','Nelcy Patricia','Olaya Ramirez',NULL,NULL,'patricia.olaya@itau.co','no80196','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,4,0,'jbaracaldo','root@localhost','2021-05-07 13:14:02','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 13:14:02','INSERCION REGISTRO'),(39,563,'CC','39548480','Nelcy Patricia','Olaya Ramirez',NULL,NULL,'patricia.olaya@itau.co','no80196','vlmQwWHQIGUkxoXl1nhXiQ==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,4,0,'jbaracaldo','root@localhost','2021-05-07 13:14:02','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 13:14:02','ACTUALIZACION REGISTRO'),(40,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-06 08:34:59',0,0,'A','2021-05-06',1,NULL,'N','2021-05-07 08:52:31',0,10,0,'asalgado','root@localhost','2021-05-06 00:10:15','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 13:52:31','ACTUALIZACION REGISTRO'),(41,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 08:54:36',0,0,'A','2021-05-06',0,NULL,'N','2021-05-07 08:52:31',0,10,0,'asalgado','root@localhost','2021-05-06 00:10:15','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 13:54:36','ACTUALIZACION REGISTRO'),(42,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:03:44','INSERCION REGISTRO'),(43,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:03:44','ACTUALIZACION REGISTRO'),(44,565,'CC','71772039','JUAN DAVID','GONZALEZ OCHOA',NULL,NULL,'DAVIGONZ@BANCOLOMBIA.COM.CO','davigonz','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:06:11','INSERCION REGISTRO'),(45,565,'CC','71772039','JUAN DAVID','GONZALEZ OCHOA',NULL,NULL,'DAVIGONZ@BANCOLOMBIA.COM.CO','davigonz','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:06:11','ACTUALIZACION REGISTRO'),(46,566,'CC','98557761','JUAN MARTIN','CHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:07:46','INSERCION REGISTRO'),(47,566,'CC','98557761','JUAN MARTIN','CHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:07:46','ACTUALIZACION REGISTRO'),(48,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-06',1,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:20:04','ACTUALIZACION REGISTRO'),(49,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 09:20:31',0,0,'A','2021-05-06',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:20:31','ACTUALIZACION REGISTRO'),(50,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-07 09:20:31',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:21:22','ACTUALIZACION REGISTRO'),(51,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-07 09:33:53',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:33:53','ACTUALIZACION REGISTRO'),(52,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','dINycK6e/ItWFWlxSud23Q==','2021-05-04 16:54:01',0,0,'A','2021-05-04',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:37:25','ACTUALIZACION REGISTRO'),(53,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','xWTS7d5opJUHCB+f32QRbg==','2021-05-04 16:54:01',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:37:25','ACTUALIZACION REGISTRO'),(54,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 09:39:35',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:39:35','ACTUALIZACION REGISTRO'),(55,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','DQDX5FJc4+o0uG2sNcS23w==','2021-05-07 09:39:35',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:40:19','ACTUALIZACION REGISTRO'),(56,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-07 09:52:58',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:52:58','ACTUALIZACION REGISTRO'),(57,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','xWTS7d5opJUHCB+f32QRbg==','2021-05-04 16:54:01',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:55:07','ACTUALIZACION REGISTRO'),(58,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','nxu8W4P+LmVXd0uIN8B9tQ==','2021-05-04 16:54:01',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 14:55:07','ACTUALIZACION REGISTRO'),(59,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','nxu8W4P+LmVXd0uIN8B9tQ==','2021-05-07 11:08:23',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 16:08:23','ACTUALIZACION REGISTRO'),(60,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-07 11:08:23',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 16:09:12','ACTUALIZACION REGISTRO'),(61,565,'CC','71772039','JUAN DAVID','GONZALEZ OCHOA',NULL,NULL,'DAVIGONZ@BANCOLOMBIA.COM.CO','davigonz','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 13:56:31',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 18:56:31','ACTUALIZACION REGISTRO'),(62,565,'CC','71772039','JUAN DAVID','GONZALEZ OCHOA',NULL,NULL,'DAVIGONZ@BANCOLOMBIA.COM.CO','davigonz','CL6eD/D3c1+FO7oA4zgMFA==','2021-05-07 13:56:31',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:06:11','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 18:57:06','ACTUALIZACION REGISTRO'),(63,558,'CC','43749812','Maria Sorelli','Uribe Ramirez',NULL,NULL,'suribe@globalcdb.com','suribe','SopWXS9I9ma8xEaS+EVs/g==','2021-05-07 13:59:06',0,0,'A','2021-05-05',0,NULL,'N',NULL,0,51,0,'esouza','root@localhost','2021-05-05 17:37:55','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 18:59:06','ACTUALIZACION REGISTRO'),(64,558,'CC','43749812','Maria Sorelli','Uribe Ramirez',NULL,NULL,'suribe@globalcdb.com','suribe','20tuckmAjA2aEM5KM/BvLw==','2021-05-07 13:59:06',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,51,0,'esouza','root@localhost','2021-05-05 17:37:55','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:01:01','ACTUALIZACION REGISTRO'),(65,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-07 14:10:35',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:10:35','ACTUALIZACION REGISTRO'),(66,567,'CC','43749812','maria sorelly','uribe ramirez',NULL,NULL,'suribe@globalcdb.com','suribera','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,51,0,'suribe','root@localhost','2021-05-07 19:10:50','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:10:50','INSERCION REGISTRO'),(67,567,'CC','43749812','maria sorelly','uribe ramirez',NULL,NULL,'suribe@globalcdb.com','suribera','8HZVDBgNSAHxoPJHRCP5Jw==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,51,0,'suribe','root@localhost','2021-05-07 19:10:50','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:10:50','ACTUALIZACION REGISTRO'),(68,567,'CC','43749812','maria sorelly','uribe ramirez',NULL,NULL,'suribe@globalcdb.com','suribera','8HZVDBgNSAHxoPJHRCP5Jw==',NULL,0,0,'A','2021-05-07',1,NULL,'N','2021-05-07 14:11:48',0,51,0,'suribe','root@localhost','2021-05-07 19:10:50','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:11:48','ACTUALIZACION REGISTRO'),(69,567,'CC','43749812','maria sorelly','uribe ramirez',NULL,NULL,'suribe@globalcdb.com','suribera','8HZVDBgNSAHxoPJHRCP5Jw==','2021-05-07 14:12:11',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 14:11:48',0,51,0,'suribe','root@localhost','2021-05-07 19:10:50','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:12:11','ACTUALIZACION REGISTRO'),(70,567,'CC','43749812','maria sorelly','uribe ramirez',NULL,NULL,'suribe@globalcdb.com','suribera','M0uIdPstua+zugK/KydUXQ==','2021-05-07 14:12:11',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 14:11:48',0,51,0,'suribe','root@localhost','2021-05-07 19:10:50','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:13:25','ACTUALIZACION REGISTRO'),(71,561,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargasp','fradazLeR6VlbGlfVkqhNw==','2021-05-07 14:26:53',0,0,'A','2021-05-06',0,NULL,'N',NULL,0,2,0,'asalgado','root@localhost','2021-05-06 16:35:54','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:26:53','ACTUALIZACION REGISTRO'),(72,568,'CC','1016023999','USUARIO PRUEBAS ','BVC',NULL,NULL,'cvargas@bvc.com.co','prueba1','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'cvargasp','root@localhost','2021-05-07 19:33:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:33:46','INSERCION REGISTRO'),(73,568,'CC','1016023999','USUARIO PRUEBAS ','BVC',NULL,NULL,'cvargas@bvc.com.co','prueba1','fradazLeR6VlbGlfVkqhNw==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,2,0,'cvargasp','root@localhost','2021-05-07 19:33:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:33:46','ACTUALIZACION REGISTRO'),(74,568,'CC','1016023999','USUARIO PRUEBAS ','BVC',NULL,NULL,'cvargas@bvc.com.co','prueba1','fradazLeR6VlbGlfVkqhNw==','2021-05-07 14:34:19',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,2,0,'cvargasp','root@localhost','2021-05-07 19:33:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:34:19','ACTUALIZACION REGISTRO'),(75,568,'CC','1016023999','USUARIO PRUEBAS ','BVC',NULL,NULL,'cvargas@bvc.com.co','prueba1','LIm7lXUSlBmWVKJnb9fLXA==','2021-05-07 14:34:19',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,2,0,'cvargasp','root@localhost','2021-05-07 19:33:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 19:35:06','ACTUALIZACION REGISTRO'),(76,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-07 15:28:33',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:28:33','ACTUALIZACION REGISTRO'),(77,569,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','kpanader','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'esouza','root@localhost','2021-05-07 20:32:07','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:32:07','INSERCION REGISTRO'),(78,569,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','kpanader','/3t/LRO3pN8F5Eh1mC7nCg==',NULL,0,0,'A','2021-05-07',0,NULL,'N',NULL,0,18,0,'esouza','root@localhost','2021-05-07 20:32:07','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:32:07','ACTUALIZACION REGISTRO'),(79,563,'CC','39548480','Nelcy Patricia','Olaya Ramirez',NULL,NULL,'patricia.olaya@itau.co','no80196','vlmQwWHQIGUkxoXl1nhXiQ==','2021-05-07 15:38:27',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,4,0,'jbaracaldo','root@localhost','2021-05-07 13:14:02','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 20:38:27','ACTUALIZACION REGISTRO'),(80,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-07 17:13:25',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-07 22:13:25','ACTUALIZACION REGISTRO'),(81,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-10 08:04:22',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 13:04:22','ACTUALIZACION REGISTRO'),(82,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-10 08:08:13',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 13:08:13','ACTUALIZACION REGISTRO'),(83,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-10 13:35:50',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 18:35:50','ACTUALIZACION REGISTRO'),(84,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-10 17:43:43',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 22:43:43','ACTUALIZACION REGISTRO'),(85,570,'CC','52449048','Mildre Stella','Castaneda Moreno',NULL,NULL,'mcastaneda@credicorpcapital.com','mcastaneda','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'esouza','root@localhost','2021-05-10 22:48:30','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 22:48:30','INSERCION REGISTRO'),(86,570,'CC','52449048','Mildre Stella','Castaneda Moreno',NULL,NULL,'mcastaneda@credicorpcapital.com','mcastaneda','awHZux86ktw+71Dg3IJo7g==',NULL,0,0,'A','2021-05-10',0,NULL,'N',NULL,0,29,0,'esouza','root@localhost','2021-05-10 22:48:30','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-10 22:48:30','ACTUALIZACION REGISTRO'),(87,570,'CC','52449048','Mildre Stella','Castaneda Moreno',NULL,NULL,'mcastaneda@credicorpcapital.com','mcastaneda','awHZux86ktw+71Dg3IJo7g==','2021-05-11 08:25:05',0,0,'A','2021-05-10',0,NULL,'N',NULL,0,29,0,'esouza','root@localhost','2021-05-10 22:48:30','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:25:05','ACTUALIZACION REGISTRO'),(88,570,'CC','52449048','Mildre Stella','Castaneda Moreno',NULL,NULL,'mcastaneda@credicorpcapital.com','mcastaneda','v26ni6slTI4k3i3Hwo8TGQ==','2021-05-11 08:25:05',0,0,'A','2021-05-11',0,NULL,'N',NULL,0,29,0,'esouza','root@localhost','2021-05-10 22:48:30','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:26:35','ACTUALIZACION REGISTRO'),(89,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:31:37','INSERCION REGISTRO'),(90,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','QIuST2aZPsuWJxL2KawfdQ==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:31:37','ACTUALIZACION REGISTRO'),(91,572,'CC','52498069','Sandra Liliana','Franco Mancipe',NULL,NULL,'sfranco@credicorpcapital.com','sfranco','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:33:21','INSERCION REGISTRO'),(92,572,'CC','52498069','Sandra Liliana','Franco Mancipe',NULL,NULL,'sfranco@credicorpcapital.com','sfranco','QIuST2aZPsuWJxL2KawfdQ==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,29,0,'mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 13:33:21','ACTUALIZACION REGISTRO'),(93,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','QIuST2aZPsuWJxL2KawfdQ==',NULL,0,0,'A','2021-05-11',1,NULL,'N','2021-05-11 11:34:22',0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:34:22','ACTUALIZACION REGISTRO'),(94,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','QIuST2aZPsuWJxL2KawfdQ==','2021-05-11 11:34:44',0,0,'A','2021-05-11',0,NULL,'N','2021-05-11 11:34:22',0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:34:44','ACTUALIZACION REGISTRO'),(95,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','TfotpZRL2bdatApm/xlzKA==','2021-05-11 11:34:44',0,0,'A','2021-05-11',0,NULL,'N','2021-05-11 11:34:22',0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:35:27','ACTUALIZACION REGISTRO'),(96,569,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','kpanader','/3t/LRO3pN8F5Eh1mC7nCg==','2021-05-11 11:48:59',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,18,0,'esouza','root@localhost','2021-05-07 20:32:07','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:48:59','ACTUALIZACION REGISTRO'),(97,569,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','kpanader','ujNW8yVDsYi8pN4BrR48bg==','2021-05-11 11:48:59',0,0,'A','2021-05-11',0,NULL,'N',NULL,0,18,0,'esouza','root@localhost','2021-05-07 20:32:07','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:49:59','ACTUALIZACION REGISTRO'),(98,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:51:14','INSERCION REGISTRO'),(99,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:51:14','ACTUALIZACION REGISTRO'),(100,574,'CC','80501110','David','Abril Garcia',NULL,NULL,'dabril@alianza.com.co','dabril','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'kpanader','root@localhost','2021-05-11 16:54:13','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:54:13','INSERCION REGISTRO'),(101,574,'CC','80501110','David','Abril Garcia',NULL,NULL,'dabril@alianza.com.co','dabril','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,18,0,'kpanader','root@localhost','2021-05-11 16:54:13','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 16:54:13','ACTUALIZACION REGISTRO'),(102,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-11 13:21:17',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 18:21:17','ACTUALIZACION REGISTRO'),(103,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-11 16:59:06',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 21:59:06','ACTUALIZACION REGISTRO'),(104,575,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','ecastaneda','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,50,0,'esouza','root@localhost','2021-05-11 22:10:29','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 22:10:29','INSERCION REGISTRO'),(105,575,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','ecastaneda','qlbW0YjaIOHzBNC7NJkNjQ==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,50,0,'esouza','root@localhost','2021-05-11 22:10:29','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-11 22:10:29','ACTUALIZACION REGISTRO'),(106,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-12 09:13:43',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-12 14:13:43','ACTUALIZACION REGISTRO'),(107,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-12 13:17:47',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-12 18:17:47','ACTUALIZACION REGISTRO'),(108,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-13 10:55:37',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 15:55:37','ACTUALIZACION REGISTRO'),(109,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'A','2021-05-11',1,NULL,'N','2021-05-13 12:07:03',0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:07:03','ACTUALIZACION REGISTRO'),(110,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'A','2021-05-11',2,NULL,'N','2021-05-13 12:09:11',0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:09:11','ACTUALIZACION REGISTRO'),(111,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'B','2021-05-11',2,NULL,'N','2021-05-13 12:09:11',0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:09:11','ACTUALIZACION REGISTRO'),(112,569,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','kpanader','ujNW8yVDsYi8pN4BrR48bg==','2021-05-13 12:22:37',0,0,'A','2021-05-11',0,NULL,'N',NULL,0,18,0,'esouza','root@localhost','2021-05-07 20:32:07','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:22:37','ACTUALIZACION REGISTRO'),(113,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'A','2021-05-11',0,NULL,'N','2021-05-13 12:09:11',0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:23:25','ACTUALIZACION REGISTRO'),(114,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','ujNW8yVDsYi8pN4BrR48bg==','2021-05-13 12:26:00',0,0,'A','2021-05-11',0,NULL,'N','2021-05-13 12:09:11',0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:26:00','ACTUALIZACION REGISTRO'),(115,573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','XlsRb7RE16X2iMjiVp1ltg==','2021-05-13 12:26:00',0,0,'A','2021-05-13',0,NULL,'N','2021-05-13 12:09:11',0,18,0,'kpanader','root@localhost','2021-05-11 16:51:14','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 17:27:06','ACTUALIZACION REGISTRO'),(116,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-13 13:09:26',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-13 18:09:26','ACTUALIZACION REGISTRO'),(117,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-14 09:09:14',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 14:09:14','ACTUALIZACION REGISTRO'),(118,572,'CC','52498069','Sandra Liliana','Franco Mancipe',NULL,NULL,'sfranco@credicorpcapital.com','sfranco','QIuST2aZPsuWJxL2KawfdQ==','2021-05-14 10:27:24',0,0,'A','2021-05-11',0,NULL,'N',NULL,0,29,0,'mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 15:27:24','ACTUALIZACION REGISTRO'),(119,572,'CC','52498069','Sandra Liliana','Franco Mancipe',NULL,NULL,'sfranco@credicorpcapital.com','sfranco','J9VoQSEQUBnT6xyMHWxbXg==','2021-05-14 10:27:24',0,0,'A','2021-05-14',0,NULL,'N',NULL,0,29,0,'mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 15:27:59','ACTUALIZACION REGISTRO'),(120,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-14 13:17:38',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 18:17:38','ACTUALIZACION REGISTRO'),(121,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-14 16:20:57',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 21:20:57','ACTUALIZACION REGISTRO'),(122,576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,7,0,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 21:24:26','INSERCION REGISTRO'),(123,576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','dmryWGQPAc530sqxyLDjkA==',NULL,0,0,'A','2021-05-14',0,NULL,'N',NULL,0,7,0,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-14 21:24:26','ACTUALIZACION REGISTRO'),(124,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-18 11:51:39',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-18 16:51:39','ACTUALIZACION REGISTRO'),(125,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-18 13:01:51',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-18 18:01:51','ACTUALIZACION REGISTRO'),(126,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','TfotpZRL2bdatApm/xlzKA==','2021-05-19 11:42:33',0,0,'A','2021-05-11',0,NULL,'N','2021-05-11 11:34:22',0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-19 16:42:33','ACTUALIZACION REGISTRO'),(127,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-19 13:52:10',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-19 18:52:10','ACTUALIZACION REGISTRO'),(128,576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','dmryWGQPAc530sqxyLDjkA==','2021-05-20 08:20:49',0,0,'A','2021-05-14',0,NULL,'N',NULL,0,7,0,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 13:20:49','ACTUALIZACION REGISTRO'),(129,576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','337vhg6opYH9t2ZEjnB6dA==','2021-05-20 08:20:49',0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 13:21:08','ACTUALIZACION REGISTRO'),(130,577,'CC','79399904','Jose Ricardo ','Sanchez Martinez ',NULL,NULL,'jose.sanchez@accivalores.com','jsanchez','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 13:45:23','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 13:45:23','INSERCION REGISTRO'),(131,577,'CC','79399904','Jose Ricardo ','Sanchez Martinez ',NULL,NULL,'jose.sanchez@accivalores.com','jsanchez','8J8wbRQcgeyVAy5WMgTFwg==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 13:45:23','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 13:45:23','ACTUALIZACION REGISTRO'),(132,577,'CC','79399904','Jose Ricardo ','Sanchez Martinez ',NULL,NULL,'jose.sanchez@accivalores.com','jsanchez','8J8wbRQcgeyVAy5WMgTFwg==',NULL,0,0,'A','2021-05-20',1,NULL,'N','2021-05-20 09:03:03',0,7,0,'cblanco','root@localhost','2021-05-20 13:45:23','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:03:03','ACTUALIZACION REGISTRO'),(133,577,'CC','79399904','Jose Ricardo ','Sanchez Martinez ',NULL,NULL,'jose.sanchez@accivalores.com','jsanchez','8J8wbRQcgeyVAy5WMgTFwg==','2021-05-20 09:04:07',0,0,'A','2021-05-20',0,NULL,'N','2021-05-20 09:03:03',0,7,0,'cblanco','root@localhost','2021-05-20 13:45:23','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:04:07','ACTUALIZACION REGISTRO'),(134,577,'CC','79399904','Jose Ricardo ','Sanchez Martinez ',NULL,NULL,'jose.sanchez@accivalores.com','jsanchez','a7xxPpAqmTsPbdf+JE06UQ==','2021-05-20 09:04:07',0,0,'A','2021-05-20',0,NULL,'N','2021-05-20 09:03:03',0,7,0,'cblanco','root@localhost','2021-05-20 13:45:23','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:05:00','ACTUALIZACION REGISTRO'),(135,576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','337vhg6opYH9t2ZEjnB6dA==','2021-05-20 09:08:07',0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:08:07','ACTUALIZACION REGISTRO'),(136,578,'CC','79403609','Mauricio Alberto ','Celis Rivera ',NULL,NULL,'mauricio.celis@accivalores.com','mcelis','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:34:18','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:34:18','INSERCION REGISTRO'),(137,578,'CC','79403609','Mauricio Alberto ','Celis Rivera ',NULL,NULL,'mauricio.celis@accivalores.com','mcelis','mwrh6szDPAuDFV6OU509Gg==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:34:18','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:34:18','ACTUALIZACION REGISTRO'),(138,579,'CC','1010223672','Maria Alexandra ','Cely Martin',NULL,NULL,'alexandra.celym@accivalores.com','acely','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:39:01','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:39:01','INSERCION REGISTRO'),(139,579,'CC','1010223672','Maria Alexandra ','Cely Martin',NULL,NULL,'alexandra.celym@accivalores.com','acely','oSugEAXZUpTsOWMnAdFztw==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:39:01','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:39:01','ACTUALIZACION REGISTRO'),(140,580,'CC','51993518','Carolina ','Bustamante Antolines',NULL,NULL,'carolina.bustamante@accivalores.com','cbustamante','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:47:01','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:47:01','INSERCION REGISTRO'),(141,580,'CC','51993518','Carolina ','Bustamante Antolines',NULL,NULL,'carolina.bustamante@accivalores.com','cbustamante','h5jyHspbGLL9SPdnXhSk4g==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:47:01','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 14:47:01','ACTUALIZACION REGISTRO'),(142,571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','TfotpZRL2bdatApm/xlzKA==','2021-05-20 11:38:54',0,0,'A','2021-05-11',0,NULL,'N','2021-05-11 11:34:22',0,29,0,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 16:38:54','ACTUALIZACION REGISTRO'),(143,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-20 13:20:39',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-20 18:20:39','ACTUALIZACION REGISTRO'),(144,576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','337vhg6opYH9t2ZEjnB6dA==','2021-05-21 09:11:29',0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 14:11:29','ACTUALIZACION REGISTRO'),(145,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-21 10:11:02',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:11:02','ACTUALIZACION REGISTRO'),(146,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 08:54:36',0,0,'A','2021-05-06',0,NULL,'N','2021-05-07 08:52:31',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','ACTUALIZACION REGISTRO'),(147,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','xWTS7d5opJUHCB+f32QRbg==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-07 08:52:31',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:13:24','ACTUALIZACION REGISTRO'),(148,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','xWTS7d5opJUHCB+f32QRbg==','2021-05-07 08:54:36',0,0,'A','2021-05-21',1,NULL,'N','2021-05-21 10:17:10',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:17:10','ACTUALIZACION REGISTRO'),(149,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','xWTS7d5opJUHCB+f32QRbg==','2021-05-07 08:54:36',0,0,'A','2021-05-21',2,NULL,'N','2021-05-21 10:17:26',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:17:26','ACTUALIZACION REGISTRO'),(150,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','xWTS7d5opJUHCB+f32QRbg==','2021-05-07 08:54:36',0,0,'B','2021-05-21',2,NULL,'N','2021-05-21 10:17:26',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:17:26','ACTUALIZACION REGISTRO'),(151,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','xWTS7d5opJUHCB+f32QRbg==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 10:17:26',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','ACTUALIZACION REGISTRO'),(152,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','AtYRL9mDSSqa9Phkkn19kw==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 10:17:26',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 15:25:08','ACTUALIZACION REGISTRO'),(153,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:01:59','INSERCION REGISTRO'),(154,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','/3t/LRO3pN8F5Eh1mC7nCg==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:01:59','ACTUALIZACION REGISTRO'),(155,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','/3t/LRO3pN8F5Eh1mC7nCg==',NULL,0,0,'A','2021-05-21',1,NULL,'N','2021-05-21 11:11:31',0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:11:31','ACTUALIZACION REGISTRO'),(156,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','/3t/LRO3pN8F5Eh1mC7nCg==','2021-05-21 11:12:12',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:11:31',0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:12:12','ACTUALIZACION REGISTRO'),(157,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-21 11:12:12',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:11:31',0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:12:55','ACTUALIZACION REGISTRO'),(158,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','AtYRL9mDSSqa9Phkkn19kw==','2021-05-07 08:54:36',0,0,'A','2021-05-21',1,NULL,'N','2021-05-21 11:14:28',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:14:28','ACTUALIZACION REGISTRO'),(159,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','AtYRL9mDSSqa9Phkkn19kw==','2021-05-07 08:54:36',0,0,'A','2021-05-21',2,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:16:30','ACTUALIZACION REGISTRO'),(160,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','AtYRL9mDSSqa9Phkkn19kw==','2021-05-07 08:54:36',0,0,'B','2021-05-21',2,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:16:30','ACTUALIZACION REGISTRO'),(161,582,'CC','1015440542','DIANA','GOMEZ',NULL,NULL,'dgomez@corredores.com','dgomez','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:17:31','INSERCION REGISTRO'),(162,582,'CC','1015440542','DIANA','GOMEZ',NULL,NULL,'dgomez@corredores.com','dgomez','/XX8QKphJAfe2/0UXrajWg==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:17:31','ACTUALIZACION REGISTRO'),(163,582,'CC','1015440542','DIANA','GOMEZ',NULL,NULL,'dgomez@corredores.com','dgomez','/XX8QKphJAfe2/0UXrajWg==','2021-05-21 11:22:16',0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:22:16','ACTUALIZACION REGISTRO'),(164,582,'CC','1015440542','DIANA','GOMEZ',NULL,NULL,'dgomez@corredores.com','dgomez','ZXOjPtnbHyaiBDbuu6clcw==','2021-05-21 11:22:16',0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:24:26','ACTUALIZACION REGISTRO'),(165,583,'CC','1072661774','ANDRES FELIPE','MONTENEGRO',NULL,NULL,'amontenegro@corredores.com','amontenegro','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:28:32','INSERCION REGISTRO'),(166,583,'CC','1072661774','ANDRES FELIPE','MONTENEGRO',NULL,NULL,'amontenegro@corredores.com','amontenegro','V+A8x456PrGD2aR2GWLjNA==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:28:32','ACTUALIZACION REGISTRO'),(167,584,'CC','1019046700','JHON JAIRO','PERILLA',NULL,NULL,'jjperilla@corredores.com','jperilla','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:30:45','INSERCION REGISTRO'),(168,584,'CC','1019046700','JHON JAIRO','PERILLA',NULL,NULL,'jjperilla@corredores.com','jperilla','9j16riYoBKvARA8kPALf1Q==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:30:45','ACTUALIZACION REGISTRO'),(169,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:32:48','INSERCION REGISTRO'),(170,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','F4Xh1mO3NS23Ai014obSZQ==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:32:48','ACTUALIZACION REGISTRO'),(171,586,'CC','1026563621','PAULA ','LUQUE',NULL,NULL,'pluque@corredores.com','pluque','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:34:40','INSERCION REGISTRO'),(172,586,'CC','1026563621','PAULA ','LUQUE',NULL,NULL,'pluque@corredores.com','pluque','WQrlqQW5zQXFa8ewFawPdw==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:34:40','ACTUALIZACION REGISTRO'),(173,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-05-21 11:35:59',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:35:59','ACTUALIZACION REGISTRO'),(174,587,'CC','80871119','CAMILO ','FORERO',NULL,NULL,'CFORERO@CORREDORES.COM','cforero','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:36:19','INSERCION REGISTRO'),(175,587,'CC','80871119','CAMILO ','FORERO',NULL,NULL,'CFORERO@CORREDORES.COM','cforero','dNXH4/dzOo/tHGPcxxtHHQ==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:36:19','ACTUALIZACION REGISTRO'),(176,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','F4Xh1mO3NS23Ai014obSZQ==',NULL,0,0,'A','2021-05-21',1,NULL,'N','2021-05-21 11:37:44',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:37:44','ACTUALIZACION REGISTRO'),(177,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','AtYRL9mDSSqa9Phkkn19kw==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','ACTUALIZACION REGISTRO'),(178,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','SopWXS9I9ma8xEaS+EVs/g==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:12','ACTUALIZACION REGISTRO'),(179,588,'CC','94536699','ANDRES','AVILA',NULL,NULL,'aavila@corredores.com','aavila','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:14','INSERCION REGISTRO'),(180,588,'CC','94536699','ANDRES','AVILA',NULL,NULL,'aavila@corredores.com','aavila','i9H2c/BOphj60kh68Gj73g==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:38:14','ACTUALIZACION REGISTRO'),(181,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','F4Xh1mO3NS23Ai014obSZQ==',NULL,0,0,'A','2021-05-21',2,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:41:42','ACTUALIZACION REGISTRO'),(182,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','F4Xh1mO3NS23Ai014obSZQ==',NULL,0,0,'B','2021-05-21',2,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:41:42','ACTUALIZACION REGISTRO'),(183,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','F4Xh1mO3NS23Ai014obSZQ==',NULL,0,0,'B','2021-05-21',0,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','ACTUALIZACION REGISTRO'),(184,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','zMbMHYC7ThgwNvMuYItQSg==',NULL,0,0,'B','2021-05-21',0,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:43:35','ACTUALIZACION REGISTRO'),(185,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','zMbMHYC7ThgwNvMuYItQSg==',NULL,0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:22','ACTUALIZACION REGISTRO'),(186,566,'CC','98557761','JUAN MARTIN','CHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-07',1,NULL,'N','2021-05-21 11:48:49',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:48:49','ACTUALIZACION REGISTRO'),(187,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','zMbMHYC7ThgwNvMuYItQSg==','2021-05-21 11:49:25',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:49:25','ACTUALIZACION REGISTRO'),(188,566,'CC','98557761','JUAN MARTIN','CHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-07',2,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:49:28','ACTUALIZACION REGISTRO'),(189,566,'CC','98557761','JUAN MARTIN','CHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'B','2021-05-07',2,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:49:28','ACTUALIZACION REGISTRO'),(190,585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','6rvIrVZlrv6QyYD3MWdlyQ==','2021-05-21 11:49:25',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:41:42',0,2,0,'asepulveda','root@localhost','2021-05-21 16:32:48','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 16:50:58','ACTUALIZACION REGISTRO'),(191,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','SopWXS9I9ma8xEaS+EVs/g==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','ACTUALIZACION REGISTRO'),(192,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','6b2IxaVZlScyXhsMYDIYcg==','2021-05-07 08:54:36',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:05:55','ACTUALIZACION REGISTRO'),(193,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','6b2IxaVZlScyXhsMYDIYcg==','2021-05-21 12:11:25',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:11:25','ACTUALIZACION REGISTRO'),(194,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:11:25',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:12','ACTUALIZACION REGISTRO'),(195,565,'CC','71772039','JUAN DAVID','GONZALEZ OCHOA',NULL,NULL,'DAVIGONZ@BANCOLOMBIA.COM.CO','davigonz','CL6eD/D3c1+FO7oA4zgMFA==','2021-05-07 13:56:31',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:06:11','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:12:54','ACTUALIZACION REGISTRO'),(196,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','DQDX5FJc4+o0uG2sNcS23w==','2021-05-07 09:39:35',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:13:18','ACTUALIZACION REGISTRO'),(197,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-14 09:09:14',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:40','ACTUALIZACION REGISTRO'),(198,566,'CC','98557761','JUAN MARTIN','CHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'B','2021-05-07',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:14:52','ACTUALIZACION REGISTRO'),(199,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'B','2021-05-07',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:07','ACTUALIZACION REGISTRO'),(200,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'B','2021-05-07',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','ACTUALIZACION REGISTRO'),(201,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'B','2021-05-21',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:15:54','ACTUALIZACION REGISTRO'),(202,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-21 12:16:57',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:16:57','ACTUALIZACION REGISTRO'),(203,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:23:04',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:23:04','ACTUALIZACION REGISTRO'),(204,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','gXYYK5QxPvk6K1vhpetrNQ==',NULL,0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','ACTUALIZACION REGISTRO'),(205,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','UItP8ea8fjRGS9vVUNfOTw==',NULL,0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:24:11','ACTUALIZACION REGISTRO'),(206,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','UItP8ea8fjRGS9vVUNfOTw==','2021-05-21 12:29:16',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:29:16','ACTUALIZACION REGISTRO'),(207,566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','IEHlf4eET42NKGEUygkKZQ==','2021-05-21 12:29:16',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:49:28',0,10,0,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 17:29:46','ACTUALIZACION REGISTRO'),(208,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-21 13:17:01',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 18:17:01','ACTUALIZACION REGISTRO'),(209,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-21 13:22:22',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-21 18:22:22','ACTUALIZACION REGISTRO'),(210,559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-24 09:10:29',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,0,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:10:29','ACTUALIZACION REGISTRO'),(211,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','VobFMQABC6iiqQdyKNlGvw==','2021-05-21 12:16:57',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','ACTUALIZACION REGISTRO'),(212,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','WT9dyp9Q7r3iG6vMiAtAYA==','2021-05-21 12:16:57',0,0,'A','2021-05-24',0,NULL,'N','2021-05-07 09:20:04',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:13:56','ACTUALIZACION REGISTRO'),(213,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','WT9dyp9Q7r3iG6vMiAtAYA==','2021-05-21 12:16:57',0,0,'A','2021-05-24',1,NULL,'N','2021-05-24 09:15:33',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:15:33','ACTUALIZACION REGISTRO'),(214,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','WT9dyp9Q7r3iG6vMiAtAYA==','2021-05-21 12:16:57',0,0,'A','2021-05-24',2,NULL,'N','2021-05-24 09:22:07',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:22:07','ACTUALIZACION REGISTRO'),(215,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','WT9dyp9Q7r3iG6vMiAtAYA==','2021-05-21 12:16:57',0,0,'B','2021-05-24',2,NULL,'N','2021-05-24 09:22:07',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:22:07','ACTUALIZACION REGISTRO'),(216,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','WT9dyp9Q7r3iG6vMiAtAYA==','2021-05-21 12:16:57',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:22:07',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','ACTUALIZACION REGISTRO'),(217,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:16:57',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:22:07',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:24:16','ACTUALIZACION REGISTRO'),(218,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:16:57',0,0,'A','2021-05-24',1,NULL,'N','2021-05-24 09:28:19',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:28:19','ACTUALIZACION REGISTRO'),(219,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:16:57',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:28:19',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:30:51','ACTUALIZACION REGISTRO'),(220,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:16:57',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:28:19',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:35:27','ACTUALIZACION REGISTRO'),(221,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-24 09:37:06',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:28:19',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:37:06','ACTUALIZACION REGISTRO'),(222,560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','hwKIlqo4euG5bgTEmRIf9Q==','2021-05-24 09:37:06',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:28:19',0,10,0,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:37:39','ACTUALIZACION REGISTRO'),(223,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','DQDX5FJc4+o0uG2sNcS23w==','2021-05-07 09:39:35',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','ACTUALIZACION REGISTRO'),(224,564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 09:39:35',0,0,'A','2021-05-24',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 14:38:54','ACTUALIZACION REGISTRO'),(225,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-21 11:12:12',0,0,'A','2021-05-21',1,NULL,'N','2021-05-24 12:10:52',0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:10:52','ACTUALIZACION REGISTRO'),(226,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-21 11:12:12',0,0,'A','2021-05-21',2,NULL,'N','2021-05-24 12:11:10',0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:11:10','ACTUALIZACION REGISTRO'),(227,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-21 11:12:12',0,0,'B','2021-05-21',2,NULL,'N','2021-05-24 12:11:10',0,2,0,'esouza','root@localhost','2021-05-21 16:01:59','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:11:10','ACTUALIZACION REGISTRO'),(228,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','FZyWO/WI7PgeriB8YfNs1w==','2021-05-24 12:28:08',0,0,'A','2021-05-04',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:28:08','ACTUALIZACION REGISTRO'),(229,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','Pfk1tp2FQ46A+k8vXv4sjQ==','2021-05-24 12:28:08',0,0,'A','2021-05-24',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:28:46','ACTUALIZACION REGISTRO'),(230,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-21 11:12:12',0,0,'A','2021-05-21',0,NULL,'N','2021-05-24 12:11:10',0,2,0,'asalgado','root@localhost','2021-05-21 16:01:59','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:14','ACTUALIZACION REGISTRO'),(231,581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-24 12:29:59',0,0,'A','2021-05-21',0,NULL,'N','2021-05-24 12:11:10',0,2,0,'asalgado','root@localhost','2021-05-21 16:01:59','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 17:29:59','ACTUALIZACION REGISTRO'),(232,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-24 13:13:15',0,0,'A','2021-05-05',0,NULL,'N','2020-12-01 13:23:26',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 18:13:15','ACTUALIZACION REGISTRO'),(233,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-24 13:45:08',0,0,'A','2021-05-07',0,NULL,'N','2020-12-10 15:07:58',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-24 18:45:08','ACTUALIZACION REGISTRO'),(234,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-24 13:13:15',0,0,'A','2021-05-05',1,NULL,'N','2021-05-25 10:10:37',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-25 15:10:37','ACTUALIZACION REGISTRO'),(235,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','0WT+HP0ems3hvs9TtitXAg==','2021-05-25 10:10:50',0,0,'A','2021-05-05',0,NULL,'N','2021-05-25 10:10:37',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-25 15:10:50','ACTUALIZACION REGISTRO'),(236,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','jvPoQG9oL10VSF2TtFV3TA==','2021-05-25 10:10:50',0,0,'A','2021-05-25',0,NULL,'N','2021-05-25 10:10:37',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-25 15:11:32','ACTUALIZACION REGISTRO'),(237,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','jvPoQG9oL10VSF2TtFV3TA==','2021-05-27 10:40:52',0,0,'A','2021-05-25',0,NULL,'N','2021-05-25 10:10:37',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 15:40:52','ACTUALIZACION REGISTRO'),(238,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','jvPoQG9oL10VSF2TtFV3TA==','2021-05-27 13:14:27',0,0,'A','2021-05-25',0,NULL,'N','2021-05-25 10:10:37',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-05-27 18:14:27','ACTUALIZACION REGISTRO'),(239,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-07-09 08:38:16',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','opaunoapp@ip-10-120-49-216.ec2.internal','2021-07-09 13:38:20','ACTUALIZACION REGISTRO'),(240,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','jvPoQG9oL10VSF2TtFV3TA==','2021-05-27 13:14:27',0,0,'A','2021-05-25',1,NULL,'N','2021-07-19 16:49:00',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-216.ec2.internal','2021-07-19 21:49:10','ACTUALIZACION REGISTRO'),(241,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','jvPoQG9oL10VSF2TtFV3TA==','2021-07-19 16:49:50',0,0,'A','2021-05-25',0,NULL,'N','2021-07-19 16:49:00',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-216.ec2.internal','2021-07-19 21:50:00','ACTUALIZACION REGISTRO'),(242,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','HuXngpc9FLtkP8E9Zv/Jwg==','2021-07-19 16:49:50',0,0,'A','2021-07-19',0,NULL,'N','2021-07-19 16:49:00',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-216.ec2.internal','2021-07-19 21:50:23','ACTUALIZACION REGISTRO'),(243,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-07-09 08:38:16',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','root@localhost','2021-07-22 20:50:25','ACTUALIZACION REGISTRO'),(244,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','UxRAI9pEq9wFYfnXAB36Ww==','2021-07-09 08:38:16',0,0,'A','2021-05-05',0,NULL,'N','2021-03-12 07:33:25',0,90,0,'admin','root@localhost','2018-02-22 02:00:56','ModificaciÃƒÂ³n Usuario - ModificaciÃƒÂ³n','root@localhost','2021-07-22 20:57:37','ACTUALIZACION REGISTRO'),(245,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','HuXngpc9FLtkP8E9Zv/Jwg==','2021-07-22 16:37:09',0,0,'A','2021-07-19',0,NULL,'N','2021-07-19 16:49:00',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-216.ec2.internal','2021-07-22 21:37:09','ACTUALIZACION REGISTRO'),(246,448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','HuXngpc9FLtkP8E9Zv/Jwg==','2021-07-22 16:37:09',0,0,'A','2021-07-19',1,NULL,'N','2021-11-03 15:18:06',0,90,0,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-11-03 20:18:05','ACTUALIZACION REGISTRO'),(247,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','Pfk1tp2FQ46A+k8vXv4sjQ==','2021-11-24 15:45:22',0,0,'A','2021-05-24',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-11-24 20:45:22','ACTUALIZACION REGISTRO'),(248,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','AaZd0Wzx5lbhvii+8+NjiQ==','2021-11-24 15:45:22',0,0,'A','2021-11-24',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-11-24 20:45:53','ACTUALIZACION REGISTRO'),(249,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','AaZd0Wzx5lbhvii+8+NjiQ==','2021-12-01 12:46:05',0,0,'A','2021-11-24',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-01 17:46:06','ACTUALIZACION REGISTRO'),(250,530,'CC','1020821622','Lina Maria','Rodriguez Hernandez',NULL,NULL,'lina.rodriguez@bvc.com.co','lrodriguez','2u6ij/RR62FB+QMd5sTHVg==','2020-11-13 09:51:45',0,0,'A','2020-11-10',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2020-11-10 17:31:39','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-01 17:46:45','ACTUALIZACION REGISTRO'),(251,530,'CC','1020821622','Lina Maria','Rodriguez Hernandez',NULL,NULL,'lina.rodriguez@bvc.com.co','lrodriguez','ReOW011NDgnT502XPvIU0g==','2020-11-13 09:51:45',0,0,'A','2021-12-01',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2020-11-10 17:31:39','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-01 17:46:45','ACTUALIZACION REGISTRO'),(252,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-24 13:45:08',0,0,'A','2021-05-07',1,NULL,'N','2021-12-03 11:58:39',0,90,0,'esouza','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 16:58:38','ACTUALIZACION REGISTRO'),(253,259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','AaZd0Wzx5lbhvii+8+NjiQ==','2021-12-03 14:53:41',0,0,'A','2021-11-24',0,NULL,'N','2020-06-16 17:30:26',0,90,0,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:53:41','ACTUALIZACION REGISTRO'),(254,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','UOqH+yQy91zfEEZhsNtu2w==','2021-05-24 13:45:08',0,0,'A','2021-05-07',0,NULL,'N','2021-12-03 11:58:39',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','ACTUALIZACION REGISTRO'),(255,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','rS0wOJOppedj8aMEpeLMUA==','2021-05-24 13:45:08',0,0,'A','2021-12-03',0,NULL,'N','2021-12-03 11:58:39',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:54:12','ACTUALIZACION REGISTRO'),(256,589,'CC','1072658172','Luis Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','lmunetonp','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,37,0,'asalgado','root@localhost','2021-12-03 19:57:18','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:57:18','INSERCION REGISTRO'),(257,589,'CC','1072658172','Luis Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','lmunetonp','rS0wOJOppedj8aMEpeLMUA==',NULL,0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,0,'asalgado','root@localhost','2021-12-03 19:57:18','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:57:18','ACTUALIZACION REGISTRO'),(258,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','rS0wOJOppedj8aMEpeLMUA==','2021-12-03 14:58:50',0,0,'A','2021-12-03',0,NULL,'N','2021-12-03 11:58:39',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 19:58:49','ACTUALIZACION REGISTRO'),(259,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 14:58:50',0,0,'A','2021-12-03',0,NULL,'N','2021-12-03 11:58:39',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:00:07','ACTUALIZACION REGISTRO'),(260,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:01:33',0,0,'A','2021-12-03',0,NULL,'N','2021-12-03 11:58:39',0,90,0,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:01:33','ACTUALIZACION REGISTRO'),(261,589,'CC','1072658172','Luis Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','lmunetonp','rS0wOJOppedj8aMEpeLMUA==','2021-12-03 15:02:28',0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,0,'asalgado','root@localhost','2021-12-03 19:57:18','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:02:28','ACTUALIZACION REGISTRO'),(262,589,'CC','1072658172','Luis Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','lmunetonp','5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:02:28',0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,0,'asalgado','root@localhost','2021-12-03 19:57:18','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:02:44','ACTUALIZACION REGISTRO'),(263,590,'CC','10726581','Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','operador1','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,37,0,'lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:06:24','INSERCION REGISTRO'),(264,590,'CC','10726581','Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','operador1','5hnxUix9rC2/tmBLWXWAqw==',NULL,0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,0,'lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:06:24','ACTUALIZACION REGISTRO'),(265,590,'CC','10726581','Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','operador1','5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:06:52',0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,0,'lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:06:52','ACTUALIZACION REGISTRO'),(266,590,'CC','10726581','Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','operador1','oiJ6V7ui+YmEjZaVtgWC6w==','2021-12-03 15:06:52',0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,0,'lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso Usuario - Inserción','opaunoapp@ip-10-120-49-215.ec2.internal','2021-12-03 20:07:04','ACTUALIZACION REGISTRO');
/*!40000 ALTER TABLE `au_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diccionario`
--

DROP TABLE IF EXISTS `diccionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diccionario` (
  `id_palabra` int(1) NOT NULL DEFAULT '1',
  `palabra` varchar(500) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_modificacion` varchar(50) DEFAULT NULL,
  `usuario_modi_bd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_palabra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diccionario`
--

LOCK TABLES `diccionario` WRITE;
/*!40000 ALTER TABLE `diccionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `diccionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_au_diccionario` BEFORE INSERT ON `diccionario` FOR EACH ROW SET NEW.usuario_modi_bd=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `au_diccionario_after_insert` AFTER INSERT ON `diccionario` FOR EACH ROW BEGIN
		
		INSERT INTO au_diccionario
			(`palabra`,
  `fecha_creacion`,
  `usuario_modificacion`,
  `au_fecha_modificacion`,
  `au_usuario`,
  `au_tipo_modificacion`
	) 	          
	         VALUES 
	(NEW.palabra,
  NEW.fecha_creacion,
  NEW.usuario_modificacion,
	
			NOW(),
			SESSION_USER(),
			'UPDATE REGISTRO');
	END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `dm_origen_mila`
--

DROP TABLE IF EXISTS `dm_origen_mila`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm_origen_mila` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_pais` int(4) NOT NULL,
  `pais` varchar(50) NOT NULL,
  `tipo_doc` int(3) NOT NULL DEFAULT '4',
  `numero_doc` varchar(20) NOT NULL,
  `numero_ver` decimal(1,0) NOT NULL,
  `cuenta` varchar(15) DEFAULT NULL,
  `estado` char(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm_origen_mila`
--

LOCK TABLES `dm_origen_mila` WRITE;
/*!40000 ALTER TABLE `dm_origen_mila` DISABLE KEYS */;
/*!40000 ALTER TABLE `dm_origen_mila` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dm_reporteUsuario`
--

DROP TABLE IF EXISTS `dm_reporteUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm_reporteUsuario` (
  `i_id_reporte` int(11) NOT NULL AUTO_INCREMENT,
  `i_num_reporte` int(11) DEFAULT NULL,
  `i_id_usuario` int(11) DEFAULT NULL,
  `fecha` varchar(20) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`i_id_reporte`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm_reporteUsuario`
--

LOCK TABLES `dm_reporteUsuario` WRITE;
/*!40000 ALTER TABLE `dm_reporteUsuario` DISABLE KEYS */;
INSERT INTO `dm_reporteUsuario` VALUES (1,1,560,'2021-05-12'),(2,1,560,'2021-05-13'),(3,1,560,'2021-05-14'),(4,1,571,'2021-05-19'),(5,1,571,'2021-05-20'),(6,1,582,'2021-05-21'),(7,1,560,'2021-05-21'),(8,1,581,'2021-05-21'),(9,1,560,'2021-05-24'),(10,1,581,'2021-05-24');
/*!40000 ALTER TABLE `dm_reporteUsuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_reporteUsuarioInsert` AFTER INSERT ON `dm_reporteUsuario` FOR EACH ROW BEGIN
INSERT INTO au_reporteUsuario
(i_id_reporte,
i_num_reporte,
i_id_usuario,
fecha)           
VALUES 
(NEW.i_id_reporte,
NEW.i_num_reporte,
NEW.i_id_usuario,
NEW.fecha);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_reporteUsuarioUpdate` AFTER UPDATE ON `dm_reporteUsuario` FOR EACH ROW BEGIN
INSERT INTO au_reporteUsuario
(i_id_reporte,
i_num_reporte,
i_id_usuario,
fecha)           
VALUES 
(NEW.i_id_reporte,
NEW.i_num_reporte,
NEW.i_id_usuario,
NEW.fecha);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `dm_scb`
--

DROP TABLE IF EXISTS `dm_scb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm_scb` (
  `i_scb` int(11) NOT NULL,
  `c_documento` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `c_digito_verificacion` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `i_tipodocumento` int(11) NOT NULL DEFAULT '0',
  `i_codigoentidad` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `c_razonsocial` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `c_tipopersona` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `c_representante` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `c_direccion` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `c_telefono` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `c_fax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `c_pais` char(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `i_codigodepto` int(11) NOT NULL DEFAULT '0',
  `i_codigociudad` int(11) NOT NULL DEFAULT '0',
  `i_entidadcolocadora` int(11) DEFAULT NULL,
  `c_representante2` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `c_representante3` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `c_tipodoc_representante` int(11) DEFAULT '0',
  `c_numdoc_representante` varchar(20) COLLATE utf8_unicode_ci DEFAULT '',
  `c_tipodoc_representante2` int(11) DEFAULT '0',
  `c_numdoc_representante2` varchar(20) COLLATE utf8_unicode_ci DEFAULT '',
  `c_tipodoc_representante3` int(11) DEFAULT '0',
  `c_numdoc_representante3` varchar(20) COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`i_scb`),
  KEY `fk_scb_tipodoc` (`i_tipodocumento`),
  KEY `fk_scb_pais` (`c_pais`),
  KEY `fk_scb_codigociudad` (`i_codigociudad`),
  KEY `fk_scb_codigodepto` (`i_codigodepto`),
  KEY `fk_scb_entidadcolocadora` (`i_entidadcolocadora`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm_scb`
--

LOCK TABLES `dm_scb` WRITE;
/*!40000 ALTER TABLE `dm_scb` DISABLE KEYS */;
INSERT INTO `dm_scb` VALUES (1,'890931609','9',4,'001','ADCAP COLOMBIA S.A.COMISIONISTA DE BOLSA','','Gabriel Enrique Rosas Gonzalez','Cra 11 N 77A 49 Piso 6 Bogota','3205940','','',11,1,0,'','Eduardo Antonio Ramirez Restrepo ',1,1,'79548076',0,'',1,'71773349'),(2,'860079174','3',4,'002','CORREDORES DAVIVIENDA S.A.COMISIONISTA DE BOLSA','','Juan Diego Correa','Cra 7 No 71-52 Piso 16 Torre B','3123300','','',11,1,0,'Mauricio Garcia Osorio',' ',1,1,'98549423',1,'80414191',0,''),(3,'860051175','9',4,'003','UALET S.A. COMISIONISTA DE BOLSA','','Leopoldo Forero Samper','calle 26B No 4A 45 Piso 11','6372055','','',11,1,0,'Felipe Gaviria Lievano',' ',1,1,'80417308',1,'3132665',0,''),(4,'830035217','3',4,'004','ITAU COMISIONISTA DE BOLSA COLOMBIA S.A','','Andres Felipe Piedrahita','','3394540','','',11,1,0,'Hernando Herrera Umana',' ',1,1,'80872046',1,'79358316',0,''),(5,'800096036','9',4,'005','BBVA VALORES COLOMBIA S.A. COMISIONISTA DE BOLSA - BBVA VALORES','','Willy Alexander Enciso Sabbagh','Cra 9 No 72 21 piso 7 Bogota','3077018','','',11,1,0,'',' ',1,1,'79686772',0,'',0,''),(7,'860071562','1',4,'007','ACCIONES Y VALORES S.A. COMISIONISTAS DE BOLSA','','Juan Carlos Aparicio Escallon','Cll 72 No 7 64 piso 11','3257800','','',11,1,0,'',' ',1,1,'19380878',0,'',0,''),(10,'800128735','8',4,'010','VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','','Andres Ochoa Franco','Medellin Cra 48 No 26-85 Av Industriales Torre Sur','4040000','','',11,1,0,'Juan Felipe Giraldo Ospina','Nora Fraija Chebib ',1,1,'98552709',1,'71743243',1,'32609830'),(13,'860079981','0',4,'013','VALORALTA S.A. COMISIONISTA DE BOLSA','','Juan Pablo Muñoz','','3138888','','',11,1,0,'Oswaldo Rincón Rojas','Rafael Augusto Poleo Graterol ',1,1,'79155228',1,'12272730',2,'350100'),(18,'860000185','4',4,'018','ALIANZA VALORES COMISIONISTA DE BOLSA S.A','',' Alejandro Garay Sarasti','Avenida Carrera 15 No 82 99 Piso 3','6447730','','',11,1,0,'',' ',1,1,'80417742',0,'',0,''),(26,'800019807','2',4,'026','COMPAÑIA PROFESIONALES DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(29,'860068182','5',4,'029','CREDICORP CAPITAL COLOMBIA S.A.','','Ramon Eduardo Mendez Jimenez','Calle 34 No 6-65','3394400','','',11,1,0,'',' ',1,1,'19429241',0,'',0,''),(34,'860009934','5',4,'034','COMPASS GROUP S.A.COMISIONISTA DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(35,'800198073','1',4,'035','CITIVALORES S.A. COMISIONISTA DE BOLSA','','Nubia Teresa Aldana Gonzalez','Cra 9 No 99-02 Piso 1 Mz','6394112','','',11,1,0,'Juan Enrique Barco Echeverri',' ',1,1,'43622057',1,'1020724817',0,''),(37,'800120184','3',4,'037','ULTRASERFINCO S.A.','','MAURICIO SINISTERRA PLANA','Cra 49 N° 52-61 Piso 9','3255560','','',11,1,0,'DANIEL MUNOZ JIMENEZ','SERGIO ANDRES LEON CALAD ',1,1,'79443502',1,'71374700',1,'79592662'),(45,'800203186','5',4,'045','CASA DE BOLSA S.A. SOCIEDAD COMISIONISTA DE BOLSA','','Carlos Ernesto Castro Leal','Carrera  13  no.  26 –45  oficina  502 ','6062100','','',11,1,0,'Oscar Javier Cantor Holguin','Maria Angela Romero Ortiz ',1,1,'88210061',1,'14895592',1,'39778596'),(50,'890907157','0',4,'050','BTG PACTUAL S.A. COMISIONISTA DE BOLSA','','Mabel Constanza Moreno Ochoa','Medellin Cra 43A No 1-50 San Fernando Plaza Torr','0344484300','','',11,1,0,'Juliana Barrero Jaramillo',' ',1,1,'43740801',1,'39177249',0,''),(51,'800189604','2',4,'051','GLOBAL SECURITIES S.A. COMISIONISTA DE BOLSA','','Jose Daniel Acosta Portilla','Medellin Calle 7 sur No 42-70 Oficina 215','4447010','','',11,1,0,'Alvaro Jose Aparicio','Alejandro Cuervo Cardenas ',1,1,'79948871',1,'19253520',1,'79535259'),(56,'830118120','5',4,'056','SERVIVALORES GNB SUDAMERIS S.A. COMISIONISTA DE BOLSA','','Maria Eugenia Arbelaez Cifuentes','','31600000','','',11,1,0,'Bermel Beltran Munoz','Maria Paula Villalba ',1,1,'24575969',1,'80353925',1,'52884216'),(57,'830504700','2',4,'057','SCOTIA SECURITIES (COLOMBIA) S.A. SOCIEDAD COMISIONISTA DE BOLSA','','Natalia Andrea Gonzalez Suarez','Carrera 7 No 114 33 Piso 09','3138660','','',11,1,0,'Beatriz Eugenia Diaz Saldarriaga','Nubia Teresa Aldana Gonzalez ',1,1,'52117817',1,'52419250',1,'43622057'),(58,'900125656','3',4,'058','SKANDIA VALORES S.A SOCIEDAD COMISIONISTA DE BOLSA','','Mirta Yolima Perez','','1234567','','',11,1,0,'',' ',1,1,'51984247',0,'',0,''),(62,'900577140','4',4,'062','LARRAIN VIAL COLOMBIA S.A. COMISIONISTA DE BOLSA','','German Farias Elgueta','','3258030','','',11,1,0,'Maria Jose Ramirez Botero',' ',1,2,'569250',1,'51782415',0,''),(90,'8300854261','6',4,'090','BOLSA DE VALORES DE COLOMBIA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(987,'830085426','1',4,'987','Pruebas BVC como comisionista',NULL,'Myriam Robayo','Carrera 7 #71-21 Torre B Piso 12','3139800',NULL,NULL,0,0,NULL,'',' ',1,1,'51642094',0,'',0,''),(988,'830136799','1',4,'988','PRUEBA BIOMAX',NULL,'MYRIAM BIOMAX PRUEBA','','3139803',NULL,NULL,0,0,NULL,'','',1,1,'23456789',0,'',0,'');
/*!40000 ALTER TABLE `dm_scb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dm_tipodocumento`
--

DROP TABLE IF EXISTS `dm_tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dm_tipodocumento` (
  `i_tipodocumento` int(11) NOT NULL DEFAULT '0',
  `c_nombredoc` varchar(60) NOT NULL DEFAULT '',
  `c_validadv` char(2) NOT NULL DEFAULT '',
  `c_dominio` char(2) NOT NULL DEFAULT '',
  `c_codigobolsa` varchar(10) DEFAULT NULL,
  `c_descripcion` varchar(60) DEFAULT NULL,
  `c_aplica` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`i_tipodocumento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm_tipodocumento`
--

LOCK TABLES `dm_tipodocumento` WRITE;
/*!40000 ALTER TABLE `dm_tipodocumento` DISABLE KEYS */;
INSERT INTO `dm_tipodocumento` VALUES (1,'Cédula de Ciudadanía','N','N','CC','CÉDULA DE CIUDADANÍA','A'),(5,'NIP o NUIP','N','A','NUIP','NÚMERO ÚNICO DE IDENTIFICACIÓN PERSONAL','A'),(4,'NIT','N','A','NIT','NÚMERO IDENTIFIACIÓN TRIBUTARIA','A'),(2,'Cédula de Extranjería','N','A','CE','CÉDULA DE EXTRANJERIA','A'),(3,'Pasaporte','N','A','PAP','PASAPORTE','A'),(6,'Tarjeta de Identidad','N','A','TI','TARJETA DE IDENTIDAD','A');
/*!40000 ALTER TABLE `dm_tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_CrearAceptacion`
--

DROP TABLE IF EXISTS `fqs_CrearAceptacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_CrearAceptacion` (
  `EntidadDeNegociosID` int(11) NOT NULL,
  `ClaseAcciones` varchar(20) NOT NULL,
  `ConOfeVen` varchar(15) NOT NULL,
  `TextoUno` varchar(600) NOT NULL,
  `TextoDos` varchar(600) NOT NULL,
  `ExistePreacuerdo` char(1) DEFAULT NULL,
  `CodScb` decimal(15,0) NOT NULL,
  `NombreSCB` varchar(100) NOT NULL,
  `RepresentanteLegal` varchar(50) NOT NULL,
  `NombreRazonSocial` varchar(60) NOT NULL,
  `NumAcciones` decimal(11,0) NOT NULL,
  `VenCon` char(1) DEFAULT NULL,
  `TipDocumento` int(11) NOT NULL,
  `NumNitDoc` varchar(20) NOT NULL,
  `NumVer` decimal(1,0) DEFAULT NULL,
  `EspFid` varchar(3) NOT NULL,
  `CtaInv` decimal(8,0) NOT NULL,
  `NombreUsuarioIdCreacion` int(11) NOT NULL,
  `FechaCreacion` datetime NOT NULL,
  `NombreUsuarioIdModificacion` int(11) NOT NULL,
  `FechaModificacion` datetime NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Ingresado',
  `PorcentajeComision` decimal(6,3) DEFAULT '0.000',
  `observacion` varchar(200) DEFAULT NULL,
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  `PorcentajePagoEfectivo` int(3) DEFAULT '0',
  `tipo_pago` tinyint(1) DEFAULT '0',
  `MontoTotalEfectivo` decimal(26,2) DEFAULT '0.00',
  `Condicion1` char(1) DEFAULT 'S',
  `Condicion2` char(1) DEFAULT 'S',
  `tipo_oferta_publica` varchar(3) DEFAULT 'OPA' COMMENT 'Valor predeterminado: OPA',
  `direccion` varchar(50) DEFAULT NULL,
  `idMila` varchar(4) DEFAULT '0',
  PRIMARY KEY (`EntidadDeNegociosID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_CrearAceptacion`
--

LOCK TABLES `fqs_CrearAceptacion` WRITE;
/*!40000 ALTER TABLE `fqs_CrearAceptacion` DISABLE KEYS */;
INSERT INTO `fqs_CrearAceptacion` VALUES (1,'Ordinarias','61584','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JUAN MANUEL ISAZA PIEROTTI',15,'0',1,'6227877',NULL,'',993617,560,'2021-05-12 09:14:00',560,'2021-05-12 09:14:00','Ingresado',15.000,NULL,'hitrespa','root@localhost','2021-05-12 14:14:00','Ingreso Demanda - Archivo',0,0,147750.00,'S','S','OPA','','0'),(2,'Ordinarias','62107','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','ALFREDO  MARIN JARAMILLO',200,'0',1,'16640923',NULL,'',2215099,560,'2021-05-13 10:55:55',560,'2021-05-13 10:55:55','Ingresado',6.599,NULL,'hitrespa','root@localhost','2021-05-13 15:55:55','Ingreso Demanda - Archivo',0,0,1970000.00,'S','S','OPA','','0'),(3,'Ordinarias','4852','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','Alejandro Garay Sarasti','Gilberto Rivera Correa',677,'1',1,'2401018',NULL,'',215255,573,'2021-05-13 12:33:00',573,'2021-05-13 12:33:00','Ingresado',2.335,NULL,'arrivera','root@localhost','2021-05-13 17:33:00','Ingreso Demanda - Insercin',0,0,6668450.00,'S','S','OPA','','0'),(4,'Ordinarias','62306','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','OSCAR HUMBERTO PALACIOS OSSA',253,'0',1,'14881057',NULL,'',2215798,560,'2021-05-14 09:09:28',560,'2021-05-14 09:09:28','Ingresado',5.217,NULL,'hitrespa','root@localhost','2021-05-14 14:09:28','Ingreso Demanda - Archivo',0,0,2492050.00,'S','S','OPA','','0'),(5,'Ordinarias','216480','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','CAMACHO PALACIOS OSCAR DARIO',2625,'0',1,'80040326',NULL,'',1756726,571,'2021-05-19 11:47:56',571,'2021-05-19 11:47:56','Ingresado',0.260,NULL,'cayala','root@localhost','2021-05-19 16:47:56','Ingreso Demanda - Archivo',0,0,25856250.00,'S','S','OPA','','0'),(6,'Ordinarias','213860','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','URIBE VILLAQUIRAN SEBASTIAN BERNARDO',202,'0',1,'1144064186',NULL,'',1786712,571,'2021-05-20 11:39:18',571,'2021-05-20 11:39:18','Ingresado',0.000,NULL,'cayala','root@localhost','2021-05-20 16:39:18','Ingreso Demanda - Archivo',0,0,1989700.00,'S','S','OPA','','0'),(7,'Ordinarias','12685544','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,2,'CORREDORES DAVIVIENDA S.A.COMISIONISTA DE BOLSA','Mauricio Garcia Osorio','LUZ ELENA OCHOA SIERRA',13139,'0',1,'32076968',NULL,'',2113730,582,'2021-05-21 11:59:38',582,'2021-05-21 11:59:38','Ingresado',0.500,NULL,'dgomez','root@localhost','2021-05-21 16:59:38','Ingreso Demanda - Insercin',0,0,129419150.00,'S','S','OPA','','0'),(8,'Ordinarias','64851','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','CESAR ALBERTO VALENCIA ZUNIGA',656,'0',1,'72250666',NULL,'',2215926,560,'2021-05-21 12:21:10',560,'2021-05-21 12:21:10','Ingresado',2.012,NULL,'hitrespa','root@localhost','2021-05-21 17:21:10','Ingreso Demanda - Insercin',0,0,6461600.00,'S','S','OPA','','0'),(9,'Ordinarias','64981','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','SERGIO  ZAPATA LARROTTA',55,'0',1,'7557564',NULL,'',901823,560,'2021-05-21 12:25:22',560,'2021-05-21 12:25:22','Ingresado',15.000,NULL,'hitrespa','root@localhost','2021-05-21 17:25:22','Ingreso Demanda - Insercin',0,0,541750.00,'S','S','OPA','','0'),(10,'Ordinarias','65022','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JORGE ALBERTO ESCOBAR GOMEZ',191,'0',1,'70125561',NULL,'',106415,560,'2021-05-21 12:27:41',560,'2021-05-21 12:27:41','Ingresado',6.910,NULL,'hitrespa','root@localhost','2021-05-21 17:27:41','Ingreso Demanda - Insercin',0,0,1881350.00,'S','S','OPA','','0'),(11,'Ordinarias','65340','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JUAN RAFAEL BAYTER POSADA',2521,'0',1,'71598574',NULL,'',196118,560,'2021-05-24 09:38:13',560,'2021-05-24 09:38:13','Ingresado',0.300,NULL,'hitrespa','root@localhost','2021-05-24 14:38:13','Ingreso Demanda - Archivo',0,0,24831850.00,'S','S','OPA','','0'),(12,'Ordinarias','65487','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Andres Ochoa Franco','JORGE LUIS OREJUELA POTES',3,'0',1,'16607549',NULL,'',1850658,560,'2021-05-24 09:38:13',560,'2021-05-24 09:38:13','Ingresado',15.000,NULL,'hitrespa','root@localhost','2021-05-24 14:38:13','Ingreso Demanda - Archivo',0,0,29550.00,'S','S','OPA','','0');
/*!40000 ALTER TABLE `fqs_CrearAceptacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_CrearAceptacion` BEFORE INSERT ON `fqs_CrearAceptacion` 
FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_CrearAceptacionInsert` AFTER INSERT ON `fqs_CrearAceptacion` FOR EACH ROW BEGIN
INSERT INTO au_CrearAceptacion
(`EntidadDeNegociosID`,
`ClaseAcciones`,
`ConOfeVen`,
`TextoUno`,
`TextoDos`,
`ExistePreacuerdo`,
`CodScb`,
`NombreSCB`,
`RepresentanteLegal`,
`NombreRazonSocial`,
`NumAcciones`,
`VenCon`,
`TipDocumento`,
`NumNitDoc`,
`NumVer`,
`EspFid`,
`CtaInv`,
`NombreUsuarioIdCreacion`,
`FechaCreacion`,
`NombreUsuarioIdModificacion`,
`FechaModificacion`,
`estado`,
`PorcentajeComision`,
`observacion`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`)          
       VALUES
(NEW.EntidadDeNegociosID,
NEW.ClaseAcciones,
NEW.ConOfeVen,
NEW.TextoUno,
NEW.TextoDos,
NEW.ExistePreacuerdo,
NEW.CodScb,
NEW.NombreSCB,
NEW.RepresentanteLegal,
NEW.NombreRazonSocial,
NEW.NumAcciones,
NEW.VenCon,
NEW.TipDocumento,
NEW.NumNitDoc,
NEW.NumVer,
NEW.EspFid,
NEW.CtaInv,
NEW.NombreUsuarioIdCreacion,
NEW.FechaCreacion,
NEW.NombreUsuarioIdModificacion,
NEW.FechaModificacion,
NEW.estado,
NEW.PorcentajeComision,
NEW.observacion,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultima_modificacion,
NEW.c_tipo_modificacion,
NOW(),
SESSION_USER(),
'INSERCION REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_upd_fqs_CrearAceptacion` BEFORE UPDATE ON `fqs_CrearAceptacion` 
    FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_CrearAceptacionUpdate` AFTER UPDATE ON `fqs_CrearAceptacion` 
    FOR EACH ROW BEGIN
		INSERT INTO au_CrearAceptacion
			(`EntidadDeNegociosID`,
  `ClaseAcciones`,
  `ConOfeVen`,
  `TextoUno`,
  `TextoDos`,
  `ExistePreacuerdo`,
  `CodScb`,
  `NombreSCB`,
  `RepresentanteLegal`,
  `NombreRazonSocial`,
  `NumAcciones`,
  `VenCon`,
  `TipDocumento`,
  `NumNitDoc`,
  `NumVer`,
  `EspFid`,
  `CtaInv`,
  `NombreUsuarioIdCreacion`,
  `FechaCreacion`,
  `NombreUsuarioIdModificacion`,
  `FechaModificacion`,
  `estado`,
  `PorcentajeComision`,
  `observacion`,
  `c_usuario_sistema_ultima_mod`,
  `c_usuario_bd_datos`,
  `ts_fecha_hora_ultima_modificacion`,
  `c_tipo_modificacion`,
  `au_fecha_modificacion`,
  `au_usuario_bd`,
  `au_tipo_accion`) 	          
	         VALUES 
	
	
	(NEW.EntidadDeNegociosID,
  NEW.ClaseAcciones,
  NEW.ConOfeVen,
  NEW.TextoUno,
  NEW.TextoDos,
  NEW.ExistePreacuerdo,
  NEW.CodScb,
  NEW.NombreSCB,
  NEW.RepresentanteLegal,
  NEW.NombreRazonSocial,
  NEW.NumAcciones,
  NEW.VenCon,
  NEW.TipDocumento,
  NEW.NumNitDoc,
  NEW.NumVer,
  NEW.EspFid,
  NEW.CtaInv,
  NEW.NombreUsuarioIdCreacion,
  NEW.FechaCreacion,
  NEW.NombreUsuarioIdModificacion,
  NEW.FechaModificacion,
  NEW.estado,
  NEW.PorcentajeComision,
  NEW.observacion,
  NEW.c_usuario_sistema_ultima_mod,
  NEW.c_usuario_bd_datos,
  NEW.ts_fecha_hora_ultima_modificacion,
  NEW.c_tipo_modificacion,
	
			NOW(),
			SESSION_USER(),
			'ACTUALIZACION REGISTRO');
    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_CrearAceptacionDelete` AFTER DELETE ON `fqs_CrearAceptacion` 
    FOR EACH ROW BEGIN
INSERT INTO au_CrearAceptacion
(`EntidadDeNegociosID`,
`ClaseAcciones`,
`ConOfeVen`,
`TextoUno`,
`TextoDos`,
`ExistePreacuerdo`,
`CodScb`,
`NombreSCB`,
`RepresentanteLegal`,
`NombreRazonSocial`,
`NumAcciones`,
`VenCon`,
`TipDocumento`,
`NumNitDoc`,
`NumVer`,
`EspFid`,
`CtaInv`,
`NombreUsuarioIdCreacion`,
`FechaCreacion`,
`NombreUsuarioIdModificacion`,
`FechaModificacion`,
`estado`,
`PorcentajeComision`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`) 	          
VALUES 
(OLD.EntidadDeNegociosID,
OLD.ClaseAcciones,
OLD.ConOfeVen,
OLD.TextoUno,
OLD.TextoDos,
OLD.ExistePreacuerdo,
OLD.CodScb,
OLD.NombreSCB,
OLD.RepresentanteLegal,
OLD.NombreRazonSocial,
OLD.NumAcciones,
OLD.VenCon,
OLD.TipDocumento,
OLD.NumNitDoc,
OLD.NumVer,
OLD.EspFid,
OLD.CtaInv,
OLD.NombreUsuarioIdCreacion,
OLD.FechaCreacion,
OLD.NombreUsuarioIdModificacion,
OLD.FechaModificacion,
OLD.estado,
OLD.PorcentajeComision,
OLD.c_usuario_sistema_ultima_mod,
OLD.c_usuario_bd_datos,
OLD.ts_fecha_hora_ultima_modificacion,
OLD.c_tipo_modificacion,
NOW(),
SESSION_USER(),
'BORRADO REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fqs_IpAutorizada`
--

DROP TABLE IF EXISTS `fqs_IpAutorizada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_IpAutorizada` (
  `id_ip` int(11) NOT NULL AUTO_INCREMENT,
  `ip_usuario` int(11) DEFAULT NULL,
  `ip` varchar(20) NOT NULL,
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ip`)
) ENGINE=InnoDB AUTO_INCREMENT=2441 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_IpAutorizada`
--

LOCK TABLES `fqs_IpAutorizada` WRITE;
/*!40000 ALTER TABLE `fqs_IpAutorizada` DISABLE KEYS */;
INSERT INTO `fqs_IpAutorizada` VALUES (1,1,'190.131.244.209',NULL,'root@localhost',NULL,NULL),(2,1,'127.0.0.1',NULL,'root@localhost',NULL,NULL),(3,10,'190.242.39.136',NULL,'root@localhost',NULL,NULL),(4,10,'172.28.1.204',NULL,'root@localhost',NULL,NULL),(28,14,'199.167.131.157','lmurillo','root@localhost','2017-01-24 05:46:03','Ingreso IP - InserciÃ³n'),(38,19,'201.221.124.8','1010001','root@localhost','2017-01-24 19:45:08','Ingreso IP - InserciÃ³n'),(40,21,'201.221.124.8','1010001','root@localhost','2017-01-24 19:58:52','Ingreso IP - InserciÃ³n'),(41,22,'201.221.124.8','1010001','root@localhost','2017-01-24 20:00:25','Ingreso IP - InserciÃ³n'),(42,23,'201.221.124.8','1010001','root@localhost','2017-01-24 20:01:41','Ingreso IP - InserciÃ³n'),(43,24,'200.14.232.217','lmurillo','root@localhost','2017-01-24 20:06:46','Ingreso IP - InserciÃ³n'),(44,24,'200.41.79.93','lmurillo','root@localhost','2017-01-24 20:06:46','Ingreso IP - InserciÃ³n'),(45,24,'200.41.79.94','lmurillo','root@localhost','2017-01-24 20:06:46','Ingreso IP - InserciÃ³n'),(46,25,'200.14.232.217','1045001','root@localhost','2017-01-24 20:43:12','Ingreso IP - InserciÃ³n'),(47,25,'200.41.79.93','1045001','root@localhost','2017-01-24 20:43:12','Ingreso IP - InserciÃ³n'),(48,25,'200.41.79.94','1045001','root@localhost','2017-01-24 20:43:12','Ingreso IP - InserciÃ³n'),(49,26,'200.14.232.217','1045001','root@localhost','2017-01-24 20:46:31','Ingreso IP - InserciÃ³n'),(50,26,'200.41.79.93','1045001','root@localhost','2017-01-24 20:46:31','Ingreso IP - InserciÃ³n'),(51,26,'200.41.79.94','1045001','root@localhost','2017-01-24 20:46:31','Ingreso IP - InserciÃ³n'),(52,27,'200.030.110.139','1004001','root@localhost','2017-01-24 23:10:27','Ingreso IP - InserciÃ³n'),(53,27,'172.23.22.111','1004001','root@localhost','2017-01-24 23:10:27','Ingreso IP - InserciÃ³n'),(55,28,'200.74.130.23','1037001','root@localhost','2017-01-25 01:19:52','Ingreso IP - InserciÃ³n'),(58,31,'181.143.34.114','1051001','root@localhost','2017-01-25 02:29:19','Ingreso IP - InserciÃ³n'),(65,9,'192.168.85.228','pruebasbvccomisionis','root@localhost','2017-01-25 03:03:00','Ingreso IP - ModificaciÃ³n'),(67,33,'200.030.110.139','1004001','root@localhost','2017-01-25 19:15:06','Ingreso IP - InserciÃ³n'),(68,33,'172.23.22.114','1004001','root@localhost','2017-01-25 19:15:06','Ingreso IP - InserciÃ³n'),(72,35,'190.131.201.70','1002001','root@localhost','2017-01-25 20:13:36','Ingreso IP - InserciÃ³n'),(73,35,'190.131.201.65','1002001','root@localhost','2017-01-25 20:13:36','Ingreso IP - InserciÃ³n'),(74,36,'190.131.201.70','1002001','root@localhost','2017-01-25 20:14:43','Ingreso IP - InserciÃ³n'),(75,36,'190.131.201.65','1002001','root@localhost','2017-01-25 20:14:43','Ingreso IP - InserciÃ³n'),(76,37,'199.167.131.157','1035001','root@localhost','2017-01-25 20:16:22','Ingreso IP - InserciÃ³n'),(77,38,'199.167.131.157','1035001','root@localhost','2017-01-25 20:18:17','Ingreso IP - InserciÃ³n'),(78,39,'199.167.131.157','1035001','root@localhost','2017-01-25 20:19:29','Ingreso IP - InserciÃ³n'),(82,41,'200.14.232.217','1045001','root@localhost','2017-01-26 18:06:10','Ingreso IP - InserciÃ³n'),(83,41,'200.41.79.93','1045001','root@localhost','2017-01-26 18:06:10','Ingreso IP - InserciÃ³n'),(84,41,'200.41.79.94','1045001','root@localhost','2017-01-26 18:06:10','Ingreso IP - InserciÃ³n'),(97,44,'200.14.232.217','1045001','root@localhost','2017-01-26 21:04:22','Ingreso IP - ModificaciÃ³n'),(98,44,'200.41.79.93','1045001','root@localhost','2017-01-26 21:04:22','Ingreso IP - ModificaciÃ³n'),(99,44,'200.41.79.94','1045001','root@localhost','2017-01-26 21:04:22','Ingreso IP - ModificaciÃ³n'),(100,45,'200.14.232.217','1045001','root@localhost','2017-01-26 21:04:36','Ingreso IP - ModificaciÃ³n'),(101,45,'200.41.79.93','1045001','root@localhost','2017-01-26 21:04:36','Ingreso IP - ModificaciÃ³n'),(102,45,'200.41.79.94','1045001','root@localhost','2017-01-26 21:04:36','Ingreso IP - ModificaciÃ³n'),(106,48,'190.131.240.114','1050001','root@localhost','2017-01-28 05:26:19','Ingreso IP - InserciÃ³n'),(109,50,'200.31.17.253','1056000','root@localhost','2017-01-30 21:24:27','Ingreso IP - InserciÃ³n'),(110,50,'190.25.232.76','1056000','root@localhost','2017-01-30 21:24:27','Ingreso IP - InserciÃ³n'),(113,51,'200.41.79.93','1045001','root@localhost','2017-01-30 21:35:59','Ingreso IP - InserciÃ³n'),(114,51,'200.41.79.94','1045001','root@localhost','2017-01-30 21:35:59','Ingreso IP - InserciÃ³n'),(115,51,'200.14.232.217','1045001','root@localhost','2017-01-30 21:35:59','Ingreso IP - InserciÃ³n'),(121,54,'10.208.7.19','1007000','root@localhost','2017-01-31 02:35:44','Ingreso IP - InserciÃ³n'),(122,54,'190.131.197.10','1007000','root@localhost','2017-01-31 02:35:44','Ingreso IP - InserciÃ³n'),(123,55,'10.192.7.55','1007000','root@localhost','2017-01-31 02:41:06','Ingreso IP - InserciÃ³n'),(124,55,'190.131.197.10','1007000','root@localhost','2017-01-31 02:41:06','Ingreso IP - InserciÃ³n'),(125,56,'10.192.7.66','1007000','root@localhost','2017-01-31 02:45:31','Ingreso IP - InserciÃ³n'),(126,56,'190.131.197.10','1007000','root@localhost','2017-01-31 02:45:31','Ingreso IP - InserciÃ³n'),(129,40,'200.14.232.217','1045001','root@localhost','2017-02-02 22:26:47','Ingreso IP - ModificaciÃ³n'),(130,40,'200.41.79.93','1045001','root@localhost','2017-02-02 22:26:47','Ingreso IP - ModificaciÃ³n'),(131,40,'200.41.79.94','1045001','root@localhost','2017-02-02 22:26:47','Ingreso IP - ModificaciÃ³n'),(132,42,'200.14.232.217','1045001','root@localhost','2017-02-02 22:26:59','Ingreso IP - ModificaciÃ³n'),(133,42,'200.41.79.93','1045001','root@localhost','2017-02-02 22:26:59','Ingreso IP - ModificaciÃ³n'),(134,42,'200.41.79.94','1045001','root@localhost','2017-02-02 22:26:59','Ingreso IP - ModificaciÃ³n'),(135,43,'200.14.232.217','1045001','root@localhost','2017-02-02 22:31:14','Ingreso IP - ModificaciÃ³n'),(136,43,'200.41.79.93','1045001','root@localhost','2017-02-02 22:31:14','Ingreso IP - ModificaciÃ³n'),(137,43,'200.41.79.94','1045001','root@localhost','2017-02-02 22:31:14','Ingreso IP - ModificaciÃ³n'),(138,58,'201.234.245.253','lmurillo','root@localhost','2017-02-08 18:59:48','Ingreso IP - InserciÃ³n'),(139,58,'85.255.167.151','lmurillo','root@localhost','2017-02-08 18:59:48','Ingreso IP - InserciÃ³n'),(140,58,'190.66.4.253','lmurillo','root@localhost','2017-02-08 18:59:48','Ingreso IP - InserciÃ³n'),(156,47,'190.131.240.114','1050001','root@localhost','2017-02-15 21:57:17','Ingreso IP - ModificaciÃ³n'),(159,62,'190.242.58.26','1018000','root@localhost','2017-02-16 19:32:18','Ingreso IP - InserciÃ³n'),(160,62,'190.242.36.50','1018000','root@localhost','2017-02-16 19:32:18','Ingreso IP - InserciÃ³n'),(161,63,'190.242.58.26','1018000','root@localhost','2017-02-16 19:33:31','Ingreso IP - InserciÃ³n'),(162,63,'190.242.36.50','1018000','root@localhost','2017-02-16 19:33:31','Ingreso IP - InserciÃ³n'),(177,32,'181.143.34.114','jsandoval','root@localhost','2017-02-20 22:17:53','Ingreso IP - ModificaciÃ³n'),(181,30,'181.143.34.114','1051001','root@localhost','2017-02-20 22:31:21','Ingreso IP - ModificaciÃ³n'),(182,64,'200.1.65.60','jsandoval','root@localhost','2017-02-21 19:18:13','Ingreso IP - InserciÃ³n'),(183,64,'10.1.2.60','jsandoval','root@localhost','2017-02-21 19:18:13','Ingreso IP - InserciÃ³n'),(184,64,'10.1.2.98','jsandoval','root@localhost','2017-02-21 19:18:13','Ingreso IP - InserciÃ³n'),(185,10,'186.28.228.162','ogomez','root@localhost','2017-02-21 20:27:51','Ingreso IP - ModificaciÃ³n'),(186,10,'186.28.228.163','ogomez','root@localhost','2017-02-21 20:27:51','Ingreso IP - ModificaciÃ³n'),(187,10,'190.242.39.139','ogomez','root@localhost','2017-02-21 20:27:51','Ingreso IP - ModificaciÃ³n'),(191,34,'186.28.228.162','1003001','root@localhost','2017-02-21 20:31:39','Ingreso IP - ModificaciÃ³n'),(192,34,'186.28.228.163','1003001','root@localhost','2017-02-21 20:31:39','Ingreso IP - ModificaciÃ³n'),(193,34,'190.131.250.74','1003001','root@localhost','2017-02-21 20:31:39','Ingreso IP - ModificaciÃ³n'),(215,65,'200.1.65.60','jsandoval','root@localhost','2017-02-21 22:59:08','Ingreso IP - ModificaciÃ³n'),(216,65,'10.1.2.60','jsandoval','root@localhost','2017-02-21 22:59:08','Ingreso IP - ModificaciÃ³n'),(217,65,'10.1.2.98','jsandoval','root@localhost','2017-02-21 22:59:08','Ingreso IP - InserciÃ³n'),(221,52,'200.41.79.93','1045001','root@localhost','2017-02-23 21:27:35','Ingreso IP - ModificaciÃ³n'),(222,52,'200.41.79.94','1045001','root@localhost','2017-02-23 21:27:35','Ingreso IP - ModificaciÃ³n'),(223,52,'200.14.232.217','1045001','root@localhost','2017-02-23 21:27:35','Ingreso IP - ModificaciÃ³n'),(227,18,'190.143.111.130','1029001','root@localhost','2017-02-28 17:57:07','Ingreso IP - ModificaciÃ³n'),(228,18,'201.245.161.224','1029001','root@localhost','2017-02-28 17:57:07','Ingreso IP - ModificaciÃ³n'),(229,18,'200.119.83.128','1029001','root@localhost','2017-02-28 17:57:07','Ingreso IP - ModificaciÃ³n'),(233,67,'190.131.245.92','jsandoval','root@localhost','2017-03-01 18:19:43','Ingreso IP - ModificaciÃ³n'),(234,67,'190.131.245.93','jsandoval','root@localhost','2017-03-01 18:19:43','Ingreso IP - ModificaciÃ³n'),(235,67,'190.131.245.97','jsandoval','root@localhost','2017-03-01 18:19:43','Ingreso IP - ModificaciÃ³n'),(236,68,'190.131.245.92','013000','root@localhost','2017-03-01 18:24:50','Ingreso IP - InserciÃ³n'),(237,68,'190.131.245.93','013000','root@localhost','2017-03-01 18:24:50','Ingreso IP - InserciÃ³n'),(238,68,'190.131.245.97','013000','root@localhost','2017-03-01 18:24:50','Ingreso IP - InserciÃ³n'),(241,49,'200.31.17.253','1056000','root@localhost','2017-03-01 23:39:43','Ingreso IP - ModificaciÃ³n'),(242,49,'190.25.232.76','1056000','root@localhost','2017-03-01 23:39:43','Ingreso IP - ModificaciÃ³n'),(243,59,'201.234.245.253','1005000','root@localhost','2017-03-03 19:36:09','Ingreso IP - ModificaciÃ³n'),(244,59,'82.255.167.151','1005000','root@localhost','2017-03-03 19:36:09','Ingreso IP - ModificaciÃ³n'),(245,59,'190.66.4.253','1005000','root@localhost','2017-03-03 19:36:09','Ingreso IP - ModificaciÃ³n'),(246,66,'200.1.65.60','001000','root@localhost','2017-03-06 19:17:31','Ingreso IP - ModificaciÃ³n'),(247,66,'10.1.2.60','001000','root@localhost','2017-03-06 19:17:31','Ingreso IP - ModificaciÃ³n'),(248,66,'10.1.2.98','001000','root@localhost','2017-03-06 19:17:31','Ingreso IP - ModificaciÃ³n'),(253,20,'201.221.124.8','1010001','root@localhost','2017-03-06 21:27:51','Ingreso IP - ModificaciÃ³n'),(284,8,'190.131.244.209','sbravo','root@localhost','2017-06-02 22:00:30','Ingreso IP - ModificaciÃ³n'),(285,70,'190.131.244.209','sbravo','root@localhost','2017-06-02 22:02:00','Ingreso IP - ModificaciÃ³n'),(286,71,'190.131.244.209','pruebasbvccomisionis','root@localhost','2017-06-02 22:10:02','Ingreso IP - InserciÃ³n'),(287,72,'190.131.244.209','pruebasbvcbiomax','root@localhost','2017-06-02 22:18:52','Ingreso IP - InserciÃ³n'),(293,15,'190.216.141.187','sbravo','root@localhost','2017-06-03 21:18:49','Ingreso IP - ModificaciÃ³n'),(294,46,'200.31.17.253','sbravo','root@localhost','2017-06-03 21:20:56','Ingreso IP - ModificaciÃ³n'),(295,46,'190.25.232.76','sbravo','root@localhost','2017-06-03 21:20:56','Ingreso IP - ModificaciÃ³n'),(296,53,'190.131.197.10','sbravo','root@localhost','2017-06-03 23:04:12','Ingreso IP - ModificaciÃ³n'),(297,53,'190.131.197.11','sbravo','root@localhost','2017-06-03 23:04:12','Ingreso IP - ModificaciÃ³n'),(298,57,'190.242.58.26','sbravo','root@localhost','2017-06-03 23:05:08','Ingreso IP - ModificaciÃ³n'),(299,57,'190.242.36.50','sbravo','root@localhost','2017-06-03 23:05:08','Ingreso IP - ModificaciÃ³n'),(300,73,'190.131.197.10','1007000','root@localhost','2017-06-05 17:59:40','Ingreso IP - InserciÃ³n'),(301,73,'10.208.7.19','1007000','root@localhost','2017-06-05 17:59:40','Ingreso IP - InserciÃ³n'),(302,74,'190.131.197.10','1007000','root@localhost','2017-06-05 18:15:55','Ingreso IP - InserciÃ³n'),(303,74,'10.192.7.55','1007000','root@localhost','2017-06-05 18:15:55','Ingreso IP - InserciÃ³n'),(304,75,'190.242.58.26','1018000','root@localhost','2017-06-05 18:32:59','Ingreso IP - InserciÃ³n'),(305,75,'190.242.36.50','1018000','root@localhost','2017-06-05 18:32:59','Ingreso IP - InserciÃ³n'),(306,76,'190.242.58.26','1018000','root@localhost','2017-06-05 18:35:29','Ingreso IP - InserciÃ³n'),(307,76,'190.242.36.50','1018000','root@localhost','2017-06-05 18:35:29','Ingreso IP - InserciÃ³n'),(309,78,'201.221.124.8','1010001','root@localhost','2017-06-05 19:10:57','Ingreso IP - InserciÃ³n'),(311,77,'201.221.124.8','1010001','root@localhost','2017-06-05 19:18:46','Ingreso IP - ModificaciÃ³n'),(312,80,'201.221.124.8','1010001','root@localhost','2017-06-05 19:22:21','Ingreso IP - InserciÃ³n'),(313,17,'181.143.34.114','sbravo','root@localhost','2017-06-05 19:22:24','Ingreso IP - ModificaciÃ³n'),(321,83,'200.31.17.253','1056000','root@localhost','2017-06-05 19:37:06','Ingreso IP - InserciÃ³n'),(322,83,'190.25.232.76','1056000','root@localhost','2017-06-05 19:37:06','Ingreso IP - InserciÃ³n'),(328,84,'181.143.34.114','1051001','root@localhost','2017-06-05 20:53:15','Ingreso IP - InserciÃ³n'),(329,85,'190.131.201.70','1002001','root@localhost','2017-06-05 21:37:24','Ingreso IP - InserciÃ³n'),(340,11,'172.23.32.107','sbravo','root@localhost','2017-06-05 21:53:00','Ingreso IP - ModificaciÃ³n'),(341,11,'192.168.89.86','sbravo','root@localhost','2017-06-05 21:53:00','Ingreso IP - ModificaciÃ³n'),(352,86,'200.30.110.139','sbravo','root@localhost','2017-06-05 22:05:21','Ingreso IP - ModificaciÃ³n'),(353,86,'172.23.32.107','sbravo','root@localhost','2017-06-05 22:05:21','Ingreso IP - ModificaciÃ³n'),(354,86,'190.66.2.204','sbravo','root@localhost','2017-06-05 22:05:21','Ingreso IP - ModificaciÃ³n'),(355,87,'200.030.110.139','1004000','root@localhost','2017-06-05 22:09:03','Ingreso IP - InserciÃ³n'),(356,87,'172.23.22.111','1004000','root@localhost','2017-06-05 22:09:03','Ingreso IP - InserciÃ³n'),(357,87,'190.66.2.204','1004000','root@localhost','2017-06-05 22:09:03','Ingreso IP - InserciÃ³n'),(362,82,'200.31.17.253','1056000','root@localhost','2017-06-06 20:22:59','Ingreso IP - ModificaciÃ³n'),(363,82,'190.25.232.76','1056000','root@localhost','2017-06-06 20:22:59','Ingreso IP - ModificaciÃ³n'),(365,16,'190.131.240.114','jsandoval','root@localhost','2017-06-07 19:02:28','Ingreso IP - ModificaciÃ³n'),(366,16,'190.216.157.114','jsandoval','root@localhost','2017-06-07 19:02:28','Ingreso IP - ModificaciÃ³n'),(367,88,'190.131.240.114','1050001','root@localhost','2017-06-07 19:07:23','Ingreso IP - InserciÃ³n'),(368,81,'201.221.124.8','1010001','root@localhost','2017-06-09 17:29:49','Ingreso IP - ModificaciÃ³n'),(371,13,'190.143.111.130','sbravo','root@localhost','2017-06-13 20:27:21','Ingreso IP - ModificaciÃ³n'),(372,13,'201.245.161.224','sbravo','root@localhost','2017-06-13 20:27:21','Ingreso IP - ModificaciÃ³n'),(373,13,'200.119.83.128','sbravo','root@localhost','2017-06-13 20:27:21','Ingreso IP - ModificaciÃ³n'),(374,90,'190.143.111.130','1029001','root@localhost','2017-06-13 20:45:32','Ingreso IP - InserciÃ³n'),(381,12,'201.221.124.8','jsandoval','root@localhost','2017-06-16 22:28:22','Ingreso IP - ModificaciÃ³n'),(383,29,'190.131.201.70','sbravo','root@localhost','2017-06-16 22:31:03','Ingreso IP - ModificaciÃ³n'),(384,79,'201.221.124.8','1010001','root@localhost','2017-06-21 03:00:22','Ingreso IP - ModificaciÃ³n'),(387,91,'190.131.244.209','ogomez','root@localhost','2018-01-04 01:20:32','Ingreso IP - InserciÃ³n'),(388,92,'190.131.244.209','ogomez','root@localhost','2018-01-04 01:23:18','Ingreso IP - InserciÃ³n'),(393,93,'192.168.232.1','lnavarropru','root@localhost','2018-01-05 00:07:43','Ingreso IP - ModificaciÃ³n'),(394,93,'192.168.95.96','lnavarropru','root@localhost','2018-01-05 00:07:43','Ingreso IP - ModificaciÃ³n'),(395,93,'190.131.244.209','lnavarropru','root@localhost','2018-01-05 00:07:43','Ingreso IP - ModificaciÃ³n'),(396,94,'190.131.244.209','lnavarropru2','root@localhost','2018-01-05 00:36:35','Ingreso IP - ModificaciÃ³n'),(399,95,'190.131.244.209','lnavarropru2','root@localhost','2018-01-05 02:35:52','Ingreso IP - ModificaciÃ³n'),(415,97,'201.221.124.8','ogomez','root@localhost','2018-01-09 21:13:10','Ingreso IP - InserciÃ³n'),(417,99,'181.143.34.114','ogomez','root@localhost','2018-01-09 21:17:37','Ingreso IP - InserciÃ³n'),(418,99,'181.143.34.115','ogomez','root@localhost','2018-01-09 21:17:37','Ingreso IP - InserciÃ³n'),(419,99,'181.143.34.116','ogomez','root@localhost','2018-01-09 21:17:37','Ingreso IP - InserciÃ³n'),(420,100,'181.143.34.114','1051000','root@localhost','2018-01-09 22:26:22','Ingreso IP - InserciÃ³n'),(421,100,'181.143.34.115','1051000','root@localhost','2018-01-09 22:26:22','Ingreso IP - InserciÃ³n'),(422,100,'181.143.34.116','1051000','root@localhost','2018-01-09 22:26:22','Ingreso IP - InserciÃ³n'),(423,101,'201.221.124.8','1010001','root@localhost','2018-01-09 23:46:04','Ingreso IP - InserciÃ³n'),(424,102,'201.221.124.8','1010001','root@localhost','2018-01-09 23:48:13','Ingreso IP - InserciÃ³n'),(425,103,'201.221.124.8','1010001','root@localhost','2018-01-09 23:49:39','Ingreso IP - InserciÃ³n'),(426,104,'201.221.124.8','1010001','root@localhost','2018-01-09 23:51:02','Ingreso IP - InserciÃ³n'),(427,105,'201.221.124.8','1010001','root@localhost','2018-01-09 23:52:25','Ingreso IP - InserciÃ³n'),(428,106,'201.221.124.8','1010001','root@localhost','2018-01-10 00:01:30','Ingreso IP - InserciÃ³n'),(429,96,'200.030.110.139','ogomez','root@localhost','2018-01-10 00:28:03','Ingreso IP - ModificaciÃ³n'),(430,96,'190.66.2.204','ogomez','root@localhost','2018-01-10 00:28:03','Ingreso IP - ModificaciÃ³n'),(434,107,'200.030.110.139','1004001','root@localhost','2018-01-10 21:01:04','Ingreso IP - ModificaciÃ³n'),(435,107,'190.66.2.204','1004001','root@localhost','2018-01-10 21:01:04','Ingreso IP - ModificaciÃ³n'),(436,107,'172.23.22.111','1004001','root@localhost','2018-01-10 21:01:04','Ingreso IP - ModificaciÃ³n'),(443,110,'190.143.111.130','1029001','root@localhost','2018-01-13 00:56:27','Ingreso IP - InserciÃ³n'),(444,110,'201.245.161.224','1029001','root@localhost','2018-01-13 00:56:27','Ingreso IP - InserciÃ³n'),(445,110,'200.119.83.128','1029001','root@localhost','2018-01-13 00:56:27','Ingreso IP - InserciÃ³n'),(449,112,'190.143.111.130','1029001','root@localhost','2018-01-13 01:07:33','Ingreso IP - InserciÃ³n'),(450,112,'201.245.161.224','1029001','root@localhost','2018-01-13 01:07:33','Ingreso IP - InserciÃ³n'),(451,112,'200.119.83.128','1029001','root@localhost','2018-01-13 01:07:33','Ingreso IP - InserciÃ³n'),(452,98,'190.131.240.114','ogomez','root@localhost','2018-01-18 04:14:48','Ingreso IP - ModificaciÃ³n'),(454,108,'190.131.201.70','ogomez','root@localhost','2018-02-13 22:38:46','Ingreso IP - ModificaciÃ³n'),(455,113,'190.131.201.70','1002001','root@localhost','2018-02-13 23:00:34','Ingreso IP - InserciÃ³n'),(456,114,'190.131.201.70','1002001','root@localhost','2018-02-13 23:04:32','Ingreso IP - InserciÃ³n'),(461,119,'190.131.240.114','1050001','root@localhost','2018-02-14 20:35:41','Ingreso IP - InserciÃ³n'),(465,109,'190.143.111.130','ogomez','root@localhost','2018-02-15 21:27:00','Ingreso IP - ModificaciÃ³n'),(466,109,'201.245.161.224','ogomez','root@localhost','2018-02-15 21:27:00','Ingreso IP - ModificaciÃ³n'),(467,109,'200.119.83.128','ogomez','root@localhost','2018-02-15 21:27:00','Ingreso IP - ModificaciÃ³n'),(471,118,'190.131.244.230','1018001','root@localhost','2018-02-16 21:25:47','Ingreso IP - ModificaciÃ³n'),(473,111,'190.143.111.130','1029001','root@localhost','2018-02-19 19:25:11','Ingreso IP - ModificaciÃ³n'),(474,111,'201.245.161.224','1029001','root@localhost','2018-02-19 19:25:11','Ingreso IP - ModificaciÃ³n'),(475,111,'200.119.83.128','1029001','root@localhost','2018-02-19 19:25:11','Ingreso IP - ModificaciÃ³n'),(476,115,'190.242.36.50','ogomez','root@localhost','2018-02-20 22:31:20','Ingreso IP - ModificaciÃ³n'),(477,116,'190.242.36.50','1018001','root@localhost','2018-02-20 22:43:24','Ingreso IP - ModificaciÃ³n'),(478,117,'190.242.36.50','1018001','root@localhost','2018-02-20 22:43:36','Ingreso IP - ModificaciÃ³n'),(482,121,'181.143.34.114','ogomez','root@localhost','2018-03-02 05:22:21','Ingreso IP - InserciÃ³n'),(483,121,'181.143.34.115','ogomez','root@localhost','2018-03-02 05:22:21','Ingreso IP - InserciÃ³n'),(484,121,'181.143.34.116','ogomez','root@localhost','2018-03-02 05:22:21','Ingreso IP - InserciÃ³n'),(485,122,'201.221.124.8','ogomez','root@localhost','2018-03-02 05:26:27','Ingreso IP - InserciÃ³n'),(492,126,'190.131.201.70','ogomez','root@localhost','2018-03-02 06:25:52','Ingreso IP - InserciÃ³n'),(493,127,'190.131.250.74','ogomez','root@localhost','2018-03-02 06:28:12','Ingreso IP - InserciÃ³n'),(494,127,'190.242.103.54','ogomez','root@localhost','2018-03-02 06:28:12','Ingreso IP - InserciÃ³n'),(495,128,'200.030.110.139','ogomez','root@localhost','2018-03-02 06:30:24','Ingreso IP - InserciÃ³n'),(496,128,'190.66.2.204','ogomez','root@localhost','2018-03-02 06:30:24','Ingreso IP - InserciÃ³n'),(497,129,'190.216.141.187','ogomez','root@localhost','2018-03-02 06:36:50','Ingreso IP - InserciÃ³n'),(498,130,'190.131.240.114','ogomez','root@localhost','2018-03-02 06:39:58','Ingreso IP - InserciÃ³n'),(499,131,'190.216.141.187','lgutierrez','root@localhost','2018-03-02 18:20:30','Ingreso IP - InserciÃ³n'),(501,133,'190.216.141.187','lgutierrez','root@localhost','2018-03-02 18:25:03','Ingreso IP - InserciÃ³n'),(502,134,'201.221.124.8','evelasquez','root@localhost','2018-03-02 18:28:33','Ingreso IP - InserciÃ³n'),(503,135,'201.221.124.8','evelasquez','root@localhost','2018-03-02 18:30:09','Ingreso IP - InserciÃ³n'),(505,137,'201.221.124.8','evelasquez','root@localhost','2018-03-02 18:37:33','Ingreso IP - InserciÃ³n'),(506,138,'201.221.124.8','evelasquez','root@localhost','2018-03-02 18:40:06','Ingreso IP - InserciÃ³n'),(507,139,'201.221.124.8','evelasquez','root@localhost','2018-03-02 18:41:24','Ingreso IP - InserciÃ³n'),(512,132,'181.143.34.114','jabaunza','root@localhost','2018-03-02 20:17:52','Ingreso IP - ModificaciÃ³n'),(513,132,'181.143.34.115','jabaunza','root@localhost','2018-03-02 20:17:52','Ingreso IP - ModificaciÃ³n'),(514,132,'181.143.34.116','jabaunza','root@localhost','2018-03-02 20:17:52','Ingreso IP - ModificaciÃ³n'),(522,144,'190.131.201.70','jmendez','root@localhost','2018-03-05 20:04:39','Ingreso IP - InserciÃ³n'),(523,145,'200.030.110.139','jherrera','root@localhost','2018-03-05 21:26:34','Ingreso IP - InserciÃ³n'),(524,145,'190.66.2.204','jherrera','root@localhost','2018-03-05 21:26:34','Ingreso IP - InserciÃ³n'),(525,145,'172.23.22.111','jherrera','root@localhost','2018-03-05 21:26:34','Ingreso IP - InserciÃ³n'),(538,148,'201.234.176.50','jparra','root@localhost','2018-03-06 03:59:42','Ingreso IP - ModificaciÃ³n'),(539,148,'190.216.159.78','jparra','root@localhost','2018-03-06 03:59:42','Ingreso IP - ModificaciÃ³n'),(540,148,'190.24.137.126','jparra','root@localhost','2018-03-06 03:59:42','Ingreso IP - ModificaciÃ³n'),(541,149,'201.234.176.50','jparra','root@localhost','2018-03-06 04:03:06','Ingreso IP - InserciÃ³n'),(542,149,'190.216.159.78','jparra','root@localhost','2018-03-06 04:03:06','Ingreso IP - InserciÃ³n'),(543,149,'190.24.137.126','jparra','root@localhost','2018-03-06 04:03:06','Ingreso IP - InserciÃ³n'),(544,150,'200.31.17.253','jparra','root@localhost','2018-03-06 04:22:23','Ingreso IP - InserciÃ³n'),(545,150,'190.25.232.76','jparra','root@localhost','2018-03-06 04:22:23','Ingreso IP - InserciÃ³n'),(546,150,'179.0.15.132','jparra','root@localhost','2018-03-06 04:22:23','Ingreso IP - InserciÃ³n'),(552,154,'192.242.58.26','kapanader','root@localhost','2018-03-06 19:35:09','Ingreso IP - InserciÃ³n'),(555,157,'190.131.244.230','kapanader','root@localhost','2018-03-06 19:38:29','Ingreso IP - InserciÃ³n'),(558,160,'201.234.176.50','rzambranog','root@localhost','2018-03-06 22:00:42','Ingreso IP - InserciÃ³n'),(559,160,'190.216.159.78','rzambranog','root@localhost','2018-03-06 22:00:42','Ingreso IP - InserciÃ³n'),(560,160,'190.24.137.126','rzambranog','root@localhost','2018-03-06 22:00:42','Ingreso IP - InserciÃ³n'),(561,161,'201.234.176.50','rzambranog','root@localhost','2018-03-06 22:04:42','Ingreso IP - InserciÃ³n'),(562,161,'190.216.159.78','rzambranog','root@localhost','2018-03-06 22:04:42','Ingreso IP - InserciÃ³n'),(563,161,'190.24.137.126','rzambranog','root@localhost','2018-03-06 22:04:42','Ingreso IP - InserciÃ³n'),(564,124,'190.143.111.130','jparra','root@localhost','2018-03-07 00:25:36','Ingreso IP - ModificaciÃ³n'),(565,124,'201.245.161.224','jparra','root@localhost','2018-03-07 00:25:36','Ingreso IP - ModificaciÃ³n'),(566,124,'200.119.83.128','jparra','root@localhost','2018-03-07 00:25:36','Ingreso IP - ModificaciÃ³n'),(567,162,'190.143.111.130','cgaray','root@localhost','2018-03-07 02:20:24','Ingreso IP - InserciÃ³n'),(568,162,'201.245.161.224','cgaray','root@localhost','2018-03-07 02:20:24','Ingreso IP - InserciÃ³n'),(569,162,'200.119.83.128','cgaray','root@localhost','2018-03-07 02:20:24','Ingreso IP - InserciÃ³n'),(570,163,'190.143.111.130','cgaray','root@localhost','2018-03-07 02:23:09','Ingreso IP - InserciÃ³n'),(571,163,'201.245.161.224','cgaray','root@localhost','2018-03-07 02:23:09','Ingreso IP - InserciÃ³n'),(572,163,'200.119.83.128','cgaray','root@localhost','2018-03-07 02:23:09','Ingreso IP - InserciÃ³n'),(575,165,'190.131.197.10','gpinilla','root@localhost','2018-03-07 21:31:06','Ingreso IP - InserciÃ³n'),(576,166,'190.131.197.10','gpinilla','root@localhost','2018-03-07 21:32:23','Ingreso IP - InserciÃ³n'),(577,167,'190.131.197.10','gpinilla','root@localhost','2018-03-07 21:33:50','Ingreso IP - InserciÃ³n'),(579,169,'190.131.197.10','gpinilla','root@localhost','2018-03-07 21:36:14','Ingreso IP - InserciÃ³n'),(583,171,'200.31.17.253','mbarrios','root@localhost','2018-03-08 22:30:25','Ingreso IP - InserciÃ³n'),(584,171,'190.25.232.76','mbarrios','root@localhost','2018-03-08 22:30:25','Ingreso IP - InserciÃ³n'),(585,171,'179.0.15.132','mbarrios','root@localhost','2018-03-08 22:30:25','Ingreso IP - InserciÃ³n'),(586,172,'190.242.103.54','jperez','root@localhost','2018-03-09 19:26:57','Ingreso IP - InserciÃ³n'),(587,172,'190.131.250.74','jperez','root@localhost','2018-03-09 19:26:57','Ingreso IP - InserciÃ³n'),(588,173,'190.242.103.54','jperez','root@localhost','2018-03-09 19:29:21','Ingreso IP - InserciÃ³n'),(589,173,'190.131.250.74','jperez','root@localhost','2018-03-09 19:29:21','Ingreso IP - InserciÃ³n'),(603,175,'200.41.79.94','jpineda','root@localhost','2018-03-12 18:20:44','Ingreso IP - InserciÃ³n'),(604,175,'200.14.232.217','jpineda','root@localhost','2018-03-12 18:20:44','Ingreso IP - InserciÃ³n'),(605,175,'200.41.79.93','jpineda','root@localhost','2018-03-12 18:20:44','Ingreso IP - InserciÃ³n'),(606,176,'200.41.79.94','jpineda','root@localhost','2018-03-12 18:22:28','Ingreso IP - InserciÃ³n'),(607,176,'200.14.232.217','jpineda','root@localhost','2018-03-12 18:22:28','Ingreso IP - InserciÃ³n'),(608,176,'200.41.79.93','jpineda','root@localhost','2018-03-12 18:22:28','Ingreso IP - InserciÃ³n'),(609,177,'200.41.79.93','jpineda','root@localhost','2018-03-12 19:10:14','Ingreso IP - InserciÃ³n'),(610,177,'200.41.79.94','jpineda','root@localhost','2018-03-12 19:10:14','Ingreso IP - InserciÃ³n'),(611,177,'200.14.232.217','jpineda','root@localhost','2018-03-12 19:10:14','Ingreso IP - InserciÃ³n'),(618,125,'192.168.128.15','esouza','root@localhost','2018-03-12 20:15:04','Ingreso IP - ModificaciÃ³n'),(619,125,'192.168.85.30','esouza','root@localhost','2018-03-12 20:15:04','Ingreso IP - ModificaciÃ³n'),(620,125,'192.168.245.104','esouza','root@localhost','2018-03-12 20:15:04','Ingreso IP - InserciÃ³n'),(624,180,'200.14.232.217','jpineda','root@localhost','2018-03-12 21:17:12','Ingreso IP - InserciÃ³n'),(625,180,'200.41.79.93','jpineda','root@localhost','2018-03-12 21:17:12','Ingreso IP - InserciÃ³n'),(626,180,'200.41.79.94','jpineda','root@localhost','2018-03-12 21:17:12','Ingreso IP - InserciÃ³n'),(633,123,'190.131.224.67','esouza','root@localhost','2018-03-14 18:49:51','Ingreso IP - ModificaciÃ³n'),(634,123,'200.41.7.154','esouza','root@localhost','2018-03-14 18:49:51','Ingreso IP - ModificaciÃ³n'),(635,123,'64.76.56.218','esouza','root@localhost','2018-03-14 18:49:51','Ingreso IP - ModificaciÃ³n'),(636,140,'64.76.56.218','mrosales','root@localhost','2018-03-14 18:59:56','Ingreso IP - ModificaciÃ³n'),(637,140,'200.41.7.154','mrosales','root@localhost','2018-03-14 18:59:56','Ingreso IP - ModificaciÃ³n'),(638,181,'64.76.56.218','mrosales','root@localhost','2018-03-14 19:03:52','Ingreso IP - InserciÃ³n'),(639,181,'200.41.7.154','mrosales','root@localhost','2018-03-14 19:03:52','Ingreso IP - InserciÃ³n'),(646,182,'190.131.245.92','esouza','root@localhost','2018-03-15 18:57:05','Ingreso IP - InserciÃ³n'),(647,182,'190.131.245.93','esouza','root@localhost','2018-03-15 18:57:05','Ingreso IP - InserciÃ³n'),(648,182,'190.131.245.94','esouza','root@localhost','2018-03-15 18:57:05','Ingreso IP - InserciÃ³n'),(649,170,'200.31.17.253','mbarrios','root@localhost','2018-03-15 20:09:07','Ingreso IP - ModificaciÃ³n'),(650,170,'190.25.232.76','mbarrios','root@localhost','2018-03-15 20:09:07','Ingreso IP - ModificaciÃ³n'),(651,170,'179.0.15.132','mbarrios','root@localhost','2018-03-15 20:09:07','Ingreso IP - ModificaciÃ³n'),(659,184,'190.131.245.92','ajimenez','root@localhost','2018-03-16 21:24:13','Ingreso IP - ModificaciÃ³n'),(660,141,'199.67.131.157','jparra','root@localhost','2018-03-16 23:26:16','Ingreso IP - ModificaciÃ³n'),(667,174,'200.41.79.93','jparra','root@localhost','2018-03-17 00:40:49','Ingreso IP - ModificaciÃ³n'),(668,174,'200.14.232.217','jparra','root@localhost','2018-03-17 00:40:49','Ingreso IP - ModificaciÃ³n'),(669,174,'200.41.79.94','jparra','root@localhost','2018-03-17 00:40:49','Ingreso IP - ModificaciÃ³n'),(682,179,'200.14.232.217','jpineda','root@localhost','2018-03-21 19:38:25','Ingreso IP - ModificaciÃ³n'),(683,179,'200.41.79.93','jpineda','root@localhost','2018-03-21 19:38:25','Ingreso IP - ModificaciÃ³n'),(684,179,'200.41.79.94','jpineda','root@localhost','2018-03-21 19:38:25','Ingreso IP - ModificaciÃ³n'),(686,187,'190.66.4.253','ygarcia','root@localhost','2018-03-21 20:52:14','Ingreso IP - InserciÃ³n'),(688,189,'199.67.131.157','alara','root@localhost','2018-03-22 00:18:38','Ingreso IP - InserciÃ³n'),(689,190,'199.67.131.157','alara','root@localhost','2018-03-22 00:20:29','Ingreso IP - InserciÃ³n'),(690,159,'190.131.244.230','kapanader','root@localhost','2018-03-22 20:07:32','Ingreso IP - ModificaciÃ³n'),(691,146,'200.030.110.139','jherrera','root@localhost','2018-03-22 21:55:12','Ingreso IP - ModificaciÃ³n'),(692,146,'190.66.2.204','jherrera','root@localhost','2018-03-22 21:55:12','Ingreso IP - ModificaciÃ³n'),(693,146,'172.23.22.114','jherrera','root@localhost','2018-03-22 21:55:12','Ingreso IP - ModificaciÃ³n'),(695,136,'201.221.124.8','evelasquez','root@localhost','2018-03-23 21:51:06','Ingreso IP - ModificaciÃ³n'),(706,186,'190.66.4.253','ygarcia','root@localhost','2018-04-04 21:23:11','Ingreso IP - ModificaciÃ³n'),(707,152,'190.242.58.26','kapanader','root@localhost','2018-04-05 19:27:39','Ingreso IP - ModificaciÃ³n'),(709,188,'190.66.4.253','ygarcia','root@localhost','2018-04-09 19:25:06','Ingreso IP - ModificaciÃ³n'),(710,155,'190.131.244.230','kapanader','root@localhost','2018-04-12 18:34:39','Ingreso IP - ModificaciÃ³n'),(711,143,'190.131.240.114','ecastaneda','root@localhost','2018-04-12 20:21:45','Ingreso IP - ModificaciÃ³n'),(712,142,'190.131.240.114','ecastaneda','root@localhost','2018-04-12 20:22:05','Ingreso IP - ModificaciÃ³n'),(713,153,'190.242.58.26','kapanader','root@localhost','2018-04-13 19:03:15','Ingreso IP - ModificaciÃ³n'),(714,164,'190.131.197.10','esouza','root@localhost','2018-04-13 20:49:53','Ingreso IP - ModificaciÃ³n'),(715,164,'190.131.197.11','esouza','root@localhost','2018-04-13 20:49:53','Ingreso IP - ModificaciÃ³n'),(716,183,'201.234.245.253','esouza','root@localhost','2018-04-13 21:32:02','Ingreso IP - ModificaciÃ³n'),(717,183,'190.66.4.253','esouza','root@localhost','2018-04-13 21:32:02','Ingreso IP - ModificaciÃ³n'),(718,183,'82.255.167.69','esouza','root@localhost','2018-04-13 21:32:02','Ingreso IP - ModificaciÃ³n'),(719,168,'190.131.197.10','gpinilla','root@localhost','2018-04-13 21:42:42','Ingreso IP - ModificaciÃ³n'),(726,158,'190.131.244.230','kapanader','root@localhost','2018-04-16 18:42:04','Ingreso IP - ModificaciÃ³n'),(727,151,'190.242.36.50','esouza','root@localhost','2018-04-17 21:19:32','Ingreso IP - ModificaciÃ³n'),(729,156,'190.131.244.230','kapanader','root@localhost','2018-04-17 22:02:59','Ingreso IP - ModificaciÃ³n'),(733,178,'200.41.79.93','jpineda','root@localhost','2018-04-18 19:59:59','Ingreso IP - ModificaciÃ³n'),(734,178,'200.41.79.94','jpineda','root@localhost','2018-04-18 19:59:59','Ingreso IP - ModificaciÃ³n'),(735,178,'200.14.232.217','jpineda','root@localhost','2018-04-18 19:59:59','Ingreso IP - ModificaciÃ³n'),(856,120,'192.168.85.204','admin','root@localhost','2018-05-28 21:32:36','Ingreso IP - ModificaciÃ³n'),(857,120,'190.242.39.139','admin','root@localhost','2018-05-28 21:32:36','Ingreso IP - ModificaciÃ³n'),(858,120,'190.131.244.209','admin','root@localhost','2018-05-28 21:32:36','Ingreso IP - ModificaciÃ³n'),(1007,1,'190.242.39.136',NULL,'root@localhost',NULL,NULL),(1208,304,'172.28.1.65','admin','root@localhost','2019-05-16 21:36:14','Ingreso IP - InserciÃ³n'),(1209,304,'190.242.39.136','admin','root@localhost','2019-05-16 21:36:14','Ingreso IP - InserciÃ³n'),(1210,304,'192.168.26.180','admin','root@localhost','2019-05-16 21:36:14','Ingreso IP - InserciÃ³n'),(1265,313,'190.131.240.114','esouza','root@localhost','2019-06-26 03:08:52','Ingreso IP - InserciÃ³n'),(1266,313,'190.216.157.114','esouza','root@localhost','2019-06-26 03:08:52','Ingreso IP - InserciÃ³n'),(1267,313,'190.131.252.99','esouza','root@localhost','2019-06-26 03:08:52','Ingreso IP - InserciÃ³n'),(1268,314,'190.131.197.10','asalgado','root@localhost','2019-06-26 03:53:53','Ingreso IP - InserciÃ³n'),(1269,314,'190.131.197.11','asalgado','root@localhost','2019-06-26 03:53:53','Ingreso IP - InserciÃ³n'),(1270,315,'190.131.250.74','asalgado','root@localhost','2019-06-26 05:06:47','Ingreso IP - InserciÃ³n'),(1271,315,'190.242.103.54','asalgado','root@localhost','2019-06-26 05:06:47','Ingreso IP - InserciÃ³n'),(1275,317,'190.216.141.187','asalgado','root@localhost','2019-06-26 05:41:25','Ingreso IP - InserciÃ³n'),(1276,318,'200.030.110.139','asalgado','root@localhost','2019-06-26 06:38:36','Ingreso IP - InserciÃ³n'),(1277,318,'190.66.2.204','asalgado','root@localhost','2019-06-26 06:38:36','Ingreso IP - InserciÃ³n'),(1278,318,'181.236.217.20','asalgado','root@localhost','2019-06-26 06:38:36','Ingreso IP - InserciÃ³n'),(1283,323,'190.216.141.187','lgutierrez','root@localhost','2019-06-26 19:04:10','Ingreso IP - InserciÃ³n'),(1285,325,'190.216.141.187','lgutierrez','root@localhost','2019-06-26 19:08:59','Ingreso IP - InserciÃ³n'),(1288,328,'190.131.244.230','kapanader','root@localhost','2019-06-26 19:19:26','Ingreso IP - InserciÃ³n'),(1289,329,'190.131.244.230','kapanader','root@localhost','2019-06-26 19:20:17','Ingreso IP - InserciÃ³n'),(1290,330,'190.131.244.230','kapanader','root@localhost','2019-06-26 19:21:07','Ingreso IP - InserciÃ³n'),(1293,332,'190.131.244.230','kapanader','root@localhost','2019-06-26 19:23:47','Ingreso IP - InserciÃ³n'),(1294,333,'190.131.197.10','gpinilla','root@localhost','2019-06-26 19:27:40','Ingreso IP - InserciÃ³n'),(1295,333,'190.27.199.62','gpinilla','root@localhost','2019-06-26 19:27:40','Ingreso IP - InserciÃ³n'),(1296,334,'64.76.56.218','mrosales','root@localhost','2019-06-26 19:28:11','Ingreso IP - InserciÃ³n'),(1297,334,'200.41.7.154','mrosales','root@localhost','2019-06-26 19:28:11','Ingreso IP - InserciÃ³n'),(1300,336,'64.76.56.218','mrosales','root@localhost','2019-06-26 19:35:44','Ingreso IP - InserciÃ³n'),(1301,336,'200.41.7.154','mrosales','root@localhost','2019-06-26 19:35:44','Ingreso IP - InserciÃ³n'),(1302,331,'64.76.56.218','mrosales','root@localhost','2019-06-26 19:36:00','Ingreso IP - ModificaciÃ³n'),(1303,331,'200.41.7.154','mrosales','root@localhost','2019-06-26 19:36:00','Ingreso IP - ModificaciÃ³n'),(1304,337,'190.242.103.54','jperez','root@localhost','2019-06-26 19:38:30','Ingreso IP - InserciÃ³n'),(1305,337,'190.131.250.74','jperez','root@localhost','2019-06-26 19:38:30','Ingreso IP - InserciÃ³n'),(1306,338,'190.242.103.54','jperez','root@localhost','2019-06-26 19:41:44','Ingreso IP - InserciÃ³n'),(1307,338,'190.131.250.74','jperez','root@localhost','2019-06-26 19:41:44','Ingreso IP - InserciÃ³n'),(1308,339,'190.131.197.10','gpinilla','root@localhost','2019-06-26 19:49:30','Ingreso IP - InserciÃ³n'),(1309,339,'190.27.199.62','gpinilla','root@localhost','2019-06-26 19:49:30','Ingreso IP - InserciÃ³n'),(1311,341,'186.155.241.196','esouza','root@localhost','2019-06-26 20:02:00','Ingreso IP - InserciÃ³n'),(1312,341,'190.131.201.70','esouza','root@localhost','2019-06-26 20:02:00','Ingreso IP - InserciÃ³n'),(1313,341,'190.242.96.250','esouza','root@localhost','2019-06-26 20:02:00','Ingreso IP - InserciÃ³n'),(1314,324,'190.0.24.67','lgutierrez','root@localhost','2019-06-26 20:04:10','Ingreso IP - ModificaciÃ³n'),(1319,344,'190.131.240.114','ecastaneda','root@localhost','2019-06-26 20:52:30','Ingreso IP - InserciÃ³n'),(1320,344,'190.216.157.114','ecastaneda','root@localhost','2019-06-26 20:52:30','Ingreso IP - InserciÃ³n'),(1321,344,'190.131.252.99','ecastaneda','root@localhost','2019-06-26 20:52:30','Ingreso IP - InserciÃ³n'),(1322,345,'190.131.240.114','ecastaneda','root@localhost','2019-06-26 20:54:43','Ingreso IP - InserciÃ³n'),(1323,345,'190.216.157.114','ecastaneda','root@localhost','2019-06-26 20:54:43','Ingreso IP - InserciÃ³n'),(1324,345,'190.131.252.99','ecastaneda','root@localhost','2019-06-26 20:54:43','Ingreso IP - InserciÃ³n'),(1325,346,'190.131.240.114','ecastaneda','root@localhost','2019-06-26 20:56:40','Ingreso IP - InserciÃ³n'),(1326,346,'190.216.157.114','ecastaneda','root@localhost','2019-06-26 20:56:40','Ingreso IP - InserciÃ³n'),(1327,346,'190.131.252.99','ecastaneda','root@localhost','2019-06-26 20:56:40','Ingreso IP - InserciÃ³n'),(1328,335,'190.131.197.10','gpinilla','root@localhost','2019-06-26 21:41:56','Ingreso IP - ModificaciÃ³n'),(1329,335,'190.27.199.62','gpinilla','root@localhost','2019-06-26 21:41:56','Ingreso IP - ModificaciÃ³n'),(1336,349,'200.030.110.139','amendieta','root@localhost','2019-06-27 01:19:09','Ingreso IP - InserciÃ³n'),(1337,349,'190.66.2.204','amendieta','root@localhost','2019-06-27 01:19:09','Ingreso IP - InserciÃ³n'),(1338,349,'181.236.217.20','amendieta','root@localhost','2019-06-27 01:19:09','Ingreso IP - InserciÃ³n'),(1339,350,'200.14.232.217','asalgado','root@localhost','2019-06-27 01:56:12','Ingreso IP - InserciÃ³n'),(1340,350,'190.66.13.169','asalgado','root@localhost','2019-06-27 01:56:12','Ingreso IP - InserciÃ³n'),(1341,350,'186.119.118.211','asalgado','root@localhost','2019-06-27 01:56:12','Ingreso IP - InserciÃ³n'),(1342,351,'200.31.17.253','asalgado','root@localhost','2019-06-27 02:35:52','Ingreso IP - InserciÃ³n'),(1343,351,'190.25.232.76','asalgado','root@localhost','2019-06-27 02:35:52','Ingreso IP - InserciÃ³n'),(1344,351,'179.0.15.132','asalgado','root@localhost','2019-06-27 02:35:52','Ingreso IP - InserciÃ³n'),(1348,353,'190.143.111.130','mcastaneda','root@localhost','2019-06-28 18:30:01','Ingreso IP - InserciÃ³n'),(1349,353,'201.245.161.224','mcastaneda','root@localhost','2019-06-28 18:30:01','Ingreso IP - InserciÃ³n'),(1350,353,'200.119.83.128','mcastaneda','root@localhost','2019-06-28 18:30:01','Ingreso IP - InserciÃ³n'),(1351,354,'190.143.111.130','mcastaneda','root@localhost','2019-06-28 18:32:40','Ingreso IP - InserciÃ³n'),(1352,354,'201.245.161.224','mcastaneda','root@localhost','2019-06-28 18:32:40','Ingreso IP - InserciÃ³n'),(1353,354,'200.119.83.128','mcastaneda','root@localhost','2019-06-28 18:32:40','Ingreso IP - InserciÃ³n'),(1361,355,'179.0.15.132','mbarrios','root@localhost','2019-06-28 20:08:27','Ingreso IP - InserciÃ³n'),(1362,355,'200.31.17.253','mbarrios','root@localhost','2019-06-28 20:08:27','Ingreso IP - InserciÃ³n'),(1363,355,'190.25.232.76','mbarrios','root@localhost','2019-06-28 20:08:27','Ingreso IP - InserciÃ³n'),(1364,356,'179.0.15.132','mbarrios','root@localhost','2019-06-28 20:11:57','Ingreso IP - InserciÃ³n'),(1365,356,'200.31.17.253','mbarrios','root@localhost','2019-06-28 20:11:57','Ingreso IP - InserciÃ³n'),(1366,356,'190.25.232.76','mbarrios','root@localhost','2019-06-28 20:11:57','Ingreso IP - InserciÃ³n'),(1367,327,'190.242.36.50','kapanader','root@localhost','2019-06-28 20:39:54','Ingreso IP - ModificaciÃ³n'),(1368,357,'190.66.13.169','jpineda','root@localhost','2019-06-28 22:22:29','Ingreso IP - InserciÃ³n'),(1369,357,'200.14.232.217','jpineda','root@localhost','2019-06-28 22:22:29','Ingreso IP - InserciÃ³n'),(1370,357,'186.119.118.211','jpineda','root@localhost','2019-06-28 22:22:29','Ingreso IP - InserciÃ³n'),(1371,358,'200.14.232.217','jpineda','root@localhost','2019-06-28 22:28:42','Ingreso IP - InserciÃ³n'),(1372,358,'190.66.13.169','jpineda','root@localhost','2019-06-28 22:28:42','Ingreso IP - InserciÃ³n'),(1373,358,'186.119.118.211','jpineda','root@localhost','2019-06-28 22:28:42','Ingreso IP - InserciÃ³n'),(1380,316,'190.66.4.253','asalgado','root@localhost','2019-07-02 20:38:35','Ingreso IP - ModificaciÃ³n'),(1381,316,'82.0.53.155','asalgado','root@localhost','2019-07-02 20:38:35','Ingreso IP - ModificaciÃ³n'),(1382,316,'82.0.54.179','asalgado','root@localhost','2019-07-02 20:38:35','Ingreso IP - ModificaciÃ³n'),(1383,359,'200.14.232.217','jpineda','root@localhost','2019-07-02 21:17:32','Ingreso IP - InserciÃ³n'),(1384,359,'190.66.13.169','jpineda','root@localhost','2019-07-02 21:17:32','Ingreso IP - InserciÃ³n'),(1385,359,'186.119.118.211','jpineda','root@localhost','2019-07-02 21:17:32','Ingreso IP - InserciÃ³n'),(1386,360,'200.14.232.217','jpineda','root@localhost','2019-07-02 21:20:44','Ingreso IP - InserciÃ³n'),(1387,360,'190.66.13.169','jpineda','root@localhost','2019-07-02 21:20:44','Ingreso IP - InserciÃ³n'),(1388,360,'186.119.118.211','jpineda','root@localhost','2019-07-02 21:20:44','Ingreso IP - InserciÃ³n'),(1392,361,'190.66.4.253','ygarcia','root@localhost','2019-07-03 00:56:20','Ingreso IP - InserciÃ³n'),(1396,326,'190.242.36.50','kapanader','root@localhost','2019-07-03 19:23:15','Ingreso IP - ModificaciÃ³n'),(1397,310,'181.143.34.114','asalgado','root@localhost','2019-07-03 22:34:23','Ingreso IP - ModificaciÃ³n'),(1398,310,'181.143.34.115','asalgado','root@localhost','2019-07-03 22:34:23','Ingreso IP - ModificaciÃ³n'),(1399,310,'181.143.34.116','asalgado','root@localhost','2019-07-03 22:34:23','Ingreso IP - ModificaciÃ³n'),(1400,363,'181.143.34.114','suribe','root@localhost','2019-07-03 22:39:18','Ingreso IP - InserciÃ³n'),(1401,363,'181.143.34.115','suribe','root@localhost','2019-07-03 22:39:18','Ingreso IP - InserciÃ³n'),(1402,363,'181.143.34.116','suribe','root@localhost','2019-07-03 22:39:18','Ingreso IP - InserciÃ³n'),(1403,364,'181.143.34.114','suribe','root@localhost','2019-07-03 22:44:30','Ingreso IP - InserciÃ³n'),(1404,364,'181.143.34.115','suribe','root@localhost','2019-07-03 22:44:30','Ingreso IP - InserciÃ³n'),(1405,364,'181.143.34.116','suribe','root@localhost','2019-07-03 22:44:30','Ingreso IP - InserciÃ³n'),(1409,343,'190.131.201.70','jmendez','root@localhost','2019-07-04 00:11:26','Ingreso IP - ModificaciÃ³n'),(1410,343,'186.155.241.196','jmendez','root@localhost','2019-07-04 00:11:26','Ingreso IP - ModificaciÃ³n'),(1411,343,'190.242.96.250','jmendez','root@localhost','2019-07-04 00:11:26','Ingreso IP - ModificaciÃ³n'),(1412,347,'190.131.201.70','jmendez','root@localhost','2019-07-04 19:55:10','Ingreso IP - ModificaciÃ³n'),(1413,347,'190.242.96.250','jmendez','root@localhost','2019-07-04 19:55:10','Ingreso IP - ModificaciÃ³n'),(1414,347,'186.155.241.196','jmendez','root@localhost','2019-07-04 19:55:10','Ingreso IP - ModificaciÃ³n'),(1415,321,'201.221.124.8','edvelasq','root@localhost','2019-07-05 00:43:37','Ingreso IP - ModificaciÃ³n'),(1416,321,'201.221.125.136','edvelasq','root@localhost','2019-07-05 00:43:37','Ingreso IP - ModificaciÃ³n'),(1417,321,'200.1.175.202','edvelasq','root@localhost','2019-07-05 00:43:37','Ingreso IP - ModificaciÃ³n'),(1421,319,'201.221.124.8','edvelasq','root@localhost','2019-07-05 00:44:25','Ingreso IP - ModificaciÃ³n'),(1422,319,'201.221.125.136','edvelasq','root@localhost','2019-07-05 00:44:25','Ingreso IP - ModificaciÃ³n'),(1423,319,'200.1.175.202','edvelasq','root@localhost','2019-07-05 00:44:25','Ingreso IP - ModificaciÃ³n'),(1424,322,'201.221.124.8','edvelasq','root@localhost','2019-07-05 00:44:40','Ingreso IP - ModificaciÃ³n'),(1425,322,'201.221.125.136','edvelasq','root@localhost','2019-07-05 00:44:40','Ingreso IP - ModificaciÃ³n'),(1426,322,'200.1.175.202','edvelasq','root@localhost','2019-07-05 00:44:40','Ingreso IP - ModificaciÃ³n'),(1427,365,'200.3.147.16','asalgado','root@localhost','2019-07-09 00:32:58','Ingreso IP - InserciÃ³n'),(1428,365,'205.210.223.133','asalgado','root@localhost','2019-07-09 00:32:58','Ingreso IP - InserciÃ³n'),(1434,368,'205.210.222.150','npachon','root@localhost','2019-07-09 20:44:44','Ingreso IP - InserciÃ³n'),(1435,368,'10.234.137.105','npachon','root@localhost','2019-07-09 20:44:44','Ingreso IP - InserciÃ³n'),(1436,367,'205.210.222.150','npachon','root@localhost','2019-07-09 20:44:57','Ingreso IP - ModificaciÃ³n'),(1437,367,'10.234.137.105','npachon','root@localhost','2019-07-09 20:44:57','Ingreso IP - ModificaciÃ³n'),(1438,348,'190.131.201.70','jmendez','root@localhost','2019-07-09 22:56:18','Ingreso IP - ModificaciÃ³n'),(1439,348,'190.242.96.250','jmendez','root@localhost','2019-07-09 22:56:18','Ingreso IP - ModificaciÃ³n'),(1440,348,'186.155.241.196','jmendez','root@localhost','2019-07-09 22:56:18','Ingreso IP - ModificaciÃ³n'),(1441,369,'190.131.201.70','jmendez','root@localhost','2019-07-10 04:56:34','Ingreso IP - InserciÃ³n'),(1442,369,'186.155.241.196','jmendez','root@localhost','2019-07-10 04:56:34','Ingreso IP - InserciÃ³n'),(1443,369,'190.242.96.250','jmendez','root@localhost','2019-07-10 04:56:34','Ingreso IP - InserciÃ³n'),(1447,362,'190.66.4.252','esouza','root@localhost','2019-07-10 21:34:34','Ingreso IP - ModificaciÃ³n'),(1448,362,'190.66.4.253','esouza','root@localhost','2019-07-10 21:34:34','Ingreso IP - ModificaciÃ³n'),(1452,366,'200.14.232.217','jpineda','root@localhost','2019-07-11 22:47:32','Ingreso IP - ModificaciÃ³n'),(1453,366,'190.66.13.169','jpineda','root@localhost','2019-07-11 22:47:32','Ingreso IP - ModificaciÃ³n'),(1454,366,'186.119.118.211','jpineda','root@localhost','2019-07-11 22:47:32','Ingreso IP - ModificaciÃ³n'),(1457,311,'201.221.125.136','asalgado','root@localhost','2019-07-12 03:01:49','Ingreso IP - ModificaciÃ³n'),(1458,311,'200.1.175.202','asalgado','root@localhost','2019-07-12 03:01:49','Ingreso IP - ModificaciÃ³n'),(1459,320,'201.221.124.8','edvelasq','root@localhost','2019-07-12 03:14:15','Ingreso IP - ModificaciÃ³n'),(1460,320,'201.221.125.136','edvelasq','root@localhost','2019-07-12 03:14:15','Ingreso IP - ModificaciÃ³n'),(1461,320,'200.1.175.202','edvelasq','root@localhost','2019-07-12 03:14:15','Ingreso IP - ModificaciÃ³n'),(1481,370,'190.242.39.136','asalgado','root@localhost','2019-10-21 22:08:57','Ingreso IP - Modificación'),(1482,370,'190.168.128.13','asalgado','root@localhost','2019-10-21 22:08:57','Ingreso IP - Modificación'),(1483,370,'201.216.46.129','asalgado','root@localhost','2019-10-21 22:08:57','Ingreso IP - Modificación'),(1487,371,'190.242.39.136','dcastanoprueba','root@localhost','2019-10-21 22:36:04','Ingreso IP - Modificación'),(1488,371,'190.168.128.13','dcastanoprueba','root@localhost','2019-10-21 22:36:04','Ingreso IP - Modificación'),(1489,309,'64.76.56.218','etriana','root@localhost','2019-10-23 23:03:17','Ingreso IP - Modificación'),(1490,309,'200.41.7.154','etriana','root@localhost','2019-10-23 23:03:17','Ingreso IP - Modificación'),(1491,352,'190.143.111.130','etriana','root@localhost','2019-10-23 23:24:07','Ingreso IP - Modificación'),(1492,352,'201.245.161.224','etriana','root@localhost','2019-10-23 23:24:07','Ingreso IP - Modificación'),(1493,352,'200.119.83.128','etriana','root@localhost','2019-10-23 23:24:07','Ingreso IP - Modificación'),(1494,312,'190.242.36.50','etriana','root@localhost','2019-10-24 00:02:37','Ingreso IP - Modificación'),(1503,375,'201.221.124.8','asalgado','root@localhost','2019-10-24 16:36:44','Ingreso IP - Inserción'),(1504,376,'190.242.36.50','asalgado','root@localhost','2019-10-24 17:11:18','Ingreso IP - Inserción'),(1505,377,'190.242.103.54','etriana','root@localhost','2019-10-24 20:42:07','Ingreso IP - Inserción'),(1506,377,'190.131.250.74','etriana','root@localhost','2019-10-24 20:42:08','Ingreso IP - Inserción'),(1513,379,'190.131.197.10','asalgado','root@localhost','2019-10-24 23:39:37','Ingreso IP - Inserción'),(1514,379,'190.131.197.11','asalgado','root@localhost','2019-10-24 23:39:37','Ingreso IP - Inserción'),(1518,380,'190.66.4.251','asalgado','root@localhost','2019-10-24 23:53:33','Ingreso IP - Modificación'),(1519,380,'190.66.4.253','asalgado','root@localhost','2019-10-24 23:53:33','Ingreso IP - Modificación'),(1520,380,'190.66.4.252','asalgado','root@localhost','2019-10-24 23:53:33','Ingreso IP - Modificación'),(1522,382,'190.216.141.187','lgutierrez','root@localhost','2019-10-25 13:35:54','Ingreso IP - Inserción'),(1526,384,'201.221.124.8','evelasquez','root@localhost','2019-10-25 13:54:06','Ingreso IP - Inserción'),(1527,384,'201.221.125.136','evelasquez','root@localhost','2019-10-25 13:54:06','Ingreso IP - Inserción'),(1528,384,'200.1.175.202','evelasquez','root@localhost','2019-10-25 13:54:06','Ingreso IP - Inserción'),(1529,385,'201.221.124.8','evelasquez','root@localhost','2019-10-25 13:55:45','Ingreso IP - Inserción'),(1530,385,'201.221.125.136','evelasquez','root@localhost','2019-10-25 13:55:45','Ingreso IP - Inserción'),(1531,385,'200.1.175.202','evelasquez','root@localhost','2019-10-25 13:55:45','Ingreso IP - Inserción'),(1532,386,'201.221.124.8','evelasquez','root@localhost','2019-10-25 13:58:03','Ingreso IP - Inserción'),(1533,386,'201.221.125.136','evelasquez','root@localhost','2019-10-25 13:58:03','Ingreso IP - Inserción'),(1534,386,'200.1.175.202','evelasquez','root@localhost','2019-10-25 13:58:03','Ingreso IP - Inserción'),(1541,387,'64.76.56.218','etriana','root@localhost','2019-10-25 14:04:15','Ingreso IP - Modificación'),(1542,387,'200.41.7.154','etriana','root@localhost','2019-10-25 14:04:15','Ingreso IP - Modificación'),(1543,388,'64.76.56.218','mrosales','root@localhost','2019-10-25 14:11:23','Ingreso IP - Inserción'),(1544,388,'200.41.7.154','mrosales','root@localhost','2019-10-25 14:11:23','Ingreso IP - Inserción'),(1545,389,'64.76.56.218','mrosales','root@localhost','2019-10-25 14:13:40','Ingreso IP - Inserción'),(1546,389,'200.41.7.154','mrosales','root@localhost','2019-10-25 14:13:40','Ingreso IP - Inserción'),(1547,390,'190.143.111.130','etriana','root@localhost','2019-10-25 14:16:57','Ingreso IP - Inserción'),(1548,390,'201.245.161.224','etriana','root@localhost','2019-10-25 14:16:57','Ingreso IP - Inserción'),(1549,390,'200.119.83.128','etriana','root@localhost','2019-10-25 14:16:57','Ingreso IP - Inserción'),(1550,391,'190.242.103.54','jperez','root@localhost','2019-10-25 14:18:20','Ingreso IP - Inserción'),(1551,391,'190.131.250.74','jperez','root@localhost','2019-10-25 14:18:20','Ingreso IP - Inserción'),(1552,392,'190.242.103.54','jperez','root@localhost','2019-10-25 14:20:23','Ingreso IP - Inserción'),(1553,392,'190.131.250.74','jperez','root@localhost','2019-10-25 14:20:23','Ingreso IP - Inserción'),(1560,395,'190.143.111.130','mcastaneda','root@localhost','2019-10-25 14:25:26','Ingreso IP - Inserción'),(1561,395,'201.245.173.130','mcastaneda','root@localhost','2019-10-25 14:25:26','Ingreso IP - Inserción'),(1562,395,'200.119.83.130','mcastaneda','root@localhost','2019-10-25 14:25:26','Ingreso IP - Inserción'),(1563,396,'190.131.240.114','ecastaneda','root@localhost','2019-10-25 15:26:21','Ingreso IP - Inserción'),(1564,396,'190.216.157.114','ecastaneda','root@localhost','2019-10-25 15:26:21','Ingreso IP - Inserción'),(1565,396,'190.131.252.99','ecastaneda','root@localhost','2019-10-25 15:26:21','Ingreso IP - Inserción'),(1569,398,'190.131.240.114','ecastaneda','root@localhost','2019-10-25 15:30:50','Ingreso IP - Inserción'),(1570,398,'190.216.157.114','ecastaneda','root@localhost','2019-10-25 15:30:50','Ingreso IP - Inserción'),(1571,398,'190.131.252.99','ecastaneda','root@localhost','2019-10-25 15:30:50','Ingreso IP - Inserción'),(1572,399,'190.66.4.251','aocampo','root@localhost','2019-10-25 15:49:38','Ingreso IP - Inserción'),(1573,399,'190.66.4.253','aocampo','root@localhost','2019-10-25 15:49:38','Ingreso IP - Inserción'),(1574,399,'190.66.4.252','aocampo','root@localhost','2019-10-25 15:49:38','Ingreso IP - Inserción'),(1575,400,'190.66.4.251','aocampo','root@localhost','2019-10-25 15:52:21','Ingreso IP - Inserción'),(1576,400,'190.66.4.253','aocampo','root@localhost','2019-10-25 15:52:21','Ingreso IP - Inserción'),(1577,400,'190.66.4.252','aocampo','root@localhost','2019-10-25 15:52:21','Ingreso IP - Inserción'),(1578,401,'186.155.241.196','asalgado','root@localhost','2019-10-25 16:31:19','Ingreso IP - Inserción'),(1579,401,'190.131.201.70','asalgado','root@localhost','2019-10-25 16:31:19','Ingreso IP - Inserción'),(1580,401,'190.242.96.250','asalgado','root@localhost','2019-10-25 16:31:19','Ingreso IP - Inserción'),(1581,402,'181.143.34.114','asalgado','root@localhost','2019-10-25 16:38:28','Ingreso IP - Inserción'),(1582,402,'181.143.34.115','asalgado','root@localhost','2019-10-25 16:38:28','Ingreso IP - Inserción'),(1583,402,'181.143.34.116','asalgado','root@localhost','2019-10-25 16:38:28','Ingreso IP - Inserción'),(1584,403,'186.155.241.196','jmendez','root@localhost','2019-10-25 16:55:15','Ingreso IP - Inserción'),(1585,403,'190.131.201.70','jmendez','root@localhost','2019-10-25 16:55:15','Ingreso IP - Inserción'),(1586,403,'190.242.96.250','jmendez','root@localhost','2019-10-25 16:55:15','Ingreso IP - Inserción'),(1587,404,'186.155.241.196','jmendez','root@localhost','2019-10-25 17:07:29','Ingreso IP - Inserción'),(1588,404,'190.131.201.70','jmendez','root@localhost','2019-10-25 17:07:29','Ingreso IP - Inserción'),(1589,404,'190.242.96.250','jmendez','root@localhost','2019-10-25 17:07:29','Ingreso IP - Inserción'),(1590,405,'186.155.241.196','jmendez','root@localhost','2019-10-25 17:09:52','Ingreso IP - Inserción'),(1591,405,'190.131.201.70','jmendez','root@localhost','2019-10-25 17:09:52','Ingreso IP - Inserción'),(1592,405,'190.242.96.250','jmendez','root@localhost','2019-10-25 17:09:52','Ingreso IP - Inserción'),(1593,406,'186.155.241.196','jmendez','root@localhost','2019-10-25 17:12:36','Ingreso IP - Inserción'),(1594,406,'190.131.201.70','jmendez','root@localhost','2019-10-25 17:12:36','Ingreso IP - Inserción'),(1595,406,'190.242.96.250','jmendez','root@localhost','2019-10-25 17:12:36','Ingreso IP - Inserción'),(1596,407,'186.155.241.196','jmendez','root@localhost','2019-10-25 17:16:27','Ingreso IP - Inserción'),(1597,407,'190.131.201.70','jmendez','root@localhost','2019-10-25 17:16:27','Ingreso IP - Inserción'),(1598,407,'190.242.96.250','jmendez','root@localhost','2019-10-25 17:16:27','Ingreso IP - Inserción'),(1605,409,'186.155.241.196','jmendez','root@localhost','2019-10-25 17:45:25','Ingreso IP - Modificación'),(1606,409,'190.131.201.70','jmendez','root@localhost','2019-10-25 17:45:25','Ingreso IP - Modificación'),(1607,409,'190.242.96.250','jmendez','root@localhost','2019-10-25 17:45:25','Ingreso IP - Modificación'),(1608,383,'201.221.124.8','evelasquez','root@localhost','2019-10-25 18:01:48','Ingreso IP - Modificación'),(1609,383,'201.221.125.136','evelasquez','root@localhost','2019-10-25 18:01:48','Ingreso IP - Modificación'),(1610,383,'200.1.175.202','evelasquez','root@localhost','2019-10-25 18:01:48','Ingreso IP - Modificación'),(1622,411,'190.242.36.50','kapanader','root@localhost','2019-10-28 14:46:19','Ingreso IP - Inserción'),(1623,412,'190.242.36.50','kapanader','root@localhost','2019-10-28 14:47:16','Ingreso IP - Inserción'),(1625,414,'190.131.244.230','kapanader','root@localhost','2019-10-28 14:48:55','Ingreso IP - Inserción'),(1626,415,'190.131.244.230','kapanader','root@localhost','2019-10-28 14:49:45','Ingreso IP - Inserción'),(1628,417,'190.131.244.230','kapanader','root@localhost','2019-10-28 14:51:29','Ingreso IP - Inserción'),(1631,373,'190.25.232.76','asalgado','root@localhost','2019-10-28 16:17:30','Ingreso IP - Modificación'),(1632,373,'179.0.15.132','asalgado','root@localhost','2019-10-28 16:17:30','Ingreso IP - Modificación'),(1633,373,'200.31.17.253','asalgado','root@localhost','2019-10-28 16:17:30','Ingreso IP - Modificación'),(1637,419,'179.0.15.132','mbarrios','root@localhost','2019-10-28 16:22:28','Ingreso IP - Inserción'),(1638,419,'200.31.17.253','mbarrios','root@localhost','2019-10-28 16:22:28','Ingreso IP - Inserción'),(1639,419,'190.25.232.76','mbarrios','root@localhost','2019-10-28 16:22:28','Ingreso IP - Inserción'),(1654,422,'190.131.197.10','bblanco','root@localhost','2019-10-28 19:47:53','Ingreso IP - Inserción'),(1655,422,'190.131.197.11','bblanco','root@localhost','2019-10-28 19:47:53','Ingreso IP - Inserción'),(1656,423,'190.131.197.10','bblanco','root@localhost','2019-10-28 19:49:19','Ingreso IP - Inserción'),(1657,423,'190.131.197.11','bblanco','root@localhost','2019-10-28 19:49:19','Ingreso IP - Inserción'),(1660,374,'200.030.110.139','asalgado','root@localhost','2019-10-28 20:32:18','Ingreso IP - Modificación'),(1661,374,'181.236.217.20','asalgado','root@localhost','2019-10-28 20:32:18','Ingreso IP - Modificación'),(1662,374,'10.186.61.24','asalgado','root@localhost','2019-10-28 20:32:18','Ingreso IP - Modificación'),(1665,427,'186.155.241.196','jmendez','root@localhost','2019-10-29 01:26:39','Ingreso IP - Inserción'),(1666,427,'190.131.201.70','jmendez','root@localhost','2019-10-29 01:26:39','Ingreso IP - Inserción'),(1667,427,'190.242.96.250','jmendez','root@localhost','2019-10-29 01:26:39','Ingreso IP - Inserción'),(1668,428,'186.155.241.196','jmendez','root@localhost','2019-10-29 01:30:01','Ingreso IP - Inserción'),(1669,428,'190.131.201.70','jmendez','root@localhost','2019-10-29 01:30:01','Ingreso IP - Inserción'),(1670,428,'190.242.96.250','jmendez','root@localhost','2019-10-29 01:30:01','Ingreso IP - Inserción'),(1674,413,'190.242.36.50','kapanader','root@localhost','2019-10-29 15:21:29','Ingreso IP - Modificación'),(1675,426,'181.236.217.20','jbaracaldo','root@localhost','2019-10-29 16:18:39','Ingreso IP - Modificación'),(1676,425,'181.236.217.20','jbaracaldo','root@localhost','2019-10-29 16:24:38','Ingreso IP - Modificación'),(1678,416,'190.131.244.230','kapanader','root@localhost','2019-10-29 16:28:55','Ingreso IP - Modificación'),(1679,393,'190.143.111.130','mcastaneda','root@localhost','2019-10-29 16:39:16','Ingreso IP - Modificación'),(1680,393,'201.245.173.130','mcastaneda','root@localhost','2019-10-29 16:39:16','Ingreso IP - Modificación'),(1681,393,'200.119.83.130','mcastaneda','root@localhost','2019-10-29 16:39:16','Ingreso IP - Modificación'),(1682,429,'200.14.232.217','jrodriguez','root@localhost','2019-10-29 17:14:38','Ingreso IP - Inserción'),(1683,429,'186.119.118.211','jrodriguez','root@localhost','2019-10-29 17:14:38','Ingreso IP - Inserción'),(1684,429,'190.66.13.169','jrodriguez','root@localhost','2019-10-29 17:14:38','Ingreso IP - Inserción'),(1688,431,'200.14.232.217','jrodriguez','root@localhost','2019-10-29 17:46:02','Ingreso IP - Inserción'),(1689,431,'186.119.118.211','jrodriguez','root@localhost','2019-10-29 17:46:02','Ingreso IP - Inserción'),(1690,431,'190.66.13.169','jrodriguez','root@localhost','2019-10-29 17:46:02','Ingreso IP - Inserción'),(1691,432,'201.234.176.50','asalgado','root@localhost','2019-10-29 20:22:44','Ingreso IP - Inserción'),(1692,432,'190.216.159.78','asalgado','root@localhost','2019-10-29 20:22:44','Ingreso IP - Inserción'),(1693,432,'190.24.137.126','asalgado','root@localhost','2019-10-29 20:22:44','Ingreso IP - Inserción'),(1694,433,'200.3.147.16','asalgado','root@localhost','2019-10-29 20:43:59','Ingreso IP - Inserción'),(1695,433,'205.210.223.133','asalgado','root@localhost','2019-10-29 20:43:59','Ingreso IP - Inserción'),(1696,434,'201.234.176.50','ypinzon','root@localhost','2019-10-29 21:47:06','Ingreso IP - Inserción'),(1697,434,'190.216.159.78','ypinzon','root@localhost','2019-10-29 21:47:06','Ingreso IP - Inserción'),(1698,434,'190.24.137.126','ypinzon','root@localhost','2019-10-29 21:47:06','Ingreso IP - Inserción'),(1699,435,'201.234.176.50','ypinzon','root@localhost','2019-10-29 21:49:34','Ingreso IP - Inserción'),(1700,435,'190.216.159.78','ypinzon','root@localhost','2019-10-29 21:49:34','Ingreso IP - Inserción'),(1701,435,'190.24.137.126','ypinzon','root@localhost','2019-10-29 21:49:34','Ingreso IP - Inserción'),(1702,424,'190.131.197.10','bblanco','root@localhost','2019-10-30 14:18:43','Ingreso IP - Modificación'),(1703,424,'190.131.197.11','bblanco','root@localhost','2019-10-30 14:18:43','Ingreso IP - Modificación'),(1704,436,'205.210.222.13','npachon','root@localhost','2019-10-30 14:36:55','Ingreso IP - Inserción'),(1705,436,'205.210.222.150','npachon','root@localhost','2019-10-30 14:36:55','Ingreso IP - Inserción'),(1706,436,'10.234.137.105','npachon','root@localhost','2019-10-30 14:36:55','Ingreso IP - Inserción'),(1714,420,'200.14.232.217','jrodriguez','root@localhost','2019-11-01 14:03:18','Ingreso IP - Modificación'),(1715,420,'186.119.118.211','jrodriguez','root@localhost','2019-11-01 14:03:18','Ingreso IP - Modificación'),(1716,420,'190.66.13.169','jrodriguez','root@localhost','2019-11-01 14:03:18','Ingreso IP - Modificación'),(1717,440,'200.14.232.217','jrodriguez','root@localhost','2019-11-01 14:17:28','Ingreso IP - Inserción'),(1718,440,'186.119.118.211','jrodriguez','root@localhost','2019-11-01 14:17:28','Ingreso IP - Inserción'),(1719,440,'190.66.13.169','jrodriguez','root@localhost','2019-11-01 14:17:28','Ingreso IP - Inserción'),(1720,441,'200.14.232.217','jrodriguez','root@localhost','2019-11-01 14:23:40','Ingreso IP - Inserción'),(1721,441,'186.119.118.211','jrodriguez','root@localhost','2019-11-01 14:23:40','Ingreso IP - Inserción'),(1722,441,'190.66.13.169','jrodriguez','root@localhost','2019-11-01 14:23:40','Ingreso IP - Inserción'),(1729,430,'200.14.232.217','jrodriguez','root@localhost','2019-11-05 17:13:13','Ingreso IP - Modificación'),(1730,430,'186.119.118.211','jrodriguez','root@localhost','2019-11-05 17:13:13','Ingreso IP - Modificación'),(1731,430,'190.66.13.169','jrodriguez','root@localhost','2019-11-05 17:13:13','Ingreso IP - Modificación'),(1732,408,'186.155.241.196','jmendez','root@localhost','2019-11-05 23:59:57','Ingreso IP - Modificación'),(1733,408,'190.131.201.70','jmendez','root@localhost','2019-11-05 23:59:57','Ingreso IP - Modificación'),(1734,408,'190.242.96.250','jmendez','root@localhost','2019-11-05 23:59:57','Ingreso IP - Modificación'),(1738,437,'200.14.232.217','jrodriguez','root@localhost','2019-11-06 16:53:11','Ingreso IP - Modificación'),(1739,437,'186.119.118.211','jrodriguez','root@localhost','2019-11-06 16:53:11','Ingreso IP - Modificación'),(1740,437,'190.66.13.169','jrodriguez','root@localhost','2019-11-06 16:53:11','Ingreso IP - Modificación'),(1741,443,'181.143.34.114','muribe','root@localhost','2019-11-07 15:21:43','Ingreso IP - Inserción'),(1742,443,'181.143.34.115','muribe','root@localhost','2019-11-07 15:21:43','Ingreso IP - Inserción'),(1743,443,'181.143.34.116','muribe','root@localhost','2019-11-07 15:21:43','Ingreso IP - Inserción'),(1744,444,'181.143.34.114','muribe','root@localhost','2019-11-07 15:28:29','Ingreso IP - Inserción'),(1745,444,'181.143.34.115','muribe','root@localhost','2019-11-07 15:28:29','Ingreso IP - Inserción'),(1746,444,'181.143.34.116','muribe','root@localhost','2019-11-07 15:28:29','Ingreso IP - Inserción'),(1750,438,'200.14.232.217','jrodriguez','root@localhost','2019-11-08 17:24:25','Ingreso IP - Modificación'),(1751,438,'186.119.118.211','jrodriguez','root@localhost','2019-11-08 17:24:25','Ingreso IP - Modificación'),(1752,438,'190.66.13.169','jrodriguez','root@localhost','2019-11-08 17:24:25','Ingreso IP - Modificación'),(1754,372,'190.216.141.187','asalgado','root@localhost','2019-11-08 19:20:40','Ingreso IP - Modificación'),(1755,442,'200.14.232.217','jrodriguez','root@localhost','2019-11-13 15:30:56','Ingreso IP - Modificación'),(1756,442,'186.119.118.211','jrodriguez','root@localhost','2019-11-13 15:30:56','Ingreso IP - Modificación'),(1757,442,'190.66.13.169','jrodriguez','root@localhost','2019-11-13 15:30:56','Ingreso IP - Modificación'),(1763,446,'200.14.232.217','jrodriguez','root@localhost','2019-11-13 20:54:26','Ingreso IP - Inserción'),(1764,446,'186.119.118.211','jrodriguez','root@localhost','2019-11-13 20:54:26','Ingreso IP - Inserción'),(1765,446,'190.66.13.169','jrodriguez','root@localhost','2019-11-13 20:54:26','Ingreso IP - Inserción'),(1766,394,'190.143.111.130','mcastaneda','root@localhost','2019-11-15 15:19:10','Ingreso IP - Modificación'),(1767,394,'201.245.173.130','mcastaneda','root@localhost','2019-11-15 15:19:10','Ingreso IP - Modificación'),(1768,394,'200.119.83.130','mcastaneda','root@localhost','2019-11-15 15:19:10','Ingreso IP - Modificación'),(1769,381,'190.216.141.187','lgutierrez','root@localhost','2019-11-15 16:17:38','Ingreso IP - Modificación'),(1773,418,'179.0.15.132','mbarrios','root@localhost','2019-11-15 20:30:05','Ingreso IP - Modificación'),(1774,418,'200.31.17.253','mbarrios','root@localhost','2019-11-15 20:30:05','Ingreso IP - Modificación'),(1775,418,'190.25.232.76','mbarrios','root@localhost','2019-11-15 20:30:05','Ingreso IP - Modificación'),(1779,445,'168.165.202.39','npachon','root@localhost','2019-11-18 15:00:52','Ingreso IP - Modificación'),(1780,445,'168.165.202.37','npachon','root@localhost','2019-11-18 15:00:52','Ingreso IP - Modificación'),(1781,445,'10.234.137.66','npachon','root@localhost','2019-11-18 15:00:52','Ingreso IP - Modificación'),(1782,439,'168.165.202.39','npachon','root@localhost','2019-11-18 16:26:47','Ingreso IP - Modificación'),(1783,439,'168.165.202.37','npachon','root@localhost','2019-11-18 16:26:47','Ingreso IP - Modificación'),(1784,397,'190.131.240.114','ecastaneda','root@localhost','2019-11-18 16:58:34','Ingreso IP - Modificación'),(1785,397,'190.216.157.114','ecastaneda','root@localhost','2019-11-18 16:58:34','Ingreso IP - Modificación'),(1786,397,'190.131.252.99','ecastaneda','root@localhost','2019-11-18 16:58:34','Ingreso IP - Modificación'),(1787,447,'10.192.81.64','asalgado','root@localhost','2019-11-18 22:14:19','Ingreso IP - Inserción'),(1788,447,'10.208.81.61','asalgado','root@localhost','2019-11-18 22:14:19','Ingreso IP - Inserción'),(1789,447,'10.192.81.62','asalgado','root@localhost','2019-11-18 22:14:19','Ingreso IP - Inserción'),(1790,421,'190.131.197.10','bblanco','root@localhost','2019-11-19 14:36:07','Ingreso IP - Modificación'),(1791,421,'190.131.197.11','bblanco','root@localhost','2019-11-19 14:36:07','Ingreso IP - Modificación'),(1795,378,'190.131.240.114','esouza','root@localhost','2019-11-19 14:44:18','Ingreso IP - Modificación'),(1796,378,'190.216.157.114','esouza','root@localhost','2019-11-19 14:44:18','Ingreso IP - Modificación'),(1797,378,'190.131.252.99','esouza','root@localhost','2019-11-19 14:44:18','Ingreso IP - Modificación'),(1801,410,'200.14.232.217','asalgado','root@localhost','2019-11-19 22:15:05','Ingreso IP - Modificación'),(1802,410,'186.119.118.211','asalgado','root@localhost','2019-11-19 22:15:05','Ingreso IP - Modificación'),(1803,410,'190.66.13.169','asalgado','root@localhost','2019-11-19 22:15:05','Ingreso IP - Modificación'),(1804,6,'192.168.128.14','asalgado','root@localhost','2020-01-08 20:40:22','Ingreso IP - Modificación'),(1805,6,'192.168.245.56','asalgado','root@localhost','2020-01-08 20:40:22','Ingreso IP - Modificación'),(1806,6,'190.242.39.136','asalgado','root@localhost','2020-01-08 20:40:22','Ingreso IP - Modificación'),(1808,259,'192.168.129.224','52167727','root@localhost','2020-05-19 15:01:49','Ingreso IP - Modificación'),(1809,259,'190.242.39.136','52167727','root@localhost','2020-05-19 15:01:49','Ingreso IP - Modificación'),(1810,449,'186.84.88.48','esouza','root@localhost','2020-05-22 19:10:01','Ingreso IP - Inserción'),(1815,451,'190.131.240.114','asalgado','root@localhost','2020-05-27 22:09:13','Ingreso IP - Inserción'),(1816,451,'190.216.157.114','asalgado','root@localhost','2020-05-27 22:09:13','Ingreso IP - Inserción'),(1817,451,'190.131.252.99','asalgado','root@localhost','2020-05-27 22:09:13','Ingreso IP - Inserción'),(1818,452,'190.131.240.114','ecastaneda','root@localhost','2020-05-28 15:56:14','Ingreso IP - Inserción'),(1819,452,'190.216.157.114','ecastaneda','root@localhost','2020-05-28 15:56:14','Ingreso IP - Inserción'),(1820,452,'190.131.252.99','ecastaneda','root@localhost','2020-05-28 15:56:14','Ingreso IP - Inserción'),(1823,454,'190.242.36.50','esouza','root@localhost','2020-05-29 12:33:56','Ingreso IP - Inserción'),(1835,456,'181.236.217.20','asalgado','root@localhost','2020-06-01 12:31:33','Ingreso IP - Inserción'),(1838,459,'190.131.244.230','kapanader','root@localhost','2020-06-01 14:28:12','Ingreso IP - Inserción'),(1839,457,'201.221.124.8','asalgado','root@localhost','2020-06-01 15:41:39','Ingreso IP - Modificación'),(1840,457,'201.221.125.136','asalgado','root@localhost','2020-06-01 15:41:39','Ingreso IP - Modificación'),(1841,457,'200.1.175.202','asalgado','root@localhost','2020-06-01 15:41:39','Ingreso IP - Modificación'),(1842,460,'181.236.217.20','jbaracaldo','root@localhost','2020-06-01 15:57:57','Ingreso IP - Inserción'),(1843,461,'201.221.124.8','smejia','root@localhost','2020-06-01 16:22:40','Ingreso IP - Inserción'),(1844,461,'201.221.125.136','smejia','root@localhost','2020-06-01 16:22:40','Ingreso IP - Inserción'),(1845,461,'200.1.175.202','smejia','root@localhost','2020-06-01 16:22:40','Ingreso IP - Inserción'),(1847,462,'201.221.124.8','smejia','root@localhost','2020-06-01 16:25:30','Ingreso IP - Inserción'),(1848,462,'201.221.125.136','smejia','root@localhost','2020-06-01 16:25:30','Ingreso IP - Inserción'),(1849,462,'200.1.175.202','smejia','root@localhost','2020-06-01 16:25:30','Ingreso IP - Inserción'),(1850,463,'201.221.124.8','smejia','root@localhost','2020-06-01 16:27:19','Ingreso IP - Inserción'),(1851,463,'201.221.125.136','smejia','root@localhost','2020-06-01 16:27:19','Ingreso IP - Inserción'),(1852,463,'200.1.175.202','smejia','root@localhost','2020-06-01 16:27:19','Ingreso IP - Inserción'),(1853,464,'201.221.124.8','smejia','root@localhost','2020-06-01 16:30:05','Ingreso IP - Inserción'),(1854,464,'201.221.125.136','smejia','root@localhost','2020-06-01 16:30:05','Ingreso IP - Inserción'),(1855,464,'200.1.175.202','smejia','root@localhost','2020-06-01 16:30:05','Ingreso IP - Inserción'),(1859,5,'192.168.232.35','asalgado','root@localhost','2020-06-01 16:48:40','Ingreso IP - Modificación'),(1860,5,'190.242.39.136','asalgado','root@localhost','2020-06-01 16:48:40','Ingreso IP - Modificación'),(1861,5,'186.86.33.246','asalgado','root@localhost','2020-06-01 16:48:40','Ingreso IP - Modificación'),(1866,465,'186.155.241.196','asepulvedab','root@localhost','2020-06-02 17:19:21','Ingreso IP - Inserción'),(1867,465,'190.131.201.70','asepulvedab','root@localhost','2020-06-02 17:19:21','Ingreso IP - Inserción'),(1868,465,'190.242.96.250','asepulvedab','root@localhost','2020-06-02 17:19:21','Ingreso IP - Inserción'),(1869,466,'186.155.241.196','asepulvedab','root@localhost','2020-06-02 17:23:36','Ingreso IP - Inserción'),(1870,466,'190.131.201.70','asepulvedab','root@localhost','2020-06-02 17:23:36','Ingreso IP - Inserción'),(1871,466,'190.242.96.250','asepulvedab','root@localhost','2020-06-02 17:23:36','Ingreso IP - Inserción'),(1875,468,'190.242.36.50','kapanader','root@localhost','2020-06-02 18:23:01','Ingreso IP - Inserción'),(1878,470,'181.236.217.20','jbaracaldo','root@localhost','2020-06-03 13:27:10','Ingreso IP - Inserción'),(1879,469,'64.76.56.218','asalgado','root@localhost','2020-06-04 13:32:27','Ingreso IP - Modificación'),(1880,469,'200.41.7.154','asalgado','root@localhost','2020-06-04 13:32:27','Ingreso IP - Modificación'),(1881,471,'64.76.56.218','mrosales','root@localhost','2020-06-04 14:01:41','Ingreso IP - Inserción'),(1882,471,'200.41.7.154','mrosales','root@localhost','2020-06-04 14:01:41','Ingreso IP - Inserción'),(1885,472,'190.143.111.130','esouza','root@localhost','2020-06-09 20:12:32','Ingreso IP - Modificación'),(1886,472,'201.245.161.224','esouza','root@localhost','2020-06-09 20:12:32','Ingreso IP - Modificación'),(1887,473,'190.143.111.130','mcastaneda','root@localhost','2020-06-10 14:42:11','Ingreso IP - Inserción'),(1888,474,'190.143.111.130','mcastaneda','root@localhost','2020-06-10 14:44:07','Ingreso IP - Inserción'),(1889,455,'186.155.241.196','etriana','root@localhost','2020-06-17 15:12:19','Ingreso IP - Modificación'),(1890,455,'190.131.201.70','etriana','root@localhost','2020-06-17 15:12:19','Ingreso IP - Modificación'),(1891,455,'190.242.96.250','etriana','root@localhost','2020-06-17 15:12:19','Ingreso IP - Modificación'),(1892,475,'190.131.197.10','asalgado','root@localhost','2020-06-18 12:56:59','Ingreso IP - Inserción'),(1893,475,'190.131.197.11','asalgado','root@localhost','2020-06-18 12:56:59','Ingreso IP - Inserción'),(1897,478,'200.14.232.217','asalgado','root@localhost','2020-06-19 13:04:43','Ingreso IP - Inserción'),(1898,478,'190.66.13.169','asalgado','root@localhost','2020-06-19 13:04:43','Ingreso IP - Inserción'),(1899,478,'186.119.118.211','asalgado','root@localhost','2020-06-19 13:04:43','Ingreso IP - Inserción'),(1901,477,'190.131.197.10','gpinilla','root@localhost','2020-06-19 15:36:34','Ingreso IP - Modificación'),(1902,458,'190.242.36.50','kapanader','root@localhost','2020-06-19 17:13:09','Ingreso IP - Modificación'),(1903,476,'190.131.197.10','gpinilla','root@localhost','2020-06-23 16:16:06','Ingreso IP - Modificación'),(1905,479,'190.216.141.187','asalgado','root@localhost','2020-06-23 17:12:06','Ingreso IP - Modificación'),(1906,479,'190.216.141.186','asalgado','root@localhost','2020-06-23 17:12:06','Ingreso IP - Modificación'),(1907,480,'200.1.80.166','lgutierrez','root@localhost','2020-06-23 19:32:13','Ingreso IP - Inserción'),(1908,480,'190.216.141.187','lgutierrez','root@localhost','2020-06-23 19:32:13','Ingreso IP - Inserción'),(1909,481,'200.14.232.217','jpineda','root@localhost','2020-06-25 22:19:20','Ingreso IP - Inserción'),(1910,481,'190.66.13.169','jpineda','root@localhost','2020-06-25 22:19:20','Ingreso IP - Inserción'),(1911,481,'186.119.118.211','jpineda','root@localhost','2020-06-25 22:19:20','Ingreso IP - Inserción'),(1915,482,'200.14.232.217','jpineda','root@localhost','2020-07-01 21:33:31','Ingreso IP - Inserción'),(1916,482,'190.66.13.169','jpineda','root@localhost','2020-07-01 21:33:31','Ingreso IP - Inserción'),(1917,482,'186.119.118.211','jpineda','root@localhost','2020-07-01 21:33:31','Ingreso IP - Inserción'),(1921,483,'200.14.232.217','jpineda','root@localhost','2020-07-06 15:05:44','Ingreso IP - Modificación'),(1922,483,'190.66.13.169','jpineda','root@localhost','2020-07-06 15:05:44','Ingreso IP - Modificación'),(1923,483,'186.119.118.211','jpineda','root@localhost','2020-07-06 15:05:44','Ingreso IP - Modificación'),(1933,484,'192.168.1.105','asalgado','root@localhost','2020-09-10 20:58:52','Ingreso IP - Modificación'),(1934,484,'201.244.244.16','asalgado','root@localhost','2020-09-10 20:58:52','Ingreso IP - Modificación'),(1935,484,'186.154.180.209','asalgado','root@localhost','2020-09-10 20:58:52','Ingreso IP - Modificación'),(1948,467,'201.244.244.16','dcastanop','root@localhost','2020-09-10 22:23:56','Ingreso IP - Modificación'),(1949,467,'190.131.201.70','dcastanop','root@localhost','2020-09-10 22:23:56','Ingreso IP - Modificación'),(1950,467,'190.242.96.250','dcastanop','root@localhost','2020-09-10 22:23:56','Ingreso IP - Modificación'),(1952,7,'192.168.128.12','esouza','root@localhost','2020-09-28 12:26:42','Ingreso IP - Modificación'),(1953,7,'190.242.39.136','esouza','root@localhost','2020-09-28 12:26:42','Ingreso IP - Modificación'),(1964,486,'181.143.34.114','esouza','root@localhost','2020-11-03 21:54:16','Ingreso IP - Modificación'),(1965,486,'181.143.34.115','esouza','root@localhost','2020-11-03 21:54:16','Ingreso IP - Modificación'),(1966,486,'181.143.34.116','esouza','root@localhost','2020-11-03 21:54:16','Ingreso IP - Modificación'),(1967,487,'190.131.240.114','esouza','root@localhost','2020-11-03 23:23:32','Ingreso IP - Inserción'),(1968,487,'190.216.157.114','esouza','root@localhost','2020-11-03 23:23:32','Ingreso IP - Inserción'),(1969,487,'190.131.252.99','esouza','root@localhost','2020-11-03 23:23:32','Ingreso IP - Inserción'),(1989,492,'190.242.36.50','asalgado','root@localhost','2020-11-05 16:29:35','Ingreso IP - Inserción'),(1990,493,'190.143.111.130','esouza','root@localhost','2020-11-05 18:02:53','Ingreso IP - Inserción'),(1991,493,'201.245.161.224','esouza','root@localhost','2020-11-05 18:02:53','Ingreso IP - Inserción'),(1993,495,'190.143.111.130','mcastaneda','root@localhost','2020-11-05 18:58:42','Ingreso IP - Inserción'),(1994,495,'190.216.141.187','mcastaneda','root@localhost','2020-11-05 18:58:42','Ingreso IP - Inserción'),(1995,494,'190.143.111.130','mcastaneda','root@localhost','2020-11-05 18:59:02','Ingreso IP - Modificación'),(1996,494,'190.216.141.187','mcastaneda','root@localhost','2020-11-05 18:59:02','Ingreso IP - Modificación'),(1997,496,'190.143.111.130','mcastaneda','root@localhost','2020-11-05 19:01:12','Ingreso IP - Inserción'),(1998,496,'190.216.141.187','mcastaneda','root@localhost','2020-11-05 19:01:12','Ingreso IP - Inserción'),(2005,498,'190.242.36.50','kpanader','root@localhost','2020-11-05 19:52:52','Ingreso IP - Inserción'),(2007,499,'190.242.36.50','kpanader','root@localhost','2020-11-05 19:59:59','Ingreso IP - Modificación'),(2008,500,'190.131.244.230','kpanader','root@localhost','2020-11-05 20:02:13','Ingreso IP - Inserción'),(2020,506,'190.131.240.114','ecastaneda','root@localhost','2020-11-06 14:36:49','Ingreso IP - Inserción'),(2021,506,'190.216.157.114','ecastaneda','root@localhost','2020-11-06 14:36:49','Ingreso IP - Inserción'),(2022,506,'190.131.252.99','ecastaneda','root@localhost','2020-11-06 14:36:49','Ingreso IP - Inserción'),(2023,507,'190.131.240.114','ecastaneda','root@localhost','2020-11-06 14:39:22','Ingreso IP - Inserción'),(2024,507,'190.216.157.114','ecastaneda','root@localhost','2020-11-06 14:39:22','Ingreso IP - Inserción'),(2025,507,'190.131.252.99','ecastaneda','root@localhost','2020-11-06 14:39:22','Ingreso IP - Inserción'),(2026,508,'190.131.240.114','ecastaneda','root@localhost','2020-11-06 14:44:11','Ingreso IP - Inserción'),(2027,508,'190.216.157.114','ecastaneda','root@localhost','2020-11-06 14:44:11','Ingreso IP - Inserción'),(2028,508,'190.131.252.99','ecastaneda','root@localhost','2020-11-06 14:44:11','Ingreso IP - Inserción'),(2029,488,'201.221.124.8','semejia','root@localhost','2020-11-06 15:34:11','Ingreso IP - Modificación'),(2030,488,'201.221.125.136','semejia','root@localhost','2020-11-06 15:34:11','Ingreso IP - Modificación'),(2031,488,'200.1.175.202','semejia','root@localhost','2020-11-06 15:34:11','Ingreso IP - Modificación'),(2032,509,'186.155.241.196','asepulveda','root@localhost','2020-11-06 16:04:48','Ingreso IP - Inserción'),(2033,509,'190.131.201.70','asepulveda','root@localhost','2020-11-06 16:04:48','Ingreso IP - Inserción'),(2034,509,'190.242.96.250','asepulveda','root@localhost','2020-11-06 16:04:48','Ingreso IP - Inserción'),(2038,511,'186.155.241.196','asepulveda','root@localhost','2020-11-06 16:09:37','Ingreso IP - Inserción'),(2039,511,'190.131.201.70','asepulveda','root@localhost','2020-11-06 16:09:37','Ingreso IP - Inserción'),(2040,511,'190.242.96.250','asepulveda','root@localhost','2020-11-06 16:09:37','Ingreso IP - Inserción'),(2041,512,'186.155.241.196','asepulveda','root@localhost','2020-11-06 16:11:16','Ingreso IP - Inserción'),(2042,512,'190.131.201.70','asepulveda','root@localhost','2020-11-06 16:11:16','Ingreso IP - Inserción'),(2043,512,'190.242.96.250','asepulveda','root@localhost','2020-11-06 16:11:16','Ingreso IP - Inserción'),(2044,513,'186.155.241.196','asepulveda','root@localhost','2020-11-06 16:12:57','Ingreso IP - Inserción'),(2045,513,'190.131.201.70','asepulveda','root@localhost','2020-11-06 16:12:57','Ingreso IP - Inserción'),(2046,513,'190.242.96.250','asepulveda','root@localhost','2020-11-06 16:12:57','Ingreso IP - Inserción'),(2047,514,'186.155.241.196','asepulveda','root@localhost','2020-11-06 16:15:11','Ingreso IP - Inserción'),(2048,514,'190.131.201.70','asepulveda','root@localhost','2020-11-06 16:15:11','Ingreso IP - Inserción'),(2049,514,'190.242.96.250','asepulveda','root@localhost','2020-11-06 16:15:11','Ingreso IP - Inserción'),(2056,517,'186.155.241.196','asepulveda','root@localhost','2020-11-06 16:20:05','Ingreso IP - Inserción'),(2057,517,'190.131.201.70','asepulveda','root@localhost','2020-11-06 16:20:05','Ingreso IP - Inserción'),(2058,517,'190.242.96.250','asepulveda','root@localhost','2020-11-06 16:20:05','Ingreso IP - Inserción'),(2060,519,'190.66.4.251','cmoque','root@localhost','2020-11-06 16:24:34','Ingreso IP - Inserción'),(2061,519,'190.66.4.252','cmoque','root@localhost','2020-11-06 16:24:34','Ingreso IP - Inserción'),(2062,519,'190.66.4.253','cmoque','root@localhost','2020-11-06 16:24:34','Ingreso IP - Inserción'),(2063,520,'190.66.4.251','cmoque','root@localhost','2020-11-06 16:33:20','Ingreso IP - Inserción'),(2064,520,'190.66.4.252','cmoque','root@localhost','2020-11-06 16:33:20','Ingreso IP - Inserción'),(2065,520,'190.66.4.253','cmoque','root@localhost','2020-11-06 16:33:20','Ingreso IP - Inserción'),(2066,518,'190.131.244.230','kpanader','root@localhost','2020-11-06 16:53:07','Ingreso IP - Modificación'),(2067,510,'186.155.241.196','asepulveda','root@localhost','2020-11-06 17:18:16','Ingreso IP - Modificación'),(2068,510,'190.131.201.70','asepulveda','root@localhost','2020-11-06 17:18:16','Ingreso IP - Modificación'),(2069,510,'190.242.96.250','asepulveda','root@localhost','2020-11-06 17:18:16','Ingreso IP - Modificación'),(2079,523,'200.14.232.217','jpineda','root@localhost','2020-11-10 13:15:14','Ingreso IP - Inserción'),(2080,523,'190.66.13.169','jpineda','root@localhost','2020-11-10 13:15:14','Ingreso IP - Inserción'),(2081,523,'186.119.118.211','jpineda','root@localhost','2020-11-10 13:15:14','Ingreso IP - Inserción'),(2086,525,'181.143.34.114','suribe','root@localhost','2020-11-10 14:35:25','Ingreso IP - Inserción'),(2087,525,'181.143.34.115','suribe','root@localhost','2020-11-10 14:35:25','Ingreso IP - Inserción'),(2088,525,'181.143.34.116','suribe','root@localhost','2020-11-10 14:35:25','Ingreso IP - Inserción'),(2089,526,'181.143.34.114','suribe','root@localhost','2020-11-10 14:38:30','Ingreso IP - Inserción'),(2090,526,'181.143.34.115','suribe','root@localhost','2020-11-10 14:38:30','Ingreso IP - Inserción'),(2091,526,'181.143.34.116','suribe','root@localhost','2020-11-10 14:38:30','Ingreso IP - Inserción'),(2093,522,'181.236.217.20','esouza','root@localhost','2020-11-10 14:42:09','Ingreso IP - Modificación'),(2094,527,'181.236.217.20','jbaracaldo','root@localhost','2020-11-10 15:12:31','Ingreso IP - Inserción'),(2097,529,'200.41.7.154','asalgado','root@localhost','2020-11-10 17:24:08','Ingreso IP - Inserción'),(2110,503,'200.1.175.62','semejia','root@localhost','2020-11-11 15:01:10','Ingreso IP - Modificación'),(2111,503,'201.221.125.136','semejia','root@localhost','2020-11-11 15:01:10','Ingreso IP - Modificación'),(2112,503,'201.221.124.8','semejia','root@localhost','2020-11-11 15:01:10','Ingreso IP - Modificación'),(2113,533,'190.131.197.10','esouza','root@localhost','2020-11-11 15:47:49','Ingreso IP - Inserción'),(2114,533,'190.131.197.11','esouza','root@localhost','2020-11-11 15:47:49','Ingreso IP - Inserción'),(2118,534,'186.155.241.196','asepulveda','root@localhost','2020-11-12 14:46:55','Ingreso IP - Inserción'),(2119,534,'190.131.201.70','asepulveda','root@localhost','2020-11-12 14:46:55','Ingreso IP - Inserción'),(2120,534,'190.242.96.250','asepulveda','root@localhost','2020-11-12 14:46:55','Ingreso IP - Inserción'),(2128,537,'190.131.197.10','gpinilla','root@localhost','2020-11-13 13:09:40','Ingreso IP - Modificación'),(2131,220,'190.242.39.136','asalgado','root@localhost','2020-11-13 20:14:49','Ingreso IP - Modificación'),(2132,220,'192.168.128.13','asalgado','root@localhost','2020-11-13 20:14:49','Ingreso IP - Modificación'),(2133,220,'192.168.1.105','asalgado','root@localhost','2020-11-13 20:14:49','Ingreso IP - Modificación'),(2137,538,'181.236.217.20','jbaracaldo','root@localhost','2020-11-17 15:24:28','Ingreso IP - Inserción'),(2144,521,'200.14.232.21','asalgado','root@localhost','2020-11-19 15:06:24','Ingreso IP - Modificación'),(2145,521,'190.66.13.169','asalgado','root@localhost','2020-11-19 15:06:24','Ingreso IP - Modificación'),(2146,521,'186.119.118.211','asalgado','root@localhost','2020-11-19 15:06:24','Ingreso IP - Modificación'),(2147,540,'200.14.232.217','jpineda','root@localhost','2020-11-19 15:10:26','Ingreso IP - Inserción'),(2148,540,'190.66.13.169','jpineda','root@localhost','2020-11-19 15:10:26','Ingreso IP - Inserción'),(2149,540,'186.119.118.211','jpineda','root@localhost','2020-11-19 15:10:26','Ingreso IP - Inserción'),(2150,539,'200.14.232.217','jpineda','root@localhost','2020-11-19 15:11:22','Ingreso IP - Modificación'),(2151,539,'190.66.13.169','jpineda','root@localhost','2020-11-19 15:11:22','Ingreso IP - Modificación'),(2152,539,'186.119.118.211','jpineda','root@localhost','2020-11-19 15:11:22','Ingreso IP - Modificación'),(2153,541,'200.14.232.217','jpineda','root@localhost','2020-11-19 15:16:15','Ingreso IP - Inserción'),(2154,541,'190.66.13.169','jpineda','root@localhost','2020-11-19 15:16:15','Ingreso IP - Inserción'),(2155,541,'186.119.118.211','jpineda','root@localhost','2020-11-19 15:16:15','Ingreso IP - Inserción'),(2156,542,'200.14.232.217','jpineda','root@localhost','2020-11-19 15:19:35','Ingreso IP - Inserción'),(2157,542,'190.66.13.169','jpineda','root@localhost','2020-11-19 15:19:35','Ingreso IP - Inserción'),(2158,542,'186.119.118.211','jpineda','root@localhost','2020-11-19 15:19:35','Ingreso IP - Inserción'),(2159,528,'01.234.176.50','esouza','root@localhost','2020-11-19 21:46:54','Ingreso IP - Modificación'),(2160,528,'138.121.13.162','esouza','root@localhost','2020-11-19 21:46:54','Ingreso IP - Modificación'),(2161,543,'201.234.176.50','mtrujillo','root@localhost','2020-11-20 15:53:43','Ingreso IP - Inserción'),(2162,543,'138.121.13.162','mtrujillo','root@localhost','2020-11-20 15:53:43','Ingreso IP - Inserción'),(2169,502,'190.131.244.230','kpanader','root@localhost','2020-11-23 16:32:55','Ingreso IP - Modificación'),(2179,490,'186.155.241.196','esouza','root@localhost','2020-11-23 18:05:29','Ingreso IP - Modificación'),(2180,490,'190.131.201.70','esouza','root@localhost','2020-11-23 18:05:29','Ingreso IP - Modificación'),(2181,490,'190.242.96.250','esouza','root@localhost','2020-11-23 18:05:29','Ingreso IP - Modificación'),(2182,491,'190.66.4.251','esouza','root@localhost','2020-11-26 21:47:29','Ingreso IP - Modificación'),(2183,491,'190.66.4.252','esouza','root@localhost','2020-11-26 21:47:29','Ingreso IP - Modificación'),(2184,491,'190.66.4.253','esouza','root@localhost','2020-11-26 21:47:29','Ingreso IP - Modificación'),(2195,535,'190.131.197.10','gpinilla','root@localhost','2020-12-01 14:52:22','Ingreso IP - Modificación'),(2202,516,'186.155.241.196','asepulveda','root@localhost','2020-12-02 17:26:48','Ingreso IP - Modificación'),(2203,516,'190.131.201.70','asepulveda','root@localhost','2020-12-02 17:26:48','Ingreso IP - Modificación'),(2204,516,'190.242.96.250','asepulveda','root@localhost','2020-12-02 17:26:48','Ingreso IP - Modificación'),(2205,524,'168.165.202.37','asalgado','root@localhost','2020-12-02 19:32:38','Ingreso IP - Modificación'),(2206,524,'168.165.202.38','asalgado','root@localhost','2020-12-02 19:32:38','Ingreso IP - Modificación'),(2207,524,'168.165.202.39','asalgado','root@localhost','2020-12-02 19:32:38','Ingreso IP - Modificación'),(2213,549,'200.14.232.217','jpineda','root@localhost','2020-12-02 23:14:48','Ingreso IP - Inserción'),(2214,549,'190.66.13.169','jpineda','root@localhost','2020-12-02 23:14:48','Ingreso IP - Inserción'),(2215,549,'186.119.118.211','jpineda','root@localhost','2020-12-02 23:14:48','Ingreso IP - Inserción'),(2216,501,'190.131.244.230','kpanader','root@localhost','2020-12-03 16:31:52','Ingreso IP - Modificación'),(2217,515,'186.155.241.196','asepulveda','root@localhost','2020-12-03 19:25:40','Ingreso IP - Modificación'),(2218,515,'190.131.201.70','asepulveda','root@localhost','2020-12-03 19:25:40','Ingreso IP - Modificación'),(2219,515,'190.242.96.250','asepulveda','root@localhost','2020-12-03 19:25:40','Ingreso IP - Modificación'),(2220,531,'200.41.7.154','acordoba','root@localhost','2020-12-04 15:08:45','Ingreso IP - Modificación'),(2221,532,'200.41.7.154','acordoba','root@localhost','2020-12-04 15:10:15','Ingreso IP - Modificación'),(2222,536,'190.131.197.10','gpinilla','root@localhost','2020-12-09 15:50:59','Ingreso IP - Modificación'),(2232,505,'201.221.124.8','semejia','root@localhost','2020-12-09 16:46:53','Ingreso IP - Modificación'),(2233,505,'201.221.125.136','semejia','root@localhost','2020-12-09 16:46:53','Ingreso IP - Modificación'),(2234,505,'201.221.125.140','semejia','root@localhost','2020-12-09 16:46:53','Ingreso IP - Modificación'),(2238,547,'168.165.202.37','npachon','root@localhost','2020-12-09 20:59:04','Ingreso IP - Modificación'),(2239,547,'168.165.202.38','npachon','root@localhost','2020-12-09 20:59:04','Ingreso IP - Modificación'),(2240,547,'168.165.202.39','npachon','root@localhost','2020-12-09 20:59:04','Ingreso IP - Modificación'),(2241,548,'199.166.10.84','npachon','root@localhost','2020-12-09 21:10:29','Ingreso IP - Modificación'),(2242,548,'199.166.10.73','npachon','root@localhost','2020-12-09 21:10:29','Ingreso IP - Modificación'),(2243,548,'199.166.10.71','npachon','root@localhost','2020-12-09 21:10:29','Ingreso IP - Modificación'),(2244,545,'168.165.202.37','npachon','root@localhost','2020-12-09 21:19:48','Ingreso IP - Modificación'),(2245,545,'168.165.202.38','npachon','root@localhost','2020-12-09 21:19:48','Ingreso IP - Modificación'),(2246,545,'168.165.202.39','npachon','root@localhost','2020-12-09 21:19:48','Ingreso IP - Modificación'),(2247,546,'168.165.202.37','npachon','root@localhost','2020-12-09 21:21:19','Ingreso IP - Modificación'),(2248,546,'168.165.202.38','npachon','root@localhost','2020-12-09 21:21:19','Ingreso IP - Modificación'),(2249,546,'168.165.202.39','npachon','root@localhost','2020-12-09 21:21:19','Ingreso IP - Modificación'),(2253,485,'201.221.124.8','esouza','root@localhost','2020-12-10 13:34:17','Ingreso IP - Modificación'),(2254,485,'201.221.125.136','esouza','root@localhost','2020-12-10 13:34:17','Ingreso IP - Modificación'),(2255,485,'200.1.175.62','esouza','root@localhost','2020-12-10 13:34:17','Ingreso IP - Modificación'),(2259,544,'201.234.176.50','mtrujillo','root@localhost','2020-12-10 15:18:57','Ingreso IP - Modificación'),(2260,544,'138.121.13.162','mtrujillo','root@localhost','2020-12-10 15:18:57','Ingreso IP - Modificación'),(2261,504,'201.221.124.8','asalgado','root@localhost','2020-12-10 17:13:17','Ingreso IP - Modificación'),(2262,504,'200.1.175.62','asalgado','root@localhost','2020-12-10 17:13:17','Ingreso IP - Modificación'),(2263,504,'201.221.125.140','asalgado','root@localhost','2020-12-10 17:13:17','Ingreso IP - Inserción'),(2268,550,'172.28.1.201','52167727','root@localhost','2020-12-21 15:12:17','Ingreso IP - Inserción'),(2272,551,'192.168.26.10','esouza','root@localhost','2021-03-12 14:50:07','Ingreso IP - Modificación'),(2273,552,'192.168.26.15','esouza','root@localhost','2021-03-12 14:55:17','Ingreso IP - Modificación'),(2274,553,'192.168.128.140','esouza','root@localhost','2021-03-12 14:58:43','Ingreso IP - Modificación'),(2275,554,'192.168.128.161','asalgado','root@localhost','2021-03-12 19:57:31','Ingreso IP - Inserción'),(2276,555,'192.168.128.143','asalgado','root@localhost','2021-03-12 20:31:23','Ingreso IP - Inserción'),(2277,556,'192.169.26.125','asalgado','root@localhost','2021-03-12 20:34:28','Ingreso IP - Inserción'),(2278,557,'192.168.128.142','asalgado','root@localhost','2021-03-12 20:39:39','Ingreso IP - Inserción'),(2291,558,'181.143.34.114','esouza','root@localhost','2021-05-05 17:37:55','Ingreso IP - Inserción'),(2292,558,'181.143.34.115','esouza','root@localhost','2021-05-05 17:37:55','Ingreso IP - Inserción'),(2293,558,'181.143.34.116','esouza','root@localhost','2021-05-05 17:37:55','Ingreso IP - Inserción'),(2305,562,'181.236.217.20','asalgado','root@localhost','2021-05-06 22:20:42','Ingreso IP - Inserción'),(2309,448,'190.242.39.136','asalgado','root@localhost','2021-05-06 22:22:54','Ingreso IP - Modificación'),(2310,448,'186.84.88.48','asalgado','root@localhost','2021-05-06 22:22:54','Ingreso IP - Modificación'),(2311,448,'190.26.11.237','asalgado','root@localhost','2021-05-06 22:22:54','Ingreso IP - Modificación'),(2312,563,'181.236.217.20','jbaracaldo','root@localhost','2021-05-07 13:14:02','Ingreso IP - Inserción'),(2322,120,'190.242.39.138',NULL,'root@localhost',NULL,NULL),(2329,567,'181.143.34.114','suribe','root@localhost','2021-05-07 19:10:50','Ingreso IP - Inserción'),(2330,567,'181.143.34.115','suribe','root@localhost','2021-05-07 19:10:50','Ingreso IP - Inserción'),(2331,567,'181.143.34.116','suribe','root@localhost','2021-05-07 19:10:50','Ingreso IP - Inserción'),(2333,569,'190.242.36.50','esouza','root@localhost','2021-05-07 20:32:07','Ingreso IP - Inserción'),(2334,570,'190.143.111.130','esouza','root@localhost','2021-05-10 22:48:30','Ingreso IP - Inserción'),(2335,570,'201.245.161.224','esouza','root@localhost','2021-05-10 22:48:30','Ingreso IP - Inserción'),(2336,571,'190.143.111.130','mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso IP - Inserción'),(2337,571,'201.245.161.224','mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso IP - Inserción'),(2338,572,'190.143.111.130','mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso IP - Inserción'),(2339,572,'201.245.161.224','mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso IP - Inserción'),(2341,574,'190.242.36.50','kpanader','root@localhost','2021-05-11 16:54:13','Ingreso IP - Inserción'),(2342,575,'190.131.240.114','esouza','root@localhost','2021-05-11 22:10:29','Ingreso IP - Inserción'),(2343,575,'190.216.157.114','esouza','root@localhost','2021-05-11 22:10:29','Ingreso IP - Inserción'),(2344,575,'190.131.252.99','esouza','root@localhost','2021-05-11 22:10:29','Ingreso IP - Inserción'),(2345,573,'190.131.244.230','kpanader','root@localhost','2021-05-13 17:23:25','Ingreso IP - Modificación'),(2346,576,'190.131.197.10','esouza','root@localhost','2021-05-14 21:24:26','Ingreso IP - Inserción'),(2347,576,'190.131.197.11','esouza','root@localhost','2021-05-14 21:24:26','Ingreso IP - Inserción'),(2348,577,'190.131.197.10','cblanco','root@localhost','2021-05-20 13:45:23','Ingreso IP - Inserción'),(2349,578,'190.131.197.10','cblanco','root@localhost','2021-05-20 14:34:18','Ingreso IP - Inserción'),(2350,579,'190.131.197.10','cblanco','root@localhost','2021-05-20 14:39:01','Ingreso IP - Inserción'),(2351,580,'190.131.197.10','cblanco','root@localhost','2021-05-20 14:47:01','Ingreso IP - Inserción'),(2361,582,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso IP - Inserción'),(2362,582,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso IP - Inserción'),(2363,582,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso IP - Inserción'),(2364,583,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso IP - Inserción'),(2365,583,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso IP - Inserción'),(2366,583,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso IP - Inserción'),(2367,584,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso IP - Inserción'),(2368,584,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso IP - Inserción'),(2369,584,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso IP - Inserción'),(2373,586,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso IP - Inserción'),(2374,586,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso IP - Inserción'),(2375,586,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso IP - Inserción'),(2376,587,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso IP - Inserción'),(2377,587,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso IP - Inserción'),(2378,587,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso IP - Inserción'),(2382,588,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso IP - Inserción'),(2383,588,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso IP - Inserción'),(2384,588,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso IP - Inserción'),(2388,585,'186.155.241.196','asepulveda','root@localhost','2021-05-21 16:48:22','Ingreso IP - Modificación'),(2389,585,'190.131.201.70','asepulveda','root@localhost','2021-05-21 16:48:22','Ingreso IP - Modificación'),(2390,585,'190.242.96.250','asepulveda','root@localhost','2021-05-21 16:48:22','Ingreso IP - Modificación'),(2391,559,'201.221.124.8','esouza','root@localhost','2021-05-21 17:05:55','Ingreso IP - Modificación'),(2392,559,'201.221.125.136','esouza','root@localhost','2021-05-21 17:05:55','Ingreso IP - Modificación'),(2393,559,'201.221.124.121','esouza','root@localhost','2021-05-21 17:05:55','Ingreso IP - Modificación'),(2394,565,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:12:54','Ingreso IP - Modificación'),(2395,565,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:12:54','Ingreso IP - Modificación'),(2396,565,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:12:54','Ingreso IP - Modificación'),(2412,566,'201.221.124.121','evelasquez','root@localhost','2021-05-21 17:24:11','Ingreso IP - Modificación'),(2413,566,'201.221.125.136','evelasquez','root@localhost','2021-05-21 17:24:11','Ingreso IP - Modificación'),(2414,566,'200.1.175.202','evelasquez','root@localhost','2021-05-21 17:24:11','Ingreso IP - Modificación'),(2424,560,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:35:27','Ingreso IP - Modificación'),(2425,560,'201.221.124.8','evelasquez','root@localhost','2021-05-24 14:35:27','Ingreso IP - Modificación'),(2426,560,'200.1.175.202','evelasquez','root@localhost','2021-05-24 14:35:27','Ingreso IP - Modificación'),(2427,564,'201.221.124.121','evelasquez','root@localhost','2021-05-24 14:38:54','Ingreso IP - Modificación'),(2428,564,'201.221.124.8','evelasquez','root@localhost','2021-05-24 14:38:54','Ingreso IP - Modificación'),(2429,564,'200.1.175.202','evelasquez','root@localhost','2021-05-24 14:38:54','Ingreso IP - Modificación'),(2430,581,'186.155.241.196','asalgado','root@localhost','2021-05-24 17:29:14','Ingreso IP - Modificación'),(2431,581,'190.131.201.70','asalgado','root@localhost','2021-05-24 17:29:14','Ingreso IP - Modificación'),(2432,581,'190.242.96.250','asalgado','root@localhost','2021-05-24 17:29:14','Ingreso IP - Modificación'),(2433,530,'190.242.39.136','asalgado','root@localhost','2021-12-01 17:46:45','Ingreso IP - Modificación'),(2434,89,'192.168.128.141','asalgado','root@localhost','2021-12-03 19:54:12','Ingreso IP - Modificación'),(2435,89,'192.168.94.129','asalgado','root@localhost','2021-12-03 19:54:12','Ingreso IP - Modificación'),(2436,89,'190.242.39.136','asalgado','root@localhost','2021-12-03 19:54:12','Ingreso IP - Modificación'),(2437,589,'192.168.94.129','asalgado','root@localhost','2021-12-03 19:57:18','Ingreso IP - Inserción'),(2438,589,'190.242.39.136','asalgado','root@localhost','2021-12-03 19:57:18','Ingreso IP - Inserción'),(2439,590,'192.168.94.129','lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso IP - Inserción'),(2440,590,'190.242.39.136','lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso IP - Inserción');
/*!40000 ALTER TABLE `fqs_IpAutorizada` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_fqs_IpAutorizada` BEFORE INSERT ON `fqs_IpAutorizada` 
FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_IpAutorizadaInsert` AFTER INSERT ON `fqs_IpAutorizada` 
FOR EACH ROW BEGIN
INSERT INTO au_IpAutorizada
(`id_ip`,
`ip_usuario`,
`ip`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_modificacion`)           
VALUES 


(NEW.id_ip,
NEW.ip_usuario,
NEW.ip,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultima_modificacion,
NEW.c_tipo_modificacion,

NOW(),
SESSION_USER(),
'INSERCIÓN REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_upd_fqs_IpAutorizada` BEFORE UPDATE ON `fqs_IpAutorizada` 
FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_IpAutorizadaUpdate` AFTER DELETE ON `fqs_IpAutorizada` 
FOR EACH ROW BEGIN
INSERT INTO au_IpAutorizada
(`id_ip`,
`ip_usuario`,
`ip`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_modificacion`)           
VALUES 


(OLD.id_ip,
OLD.ip_usuario,
OLD.ip,
OLD.c_usuario_sistema_ultima_mod,
OLD.c_usuario_bd_datos,
OLD.ts_fecha_hora_ultima_modificacion,
OLD.c_tipo_modificacion,

NOW(),
SESSION_USER(),
'BORRADO REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fqs_Parametrizacion`
--

DROP TABLE IF EXISTS `fqs_Parametrizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_Parametrizacion` (
  `EntidadDeNegociosID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de la tabla',
  `UsuarioID` int(11) NOT NULL COMMENT 'Campo llave de negocio entre Parametrizaci�n y Usuario',
  `FechaIniOperacion` date NOT NULL COMMENT 'Campo para la fecha de inicio de la operaci�n',
  `HoraIniOperacion` time NOT NULL COMMENT 'Campo para la hora de inicio de la operaci�n',
  `FechaFinOperacion` date NOT NULL COMMENT 'Campo para la fecha de finalizaci�n de la operaci�n',
  `HoraFinOperacion` time NOT NULL COMMENT 'Campo para la hora de finalizaci�n de la operaci�n',
  `MinAccionesObjOferta` decimal(11,0) NOT NULL COMMENT 'Campo para el n�mero minimo de acciones',
  `MaxAccionesObjOferta` decimal(11,0) NOT NULL COMMENT 'Campo para el n�mero maximo de acciones',
  `NombreRazonSocial` varchar(50) NOT NULL COMMENT 'Campo para el nombre o razon social',
  `PrecioAceptaciones` decimal(16,2) NOT NULL COMMENT 'Campo para el percio de las aceptaciones',
  `NumeroAceptacion` int(11) NOT NULL COMMENT 'Campo para el n�mero o consecutivo',
  `TextoUno` varchar(600) NOT NULL COMMENT 'Campo para el texto 1',
  `TextoDos` varchar(600) NOT NULL COMMENT 'Campo para el texto 2',
  `ExistePreacuerdo` tinyint(1) NOT NULL COMMENT 'Campo si existe � no preacuerdo',
  `CantReporte` decimal(2,0) NOT NULL COMMENT 'Campo para la cantidad de reportes',
  `Nanotecnico` varchar(20) DEFAULT NULL COMMENT 'Campo para el nanot�cnico',
  `ClaseAcciones` varchar(20) DEFAULT NULL COMMENT 'Campo para las clases de acciones',
  `CantUsuariosOpe` decimal(3,0) DEFAULT NULL,
  `NombreUsuarioIdCreacion` int(11) NOT NULL COMMENT 'Usuario quien crea el registro',
  `FechaCreacion` datetime NOT NULL COMMENT 'Fecha en la que se creo el nuevo registro',
  `NombreUsuarioIdModificacion` int(11) NOT NULL COMMENT 'Usuario quien modifica el registro',
  `FechaModificacion` datetime NOT NULL COMMENT 'Fecha en la que se realizo la ultima actualizaci�n',
  `TodoONada` tinyint(1) NOT NULL,
  `ActivarCargaMasiva` tinyint(1) NOT NULL,
  `TipoDocumentoOferente` int(11) NOT NULL COMMENT 'Tipo de documento del comprador',
  `NumeroDocumentoOferente` varchar(15) NOT NULL COMMENT 'N�mero de documento del oferente',
  `DVOferente` varchar(8) DEFAULT NULL COMMENT 'Dígito de verificaci�n del oferente',
  `EFOferente` varchar(3) DEFAULT NULL COMMENT 'Especial fiduciario del oferente',
  `CuentaDecevalOferente` int(8) NOT NULL COMMENT 'Cuenta Deceval del Oferente',
  `SCBOferente` int(11) NOT NULL COMMENT 'SCB que representa al oferente',
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  `HoraIniOperacionCarga` time DEFAULT NULL COMMENT 'Campo para la hora inicio de la carga masiva',
  `HoraFinOperacionCarga` time DEFAULT NULL COMMENT 'Campo para la hora Fin de la carga masiva',
  `Accionesnegociadas` varchar(30) DEFAULT NULL,
  `TxtBoletinInformativo` varchar(700) DEFAULT NULL,
  `umbral` int(15) DEFAULT NULL,
  `precioaccionespago` int(10) DEFAULT NULL,
  `porcentajeefectivopago` int(3) DEFAULT NULL,
  `TextoTres` varchar(600) DEFAULT NULL,
  `TextoCuatro` varchar(600) DEFAULT NULL,
  `TextoCinco` varchar(600) DEFAULT NULL,
  `TextoSeis` varchar(600) DEFAULT NULL,
  `TextoSiete` varchar(640) DEFAULT NULL,
  `tipo_oferta_publica` varchar(3) DEFAULT 'OPA' COMMENT 'Valores vÃ¡lidos: OPA. OPI',
  `tipo_pago` int(1) DEFAULT NULL,
  `direccion` tinyint(1) DEFAULT '0' COMMENT 'Activar el campo direccion en formulario de ingreso de aceptaciones',
  `MILA` tinyint(1) DEFAULT '0' COMMENT 'Activa MILA en la operacion',
  PRIMARY KEY (`EntidadDeNegociosID`),
  UNIQUE KEY `Uk_Parametrizacion` (`UsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='-- =============================================\nAuthor: Leonard Willian Prens Herrera\nCreate date: 15-02-2016\nDescription: Tabla Diccionario Parametrizacion de los usuarios.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_Parametrizacion`
--

LOCK TABLES `fqs_Parametrizacion` WRITE;
/*!40000 ALTER TABLE `fqs_Parametrizacion` DISABLE KEYS */;
INSERT INTO `fqs_Parametrizacion` VALUES (1,89,'2021-12-03','09:00:00','2021-12-04','12:59:59',1,390266,'SMURFIT KAPPA GROUP PLC',9850.00,0,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad CARTÓN DE COLOMBIA S.A. que han sido ofrecidas en compra por parte de SMURFIT KAPPA GROUP PLC., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.\n\nESTA ACEPTACIÓN A LA OFERTA, SE CONSIDERA EN FIRME Y POR LO TANTO ES IRREVOCABLE A PARTIR DEL MOMENTO DE LA PRESENTACIÓN DE LA MISMA, SIN QUE HAYA LUGAR A SU MODIFICACIÓN, DESISTIMIENTO O CESACIÓN DE EFECTOS, SALVO EN LOS CASOS QUE BVC LO CONSIDERE.',2,3,'CARTON','Ordinarias',10,89,'2021-05-06 17:55:16',89,'2021-12-03 15:02:00',1,1,4,'444444100','5','',2209266,10,'lmuneton','root@localhost','2021-12-03 20:02:00','Actualizar Parametro - Actualización','09:00:00','11:59:59','CARTÓN DE COLOMBIA S.A.','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 de 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de CARTÓN DE COLOMBIA S.A., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo trescientas noventa mil doscientas sesenta y seis (390.266) acciones ordinarias.',0,0,0,NULL,NULL,NULL,NULL,NULL,'OPA',NULL,2,2);
/*!40000 ALTER TABLE `fqs_Parametrizacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_fqs_Parametrizacion` BEFORE INSERT ON `fqs_Parametrizacion` 
FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_ParametrizacionInsert` AFTER INSERT ON `fqs_Parametrizacion` FOR EACH ROW BEGIN


INSERT INTO au_Parametrizacion
(`EntidadDeNegociosID`,
`UsuarioID`,
`FechaIniOperacion`,
`HoraIniOperacion`,
`FechaFinOperacion`,
`HoraFinOperacion`,
`MinAccionesObjOferta`,
`MaxAccionesObjOferta`,
`NombreRazonSocial`,
`PrecioAceptaciones`,
`NumeroAceptacion`,
`TextoUno`,
`TextoDos`,
`ExistePreacuerdo`,
`CantReporte`,
`Nanotecnico`,
`ClaseAcciones`,
`CantUsuariosOpe`,
`NombreUsuarioIdCreacion`,
`FechaCreacion`,
`NombreUsuarioIdModificacion`,
`FechaModificacion`,
`TodoONada`,
`ActivarCargaMasiva`,
`TipoDocumentoOferente`,
`NumeroDocumentoOferente`,
`DVOferente`,
`EFOferente`,
`CuentaDecevalOferente`,
`SCBOferente`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`HoraIniOperacionCarga`,
`HoraFinOperacionCarga`,
`Accionesnegociadas`,
`TxtBoletinInformativo`,
`au_usuario_bd`,
`au_fecha_modificacion`,
`au_tipo_accion`)           
VALUES 
(NEW.EntidadDeNegociosID,
NEW.UsuarioID,
NEW.FechaIniOperacion,
NEW.HoraIniOperacion,
NEW.FechaFinOperacion,
NEW.HoraFinOperacion,
NEW.MinAccionesObjOferta,
NEW.MaxAccionesObjOferta,
NEW.NombreRazonSocial,
NEW.PrecioAceptaciones,
NEW.NumeroAceptacion,
NEW.TextoUno,
NEW.TextoDos,
NEW.ExistePreacuerdo,
NEW.CantReporte,
NEW.Nanotecnico,
NEW.ClaseAcciones,
NEW.CantUsuariosOpe,
NEW.NombreUsuarioIdCreacion,
NEW.FechaCreacion,
NEW.NombreUsuarioIdModificacion,
NEW.FechaModificacion,
NEW.TodoONada,
NEW.ActivarCargaMasiva,
NEW.TipoDocumentoOferente,
NEW.NumeroDocumentoOferente,
NEW.DVOferente,
NEW.EFOferente,
NEW.CuentaDecevalOferente,
NEW.SCBOferente,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultima_modificacion,
NEW.c_tipo_modificacion,
NEW.HoraIniOperacionCarga,
NEW.HoraFinOperacionCarga,
NEW.Accionesnegociadas,
NEW.TxtBoletinInformativo,
SESSION_USER(),
NOW(),
'INSERCI? REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_upd_fqs_Parametrizacion` BEFORE UPDATE ON `fqs_Parametrizacion` 
FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_ParametrizacionUpdate` AFTER UPDATE ON `fqs_Parametrizacion` FOR EACH ROW BEGIN


INSERT INTO au_Parametrizacion
(`EntidadDeNegociosID`,
`UsuarioID`,
`FechaIniOperacion`,
`HoraIniOperacion`,
`FechaFinOperacion`,
`HoraFinOperacion`,
`MinAccionesObjOferta`,
`MaxAccionesObjOferta`,
`NombreRazonSocial`,
`PrecioAceptaciones`,
`NumeroAceptacion`,
`TextoUno`,
`TextoDos`,
`ExistePreacuerdo`,
`CantReporte`,
`Nanotecnico`,
`ClaseAcciones`,
`CantUsuariosOpe`,
`NombreUsuarioIdCreacion`,
`FechaCreacion`,
`NombreUsuarioIdModificacion`,
`FechaModificacion`,
`TodoONada`,
`ActivarCargaMasiva`,
`TipoDocumentoOferente`,
`NumeroDocumentoOferente`,
`DVOferente`,
`EFOferente`,
`CuentaDecevalOferente`,
`SCBOferente`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`HoraIniOperacionCarga`,
`HoraFinOperacionCarga`,
`Accionesnegociadas`,
`TxtBoletinInformativo`,
`au_usuario_bd`,
`au_fecha_modificacion`,
`au_tipo_accion`)           
VALUES 
(NEW.EntidadDeNegociosID,
NEW.UsuarioID,
NEW.FechaIniOperacion,
NEW.HoraIniOperacion,
NEW.FechaFinOperacion,
NEW.HoraFinOperacion,
NEW.MinAccionesObjOferta,
NEW.MaxAccionesObjOferta,
NEW.NombreRazonSocial,
NEW.PrecioAceptaciones,
NEW.NumeroAceptacion,
NEW.TextoUno,
NEW.TextoDos,
NEW.ExistePreacuerdo,
NEW.CantReporte,
NEW.Nanotecnico,
NEW.ClaseAcciones,
NEW.CantUsuariosOpe,
NEW.NombreUsuarioIdCreacion,
NEW.FechaCreacion,
NEW.NombreUsuarioIdModificacion,
NEW.FechaModificacion,
NEW.TodoONada,
NEW.ActivarCargaMasiva,
NEW.TipoDocumentoOferente,
NEW.NumeroDocumentoOferente,
NEW.DVOferente,
NEW.EFOferente,
NEW.CuentaDecevalOferente,
NEW.SCBOferente,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultima_modificacion,
NEW.c_tipo_modificacion,
NEW.HoraIniOperacionCarga,
NEW.HoraFinOperacionCarga,
NEW.Accionesnegociadas,
NEW.TxtBoletinInformativo,
SESSION_USER(),
NOW(),
'ACTUALIZACI? REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_ParametrizacionDelete` AFTER DELETE ON `fqs_Parametrizacion` FOR EACH ROW BEGIN

INSERT INTO au_Parametrizacion
(`EntidadDeNegociosID`,
`UsuarioID`,
`FechaIniOperacion`,
`HoraIniOperacion`,
`FechaFinOperacion`,
`HoraFinOperacion`,
`MinAccionesObjOferta`,
`MaxAccionesObjOferta`,
`NombreRazonSocial`,
`PrecioAceptaciones`,
`NumeroAceptacion`,
`TextoUno`,
`TextoDos`,
`ExistePreacuerdo`,
`CantReporte`,
`Nanotecnico`,
`ClaseAcciones`,
`CantUsuariosOpe`,
`NombreUsuarioIdCreacion`,
`FechaCreacion`,
`NombreUsuarioIdModificacion`,
`FechaModificacion`,
`TodoONada`,
`ActivarCargaMasiva`,
`TipoDocumentoOferente`,
`NumeroDocumentoOferente`,
`DVOferente`,
`EFOferente`,
`CuentaDecevalOferente`,
`SCBOferente`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`HoraIniOperacionCarga`,
`HoraFinOperacionCarga`,
`Accionesnegociadas`,
`TxtBoletinInformativo`,
`au_usuario_bd`,
`au_fecha_modificacion`,
`au_tipo_accion`)           
VALUES 
(OLD.EntidadDeNegociosID,
OLD.UsuarioID,
OLD.FechaIniOperacion,
OLD.HoraIniOperacion,
OLD.FechaFinOperacion,
OLD.HoraFinOperacion,
OLD.MinAccionesObjOferta,
OLD.MaxAccionesObjOferta,
OLD.NombreRazonSocial,
OLD.PrecioAceptaciones,
OLD.NumeroAceptacion,
OLD.TextoUno,
OLD.TextoDos,
OLD.ExistePreacuerdo,
OLD.CantReporte,
OLD.Nanotecnico,
OLD.ClaseAcciones,
OLD.CantUsuariosOpe,
OLD.NombreUsuarioIdCreacion,
OLD.FechaCreacion,
OLD.NombreUsuarioIdModificacion,
OLD.FechaModificacion,
OLD.TodoONada,
OLD.ActivarCargaMasiva,
OLD.TipoDocumentoOferente,
OLD.NumeroDocumentoOferente,
OLD.DVOferente,
OLD.EFOferente,
OLD.CuentaDecevalOferente,
OLD.SCBOferente,
OLD.c_usuario_sistema_ultima_mod,
OLD.c_usuario_bd_datos,
OLD.ts_fecha_hora_ultima_modificacion,
OLD.c_tipo_modificacion,
OLD.HoraIniOperacionCarga,
OLD.HoraFinOperacionCarga,
OLD.Accionesnegociadas,
OLD.TxtBoletinInformativo,
SESSION_USER(),
NOW(),
'BORRADO REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fqs_adjudicacion`
--

DROP TABLE IF EXISTS `fqs_adjudicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_adjudicacion` (
  `i_id_adjudicacion` int(11) NOT NULL AUTO_INCREMENT,
  `i_id_aceptacion` int(11) DEFAULT NULL,
  `i_acciones_adjudicadas` double(15,0) DEFAULT NULL,
  `d_precio` decimal(15,2) DEFAULT NULL,
  `d_monto` decimal(17,2) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultima_modificacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`i_id_adjudicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_adjudicacion`
--

LOCK TABLES `fqs_adjudicacion` WRITE;
/*!40000 ALTER TABLE `fqs_adjudicacion` DISABLE KEYS */;
INSERT INTO `fqs_adjudicacion` VALUES (1,1,15,9850.00,147750.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(2,2,200,9850.00,1970000.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(3,3,677,9850.00,6668450.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(4,4,253,9850.00,2492050.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(5,5,2625,9850.00,25856250.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(6,6,202,9850.00,1989700.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(7,7,13139,9850.00,129419150.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(8,8,656,9850.00,6461600.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(9,9,55,9850.00,541750.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(10,10,191,9850.00,1881350.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(11,11,2521,9850.00,24831850.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción'),(12,12,3,9850.00,29550.00,'Adjudicado','cvargas','root@localhost','2021-05-27 15:49:51','Ingreso Adjudicaión - Inserción');
/*!40000 ALTER TABLE `fqs_adjudicacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_fqsAdjudicacion` BEFORE INSERT ON `fqs_adjudicacion` 
FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_AdjudicacionInsert` AFTER INSERT ON `fqs_adjudicacion` 
FOR EACH ROW BEGIN
INSERT INTO au_adjudicacion
(`i_id_adjudicacion`,
`i_id_aceptacion`,
`i_acciones_adjudicadas`,
`d_precio`,
`d_monto`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`) 	          
VALUES 


(NEW.i_id_adjudicacion,
NEW.i_id_aceptacion,
NEW.i_acciones_adjudicadas,
NEW.d_precio,
NEW.d_monto,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultima_modificacion,
NEW.c_tipo_modificacion,

NOW(),
SESSION_USER(),
'INSERCI? REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_AdjudicacionUpdate` AFTER UPDATE ON `fqs_adjudicacion` 
FOR EACH ROW BEGIN
INSERT INTO au_adjudicacion
(`i_id_adjudicacion`,
`i_id_aceptacion`,
`i_acciones_adjudicadas`,
`d_precio`,
`d_monto`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`) 	          
VALUES 


(NEW.i_id_adjudicacion,
NEW.i_id_aceptacion,
NEW.i_acciones_adjudicadas,
NEW.d_precio,
NEW.d_monto,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultima_modificacion,
NEW.c_tipo_modificacion,

NOW(),
SESSION_USER(),
'ACTUALIZACI? REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_AdjudicacionDelete` AFTER DELETE ON `fqs_adjudicacion` 
FOR EACH ROW BEGIN
INSERT INTO au_adjudicacion
(`i_id_adjudicacion`,
`i_id_aceptacion`,
`i_acciones_adjudicadas`,
`d_precio`,
`d_monto`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultima_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`) 	          
VALUES 


(OLD.i_id_adjudicacion,
OLD.i_id_aceptacion,
OLD.i_acciones_adjudicadas,
OLD.d_precio,
OLD.d_monto,
OLD.c_usuario_sistema_ultima_mod,
OLD.c_usuario_bd_datos,
OLD.ts_fecha_hora_ultima_modificacion,
OLD.c_tipo_modificacion,

NOW(),
SESSION_USER(),
'BORRADO REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fqs_auditoria`
--

DROP TABLE IF EXISTS `fqs_auditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_auditoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_fecha` datetime NOT NULL,
  `i_idusuario` int(11) DEFAULT NULL,
  `c_ip` varchar(20) DEFAULT NULL,
  `c_evento` varchar(1001) DEFAULT NULL,
  `c_resultado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`t_fecha`),
  KEY `fk_auditoria_usuario` (`i_idusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=176 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_auditoria`
--

LOCK TABLES `fqs_auditoria` WRITE;
/*!40000 ALTER TABLE `fqs_auditoria` DISABLE KEYS */;
INSERT INTO `fqs_auditoria` VALUES (1,'2021-05-07 16:47:37',569,'190.242.36.50','Inicio de sesión','Fecha/Horario previo al inicio de la operación'),(2,'2021-05-07 17:13:25',448,'190.242.39.136','Inicio de sesión','Exitoso'),(3,'2021-05-07 17:39:06',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(4,'2021-05-10 08:04:22',448,'190.242.39.136','Inicio de sesión','Exitoso'),(5,'2021-05-10 08:08:13',89,'190.242.39.136','Inicio de sesión','Exitoso'),(6,'2021-05-10 08:15:06',89,'190.242.39.136','Fin de sesión usuario','Exitoso'),(7,'2021-05-10 08:25:36',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(8,'2021-05-10 13:35:50',448,'190.242.39.136','Inicio de sesión','Exitoso'),(9,'2021-05-10 17:43:43',120,'190.242.39.139','Inicio de sesión','Exitoso'),(10,'2021-05-11 08:25:05',570,'190.143.111.130','Inicio de sesión','Exitoso'),(11,'2021-05-11 08:33:24',570,'190.143.111.130','Fin de sesión usuario','Exitoso'),(12,'2021-05-11 11:34:22',571,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(13,'2021-05-11 11:34:44',571,'190.143.111.130','Inicio de sesión','Exitoso'),(14,'2021-05-11 11:48:59',569,'190.242.36.50','Inicio de sesión','Exitoso'),(15,'2021-05-11 13:21:17',448,'190.242.39.136','Inicio de sesión','Exitoso'),(16,'2021-05-11 16:59:06',120,'190.242.39.139','Inicio de sesión','Exitoso'),(17,'2021-05-12 09:13:43',560,'201.221.124.8','Inicio de sesión','Exitoso'),(18,'2021-05-12 13:17:47',448,'190.242.39.136','Inicio de sesión','Exitoso'),(19,'2021-05-12 15:05:04',448,'190.242.39.138','Fin de sesión usuario','Exitoso'),(20,'2021-05-13 10:55:37',560,'201.221.124.8','Inicio de sesión','Exitoso'),(21,'2021-05-13 11:11:37',560,'201.221.124.8','Fin de sesión usuario','Exitoso'),(22,'2021-05-13 12:07:03',573,'191.92.40.141','Intento fallido de acceso al sistema','Fallido'),(23,'2021-05-13 12:07:22',573,'191.92.40.141','Intento fallido por IP no registrada','Fallido'),(24,'2021-05-13 12:09:11',573,'190.131.244.230','Intento fallido de acceso al sistema','Fallido'),(25,'2021-05-13 12:10:15',573,'190.131.244.230','Inicio de sesión','Usuario Bloqueado'),(26,'2021-05-13 12:22:37',569,'190.242.36.50','Inicio de sesión','Exitoso'),(27,'2021-05-13 12:26:00',573,'190.131.244.230','Inicio de sesión','Exitoso'),(28,'2021-05-13 13:08:11',448,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(29,'2021-05-13 13:08:24',448,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(30,'2021-05-13 13:08:48',448,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(31,'2021-05-13 13:09:26',448,'190.26.11.237','Inicio de sesión','Exitoso'),(32,'2021-05-13 13:35:09',448,'190.26.11.237','Fin de sesión usuario','Exitoso'),(33,'2021-05-13 13:37:36',573,'190.131.244.230','Fin de sesión usuario','Exitoso'),(34,'2021-05-14 09:09:14',560,'201.221.124.8','Inicio de sesión','Exitoso'),(35,'2021-05-14 09:11:15',560,'201.221.124.8','Fin de sesión usuario','Exitoso'),(36,'2021-05-14 10:27:24',572,'190.143.111.130','Inicio de sesión','Exitoso'),(37,'2021-05-14 13:17:38',448,'190.242.39.136','Inicio de sesión','Exitoso'),(38,'2021-05-14 13:40:33',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(39,'2021-05-14 16:20:57',120,'190.242.39.139','Inicio de sesión','Exitoso'),(40,'2021-05-18 11:51:39',89,'190.242.39.136','Inicio de sesión','Exitoso'),(41,'2021-05-18 13:00:47',89,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(42,'2021-05-18 13:01:08',89,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(43,'2021-05-18 13:01:51',89,'190.242.39.136','Inicio de sesión','Exitoso'),(44,'2021-05-19 11:42:33',571,'190.143.111.130','Inicio de sesión','Exitoso'),(45,'2021-05-19 13:52:10',89,'190.242.39.136','Inicio de sesión','Exitoso'),(46,'2021-05-20 08:20:49',576,'190.131.197.10','Inicio de sesión','Exitoso'),(47,'2021-05-20 09:03:03',577,'190.131.197.10','Intento fallido de acceso al sistema','Fallido'),(48,'2021-05-20 09:04:07',577,'190.131.197.10','Inicio de sesión','Exitoso'),(49,'2021-05-20 09:08:07',576,'190.131.197.10','Inicio de sesión','Exitoso'),(50,'2021-05-20 11:38:54',571,'190.143.111.130','Inicio de sesión','Exitoso'),(51,'2021-05-20 13:20:39',89,'190.242.39.136','Inicio de sesión','Exitoso'),(52,'2021-05-20 13:34:41',577,'190.131.197.10','Fin de sesión usuario','Exitoso'),(53,'2021-05-21 09:11:29',576,'190.131.197.10','Inicio de sesión','Exitoso'),(54,'2021-05-21 09:17:07',560,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(55,'2021-05-21 09:17:15',560,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(56,'2021-05-21 09:22:04',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(57,'2021-05-21 09:22:27',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(58,'2021-05-21 09:25:29',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(59,'2021-05-21 09:25:58',560,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(60,'2021-05-21 09:30:05',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(61,'2021-05-21 09:37:34',560,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(62,'2021-05-21 09:38:45',564,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(63,'2021-05-21 09:59:44',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(64,'2021-05-21 10:11:02',120,'190.242.39.139','Inicio de sesión','Exitoso'),(65,'2021-05-21 10:17:10',559,'201.221.124.121','Intento fallido de acceso al sistema','Fallido'),(66,'2021-05-21 10:17:26',559,'201.221.124.121','Intento fallido de acceso al sistema','Fallido'),(67,'2021-05-21 10:19:32',559,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(68,'2021-05-21 10:20:17',559,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(69,'2021-05-21 10:22:07',559,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(70,'2021-05-21 10:23:05',559,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(71,'2021-05-21 10:28:54',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(72,'2021-05-21 10:33:21',89,'190.252.48.244','Intento fallido por IP no registrada','Fallido'),(73,'2021-05-21 11:11:31',581,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(74,'2021-05-21 11:12:12',581,'190.131.201.70','Inicio de sesión','Exitoso'),(75,'2021-05-21 11:14:28',559,'201.221.124.121','Intento fallido de acceso al sistema','Fallido'),(76,'2021-05-21 11:15:34',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(77,'2021-05-21 11:16:30',559,'201.221.124.121','Intento fallido de acceso al sistema','Fallido'),(78,'2021-05-21 11:17:31',559,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(79,'2021-05-21 11:22:16',582,'190.131.201.70','Inicio de sesión','Exitoso'),(80,'2021-05-21 11:35:59',120,'190.242.39.139','Inicio de sesión','Exitoso'),(81,'2021-05-21 11:37:44',585,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(82,'2021-05-21 11:41:42',585,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(83,'2021-05-21 11:42:50',559,'201.221.124.121','Intento fallido por IP no registrada','Fallido'),(84,'2021-05-21 11:42:55',585,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(85,'2021-05-21 11:45:52',585,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(86,'2021-05-21 11:47:06',585,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(87,'2021-05-21 11:48:49',566,'201.221.124.121','Intento fallido de acceso al sistema','Fallido'),(88,'2021-05-21 11:49:25',585,'190.131.201.70','Inicio de sesión','Exitoso'),(89,'2021-05-21 11:49:28',566,'201.221.124.121','Intento fallido de acceso al sistema','Fallido'),(90,'2021-05-21 11:49:58',566,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(91,'2021-05-21 11:51:38',566,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(92,'2021-05-21 12:04:53',582,'190.131.201.70','Fin de sesión usuario','Exitoso'),(93,'2021-05-21 12:11:25',559,'201.221.124.121','Inicio de sesión','Exitoso'),(94,'2021-05-21 12:16:42',559,'201.221.124.121','Fin de sesión usuario','Exitoso'),(95,'2021-05-21 12:16:54',566,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(96,'2021-05-21 12:16:57',560,'201.221.124.121','Inicio de sesión','Exitoso'),(97,'2021-05-21 12:17:39',566,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(98,'2021-05-21 12:20:22',566,'201.221.124.121','Inicio de sesión','Usuario Bloqueado'),(99,'2021-05-21 12:23:04',559,'201.221.124.121','Inicio de sesión','Exitoso'),(100,'2021-05-21 12:24:30',559,'201.221.124.121','Fin de sesión usuario','Exitoso'),(101,'2021-05-21 12:29:16',566,'201.221.124.121','Inicio de sesión','Exitoso'),(102,'2021-05-21 12:53:59',560,'201.221.124.121','Fin de sesión usuario','Exitoso'),(103,'2021-05-21 13:17:01',89,'190.242.39.136','Inicio de sesión','Exitoso'),(104,'2021-05-21 13:22:22',89,'190.242.39.136','Inicio de sesión','Exitoso'),(105,'2021-05-24 09:05:21',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(106,'2021-05-24 09:05:29',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(107,'2021-05-24 09:05:57',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(108,'2021-05-24 09:10:29',559,'201.221.124.8','Inicio de sesión','Exitoso'),(109,'2021-05-24 09:11:34',564,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(110,'2021-05-24 09:15:33',560,'201.221.124.8','Intento fallido de acceso al sistema','Fallido'),(111,'2021-05-24 09:22:07',560,'201.221.124.8','Intento fallido de acceso al sistema','Fallido'),(112,'2021-05-24 09:22:28',560,'201.221.124.8','Inicio de sesión','Usuario Bloqueado'),(113,'2021-05-24 09:23:07',560,'201.221.124.8','Inicio de sesión','Usuario Bloqueado'),(114,'2021-05-24 09:23:09',560,'201.221.124.8','Inicio de sesión','Usuario Bloqueado'),(115,'2021-05-24 09:25:08',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(116,'2021-05-24 09:26:50',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(117,'2021-05-24 09:28:19',560,'201.221.124.8','Intento fallido de acceso al sistema','Fallido'),(118,'2021-05-24 09:28:54',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(119,'2021-05-24 09:31:52',560,'201.221.124.8','Intento fallido por IP no registrada','Fallido'),(120,'2021-05-24 09:37:06',560,'201.221.124.8','Inicio de sesión','Exitoso'),(121,'2021-05-24 12:10:52',581,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(122,'2021-05-24 12:11:10',581,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(123,'2021-05-24 12:15:13',581,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(124,'2021-05-24 12:28:08',259,'190.242.39.136','Inicio de sesión','Exitoso'),(125,'2021-05-24 12:29:59',581,'190.131.201.70','Inicio de sesión','Exitoso'),(126,'2021-05-24 12:32:53',259,'190.242.39.136','Fin de sesión usuario','Exitoso'),(127,'2021-05-24 13:13:15',448,'190.242.39.136','Inicio de sesión','Exitoso'),(128,'2021-05-24 13:42:47',559,'201.221.124.8','Fin de sesión usuario','Exitoso'),(129,'2021-05-24 13:44:34',89,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(130,'2021-05-24 13:45:08',89,'190.242.39.136','Inicio de sesión','Exitoso'),(131,'2021-05-24 16:05:53',448,'190.242.39.138','Fin de sesión usuario','Exitoso'),(132,'2021-05-25 10:10:37',448,'190.242.39.136','Intento fallido de acceso al sistema','Fallido'),(133,'2021-05-25 10:10:50',448,'190.242.39.136','Inicio de sesión','Exitoso'),(134,'2021-05-25 11:00:38',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(135,'2021-05-27 10:40:52',448,'190.242.39.136','Inicio de sesión','Exitoso'),(136,'2021-05-27 10:54:47',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(137,'2021-05-27 13:14:27',448,'190.242.39.136','Inicio de sesión','Exitoso'),(138,'2021-05-27 13:16:37',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(139,'2021-07-09 08:38:20',120,'190.131.244.209','Inicio de sesión','Exitoso'),(140,'2021-07-12 18:00:07',1,'190.242.39.136','Inicio de sesión','Usuario Inactivo'),(141,'2021-07-12 18:00:38',1,'190.242.39.136','Inicio de sesión','Usuario Inactivo'),(142,'2021-07-12 18:01:43',1,'190.242.39.136','Inicio de sesión','Usuario Inactivo'),(143,'2021-07-12 18:02:06',1,'190.242.39.136','Inicio de sesión','Usuario Inactivo'),(144,'2021-07-19 16:49:10',448,'190.242.39.136','Intento fallido de acceso al sistema','Fallido'),(145,'2021-07-19 16:50:00',448,'190.242.39.136','Inicio de sesión','Exitoso'),(146,'2021-07-22 16:37:09',448,'190.242.39.136','Inicio de sesión','Exitoso'),(147,'2021-07-22 16:37:30',448,'190.242.39.136','Fin de sesión usuario','Exitoso'),(148,'2021-08-04 10:50:50',583,'190.131.201.70','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(149,'2021-08-04 15:21:54',570,'190.143.111.130','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(150,'2021-08-04 15:37:49',570,'190.143.111.130','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(151,'2021-08-04 15:38:12',570,'190.143.111.130','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(152,'2021-08-05 10:13:17',562,'181.236.217.20','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(153,'2021-08-05 14:28:53',562,'181.236.217.20','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(154,'2021-08-09 10:08:36',562,'181.236.217.20','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(155,'2021-08-09 16:19:56',562,'181.236.217.20','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(156,'2021-09-24 16:08:03',576,'190.131.197.10','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(157,'2021-09-28 08:55:54',577,'190.131.197.10','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(158,'2021-11-03 15:18:05',448,'186.84.91.44','Intento fallido de acceso al sistema','Fallido'),(159,'2021-11-24 10:31:37',576,'190.131.197.10','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(160,'2021-11-24 15:45:22',259,'190.242.39.136','Inicio de sesión','Exitoso'),(161,'2021-11-24 15:46:37',259,'190.242.39.136','Fin de sesión usuario','Exitoso'),(162,'2021-11-26 12:32:37',570,'190.143.111.130','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(163,'2021-11-26 12:34:33',570,'190.143.111.130','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(164,'2021-12-01 12:46:06',259,'190.242.39.136','Inicio de sesión','Exitoso'),(165,'2021-12-03 11:58:38',89,'190.242.39.136','Intento fallido de acceso al sistema','Fallido'),(166,'2021-12-03 14:53:41',259,'190.242.39.136','Inicio de sesión','Exitoso'),(167,'2021-12-03 14:55:50',89,'190.242.39.138','Intento fallido por IP no registrada','Fallido'),(168,'2021-12-03 14:58:49',89,'190.242.39.136','Inicio de sesión','Exitoso'),(169,'2021-12-03 15:00:53',89,'190.242.39.136','Fin de sesión usuario','Exitoso'),(170,'2021-12-03 15:01:14',589,'190.242.39.136','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(171,'2021-12-03 15:01:33',89,'190.242.39.136','Inicio de sesión','Exitoso'),(172,'2021-12-03 15:02:06',89,'190.242.39.136','Fin de sesión usuario','Exitoso'),(173,'2021-12-03 15:02:28',589,'190.242.39.136','Inicio de sesión','Exitoso'),(174,'2021-12-03 15:06:45',589,'190.242.39.136','Fin de sesión usuario','Exitoso'),(175,'2021-12-03 15:06:52',590,'190.242.39.136','Inicio de sesión','Exitoso');
/*!40000 ALTER TABLE `fqs_auditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_festivo`
--

DROP TABLE IF EXISTS `fqs_festivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_festivo` (
  `d_fecha` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`d_fecha`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_festivo`
--

LOCK TABLES `fqs_festivo` WRITE;
/*!40000 ALTER TABLE `fqs_festivo` DISABLE KEYS */;
INSERT INTO `fqs_festivo` VALUES ('0000-00-00'),('1990-12-31'),('1991-01-01'),('1991-05-01'),('1991-05-21'),('1991-09-11'),('1991-09-18'),('1991-09-19'),('1991-11-01'),('1991-12-25'),('1991-12-31'),('1992-01-01'),('1992-02-28'),('1992-02-29'),('1992-04-17'),('1992-04-18'),('1992-05-01'),('1992-05-21'),('1992-09-11'),('1992-09-18'),('1992-09-19'),('1992-10-12'),('1992-12-08'),('1992-12-25'),('1992-12-31'),('1993-01-01'),('1993-04-09'),('1993-04-10'),('1993-05-01'),('1993-05-21'),('1993-06-10'),('1993-06-29'),('1993-09-11'),('1993-09-18'),('1993-09-19'),('1993-10-12'),('1993-11-01'),('1993-12-08'),('1993-12-25'),('1993-12-31'),('1994-01-10'),('1994-03-31'),('1994-04-01'),('1994-05-16'),('1994-06-06'),('1994-06-13'),('1994-07-04'),('1994-07-20'),('1994-08-15'),('1994-10-17'),('1994-11-07'),('1994-11-14'),('1994-12-08'),('1995-01-09'),('1995-03-20'),('1995-04-13'),('1995-04-14'),('1995-05-01'),('1995-05-29'),('1995-06-19'),('1995-06-26'),('1995-07-03'),('1995-07-20'),('1995-08-07'),('1995-08-21'),('1995-10-16'),('1995-11-06'),('1995-11-13'),('1995-12-08'),('1995-12-25'),('1995-12-29'),('1996-01-01'),('1996-01-08'),('1996-03-25'),('1996-04-04'),('1996-04-05'),('1996-05-01'),('1996-05-20'),('1996-06-10'),('1996-06-17'),('1996-07-01'),('1996-07-20'),('1996-08-07'),('1996-08-19'),('1996-10-14'),('1996-11-04'),('1996-11-11'),('1996-12-24'),('1996-12-25'),('1996-12-31'),('1997-01-06'),('1997-03-24'),('1997-03-27'),('1997-03-28'),('1997-05-01'),('1997-05-12'),('1997-06-02'),('1997-06-09'),('1997-06-30'),('1997-08-07'),('1997-08-18'),('1997-10-13'),('1997-11-03'),('1997-11-17'),('1997-12-08'),('1997-12-24'),('1997-12-25'),('1997-12-31'),('1998-01-01'),('1998-01-12'),('1998-03-23'),('1998-04-09'),('1998-04-10'),('1998-05-01'),('1998-05-25'),('1998-06-15'),('1998-06-22'),('1998-06-29'),('1998-07-20'),('1998-08-07'),('1998-08-17'),('1998-10-12'),('1998-11-02'),('1998-11-16'),('1998-12-08'),('1998-12-24'),('1998-12-25'),('1998-12-31'),('1999-01-01'),('1999-01-11'),('1999-03-22'),('1999-04-01'),('1999-04-02'),('1999-05-01'),('1999-05-17'),('1999-06-07'),('1999-06-14'),('1999-07-05'),('1999-07-20'),('1999-08-07'),('1999-08-16'),('1999-10-18'),('1999-11-01'),('1999-11-15'),('1999-12-08'),('1999-12-24'),('1999-12-25'),('1999-12-29'),('1999-12-30'),('1999-12-31'),('2000-01-01'),('2000-01-03'),('2000-01-10'),('2000-03-20'),('2000-04-20'),('2000-04-21'),('2000-05-01'),('2000-06-05'),('2000-06-26'),('2000-07-03'),('2000-07-20'),('2000-08-07'),('2000-08-21'),('2000-10-16'),('2000-11-06'),('2000-11-13'),('2000-12-08'),('2000-12-25'),('2000-12-29'),('2001-01-01'),('2001-01-08'),('2001-03-19'),('2001-04-12'),('2001-04-13'),('2001-05-01'),('2001-05-17'),('2001-05-28'),('2001-06-18'),('2001-06-25'),('2001-07-02'),('2001-07-20'),('2001-08-07'),('2001-08-20'),('2001-10-15'),('2001-11-05'),('2001-11-12'),('2001-12-08'),('2001-12-25'),('2001-12-31'),('2002-01-01'),('2002-01-07'),('2002-03-25'),('2002-03-28'),('2002-03-29'),('2002-05-01'),('2002-05-13'),('2002-06-03'),('2002-06-10'),('2002-07-01'),('2002-07-20'),('2002-08-07'),('2002-08-19'),('2002-10-14'),('2002-11-04'),('2002-11-11'),('2002-12-08'),('2002-12-25'),('2002-12-31'),('2003-01-01'),('2003-01-06'),('2003-03-24'),('2003-04-17'),('2003-04-18'),('2003-05-01'),('2003-06-02'),('2003-06-23'),('2003-06-30'),('2003-07-20'),('2003-08-07'),('2003-08-18'),('2003-10-13'),('2003-11-03'),('2003-11-17'),('2003-12-08'),('2003-12-25'),('2003-12-31'),('2004-01-01'),('2004-01-12'),('2004-03-22'),('2004-04-08'),('2004-04-09'),('2004-05-01'),('2004-05-24'),('2004-06-14'),('2004-06-21'),('2004-07-05'),('2004-07-20'),('2004-08-07'),('2004-08-16'),('2004-10-18'),('2004-11-01'),('2004-11-15'),('2004-12-08'),('2004-12-25'),('2004-12-31'),('2005-01-01'),('2005-01-10'),('2005-03-21'),('2005-03-24'),('2005-03-25'),('2005-05-01'),('2005-05-09'),('2005-05-30'),('2005-06-06'),('2005-07-04'),('2005-07-20'),('2005-08-07'),('2005-08-15'),('2005-10-17'),('2005-11-07'),('2005-11-14'),('2005-12-08'),('2005-12-25'),('2005-12-30'),('2006-01-01'),('2006-01-09'),('2006-03-20'),('2006-04-13'),('2006-04-14'),('2006-05-01'),('2006-05-29'),('2006-06-19'),('2006-06-26'),('2006-07-03'),('2006-07-20'),('2006-08-07'),('2006-08-21'),('2006-10-16'),('2006-11-06'),('2006-11-13'),('2006-12-08'),('2006-12-25'),('2006-12-29'),('2007-01-01'),('2007-01-08'),('2007-03-19'),('2007-04-05'),('2007-04-06'),('2007-05-01'),('2007-05-21'),('2007-06-11'),('2007-06-18'),('2007-07-02'),('2007-07-20'),('2007-08-07'),('2007-08-20'),('2007-10-15'),('2007-11-05'),('2007-11-12'),('2007-12-08'),('2007-12-25'),('2007-12-31'),('2008-01-01'),('2008-01-07'),('2008-03-20'),('2008-03-21'),('2008-03-24'),('2008-05-01'),('2008-05-05'),('2008-05-26'),('2008-06-02'),('2008-06-30'),('2008-07-20'),('2008-08-07'),('2008-08-18'),('2008-10-13'),('2008-11-03'),('2008-11-17'),('2008-12-08'),('2008-12-25'),('2008-12-31'),('2009-01-01'),('2009-01-12'),('2009-03-23'),('2009-04-09'),('2009-04-10'),('2009-05-01'),('2009-05-25'),('2009-06-15'),('2009-06-22'),('2009-06-29'),('2009-07-20'),('2009-08-07'),('2009-08-17'),('2009-10-12'),('2009-11-02'),('2009-11-16'),('2009-12-08'),('2009-12-25'),('2009-12-31'),('2010-01-01'),('2010-01-02'),('2010-01-03'),('2010-01-11'),('2010-03-22'),('2010-04-01'),('2010-04-02'),('2010-04-04'),('2010-05-01'),('2010-05-17'),('2010-06-07'),('2010-06-14'),('2010-07-05'),('2010-07-20'),('2010-08-07'),('2010-08-16'),('2010-10-18'),('2010-11-01'),('2010-11-15'),('2010-12-08'),('2010-12-25'),('2010-12-31'),('2011-01-01'),('2011-01-10'),('2011-03-21'),('2011-04-21'),('2011-04-22'),('2011-05-01'),('2011-06-06'),('2011-06-27'),('2011-07-04'),('2011-07-20'),('2011-08-07'),('2011-08-15'),('2011-10-17'),('2011-11-07'),('2011-11-14'),('2011-12-08'),('2011-12-25'),('2011-12-30'),('2012-01-01'),('2012-01-09'),('2012-03-19'),('2012-04-05'),('2012-04-06'),('2012-05-01'),('2012-05-21'),('2012-06-11'),('2012-06-18'),('2012-07-02'),('2012-07-20'),('2012-08-07'),('2012-08-20'),('2012-10-15'),('2012-11-05'),('2012-11-12'),('2012-12-08'),('2012-12-25'),('2012-12-31'),('2013-01-01'),('2013-01-07'),('2013-03-25'),('2013-03-28'),('2013-03-29'),('2013-05-01'),('2013-05-13'),('2013-06-03'),('2013-06-10'),('2013-07-01'),('2013-07-20'),('2013-08-07'),('2013-08-19'),('2013-10-14'),('2013-11-04'),('2013-11-11'),('2013-12-08'),('2013-12-25'),('2014-01-01'),('2014-01-06'),('2014-03-24'),('2014-04-17'),('2014-04-18'),('2014-05-01'),('2014-06-02'),('2014-06-23'),('2014-06-30'),('2014-07-20'),('2014-08-07'),('2014-08-18'),('2014-10-13'),('2014-11-03'),('2014-11-17'),('2014-12-08'),('2014-12-25'),('2015-01-01'),('2015-01-12'),('2015-03-23'),('2015-04-02'),('2015-04-03'),('2015-05-01'),('2015-05-18'),('2015-06-08'),('2015-06-15'),('2015-06-29'),('2015-07-20'),('2015-08-07'),('2015-08-17'),('2015-10-12'),('2015-11-02'),('2015-11-16'),('2015-12-08'),('2015-12-25'),('2016-01-01'),('2016-01-11'),('2016-03-12'),('2016-03-13'),('2016-03-19'),('2016-03-20'),('2016-03-21'),('2016-03-24'),('2016-03-25'),('2016-03-26'),('2016-03-27'),('2016-04-02'),('2016-04-03'),('2016-04-09'),('2016-04-10'),('2016-04-16'),('2016-04-17'),('2016-04-23'),('2016-04-24'),('2016-04-30'),('2016-05-01'),('2016-05-07'),('2016-05-08'),('2016-05-09'),('2016-05-14'),('2016-05-15'),('2016-05-21'),('2016-05-22'),('2016-05-28'),('2016-05-29'),('2016-05-30'),('2016-06-04'),('2016-06-05'),('2016-06-06'),('2016-06-11'),('2016-06-12'),('2016-06-18'),('2016-06-19'),('2016-06-25'),('2016-06-26'),('2016-07-02'),('2016-07-03'),('2016-07-04'),('2016-07-09'),('2016-07-10'),('2016-07-16'),('2016-07-17'),('2016-07-20'),('2016-07-23'),('2016-07-24'),('2016-07-30'),('2016-07-31'),('2016-08-06'),('2016-08-07'),('2016-08-13'),('2016-08-14'),('2016-08-15'),('2016-08-20'),('2016-08-21'),('2016-08-27'),('2016-08-28'),('2016-09-03'),('2016-09-04'),('2016-09-10'),('2016-09-11'),('2016-09-17'),('2016-09-18'),('2016-09-24'),('2016-09-25'),('2016-10-01'),('2016-10-02'),('2016-10-08'),('2016-10-09'),('2016-10-15'),('2016-10-16'),('2016-10-17'),('2016-10-22'),('2016-10-23'),('2016-10-29'),('2016-10-30'),('2016-11-05'),('2016-11-06'),('2016-11-07'),('2016-11-12'),('2016-11-13'),('2016-11-14'),('2016-11-19'),('2016-11-20'),('2016-11-26'),('2016-11-27'),('2016-12-03'),('2016-12-04'),('2016-12-08'),('2016-12-10'),('2016-12-11'),('2016-12-17'),('2016-12-18'),('2016-12-24'),('2016-12-25'),('2016-12-31'),('2017-01-01'),('2017-01-09'),('2017-03-20'),('2017-04-13'),('2017-04-14'),('2017-05-01'),('2017-05-29'),('2017-06-19'),('2017-06-26'),('2017-07-03'),('2017-07-20'),('2017-08-07'),('2017-08-21'),('2017-11-06'),('2017-11-13'),('2017-12-08'),('2017-12-25'),('2018-01-01'),('2018-01-08'),('2018-03-19'),('2018-03-30'),('2018-05-01'),('2018-05-14'),('2018-06-04'),('2018-06-11'),('2018-07-02'),('2018-07-20'),('2018-08-07'),('2018-08-20'),('2018-10-15'),('2018-11-05'),('2018-11-12'),('2018-12-08'),('2018-12-25'),('2019-01-01'),('2019-01-07'),('2019-03-25'),('2019-04-18'),('2019-04-19'),('2019-05-01'),('2019-06-03'),('2019-06-24'),('2019-07-01'),('2019-07-20'),('2019-08-07'),('2019-08-19'),('2019-10-14'),('2019-11-04'),('2019-11-11'),('2019-12-08'),('2019-12-25'),('2020-01-01'),('2020-01-06'),('2020-03-23'),('2020-04-09'),('2020-04-10'),('2020-05-01'),('2020-05-25'),('2020-06-15'),('2020-06-22'),('2020-06-29'),('2020-07-20'),('2020-08-07'),('2020-08-17'),('2020-10-12'),('2020-11-02'),('2020-11-16'),('2020-12-08'),('2020-12-25'),('2021-01-01'),('2021-01-11'),('2021-03-22'),('2021-04-01'),('2021-04-02'),('2021-05-01'),('2021-05-17'),('2021-06-07'),('2021-06-14'),('2021-07-05'),('2021-07-20'),('2021-08-07'),('2021-08-16'),('2021-10-18'),('2021-11-01'),('2021-11-15'),('2021-12-08'),('2021-12-25');
/*!40000 ALTER TABLE `fqs_festivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_formapago`
--

DROP TABLE IF EXISTS `fqs_formapago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_formapago` (
  `i_id_aceptacion` int(11) DEFAULT NULL,
  `PorcentajeEfectivoAsignado` int(3) DEFAULT NULL,
  `MontoEfectivoAsignado` decimal(26,2) DEFAULT NULL,
  `PorcentajeTitulosAsignado` int(3) DEFAULT NULL,
  `MontoTitulosAsignado` decimal(26,2) DEFAULT NULL,
  `CantidadAccionesPago` bigint(20) DEFAULT NULL,
  `MontoTitulosFinal` decimal(26,2) DEFAULT NULL,
  `SaldoMontoTitulos` decimal(26,2) DEFAULT NULL,
  `MontoEfectivoFinal` decimal(26,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_formapago`
--

LOCK TABLES `fqs_formapago` WRITE;
/*!40000 ALTER TABLE `fqs_formapago` DISABLE KEYS */;
/*!40000 ALTER TABLE `fqs_formapago` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_formapagoinsert` AFTER INSERT ON `fqs_formapago` FOR EACH ROW BEGIN
INSERT INTO au_formapago
(
`i_id_aceptacion`,
	`PorcentajeEfectivoAsignado`,
	`MontoEfectivoAsignado`,
	`PorcentajeTitulosAsignado`,
	`MontoTitulosAsignado`,
	`CantidadAccionesPago`,
	`MontoTitulosFinal`,
	`SaldoMontoTitulos` ,
	`MontoEfectivoFinal`,
   `au_usuario_bd`,
   `au_fecha_modificacion` ,
   `au_tipo_accion`
)           
VALUES 
(NEW.i_id_aceptacion,
NEW.PorcentajeEfectivoAsignado,
NEW.MontoEfectivoAsignado,
NEW.PorcentajeTitulosAsignado,
NEW.MontoTitulosAsignado,
NEW.CantidadAccionesPago,
NEW.MontoTitulosFinal,
NEW.SaldoMontoTitulos,
NEW.MontoEfectivoFinal,
SESSION_USER(),
NOW(),
'INSERT REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_formapagoupdate` AFTER UPDATE ON `fqs_formapago` FOR EACH ROW BEGIN
INSERT INTO au_formapago
(
`i_id_aceptacion`,
	`PorcentajeEfectivoAsignado`,
	`MontoEfectivoAsignado`,
	`PorcentajeTitulosAsignado`,
	`MontoTitulosAsignado`,
	`CantidadAccionesPago`,
	`MontoTitulosFinal`,
	`SaldoMontoTitulos` ,
	`MontoEfectivoFinal`,
   `au_usuario_bd`,
   `au_fecha_modificacion` ,
   `au_tipo_accion`
)           
VALUES 
(NEW.i_id_aceptacion,
NEW.PorcentajeEfectivoAsignado,
NEW.MontoEfectivoAsignado,
NEW.PorcentajeTitulosAsignado,
NEW.MontoTitulosAsignado,
NEW.CantidadAccionesPago,
NEW.MontoTitulosFinal,
NEW.SaldoMontoTitulos,
NEW.MontoEfectivoFinal,
SESSION_USER(),
NOW(),
'UPDATE REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_formapagodelete` BEFORE DELETE ON `fqs_formapago` FOR EACH ROW BEGIN
INSERT INTO au_formapago
(
`i_id_aceptacion`,
	`PorcentajeEfectivoAsignado`,
	`MontoEfectivoAsignado`,
	`PorcentajeTitulosAsignado`,
	`MontoTitulosAsignado`,
	`CantidadAccionesPago`,
	`MontoTitulosFinal`,
	`SaldoMontoTitulos` ,
	`MontoEfectivoFinal`,
   `au_usuario_bd`,
   `au_fecha_modificacion` ,
   `au_tipo_accion`
)           
VALUES 
(OLD.i_id_aceptacion,
OLD.PorcentajeEfectivoAsignado,
OLD.MontoEfectivoAsignado,
OLD.PorcentajeTitulosAsignado,
OLD.MontoTitulosAsignado,
OLD.CantidadAccionesPago,
OLD.MontoTitulosFinal,
OLD.SaldoMontoTitulos,
OLD.MontoEfectivoFinal,
SESSION_USER(),
NOW(),
'DELETE REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fqs_logusuariosadmin`
--

DROP TABLE IF EXISTS `fqs_logusuariosadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_logusuariosadmin` (
  `c_usuario` varchar(30) NOT NULL DEFAULT '',
  `dt_horaingreso` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `c_paginaingreso` varchar(30) NOT NULL DEFAULT '',
  `c_ipingresa` varchar(15) DEFAULT NULL,
  `i_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`i_id`)
) ENGINE=MyISAM AUTO_INCREMENT=131 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_logusuariosadmin`
--

LOCK TABLES `fqs_logusuariosadmin` WRITE;
/*!40000 ALTER TABLE `fqs_logusuariosadmin` DISABLE KEYS */;
INSERT INTO `fqs_logusuariosadmin` VALUES ('cvargas','2021-05-07 17:13:32','Reporte Consolidado','190.242.39.136',1),('cvargas','2021-05-07 17:13:41','Generar Adjudicación','190.242.39.136',2),('cvargas','2021-05-07 17:13:45','Descargar Resultados','190.242.39.136',3),('cvargas','2021-05-07 17:13:48','Descargar Resultados','190.242.39.136',4),('cvargas','2021-05-07 17:13:58','Parametrización','190.242.39.136',5),('cvargas','2021-05-07 17:14:08','Reporte Consolidado','190.242.39.136',6),('cvargas','2021-05-07 17:24:48','Descargar Resultados','190.242.39.136',7),('cvargas','2021-05-07 17:25:47','Parametrización','190.242.39.136',8),('cvargas','2021-05-10 08:05:12','Parametrización','190.242.39.136',9),('lmuneton','2021-05-10 08:08:17','Parametrización','190.242.39.136',10),('cvargas','2021-05-10 08:08:23','Generar Boletín','190.242.39.136',11),('lmuneton','2021-05-10 08:14:52','Descargar Resultados','190.242.39.136',12),('lmuneton','2021-05-10 08:14:57','Reporte Consolidado','190.242.39.136',13),('cvargas','2021-05-10 08:16:20','Parametrización','190.242.39.136',14),('cvargas','2021-05-10 08:22:34','Reporte Consolidado','190.242.39.136',15),('cvargas','2021-05-10 08:23:22','Descargar Resultados','190.242.39.136',16),('cvargas','2021-05-10 08:24:04','Parametrización','190.242.39.136',17),('cvargas','2021-05-10 13:35:56','Generar Boletín','190.242.39.136',18),('cvargas','2021-05-10 13:36:39','Reporte Consolidado','190.242.39.136',19),('cvargas','2021-05-10 13:36:41','Reporte Consolidado','190.242.39.136',20),('esouza','2021-05-10 17:43:55','Gestion de Usuarios','190.242.39.139',21),('esouza','2021-05-10 17:50:03','Mantenedor SCB','190.242.39.139',22),('mcastaneda','2021-05-11 08:27:26','Gestion de Usuarios','190.143.111.130',23),('kpanader','2021-05-11 11:50:18','Gestion de Usuarios','190.242.36.50',24),('cvargas','2021-05-11 13:21:24','Reporte Consolidado','190.242.39.136',25),('cvargas','2021-05-11 13:24:11','Auditoria','190.242.39.136',26),('cvargas','2021-05-11 13:24:39','Generar Boletín','190.242.39.136',27),('esouza','2021-05-11 16:59:10','Gestion de Usuarios','190.242.39.139',28),('esouza','2021-05-11 17:11:52','Mantenedor SCB','190.242.39.139',29),('hitrespa','2021-05-12 09:13:49','Carga Masiva de Aceptaciones','201.221.124.8',30),('hitrespa','2021-05-12 09:14:06','Carga Masiva de Aceptaciones','201.221.124.8',31),('hitrespa','2021-05-12 09:14:45','Reporte Consolidado','201.221.124.8',32),('cvargas','2021-05-12 13:17:52','Reporte Consolidado','190.242.39.136',33),('cvargas','2021-05-12 13:18:46','Generar Boletín','190.242.39.136',34),('hitrespa','2021-05-13 10:55:44','Carga Masiva de Aceptaciones','201.221.124.8',35),('hitrespa','2021-05-13 10:56:01','Reporte Consolidado','201.221.124.8',36),('kpanader','2021-05-13 12:22:41','Gestion de Usuarios','190.242.36.50',37),('arrivera','2021-05-13 12:27:15','Ingreso de Aceptaciones','190.131.244.230',38),('cvargas','2021-05-13 13:09:37','Reporte Consolidado','190.26.11.237',39),('cvargas','2021-05-13 13:11:04','Generar Boletín','190.26.11.237',40),('hitrespa','2021-05-14 09:09:21','Carga Masiva de Aceptaciones','201.221.124.8',41),('hitrespa','2021-05-14 09:09:44','Reporte Consolidado','201.221.124.8',42),('sfranco','2021-05-14 10:29:21','Reporte Consolidado','190.143.111.130',43),('sfranco','2021-05-14 10:29:29','Modificación de Aceptaciones','190.143.111.130',44),('sfranco','2021-05-14 10:29:47','Ingreso de Aceptaciones','190.143.111.130',45),('cvargas','2021-05-14 13:18:11','Reporte Consolidado','190.242.39.136',46),('cvargas','2021-05-14 13:26:12','Generar Boletín','190.242.39.136',47),('cvargas','2021-05-14 13:33:25','Reporte Consolidado','190.242.39.138',48),('esouza','2021-05-14 16:21:00','Gestion de Usuarios','190.242.39.139',49),('esouza','2021-05-14 16:25:38','Gestion de Usuarios','190.242.39.139',50),('esouza','2021-05-14 16:25:41','Mantenedor SCB','190.242.39.139',51),('lmuneton','2021-05-18 11:51:47','Reporte Consolidado','190.242.39.136',52),('lmuneton','2021-05-18 13:01:57','Reporte Consolidado','190.242.39.136',53),('lmuneton','2021-05-18 13:04:21','Generar Boletín','190.242.39.136',54),('cayala','2021-05-19 11:42:41','Carga Masiva de Aceptaciones','190.143.111.130',55),('cayala','2021-05-19 11:43:47','Reporte Consolidado','190.143.111.130',56),('cayala','2021-05-19 11:43:54','Reporte Consolidado','190.143.111.130',57),('cayala','2021-05-19 11:44:02','Carga Masiva de Aceptaciones','190.143.111.130',58),('cayala','2021-05-19 11:47:44','Carga Masiva de Aceptaciones','190.143.111.130',59),('cayala','2021-05-19 11:48:47','Reporte Consolidado','190.143.111.130',60),('lmuneton','2021-05-19 13:52:17','Reporte Consolidado','190.242.39.136',61),('lmuneton','2021-05-19 13:53:05','Generar Boletín','190.242.39.136',62),('lmuneton','2021-05-19 13:53:31','Reporte Consolidado','190.242.39.136',63),('cblanco','2021-05-20 08:21:15','Gestion de Usuarios','190.131.197.10',64),('cblanco','2021-05-20 08:27:15','Gestion de Usuarios','190.131.197.10',65),('cblanco','2021-05-20 09:08:17','Reporte Consolidado','190.131.197.10',66),('cblanco','2021-05-20 09:08:27','Gestion de Usuarios','190.131.197.10',67),('cayala','2021-05-20 11:39:03','Carga Masiva de Aceptaciones','190.143.111.130',68),('cayala','2021-05-20 11:41:38','Reporte Consolidado','190.143.111.130',69),('lmuneton','2021-05-20 13:20:45','Reporte Consolidado','190.242.39.136',70),('lmuneton','2021-05-20 13:22:13','Generar Boletín','190.242.39.136',71),('esouza','2021-05-21 10:11:06','Gestion de Usuarios','190.242.39.139',72),('esouza','2021-05-21 11:09:48','Mantenedor SCB','190.242.39.138',73),('asepulveda','2021-05-21 11:12:59','Gestion de Usuarios','190.131.201.70',74),('esouza','2021-05-21 11:13:35','Gestion de Usuarios','190.242.39.138',75),('asepulveda','2021-05-21 11:19:07','Reporte Consolidado','190.131.201.70',76),('dgomez','2021-05-21 11:24:39','Ingreso de Aceptaciones','190.131.201.70',77),('asepulveda','2021-05-21 11:25:49','Gestion de Usuarios','190.131.201.70',78),('dgomez','2021-05-21 11:29:24','Ingreso de Aceptaciones','190.131.201.70',79),('dgomez','2021-05-21 11:30:25','Ingreso de Aceptaciones','190.131.201.70',80),('esouza','2021-05-21 11:37:39','Gestion de Usuarios','190.242.39.139',81),('asepulveda','2021-05-21 11:42:02','Gestion de Usuarios','190.131.201.70',82),('asepulveda','2021-05-21 11:42:04','Reporte Consolidado','190.131.201.70',83),('asepulveda','2021-05-21 11:42:49','Gestion de Usuarios','190.131.201.70',84),('dgomez','2021-05-21 11:47:37','Ingreso de Aceptaciones','190.131.201.70',85),('dgomez','2021-05-21 11:51:14','Ingreso de Aceptaciones','190.131.201.70',86),('esouza','2021-05-21 11:52:10','Gestion de Usuarios','190.242.39.139',87),('lgallego','2021-05-21 11:52:55','Ingreso de Aceptaciones','190.131.201.70',88),('dgomez','2021-05-21 12:00:58','Reporte Consolidado','190.131.201.70',89),('dgomez','2021-05-21 12:03:30','Ingreso de Aceptaciones','190.131.201.70',90),('dgomez','2021-05-21 12:04:42','Ingreso de Aceptaciones','190.131.201.70',91),('evelasquez','2021-05-21 12:12:15','Gestion de Usuarios','201.221.124.121',92),('evelasquez','2021-05-21 12:14:24','Gestion de Usuarios','201.221.124.121',93),('hitrespa','2021-05-21 12:18:05','Ingreso de Aceptaciones','201.221.124.121',94),('asepulveda','2021-05-21 12:18:35','Reporte Consolidado','190.131.201.70',95),('evelasquez','2021-05-21 12:23:07','Gestion de Usuarios','201.221.124.121',96),('evelasquez','2021-05-21 12:23:08','Gestion de Usuarios','201.221.124.121',97),('evelasquez','2021-05-21 12:23:08','Gestion de Usuarios','201.221.124.121',98),('evelasquez','2021-05-21 12:23:27','Gestion de Usuarios','201.221.124.121',99),('hitrespa','2021-05-21 12:30:28','Reporte Consolidado','201.221.124.121',100),('asepulveda','2021-05-21 12:52:00','Reporte Consolidado','190.131.201.70',101),('lmuneton','2021-05-21 13:17:08','Reporte Consolidado','190.242.39.136',102),('lmuneton','2021-05-21 13:18:08','Generar Boletín','190.242.39.136',103),('lmuneton','2021-05-21 13:22:28','Generar Boletín','190.242.39.136',104),('evelasquez','2021-05-24 09:11:06','Gestion de Usuarios','201.221.124.8',105),('evelasquez','2021-05-24 09:11:27','Gestion de Usuarios','201.221.124.8',106),('evelasquez','2021-05-24 09:23:31','Gestion de Usuarios','201.221.124.8',107),('evelasquez','2021-05-24 09:23:34','Gestion de Usuarios','201.221.124.8',108),('evelasquez','2021-05-24 09:23:53','Gestion de Usuarios','201.221.124.8',109),('hitrespa','2021-05-24 09:38:05','Carga Masiva de Aceptaciones','201.221.124.8',110),('hitrespa','2021-05-24 10:11:07','Reporte Consolidado','201.221.124.8',111),('asalgado','2021-05-24 12:28:52','Gestion de Usuarios','190.242.39.136',112),('asepulveda','2021-05-24 13:02:01','Reporte Consolidado','190.131.201.70',113),('cvargas','2021-05-24 13:13:23','Reporte Consolidado','190.242.39.136',114),('cvargas','2021-05-24 13:21:06','Reporte Consolidado','190.242.39.136',115),('cvargas','2021-05-24 13:36:54','Generar Boletín','190.242.39.138',116),('lmuneton','2021-05-24 13:45:15','Generar Boletín','190.242.39.136',117),('cvargas','2021-05-25 10:30:29','Reporte Consolidado','190.242.39.136',118),('cvargas','2021-05-27 10:41:52','Generar Adjudicación','190.242.39.136',119),('cvargas','2021-05-27 10:51:27','Descargar Resultados','190.242.39.136',120),('cvargas','2021-05-27 13:14:32','Descargar Resultados','190.242.39.136',121),('cvargas','2021-05-27 13:15:56','Generar Boletín','190.242.39.136',122),('cvargas','2021-07-19 16:50:35','Parametrización','190.242.39.136',123),('cvargas','2021-07-22 16:37:21','Parametrización','190.242.39.136',124),('asalgado','2021-11-24 15:46:19','Gestion de Usuarios','190.242.39.136',125),('asalgado','2021-12-01 12:46:10','Gestion de Usuarios','190.242.39.136',126),('asalgado','2021-12-03 14:53:46','Gestion de Usuarios','190.242.39.136',127),('lmuneton','2021-12-03 15:00:32','Parametrización','190.242.39.136',128),('lmuneton','2021-12-03 15:01:38','Parametrización','190.242.39.136',129),('lmunetonp','2021-12-03 15:04:43','Gestion de Usuarios','190.242.39.136',130);
/*!40000 ALTER TABLE `fqs_logusuariosadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_opcionmodulo`
--

DROP TABLE IF EXISTS `fqs_opcionmodulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_opcionmodulo` (
  `i_opcionmodulo` int(11) NOT NULL DEFAULT '0',
  `i_modulosistema` int(11) NOT NULL,
  `i_codigopagina` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(35) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  `i_estado` int(11) NOT NULL DEFAULT '0',
  `i_orden` int(11) NOT NULL DEFAULT '0',
  `i_opciondepende` int(11) DEFAULT NULL,
  PRIMARY KEY (`i_opcionmodulo`),
  KEY `FK_pagina` (`i_codigopagina`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_opcionmodulo`
--

LOCK TABLES `fqs_opcionmodulo` WRITE;
/*!40000 ALTER TABLE `fqs_opcionmodulo` DISABLE KEYS */;
INSERT INTO `fqs_opcionmodulo` VALUES (7,0,5,'Modificación de Aceptaciones','--',1,2,6),(2,0,1,'Ingreso de Aceptaciones','--',1,1,6),(17,0,15,'Rechazo de Aceptaciones','--',1,3,6),(5,0,3,'Gestion de Usuarios','--',1,5,NULL),(6,0,0,'Gestión de Aceptaciones','--',1,1,NULL),(8,0,6,'Rechazos de Aceptaciones','--',1,3,6),(9,0,7,'Parametrización','--',1,3,NULL),(10,0,0,'Reportes','--',1,2,NULL),(11,0,9,'Reporte Diario','--',1,1,10),(12,0,10,'Reporte Consolidado','--',1,2,10),(13,0,11,'Reporte de Adjudicación','--',1,3,10),(14,0,0,'Adjudicación','--',1,4,NULL),(15,0,13,'Generar Adjudicación','--',1,1,14),(16,0,14,'Generar Interfaz','--',1,2,14),(20,0,17,'Descargar Resultados','--',1,2,14),(18,0,16,'Carga Masiva de Aceptaciones','--',1,4,6),(21,0,18,'Cambio de Contraseña','--',1,6,NULL),(22,0,19,'Mantenedor SCB','--',1,5,NULL),(23,0,20,'Diccionario de Contraseñas','--',1,5,NULL),(24,0,21,'Generar Boletín','--',1,2,10),(25,0,22,'Auditoria','--',1,4,NULL),(26,0,23,'Mantenedor MILA','--',1,5,NULL);
/*!40000 ALTER TABLE `fqs_opcionmodulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_pagina`
--

DROP TABLE IF EXISTS `fqs_pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_pagina` (
  `i_codigopagina` int(11) NOT NULL DEFAULT '0',
  `c_nombre` varchar(100) DEFAULT NULL,
  `c_descripcion` varchar(100) DEFAULT NULL,
  `c_subtitulo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`i_codigopagina`),
  KEY `idx_fqs_pagina1` (`c_nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_pagina`
--

LOCK TABLES `fqs_pagina` WRITE;
/*!40000 ALTER TABLE `fqs_pagina` DISABLE KEYS */;
INSERT INTO `fqs_pagina` VALUES (0,'com.framework.common.ui.BienvenidaContent','INICIO',NULL),(1,'com.framework.common.ui.contents.CrearAceptaciones','INGRESO DE ACEPTACIONES',NULL),(3,'com.framework.common.ui.content.user.AdminUsuariosContent','GESTION DE USUARIOS',NULL),(5,'com.framework.common.ui.contents.ModificarAceptaciones','MODIFICACIÓN DE ACEPTACIONES',NULL),(6,'com.framework.common.ui.contents.RechazoAceptaciones','RECHAZO DE ACEPTACIONES',NULL),(7,'com.framework.common.ui.contents.CrearParametros','PARAMETRIZACION',NULL),(15,'com.framework.common.ui.contents.RechazoAceptaciones','RECHAZO DE ACEPTACIONES',NULL),(9,'com.framework.common.ui.contents.ReporteDiario','REPORTE DIARIO',NULL),(10,'com.framework.common.ui.contents.ReporteConsolidado','REPORTE CONSOLIDADO',NULL),(11,'com.framework.common.ui.contents.ReporteAdjudicacion','REPORTE DE ADJUDICACIÓN',NULL),(13,'com.framework.common.ui.contents.GenerarAdjudicacion','GENERAR ADJUDICACIÓN',NULL),(14,'com.framework.common.ui.contents.GenerarInterfaz','GENERAR INTERFAZ ',NULL),(17,'com.framework.common.ui.contents.DescargarAdjudicacion','DESCARGAR RESULTADOS DE ADJUDICACIÓN',NULL),(16,'com.framework.common.ui.contents.CargaMasivaAceptaciones','CARGA MASIVA DE ACEPTACIONES',NULL),(18,'com.framework.common.ui.contents.CambioContrasenaPrincipal','CAMBIO DE CONTRASEÑA',NULL),(19,'com.framework.common.ui.contents.MantenedorScb','MANTENERDOR SCB',NULL),(20,'com.framework.common.ui.content.user.DiccionarioContrasenas','DICCIONARIO CONTRASEÑAS',NULL),(21,'com.framework.common.ui.contents.GenerarBoletin','GENERAR BOLETÃN',NULL),(22,'com.framework.common.ui.content.user.LogAuditoria','AUDITORIA',NULL),(23,'com.framework.common.ui.contents.MantenedorMila','MANTENERDOR MILA',NULL);
/*!40000 ALTER TABLE `fqs_pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_parametro`
--

DROP TABLE IF EXISTS `fqs_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_parametro` (
  `i_parametro` int(10) NOT NULL DEFAULT '0',
  `i_tipodato` tinyint(4) NOT NULL DEFAULT '0',
  `c_valor` varchar(255) NOT NULL DEFAULT '',
  `c_descripcion` varchar(100) DEFAULT NULL,
  `c_nombre` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`i_parametro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_parametro`
--

LOCK TABLES `fqs_parametro` WRITE;
/*!40000 ALTER TABLE `fqs_parametro` DISABLE KEYS */;
INSERT INTO `fqs_parametro` VALUES (15000,1,'2','Número de intentos fallidos','autenticacionIntentosFallidosBloqueo'),(15001,30,'30','Tiempo máximo de inactividad','autenticacionTiempoDeslogueoInactividad'),(15006,1,'0','Restricción en el uso de claves anteriores a','passwordHistorialRestriccion'),(15008,1,'0','Tiempo Minimo cambio contrase?as','passwordTiempoMinimoCambio'),(15015,0,'es_CO','Locale Global de la Aplicación','locale'),(20000,1,'true','Se valida IP unica o no','IpValida'),(20001,1,'true','Mostrar Captcha','Captcha'),(20005,1,'/apps/OPA/IDR','Ruta Generacion Archivo IDR','rutaIDR'),(20004,1,'/apps/OPA/CargaMasiva','Ruta Cargue Masivo de Aceptaciones','rutaCargueMasivo'),(20007,1,'/apps/OPA/ArchivoAdjudicacion','Ruta cargue Adjudicacion','rutaCargueAdjudicacion'),(20006,1,'40000','Registros Maximos Cargue Masivo','cantMaxCargueMasivo'),(20008,1,'20','n?mero de d?as de vencimiento contrase?a','vencimientoContrase?a'),(20011,1,'/apps/OPA/Boletin','Ruta Boletin','rutaBoletin'),(20012,1,'6Ldz31cUAAAAAGp7q3wQwKLqtC1FI9dSNhsr_GAD ','LLave de configuracion de captcha','captcha_key_public'),(20013,1,'6Ldz31cUAAAAAH3ue3pq6rNuclHr6GYzPo_52SsQ ','Llave privada de configuracion de captcha','captcha_key_private'),(20009,0,'/apps/OPA/I20','Ruta cargue I20','rutaI20');
/*!40000 ALTER TABLE `fqs_parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_perfil`
--

DROP TABLE IF EXISTS `fqs_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_perfil` (
  `i_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `c_nombre` char(21) NOT NULL DEFAULT '',
  `dt_horainisesion` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `dt_horafinsesion` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `c_descripcion` char(100) DEFAULT NULL,
  PRIMARY KEY (`i_perfil`),
  UNIQUE KEY `UK_Nombre` (`c_nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=5690 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_perfil`
--

LOCK TABLES `fqs_perfil` WRITE;
/*!40000 ALTER TABLE `fqs_perfil` DISABLE KEYS */;
INSERT INTO `fqs_perfil` VALUES (1,'Administrador SCB','2002-10-31 00:00:00','2020-12-31 23:59:59','Administrador SCB'),(2,'Administrador BVC','2014-07-15 00:00:00','2020-12-31 23:59:59','Administrador BVC'),(3,'Riesgos','2015-09-08 00:00:00','2020-12-31 23:59:59','Riesgos'),(4,'Operador SCB','2015-09-08 00:00:00','2020-12-31 23:59:59','Operador SCB'),(5,'Administrador General','2015-09-08 00:00:00','2020-12-31 23:59:59','Administrador General');
/*!40000 ALTER TABLE `fqs_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_permiso`
--

DROP TABLE IF EXISTS `fqs_permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=MyISAM AUTO_INCREMENT=3189 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_permiso`
--

LOCK TABLES `fqs_permiso` WRITE;
/*!40000 ALTER TABLE `fqs_permiso` DISABLE KEYS */;
INSERT INTO `fqs_permiso` VALUES (3158,4,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(50,4,2,'2003-12-31 00:00:00','2016-12-31 00:00:00','Ingreso Aceptaciones'),(49,4,6,'2003-12-31 00:00:00','2016-12-31 00:00:00','Gestion de Aceptaciones'),(14,5,6,'2003-12-31 00:00:00','2016-12-31 00:00:00','Gestion de Aceptaciones'),(53,5,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(3157,4,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(52,5,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(12,3,5,'2003-12-31 00:00:00','2016-12-31 00:00:00','Administrar Usuarios'),(39,4,7,'2003-12-31 00:00:00','2016-12-31 00:00:00','Modificacion Aceptaciones'),(15,5,2,'2003-12-31 00:00:00','2016-12-31 00:00:00','Ingreso Aceptaciones'),(3159,1,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(3160,1,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(18,5,9,'2003-12-31 00:00:00','2016-12-31 00:00:00','Parametrización'),(26,5,5,'2003-12-31 00:00:00','2016-12-31 00:00:00','Gestión de Usuarios'),(31,2,9,'2003-12-31 00:00:00','2016-12-31 00:00:00','Parametrización'),(3164,2,6,'1000-01-01 00:00:00','2016-12-31 00:00:00','Gestion de Aceptaciones'),(3163,2,17,'2016-12-31 00:00:00','2016-12-31 00:00:00','Rechazo de Aceptaciones'),(3162,2,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(51,5,17,'2003-12-31 00:00:00','2022-12-31 00:00:00','Rechazo de Aceptaciones'),(3161,2,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(16,5,7,'2003-12-31 00:00:00','2016-12-31 00:00:00','Modificacion Aceptaciones'),(48,1,5,'2016-12-31 00:00:00','2016-12-31 00:00:00','Gestión de Usuarios'),(56,2,20,'2016-12-31 00:00:00','2016-12-31 00:00:00','Descargar resultados'),(3165,2,14,'2016-12-31 00:00:00','2016-12-31 00:00:00','Adjudicación'),(3166,2,15,'2016-12-31 00:00:00','2016-12-31 00:00:00','Generar Adjudicación'),(3167,4,18,'2016-12-31 00:00:00','2016-12-31 00:00:00','Carga Masiva de Aceptaciones'),(57,1,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(58,2,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(59,3,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(60,4,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(61,5,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(63,3,22,'2016-12-31 00:00:00','2016-12-31 00:00:00','Mantenedor SCB'),(64,5,22,'2016-12-31 00:00:00','2016-12-31 00:00:00','Mantenedor SCB'),(3168,3,23,'2016-01-01 00:00:00','2016-12-31 00:00:00','Diccionario de contraseñas'),(3180,5,18,'2016-12-31 00:00:00','2016-12-31 00:00:00','Carga Masiva de Aceptaciones'),(3178,5,15,'2016-12-31 00:00:00','2016-12-31 00:00:00','Generar Adjudicación'),(3177,5,20,'2016-12-31 00:00:00','2016-12-31 00:00:00','Descargar Resultados'),(3176,5,14,'2016-12-31 00:00:00','2016-12-31 00:00:00','Adjudicación'),(3175,5,23,'2016-01-01 00:00:00','2016-12-31 00:00:00','Diccionario de contraseñas'),(3181,2,24,'2016-12-01 00:00:00','2018-12-31 00:00:00','Generar BoletÃ­n'),(3182,5,24,'2016-12-01 00:00:00','2018-12-31 00:00:00','Generar BoletÃ­n'),(3183,2,25,'2016-01-01 00:00:00','2020-01-01 00:00:00','Auditoria'),(3184,5,25,'2016-01-01 00:00:00','2020-01-01 00:00:00','Auditoria'),(3188,5,26,'2019-01-01 00:00:00','2020-01-01 00:00:00','Mantenedor MILA'),(3187,3,26,'2019-01-01 00:00:00','2020-01-01 00:00:00','Mantenedor MILA');
/*!40000 ALTER TABLE `fqs_permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_usuario`
--

DROP TABLE IF EXISTS `fqs_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_usuario` (
  `i_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `c_tipo_identificacion` varchar(3) DEFAULT NULL,
  `c_identificacion` varchar(20) DEFAULT NULL,
  `c_nombre` varchar(50) DEFAULT '',
  `c_apellidos` varchar(50) DEFAULT '',
  `c_direccion` varchar(20) DEFAULT '',
  `c_telefono` varchar(20) DEFAULT '',
  `c_email` varchar(100) DEFAULT NULL,
  `c_login` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `c_contrasena` varchar(100) DEFAULT '',
  `dt_ultimologin` datetime DEFAULT NULL,
  `i_empresa` int(11) unsigned DEFAULT '0',
  `i_usuario_padre` int(11) DEFAULT '0',
  `c_estado` varchar(10) NOT NULL DEFAULT 'Activo',
  `f_ult_cambio_clave` date DEFAULT NULL,
  `i_numsesiones` int(11) DEFAULT '0',
  `i_usuariosupvisor` int(11) DEFAULT NULL,
  `c_proceso` char(2) DEFAULT 'N',
  `f_ult_cambio_reintento` datetime DEFAULT NULL,
  `sesion` tinyint(1) DEFAULT '0',
  `i_cod_agente` int(11) DEFAULT NULL,
  `ty_cambiocontrasena` tinyint(1) DEFAULT '0',
  `c_usuario_sistema_ultima_mod` varchar(45) DEFAULT NULL,
  `c_usuario_bd_datos` varchar(45) DEFAULT NULL,
  `ts_fecha_hora_ultimo_modificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `c_tipo_modificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`i_usuario`),
  UNIQUE KEY `UK_Login` (`c_login`),
  KEY `IDX_Estado` (`c_estado`)
) ENGINE=MyISAM AUTO_INCREMENT=591 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_usuario`
--

LOCK TABLES `fqs_usuario` WRITE;
/*!40000 ALTER TABLE `fqs_usuario` DISABLE KEYS */;
INSERT INTO `fqs_usuario` VALUES (1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','VlxNhd+KGu2BcKxDCJ+rlg==','2019-05-16 11:32:18',0,0,'I','2019-05-13',0,NULL,'N','2019-01-22 12:03:59',0,90,1,NULL,'root@localhost',NULL,NULL),(5,'CC','52516979','Diana','Nieto',NULL,NULL,'dnieto@bvc.com.co','dnieto','rmlOKuh6J04nPD1Em7F4NA==','2020-06-19 14:07:55',0,0,'A','2020-06-01',0,NULL,'N','2020-06-12 14:09:00',0,90,1,'asalgado','root@localhost','2017-01-23 19:49:14','Modificación Usuario - Modificación'),(6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','x3eehUXEblHCkl358mGwvg==','2019-11-19 13:00:22',0,0,'I','2019-11-15',0,NULL,'N','2019-11-15 13:07:15',0,90,1,'asalgado','root@localhost','2017-01-23 19:50:26','Modificación Usuario - Modificación'),(7,'CC','51642094','Myriam','Robayo Carrillo',NULL,NULL,'MRobayo@bvc.com.co','mrobayo','4I9y0o1ZwJHv+HeYS1h3wA==','2019-11-19 13:04:07',0,0,'I','2020-09-28',0,NULL,'N','2017-06-20 14:31:50',0,90,0,'esouza','root@localhost','2017-01-23 21:36:37','Modificación Usuario - Modificación'),(589,'CC','1072658172','Luis Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','lmunetonp','5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:02:28',0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,1,'asalgado','root@localhost','2021-12-03 19:57:18','Ingreso Usuario - Inserción'),(220,'CC','1013636943','Diana Marcela','Castano Quevedo',NULL,NULL,'dcastano@bvc.com.co','dcastano','qB25qiMe8Tv/YRRnjzDeyA==','2020-12-10 16:18:14',0,0,'A','2020-12-07',0,NULL,'N','2020-11-13 14:50:08',0,90,1,'asalgado','root@localhost','2018-08-29 21:54:32','Modificación Usuario - Modificación'),(89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:01:33',0,0,'A','2021-12-03',0,NULL,'N','2021-12-03 11:58:39',0,90,1,'asalgado','root@localhost','2017-06-09 22:07:52','Modificación Usuario - Modificación'),(259,'CC','1069739254','Ana Maria','Salgado Galindo',NULL,NULL,'asalgado@bvc.com.co','asalgado','AaZd0Wzx5lbhvii+8+NjiQ==','2021-12-03 14:53:41',0,0,'A','2021-11-24',0,NULL,'N','2020-06-16 17:30:26',0,90,1,'52167727','root@localhost','2019-01-23 01:34:50','Modificación Usuario - Modificación'),(304,'CC','1016039534','Edwinson Javier','Triana',NULL,NULL,'javier.triana@bvc.com.co','etriana','TxR8RMzp5hisvOr1BIu0fA==','2020-06-17 10:09:49',0,0,'A','2020-06-17',0,NULL,'N',NULL,0,90,1,'admin','root@localhost','2019-05-16 21:36:14','Ingreso Usuario - InserciÃƒÂ³n'),(10,'CC','52167727','Sol Veronica','Lozano',NULL,NULL,'sol.lozano@bvc.com.co','52167727','45zRahLzRxxgF8sSy93ERQ==','2020-12-21 10:13:36',0,0,'A','2020-12-21',0,NULL,'N','2020-12-18 17:37:09',0,90,1,NULL,'root@localhost',NULL,NULL),(448,'CC','1016023999','Camilo','Vargas Cruz',NULL,NULL,'cvargas@bvc.com.co','cvargas','HuXngpc9FLtkP8E9Zv/Jwg==','2021-07-22 16:37:09',0,0,'A','2021-07-19',1,NULL,'N','2021-11-03 15:18:06',0,90,1,'asalgado','root@localhost','2020-05-11 15:52:34','Modificación Usuario - Modificación'),(590,'CC','10726581','Felipe','Muneton',NULL,NULL,'lmuneton@bvc.com.co','operador1','oiJ6V7ui+YmEjZaVtgWC6w==','2021-12-03 15:06:52',0,0,'A','2021-12-03',0,NULL,'N',NULL,0,37,1,'lmunetonp','root@localhost','2021-12-03 20:06:24','Ingreso Usuario - Inserción'),(588,'CC','94536699','ANDRES','AVILA',NULL,NULL,'aavila@corredores.com','aavila','i9H2c/BOphj60kh68Gj73g==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:38:14','Ingreso Usuario - Inserción'),(587,'CC','80871119','CAMILO ','FORERO',NULL,NULL,'CFORERO@CORREDORES.COM','cforero','dNXH4/dzOo/tHGPcxxtHHQ==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:36:19','Ingreso Usuario - Inserción'),(586,'CC','1026563621','PAULA ','LUQUE',NULL,NULL,'pluque@corredores.com','pluque','WQrlqQW5zQXFa8ewFawPdw==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:34:40','Ingreso Usuario - Inserción'),(585,'CC','71707238','LUIS','GALLEGO',NULL,NULL,'lgallego@corredores.com','lgallego','6rvIrVZlrv6QyYD3MWdlyQ==','2021-05-21 11:49:25',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:41:42',0,2,1,'asepulveda','root@localhost','2021-05-21 16:32:48','Modificación Usuario - Modificación'),(584,'CC','1019046700','JHON JAIRO','PERILLA',NULL,NULL,'jjperilla@corredores.com','jperilla','9j16riYoBKvARA8kPALf1Q==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:30:45','Ingreso Usuario - Inserción'),(530,'CC','1020821622','Lina Maria','Rodriguez Hernandez',NULL,NULL,'lina.rodriguez@bvc.com.co','lrodriguez','ReOW011NDgnT502XPvIU0g==','2020-11-13 09:51:45',0,0,'A','2021-12-01',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2020-11-10 17:31:39','Modificación Usuario - Modificación'),(583,'CC','1072661774','ANDRES FELIPE','MONTENEGRO',NULL,NULL,'amontenegro@corredores.com','amontenegro','V+A8x456PrGD2aR2GWLjNA==',NULL,0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,0,'asepulveda','root@localhost','2021-05-21 16:28:32','Ingreso Usuario - Inserción'),(582,'CC','1015440542','DIANA','GOMEZ',NULL,NULL,'dgomez@corredores.com','dgomez','ZXOjPtnbHyaiBDbuu6clcw==','2021-05-21 11:22:16',0,0,'A','2021-05-21',0,NULL,'N',NULL,0,2,1,'asepulveda','root@localhost','2021-05-21 16:17:31','Ingreso Usuario - Inserción'),(581,'CC','1052394959','Arturo Antonio','Sepulveda Barrera',NULL,NULL,'asepulvedab@corredores.com','asepulveda','YXKnDwCdx7OKCCstppwnpA==','2021-05-24 12:29:59',0,0,'A','2021-05-21',0,NULL,'N','2021-05-24 12:11:10',0,2,1,'asalgado','root@localhost','2021-05-21 16:01:59','Modificación Usuario - Modificación'),(580,'CC','51993518','Carolina ','Bustamante Antolines',NULL,NULL,'carolina.bustamante@accivalores.com','cbustamante','h5jyHspbGLL9SPdnXhSk4g==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:47:01','Ingreso Usuario - Inserción'),(579,'CC','1010223672','Maria Alexandra ','Cely Martin',NULL,NULL,'alexandra.celym@accivalores.com','acely','oSugEAXZUpTsOWMnAdFztw==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:39:01','Ingreso Usuario - Inserción'),(578,'CC','79403609','Mauricio Alberto ','Celis Rivera ',NULL,NULL,'mauricio.celis@accivalores.com','mcelis','mwrh6szDPAuDFV6OU509Gg==',NULL,0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,0,'cblanco','root@localhost','2021-05-20 14:34:18','Ingreso Usuario - Inserción'),(577,'CC','79399904','Jose Ricardo ','Sanchez Martinez ',NULL,NULL,'jose.sanchez@accivalores.com','jsanchez','a7xxPpAqmTsPbdf+JE06UQ==','2021-05-20 09:04:07',0,0,'A','2021-05-20',0,NULL,'N','2021-05-20 09:03:03',0,7,1,'cblanco','root@localhost','2021-05-20 13:45:23','Ingreso Usuario - Inserción'),(576,'CC','1030630336','Brandon Camilo','Blanco Romero',NULL,NULL,'camilo.blanco@accivalores.com','cblanco','337vhg6opYH9t2ZEjnB6dA==','2021-05-21 09:11:29',0,0,'A','2021-05-20',0,NULL,'N',NULL,0,7,1,'esouza','root@localhost','2021-05-14 21:24:26','Ingreso Usuario - Inserción'),(574,'CC','80501110','David','Abril Garcia',NULL,NULL,'dabril@alianza.com.co','dabril','ujNW8yVDsYi8pN4BrR48bg==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,18,0,'kpanader','root@localhost','2021-05-11 16:54:13','Ingreso Usuario - Inserción'),(575,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','ecastaneda','qlbW0YjaIOHzBNC7NJkNjQ==',NULL,0,0,'A','2021-05-11',0,NULL,'N',NULL,0,50,0,'esouza','root@localhost','2021-05-11 22:10:29','Ingreso Usuario - Inserción'),(573,'CC','16728398','Arturo','Rivera Nieto',NULL,NULL,'arrivera@alianza.com.co','arrivera','XlsRb7RE16X2iMjiVp1ltg==','2021-05-13 12:26:00',0,0,'A','2021-05-13',0,NULL,'N','2021-05-13 12:09:11',0,18,1,'kpanader','root@localhost','2021-05-11 16:51:14','Modificación Usuario - Modificación'),(572,'CC','52498069','Sandra Liliana','Franco Mancipe',NULL,NULL,'sfranco@credicorpcapital.com','sfranco','J9VoQSEQUBnT6xyMHWxbXg==','2021-05-14 10:27:24',0,0,'A','2021-05-14',0,NULL,'N',NULL,0,29,1,'mcastaneda','root@localhost','2021-05-11 13:33:21','Ingreso Usuario - Inserción'),(569,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','kpanader','ujNW8yVDsYi8pN4BrR48bg==','2021-05-13 12:22:37',0,0,'A','2021-05-11',0,NULL,'N',NULL,0,18,1,'esouza','root@localhost','2021-05-07 20:32:07','Ingreso Usuario - Inserción'),(570,'CC','52449048','Mildre Stella','Castaneda Moreno',NULL,NULL,'mcastaneda@credicorpcapital.com','mcastaneda','v26ni6slTI4k3i3Hwo8TGQ==','2021-05-11 08:25:05',0,0,'A','2021-05-11',0,NULL,'N',NULL,0,29,1,'esouza','root@localhost','2021-05-10 22:48:30','Ingreso Usuario - Inserción'),(567,'CC','43749812','maria sorelly','uribe ramirez',NULL,NULL,'suribe@globalcdb.com','suribera','M0uIdPstua+zugK/KydUXQ==','2021-05-07 14:12:11',0,0,'A','2021-05-07',0,NULL,'N','2021-05-07 14:11:48',0,51,1,'suribe','root@localhost','2021-05-07 19:10:50','Ingreso Usuario - Inserción'),(565,'CC','71772039','JUAN DAVID','GONZALEZ OCHOA',NULL,NULL,'DAVIGONZ@BANCOLOMBIA.COM.CO','davigonz','CL6eD/D3c1+FO7oA4zgMFA==','2021-05-07 13:56:31',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,10,1,'evelasquez','root@localhost','2021-05-07 14:06:11','Modificación Usuario - Modificación'),(564,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-07 09:39:35',0,0,'A','2021-05-24',0,NULL,'N',NULL,0,10,0,'evelasquez','root@localhost','2021-05-07 14:03:44','Modificación Usuario - Modificación'),(563,'CC','39548480','Nelcy Patricia','Olaya Ramirez',NULL,NULL,'patricia.olaya@itau.co','no80196','vlmQwWHQIGUkxoXl1nhXiQ==','2021-05-07 15:38:27',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,4,0,'jbaracaldo','root@localhost','2021-05-07 13:14:02','Ingreso Usuario - Inserción'),(571,'CC','79416489','Carlos Humberto','Ayala Guerrero',NULL,NULL,'cayala@credicorpcapital.com','cayala','TfotpZRL2bdatApm/xlzKA==','2021-05-20 11:38:54',0,0,'A','2021-05-11',0,NULL,'N','2021-05-11 11:34:22',0,29,1,'mcastaneda','root@localhost','2021-05-11 13:31:37','Ingreso Usuario - Inserción'),(559,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'Edvelasq@bancolombia.com.co','evelasquez','gXYYK5QxPvk6K1vhpetrNQ==','2021-05-24 09:10:29',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:16:30',0,10,1,'esouza','root@localhost','2021-05-06 00:10:15','Modificación Usuario - Modificación'),(560,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','hwKIlqo4euG5bgTEmRIf9Q==','2021-05-24 09:37:06',0,0,'A','2021-05-24',0,NULL,'N','2021-05-24 09:28:19',0,10,1,'evelasquez','root@localhost','2021-05-06 13:41:32','Modificación Usuario - Modificación'),(550,'CC','79266824','Luis  orlando','Suarez Arevalo',NULL,NULL,'orlando.suarez@bvc.com.co','lsuarez','u51vEnP3v/HeAH4y3SqBGg==',NULL,0,0,'A','2020-12-21',0,NULL,'N',NULL,0,90,0,'52167727','root@localhost','2020-12-21 15:12:17','Ingreso Usuario - Inserción'),(562,'CC','79296043','Jesus Elias','Baracaldo Rojas',NULL,NULL,'jesus.baracaldo@itau.co','jbaracaldo','ecCtCR1sIF76E1VT9iyuow==','2021-05-07 07:42:44',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,4,1,'asalgado','root@localhost','2021-05-06 22:20:42','Ingreso Usuario - Inserción'),(566,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','IEHlf4eET42NKGEUygkKZQ==','2021-05-21 12:29:16',0,0,'A','2021-05-21',0,NULL,'N','2021-05-21 11:49:28',0,10,1,'evelasquez','root@localhost','2021-05-07 14:07:46','Modificación Usuario - Modificación'),(558,'CC','43749812','Maria Sorelli','Uribe Ramirez',NULL,NULL,'suribe@globalcdb.com','suribe','20tuckmAjA2aEM5KM/BvLw==','2021-05-07 13:59:06',0,0,'A','2021-05-07',0,NULL,'N',NULL,0,51,1,'esouza','root@localhost','2021-05-05 17:37:55','Ingreso Usuario - Inserción'),(551,'CC','1075875673','Luis Alejandro','Rojas',NULL,NULL,'lrojas@bvc.com.co','lrojas','wQBYxgIc/du1mE28JXVC/A==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'esouza','root@localhost','2021-03-12 12:39:12','Modificación Usuario - Modificación'),(552,'CC','1031170390','Nicolas','Zamora',NULL,NULL,'nicolas.zamora@bvc.com.co','nzamora','f2iVzE9H2fWOKAbGsKUk8A==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'esouza','root@localhost','2021-03-12 13:15:14','Modificación Usuario - Modificación'),(553,'CC','1075650720','Lina Maria','Orozco',NULL,NULL,'lina.orozco@bvc.com.co','lorozco','k6MAkhe65W3Y4NhnfII61w==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'esouza','root@localhost','2021-03-12 13:46:26','Modificación Usuario - Modificación'),(554,'CC','1015453438','Maria Fernanda','Ramos',NULL,NULL,'mramos@bvc.com.co','mramos','XLzHbhgNdHisUoo3sHSVLQ==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2021-03-12 19:57:31','Ingreso Usuario - Inserción'),(555,'CC','1010221471','Viviana','Henao',NULL,NULL,'vhenao@bvc.com.co','vhenao','jWeWymDOyjiUj/siydJiPw==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2021-03-12 20:31:23','Ingreso Usuario - Inserción'),(556,'CC','1019128119','Adrian Esteban','Plazas',NULL,NULL,'adrian.plazas@bvc.com.co','aplazas','TFlqWgDHU9nEwt59P5mqoA==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2021-03-12 20:34:28','Ingreso Usuario - Inserción'),(557,'CC','1100961291','Alejandra','Gomez',NULL,NULL,'mayra.gomez@bvc.com.co','agomez','E/holDO8njuuPhsRcaZBUg==',NULL,0,0,'A','2021-03-12',0,NULL,'N',NULL,0,90,0,'asalgado','root@localhost','2021-03-12 20:39:39','Ingreso Usuario - Inserción');
/*!40000 ALTER TABLE `fqs_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_fqs_usuario` BEFORE INSERT ON `fqs_usuario` 
    FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_usuarioInsert` AFTER INSERT ON `fqs_usuario` 
    FOR EACH ROW BEGIN
INSERT INTO au_usuario
(`i_usuario`,
`c_tipo_identificacion`,
`c_identificacion`,
`c_nombre`,
`c_apellidos`,
`c_direccion`,
`c_telefono`,
`c_email`,
`c_login`,
`c_contrasena`,
`dt_ultimologin`,
`i_empresa`,
`i_usuario_padre`,
`c_estado`,
`f_ult_cambio_clave`,
`i_numsesiones`,
`i_usuariosupvisor`,
`c_proceso`,
`f_ult_cambio_reintento`,
`sesion`,
`i_cod_agente`,
`ty_cambiocontrasena`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultimo_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`) 	          
VALUES 
(NEW.i_usuario,
NEW.c_tipo_identificacion,
NEW.c_identificacion,
NEW.c_nombre,
NEW.c_apellidos,
NEW.c_direccion,
NEW.c_telefono,
NEW.c_email,
NEW.c_login,
NEW.c_contrasena,
NEW.dt_ultimologin,
NEW.i_empresa,
NEW.i_usuario_padre,
NEW.c_estado,
NEW.f_ult_cambio_clave,
NEW.i_numsesiones,
NEW.i_usuariosupvisor,
NEW.c_proceso,
NEW.f_ult_cambio_reintento,
NEW.sesion,
NEW.i_cod_agente,
NEW.ty_cambiocontrasena,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultimo_modificacion,
NEW.c_tipo_modificacion,
NOW(),
SESSION_USER(),
'INSERCION REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `log_trigger_user_upd_fqs_usuario` BEFORE UPDATE ON `fqs_usuario` 
    FOR EACH ROW SET NEW.c_usuario_bd_datos=CURRENT_USER() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `fqs_usuarioUpdate` AFTER UPDATE ON `fqs_usuario` 
    FOR EACH ROW BEGIN
INSERT INTO au_usuario
(`i_usuario`,
`c_tipo_identificacion`,
`c_identificacion`,
`c_nombre`,
`c_apellidos`,
`c_direccion`,
`c_telefono`,
`c_email`,
`c_login`,
`c_contrasena`,
`dt_ultimologin`,
`i_empresa`,
`i_usuario_padre`,
`c_estado`,
`f_ult_cambio_clave`,
`i_numsesiones`,
`i_usuariosupvisor`,
`c_proceso`,
`f_ult_cambio_reintento`,
`sesion`,
`i_cod_agente`,
`c_usuario_sistema_ultima_mod`,
`c_usuario_bd_datos`,
`ts_fecha_hora_ultimo_modificacion`,
`c_tipo_modificacion`,
`au_fecha_modificacion`,
`au_usuario_bd`,
`au_tipo_accion`) 	          
VALUES 
(NEW.i_usuario,
NEW.c_tipo_identificacion,
NEW.c_identificacion,
NEW.c_nombre,
NEW.c_apellidos,
NEW.c_direccion,
NEW.c_telefono,
NEW.c_email,
NEW.c_login,
NEW.c_contrasena,
NEW.dt_ultimologin,
NEW.i_empresa,
NEW.i_usuario_padre,
NEW.c_estado,
NEW.f_ult_cambio_clave,
NEW.i_numsesiones,
NEW.i_usuariosupvisor,
NEW.c_proceso,
NEW.f_ult_cambio_reintento,
NEW.sesion,
NEW.i_cod_agente,
NEW.c_usuario_sistema_ultima_mod,
NEW.c_usuario_bd_datos,
NEW.ts_fecha_hora_ultimo_modificacion,
NEW.c_tipo_modificacion,
NOW(),
SESSION_USER(),
'ACTUALIZACION REGISTRO');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fqs_usuario_has_fqs_perfil`
--

DROP TABLE IF EXISTS `fqs_usuario_has_fqs_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_usuario_has_fqs_perfil` (
  `fqs_usuario_i_usuario` int(11) NOT NULL,
  `fqs_perfil_i_perfil` int(11) NOT NULL,
  `c_proceso` char(1) DEFAULT 'N',
  PRIMARY KEY (`fqs_usuario_i_usuario`,`fqs_perfil_i_perfil`),
  KEY `FK_usr_rol_perfil` (`fqs_perfil_i_perfil`),
  KEY `FK_usr_rol_usuario` (`fqs_usuario_i_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_usuario_has_fqs_perfil`
--

LOCK TABLES `fqs_usuario_has_fqs_perfil` WRITE;
/*!40000 ALTER TABLE `fqs_usuario_has_fqs_perfil` DISABLE KEYS */;
INSERT INTO `fqs_usuario_has_fqs_perfil` VALUES (1,5,'N'),(321,4,'N'),(353,4,'N'),(352,1,'N'),(5,2,'N'),(6,2,'N'),(7,2,'N'),(220,2,'N'),(320,4,'N'),(351,1,'N'),(348,4,'N'),(347,4,'N'),(89,2,'N'),(120,3,'N'),(346,4,'N'),(345,4,'N'),(344,4,'N'),(319,4,'N'),(343,4,'N'),(350,1,'N'),(341,1,'N'),(349,4,'N'),(339,4,'N'),(338,4,'N'),(337,4,'N'),(336,4,'N'),(318,1,'N'),(335,4,'N'),(317,1,'N'),(316,1,'N'),(315,1,'N'),(314,1,'N'),(334,4,'N'),(333,4,'N'),(259,3,'N'),(313,1,'N'),(312,1,'N'),(332,4,'N'),(331,4,'N'),(311,1,'N'),(310,1,'N'),(330,4,'N'),(329,4,'N'),(328,4,'N'),(327,4,'N'),(326,4,'N'),(325,4,'N'),(304,3,'N'),(324,4,'N'),(10,5,'N'),(309,1,'N'),(323,4,'N'),(322,4,'N'),(354,4,'N'),(355,4,'N'),(356,4,'N'),(357,4,'N'),(358,4,'N'),(359,4,'N'),(360,4,'N'),(361,4,'N'),(362,4,'N'),(363,4,'N'),(364,4,'N'),(365,1,'N'),(366,4,'N'),(367,4,'N'),(368,4,'N'),(369,4,'N'),(370,1,'N'),(371,4,'N'),(372,1,'N'),(373,1,'N'),(374,1,'N'),(375,1,'N'),(376,1,'N'),(377,1,'N'),(378,1,'N'),(379,1,'N'),(380,1,'N'),(381,4,'N'),(382,4,'N'),(383,4,'N'),(384,4,'N'),(385,4,'N'),(386,4,'N'),(387,1,'N'),(388,4,'N'),(389,4,'N'),(390,1,'N'),(391,4,'N'),(392,4,'N'),(393,4,'N'),(394,4,'N'),(395,4,'N'),(396,4,'N'),(397,4,'N'),(398,4,'N'),(399,4,'N'),(400,4,'N'),(401,1,'N'),(402,1,'N'),(403,4,'N'),(404,4,'N'),(405,4,'N'),(406,4,'N'),(407,4,'N'),(408,4,'N'),(409,4,'N'),(410,1,'N'),(411,4,'N'),(412,4,'N'),(413,4,'N'),(414,4,'N'),(415,4,'N'),(416,4,'N'),(417,4,'N'),(418,4,'N'),(419,4,'N'),(420,4,'N'),(421,4,'N'),(422,4,'N'),(423,4,'N'),(424,4,'N'),(425,4,'N'),(426,4,'N'),(427,4,'N'),(428,4,'N'),(429,4,'N'),(430,4,'N'),(431,4,'N'),(432,1,'N'),(433,1,'N'),(434,4,'N'),(435,4,'N'),(436,4,'N'),(437,4,'N'),(438,4,'N'),(439,4,'N'),(440,4,'N'),(441,4,'N'),(442,4,'N'),(443,4,'N'),(444,4,'N'),(445,4,'N'),(446,4,'N'),(447,1,'N'),(448,2,'N'),(449,1,'N'),(466,4,'N'),(451,1,'N'),(452,4,'N'),(465,4,'N'),(454,1,'N'),(455,1,'N'),(456,1,'N'),(457,1,'N'),(458,4,'N'),(459,4,'N'),(460,4,'N'),(461,4,'N'),(462,4,'N'),(463,4,'N'),(464,4,'N'),(467,4,'N'),(468,4,'N'),(469,1,'N'),(470,4,'N'),(471,4,'N'),(472,1,'N'),(473,4,'N'),(474,4,'N'),(475,1,'N'),(476,4,'N'),(477,4,'N'),(478,1,'N'),(479,1,'N'),(480,4,'N'),(481,4,'N'),(482,4,'N'),(483,4,'N'),(484,1,'N'),(485,1,'N'),(486,1,'N'),(487,1,'N'),(488,4,'N'),(522,1,'N'),(490,1,'N'),(491,1,'N'),(492,1,'N'),(493,1,'N'),(494,4,'N'),(495,4,'N'),(496,4,'N'),(521,1,'N'),(498,4,'N'),(499,4,'N'),(500,4,'N'),(501,4,'N'),(502,4,'N'),(503,4,'N'),(504,4,'N'),(505,4,'N'),(506,4,'N'),(507,4,'N'),(508,4,'N'),(509,4,'N'),(510,4,'N'),(511,4,'N'),(512,4,'N'),(513,4,'N'),(514,4,'N'),(515,4,'N'),(516,4,'N'),(517,4,'N'),(518,4,'N'),(519,4,'N'),(520,4,'N'),(523,4,'N'),(524,1,'N'),(525,4,'N'),(526,4,'N'),(527,4,'N'),(528,1,'N'),(529,1,'N'),(530,2,'N'),(531,4,'N'),(532,4,'N'),(533,1,'N'),(534,4,'N'),(535,4,'N'),(536,4,'N'),(537,4,'N'),(538,4,'N'),(539,4,'N'),(540,4,'N'),(541,4,'N'),(542,4,'N'),(543,4,'N'),(544,4,'N'),(545,4,'N'),(546,4,'N'),(547,4,'N'),(548,4,'N'),(549,4,'N'),(550,3,'N'),(551,2,'N'),(552,2,'N'),(553,2,'N'),(554,2,'N'),(555,2,'N'),(556,2,'N'),(557,2,'N'),(558,1,'N'),(559,1,'N'),(560,4,'N'),(571,4,'N'),(562,1,'N'),(563,4,'N'),(564,4,'N'),(565,4,'N'),(566,4,'N'),(567,4,'N'),(570,1,'N'),(569,1,'N'),(572,4,'N'),(573,4,'N'),(574,4,'N'),(575,1,'N'),(576,1,'N'),(577,4,'N'),(578,4,'N'),(579,4,'N'),(580,4,'N'),(581,1,'N'),(582,4,'N'),(583,4,'N'),(584,4,'N'),(585,4,'N'),(586,4,'N'),(587,4,'N'),(588,4,'N'),(589,1,'N'),(590,4,'N');
/*!40000 ALTER TABLE `fqs_usuario_has_fqs_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fqs_usuario_password_historial`
--

DROP TABLE IF EXISTS `fqs_usuario_password_historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fqs_usuario_password_historial` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `i_usuario` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  `i_usuario_modificador` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario` (`i_usuario`),
  KEY `FK_modificador` (`i_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_usuario_password_historial`
--

LOCK TABLES `fqs_usuario_password_historial` WRITE;
/*!40000 ALTER TABLE `fqs_usuario_password_historial` DISABLE KEYS */;
INSERT INTO `fqs_usuario_password_historial` VALUES (1,570,'awHZux86ktw+71Dg3IJo7g==','2021-05-10 17:48:30','120'),(2,570,'v26ni6slTI4k3i3Hwo8TGQ==','2021-05-11 08:26:35','570'),(3,571,'QIuST2aZPsuWJxL2KawfdQ==','2021-05-11 08:31:37','570'),(4,572,'QIuST2aZPsuWJxL2KawfdQ==','2021-05-11 08:33:21','570'),(5,571,'TfotpZRL2bdatApm/xlzKA==','2021-05-11 11:35:27','571'),(6,569,'ujNW8yVDsYi8pN4BrR48bg==','2021-05-11 11:49:59','569'),(7,573,'ujNW8yVDsYi8pN4BrR48bg==','2021-05-11 11:51:14','569'),(8,574,'ujNW8yVDsYi8pN4BrR48bg==','2021-05-11 11:54:13','569'),(9,575,'qlbW0YjaIOHzBNC7NJkNjQ==','2021-05-11 17:10:29','120'),(10,573,'XlsRb7RE16X2iMjiVp1ltg==','2021-05-13 12:27:06','573'),(11,572,'J9VoQSEQUBnT6xyMHWxbXg==','2021-05-14 10:27:59','572'),(12,576,'dmryWGQPAc530sqxyLDjkA==','2021-05-14 16:24:26','120'),(13,576,'337vhg6opYH9t2ZEjnB6dA==','2021-05-20 08:21:08','576'),(14,577,'8J8wbRQcgeyVAy5WMgTFwg==','2021-05-20 08:45:23','576'),(15,577,'a7xxPpAqmTsPbdf+JE06UQ==','2021-05-20 09:05:00','577'),(16,578,'mwrh6szDPAuDFV6OU509Gg==','2021-05-20 09:34:18','576'),(17,579,'oSugEAXZUpTsOWMnAdFztw==','2021-05-20 09:39:01','576'),(18,580,'h5jyHspbGLL9SPdnXhSk4g==','2021-05-20 09:47:01','576'),(19,559,'xWTS7d5opJUHCB+f32QRbg==','2021-05-21 10:13:24','120'),(20,559,'AtYRL9mDSSqa9Phkkn19kw==','2021-05-21 10:25:08','120'),(21,581,'/3t/LRO3pN8F5Eh1mC7nCg==','2021-05-21 11:01:59','120'),(22,581,'YXKnDwCdx7OKCCstppwnpA==','2021-05-21 11:12:55','581'),(23,582,'/XX8QKphJAfe2/0UXrajWg==','2021-05-21 11:17:31','581'),(24,582,'ZXOjPtnbHyaiBDbuu6clcw==','2021-05-21 11:24:26','582'),(25,583,'V+A8x456PrGD2aR2GWLjNA==','2021-05-21 11:28:32','581'),(26,584,'9j16riYoBKvARA8kPALf1Q==','2021-05-21 11:30:45','581'),(27,585,'F4Xh1mO3NS23Ai014obSZQ==','2021-05-21 11:32:48','581'),(28,586,'WQrlqQW5zQXFa8ewFawPdw==','2021-05-21 11:34:40','581'),(29,587,'dNXH4/dzOo/tHGPcxxtHHQ==','2021-05-21 11:36:19','581'),(30,559,'SopWXS9I9ma8xEaS+EVs/g==','2021-05-21 11:38:12','120'),(31,588,'i9H2c/BOphj60kh68Gj73g==','2021-05-21 11:38:14','581'),(32,585,'zMbMHYC7ThgwNvMuYItQSg==','2021-05-21 11:43:35','581'),(33,585,'6rvIrVZlrv6QyYD3MWdlyQ==','2021-05-21 11:50:58','585'),(34,559,'6b2IxaVZlScyXhsMYDIYcg==','2021-05-21 12:05:55','120'),(35,559,'gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:12:12','559'),(36,566,'gXYYK5QxPvk6K1vhpetrNQ==','2021-05-21 12:15:54','559'),(37,566,'UItP8ea8fjRGS9vVUNfOTw==','2021-05-21 12:24:11','559'),(38,566,'IEHlf4eET42NKGEUygkKZQ==','2021-05-21 12:29:46','566'),(39,560,'WT9dyp9Q7r3iG6vMiAtAYA==','2021-05-24 09:13:56','559'),(40,560,'gXYYK5QxPvk6K1vhpetrNQ==','2021-05-24 09:24:16','559'),(41,560,'hwKIlqo4euG5bgTEmRIf9Q==','2021-05-24 09:37:39','560'),(42,564,'gXYYK5QxPvk6K1vhpetrNQ==','2021-05-24 09:38:54','559'),(43,259,'Pfk1tp2FQ46A+k8vXv4sjQ==','2021-05-24 12:28:46','259'),(44,448,'jvPoQG9oL10VSF2TtFV3TA==','2021-05-25 10:11:32','448'),(45,448,'HuXngpc9FLtkP8E9Zv/Jwg==','2021-07-19 16:50:13','448'),(46,259,'AaZd0Wzx5lbhvii+8+NjiQ==','2021-11-24 15:45:53','259'),(47,530,'ReOW011NDgnT502XPvIU0g==','2021-12-01 12:46:45','259'),(48,89,'rS0wOJOppedj8aMEpeLMUA==','2021-12-03 14:54:12','259'),(49,589,'rS0wOJOppedj8aMEpeLMUA==','2021-12-03 14:57:18','259'),(50,89,'5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:00:07','89'),(51,589,'5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:02:44','589'),(52,590,'5hnxUix9rC2/tmBLWXWAqw==','2021-12-03 15:06:24','589'),(53,590,'oiJ6V7ui+YmEjZaVtgWC6w==','2021-12-03 15:07:04','590');
/*!40000 ALTER TABLE `fqs_usuario_password_historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq`
--

DROP TABLE IF EXISTS `seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq` (
  `name` varchar(20) NOT NULL,
  `val` int(10) unsigned NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq`
--

LOCK TABLES `seq` WRITE;
/*!40000 ALTER TABLE `seq` DISABLE KEYS */;
INSERT INTO `seq` VALUES ('dm_formulario',12),('dm_ofertante',341688),('dm_adjudicado',0),('fqs_CrearAceptacion',0);
/*!40000 ALTER TABLE `seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'opa'
--
/*!50003 DROP FUNCTION IF EXISTS `seq` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `seq`(seq_name CHAR (20)) RETURNS int(11)
BEGIN
      UPDATE seq SET val=LAST_INSERT_ID(val+1) WHERE NAME=seq_name;
      RETURN LAST_INSERT_ID();
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `seqInterfaz20` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `seqInterfaz20`() RETURNS int(9)
BEGIN
DECLARE result INT;
	DECLARE fecha DATE;
	
	SELECT fechaGeneracion INTO fecha FROM au_Interfaz20;
	
	IF (fecha < DATE(NOW())) THEN
		UPDATE au_Interfaz20 SET consecutivo = 0, fechaGeneracion = NOW();
	END IF;
	
	UPDATE au_Interfaz20 SET consecutivo = consecutivo + 1;
	SELECT LPAD(consecutivo, 3, 0) INTO result FROM au_Interfaz20;
	RETURN result;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `seqInterfazBackOffice` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `seqInterfazBackOffice`() RETURNS int(11)
BEGIN
	DECLARE result INT;
	DECLARE fecha DATE;
	
	SELECT fechaGeneracion INTO fecha FROM au_InterfazBackOffice;
	
	IF (fecha < DATE(NOW())) THEN
		UPDATE au_InterfazBackOffice SET consecutivoIDR = 0, fechaGeneracion = NOW();
	END IF;
	
	UPDATE au_InterfazBackOffice SET consecutivoIDR = consecutivoIDR + 1;
	SELECT LPAD(consecutivoIDR, 3, 0) INTO result FROM au_InterfazBackOffice;
	RETURN result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `seqReporteAdjudicacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `seqReporteAdjudicacion`() RETURNS int(11)
BEGIN
	DECLARE result INT;
	DECLARE fecha DATE;
	
	SELECT fechaGeneracion INTO fecha FROM au_reporteadjudicacion;
	
	IF (fecha < DATE(NOW())) THEN
		UPDATE au_reporteadjudicacion SET consecutivo = 0, fechaGeneracion = NOW();
	END IF;
	
	UPDATE au_reporteadjudicacion SET consecutivo = consecutivo + 1;
	SELECT LPAD(consecutivo, 3, 0) INTO result FROM au_reporteadjudicacion;
	RETURN result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-03 15:33:27
