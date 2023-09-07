/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.db;

import com.quasar.frameq.data.FqsParametrizacion;
import com.quasar.frameq.data.OrigenMILA;
import com.quasar.frameq.data.Parametrizacion;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.data.TipoDocumento;
import com.quasar.frameq.estructura.IpAutorizada;
import com.quasar.frameq.fachadas.FacadePerfiles;
import com.quasar.frameq.fachadas.FacadeUsuarios;
import com.quasar.frameq.fachadas.FacadeTipoDocumento;
import com.quasar.frameq.fachadas.FacadeSCB;
import com.quasar.frameq.fachadas.FacadeAceptaciones;
import com.quasar.frameq.fachadas.FacadeDiccionario;
import com.quasar.frameq.fachadas.FacadeOrigenMILA;
import com.quasar.frameq.seguridad.Perfil;
import com.quasar.frameq.fachadas.FacadeParametros;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Administrador
 */
public class Facade {

    

    FacadeTipoDocumento FDocumento = new FacadeTipoDocumento();
    FacadePerfiles FPerfil = new FacadePerfiles();
    FacadeUsuarios Fusuarios = new FacadeUsuarios();

    FacadeAceptaciones FAceptaciones = new FacadeAceptaciones();
    FacadeParametros FParametrizacion = new FacadeParametros();
    FacadeSCB Fscb = new FacadeSCB();
    
    FacadeDiccionario FPDiccionario = new FacadeDiccionario();
    FacadeOrigenMILA FOrigenMILA = new FacadeOrigenMILA();

    public List<TipoDocumento> RetornarDocumentos() {

        return FDocumento.RetornarDocumentos();
    }
    
   public List<TipoDocumento> RetornarDocumentosOferente() {

        return FDocumento.RetornarDocumentosOferente();
    }

    public List<Perfil> RetornarPerfiles() {
        return FPerfil.RetornarPerfiles();
    }

    public List<TipoDocumento> RetornarDocumentoApoderado() {
        return FDocumento.RetornarDocumentoApoderado();
    }   


    public List<SCB> RetornarSCB() {
        return Fscb.RetornarSCB();
    }

    public String RetornarSCBusu(Integer id) {
        return Fscb.RetornarSCBusuario(id);
    }

    public String RetornarSCBusuarioSelectid(Integer id) {
        return Fscb.RetornarSCBusuarioSelectid(id);
    }
    
    public String RetornarSCBusuSelec(Integer id) {
        return Fscb.RetornarSCBusuarioSelect(id);
    }
    
    public List<List<String>> Listarscb() {
        return Fscb.Listarscb();
    }
    
    public String CrearSCB(String codigoScb, String nombreScb, int tipoDocumento, String documento, String digitoVerificacion, String c_direccion, String telefono, String representante, String representante2, String representante3, int estado, int tipodocumento1, String documento1, int tipodocumento2, String documento2, int tipodocumento3, String documento3) {

        return Fscb.IngresarSCB(codigoScb, nombreScb, tipoDocumento, documento, digitoVerificacion, c_direccion, telefono, representante, representante2, representante3, estado, tipodocumento1, documento1,tipodocumento2, documento2, tipodocumento3, documento3);
    }
    
    public String ModificarSCB(String codigoScb, String nombreScb, int tipoDocumento, String documento, String digitoVerificacion, String c_direccion, String telefono, String representante, String representante1, String representante2, int estado, int tipodocumento1, String documento1, int tipodocumento2, String documento2, int tipodocumento3, String documento3 ) {

        return Fscb.ModificarSCB(codigoScb, nombreScb, tipoDocumento, documento, digitoVerificacion, c_direccion, telefono, representante, representante1, representante2, estado,tipodocumento1, documento1,tipodocumento2, documento2, tipodocumento3, documento3);
    }

    public String RetornaPerfil(Integer id) {

        return FPerfil.RetornarPerfilUsuario(id);
    }

    
    public List<List<String>> ListarDemandas(String usuario, String numaceptaciones, String FechIni, String FechaFin) {
        return FAceptaciones.ListarDemandas(usuario, numaceptaciones, FechIni, FechaFin);
    }
      
    public List<List<String>> ListarDemandasAdjudicacion() {
        return FAceptaciones.ListarDemandasAdjudicacion();
    }
     
    public List<List<String>> ListarDemandas() {
        return FAceptaciones.ListarDemandas();
    }
    
    public List<List<String>> ListarDemandasAdjudicacionconsolidado(String ctaInv) {
    return FAceptaciones.ListarDemandasAdjudicacionconsolidado(ctaInv);
    }

