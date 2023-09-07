/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.data;

import com.quasar.frameq.db.Persistente;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Administrador
 */
public class OrigenMILA extends Persistente implements Comparable<OrigenMILA>{

    private Integer idMila;
    private Integer codigoPais;
    private String pais;
    private Integer tipoDocumento;
    private String numeroDocumento;
    private String nombreTipoDocumento;
    private String numVerificacion;
    private String cuenta;
    private Integer estado;

    public OrigenMILA() {
    }

    public OrigenMILA(Integer idMila, Integer codigoPais, String pais, Integer tipoDocumento, String numeroDocumento, String numVerificacion, String cuenta, Integer estado) {
        this.idMila = idMila;
        this.codigoPais = codigoPais;
        this.pais = pais;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.numVerificacion = numVerificacion;
        this.cuenta = cuenta;
        this.estado = estado;
    }

    public Integer getIdMila() {
        return idMila;
    }

    public void setIdMila(Integer idMila) {
        this.idMila = idMila;
    }

    public Integer getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumVerificacion() {
        return numVerificacion;
    }

    public void setNumVerificacion(String numVerificacion) {
        this.numVerificacion = numVerificacion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    @Override
    public Vector getContenido() {
        Vector v = new Vector();
        v.add(idMila);
        v.add(codigoPais);
        v.add(pais);
        v.add(tipoDocumento);
        v.add(numeroDocumento);
        v.add(numVerificacion);
        v.add(cuenta);
        v.add(estado);
        return v;
    }

    @Override
    public Persistente nuevo(Vector v) {
        return new OrigenMILA((Integer) v.elementAt(0), (Integer) v.elementAt(1), (String) v.elementAt(2), (Integer) v.elementAt(3), (String) v.elementAt(4), (String) v.elementAt(5), (String) v.elementAt(6), (Integer) v.elementAt(7));
    }

    @Override
    public void inicializar() {
        setPersistente(this);
        String atributos[] = {"i_id", "codigo_pais", "pais", "tipo_doc", "numero_doc", "numero_ver", "cuenta", "estado"};
        int precision[] = {0, 0, 0, 0, 0, 0, 0, 0};
        this.setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("dm_origen_mila");
        setElementosLLave(1);
    }

    @Override
    public void setContenido(Vector v) {
        this.setIdMila((Integer) v.elementAt(0));
        this.setCodigoPais((Integer) v.elementAt(1));
        this.setPais(v.elementAt(2).toString());
        this.setTipoDocumento((Integer) v.elementAt(3));
        this.setNumeroDocumento(v.elementAt(4).toString());
        this.setNumVerificacion(v.elementAt(5).toString());
        this.setCuenta(v.elementAt(6).toString());
        this.setEstado((Integer) v.elementAt(7));
    }

    @Override
    public void setContenido() throws SQLException {
        this.setIdMila(rs.getInt("i_id"));
        this.setCodigoPais(rs.getInt("codigo_pais"));
        this.setPais(rs.getString("pais"));
        this.setTipoDocumento(rs.getInt("tipo_doc"));
        this.setNumeroDocumento(rs.getString("numero_doc"));
        this.setNumVerificacion(rs.getString("numero_ver"));
        this.setCuenta(rs.getString("cuenta"));
        this.setEstado(rs.getInt("estado"));

    }

    @Override
    public int compareTo(OrigenMILA o) {
        return this.getCodigoPais().compareTo(o.getCodigoPais());
    }
}
