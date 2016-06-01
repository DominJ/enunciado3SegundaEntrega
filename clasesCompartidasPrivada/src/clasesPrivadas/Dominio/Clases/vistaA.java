package clasesPrivadas.Dominio.Clases;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import excepciones.NonExistObjectToReadException;

/**
 * @author Daniel Pulido
 *
 */

public class vistaA {
	  private CtrlPresentacion iCtrlPresentacion;
	  private JFrame frameVista1 = new JFrame("Abrir");
	  private JPanel panelContenidos1 = new JPanel();
	  private JButton buttonP = new JButton("Fichero predeterminado");
	  private JButton buttonR = new JButton("Ruta");
	  


public vistaA(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	}

public void activar() {
    frameVista1.setEnabled(true);
    hacerVisible();
  }

  public void desactivar() {
    frameVista1.setEnabled(false);
    hacerInvisible();
  }
	  public void hacerVisible() {
	    frameVista1.pack();
	    frameVista1.setVisible(true);
	  }

	  public void hacerInvisible() {
	    frameVista1.setVisible(false);
	  }
	  
	  private void inicializar_frameMBD() {
			frameVista1.setMinimumSize(new Dimension(370,150));
		    frameVista1.setResizable(true);
		    frameVista1.setLocationRelativeTo(null);
			FlowLayout layout1 = new FlowLayout(FlowLayout.LEFT, 10, 35);
		    frameVista1.setLayout(layout1);
		   
		    JPanel contentPanel = (JPanel) frameVista1.getContentPane();
		    contentPanel.add(panelContenidos1);
		    
		    frameVista1.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		        	 System.exit(0);
		         }  
		         
		      });
		    asignar_listenersComponentes1();
			}

		
		
		public void actionPerformed_buttonP (ActionEvent event) throws ClassNotFoundException, NonExistObjectToReadException, IOException {
			iCtrlPresentacion.sincronizacionA_a_Principal();
		}
		
		public void actionPerformed_buttonR (ActionEvent event) throws ClassNotFoundException, NonExistObjectToReadException {
			iCtrlPresentacion.sincronizacionA_a_FCT();
		}
		
	
		public void asignar_listenersComponentes1() {

		    buttonP.addActionListener
		      (new ActionListener() {
		        public void actionPerformed (ActionEvent event) {
		          String texto = ((JButton) event.getSource()).getText();
		          System.out.println("Has clickado el boton con texto: " + texto);
		          try {
					actionPerformed_buttonP(event);
				} catch (ClassNotFoundException | NonExistObjectToReadException | IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Se ha producido un problema al asignar un listener");
				}
		        }
		      });

		    buttonR.addActionListener
		      (new ActionListener() {
		        public void actionPerformed (ActionEvent event) {
		          String texto = ((JButton) event.getSource()).getText();
		          System.out.println("Has clickado el boton con texto: " + texto);
		          try {
					actionPerformed_buttonR(event);
				} catch (ClassNotFoundException | NonExistObjectToReadException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Se ha producido un problema al asignar un listener");

				}
		        }
		      });
		  }
	  public void inicializarComponentes() {
		  	inicializar_frameMBD();
		    frameVista1.add(buttonP);
		    frameVista1.add(buttonR);
		    
	  }
}


