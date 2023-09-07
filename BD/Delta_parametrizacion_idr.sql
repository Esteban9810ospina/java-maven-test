ALTER TABLE `fqs_parametrizacion`
	ADD COLUMN `comisionCompra` DECIMAL(16,3) NOT NULL AFTER `AccionesEnCirculacion`;
ALTER TABLE `fqs_parametrizacion`
	ADD COLUMN `referenciaComprador` VARCHAR(8) NULL DEFAULT '' AFTER `comisionCompra`;