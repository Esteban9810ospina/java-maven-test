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

import com.quasar.frameq.db.Persistente;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

public class Fase extends Persistente {

	private Integer emision;
	private Integer idfase;
	private String nombre;
	private Integer estadofase;
	private Integer tipoadjudicacion;
	private Integer grupodestinatario;
	private Double montomaximo;
	private String observaciones;
	private Double accionesdemandadas;
	private Double accionesofrecidas;
	private Date fechainicial;
	private Date fechafinal;
	private Date fechacargainicial;
	private Date fechacargafinal;
	private Date fechaadinicial;
	private Date fechaadfinal;
	private Date fechaModInicial;
	private Date fechaModFinal;
	private Date fechaExcInicial;
	private Date fechaExcFinal;

	public Fase() {
		super();
		this.emision = 0;
		this.idfase = 0;
		this.nombre = "";
		this.estadofase = 0;
		this.tipoadjudicacion = 0;
		this.grupodestinatario = 0;
		this.montomaximo = 0d;
		this.observaciones = "";
		this.accionesdemandadas = 0d;
		this.accionesofrecidas = 0d;		
		this.fechainicial      = Date.valueOf("2001-01-01"); 		
		this.fechafinal        = Date.valueOf("2001-01-01"); 
		this.fechacargainicial = Date.valueOf("2001-01-01");
		this.fechacargafinal   = Date.valueOf("2001-01-01");
		this.fechaadinicial    = Date.valueOf("2001-01-01");
		this.fechaadfinal	   = Date.valueOf("2001-01-01");
	}

	public Fase(Integer emision, Integer idfase, String nombre, Integer estadofase, Integer tipoadjudicacion, Integer grupodestinatario, Double montomaximo, String observaciones,
			Double accionesdemandadas, Double accionesofrecidas, Date fechainicial, Date fechafinal, Date fechacargainicial, Date fechacargafinal, Date fechaModInicial, Date fechaModFinal, Date fechaExcInicial, Date fechaExcFinal, 
			Date fechaadinicial, Date fechaadfinal ) {
		setEmision(emision);
		setIdfase(idfase);
		setNombre(nombre);
		setEstadofase(estadofase);
		setTipoadjudicacion(tipoadjudicacion);
		setGrupodestinatario(grupodestinatario);
		setMontomaximo(montomaximo);
		setObservaciones(observaciones);
		setAccionesdemandadas(accionesdemandadas);
		setAccionesofrecidas(accionesofrecidas);
		setFechainicial(fechainicial);
		setFechafinal(fechafinal);
		setFechacargainicial(fechacargainicial);
		setFechacargafinal(fechacargafinal);
		setFechaadinicial(fechaadinicial);
		setFechaadfinal(fechaadfinal);
		setFechaModInicial(fechaModInicial);
		setFechaModFinal(fechaModFinal);
		setFechaExcInicial(fechaExcInicial);
		setFechaExcFinal(fechaExcFinal);
	}

	public void setEmision(Integer emision) {
		this.emision = emision;
	}

	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEstadofase(Integer estadofase) {
		this.estadofase = estadofase;
	}

	public void setTipoadjudicacion(Integer tipoadjudicacion) {
		this.tipoadjudicacion = tipoadjudicacion;
	}

	public void setGrupodestinatario(Integer grupodestinatario) {
		this.grupodestinatario = grupodestinatario;
	}

