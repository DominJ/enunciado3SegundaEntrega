package clasesCompartidas;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaCCN {
	private JPanel panelCCN = new JPanel();
    private CtrlPresentacion iCtrlPresentacion;
	private JFrame frameVistaCCN = new JFrame("Crear Camino Nuevo");	
	private static TextField tf1 = new TextField("",20);
	private static TextField tf2 = new TextField("",20);
	private static Label Nodo = new Label("Nodo");
	private static TextField tf3 = new TextField("",20);
	private static Label Men = new Label("Menor");
	private static Label May = new Label("Mayor");
	private static JButton buttonOk = new JButton("Ok");
	
	public void activar() {
	    frameVistaCCN.setEnabled(true);
	  }

	  public void desactivar() {
	    frameVistaCCN.setEnabled(false);
	  }
		  public void hacerVisible() {
		    frameVistaCCN.pack();
		    frameVistaCCN.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaCCN.setVisible(false);
		  }
		  
	
	public VistaCCN(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	}
	
	public void actionPerformed_buttonOk (ActionEvent event) {
		Component a = panelCCN.getComponent(1);
		Component b = panelCCN.getComponent(3);
		Component c = panelCCN.getComponent(5);
		TextField a1 = (TextField) a;
		TextField b1 = (TextField) b;
		TextField c1 = (TextField) c;
		String a2 = a1.getText();
		String b2 = b1.getText();
		String c2 = c1.getText();
		int b3 = Integer.parseInt(b2);
		int c3 = Integer.parseInt(c2);
		iCtrlPresentacion.sincronizacionCCN_a_RC1(a2,b3,c3);
	}
  
  private void asignar_listenersComponentes3() {
	  buttonOk.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonOk(event);
	        }
	      });
	}
	
	public void inicializarComponentes() {
		frameVistaCCN.setMinimumSize(new Dimension(330,90));
		frameVistaCCN.setResizable(false);
		frameVistaCCN.setLocationRelativeTo(null);
		frameVistaCCN.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaCCN.getContentPane();
	    contentPaneAnadir.add(panelCCN);
	    
	    frameVistaCCN.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 iCtrlPresentacion.sincronizacionCCN_a_RC();
	         }        
	      });  
	    
	    
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
	    frameVistaCCN.setLayout(layout);
	    panelCCN.setLayout(new FlowLayout());
	    
	    Nodo.setText("Nodo");
	    Men.setText("Extremo menor de relevancia");
	    May.setText("Extremo mayor de relevancia");
	    tf1.setLocation(30, 30);
	    tf2.setLocation(30, 30);
	    tf3.setLocation(30, 30);
	    panelCCN.add(Nodo);
	    panelCCN.add(tf1);
	    panelCCN.add(Men);
	    panelCCN.add(tf2);
	    panelCCN.add(May);
	    panelCCN.add(tf3);
	    panelCCN.add(buttonOk);

		
	    frameVistaCCN.setVisible(true);
	    asignar_listenersComponentes3();
	}
	
}
