/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.data.FqsParametrizacion;
import com.quasar.frameq.parametros.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Colsubsidio
 */
public class FacadeParametros {

    private static final Logger logger = Logger.getLogger(FacadeParametros.class.getName());

    public int ValidarTotalRegParametrizacion() {
        int VariableLocal_Resultado = 1;
        Parametro ValidarParametro = new Parametro();
        try {
            ValidarParametro.consultaLectura("SELECT Count(EntidadDeNegociosID) AS 'RESULTADO' FROM fqs_Parametrizacion;");
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = Integer.parseInt(ValidarParametro.rs.getString("RESULTADO"));

            } else {
                VariableLocal_Resultado = 1;
            }

        } catch (Exception e) {
            VariableLocal_Resultado = 1;

        } finally {
            ValidarParametro.cerrarConexiones();
        }
        return VariableLocal_Resultado;
    }

    //Guarda Parametrización OPA
    public String IngresarParametrizacion(int parametro_usario, String parametro_FechaIniOp, String paramero_HoraIniOp, String parametro_FechaFinOp, String parametro_HoraFinOp,
            String parametro_MinAccionesObjOf, String parametro_MaxAccionesObjOf, String parametro_NombreRazonSocial, String parametro_PrecioAc,
            int parametro_NumeroAcp, String parametro_TextoUno, String parametro_TextoDos, int parametro_ExistePreacuerdo, int parametro_CantRpt,
            String parametro_Nanotecnico, String parametro_ClaseDeAcciones, int parametro_CantUsOp, int parametro_UsCrea,
            String parametro_FechaCrea, int parametro_UsModi, String parametro_FechaModi, int parametro_TodooNada, int parametro_ActivarCm,
            String c_usuario_sistema_ultima_mod, String ts_fecha_hora_ultima_modificacion,
            Integer tipoDocumentoOferente, String numeroDocumentoOferente, String DVOferente, String especialFiduciarioOferente, 
            Integer cuentaDecevalOferente, Integer scbOferente, String paramero_HoraIniCarga, String parametro_HoraFinCarga, 
            String parametro_AccionesNegociadas, String parametro_TxtBoletinInfo,String parametro_umbral, String parametro_precioaccionespago, 
            String parametro_porcentajeefectivopago, String tipoOfertaPublica, int parametro_direccion, int parametro_MILA,String txtBulletinInformative,String accionesEnCirculacion, String comisionCompra, String referenciaComprador) {
        Parametro IngresarParametro = new Parametro();
        String variablelocal_resultado = null;
        String variablelocal_consulta = null;

        logger.info("DV que llega - " + DVOferente);
        String resul = "";
        try {
            if (ValidarTotalRegParametrizacion() == 0) {
                String c_tipo_modificacion = "Ingreso Parametro - Inserción";
                String query = "INSERT INTO fqs_Parametrizacion (UsuarioID, FechaIniOperacion, HoraIniOperacion, FechaFinOperacion, "
                        + "HoraFinOperacion, MinAccionesObjOferta, MaxAccionesObjOferta, NombreRazonSocial, "
                        + "PrecioAceptaciones, comisionCompra, referenciaComprador, NumeroAceptacion, TextoUno, TextoDos, ExistePreacuerdo, CantReporte, "
                        + "Nanotecnico, ClaseAcciones, CantUsuariosOpe, NombreUsuarioIdCreacion, FechaCreacion, "
                        + "NombreUsuarioIdModificacion, FechaModificacion, TodoONada, ActivarCargaMasiva, "
                        + "TipoDocumentoOferente, NumeroDocumentoOferente, DVOferente, EFOferente, CuentaDecevalOferente, SCBOferente, "
                        + "c_usuario_sistema_ultima_mod, ts_fecha_hora_ultima_modificacion, c_tipo_modificacion,HoraIniOperacionCarga,HoraFinOperacionCarga,Accionesnegociadas,TxtBoletinInformativo,"
                        + "umbral,precioaccionespago,porcentajeefectivopago, tipo_oferta_publica, direccion, MILA,TxtBulletinInformative,AccionesEnCirculacion) VALUES ('" + parametro_usario
                        + "', '" + parametro_FechaIniOp
                        + "', '" + paramero_HoraIniOp
                        + "', '" + parametro_FechaFinOp
                        + "', '" + parametro_HoraFinOp
                        + "', '" + parametro_MinAccionesObjOf
                        + "', '" + parametro_MaxAccionesObjOf
                        + "', '" + parametro_NombreRazonSocial
                        + "', '" + parametro_PrecioAc
                        + "', '" + comisionCompra
                        + "', '" + referenciaComprador
                        + "', '" + parametro_NumeroAcp
                        + "', '" + parametro_TextoUno
                        + "', '" + parametro_TextoDos
                        + "', '" + parametro_ExistePreacuerdo
                        + "', '" + parametro_CantRpt
                        + "', '" + parametro_Nanotecnico
                        + "', '" + parametro_ClaseDeAcciones
                        + "', '" + parametro_CantUsOp
                        + "', '" + parametro_UsCrea
                        + "', '" + parametro_FechaCrea
                        + "', '" + parametro_UsModi
                        + "', '" + parametro_FechaModi
                        + "', '" + parametro_TodooNada
                        + "', '" + parametro_ActivarCm
                        + "', '" + tipoDocumentoOferente
                        + "', '" + numeroDocumentoOferente
                        + "', '" + DVOferente
                        + "', '" + especialFiduciarioOferente
                        + "', '" + cuentaDecevalOferente
                        + "', '" + scbOferente
                        + "', '" + c_usuario_sistema_ultima_mod
                        + "', '" + ts_fecha_hora_ultima_modificacion
                        + "', '" + c_tipo_modificacion
                        + "', '" + paramero_HoraIniCarga
                        + "', '" + parametro_HoraFinCarga
                        + "', '" + parametro_AccionesNegociadas
                        + "', '" + parametro_TxtBoletinInfo
                        + "', '" + parametro_umbral
                        + "', '" + parametro_precioaccionespago
                        + "', '" + parametro_porcentajeefectivopago
                        + "', '" + tipoOfertaPublica
                        + "', '" + parametro_direccion
                        + "', " + parametro_MILA
                        + ", '" + txtBulletinInformative
                        + "', " + accionesEnCirculacion

                        +")";
                if (IngresarParametro.actualizar(query) == 1) {
                    resul = "Parametrización Creada Satisfactoriamente";
                } else {
                    resul = "Error en la actualización de la parametrización";
                }
            } else {
                String c_tipo_modificacion = "Actualizar Parametro - Actualización";
                if (IngresarParametro.actualizar("UPDATE fqs_Parametrizacion SET UsuarioID = '" + parametro_usario + "', FechaIniOperacion = '" + parametro_FechaIniOp + "', HoraIniOperacion = '" + paramero_HoraIniOp + "', FechaFinOperacion = '" + parametro_FechaFinOp + "', "
                        + " HoraFinOperacion = '" + parametro_HoraFinOp + "', MinAccionesObjOferta = '" + parametro_MinAccionesObjOf + "', MaxAccionesObjOferta = '" + parametro_MaxAccionesObjOf + "', NombreRazonSocial = '" + parametro_NombreRazonSocial + "', "
                        + "PrecioAceptaciones = '" + parametro_PrecioAc + "', NumeroAceptacion = '" + parametro_NumeroAcp + "', TextoUno = '" + parametro_TextoUno + "', TextoDos = '" + parametro_TextoDos + "', ExistePreacuerdo = '" + parametro_ExistePreacuerdo + "', CantReporte = '" + parametro_CantRpt + "', "
                        + "Nanotecnico = '" + parametro_Nanotecnico + "', ClaseAcciones = '" + parametro_ClaseDeAcciones + "', CantUsuariosOpe = '" + parametro_CantUsOp + "', NombreUsuarioIdCreacion = '" + parametro_UsCrea + "', "
                        + "c_tipo_modificacion = '" + c_tipo_modificacion + "', NombreUsuarioIdModificacion = '" + parametro_UsModi + "', FechaModificacion = '" + parametro_FechaModi + "', c_usuario_sistema_ultima_mod = '" + c_usuario_sistema_ultima_mod + "',ts_fecha_hora_ultima_modificacion = '" + ts_fecha_hora_ultima_modificacion + "', TodoONada = '" + parametro_TodooNada + "', ActivarCargaMasiva = '" + parametro_ActivarCm + "',"
                        + "TipoDocumentoOferente=" + tipoDocumentoOferente + ", NumeroDocumentoOferente='" + numeroDocumentoOferente + "', DVOferente='" + DVOferente + "', EFOferente='" + especialFiduciarioOferente + "', CuentaDecevalOferente=" + cuentaDecevalOferente + ", SCBOferente= " + scbOferente + ",HoraIniOperacionCarga = '" + paramero_HoraIniCarga + "'" + ",HoraFinOperacionCarga = '" + parametro_HoraFinCarga + "', Accionesnegociadas ='" + 
                        parametro_AccionesNegociadas + "', TxtBoletinInformativo = '" + parametro_TxtBoletinInfo + "', tipo_oferta_publica = '" + tipoOfertaPublica + "', direccion = " + parametro_direccion + ", MILA = " + parametro_MILA+",  TxtBulletinInformative = '"+ txtBulletinInformative+"', comisionCompra='" + comisionCompra + "', referenciaComprador='" + referenciaComprador + "', AccionesEnCirculacion = "+accionesEnCirculacion ) == 1) {
                    resul = "Parametrización Actualizada Satisfactoriamente";
                } else {
                    resul = "Error en la actualización de la parametrización";
                }
            }

		            System.out.println("Parametrizacion cargada");
												  
        } catch (Exception e) {
            resul = "Hubo un Error Al Momento de Crear La Parametrización";

        } finally {
            IngresarParametro.cerrarConexiones();
        }
		        System.out.println("Retorno Parametrizacion "+resul);
													 
        return resul;
    }

    //Guarda parametrización OPI
    public String IngresarParametrizacion(int parametro_usario, String parametro_FechaIniOp, String paramero_HoraIniOp, String parametro_FechaFinOp, String parametro_HoraFinOp,
            String parametro_MinAccionesObjOf, String parametro_MaxAccionesObjOf, String parametro_NombreRazonSocial, String parametro_PrecioAc,
            int parametro_NumeroAcp, String parametro_TextoUno, String parametro_TextoDos, int parametro_ExistePreacuerdo, int parametro_CantRpt,
            String parametro_Nanotecnico, String parametro_ClaseDeAcciones, int parametro_CantUsOp, int parametro_UsCrea,
            String parametro_FechaCrea, int parametro_UsModi, String parametro_FechaModi, int parametro_TodooNada, int parametro_ActivarCm,
            String c_usuario_sistema_ultima_mod, String ts_fecha_hora_ultima_modificacion,
            Integer tipoDocumentoOferente, String numeroDocumentoOferente, String DVOferente, String especialFiduciarioOferente, 
            Integer cuentaDecevalOferente, Integer scbOferente, String paramero_HoraIniCarga, String parametro_HoraFinCarga,
            String parametro_AccionesNegociadas, String parametro_TxtBoletinInfo, String parametro_umbral, String parametro_precioaccionespago, 
            String parametro_porcentajeefectivopago, String parametro_TextoTres, String parametro_TextoCuatro, String parametro_TextoCinco, 
            String parametro_TextoSeis, String parametro_TextoSiete, String tipoOfertaPublica, int tipoPago, int parametro_direccion, int parametro_MILA,
            String txtBulletinInformative,String accionesEnCirculacion) {

        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Parametro IngresarParametro = new Parametro();
        String variablelocal_resultado = null;
        String variablelocal_consulta = null;

        String resul = "";
        try {
            if (ValidarTotalRegParametrizacion() == 0) {
                String c_tipo_modificacion = "Ingreso Parametro - Inserción";                          
                if (IngresarParametro.actualizar("INSERT INTO fqs_Parametrizacion (UsuarioID, FechaIniOperacion, HoraIniOperacion, FechaFinOperacion, "
                        + "HoraFinOperacion, MinAccionesObjOferta, MaxAccionesObjOferta, NombreRazonSocial, "
                        + "PrecioAceptaciones, NumeroAceptacion, TextoUno, TextoDos, ExistePreacuerdo, CantReporte, "
                        + "Nanotecnico, ClaseAcciones, CantUsuariosOpe, NombreUsuarioIdCreacion, FechaCreacion, "
                        + "NombreUsuarioIdModificacion, FechaModificacion, TodoONada, ActivarCargaMasiva, "
                        + "TipoDocumentoOferente, NumeroDocumentoOferente, DVOferente, EFOferente, CuentaDecevalOferente, SCBOferente, "
                        + "c_usuario_sistema_ultima_mod, ts_fecha_hora_ultima_modificacion, c_tipo_modificacion,HoraIniOperacionCarga,HoraFinOperacionCarga,Accionesnegociadas,"
                        + "TxtBoletinInformativo, umbral,precioaccionespago,porcentajeefectivopago, TextoTres, TextoCuatro, TextoCinco,TextoSeis,TextoSiete, tipo_oferta_publica, "
                        + "tipo_pago, direccion, MILA,,TxtBulletinInformative,AccionesEnCirculacion) VALUES ('" + parametro_usario
                        + "', '" + parametro_FechaIniOp
                        + "', '" + paramero_HoraIniOp
                        + "', '" + parametro_FechaFinOp
                        + "', '" + parametro_HoraFinOp
                        + "', '" + parametro_MinAccionesObjOf
                        + "', '" + parametro_MaxAccionesObjOf
                        + "', '" + parametro_NombreRazonSocial
                        + "', '" + parametro_PrecioAc
                        + "', '" + parametro_NumeroAcp
                        + "', '" + parametro_TextoUno
                        + "', '" + parametro_TextoDos
                        + "', '" + parametro_ExistePreacuerdo
                        + "', '" + parametro_CantRpt
                        + "', '" + parametro_Nanotecnico
                        + "', '" + parametro_ClaseDeAcciones
                        + "', '" + parametro_CantUsOp
                        + "', '" + parametro_UsCrea
                        + "', '" + parametro_FechaCrea
                        + "', '" + parametro_UsModi
                        + "', '" + parametro_FechaModi
                        + "', '" + parametro_TodooNada
                        + "', '" + parametro_ActivarCm
                        + "', '" + tipoDocumentoOferente
                        + "', '" + numeroDocumentoOferente
                        + "', '" + DVOferente
                        + "', '" + especialFiduciarioOferente
                        + "', '" + cuentaDecevalOferente
                        + "', '" + scbOferente
                        + "', '" + c_usuario_sistema_ultima_mod
                        + "', '" + ts_fecha_hora_ultima_modificacion
                        + "', '" + c_tipo_modificacion
                        + "', '" + paramero_HoraIniCarga
                        + "', '" + parametro_HoraFinCarga
                        + "', '" + parametro_AccionesNegociadas
                        + "', '" + parametro_TxtBoletinInfo
                        + "', '" + parametro_umbral
                        + "', '" + parametro_precioaccionespago
                        + "', '" + parametro_porcentajeefectivopago
                        + "', '" + parametro_TextoTres
                        + "', '" + parametro_TextoCuatro
                        + "', '" + parametro_TextoCinco
                        + "', '" + parametro_TextoSeis
                        + "', '" + parametro_TextoSiete
                        + "', '" + tipoOfertaPublica
                        + "', '" + tipoPago
                        + "', '" + parametro_direccion
                        + "', " + parametro_MILA
                        + ", '" + txtBulletinInformative
                        + "', " + accionesEnCirculacion
                        + ")") == 1) {
                    resul = "Parametrización Creada Satisfactoriamente";
                } else {
                    resul = "Error en la actualización de la parametrización";
                }
            } else {
                String c_tipo_modificacion = "Actualizar Parametro - Actualización";
                if (IngresarParametro.actualizar("UPDATE fqs_Parametrizacion SET UsuarioID = '" + parametro_usario + "', FechaIniOperacion = '" + parametro_FechaIniOp + "', HoraIniOperacion = '" + paramero_HoraIniOp + "', FechaFinOperacion = '" + parametro_FechaFinOp + "', "
                        + " HoraFinOperacion = '" + parametro_HoraFinOp + "', MinAccionesObjOferta = '" + parametro_MinAccionesObjOf + "', MaxAccionesObjOferta = '" + parametro_MaxAccionesObjOf + "', NombreRazonSocial = '" + parametro_NombreRazonSocial + "', "
                        + "PrecioAceptaciones = '" + parametro_PrecioAc + "', NumeroAceptacion = '" + parametro_NumeroAcp + "', TextoUno = '" + parametro_TextoUno + "', TextoDos = '" + parametro_TextoDos + "', TextoTres = '" + parametro_TextoTres + "', TextoCuatro = '" + parametro_TextoCuatro + "', TextoCinco = '" + parametro_TextoCinco + "', TextoSeis = '" + parametro_TextoSeis + "', TextoSiete = '" + parametro_TextoSiete + "', ExistePreacuerdo = '" + parametro_ExistePreacuerdo + "', CantReporte = '" + parametro_CantRpt + "', "
                        + "Nanotecnico = '" + parametro_Nanotecnico + "', ClaseAcciones = '" + parametro_ClaseDeAcciones + "', CantUsuariosOpe = '" + parametro_CantUsOp + "', NombreUsuarioIdCreacion = '" + parametro_UsCrea + "', "
                        + "c_tipo_modificacion = '" + c_tipo_modificacion + "', NombreUsuarioIdModificacion = '" + parametro_UsModi + "', FechaModificacion = '" + parametro_FechaModi + "', c_usuario_sistema_ultima_mod = '" + c_usuario_sistema_ultima_mod + "',ts_fecha_hora_ultima_modificacion = '" + ts_fecha_hora_ultima_modificacion + "', TodoONada = '" + parametro_TodooNada + "', ActivarCargaMasiva = '" + parametro_ActivarCm + "',"
                        + "TipoDocumentoOferente=" + tipoDocumentoOferente + ", NumeroDocumentoOferente='" + numeroDocumentoOferente + "', DVOferente='" + DVOferente + "', EFOferente='" + especialFiduciarioOferente + "', CuentaDecevalOferente=" + cuentaDecevalOferente + ", SCBOferente= " + scbOferente + ",HoraIniOperacionCarga = '" + paramero_HoraIniCarga + "'" + ",HoraFinOperacionCarga = '" + parametro_HoraFinCarga 
                        + "', Accionesnegociadas ='" + parametro_AccionesNegociadas + "', TxtBoletinInformativo = '" + parametro_TxtBoletinInfo + "',umbral = " + parametro_umbral + ",precioaccionespago = " + parametro_precioaccionespago + ",porcentajeefectivopago = " + parametro_porcentajeefectivopago + ",tipo_oferta_publica = '" + tipoOfertaPublica + "'" + ",tipo_pago = '" + tipoPago + "', direccion = " + parametro_direccion + " , MILA = " + parametro_MILA+",  TxtBulletinInformative = '"+ txtBulletinInformative+"', AccionesEnCirculacion = "+accionesEnCirculacion) == 1) {
                    resul = "Parametrización Actualizada Satisfactoriamente";
                } else {
                    resul = "Error en la actualización de la parametrización";
                }

            }
            IngresarParametro.cerrarConexiones();
        } catch (Exception e) {
            resul = "Hubo un Error Al Momento de Crear La Parametrización";
            logger.error("OPI - " + FacadeParametros.class.getName(), e);
        } finally {
            IngresarParametro.cerrarConexiones();
        }
        return resul;
    }

    public List<String> FechasIngreso() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String fechaInicial, fechaFinal, horaInicial, horaFin, horaInicialCarga, horaFinCarga;
        List<String> fechas = new ArrayList<String>();
        Parametro par = new Parametro();
        try {
            par.consultaLectura("select FechaIniOperacion, FechaFinOperacion, HoraIniOperacion, HoraFinOperacion, HoraIniOperacionCarga, HoraFinOperacionCarga from fqs_Parametrizacion");
            if (par.rs.first()) {

                fechaInicial = par.rs.getString("FechaIniOperacion");
                fechaFinal = par.rs.getString("FechaFinOperacion");
                horaInicial = par.rs.getString("HoraIniOperacion");
                horaFin = par.rs.getString("HoraFinOperacion");
                horaInicialCarga = par.rs.getString("HoraIniOperacionCarga");
                horaFinCarga = par.rs.getString("HoraFinOperacionCarga");

                fechas.add(fechaInicial);
                fechas.add(fechaFinal);
                fechas.add(horaInicial);
                fechas.add(horaFin);
                fechas.add(horaInicialCarga);
                fechas.add(horaFinCarga);
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);

        } finally {

            par.cerrarConexiones();
        }
        return fechas;
    }

    public boolean RetornarFestivo(String fecha) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean festivo = false;
        Parametro par = new Parametro();

        try {
            par.consultaG("SELECT d_fecha FROM fqs_festivo WHERE d_fecha=?", fecha);
            if (par.rs.first()) {
                festivo = true;
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            par.cerrarConexiones();
        }
        return festivo;
    }

    public void ReiniciaConsecutivo() {
        Parametro par = new Parametro();
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        try {

            par.actualiza("UPDATE seq SET val=0 WHERE name='dm_formulario'");

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            par.cerrarConexiones();
        }

    }
    public List<String> RetornaParametros() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        List<String> parametros = new ArrayList<String>();
        Parametro par = new Parametro();
        try {
            par.consultaLectura("SELECT * FROM fqs_Parametrizacion");
            if (par.rs.first()) {
                parametros.add(par.rs.getString("EntidadDeNegociosID"));
                parametros.add(par.rs.getString("UsuarioID"));
                parametros.add(par.rs.getString("FechaIniOperacion"));
                parametros.add(par.rs.getString("HoraIniOperacion"));
                parametros.add(par.rs.getString("FechaFinOperacion"));
                parametros.add(par.rs.getString("HoraFinOperacion"));
                parametros.add(par.rs.getString("MinAccionesObjOferta"));
                parametros.add(par.rs.getString("MaxAccionesObjOferta"));
                parametros.add(par.rs.getString("NombreRazonSocial"));
                parametros.add(par.rs.getString("PrecioAceptaciones"));
                parametros.add(par.rs.getString("NumeroAceptacion"));
                parametros.add(par.rs.getString("TextoUno"));
                parametros.add(par.rs.getString("TextoDos"));
                parametros.add(par.rs.getString("ExistePreacuerdo"));
                parametros.add(par.rs.getString("CantReporte"));
                parametros.add(par.rs.getString("Nanotecnico"));
                parametros.add(par.rs.getString("ClaseAcciones"));
                parametros.add(par.rs.getString("CantUsuariosOpe"));
                parametros.add(par.rs.getString("NombreUsuarioIdCreacion"));
                parametros.add(par.rs.getString("FechaCreacion"));
                parametros.add(par.rs.getString("FechaModificacion"));
                parametros.add(par.rs.getString("TodoONada"));
                parametros.add(par.rs.getString("TipoDocumentoOferente"));
                parametros.add(par.rs.getString("NumeroDocumentoOferente"));
                parametros.add(par.rs.getString("DVOferente"));
                parametros.add(par.rs.getString("EFOferente"));
                parametros.add(par.rs.getString("CuentaDecevalOferente"));
                parametros.add(par.rs.getString("SCBOferente"));
                parametros.add(par.rs.getString("ActivarCargaMasiva"));
                parametros.add(par.rs.getString("HoraIniOperacionCarga"));
                parametros.add(par.rs.getString("HoraFinOperacionCarga"));
                parametros.add(par.rs.getString("Accionesnegociadas"));
                parametros.add(par.rs.getString("TxtBoletinInformativo"));
                parametros.add(par.rs.getString("umbral"));
                parametros.add(par.rs.getString("precioaccionespago"));
                parametros.add(par.rs.getString("porcentajeefectivopago"));
                parametros.add(par.rs.getString("TextoTres"));
                parametros.add(par.rs.getString("TextoCuatro"));
                parametros.add(par.rs.getString("TextoCinco"));
                parametros.add(par.rs.getString("TextoSeis"));
                parametros.add(par.rs.getString("TextoSiete"));
                parametros.add(par.rs.getString("tipo_oferta_publica"));
                parametros.add(par.rs.getString("tipo_pago"));
                parametros.add(par.rs.getString("direccion"));
                parametros.add(par.rs.getString("MILA"));
				parametros.add(par.rs.getString("AccionesEnCirculacion"));
                parametros.add(par.rs.getString("TxtBulletinInformative"));  														  
																						   
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);

        } finally {
            par.cerrarConexiones();
        }
        return parametros;
    }
	    
    
    public FqsParametrizacion getFqsParametrizacion() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        FqsParametrizacion fqsParametrizacion = new FqsParametrizacion();
        Parametro par = new Parametro();
        try {
            par.consultaLectura("SELECT * FROM fqs_Parametrizacion");
            if (par.rs.first()) {
                fqsParametrizacion.setEntidadDeNegociosId(par.rs.getString("EntidadDeNegociosID"));
                fqsParametrizacion.setUsuarioId(par.rs.getString("UsuarioID"));
                fqsParametrizacion.setFechaIniOperacion(par.rs.getString("FechaIniOperacion"));
                fqsParametrizacion.setHoraIniOperacion(par.rs.getString("HoraIniOperacion"));
                fqsParametrizacion.setFechaFinOperacion(par.rs.getString("FechaFinOperacion"));
                fqsParametrizacion.setHoraFinOperacion(par.rs.getString("HoraFinOperacion"));
                fqsParametrizacion.setMinAccionesObjOferta(par.rs.getString("MinAccionesObjOferta"));
                fqsParametrizacion.setMaxAccionesObjOferta(par.rs.getString("MaxAccionesObjOferta"));
                fqsParametrizacion.setNombreRazonSocial(par.rs.getString("NombreRazonSocial"));
                fqsParametrizacion.setPrecioAceptaciones(par.rs.getString("PrecioAceptaciones"));
                fqsParametrizacion.setNumeroAceptacion(par.rs.getString("NumeroAceptacion"));//10
                fqsParametrizacion.setTextoUno(par.rs.getString("TextoUno"));
                fqsParametrizacion.setTextoDos(par.rs.getString("TextoDos"));
                fqsParametrizacion.setExistePreacuerdo(par.rs.getString("ExistePreacuerdo"));
                fqsParametrizacion.setCantReporte(par.rs.getString("CantReporte"));
                fqsParametrizacion.setNanotecnico(par.rs.getString("Nanotecnico"));
                fqsParametrizacion.setClaseAcciones(par.rs.getString("ClaseAcciones"));
                fqsParametrizacion.setCantUsuariosOpe(par.rs.getString("CantUsuariosOpe"));
                fqsParametrizacion.setNombreUsuarioIdCreacion(par.rs.getString("NombreUsuarioIdCreacion"));
                fqsParametrizacion.setFechaCreacion(par.rs.getString("FechaCreacion"));
                fqsParametrizacion.setFechaModificacion(par.rs.getString("FechaModificacion"));//20
                fqsParametrizacion.setTodoONada(par.rs.getString("TodoONada"));
                fqsParametrizacion.setTipoDocumentoOferente(par.rs.getString("TipoDocumentoOferente"));
                fqsParametrizacion.setNumeroDocumentoOferente(par.rs.getString("NumeroDocumentoOferente"));
                fqsParametrizacion.setdVOferente(par.rs.getString("DVOferente"));
                fqsParametrizacion.setEFOferente(par.rs.getString("EFOferente"));
                fqsParametrizacion.setCuentaDecevalOferente(par.rs.getString("CuentaDecevalOferente"));
                fqsParametrizacion.setSCBOferente(par.rs.getString("SCBOferente"));
                fqsParametrizacion.setActivarCargaMasiva(par.rs.getString("ActivarCargaMasiva"));
                fqsParametrizacion.setHoraIniOperacionCarga(par.rs.getString("HoraIniOperacionCarga"));
                fqsParametrizacion.setHoraFinOperacionCarga(par.rs.getString("HoraFinOperacionCarga"));//30
                fqsParametrizacion.setAccionesnegociadas(par.rs.getString("Accionesnegociadas"));
                fqsParametrizacion.setTxtBoletinInformativo(par.rs.getString("TxtBoletinInformativo"));
                fqsParametrizacion.setUmbral(par.rs.getString("umbral"));
                fqsParametrizacion.setPrecioaccionespago(par.rs.getString("precioaccionespago"));
                fqsParametrizacion.setPorcentajeefectivopago(par.rs.getString("porcentajeefectivopago"));//35
                fqsParametrizacion.setTextoTres(par.rs.getString("TextoTres"));
                fqsParametrizacion.setTextoCuatro(par.rs.getString("TextoCuatro"));
                fqsParametrizacion.setTextoCinco(par.rs.getString("TextoCinco"));
                fqsParametrizacion.setTextoSeis(par.rs.getString("TextoSeis"));
                fqsParametrizacion.setTextoSiete(par.rs.getString("TextoSiete"));//40
                fqsParametrizacion.setTipoOfertaPublica(par.rs.getString("tipo_oferta_publica"));
                fqsParametrizacion.setTipoPago(par.rs.getString("tipo_pago"));
                fqsParametrizacion.setDireccion(par.rs.getString("direccion"));
                fqsParametrizacion.setMila(par.rs.getString("MILA"));
                fqsParametrizacion.setAccionesEnCirculacion(par.rs.getString("AccionesEnCirculacion"));
                fqsParametrizacion.setTxtBulletinInformative(par.rs.getString("TxtBulletinInformative")); 
                fqsParametrizacion.setComisionCompra(par.rs.getString("comisionCompra"));
                fqsParametrizacion.setReferenciaComprador(par.rs.getString("referenciaComprador"));
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            par.cerrarConexiones();
        }
        return fqsParametrizacion;
    }

    public int CantUsuariosOpe() {
        int VariableLocal_Resultado = 1;
        Parametro ValidarParametro = new Parametro();
        try {
            ValidarParametro.consultaLectura("SELECT CantUsuariosOpe FROM fqs_Parametrizacion ;");
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = Integer.parseInt(ValidarParametro.rs.getString("CantUsuariosOpe"));

            } else {
                VariableLocal_Resultado = 1;
            }
        } catch (Exception e) {
            VariableLocal_Resultado = 1;
        }
        ValidarParametro.cerrarConexiones();
        return VariableLocal_Resultado;
    }

    public int ValidarCantidadReportes() {
        int VariableLocal_Resultado = 1;
        Parametro ValidarParametro = new Parametro();
        try {
            ValidarParametro.consultaLectura("SELECT CantReporte AS RESULTADO FROM fqs_Parametrizacion;");
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = Integer.parseInt(ValidarParametro.rs.getString("RESULTADO"));
            } else {
                VariableLocal_Resultado = 1;
            }

        } catch (Exception e) {
            VariableLocal_Resultado = 1;

        } finally {
            ValidarParametro.cerrarConexiones();
        }
        return VariableLocal_Resultado;
    }

    public String rutaCargueMasivo() {
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("Select c_valor from fqs_parametro where i_parametro = 20004");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);

        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public String rutaIDRD() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("Select c_valor from fqs_parametro where i_parametro = 20005");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public String rutaAdjudicacion() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("Select c_valor from fqs_parametro where i_parametro = 20007");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public String rutaI20() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("Select c_valor from fqs_parametro where i_parametro = 20009");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException e) {
            logger.error("OPI - " + FacadeParametros.class.getName(), e);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public int limiteCargaMasiva() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int max = 0;
        Parametro param = new Parametro();
        try {
            param.consultaLectura("Select c_valor from fqs_parametro where i_parametro = 20006");
            if (param.rs.first()) {
                max = Integer.parseInt(param.rs.getString("c_valor"));
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return max;
    }

    public String usuarioAdjudicacion() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("SELECT DISTINCT (CONCAT( c_nombre,' ',c_apellidos) ) AS c_valor  FROM fqs_adjudicacion a INNER JOIN fqs_usuario b ON a.c_usuario_sistema_ultima_mod=b.c_login");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;

    }

    public String horaAdjudicacion() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("SELECT DATE_FORMAT(MAX(ts_fecha_hora_ultima_modificacion),'%H:%i:%s') AS c_valor  FROM fqs_adjudicacion a ");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public String fechaAdjudicacion() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("SELECT DATE_FORMAT(MAX(ts_fecha_hora_ultima_modificacion),'%d-%m-%Y') AS c_valor  FROM fqs_adjudicacion a ");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public String rutaBoletin() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String ruta = "";
        Parametro param = new Parametro();
        try {
            param.consultaLectura("Select c_valor from fqs_parametro where i_parametro = 20011");
            if (param.rs.first()) {
                ruta = param.rs.getString("c_valor");
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeParametros.class.getName(), ex);
        } finally {
            param.cerrarConexiones();
        }
        return ruta;
    }

    public List<String> Umbral_Pago_Rango() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        List<String> parametros = new ArrayList<String>();
        Parametro param = new Parametro();
        try {
            param.consultaLectura("select umbral,porcentajeefectivopago from fqs_Parametrizacion ;");
            if (param.rs.first()) {
                parametros.add(param.rs.getString("umbral"));
                parametros.add(param.rs.getString("porcentajeefectivopago"));
            }

        } catch (SQLException e) {
            logger.error("OPI - " + FacadeParametros.class.getName(), e);
        } finally {
            param.cerrarConexiones();
        }
        return parametros;
    }

}
