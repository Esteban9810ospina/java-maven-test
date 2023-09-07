/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.data;

import com.quasar.frameq.db.Persistente;
import java.sql.Date;
import java.util.Vector;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * @author LSIERRA
 */
public class Aceptaciones extends Persistente {   

  private Integer entidadDeNegociosID;
  private String  claseAcciones;
  private String  conOfeVen;
  private String  textoUno;
  private String  textoDos;
  private boolean existePreacuerdo;
  private Double  codScb;
  private String  nombreSCB;
  private String  representanteLegal;
  private String nombreRazonSocial;
  private Double  numAcciones;
  private boolean  venCon;
  private Integer tipDocumento;
  private String numNitDoc;
  private Double  numVer;
  private String espFid;
  private Double  ctaInv;
  private Integer nombreUsuarioIdCreacion;
  private Timestamp  fechaCreacion;
  private Integer nombreUsuarioIdModificacion;
  private Timestamp fechaModificacion;
        

  public Aceptaciones() {
      
    entidadDeNegociosID = new Integer(0);
    claseAcciones = "";
    conOfeVen = "";
    textoUno = "";
    textoDos = "";
    existePreacuerdo = new Boolean(true);
    codScb = new Double(0.0);
    nombreSCB = "";
    representanteLegal = "";
    nombreRazonSocial = "";
    numAcciones = new Double(0.0);
    venCon = new Boolean(true);
    tipDocumento = new Integer(0);
    numNitDoc = "";
    numVer = new Double(0.0);
    espFid="";
    ctaInv=new Double(0.0);
    nombreUsuarioIdCreacion = new Integer(0);
    fechaCreacion = (new Timestamp(System.currentTimeMillis()));
    nombreUsuarioIdModificacion=new Integer(0);
    fechaModificacion= (new Timestamp(System.currentTimeMillis()));

  }

  public Aceptaciones(Integer entidadDeNegociosID, String  claseAcciones, String  conOfeVen,
  String  textoUno, String  textoDos, boolean existePreacuerdo,
  Double  codScb, String  nombreSCB, String  representanteLegal,
  String nombreRazonSocial, Double  numAcciones, boolean  venCon,
  Integer tipDocumento, String numNitDoc, Double  numVer,
  String espFid, Double  ctaInv, Integer nombreUsuarioIdCreacion,
  Timestamp  fechaCreacion, Integer nombreUsuarioIdModificacion,
  Timestamp fechaModificacion) {
      
    setEntidadDeNegociosID(entidadDeNegociosID);
    setClaseAcciones(claseAcciones);
    setConOfeVen(conOfeVen);
    setTextoUno(textoUno);
    setTextoDos(textoDos);
    setExistePreacuerdo(existePreacuerdo);
    setCodScb(codScb);
    setNombreSCB(nombreSCB);
    setRepresentanteLegal(representanteLegal);
    setNombreRazonSocial(nombreRazonSocial);
    setNumAcciones(numAcciones);
    setVenCon(venCon);
    setTipDocumento(tipDocumento);
    setNumNitDoc(numNitDoc);
    setNumVer(numVer);
    setEspFid(espFid);
    setCtaInv(ctaInv);
    setNombreUsuarioIdCreacion(nombreUsuarioIdCreacion);
    setFechaCreacion(fechaCreacion);
    setNombreUsuarioIdModificacion(nombreUsuarioIdModificacion);
    setFechaModificacion(fechaModificacion);
  }

    public Integer getEntidadDeNegociosID() {
        return entidadDeNegociosID;
    }

    public void setEntidadDeNegociosID(Integer entidadDeNegociosID) {
        this.entidadDeNegociosID = entidadDeNegociosID;
    }

    public String getClaseAcciones() {
        return claseAcciones;
    }

    public void setClaseAcciones(String claseAcciones) {
        this.claseAcciones = claseAcciones;
    }

    public String getConOfeVen() {
        return conOfeVen;
    }

