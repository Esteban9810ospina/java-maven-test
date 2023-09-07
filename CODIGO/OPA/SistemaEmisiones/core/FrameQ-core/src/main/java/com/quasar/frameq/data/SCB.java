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
public class SCB extends Persistente{
   
    private Integer idScb;
    private String nombredoc;
    private Integer tipoDoc;
    private String razonSocial;
    private String codigoEntidad;
    private String tipoPersona;
    private String representante;
    private String direccion;
    private String telefono;
    private String fax;
    private String pais;
    private Integer codDep;
    private Integer codPais;
    private Integer entidadColocadora;
    private String representante1;
    private String representante2;    
    private String digitoVerificacion;
    private String nombredocr;
    private String nombredoc1;
    private String nombredoc2;
    
    public SCB() {
    }    

    public SCB(Integer idScb, String nombredoc, Integer tipoDoc, String codigoEntidad, String razonSocial, String tipoPersona, String representante, String direccion, String telefono, String fax, String pais, Integer codDep, Integer codPais, Integer entidadColocadora, String representante1, String representante2, String digitoVerificacion,String nombredocr, String nombredoc1,String nombredoc2) {
       
        
        this.idScb = idScb;
        this.nombredoc = nombredoc;
        this.tipoDoc = tipoDoc;
        this.codigoEntidad = codigoEntidad;
        this.razonSocial = razonSocial;
        this.tipoPersona = tipoPersona;
        this.representante = representante;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fax = fax;
        this.pais = pais;
        this.codDep = codDep;
        this.codPais = codPais;
        this.entidadColocadora = entidadColocadora;
        this.representante1 = representante1;
        this.representante2 = representante2;
        this.digitoVerificacion=digitoVerificacion;
        this.nombredocr = nombredocr;
        this.nombredoc1 = nombredoc1;
        this.nombredoc2 = nombredoc2;
    }

    
    
    public Integer getIdScb() {
        return idScb;
    }

    public void setIdScb(Integer idScb) {
        this.idScb = idScb;
    }

    public String getNombredoc() {
        return nombredoc;
    }

    public void setNombredoc(String nombredoc) {
        this.nombredoc = nombredoc;
    }

    public Integer getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Integer tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    
    public String getCodigoEntidad() {
        return codigoEntidad;
    }
    

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getCodDep() {
        return codDep;
    }

    public void setCodDep(Integer codDep) {
        this.codDep = codDep;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    public Integer getEntidadColocadora() {
        return entidadColocadora;
    }

    public void setEntidadColocadora(Integer entidadColocadora) {
        this.entidadColocadora = entidadColocadora;
    }
    
    
    public String getRepresentante1() {
            return representante1;
    }

    public void setRepresentante1(String representante1) {
        this.representante1 = representante1;
    }
    
    public String getRepresentante2() {
        return representante2;
    }

    public void setRepresentante2(String representante2) {
        this.representante2 = representante2;
    }
    
   public String getdigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setdigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }
    
     public String getNombredocr() {
        return nombredocr;
    }

    public void setNombredocr(String nombredocr) {
        this.nombredocr = nombredocr;
    }
    
    public String getNombredoc1() {
        return nombredoc1;
    }

    public void setNombredoc1(String nombredoc1) {
        this.nombredoc1 = nombredoc1;
    }
   
    public String getNombredoc2() {
        return nombredoc2;
    }

    public void setNombredoc2(String nombredoc2) {
        this.nombredoc2 = nombredoc2;
    }
    
    @Override
    public Vector getContenido() {
        Vector v = new Vector();
        
        v.add(idScb);
        v.add(nombredoc);
        v.add(tipoDoc);
        v.add(codigoEntidad);
        v.add(razonSocial);
        v.add(tipoPersona);
        v.add(representante);
        v.add(direccion);
        v.add(telefono);
        v.add(fax);
        v.add(pais);
        v.add(codDep);
        v.add(codPais);
        v.add(entidadColocadora);
        v.add(representante1);
        v.add(representante2);
        v.add(digitoVerificacion);
        v.add(nombredocr);
        v.add(nombredoc1);
        v.add(nombredoc2);
                
         
        return v;
    }

