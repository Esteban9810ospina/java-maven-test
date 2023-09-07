///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.quasar.frameq.data;
//
//import com.quasar.frameq.db.Persistente;
//import java.sql.SQLException;
//import java.util.Vector;
//
///**
// *
// * @author Administrador
// */
//public class TipoInv extends Persistente{
//
//    private Integer tipoinv ;
//    private Integer grupoinversionista;
//    private String nombre;
//    private Double montomaximo;
//    private Double montominimo;
//    private Integer accionesdemandadas;
//    
//    public TipoInv(){
//    }
//    
//    public TipoInv (Integer tipoinv, Integer grupoinversionista, String nombre, Double montomaximo, Double montominimo, Integer accionesdemandadas) {
//        this.tipoinv = tipoinv;
//        this.grupoinversionista = grupoinversionista;
//        this.nombre = nombre;
//        this.montomaximo = montomaximo;
//        this.montominimo = montominimo;
//        this.accionesdemandadas = accionesdemandadas;
//    }
//    
//    public Integer getTipoinv() {
//        return tipoinv;
//    }
//
//    public void setTipoinv(Integer tipoinv) {
//        this.tipoinv = tipoinv;
//    }
//
//    public Integer getGrupoinversionista() {
//        return grupoinversionista;
//    }
//
//    public void setGrupoinversionista(Integer grupoinversionista) {
//        this.grupoinversionista = grupoinversionista;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Double getMontomaximo() {
//        return montomaximo;
//    }
//
//    public void setMontomaximo(Double montomaximo) {
//        this.montomaximo = montomaximo;
//    }
//
//    public Double getMontominimo() {
//        return montominimo;
//    }
//
//    public void setMontominimo(Double montominimo) {
//        this.montominimo = montominimo;
//    }
//
//    public Integer getAccionesdemandadas() {
//        return accionesdemandadas;
//    }
//
//    public void setAccionesdemandadas(Integer accionesdemandadas) {
//        this.accionesdemandadas = accionesdemandadas;
//    }
//
//    @Override
//    public Vector getContenido() {
//        Vector v = new Vector();
//        v.add(tipoinv);
//        v.add(grupoinversionista);
//        v.add(nombre);
//        v.add(montomaximo);
//        v.add(montominimo);
//        v.add(accionesdemandadas);
//        return v;
//    }
//
//    @Override
//    public Persistente nuevo(Vector v) {
//        return new TipoInv((Integer)v.elementAt(0),(Integer)v.elementAt(1),(String)v.elementAt(2),(Double)v.elementAt(3),(Double)v.elementAt(4),(Integer)v.elementAt(5));
//    }
//
//    @Override
//    public void inicializar() {
//        setPersistente(this);
//        String atributos[]={"i_grupoinversionista","i_tipoinv","c_nombre","e_montomaximo","e_montominimo","i_accionesdemandadas"};
//        int precision[]={0,0,0,0,0,0};
//        this.setPrecision(precision);
//        setAtributos(atributos);
//        setNombreTabla("dm_tipoinv");
//        setElementosLLave(1);
//    }
//
//    @Override
//    public void setContenido(Vector v) {
//        this.setTipoinv((Integer)v.elementAt(0));
//        this.setGrupoinversionista((Integer)v.elementAt(1));
//        this.setNombre(v.elementAt(2).toString());
//        this.setMontomaximo((Double)v.elementAt(3));
//        this.setMontominimo((Double)v.elementAt(4));
//        this.setAccionesdemandadas((Integer)v.elementAt(5));
//    }
//
//    @Override
//    public void setContenido() throws SQLException {
//        this.setTipoinv(rs.getInt("i_grupoinversionista"));
//        this.setGrupoinversionista(rs.getInt("i_tipoinv"));
//        this.setNombre(rs.getString("c_nombre"));
//        this.setMontomaximo(Double.parseDouble(rs.getString("e_montomaximo")));
//        this.setMontominimo(Double.parseDouble(rs.getString("e_montominimo")));
//        this.setAccionesdemandadas(rs.getInt("i_accionesdemandadas"));
//    }
//}
