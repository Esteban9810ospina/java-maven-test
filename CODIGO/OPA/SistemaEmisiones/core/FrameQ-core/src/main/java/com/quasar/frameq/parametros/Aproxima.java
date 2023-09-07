package com.quasar.frameq.parametros;


import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;


 public class Aproxima extends Persistente
 {
 	private Double valor;

	public Aproxima() {
          setValor(new Double(0.0));
	}

	public final Double getValor()
	{
		return valor;
	}
	public void setValor(Double setValor)
	{
		valor = setValor;
	}


	public final void valor()
	{

	}

        public Aproxima(Double valor){
          setValor(valor);
        }

         public Vector getContenido() {
          Vector v=new Vector();
          v.add(valor);
          return v;
        }

         public void inicializar(){
          setPersistente(this);
          String atributos[]={"e_valor"};
          setAtributos(atributos);
          setNombreTabla("fqs_aproxima");
          setElementosLLave(0);
        }

 //** nuevo parametros Vector con atributos de Aproxima

        public Persistente nuevo (Vector v){
           return new Aproxima ((Double)v.elementAt(6));
        }
///**Main

  public static void main(String[] args){
    Aproxima aproxi=new Aproxima(new Double(3.444));
    aproxi.inicializar();
    aproxi.getContenido();
    aproxi.insertar();
    aproxi.consultar();
  }

   public void setContenido() throws SQLException {
          setValor(new Double(rs.getDouble("e_valor")));
    }

    @Override
    public void setContenido(Vector v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}