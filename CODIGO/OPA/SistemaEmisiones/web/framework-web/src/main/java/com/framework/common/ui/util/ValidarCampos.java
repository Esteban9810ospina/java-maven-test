/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.util;

import com.framework.common.service.security.MyUserDetailsService;
import com.quasar.frameq.data.Formulario;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.db.Facade;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrador
 */
public class ValidarCampos {

    private static final Logger logger = Logger.getLogger(ValidarCampos.class.getName());
    private MyUserDetailsService userDetailsService;
    Facade fachada = new Facade();
    String regexTodoNada = "^[nsNS]*$";
    String Alfanumerica = "^[a-zA-Z0-9\\s]*$";
    String eñestildes = "^[ a-zA-Z0-9áéíóúñÁÉÍÓÚÑ]*$";
    //String representanteLegal = "^[ a-zA-ZáéíóúñÁÉÍÓÚÑ]*$";
    String representanteLegal = "^[a-zA-Z0-9]*$";
    String numerica = "^[0-9]*$";
    String numerico = "^[0-9]*$";
    String concatError = "";
    String regexNumericPuntComa = "^[0-9,]*$";
    String regexTresDecimales = "\\d+(\\,\\d{1,3}|,{1})?";
    public static final String UTF8_BOM = "\uFEFF";
    public String tipoDoc = "";
    Integer idDetailsService;
    String codigo = "";
    Map<String,String> documentTypesMap = new HashMap<String, String>();

    public String quitarFormato(String numero) {
        String retorno = numero;
        retorno = retorno != null ? retorno.replace(".", "") : "";
        return retorno;
    }

