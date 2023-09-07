/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.data;

/**
 *
 * @author jam
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.quasar.frameq.interfaces.Error;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.quasar.frameq.db.Persistente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Formulario extends Persistente {

    private Integer numformulario;
    private Integer digitoverificacion;
    private Integer ofertante;
    private Integer representante;
    private Integer cuotainicial;
    private Double montosolicitado;
    private Integer paquete;
    private Integer dividendos;
    private int saldo;
    private Double montovalido;
    private Integer archivo;
    private String opcionmontosolicitado;
    private String modalidadpago;
    private Double montocalculado;
    private Double montoaprobado;
    private String depositantedirecto;
    private String validaregistros;
    private String firmaaccionista;
    private String firmatitular;
    private Timestamp fechagrabacion;
    private Timestamp fecharadicacion;
    private Integer idplazo;
    private Integer digitoverdocumento;
    private Integer fase;
    private Integer emision;
    private Integer tipoinv;
    private Double devoluciones;
    private Integer entidadcolocadora;
    private Integer bancocolocador;
    private String sucursalbancaria;
    private String promotorbanco;
    private Integer aceptacondiciones;
    private Double accionesacomprar;
    //private JDBCAdapter tabla;
    private Character estado;
    private Double valorAccion;
    private String usuario;
    private Double montonominal;
    private Double tasaofrecida;
    private String referenciaComisionista;

    public Formulario() {

        this.numformulario = new Integer(0);
        this.digitoverificacion = new Integer(0);
        this.ofertante = new Integer(0);
        this.representante = new Integer(0);
        this.cuotainicial = new Integer(0);
        this.montosolicitado = new Double(0);
        this.paquete = new Integer(0);
        this.dividendos = new Integer(0);
        this.saldo = 0;
        this.montovalido = new Double(0);
        this.modalidadpago = "";
        this.archivo = new Integer(0);
        this.opcionmontosolicitado = "";
        this.montocalculado = new Double(0);
        this.montoaprobado = new Double(0);
        this.depositantedirecto = "";
        this.validaregistros = "";
        this.firmaaccionista = "";
        this.firmatitular = "";
        this.fechagrabacion = new Timestamp(System.currentTimeMillis());
        this.fecharadicacion = new Timestamp(System.currentTimeMillis());
        this.idplazo = new Integer(0);
        this.digitoverdocumento = new Integer(0);
        this.fase = new Integer(0);
        this.emision = new Integer(0);
        this.tipoinv = new Integer(0);
        this.devoluciones = new Double(0);
        this.entidadcolocadora = new Integer(0);
        this.bancocolocador = new Integer(0);
        this.sucursalbancaria = "";
        this.promotorbanco = "";
        this.aceptacondiciones = 0;
        this.accionesacomprar = new Double(0);
        this.estado = new Character('I');
        this.valorAccion = 0.0;
        this.usuario = "";
        setMontonominal(0.0);
        setTasaofrecida(0.0);
        this.referenciaComisionista = "";

    }

    public Formulario(Integer numformulario, Integer digitoverificacion, Integer ofertante,
            Integer representante, Integer cuotainicial, Double montosolicitado,
            Integer paquete, Integer dividendos, int saldo, Double montovalido,
            Integer archivo, String opcionmontosolicitado,
            String modalidadpago, Double montocalculado, Double montoaprobado,
            String depositantedirecto, String validaregistros, String firmaaccionista,
            String firmatitular, Timestamp fechagrabacion, Timestamp fecharadicacion,
            Integer idplazo, Integer digitoverdocumento, Integer fase, Integer emision,
            Integer tipoinv, Double devoluciones, Integer entidadcolocadora,
            Integer bancocolocador, String sucursalbancaria, String promotorbanco, Integer aceptacondiciones,
            Double accionesacomprar,
            Character estado,
            Double valorAccion, String usuario, Double montonominal, Double tasaofrecida, String referenciaComisionista) {
        this.setNumformulario(numformulario);
        this.setDigitoverificacion(digitoverificacion);
        this.setOfertante(ofertante);
        this.setRepresentante(representante);
        this.setCuotainicial(cuotainicial);
        this.setMontosolicitado(montosolicitado);
        this.setPaquete(paquete);
        this.setDividendos(dividendos);
        this.setSaldo(saldo);
        this.setMontovalido(montovalido);
        this.setArchivo(archivo);
        this.setOpcionmontosolicitado(opcionmontosolicitado);
        this.setModalidadpago(modalidadpago);
        this.setMontocalculado(montocalculado);
        this.setMontoaprobado(montoaprobado);
        this.setDepositantedirecto(depositantedirecto);
        this.setValidaregistros(validaregistros);
        this.setFirmaaccionista(firmaaccionista);
        this.setFirmatitular(firmatitular);
        this.setFechagrabacion(fechagrabacion);
        this.setFecharadicacion(fecharadicacion);
        this.setIdplazo(idplazo);
        this.setDigitoverdocumento(digitoverdocumento);
        this.setFase(fase);
        this.setEmision(emision);
        this.setTipoinv(tipoinv);
        this.setDevoluciones(devoluciones);
        this.setEntidadcolocadora(entidadcolocadora);
        this.setBancocolocador(bancocolocador);
        this.setSucursalbancaria(sucursalbancaria);
        this.setPromotorbanco(promotorbanco);
        this.setAceptaciondiciones(aceptacondiciones);
        this.setAccionesacomprar(accionesacomprar);
        this.setEstado(estado);
        this.setValorAccion(valorAccion);
        this.setUsuario(usuario);
        setMontonominal(montonominal);
        setTasaofrecida(tasaofrecida);
        this.setReferenciaComisionista(referenciaComisionista);
    }

    public void setMontonominal(Double montonominal) {
        this.montonominal = montonominal;
    }

    public void setTasaofrecida(Double tasaofrecida) {
        this.tasaofrecida = tasaofrecida;
    }

    public void setPromotorbanco(String promotorbanco) {
        this.promotorbanco = promotorbanco;
    }

    public void setSucursalbancaria(String sucursalbancaria) {
        this.sucursalbancaria = sucursalbancaria;
    }

    public Error setBancocolocador(Integer bancocolocador) {
        Error error = new Error();
        if (this.getModalidadpago() != null) {
            if (this.getModalidadpago().equalsIgnoreCase("1")) { // Pago de contado
                this.bancocolocador = bancocolocador;
                return error;
            }
        } else {
            return error;
        }
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.tabla.getConnection();
            stmt = connection.createStatement();
            String sqlquery = "select c_tipoentidad from dm_entidadcolocadora where i_entidadcolocadora = ";
            sqlquery = sqlquery.concat(bancocolocador.toString());
            rs = stmt.executeQuery(sqlquery);
            if (rs.next()) {
                this.bancocolocador = bancocolocador;
            } else {
                error.setTipoError(57);
                error.setDescripcion("La entidad colocadora no existe");
                error.setCampo(16);
            }
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, se);
            }
        }
        return error;
    }

    public void setNumformulario(Integer numformulario) {
        this.numformulario = numformulario;
    }

    public void setDigitoverificacion(Integer digitoverificacion) {
        this.digitoverificacion = digitoverificacion;
    }

    public void setOfertante(Integer ofertante) {
        this.ofertante = ofertante;
    }

    public void setRepresentante(Integer representante) {
        this.representante = representante;
    }

    public void setCuotainicial(Integer cuotainicial) {
        this.cuotainicial = cuotainicial;
    }

    public Error setMontosolicitado(Double montosolicitado) {
        Error error = new Error();
        //if (montosolicitado.doubleValue() >= 600000d) // Este valor debe ser parametrizado
        if (montosolicitado.doubleValue() > 0d) // Este valor debe ser parametrizado
        {
            this.montosolicitado = montosolicitado;
        } else {
            error.setTipoError(56);
            error.setDescripcion("El monto solicitado no es válido");
            error.setCampo(6);
        }
        return error;
    }

    public void setPaquete(Integer paquete) {
        this.paquete = paquete;
    }

    public void setDividendos(Integer dividendos) {
        this.dividendos = dividendos;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setMontovalido(Double montovalido) {
        this.montovalido = montovalido;
    }

    public void setEntidadcolocadoraSimple(Integer entidadcolocadora) {
        this.entidadcolocadora = entidadcolocadora;
    }

    /*  SE DESHABILITA ESTE METODO PARA LA DEMOCRATIZACION DE TIGO, HAY QUE CORREGIRLO PARA OSAGEN Y DESHABILITAR EL OTRO
     public Error setEntidadcolocadora(Integer entidadcolocadora) {
     Error error = new Error();

     if (entidadcolocadora.intValue() == 1 || entidadcolocadora.intValue() == 2)
     this.entidadcolocadora=entidadcolocadora;
     else {
     error.setTipoError(65);
     error.setDescripcion("El campo entidad colocadora no es válido");
     error.setCampo(26);
     }


     return error;
     }
     */
    public Error setEntidadcolocadora(Integer entidadcolocadora) {
        Error error = new Error();
        if (this.getModalidadpago() != null) {
            if (this.getModalidadpago().equalsIgnoreCase("1")) { // Pago de contado
                this.entidadcolocadora = entidadcolocadora;
                return error;
            }
        } else {
            return error;
        }
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.tabla.getConnection();
            stmt = connection.createStatement();
            String sqlquery = "select c_tipoentidad from dm_entidadcolocadora where i_entidadcolocadora = ";
            sqlquery = sqlquery.concat(entidadcolocadora.toString());
            rs = stmt.executeQuery(sqlquery);
            if (rs.next()) {
                this.entidadcolocadora = entidadcolocadora;
            } else {
                error.setTipoError(57);
                error.setDescripcion("La entidad colocadora no existe");
                error.setCampo(16);
            }
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, se);
            }
        }
        return error;
    }

    public void setArchivo(Integer archivo) {
        this.archivo = archivo;
    }

    public void setOpcionmontosolicitado(String opcionmontosolicitado) {
        this.opcionmontosolicitado = opcionmontosolicitado;
    }

    public Error setModalidadpago(String modalidadpago) {
        Error error = new Error();
        if (modalidadpago.equalsIgnoreCase("1") || modalidadpago.equalsIgnoreCase("2")
                || modalidadpago.equalsIgnoreCase("0")) {
            this.modalidadpago = modalidadpago;
        } else {
            error.setTipoError(58);
            error.setDescripcion("La modalidad de pago no es válida");
            error.setCampo(5);
        }
        return error;
    }

    public Error setMontocalculado(Double montocalculado) {
        Error error = new Error();
        if (montocalculado.doubleValue() > 0d) // Debe parametrizarse
        {
            this.montocalculado = montocalculado;
        } else {
            error.setTipoError(59);
            error.setDescripcion("El monto calculado no es válido");
            error.setCampo(7);
        }
        return error;
    }

    public Error setMontoaprobado(Double montoaprobado) {
        Error error = new Error();
//if (montoaprobado.doubleValue() >= 600000d) // Debe parametrizarse
        if (montoaprobado.doubleValue() == 0d) // Debe parametrizarse
        {
            this.montoaprobado = montoaprobado;
        } else {
            error.setTipoError(60);
            error.setDescripcion("El monto aprobado no es válido");
            error.setCampo(8);
        }
        return error;
    }

    public Error setDepositantedirecto(String depositantedirecto) {
        this.depositantedirecto = depositantedirecto;
        return null;
    }

    public Error setValidaregistros(String validaregistros) {
        Error error = new Error();
        if (validaregistros.equalsIgnoreCase("1") || validaregistros.equalsIgnoreCase("3")) {
            this.validaregistros = validaregistros;
        } else {
            error.setTipoError(62);
            error.setDescripcion("El campo valida registros no es válido");
            error.setCampo(30);
        }
        return error;
    }

    public Error setFirmaaccionista(String firmaaccionista) {
        Error error = new Error();
        if (firmaaccionista.equalsIgnoreCase("0") || firmaaccionista.equalsIgnoreCase("1")) {
            this.firmaaccionista = firmaaccionista;
        } else {
            error.setTipoError(63);
            error.setDescripcion("El campo firma accionista es válido");
            error.setCampo(33);
        }
        return error;
    }

    public Error setFirmatitular(String firmatitular) {
        Error error = new Error();
        if (firmatitular.equalsIgnoreCase("0") || firmatitular.equalsIgnoreCase("1")) {
            this.firmatitular = firmatitular;
        } else {
            error.setTipoError(63);
            error.setDescripcion("El campo firma titular es válido");
            error.setCampo(33);
        }
        return error;
    }

    public Error setFechagrabacion(Timestamp fechagrabacion) {
        Error error = new Error();
        try {
            this.fechagrabacion = fechagrabacion;
        } catch (Exception ex) {
            error.setTipoError(64);
            error.setDescripcion("La fecha de grabación no es válida");
            error.setCampo(32);
        }
        return error;
    }

    public Error setFecharadicacion(Timestamp fecharadicacion) {
        Error error = new Error();
        try {
            this.fecharadicacion = fecharadicacion;
        } catch (Exception ex) {
            error.setTipoError(65);
            error.setDescripcion("La fecha de radicación no es válida");
            error.setCampo(31);
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return error;
    }

    public void setIdplazo(Integer idplazo) {
        this.idplazo = idplazo;
    }

    public void setDigitoverdocumento(Integer digitoverdocumento) {
        this.digitoverdocumento = digitoverdocumento;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public void setEmision(Integer emision) {
        this.emision = emision;
    }

    public void setTipoinv(Integer tipoinv) {
        this.tipoinv = tipoinv;
    }

    public void setDevoluciones(Double devoluciones) {
        this.devoluciones = devoluciones;
    }

    public void setAceptaciondiciones(Integer aceptaciondiciones) {
        this.aceptacondiciones = aceptaciondiciones;
    }

    public void setAccionesacomprar(Double accionesacomprar) {
        this.accionesacomprar = accionesacomprar;
    }

    public Integer getNumformulario() {
        return numformulario;
    }

    public Integer getDigitoverificacion() {
        return digitoverificacion;
    }

    public Integer getOfertante() {
        return ofertante;
    }

    public Integer getRepresentante() {
        return representante;
    }

    public Integer getCuotainicial() {
        return cuotainicial;
    }

    public Double getMontosolicitado() {
        return montosolicitado;
    }

    public Integer getPaquete() {
        return paquete;
    }

    public Integer getDividendos() {
        return dividendos;
    }

    public int getSaldo() {
        return saldo;
    }

    public Double getMontovalido() {
        return montovalido;
    }

    public Integer getEntidadcolocadora() {
        return entidadcolocadora;
    }

    public Integer getArchivo() {
        return archivo;
    }

    public String getOpcionmontosolicitado() {
        return opcionmontosolicitado;
    }

    public String getModalidadpago() {
        return modalidadpago;
    }

    public Double getMontocalculado() {
        return montocalculado;
    }

    public Double getMontoaprobado() {
        return montoaprobado;
    }

    public String getDepositantedirecto() {
        return depositantedirecto;
    }

    public String getValidaregistros() {
        return validaregistros;
    }

    public String getFirmaaccionista() {
        return firmaaccionista;
    }

    public String getFirmatitular() {
        return firmatitular;
    }

    public Timestamp getFechagrabacion() {
        return fechagrabacion;
    }

    public Timestamp getFecharadicacion() {
        return fecharadicacion;
    }

    public Integer getIdplazo() {
        return idplazo;
    }

    public Integer getDigitoverdocumento() {
        return digitoverdocumento;
    }

    public Integer getFase() {
        return fase;
    }

    public Integer getEmision() {
        return emision;
    }

    public Integer getTipoinv() {
        return tipoinv;
    }

    public Double getDevoluciones() {
        return devoluciones;
    }

    public String getPromotorbanco() {
        return promotorbanco;
    }

    public String getSucursalbancaria() {
        return sucursalbancaria;
    }

    public Integer getBancocolocador() {
        return bancocolocador;
    }

    public Integer getAceptacondiciones() {
        return aceptacondiciones;
    }

    public Double getAccionesacomprar() {
        return accionesacomprar;
    }

    public Double getMontonominal() {
        return montonominal;
    }

    public Double getTasaofrecida() {
        return tasaofrecida;
    }

    public void setReferenciaComisionista(String referenciaComisionista) {
        if (referenciaComisionista != null) {
            if (!referenciaComisionista.equals("null")) {
                this.referenciaComisionista = referenciaComisionista;
            } else {
                this.referenciaComisionista = "";
            }
        } else {
            this.referenciaComisionista = "";
        }
    }

    public String getReferenciaComisionista() {
        return referenciaComisionista;
    }

    public Vector getContenido() {
        Vector v = new Vector();
        v.add(numformulario);
        v.add(digitoverificacion);
        v.add(ofertante);
        v.add(representante);
        v.add(cuotainicial);
        v.add(montosolicitado);
        v.add(paquete);
        v.add(dividendos);
        v.add(new Integer(saldo));
        v.add(montovalido);
        v.add(archivo);
        v.add(opcionmontosolicitado);
        v.add(modalidadpago);
        v.add(montocalculado);
        v.add(montoaprobado);
        v.add(depositantedirecto);
        v.add(validaregistros);
        v.add(firmaaccionista);
        v.add(firmatitular);
        v.add(fechagrabacion);
        v.add(fecharadicacion);
        v.add(idplazo);
        v.add(digitoverdocumento);
        v.add(fase);
        v.add(emision);
        v.add(tipoinv);
        v.add(devoluciones);
        v.add(entidadcolocadora);
        v.add(bancocolocador);
        v.add(sucursalbancaria);
        v.add(promotorbanco);
        v.add(aceptacondiciones);
        v.add(accionesacomprar);
        v.add(estado);
        v.add(valorAccion);
        v.add(usuario);
        v.add(montonominal);
        v.add(tasaofrecida);
        v.add(referenciaComisionista);
        return v;
    }

    public void inicializar() {
        setPersistente(this);
        String atributos[] = {"i_numformulario", "i_digitoverificacion", "i_ofertante",
            "i_representante", "i_cuotainicial", "e_montosolicitado",
            "i_paquete", "i_dividendos", "i_saldo",
            "i_montovalido", "i_archivo", "c_opcionmontosolicitado",
            "c_modalidadpago", "e_montocalculado", "e_montoaprobado",
            "c_depositantedirecto", "c_validaregistros", "c_firmaaccionista",
            "c_firmatitular", "dt_fechagrabacion", "dt_fecharadicacion",
            "i_idplazo", "i_digitoverdocumento", "i_fase",
            "i_emision", "i_tipoinv", "e_devoluciones",
            "i_entidadcolocadora", "c_bancocolocador", "c_sucursalbancaria",
            "c_promotorbanco", "i_aceptacondiciones", "i_accionesacomprar",
            "c_estado", "e_valoraccion", "c_usuario",
            "c_montonominal", "c_tasaofrecida", "c_referencia_comisionista"};
        int precision[] = {0, 0, 0, 0, 2, 0, 0, 2, 2, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 2, 0};
        this.setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("dm_formulario");
        setElementosLLave(1);
    }

    public Persistente nuevo(Vector v) {
        return new Formulario((Integer) v.elementAt(0), (Integer) v.elementAt(1), (Integer) v.elementAt(2),
                (Integer) v.elementAt(3), (Integer) v.elementAt(4), (Double) v.elementAt(5),
                (Integer) v.elementAt(6), (Integer) v.elementAt(7), ((Integer) v.elementAt(8)).intValue(),
                (Double) v.elementAt(9), (Integer) v.elementAt(10), (String) v.elementAt(11),
                (String) v.elementAt(12), (Double) v.elementAt(13), (Double) v.elementAt(14),
                (String) v.elementAt(15), (String) v.elementAt(16), (String) v.elementAt(17),
                (String) v.elementAt(18), (Timestamp) v.elementAt(19), (Timestamp) v.elementAt(20),
                (Integer) v.elementAt(21), (Integer) v.elementAt(22), (Integer) v.elementAt(23),
                (Integer) v.elementAt(24), (Integer) v.elementAt(25), (Double) v.elementAt(26),
                (Integer) v.elementAt(27), (Integer) v.elementAt(28), (String) v.elementAt(29),
                (String) v.elementAt(30), (Integer) v.elementAt(31), (Double) v.elementAt(32),
                (Character) v.elementAt(33), (Double) v.elementAt(34), (String) v.elementAt(35),
                (Double) v.elementAt(36), (Double) v.elementAt(37), (String) v.elementAt(38));
    }

    public void setContenido() throws SQLException {
        this.setNumformulario(new Integer(rs.getInt("i_numformulario")));
        this.setDigitoverificacion(new Integer(rs.getInt("i_digitoverificacion")));
        this.setOfertante(new Integer(rs.getInt("i_ofertante")));
        this.setRepresentante(new Integer(rs.getInt("i_representante")));
        this.setCuotainicial(new Integer(rs.getInt("i_cuotainicial")));
        this.setMontosolicitado(new Double(rs.getDouble("e_montosolicitado")));
        this.setPaquete(new Integer(rs.getInt("i_paquete")));
        this.setDividendos(new Integer(rs.getInt("i_dividendos")));
        this.setSaldo(rs.getInt("i_saldo"));
        this.setMontovalido(new Double(rs.getDouble("i_montovalido")));
        this.setArchivo(new Integer(rs.getInt("i_archivo")));
        this.setOpcionmontosolicitado(new String(rs.getString("c_opcionmontosolicitado")));
        this.setModalidadpago(new String(rs.getString("c_modalidadpago")));
        this.setMontocalculado(new Double(rs.getDouble("e_montocalculado")));
        this.setMontoaprobado(new Double(rs.getDouble("e_montoaprobado")));
        this.setDepositantedirecto(new String(rs.getString("c_depositantedirecto")));
        this.setValidaregistros(new String(rs.getString("c_validaregistros")));
        this.setFirmaaccionista(new String(rs.getString("c_firmaaccionista")));
        this.setFirmatitular(new String(rs.getString("c_firmatitular")));
        this.setFechagrabacion(rs.getTimestamp("dt_fechagrabacion"));
        this.setFecharadicacion(rs.getTimestamp("dt_fecharadicacion"));
        this.setIdplazo(new Integer(rs.getInt("i_idplazo")));
        this.setDigitoverdocumento(new Integer(rs.getInt("i_digitoverdocumento")));
        this.setFase(new Integer(rs.getInt("i_fase")));
        this.setEmision(new Integer(rs.getInt("i_emision")));
        this.setTipoinv(new Integer(rs.getInt("i_tipoinv")));
        this.setDevoluciones(new Double(rs.getDouble("e_devoluciones")));
        this.setEntidadcolocadora(new Integer(rs.getInt("i_entidadcolocadora")));
        this.setBancocolocador(new Integer(rs.getInt("c_bancocolocador")));
        this.setSucursalbancaria(new String(rs.getString("c_sucursalbancaria")));
        this.setPromotorbanco(new String(rs.getString("c_promotorbanco")));
        this.setAceptaciondiciones(new Integer(rs.getInt("i_aceptacondiciones")));
        this.setAccionesacomprar(new Double(rs.getDouble("i_accionesacomprar")));
        String str = rs.getString("c_estado");
        this.setEstado(new Character(str.charAt(0)));
        this.setValorAccion(new Double(rs.getDouble("e_valoraccion")));
        this.setUsuario(rs.getString("c_usuario"));
        setMontonominal(new Double(rs.getDouble("c_montonominal")));
        setTasaofrecida(new Double(rs.getDouble("c_tasaofrecida")));
        setReferenciaComisionista(new String(rs.getString("c_referencia_comisionista")));
    }

    public void setContenido(Vector v) {
        String auxS;
        Integer auxI;
        Date auxD;
        Timestamp auxT;
        Double auxDb;
        Float auxF;

        // 0. i_numformulario
        auxS = v.elementAt(0).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setNumformulario(auxI);
        } else {
            this.setNumformulario(new Integer(0));
        }

        //1. i_digitoverificacion
        auxS = v.elementAt(1).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setDigitoverificacion(auxI);
        } else {
            this.setDigitoverificacion(new Integer(0));
        }

        //2. i_ofertante
        auxS = v.elementAt(2).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setOfertante(auxI);
        } else {
            this.setOfertante(new Integer(0));
        }

        //3. i_representante
        auxS = v.elementAt(3).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setRepresentante(auxI);
        } else {
            this.setRepresentante(new Integer(0));
        }

        //4. i_cuotainicial
        auxS = v.elementAt(4).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setCuotainicial(auxI);
        } else {
            this.setCuotainicial(new Integer(0));
        }

        //5. e_montosolicitado
        auxS = v.elementAt(5).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMontosolicitado(auxDb);
        } else {
            this.setMontosolicitado(new Double(0));
        }

        //6. i_paquete
        auxS = v.elementAt(6).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setPaquete(auxI);
        } else {
            this.setPaquete(new Integer(0));
        }

        //7. i_dividendos
        auxS = v.elementAt(7).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setDividendos(auxI);
        } else {
            this.setDividendos(new Integer(0));
        }

        //8. i_saldo
        auxS = v.elementAt(8).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setSaldo(auxI.intValue());
        } else {
            this.setSaldo(0);
        }

        //9. i_montovalido
        auxS = v.elementAt(9).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMontovalido(auxDb);
        } else {
            this.setMontovalido(new Double(0));
        }

        // 10. i_archivo
        auxS = v.elementAt(10).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setArchivo(auxI);
        } else {
            this.setArchivo(new Integer(0));
        }

        //11. c_opcionmontosolicitado
        this.setOpcionmontosolicitado((String) v.elementAt(11));

        //12. c_modalidadpago
        this.setModalidadpago((String) v.elementAt(12));

        //13. e_montocalculado
        auxS = v.elementAt(13).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMontocalculado(auxDb);
        } else {
            this.setMontocalculado(new Double(0));
        }

        //14. e_montoaprobado
        auxS = v.elementAt(14).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMontoaprobado(auxDb);
        } else {
            this.setMontoaprobado(new Double(0));
        }

        //15. c_depositantedirecto
        this.setDepositantedirecto((String) v.elementAt(15));

        //16. c_validaregistros
        this.setValidaregistros((String) v.elementAt(16));

        //17. c_firmaaccionista
        this.setFirmaaccionista((String) v.elementAt(17));

        //18. c_firmatitular
        this.setFirmatitular((String) v.elementAt(18));

        //19. dt_fechagrabacion
        auxS = v.elementAt(19).toString();
        auxT = Timestamp.valueOf(auxS);
        if (auxT != null) {
            this.setFechagrabacion(auxT);
        } else {
            this.setFechagrabacion(new java.sql.Timestamp(System.currentTimeMillis()));
        }

        //20. dt_fecharadicacion
        auxS = v.elementAt(20).toString();
        auxT = Timestamp.valueOf(auxS);
        if (auxT != null) {
            this.setFecharadicacion(auxT);
        } else {
            this.setFecharadicacion(new java.sql.Timestamp(System.currentTimeMillis()));
        }

        //21. i_idplazo
        auxS = v.elementAt(21).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setIdplazo(auxI);
        } else {
            this.setIdplazo(new Integer(0));
        }

        //22. i_digitoverdocumento
        auxS = v.elementAt(22).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setDigitoverdocumento(auxI);
        } else {
            this.setDigitoverdocumento(new Integer(0));
        }

        //23. i_fase
        auxS = v.elementAt(23).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setFase(auxI);
        } else {
            this.setFase(new Integer(0));
        }

        //24. i_emision
        auxS = v.elementAt(24).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setEmision(auxI);
        } else {
            this.setEmision(new Integer(0));
        }

        //25. i_tipoinv
        auxS = v.elementAt(25).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setTipoinv(auxI);
        } else {
            this.setTipoinv(new Integer(0));
        }

        //26. e_devoluciones
        auxS = v.elementAt(26).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setDevoluciones(auxDb);
        } else {
            this.setDevoluciones(new Double(0));
        }

        //27. i_entidadcolocadora
        auxS = v.elementAt(27).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setEntidadcolocadora(auxI);
        } else {
            this.setEntidadcolocadora(new Integer(0));
        }

        //28. c_bancocolocador
        auxS = v.elementAt(28).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setBancocolocador(auxI);
        } else {
            this.setBancocolocador(new Integer(0));
        }

        //29. c_sucursalbancaria
        this.setSucursalbancaria((String) v.elementAt(29));

        //30. c_promotorbanco
        this.setPromotorbanco((String) v.elementAt(30));

        //31. i_aceptacondiciones
        auxS = v.elementAt(31).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setAceptaciondiciones(auxI);
        } else {
            this.setAceptaciondiciones(new Integer(0));
        }

        //32. i_accionesacomprar
        auxS = v.elementAt(32).toString();
        //auxDb = new Double(auxS);
        auxDb = new Double(auxS);
        if (auxI != null) {
            this.setAccionesacomprar(auxDb);
        } else {
            this.setAccionesacomprar(new Double(0));
        }

        //33. c_estado
        this.setEstado(new Character(v.elementAt(33) != null ? v.elementAt(33).toString().charAt(0) : ' '));

        //34. e_valoraccion
        auxS = v.elementAt(34).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setValorAccion(auxDb);
        } else {
            this.setValorAccion(new Double(0));
        }

        //35. c_usuario
        this.setUsuario(v.elementAt(33) != null ? v.elementAt(33).toString() : "");

        //36. c_montonominal
        auxS = v.elementAt(36).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMontonominal(auxDb);
        } else {
            this.setMontonominal(new Double(0));
        }

        //37. c_tasaofrecida
        auxS = v.elementAt(37).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setTasaofrecida(auxDb);
        } else {
            this.setTasaofrecida(new Double(0));
        }

        //38. c_referencia_comisionista       
        this.setReferenciaComisionista(v.elementAt(38) != null ? v.elementAt(39).toString() : "");
    }

    public boolean referencia(Vector v) {
        return true;
    }

    public static void main(String[] args) throws NamingException {
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
        Context context = new InitialContext();
        context.createSubcontext("java:");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/bookbuilding");
        dataSource.setUser("root");
        dataSource.setPassword("dinn3466");
        context.bind("java:/BookbuildingDS", dataSource);

        Formulario formulario = new Formulario();
        try {
            formulario.consultaG("select 1 from dm_formulario");

        } catch (SQLException e) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            formulario.cerrarConexiones();
        }
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Double getValorAccion() {
        return valorAccion;
    }

    public void setValorAccion(Double valorAccion) {
        this.valorAccion = valorAccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
