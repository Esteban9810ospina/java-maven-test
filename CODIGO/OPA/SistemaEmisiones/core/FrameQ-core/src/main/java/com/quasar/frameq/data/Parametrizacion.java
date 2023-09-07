/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.data;

/**
 *
 * @author David_Puerta
 */
public class Parametrizacion {
    
    private String textoUno;
    private String textoDos;
    private String textoTres;
    private String textoCuatro;
    private String fecha;
    private String claseAcciones;
    private String existePreacuerdo;
    
    public Parametrizacion(){
        this.textoUno = "";
        this.textoDos = "";
        this.textoTres = "";
        this.textoCuatro = "";
        this.fecha = "";
        this.claseAcciones = "";
        this.existePreacuerdo = "";
    }

    public Parametrizacion(String textoUno, String textoDos, String textoTres, String textoCuatro, String fecha, String claseAcciones, String existePreacuerdo) {
        this.textoUno = textoUno;
        this.textoDos = textoDos;
        this.textoTres = textoTres;
        this.textoCuatro = textoCuatro;
        this.fecha = fecha;
        this.claseAcciones = claseAcciones;
        this.existePreacuerdo = existePreacuerdo;
    }
    
    

    public String getTextoUno() {
        return textoUno;
    }

    public void setTextoUno(String textoUno) {
        this.textoUno = textoUno;
    }

    public String getTextoDos() {
        return textoDos;
    }

    public void setTextoDos(String textoDos) {
        this.textoDos = textoDos;
    }

    public String getTextoTres() {
        return textoTres;
    }

    public void setTextoTres(String textoTres) {
        this.textoTres = textoTres;
    }

    public String getTextoCuatro() {
        return textoCuatro;
    }

    public void setTextoCuatro(String textoCuatro) {
        this.textoCuatro = textoCuatro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getClaseAcciones() {
        return claseAcciones;
    }

    public void setClaseAcciones(String claseAcciones) {
        this.claseAcciones = claseAcciones;
    }

    public String getExistePreacuerdo() {
        return existePreacuerdo;
    }

    public void setExistePreacuerdo(String existePreacuerdo) {
        this.existePreacuerdo = existePreacuerdo;
    }
    
    
    
}