      public List<List<String>> ListarDemandasReporteConsolidado(String usuario, String FechIni, String FechaFin, Integer perfil, Integer scb) {
        return FAceptaciones.ListarDemandasReporteConsolidado(usuario,  FechIni, FechaFin, perfil, scb);
    } 
      
     public String Totales (String usuario, Integer perfil, Integer scb, String FechIni, String FechaFin){
      return FAceptaciones.Totales(usuario, perfil, scb,  FechIni, FechaFin);   
     } 
      
      
      public List<List<String>> ListarDemandasRechazadas(String usuario, String numaceptaciones, String FechIni, String FechaFin) {
        return FAceptaciones.ListarDemandasRechazadas(usuario, numaceptaciones, FechIni, FechaFin);
    }  

    public List<List<String>> Retornarusuarios() {
        return Fusuarios.RetornarUsuarios();
    }
    
      public List<List<String>> RetornarusuariosSCB(String id ) {
        return Fusuarios.RetornarUsuariosSCB(id);
    }

    public List<List<String>> RetornaPassusuarios(String users) {
        return Fusuarios.RetornarPassUsuarios(users);
    }
    

    public List<List<String>> RetornaLogin(String user) {
        return Fusuarios.RetornaLogin(user);
    }

    public ArrayList<IpAutorizada> traerIpAutorizada(Integer user) {
        return Fusuarios.traerIpAutorizada(user);
    }    
    
      
    public boolean CambiodeContrasena(String login) {
        return Fusuarios.CambiodeContrasena(login);
    }
    
    public String retornaPassActual(int id) {
        return Fusuarios.retornaPassActual(id);
    }

    //Crear Aceptación OPA
    public String CrearAceptacion(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombre, Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double porcentajeComision,  Double precio, String direccion, int idMila) {
        
        return FAceptaciones.IngresarAceptacion(claseAcciones, consecutivo, texto1, texto2, preacuerdo, codigoScb, nombreScb,
                representante, nombre, numAcciones, TN, tipoDoc, numDoc, numVer, fiduciario, cuentaInv, usuario, fecha, usuarioMod, fechaMod, nomUsuario, porcentajeComision, precio, direccion, idMila);
    }
    
    //Crear Aceptación OPI
     public String CrearAceptacion(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombre, Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double porcentajeComision,Double porcentajePagoEfectivo, int tipoPago, Double precio, String condicion1, String condicion2, String direccion,int idMila) {

        return FAceptaciones.IngresarAceptacion(claseAcciones, consecutivo, texto1, texto2, preacuerdo, codigoScb, nombreScb,
                representante, nombre, numAcciones, TN, tipoDoc, numDoc, numVer, fiduciario, cuentaInv, usuario, fecha, usuarioMod, fechaMod, nomUsuario, porcentajeComision, porcentajePagoEfectivo,tipoPago,precio,condicion1,condicion2, direccion,idMila);
    }

    public String ModificarAceptacion(String claseAcciones, String consecutivo, String texto1, String texto2, Integer preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombre, /*String apellidoRazonSocial,*/ Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String observacion, String nomUsuario, String idAceptacion,Double porcentajeComision, String direccion, int idMila ) {

        return FAceptaciones.ModificarAceptacion(claseAcciones, consecutivo, texto1, texto2, preacuerdo, codigoScb, nombreScb,
                representante,  nombre, /*apellidoRazonSocial,*/ numAcciones, TN, tipoDoc, numDoc, numVer, fiduciario, cuentaInv, usuario, fecha, usuarioMod, fechaMod, observacion, nomUsuario, idAceptacion, porcentajeComision, direccion,idMila);
    }
    
    
    public String RechazarAceptacion(String apellidoRazon, String consecutivoOferta, Integer existePreacuerdo,String idMila, String nombreRepresentanteLegal, int tipoDoc, String numDoc, Double digV, String especFidu, String cuenInv, Integer tipoCon, Double numAcc, String observacion, String estado,  String porcentajeCom, String nomUsuario,
            String fecha, String idAceptacion) {

        return FAceptaciones.RechazarAceptacion(apellidoRazon, consecutivoOferta, existePreacuerdo, idMila, nombreRepresentanteLegal, tipoDoc, numDoc, digV , especFidu, cuenInv, tipoCon, numAcc, observacion, estado, porcentajeCom, nomUsuario, fecha,  idAceptacion);
    }

     public String RecalcularMontoTotalEfectivoAceptaciones(String precio) {

        return FAceptaciones.RecalcularMontoTotalEfectivoAceptaciones(precio);
    }
     
