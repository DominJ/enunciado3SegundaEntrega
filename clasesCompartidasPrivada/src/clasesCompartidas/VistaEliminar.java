package clasesCompartidas;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clasesPrivadas.Dominio.Clases.ConjuntoResultados;
import clasesPrivadas.Dominio.Clases.Grafo;

public class VistaEliminar {
	private static JPanel panelEliminar = new JPanel();
	private static JFrame frameVistaEliminar = new JFrame("Eliminar");
	private static CheckboxGroup Tipos = new CheckboxGroup();
	private static Checkbox chkPaper = new Checkbox("Paper",Tipos,true);
	private static Checkbox chkAuthor = new Checkbox("Author",Tipos,false);
	private static Checkbox chkConf = new Checkbox("Conference",Tipos,false);
	private static Checkbox chkTerm = new Checkbox("Term",Tipos,false);
	private static TextField tf1 = new TextField("",20);
	private static JButton buttonOk = new JButton("Ok");
	static Grafo gh = new Grafo(); //grafo heterogeneo que contiene todos los datos en memoria
	static ConjuntoResultados cr = new ConjuntoResultados();
	
	public static void actionPerformed_buttonOk (ActionEvent event) {
		int a = panelEliminar.getComponentCount();
		System.out.println("Numberargs:"+a+"\n");
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
		System.out.println("Check:"+s+"\n");
		System.out.println("TextField:"+n+"\n");
		//(0 = P, 1 = A, 2 = C, 3 = T)
		int options = 0;
		if(s == "Author") options = 1;
		else if(s == "Conference") options = 2;
		else if(s == "Term") options = 3;
		try
		{
			gh.eliminarNodo(options, gh.consultarNodo(options, n));
			cr.vaciar_resultados();
		}
		catch(NullPointerException e)
		{
			System.out.println("Alguna de las relaciones esta vacia");
		}


	}

private static void asignar_listenersComponentes2() {
	  buttonOk.addActionListener
	      (new ActionListener() {
	        public void actionPerformed (ActionEvent event) {
	          String texto = ((JButton) event.getSource()).getText();
	          System.out.println("Has clickado el boton con texto: " + texto);
	          actionPerformed_buttonOk(event);
	        }
	      });
	}

public static void actionPerformed_buttonE (ActionEvent event) {
		frameVistaEliminar.setMinimumSize(new Dimension(500,100));
		frameVistaEliminar.setResizable(false);
		frameVistaEliminar.setLocationRelativeTo(null);
		frameVistaEliminar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    JPanel contentPaneAnadir = (JPanel) frameVistaEliminar.getContentPane();
	    contentPaneAnadir.add(panelEliminar);
	    
		
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
	
	    
	    //frameVista1.setVisible(false);
	    asignar_listenersComponentes2();
	}
	
}