    public String ponerFormatoNumero(String numero) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String retorno = numero;
        try {
            if (numero.trim().length() > 0) {
                BigDecimal num = new BigDecimal(numero);
                DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
                simbolo.setDecimalSeparator('.');
                simbolo.setGroupingSeparator(',');
                DecimalFormat formateador = new DecimalFormat("###,###.####", simbolo);
                retorno = formateador.format(num);
            } else {
                retorno = "0";
            }
        } catch (Exception e) {
            logger.error("OPA - " + ValidarCampos.class.getName(), e);
        }
        return retorno;
    }

    public int validarRut(String rut) {
        int result = 0, sumatoria = 0;
        String nString = rut;
        while (nString.length() < 15) {
            nString = "0" + nString;
        }
        int[] primos = new int[]{3, 7, 13, 17, 19, 23, 29, 37, 41, 43, 47, 53, 59, 67, 71};
        for (int i = 0; i < primos.length; i++) {
            sumatoria += Integer.parseInt(nString.substring(i, i + 1)) * primos[primos.length - (i + 1)];
        }
        result = sumatoria % 11;
        if (result > 1) {
            result = 11 - result;
        }
        return result;
    }

    public String eliminarDecimales(String valor) {
        String sinMantisa = "";
        if (valor.contains(",")) {
            sinMantisa = valor.substring(0, valor.indexOf(","));
        } else {
            sinMantisa = valor;
        }
        return (sinMantisa);
    }

    public static synchronized int[] obtenerSecuenciasFormulario() {
        Formulario formulario = new Formulario();
        try {
            formulario.consultaG("select seq('dm_formulario') i_numformulario, seq('dm_ofertante') i_ofertante");
            if (formulario.first()) {
                return new int[]{formulario.rs.getInt("i_numformulario"), formulario.rs.getInt("i_ofertante")};
            }
            formulario.cerrarConexiones();
            throw new RuntimeException("Error inesperado obteniendo valores de secuencia, la consulta no arrojo resultados");
        } catch (SQLException e) {
            formulario.cerrarConexiones();
            throw new RuntimeException("Error inesperado obteniendo valores de secuencia", e);
        } finally {
        }
    }

    public boolean validarEstadoCargaMasiva() {
        boolean TNShow = false;
        Formulario formulario = new Formulario();
        try {
            formulario.consultaG("SELECT ActivarCargaMasiva FROM fqs_Parametrizacion WHERE ActivarCargaMasiva=?", new Boolean(Boolean.TRUE));
            if (formulario.rs.first()) {
                TNShow = true;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error inesperado obteniendo el estado de la carga masiva", ex);
        } finally {
            formulario.cerrarConexiones();
        }
        return TNShow;

    }

    public String fechaIngresoSinHora() {

        String retorno = "";

        List<String> fechas = fachada.FechasIngreso();

        if (fechas.size() > 0) {
            String fechaIn = fechas.get(0).substring(8, 10) + "/" + fechas.get(0).substring(5, 7) + "/" + fechas.get(0).substring(0, 4);
            String fechaFi = fechas.get(1).substring(8, 10) + "/" + fechas.get(1).substring(5, 7) + "/" + fechas.get(1).substring(0, 4);

            String horaIn = fechas.get(2);
            String horaFin = fechas.get(3);

            boolean festivo = fachada.Retornafestivo(ObtenerFormatoFestivo());

            Date fechaInicial = ObtenerFecha(fechaIn, 0);
            Date fechaFn = ObtenerFecha(fechaFi, 1);

            Date horaInicial = ObtenerHora(horaIn);
            Date horaFinal = ObtenerHora(horaFin);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.YEAR, 0);
            //Date horaActual = calendar.getTime();
            Calendar today = Calendar.getInstance();

            Date hoy = today.getTime();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            Date hoyFest = today.getTime();

            if (!festivo) {
                if (hoy.after(fechaInicial) && hoy.before(fechaFn)) {
                } else {
                    retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha no permitida";
                }
            } else {
                retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha no permitida";
            }
        } else {
            retorno = "No hay datos en la tabla Parametrización";
        }

        return retorno;
    }

    public String fechaIngreso() {

        String retorno = "";

        List<String> fechas = fachada.FechasIngreso();

        if (fechas.size() > 0) {
            String fechaIn = fechas.get(0).substring(8, 10) + "/" + fechas.get(0).substring(5, 7) + "/" + fechas.get(0).substring(0, 4);
            String fechaFi = fechas.get(1).substring(8, 10) + "/" + fechas.get(1).substring(5, 7) + "/" + fechas.get(1).substring(0, 4);

            String horaIn = fechas.get(2);
            String horaFin = fechas.get(3);

            boolean festivo = fachada.Retornafestivo(ObtenerFormatoFestivo());

            Date fechaInicial = ObtenerFecha(fechaIn, 0);
            Date fechaFn = ObtenerFecha(fechaFi, 1);

            Date horaInicial = ObtenerHora(horaIn);
            Date horaFinal = ObtenerHora(horaFin);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.YEAR, 0);
            Date horaActual = calendar.getTime();
            Calendar today = Calendar.getInstance();

            Date hoy = today.getTime();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            Date hoyFest = today.getTime();

            if (!festivo) {
                if (hoy.after(fechaInicial) && hoy.before(fechaFn)) {
                    if (horaActual.after(horaInicial)
                            && horaActual.before(horaFinal)) {
                    } else {
                        retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
                    }
                } else {
                    retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
                }
            } else {
                retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
            }
        } else {
            retorno = "No hay datos en la tabla Parametrización";
        }

        return retorno;
    }

    public String fechaIngresoCarga() {

        String retorno = "";

        List<String> fechas = fachada.FechasIngreso();

        if (fechas.size() > 0) {
            String fechaIn = fechas.get(0).substring(8, 10) + "/" + fechas.get(0).substring(5, 7) + "/" + fechas.get(0).substring(0, 4);
            String fechaFi = fechas.get(1).substring(8, 10) + "/" + fechas.get(1).substring(5, 7) + "/" + fechas.get(1).substring(0, 4);

            String horaInC = fechas.get(4);
            String horaFinC = fechas.get(5);

            boolean festivo = fachada.Retornafestivo(ObtenerFormatoFestivo());

            Date fechaInicial = ObtenerFecha(fechaIn, 0);
            Date fechaFn = ObtenerFecha(fechaFi, 1);

            Date horaInicialC = ObtenerHora(horaInC);
            Date horaFinalC = ObtenerHora(horaFinC);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.YEAR, 0);
            Date horaActual = calendar.getTime();
            Calendar today = Calendar.getInstance();

            Date hoy = today.getTime();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            Date hoyFest = today.getTime();

            if (!festivo) {
                if (hoy.after(fechaInicial) && hoy.before(fechaFn)) {
                    if (horaActual.after(horaInicialC)
                            && horaActual.before(horaFinalC)) {
                    } else {
                        retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
                    }
                } else {
                    retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
                }
            } else {
                retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
            }
        } else {
            retorno = "No hay datos en la tabla Parametrización";
        }

        return retorno;
    }

    private Date ObtenerFecha(String fechaEntrada, int flag) {
        Calendar calendar = new GregorianCalendar();
        Integer dia = Integer.parseInt(fechaEntrada.substring(0, 2));
        Integer mes = Integer.parseInt(fechaEntrada.substring(3, 5));
        Integer anyo = Integer.parseInt(fechaEntrada.substring(6, 10));
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes - 1);
        calendar.set(Calendar.YEAR, anyo);
        if (flag == 0) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        } else if (flag == 1) {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        }
        calendar.set(Calendar.MILLISECOND, 0);
        Date fechaFinal = calendar.getTime();
        return fechaFinal;
    }

    private Date ObtenerHora(String horaEntrada) {
        Calendar calendar = new GregorianCalendar();
        Integer hora = Integer.parseInt(horaEntrada.substring(0, 2));
        Integer min = Integer.parseInt(horaEntrada.substring(3, 5));
        Integer seg = Integer.parseInt(horaEntrada.substring(6, 8));
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.YEAR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, seg);
        calendar.set(Calendar.MILLISECOND, 0);
        Date fechaFinal = calendar.getTime();
        return fechaFinal;
    }

    private String ObtenerFormatoFestivo() {
        Calendar calendar = Calendar.getInstance();
        int anyo = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        StringBuilder formatoFecha = new StringBuilder();
        formatoFecha.append(anyo);
        formatoFecha.append("-");
        formatoFecha.append(mes + 1);
        formatoFecha.append("-");
        formatoFecha.append(dia);
        return formatoFecha.toString();
    }

    public String fechaIngresoAdjudicacion() {

        String retorno = "";

        List<String> fechas = fachada.FechasIngreso();

        if (fechas.size() > 0) {
            String fechaIn = fechas.get(0).substring(8, 10) + "/" + fechas.get(0).substring(5, 7) + "/" + fechas.get(0).substring(0, 4);
            String fechaFi = fechas.get(1).substring(8, 10) + "/" + fechas.get(1).substring(5, 7) + "/" + fechas.get(1).substring(0, 4);

            boolean festivo = fachada.Retornafestivo(ObtenerFormatoFestivo());

            Date fechaInicial = ObtenerFecha(fechaIn, 0);
            Date fechaFn = ObtenerFecha(fechaFi, 1);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.YEAR, 0);
            Calendar today = Calendar.getInstance();

            Date hoy = today.getTime();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            Date hoyFest = today.getTime();

            if (!festivo) {
                if (hoy.after(fechaInicial) && hoy.before(fechaFn)) {
                } else {
                    retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
                }
            } else {
                retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
            }
        } else {
            retorno = "No hay datos en la tabla Parametrización";
        }
        return retorno;
    }

    public String horaIngresoAdjudicacion() {

        String retorno = "";

        List<String> fechas = fachada.FechasIngreso();

        if (fechas.size() > 0) {
            String fechaIn = fechas.get(0).substring(8, 10) + "/" + fechas.get(0).substring(5, 7) + "/" + fechas.get(0).substring(0, 4);
            String fechaFi = fechas.get(1).substring(8, 10) + "/" + fechas.get(1).substring(5, 7) + "/" + fechas.get(1).substring(0, 4);

            String horaIn = fechas.get(2);
            String horaFin = fechas.get(3);

            boolean festivo = fachada.Retornafestivo(ObtenerFormatoFestivo());

            Date fechaInicial = ObtenerFecha(fechaIn, 0);
            Date fechaFn = ObtenerFecha(fechaFi, 1);

            Date horaInicial = ObtenerHora(horaIn);
            Date horaFinal = ObtenerHora(horaFin);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.YEAR, 0);
            Date horaActual = calendar.getTime();
            Calendar today = Calendar.getInstance();

            Date hoy = today.getTime();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            Date hoyFest = today.getTime();

            if (!festivo) {
                if (horaActual.after(horaInicial)
                        && horaActual.before(horaFinal)) {
                } else {
                    retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
                }

            } else {
                retorno = "No está permitido el ingreso al módulo, debido a que está intentando ingresar en una Fecha/Hora no permitido";
            }
        } else {
            retorno = "No hay datos en la tabla Parametrización";
        }

        return retorno;
    }

    public String registroControl(String registro, int cantRegistro, Double acciones) {
        String[] registros = registro.split(";");
        String error = "";
        try {
            if (registro != null) {
                if (registro.length() == 0) {
                    error += "El registro de control 1 tiene el siguiente error: El campo es obligario; El registro de control 2 tiene el siguiente error: El campo es obligario; ";
                } else {
                    if (registros[0] == null || registros[0].length() == 0 || registros[0] == "") {
                        error += "El registro de control 1 tiene el siguiente error: El registro de control no tiene la estructura correcta;";
                    } else {
                        try {
                            int valor = Integer.valueOf(registros[0]);
                            if (!(valor == cantRegistro)) {
                                error += "El registro de control 1 tiene el siguiente error: Cantidad de registro no coinciden;";
                            }
                        } catch (Exception ex) {
                            error += "El valor " + registros[0] + " del registro de control 1 tiene el siguiente error:  El registro de control no cumple con la estructura del archivo;";
                        }
                    }
                    if (registros[1] == null || registros[1].length() == 0 || registros[0] == "") {
                        error += "El registro de control 2 tiene el siguiente error: El registro de control no cumple con la estructura del archivo;";
                    } else {
                        try {
                            //int valor=Integer.valueOf(registros[1]);
                            double valor = Double.parseDouble(registros[1]);
                            if (!(valor == acciones)) {
                                error += "El registro de control 2 tiene el siguiente error: La sumatoria total del número de acciones que acepto vender no coincide; ";
                            }
                        } catch (Exception ex) {
                            error += "El valor " + registros[1] + " del registro de control 2 tiene el siguiente error:  El registro de control no cumple con la estructura del archivo;";
                        }
                    }
                }
            } else {
                error += "El registro de control 1 tiene el siguiente error: El campo es obligario; El registro de control 2 tiene el siguiente error: El campo es obligario; ";
            }
        } catch (Exception ex) {
            error += "El registro de control no concuerda con los datos a subir. ";
        }
        return error;
    }

    public String ValidacionRegistro(String registro, String usuario, String tipoOfertaPublica, 
            int tipoPagoParametrizado, boolean paramDireccionActivated) {
        String[] registros = registro.split(";", -1);
        String error = "";
        tipoDoc = "";

        //La cantidad de registros varía dependiendo del Tipo de Oferta pública
        int length = tipoOfertaPublica.equals(AppConstants.OPI_OPERATION) ? 14 : 12;

        try {
            if (registros.length == length) {
                for (int i = 0; i < registros.length; i++) {
                    String campo = registros[i].trim();
                    if (campo.startsWith(UTF8_BOM)) {
                        campo = campo.substring(1);
                    }
                    switch (i) {
                        case 0:
                            error += ConsecutivoVenta(campo);
                            break;
                        case 1:
                            error += TodoNada(campo);
                            break;
                        case 2:
                            error += existePreacuerdo(campo);
                            break;
                        case 3:
                            error += accionesAceptadas(campo);
                            break;
                        case 4:
                            error += nombreApellido(campo);
                            break;
                        /*case 5:
                            error += apellido(campo);
                            break;*/
                        case 5:
                            tipoDoc = campo;
                            error += tipoDocumento(campo);
                            break;
                        case 6:
                            error += nDocumento(campo);
                            break;
                        case 7:
                            error += dVerificacion(campo, registros[i - 1].trim());
                            break;
                        case 8:
                            error += fiduciario(campo);
                            break;
                        case 9:
                            error += cuentaInversionista(campo);
                            break;
                        case 10:
                            error += representanteLegal(campo, usuario);
                            break;
                        case 11:
                            error += porcentajeComision(campo);
                            break;
                        case 12:
                            error += direccion(campo,paramDireccionActivated,tipoOfertaPublica);
                            break;
                        case 13:
                            error += porcentajePagoEfectivo(campo, tipoOfertaPublica, tipoPagoParametrizado);
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            } else {
                return "El registro no cumple con la estructura del archivo. ";
            }
            if (error.equals("")) {
                error = "Validación correcta: registro no cargado. ";
            }
            return error;
        } catch (Exception e) {
            return "El registro no cumple con la estructura del archivo. ";
        }
    }

    private String representanteLegal(String campo, String usuario) {
        String error = "";
        concatError = "";
        int errores = 0;

        String cadena = "";
        String codigo = "";

        SCB Lrep1 = new SCB();
        Lrep1.cerrarConexiones();
        List<String> Lrep = new ArrayList<String>();
        try {

            Lrep1 = fachada.cargarRepresentante(String.valueOf(usuario));

            Lrep.add(Lrep1.getNombredocr());
            Lrep.add(Lrep1.getNombredoc1());
            Lrep.add(Lrep1.getNombredoc2());
            Boolean existe = isContain(Lrep, campo);

            if (!existe) {
                errores++;
                error += "Número de documento no se encuentra registrado para esta SCB;";

            }
        } catch (Exception e) {
        }

        if (!campo.matches(representanteLegal)) {
            errores++;
            error += "Este campo contiene caracteres no válidos; ";
        }

        if (campo.length() > 15) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Documento del representante Legal de la SCB tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }

        return concatError + error;

    }

    private String cuentaInversionista(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (!campo.matches(numerica)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }

        if (campo.length() > 8) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        if (campo.equals("0")) {
            errores++;
            //error += "Cantidad de acciones inválida; "; Lsierra 2016-04-15 Mantis 2588
            error += "Cuenta Inversionista inválida; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Cuenta Inversionista tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }

        return concatError + error;
    }

    private String fiduciario(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;
        String tipo = "";

        try {
        tipo = tipoDoc;
        } catch (Exception e) {
        }

        if (tipoDoc.equalsIgnoreCase("N")) {
            if (!campo.matches(Alfanumerica)) {
                errores++;
                error += "El campo tiene caracteres inválidos; ";
            }
            if (campo.length() > 3) {
                errores++;
                error += "La longitud supera el máximo permitido; ";
            }
        } else if (!campo.equals("")) {
            errores++;
            error += "El especial fiduciario solo se puede ingresar para NIT; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Especial fiduciario tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }

        return concatError + error;
    }

    private String dVerificacion(String campo, String nit) {
        String error = "";
        concatError = "";
        int errores = 0;
        int id = 0;
        String tipo = "";
        try {
            
            tipo = tipoDoc;
            id = Integer.parseInt(nit);
        } catch (Exception e) {
        }
              
        if (tipoDoc.equalsIgnoreCase("N")) {
            if (!campo.matches(numerica)) {
                errores++;
                error += "El campo tiene caracteres inválidos; ";
            }

            if (campo.length() > 1) {
                errores++;
                error += "La longitud supera el máximo permitido; ";
            }

            if (campo.equals("")) {
                errores++;
                error += "El campo es obligatorio; ";
            } else if (nit.matches(numerica)) {
                if (!String.valueOf(validarRut(nit)).equals(campo)) {
                    errores++;
                    error += "El dígito de verificación ingresado no corresponde al NIT; ";
                }
            }
        } else if (!campo.equals("")) {
            errores++;
            error += "No se puede ingresar, el Tipo de Documento es diferente a NIT; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Digito de Verificación tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }

        return concatError + error;
    }

    private String nDocumento(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;
        String tipo = "";
        try {
            tipo = tipoDoc;
        } catch (Exception e) {
        }
        if (tipoDoc.equals("C") || tipoDoc.equals("N") || tipoDoc.equals("T") ||
             tipoDoc.equals("c") || tipoDoc.equals("n") || tipoDoc.equals("t")) {
            if (!campo.matches(numerica)) {
                errores++;
                error += "El campo tiene caracteres inválidos; ";
            }
        } else if (tipoDoc.equals("E") || tipoDoc.equals("P") || tipoDoc.equals("I") ||
                    tipoDoc.equals("e") || tipoDoc.equals("p") || tipoDoc.equals("i")) {
            if (!campo.matches(Alfanumerica)) {
                errores++;
                error += "El campo tiene caracteres inválidos; ";
            }
        }

        if (campo.length() > 15) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Número de documento tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }

        return concatError + error;
    }

    private String tipoDocumento(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (!campo.matches(Alfanumerica)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }

        if (campo.length() > 1) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        try {
            
            if(!documentTypesMap.containsKey(campo.trim().toUpperCase())){
                errores++;
                error += "El tipo de documento no existe; ";
            }
        } catch (Exception e) {
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Tipo de documento tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }

        return concatError + error;
    }

    
    private String nombre(String campo) {

        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 30) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

//        if (campo.equals("")) {
//            errores++;
//            error += "El campo es obligatorio; ";
//        }
        if (!campo.matches(eñestildes)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Nombres tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    private String apellido(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 30) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        if (!campo.matches(eñestildes)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Apellidos / Razón Social tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    private String nombreApellido(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 50) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        if (!campo.matches(eñestildes)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Nombre y apellidos / Razón Social tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    private String accionesAceptadas(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 11) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (!campo.matches(numerica)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }

        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }

        if (campo.equals("0")) {
            errores++;
            error += "Cantidad de acciones inválida; ";
        }
        if (errores > 0) {
            concatError = "El valor " + campo + " del campo No. de Acciones que acepto vender tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    private String existePreacuerdo(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 1) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }
        if (fachada.existePreacuerdo() && campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }
        if (!campo.matches(regexTodoNada)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }
        if (!fachada.existePreacuerdo() && !campo.equals("")) {
            errores++;
            error += "El campo no se encuentra habilitado para ser ingresado; ";
        }
        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Existe Preacuerdo tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    private String TodoNada(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 1) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }
        if (fachada.isTNShow() && campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }
        if (!campo.matches(regexTodoNada)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        }
        if (!fachada.isTNShow() && !campo.equals("")) {
            errores++;
            error += "El campo no se encuentra habilitado para ser ingresado; ";
        }
        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Se vende con condición Todo o Nada tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    private String ConsecutivoVenta(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;
        if (!campo.matches(Alfanumerica)) {
            errores++;
            error += "El campo tiene caracteres  inválidos; ";
        }
        if (campo.length() > 8) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }
        if (campo.equals("")) {
            errores++;
            error += "El campo es obligatorio; ";
        }
        if (errores > 0) {
            concatError = "El valor " + campo + " del campo Consecutivo Oferta de Venta tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    public int retornarIdDocumento(String campo) {

        if (campo.trim().equalsIgnoreCase("C")) {
            campo = "Cédula de Ciudadanía";
        } else if (campo.trim().equalsIgnoreCase("E")) {
            campo = "Cédula de Extranjería";
        } else if (campo.trim().equalsIgnoreCase("P")) {
            campo = "Pasaporte";
        } else if (campo.trim().equalsIgnoreCase("N")) {
            campo = "NIT";
        } else if (campo.trim().equalsIgnoreCase("I")) {
            campo = "NIP o NUIP";
        } else if (campo.trim().equalsIgnoreCase("T")) {
            campo = "Tarjeta de Identidad";
        } else {
            campo = "";
        }

        return fachada.existeDocumento(campo);
    }

    private String porcentajeComision(String campo) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (campo.length() > 7) {
            errores++;
            error += "La longitud supera el máximo permitido; ";
        }

        if (!campo.matches(regexNumericPuntComa)) {
            errores++;
            error += "El campo tiene caracteres inválidos; ";
        } else if (campo != null && !campo.equals("")) {
            if (!campo.matches(regexTresDecimales)) {
                errores++;
                error += "El valor supera el máximo de decimales permitidos; ";
            }
        }

        Double valor = 0.0;
        try {
            valor = Double.parseDouble(campo.replace(",", "."));
            if (valor > 100) {
                errores++;
                error += "El valor supera el porcentaje máximo; ";
            }
        } catch (Exception e) {
        }

        if (errores > 0) {
            concatError = "El valor " + campo + " del campo porcentaje de comisión tiene "
                    .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
        }
        return concatError + error;
    }

    public boolean isContain(List<String> lista, String clave) {

        for (int i = 0; i < lista.size(); i++) {

            if (clave.equals(lista.get(i))) {

                return true;

            }

        }
        return false;
    }

    public String validaParametrovacio() {

        String retorno = "";

        List<String> fechas = fachada.FechasIngreso();

        if (fechas.size() > 0) {
            retorno = "";
        } else {
            retorno = "No hay datos en la tabla Parametrización";
        }
        return retorno;
    }

    /**
     *
     * @param campo
     * @param tipoOfertaPublica corresponde a OPI u OPA
     * @param tipoPagoParametrizado correesponde a Manual o Predeterminado
     * @return
     */
    private String porcentajePagoEfectivo(String campo, String tipoOfertaPublica, int tipoPagoParametrizado) {
        String error = "";
        concatError = "";
        int errores = 0;

        if (tipoOfertaPublica.equals("OPI")) {

            ////////////////
            if (campo.length() > 3) {
                errores++;
                error += "La longitud supera el máximo permitido; ";
            }

            if (!campo.matches(numerico)) {
                errores++;
                error += "El campo tiene caracteres inválidos; ";
            }

            if (campo.equals("")) {
                errores++;
                error += "El campo es obligatorio; ";
            }

            int valor2 = 0;

            try {
                valor2 = Integer.parseInt(campo);

            } catch (Exception e) {
            }

            //Validación para ingreso manual parametrizado: valores del 0 al 100
            if (tipoPagoParametrizado == AppConstants.PORCENTAJE_PAGO_EFECTIVO_PARAM_MANUAL) {

                if (valor2 > 100) {
                    errores++;
                    error += "Porcentaje no válido, debe ser entre 0% y 100%; ";
                }

            } else {
                //Valdiación para ingreso predeterminado parametrizado: Únicos valores: 0 ó 100
                if (valor2 != 0 && valor2 != 100) {
                    errores++;
                    error += "Porcentaje no válido, debe ser únicamente 0% ó 100%; ";
                }
            }

            if (errores > 0) {
                concatError = "El valor " + campo + " del campo porcentaje de Pago en Efectivo tiene "
                        .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
            }

        }

        return concatError + error;
    }

    /**
     * Método encargado de validar la estructura del campo "dirección"
     *
     * @param campo
     * @return
     */
    private String direccion(String campo, boolean paramDireccionActivated,String tipoOfertaPublica) {
        String error = "";
        concatError = "";
        int errores = 0;

        if(tipoOfertaPublica.equals("OPI")){
            if (paramDireccionActivated) {

                if (campo.length() > 50) {
                    errores++;
                    error += "La longitud supera el máximo permitido; ";
                }

                if (errores > 0) {
                    concatError = "El valor " + campo + " del campo Dirección tiene "
                            .concat(errores > 1 ? "los siguientes errores: " : "el siguiente error: ");
                }
            }else if(!campo.equals(""))
                error += "El campo Dirección debe enviarse vacío ya que está desactivado";
        }
        return concatError + error;
    }
    
    /**
     * Populate document types to don´t call every time to Database
     */
    public void populateDocumentTypes(){
        documentTypesMap.put("C", "Cédula de Ciudadanía");
        documentTypesMap.put("E", "Cédula de Extranjería");
        documentTypesMap.put("P", "Pasaporte");
        documentTypesMap.put("N", "NIT");
        documentTypesMap.put("I", "NIP o NUIP");
        documentTypesMap.put("T", "Tarjeta de Identidad");
    }
}