     public String RecalcularMontoTotalRechazo(String precio, Double numeAccion, String idAceptacion) {

        return FAceptaciones.RecalcularMontoTotalRechazo(precio, numeAccion, idAceptacion);
    }    
    
    //Crea parametrización para OPA
    public String CrearParametros(int parametro_usario, String parametro_FechaIniOp, String paramero_HoraIniOp, String parametro_FechaFinOp, String parametro_HoraFinOp,
            String parametro_MinAccionesObjOf, String parametro_MaxAccionesObjOf, String parametro_NombreRazonSocial, String parametro_PrecioAc,
            int parametro_NumeroAcp, String parametro_TextoUno, String parametro_TextoDos, int parametro_ExistePreacuerdo, int parametro_CantRpt,
            String parametro_Nanotecnico, String parametro_ClaseDeAcciones, int parametro_CantUsOp, int parametro_UsCrea,
            String parametro_FechaCrea, int parametro_UsModi, String parametro_FechaModi,int parametro_TodooNada, int parametro_ActivarCm,
            String c_usuario_sistema_ultima_mod, String ts_fecha_hora_ultima_modificacion, Integer tipoDocumentoOferente,String numeroDocumentoOferente,String DVOferente,String especialFiduciarioOferente, Integer cuentaDecevalOferente,Integer scbOferente,String paramero_HoraIniCarga,String parametro_HoraFinCarga, String parametro_AccionesNegociadas, String parametro_TxtBoletinInfo,String parametro_umbral, String parametro_precioaccionespago, String parametro_porcentajeefectivopago, String tipoOfertaPublica, int parametro_direccion,int parametro_MILA,String txtBulletinInformative,String accionesEnCirculacion, String comisionCompra, String referenciaComprador) {
       return FParametrizacion.IngresarParametrizacion(parametro_usario, parametro_FechaIniOp, paramero_HoraIniOp, parametro_FechaFinOp, parametro_HoraFinOp, parametro_MinAccionesObjOf, parametro_MaxAccionesObjOf, parametro_NombreRazonSocial, parametro_PrecioAc, parametro_NumeroAcp, parametro_TextoUno, parametro_TextoDos, parametro_ExistePreacuerdo, parametro_CantRpt, parametro_Nanotecnico, parametro_ClaseDeAcciones, parametro_CantUsOp, parametro_UsCrea, parametro_FechaCrea, parametro_UsModi, parametro_FechaModi, parametro_TodooNada,
              parametro_ActivarCm, c_usuario_sistema_ultima_mod, ts_fecha_hora_ultima_modificacion,
              tipoDocumentoOferente, numeroDocumentoOferente, DVOferente, especialFiduciarioOferente,  cuentaDecevalOferente,  scbOferente,paramero_HoraIniCarga,parametro_HoraFinCarga,parametro_AccionesNegociadas,parametro_TxtBoletinInfo, parametro_umbral, parametro_precioaccionespago, parametro_porcentajeefectivopago, tipoOfertaPublica, parametro_direccion, parametro_MILA,txtBulletinInformative,accionesEnCirculacion, comisionCompra, referenciaComprador);
       
    }
    
