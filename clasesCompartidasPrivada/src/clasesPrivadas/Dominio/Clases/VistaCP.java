package clasesPrivadas.Dominio.Clases;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VistaCP {
	private Panel panelCP = new Panel();
	private Frame frameVistaCP = new Frame("Camino Predeterminado");	
	private CtrlPresentacion iCtrlPresentacion;
	private Label headerLabel;
	private Label statusLabel;
	private Button OKButton = new Button("Escoge");
    private Choice camino = new Choice();

	
	 void asignar_listenersComponentes2() {
		 OKButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {     
	            String data = "Camino Seleccionado: " 
	            + camino.getItem(camino.getSelectedIndex());
	            statusLabel.setText(data);
	        	 iCtrlPresentacion.sincronizacionCP_a_CP1(camino.getItem(camino.getSelectedIndex()));
	         }
	      }); 
	 }

	public void activar() {
	    frameVistaCP.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaCP.setEnabled(false);
	    hacerInvisible();
	  }
		  public void hacerVisible() {
		    frameVistaCP.pack();
		    frameVistaCP.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaCP.setVisible(false);
		  }
		  
	
	public VistaCP(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	}
	
	void inicializarComponentes() {
		frameVistaCP.setMinimumSize(new Dimension(400,400));
		frameVistaCP.setResizable(true);
		frameVistaCP.setLocationRelativeTo(null);
	    frameVistaCP.setLayout(new GridLayout(3, 1));
	    panelCP.setLayout(new FlowLayout());
		
	    frameVistaCP.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 iCtrlPresentacion.sincronizacionCP_a_RC();
	         }        
	      });    
	      headerLabel = new Label();
	      headerLabel.setAlignment(Label.CENTER);
	      statusLabel = new Label();        
	      statusLabel.setAlignment(Label.CENTER);
	      statusLabel.setSize(350,100);
	      
	      frameVistaCP.add(headerLabel);
	      frameVistaCP.add(panelCP);
	      frameVistaCP.add(statusLabel);
	      frameVistaCP.setVisible(true);

	      

	      headerLabel.setText("Selecciona el camino predeterminado:"); 


	      camino.add("PA");
	      camino.add("PC");
	      camino.add("PT");
	      camino.add("AP");
	      camino.add("CP");
	      camino.add("TP");

	
	      panelCP.add(camino);
	      panelCP.add(OKButton);


	    asignar_listenersComponentes2();
	}
}
