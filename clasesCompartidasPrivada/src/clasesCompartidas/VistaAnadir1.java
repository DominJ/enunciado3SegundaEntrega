package clasesCompartidas;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VistaAnadir1 {

	
	  private CtrlPresentacion iCtrlPresentacion;

	// Anadir //
	private static JPanel panelAnadir = new JPanel();
	private static JPanel panelAnadir1 = new JPanel();;
	private static JFrame frameVistaAnadir = new JFrame("Añadir");	
	//private static JFrame frameVistaAnadir1 = new JFrame("Añadir DI");
	private static CheckboxGroup Tipos = new CheckboxGroup();
	private static Checkbox chkAuthor = new Checkbox("Author",Tipos,false);
	private static Checkbox chkConf = new Checkbox("Conference",Tipos,false);
	private static Checkbox chkTerm = new Checkbox("Term",Tipos,false);
	private static TextField tf1 = new TextField("",20);
	private static TextField tf2 = new TextField("",20);
	private static Label PaperL = new Label("Paper");
	private static JButton buttonOk = new JButton("Ok");
	
	
	private static JButton buttonDI = new JButton("Dato Independiente");
	private static JButton buttonCD = new JButton("Conjunto de Datos");


public void activar() {
    frameVistaAnadir.setEnabled(true);
  }

  public void desactivar() {
    frameVistaAnadir.setEnabled(false);
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
	
	public void actionPerformed_buttonOk (ActionEvent event) {
		int a = panelAnadir.getComponentCount();
		System.out.println("Numberargs:"+a+"\n");
		//List<JTextField> list = new ArrayLists<JTextField>();
		Component[] components = panelAnadir.getComponents();
		String s = "";
		String n = "";
		for (Component component : components) {
		    if (component.getClass().equals(Checkbox.class)) {
		    	Checkbox b = (Checkbox)component;
		    	if(b.getState()) {
		    		s = b.getLabel();
		    		//System.out.println("Check:"+s+"\n");
		    	}
		    }
		    if (component.getClass().equals(TextField.class)) {
		    	TextField c = (TextField)component;
		    	n = c.getText();
		    }
		}
		System.out.println("Check:"+s+"\n");
		System.out.println("TextField:"+n+"\n");
		
		iCtrlPresentacion.anadirnodo(s,n);


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
		frameVistaAnadir.setMinimumSize(new Dimension(330,80));
		frameVistaAnadir.setResizable(false);
		frameVistaAnadir.setLocationRelativeTo(null);
		frameVistaAnadir.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaAnadir.getContentPane();
	    contentPaneAnadir.add(panelAnadir);
	    
		
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
		//cambiao ventana -> frameVista
	    frameVistaAnadir.setLayout(layout);
	    panelAnadir.setLayout(new FlowLayout());
		
	    frameVistaAnadir.setVisible(true);
	    panelAnadir.setVisible(true);
	    
	    panelAnadir.add(buttonDI);
	    panelAnadir.add(buttonCD);
	    asignar_listenersComponentes2();
	}

}