    //crea parametrización OPI
    public String CrearParametros(int parametro_usario, String parametro_FechaIniOp, 
            String paramero_HoraIniOp, String parametro_FechaFinOp, String parametro_HoraFinOp,
            String parametro_MinAccionesObjOf, String parametro_MaxAccionesObjOf, 
            String parametro_NombreRazonSocial, String parametro_PrecioAc,
            int parametro_NumeroAcp, String parametro_TextoUno, String parametro_TextoDos, 
            int parametro_ExistePreacuerdo, int parametro_CantRpt,
            String parametro_Nanotecnico, String parametro_ClaseDeAcciones, int parametro_CantUsOp, int parametro_UsCrea,
            String parametro_FechaCrea, int parametro_UsModi, String parametro_FechaModi,int parametro_TodooNada, int parametro_ActivarCm,
            String c_usuario_sistema_ultima_mod, String ts_fecha_hora_ultima_modificacion,
            Integer tipoDocumentoOferente,String numeroDocumentoOferente,String DVOferente,
            String especialFiduciarioOferente, Integer cuentaDecevalOferente, 
            Integer scbOferente,String paramero_HoraIniCarga,String parametro_HoraFinCarga, 
            String parametro_AccionesNegociadas, String parametro_TxtBoletinInfo, String parametro_umbral, 
            String parametro_precioaccionespago, String parametro_porcentajeefectivopago, 
            String parametro_TextoTres, String parametro_TextoCuatro, String parametro_TextoCinco, 
            String parametro_TextoSeis, String parametro_TextoSiete, String tipoOfertaPublica, 
            int tipoPago, int parametro_direccion, int parametro_MILA,
            String txtBulletinInformative,String accionesEnCirculacion) {
    return FParametrizacion.IngresarParametrizacion(parametro_usario, parametro_FechaIniOp, 
            paramero_HoraIniOp, parametro_FechaFinOp, parametro_HoraFinOp, parametro_MinAccionesObjOf, 
            parametro_MaxAccionesObjOf, parametro_NombreRazonSocial, parametro_PrecioAc, parametro_NumeroAcp, 
            parametro_TextoUno, parametro_TextoDos, parametro_ExistePreacuerdo, parametro_CantRpt, 
            parametro_Nanotecnico, parametro_ClaseDeAcciones, parametro_CantUsOp, parametro_UsCrea, 
            parametro_FechaCrea, parametro_UsModi, parametro_FechaModi, parametro_TodooNada,
            parametro_ActivarCm, c_usuario_sistema_ultima_mod, ts_fecha_hora_ultima_modificacion,
            tipoDocumentoOferente, numeroDocumentoOferente, DVOferente, especialFiduciarioOferente,  
            cuentaDecevalOferente,  scbOferente,paramero_HoraIniCarga,parametro_HoraFinCarga, 
            parametro_AccionesNegociadas, parametro_TxtBoletinInfo ,parametro_umbral, 
            parametro_precioaccionespago, parametro_porcentajeefectivopago,
            parametro_TextoTres,parametro_TextoCuatro,parametro_TextoCinco,
            parametro_TextoSeis,parametro_TextoSiete, tipoOfertaPublica, tipoPago, parametro_direccion, parametro_MILA,
            txtBulletinInformative,accionesEnCirculacion);
       
    }
    public void reiniciaCon(){
        
        FParametrizacion.ReiniciaConsecutivo();
    }

    // Metodos Leonard Prens
    public String RetornarFechaAcep(Integer id) {
        return FAceptaciones.retornaFechaAceptacion(id);
    }

    public String [] RetornarDatosPara() {
        return FAceptaciones.RetornarDatosParam();
    }
    
    public Parametrizacion retornarParametrizacionParcial() {
        return FAceptaciones.retornarParametrizacionParcial();
    } 
      
    public String fechaAcepta(int usuario) {
        return FAceptaciones.FechaAceptacion(usuario);
    }
        
      
        public String estadoAceptacion(String idaceptacion) {
        return FAceptaciones.estadoAceptacion(idaceptacion);
    }
          
        


    public boolean RetornaConsecutivo(String consecutivo) {
        return FAceptaciones.RetornaConsecutivo(consecutivo);
    }
    
    public List<String> FechasIngreso() {
        return FParametrizacion.FechasIngreso();
    }
     
     public boolean Retornafestivo(String fecha){
         
       return FParametrizacion.RetornarFestivo(fecha);
     }
     
     public void borrarAceptaciones(){
         
       FAceptaciones.BorraAceptaciones();
     }
     
     public int validaHayParametros(){
         
       return FParametrizacion.ValidarTotalRegParametrizacion();
     }
     
      public List<String> RetornaParametros(){
          
        return FParametrizacion.RetornaParametros();
    }

    public FqsParametrizacion getFqsParametrizacion(){
        return FParametrizacion.getFqsParametrizacion();
    }
    

      
       public boolean isTNShow() {
           return FAceptaciones.isTNShow();
       }
       
    public  boolean existePreacuerdo() {
        return FAceptaciones.existePreacuerdo();
    }
       
       
    public String [] CargarAceptacion(String id) {
        return FAceptaciones.CargarAceptacion(id);
    }
    
    public String [] CargarAceptacionOPI(String id) {
        return FAceptaciones.CargarAceptacionOPI(id);
    }
    
    public String findAceptacionTypeById(String id){
        return FAceptaciones.findAceptacionTypeById(id);
    }
    
    public int existeDocumento(String nombre) {
        return FDocumento.existeDocumento(nombre);
    }
    
    public String rutaCargueMasivo() {
        return FParametrizacion.rutaCargueMasivo();
    }
    
    public String rutaIDRD() {
        return FParametrizacion.rutaIDRD();
    }
    
     public String rutaAdjudicacion() {
        return FParametrizacion.rutaAdjudicacion();
    }
    
