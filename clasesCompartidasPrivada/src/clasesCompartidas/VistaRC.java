package clasesCompartidas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaRC {
	
	
    private static JPanel panelRC = new JPanel();
	private static JFrame frameVistaRC = new JFrame("Añadir");	
	
	
	private static JFrame frameVistaCP = new JFrame("Camino Predeterminado");
    private static JPanel panelCP = new JPanel();

	
	private static JFrame frameVistaCCN = new JFrame("Crear Camino Nuevo");	
    private static JPanel panelCCN = new JPanel();



	
	private static JButton buttonCP = new JButton("Camino Predeterminado");
	private static JButton buttonCCN = new JButton("Crear Camino Nuevo");

	public static void actionPerformed_buttonCP (ActionEvent event) {
		frameVistaCP.setMinimumSize(new Dimension(330,90));
		frameVistaCP.setResizable(false);
		frameVistaCP.setLocationRelativeTo(null);
		frameVistaCP.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaCP.getContentPane();
	    contentPaneAnadir.add(panelCP);
	    
		
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
		//cambiao ventana -> frameVista
	    frameVistaCP.setLayout(layout);
	    panelCP.setLayout(new FlowLayout());
		
	    frameVistaCP.setVisible(true);
	}
	
	public static void actionPerformed_buttonCCN (ActionEvent event) {
		frameVistaCCN.setMinimumSize(new Dimension(330,90));
		frameVistaCCN.setResizable(false);
		frameVistaCCN.setLocationRelativeTo(null);
		frameVistaCCN.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaCCN.getContentPane();
	    contentPaneAnadir.add(panelCCN);
	    
		
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
		//cambiao ventana -> frameVista
	    frameVistaCCN.setLayout(layout);
	    panelCCN.setLayout(new FlowLayout());
		
	    frameVistaCCN.setVisible(true);
	}
	
	private static void asignar_listenersComponentes2() {
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



	public static void actionPerformed_buttonRC (ActionEvent event) {
			frameVistaRC.setMinimumSize(new Dimension(330,100));
			frameVistaRC.setResizable(false);
			frameVistaRC.setLocationRelativeTo(null);
			frameVistaRC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    JPanel contentPaneAnadir = (JPanel) frameVistaRC.getContentPane();
		    contentPaneAnadir.add(panelRC);
		    
			
			FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
			//cambiao ventana -> frameVista
		    frameVistaRC.setLayout(layout);
		    panelRC.setLayout(new FlowLayout());
			
		    frameVistaRC.setVisible(true);
		    panelRC.setVisible(true);
		    
		    panelRC.add(buttonCP);
		    panelRC.add(buttonCCN);
		    asignar_listenersComponentes2();
		}
}