    public void setConOfeVen(String conOfeVen) {
        this.conOfeVen = conOfeVen;
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

    public Boolean getExistePreacuerdo() {
        return existePreacuerdo;
    }

    public void setExistePreacuerdo(Boolean existePreacuerdo) {
        this.existePreacuerdo = existePreacuerdo;
    }

    public Double getCodScb() {
        return codScb;
    }

    public void setCodScb(Double codScb) {
        this.codScb = codScb;
    }

    public String getNombreSCB() {
        return nombreSCB;
    }

    public void setNombreSCB(String nombreSCB) {
        this.nombreSCB = nombreSCB;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public Double getNumAcciones() {
        return numAcciones;
    }

    public void setNumAcciones(Double numAcciones) {
        this.numAcciones = numAcciones;
    }

    public Boolean getVenCon() {
        return existePreacuerdo;
    }

    public void setVenCon(Boolean venCon) {
        this.venCon = venCon;
    }

    public Integer getTipDocumento() {
        return tipDocumento;
    }

    public void setTipDocumento(Integer tipDocumento) {
        this.tipDocumento = tipDocumento;
    }

    public String getNumNitDoc() {
        return numNitDoc;
    }

    public void setNumNitDoc(String numNitDoc) {
        this.numNitDoc = numNitDoc;
    }
    
    
    public Double getNumVer() {
        return numVer;
    }

    public void setNumVer(Double numVer) {
        this.numVer = numVer;
    }
    
     public String getEspFid() {
        return espFid;
    }

    public void setEspFid(String espFid) {
        this.espFid = espFid;
    }   
    
    
    public Double getCtaInv() {
        return ctaInv;
    }

    public void setCtaInv(Double ctaInv) {
        this.ctaInv = ctaInv;
    }
    
    public Integer getNombreUsuarioIdCreacion() {
        return nombreUsuarioIdCreacion;
    }

    public void setNombreUsuarioIdCreacion(Integer nombreUsuarioIdCreacion) {
        this.nombreUsuarioIdCreacion = nombreUsuarioIdCreacion;
    }   
    
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public Integer getNombreUsuarioIdModificacion() {
        return nombreUsuarioIdModificacion;
    }

    public void setNombreUsuarioIdModificacion(Integer nombreUsuarioIdModificacion) {
        this.nombreUsuarioIdModificacion = nombreUsuarioIdModificacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

  
    
    public Vector getContenido() {
        Vector v = new Vector();

        v.add(entidadDeNegociosID);
        v.add(claseAcciones);
        v.add(conOfeVen);
        v.add(textoUno);
        v.add(textoDos);
        v.add(existePreacuerdo);
        v.add(codScb);
        v.add(nombreSCB);
        v.add(representanteLegal);
        v.add(nombreRazonSocial);
        v.add(numAcciones);
        v.add(venCon);
        v.add(tipDocumento);
        v.add(numNitDoc);
        v.add(numVer);
        v.add(espFid);
        v.add(ctaInv);
        v.add(nombreUsuarioIdCreacion);
        v.add(fechaCreacion);
        v.add(nombreUsuarioIdModificacion);
        v.add(fechaModificacion);


    return v;
  }

  public void inicializar() {
    setPersistente(this);
    String atributos[] = {"EntidadDeNegociosID", "ClaseAcciones", "ConOfeVen",
                          "TextoUno", "TextoDos", "ExistePreacuerdo", "CodScb",
                          "NombreSCB", "RepresentanteLegal", "NombreRazonSocial",
                          "NumAcciones", "VenCon", "TipDocumento", "NumNitDoc",
                          "NumVer", "EspFid", "CtaInv", "NombreUsuarioIdCreacion",
                          "FechaCreacion", "NombreUsuarioIdModificacion",
                          "FechaModificacion",};

    setAtributos(atributos);
    setNombreTabla("fqs_CrearAceptacion");
    setElementosLLave(1);
  }

  //** nuevo parametros Vector con atributos de GrupoMoneda
  public Persistente nuevo(Vector v) {
    return new Aceptaciones((Integer) v.elementAt(0), (String) v.elementAt(1),
  (String) v.elementAt(2), (String) v.elementAt(3),
  (String) v.elementAt(4), (Boolean) v.elementAt(5),
  (Double) v.elementAt(6), (String) v.elementAt(7),
  (String) v.elementAt(8), (String) v.elementAt(9),
  (Double) v.elementAt(10), (Boolean) v.elementAt(11),
  (Integer) v.elementAt(12), (String) v.elementAt(13),
  (Double) v.elementAt(14), (String) v.elementAt(15),
  (Double) v.elementAt(16), (Integer) v.elementAt(17),
  (Timestamp) v.elementAt(18), (Integer) v.elementAt(19),
  (Timestamp) v.elementAt(20));
  }

  public void setContenido() throws SQLException {
      
    setEntidadDeNegociosID(new Integer(rs.getInt("EntidadDeNegociosID")));
    setClaseAcciones((rs.getString("ClaseAcciones")));
    setConOfeVen(rs.getString("ConOfeVen"));
    setTextoUno((rs.getString("TextoUno")));
    setTextoDos((rs.getString("TextoDos")));
    setExistePreacuerdo(new Boolean(rs.getBoolean("ExistePreacuerdo")));
    setCodScb(new Double(rs.getDouble("CodScb")));
    setNombreSCB((rs.getString("NombreSCB")));
    setRepresentanteLegal((rs.getString("RepresentanteLegal")));
    setNombreRazonSocial((rs.getString("NombreRazonSocial")));
    setNumAcciones(new Double(rs.getDouble("NumAcciones")));
    setVenCon(new Boolean(rs.getBoolean("VenCon")));
    setTipDocumento(new Integer(rs.getInt("TipDocumento")));
    setNumNitDoc((rs.getString("NumNitDoc")));
    setNumVer(new Double(rs.getDouble("NumVer")));
    setEspFid((rs.getString("EspFid")));
    setCtaInv(new Double(rs.getDouble("CtaInv")));
    setNombreUsuarioIdCreacion(new Integer(rs.getInt("FechaCreacion")));
    setFechaCreacion(rs.getTimestamp("dt_fecharadicacion"));
    setNombreUsuarioIdModificacion(new Integer(rs.getInt("NombreUsuarioIdModificacion")));
    setFechaModificacion(rs.getTimestamp("FechaModificacion"));

  }

  public void setContenido(Vector v) {

      String auxS;
      Integer auxI;
      Date auxD;
      Timestamp auxT;
      Double auxDb;
      Float auxF;
      Double cant;
      Boolean auxBoo;


      auxS = v.elementAt(0).toString();
      auxI = new Integer(auxS);
      if (auxI != null) {
          this.setEntidadDeNegociosID(auxI);
      } else {
          this.setEntidadDeNegociosID(new Integer(0));
      }
      
      setClaseAcciones((String) v.elementAt(1));
      
      setConOfeVen((String) v.elementAt(2));
      
      setTextoUno((String) v.elementAt(3));
      
      setTextoDos((String) v.elementAt(4));
      
      
      auxS = v.elementAt(5).toString();
      auxBoo = new Boolean(auxS);
      if (auxBoo != null) {
          this.setExistePreacuerdo(auxBoo);
      } else {
          this.setExistePreacuerdo(new Boolean(true));
      }
           
      
      auxS = v.elementAt(6).toString();
      auxDb = new Double(auxS);
      if (auxDb != null) {
          this.setCodScb(auxDb);
      } else {
          this.setCodScb(new Double(0));
      }

    setNombreSCB((String) v.elementAt(7));
    
    setRepresentanteLegal((String) v.elementAt(8));
    
    setNombreRazonSocial((String) v.elementAt(9));
    
      auxS = v.elementAt(10).toString();
      auxDb = new Double(auxS);
      if (auxDb != null) {
          this.setNumAcciones(auxDb);
      } else {
          this.setNumAcciones(new Double(0));
      }
      
      
       auxS = v.elementAt(11).toString();
      auxBoo = new Boolean(auxS);
      if (auxBoo != null) {
          this.setVenCon(auxBoo);
      } else {
          this.setVenCon(new Boolean(true));
      }
      
      
      auxS = v.elementAt(12).toString();
      auxI = new Integer(auxS);
      if (auxI != null) {
          this.setTipDocumento(auxI);
      } else {
          this.setTipDocumento(new Integer(0));
      }
      
      setNumNitDoc((String) v.elementAt(13));
      

      auxS = v.elementAt(14).toString();
      auxDb = new Double(auxS);
      if (auxDb != null) {
          this.setNumVer(auxDb);
      } else {
          this.setNumVer(new Double(0));
      }
      
      setEspFid((String) v.elementAt(15));
      
      
      auxS = v.elementAt(16).toString();
      auxDb = new Double(auxS);
      if (auxDb != null) {
          this.setCtaInv(auxDb);
      } else {
          this.setCtaInv(new Double(0));
      }
      
      auxS = v.elementAt(17).toString();
      auxI = new Integer(auxS);
      if (auxI != null) {
          this.setNombreUsuarioIdCreacion(auxI);
      } else {
          this.setNombreUsuarioIdCreacion(new Integer(0));
      }
      
      
      auxS = v.elementAt(18).toString();
      auxT = Timestamp.valueOf(auxS);
      if (auxT != null) {
          this.setFechaCreacion(auxT);
      } else {
          this.setFechaCreacion(new java.sql.Timestamp(System.currentTimeMillis()));
      }

      auxS = v.elementAt(19).toString();
      auxI = new Integer(auxS);
      if (auxI != null) {
          this.setNombreUsuarioIdModificacion(auxI);
      } else {
          this.setNombreUsuarioIdModificacion(new Integer(0));
      }
      
      
      auxS = v.elementAt(20).toString();
      auxT = Timestamp.valueOf(auxS);
      if (auxT != null) {
          this.setFechaModificacion(auxT);
      } else {
          this.setFechaModificacion(new java.sql.Timestamp(System.currentTimeMillis()));
      }

      
  }

  public boolean referencia(Vector v) {
    return true;
  }

 
  
  
  
}

