ALTER TABLE `fqs_crearaceptacion`
	ALTER `Nombre` DROP DEFAULT;
ALTER TABLE `fqs_crearaceptacion`
	CHANGE COLUMN `Nombre` `NombreRazonSocial` VARCHAR(60) NOT NULL AFTER `RepresentanteLegal`,
	DROP COLUMN `ApellidoRazonSocial`;
	
	
ALTER TABLE au_crearaceptacion
	ALTER `Nombre` DROP DEFAULT;
ALTER TABLE au_crearaceptacion
	CHANGE COLUMN `Nombre` `NombreRazonSocial` VARCHAR(60) NOT NULL AFTER `RepresentanteLegal`,
	DROP COLUMN `ApellidoRazonSocial`;