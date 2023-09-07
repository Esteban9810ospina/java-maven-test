ALTER TABLE `fqs_opcionmodulo`
	CHANGE COLUMN `c_nombre` `c_nombre` VARCHAR(36) NOT NULL DEFAULT '' COLLATE 'utf8_general_ci' AFTER `i_codigopagina`;
	
UPDATE `migracion`.`fqs_opcionmodulo` SET `c_nombre`='Modificación/Rechazo de Aceptaciones' WHERE  `i_opcionmodulo`=17;

ALTER TABLE `fqs_logusuariosadmin`
	CHANGE COLUMN `c_paginaingreso` `c_paginaingreso` VARCHAR(36) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci' AFTER `dt_horaingreso`;
	
ALTER TABLE `fqs_logusuariosadmin`
	CHANGE COLUMN `dt_horaingreso` `dt_horaingreso` DATETIME NOT NULL AFTER `c_usuario`,
	CHANGE COLUMN `c_paginaingreso` `c_paginaingreso` VARCHAR(36) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci' AFTER `dt_horaingreso`;