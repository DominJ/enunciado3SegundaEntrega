package clasesPrivadas.Dominio.Clases;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Daniel Pulido
 *
 */

public class VistaEliminar {
	  private CtrlPresentacion iCtrlPresentacion;

	private  JPanel panelEliminar = new JPanel();
	private  JFrame frameVistaEliminar = new JFrame("Eliminar");
	private  CheckboxGroup Tipos = new CheckboxGroup();
	private  Checkbox chkPaper = new Checkbox("Paper",Tipos,true);
	private  Checkbox chkAuthor = new Checkbox("Author",Tipos,false);
	private  Checkbox chkConf = new Checkbox("Conference",Tipos,false);
	private  Checkbox chkTerm = new Checkbox("Term",Tipos,false);
	private  TextField tf1 = new TextField("",20);
	private JButton buttonOk = new JButton("Ok");
	

	public VistaEliminar(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    inicializarComponentes();
	}

	public void activar() {
		frameVistaEliminar.setEnabled(true);
		hacerVisible();
	}

  public void desactivar() {
    frameVistaEliminar.setEnabled(false);
    hacerInvisible();
  }
	
	  public void hacerVisible() {
		    frameVistaEliminar.pack();
		    frameVistaEliminar.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaEliminar.setVisible(false);
		  }
	
	
	
	public  void actionPerformed_buttonOk (ActionEvent event) {
		int a = panelEliminar.getComponentCount();
		//List<JTextField> list = new ArrayLists<JTextField>();
		Component[] components = panelEliminar.getComponents();
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
		//(0 = P, 1 = A, 2 = C, 3 = T)
		int options = 0;
		if(s == "Author") options = 1;
		else if(s == "Conference") options = 2;
		else if(s == "Term") options = 3;
		iCtrlPresentacion.sincronizacionEliminar_a_MBD1(options,n);
	}

private  void asignar_listenersComponentes2() {
	  buttonOk.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonOk(event);
	        }
	      });
	}

public  void inicializarComponentes () {
		frameVistaEliminar.setMinimumSize(new Dimension(520,150));
		frameVistaEliminar.setResizable(true);
		frameVistaEliminar.setLocationRelativeTo(null);
		frameVistaEliminar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaEliminar.getContentPane();
	    contentPaneAnadir.add(panelEliminar);
	    
	    
	    frameVistaEliminar.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 iCtrlPresentacion.sincronizacionEliminar_a_MBD();
	         }        
	      });  
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
		//cambiao ventana -> frameVista
	    frameVistaEliminar.setLayout(layout);
	    panelEliminar.setLayout(new FlowLayout());
		
	    frameVistaEliminar.setVisible(true);
	    panelEliminar.setVisible(true);
	    tf1 = new TextField("Anade el valor", 20);
	    tf1.setLocation(30, 30);
	    panelEliminar.add(chkPaper);
	    panelEliminar.add(chkAuthor);   
	    panelEliminar.add(chkConf);       
	    panelEliminar.add(chkTerm); 
	    panelEliminar.add(tf1);
	    panelEliminar.add(buttonOk);
	
	    
	    asignar_listenersComponentes2();
	}

	
}
