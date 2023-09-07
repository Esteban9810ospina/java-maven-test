package com.quasar.frameq.parametros;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;

public class CFestivo extends Persistente {


  private Parametro parametro = new Parametro();
  private Festivo festivo = new Festivo();

  public CFestivo() {
  }

  /*
   * public static void main(String[] args) { CFestivo CFestivo1 = new CFestivo(); }
   */
  public Persistente nuevo(Vector v) {
    return new CFestivo();
  }

  public void inicializar() {
    setPersistente(this);
    String atributos[] = {};
  }

  public Vector getContenido() {
    Vector v = new Vector();
    return v;
  }


    @Override
    public void setContenido(Vector v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setContenido() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
} // end of class CFestivo


