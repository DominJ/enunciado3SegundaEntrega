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


public class VistaAnadir1 {

	private CtrlPresentacion iCtrlPresentacion;
	private JPanel panelAnadir = new JPanel();
	private JFrame frameVistaAnadir = new JFrame("Anadir");	
	private JButton buttonDI = new JButton("Dato Independiente");
	private JButton buttonCD = new JButton("Conjunto de Datos");


public void activar() {
    frameVistaAnadir.setEnabled(true);
    hacerVisible();
  }

  public void desactivar() {
    frameVistaAnadir.setEnabled(false);
    hacerInvisible();
  }
	
	  public void hacerVisible() {
		    frameVistaAnadir.pack();
		    frameVistaAnadir.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaAnadir.setVisible(false);
		  }
	
	public VistaAnadir1(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	  }



public void actionPerformed_buttonCD (ActionEvent event) {
	
	iCtrlPresentacion.sincronizacionAnadir1_a_CD();
}

public void actionPerformed_buttonDI (ActionEvent event) {
	
	iCtrlPresentacion.sincronizacionAnadir1_a_DI();
}

private void asignar_listenersComponentes2() {
	  buttonDI.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonDI(event);
	        }
	      });
	  buttonCD.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonCD(event);
        }
      });
	}

public void inicializarComponentes () {
		frameVistaAnadir.setMinimumSize(new Dimension(330,90));
		frameVistaAnadir.setResizable(true);
		frameVistaAnadir.setLocationRelativeTo(null);
		frameVistaAnadir.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaAnadir.getContentPane();
	    contentPaneAnadir.add(panelAnadir);
	    frameVistaAnadir.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 iCtrlPresentacion.sincronizacionAnadir1_a_MBD();
	         }        
	      });
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
	    frameVistaAnadir.setLayout(layout);
	    panelAnadir.setLayout(new FlowLayout());
	    frameVistaAnadir.setVisible(true);
	    panelAnadir.setVisible(true);
	    panelAnadir.add(buttonDI);
	    panelAnadir.add(buttonCD);
	    asignar_listenersComponentes2();
	}

}
