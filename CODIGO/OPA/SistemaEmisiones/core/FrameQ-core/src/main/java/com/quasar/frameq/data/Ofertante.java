//package com.quasar.frameq.data;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.Collection;
//import java.util.Vector;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//import com.quasar.frameq.db.Persistente;
//import com.quasar.frameq.fachadas.FacadeUsuarios;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Ofertante extends Persistente {
//
//    private Integer ofertante;
//    private Integer tipodocumento;
//    private String numdocumento;
//    private String primerapellido;
//    private String segundoapellido;
//    private String nombres;
//    private int tipoinversionista;
//    private String tipoinstitucion;
//    private Integer numAfiliados;
//    private String retencion;
//    private String autoretenedor;
//    private String tipocuenta;
//    private String residente;
//    private String contribuyente;
//    private String mayoredad;
//    private Integer actividad;
//    private String caracter;
//    private Integer ingresosmensuales;
//    private Integer patrimonio;
//    private String origenfondos;
//    private String cuentadeceval;
//    private String accionista;
//    private Integer referencia;
//    private Integer fase;
//    private Double montosolicitado;
//    //private JDBCAdapter tabla;
//    private Integer emision;
//    //private String inversionista; // Eliminar este campo, no sirve para nada
//    private String tipoPersona;
//    private Integer domicilio;
//    private Double montoExtranjeros;
//    //nuevos campos
//    private Integer declararRenta;
//    private Integer patrimonioAutonomo;
//    private Integer cuentaDeposito;
//    private Integer indicadortipoinv;
//    private Double montomaximoinvertir;
//    private String ef;
//    private String esColaborador;
//    private String esCliente;
//
//    public Ofertante() {
//        this.ofertante = new Integer(0);
//        this.tipodocumento = new Integer(0);
//        this.tipoPersona = "1"; // Natural por defecto
//        this.numdocumento = "";
//        this.primerapellido = "";
//        this.segundoapellido = "";
//        this.nombres = "";
//        this.tipoinversionista = 0;
//        this.tipoinstitucion = "0";
//        this.numAfiliados = 0;
//        this.montoExtranjeros = 0.0;
//        this.retencion = "";
//        this.autoretenedor = "";
//        this.domicilio = new Integer(0);
//        this.tipocuenta = "3";
//        this.residente = "";
//        this.contribuyente = "";
//        this.mayoredad = "1";
//        this.actividad = new Integer(0);
//        this.caracter = "";
//        this.ingresosmensuales = new Integer(0);
//        this.patrimonio = new Integer(0);
//        this.origenfondos = "NA";
//        this.cuentadeceval = "";
//        this.accionista = "2";
//        this.referencia = new Integer(0);
//        this.fase = new Integer(0);
//        this.montosolicitado = new Double(0);
//        this.emision = new Integer(0);
//        //nuevos campos
//        this.declararRenta = new Integer(0);
//        this.patrimonioAutonomo = new Integer(0);
//        this.cuentaDeposito = new Integer(0);
//        this.indicadortipoinv = 0;
//        this.montomaximoinvertir = 0.0;
//        this.ef = new String();
//        this.esColaborador = "";
//        this.esCliente = "";
//
//        try {
//            jbInit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    public Ofertante(Integer ofertante, Integer tipodocumento, String tipoPersona,
//            String numdocumento, String primerapellido, String segundoapellido,
//            String nombres, Integer tipoinversionista,
//            String tipoinstitucion, Integer numAfiliados, Double montoExtranjeros, String retencion,
//            String autoretenedor, Integer domicilio,
//            String tipocuenta, String residente,
//            String contribuyente, String mayoredad, Integer actividad, String caracter,
//            Integer ingresosmensuales, Integer patrimonio,
//            String origenfondos, String cuentadeceval, String accionista, Integer referencia,
//            Integer fase, Double montosolicitado, Integer emision, Integer declararRenta,
//            Integer patrimonioAutonomo, String cuentaDeposito, Integer indicadortipoinv, Double montomaximo, String ef,
//            String esColaborador, String esCliente) {
//        this.setOfertante(ofertante);
//        this.setTipodocumento(tipodocumento);
//        this.setTipoPersona(tipoPersona);
//        this.setNumdocumento(numdocumento);
//        this.setPrimerapellido(primerapellido);
//        this.setSegundoapellido(segundoapellido);
//        this.setNombres(nombres);
//        this.setTipoinversionista(tipoinversionista);
//        this.setTipoinstitucion(tipoinstitucion);
//        this.setNumAfiliados(numAfiliados);
//        this.setMontoExtranjeros(montoExtranjeros);
//        this.setRetencion(retencion);
//        this.setAutoretenedor(autoretenedor);
//        this.setDomicilio(domicilio);
//        this.setTipocuenta(tipocuenta);
//        this.setResidente(residente);
//        this.setContribuyente(contribuyente);
//        this.setMayoredad(mayoredad);
//        this.setActividad(actividad);
//        this.setCaracter(caracter);
//        this.setIngresosmensuales(ingresosmensuales);
//        this.setPatrimonio(patrimonio);
//        this.setOrigenfondos(origenfondos);
//        this.setCuentadeceval(cuentadeceval);
//        this.setAccionista(accionista);
//        this.setReferencia(referencia);
//        this.setFase(fase);
//        this.setMontosolicitado(montosolicitado);
//        this.setEmision(emision);
//
//        //Lineas agregada
//        this.setDeclararRenta(declararRenta.toString());
//        this.setPatrimonioAutonomo(patrimonioAutonomo.toString());
//        this.setCuentaDeposito(cuentaDeposito);
//        this.setIndicadorTipoInv(indicadortipoinv);
//        this.setMontoMaximoInvertir(montomaximo);
//        this.setEf(ef);
//        this.setEsColaborador(esColaborador);
//        this.setEsCliente(esCliente);
//
//    }
//
//    public void setOfertante(Integer ofertante) {
//        this.ofertante = ofertante;
//    }
//
//    public Error setTipodocumento(Integer tipodocumento) {
//        Connection connection = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        Error error = new Error();
//        try {
//            connection = this.tabla.getConnection();
//            stmt = connection.createStatement();
//            String sqlquery = "select c_nombredoc from dm_tipodocumento where i_tipodocumento = ".concat(tipodocumento.toString());
//            rs = stmt.executeQuery(sqlquery);
//            if (rs.next()) {
//                this.tipodocumento = tipodocumento;
//            } 
//        } catch (SQLException se) {
//            Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, se);
//
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return error;
//    }
//
//    public void setNumdocumento(String numdocumento) {
//        this.numdocumento = numdocumento;
//    }
//
//    //metodo nuevo
//    public Error setMontoMaximoInvertir(Double montoMaximo) {
//        Error error = new Error();
//
//        if ((this.indicadortipoinv.intValue() <= 3) && (this.indicadortipoinv.intValue() >= 1)) {
//            if (montoMaximo.doubleValue() > 0) {
//                this.montomaximoinvertir = montoMaximo;
//            } 
//        } else {
//            if (montomaximoinvertir != null && montomaximoinvertir.doubleValue() == 0) {
//                this.montomaximoinvertir = montoMaximo;
//            } 
//        }
//        return error;
//    }
//
//    public void setPrimerapellido(String primerapellido) {
//        this.primerapellido = primerapellido;
//    }
//
//    public void setSegundoapellido(String segundoapellido) {
//        this.segundoapellido = segundoapellido;
//    }
//
//    public Error setCuentaDeposito(String cuentadeposito) {
//        Error error = new Error();
//        try {
//            this.cuentaDeposito = new Integer(cuentadeposito.trim());
//        } catch (NumberFormatException e) {
//            Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, e);
//        }
//
//        return error;
//    }
//
//    public Error setAccionista(String accionista) {
//        Error error = new Error();
//        if (accionista.equalsIgnoreCase("1") || accionista.equalsIgnoreCase("2")) {
//            this.accionista = accionista;
//        } 
//        return error;
//    }
//
//    public void setNombres(String nombres) {
//        this.nombres = nombres;
//    }
//
//    public Error setTipoinversionista(Integer tipoinversionista) {
//        Error error = new Error();
//
//        this.tipoinversionista = tipoinversionista.intValue();
//        return error;
//    }
//
//    public Error setTipoinversionista(String tipoinversionista, int fase, int emision) {
//        Error error = new Error();
//        Connection connection = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            connection = this.tabla.getConnection();
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery("select fas.i_grupodestinatario grupodestinatario, gru.c_nombreGrupo nombreGrupo"
//                    + " from dm_fase fas, dm_grupoinv gru"
//                    + " where i_emision=" + emision + " and i_idfase=" + fase
//                    + " and fas.i_grupodestinatario = gru.i_idGrupoInv");
//            if (rs.first()) {
//                if (rs.getString("nombreGrupo").indexOf("olidar") != -1) {
//                    if (tipoinversionista.equals("0")) {
//                        this.tipoinversionista = Integer.parseInt(tipoinversionista);
//                    }
//                } else {
//                    if (tipoinversionista.equals("1")
//                            || tipoinversionista.equals("2")) {
//                        this.tipoinversionista = Integer.parseInt(tipoinversionista);
//                    } 
//                }
//            }
//        } catch (SQLException se) {
//             Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, se);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return error;
//
//    }
//
//    public void setTipoinstitucion(String tipoinstitucion) {
//        this.tipoinstitucion = tipoinstitucion;
//    }
//
//    public Error setTipoinstitucion(String tipoinstitucion, int fase, int emision) {
//        Error error = new Error();
//        Connection connection = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            connection = this.tabla.getConnection();
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery("select i_grupodestinatario from dm_fase where i_idfase=" + fase + " and i_emision=" + emision);
//            if (rs.first()) {
//                if (rs.getString("i_grupodestinatario").equals("2")) {
//                    if (tipoinstitucion.equalsIgnoreCase("1")
//                            || tipoinstitucion.equalsIgnoreCase("2")
//                            || tipoinstitucion.equalsIgnoreCase("3")
//                            || tipoinstitucion.equalsIgnoreCase("0")) {
//                        this.tipoinstitucion = tipoinstitucion;
//                    } 
//                }
//            } else {
//                if (tipoinstitucion.equals("0")) {
//                    this.tipoinstitucion = tipoinstitucion;
//                } 
//            }
//        } catch (SQLException se) {
//           Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, se);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return error;
//    }
//
//    public void setNumAfiliados(Integer numAfiliados) {
//        this.numAfiliados = numAfiliados;
//    }
//
//    public Error setRetencion(String retencion) {
//        Error error = new Error();
//        if (retencion != null && (retencion.equalsIgnoreCase("1") || retencion.equalsIgnoreCase("2") || retencion.equalsIgnoreCase("0"))) {
//            this.retencion = retencion;
//        } 
//        return error;
//    }
//
//    public Error setAutoretenedor(String autoretenedor) {
//
//        Error error = new Error();
//        if (autoretenedor != null && (autoretenedor.equalsIgnoreCase("1") || autoretenedor.equalsIgnoreCase("2") || autoretenedor.equalsIgnoreCase("0"))) {
//            this.autoretenedor = autoretenedor;
//        } 
//        return error;
//    }
//
//    public Error setTipocuenta(String tipocuenta) {
//        Error error = new Error();
//        if (tipocuenta != null && (tipocuenta.equalsIgnoreCase("1") || tipocuenta.equalsIgnoreCase("2") || tipocuenta.equalsIgnoreCase("3"))) {
//            this.tipocuenta = tipocuenta;
//        }
//        return error;
//    }
//
//    //M�todo agregado
//    public Error setDeclararRenta(String declarar) {
//        Error error = new Error();
//        if (declarar != null && (declarar.equalsIgnoreCase("1") || declarar.equalsIgnoreCase("2"))) {
//            this.declararRenta = new Integer(declarar.trim());
//        } 
//        return error;
//    }
//
//    public void setDeclararRentaSimple(String declarar) {
//        this.declararRenta = new Integer(declarar);
//    }
//
//    //M�todo agregado
//    public Error setIndicadorTipoInv(Integer indicador) {
//        Error error = new Error();
//        try {
//            if (indicador.intValue() == 1 || indicador.intValue() == 2
//                    || indicador.intValue() == 3 || indicador.intValue() == 0
//                    || indicador.intValue() == 4 || indicador.intValue() == 5
//                    || indicador.intValue() == 6 || indicador.intValue() == 7
//                    || indicador.intValue() == 8 || indicador.intValue() == 9
//                    || indicador.intValue() == 10 || indicador.intValue() == 11
//                    || indicador.intValue() == 12 || indicador.intValue() == 13
//                    || indicador.intValue() == 14) {
//                this.indicadortipoinv = indicador;
//            } 
//        } catch (Exception e) {
//           Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, e);
//        }
//
//        return error;
//    }
//
//    //M�todo agregado
//    public Error setPatrimonioAutonomo(String autonomo) {
//        Error error = new Error();
//        Fase faseClass = new Fase();
//
//        try {
//            faseClass.consultaG("select fase.i_grupodestinatario, grupoInv.c_nombreGrupo"
//                    + " from dm_fase fase, dm_grupoinv grupoInv"
//                    + " where fase.i_grupodestinatario = grupoInv.i_idGrupoInv"
//                    + " and fase.i_emision=" + emision.toString() + " and fase.i_idfase=" + fase.toString()
//                    + " and grupoInv.c_nombreGrupo like '%olidario%'");
//
//            if (faseClass.first()) {
//                if (autonomo.equalsIgnoreCase("1") || autonomo.equalsIgnoreCase("2")
//                        || autonomo.equalsIgnoreCase("0")) {
//                    this.patrimonioAutonomo = new Integer(autonomo.trim());
//                } 
//            } else {
//                if (autonomo.equalsIgnoreCase("1") || autonomo.equalsIgnoreCase("2")) {
//                    this.patrimonioAutonomo = new Integer(autonomo.trim());
//                } 
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            faseClass.cerrarConexiones();
//        }
//        return error;
//    }
//
//    public Error setResidente(String residente) {
//        Error error = new Error();
//        if (residente.equalsIgnoreCase("S") || residente.equalsIgnoreCase("N")) {
//            this.residente = residente;
//        } 
//        return error;
//    }
//
//    public Error setContribuyente(String contribuyente) {
//        Error error = new Error();
//        if (contribuyente.equalsIgnoreCase("1") || contribuyente.equalsIgnoreCase("2")) {
//            this.contribuyente = contribuyente;
//        } 
//        return error;
//    }
//
//    public Error setMayoredad(String mayoredad) {
//        Error error = new Error();
//        if (mayoredad.equalsIgnoreCase("1") || mayoredad.equalsIgnoreCase("2") || mayoredad.equalsIgnoreCase("0")) {
//            this.mayoredad = mayoredad;
//        } 
//        return error;
//    }
//
//    public Error setActividad(Integer actividad) {
//        Connection connection = null;
//        Error error = new Error();
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            connection = this.tabla.getConnection();
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery("select c_nombre from dm_actividadeconomica where i_actividad = " + actividad);
//            if (rs.next()) {
//                this.actividad = actividad;
//            } 
//        } catch (SQLException se) {
//             Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, se);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException se) {
//                Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, se);
//            }
//
//        }
//        return error;
//    }
//
//    public Error setCaracter(String caracter) {
//        Error error = new Error();
//        if (caracter.equalsIgnoreCase("1") || caracter.equalsIgnoreCase("2")
//                || caracter.equalsIgnoreCase("0") || caracter.equalsIgnoreCase("3")
//                || caracter.equalsIgnoreCase("4") || caracter.equalsIgnoreCase("5")) // Dice 4 personas naturales
//        {
//            this.caracter = caracter;
//        } 
//        return error;
//    }
//
//    public Error setIngresosmensuales(Integer ingresosmensuales) {
//        Error error = new Error();
//        if (ingresosmensuales.intValue() == 1 || ingresosmensuales.intValue() == 2
//                || ingresosmensuales.intValue() == 3) {
//            this.ingresosmensuales = ingresosmensuales;
//        } 
//        return error;
//    }
//
//    public Error setPatrimonio(Integer patrimonio) {
//        Error error = new Error();
//        if (patrimonio.intValue() == 1 || patrimonio.intValue() == 2
//                || patrimonio.intValue() == 3) {
//            this.patrimonio = patrimonio;
//        } 
//        return error;
//    }
//
//    public void setOrigenfondos(String origenfondos) {
//        this.origenfondos = origenfondos;
//    }
//
//    public void setCuentadeceval(String cuentadeceval) {
//        this.cuentadeceval = cuentadeceval;
//    }
//
//    public void setReferencia(Integer referencia) {
//        this.referencia = referencia;
//    }
//
//    public void setFase(Integer fase) {
//        this.fase = fase;
//    }
//
//    public void setMontosolicitado(Double montosolicitado) {
//        this.montosolicitado = montosolicitado;
//    }
//
//    public void setEmision(Integer emision) {
//        this.emision = emision;
//    }
//
//    public Error setTipoPersona(String tipoPersona) {
//        Error error = new Error();
//        try {
//            Integer.parseInt(tipoPersona);
//            this.tipoPersona = tipoPersona;
//        } catch (NumberFormatException e) {
//             Logger.getLogger(Ofertante.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return error;
//    }
//
//    public void setDomicilio(Integer domicilio) {
//        this.domicilio = domicilio;
//    }
//
//    public void setMontoExtranjeros(Double montoExtranjeros) {
//        this.montoExtranjeros = montoExtranjeros;
//    }
//
//    public void setEf(String ef) {
//        if (ef != null) {
//            if (!ef.equals("null")) {
//                this.ef = ef;
//            } else {
//                this.ef = "";
//            }
//        } else {
//            this.ef = "";
//        }
//    }
//
//    public Integer getOfertante() {
//        return ofertante;
//    }
//
//    public Integer getTipodocumento() {
//        return tipodocumento;
//    }
//
//    public String getNumdocumento() {
//        return numdocumento;
//    }
//
//    public String getPrimerapellido() {
//        return primerapellido;
//    }
//
//    public String getSegundoapellido() {
//        return segundoapellido;
//    }
//
//    public String getNombres() {
//        return nombres;
//    }
//
//    public int getTipoinversionista() {
//        return tipoinversionista;
//    }
//
//    public String getTipoinstitucion() {
//        return tipoinstitucion;
//    }
//
//    public Integer getCodinstitucion() {
//        return numAfiliados;
//    }
//
//    public String getRetencion() {
//        return retencion;
//    }
//
//    public String getAutoretenedor() {
//        return autoretenedor;
//    }
//
//    public String getTipocuenta() {
//        return tipocuenta;
//    }
//
//    public String getResidente() {
//        return residente;
//    }
//
//    public String getContribuyente() {
//        return contribuyente;
//    }
//
//    public String getMayoredad() {
//        return mayoredad;
//    }
//
//    public Integer getActividad() {
//        return actividad;
//    }
//
//    public String getCaracter() {
//        return caracter;
//    }
//
//    public Integer getIngresosmensuales() {
//        return ingresosmensuales;
//    }
//
//    public Integer getPatrimonio() {
//        return patrimonio;
//    }
//
//    public String getOrigenfondos() {
//        return origenfondos;
//    }
//
//    public String getCuentadeceval() {
//        return cuentadeceval;
//    }
//
//    public String getAccionista() {
//        return accionista;
//    }
//
//    public Integer getReferencia() {
//        return referencia;
//    }
//
//    public Integer getFase() {
//        return fase;
//    }
//
//    public Double getMontosolicitado() {
//        return montosolicitado;
//    }
//
//    public Integer getEmision() {
//        return emision;
//    }
//
//    public String getTipoPersona() {
//        return tipoPersona;
//    }
//
//    public Integer getDomicilio() {
//        return domicilio;
//    }
//
//    public Double getMontoExtranjeros() {
//        return montoExtranjeros;
//    }
//
//    public Integer getDeclararRenta() {
//        return declararRenta;
//    }
//
//    public Integer getPatrimonioAutonomo() {
//        return patrimonioAutonomo;
//    }
//
//    public Integer getCuentaDeposito() {
//        return cuentaDeposito;
//    }
//
//    public Integer getIndicadorTipoInv() {
//        return indicadortipoinv;
//    }
//
//    public Double getMontoMaximoInvertir() {
//        return montomaximoinvertir;
//    }
//
//    public String getEf() {
//        return ef;
//    }
//
//    public Vector getContenido() {
//        Vector v = new Vector();
//        v.add(ofertante);
//        v.add(tipodocumento);
//        v.add(this.tipoPersona);
//        v.add(numdocumento);
//        v.add(primerapellido);
//        v.add(segundoapellido);
//        v.add(nombres);
//        v.add(tipoinversionista);
//        v.add(tipoinstitucion);
//        v.add(numAfiliados);
//        v.add(this.montoExtranjeros);//10
//        v.add(retencion);
//        v.add(autoretenedor);
//        v.add(this.domicilio);
//        v.add(tipocuenta);
//        v.add(residente);
//        v.add(contribuyente);
//        v.add(mayoredad);
//        v.add(actividad);
//        v.add(caracter);
//        v.add(ingresosmensuales);//20        
//        v.add(patrimonio);
//        v.add(origenfondos);
//        v.add(cuentadeceval);
//        v.add(accionista);
//        v.add(referencia);
//        v.add(fase);
//        v.add(montosolicitado);
//        v.add(emision);
//        v.add(declararRenta);
//        v.add(patrimonioAutonomo);
//        v.add(cuentaDeposito.toString());//TODO
//        v.add(indicadortipoinv);
//        v.add(montomaximoinvertir);
//        v.add(ef);
//        v.add(esColaborador);
//        v.add(esCliente);
//        return v;
//    }
//
//    public void inicializar() {
//        setPersistente(this);
//        String atributos[] = {"i_ofertante", "i_tipodocumento", "c_tipopersona", "i_numdocumento", "c_primerapellido",
//            "c_segundoapellido", "c_nombres", "i_tipoinversionista",//"c_inversionista",
//            "c_tipoinstitucion", "i_numafiliados", "e_montoextranjeros", "c_retencion", "c_autoretenedor",
//            "i_domicilio", "c_tipocuenta", "c_residente", "c_contribuyente", "c_mayoredad", "i_actividad",
//            "c_caracter", "i_ingresosmensuales", "i_patrimonio", "c_origenfondos",
//            "c_cuentadeceval", "c_accionista", "i_referencia", "i_fase",
//            "e_montosolicitado", "i_emision", "i_declararrenta", "i_patrimonioAutonomo",
//            "i_cuentaDeposito", "i_indicadortipoinv", "i_montomaximoinvertir", "c_ef", "c_es_colaborador", "c_es_cliente"};
//        int precision[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        this.setPrecision(precision);
//        setAtributos(atributos);
//        setNombreTabla("dm_ofertante");
//        setElementosLLave(1);
//    }
//
//    public Persistente nuevo(Vector v) {
//        return new Ofertante((Integer) v.elementAt(0), // i_ofertante
//                (Integer) v.elementAt(1), // i_tipo documento
//                (String) v.elementAt(2), // c_tipo persona
//                (String) v.elementAt(3), // i_numero documento
//                (String) v.elementAt(4), // c_primer apellido
//                (String) v.elementAt(5), // c_segundo apellido
//                (String) v.elementAt(6), // c_nombres
//                (Integer) v.elementAt(7), // i_tipo inversionista
//                //(String)v.elementAt(8), // c_inversionista
//                (String) v.elementAt(8), // c_tipo institucional
//                (Integer) v.elementAt(9), // i_numero afiliados
//                (Double) v.elementAt(10), // e_monto extranjeros
//                (String) v.elementAt(11), // c_retencion
//                (String) v.elementAt(12), // c_autoretenedor
//                (Integer) v.elementAt(13), // i_domicilio
//                (String) v.elementAt(14), // c_tipocuenta
//                (String) v.elementAt(15), // c_residente
//                (String) v.elementAt(16), // c_contribuyente
//                (String) v.elementAt(17), // c_mayoredad
//                (Integer) v.elementAt(18), // i_actividad
//                (String) v.elementAt(19), // c_caracter
//                (Integer) v.elementAt(20), // i_ingresosmensuales
//                (Integer) v.elementAt(21), // i_patrimonio
//                (String) v.elementAt(22), // c_origenfondos
//                (String) v.elementAt(23), // c_cuentadeceval
//                (String) v.elementAt(24), // c_accionista
//                (Integer) v.elementAt(25), // i_referencia
//                (Integer) v.elementAt(26), // i_fase
//                (Double) v.elementAt(27), // e_montosolicitado
//                (Integer) v.elementAt(28), // i_emision
//
//                //Nuevos instrucciones
//                (Integer) v.elementAt(29), // i_declararrenta
//                (Integer) v.elementAt(30), // i_patrimonioautonomo
//                (String) v.elementAt(31), // i_cuentadeposito
//                (Integer) v.elementAt(32), // i_indicadortipoinv
//                (Double) v.elementAt(33), //i_montomaximoinvertir
//                (String) v.elementAt(34), //c_ef
//                (String) v.elementAt(35), //c_es_colaborador
//                (String) v.elementAt(36) //c_es_cliente
//        );
//    }
//
//    public void setContenido() throws SQLException {
//        this.setOfertante(new Integer(rs.getInt("i_ofertante")));
//        this.setTipodocumento(new Integer(rs.getInt("i_tipodocumento")));
//        this.setTipoPersona(rs.getString("c_tipopersona"));
//        this.setNumdocumento((rs.getString("i_numdocumento")));
//        this.setPrimerapellido((rs.getString("c_primerapellido")));
//        this.setSegundoapellido((rs.getString("c_segundoapellido")));
//        this.setNombres((rs.getString("c_nombres")));
//        this.setTipoinversionista(new Integer(rs.getInt("i_tipoinversionista")));
//        this.setTipoinstitucion((rs.getString("c_tipoinstitucion")));
//        this.setNumAfiliados(new Integer(rs.getInt("i_numafiliados")));
//        this.setRetencion(rs.getString("c_retencion"));
//        this.setAutoretenedor((rs.getString("c_autoretenedor")));
//        this.setDomicilio(new Integer(rs.getInt("i_domicilio")));
//        this.setTipocuenta((rs.getString("c_tipocuenta")));
//        this.setResidente((rs.getString("c_residente")));
//        this.setContribuyente((rs.getString("c_contribuyente")));
//        this.setMayoredad((rs.getString("c_mayoredad")));
//        this.setActividad(new Integer(rs.getInt("i_actividad")));
//        this.setCaracter((rs.getString("c_caracter")));
//        this.setIngresosmensuales(new Integer(rs.getInt("i_ingresosmensuales")));
//        this.setPatrimonio(new Integer(rs.getInt("i_patrimonio")));
//        this.setOrigenfondos((rs.getString("c_origenfondos")));
//        this.setCuentadeceval((rs.getString("c_cuentadeceval")));
//        this.setAccionista((rs.getString("c_accionista")));
//        this.setReferencia(new Integer(rs.getInt("i_referencia")));
//        this.setFase(new Integer(rs.getInt("i_fase")));
//        this.setMontosolicitado(new Double(rs.getDouble("e_montosolicitado")));
//        this.setEmision(new Integer(rs.getInt("i_emision")));
//        this.setDomicilio(new Integer(rs.getInt("i_domicilio")));
//
//        //Lineas nuevas
//        this.setDeclararRenta((rs.getString("i_declararrenta")));
//        this.setPatrimonioAutonomo((rs.getString("i_patrimonioautonomo")));
//        this.setCuentaDeposito((rs.getString("i_cuentadeposito")));
//        this.setIndicadorTipoInv(new Integer(rs.getString("i_indicadortipoinv")));
//        this.setMontoMaximoInvertir(new Double(rs.getDouble("i_montomaximoinvertir")));
//        this.setEf(rs.getString("c_ef"));
//        this.setEsColaborador(rs.getString("c_es_colaborador"));
//        this.setEsCliente(rs.getString("c_es_cliente"));
//    }
//
//    public void setContenido(Vector v) {
//        String auxS;
//        Integer auxI;
//        Date auxD;
//        Timestamp auxT;
//        Double auxDb;
//        Float auxF;
//        Double auxL;
//        this.setOfertante(new Integer(0));
//
//        auxS = v.elementAt(1).toString();
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setTipodocumento(auxI);
//        } else {
//            this.setTipodocumento(new Integer(0));
//        }
//
//        this.setTipoPersona((String) v.elementAt(2));
//
//        this.setNumdocumento((String) v.elementAt(3));
//
//        this.setPrimerapellido((String) v.elementAt(4));
//
//        this.setSegundoapellido((String) v.elementAt(5));
//
//        this.setNombres((String) v.elementAt(6));
//
//        auxS = v.elementAt(7).toString(); // i_numafiliados
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setTipoinversionista(auxI); // i_tipo de inversionista
//        } else {
//            this.setNumAfiliados(new Integer(0));
//        }
//
//        this.setTipoinstitucion((String) v.elementAt(8));
//        auxS = v.elementAt(9).toString(); // i_numafiliados
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setNumAfiliados(auxI);
//        } else {
//            this.setNumAfiliados(new Integer(0));
//        }
//
//        //this.setMontoExtranjeros(Double.valueOf((String)v.elementAt(10)));
//        auxS = v.elementAt(10).toString();
//        auxDb = new Double(auxS);
//        if (auxDb != null) {
//            this.setMontosolicitado(auxDb);
//        } else {
//            this.setMontosolicitado(new Double(0));
//        }
//
//        this.setRetencion((String) v.elementAt(11));
//
//        this.setAutoretenedor((String) v.elementAt(12));
//        auxS = v.elementAt(13).toString(); // i_domicilio
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setDomicilio(auxI);
//        }
//
//        this.setTipocuenta((String) v.elementAt(14));
//
//        this.setResidente((String) v.elementAt(15));
//
//        this.setContribuyente((String) v.elementAt(16));
//
//        this.setMayoredad((String) v.elementAt(17));
//
//        auxS = v.elementAt(18).toString(); // i_actividad
//        auxI = new Integer(auxS); //
//        if (auxI != null) {
//            this.setActividad(auxI);
//        } else {
//            this.setActividad(new Integer(0));
//        }
//
//        this.setCaracter((String) v.elementAt(19));
//
//        auxS = v.elementAt(20).toString(); // i_ingresos
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setIngresosmensuales(auxI);
//        } else {
//            this.setIngresosmensuales(new Integer(0));
//        }
//
//        auxS = v.elementAt(21).toString(); // i_patrimonio
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setPatrimonio(auxI);
//        } else {
//            this.setPatrimonio(new Integer(0));
//        }
//
//        this.setOrigenfondos((String) v.elementAt(22));
//
//        this.setCuentadeceval((String) v.elementAt(23));
//
//        this.setAccionista((String) v.elementAt(24));
//
//        auxS = v.elementAt(25).toString(); // i_referencia
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setReferencia(auxI);
//        } else {
//            this.setReferencia(new Integer(0));
//        }
//
//        auxS = v.elementAt(26).toString(); // i_fase
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setFase(auxI);
//        } else {
//            this.setFase(new Integer(0));
//        }
//
//        auxS = v.elementAt(27).toString();
//        auxDb = new Double(auxS);
//        if (auxDb != null) {
//            this.setMontosolicitado(auxDb);
//        } else {
//            this.setMontosolicitado(new Double(0));
//        }
//
//        auxS = v.elementAt(28).toString(); // i_emision
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setEmision(auxI);
//        } else {
//            this.setEmision(new Integer(0));
//        }
//
//        //Linea nueva
//        auxS = v.elementAt(29).toString(); // i_declararrenta
//        if (auxS != null) {
//            this.setDeclararRenta(auxS);
//        } else {
//            this.setDeclararRenta(new String("0"));
//        }
//
//        auxS = v.elementAt(30).toString(); // i_patrimonioautonomo
//        if (auxS != null) {
//            this.setPatrimonioAutonomo(auxS);
//        } else {
//            this.setPatrimonioAutonomo("0");
//        }
//
//        this.setCuentaDeposito((String) v.elementAt(31)); //c_cuentadeposito
//
//        auxS = v.elementAt(32).toString(); // i_indicadortipoinv
//        auxI = new Integer(auxS);
//        if (auxI != null) {
//            this.setIndicadorTipoInv(auxI);
//        } else {
//            this.setIndicadorTipoInv(new Integer(0));
//        }
//
//        this.setEf((String) v.elementAt(34));
//
//        this.setEsColaborador(v.elementAt(35) != null ? v.elementAt(35).toString() : "");
//        this.setEsCliente(v.elementAt(36) != null ? v.elementAt(36).toString() : "");
//
//    }
//
//    public boolean referencia(Vector v) {
//        return true;
//    }
//
//    public int ValidarDigitoVerificacion(String unNit) {
//        int miSuma = 0;
//        int DigitoVer = 0;
//        int[] miArregloPA = {71, 67, 59, 53, 47, 43, 41, 37, 29, 23, 19, 17, 13, 7, 3};
//
//        for (int i = 0; i < unNit.length(); i++) {
//            miSuma = miSuma + (Integer.parseInt(unNit.substring(i, i + 1)) * miArregloPA[15 - (unNit.length() - i)]);
//        }
//
//        DigitoVer = miSuma % 11;
//        if (DigitoVer > 1) {
//            DigitoVer = 11 - DigitoVer;
//        }
//        return DigitoVer;
//
//    }
//
//    private void jbInit() throws Exception {
//    }
//
//    /**
//     * @return the esColaborador
//     */
//    public String getEsColaborador() {
//        return esColaborador;
//    }
//
//    /**
//     * @param esColaborador the esColaborador to set
//     */
//    public void setEsColaborador(String esColaborador) {
//        this.esColaborador = esColaborador;
//    }
//
//    /**
//     * @return the esCliente
//     */
//    public String getEsCliente() {
//        return esCliente;
//    }
//
//    /**
//     * @param esCliente the esCliente to set
//     */
//    public void setEsCliente(String esCliente) {
//        this.esCliente = esCliente;
//    }
//}
