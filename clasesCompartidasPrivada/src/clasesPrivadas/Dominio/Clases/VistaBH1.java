package clasesPrivadas.Dominio.Clases;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


import clasesCompartidas.Pair;

public class VistaBH1 {
	private CtrlPresentacion iCtrlPresentacion;
	private Frame frameVistaBH11 = new Frame("Resultados");	
	private TextArea a = new TextArea();

	public void activar(ArrayList<Pair<Double,Integer>> aux) {
		a.setText("Ranking " + " Nodo " + " Relevancia ");
		for(int i = 0; i < aux.size(); i++){
			Pair aux1 = aux.get(i);
		}
		
		frameVistaBH11.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaBH11.setEnabled(false);
	    hacerInvisible();
	  }
		  public void hacerVisible() {
		    frameVistaBH11.pack();
		    frameVistaBH11.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaBH11.setVisible(false);
		  }
			public VistaBH1(CtrlPresentacion pCtrlPresentacion) {
			    iCtrlPresentacion = pCtrlPresentacion;
			    inicializarComponentes();
			}
		    public void inicializarComponentes() {
		    	frameVistaBH11.setSize(new Dimension(400,400));
			    frameVistaBH11.setLayout(new GridLayout(3, 1));
			    frameVistaBH11.addWindowListener(new WindowAdapter() {
			         public void windowClosing(WindowEvent windowEvent){
			        	 iCtrlPresentacion.sincronizacionBH1_a_BH();
			         }        
			      });    
		    }

}
