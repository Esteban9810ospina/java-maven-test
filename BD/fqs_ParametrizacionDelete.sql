DELIMITER |
CREATE TRIGGER `fqs_ParametrizacionDelete` AFTER DELETE ON `fqs_Parametrizacion` FOR EACH ROW BEGIN
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
`TxtBulletinInformative`,
`AccionesEnCirculacion`,
`comisionCompra`,
`referenciaComprador`,
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
SESSION_USER(),
NOW(),
OLD.TxtBulletinInformative,
OLD.AccionesEnCirculacion,
OLD.comisionCompra,
OLD.referenciaComprador,
'BORRADO REGISTRO');
END