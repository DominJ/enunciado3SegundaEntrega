package clasesPrivadas.Dominio.Clases;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class vistaDI {
	  private CtrlPresentacion iCtrlPresentacion;
		private static JPanel panelAnadir1 = new JPanel();;
		private static JFrame frameVistaAnadir1 = new JFrame("Añadir DI");
		private static CheckboxGroup Tipos = new CheckboxGroup();
		private static Checkbox chkAuthor = new Checkbox("Author",Tipos,false);
		private static Checkbox chkConf = new Checkbox("Conference",Tipos,false);
		private static Checkbox chkTerm = new Checkbox("Term",Tipos,false);
		private static TextField tf1 = new TextField("",20);
		private static TextField tf2 = new TextField("",20);
		private static Label PaperL = new Label("Paper");
		private static JButton buttonOk = new JButton("Ok");

	public void activar() {
	    frameVistaAnadir1.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaAnadir1.setEnabled(false);
	    hacerInvisible();
	  }
		  public void hacerVisible() {
		    frameVistaAnadir1.pack();
		    frameVistaAnadir1.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaAnadir1.setVisible(false);
		  }
		  
		  public vistaDI(CtrlPresentacion pCtrlPresentacion) {
			    iCtrlPresentacion = pCtrlPresentacion;
			    inicializarComponentes();
			}
		  
		  public void actionPerformed_buttonOk (ActionEvent event) {
				int a = panelAnadir1.getComponentCount();
				System.out.println("Numberargs:"+a+"\n");
				//List<JTextField> list = new ArrayLists<JTextField>();
				Component[] components = panelAnadir1.getComponents();
				String s = "";
				String n = "";
				Component z = panelAnadir1.getComponent(1);
				TextField x = (TextField) z;
				String j = x.getText();
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
				System.out.println("Se ha añadido un paper:"+j+"\n");
				System.out.println("relacionado con un tipo de nodo:"+s+"\n");
				System.out.println("con el valor:"+n+"\n");
				
				String s1 = "Paper";
				iCtrlPresentacion.sincronizacionDI_a_Anadir11(s1, j, s, n);
				

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
			  frameVistaAnadir1.setMinimumSize(new Dimension(700,200));
				frameVistaAnadir1.setResizable(false);
				frameVistaAnadir1.setLocationRelativeTo(null);
				frameVistaAnadir1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			    JPanel contentPaneAnadir = (JPanel) frameVistaAnadir1.getContentPane();
			    contentPaneAnadir.add(panelAnadir1);
			    
			    frameVistaAnadir1.addWindowListener(new WindowAdapter() {
			         public void windowClosing(WindowEvent windowEvent){
			        	 iCtrlPresentacion.sincronizacionDI_a_Anadir1();
			         }        
			      });
				FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
				//cambiao ventana -> frameVista
			    frameVistaAnadir1.setLayout(layout);
			    panelAnadir1.setLayout(new FlowLayout());
				
			    frameVistaAnadir1.setVisible(true);
			    panelAnadir1.setVisible(true);
			    
			    
			    
			    tf1 = new TextField("Anade el valor", 20);
			    tf1.setLocation(30, 30);
			    tf2 = new TextField("Anade el paper", 20);
			    tf2.setLocation(30, 30);
			    panelAnadir1.add(PaperL);
			    panelAnadir1.add(tf2);
			    panelAnadir1.add(chkAuthor);
			    panelAnadir1.add(chkConf);
			    panelAnadir1.add(chkTerm);
			    panelAnadir1.add(tf1);
			    panelAnadir1.add(buttonOk);


			    
			    //frameVistaAnadir1.setVisible(false);
			    asignar_listenersComponentes3();
		  }

}