	public void setMontomaximo(Double montomaximo) {
		this.montomaximo = montomaximo;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setAccionesdemandadas(Double accionesdemandadas) {
		this.accionesdemandadas = accionesdemandadas;
	}

	public void setAccionesofrecidas(Double accionesofrecidas) {
		this.accionesofrecidas = accionesofrecidas;
	}

	public void setFechainicial(Date fechainicial) {
		this.fechainicial = fechainicial;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}

	public void setFechacargainicial(Date fechacargainicial) {
		this.fechacargainicial = fechacargainicial;
	}

	public void setFechacargafinal(Date fechacargafinal) {
		this.fechacargafinal = fechacargafinal;
	}

	public void setFechaadinicial(Date fechaadinicial) {
		this.fechaadinicial = fechaadinicial;
	}

	public void setFechaadfinal(Date fechaadfinal) {
		this.fechaadfinal = fechaadfinal;
	}

	public Integer getEmision() {
		return emision;
	}

	public Integer getIdfase() {
		return idfase;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEstadofase() {
		return estadofase;
	}

	public Integer getTipoadjudicacion() {
		return tipoadjudicacion;
	}

	public Integer getGrupodestinatario() {
		return grupodestinatario;
	}

	public Double getMontomaximo() {
		return montomaximo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public Double getAccionesdemandadas() {
		return accionesdemandadas;
	}

	public Double getAccionesofrecidas() {
		return accionesofrecidas;
	}

	public Date getFechainicial() {
		return fechainicial;
	}

	public Date getFechafinal() {
		return fechafinal;
	}

	public Date getFechacargainicial() {
		return fechacargainicial;
	}

	public Date getFechacargafinal() {
		return fechacargafinal;
	}

	public Date getFechaadinicial() {
		return fechaadinicial;
	}

	public Date getFechaadfinal() {
		return fechaadfinal;
	}

	public Date getFechaModInicial() {
		return fechaModInicial;
	}

	public void setFechaModInicial(Date fechaModInicial) {
		this.fechaModInicial = fechaModInicial;
	}

	public Date getFechaModFinal() {
		return fechaModFinal;
	}

	public void setFechaModFinal(Date fechaModFinal) {
		this.fechaModFinal = fechaModFinal;
	}

	public Date getFechaExcInicial() {
		return fechaExcInicial;
	}

	public void setFechaExcInicial(Date fechaExcInicial) {
		this.fechaExcInicial = fechaExcInicial;
	}

	public Date getFechaExcFinal() {
		return fechaExcFinal;
	}

	public void setFechaExcFinal(Date fechaExcFinal) {
		this.fechaExcFinal = fechaExcFinal;
	}

	public Vector getContenido() {
		Vector v = new Vector();
		v.add(emision);
		v.add(idfase);
		v.add(nombre);
		v.add(estadofase);
		v.add(tipoadjudicacion);
		v.add(grupodestinatario);
		v.add(montomaximo);
		v.add(observaciones);
		v.add(accionesdemandadas);
		v.add(accionesofrecidas);
		v.add(fechainicial);
		v.add(fechafinal);
		v.add(fechacargainicial);
		v.add(fechacargafinal);
		v.add(this.fechaModInicial);
		v.add(this.fechaModFinal);
		v.add(this.fechaExcInicial);
		v.add(this.fechaExcFinal);
		v.add(fechaadinicial);
		v.add(fechaadfinal);		
		return v;
	}

	public void inicializar() {
		setPersistente(this);
		String atributos[] = { "i_emision", "i_idfase", "c_nombre", "i_estadofase", "i_tipoadjudicacion", "i_grupodestinatario", "e_montomaximo", "c_observaciones", "i_accionesdemandadas",
				"i_accionesofrecidas", "d_fechainicial", "d_fechafinal", "d_fechacargainicial", "d_fechacargafinal", "d_fechamodinicial", "d_fechamodfinal","d_fechaexcinicial", "d_fechaexcfinal",
				"d_fechaadinicial", "d_fechaadfinal"};
		int precision[] = { 0, 0, 0, 0, 0, 0, 2, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		setPrecision(precision);
		setAtributos(atributos);
		setNombreTabla("dm_fase");
		setElementosLLave(2);
	}

	public Persistente nuevo(Vector v) {
		return new Fase((Integer) v.elementAt(0), (Integer) v.elementAt(1), (String) v.elementAt(2), (Integer) v.elementAt(3), (Integer) v.elementAt(4), (Integer) v.elementAt(5),
				(Double) v.elementAt(6), (String) v.elementAt(7), (Double) v.elementAt(8), (Double) v.elementAt(9), (Date) v.elementAt(10), (Date) v.elementAt(11), (Date) v.elementAt(12),
				(Date) v.elementAt(13), (Date) v.elementAt(14), (Date) v.elementAt(15), (Date) v.elementAt(16), (Date) v.elementAt(17), (Date) v.elementAt(18), (Date) v.elementAt(19));
	}

	public void setContenido() throws SQLException {
		setEmision(rs.getInt("i_emision"));
		setIdfase(rs.getInt("i_idfase"));
		setNombre(rs.getString("c_nombre"));
		setEstadofase(rs.getInt("i_estadofase"));
		setTipoadjudicacion(rs.getInt("i_tipoadjudicacion"));
		setGrupodestinatario(rs.getInt("i_grupodestinatario"));
		setMontomaximo(rs.getDouble("e_montomaximo"));
		setObservaciones(rs.getString("c_observaciones"));
		setAccionesdemandadas(rs.getDouble("i_accionesdemandadas"));
		setAccionesofrecidas(rs.getDouble("i_accionesofrecidas"));
		setFechainicial(rs.getDate("d_fechainicial"));
		setFechafinal(rs.getDate("d_fechafinal"));
		setFechacargainicial(rs.getDate("d_fechacargainicial"));
		setFechacargafinal(rs.getDate("d_fechacargafinal"));
		setFechaadinicial(rs.getDate("d_fechaadinicial"));
		setFechaadfinal(rs.getDate("d_fechaadfinal"));
		setFechaModInicial(rs.getDate("d_fechamodinicial"));
		setFechaModFinal(rs.getDate("d_fechamodfinal"));
		setFechaExcInicial(rs.getDate("d_fechaExcinicial"));
		setFechaExcFinal(rs.getDate("d_fechaexcfinal"));
	}

	public void setContenido(Vector v) {
		String auxS = v.elementAt(0).toString();
		Integer auxI = new Integer(auxS);
		if (auxI != null)
			setEmision(auxI);
		else
			setEmision(0);
		auxS = v.elementAt(1).toString();
		auxI = new Integer(auxS);
		if (auxI != null)
			setIdfase(auxI);
		else
			setIdfase(0);
		setNombre((String) v.elementAt(2));
		auxS = v.elementAt(3).toString();
		auxI = new Integer(auxS);
		if (auxI != null)
			setEstadofase(auxI);
		else
			setEstadofase(0);
		auxS = v.elementAt(4).toString();
		auxI = new Integer(auxS);
		if (auxI != null)
			setTipoadjudicacion(auxI);
		else
			setTipoadjudicacion(0);
		auxS = v.elementAt(5).toString();
		auxI = new Integer(auxS);
		if (auxI != null)
			setGrupodestinatario(auxI);
		else
			setGrupodestinatario(0);
		auxS = v.elementAt(6).toString();
		Double auxDb = new Double(auxS);
		if (auxDb != null)
			setMontomaximo(auxDb);
		else
			setMontomaximo(0d);
		setObservaciones((String) v.elementAt(7));
		auxS = v.elementAt(8).toString();
		auxDb = new Double(auxS);
		if (auxDb != null)
			setAccionesdemandadas(auxDb);
		else
			setAccionesdemandadas(0d);
		auxS = v.elementAt(9).toString();
		auxDb = new Double(auxS);
		if (auxDb != null)
			setAccionesofrecidas(auxDb);
		else
			setAccionesofrecidas(0d);
		auxS = v.elementAt(10).toString();
		Date auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechainicial(auxD);
		else
			setFechainicial(Date.valueOf(""));
		auxS = v.elementAt(11).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechafinal(auxD);
		else
			setFechafinal(Date.valueOf(""));
		auxS = v.elementAt(12).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechacargainicial(auxD);
		else
			setFechacargainicial(Date.valueOf(""));
		auxS = v.elementAt(13).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechacargafinal(auxD);
		else
			setFechacargafinal(Date.valueOf(""));
		
		//
		auxS = v.elementAt(14).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechaModInicial(auxD);
		else
			setFechaModInicial(Date.valueOf(""));
		//
		auxS = v.elementAt(15).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechaModFinal(auxD);
		else
			setFechaModFinal(Date.valueOf(""));
		//
		auxS = v.elementAt(16).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechaExcInicial(auxD);
		else
			setFechaExcInicial(Date.valueOf(""));
		//
		auxS = v.elementAt(17).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechaExcFinal(auxD);
		else
			setFechaExcFinal(Date.valueOf(""));
		
		auxS = v.elementAt(18).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechaadinicial(auxD);
		else
			setFechaadinicial(Date.valueOf(""));
		auxS = v.elementAt(19).toString();
		auxD = Date.valueOf(auxS);
		if (auxD != null)
			setFechaadfinal(auxD);
		else
			setFechaadfinal(Date.valueOf(""));
		
	}

	public boolean referencia(Vector v) {
		return true;
	}

}
