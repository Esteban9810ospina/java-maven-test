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
 * Fecha: 2016-03-24
 *
 * @author LSIERRA
 */
public class Adjudicacion extends Persistente {

    private Integer id_adjudicacion;
    private Integer id_aceptacion;
    private Integer acciones_adjudicadas;
    private Double precio;
    private Double monto;
    private String usuariosistemaultimamod;
    private String usuariobddatos;
    private Timestamp fechahoraultimamodificacion;
    private String tipomodificacion;

    public Adjudicacion() {

        id_adjudicacion = new Integer(0);
        id_aceptacion = new Integer(0);
        acciones_adjudicadas = new Integer(0);
        precio = new Double(0.0);
        monto = new Double(0.0);
        usuariosistemaultimamod = "";
        usuariobddatos = "";
        fechahoraultimamodificacion = (new Timestamp(System.currentTimeMillis()));
        tipomodificacion = "";

    }

    public Adjudicacion(Integer id_adjudicacion, Integer id_aceptacion, Integer acciones_adjudicadas,
            Double precio, Double monto, String usuariosistemaultimamod, String usuariobddatos, Timestamp fechahoraultimamodificacion, String tipomodificacion) {

        setId_adjudicacion(id_adjudicacion);
        setId_aceptacion(id_aceptacion);
        setAcciones_adjudicadas(acciones_adjudicadas);
        setPrecio(precio);
        setMonto(monto);
        setUsuariosistemaultimamod(usuariosistemaultimamod);
        setUsuariobddatos(usuariobddatos);
        setFechahoraultimamodificacion(fechahoraultimamodificacion);
        setTipomodificacion(tipomodificacion);

    }

    public Integer getId_adjudicacion() {
        return id_adjudicacion;
    }

    public void setId_adjudicacion(Integer id_adjudicacion) {
        this.id_adjudicacion = id_adjudicacion;
    }

    public Integer getId_aceptacion() {
        return id_aceptacion;
    }

    public void setId_aceptacion(Integer id_aceptacion) {
        this.id_aceptacion = id_aceptacion;
    }

    public Integer getAcciones_adjudicadas() {
        return acciones_adjudicadas;
    }

    public void setAcciones_adjudicadas(Integer acciones_adjudicadas) {
        this.acciones_adjudicadas = acciones_adjudicadas;
    }

    public Double getPreciob() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getUsuariosistemaultimamod() {
        return usuariosistemaultimamod;
    }

    public void setUsuariosistemaultimamod(String usuariosistemaultimamod) {
        this.usuariosistemaultimamod = usuariosistemaultimamod;
    }

    public String getUsuariobddatos() {
        return usuariobddatos;
    }

    public void setUsuariobddatos(String usuariobddatos) {
        this.usuariobddatos = usuariobddatos;
    }

    public Timestamp getFechahoraultimamodificacion() {
        return fechahoraultimamodificacion;
    }

    public void setFechahoraultimamodificacion(Timestamp fechahoraultimamodificacion) {
        this.fechahoraultimamodificacion = fechahoraultimamodificacion;
    }

    public String getTipomodificacion() {
        return tipomodificacion;
    }

    public void setTipomodificacion(String tipomodificacion) {
        this.tipomodificacion = tipomodificacion;
    }

    public Vector getContenido() {
        Vector v = new Vector();

        v.add(id_adjudicacion);
        v.add(id_aceptacion);
        v.add(acciones_adjudicadas);
        v.add(precio);
        v.add(monto);
        v.add(usuariosistemaultimamod);
        v.add(usuariobddatos);
        v.add(fechahoraultimamodificacion);
        v.add(tipomodificacion);

        return v;
    }

    public void inicializar() {
        setPersistente(this);
        String atributos[] = {"i_id_adjudicacion", "i_id_aceptacion", "i_acciones_adjudicadas",
            "d_precio", "d_monto", "c_usuario_sistema_ultima_mod", "c_usuario_bd_datos",
            "ts_fecha_hora_ultima_modificacion", "c_tipo_modificacion",};

        setAtributos(atributos);
        setNombreTabla("fqs_adjudicacion");
        setElementosLLave(1);
    }

    //** nuevo parametros Vector con atributos de GrupoMoneda
    public Persistente nuevo(Vector v) {
        return new Adjudicacion((Integer) v.elementAt(0), (Integer) v.elementAt(1),
                (Integer) v.elementAt(2), (Double) v.elementAt(3),
                (Double) v.elementAt(4), (String) v.elementAt(5),
                (String) v.elementAt(6), (Timestamp) v.elementAt(7),
                (String) v.elementAt(8));
    }

    public void setContenido() throws SQLException {

        setId_adjudicacion(new Integer(rs.getInt("i_id_adjudicacion")));
        setId_aceptacion(new Integer(rs.getInt("i_id_aceptacion")));
        setAcciones_adjudicadas(new Integer(rs.getInt("i_acciones_adjudicadas")));
        setPrecio(new Double(rs.getDouble("d_precio")));
        setMonto(new Double(rs.getDouble("d_monto")));
        setUsuariosistemaultimamod((rs.getString("c_usuario_sistema_ultima_mod")));
        setUsuariobddatos((rs.getString("c_usuario_bd_datos")));
        setFechahoraultimamodificacion(rs.getTimestamp("ts_fecha_hora_ultima_modificacion"));
        setTipomodificacion((rs.getString("c_tipo_modificacion")));

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
            this.setId_adjudicacion(auxI);
        } else {
            this.setId_adjudicacion(new Integer(0));
        }

        if (auxI != null) {
            this.setId_aceptacion(auxI);
        } else {
            this.setId_aceptacion(new Integer(0));
        }

        if (auxI != null) {
            this.setAcciones_adjudicadas(auxI);
        } else {
            this.setAcciones_adjudicadas(new Integer(0));
        }

        auxS = v.elementAt(3).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setPrecio(auxDb);
        } else {
            this.setPrecio(new Double(0));
        }

        auxS = v.elementAt(4).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMonto(auxDb);
        } else {
            this.setMonto(new Double(0));
        }

        setUsuariosistemaultimamod((String) v.elementAt(5));

        setUsuariobddatos((String) v.elementAt(6));

        auxS = v.elementAt(7).toString();
        auxT = Timestamp.valueOf(auxS);
        if (auxT != null) {
            this.setFechahoraultimamodificacion(auxT);
        } else {
            this.setFechahoraultimamodificacion(new java.sql.Timestamp(System.currentTimeMillis()));
        }

        setTipomodificacion((String) v.elementAt(8));

    }

    public boolean referencia(Vector v) {
        return true;
    }

}
