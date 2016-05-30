package clasesPrivadas.Dominio.Clases;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private JPanel panelCCN1 = new JPanel();
	private JPanel panelCCN2 = new JPanel();
	private JPanel panelCCN3 = new JPanel();
	private JPanel panelCCN4 = new JPanel();
	private JPanel panelBotones = new JPanel();
    private CtrlPresentacion iCtrlPresentacion;
	private JFrame frameVistaCCN = new JFrame("Crear Camino Nuevo");	
	private static TextField tf1 = new TextField("",10);
	private static TextField tf2 = new TextField("",10);
	private static Label Nodo = new Label("Nodo");
	private static TextField tf3 = new TextField("",10);
	private static Label Men = new Label("Menor");
	private static Label May = new Label("Mayor");
	private static JButton buttonOk = new JButton("Ok");

	
	public void activar() {
	    frameVistaCCN.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaCCN.setEnabled(false);
	    hacerInvisible();
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
		Component a = panelCCN.getComponent(0);
		Component b = panelCCN.getComponent(1);
		Component c = panelCCN.getComponent(2);
		JPanel a1 = (JPanel) a;
		JPanel b1 = (JPanel) b;
		JPanel c1 = (JPanel) c;
		Component a2 = a1.getComponent(1);
		Component b2 = b1.getComponent(1);
		Component c2 = c1.getComponent(1);
		TextField a3 = (TextField) a2;
		TextField b3 = (TextField) b2;
		TextField c3 = (TextField) c2;
		String a4 = a3.getText();
		String b4 = b3.getText();
		String c4 = c3.getText();
		int b5 = Integer.parseInt(b4);
		int c5 = Integer.parseInt(c4);
		iCtrlPresentacion.sincronizacionCCN_a_RC1(a4,b5,c5);
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
		frameVistaCCN.setMinimumSize(new Dimension(590,200));
		frameVistaCCN.setResizable(true);
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
	   /* tf1.setLocation(30, 30);
	    tf2.setLocation(30, 30);
	    tf3.setLocation(30, 30); */
	    panelCCN.setLayout(new BorderLayout());
	    panelCCN.add(panelCCN1,BorderLayout.NORTH);
	    panelCCN.add(panelCCN2,BorderLayout.WEST);
	    panelCCN.add(panelCCN3,BorderLayout.EAST);
	    panelCCN.add(panelCCN4,BorderLayout.SOUTH);
	    panelCCN1.add(Nodo);
	    panelCCN1.add(tf1);
	    panelCCN2.add(Men);
	    panelCCN2.add(tf2);
	    panelCCN3.add(May);
	    panelCCN3.add(tf3);
	    panelCCN4.add(panelBotones,BorderLayout.PAGE_END);
	    panelBotones.add(buttonOk);

		
	    asignar_listenersComponentes3();
	}
	
}
