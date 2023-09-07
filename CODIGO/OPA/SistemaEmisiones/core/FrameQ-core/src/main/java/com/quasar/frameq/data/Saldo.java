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
import java.sql.SQLException;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Saldo extends Persistente {
    private static final Logger logger = Logger.getLogger(Saldo.class.getName());
    private Integer saldo;
    private Integer formapago; // 1: efectivo/cheque, 2: Débito automático, 3:
    // línea de crédito
    private Integer codigoEntidad;
    private String cuenta;
    private Integer tipocuenta;
    private Integer ofertante;
    private Double montoTotal;
    private Double tasainteres;
    private Integer fase;
    private Integer emision;
    private Integer tipopago;
    private Double numDocumento;
    private Double valorMontoAprobado;

    public Saldo() {
        this.saldo = new Integer(0);
        this.formapago = new Integer(0);
        this.codigoEntidad = new Integer(0);
        this.cuenta = new String("");
        this.tipocuenta = new Integer(0);
        this.ofertante = new Integer(0);
        this.montoTotal = new Double(0);
        this.tasainteres = new Double(0);
        this.fase = new Integer(0);
        this.emision = new Integer(0);
        this.tipopago = new Integer(0);
        this.numDocumento = new Double(0L);
        this.valorMontoAprobado = new Double(0);
    }

    public Saldo(Integer saldo, Integer formapago, Integer codigoEntidad, String cuenta, Integer tipocuenta, Integer ofertante, Double montoTotal, Double tasainteres, Integer fase, Integer emision,
            Integer tipopago, Double numDocumento, Double valorMontoAprobado) {
        this.setSaldo(saldo);
        this.setFormapago(formapago);
        this.setCodigoEntidad(codigoEntidad);
        this.setCuenta(cuenta);
        this.setTipocuenta(tipocuenta);
        this.setOfertante(ofertante);
        this.setMontoTotal(montoTotal);
        this.setTasainteres(tasainteres);
        this.setFase(fase);
        this.setEmision(emision);
        this.setTipopago(tipopago);
        this.setNumDocumento(numDocumento);
        this.setValorMontoAprobado(valorMontoAprobado, new Double(0));
    }

    public void setSaldo(String registro, int fase, int emision) {

        this.fase = new Integer(fase);
        this.emision = new Integer(emision);

		// Estado anterior: if (registro.substring(103, 104).trim().length() >
        // 0) {
        // this.formapago = Integer.valueOf(registro.substring(103,
        // 104).trim());
        if (registro.substring(107, 108).trim().length() > 0) {
            this.formapago = Integer.valueOf(registro.substring(107, 108).trim());
        } else {
            this.formapago = new Integer(0);
        }

		// Estado anterior: if (registro.substring(104, 107).trim().length() >
        // 0) // Este campo parece que no va
        // this.codigoEntidad = Integer.valueOf(registro.substring(104,
        // 107).trim());
        if (registro.substring(108, 112).trim().length() > 0) // Este campo
        // parece que no
        // va
        {
            this.codigoEntidad = Integer.valueOf(registro.substring(108, 112).trim());
        } else {
            this.codigoEntidad = new Integer(0);
        }

		// Estado inicial: if (registro.substring(107, 119).trim().length() > 0)
        // {// Este campo parece que no va
        // this.numDocumento = Double.valueOf(registro.substring(107,
        // 119).trim());
        if (registro.substring(112, 127).trim().length() > 0) {// Este campo
            // parece que no
            // va
            this.numDocumento = Double.valueOf(registro.substring(112, 127).trim());
        } else {
            this.numDocumento = new Double(0L);
        }

        if (this.getFormapago().intValue() == 2) { // Si es débito automático
            // estado inicial: if (registro.substring(120, 135).trim().length()
            // > 0)
            // this.cuenta = Double.valueOf(registro.substring(120, 135).trim());
            if (registro.substring(128, 148).trim().length() > 0) {
                this.cuenta = registro.substring(128, 148).trim();
            } else {
                this.cuenta = new String("");
            }

			// Estado anteriro: if (registro.substring(119, 120).trim().length()
            // > 0)
            // this.tipocuenta = Integer.valueOf(registro.substring(119,
            // 120).trim());
            if (registro.substring(127, 128).trim().length() > 0) {
                this.tipocuenta = Integer.valueOf(registro.substring(127, 128).trim());
            } else {
                this.tipocuenta = new Integer(0);
            }

            if ((registro.substring(230, 242).trim().length() > 0) && (this.getFormapago().equals("3"))) {
                this.valorMontoAprobado = Double.valueOf(registro.substring(230, 242).trim());
            } else {
                this.valorMontoAprobado = new Double(0);
            }

        } else {
			// Estado anterior: if (registro.substring(119, 120).trim().length()
            // > 0)
            // this.tipocuenta = Integer.valueOf(registro.substring(119,
            // 120).trim());
            if (registro.substring(127, 128).trim().length() > 0) {
                this.tipocuenta = Integer.valueOf(registro.substring(127, 128).trim());
            } else {
                this.tipocuenta = new Integer(0);
            }

			// Estado anterior: if (registro.substring(120, 135).trim().length()
            // > 0)
            // this.cuenta = Double.valueOf(registro.substring(120, 135).trim());
            if (registro.substring(128, 148).trim().length() > 0) {
                this.cuenta = registro.substring(128, 148).trim();
            } else {
                this.cuenta = new String("");
            }

            if ((registro.substring(230, 242).trim().length() > 0) && (this.getFormapago().intValue() == 3)) {
                this.valorMontoAprobado = Double.valueOf(registro.substring(230, 242).trim());
            } else {
                this.valorMontoAprobado = new Double(0);
            }
        }
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Error setValorMontoAprobado(Double montoAprovado, Double montoSolicitado) {
        Error error = new Error();
        if (formapago.intValue() == 3) {
            if (montoAprovado.doubleValue() <= 0) {
            } else {
                if (montoSolicitado.doubleValue() <= montoAprovado.doubleValue()) {
                    valorMontoAprobado = montoAprovado;
                }
            }
        } else {
            valorMontoAprobado = montoAprovado;
        }

        return error;
    }

    public Error setFormapago(Integer formapago) {
        Error error = new Error();

        if (formapago.intValue() == 1 || formapago.intValue() == 2 || formapago.intValue() == 3) {
            this.formapago = formapago;
        } 
        return error;
    }

    public void setCodigoEntidad(Integer codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Error setTipocuenta(Integer tipocuenta) {
        Error error = new Error();
        if (this.formapago.intValue() == 2) {
            if (tipocuenta.intValue() == 1 || tipocuenta.intValue() == 2) {
                this.tipocuenta = tipocuenta;
            } 
        } else {
            this.tipocuenta = tipocuenta;
        }
        return error;
    }

    public void setOfertante(Integer ofertante) {
        this.ofertante = ofertante;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setTasainteres(Double tasainteres) {
        this.tasainteres = tasainteres;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public void setEmision(Integer emision) {
        this.emision = emision;
    }

    public void setTipopago(Integer tipopago) {
        this.tipopago = tipopago;
    }

    public void setNumDocumento(Double numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public Integer getFormapago() {
        return formapago;
    }

    public Integer getCodigobanco() {
        return codigoEntidad;
    }

    public Double getoCreditoAprobado() {
        return this.valorMontoAprobado;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public Integer getTipocuenta() {
        return tipocuenta;
    }

    public Integer getOfertante() {
        return ofertante;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public Double getTasainteres() {
        return tasainteres;
    }

    public Integer getFase() {
        return fase;
    }

    public Integer getEmision() {
        return emision;
    }

    public Integer getTipopago() {
        return tipopago;
    }

    public Double getNumDocumento() {
        return numDocumento;
    }

    public Vector getContenido() {
        Vector v = new Vector();
        v.add(saldo);
        v.add(formapago);
        v.add(codigoEntidad);
        v.add(cuenta);
        v.add(tipocuenta);
        v.add(ofertante);
        v.add(montoTotal);
        v.add(tasainteres);
        v.add(fase);
        v.add(emision);
        v.add(tipopago);
        v.add(numDocumento);
        v.add(valorMontoAprobado);
        return v;
    }

    public void inicializar() {
        setPersistente(this);
        String atributos[] = {"i_saldo", "i_formapago", "i_codigoentidad", "i_cuenta", "i_tipocuenta", "i_ofertante", "e_montototal", "e_tasainteres", "i_fase", "i_emision", "i_tipopago",
            "i_numdocumento", "e_valormontoaprobado"};
        int precision[] = {0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0};
        this.setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("dm_saldo");
        setElementosLLave(1);
    }

    public Persistente nuevo(Vector v) {
        return new Saldo((Integer) v.elementAt(0), (Integer) v.elementAt(1), (Integer) v.elementAt(2), (String) v.elementAt(3), (Integer) v.elementAt(4), (Integer) v.elementAt(5),
                (Double) v.elementAt(6), (Double) v.elementAt(7), (Integer) v.elementAt(8), (Integer) v.elementAt(9), (Integer) v.elementAt(10), (Double) v.elementAt(11), (Double) v.elementAt(12));
    }

    public void setContenido() throws SQLException {
        this.setSaldo(new Integer(rs.getInt("i_saldo")));
        this.setFormapago(new Integer(rs.getInt("i_formapago")));
        this.setCodigoEntidad(new Integer(rs.getInt("i_codigoentidad")));
        this.setCuenta(rs.getString("i_cuenta"));
        this.setTipocuenta(new Integer(rs.getInt("i_tipocuenta")));
        this.setOfertante(new Integer(rs.getInt("i_ofertante")));
        this.setMontoTotal(new Double(rs.getDouble("e_montototal")));
        this.setTasainteres(new Double(rs.getDouble("e_tasainteres")));
        this.setFase(new Integer(rs.getInt("i_fase")));
        this.setEmision(new Integer(rs.getInt("i_emision")));
        this.setTipopago(new Integer(rs.getInt("i_tipopago")));
        this.setNumDocumento(new Double(rs.getDouble("i_numdocumento")));
        this.setValorMontoAprobado(new Double(rs.getDouble("e_valormontoaprobado")), new Double(0));
    }

    public void setContenido(Vector v) {
        String auxS;
        Integer auxI;
        Double auxDb;
        Double auxL;
        String auxL1;
        auxS = v.elementAt(0).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.setSaldo(auxI);
        } else {
            this.setSaldo(new Integer(0));
        }

        auxS = v.elementAt(1).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.formapago = auxI;
        } else {
            this.formapago = new Integer(0);
        }

        auxS = v.elementAt(2).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.codigoEntidad = auxI;
        } else {
            this.codigoEntidad = new Integer(0);
        }

        auxS = v.elementAt(3).toString();
        auxL1 = auxS;
        if (!auxL1.equals("")) {
            this.cuenta = auxL1;
        } else {
            this.cuenta = auxL1;
        }

        auxS = v.elementAt(4).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.tipocuenta = auxI;
        } else {
            this.tipocuenta = new Integer(0);
        }

        auxS = v.elementAt(5).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.ofertante = auxI;
        } else {
            this.ofertante = new Integer(0);
        }

        auxS = v.elementAt(6).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.montoTotal = auxDb;
        } else {
            this.montoTotal = new Double(0);
        }

        auxS = v.elementAt(7).toString();
        auxDb = new Double(auxS);
        if (auxDb != null) {
            this.tasainteres = auxDb;
        } else {
            this.tasainteres = new Double(0);
        }

        auxS = v.elementAt(8).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.fase = auxI;
        } else {
            this.fase = new Integer(0);
        }

        auxS = v.elementAt(9).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.emision = auxI;
        } else {
            this.emision = new Integer(0);
        }

        auxS = v.elementAt(10).toString();
        auxI = new Integer(auxS);
        if (auxI != null) {
            this.tipopago = auxI;
        } else {
            this.tipopago = new Integer(0);
        }

        auxS = v.elementAt(11).toString();
        auxL = new Double(auxS);
        if (auxL != null) {
            this.numDocumento = auxL;
        } else {
            this.numDocumento = new Double(0L);
        }

        auxS = v.elementAt(12).toString();
        auxDb = new Double(auxS);
        if (auxL != null) {
            this.valorMontoAprobado = auxDb;
        } else {
            this.valorMontoAprobado = new Double(0);
        }

    }

    public boolean referencia(Vector v) {
        return true;
    }

    public static void main(String[] args) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        try {
            Saldo prueba = new Saldo(new Integer(1), new Integer(1), new Integer(1), new String(""), new Integer(1), new Integer(1), new Double(1.1 * 6), new Double(1.1 * 7), new Integer(1),
                    new Integer(1), new Integer(1), new Double(0L), new Double(0));
            prueba.insertar();
            prueba.consultaG("select i_saldo, i_formapago, i_codigoentidad, i_cuenta, i_tipocuenta, i_ofertante, "
                    + "e_montototal, e_tasainteres, i_fase, i_emision, i_tipopago, i_numdocumento, e_valormontoaprobado "
                    + "from dm_saldo where i_saldo='1'");
            prueba.first();
            prueba.setContenido();
            // por favor modifique los datos para actualizar
            prueba.actualizar();
            prueba.consultaG("i_saldo, i_formapago, i_codigoentidad, i_cuenta, i_tipocuenta, i_ofertante, "
                    + "e_montototal, e_tasainteres, i_fase, i_emision, i_tipopago, i_numdocumento, e_valormontoaprobado "
                    + "from dm_saldo ");
            while (prueba.next()) {
                prueba.setContenido();
                // por favor modifique los datos para imprimir
            }
        } catch (Exception Ex) {
            logger.error("OPA - " + Saldo.class.getName(), Ex);
        }
    }
}
