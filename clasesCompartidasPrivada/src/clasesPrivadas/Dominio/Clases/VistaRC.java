package clasesPrivadas.Dominio.Clases;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaRC {
	
	
    private JPanel panelRC = new JPanel();
	private JFrame frameVistaRC = new JFrame("Anadir");	
	private CtrlPresentacion iCtrlPresentacion;
	private JButton buttonCP = new JButton("Camino Predeterminado");
	private JButton buttonCCN = new JButton("Crear Camino Nuevo");

	

	public void activar() {
	    frameVistaRC.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaRC.setEnabled(false);
	    hacerInvisible();
	  }
		  public void hacerVisible() {
		    frameVistaRC.pack();
		    frameVistaRC.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaRC.setVisible(false);
		  }
		  
	
	public VistaRC(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	}
	
	void inicializarComponentes() {
		frameVistaRC.setMinimumSize(new Dimension(330,100));
		frameVistaRC.setResizable(true);
		frameVistaRC.setLocationRelativeTo(null);
		frameVistaRC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaRC.getContentPane();
	    contentPaneAnadir.add(panelRC);
	    
	    frameVistaRC.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 iCtrlPresentacion.sincronizacionRC_a_VistaPrincipal();
	         }        
	      });  
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
	    frameVistaRC.setLayout(layout);
	    panelRC.setLayout(new FlowLayout());
		
	    frameVistaRC.setVisible(true);
	    panelRC.setVisible(true);
	    
	    panelRC.add(buttonCP);
	    panelRC.add(buttonCCN);
	    asignar_listenersComponentes2();
	}
	
	private void asignar_listenersComponentes2() {
		  buttonCP.addActionListener
		      (new ActionListener() {
		        public void actionPerformed (ActionEvent event) {
		          String texto = ((JButton) event.getSource()).getText();
		          System.out.println("Has clickado el boton con texto: " + texto);
		          actionPerformed_buttonCP(event);
		        }
		      });
		  buttonCCN.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonCCN(event);
	        }
	      });
		}
	
	public void actionPerformed_buttonCP (ActionEvent event) {
		iCtrlPresentacion.sincronizacionRC_a_CP();
	}
	
	public void actionPerformed_buttonCCN (ActionEvent event) {
		iCtrlPresentacion.sincronizacionRC_a_CCN();

	}
	
}
