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
public class TipoDocumento extends Persistente{
    private Integer tipodocumento;
    private String nombredoc;
    private String validadv;
    private String dominio;
    private String codigobolsa;
    private String descripcion;
    
    
    public TipoDocumento() {
    }    
    
    public TipoDocumento(Integer tipodocumento, String nombredoc, String validadv, String dominio, String codigobolsa, String descripcion) {
        this.tipodocumento = tipodocumento;
        this.nombredoc = nombredoc;
        this.validadv = validadv;
        this.dominio = dominio;
        this.codigobolsa = codigobolsa;
        this.descripcion = descripcion;
    }
    
    

    public Integer getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Integer tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNombredoc() {
        return nombredoc;
    }

    public void setNombredoc(String nombredoc) {
        this.nombredoc = nombredoc;
    }

    public String getValidadv() {
        return validadv;
    }

    public void setValidadv(String validadv) {
        this.validadv = validadv;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getCodigobolsa() {
        return codigobolsa;
    }

    public void setCodigobolsa(String codigobolsa) {
        this.codigobolsa = codigobolsa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Vector getContenido() {
        Vector v = new Vector();
        v.add(tipodocumento);
        v.add(nombredoc);
        v.add(validadv);
        v.add(dominio);
        v.add(codigobolsa);
        v.add(descripcion);
        return v;
    }

    @Override
    public Persistente nuevo(Vector v) {
        return new TipoDocumento((Integer)v.elementAt(0),(String)v.elementAt(1),(String)v.elementAt(2),(String)v.elementAt(3),(String)v.elementAt(4),(String)v.elementAt(5));
    }

    @Override
    public void inicializar() {
        setPersistente(this);
        String atributos[]={"i_tipodocumento","c_nombredoc","c_validadv","c_dominio","c_codigobolsa","c_descripcion"};
        int precision[]={0,0,0,0,0,0};
        this.setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("dm_tipodocumento");
        setElementosLLave(1);
    }

    @Override
    public void setContenido(Vector v) {
        this.setTipodocumento((Integer)v.elementAt(0));
        this.setNombredoc(v.elementAt(1).toString());
        this.setValidadv(v.elementAt(2).toString());
        this.setDominio(v.elementAt(3).toString());
        this.setCodigobolsa(v.elementAt(4).toString());
        this.setDescripcion(v.elementAt(5).toString());
    }

    @Override
    public void setContenido() throws SQLException {
        this.setTipodocumento(rs.getInt("i_tipodocumento"));
        this.setNombredoc(rs.getString("c_nombredoc"));
        this.setValidadv(rs.getString("c_validadv"));
        this.setDominio(rs.getString("c_dominio"));
        this.setCodigobolsa(rs.getString("c_codigobolsa"));
        this.setDescripcion(rs.getString("c_descripcion"));
       
    }
    
}
