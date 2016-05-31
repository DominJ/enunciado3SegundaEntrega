package clasesPrivadas.Dominio.Clases;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clasesCompartidas.Pair;

public class VistaBH1 {
	private CtrlPresentacion iCtrlPresentacion;
	private Frame frameVistaBH1 = new Frame("Resultados");	
	private Panel panelBH = new Panel();
	private DefaultTableModel model = new DefaultTableModel(); 
	private JTable table = new JTable(model); 


	public void activar(ArrayList<Pair<Double,String>> aux) {
		inicializarComponentes(); 
		model.addRow(new Object[]{"Ranking","Nodo","Relevancia"});
		for(int i = 0; i < aux.size(); i++){
			Pair<Double,String> aux1 = aux.get(i);
			Double aux2 = aux1.getFirst();
			String aux3 = aux1.getSecond();
			model.addRow(new Object[]{i+1, aux3,aux2});
		}
	    frameVistaBH1.add(table);
	    frameVistaBH1.setEnabled(true);
		hacerVisible();
	}
	
	  public void desactivar() {
		  if (model.getRowCount() > 0) {
			    for (int i = model.getRowCount() - 1; i > -1; i--) {
			        model.removeRow(i);
			    }
			}
		  table.removeAll();
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
			    model.addColumn("Ranking"); 
				model.addColumn("Nodo"); 
				model.addColumn("Relevancia"); 
			   // inicializarComponentes();
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
			        	 iCtrlPresentacion.sincronizacionBH1_a_Principal();
			         }        
			      });
		    }

}
