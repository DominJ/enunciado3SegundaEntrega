package clasesCompartidas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VistaMBD {
	  private CtrlPresentacion iCtrlPresentacion;
	  private JFrame frameVista1 = new JFrame("Opcions");
	  private JPanel panelContenidos1 = new JPanel();
	  private JPanel panelBotones1 = new JPanel();
	  private JButton buttonA = new JButton("Anadir");
	  private JButton buttonAR = new JButton("Actualizar");
	  private JButton buttonLH = new JButton("Limpiar Historial");
	  private JButton buttonE = new JButton("Eliminar");

	  

public void activar() {
    frameVista1.setEnabled(true);
  }

  public void desactivar() {
    frameVista1.setEnabled(false);
  }
	  public void hacerVisible() {
	    frameVista1.pack();
	    frameVista1.setVisible(true);
	  }

	  public void hacerInvisible() {
	    frameVista1.setVisible(false);
	  }
	  
	  private void inicializar_frameMBD() {
			System.out.println("No existeix\n");
			frameVista1.setMinimumSize(new Dimension(530,200));
		    frameVista1.setPreferredSize(frameVista1.getMinimumSize());
		    frameVista1.setResizable(false);
		    // Posicion y operaciones por defecto
		    frameVista1.setLocationRelativeTo(null);
		    frameVista1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    JPanel contentPanel = (JPanel) frameVista1.getContentPane();
		    contentPanel.add(panelContenidos1);
		    JLabel etiqueta1 = new JLabel("MODIFICACIONES");
		    etiqueta1.setForeground(Color.GREEN);
		    frameVista1.add(etiqueta1);
			FlowLayout layout1 = new FlowLayout(FlowLayout.LEFT, 10, 35);
		    frameVista1.setLayout(layout1);
		    
			}


		private void inicializar_panelContenidos1() {
		    // Layout
		    panelContenidos1.setLayout(new BorderLayout());
		    // Paneles
		    panelContenidos1.add(panelBotones1,BorderLayout.NORTH);
		  }

		private void inicializar_panelBotones1() {
		    // Layout
		    panelBotones1.setLayout(new GridLayout());
		    // Componentes
		    panelBotones1.add(buttonA);
		    panelBotones1.add(buttonAR);
		    panelBotones1.add(buttonLH);
		    panelBotones1.add(buttonE);
		  }
		
		
		public void actionPerformed_buttonA (ActionEvent event) {
			iCtrlPresentacion.sincronizacionMBD_a_Anadir1();
		}
		public void asignar_listenersComponentes1() {

		    // Listeners para los botones
			
		    buttonA.addActionListener
		      (new ActionListener() {
		        public void actionPerformed (ActionEvent event) {
		          String texto = ((JButton) event.getSource()).getText();
		          System.out.println("Has clickado el boton con texto: " + texto);
		          actionPerformed_buttonA(event);
		        }
		      });

		    buttonAR.addActionListener
		      (new ActionListener() {
		        public void actionPerformed (ActionEvent event) {
		          String texto = ((JButton) event.getSource()).getText();
		          System.out.println("Has clickado el boton con texto: " + texto);
		          actionPerformed_buttonAR(event);
		        }
		      });

		    buttonLH.addActionListener
		      (new ActionListener() {
		        public void actionPerformed (ActionEvent event) {
		          String texto = ((JButton) event.getSource()).getText();
		          System.out.println("Has clickado el boton con texto: " + texto);
		          actionPerformed_buttonLH(event);
		        }
		      });
		    buttonE.addActionListener
		    (new ActionListener() {
		      public void actionPerformed (ActionEvent event) {
		        String texto = ((JButton) event.getSource()).getText();
		        System.out.println("Has clickado el boton con texto: " + texto);
		        VistaEliminar.actionPerformed_buttonE(event);
		        }
		    });

		    

		  }
	  public void inicializarComponentes() {
		  	inicializar_frameMBD();
		    inicializar_panelContenidos1();
		    inicializar_panelBotones1();
		    asignar_listenersComponentes1();
		    System.out.println
		      ("isEventDispatchThread1: " + SwingUtilities.isEventDispatchThread());
		   hacerVisible();
		    
	  }
	  
	public VistaMBD(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	}
}
