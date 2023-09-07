ALTER TABLE `fqs_usuario`
	ADD COLUMN `c_llave_codificada` VARCHAR(100) NOT NULL DEFAULT '' AFTER `c_contrasena`;

