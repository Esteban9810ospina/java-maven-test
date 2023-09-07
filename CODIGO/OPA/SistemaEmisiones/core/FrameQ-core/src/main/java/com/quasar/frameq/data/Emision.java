package com.quasar.frameq.data;

/**
 *
 * @author jam
 */
import com.quasar.frameq.db.Persistente;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emision extends Persistente {

    private Integer emision;
    private String nemo;
    private String nombre;
    private Double montototal;
    private Integer tipoaccion;
    private Double valoraccion;
    private String anulacionparcial;
    private String emisor;
    private String depositovalores;
    private String centralprocesos;
    private String entidadadjudicadora;
    private String deposito;
    private String fiduciaria;
    private Integer tipomercado;
    private Integer moneda;
    private String montototalfijo;
    private Integer accionesofrecidas;
    private Integer accionesdemandadas;
    private Double valorbasesuscripcion;
    private Double porcentajecuotainicial;
    private Double valorpatrimonial;
    private String dividendos;
    private Date fechaexdividendo;
    private Date fechainicial;
    private Date fechafinal;

    public Emision() {

        this.setEmision(new Integer(0));
        this.setNemo(new String(""));
        this.setNombre(new String(""));
        this.setMontototal(new Double(0.0));
        this.setTipoaccion(new Integer(0));
        this.setValoraccion(new Double(0.0));
        this.setAnulacionparcial(new String(""));
        this.setEmisor(new String(""));
        this.setDepositovalores(new String(""));
        this.setCentralprocesos(new String(""));
        this.setEntidadadjudicadora(new String(""));
        this.setDeposito(new String(""));
        this.setFiduciaria(new String(""));
        this.setTipomercado(new Integer(0));
        this.setMoneda(new Integer(0));
        this.setMontototalfijo(new String(""));
        this.setAccionesofrecidas(new Integer(0));
        this.setAccionesdemandadas(new Integer(0));
        this.setValorbasesuscripcion(new Double(0.0));
        this.setPorcentajecuotainicial(new Double(0.0));
        this.setValorpatrimonial(new Double(0.0));
        this.setDividendos(new String(""));
        this.setFechaexdividendo(Date.valueOf("2001-01-01"));
        this.setFechainicial(Date.valueOf("2001-01-01"));
        this.setFechafinal(Date.valueOf("2001-01-01"));
    }

    public Emision(Integer emision, String nemo, String nombre, Double montototal, Integer tipoaccion, Double valoraccion, String anulacionparcial, String emisor, String depositovalores, String centralprocesos, String entidadadjudicadora, String deposito, String fiduciaria, Integer tipomercado, Integer moneda, String montototalfijo, Integer accionesofrecidas, Integer accionesdemandadas, Double valorbasesuscripcion, Double porcentajecuotainicial, Double valorpatrimonial, String dividendos, Date fechaexdividendo, Date fechainicial, Date fechafinal) {
        this.setEmision(emision);
        this.setNemo(nemo);
        this.setNombre(nombre);
        this.setMontototal(montototal);
        this.setTipoaccion(tipoaccion);
        this.setValoraccion(valoraccion);
        this.setAnulacionparcial(anulacionparcial);
        this.setEmisor(emisor);
        this.setDepositovalores(depositovalores);
        this.setCentralprocesos(centralprocesos);
        this.setEntidadadjudicadora(entidadadjudicadora);
        this.setDeposito(deposito);
        this.setFiduciaria(fiduciaria);
        this.setTipomercado(tipomercado);
        this.setMoneda(moneda);
        this.setMontototalfijo(montototalfijo);
        this.setAccionesofrecidas(accionesofrecidas);
        this.setAccionesdemandadas(accionesdemandadas);
        this.setValorbasesuscripcion(valorbasesuscripcion);
        this.setPorcentajecuotainicial(porcentajecuotainicial);
        this.setValorpatrimonial(valorpatrimonial);
        this.setDividendos(dividendos);
        this.setFechaexdividendo(fechaexdividendo);
        this.setFechainicial(fechainicial);
        this.setFechafinal(fechafinal);
    }

    public void setEmision(Integer emision) {
        this.emision = emision;
    }

    public void setNemo(String nemo) {
        this.nemo = nemo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMontototal(Double montototal) {
        this.montototal = montototal;
    }

    public void setTipoaccion(Integer tipoaccion) {
        this.tipoaccion = tipoaccion;
    }

    public void setValoraccion(Double valoraccion) {
        this.valoraccion = valoraccion;
    }

    public void setAnulacionparcial(String anulacionparcial) {
        this.anulacionparcial = anulacionparcial;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public void setDepositovalores(String depositovalores) {
        this.depositovalores = depositovalores;
    }

    public void setCentralprocesos(String centralprocesos) {
        this.centralprocesos = centralprocesos;
    }

    public void setEntidadadjudicadora(String entidadadjudicadora) {
        this.entidadadjudicadora = entidadadjudicadora;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public void setFiduciaria(String fiduciaria) {
        this.fiduciaria = fiduciaria;
    }

    public void setTipomercado(Integer tipomercado) {
        this.tipomercado = tipomercado;
    }

    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    public void setMontototalfijo(String montototalfijo) {
        this.montototalfijo = montototalfijo;
    }

    public void setAccionesofrecidas(Integer accionesofrecidas) {
        this.accionesofrecidas = accionesofrecidas;
    }

    public void setAccionesdemandadas(Integer accionesdemandadas) {
        this.accionesdemandadas = accionesdemandadas;
    }

    public void setValorbasesuscripcion(Double valorbasesuscripcion) {
        this.valorbasesuscripcion = valorbasesuscripcion;
    }

    public void setPorcentajecuotainicial(Double porcentajecuotainicial) {
        this.porcentajecuotainicial = porcentajecuotainicial;
    }

    public void setValorpatrimonial(Double valorpatrimonial) {
        this.valorpatrimonial = valorpatrimonial;
    }

    public void setDividendos(String dividendos) {
        this.dividendos = dividendos;
    }

    public void setFechaexdividendo(Date fechaexdividendo) {
        this.fechaexdividendo = fechaexdividendo;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Integer getEmision() {
        return emision;
    }

    public String getNemo() {
        return nemo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getMontototal() {
        return montototal;
    }

    public Integer getTipoaccion() {
        return tipoaccion;
    }

    public Double getValoraccion() {
        return valoraccion;
    }

    public String getAnulacionparcial() {
        return anulacionparcial;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getDepositovalores() {
        return depositovalores;
    }

    public String getCentralprocesos() {
        return centralprocesos;
    }

    public String getEntidadadjudicadora() {
        return entidadadjudicadora;
    }

    public String getDeposito() {
        return deposito;
    }

    public String getFiduciaria() {
        return fiduciaria;
    }

    public Integer getTipomercado() {
        return tipomercado;
    }

    public Integer getMoneda() {
        return moneda;
    }

    public String getMontototalfijo() {
        return montototalfijo;
    }

    public Integer getAccionesofrecidas() {
        return accionesofrecidas;
    }

    public Integer getAccionesdemandadas() {
        return accionesdemandadas;
    }

    public Double getValorbasesuscripcion() {
        return valorbasesuscripcion;
    }

    public Double getPorcentajecuotainicial() {
        return porcentajecuotainicial;
    }

    public Double getValorpatrimonial() {
        return valorpatrimonial;
    }

    public String getDividendos() {
        return dividendos;
    }

    public Date getFechaexdividendo() {
        return fechaexdividendo;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public Vector getContenido() {
        Vector v = new Vector();
        v.add(emision);
        v.add(nemo);
        v.add(nombre);
        v.add(montototal);
        v.add(tipoaccion);
        v.add(valoraccion);
        v.add(anulacionparcial);
        v.add(emisor);
        v.add(depositovalores);
        v.add(centralprocesos);
        v.add(entidadadjudicadora);
        v.add(deposito);
        v.add(fiduciaria);
        v.add(tipomercado);
        v.add(moneda);
        v.add(montototalfijo);
        v.add(accionesofrecidas);
        v.add(accionesdemandadas);
        v.add(valorbasesuscripcion);
        v.add(porcentajecuotainicial);
        v.add(valorpatrimonial);
        v.add(dividendos);
        v.add(fechaexdividendo);
        v.add(fechainicial);
        v.add(fechafinal);
        return v;
    }

    public void inicializar() {
        setPersistente(this);
        String atributos[] = {"i_emision", "c_nemo", "c_nombre", "e_montototal", "i_tipoaccion", "e_valoraccion", "c_anulacionparcial", "c_emisor", "c_depositovalores", "c_centralprocesos", "c_entidadadjudicadora", "c_deposito", "c_fiduciaria", "i_tipomercado", "i_moneda", "c_montototalfijo", "i_accionesofrecidas", "i_accionesdemandadas", "e_valorbasesuscripcion", "e_porcentajecuotainicial", "e_valorpatrimonial", "c_dividendos", "d_fechaexdividendo", "d_fechainicial", "d_fechafinal"};
        int precision[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("sep_emision");
        setElementosLLave(1);
    }

    public Persistente nuevo(Vector v) {
        return new Emision((Integer) v.elementAt(0), (String) v.elementAt(1), (String) v.elementAt(2), (Double) v.elementAt(3), (Integer) v.elementAt(4), (Double) v.elementAt(5), (String) v.elementAt(6), (String) v.elementAt(7), (String) v.elementAt(8), (String) v.elementAt(9), (String) v.elementAt(10), (String) v.elementAt(11), (String) v.elementAt(12), (Integer) v.elementAt(13), (Integer) v.elementAt(14), (String) v.elementAt(15), (Integer) v.elementAt(16), (Integer) v.elementAt(17), (Double) v.elementAt(18), (Double) v.elementAt(19), (Double) v.elementAt(20), (String) v.elementAt(21), (Date) v.elementAt(22), (Date) v.elementAt(23), (Date) v.elementAt(24));
    }

    public void setContenido() throws SQLException {
        this.setEmision(new Integer(rs.getInt("i_emision")));
        this.setNemo((rs.getString("c_nemo")));
        this.setNombre((rs.getString("c_nombre")));
        this.setMontototal(new Double(rs.getDouble("e_montototal")));
        this.setTipoaccion(new Integer(rs.getInt("i_tipoaccion")));
        this.setValoraccion(new Double(rs.getDouble("e_valoraccion")));
        this.setAnulacionparcial((rs.getString("c_anulacionparcial")));
        this.setEmisor((rs.getString("c_emisor")));
        this.setDepositovalores((rs.getString("c_depositovalores")));
        this.setCentralprocesos((rs.getString("c_centralprocesos")));
        this.setEntidadadjudicadora((rs.getString("c_entidadadjudicadora")));
        this.setDeposito((rs.getString("c_deposito")));
        this.setFiduciaria((rs.getString("c_fiduciaria")));
        this.setTipomercado(new Integer(rs.getInt("i_tipomercado")));
        this.setMoneda(new Integer(rs.getInt("i_moneda")));
        this.setMontototalfijo((rs.getString("c_montototalfijo")));
        this.setAccionesofrecidas(new Integer(rs.getInt("i_accionesofrecidas")));
        this.setAccionesdemandadas(new Integer(rs.getInt("i_accionesdemandadas")));
        this.setValorbasesuscripcion(new Double(rs.getDouble("e_valorbasesuscripcion")));
        this.setPorcentajecuotainicial(new Double(rs.getDouble("e_porcentajecuotainicial")));
        this.setValorpatrimonial(new Double(rs.getDouble("e_valorpatrimonial")));
        this.setDividendos((rs.getString("c_dividendos")));
        this.setFechaexdividendo(rs.getDate("d_fechaexdividendo"));
        this.setFechainicial(rs.getDate("d_fechainicial"));
        this.setFechafinal(rs.getDate("d_fechafinal"));
    }

    public void setContenido(Vector v) {
        String auxS;
        Integer auxI;
        Date auxD;
        Timestamp auxT;
        Double auxDb;
        Float auxF;
        auxS = v.elementAt(0).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setEmision(auxI);
        } else {
            this.setEmision(new Integer(0));
        }

        this.setNemo((String) v.elementAt(1));

        this.setNombre((String) v.elementAt(2));

        auxS = v.elementAt(3).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setMontototal(auxDb);
        } else {
            this.setMontototal(new Double(0.0));
        }

        auxS = v.elementAt(4).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setTipoaccion(auxI);
        } else {
            this.setTipoaccion(new Integer(0));
        }

        auxS = v.elementAt(5).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setValoraccion(auxDb);
        } else {
            this.setValoraccion(new Double(0.0));
        }

        this.setAnulacionparcial((String) v.elementAt(6));

        this.setEmisor((String) v.elementAt(7));

        this.setDepositovalores((String) v.elementAt(8));

        this.setCentralprocesos((String) v.elementAt(9));

        this.setEntidadadjudicadora((String) v.elementAt(10));

        this.setDeposito((String) v.elementAt(11));

        this.setFiduciaria((String) v.elementAt(12));

        auxS = v.elementAt(13).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setTipomercado(auxI);
        } else {
            this.setTipomercado(new Integer(0));
        }

        auxS = v.elementAt(14).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setMoneda(auxI);
        } else {
            this.setMoneda(new Integer(0));
        }

        this.setMontototalfijo((String) v.elementAt(15));

        auxS = v.elementAt(16).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setAccionesofrecidas(auxI);
        } else {
            this.setAccionesofrecidas(new Integer(0));
        }

        auxS = v.elementAt(17).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setAccionesdemandadas(auxI);
        } else {
            this.setAccionesdemandadas(new Integer(0));
        }

        auxS = v.elementAt(18).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setValorbasesuscripcion(auxDb);
        } else {
            this.setValorbasesuscripcion(new Double(0.0));
        }

        auxS = v.elementAt(19).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setPorcentajecuotainicial(auxDb);
        } else {
            this.setPorcentajecuotainicial(new Double(0.0));
        }

        auxS = v.elementAt(20).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.setValorpatrimonial(auxDb);
        } else {
            this.setValorpatrimonial(new Double(0.0));
        }

        this.setDividendos((String) v.elementAt(21));

        auxS = v.elementAt(22).toString();
        auxD = Date.valueOf(auxS);
        if (auxD != null) {
            this.setFechaexdividendo(auxD);
        } else {
            this.setFechaexdividendo(Date.valueOf(""));
        }

        auxS = v.elementAt(23).toString();
        auxD = Date.valueOf(auxS);
        if (auxD != null) {
            this.setFechainicial(auxD);
        } else {
            this.setFechainicial(Date.valueOf(""));
        }

        auxS = v.elementAt(24).toString();
        auxD = Date.valueOf(auxS);
        if (auxD != null) {
            this.setFechafinal(auxD);
        } else {
            this.setFechafinal(Date.valueOf(""));
        }

    }

    public boolean referencia(Vector v) {
        return true;
    }

    public static void main(String[] args) {
        try {
            Emision prueba = new Emision(new Integer(99), new String("Datos prueba campo 1"), new String("Datos prueba campo 2"), new Double(1.1 * 3), new Integer(1), new Double(1.1 * 5), new String("Datos prueba campo 6"), new String("Datos prueba campo 7"), new String("Datos prueba campo 8"), new String("Datos prueba campo 9"), new String("Datos prueba campo 10"), new String("Datos prueba campo 11"), new String("Datos prueba campo 12"), new Integer(1), new Integer(1), new String("Datos prueba campo 15"), new Integer(1), new Integer(1), new Double(1.1 * 18), new Double(1.1 * 19), new Double(1.1 * 20), new String("Datos prueba campo 21"), Date.valueOf("2001-01-01"), Date.valueOf("2001-01-01"), Date.valueOf("2001-01-01"));
            prueba.insertar();
            prueba.consultaG("select i_emision, c_nemo, c_nombre, e_montototal, i_tipoaccion, e_valoraccion, "
                    + "c_anulacionparcial, c_emisor, c_depositovalores, c_centralprocesos, c_entidadadjudicadora, "
                    + "c_deposito, c_fiduciaria, i_tipomercado, i_moneda, c_montototalfijo, i_accionesofrecidas, "
                    + "i_accionesdemandadas, e_valorbasesuscripcion, e_porcentajecuotainicial, e_valorpatrimonial, "
                    + "c_dividendos, d_fechaexdividendo, d_fechainicial, d_fechafinal from sep_emision where i_emision='1'");
            prueba.first();
            prueba.setContenido();
            //por favor modifique los datos para actualizar
            prueba.actualizar();
            prueba.consultaG("select i_emision, c_nemo, c_nombre, e_montototal, i_tipoaccion, e_valoraccion, "
                    + "c_anulacionparcial, c_emisor, c_depositovalores, c_centralprocesos, c_entidadadjudicadora, "
                    + "c_deposito, c_fiduciaria, i_tipomercado, i_moneda, c_montototalfijo, i_accionesofrecidas, "
                    + "i_accionesdemandadas, e_valorbasesuscripcion, e_porcentajecuotainicial, e_valorpatrimonial, "
                    + "c_dividendos, d_fechaexdividendo, d_fechainicial, d_fechafinal from sep_emision ");
            while (prueba.next()) {
                prueba.setContenido();
                //por favor modifique los datos para imprimir
            }
        } catch (Exception Ex) {
            Logger.getLogger(Emision.class.getName()).log(Level.SEVERE, null, Ex);
        }
    }
}
