package clasesCompartidas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class vistaCD {
	  private CtrlPresentacion iCtrlPresentacion;
	  private JFrame frameVistaCD = new JFrame("Añadir CD");
	  private JPanel panelCD = new JPanel();
	  private Label PaperL = new Label("Dialogo");
	  private JButton buttonAceptar = new JButton("Aceptar");
	  private JButton buttonCancelar = new JButton("Cancelar");




	public void activar() {
	    frameVistaCD.setEnabled(true);
	  }

	  public void desactivar() {
	    frameVistaCD.setEnabled(false);
	  }
		  public void hacerVisible() {
		    frameVistaCD.pack();
		    frameVistaCD.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaCD.setVisible(false);
		  }
		  
		  
          void actionPerformed_buttonAceptar(ActionEvent event) {
        	  //iCtrlPresentacion.actualizarCD();
          }
          
          void actionPerformed_buttonCancelar(ActionEvent event) {
        	  iCtrlPresentacion.sincronizacionCD_a_Anadir1();
          }



private void asignar_listenersComponentes() {
	  buttonAceptar.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonAceptar(event);
	        }
	      });
	  buttonCancelar.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonCancelar(event);
        }
      });
	}

		  
		  public void inicializarComponentes () {
				frameVistaCD.setMinimumSize(new Dimension(800,300));
				frameVistaCD.setResizable(false);
				frameVistaCD.setLocationRelativeTo(null);
				frameVistaCD.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			    JPanel contentPaneAnadir = (JPanel) frameVistaCD.getContentPane();
			    contentPaneAnadir.add(panelCD);
			    
				
				FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
				//cambiao ventana -> frameVista
			    frameVistaCD.setLayout(layout);
			    panelCD.setLayout(new FlowLayout());
				
			    frameVistaCD.setVisible(true);
			    panelCD.setVisible(true);
			    
			    panelCD.add(PaperL);
			    PaperL.setText("Para añadir conjuntos de datos, debe añadir los ficheros"
			    		+ "en la carpeta AddData con los nombres correspondientes,"
			    		+ "quiere añadir el conjunto de datos?");
			    panelCD.add(buttonAceptar);
			    panelCD.add(buttonCancelar);
			  
			   
			    asignar_listenersComponentes(); 
			 

			 
		
		  }
		  
		  public vistaCD(CtrlPresentacion pCtrlPresentacion) {
			    iCtrlPresentacion = pCtrlPresentacion;
			    inicializarComponentes();
			}

}
