USE `opa2`;

DELIMITER $$

DROP TRIGGER IF EXISTS opa2.fqs_CrearAceptacionInsert$$
USE `opa2`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `fqs_CrearAceptacionInsert` AFTER INSERT ON `fqs_crearaceptacion` FOR EACH ROW BEGIN

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
END$$
DELIMITER ;
