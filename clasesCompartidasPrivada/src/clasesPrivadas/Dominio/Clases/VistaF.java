package clasesPrivadas.Dominio.Clases;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Daniel Pulido
 *
 */
public class VistaF {
	  private JPanel panelF = new JPanel();
		private JFrame frameVistaF = new JFrame("Filtros");	
		private CtrlPresentacion iCtrlPresentacion;
		private Checkbox chkAuthor = new Checkbox("Author",false);
		private Checkbox chkConf = new Checkbox("Conference",false);
		private Checkbox chkTerm = new Checkbox("Term",false);
		private Checkbox chkPaper = new Checkbox("Paper",false);
		private JButton buttonOk = new JButton("Ok");
		private Label s = new Label("Selecciona los filtros que quieres aplicar");

	public VistaF(CtrlPresentacion pCtrlPresentacion) {
		    iCtrlPresentacion = pCtrlPresentacion;
		    inicializarComponentes();
		}

	public void activar() {
	    frameVistaF.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frameVistaF.setEnabled(false);
	    hacerInvisible();
	  }
		  public void hacerVisible() {
		    frameVistaF.pack();
		    frameVistaF.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frameVistaF.setVisible(false);
		  }
		  
	
	public void inicializarComponentes() {
		    frameVistaF.setMinimumSize(new Dimension(700,200));
			frameVistaF.setResizable(true);
			frameVistaF.setLocationRelativeTo(null);
			frameVistaF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    JPanel contentPaneAnadir = (JPanel) frameVistaF.getContentPane();
		    contentPaneAnadir.add(panelF);
		    
		    frameVistaF.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		        	 iCtrlPresentacion.sincronizacionF_a_RC();
		         }        
		      });
			FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
			//cambiao ventana -> frameVista
		    frameVistaF.setLayout(layout);
		    panelF.setLayout(new FlowLayout());
			
		    frameVistaF.setVisible(true);
		    panelF.setVisible(true);
		    
		    
		    
		   
		    panelF.add(s);
		    panelF.add(chkPaper);
		    panelF.add(chkAuthor);
		    panelF.add(chkConf);
		    panelF.add(chkTerm);
		    panelF.add(buttonOk);


		    
		    //frameVistaF.setVisible(false);
		    asignar_listenersComponentes3();
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
	  public void actionPerformed_buttonOk (ActionEvent event) {
			int a = panelF.getComponentCount();
			//List<JTextField> list = new ArrayLists<JTextField>();
			Component z = panelF.getComponent(1);
			Checkbox x = (Checkbox) z;
			Component z1 = panelF.getComponent(2);
			Checkbox x1 = (Checkbox) z1;
			Component z2 = panelF.getComponent(3);
			Checkbox x2 = (Checkbox) z2;
			Component z3 = panelF.getComponent(4);
			Checkbox x3 = (Checkbox) z3;
			Set<Integer> c = new HashSet<Integer>();
			if (x.getState()) c.add(0);
			if (x1.getState()) c.add(1);
			if(x2.getState()) c.add(2);
			if(x3.getState()) c.add(3);
			
			
			iCtrlPresentacion.sincronizacionF_a_CCN(c);
			

		}
}
