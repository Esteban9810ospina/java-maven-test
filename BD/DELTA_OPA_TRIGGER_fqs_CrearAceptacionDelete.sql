USE `opa2`;

DELIMITER $$

DROP TRIGGER IF EXISTS opa2.fqs_CrearAceptacionDelete$$
USE `opa`$$
CREATE DEFINER = CURRENT_USER TRIGGER `opa`.`fqs_CrearAceptacionDelete` AFTER DELETE ON `fqs_crearaceptacion` FOR EACH ROW
BEGIN
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
END$$
DELIMITER ;