    @Override
    public Persistente nuevo(Vector v) {
        return new SCB((Integer)v.elementAt(0),(String)v.elementAt(1),(Integer)v.elementAt(2),(String)v.elementAt(3), (String)v.elementAt(4),(String)v.elementAt(5),(String)v.elementAt(6),(String)v.elementAt(7),(String)v.elementAt(9),(String)v.elementAt(10),(String)v.elementAt(11),(Integer)v.elementAt(12),(Integer)v.elementAt(13),(Integer)v.elementAt(14),(String)v.elementAt(15),(String)v.elementAt(16),(String)v.elementAt(17),(String)v.elementAt(18),(String)v.elementAt(19),(String)v.elementAt(20));
    }

    @Override
    public void inicializar() {
        setPersistente(this);
        String atributos[]={"i_scb","c_documento","i_tipodocumento", "i_codigoentidad", "c_razonsocial","c_tipopersona","c_representante","c_direccion","c_telefono","c_fax","c_pais","i_codigodepto","i_codigociudad","i_entidadcolocadora", "c_representante1", "c_representante2", "c_digito_verificacion", "c_numdoc_representante", "c_numdoc_representante2", "c_numdoc_representante3"};
        int precision[]={0,0,0,0,0,0};
        this.setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("dm_scb");
        setElementosLLave(1);
    }

    @Override
    public void setContenido(Vector v) {
        
        this.setIdScb((Integer)v.elementAt(0));
        this.setNombredoc(v.elementAt(1).toString());
        this.setTipoDoc((Integer)v.elementAt(2));
        this.setCodigoEntidad(v.elementAt(3).toString());
        this.setRazonSocial(v.elementAt(4).toString());
        this.setTipoPersona(v.elementAt(5).toString());
        this.setRepresentante(v.elementAt(6).toString());
        this.setDireccion(v.elementAt(7).toString());
        this.setTelefono(v.elementAt(8).toString());
        this.setFax(v.elementAt(9).toString());
        this.setPais(v.elementAt(10).toString());
        this.setCodDep((Integer)v.elementAt(11));
        this.setCodPais((Integer)v.elementAt(12));
        this.setEntidadColocadora((Integer)v.elementAt(13));
        this.setRepresentante1((String)v.elementAt(14));
        this.setRepresentante2((String)v.elementAt(15));
        this.setdigitoVerificacion((String)v.elementAt(16));
        this.setNombredocr((String)v.elementAt(17));
        this.setNombredoc1((String)v.elementAt(18));
        this.setNombredoc2((String)v.elementAt(19));
        
        
    }

    @Override
    public void setContenido() throws SQLException {

        this.setIdScb(rs.getInt("i_scb"));
        this.setNombredoc(rs.getString("c_documento"));
        this.setTipoDoc(rs.getInt("i_tipodocumento"));
        this.setCodigoEntidad(rs.getString("i_codigoentidad"));
        this.setRazonSocial(rs.getString("c_razonsocial"));
        this.setTipoPersona(rs.getString("c_tipopersona"));
        this.setRepresentante(rs.getString("c_representante"));
        this.setDireccion(rs.getString("c_direccion"));
        this.setTelefono(rs.getString("c_telefono"));
        this.setFax(rs.getString("c_fax"));
        this.setPais(rs.getString("c_pais"));
        this.setCodDep(rs.getInt("i_codigodepto"));
        this.setCodPais(rs.getInt("i_codigociudad"));
        this.setEntidadColocadora(rs.getInt("i_entidadcolocadora"));
        this.setRepresentante1(rs.getString("c_representante1"));
        this.setRepresentante2(rs.getString("c_representante2"));
        this.setdigitoVerificacion(rs.getString("c_digito_verificacion"));
        this.setNombredocr("c_numdoc_representante");
        this.setNombredoc1("c_numdoc_representante2");
        this.setNombredoc2("c_numdoc_representante3");
        
    }

    
}
