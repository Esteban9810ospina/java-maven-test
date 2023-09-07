
ALTER TABLE `au_parametrizacion`
	ADD COLUMN `comisionCompra` DECIMAL(6,3) NOT NULL DEFAULT '0.000' AFTER `AccionesEnCirculacion`;
ALTER TABLE `au_parametrizacion`
	ADD COLUMN `referenciaComprador` VARCHAR(8) NULL DEFAULT '' AFTER `comisionCompra`;
	

