package clasesPrivadas.Dominio.Clases;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


import clasesCompartidas.Pair;

public class VistaBH1 {
	private CtrlPresentacion iCtrlPresentacion;
	private Frame frameVistaBH1 = new Frame("Resultados");	
	private TextArea a = new TextArea();
	private Panel panelBH = new Panel();

	public void activar(ArrayList<Pair<Double,Integer>> aux) {
		a.setText("Ranking " + " Nodo " + " Relevancia ");
		for(int i = 0; i < aux.size(); i++){
			Pair<Double,Integer> aux1 = aux.get(i);
			Double aux2 = aux1.getFirst();
			Integer aux3 = aux1.getSecond();
			a.setText(i+ " " + aux2+" "+aux3 + "\n");
		}
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaBH1.setEnabled(false);
	    hacerInvisible();
	  }
		  public void hacerVisible() {
		    frameVistaBH1.pack();
		    frameVistaBH1.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaBH1.setVisible(false);
		  }
			public VistaBH1(CtrlPresentacion pCtrlPresentacion) {
			    iCtrlPresentacion = pCtrlPresentacion;
			    inicializarComponentes();
			}
		    public void inicializarComponentes() {
		    	frameVistaBH1.setSize(new Dimension(400,400));
				frameVistaBH1.setMinimumSize(new Dimension(700,200));
				frameVistaBH1.setResizable(true);
				frameVistaBH1.setLocationRelativeTo(null);
			    frameVistaBH1.setLayout(new GridLayout(3, 1));
			    panelBH.setLayout(new FlowLayout());
			    frameVistaBH1.addWindowListener(new WindowAdapter() {
			         public void windowClosing(WindowEvent windowEvent){
			        	 iCtrlPresentacion.sincronizacionBH1_a_BH();
			         }        
			      });  
			    frameVistaBH1.add(a);
		    }

}
