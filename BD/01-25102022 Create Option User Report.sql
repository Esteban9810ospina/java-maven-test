/*
Nueva opción reporte de Usuarios
*/
INSERT INTO fqs_pagina (i_codigopagina, c_nombre, c_descripcion, c_subtitulo) VALUES (24, 'com.framework.common.ui.contents.ReporteUsuario', 'REPORTE USUARIOS', NULL);
INSERT INTO fqs_opcionmodulo (i_opcionmodulo, i_modulosistema, i_codigopagina, c_nombre, c_descripcion, i_estado, i_orden, i_opciondepende) VALUES (27, 0, 24, 'Reporte de usuarios', '--', 1, 3, 10);
INSERT INTO fqs_permiso (i_permiso, i_perfil, i_opcionmodulo, dt_horainipermiso, dt_horafinpermiso, c_descripcion) VALUES (3189, 2, 27, '1000-01-01 00:00:00', '1000-01-01 00:00:00', 'Reporte de usuarios');