    //OPA 
    public String CrearAceptacionCargueMasivo(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombreRazonSocial , /*String apellidoRazonSocial,*/ Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double digVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double  porcentajeComision , Double precio, String direccion) {

        return FAceptaciones.IngresarAceptacionCargueMasivo(claseAcciones, consecutivo, texto1, texto2, preacuerdo, codigoScb, nombreScb,
                representante, nombreRazonSocial, /*apellidoRazonSocial,*/ numAcciones, TN, tipoDoc, numDoc, digVer, fiduciario, cuentaInv, usuario, fecha, 
                usuarioMod, fechaMod, nomUsuario,porcentajeComision, precio, direccion);
    }
    
    //OPI
    public String CrearAceptacionCargueMasivo(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombreRazonSocial , /*String apellidoRazonSocial,*/ Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double  porcentajeComision,Double porcentajePagoefectivo, int tipoPago , 
            Double PrecioAccion, String Condicion1, String Condicion2, String direccion ) {

        return FAceptaciones.IngresarAceptacionCargueMasivo(claseAcciones, consecutivo, texto1, texto2, preacuerdo, codigoScb, nombreScb,
                representante, nombreRazonSocial, /*apellidoRazonSocial,*/ numAcciones, TN, tipoDoc, numDoc, numVer, fiduciario, cuentaInv, usuario, fecha,
                usuarioMod, fechaMod, nomUsuario,porcentajeComision,porcentajePagoefectivo, tipoPago,PrecioAccion, Condicion1,Condicion2,
                direccion);
    }
       
    public String retornarDia(int id) {
        return FAceptaciones.retornarDia(id);
    }
    
    public String devolverLetraDocumento(int idDoc) {
        return FDocumento.devolverLetraDocumento(idDoc);
    }
    
    public int limiteCargaMasiva() {
        return FParametrizacion.limiteCargaMasiva();
    }
    
     public String fechaAdjudicacion() {
        return FParametrizacion.fechaAdjudicacion();
    }
     
     public String horaAdjudicacion() {
        return FParametrizacion.horaAdjudicacion();
    }
     public String usuarioAdjudicacion() {
        return FParametrizacion.usuarioAdjudicacion();
    }

    public String GuardarPalabras(String palabra, String nomUsuario  ) {
       
       // return  FacadeDiccionario.GuardarPalabrasRestringidas(palabra);
       return FPDiccionario.GuardarPalabrasRestringidas(palabra, nomUsuario);
    }

    public List<TipoDocumento> RetornarDocumentoRepresentanteL() {
        return FDocumento.RetornarDocumentoRepresentanteL();
    }

    public SCB cargarRepresentante(String codigo) {
        return FAceptaciones.CargarRepresentante(codigo);
    }

    public List<List<String>> ListarLogin(String Txtlogin, String DateIni, String DateFin) {
        return Fusuarios.ListarLogin(Txtlogin,DateIni,DateFin);
    }


    public List<List<String>> ListarAuParametros(String Txtlogin, String DateIni, String DateFin) {
       return Fusuarios.ListarAuParametros(Txtlogin,DateIni,DateFin);
    }

    public List<List<String>> ListarAuAcep(String Txtlogin, String DateIni, String DateFin) {
        return Fusuarios.ListaAuAcep(Txtlogin,DateIni,DateFin);
    }
    
    public String rutaBoletin() {
       return FParametrizacion.rutaBoletin();
   }
        
    
    public static Properties cargarPropertiesLog() {
        Properties props = new Properties();
        FileInputStream log;
       
       try {
           log = new FileInputStream("/apps/OPA/logs/opa-log4j.properties");
           props.load(log);
           log.close();
                      
       } catch (FileNotFoundException ex) {
           
       } catch (IOException ex) {
           
       }        
        return props ;
    }
    
    public List<String> umbral_Pago_Rango() {
        return FParametrizacion.Umbral_Pago_Rango();
    }
    
     public String rutaI20() {
        return FParametrizacion.rutaI20();
    }
     
     public long countAceptacionesExists(){
         return FAceptaciones.countAceptacionesExists();
     }
     public List<OrigenMILA> RetornarOrigenMIla() {
        return FOrigenMILA.RetornarOrigenMILA();
    }
   public List<OrigenMILA> RetornarOrigenMILActivos() {
        return FOrigenMILA.RetornarOrigenMILActivos();
    }
   
   public String[] CargarIdMila(String idNegocio) throws SQLException{
       return FAceptaciones.CargarIdMila(idNegocio);
   }
}
