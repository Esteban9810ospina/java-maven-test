-- MySQL dump 10.13  Distrib 5.5.49, for Linux (x86_64)
--
-- Host: localhost    Database: opa
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

DECLARE
  fecha CONSTANT VARCHAR2(20) := '2016-02-19 18:14:42';

LOCK TABLES `Diccionarios_DiasLetras` WRITE;
/*!40000 ALTER TABLE `Diccionarios_DiasLetras` DISABLE KEYS */;
INSERT INTO `Diccionarios_DiasLetras` VALUES (1,'Primero',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(2,'Dos',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(3,'Tres',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(4,'Cuatro',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(5,'Cinco',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(6,'Seis',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(7,'Siete',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(8,'Ocho',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(9,'Nueve',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(10,'Diez',1,'2016-02-19 18:14:41',1,'2016-02-19 18:14:41'),(11,'Once',1,fecha,1,fecha),(12,'Doce',1,fecha,1,fecha),(13,'Trece',1,fecha,1,fecha),(14,'Catorce',1,fecha,1,fecha),(15,'Quince',1,fecha,1,fecha),(16,'Dieciseis',1,fecha,1,fecha),(17,'Diecisiete',1,fecha,1,fecha),(18,'Dieciocho',1,fecha,1,fecha),(19,'Diecinueve',1,fecha,1,fecha),(20,'Veinte',1,fecha,1,fecha),(21,'Veintiuno',1,fecha,1,fecha),(22,'Veintidos',1,fecha,1,fecha),(23,'Veintitres',1,fecha,1,fecha),(24,'Veinticuatro',1,fecha,1,fecha),(25,'Veinticinco',1,fecha,1,fecha),(26,'Veintiseis',1,fecha,1,fecha),(27,'Veintisiste',1,fecha,1,fecha),(28,'Veintiocho',1,fecha,1,fecha),(29,'Veintinueve',1,fecha,1,fecha),(30,'Treinta',1,fecha,1,fecha),(31,'Treinta y uno',1,fecha,1,fecha);
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
  `NombreRazonSocial` varchar(50) NOT NULL,
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
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_CrearAceptacion`
--

LOCK TABLES `au_CrearAceptacion` WRITE;
/*!40000 ALTER TABLE `au_CrearAceptacion` DISABLE KEYS */;
INSERT INTO `au_CrearAceptacion` VALUES (1,1,'ORDINARIAS','6561','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','VILLEGAS Y VILLEGAS IVEGAS LTDA',3581,'1',4,'860501968',4,'',598022,111,'2018-01-17 11:43:52',111,'2018-01-17 11:43:52','Ingresado',0.200,NULL,'mleon','root@localhost','2018-01-17 16:43:52','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 16:43:52','INSERCION REGISTRO'),(2,2,'ORDINARIAS','8616','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','CREDICORP CAPITAL COLOMBIA',283,'1',4,'860068182',5,'',136,111,'2018-01-17 11:53:34',111,'2018-01-17 11:53:34','Ingresado',0.000,NULL,'mleon','root@localhost','2018-01-17 16:53:34','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 16:53:34','INSERCION REGISTRO'),(3,3,'ORDINARIAS','10655','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','VARGAS CASTILLA VANESA',2028,'1',1,'1020767348',NULL,'',495270,111,'2018-01-17 12:51:16',111,'2018-01-17 12:51:16','Ingresado',0.000,NULL,'mleon','root@localhost','2018-01-17 17:51:16','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 17:51:16','INSERCION REGISTRO'),(4,4,'ORDINARIAS','3406','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','VALENTINA  GOMEZ MINOTAS',165,'0',1,'1152189801',NULL,'',619598,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',7.500,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 15:40:14','INSERCION REGISTRO'),(5,5,'ORDINARIAS','3413','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','MELISSA  GOMEZ MINOTAS',37,'0',1,'1036670986',NULL,'',619603,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 15:40:14','INSERCION REGISTRO'),(6,6,'ORDINARIAS','3420','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','ANA MARIA MINOTAS MARTINEZ',37,'0',1,'43007152',NULL,'',322353,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 15:40:14','INSERCION REGISTRO'),(7,7,'ORDINARIAS','3665','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','LUIS ALBERTO HERNANDEZ MORENO',1,'0',1,'1032385931',NULL,'',823463,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 15:40:14','INSERCION REGISTRO'),(8,8,'ORDINARIAS','3874','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','PAULA ANDREA GOMEZ POSADA',185,'0',1,'43832451',NULL,'',599247,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',6.690,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 15:40:14','INSERCION REGISTRO'),(9,9,'ORDINARIAS','5037','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','VALORES BANCOLOMBIA SA COMISIONISTAS DE BOLSA',30500,'0',4,'800128735',8,'',131,102,'2018-01-22 09:57:24',102,'2018-01-22 09:57:24','Ingresado',0.000,NULL,'hitrespa','root@localhost','2018-01-22 14:57:24','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 14:57:24','INSERCION REGISTRO'),(10,10,'ORDINARIAS','5168','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','EDGAR ANDRES NARANJO HENAO',29,'0',1,'8013934',NULL,'',1105202,102,'2018-01-22 09:57:24',102,'2018-01-22 09:57:24','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-22 14:57:24','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 14:57:24','INSERCION REGISTRO'),(11,11,'ORDINARIAS','19965','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','ZAPATA ARIAS LUIS FERNANDO',178,'1',1,'8292642',NULL,'',61355,111,'2018-01-22 12:17:25',111,'2018-01-22 12:17:25','Ingresado',0.300,NULL,'mleon','root@localhost','2018-01-22 17:17:25','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 17:17:25','INSERCION REGISTRO'),(12,12,'ORDINARIAS','5665','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','ENGICO LTDA',6000,'0',4,'890924366',5,'',223869,102,'2018-01-23 11:13:48',102,'2018-01-23 11:13:48','Ingresado',0.300,NULL,'hitrespa','root@localhost','2018-01-23 16:13:48','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 16:13:48','INSERCION REGISTRO'),(13,13,'ORDINARIAS','252','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,4,'ITAU COMISIONISTA DE BOLSA COLOMBIA S.A','Felix Eduardo Buendia Anjel','OLGA MATILDE VILLEGAS JARAMILLO ',1190,'0',1,'52621962',NULL,'',1216571,107,'2018-01-30 09:36:18',107,'2018-01-30 09:36:18','Ingresado',1.600,NULL,'1004002','root@localhost','2018-01-30 14:36:18','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 14:36:18','INSERCION REGISTRO'),(14,14,'ORDINARIAS','29179','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','OSCAR VELASQUEZ Y CIA S EN C',370,'1',4,'860500220',1,'',539615,111,'2018-01-30 12:21:51',111,'2018-01-30 12:21:51','Ingresado',3.300,NULL,'mleon','root@localhost','2018-01-30 17:21:51','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 17:21:51','INSERCION REGISTRO'),(15,15,'ORDINARIAS','4463','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','CORDOBA MUÑOZ RAMON ANTONIO',371,'0',1,'8347488',NULL,'',561537,119,'2018-02-14 10:59:59',119,'2018-02-14 10:59:59','Ingresado',1.541,NULL,'1050002','root@localhost','2018-02-14 15:59:59','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:59:59','INSERCION REGISTRO'),(16,16,'ORDINARIAS','4465','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','VASCO ARANGO INES AMPARO DE LA MILAGROSA',4819,'0',1,'32341935',NULL,'',551470,119,'2018-02-14 11:03:02',119,'2018-02-14 11:03:02','Ingresado',0.300,NULL,'1050002','root@localhost','2018-02-14 16:03:02','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 16:03:02','INSERCION REGISTRO'),(17,17,'ORDINARIAS','4507','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','SANCHEZ VASCO BETTY ',743,'0',1,'1152190643',NULL,'',1434803,119,'2018-02-14 11:04:44',119,'2018-02-14 11:04:44','Ingresado',0.770,NULL,'1050002','root@localhost','2018-02-14 16:04:44','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 16:04:44','INSERCION REGISTRO'),(18,18,'ORDINARIAS','4535','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','VASCO  ANDRES MAURICIO',110,'0',1,'1036624445',NULL,'',1445238,119,'2018-02-14 11:07:48',119,'2018-02-14 11:07:48','Ingresado',5.200,NULL,'1050002','root@localhost','2018-02-14 16:07:48','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 16:07:48','INSERCION REGISTRO'),(19,19,'ORDINARIAS','4536','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','DUQUE FLOREZ HAROL ALBERTO',70,'0',1,'79404727',NULL,'',583700,119,'2018-02-14 11:10:09',119,'2018-02-14 11:10:09','Ingresado',8.200,NULL,'1050002','root@localhost','2018-02-14 16:10:09','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 16:10:09','INSERCION REGISTRO'),(20,20,'ORDINARIAS','47297','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','INGENIERIA DE VIAS SA',143002,'1',4,'800186228',2,'',557594,111,'2018-02-15 12:11:14',111,'2018-02-15 12:11:14','Ingresado',0.500,NULL,'mleon','root@localhost','2018-02-15 17:11:14','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 17:11:14','INSERCION REGISTRO'),(21,21,'ORDINARIAS','1521','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','José Ricardo Pérez Sandoval','MARTHA LUCIA GUTIERREZ DE AZCARATE',687,'1',1,'29281308',NULL,'',1556925,118,'2018-02-19 09:09:11',118,'2018-02-19 09:09:11','Ingresado',2.080,NULL,'arrivera','root@localhost','2018-02-19 14:09:11','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:09:11','INSERCION REGISTRO'),(22,22,'ORDINARIAS','1545','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','José Ricardo Pérez Sandoval','JULIANA AZCARATE GUTIERREZ',687,'1',1,'29111088',NULL,'',85407,118,'2018-02-19 09:11:05',118,'2018-02-19 09:11:05','Ingresado',2.080,NULL,'arrivera','root@localhost','2018-02-19 14:11:05','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:11:05','INSERCION REGISTRO'),(23,23,'ORDINARIAS','48189','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','CONSTRUCTUCCIONES ARYS LTDA',2046,'1',4,'830117896',7,'',1475350,111,'2018-02-19 09:47:20',111,'2018-02-19 09:47:20','Ingresado',1.000,NULL,'mleon','root@localhost','2018-02-19 14:47:20','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:47:20','INSERCION REGISTRO'),(24,24,'ORDINARIAS','18262','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','JOSE DAVID POSADA BOTERO',20000,'0',1,'71708034',NULL,'',17505,102,'2018-02-19 11:28:55',102,'2018-02-19 11:28:55','Ingresado',0.500,NULL,'hitrespa','root@localhost','2018-02-19 16:28:55','Ingreso Demanda - Archivo','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 16:28:55','INSERCION REGISTRO'),(25,25,'ORDINARIAS','5384','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','INVERSIONES Y VALORES SAS',137,'0',4,'900206752',0,'',1426278,119,'2018-02-19 12:49:55',119,'2018-02-19 12:49:55','Ingresado',0.000,NULL,'1050002','root@localhost','2018-02-19 17:49:55','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 17:49:55','INSERCION REGISTRO'),(26,25,'ORDINARIAS','5384','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','INVERSIONES Y VALORES SAS',137,'0',4,'900206752',0,'',1426278,119,'2018-02-19 12:49:55',119,'2018-02-19 12:51:01','Modificado',8.342,'','1050002','root@localhost','2018-02-19 17:49:55','Modificación Aceptación - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 17:51:01','ACTUALIZACION REGISTRO'),(27,26,'ORDINARIAS','51632','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','PQUIM LTDA',55,'1',4,'800162553',8,'',703727,111,'2018-02-20 10:40:01',111,'2018-02-20 10:40:01','Ingresado',1.000,NULL,'mleon','root@localhost','2018-02-20 15:40:01','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:40:01','INSERCION REGISTRO'),(28,4,'ORDINARIAS','3406','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','VALENTINA  GOMEZ MINOTAS',165,'0',1,'1152189801',NULL,'',619598,102,'2018-01-18 10:40:14',102,'2018-02-20 10:44:09','Modificado',7.503,'','hitrespa','root@localhost','2018-01-18 15:40:14','Modificación Aceptación - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:44:09','ACTUALIZACION REGISTRO'),(29,8,'ORDINARIAS','3874','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','PAULA ANDREA GOMEZ POSADA',185,'0',1,'43832451',NULL,'',599247,102,'2018-01-18 10:40:14',102,'2018-02-20 10:44:39','Modificado',6.692,'','hitrespa','root@localhost','2018-01-18 15:40:14','Modificación Aceptación - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:44:39','ACTUALIZACION REGISTRO'),(30,27,'ORDINARIAS','1591','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','José Ricardo Pérez Sandoval','MANUEL ANTONIO LOPEZ BOTERO',4000,'1',1,'7531944',NULL,'',4840,118,'2018-02-20 11:00:02',118,'2018-02-20 11:00:02','Ingresado',1.000,NULL,'arrivera','root@localhost','2018-02-20 16:00:02','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 16:00:02','INSERCION REGISTRO'),(31,28,'ORDINARIAS','5470','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','EMERGING MARKETS CORE EQUITY PORTFOLIO OF DFA INVE',5134,'0',4,'900540404',3,'',1796144,119,'2018-02-20 11:31:30',119,'2018-02-20 11:31:30','Ingresado',0.000,NULL,'1050002','root@localhost','2018-02-20 16:31:30','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 16:31:30','INSERCION REGISTRO'),(32,29,'ORDINARIAS','5469','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','THE EMERGING MARKETS SMALL CAP SERIES OF THE DFA',19092,'0',4,'900540407',5,'',1796146,119,'2018-02-20 11:34:39',119,'2018-02-20 11:34:39','Ingresado',NULL,NULL,'1050002','root@localhost','2018-02-20 16:34:39','Ingreso Demanda - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 16:34:39','INSERCION REGISTRO');
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
INSERT INTO `au_InterfazBackOffice` VALUES (1,'2018-02-21');
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_IpAutorizada`
--

LOCK TABLES `au_IpAutorizada` WRITE;
/*!40000 ALTER TABLE `au_IpAutorizada` DISABLE KEYS */;
INSERT INTO `au_IpAutorizada` VALUES (1,431,107,'200.030.110.139','1004001','root@localhost','2018-01-10 16:00:12','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:00:12','INSERCIÓN REGISTRO'),(2,432,107,'190.66.2.204','1004001','root@localhost','2018-01-10 16:00:12','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:00:12','INSERCIÓN REGISTRO'),(3,433,107,'172.23.22.111','1004001','root@localhost','2018-01-10 16:00:12','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:00:12','INSERCIÓN REGISTRO'),(4,431,107,'200.030.110.139','1004001','root@localhost','2018-01-10 16:00:12','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','BORRADO REGISTRO'),(5,432,107,'190.66.2.204','1004001','root@localhost','2018-01-10 16:00:12','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','BORRADO REGISTRO'),(6,433,107,'172.23.22.111','1004001','root@localhost','2018-01-10 16:00:12','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','BORRADO REGISTRO'),(7,434,107,'200.030.110.139','1004001','root@localhost','2018-01-10 16:01:04','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','INSERCIÓN REGISTRO'),(8,435,107,'190.66.2.204','1004001','root@localhost','2018-01-10 16:01:04','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','INSERCIÓN REGISTRO'),(9,436,107,'172.23.22.111','1004001','root@localhost','2018-01-10 16:01:04','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','INSERCIÓN REGISTRO'),(10,385,6,'192.168.88.5','ogomez','root@localhost','2018-01-03 20:05:34','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:59:37','BORRADO REGISTRO'),(11,386,6,'190.131.244.209','ogomez','root@localhost','2018-01-03 20:05:34','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:59:37','BORRADO REGISTRO'),(12,437,6,'192.168.88.5','ogomez','root@localhost','2018-01-11 22:59:37','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:59:37','INSERCIÓN REGISTRO'),(13,438,6,'190.131.244.209','ogomez','root@localhost','2018-01-11 22:59:37','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:59:37','INSERCIÓN REGISTRO'),(14,439,108,'190.131.201.70','ogomez','root@localhost','2018-01-11 23:23:34','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:23:34','INSERCIÓN REGISTRO'),(15,440,109,'190.143.111.130','ogomez','root@localhost','2018-01-11 23:24:49','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:24:49','INSERCIÓN REGISTRO'),(16,441,109,'201.245.161.224','ogomez','root@localhost','2018-01-11 23:24:49','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:24:49','INSERCIÓN REGISTRO'),(17,442,109,'200.119.83.128','ogomez','root@localhost','2018-01-11 23:24:49','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:24:49','INSERCIÓN REGISTRO'),(18,443,110,'190.143.111.130','1029001','root@localhost','2018-01-12 19:56:27','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 19:56:27','INSERCIÓN REGISTRO'),(19,444,110,'201.245.161.224','1029001','root@localhost','2018-01-12 19:56:27','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 19:56:27','INSERCIÓN REGISTRO'),(20,445,110,'200.119.83.128','1029001','root@localhost','2018-01-12 19:56:27','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 19:56:27','INSERCIÓN REGISTRO'),(21,446,111,'190.143.111.130','1029001','root@localhost','2018-01-12 20:05:04','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:05:04','INSERCIÓN REGISTRO'),(22,447,111,'201.245.161.224','1029001','root@localhost','2018-01-12 20:05:04','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:05:04','INSERCIÓN REGISTRO'),(23,448,111,'200.119.83.128','1029001','root@localhost','2018-01-12 20:05:04','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:05:04','INSERCIÓN REGISTRO'),(24,449,112,'190.143.111.130','1029001','root@localhost','2018-01-12 20:07:33','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:07:33','INSERCIÓN REGISTRO'),(25,450,112,'201.245.161.224','1029001','root@localhost','2018-01-12 20:07:33','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:07:33','INSERCIÓN REGISTRO'),(26,451,112,'200.119.83.128','1029001','root@localhost','2018-01-12 20:07:33','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:07:33','INSERCIÓN REGISTRO'),(27,416,98,'190.131.240.114','ogomez','root@localhost','2018-01-09 16:15:32','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 23:14:48','BORRADO REGISTRO'),(28,452,98,'190.131.240.114','ogomez','root@localhost','2018-01-17 23:14:48','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 23:14:48','INSERCIÓN REGISTRO'),(29,439,108,'190.131.201.70','ogomez','root@localhost','2018-01-11 23:23:34','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 03:57:24','BORRADO REGISTRO'),(30,453,108,'190.131.201.70','ogomez','root@localhost','2018-02-13 03:57:24','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 03:57:24','INSERCIÓN REGISTRO'),(31,453,108,'190.131.201.70','ogomez','root@localhost','2018-02-13 03:57:24','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:38:46','BORRADO REGISTRO'),(32,454,108,'190.131.201.70','ogomez','root@localhost','2018-02-13 17:38:46','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:38:46','INSERCIÓN REGISTRO'),(33,455,113,'190.131.201.70','1002001','root@localhost','2018-02-13 18:00:34','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:00:34','INSERCIÓN REGISTRO'),(34,456,114,'190.131.201.70','1002001','root@localhost','2018-02-13 18:04:32','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:04:32','INSERCIÓN REGISTRO'),(35,457,115,'190.242.36.50','ogomez','root@localhost','2018-02-13 19:51:06','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 19:51:06','INSERCIÓN REGISTRO'),(36,458,116,'190.242.36.50','1018001','root@localhost','2018-02-13 21:10:59','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:10:59','INSERCIÓN REGISTRO'),(37,459,117,'190.242.36.50','1018001','root@localhost','2018-02-13 21:11:57','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:11:57','INSERCIÓN REGISTRO'),(38,460,118,'190.131.244.30','1018001','root@localhost','2018-02-13 21:12:57','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:12:57','INSERCIÓN REGISTRO'),(39,461,119,'190.131.240.114','1050001','root@localhost','2018-02-14 15:35:41','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:35:41','INSERCIÓN REGISTRO'),(40,440,109,'190.143.111.130','ogomez','root@localhost','2018-01-11 23:24:49','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','BORRADO REGISTRO'),(41,441,109,'201.245.161.224','ogomez','root@localhost','2018-01-11 23:24:49','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','BORRADO REGISTRO'),(42,442,109,'200.119.83.128','ogomez','root@localhost','2018-01-11 23:24:49','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','BORRADO REGISTRO'),(43,462,109,'190.143.111.130','ogomez','root@localhost','2018-02-15 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','INSERCIÓN REGISTRO'),(44,463,109,'201.245.161.224','ogomez','root@localhost','2018-02-15 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','INSERCIÓN REGISTRO'),(45,464,109,'200.119.83.128','ogomez','root@localhost','2018-02-15 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','INSERCIÓN REGISTRO'),(46,462,109,'190.143.111.130','ogomez','root@localhost','2018-02-15 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','BORRADO REGISTRO'),(47,463,109,'201.245.161.224','ogomez','root@localhost','2018-02-15 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','BORRADO REGISTRO'),(48,464,109,'200.119.83.128','ogomez','root@localhost','2018-02-15 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','BORRADO REGISTRO'),(49,465,109,'190.143.111.130','ogomez','root@localhost','2018-02-15 16:27:00','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','INSERCIÓN REGISTRO'),(50,466,109,'201.245.161.224','ogomez','root@localhost','2018-02-15 16:27:00','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','INSERCIÓN REGISTRO'),(51,467,109,'200.119.83.128','ogomez','root@localhost','2018-02-15 16:27:00','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','INSERCIÓN REGISTRO'),(52,446,111,'190.143.111.130','1029001','root@localhost','2018-01-12 20:05:04','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','BORRADO REGISTRO'),(53,447,111,'201.245.161.224','1029001','root@localhost','2018-01-12 20:05:04','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','BORRADO REGISTRO'),(54,448,111,'200.119.83.128','1029001','root@localhost','2018-01-12 20:05:04','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','BORRADO REGISTRO'),(55,468,111,'190.143.111.130','1029001','root@localhost','2018-02-15 16:29:18','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','INSERCIÓN REGISTRO'),(56,469,111,'201.245.161.224','1029001','root@localhost','2018-02-15 16:29:18','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','INSERCIÓN REGISTRO'),(57,470,111,'200.119.83.128','1029001','root@localhost','2018-02-15 16:29:18','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','INSERCIÓN REGISTRO'),(58,460,118,'190.131.244.30','1018001','root@localhost','2018-02-13 21:12:57','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:25:47','BORRADO REGISTRO'),(59,471,118,'190.131.244.230','1018001','root@localhost','2018-02-16 16:25:47','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:25:47','INSERCIÓN REGISTRO'),(60,457,115,'190.242.36.50','ogomez','root@localhost','2018-02-13 19:51:06','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 17:41:44','BORRADO REGISTRO'),(61,472,115,'190.242.36.50','ogomez','root@localhost','2018-02-16 17:41:45','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 17:41:45','INSERCIÓN REGISTRO'),(62,468,111,'190.143.111.130','1029001','root@localhost','2018-02-15 16:29:18','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','BORRADO REGISTRO'),(63,469,111,'201.245.161.224','1029001','root@localhost','2018-02-15 16:29:18','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','BORRADO REGISTRO'),(64,470,111,'200.119.83.128','1029001','root@localhost','2018-02-15 16:29:18','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','BORRADO REGISTRO'),(65,473,111,'190.143.111.130','1029001','root@localhost','2018-02-19 14:25:11','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','INSERCIÓN REGISTRO'),(66,474,111,'201.245.161.224','1029001','root@localhost','2018-02-19 14:25:11','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','INSERCIÓN REGISTRO'),(67,475,111,'200.119.83.128','1029001','root@localhost','2018-02-19 14:25:11','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','INSERCIÓN REGISTRO'),(68,472,115,'190.242.36.50','ogomez','root@localhost','2018-02-16 17:41:45','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:31:20','BORRADO REGISTRO'),(69,476,115,'190.242.36.50','ogomez','root@localhost','2018-02-20 17:31:20','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:31:20','INSERCIÓN REGISTRO'),(70,458,116,'190.242.36.50','1018001','root@localhost','2018-02-13 21:10:59','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:43:24','BORRADO REGISTRO'),(71,477,116,'190.242.36.50','1018001','root@localhost','2018-02-20 17:43:24','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:43:24','INSERCIÓN REGISTRO'),(72,459,117,'190.242.36.50','1018001','root@localhost','2018-02-13 21:11:57','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:43:36','BORRADO REGISTRO'),(73,478,117,'190.242.36.50','1018001','root@localhost','2018-02-20 17:43:36','Ingreso IP - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:43:36','INSERCIÓN REGISTRO'),(74,479,120,'192.168.85.204','admin','root@localhost','2018-02-21 21:00:56','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:00:56','INSERCIÓN REGISTRO'),(75,480,120,'192.168.232.170','admin','root@localhost','2018-02-21 21:00:56','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:00:56','INSERCIÓN REGISTRO'),(76,481,120,'190.131.244.209','admin','root@localhost','2018-02-21 21:00:56','Ingreso IP - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:00:56','INSERCIÓN REGISTRO');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='-- =============================================\nAuthor: Leonard Willian Prens Herrera\nCreate date: 15-02-2016\nDescription: Tabla Diccionario Parametrizacion de los usuarios.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_Parametrizacion`
--

LOCK TABLES `au_Parametrizacion` WRITE;
/*!40000 ALTER TABLE `au_Parametrizacion` DISABLE KEYS */;
INSERT INTO `au_Parametrizacion` VALUES (1,1,6,'2018-01-10','09:00:00','2018-02-20','12:59:59',1,575361,'GRUPO ARGOS S.A.',10500.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',2,3,'ODINSA','ORDINARIAS',10,6,'2018-01-10 08:59:15',6,'2018-01-10 08:59:15',1,1,4,'890900266','3','',18336,50,'lnavarro','root@localhost','2018-01-10 13:59:15','Ingreso Parametro - Inserción','09:00:00','11:59:59','ODINSA S.A.','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de ODINSA S.A.., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo quinientas setenta y cinco mil trescientas sesenta y un (575.361)  acciones ordinarias.','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 13:59:15','INSERCI? REGISTRO'),(2,1,6,'2018-01-10','09:00:00','2018-02-20','12:59:59',1,575361,'GRUPO ARGOS S.A.',10500.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',2,3,'ODINSA','ORDINARIAS',10,6,'2018-01-10 08:59:15',6,'2018-01-10 09:00:53',1,1,4,'890900266','3','',18336,50,'lnavarro','root@localhost','2018-01-10 14:00:53','Actualizar Parametro - Actualización','09:00:00','11:59:59','ODINSA S.A.','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de ODINSA S.A.., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo quinientas setenta y cinco mil trescientas sesenta y un (575.361)  acciones ordinarias.','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 14:00:53','ACTUALIZACI? REGISTRO');
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_adjudicacion`
--

LOCK TABLES `au_adjudicacion` WRITE;
/*!40000 ALTER TABLE `au_adjudicacion` DISABLE KEYS */;
INSERT INTO `au_adjudicacion` VALUES (1,1801,1,1500,10500.00,15750000.00,'lnavarro','root@localhost','2018-01-09 22:08:46','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:31','BORRADO REGISTRO'),(2,1802,2,20000,10500.00,210000000.00,'lnavarro','root@localhost','2018-01-09 22:08:46','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:31','BORRADO REGISTRO'),(3,1803,3,890,10500.00,9345000.00,'lnavarro','root@localhost','2018-01-09 22:08:46','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:31','BORRADO REGISTRO'),(4,1804,4,100,10500.00,1050000.00,'lnavarro','root@localhost','2018-01-09 22:08:46','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:31','BORRADO REGISTRO'),(5,1805,5,200,10500.00,2100000.00,'lnavarro','root@localhost','2018-01-09 22:08:46','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:31','BORRADO REGISTRO'),(6,1806,6,500,10500.00,5250000.00,'lnavarro','root@localhost','2018-01-09 22:08:46','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:31','BORRADO REGISTRO'),(7,1807,3,2028,10500.00,21294000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(8,1808,4,165,10500.00,1732500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(9,1809,5,37,10500.00,388500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(10,1810,6,37,10500.00,388500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(11,1811,7,1,10500.00,10500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(12,1812,8,185,10500.00,1942500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(13,1813,10,29,10500.00,304500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(14,1814,11,178,10500.00,1869000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(15,1815,13,1190,10500.00,12495000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(16,1816,15,371,10500.00,3895500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(17,1817,16,4819,10500.00,50599500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(18,1818,17,743,10500.00,7801500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(19,1819,18,110,10500.00,1155000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(20,1820,19,70,10500.00,735000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(21,1821,21,687,10500.00,7213500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(22,1822,22,687,10500.00,7213500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(23,1823,24,20000,10500.00,210000000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(24,1824,27,4000,10500.00,42000000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(25,1825,1,3581,10500.00,37600500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(26,1826,2,283,10500.00,2971500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(27,1827,9,30500,10500.00,320250000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(28,1828,12,6000,10500.00,63000000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(29,1829,14,370,10500.00,3885000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(30,1830,20,143002,10500.00,1501521000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(31,1831,23,2046,10500.00,21483000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(32,1832,25,137,10500.00,1438500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(33,1833,26,55,10500.00,577500.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(34,1834,28,5134,10500.00,53907000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO'),(35,1835,29,19092,10500.00,200466000.00,'lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:13:38','INSERCI? REGISTRO');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_reporteUsuario`
--

LOCK TABLES `au_reporteUsuario` WRITE;
/*!40000 ALTER TABLE `au_reporteUsuario` DISABLE KEYS */;
INSERT INTO `au_reporteUsuario` VALUES (1,1,1,111,'2018-01-17'),(2,1,1,111,'2018-01-17'),(3,1,1,111,'2018-01-17'),(4,2,1,102,'2018-01-18'),(5,3,1,102,'2018-01-22'),(6,4,1,111,'2018-01-22'),(7,5,1,102,'2018-01-23'),(8,6,1,102,'2018-01-24'),(9,7,1,102,'2018-01-26'),(10,8,1,107,'2018-01-30'),(11,8,1,107,'2018-01-30'),(12,9,1,111,'2018-01-30'),(13,10,1,107,'2018-02-01'),(14,11,1,111,'2018-02-01'),(15,12,1,119,'2018-02-14'),(16,13,1,102,'2018-02-15'),(17,14,1,111,'2018-02-15'),(18,15,1,102,'2018-02-19'),(19,16,1,119,'2018-02-19'),(20,17,1,111,'2018-02-20'),(21,18,1,119,'2018-02-20'),(22,19,1,115,'2018-02-20');
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
INSERT INTO `au_reporteadjudicacion` VALUES (1,'2018-02-21');
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
) ENGINE=MyISAM AUTO_INCREMENT=266 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_usuario`
--

LOCK TABLES `au_usuario` WRITE;
/*!40000 ALTER TABLE `au_usuario` DISABLE KEYS */;
INSERT INTO `au_usuario` VALUES (1,96,'CC','1136885240','Jonathan Javier','Herrera Sanchez',NULL,NULL,'jhonatan.herrera@itau.co','1004001','3f6ASQ6EpnKVcSEjoPjM1w==','2018-01-10 10:57:29',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 13:59:17',0,4,0,'ogomez','root@localhost','2018-01-09 16:11:38','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 15:57:29','ACTUALIZACION REGISTRO'),(2,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:00:12','INSERCION REGISTRO'),(3,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','RKnjd7l5wIRAqUZ+dPiclQ==',NULL,0,0,'A','2018-01-10',0,NULL,'N',NULL,0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:00:12','ACTUALIZACION REGISTRO'),(4,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','RKnjd7l5wIRAqUZ+dPiclQ==',NULL,0,0,'A','2018-01-10',0,NULL,'N',NULL,0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:01:04','ACTUALIZACION REGISTRO'),(5,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','RKnjd7l5wIRAqUZ+dPiclQ==','2018-01-10 11:40:17',0,0,'A','2018-01-10',0,NULL,'N',NULL,0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:40:17','ACTUALIZACION REGISTRO'),(6,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','LSRLkxtPDKJX/fKzQk4tBA==','2018-01-10 11:40:17',0,0,'A','2018-01-10',0,NULL,'N',NULL,0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 16:41:02','ACTUALIZACION REGISTRO'),(7,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-10 13:22:08',0,0,'A','2018-01-04',0,NULL,'N','2018-01-09 17:41:36',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-10 18:22:08','ACTUALIZACION REGISTRO'),(8,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-10 13:22:08',0,0,'A','2018-01-04',1,NULL,'N','2018-01-11 12:00:41',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 17:00:41','ACTUALIZACION REGISTRO'),(9,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-10 13:22:08',0,0,'A','2018-01-04',2,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 17:00:52','ACTUALIZACION REGISTRO'),(10,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-10 13:22:08',0,0,'B','2018-01-04',2,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 17:00:52','ACTUALIZACION REGISTRO'),(11,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','nmH+gRtN4cNWx9xYKbtwow==','2018-01-11 13:56:31',0,0,'A','2017-06-09',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 18:56:31','ACTUALIZACION REGISTRO'),(12,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-11 13:56:31',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 18:57:19','ACTUALIZACION REGISTRO'),(13,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-11 14:17:46',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 19:17:46','ACTUALIZACION REGISTRO'),(14,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','XOvhFRuFAS85b1XR5tbxWg==','2018-01-11 17:58:46',0,0,'A','2018-01-05',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:58:46','ACTUALIZACION REGISTRO'),(15,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-10 13:22:08',0,0,'A','2018-01-04',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:59:37','ACTUALIZACION REGISTRO'),(16,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','wq5iz+BD3JW4i2YVDt2bdw==','2018-01-10 13:22:08',0,0,'A','2018-01-11',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 22:59:37','ACTUALIZACION REGISTRO'),(17,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:23:34','INSERCION REGISTRO'),(18,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','XOvhFRuFAS85b1XR5tbxWg==',NULL,0,0,'A','2018-01-11',0,NULL,'N',NULL,0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:23:34','ACTUALIZACION REGISTRO'),(19,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:24:49','INSERCION REGISTRO'),(20,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','XOvhFRuFAS85b1XR5tbxWg==',NULL,0,0,'A','2018-01-11',0,NULL,'N',NULL,0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:24:49','ACTUALIZACION REGISTRO'),(21,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','XOvhFRuFAS85b1XR5tbxWg==','2018-01-11 18:55:51',0,0,'A','2018-01-11',0,NULL,'N',NULL,0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:55:51','ACTUALIZACION REGISTRO'),(22,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','yUZl+eFGxffItuUxCrNJVg==','2018-01-11 18:55:51',0,0,'A','2018-01-11',0,NULL,'N',NULL,0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-11 23:57:08','ACTUALIZACION REGISTRO'),(23,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','XOvhFRuFAS85b1XR5tbxWg==','2018-01-12 07:03:24',0,0,'A','2018-01-11',0,NULL,'N',NULL,0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 12:03:24','ACTUALIZACION REGISTRO'),(24,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 07:03:24',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 12:03:48','ACTUALIZACION REGISTRO'),(25,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 19:48:35','ACTUALIZACION REGISTRO'),(26,110,'CC','79763827','WILLIAM','SILVA',NULL,NULL,'wsilva@credicorpcapital.com','wsilva','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 19:56:27','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 19:56:27','INSERCION REGISTRO'),(27,110,'CC','79763827','WILLIAM','SILVA',NULL,NULL,'wsilva@credicorpcapital.com','wsilva','OccjmXv3RONbOP8LahffeA==',NULL,0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 19:56:27','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 19:56:27','ACTUALIZACION REGISTRO'),(28,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','wq5iz+BD3JW4i2YVDt2bdw==','2018-01-12 15:01:05',0,0,'A','2018-01-11',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:01:05','ACTUALIZACION REGISTRO'),(29,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-12 15:01:05',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:01:22','ACTUALIZACION REGISTRO'),(30,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:05:04','INSERCION REGISTRO'),(31,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','jfvWmkZK1XcJbCTULxtVEQ==',NULL,0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:05:04','ACTUALIZACION REGISTRO'),(32,112,'CC','1013632361','NICOLAS','GOMEZ',NULL,NULL,'ngomezm@credicorpcapital.com','ngomezm','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:07:33','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:07:33','INSERCION REGISTRO'),(33,112,'CC','1013632361','NICOLAS','GOMEZ',NULL,NULL,'ngomezm@credicorpcapital.com','ngomezm','jfvWmkZK1XcJbCTULxtVEQ==',NULL,0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:07:33','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:07:33','ACTUALIZACION REGISTRO'),(34,112,'CC','1013632361','NICOLAS','GOMEZ',NULL,NULL,'ngomezm@credicorpcapital.com','ngomezm','jfvWmkZK1XcJbCTULxtVEQ==','2018-01-12 15:09:49',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:07:33','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:09:49','ACTUALIZACION REGISTRO'),(35,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-12 15:13:03',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:13:03','ACTUALIZACION REGISTRO'),(36,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','jfvWmkZK1XcJbCTULxtVEQ==','2018-01-12 15:41:13',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:41:13','ACTUALIZACION REGISTRO'),(37,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-12 15:41:13',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-12 20:41:59','ACTUALIZACION REGISTRO'),(38,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-15 14:10:54',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-15 19:10:54','ACTUALIZACION REGISTRO'),(39,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','XOvhFRuFAS85b1XR5tbxWg==',NULL,0,0,'A','2018-01-09',1,NULL,'N','2018-01-15 15:26:55',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-15 20:26:55','ACTUALIZACION REGISTRO'),(40,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','XOvhFRuFAS85b1XR5tbxWg==',NULL,0,0,'A','2018-01-09',2,NULL,'N','2018-01-15 15:27:46',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-15 20:27:46','ACTUALIZACION REGISTRO'),(41,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','XOvhFRuFAS85b1XR5tbxWg==',NULL,0,0,'B','2018-01-09',2,NULL,'N','2018-01-15 15:27:46',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-15 20:27:46','ACTUALIZACION REGISTRO'),(42,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-16 13:59:16',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-16 18:59:16','ACTUALIZACION REGISTRO'),(43,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'A','2018-01-12',1,NULL,'N','2018-01-16 14:54:42',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-16 19:54:42','ACTUALIZACION REGISTRO'),(44,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-16 15:51:05',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-16 20:51:05','ACTUALIZACION REGISTRO'),(45,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-17 08:26:40',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 13:26:40','ACTUALIZACION REGISTRO'),(46,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-17 09:12:52',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 14:12:52','ACTUALIZACION REGISTRO'),(47,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-17 10:11:56',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 15:11:56','ACTUALIZACION REGISTRO'),(48,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-17 12:38:24',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 17:38:24','ACTUALIZACION REGISTRO'),(49,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-17 13:47:27',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 18:47:27','ACTUALIZACION REGISTRO'),(50,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-17 14:06:31',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 19:06:31','ACTUALIZACION REGISTRO'),(51,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-17 14:10:20',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 19:10:20','ACTUALIZACION REGISTRO'),(52,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','XOvhFRuFAS85b1XR5tbxWg==','2018-01-17 18:14:05',0,0,'A','2018-01-05',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 23:14:05','ACTUALIZACION REGISTRO'),(53,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','XOvhFRuFAS85b1XR5tbxWg==',NULL,0,0,'A','2018-01-09',0,NULL,'N','2018-01-15 15:27:46',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 23:14:48','ACTUALIZACION REGISTRO'),(54,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','wq5iz+BD3JW4i2YVDt2bdw==',NULL,0,0,'A','2018-01-17',0,NULL,'N','2018-01-15 15:27:46',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-17 23:14:48','ACTUALIZACION REGISTRO'),(55,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-18 10:38:59',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 15:38:59','ACTUALIZACION REGISTRO'),(56,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-18 13:37:07',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 18:37:07','ACTUALIZACION REGISTRO'),(57,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-18 14:43:15',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 19:43:15','ACTUALIZACION REGISTRO'),(58,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-18 14:52:52',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-18 19:52:52','ACTUALIZACION REGISTRO'),(59,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-19 12:04:54',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-19 17:04:54','ACTUALIZACION REGISTRO'),(60,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-19 13:31:37',0,0,'A','2018-01-12',0,NULL,'N','2018-01-11 12:00:52',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-19 18:31:37','ACTUALIZACION REGISTRO'),(61,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-22 09:34:12',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 14:34:12','ACTUALIZACION REGISTRO'),(62,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-22 11:17:19',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 16:17:19','ACTUALIZACION REGISTRO'),(63,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-22 12:07:51',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 17:07:51','ACTUALIZACION REGISTRO'),(64,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-19 13:31:37',0,0,'A','2018-01-12',1,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 18:57:49','ACTUALIZACION REGISTRO'),(65,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-22 13:58:03',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 18:58:03','ACTUALIZACION REGISTRO'),(66,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-22 15:50:16',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-22 20:50:16','ACTUALIZACION REGISTRO'),(67,103,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','JP/zuSp86jydA8V0HJ60Pg==','2018-01-23 08:43:22',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,0,'1010001','root@localhost','2018-01-09 18:49:39','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 13:43:22','ACTUALIZACION REGISTRO'),(68,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-23 10:25:55',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 15:25:55','ACTUALIZACION REGISTRO'),(69,103,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','JP/zuSp86jydA8V0HJ60Pg==','2018-01-23 10:51:26',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,0,'1010001','root@localhost','2018-01-09 18:49:39','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 15:51:26','ACTUALIZACION REGISTRO'),(70,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-23 11:09:46',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 16:09:46','ACTUALIZACION REGISTRO'),(71,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-23 12:53:06',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 17:53:06','ACTUALIZACION REGISTRO'),(72,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-23 13:59:49',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 18:59:49','ACTUALIZACION REGISTRO'),(73,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-23 14:04:11',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 19:04:11','ACTUALIZACION REGISTRO'),(74,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-23 14:59:27',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 19:59:27','ACTUALIZACION REGISTRO'),(75,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-23 15:40:12',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-23 20:40:12','ACTUALIZACION REGISTRO'),(76,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-24 12:30:27',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-24 17:30:27','ACTUALIZACION REGISTRO'),(77,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-24 13:13:09',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-24 18:13:09','ACTUALIZACION REGISTRO'),(78,3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','wfKInGj6zEfvj3WA3Uj5Kw==','2017-07-07 14:10:41',0,0,'A','2017-07-07',1,NULL,'N','2018-01-24 14:04:40',0,90,0,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-24 19:04:40','ACTUALIZACION REGISTRO'),(79,3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','wfKInGj6zEfvj3WA3Uj5Kw==','2018-01-24 14:06:18',0,0,'A','2017-07-07',0,NULL,'N','2018-01-24 14:04:40',0,90,0,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-24 19:06:18','ACTUALIZACION REGISTRO'),(80,3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','JZm5c7gWZSq6eNOzApDltg==','2018-01-24 14:06:18',0,0,'A','2018-01-24',0,NULL,'N','2018-01-24 14:04:40',0,90,0,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-24 19:06:40','ACTUALIZACION REGISTRO'),(81,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-24 14:58:07',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-24 19:58:07','ACTUALIZACION REGISTRO'),(82,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-25 13:21:16',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-25 18:21:16','ACTUALIZACION REGISTRO'),(83,3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','JZm5c7gWZSq6eNOzApDltg==','2018-01-25 14:18:57',0,0,'A','2018-01-24',0,NULL,'N','2018-01-24 14:04:40',0,90,0,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-25 19:18:57','ACTUALIZACION REGISTRO'),(84,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-25 14:51:31',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-25 19:51:31','ACTUALIZACION REGISTRO'),(85,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-22 12:07:51',0,0,'A','2018-01-12',1,NULL,'N','2018-01-25 15:11:17',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-25 20:11:17','ACTUALIZACION REGISTRO'),(86,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-01-26 11:02:26',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-26 16:02:26','ACTUALIZACION REGISTRO'),(87,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-26 13:47:55',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-26 18:47:55','ACTUALIZACION REGISTRO'),(88,3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','JZm5c7gWZSq6eNOzApDltg==','2018-01-26 14:15:17',0,0,'A','2018-01-24',0,NULL,'N','2018-01-24 14:04:40',0,90,0,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-26 19:15:17','ACTUALIZACION REGISTRO'),(89,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-29 14:13:59',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-29 19:13:59','ACTUALIZACION REGISTRO'),(90,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','LSRLkxtPDKJX/fKzQk4tBA==','2018-01-10 11:40:17',0,0,'A','2018-01-10',1,NULL,'N','2018-01-30 08:16:18',0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 13:16:18','ACTUALIZACION REGISTRO'),(91,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','LSRLkxtPDKJX/fKzQk4tBA==','2018-01-30 08:17:03',0,0,'A','2018-01-10',0,NULL,'N','2018-01-30 08:16:18',0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 13:17:03','ACTUALIZACION REGISTRO'),(92,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','yUZl+eFGxffItuUxCrNJVg==','2018-01-30 08:17:03',0,0,'A','2018-01-30',0,NULL,'N','2018-01-30 08:16:18',0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 13:17:36','ACTUALIZACION REGISTRO'),(93,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','yUZl+eFGxffItuUxCrNJVg==','2018-01-30 09:32:41',0,0,'A','2018-01-30',0,NULL,'N','2018-01-30 08:16:18',0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 14:32:41','ACTUALIZACION REGISTRO'),(94,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-01-30 12:10:50',0,0,'A','2018-01-12',0,NULL,'N','2018-01-25 15:11:17',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 17:10:50','ACTUALIZACION REGISTRO'),(95,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-30 13:40:33',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 18:40:33','ACTUALIZACION REGISTRO'),(96,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-30 14:05:36',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-30 19:05:36','ACTUALIZACION REGISTRO'),(97,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-01-31 13:09:54',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-31 18:09:54','ACTUALIZACION REGISTRO'),(98,1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','XOvhFRuFAS85b1XR5tbxWg==','2018-01-05 12:05:37',0,0,'A','2018-01-05',2,NULL,'N','2018-01-31 17:38:49',0,90,0,NULL,'root@localhost',NULL,NULL,'opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-31 22:38:49','ACTUALIZACION REGISTRO'),(99,1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','XOvhFRuFAS85b1XR5tbxWg==','2018-01-05 12:05:37',0,0,'B','2018-01-05',2,NULL,'N','2018-01-31 17:38:49',0,90,0,NULL,'root@localhost',NULL,NULL,'opaunoapp@ip-192-168-70-35.ec2.internal','2018-01-31 22:38:49','ACTUALIZACION REGISTRO'),(100,3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','oiJ6V7ui+YmEjZaVtgWC6w==','2018-01-26 14:15:17',0,0,'A','2018-01-24',0,NULL,'N','2018-01-24 14:04:40',0,90,0,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación','root@localhost','2018-02-01 11:27:13','ACTUALIZACION REGISTRO'),(101,1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','XOvhFRuFAS85b1XR5tbxWg==','2018-01-05 12:05:37',0,0,'A','2018-01-05',0,NULL,'N','2018-01-31 17:38:49',0,90,0,NULL,'root@localhost',NULL,NULL,'opaunoapp@localhost','2018-02-01 12:25:07','ACTUALIZACION REGISTRO'),(102,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','7QsgiqKc52pOsB8AV6swGA==','2018-02-01 08:48:45',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 13:48:45','ACTUALIZACION REGISTRO'),(103,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','3K2QOSimrhTmqeT45p7gAw==','2018-02-01 08:48:45',0,0,'A','2018-02-01',0,NULL,'N','2018-01-09 14:23:40',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 13:49:42','ACTUALIZACION REGISTRO'),(104,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','yUZl+eFGxffItuUxCrNJVg==','2018-01-30 09:32:41',0,0,'A','2018-01-30',1,NULL,'N','2018-02-01 10:37:57',0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 15:37:57','ACTUALIZACION REGISTRO'),(105,107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','yUZl+eFGxffItuUxCrNJVg==','2018-02-01 10:38:49',0,0,'A','2018-01-30',0,NULL,'N','2018-02-01 10:37:57',0,4,0,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 15:38:49','ACTUALIZACION REGISTRO'),(106,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','kWs1UK6ktB9I5ADMZY/CmA==','2018-02-01 13:50:34',0,0,'A','2018-01-12',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 18:50:34','ACTUALIZACION REGISTRO'),(107,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-01 13:50:34',0,0,'A','2018-02-01',0,NULL,'N','2018-01-22 13:57:49',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 18:51:00','ACTUALIZACION REGISTRO'),(108,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','9ZIhhFB96FvRk0QrCG2LXA==','2018-02-01 17:58:37',0,0,'A','2018-01-12',0,NULL,'N','2018-01-25 15:11:17',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 22:58:37','ACTUALIZACION REGISTRO'),(109,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7JfOVijXbkQb1MnpH2YWzg==','2018-02-01 17:58:37',0,0,'A','2018-02-01',0,NULL,'N','2018-01-25 15:11:17',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-01 22:59:16','ACTUALIZACION REGISTRO'),(110,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-01 13:50:34',0,0,'A','2018-02-01',1,NULL,'N','2018-02-02 13:19:23',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-02 18:19:23','ACTUALIZACION REGISTRO'),(111,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-02 13:19:51',0,0,'A','2018-02-01',0,NULL,'N','2018-02-02 13:19:23',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-02 18:19:51','ACTUALIZACION REGISTRO'),(112,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-02 13:19:51',0,0,'A','2018-02-01',1,NULL,'N','2018-02-05 13:34:50',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-05 18:34:50','ACTUALIZACION REGISTRO'),(113,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-05 13:35:13',0,0,'A','2018-02-01',0,NULL,'N','2018-02-05 13:34:50',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-05 18:35:13','ACTUALIZACION REGISTRO'),(114,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-06 13:21:09',0,0,'A','2018-02-01',0,NULL,'N','2018-02-05 13:34:50',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-06 18:21:09','ACTUALIZACION REGISTRO'),(115,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-07 13:25:15',0,0,'A','2018-02-01',0,NULL,'N','2018-02-05 13:34:50',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-07 18:25:15','ACTUALIZACION REGISTRO'),(116,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','JLj2NC1fa7ZoTPyoqUTXBw==','2018-02-07 13:59:53',0,0,'A','2018-01-11',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-07 18:59:53','ACTUALIZACION REGISTRO'),(117,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-07 13:59:53',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-07 19:02:22','ACTUALIZACION REGISTRO'),(118,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-07 14:15:55',0,0,'A','2018-02-01',0,NULL,'N','2018-02-05 13:34:50',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-07 19:15:55','ACTUALIZACION REGISTRO'),(119,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-07 14:15:55',0,0,'A','2018-02-01',1,NULL,'N','2018-02-08 13:15:54',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-08 18:15:54','ACTUALIZACION REGISTRO'),(120,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-08 13:16:29',0,0,'A','2018-02-01',0,NULL,'N','2018-02-08 13:15:54',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-08 18:16:29','ACTUALIZACION REGISTRO'),(121,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-08 14:23:38',0,0,'A','2018-02-01',0,NULL,'N','2018-02-08 13:15:54',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-08 19:23:38','ACTUALIZACION REGISTRO'),(122,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-08 14:54:02',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-08 19:54:02','ACTUALIZACION REGISTRO'),(123,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-08 14:23:38',0,0,'A','2018-02-01',1,NULL,'N','2018-02-09 13:41:06',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-09 18:41:06','ACTUALIZACION REGISTRO'),(124,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-09 13:41:37',0,0,'A','2018-02-01',0,NULL,'N','2018-02-09 13:41:06',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-09 18:41:37','ACTUALIZACION REGISTRO'),(125,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','yUZl+eFGxffItuUxCrNJVg==','2018-01-11 18:55:51',0,0,'A','2018-01-11',1,NULL,'N','2018-02-09 16:52:37',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-09 21:52:37','ACTUALIZACION REGISTRO'),(126,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','yUZl+eFGxffItuUxCrNJVg==','2018-01-11 18:55:51',0,0,'A','2018-01-11',2,NULL,'N','2018-02-09 16:55:24',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-09 21:55:24','ACTUALIZACION REGISTRO'),(127,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','yUZl+eFGxffItuUxCrNJVg==','2018-01-11 18:55:51',0,0,'B','2018-01-11',2,NULL,'N','2018-02-09 16:55:24',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-09 21:55:24','ACTUALIZACION REGISTRO'),(128,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-12 13:51:07',0,0,'A','2018-02-01',0,NULL,'N','2018-02-09 13:41:06',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-12 18:51:07','ACTUALIZACION REGISTRO'),(129,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','XOvhFRuFAS85b1XR5tbxWg==','2018-02-12 22:55:55',0,0,'A','2018-01-05',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 03:55:55','ACTUALIZACION REGISTRO'),(130,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-12 22:55:55',0,0,'A','2018-02-12',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 03:56:28','ACTUALIZACION REGISTRO'),(131,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','yUZl+eFGxffItuUxCrNJVg==','2018-01-11 18:55:51',0,0,'A','2018-01-11',0,NULL,'N','2018-02-09 16:55:24',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 03:57:24','ACTUALIZACION REGISTRO'),(132,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','rOlPSvb6jr6aq/u3UruaPg==','2018-01-11 18:55:51',0,0,'A','2018-02-12',0,NULL,'N','2018-02-09 16:55:24',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 03:57:24','ACTUALIZACION REGISTRO'),(133,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','rOlPSvb6jr6aq/u3UruaPg==','2018-02-13 10:17:39',0,0,'A','2018-02-12',0,NULL,'N','2018-02-09 16:55:24',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 15:17:39','ACTUALIZACION REGISTRO'),(134,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 10:17:39',0,0,'A','2018-02-13',0,NULL,'N','2018-02-09 16:55:24',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 15:18:22','ACTUALIZACION REGISTRO'),(135,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 10:17:39',0,0,'A','2018-02-13',1,NULL,'N','2018-02-13 12:31:54',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:31:54','ACTUALIZACION REGISTRO'),(136,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 10:17:39',0,0,'A','2018-02-13',2,NULL,'N','2018-02-13 12:32:30',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:32:30','ACTUALIZACION REGISTRO'),(137,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 10:17:39',0,0,'B','2018-02-13',2,NULL,'N','2018-02-13 12:32:30',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:32:30','ACTUALIZACION REGISTRO'),(138,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-13 12:38:16',0,0,'A','2018-02-12',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:38:16','ACTUALIZACION REGISTRO'),(139,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 10:17:39',0,0,'A','2018-02-13',0,NULL,'N','2018-02-13 12:32:30',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:38:46','ACTUALIZACION REGISTRO'),(140,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 12:40:16',0,0,'A','2018-02-13',0,NULL,'N','2018-02-13 12:32:30',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 17:40:16','ACTUALIZACION REGISTRO'),(141,113,'CC','1015440542','Diana Milena','Gomez Diaz',NULL,NULL,'dgomez@corredores.com','dgomez','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'1002001','root@localhost','2018-02-13 18:00:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:00:34','INSERCION REGISTRO'),(142,113,'CC','1015440542','Diana Milena','Gomez Diaz',NULL,NULL,'dgomez@corredores.com','dgomez','xPq/l6qGnPLdYaRjPc7PXg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,2,0,'1002001','root@localhost','2018-02-13 18:00:34','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:00:34','ACTUALIZACION REGISTRO'),(143,114,'CC','1073599008','Maria Alejandra ','Romero',NULL,NULL,'mromero@corredores.com','mromero','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,2,0,'1002001','root@localhost','2018-02-13 18:04:32','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:04:32','INSERCION REGISTRO'),(144,114,'CC','1073599008','Maria Alejandra ','Romero',NULL,NULL,'mromero@corredores.com','mromero','xPq/l6qGnPLdYaRjPc7PXg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,2,0,'1002001','root@localhost','2018-02-13 18:04:32','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:04:32','ACTUALIZACION REGISTRO'),(145,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-13 13:47:29',0,0,'A','2018-02-01',0,NULL,'N','2018-02-09 13:41:06',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 18:47:29','ACTUALIZACION REGISTRO'),(146,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-13 14:27:40',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 19:27:40','ACTUALIZACION REGISTRO'),(147,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-13 14:46:35',0,0,'A','2018-02-12',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 19:46:35','ACTUALIZACION REGISTRO'),(148,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 19:51:06','INSERCION REGISTRO'),(149,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','0M7Pxj83XcUGyJ3AbVp+Kw==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 19:51:06','ACTUALIZACION REGISTRO'),(150,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','0M7Pxj83XcUGyJ3AbVp+Kw==','2018-02-13 16:07:19',0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:07:19','ACTUALIZACION REGISTRO'),(151,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','z1BrrKD7rjKIu7pwj6o+Aw==','2018-02-13 16:07:19',0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:07:44','ACTUALIZACION REGISTRO'),(152,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:10:59','INSERCION REGISTRO'),(153,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:10:59','ACTUALIZACION REGISTRO'),(154,117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:11:57','INSERCION REGISTRO'),(155,117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:11:57','ACTUALIZACION REGISTRO'),(156,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:12:57','INSERCION REGISTRO'),(157,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:12:57','ACTUALIZACION REGISTRO'),(158,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',1,NULL,'N','2018-02-13 16:17:27',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:17:27','ACTUALIZACION REGISTRO'),(159,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','lRAtqzTdE64m0tHQrjDKAg==','2018-02-13 16:18:23',0,0,'A','2018-02-13',0,NULL,'N','2018-02-13 16:17:27',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:18:23','ACTUALIZACION REGISTRO'),(160,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:18:23',0,0,'A','2018-02-13',0,NULL,'N','2018-02-13 16:17:27',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-13 21:19:15','ACTUALIZACION REGISTRO'),(161,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-14 10:31:05',0,0,'A','2018-02-12',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:31:05','ACTUALIZACION REGISTRO'),(162,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','wq5iz+BD3JW4i2YVDt2bdw==','2018-02-14 10:31:16',0,0,'A','2018-01-17',0,NULL,'N','2018-01-15 15:27:46',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:31:16','ACTUALIZACION REGISTRO'),(163,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:31:16',0,0,'A','2018-02-14',0,NULL,'N','2018-01-15 15:27:46',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:34:32','ACTUALIZACION REGISTRO'),(164,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:35:41','INSERCION REGISTRO'),(165,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','5sS8vQCj0lSWDyDcE9W9VA==',NULL,0,0,'A','2018-02-14',0,NULL,'N',NULL,0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:35:41','ACTUALIZACION REGISTRO'),(166,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','5sS8vQCj0lSWDyDcE9W9VA==',NULL,0,0,'A','2018-02-14',1,NULL,'N','2018-02-14 10:36:00',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:36:00','ACTUALIZACION REGISTRO'),(167,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','5sS8vQCj0lSWDyDcE9W9VA==','2018-02-14 10:36:17',0,0,'A','2018-02-14',0,NULL,'N','2018-02-14 10:36:00',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:36:17','ACTUALIZACION REGISTRO'),(168,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:36:17',0,0,'A','2018-02-14',0,NULL,'N','2018-02-14 10:36:00',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 15:36:31','ACTUALIZACION REGISTRO'),(169,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-14 13:24:25',0,0,'A','2018-02-01',0,NULL,'N','2018-02-09 13:41:06',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 18:24:25','ACTUALIZACION REGISTRO'),(170,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-14 14:14:27',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-14 19:14:27','ACTUALIZACION REGISTRO'),(171,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','3K2QOSimrhTmqeT45p7gAw==','2018-02-01 08:48:45',0,0,'A','2018-02-01',1,NULL,'N','2018-02-15 08:06:43',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 13:06:43','ACTUALIZACION REGISTRO'),(172,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','3K2QOSimrhTmqeT45p7gAw==','2018-02-15 08:07:16',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 08:06:43',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 13:07:16','ACTUALIZACION REGISTRO'),(173,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7JfOVijXbkQb1MnpH2YWzg==','2018-02-01 17:58:37',0,0,'A','2018-02-01',1,NULL,'N','2018-02-15 10:39:16',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 15:39:16','ACTUALIZACION REGISTRO'),(174,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7JfOVijXbkQb1MnpH2YWzg==','2018-02-01 17:58:37',0,0,'A','2018-02-01',2,NULL,'N','2018-02-15 10:39:56',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 15:39:56','ACTUALIZACION REGISTRO'),(175,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7JfOVijXbkQb1MnpH2YWzg==','2018-02-01 17:58:37',0,0,'B','2018-02-01',2,NULL,'N','2018-02-15 10:39:56',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 15:39:56','ACTUALIZACION REGISTRO'),(176,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'A','2018-01-12',2,NULL,'N','2018-02-15 11:18:42',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:18:42','ACTUALIZACION REGISTRO'),(177,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'B','2018-01-12',2,NULL,'N','2018-02-15 11:18:42',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:18:42','ACTUALIZACION REGISTRO'),(178,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-15 11:24:35',0,0,'A','2018-02-12',0,NULL,'N','2018-01-05 12:06:58',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:24:35','ACTUALIZACION REGISTRO'),(179,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'A','2018-01-12',0,NULL,'N','2018-02-15 11:18:42',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:25:47','ACTUALIZACION REGISTRO'),(180,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'A','2018-01-12',1,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:26:24','ACTUALIZACION REGISTRO'),(181,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','1qWhnOGZnc6SeM8erARmqg==','2018-01-12 14:48:35',0,0,'A','2018-01-12',0,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','ACTUALIZACION REGISTRO'),(182,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','lRAtqzTdE64m0tHQrjDKAg==','2018-01-12 14:48:35',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:27:00','ACTUALIZACION REGISTRO'),(183,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','lRAtqzTdE64m0tHQrjDKAg==','2018-02-15 11:28:12',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:28:12','ACTUALIZACION REGISTRO'),(184,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','DOPeGpAgGCDXIRc+oNkniA==','2018-02-15 11:28:12',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:28:49','ACTUALIZACION REGISTRO'),(185,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7JfOVijXbkQb1MnpH2YWzg==','2018-02-01 17:58:37',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 10:39:56',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','ACTUALIZACION REGISTRO'),(186,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7CUFURoonQbyyLmRQkV1JA==','2018-02-01 17:58:37',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 10:39:56',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:29:18','ACTUALIZACION REGISTRO'),(187,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','DOPeGpAgGCDXIRc+oNkniA==','2018-02-15 11:30:45',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 16:30:45','ACTUALIZACION REGISTRO'),(188,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','7CUFURoonQbyyLmRQkV1JA==','2018-02-15 12:05:13',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 10:39:56',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 17:05:13','ACTUALIZACION REGISTRO'),(189,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-15 12:05:13',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 10:39:56',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 17:06:02','ACTUALIZACION REGISTRO'),(190,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-14 13:24:25',0,0,'A','2018-02-01',1,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 18:13:57','ACTUALIZACION REGISTRO'),(191,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-15 13:15:43',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 18:15:43','ACTUALIZACION REGISTRO'),(192,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-15 13:23:08',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 18:23:08','ACTUALIZACION REGISTRO'),(193,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-15 14:37:26',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-15 19:37:26','ACTUALIZACION REGISTRO'),(194,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-15 12:05:13',0,0,'A','2018-02-15',1,NULL,'N','2018-02-16 10:32:50',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 15:32:50','ACTUALIZACION REGISTRO'),(195,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-15 12:05:13',0,0,'A','2018-02-15',2,NULL,'N','2018-02-16 10:33:18',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 15:33:18','ACTUALIZACION REGISTRO'),(196,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-15 12:05:13',0,0,'B','2018-02-15',2,NULL,'N','2018-02-16 10:33:18',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 15:33:18','ACTUALIZACION REGISTRO'),(197,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','z1BrrKD7rjKIu7pwj6o+Aw==','2018-02-13 16:07:19',0,0,'A','2018-02-13',1,NULL,'N','2018-02-16 11:25:09',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:25:09','ACTUALIZACION REGISTRO'),(198,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','z1BrrKD7rjKIu7pwj6o+Aw==','2018-02-16 11:25:28',0,0,'A','2018-02-13',0,NULL,'N','2018-02-16 11:25:09',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:25:28','ACTUALIZACION REGISTRO'),(199,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:25:47','ACTUALIZACION REGISTRO'),(200,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','lRAtqzTdE64m0tHQrjDKAg==','2018-02-16 11:35:52',0,0,'A','2018-02-13',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:35:52','ACTUALIZACION REGISTRO'),(201,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-15 11:24:35',0,0,'A','2018-02-12',1,NULL,'N','2018-02-16 11:35:53',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:35:53','ACTUALIZACION REGISTRO'),(202,1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 11:36:29',0,0,'A','2018-01-05',0,NULL,'N','2018-01-31 17:38:49',0,90,0,NULL,'root@localhost',NULL,NULL,'opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:36:29','ACTUALIZACION REGISTRO'),(203,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','pHSq05X7wezRDHVN73Dndg==','2018-02-16 11:35:52',0,0,'A','2018-02-16',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 16:38:17','ACTUALIZACION REGISTRO'),(204,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','pHSq05X7wezRDHVN73Dndg==','2018-02-16 12:15:03',0,0,'A','2018-02-16',0,NULL,'N',NULL,0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 17:15:03','ACTUALIZACION REGISTRO'),(205,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-16 12:25:29',0,0,'A','2018-02-12',0,NULL,'N','2018-02-16 11:35:53',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 17:25:29','ACTUALIZACION REGISTRO'),(206,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','z1BrrKD7rjKIu7pwj6o+Aw==','2018-02-16 11:25:28',0,0,'A','2018-02-13',0,NULL,'N','2018-02-16 11:25:09',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 17:41:44','ACTUALIZACION REGISTRO'),(207,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 11:25:28',0,0,'A','2018-02-16',0,NULL,'N','2018-02-16 11:25:09',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 17:41:44','ACTUALIZACION REGISTRO'),(208,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-16 14:21:44',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 19:21:44','ACTUALIZACION REGISTRO'),(209,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-16 14:55:16',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-16 19:55:16','ACTUALIZACION REGISTRO'),(210,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','pHSq05X7wezRDHVN73Dndg==','2018-02-16 12:15:03',0,0,'A','2018-02-16',1,NULL,'N','2018-02-19 09:04:32',0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:04:32','ACTUALIZACION REGISTRO'),(211,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','pHSq05X7wezRDHVN73Dndg==','2018-02-19 09:05:16',0,0,'A','2018-02-16',0,NULL,'N','2018-02-19 09:04:32',0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:05:16','ACTUALIZACION REGISTRO'),(212,109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','DOPeGpAgGCDXIRc+oNkniA==','2018-02-19 09:24:45',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 11:26:24',0,29,0,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:24:45','ACTUALIZACION REGISTRO'),(213,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-15 12:05:13',0,0,'A','2018-02-15',0,NULL,'N','2018-02-16 10:33:18',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:25:11','ACTUALIZACION REGISTRO'),(214,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-19 09:41:24',0,0,'A','2018-02-15',0,NULL,'N','2018-02-16 10:33:18',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 14:41:24','ACTUALIZACION REGISTRO'),(215,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:36:17',0,0,'A','2018-02-14',1,NULL,'N','2018-02-19 10:37:56',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 15:37:56','ACTUALIZACION REGISTRO'),(216,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:31:16',0,0,'A','2018-02-14',1,NULL,'N','2018-02-19 10:38:16',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 15:38:16','ACTUALIZACION REGISTRO'),(217,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:31:16',0,0,'A','2018-02-14',2,NULL,'N','2018-02-19 10:41:58',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 15:41:58','ACTUALIZACION REGISTRO'),(218,98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:31:16',0,0,'B','2018-02-14',2,NULL,'N','2018-02-19 10:41:58',0,50,0,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 15:41:58','ACTUALIZACION REGISTRO'),(219,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-19 10:44:45',0,0,'A','2018-02-14',0,NULL,'N','2018-02-19 10:37:56',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 15:44:45','ACTUALIZACION REGISTRO'),(220,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','3K2QOSimrhTmqeT45p7gAw==','2018-02-19 11:26:48',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 08:06:43',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 16:26:48','ACTUALIZACION REGISTRO'),(221,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-19 12:43:17',0,0,'A','2018-02-14',0,NULL,'N','2018-02-19 10:37:56',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 17:43:17','ACTUALIZACION REGISTRO'),(222,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-19 13:38:44',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 18:38:44','ACTUALIZACION REGISTRO'),(223,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-19 13:55:43',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 18:55:43','ACTUALIZACION REGISTRO'),(224,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 12:40:16',0,0,'A','2018-02-13',1,NULL,'N','2018-02-19 18:22:22',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 23:22:22','ACTUALIZACION REGISTRO'),(225,108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-19 18:22:44',0,0,'A','2018-02-13',0,NULL,'N','2018-02-19 18:22:22',0,2,0,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-19 23:22:44','ACTUALIZACION REGISTRO'),(226,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-20 08:32:22',0,0,'A','2018-02-14',0,NULL,'N','2018-02-19 10:37:56',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 13:32:22','ACTUALIZACION REGISTRO'),(227,111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-20 10:30:50',0,0,'A','2018-02-15',0,NULL,'N','2018-02-16 10:33:18',0,29,0,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:30:50','ACTUALIZACION REGISTRO'),(228,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-20 08:32:22',0,0,'A','2018-02-14',1,NULL,'N','2018-02-20 10:41:46',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:41:46','ACTUALIZACION REGISTRO'),(229,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-20 10:42:05',0,0,'A','2018-02-14',0,NULL,'N','2018-02-20 10:41:46',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:42:05','ACTUALIZACION REGISTRO'),(230,102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','3K2QOSimrhTmqeT45p7gAw==','2018-02-20 10:43:18',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 08:06:43',0,10,0,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:43:18','ACTUALIZACION REGISTRO'),(231,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 11:25:28',0,0,'A','2018-02-16',1,NULL,'N','2018-02-20 10:47:18',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:47:18','ACTUALIZACION REGISTRO'),(232,117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',1,NULL,'N','2018-02-20 10:48:17',0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:48:17','ACTUALIZACION REGISTRO'),(233,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 11:25:28',0,0,'A','2018-02-16',2,NULL,'N','2018-02-20 10:51:43',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:51:43','ACTUALIZACION REGISTRO'),(234,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 11:25:28',0,0,'B','2018-02-16',2,NULL,'N','2018-02-20 10:51:43',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:51:43','ACTUALIZACION REGISTRO'),(235,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:18:23',0,0,'A','2018-02-13',1,NULL,'N','2018-02-20 10:52:06',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:52:06','ACTUALIZACION REGISTRO'),(236,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:18:23',0,0,'A','2018-02-13',2,NULL,'N','2018-02-20 10:52:47',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:52:47','ACTUALIZACION REGISTRO'),(237,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:18:23',0,0,'B','2018-02-13',2,NULL,'N','2018-02-20 10:52:47',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:52:47','ACTUALIZACION REGISTRO'),(238,117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',2,NULL,'N','2018-02-20 10:53:20',0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:53:20','ACTUALIZACION REGISTRO'),(239,117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'B','2018-02-13',2,NULL,'N','2018-02-20 10:53:20',0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:53:20','ACTUALIZACION REGISTRO'),(240,118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','pHSq05X7wezRDHVN73Dndg==','2018-02-20 10:57:56',0,0,'A','2018-02-16',0,NULL,'N','2018-02-19 09:04:32',0,18,0,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 15:57:56','ACTUALIZACION REGISTRO'),(241,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-20 11:01:40',0,0,'A','2018-02-14',0,NULL,'N','2018-02-20 10:41:46',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 16:01:40','ACTUALIZACION REGISTRO'),(242,119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-20 11:27:39',0,0,'A','2018-02-14',0,NULL,'N','2018-02-20 10:41:46',0,50,0,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 16:27:39','ACTUALIZACION REGISTRO'),(243,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-20 12:29:14',0,0,'A','2018-02-12',0,NULL,'N','2018-02-16 11:35:53',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:29:14','ACTUALIZACION REGISTRO'),(244,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 11:25:28',0,0,'A','2018-02-16',0,NULL,'N','2018-02-20 10:51:43',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:31:20','ACTUALIZACION REGISTRO'),(245,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','H/KDJt2g3iahBvRQBP/RyQ==','2018-02-16 11:25:28',0,0,'A','2018-02-20',0,NULL,'N','2018-02-20 10:51:43',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:31:20','ACTUALIZACION REGISTRO'),(246,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','H/KDJt2g3iahBvRQBP/RyQ==','2018-02-20 12:40:59',0,0,'A','2018-02-20',0,NULL,'N','2018-02-20 10:51:43',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:40:59','ACTUALIZACION REGISTRO'),(247,115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','lRAtqzTdE64m0tHQrjDKAg==','2018-02-20 12:40:59',0,0,'A','2018-02-20',0,NULL,'N','2018-02-20 10:51:43',0,18,0,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:41:39','ACTUALIZACION REGISTRO'),(248,116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:18:23',0,0,'A','2018-02-13',0,NULL,'N','2018-02-20 10:52:47',0,18,0,'1018001','root@localhost','2018-02-13 21:10:59','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:43:24','ACTUALIZACION REGISTRO'),(249,117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',0,NULL,'N','2018-02-20 10:53:20',0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 17:43:36','ACTUALIZACION REGISTRO'),(250,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-20 13:06:14',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 18:06:14','ACTUALIZACION REGISTRO'),(251,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-20 14:06:53',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 19:06:53','ACTUALIZACION REGISTRO'),(252,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-20 14:39:54',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-20 19:39:54','ACTUALIZACION REGISTRO'),(253,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','v0UPEpZo95OBGgxliW1neg==','2018-02-21 08:03:19',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 13:03:19','ACTUALIZACION REGISTRO'),(254,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','HYkU0Nl49Lld7SG99bIkDA==','2018-02-21 08:03:19',0,0,'A','2018-02-21',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 13:04:05','ACTUALIZACION REGISTRO'),(255,89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-21 08:20:29',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,0,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 13:20:29','ACTUALIZACION REGISTRO'),(256,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','HYkU0Nl49Lld7SG99bIkDA==','2018-02-21 09:09:34',0,0,'A','2018-02-21',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 14:09:34','ACTUALIZACION REGISTRO'),(257,6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','HYkU0Nl49Lld7SG99bIkDA==','2018-02-21 10:45:02',0,0,'A','2018-02-21',0,NULL,'N','2018-02-15 13:13:57',0,90,0,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 15:45:02','ACTUALIZACION REGISTRO'),(258,61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-21 15:49:41',0,0,'A','2018-02-12',0,NULL,'N','2018-02-16 11:35:53',0,90,0,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 20:49:41','ACTUALIZACION REGISTRO'),(259,1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','XOvhFRuFAS85b1XR5tbxWg==','2018-02-21 15:50:19',0,0,'A','2018-01-05',0,NULL,'N','2018-01-31 17:38:49',0,90,0,NULL,'root@localhost',NULL,NULL,'opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 20:50:19','ACTUALIZACION REGISTRO'),(260,1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','rOlPSvb6jr6aq/u3UruaPg==','2018-02-21 15:50:19',0,0,'A','2018-02-21',0,NULL,'N','2018-01-31 17:38:49',0,90,0,NULL,'root@localhost',NULL,NULL,'opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 20:50:42','ACTUALIZACION REGISTRO'),(261,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','',NULL,0,0,'A',NULL,0,NULL,'N',NULL,0,90,0,'admin','root@localhost','2018-02-21 21:00:56','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:00:56','INSERCION REGISTRO'),(262,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','xHGAZvHeOOOVI+Xrs2Q/eQ==',NULL,0,0,'A','2018-02-21',0,NULL,'N',NULL,0,90,0,'admin','root@localhost','2018-02-21 21:00:56','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:00:56','ACTUALIZACION REGISTRO'),(263,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','xHGAZvHeOOOVI+Xrs2Q/eQ==',NULL,0,0,'A','2018-02-21',1,NULL,'N','2018-02-21 16:01:26',0,90,0,'admin','root@localhost','2018-02-21 21:00:56','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:01:26','ACTUALIZACION REGISTRO'),(264,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','xHGAZvHeOOOVI+Xrs2Q/eQ==','2018-02-21 16:01:56',0,0,'A','2018-02-21',0,NULL,'N','2018-02-21 16:01:26',0,90,0,'admin','root@localhost','2018-02-21 21:00:56','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:01:56','ACTUALIZACION REGISTRO'),(265,120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','I3XwVL0mKprCBLQY2xnx1Q==','2018-02-21 16:01:56',0,0,'A','2018-02-21',0,NULL,'N','2018-02-21 16:01:26',0,90,0,'admin','root@localhost','2018-02-21 21:00:56','Ingreso Usuario - Inserción','opaunoapp@ip-192-168-70-35.ec2.internal','2018-02-21 21:02:39','ACTUALIZACION REGISTRO');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dm_reporteUsuario`
--

LOCK TABLES `dm_reporteUsuario` WRITE;
/*!40000 ALTER TABLE `dm_reporteUsuario` DISABLE KEYS */;
INSERT INTO `dm_reporteUsuario` VALUES (1,1,111,'2018-01-17'),(2,1,102,'2018-01-18'),(3,1,102,'2018-01-22'),(4,1,111,'2018-01-22'),(5,1,102,'2018-01-23'),(6,1,102,'2018-01-24'),(7,1,102,'2018-01-26'),(8,1,107,'2018-01-30'),(9,1,111,'2018-01-30'),(10,1,107,'2018-02-01'),(11,1,111,'2018-02-01'),(12,1,119,'2018-02-14'),(13,1,102,'2018-02-15'),(14,1,111,'2018-02-15'),(15,1,102,'2018-02-19'),(16,1,119,'2018-02-19'),(17,1,111,'2018-02-20'),(18,1,119,'2018-02-20'),(19,1,115,'2018-02-20');
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
INSERT INTO `dm_scb` VALUES (1,'890931609','9',4,'001','ADCAP COLOMBIA S.A.COMISIONISTA DE BOLSA','','Daniel Loaiza Arango','','3205940','','',11,1,0,'',' ',1,1,'71377882',0,'',0,''),(2,'860079174','3',4,'002','CORREDORES DAVIVIENDA S.A.COMISIONISTA DE BOLSA','','Alfonso Duran Villegas','Cra 7 No 71-52 Piso 16 Torre B','3123300','','',11,1,0,'Mauricio Garcia Osorio',' ',1,1,'79150142',1,'8041411',0,''),(3,'860051175','9',4,'003','AFIN S.A. COMISIONISTA DE BOLSA','','Arturo Mendez Vallejo','Cra 14b No 106-50','6372055','','',11,1,0,'',' ',1,1,'19230325',0,'',0,''),(4,'830035217','3',4,'004','ITAU COMISIONISTA DE BOLSA COLOMBIA S.A','','Felix Eduardo Buendia Anjel','Cra 7 No 27-18 Piso 13','3394540','','',11,1,0,'Jose Rafael Bernal Rodriguez','Hernando Herrera Umaña ',1,1,'80418248',1,'79521094',1,'79358316'),(5,'800096036','9',4,'005','BBVA VALORES COLOMBIA S.A. COMISIONISTA DE BOLSA - BBVA VALORES','','Juan Pablo Amorocho Gutierrez','','3077018','','',11,1,0,'Diana Paola Rueda Ortega','Willy Alexander Enciso Sabbagh ',1,1,'79555672',1,'53159592',1,'79686772'),(7,'860071562','1',4,'007','ACCIONES Y VALORES S.A. COMISIONISTAS DE BOLSA','','Juan Carlos Aparicio Escallon','','3257800','','',11,1,0,'',' ',1,1,'19380878',0,'',0,''),(10,'800128735','8',4,'010','VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','','Rupert James Stebbings','Medellin Cra 48 No 26-85 Av Industriales Torre Sur','4040000','','',11,1,0,'Jose Alberto Arango Espinosa','Andres Ochoa Franco ',1,2,'331307',1,'98547135',1,'98552709'),(13,'860079981','0',4,'013','VALORALTA S.A. COMISIONISTA DE BOLSA','','Juan Pablo Muñoz','','3138888','','',11,1,0,'',' ',1,1,'79155228',0,'',0,''),(18,'860000185','4',4,'018','ALIANZA VALORES COMISIONISTA DE BOLSA S.A','','José Ricardo Pérez Sandoval','','6447730','','',11,1,0,'José Tomas Abril',' ',1,1,'79691120',1,'19436955',0,''),(26,'800019807','2',4,'026','COMPAÑIA PROFESIONALES DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(29,'860068182','5',4,'029','CREDICORP CAPITAL COLOMBIA S.A.','','Ramon Eduardo Mendez Jimenez','Calle 34 No 6-65','3394400','','',11,1,0,'Pablo Ospina Sorzano','Andres Eduardo Venegas Ramirez ',1,1,'19429241',1,'80414647',1,'79943300'),(34,'860009934','5',4,'034','COMPASS GROUP S.A.COMISIONISTA DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(35,'800198073','1',4,'035','CITIVALORES S.A. COMISIONISTA DE BOLSA','','Diego Felipe Riveros Riveros','Cra 9 No 99-02 Piso 1 Mz','6394112','','',11,1,0,'Elizabeth Rey Diaz',' ',1,1,'79595341',1,'52868212',0,''),(37,'800120184','3',4,'037','ULTRASERFINCO S.A.','','Luis Fernando Barahona Sierra','Cra 49 No 52-61 Piso 9','0344443522','','',11,1,0,'Sara Matilde Pereira Fajardo',' ',1,1,'79723103',1,'52145602',0,''),(45,'800203186','5',4,'045','CASA DE BOLSA S.A. SOCIEDAD COMISIONISTA DE BOLSA','','Ricardo Herrera Castillo','Cra 7 No 33-42 Piso 9','6062100','','',11,1,0,'Angela Victoria Figueroa','Daniel Humberto Gomez Martinez ',1,1,'79505704',1,'39686161',1,'19194520'),(50,'890907157','0',4,'050','BTG PACTUAL S.A. COMISIONISTA DE BOLSA','','Mabel Moreno Ochoa','Medellin Cra 43A No 1-50 San Fernando Plaza Torr','0344484300','','',11,1,0,'Juliana Barrero Jaramillo',' ',1,1,'43740801',1,'39177249',0,''),(51,'800189604','2',4,'051','GLOBAL SECURITIES S.A. COMISIONISTA DE BOLSA','','Jose Daniel Acosta Portilla','Medellin Calle 7 sur No 42-70 Oficina 215','4447010','','',11,1,0,'André Kurt Schober Maya','Alejandro Cuervo Cardenas ',1,1,'79948871',1,'98552159',1,'79535259'),(56,'830118120','5',4,'056','SERVIVALORES GNB SUDAMERIS S.A. COMISIONISTA DE BOLSA','','Maria Eugenia Arbelaez Cifuentes','','31600000','','',11,1,0,'Maria Paula Villalba Agudelo',' ',1,1,'24575969',1,'52884216',0,''),(57,'830504700','2',4,'057','SCOTIA SECURITIES (COLOMBIA) S.A. SOCIEDAD COMISIONISTA DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(58,'900125656','3',4,'058','OLD MUTUAL VALORES S.A. SOCIEDAD COMISIONISTA DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(62,'900577140','4',4,'062','LARRAIN VIAL COLOMBIA S.A. COMISIONISTA DE BOLSA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(90,'8300854261','6',4,'090','BOLSA DE VALORES DE COLOMBIA','','Representante','','1234567','','',11,1,0,'','',1,2,'NoExiste',0,'',0,''),(987,'830085426','1',4,'987','Pruebas BVC como comisionista',NULL,'Myriam Robayo','Carrera 7 #71-21 Torre B Piso 12','3139800',NULL,NULL,0,0,NULL,'',' ',1,1,'51642094',0,'',0,''),(988,'830136799','1',4,'988','PRUEBA BIOMAX',NULL,'MYRIAM BIOMAX PRUEBA','','3139803',NULL,NULL,0,0,NULL,'','',1,1,'23456789',0,'',0,'');
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
  PRIMARY KEY (`EntidadDeNegociosID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_CrearAceptacion`
--

LOCK TABLES `fqs_CrearAceptacion` WRITE;
/*!40000 ALTER TABLE `fqs_CrearAceptacion` DISABLE KEYS */;
INSERT INTO `fqs_CrearAceptacion` VALUES (1,'ORDINARIAS','6561','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','VILLEGAS Y VILLEGAS IVEGAS LTDA',3581,'1',4,'860501968',4,'',598022,111,'2018-01-17 11:43:52',111,'2018-01-17 11:43:52','Ingresado',0.200,NULL,'mleon','root@localhost','2018-01-17 16:43:52','Ingreso Demanda - Inserción'),(2,'ORDINARIAS','8616','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','CREDICORP CAPITAL COLOMBIA',283,'1',4,'860068182',5,'',136,111,'2018-01-17 11:53:34',111,'2018-01-17 11:53:34','Ingresado',0.000,NULL,'mleon','root@localhost','2018-01-17 16:53:34','Ingreso Demanda - Inserción'),(3,'ORDINARIAS','10655','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','VARGAS CASTILLA VANESA',2028,'1',1,'1020767348',NULL,'',495270,111,'2018-01-17 12:51:16',111,'2018-01-17 12:51:16','Ingresado',0.000,NULL,'mleon','root@localhost','2018-01-17 17:51:16','Ingreso Demanda - Inserción'),(4,'ORDINARIAS','3406','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','VALENTINA  GOMEZ MINOTAS',165,'0',1,'1152189801',NULL,'',619598,102,'2018-01-18 10:40:14',102,'2018-02-20 10:44:09','Modificado',7.503,'','hitrespa','root@localhost','2018-01-18 15:40:14','Modificación Aceptación - Modificación'),(5,'ORDINARIAS','3413','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','MELISSA  GOMEZ MINOTAS',37,'0',1,'1036670986',NULL,'',619603,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo'),(6,'ORDINARIAS','3420','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','ANA MARIA MINOTAS MARTINEZ',37,'0',1,'43007152',NULL,'',322353,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo'),(7,'ORDINARIAS','3665','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','LUIS ALBERTO HERNANDEZ MORENO',1,'0',1,'1032385931',NULL,'',823463,102,'2018-01-18 10:40:14',102,'2018-01-18 10:40:14','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-18 15:40:14','Ingreso Demanda - Archivo'),(8,'ORDINARIAS','3874','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','PAULA ANDREA GOMEZ POSADA',185,'0',1,'43832451',NULL,'',599247,102,'2018-01-18 10:40:14',102,'2018-02-20 10:44:39','Modificado',6.692,'','hitrespa','root@localhost','2018-01-18 15:40:14','Modificación Aceptación - Modificación'),(9,'ORDINARIAS','5037','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','VALORES BANCOLOMBIA SA COMISIONISTAS DE BOLSA',30500,'0',4,'800128735',8,'',131,102,'2018-01-22 09:57:24',102,'2018-01-22 09:57:24','Ingresado',0.000,NULL,'hitrespa','root@localhost','2018-01-22 14:57:24','Ingreso Demanda - Archivo'),(10,'ORDINARIAS','5168','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','EDGAR ANDRES NARANJO HENAO',29,'0',1,'8013934',NULL,'',1105202,102,'2018-01-22 09:57:24',102,'2018-01-22 09:57:24','Ingresado',15.000,NULL,'hitrespa','root@localhost','2018-01-22 14:57:24','Ingreso Demanda - Archivo'),(11,'ORDINARIAS','19965','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','ZAPATA ARIAS LUIS FERNANDO',178,'1',1,'8292642',NULL,'',61355,111,'2018-01-22 12:17:25',111,'2018-01-22 12:17:25','Ingresado',0.300,NULL,'mleon','root@localhost','2018-01-22 17:17:25','Ingreso Demanda - Inserción'),(12,'ORDINARIAS','5665','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','ENGICO LTDA',6000,'0',4,'890924366',5,'',223869,102,'2018-01-23 11:13:48',102,'2018-01-23 11:13:48','Ingresado',0.300,NULL,'hitrespa','root@localhost','2018-01-23 16:13:48','Ingreso Demanda - Archivo'),(13,'ORDINARIAS','252','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,4,'ITAU COMISIONISTA DE BOLSA COLOMBIA S.A','Felix Eduardo Buendia Anjel','OLGA MATILDE VILLEGAS JARAMILLO ',1190,'0',1,'52621962',NULL,'',1216571,107,'2018-01-30 09:36:18',107,'2018-01-30 09:36:18','Ingresado',1.600,NULL,'1004002','root@localhost','2018-01-30 14:36:18','Ingreso Demanda - Inserción'),(14,'ORDINARIAS','29179','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','OSCAR VELASQUEZ Y CIA S EN C',370,'1',4,'860500220',1,'',539615,111,'2018-01-30 12:21:51',111,'2018-01-30 12:21:51','Ingresado',3.300,NULL,'mleon','root@localhost','2018-01-30 17:21:51','Ingreso Demanda - Inserción'),(15,'ORDINARIAS','4463','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','CORDOBA MUÑOZ RAMON ANTONIO',371,'0',1,'8347488',NULL,'',561537,119,'2018-02-14 10:59:59',119,'2018-02-14 10:59:59','Ingresado',1.541,NULL,'1050002','root@localhost','2018-02-14 15:59:59','Ingreso Demanda - Inserción'),(16,'ORDINARIAS','4465','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','VASCO ARANGO INES AMPARO DE LA MILAGROSA',4819,'0',1,'32341935',NULL,'',551470,119,'2018-02-14 11:03:02',119,'2018-02-14 11:03:02','Ingresado',0.300,NULL,'1050002','root@localhost','2018-02-14 16:03:02','Ingreso Demanda - Inserción'),(17,'ORDINARIAS','4507','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','SANCHEZ VASCO BETTY ',743,'0',1,'1152190643',NULL,'',1434803,119,'2018-02-14 11:04:44',119,'2018-02-14 11:04:44','Ingresado',0.770,NULL,'1050002','root@localhost','2018-02-14 16:04:44','Ingreso Demanda - Inserción'),(18,'ORDINARIAS','4535','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','VASCO  ANDRES MAURICIO',110,'0',1,'1036624445',NULL,'',1445238,119,'2018-02-14 11:07:48',119,'2018-02-14 11:07:48','Ingresado',5.200,NULL,'1050002','root@localhost','2018-02-14 16:07:48','Ingreso Demanda - Inserción'),(19,'ORDINARIAS','4536','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','DUQUE FLOREZ HAROL ALBERTO',70,'0',1,'79404727',NULL,'',583700,119,'2018-02-14 11:10:09',119,'2018-02-14 11:10:09','Ingresado',8.200,NULL,'1050002','root@localhost','2018-02-14 16:10:09','Ingreso Demanda - Inserción'),(20,'ORDINARIAS','47297','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','INGENIERIA DE VIAS SA',143002,'1',4,'800186228',2,'',557594,111,'2018-02-15 12:11:14',111,'2018-02-15 12:11:14','Ingresado',0.500,NULL,'mleon','root@localhost','2018-02-15 17:11:14','Ingreso Demanda - Inserción'),(21,'ORDINARIAS','1521','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','José Ricardo Pérez Sandoval','MARTHA LUCIA GUTIERREZ DE AZCARATE',687,'1',1,'29281308',NULL,'',1556925,118,'2018-02-19 09:09:11',118,'2018-02-19 09:09:11','Ingresado',2.080,NULL,'arrivera','root@localhost','2018-02-19 14:09:11','Ingreso Demanda - Inserción'),(22,'ORDINARIAS','1545','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','José Ricardo Pérez Sandoval','JULIANA AZCARATE GUTIERREZ',687,'1',1,'29111088',NULL,'',85407,118,'2018-02-19 09:11:05',118,'2018-02-19 09:11:05','Ingresado',2.080,NULL,'arrivera','root@localhost','2018-02-19 14:11:05','Ingreso Demanda - Inserción'),(23,'ORDINARIAS','48189','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','CONSTRUCTUCCIONES ARYS LTDA',2046,'1',4,'830117896',7,'',1475350,111,'2018-02-19 09:47:20',111,'2018-02-19 09:47:20','Ingresado',1.000,NULL,'mleon','root@localhost','2018-02-19 14:47:20','Ingreso Demanda - Inserción'),(24,'ORDINARIAS','18262','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,10,'VALORES BANCOLOMBIA S.A. COMISIONISTA DE BOLSA','Rupert James Stebbings','JOSE DAVID POSADA BOTERO',20000,'0',1,'71708034',NULL,'',17505,102,'2018-02-19 11:28:55',102,'2018-02-19 11:28:55','Ingresado',0.500,NULL,'hitrespa','root@localhost','2018-02-19 16:28:55','Ingreso Demanda - Archivo'),(25,'ORDINARIAS','5384','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','INVERSIONES Y VALORES SAS',137,'0',4,'900206752',0,'',1426278,119,'2018-02-19 12:49:55',119,'2018-02-19 12:51:01','Modificado',8.342,'','1050002','root@localhost','2018-02-19 17:49:55','Modificación Aceptación - Modificación'),(26,'ORDINARIAS','51632','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,29,'CREDICORP CAPITAL COLOMBIA S.A.','Ramon Eduardo Mendez Jimenez','PQUIM LTDA',55,'1',4,'800162553',8,'',703727,111,'2018-02-20 10:40:01',111,'2018-02-20 10:40:01','Ingresado',1.000,NULL,'mleon','root@localhost','2018-02-20 15:40:01','Ingreso Demanda - Inserción'),(27,'ORDINARIAS','1591','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,18,'ALIANZA VALORES COMISIONISTA DE BOLSA S.A','José Ricardo Pérez Sandoval','MANUEL ANTONIO LOPEZ BOTERO',4000,'1',1,'7531944',NULL,'',4840,118,'2018-02-20 11:00:02',118,'2018-02-20 11:00:02','Ingresado',1.000,NULL,'arrivera','root@localhost','2018-02-20 16:00:02','Ingreso Demanda - Inserción'),(28,'ORDINARIAS','5470','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','EMERGING MARKETS CORE EQUITY PORTFOLIO OF DFA INVE',5134,'0',4,'900540404',3,'',1796144,119,'2018-02-20 11:31:30',119,'2018-02-20 11:31:30','Ingresado',0.000,NULL,'1050002','root@localhost','2018-02-20 16:31:30','Ingreso Demanda - Inserción'),(29,'ORDINARIAS','5469','Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',NULL,50,'BTG PACTUAL S.A. COMISIONISTA DE BOLSA','Mabel Moreno Ochoa','THE EMERGING MARKETS SMALL CAP SERIES OF THE DFA',19092,'0',4,'900540407',5,'',1796146,119,'2018-02-20 11:34:39',119,'2018-02-20 11:34:39','Ingresado',NULL,NULL,'1050002','root@localhost','2018-02-20 16:34:39','Ingreso Demanda - Inserción');
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
) ENGINE=InnoDB AUTO_INCREMENT=482 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_IpAutorizada`
--

LOCK TABLES `fqs_IpAutorizada` WRITE;
/*!40000 ALTER TABLE `fqs_IpAutorizada` DISABLE KEYS */;
INSERT INTO `fqs_IpAutorizada` VALUES (1,1,'190.131.244.209',NULL,'root@localhost',NULL,NULL),(2,1,'127.0.0.1',NULL,'root@localhost',NULL,NULL),(28,14,'199.167.131.157','lmurillo','root@localhost','2017-01-24 00:46:03','Ingreso IP - Inserción'),(38,19,'201.221.124.8','1010001','root@localhost','2017-01-24 14:45:08','Ingreso IP - Inserción'),(40,21,'201.221.124.8','1010001','root@localhost','2017-01-24 14:58:52','Ingreso IP - Inserción'),(41,22,'201.221.124.8','1010001','root@localhost','2017-01-24 15:00:25','Ingreso IP - Inserción'),(42,23,'201.221.124.8','1010001','root@localhost','2017-01-24 15:01:41','Ingreso IP - Inserción'),(43,24,'200.14.232.217','lmurillo','root@localhost','2017-01-24 15:06:46','Ingreso IP - Inserción'),(44,24,'200.41.79.93','lmurillo','root@localhost','2017-01-24 15:06:46','Ingreso IP - Inserción'),(45,24,'200.41.79.94','lmurillo','root@localhost','2017-01-24 15:06:46','Ingreso IP - Inserción'),(46,25,'200.14.232.217','1045001','root@localhost','2017-01-24 15:43:12','Ingreso IP - Inserción'),(47,25,'200.41.79.93','1045001','root@localhost','2017-01-24 15:43:12','Ingreso IP - Inserción'),(48,25,'200.41.79.94','1045001','root@localhost','2017-01-24 15:43:12','Ingreso IP - Inserción'),(49,26,'200.14.232.217','1045001','root@localhost','2017-01-24 15:46:31','Ingreso IP - Inserción'),(50,26,'200.41.79.93','1045001','root@localhost','2017-01-24 15:46:31','Ingreso IP - Inserción'),(51,26,'200.41.79.94','1045001','root@localhost','2017-01-24 15:46:31','Ingreso IP - Inserción'),(52,27,'200.030.110.139','1004001','root@localhost','2017-01-24 18:10:27','Ingreso IP - Inserción'),(53,27,'172.23.22.111','1004001','root@localhost','2017-01-24 18:10:27','Ingreso IP - Inserción'),(55,28,'200.74.130.23','1037001','root@localhost','2017-01-24 20:19:52','Ingreso IP - Inserción'),(58,31,'181.143.34.114','1051001','root@localhost','2017-01-24 21:29:19','Ingreso IP - Inserción'),(65,9,'192.168.85.228','pruebasbvccomisionis','root@localhost','2017-01-24 22:03:00','Ingreso IP - Modificación'),(67,33,'200.030.110.139','1004001','root@localhost','2017-01-25 14:15:06','Ingreso IP - Inserción'),(68,33,'172.23.22.114','1004001','root@localhost','2017-01-25 14:15:06','Ingreso IP - Inserción'),(72,35,'190.131.201.70','1002001','root@localhost','2017-01-25 15:13:36','Ingreso IP - Inserción'),(73,35,'190.131.201.65','1002001','root@localhost','2017-01-25 15:13:36','Ingreso IP - Inserción'),(74,36,'190.131.201.70','1002001','root@localhost','2017-01-25 15:14:43','Ingreso IP - Inserción'),(75,36,'190.131.201.65','1002001','root@localhost','2017-01-25 15:14:43','Ingreso IP - Inserción'),(76,37,'199.167.131.157','1035001','root@localhost','2017-01-25 15:16:22','Ingreso IP - Inserción'),(77,38,'199.167.131.157','1035001','root@localhost','2017-01-25 15:18:17','Ingreso IP - Inserción'),(78,39,'199.167.131.157','1035001','root@localhost','2017-01-25 15:19:29','Ingreso IP - Inserción'),(82,41,'200.14.232.217','1045001','root@localhost','2017-01-26 13:06:10','Ingreso IP - Inserción'),(83,41,'200.41.79.93','1045001','root@localhost','2017-01-26 13:06:10','Ingreso IP - Inserción'),(84,41,'200.41.79.94','1045001','root@localhost','2017-01-26 13:06:10','Ingreso IP - Inserción'),(97,44,'200.14.232.217','1045001','root@localhost','2017-01-26 16:04:22','Ingreso IP - Modificación'),(98,44,'200.41.79.93','1045001','root@localhost','2017-01-26 16:04:22','Ingreso IP - Modificación'),(99,44,'200.41.79.94','1045001','root@localhost','2017-01-26 16:04:22','Ingreso IP - Modificación'),(100,45,'200.14.232.217','1045001','root@localhost','2017-01-26 16:04:36','Ingreso IP - Modificación'),(101,45,'200.41.79.93','1045001','root@localhost','2017-01-26 16:04:36','Ingreso IP - Modificación'),(102,45,'200.41.79.94','1045001','root@localhost','2017-01-26 16:04:36','Ingreso IP - Modificación'),(106,48,'190.131.240.114','1050001','root@localhost','2017-01-28 00:26:19','Ingreso IP - Inserción'),(109,50,'200.31.17.253','1056000','root@localhost','2017-01-30 16:24:27','Ingreso IP - Inserción'),(110,50,'190.25.232.76','1056000','root@localhost','2017-01-30 16:24:27','Ingreso IP - Inserción'),(113,51,'200.41.79.93','1045001','root@localhost','2017-01-30 16:35:59','Ingreso IP - Inserción'),(114,51,'200.41.79.94','1045001','root@localhost','2017-01-30 16:35:59','Ingreso IP - Inserción'),(115,51,'200.14.232.217','1045001','root@localhost','2017-01-30 16:35:59','Ingreso IP - Inserción'),(121,54,'10.208.7.19','1007000','root@localhost','2017-01-30 21:35:44','Ingreso IP - Inserción'),(122,54,'190.131.197.10','1007000','root@localhost','2017-01-30 21:35:44','Ingreso IP - Inserción'),(123,55,'10.192.7.55','1007000','root@localhost','2017-01-30 21:41:06','Ingreso IP - Inserción'),(124,55,'190.131.197.10','1007000','root@localhost','2017-01-30 21:41:06','Ingreso IP - Inserción'),(125,56,'10.192.7.66','1007000','root@localhost','2017-01-30 21:45:31','Ingreso IP - Inserción'),(126,56,'190.131.197.10','1007000','root@localhost','2017-01-30 21:45:31','Ingreso IP - Inserción'),(129,40,'200.14.232.217','1045001','root@localhost','2017-02-02 17:26:47','Ingreso IP - Modificación'),(130,40,'200.41.79.93','1045001','root@localhost','2017-02-02 17:26:47','Ingreso IP - Modificación'),(131,40,'200.41.79.94','1045001','root@localhost','2017-02-02 17:26:47','Ingreso IP - Modificación'),(132,42,'200.14.232.217','1045001','root@localhost','2017-02-02 17:26:59','Ingreso IP - Modificación'),(133,42,'200.41.79.93','1045001','root@localhost','2017-02-02 17:26:59','Ingreso IP - Modificación'),(134,42,'200.41.79.94','1045001','root@localhost','2017-02-02 17:26:59','Ingreso IP - Modificación'),(135,43,'200.14.232.217','1045001','root@localhost','2017-02-02 17:31:14','Ingreso IP - Modificación'),(136,43,'200.41.79.93','1045001','root@localhost','2017-02-02 17:31:14','Ingreso IP - Modificación'),(137,43,'200.41.79.94','1045001','root@localhost','2017-02-02 17:31:14','Ingreso IP - Modificación'),(138,58,'201.234.245.253','lmurillo','root@localhost','2017-02-08 13:59:48','Ingreso IP - Inserción'),(139,58,'85.255.167.151','lmurillo','root@localhost','2017-02-08 13:59:48','Ingreso IP - Inserción'),(140,58,'190.66.4.253','lmurillo','root@localhost','2017-02-08 13:59:48','Ingreso IP - Inserción'),(152,2,'200.1.81.99','ogomez','root@localhost','2017-02-14 18:41:50','Ingreso IP - Modificación'),(153,2,'190.131.244.209','ogomez','root@localhost','2017-02-14 18:41:50','Ingreso IP - Modificación'),(156,47,'190.131.240.114','1050001','root@localhost','2017-02-15 16:57:17','Ingreso IP - Modificación'),(159,62,'190.242.58.26','1018000','root@localhost','2017-02-16 14:32:18','Ingreso IP - Inserción'),(160,62,'190.242.36.50','1018000','root@localhost','2017-02-16 14:32:18','Ingreso IP - Inserción'),(161,63,'190.242.58.26','1018000','root@localhost','2017-02-16 14:33:31','Ingreso IP - Inserción'),(162,63,'190.242.36.50','1018000','root@localhost','2017-02-16 14:33:31','Ingreso IP - Inserción'),(177,32,'181.143.34.114','jsandoval','root@localhost','2017-02-20 17:17:53','Ingreso IP - Modificación'),(181,30,'181.143.34.114','1051001','root@localhost','2017-02-20 17:31:21','Ingreso IP - Modificación'),(182,64,'200.1.65.60','jsandoval','root@localhost','2017-02-21 14:18:13','Ingreso IP - Inserción'),(183,64,'10.1.2.60','jsandoval','root@localhost','2017-02-21 14:18:13','Ingreso IP - Inserción'),(184,64,'10.1.2.98','jsandoval','root@localhost','2017-02-21 14:18:13','Ingreso IP - Inserción'),(185,10,'186.28.228.162','ogomez','root@localhost','2017-02-21 15:27:51','Ingreso IP - Modificación'),(186,10,'186.28.228.163','ogomez','root@localhost','2017-02-21 15:27:51','Ingreso IP - Modificación'),(187,10,'190.131.250.74','ogomez','root@localhost','2017-02-21 15:27:51','Ingreso IP - Modificación'),(191,34,'186.28.228.162','1003001','root@localhost','2017-02-21 15:31:39','Ingreso IP - Modificación'),(192,34,'186.28.228.163','1003001','root@localhost','2017-02-21 15:31:39','Ingreso IP - Modificación'),(193,34,'190.131.250.74','1003001','root@localhost','2017-02-21 15:31:39','Ingreso IP - Modificación'),(215,65,'200.1.65.60','jsandoval','root@localhost','2017-02-21 17:59:08','Ingreso IP - Modificación'),(216,65,'10.1.2.60','jsandoval','root@localhost','2017-02-21 17:59:08','Ingreso IP - Modificación'),(217,65,'10.1.2.98','jsandoval','root@localhost','2017-02-21 17:59:08','Ingreso IP - Inserción'),(221,52,'200.41.79.93','1045001','root@localhost','2017-02-23 16:27:35','Ingreso IP - Modificación'),(222,52,'200.41.79.94','1045001','root@localhost','2017-02-23 16:27:35','Ingreso IP - Modificación'),(223,52,'200.14.232.217','1045001','root@localhost','2017-02-23 16:27:35','Ingreso IP - Modificación'),(227,18,'190.143.111.130','1029001','root@localhost','2017-02-28 12:57:07','Ingreso IP - Modificación'),(228,18,'201.245.161.224','1029001','root@localhost','2017-02-28 12:57:07','Ingreso IP - Modificación'),(229,18,'200.119.83.128','1029001','root@localhost','2017-02-28 12:57:07','Ingreso IP - Modificación'),(233,67,'190.131.245.92','jsandoval','root@localhost','2017-03-01 13:19:43','Ingreso IP - Modificación'),(234,67,'190.131.245.93','jsandoval','root@localhost','2017-03-01 13:19:43','Ingreso IP - Modificación'),(235,67,'190.131.245.97','jsandoval','root@localhost','2017-03-01 13:19:43','Ingreso IP - Modificación'),(236,68,'190.131.245.92','013000','root@localhost','2017-03-01 13:24:50','Ingreso IP - Inserción'),(237,68,'190.131.245.93','013000','root@localhost','2017-03-01 13:24:50','Ingreso IP - Inserción'),(238,68,'190.131.245.97','013000','root@localhost','2017-03-01 13:24:50','Ingreso IP - Inserción'),(241,49,'200.31.17.253','1056000','root@localhost','2017-03-01 18:39:43','Ingreso IP - Modificación'),(242,49,'190.25.232.76','1056000','root@localhost','2017-03-01 18:39:43','Ingreso IP - Modificación'),(243,59,'201.234.245.253','1005000','root@localhost','2017-03-03 14:36:09','Ingreso IP - Modificación'),(244,59,'82.255.167.151','1005000','root@localhost','2017-03-03 14:36:09','Ingreso IP - Modificación'),(245,59,'190.66.4.253','1005000','root@localhost','2017-03-03 14:36:09','Ingreso IP - Modificación'),(246,66,'200.1.65.60','001000','root@localhost','2017-03-06 14:17:31','Ingreso IP - Modificación'),(247,66,'10.1.2.60','001000','root@localhost','2017-03-06 14:17:31','Ingreso IP - Modificación'),(248,66,'10.1.2.98','001000','root@localhost','2017-03-06 14:17:31','Ingreso IP - Modificación'),(253,20,'201.221.124.8','1010001','root@localhost','2017-03-06 16:27:51','Ingreso IP - Modificación'),(255,3,'192.168.85.228','admin','root@localhost','2017-04-06 15:25:48','Ingreso IP - Modificación'),(256,3,'190.131.244.209','admin','root@localhost','2017-04-06 15:25:48','Ingreso IP - Modificación'),(262,4,'192.168.85.30','admin','root@localhost','2017-04-06 15:29:03','Ingreso IP - Modificación'),(263,4,'190.131.244.209','admin','root@localhost','2017-04-06 15:29:03','Ingreso IP - Modificación'),(264,5,'192.168.232.35','admin','root@localhost','2017-04-06 15:29:24','Ingreso IP - Modificación'),(265,5,'192.168.95.40','admin','root@localhost','2017-04-06 15:29:24','Ingreso IP - Modificación'),(266,5,'190.131.244.209','admin','root@localhost','2017-04-06 15:29:24','Ingreso IP - Modificación'),(284,8,'190.131.244.209','sbravo','root@localhost','2017-06-02 17:00:30','Ingreso IP - Modificación'),(285,70,'190.131.244.209','sbravo','root@localhost','2017-06-02 17:02:00','Ingreso IP - Modificación'),(286,71,'190.131.244.209','pruebasbvccomisionis','root@localhost','2017-06-02 17:10:02','Ingreso IP - Inserción'),(287,72,'190.131.244.209','pruebasbvcbiomax','root@localhost','2017-06-02 17:18:52','Ingreso IP - Inserción'),(293,15,'190.216.141.187','sbravo','root@localhost','2017-06-03 16:18:49','Ingreso IP - Modificación'),(294,46,'200.31.17.253','sbravo','root@localhost','2017-06-03 16:20:56','Ingreso IP - Modificación'),(295,46,'190.25.232.76','sbravo','root@localhost','2017-06-03 16:20:56','Ingreso IP - Modificación'),(296,53,'190.131.197.10','sbravo','root@localhost','2017-06-03 18:04:12','Ingreso IP - Modificación'),(297,53,'190.131.197.11','sbravo','root@localhost','2017-06-03 18:04:12','Ingreso IP - Modificación'),(298,57,'190.242.58.26','sbravo','root@localhost','2017-06-03 18:05:08','Ingreso IP - Modificación'),(299,57,'190.242.36.50','sbravo','root@localhost','2017-06-03 18:05:08','Ingreso IP - Modificación'),(300,73,'190.131.197.10','1007000','root@localhost','2017-06-05 12:59:40','Ingreso IP - Inserción'),(301,73,'10.208.7.19','1007000','root@localhost','2017-06-05 12:59:40','Ingreso IP - Inserción'),(302,74,'190.131.197.10','1007000','root@localhost','2017-06-05 13:15:55','Ingreso IP - Inserción'),(303,74,'10.192.7.55','1007000','root@localhost','2017-06-05 13:15:55','Ingreso IP - Inserción'),(304,75,'190.242.58.26','1018000','root@localhost','2017-06-05 13:32:59','Ingreso IP - Inserción'),(305,75,'190.242.36.50','1018000','root@localhost','2017-06-05 13:32:59','Ingreso IP - Inserción'),(306,76,'190.242.58.26','1018000','root@localhost','2017-06-05 13:35:29','Ingreso IP - Inserción'),(307,76,'190.242.36.50','1018000','root@localhost','2017-06-05 13:35:29','Ingreso IP - Inserción'),(309,78,'201.221.124.8','1010001','root@localhost','2017-06-05 14:10:57','Ingreso IP - Inserción'),(311,77,'201.221.124.8','1010001','root@localhost','2017-06-05 14:18:46','Ingreso IP - Modificación'),(312,80,'201.221.124.8','1010001','root@localhost','2017-06-05 14:22:21','Ingreso IP - Inserción'),(313,17,'181.143.34.114','sbravo','root@localhost','2017-06-05 14:22:24','Ingreso IP - Modificación'),(321,83,'200.31.17.253','1056000','root@localhost','2017-06-05 14:37:06','Ingreso IP - Inserción'),(322,83,'190.25.232.76','1056000','root@localhost','2017-06-05 14:37:06','Ingreso IP - Inserción'),(328,84,'181.143.34.114','1051001','root@localhost','2017-06-05 15:53:15','Ingreso IP - Inserción'),(329,85,'190.131.201.70','1002001','root@localhost','2017-06-05 16:37:24','Ingreso IP - Inserción'),(340,11,'172.23.32.107','sbravo','root@localhost','2017-06-05 16:53:00','Ingreso IP - Modificación'),(341,11,'192.168.89.86','sbravo','root@localhost','2017-06-05 16:53:00','Ingreso IP - Modificación'),(352,86,'200.30.110.139','sbravo','root@localhost','2017-06-05 17:05:21','Ingreso IP - Modificación'),(353,86,'172.23.32.107','sbravo','root@localhost','2017-06-05 17:05:21','Ingreso IP - Modificación'),(354,86,'190.66.2.204','sbravo','root@localhost','2017-06-05 17:05:21','Ingreso IP - Modificación'),(355,87,'200.030.110.139','1004000','root@localhost','2017-06-05 17:09:03','Ingreso IP - Inserción'),(356,87,'172.23.22.111','1004000','root@localhost','2017-06-05 17:09:03','Ingreso IP - Inserción'),(357,87,'190.66.2.204','1004000','root@localhost','2017-06-05 17:09:03','Ingreso IP - Inserción'),(360,7,'192.168.95.121','sbravo','root@localhost','2017-06-05 22:16:28','Ingreso IP - Modificación'),(361,7,'190.131.244.209','sbravo','root@localhost','2017-06-05 22:16:28','Ingreso IP - Modificación'),(362,82,'200.31.17.253','1056000','root@localhost','2017-06-06 15:22:59','Ingreso IP - Modificación'),(363,82,'190.25.232.76','1056000','root@localhost','2017-06-06 15:22:59','Ingreso IP - Modificación'),(365,16,'190.131.240.114','jsandoval','root@localhost','2017-06-07 14:02:28','Ingreso IP - Modificación'),(366,16,'190.216.157.114','jsandoval','root@localhost','2017-06-07 14:02:28','Ingreso IP - Modificación'),(367,88,'190.131.240.114','1050001','root@localhost','2017-06-07 14:07:23','Ingreso IP - Inserción'),(368,81,'201.221.124.8','1010001','root@localhost','2017-06-09 12:29:49','Ingreso IP - Modificación'),(369,89,'192.168.85.30','sbravo','root@localhost','2017-06-09 17:07:52','Ingreso IP - Inserción'),(370,89,'190.131.244.209','sbravo','root@localhost','2017-06-09 17:07:52','Ingreso IP - Inserción'),(371,13,'190.143.111.130','sbravo','root@localhost','2017-06-13 15:27:21','Ingreso IP - Modificación'),(372,13,'201.245.161.224','sbravo','root@localhost','2017-06-13 15:27:21','Ingreso IP - Modificación'),(373,13,'200.119.83.128','sbravo','root@localhost','2017-06-13 15:27:21','Ingreso IP - Modificación'),(374,90,'190.143.111.130','1029001','root@localhost','2017-06-13 15:45:32','Ingreso IP - Inserción'),(381,12,'201.221.124.8','jsandoval','root@localhost','2017-06-16 17:28:22','Ingreso IP - Modificación'),(383,29,'190.131.201.70','sbravo','root@localhost','2017-06-16 17:31:03','Ingreso IP - Modificación'),(384,79,'201.221.124.8','1010001','root@localhost','2017-06-20 22:00:22','Ingreso IP - Modificación'),(387,91,'190.131.244.209','ogomez','root@localhost','2018-01-03 20:20:32','Ingreso IP - Inserción'),(388,92,'190.131.244.209','ogomez','root@localhost','2018-01-03 20:23:18','Ingreso IP - Inserción'),(393,93,'192.168.232.1','lnavarropru','root@localhost','2018-01-04 19:07:43','Ingreso IP - Modificación'),(394,93,'192.168.95.96','lnavarropru','root@localhost','2018-01-04 19:07:43','Ingreso IP - Modificación'),(395,93,'190.131.244.209','lnavarropru','root@localhost','2018-01-04 19:07:43','Ingreso IP - Modificación'),(396,94,'190.131.244.209','lnavarropru2','root@localhost','2018-01-04 19:36:35','Ingreso IP - Modificación'),(399,95,'190.131.244.209','lnavarropru2','root@localhost','2018-01-04 21:35:52','Ingreso IP - Modificación'),(406,61,'192.168.85.204','admin','root@localhost','2018-01-05 17:07:55','Ingreso IP - Modificación'),(407,61,'192.168.232.170','admin','root@localhost','2018-01-05 17:07:55','Ingreso IP - Modificación'),(408,61,'190.131.244.209','admin','root@localhost','2018-01-05 17:07:55','Ingreso IP - Modificación'),(409,69,'0.0.0.0','admin','root@localhost','2018-01-05 17:09:54','Ingreso IP - Modificación'),(410,60,'192.168.89.86','ogomez','root@localhost','2018-01-09 15:44:09','Ingreso IP - Modificación'),(411,60,'190.131.244.209','ogomez','root@localhost','2018-01-09 15:44:09','Ingreso IP - Modificación'),(415,97,'201.221.124.8','ogomez','root@localhost','2018-01-09 16:13:10','Ingreso IP - Inserción'),(417,99,'181.143.34.114','ogomez','root@localhost','2018-01-09 16:17:37','Ingreso IP - Inserción'),(418,99,'181.143.34.115','ogomez','root@localhost','2018-01-09 16:17:37','Ingreso IP - Inserción'),(419,99,'181.143.34.116','ogomez','root@localhost','2018-01-09 16:17:37','Ingreso IP - Inserción'),(420,100,'181.143.34.114','1051000','root@localhost','2018-01-09 17:26:22','Ingreso IP - Inserción'),(421,100,'181.143.34.115','1051000','root@localhost','2018-01-09 17:26:22','Ingreso IP - Inserción'),(422,100,'181.143.34.116','1051000','root@localhost','2018-01-09 17:26:22','Ingreso IP - Inserción'),(423,101,'201.221.124.8','1010001','root@localhost','2018-01-09 18:46:04','Ingreso IP - Inserción'),(424,102,'201.221.124.8','1010001','root@localhost','2018-01-09 18:48:13','Ingreso IP - Inserción'),(425,103,'201.221.124.8','1010001','root@localhost','2018-01-09 18:49:39','Ingreso IP - Inserción'),(426,104,'201.221.124.8','1010001','root@localhost','2018-01-09 18:51:02','Ingreso IP - Inserción'),(427,105,'201.221.124.8','1010001','root@localhost','2018-01-09 18:52:25','Ingreso IP - Inserción'),(428,106,'201.221.124.8','1010001','root@localhost','2018-01-09 19:01:30','Ingreso IP - Inserción'),(429,96,'200.030.110.139','ogomez','root@localhost','2018-01-09 19:28:03','Ingreso IP - Modificación'),(430,96,'190.66.2.204','ogomez','root@localhost','2018-01-09 19:28:03','Ingreso IP - Modificación'),(434,107,'200.030.110.139','1004001','root@localhost','2018-01-10 16:01:04','Ingreso IP - Modificación'),(435,107,'190.66.2.204','1004001','root@localhost','2018-01-10 16:01:04','Ingreso IP - Modificación'),(436,107,'172.23.22.111','1004001','root@localhost','2018-01-10 16:01:04','Ingreso IP - Modificación'),(437,6,'192.168.88.5','ogomez','root@localhost','2018-01-11 22:59:37','Ingreso IP - Modificación'),(438,6,'190.131.244.209','ogomez','root@localhost','2018-01-11 22:59:37','Ingreso IP - Modificación'),(443,110,'190.143.111.130','1029001','root@localhost','2018-01-12 19:56:27','Ingreso IP - Inserción'),(444,110,'201.245.161.224','1029001','root@localhost','2018-01-12 19:56:27','Ingreso IP - Inserción'),(445,110,'200.119.83.128','1029001','root@localhost','2018-01-12 19:56:27','Ingreso IP - Inserción'),(449,112,'190.143.111.130','1029001','root@localhost','2018-01-12 20:07:33','Ingreso IP - Inserción'),(450,112,'201.245.161.224','1029001','root@localhost','2018-01-12 20:07:33','Ingreso IP - Inserción'),(451,112,'200.119.83.128','1029001','root@localhost','2018-01-12 20:07:33','Ingreso IP - Inserción'),(452,98,'190.131.240.114','ogomez','root@localhost','2018-01-17 23:14:48','Ingreso IP - Modificación'),(454,108,'190.131.201.70','ogomez','root@localhost','2018-02-13 17:38:46','Ingreso IP - Modificación'),(455,113,'190.131.201.70','1002001','root@localhost','2018-02-13 18:00:34','Ingreso IP - Inserción'),(456,114,'190.131.201.70','1002001','root@localhost','2018-02-13 18:04:32','Ingreso IP - Inserción'),(461,119,'190.131.240.114','1050001','root@localhost','2018-02-14 15:35:41','Ingreso IP - Inserción'),(465,109,'190.143.111.130','ogomez','root@localhost','2018-02-15 16:27:00','Ingreso IP - Modificación'),(466,109,'201.245.161.224','ogomez','root@localhost','2018-02-15 16:27:00','Ingreso IP - Modificación'),(467,109,'200.119.83.128','ogomez','root@localhost','2018-02-15 16:27:00','Ingreso IP - Modificación'),(471,118,'190.131.244.230','1018001','root@localhost','2018-02-16 16:25:47','Ingreso IP - Modificación'),(473,111,'190.143.111.130','1029001','root@localhost','2018-02-19 14:25:11','Ingreso IP - Modificación'),(474,111,'201.245.161.224','1029001','root@localhost','2018-02-19 14:25:11','Ingreso IP - Modificación'),(475,111,'200.119.83.128','1029001','root@localhost','2018-02-19 14:25:11','Ingreso IP - Modificación'),(476,115,'190.242.36.50','ogomez','root@localhost','2018-02-20 17:31:20','Ingreso IP - Modificación'),(477,116,'190.242.36.50','1018001','root@localhost','2018-02-20 17:43:24','Ingreso IP - Modificación'),(478,117,'190.242.36.50','1018001','root@localhost','2018-02-20 17:43:36','Ingreso IP - Modificación'),(479,120,'192.168.85.204','admin','root@localhost','2018-02-21 21:00:56','Ingreso IP - Inserción'),(480,120,'192.168.232.170','admin','root@localhost','2018-02-21 21:00:56','Ingreso IP - Inserción'),(481,120,'190.131.244.209','admin','root@localhost','2018-02-21 21:00:56','Ingreso IP - Inserción');
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
  `Accionesnegociadas` varchar(20) DEFAULT NULL,
  `TxtBoletinInformativo` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`EntidadDeNegociosID`),
  UNIQUE KEY `Uk_Parametrizacion` (`UsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='-- =============================================\nAuthor: Leonard Willian Prens Herrera\nCreate date: 15-02-2016\nDescription: Tabla Diccionario Parametrizacion de los usuarios.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_Parametrizacion`
--

LOCK TABLES `fqs_Parametrizacion` WRITE;
/*!40000 ALTER TABLE `fqs_Parametrizacion` DISABLE KEYS */;
INSERT INTO `fqs_Parametrizacion` VALUES (1,6,'2018-01-10','09:00:00','2018-02-20','12:59:59',1,575361,'GRUPO ARGOS S.A.',10500.00,1,'Por cuenta del (los) comitente(s), por medio del siguiente formulario electrónico presentamos OFERTA DE VENTA de Acciones Ordinarias en circulación de la Sociedad ODINSA S.A. que han sido ofrecidas en compra por parte de GRUPO ARGOS S.A. ., de conformidad con el Aviso de Oferta Pública de Adquisición, el Reglamento, la Circular Única de la Bolsa y en las demás normas que tanto nuestra firma comisionista como nuestro(s) comitente(s) declara(mos) conocer y me (nos) obligo(amos) a cumplir.','CON LA SUSCRIPCIÓN DE ESTE FORMULARIO ELECTRÓNICO EXPRESAMENTE ACEPTAMOS QUE EN LA HIPÓTESIS DE QUE SE PRESENTE UNA OFERTA QUE MEJORE LAS CONDICIONES DE LA OFERTA QUE SE RESPONDE CON ESTE FORMULARIO ELECTRÓNICO, LA PRESENTE ACEPTACIÓN SE ENTENDERÁ REVOCADA Y AL MISMO TIEMPO ENTENDEREMOS ACEPTADA LA OFERTA QUE OFREZCA LAS MEJORES CONDICIONES.',2,3,'ODINSA','ORDINARIAS',10,6,'2018-01-10 08:59:15',6,'2018-01-10 09:00:53',1,1,4,'890900266','3','',18336,50,'lnavarro','root@localhost','2018-01-10 14:00:53','Actualizar Parametro - Actualización','09:00:00','11:59:59','ODINSA S.A.','Con fundamento en lo establecido en el artículo 6.15.2.1.20 del decreto 2555 del 2010 y el artículo 3.3.3.11 del Reglamento General de la Bolsa de Valores de Colombia, se suministra al mercado la siguiente información para el día de hoy, en relación con la OPA sobre acciones ordinarias de ODINSA S.A.., en la cual se ofrece adquirir como mínimo una (1) acción ordinaria y como máximo quinientas setenta y cinco mil trescientas sesenta y un (575.361)  acciones ordinarias.');
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
) ENGINE=InnoDB AUTO_INCREMENT=1836 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_adjudicacion`
--

LOCK TABLES `fqs_adjudicacion` WRITE;
/*!40000 ALTER TABLE `fqs_adjudicacion` DISABLE KEYS */;
INSERT INTO `fqs_adjudicacion` VALUES (1807,3,2028,10500.00,21294000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1808,4,165,10500.00,1732500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1809,5,37,10500.00,388500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1810,6,37,10500.00,388500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1811,7,1,10500.00,10500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1812,8,185,10500.00,1942500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1813,10,29,10500.00,304500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1814,11,178,10500.00,1869000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1815,13,1190,10500.00,12495000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1816,15,371,10500.00,3895500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1817,16,4819,10500.00,50599500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1818,17,743,10500.00,7801500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1819,18,110,10500.00,1155000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1820,19,70,10500.00,735000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1821,21,687,10500.00,7213500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1822,22,687,10500.00,7213500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1823,24,20000,10500.00,210000000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1824,27,4000,10500.00,42000000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1825,1,3581,10500.00,37600500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1826,2,283,10500.00,2971500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1827,9,30500,10500.00,320250000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1828,12,6000,10500.00,63000000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1829,14,370,10500.00,3885000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1830,20,143002,10500.00,1501521000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1831,23,2046,10500.00,21483000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1832,25,137,10500.00,1438500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1833,26,55,10500.00,577500.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1834,28,5134,10500.00,53907000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción'),(1835,29,19092,10500.00,200466000.00,'Adjudicado','lnavarro','root@localhost','2018-02-21 14:13:38','Ingreso Adjudicaión - Inserción');
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
) ENGINE=MyISAM AUTO_INCREMENT=261 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_auditoria`
--

LOCK TABLES `fqs_auditoria` WRITE;
/*!40000 ALTER TABLE `fqs_auditoria` DISABLE KEYS */;
INSERT INTO `fqs_auditoria` VALUES (1,'2018-01-10 09:00:55',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(2,'2018-01-10 10:57:29',96,'190.66.2.204','Inicio de sesión','Exitoso'),(3,'2018-01-10 11:01:20',96,'190.66.2.204','Fin de sesión usuario','Exitoso'),(4,'2018-01-10 11:40:17',107,'190.66.2.204','Inicio de sesión','Exitoso'),(5,'2018-01-10 13:22:08',6,'190.131.244.209','Inicio de sesión','Exitoso'),(6,'2018-01-11 12:00:41',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(7,'2018-01-11 12:00:52',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(8,'2018-01-11 13:50:58',6,'190.131.244.209','Inicio de sesión','Usuario Bloqueado'),(9,'2018-01-11 13:56:31',89,'190.131.244.209','Inicio de sesión','Exitoso'),(10,'2018-01-11 14:13:47',89,'190.131.244.209','Fin de sesión usuario','Exitoso'),(11,'2018-01-11 14:17:46',89,'190.131.244.209','Inicio de sesión','Exitoso'),(12,'2018-01-11 17:58:46',61,'190.131.244.209','Inicio de sesión','Exitoso'),(13,'2018-01-11 18:28:22',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(14,'2018-01-11 18:55:51',108,'190.131.201.70','Inicio de sesión','Exitoso'),(15,'2018-01-12 07:03:24',109,'190.143.111.130','Inicio de sesión','Exitoso'),(16,'2018-01-12 07:06:00',109,'190.143.111.130','Fin de sesión usuario','Exitoso'),(17,'2018-01-12 14:48:35',109,'190.143.111.130','Inicio de sesión','Exitoso'),(18,'2018-01-12 15:01:05',6,'190.131.244.209','Inicio de sesión','Exitoso'),(19,'2018-01-12 15:08:28',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(20,'2018-01-12 15:09:15',109,'190.143.111.130','Fin de sesión usuario','Exitoso'),(21,'2018-01-12 15:09:49',112,'190.143.111.130','Inicio de sesión','Exitoso'),(22,'2018-01-12 15:13:03',89,'190.131.244.209','Inicio de sesión','Exitoso'),(23,'2018-01-12 15:41:13',111,'190.143.111.130','Inicio de sesión','Exitoso'),(24,'2018-01-12 15:48:33',111,'190.143.111.130','Fin de sesión usuario','Exitoso'),(25,'2018-01-15 14:10:54',6,'190.131.244.209','Inicio de sesión','Exitoso'),(26,'2018-01-15 14:36:49',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(27,'2018-01-15 15:26:55',98,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(28,'2018-01-15 15:27:46',98,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(29,'2018-01-16 13:59:16',6,'190.131.244.209','Inicio de sesión','Exitoso'),(30,'2018-01-16 14:27:24',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(31,'2018-01-16 14:54:42',109,'200.119.83.130','Intento fallido de acceso al sistema','Fallido'),(32,'2018-01-16 15:51:05',111,'190.143.111.130','Inicio de sesión','Exitoso'),(33,'2018-01-17 08:26:40',111,'190.143.111.130','Inicio de sesión','Exitoso'),(34,'2018-01-17 09:12:52',111,'190.143.111.130','Inicio de sesión','Exitoso'),(35,'2018-01-17 10:11:56',111,'190.143.111.130','Inicio de sesión','Exitoso'),(36,'2018-01-17 12:38:24',6,'190.131.244.209','Inicio de sesión','Exitoso'),(37,'2018-01-17 13:07:45',111,'190.143.111.130','Fin de sesión usuario','Exitoso'),(38,'2018-01-17 13:47:27',6,'190.131.244.209','Inicio de sesión','Exitoso'),(39,'2018-01-17 14:06:25',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(40,'2018-01-17 14:06:31',89,'190.131.244.209','Inicio de sesión','Exitoso'),(41,'2018-01-17 14:10:20',6,'190.131.244.209','Inicio de sesión','Exitoso'),(42,'2018-01-17 18:14:05',61,'190.131.244.209','Inicio de sesión','Exitoso'),(43,'2018-01-17 18:17:32',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(44,'2018-01-18 10:38:59',102,'201.221.124.8','Inicio de sesión','Exitoso'),(45,'2018-01-18 13:37:07',6,'190.131.244.209','Inicio de sesión','Exitoso'),(46,'2018-01-18 14:43:15',89,'190.131.244.209','Inicio de sesión','Exitoso'),(47,'2018-01-18 14:52:52',6,'190.131.244.209','Inicio de sesión','Exitoso'),(48,'2018-01-18 14:56:18',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(49,'2018-01-19 12:04:54',102,'201.221.124.8','Inicio de sesión','Exitoso'),(50,'2018-01-19 12:12:08',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(51,'2018-01-19 13:31:37',6,'190.131.244.209','Inicio de sesión','Exitoso'),(52,'2018-01-19 14:33:41',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(53,'2018-01-22 09:34:12',102,'201.221.124.8','Inicio de sesión','Exitoso'),(54,'2018-01-22 10:10:21',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(55,'2018-01-22 11:17:19',102,'201.221.124.8','Inicio de sesión','Exitoso'),(56,'2018-01-22 11:18:31',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(57,'2018-01-22 12:07:51',111,'190.143.111.130','Inicio de sesión','Exitoso'),(58,'2018-01-22 13:57:49',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(59,'2018-01-22 13:58:03',6,'190.131.244.209','Inicio de sesión','Exitoso'),(60,'2018-01-22 14:12:51',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(61,'2018-01-22 15:50:16',6,'190.131.244.209','Inicio de sesión','Exitoso'),(62,'2018-01-22 15:52:06',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(63,'2018-01-23 08:43:22',103,'201.221.124.8','Inicio de sesión','Exitoso'),(64,'2018-01-23 10:25:55',102,'201.221.124.8','Inicio de sesión','Exitoso'),(65,'2018-01-23 10:51:26',103,'201.221.124.8','Inicio de sesión','Exitoso'),(66,'2018-01-23 11:09:46',6,'190.131.244.209','Inicio de sesión','Exitoso'),(67,'2018-01-23 11:10:35',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(68,'2018-01-23 12:53:06',102,'201.221.124.8','Inicio de sesión','Exitoso'),(69,'2018-01-23 13:59:49',102,'201.221.124.8','Inicio de sesión','Exitoso'),(70,'2018-01-23 14:04:11',6,'190.131.244.209','Inicio de sesión','Exitoso'),(71,'2018-01-23 14:59:27',89,'190.131.244.209','Inicio de sesión','Exitoso'),(72,'2018-01-23 15:40:12',6,'190.131.244.209','Inicio de sesión','Exitoso'),(73,'2018-01-23 15:47:24',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(74,'2018-01-24 12:30:27',102,'201.221.124.8','Inicio de sesión','Exitoso'),(75,'2018-01-24 12:31:57',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(76,'2018-01-24 13:13:09',89,'190.131.244.209','Inicio de sesión','Exitoso'),(77,'2018-01-24 14:04:40',3,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(78,'2018-01-24 14:06:18',3,'190.131.244.209','Inicio de sesión','Exitoso'),(79,'2018-01-24 14:07:44',3,'190.131.244.209','Fin de sesión usuario','Exitoso'),(80,'2018-01-24 14:58:07',89,'190.131.244.209','Inicio de sesión','Exitoso'),(81,'2018-01-25 13:21:16',89,'190.131.244.209','Inicio de sesión','Exitoso'),(82,'2018-01-25 14:18:57',3,'190.131.244.209','Inicio de sesión','Exitoso'),(83,'2018-01-25 14:19:30',3,'190.131.244.209','Fin de sesión usuario','Exitoso'),(84,'2018-01-25 14:51:31',89,'190.131.244.209','Inicio de sesión','Exitoso'),(85,'2018-01-25 15:11:17',111,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(86,'2018-01-26 11:02:26',102,'201.221.124.8','Inicio de sesión','Exitoso'),(87,'2018-01-26 11:53:03',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(88,'2018-01-26 13:47:55',89,'190.131.244.209','Inicio de sesión','Exitoso'),(89,'2018-01-26 14:15:17',3,'190.131.244.209','Inicio de sesión','Exitoso'),(90,'2018-01-26 14:15:32',3,'190.131.244.209','Fin de sesión usuario','Exitoso'),(91,'2018-01-29 14:13:59',6,'190.131.244.209','Inicio de sesión','Exitoso'),(92,'2018-01-30 08:16:18',107,'190.66.2.204','Intento fallido de acceso al sistema','Fallido'),(93,'2018-01-30 08:17:03',107,'190.66.2.204','Inicio de sesión','Exitoso'),(94,'2018-01-30 09:32:41',107,'190.66.2.204','Inicio de sesión','Exitoso'),(95,'2018-01-30 12:10:50',111,'190.143.111.130','Inicio de sesión','Exitoso'),(96,'2018-01-30 13:40:33',6,'190.131.244.209','Inicio de sesión','Exitoso'),(97,'2018-01-30 14:05:36',89,'190.131.244.209','Inicio de sesión','Exitoso'),(98,'2018-01-30 14:40:33',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(99,'2018-01-31 13:09:54',6,'190.131.244.209','Inicio de sesión','Exitoso'),(100,'2018-01-31 17:38:49',1,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(101,'2018-02-01 08:48:45',102,'201.221.124.8','Inicio de sesión','Exitoso'),(102,'2018-02-01 09:18:36',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(103,'2018-02-01 10:37:57',107,'190.66.2.204','Intento fallido de acceso al sistema','Fallido'),(104,'2018-02-01 10:38:49',107,'190.66.2.204','Inicio de sesión','Exitoso'),(105,'2018-02-01 13:50:34',6,'190.131.244.209','Inicio de sesión','Exitoso'),(106,'2018-02-01 17:58:37',111,'190.143.111.130','Inicio de sesión','Exitoso'),(107,'2018-02-01 18:03:44',111,'190.143.111.130','Fin de sesión usuario','Exitoso'),(108,'2018-02-02 13:19:23',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(109,'2018-02-02 13:19:51',6,'190.131.244.209','Inicio de sesión','Exitoso'),(110,'2018-02-05 13:34:50',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(111,'2018-02-05 13:35:13',6,'190.131.244.209','Inicio de sesión','Exitoso'),(112,'2018-02-06 13:21:09',6,'190.131.244.209','Inicio de sesión','Exitoso'),(113,'2018-02-07 13:25:15',6,'190.131.244.209','Inicio de sesión','Exitoso'),(114,'2018-02-07 13:58:41',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(115,'2018-02-07 13:59:53',89,'190.131.244.209','Inicio de sesión','Exitoso'),(116,'2018-02-07 14:15:55',6,'190.131.244.209','Inicio de sesión','Exitoso'),(117,'2018-02-07 14:17:45',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(118,'2018-02-08 13:15:54',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(119,'2018-02-08 13:16:29',6,'190.131.244.209','Inicio de sesión','Exitoso'),(120,'2018-02-08 14:23:38',6,'190.131.244.209','Inicio de sesión','Exitoso'),(121,'2018-02-08 14:49:54',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(122,'2018-02-08 14:54:02',89,'190.131.244.209','Inicio de sesión','Exitoso'),(123,'2018-02-09 13:41:06',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(124,'2018-02-09 13:41:37',6,'190.131.244.209','Inicio de sesión','Exitoso'),(125,'2018-02-09 14:00:39',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(126,'2018-02-09 16:52:37',108,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(127,'2018-02-09 16:52:37',108,'190.131.201.70','Intento fallido de acceso al sistema','Captcha inválido'),(128,'2018-02-09 16:55:24',108,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(129,'2018-02-09 16:59:13',108,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(130,'2018-02-12 13:51:07',6,'190.131.244.209','Inicio de sesión','Exitoso'),(131,'2018-02-12 22:55:55',61,'190.131.244.209','Inicio de sesión','Exitoso'),(132,'2018-02-12 23:04:56',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(133,'2018-02-13 10:17:39',108,'190.131.201.70','Inicio de sesión','Exitoso'),(134,'2018-02-13 12:31:54',108,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(135,'2018-02-13 12:32:30',108,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(136,'2018-02-13 12:32:50',108,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(137,'2018-02-13 12:34:01',108,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(138,'2018-02-13 12:34:19',108,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(139,'2018-02-13 12:36:04',108,'190.131.201.70','Inicio de sesión','Usuario Bloqueado'),(140,'2018-02-13 12:38:16',61,'190.131.244.209','Inicio de sesión','Exitoso'),(141,'2018-02-13 12:40:16',108,'190.131.201.70','Inicio de sesión','Exitoso'),(142,'2018-02-13 13:07:20',108,'190.131.201.70','Fin de sesión usuario','Exitoso'),(143,'2018-02-13 13:47:29',6,'190.131.244.209','Inicio de sesión','Exitoso'),(144,'2018-02-13 13:56:29',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(145,'2018-02-13 14:27:40',89,'190.131.244.209','Inicio de sesión','Exitoso'),(146,'2018-02-13 14:46:35',61,'190.131.244.209','Inicio de sesión','Exitoso'),(147,'2018-02-13 15:01:49',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(148,'2018-02-13 16:07:19',115,'190.242.36.50','Inicio de sesión','Exitoso'),(149,'2018-02-13 16:17:03',115,'190.242.36.50','Fin de sesión usuario','Exitoso'),(150,'2018-02-13 16:17:27',116,'190.242.36.50','Intento fallido de acceso al sistema','Fallido'),(151,'2018-02-13 16:18:23',116,'190.242.36.50','Inicio de sesión','Exitoso'),(152,'2018-02-13 16:19:44',116,'190.242.36.50','Fin de sesión usuario','Exitoso'),(153,'2018-02-14 10:31:05',61,'190.131.244.209','Inicio de sesión','Exitoso'),(154,'2018-02-14 10:31:16',98,'190.131.240.114','Inicio de sesión','Exitoso'),(155,'2018-02-14 10:31:24',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(156,'2018-02-14 10:35:48',98,'190.131.240.114','Fin de sesión usuario','Exitoso'),(157,'2018-02-14 10:36:00',119,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(158,'2018-02-14 10:36:17',119,'190.131.240.114','Inicio de sesión','Exitoso'),(159,'2018-02-14 11:19:46',119,'190.131.240.114','Fin de sesión usuario','Exitoso'),(160,'2018-02-14 13:24:25',6,'190.131.244.209','Inicio de sesión','Exitoso'),(161,'2018-02-14 14:14:27',89,'190.131.244.209','Inicio de sesión','Exitoso'),(162,'2018-02-14 14:43:54',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(163,'2018-02-15 08:06:43',102,'201.221.124.8','Intento fallido de acceso al sistema','Fallido'),(164,'2018-02-15 08:07:16',102,'201.221.124.8','Inicio de sesión','Exitoso'),(165,'2018-02-15 08:13:06',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(166,'2018-02-15 10:39:16',111,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(167,'2018-02-15 10:39:56',111,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(168,'2018-02-15 10:41:07',111,'190.143.111.130','Inicio de sesión','Usuario Bloqueado'),(169,'2018-02-15 10:42:42',111,'190.143.111.130','Inicio de sesión','Usuario Bloqueado'),(170,'2018-02-15 11:18:42',109,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(171,'2018-02-15 11:19:47',109,'190.143.111.130','Inicio de sesión','Usuario Bloqueado'),(172,'2018-02-15 11:24:35',61,'190.131.244.209','Inicio de sesión','Exitoso'),(173,'2018-02-15 11:26:24',109,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(174,'2018-02-15 11:28:12',109,'190.143.111.130','Inicio de sesión','Exitoso'),(175,'2018-02-15 11:29:40',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(176,'2018-02-15 11:30:10',109,'190.143.111.130','Fin de sesión usuario','Exitoso'),(177,'2018-02-15 11:30:45',109,'190.143.111.130','Inicio de sesión','Exitoso'),(178,'2018-02-15 11:31:09',109,'190.143.111.130','Fin de sesión usuario','Exitoso'),(179,'2018-02-15 12:05:13',111,'190.143.111.130','Inicio de sesión','Exitoso'),(180,'2018-02-15 13:13:57',6,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(181,'2018-02-15 13:15:43',6,'190.131.244.209','Inicio de sesión','Exitoso'),(182,'2018-02-15 13:23:08',6,'190.131.244.209','Inicio de sesión','Exitoso'),(183,'2018-02-15 14:37:26',6,'190.131.244.209','Inicio de sesión','Exitoso'),(184,'2018-02-16 10:32:50',111,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(185,'2018-02-16 10:33:18',111,'190.143.111.130','Intento fallido de acceso al sistema','Fallido'),(186,'2018-02-16 10:33:50',111,'190.143.111.130','Inicio de sesión','Usuario Bloqueado'),(187,'2018-02-16 10:54:17',118,'190.131.244.230','Intento fallido por IP no registrada','Fallido'),(188,'2018-02-16 11:25:09',115,'190.242.36.50','Intento fallido de acceso al sistema','Captcha inválido'),(189,'2018-02-16 11:25:28',115,'190.242.36.50','Inicio de sesión','Exitoso'),(190,'2018-02-16 11:35:52',118,'190.131.244.230','Inicio de sesión','Exitoso'),(191,'2018-02-16 11:35:53',61,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(192,'2018-02-16 11:36:29',1,'190.131.244.209','Inicio de sesión','Exitoso'),(193,'2018-02-16 11:37:52',115,'190.242.36.50','Fin de sesión usuario','Exitoso'),(194,'2018-02-16 12:15:03',118,'190.131.244.230','Inicio de sesión','Exitoso'),(195,'2018-02-16 12:25:29',61,'190.131.244.209','Inicio de sesión','Exitoso'),(196,'2018-02-16 12:46:23',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(197,'2018-02-16 14:21:44',6,'190.131.244.209','Inicio de sesión','Exitoso'),(198,'2018-02-16 14:33:36',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(199,'2018-02-16 14:55:16',6,'190.131.244.209','Inicio de sesión','Exitoso'),(200,'2018-02-16 15:23:36',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(201,'2018-02-19 09:04:32',118,'190.131.244.230','Intento fallido de acceso al sistema','Captcha inválido'),(202,'2018-02-19 09:05:16',118,'190.131.244.230','Inicio de sesión','Exitoso'),(203,'2018-02-19 09:06:04',111,'190.143.111.130','Inicio de sesión','Usuario Bloqueado'),(204,'2018-02-19 09:24:45',109,'190.143.111.130','Inicio de sesión','Exitoso'),(205,'2018-02-19 09:37:18',109,'190.143.111.130','Fin de sesión usuario','Exitoso'),(206,'2018-02-19 09:41:24',111,'190.143.111.130','Inicio de sesión','Exitoso'),(207,'2018-02-19 10:37:56',119,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(208,'2018-02-19 10:38:16',98,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(209,'2018-02-19 10:41:58',98,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(210,'2018-02-19 10:44:14',98,'190.131.240.114','Inicio de sesión','Usuario Bloqueado'),(211,'2018-02-19 10:44:45',119,'190.131.240.114','Inicio de sesión','Exitoso'),(212,'2018-02-19 11:26:48',102,'201.221.124.8','Inicio de sesión','Exitoso'),(213,'2018-02-19 12:43:17',119,'190.131.240.114','Inicio de sesión','Exitoso'),(214,'2018-02-19 13:38:44',6,'190.131.244.209','Inicio de sesión','Exitoso'),(215,'2018-02-19 13:55:43',89,'190.131.244.209','Inicio de sesión','Exitoso'),(216,'2018-02-19 18:22:22',108,'190.131.201.70','Intento fallido de acceso al sistema','Fallido'),(217,'2018-02-19 18:22:44',108,'190.131.201.70','Inicio de sesión','Exitoso'),(218,'2018-02-19 18:23:36',108,'190.131.201.70','Fin de sesión usuario','Exitoso'),(219,'2018-02-20 08:32:22',119,'190.131.240.114','Inicio de sesión','Exitoso'),(220,'2018-02-20 10:30:50',111,'190.143.111.130','Inicio de sesión','Exitoso'),(221,'2018-02-20 10:41:46',119,'190.131.240.114','Intento fallido de acceso al sistema','Fallido'),(222,'2018-02-20 10:42:05',119,'190.131.240.114','Inicio de sesión','Exitoso'),(223,'2018-02-20 10:43:18',102,'201.221.124.8','Inicio de sesión','Exitoso'),(224,'2018-02-20 10:45:09',102,'201.221.124.8','Fin de sesión usuario','Exitoso'),(225,'2018-02-20 10:47:18',115,'190.242.58.26','Intento fallido de acceso al sistema','Fallido'),(226,'2018-02-20 10:48:17',117,'190.242.58.26','Intento fallido de acceso al sistema','Captcha inválido'),(227,'2018-02-20 10:49:15',117,'190.242.58.26','Intento fallido por IP no registrada','Fallido'),(228,'2018-02-20 10:51:14',117,'190.242.58.26','Intento fallido por IP no registrada','Fallido'),(229,'2018-02-20 10:51:43',115,'190.242.36.50','Intento fallido de acceso al sistema','Fallido'),(230,'2018-02-20 10:52:06',116,'190.242.58.26','Intento fallido de acceso al sistema','Fallido'),(231,'2018-02-20 10:52:13',115,'190.242.36.50','Inicio de sesión','Usuario Bloqueado'),(232,'2018-02-20 10:52:42',117,'190.242.58.26','Intento fallido por IP no registrada','Fallido'),(233,'2018-02-20 10:52:47',116,'190.242.36.50','Intento fallido de acceso al sistema','Fallido'),(234,'2018-02-20 10:53:20',117,'190.242.58.26','Intento fallido de acceso al sistema','Fallido'),(235,'2018-02-20 10:53:30',116,'190.242.36.50','Inicio de sesión','Usuario Bloqueado'),(236,'2018-02-20 10:53:57',117,'190.242.58.26','Inicio de sesión','Usuario Bloqueado'),(237,'2018-02-20 10:54:42',116,'190.242.36.50','Inicio de sesión','Usuario Bloqueado'),(238,'2018-02-20 10:57:56',118,'190.131.244.230','Inicio de sesión','Exitoso'),(239,'2018-02-20 11:01:40',119,'190.131.240.114','Inicio de sesión','Exitoso'),(240,'2018-02-20 11:27:39',119,'190.131.240.114','Inicio de sesión','Exitoso'),(241,'2018-02-20 12:02:58',115,'190.242.36.50','Inicio de sesión','Usuario Bloqueado'),(242,'2018-02-20 12:29:14',61,'190.131.244.209','Inicio de sesión','Exitoso'),(243,'2018-02-20 12:40:59',115,'190.242.36.50','Inicio de sesión','Exitoso'),(244,'2018-02-20 13:06:14',6,'190.131.244.209','Inicio de sesión','Exitoso'),(245,'2018-02-20 13:24:58',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(246,'2018-02-20 14:06:53',89,'190.131.244.209','Inicio de sesión','Exitoso'),(247,'2018-02-20 14:39:54',6,'190.131.244.209','Inicio de sesión','Exitoso'),(248,'2018-02-20 14:43:59',6,'190.131.244.209','Fin de sesión usuario','Exitoso'),(249,'2018-02-21 08:03:19',6,'190.131.244.209','Inicio de sesión','Exitoso'),(250,'2018-02-21 08:20:29',89,'190.131.244.209','Inicio de sesión','Exitoso'),(251,'2018-02-21 09:09:34',6,'190.131.244.209','Inicio de sesión','Exitoso'),(252,'2018-02-21 10:45:02',6,'190.131.244.209','Inicio de sesión','Exitoso'),(253,'2018-02-21 13:11:31',119,'190.131.240.114','Inicio de sesión','Fecha/Horario despues del inicio de la operación'),(254,'2018-02-21 15:49:41',61,'190.131.244.209','Inicio de sesión','Exitoso'),(255,'2018-02-21 15:49:56',61,'190.131.244.209','Fin de sesión usuario','Exitoso'),(256,'2018-02-21 15:50:19',1,'190.131.244.209','Inicio de sesión','Exitoso'),(257,'2018-02-21 16:01:05',1,'190.131.244.209','Fin de sesión usuario','Exitoso'),(258,'2018-02-21 16:01:26',120,'190.131.244.209','Intento fallido de acceso al sistema','Fallido'),(259,'2018-02-21 16:01:57',120,'190.131.244.209','Inicio de sesión','Exitoso'),(260,'2018-02-21 16:04:31',120,'190.131.244.209','Fin de sesión usuario','Exitoso');
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
) ENGINE=MyISAM AUTO_INCREMENT=275 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_logusuariosadmin`
--

LOCK TABLES `fqs_logusuariosadmin` WRITE;
/*!40000 ALTER TABLE `fqs_logusuariosadmin` DISABLE KEYS */;
INSERT INTO `fqs_logusuariosadmin` VALUES ('lnavarro','2018-01-10 08:57:30','Generar Boletín','190.131.244.209',1),('lnavarro','2018-01-10 08:57:33','Parametrización','190.131.244.209',2),('lnavarro','2018-01-10 08:59:19','Parametrización','190.131.244.209',3),('lnavarro','2018-01-10 08:59:21','Reporte Consolidado','190.131.244.209',4),('lnavarro','2018-01-10 08:59:23','Parametrización','190.131.244.209',5),('1004001','2018-01-10 10:57:35','Gestion de Usuarios','190.66.2.204',6),('1004001','2018-01-10 11:00:47','Cambio de Contraseña','190.66.2.204',7),('1004001','2018-01-10 11:00:51','Gestion de Usuarios','190.66.2.204',8),('1004002','2018-01-10 11:42:09','Gestión de Aceptaciones','190.66.2.204',9),('1004002','2018-01-10 11:42:12','Ingreso de Aceptaciones','190.66.2.204',10),('lnavarro','2018-01-10 13:22:26','Reporte Consolidado','190.131.244.209',11),('lnavarro','2018-01-10 13:22:34','Generar Boletín','190.131.244.209',12),('lnavarro','2018-01-10 13:43:44','Reporte Consolidado','190.131.244.209',13),('lmuneton','2018-01-11 13:57:26','Reporte Consolidado','190.131.244.209',14),('lmuneton','2018-01-11 13:58:50','Generar Boletín','190.131.244.209',15),('lmuneton','2018-01-11 14:17:52','Reporte Consolidado','190.131.244.209',16),('lmuneton','2018-01-11 14:18:05','Generar Boletín','190.131.244.209',17),('ogomez','2018-01-11 17:58:49','Gestion de Usuarios','190.131.244.209',18),('ogomez','2018-01-11 18:22:23','Gestion de Usuarios','190.131.244.209',19),('ogomez','2018-01-11 18:24:53','Mantenedor SCB','190.131.244.209',20),('1029001','2018-01-12 07:03:54','Gestion de Usuarios','190.143.111.130',21),('1029001','2018-01-12 14:48:38','Gestion de Usuarios','190.143.111.130',22),('lnavarro','2018-01-12 15:01:26','Generar Boletín','190.131.244.209',23),('lnavarro','2018-01-12 15:01:27','Reporte Consolidado','190.131.244.209',24),('lnavarro','2018-01-12 15:01:34','Generar Boletín','190.131.244.209',25),('lnavarro','2018-01-12 15:06:28','Reporte Consolidado','190.131.244.209',26),('1029001','2018-01-12 15:07:59','Gestion de Usuarios','190.143.111.130',27),('1029001','2018-01-12 15:08:04','Cambio de Contraseña','190.143.111.130',28),('1029001','2018-01-12 15:08:12','Gestion de Usuarios','190.143.111.130',29),('lmuneton','2018-01-12 15:13:07','Reporte Consolidado','190.131.244.209',30),('lmuneton','2018-01-12 15:13:57','Generar Boletín','190.131.244.209',31),('mleon','2018-01-12 15:42:55','Ingreso de Aceptaciones','190.143.111.130',32),('mleon','2018-01-12 15:43:12','Carga Masiva de Aceptaciones','190.143.111.130',33),('lnavarro','2018-01-15 14:11:05','Reporte Consolidado','190.131.244.209',34),('lnavarro','2018-01-15 14:23:19','Generar Boletín','190.131.244.209',35),('lnavarro','2018-01-16 13:59:23','Reporte Consolidado','190.131.244.209',36),('lnavarro','2018-01-16 14:01:08','Generar Boletín','190.131.244.209',37),('mleon','2018-01-16 15:51:12','Ingreso de Aceptaciones','190.143.111.130',38),('mleon','2018-01-16 15:51:51','Reporte Consolidado','190.143.111.130',39),('mleon','2018-01-17 09:18:48','Ingreso de Aceptaciones','190.143.111.130',40),('mleon','2018-01-17 10:12:00','Ingreso de Aceptaciones','190.143.111.130',41),('mleon','2018-01-17 11:35:05','Ingreso de Aceptaciones','190.143.111.130',42),('mleon','2018-01-17 11:35:13','Ingreso de Aceptaciones','190.143.111.130',43),('mleon','2018-01-17 11:54:38','Reporte Consolidado','190.143.111.130',44),('mleon','2018-01-17 12:36:46','Reporte Consolidado','190.143.111.130',45),('mleon','2018-01-17 12:36:54','Reportes','190.143.111.130',46),('lnavarro','2018-01-17 12:38:29','Reporte Consolidado','190.131.244.209',47),('mleon','2018-01-17 12:47:15','Ingreso de Aceptaciones','190.143.111.130',48),('mleon','2018-01-17 12:51:35','Reporte Consolidado','190.143.111.130',49),('lnavarro','2018-01-17 13:51:43','Generar Boletín','190.131.244.209',50),('lnavarro','2018-01-17 13:51:45','Reporte Consolidado','190.131.244.209',51),('lnavarro','2018-01-17 13:57:58','Generar Boletín','190.131.244.209',52),('lmuneton','2018-01-17 14:06:37','Reporte Consolidado','190.131.244.209',53),('lnavarro','2018-01-17 14:10:24','Reporte Consolidado','190.131.244.209',54),('ogomez','2018-01-17 18:14:09','Mantenedor SCB','190.131.244.209',55),('ogomez','2018-01-17 18:14:13','Gestion de Usuarios','190.131.244.209',56),('hitrespa','2018-01-18 10:39:06','Carga Masiva de Aceptaciones','201.221.124.8',57),('hitrespa','2018-01-18 11:25:30','Reporte Consolidado','201.221.124.8',58),('lnavarro','2018-01-18 13:37:13','Reporte Consolidado','190.131.244.209',59),('lnavarro','2018-01-18 13:38:34','Generar Boletín','190.131.244.209',60),('lmuneton','2018-01-18 14:43:19','Generar Boletín','190.131.244.209',61),('lmuneton','2018-01-18 14:43:20','Reporte Consolidado','190.131.244.209',62),('lmuneton','2018-01-18 14:43:21','Reporte Consolidado','190.131.244.209',63),('lnavarro','2018-01-18 14:52:56','Reporte Consolidado','190.131.244.209',64),('hitrespa','2018-01-19 12:04:58','Carga Masiva de Aceptaciones','201.221.124.8',65),('lnavarro','2018-01-19 13:31:41','Reporte Consolidado','190.131.244.209',66),('lnavarro','2018-01-19 13:35:50','Generar Boletín','190.131.244.209',67),('lnavarro','2018-01-19 14:10:23','Reporte Consolidado','190.131.244.209',68),('hitrespa','2018-01-22 09:34:20','Carga Masiva de Aceptaciones','201.221.124.8',69),('hitrespa','2018-01-22 09:35:44','Carga Masiva de Aceptaciones','201.221.124.8',70),('hitrespa','2018-01-22 09:58:05','Reporte Consolidado','201.221.124.8',71),('hitrespa','2018-01-22 11:17:31','Ingreso de Aceptaciones','201.221.124.8',72),('mleon','2018-01-22 12:07:56','Ingreso de Aceptaciones','190.143.111.130',73),('mleon','2018-01-22 12:17:50','Reporte Consolidado','190.143.111.130',74),('lnavarro','2018-01-22 13:58:14','Reporte Consolidado','190.131.244.209',75),('lnavarro','2018-01-22 13:59:58','Generar Boletín','190.131.244.209',76),('lnavarro','2018-01-22 15:50:20','Reporte Consolidado','190.131.244.209',77),('jlezcano','2018-01-23 08:43:31','Reporte Consolidado','201.221.124.8',78),('jlezcano','2018-01-23 08:47:08','Ingreso de Aceptaciones','201.221.124.8',79),('jlezcano','2018-01-23 08:47:21','Ingreso de Aceptaciones','201.221.124.8',80),('jlezcano','2018-01-23 08:48:23','Ingreso de Aceptaciones','201.221.124.8',81),('jlezcano','2018-01-23 08:48:26','Carga Masiva de Aceptaciones','201.221.124.8',82),('jlezcano','2018-01-23 08:48:38','Ingreso de Aceptaciones','201.221.124.8',83),('hitrespa','2018-01-23 10:26:00','Carga Masiva de Aceptaciones','201.221.124.8',84),('hitrespa','2018-01-23 10:29:34','Ingreso de Aceptaciones','201.221.124.8',85),('hitrespa','2018-01-23 10:29:42','Reporte Consolidado','201.221.124.8',86),('jlezcano','2018-01-23 10:51:32','Carga Masiva de Aceptaciones','201.221.124.8',87),('jlezcano','2018-01-23 11:09:38','Ingreso de Aceptaciones','201.221.124.8',88),('lnavarro','2018-01-23 11:09:54','Reporte Consolidado','190.131.244.209',89),('hitrespa','2018-01-23 11:13:41','Carga Masiva de Aceptaciones','201.221.124.8',90),('hitrespa','2018-01-23 12:53:11','Carga Masiva de Aceptaciones','201.221.124.8',91),('hitrespa','2018-01-23 12:55:58','Carga Masiva de Aceptaciones','201.221.124.8',92),('hitrespa','2018-01-23 13:01:17','Carga Masiva de Aceptaciones','201.221.124.8',93),('hitrespa','2018-01-23 13:06:58','Carga Masiva de Aceptaciones','201.221.124.8',94),('hitrespa','2018-01-23 13:59:54','Carga Masiva de Aceptaciones','201.221.124.8',95),('hitrespa','2018-01-23 13:59:57','Carga Masiva de Aceptaciones','201.221.124.8',96),('hitrespa','2018-01-23 14:00:44','Carga Masiva de Aceptaciones','201.221.124.8',97),('hitrespa','2018-01-23 14:00:45','Carga Masiva de Aceptaciones','201.221.124.8',98),('hitrespa','2018-01-23 14:00:45','Carga Masiva de Aceptaciones','201.221.124.8',99),('hitrespa','2018-01-23 14:02:52','Carga Masiva de Aceptaciones','201.221.124.8',100),('hitrespa','2018-01-23 14:02:53','Carga Masiva de Aceptaciones','201.221.124.8',101),('hitrespa','2018-01-23 14:02:53','Carga Masiva de Aceptaciones','201.221.124.8',102),('lnavarro','2018-01-23 14:04:15','Reporte Consolidado','190.131.244.209',103),('hitrespa','2018-01-23 14:12:55','Carga Masiva de Aceptaciones','201.221.124.8',104),('hitrespa','2018-01-23 14:12:56','Carga Masiva de Aceptaciones','201.221.124.8',105),('hitrespa','2018-01-23 14:12:56','Carga Masiva de Aceptaciones','201.221.124.8',106),('lmuneton','2018-01-23 15:06:07','Reporte Consolidado','190.131.244.209',107),('lmuneton','2018-01-23 15:06:08','Generar Boletín','190.131.244.209',108),('lmuneton','2018-01-23 15:16:10','Reporte Consolidado','190.131.244.209',109),('lnavarro','2018-01-23 15:40:17','Reporte Consolidado','190.131.244.209',110),('hitrespa','2018-01-24 12:30:44','Reporte Consolidado','201.221.124.8',111),('lmuneton','2018-01-24 13:17:09','Reporte Consolidado','190.131.244.209',112),('lmuneton','2018-01-24 13:17:15','Generar Boletín','190.131.244.209',113),('lmuneton','2018-01-24 13:43:23','Reporte Consolidado','190.131.244.209',114),('ehernandez','2018-01-24 14:07:02','Reporte Consolidado','190.131.244.209',115),('lmuneton','2018-01-24 14:58:12','Reporte Consolidado','190.131.244.209',116),('lmuneton','2018-01-25 13:21:21','Generar Boletín','190.131.244.209',117),('lmuneton','2018-01-25 13:28:14','Reporte Consolidado','190.131.244.209',118),('ehernandez','2018-01-25 14:19:00','Reporte Consolidado','190.131.244.209',119),('hitrespa','2018-01-26 11:02:33','Reporte Consolidado','201.221.124.8',120),('lmuneton','2018-01-26 13:47:59','Reporte Consolidado','190.131.244.209',121),('lmuneton','2018-01-26 13:49:05','Generar Boletín','190.131.244.209',122),('lmuneton','2018-01-26 13:52:49','Reporte Consolidado','190.131.244.209',123),('ehernandez','2018-01-26 14:15:20','Parametrización','190.131.244.209',124),('ehernandez','2018-01-26 14:15:23','Reporte Consolidado','190.131.244.209',125),('lnavarro','2018-01-29 14:14:03','Reporte Consolidado','190.131.244.209',126),('lnavarro','2018-01-29 14:20:47','Generar Boletín','190.131.244.209',127),('lnavarro','2018-01-29 14:40:19','Reporte Consolidado','190.131.244.209',128),('1004002','2018-01-30 08:17:51','Gestión de Aceptaciones','190.66.2.204',129),('1004002','2018-01-30 08:17:55','Ingreso de Aceptaciones','190.66.2.204',130),('1004002','2018-01-30 09:32:56','Gestión de Aceptaciones','190.66.2.204',131),('1004002','2018-01-30 09:32:58','Ingreso de Aceptaciones','190.66.2.204',132),('1004002','2018-01-30 09:36:36','Reportes','190.66.2.204',133),('1004002','2018-01-30 09:36:38','Reporte Consolidado','190.66.2.204',134),('mleon','2018-01-30 12:10:54','Ingreso de Aceptaciones','190.143.111.130',135),('mleon','2018-01-30 12:22:19','Reporte Consolidado','190.143.111.130',136),('lnavarro','2018-01-30 13:40:37','Reporte Consolidado','190.131.244.209',137),('lnavarro','2018-01-30 13:42:08','Generar Boletín','190.131.244.209',138),('lnavarro','2018-01-30 13:47:51','Reporte Consolidado','190.131.244.209',139),('lmuneton','2018-01-30 14:05:40','Reporte Consolidado','190.131.244.209',140),('lnavarro','2018-01-31 13:09:58','Reporte Consolidado','190.131.244.209',141),('lnavarro','2018-01-31 13:22:51','Generar Boletín','190.131.244.209',142),('hitrespa','2018-02-01 08:49:58','Ingreso de Aceptaciones','201.221.124.8',143),('hitrespa','2018-02-01 09:17:10','Ingreso de Aceptaciones','201.221.124.8',144),('1004002','2018-02-01 10:38:57','Reporte Consolidado','190.66.2.204',145),('lnavarro','2018-02-01 13:51:18','Reporte Consolidado','190.131.244.209',146),('lnavarro','2018-02-01 13:52:52','Generar Boletín','190.131.244.209',147),('mleon','2018-02-01 17:59:38','Reporte Consolidado','190.143.111.130',148),('lnavarro','2018-02-02 13:20:03','Reporte Consolidado','190.131.244.209',149),('lnavarro','2018-02-02 13:25:37','Generar Boletín','190.131.244.209',150),('lnavarro','2018-02-05 13:35:17','Reporte Consolidado','190.131.244.209',151),('lnavarro','2018-02-05 13:38:59','Generar Boletín','190.131.244.209',152),('lnavarro','2018-02-06 13:21:14','Reporte Consolidado','190.131.244.209',153),('lnavarro','2018-02-06 13:22:14','Generar Boletín','190.131.244.209',154),('lnavarro','2018-02-07 13:28:10','Reporte Consolidado','190.131.244.209',155),('lnavarro','2018-02-07 13:30:15','Generar Boletín','190.131.244.209',156),('lmuneton','2018-02-07 14:02:28','Reporte Consolidado','190.131.244.209',157),('lnavarro','2018-02-08 13:16:57','Reporte Consolidado','190.131.244.209',158),('lnavarro','2018-02-08 13:41:29','Generar Boletín','190.131.244.209',159),('lnavarro','2018-02-08 14:23:41','Generar Boletín','190.131.244.209',160),('lmuneton','2018-02-08 14:54:06','Reporte Consolidado','190.131.244.209',161),('lnavarro','2018-02-09 13:41:40','Reporte Consolidado','190.131.244.209',162),('lnavarro','2018-02-09 13:43:52','Generar Boletín','190.131.244.209',163),('lnavarro','2018-02-12 13:51:17','Reporte Consolidado','190.131.244.209',164),('lnavarro','2018-02-12 13:54:27','Generar Boletín','190.131.244.209',165),('ogomez','2018-02-12 22:56:40','Gestion de Usuarios','190.131.244.209',166),('1002001','2018-02-13 10:19:00','Gestion de Usuarios','190.131.201.70',167),('ogomez','2018-02-13 12:38:22','Gestion de Usuarios','190.131.244.209',168),('1002001','2018-02-13 12:40:41','Gestion de Usuarios','190.131.201.70',169),('1002001','2018-02-13 12:55:18','Gestion de Usuarios','190.131.201.70',170),('lnavarro','2018-02-13 13:47:44','Reporte Consolidado','190.131.244.209',171),('lnavarro','2018-02-13 13:50:40','Generar Boletín','190.131.244.209',172),('lmuneton','2018-02-13 14:27:43','Generar Boletín','190.131.244.209',173),('lmuneton','2018-02-13 14:27:47','Generar Boletín','190.131.244.209',174),('lmuneton','2018-02-13 14:27:48','Reporte Consolidado','190.131.244.209',175),('ogomez','2018-02-13 14:46:46','Gestion de Usuarios','190.131.244.209',176),('1018001','2018-02-13 16:07:57','Gestion de Usuarios','190.242.36.50',177),('rrodriguez','2018-02-13 16:19:33','Ingreso de Aceptaciones','190.242.36.50',178),('ogomez','2018-02-14 10:31:12','Gestion de Usuarios','190.131.244.209',179),('1050001','2018-02-14 10:34:35','Gestion de Usuarios','190.131.240.114',180),('1050002','2018-02-14 10:41:35','Ingreso de Aceptaciones','190.131.240.114',181),('1050002','2018-02-14 11:00:07','Modificación de Aceptaciones','190.131.240.114',182),('1050002','2018-02-14 11:00:33','Ingreso de Aceptaciones','190.131.240.114',183),('1050002','2018-02-14 11:06:14','Ingreso de Aceptaciones','190.131.240.114',184),('1050002','2018-02-14 11:06:16','Modificación de Aceptaciones','190.131.240.114',185),('1050002','2018-02-14 11:06:20','Ingreso de Aceptaciones','190.131.240.114',186),('1050002','2018-02-14 11:07:55','Ingreso de Aceptaciones','190.131.240.114',187),('1050002','2018-02-14 11:10:17','Reporte Consolidado','190.131.240.114',188),('1050002','2018-02-14 11:13:39','Ingreso de Aceptaciones','190.131.240.114',189),('1050002','2018-02-14 11:13:40','Modificación de Aceptaciones','190.131.240.114',190),('1050002','2018-02-14 11:15:47','Modificación de Aceptaciones','190.131.240.114',191),('1050002','2018-02-14 11:16:07','Modificación de Aceptaciones','190.131.240.114',192),('1050002','2018-02-14 11:18:32','Modificación de Aceptaciones','190.131.240.114',193),('1050002','2018-02-14 11:18:52','Modificación de Aceptaciones','190.131.240.114',194),('lnavarro','2018-02-14 13:28:07','Reporte Consolidado','190.131.244.209',195),('lnavarro','2018-02-14 13:31:16','Generar Boletín','190.131.244.209',196),('lmuneton','2018-02-14 14:14:30','Generar Boletín','190.131.244.209',197),('lnavarro','2018-02-14 14:15:48','Reporte Consolidado','190.131.244.209',198),('hitrespa','2018-02-15 08:07:26','Reporte Consolidado','201.221.124.8',199),('ogomez','2018-02-15 11:24:43','Gestion de Usuarios','190.131.244.209',200),('1029001','2018-02-15 11:28:53','Gestion de Usuarios','190.143.111.130',201),('mleon','2018-02-15 12:06:24','Ingreso de Aceptaciones','190.143.111.130',202),('mleon','2018-02-15 12:12:05','Reporte Consolidado','190.143.111.130',203),('lnavarro','2018-02-15 13:15:48','Reporte Consolidado','190.131.244.209',204),('lnavarro','2018-02-15 13:24:22','Reporte Consolidado','190.131.244.209',205),('lnavarro','2018-02-15 13:26:22','Generar Boletín','190.131.244.209',206),('lnavarro','2018-02-15 14:37:31','Reporte Consolidado','190.131.244.209',207),('1018001','2018-02-16 11:25:32','Gestion de Usuarios','190.242.36.50',208),('1018001','2018-02-16 11:37:41','Reporte Consolidado','190.242.36.50',209),('arrivera','2018-02-16 12:15:23','Ingreso de Aceptaciones','190.131.244.230',210),('ogomez','2018-02-16 12:25:35','Gestion de Usuarios','190.131.244.209',211),('ogomez','2018-02-16 12:26:35','Gestion de Usuarios','190.131.244.209',212),('ogomez','2018-02-16 12:28:31','Mantenedor SCB','190.131.244.209',213),('ogomez','2018-02-16 12:37:28','Gestion de Usuarios','190.131.244.209',214),('lnavarro','2018-02-16 14:21:47','Reporte Consolidado','190.131.244.209',215),('lnavarro','2018-02-16 14:23:04','Generar Boletín','190.131.244.209',216),('lnavarro','2018-02-16 14:55:19','Reporte Consolidado','190.131.244.209',217),('arrivera','2018-02-19 09:05:25','Ingreso de Aceptaciones','190.131.244.230',218),('1029001','2018-02-19 09:24:50','Gestion de Usuarios','190.143.111.130',219),('mleon','2018-02-19 09:41:31','Ingreso de Aceptaciones','190.143.111.130',220),('1050002','2018-02-19 10:44:50','Ingreso de Aceptaciones','190.131.240.114',221),('hitrespa','2018-02-19 11:26:57','Ingreso de Aceptaciones','201.221.124.8',222),('hitrespa','2018-02-19 11:26:59','Carga Masiva de Aceptaciones','201.221.124.8',223),('hitrespa','2018-02-19 11:29:11','Reporte Consolidado','201.221.124.8',224),('1050002','2018-02-19 12:43:44','Ingreso de Aceptaciones','190.131.240.114',225),('1050002','2018-02-19 12:50:05','Modificación de Aceptaciones','190.131.240.114',226),('1050002','2018-02-19 12:51:43','Reporte Consolidado','190.131.240.114',227),('1050002','2018-02-19 12:52:18','Reporte Consolidado','190.131.240.114',228),('lnavarro','2018-02-19 13:38:47','Reporte Consolidado','190.131.244.209',229),('lnavarro','2018-02-19 13:44:23','Generar Boletín','190.131.244.209',230),('lmuneton','2018-02-19 13:56:08','Reporte Consolidado','190.131.244.209',231),('lmuneton','2018-02-19 13:56:09','Generar Boletín','190.131.244.209',232),('1002001','2018-02-19 18:22:57','Reporte Consolidado','190.131.201.70',233),('1002001','2018-02-19 18:23:15','Gestion de Usuarios','190.131.201.70',234),('1002001','2018-02-19 18:23:23','Reporte Consolidado','190.131.201.70',235),('1050002','2018-02-20 08:35:13','Ingreso de Aceptaciones','190.131.240.114',236),('mleon','2018-02-20 10:30:55','Reporte Consolidado','190.143.111.130',237),('mleon','2018-02-20 10:31:21','Ingreso de Aceptaciones','190.143.111.130',238),('hitrespa','2018-02-20 10:43:23','Modificación de Aceptaciones','201.221.124.8',239),('1050002','2018-02-20 10:45:08','Ingreso de Aceptaciones','190.131.240.114',240),('mleon','2018-02-20 10:45:32','Reporte Consolidado','190.143.111.130',241),('arrivera','2018-02-20 10:58:03','Ingreso de Aceptaciones','190.131.244.230',242),('1050002','2018-02-20 11:01:54','Gestión de Aceptaciones','190.131.240.114',243),('1050002','2018-02-20 11:01:56','Ingreso de Aceptaciones','190.131.240.114',244),('1050002','2018-02-20 11:03:13','Ingreso de Aceptaciones','190.131.240.114',245),('1050002','2018-02-20 11:21:21','Gestión de Aceptaciones','190.131.240.114',246),('1050002','2018-02-20 11:21:23','Ingreso de Aceptaciones','190.131.240.114',247),('1050002','2018-02-20 11:27:48','Ingreso de Aceptaciones','190.131.240.114',248),('1050002','2018-02-20 11:41:53','Reporte Consolidado','190.131.240.114',249),('1050002','2018-02-20 11:47:06','Modificación de Aceptaciones','190.131.240.114',250),('1050002','2018-02-20 11:47:11','Modificación de Aceptaciones','190.131.240.114',251),('1050002','2018-02-20 11:49:59','Modificación de Aceptaciones','190.131.240.114',252),('ogomez','2018-02-20 12:29:47','Gestion de Usuarios','190.131.244.209',253),('1018001','2018-02-20 12:41:55','Gestion de Usuarios','190.242.36.50',254),('1018001','2018-02-20 12:43:04','Gestion de Usuarios','190.242.36.50',255),('1018001','2018-02-20 12:43:06','Gestion de Usuarios','190.242.36.50',256),('1018001','2018-02-20 12:43:09','Gestion de Usuarios','190.242.36.50',257),('1018001','2018-02-20 12:43:42','Gestion de Usuarios','190.242.36.50',258),('1018001','2018-02-20 12:57:04','Reporte Consolidado','190.242.36.50',259),('lnavarro','2018-02-20 13:06:20','Reporte Consolidado','190.131.244.209',260),('lnavarro','2018-02-20 13:09:37','Generar Boletín','190.131.244.209',261),('lmuneton','2018-02-20 14:06:58','Generar Boletín','190.131.244.209',262),('lnavarro','2018-02-20 14:40:09','Reporte Consolidado','190.131.244.209',263),('lnavarro','2018-02-21 08:04:11','Reporte Consolidado','190.131.244.209',264),('lmuneton','2018-02-21 08:20:34','Reporte Consolidado','190.131.244.209',265),('lnavarro','2018-02-21 09:09:43','Generar Boletín','190.131.244.209',266),('lnavarro','2018-02-21 09:09:59','Generar Adjudicación','190.131.244.209',267),('lnavarro','2018-02-21 09:15:25','Descargar Resultados','190.131.244.209',268),('lnavarro','2018-02-21 09:17:48','Reporte Consolidado','190.131.244.209',269),('lnavarro','2018-02-21 10:45:07','Reporte Consolidado','190.131.244.209',270),('ogomez','2018-02-21 15:49:45','Gestion de Usuarios','190.131.244.209',271),('admin','2018-02-21 15:51:00','Gestion de Usuarios','190.131.244.209',272),('admin','2018-02-21 15:52:06','Gestion de Usuarios','190.131.244.209',273),('esouza','2018-02-21 16:03:08','Gestion de Usuarios','190.131.244.209',274);
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
  `c_nombre` varchar(30) NOT NULL DEFAULT '',
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
INSERT INTO `fqs_opcionmodulo` VALUES (7,0,5,'Modificación de Aceptaciones','--',1,2,6),(2,0,1,'Ingreso de Aceptaciones','--',1,1,6),(17,0,15,'Rechazo de Aceptaciones','--',1,3,6),(5,0,3,'Gestion de Usuarios','--',1,5,NULL),(6,0,0,'Gestión de Aceptaciones','--',1,1,NULL),(8,0,6,'Rechazos de Aceptaciones','--',1,3,6),(9,0,7,'Parametrización','--',1,3,NULL),(10,0,0,'Reportes','--',1,2,NULL),(11,0,9,'Reporte Diario','--',1,1,10),(12,0,10,'Reporte Consolidado','--',1,2,10),(13,0,11,'Reporte de Adjudicación','--',1,3,10),(14,0,0,'Adjudicación','--',1,4,NULL),(15,0,13,'Generar Adjudicación','--',1,1,14),(16,0,14,'Generar Interfaz','--',1,2,14),(20,0,17,'Descargar Resultados','--',1,2,14),(18,0,16,'Carga Masiva de Aceptaciones','--',1,4,6),(21,0,18,'Cambio de Contraseña','--',1,6,NULL),(22,0,19,'Mantenedor SCB','--',1,5,NULL),(23,0,20,'Diccionario de Contraseñas','--',1,5,NULL),(24,0,21,'Generar Boletín','--',1,2,10),(25,0,22,'Auditoria','--',1,4,NULL);
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
INSERT INTO `fqs_pagina` VALUES (0,'com.framework.common.ui.BienvenidaContent','INICIO',NULL),(1,'com.framework.common.ui.contents.CrearAceptaciones','INGRESO DE ACEPTACIONES',NULL),(3,'com.framework.common.ui.content.user.AdminUsuariosContent','GESTION DE USUARIOS',NULL),(5,'com.framework.common.ui.contents.ModificarAceptaciones','MODIFICACIÓN DE ACEPTACIONES',NULL),(6,'com.framework.common.ui.contents.RechazoAceptaciones','RECHAZO DE ACEPTACIONES',NULL),(7,'com.framework.common.ui.contents.CrearParametros','PARAMETRIZACION',NULL),(15,'com.framework.common.ui.contents.RechazoAceptaciones','RECHAZO DE ACEPTACIONES',NULL),(9,'com.framework.common.ui.contents.ReporteDiario','REPORTE DIARIO',NULL),(10,'com.framework.common.ui.contents.ReporteConsolidado','REPORTE CONSOLIDADO',NULL),(11,'com.framework.common.ui.contents.ReporteAdjudicacion','REPORTE DE ADJUDICACIÓN',NULL),(13,'com.framework.common.ui.contents.GenerarAdjudicacion','GENERAR ADJUDICACIÓN',NULL),(14,'com.framework.common.ui.contents.GenerarInterfaz','GENERAR INTERFAZ ',NULL),(17,'com.framework.common.ui.contents.DescargarAdjudicacion','DESCARGAR RESULTADOS DE ADJUDICACIÓN',NULL),(16,'com.framework.common.ui.contents.CargaMasivaAceptaciones','CARGA MASIVA DE ACEPTACIONES',NULL),(18,'com.framework.common.ui.contents.CambioContrasenaPrincipal','CAMBIO DE CONTRASEÑA',NULL),(19,'com.framework.common.ui.contents.MantenedorScb','MANTENERDOR SCB',NULL),(20,'com.framework.common.ui.content.user.DiccionarioContrasenas','DICCIONARIO CONTRASEÑAS',NULL),(21,'com.framework.common.ui.contents.GenerarBoletin','GENERAR BOLETÃN',NULL),(22,'com.framework.common.ui.content.user.LogAuditoria','AUDITORIA',NULL);
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
INSERT INTO `fqs_parametro` VALUES (15000,1,'2','Número de intentos fallidos','autenticacionIntentosFallidosBloqueo'),(15001,30,'30','Tiempo máximo de inactividad','autenticacionTiempoDeslogueoInactividad'),(15006,1,'0','Restricción en el uso de claves anteriores a','passwordHistorialRestriccion'),(15008,1,'0','Tiempo Minimo cambio contrase?as','passwordTiempoMinimoCambio'),(15015,0,'es_CO','Locale Global de la Aplicación','locale'),(20000,1,'true','Se valida IP unica o no','IpValida'),(20001,1,'true','Mostrar Captcha','Captcha'),(20005,1,'/apps/OPA/IDR','Ruta Generacion Archivo IDR','rutaIDR'),(20004,1,'/apps/OPA/CargaMasiva','Ruta Cargue Masivo de Aceptaciones','rutaCargueMasivo'),(20007,1,'/apps/OPA/ArchivoAdjudicacion','Ruta cargue Adjudicacion','rutaCargueAdjudicacion'),(20006,1,'40000','Registros Maximos Cargue Masivo','cantMaxCargueMasivo'),(20008,1,'20','n?mero de d?as de vencimiento contrase?a','vencimientoContrase?a'),(20011,1,'/apps/OPA/Boletin','Ruta Boletin','rutaBoletin');
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
) ENGINE=MyISAM AUTO_INCREMENT=3185 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_permiso`
--

LOCK TABLES `fqs_permiso` WRITE;
/*!40000 ALTER TABLE `fqs_permiso` DISABLE KEYS */;
INSERT INTO `fqs_permiso` VALUES (3158,4,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(50,4,2,'2003-12-31 00:00:00','2016-12-31 00:00:00','Ingreso Aceptaciones'),(49,4,6,'2003-12-31 00:00:00','2016-12-31 00:00:00','Gestion de Aceptaciones'),(14,5,6,'2003-12-31 00:00:00','2016-12-31 00:00:00','Gestion de Aceptaciones'),(53,5,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(3157,4,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(52,5,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(12,3,5,'2003-12-31 00:00:00','2016-12-31 00:00:00','Administrar Usuarios'),(39,4,7,'2003-12-31 00:00:00','2016-12-31 00:00:00','Modificacion Aceptaciones'),(15,5,2,'2003-12-31 00:00:00','2016-12-31 00:00:00','Ingreso Aceptaciones'),(3159,1,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(3160,1,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(18,5,9,'2003-12-31 00:00:00','2016-12-31 00:00:00','Parametrización'),(26,5,5,'2003-12-31 00:00:00','2016-12-31 00:00:00','Gestión de Usuarios'),(31,2,9,'2003-12-31 00:00:00','2016-12-31 00:00:00','Parametrización'),(3164,2,6,'1000-01-01 00:00:00','2016-12-31 00:00:00','Gestion de Aceptaciones'),(3163,2,17,'2016-12-31 00:00:00','2016-12-31 00:00:00','Rechazo de Aceptaciones'),(3162,2,12,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reporte Consolidado'),(51,5,17,'2003-12-31 00:00:00','2022-12-31 00:00:00','Rechazo de Aceptaciones'),(3161,2,10,'2016-12-31 00:00:00','2016-12-31 00:00:00','Reportes'),(16,5,7,'2003-12-31 00:00:00','2016-12-31 00:00:00','Modificacion Aceptaciones'),(48,1,5,'2016-12-31 00:00:00','2016-12-31 00:00:00','Gestión de Usuarios'),(56,2,20,'2016-12-31 00:00:00','2016-12-31 00:00:00','Descargar resultados'),(3165,2,14,'2016-12-31 00:00:00','2016-12-31 00:00:00','Adjudicación'),(3166,2,15,'2016-12-31 00:00:00','2016-12-31 00:00:00','Generar Adjudicación'),(3167,4,18,'2016-12-31 00:00:00','2016-12-31 00:00:00','Carga Masiva de Aceptaciones'),(57,1,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(58,2,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(59,3,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(60,4,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(61,5,21,'2016-12-31 00:00:00','2016-12-31 00:00:00','Cambio de contrase?a'),(63,3,22,'2016-12-31 00:00:00','2016-12-31 00:00:00','Mantenedor SCB'),(64,5,22,'2016-12-31 00:00:00','2016-12-31 00:00:00','Mantenedor SCB'),(3168,3,23,'2016-01-01 00:00:00','2016-12-31 00:00:00','Diccionario de contraseñas'),(3180,5,18,'2016-12-31 00:00:00','2016-12-31 00:00:00','Carga Masiva de Aceptaciones'),(3178,5,15,'2016-12-31 00:00:00','2016-12-31 00:00:00','Generar Adjudicación'),(3177,5,20,'2016-12-31 00:00:00','2016-12-31 00:00:00','Descargar Resultados'),(3176,5,14,'2016-12-31 00:00:00','2016-12-31 00:00:00','Adjudicación'),(3175,5,23,'2016-01-01 00:00:00','2016-12-31 00:00:00','Diccionario de contraseñas'),(3181,2,24,'2016-12-01 00:00:00','2018-12-31 00:00:00','Generar BoletÃ­n'),(3182,5,24,'2016-12-01 00:00:00','2018-12-31 00:00:00','Generar BoletÃ­n'),(3183,2,25,'2016-01-01 00:00:00','2020-01-01 00:00:00','Auditoria'),(3184,5,25,'2016-01-01 00:00:00','2020-01-01 00:00:00','Auditoria');
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
) ENGINE=MyISAM AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_usuario`
--

LOCK TABLES `fqs_usuario` WRITE;
/*!40000 ALTER TABLE `fqs_usuario` DISABLE KEYS */;
INSERT INTO `fqs_usuario` VALUES (1,'CE','566363','Super','Administrador',NULL,NULL,'LMurillo@bvc.com.co','admin','rOlPSvb6jr6aq/u3UruaPg==','2018-02-21 15:50:19',0,0,'A','2018-02-21',0,NULL,'N','2018-01-31 17:38:49',0,90,1,NULL,'root@localhost',NULL,NULL),(2,'CC','80882230','Leonardo','Murillo',NULL,NULL,'LMurillo@bvc.com.co','lmurillo','rOlPSvb6jr6aq/u3UruaPg==','2017-02-15 15:04:49',0,0,'A','2017-02-14',0,NULL,'N','2017-02-15 15:01:12',0,90,1,'ogomez','root@localhost','2016-03-16 03:35:01','Modificación Usuario - Modificación'),(3,'CC','3066632','Esneider ','Hernandez Orjuela',NULL,NULL,'ehernandez@bvc.com.co','ehernandez','oiJ6V7ui+YmEjZaVtgWC6w==','2018-01-26 14:15:17',0,0,'A','2018-01-24',0,NULL,'N','2018-01-24 14:04:40',0,90,1,'admin','root@localhost','2017-01-23 14:43:07','Modificación Usuario - Modificación'),(4,'CC','1020741937','Melissa','Jaimes',NULL,NULL,'Ejaimes@bvc.com.co','ejaimes','rOlPSvb6jr6aq/u3UruaPg==','2017-01-23 18:01:18',0,0,'A','2017-03-07',0,NULL,'N','2017-02-02 10:32:32',0,90,0,'admin','root@localhost','2017-01-23 14:45:15','Modificación Usuario - Modificación'),(5,'CC','52516979','Diana','Nieto',NULL,NULL,'dnieto@bvc.com.co','dnieto','FWvSdEVgcu7fXeivSY79vg==',NULL,0,0,'A','2017-01-23',0,NULL,'N',NULL,0,90,0,'admin','root@localhost','2017-01-23 14:49:14','Modificación Usuario - Modificación'),(6,'CC','1015442702','Leidy','Navarro',NULL,NULL,'lnavarro@bvc.com.co','lnavarro','HYkU0Nl49Lld7SG99bIkDA==','2018-02-21 10:45:02',0,0,'A','2018-02-21',0,NULL,'N','2018-02-15 13:13:57',0,90,1,'ogomez','root@localhost','2017-01-23 14:50:26','Modificación Usuario - Modificación'),(7,'CC','51642094','Myriam','Robayo Carrillo',NULL,NULL,'MRobayo@bvc.com.co','mrobayo','zvThoZep5e7hVQdkcKx42Q==','2017-06-20 14:33:02',0,0,'A','2017-06-05',0,NULL,'N','2017-06-20 14:31:50',0,90,1,'sbravo','root@localhost','2017-01-23 16:36:37','Modificación Usuario - Modificación'),(119,'CC','1017163223','Paola Elizabeth ','Escudero Londono',NULL,NULL,'paola.escudero@btgpactual.com','1050002','MHcq0kJB0lLrugUxJCV2DA==','2018-02-20 11:27:39',0,0,'A','2018-02-14',0,NULL,'N','2018-02-20 10:41:46',0,50,1,'1050001','root@localhost','2018-02-14 15:35:41','Ingreso Usuario - Inserción'),(120,'CC','87065060','Esteban','Souza',NULL,NULL,'pseguridadinfo@bvc.com.co','esouza','I3XwVL0mKprCBLQY2xnx1Q==','2018-02-21 16:01:56',0,0,'A','2018-02-21',0,NULL,'N','2018-02-21 16:01:26',0,90,1,'admin','root@localhost','2018-02-21 21:00:56','Ingreso Usuario - Inserción'),(114,'CC','1073599008','Maria Alejandra ','Romero',NULL,NULL,'mromero@corredores.com','mromero','xPq/l6qGnPLdYaRjPc7PXg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,2,0,'1002001','root@localhost','2018-02-13 18:04:32','Ingreso Usuario - Inserción'),(115,'CC','1013605388','Katherine Johanna','Panader Munar',NULL,NULL,'kapanader@alianza.com.co','1018001','lRAtqzTdE64m0tHQrjDKAg==','2018-02-20 12:40:59',0,0,'A','2018-02-20',0,NULL,'N','2018-02-20 10:51:43',0,18,1,'ogomez','root@localhost','2018-02-13 19:51:06','Modificación Usuario - Modificación'),(116,'CC','79569211','RAFAEL ORLANDO','RODRIGUEZ RODRIGUEZ',NULL,NULL,'rorodriguez@alianza.com.co','rrodriguez','aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:18:23',0,0,'A','2018-02-13',0,NULL,'N','2018-02-20 10:52:47',0,18,1,'1018001','root@localhost','2018-02-13 21:10:59','Modificación Usuario - Modificación'),(117,'CC','80501110','WILSON DAVID','ABRIL GARCIA',NULL,NULL,'dabril@alianza.com.co','dabril','lRAtqzTdE64m0tHQrjDKAg==',NULL,0,0,'A','2018-02-13',0,NULL,'N','2018-02-20 10:53:20',0,18,0,'1018001','root@localhost','2018-02-13 21:11:57','Modificación Usuario - Modificación'),(118,'CC','16728398','ARTURO','RIVERA NIETO',NULL,NULL,'arrivera@alianza.com.co','arrivera','pHSq05X7wezRDHVN73Dndg==','2018-02-20 10:57:56',0,0,'A','2018-02-16',0,NULL,'N','2018-02-19 09:04:32',0,18,1,'1018001','root@localhost','2018-02-13 21:12:57','Modificación Usuario - Modificación'),(110,'CC','79763827','WILLIAM','SILVA',NULL,NULL,'wsilva@credicorpcapital.com','wsilva','OccjmXv3RONbOP8LahffeA==',NULL,0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 19:56:27','Ingreso Usuario - Inserción'),(111,'CC','52268165','MILENA','LEON',NULL,NULL,'mleon@credicorpcapital.com','mleon','V683IHKipk20RGGHh0EZdQ==','2018-02-20 10:30:50',0,0,'A','2018-02-15',0,NULL,'N','2018-02-16 10:33:18',0,29,1,'1029001','root@localhost','2018-01-12 20:05:04','Modificación Usuario - Modificación'),(112,'CC','1013632361','NICOLAS','GOMEZ',NULL,NULL,'ngomezm@credicorpcapital.com','ngomezm','jfvWmkZK1XcJbCTULxtVEQ==','2018-01-12 15:09:49',0,0,'A','2018-01-12',0,NULL,'N',NULL,0,29,0,'1029001','root@localhost','2018-01-12 20:07:33','Ingreso Usuario - Inserción'),(113,'CC','1015440542','Diana Milena','Gomez Diaz',NULL,NULL,'dgomez@corredores.com','dgomez','xPq/l6qGnPLdYaRjPc7PXg==',NULL,0,0,'A','2018-02-13',0,NULL,'N',NULL,0,2,0,'1002001','root@localhost','2018-02-13 18:00:34','Ingreso Usuario - Inserción'),(109,'CC','79656056','Carlos Eduardo','Garay Forero',NULL,NULL,'cgaray@credicorpcapital.com','1029001','DOPeGpAgGCDXIRc+oNkniA==','2018-02-19 09:24:45',0,0,'A','2018-02-15',0,NULL,'N','2018-02-15 11:26:24',0,29,1,'ogomez','root@localhost','2018-01-11 23:24:49','Modificación Usuario - Modificación'),(108,'CC','52789309','Jenny','Mendez Barreto',NULL,NULL,'jmendez@corredores.com','1002001','xPq/l6qGnPLdYaRjPc7PXg==','2018-02-19 18:22:44',0,0,'A','2018-02-13',0,NULL,'N','2018-02-19 18:22:22',0,2,1,'ogomez','root@localhost','2018-01-11 23:23:34','Modificación Usuario - Modificación'),(60,'CC','1095800722','Jonathan','Sandoval',NULL,NULL,'jsandoval@bvc.com.co','jsandoval','cOhLdF+zbUz4UUjlhnva9A==','2017-06-16 12:27:38',0,0,'B','2017-06-05',0,NULL,'N','2017-06-01 20:15:47',0,90,1,'ogomez','root@localhost','2017-02-14 18:39:04','Modificación Usuario - Modificación'),(61,'CC','1053826158','Orlando','Gomez',NULL,NULL,'ogomez@bvc.com.co','ogomez','rOlPSvb6jr6aq/u3UruaPg==','2018-02-21 15:49:41',0,0,'A','2018-02-12',0,NULL,'N','2018-02-16 11:35:53',0,90,1,'admin','root@localhost','2017-02-14 18:40:41','Modificación Usuario - Modificación'),(104,'CC','43503083','MARIA EUNICE','GIRALDO ZULUAGA',NULL,NULL,'MARGIRAL@BANCOLOMBIA.COM.CO','margiral','006a9mhQItfn81Uks6JMIA==','2018-01-09 16:32:55',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,1,'1010001','root@localhost','2018-01-09 18:51:02','Ingreso Usuario - Inserción'),(105,'CC','98557761','JUAN MARTIN','OCHOA VASCO',NULL,NULL,'JMOCHOA@BANCOLOMBIA.COM.CO','jmochoa','bLuRfQ61fkxAL73myxZOEw==',NULL,0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,0,'1010001','root@localhost','2018-01-09 18:52:25','Ingreso Usuario - Inserción'),(106,'CC','1152458082','LUIS GABRIEL','JARAMILLO GIRALDO',NULL,NULL,'LUJARAMI@BANCOLOMBIA.COM.CO','lujarami','ZTPkgUC69A+eY8xOzUfvAQ==','2018-01-09 14:31:25',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,1,'1010001','root@localhost','2018-01-09 19:01:30','Ingreso Usuario - Inserción'),(107,'CC','1020768880','NATHALY','JIMENEZ PALENCIA',NULL,NULL,'nathaly.jimenez@itau.co','1004002','yUZl+eFGxffItuUxCrNJVg==','2018-02-01 10:38:49',0,0,'A','2018-01-30',0,NULL,'N','2018-02-01 10:37:57',0,4,1,'1004001','root@localhost','2018-01-10 16:00:12','Modificación Usuario - Modificación'),(103,'CC','43267928','JOHANNA REGINA','LEZCANO GRACIANO',NULL,NULL,'JLEZCANO@BANCOLOMBIA.COM.CO','jlezcano','JP/zuSp86jydA8V0HJ60Pg==','2018-01-23 10:51:26',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,1,'1010001','root@localhost','2018-01-09 18:49:39','Ingreso Usuario - Inserción'),(69,'CC','1019044741','Sandra Lizeth','Bravo Cardona',NULL,NULL,'sbravo@bvc.com.co','sbravo','QvthVbSA+GazWX2rNeyyTA==','2017-06-16 12:28:59',0,0,'I','2017-06-01',0,NULL,'N','2017-06-14 15:46:05',0,90,1,'admin','root@localhost','2017-06-01 13:04:40','Modificación Usuario - Modificación'),(89,'CC','1072658172','Luis Felipe','Muneton Narvaez',NULL,NULL,'lmuneton@bvc.com.co','lmuneton','eSxet+covafWxdMkSyrT2g==','2018-02-21 08:20:29',0,0,'A','2018-02-07',0,NULL,'N','2017-06-13 13:30:27',0,90,1,'sbravo','root@localhost','2017-06-09 17:07:52','Ingreso Usuario - Inserción'),(96,'CC','1136885240','Jonathan Javier','Herrera Sanchez',NULL,NULL,'jhonatan.herrera@itau.co','1004001','3f6ASQ6EpnKVcSEjoPjM1w==','2018-01-10 10:57:29',0,0,'A','2018-01-09',0,NULL,'N','2018-01-09 13:59:17',0,4,1,'ogomez','root@localhost','2018-01-09 16:11:38','Modificación Usuario - Modificación'),(102,'CC','8203339','HILBERT DAVID','TRESPALACIOS VILLERA',NULL,NULL,'HITRESPA@BANCOLOMBIA.COM.CO','hitrespa','3K2QOSimrhTmqeT45p7gAw==','2018-02-20 10:43:18',0,0,'A','2018-02-01',0,NULL,'N','2018-02-15 08:06:43',0,10,1,'1010001','root@localhost','2018-01-09 18:48:13','Ingreso Usuario - Inserción'),(101,'CC','8160880','Juan Carlos','Velasquez Gaviria',NULL,NULL,'JCVELASQ@BANCOLOMBIA.COM.CO','jcvelasq','ZWeFJqexVcVfM9AyIAi31w==','2018-01-09 16:10:58',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,1,'1010001','root@localhost','2018-01-09 18:46:04','Ingreso Usuario - Inserción'),(100,'CC','1020432957','JUAN ESTEBAN','BERMUDEZ CASTRILLON',NULL,NULL,'juan.bermudez@globalcdb.com','jebermudez','tsGO7W7TKkDjmwgD1bgBCA==','2018-01-09 12:32:21',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,51,1,'1051000','root@localhost','2018-01-09 17:26:22','Ingreso Usuario - Inserción'),(97,'CC','1017137640','Eddier Jhonnatan','Velasquez Quintero',NULL,NULL,'edvelasq@bancolombia.com.co','1010001','bLuRfQ61fkxAL73myxZOEw==','2018-01-09 13:37:54',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,10,1,'ogomez','root@localhost','2018-01-09 16:13:10','Ingreso Usuario - Inserción'),(98,'CC','8128088','Edwin Mauricio','Castaneda Garcia',NULL,NULL,'edwin.castaneda@btgpactual.com','1050001','MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:31:16',0,0,'B','2018-02-14',2,NULL,'N','2018-02-19 10:41:58',0,50,1,'ogomez','root@localhost','2018-01-09 16:15:32','Modificación Usuario - Modificación'),(99,'CC','12234450','Julio Cesar','Abaunza Gamez',NULL,NULL,'julio.abaunza@globalcdb.com','1051000','C5ndDl49MCne73CC+8mQog==','2018-01-09 12:16:29',0,0,'A','2018-01-09',0,NULL,'N',NULL,0,51,1,'ogomez','root@localhost','2018-01-09 16:17:37','Ingreso Usuario - Inserción');
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
INSERT INTO `fqs_usuario_has_fqs_perfil` VALUES (1,5,'N'),(2,3,'N'),(3,2,'N'),(4,2,'N'),(5,2,'N'),(6,2,'N'),(7,2,'N'),(116,4,'N'),(115,1,'N'),(114,4,'N'),(113,4,'N'),(112,4,'N'),(111,4,'N'),(110,4,'N'),(109,1,'N'),(108,1,'N'),(107,4,'N'),(106,4,'N'),(105,4,'N'),(104,4,'N'),(103,4,'N'),(102,4,'N'),(101,4,'N'),(60,3,'N'),(61,3,'N'),(100,4,'N'),(99,1,'N'),(98,1,'N'),(69,3,'N'),(89,2,'N'),(120,3,'N'),(97,1,'N'),(96,1,'N'),(119,4,'N'),(118,4,'N'),(117,4,'N');
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
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fqs_usuario_password_historial`
--

LOCK TABLES `fqs_usuario_password_historial` WRITE;
/*!40000 ALTER TABLE `fqs_usuario_password_historial` DISABLE KEYS */;
INSERT INTO `fqs_usuario_password_historial` VALUES (1,107,'RKnjd7l5wIRAqUZ+dPiclQ==','2018-01-10 11:00:12','96'),(2,107,'LSRLkxtPDKJX/fKzQk4tBA==','2018-01-10 11:41:02','107'),(3,89,'JLj2NC1fa7ZoTPyoqUTXBw==','2018-01-11 13:57:19','89'),(4,6,'wq5iz+BD3JW4i2YVDt2bdw==','2018-01-11 17:59:37','61'),(5,108,'XOvhFRuFAS85b1XR5tbxWg==','2018-01-11 18:23:34','61'),(6,109,'XOvhFRuFAS85b1XR5tbxWg==','2018-01-11 18:24:49','61'),(7,108,'yUZl+eFGxffItuUxCrNJVg==','2018-01-11 18:57:08','108'),(8,109,'1qWhnOGZnc6SeM8erARmqg==','2018-01-12 07:03:48','109'),(9,110,'OccjmXv3RONbOP8LahffeA==','2018-01-12 14:56:27','109'),(10,6,'kWs1UK6ktB9I5ADMZY/CmA==','2018-01-12 15:01:22','6'),(11,111,'jfvWmkZK1XcJbCTULxtVEQ==','2018-01-12 15:05:04','109'),(12,112,'jfvWmkZK1XcJbCTULxtVEQ==','2018-01-12 15:07:33','109'),(13,111,'9ZIhhFB96FvRk0QrCG2LXA==','2018-01-12 15:41:59','111'),(14,98,'wq5iz+BD3JW4i2YVDt2bdw==','2018-01-17 18:14:48','61'),(15,3,'JZm5c7gWZSq6eNOzApDltg==','2018-01-24 14:06:40','3'),(16,107,'yUZl+eFGxffItuUxCrNJVg==','2018-01-30 08:17:36','107'),(17,102,'3K2QOSimrhTmqeT45p7gAw==','2018-02-01 08:49:42','102'),(18,6,'v0UPEpZo95OBGgxliW1neg==','2018-02-01 13:51:00','6'),(19,111,'7JfOVijXbkQb1MnpH2YWzg==','2018-02-01 17:59:15','111'),(20,89,'eSxet+covafWxdMkSyrT2g==','2018-02-07 14:02:22','89'),(21,61,'rOlPSvb6jr6aq/u3UruaPg==','2018-02-12 22:56:28','61'),(22,108,'rOlPSvb6jr6aq/u3UruaPg==','2018-02-12 22:57:24','61'),(23,108,'xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 10:18:22','108'),(24,113,'xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 13:00:34','108'),(25,114,'xPq/l6qGnPLdYaRjPc7PXg==','2018-02-13 13:04:32','108'),(26,115,'0M7Pxj83XcUGyJ3AbVp+Kw==','2018-02-13 14:51:06','61'),(27,115,'z1BrrKD7rjKIu7pwj6o+Aw==','2018-02-13 16:07:44','115'),(28,116,'lRAtqzTdE64m0tHQrjDKAg==','2018-02-13 16:10:59','115'),(29,117,'lRAtqzTdE64m0tHQrjDKAg==','2018-02-13 16:11:57','115'),(30,118,'lRAtqzTdE64m0tHQrjDKAg==','2018-02-13 16:12:57','115'),(31,116,'aUWeUiberEgqQkE1nkFc3Q==','2018-02-13 16:19:15','116'),(32,98,'MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:34:31','98'),(33,119,'5sS8vQCj0lSWDyDcE9W9VA==','2018-02-14 10:35:41','98'),(34,119,'MHcq0kJB0lLrugUxJCV2DA==','2018-02-14 10:36:31','119'),(35,109,'lRAtqzTdE64m0tHQrjDKAg==','2018-02-15 11:27:00','61'),(36,109,'DOPeGpAgGCDXIRc+oNkniA==','2018-02-15 11:28:49','109'),(37,111,'7CUFURoonQbyyLmRQkV1JA==','2018-02-15 11:29:18','109'),(38,111,'V683IHKipk20RGGHh0EZdQ==','2018-02-15 12:06:02','111'),(39,118,'pHSq05X7wezRDHVN73Dndg==','2018-02-16 11:38:17','118'),(40,115,'XOvhFRuFAS85b1XR5tbxWg==','2018-02-16 12:41:44','61'),(41,115,'H/KDJt2g3iahBvRQBP/RyQ==','2018-02-20 12:31:20','61'),(42,115,'lRAtqzTdE64m0tHQrjDKAg==','2018-02-20 12:41:39','115'),(43,6,'HYkU0Nl49Lld7SG99bIkDA==','2018-02-21 08:04:05','6'),(44,1,'rOlPSvb6jr6aq/u3UruaPg==','2018-02-21 15:50:42','1'),(45,120,'xHGAZvHeOOOVI+Xrs2Q/eQ==','2018-02-21 16:00:56','1'),(46,120,'I3XwVL0mKprCBLQY2xnx1Q==','2018-02-21 16:02:39','120');
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
INSERT INTO `seq` VALUES ('dm_formulario',29),('dm_ofertante',333945),('dm_adjudicado',0),('fqs_CrearAceptacion',0);
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
		UPDATE au_Interfaz20 SET consecutivo = 0, fechaGeneracion = NOW()
        WHERE consecutivo != 0;
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

-- Dump completed on 2018-02-22 13:10:01
