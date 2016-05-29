package clasesPrivadas.Dominio.Clases;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class vistaGuardar {
	private CtrlPresentacion iCtrlPresentacion;
	private JFrame frameVista = new JFrame("Camins de cerca de rellevancia");
	private JPanel panelContenidos = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JButton buttonG = new JButton("Guardar");
	private JButton buttonC = new JButton("Cancelar");
	private Label c = new Label("Ins");
	private TextField a = new TextField("",10);
	

public void activar() {
    frameVista.setEnabled(true);
    hacerVisible();
  }

  public void desactivar() {
    frameVista.setEnabled(false);
    hacerInvisible();
  }
	
	  public void hacerVisible() {
		    frameVista.pack();
		    frameVista.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVista.setVisible(false);
		  }
	
	public vistaGuardar(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	  }

	private void inicializarComponentes() {
		frameVista.setMinimumSize(new Dimension(350,250));
		frameVista.setResizable(false);
		frameVista.setLocationRelativeTo(null);
		frameVista.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVista.getContentPane();
	    contentPaneAnadir.add(panelContenidos);
	    frameVista.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 iCtrlPresentacion.sincronizacionGuardar_a_Principal();
	         }        
	      });
		GridBagLayout layout = new GridBagLayout();
	    frameVista.setLayout(layout);
	    c.setText("Introduzca la ruta donde quiere guardar los cambios");
	    panelContenidos.setLayout(new BorderLayout());
	    panelContenidos.add(c,BorderLayout.NORTH);
	    panelContenidos.add(a,BorderLayout.CENTER);
	    panelContenidos.add(panelBotones,BorderLayout.SOUTH);
	    panelBotones.add(buttonG);
	    panelBotones.add(buttonC);
	    //panelBotones.setLayout(new GridLayout());
	    asignar_listenersComponentes2();
		
	}
	
	private void asignar_listenersComponentes2() {
	    buttonG.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto + "\n");
	          actionPerformed_buttonG(event);
	        }
	      });

	    buttonC.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonC(event);
	        }
	      });

}
	public void actionPerformed_buttonG (ActionEvent event) {
		String b = a.getText();
		System.out.println(b);
		iCtrlPresentacion.sincronizacionGuardar_a_Principal1(b);
	  }

	public void actionPerformed_buttonC (ActionEvent event) {
		System.exit(0);
	  }
}
