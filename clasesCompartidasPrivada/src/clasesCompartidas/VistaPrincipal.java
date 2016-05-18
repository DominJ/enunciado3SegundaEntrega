package clasesCompartidas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class VistaPrincipal {
	
// Vista Principal //
private CtrlPresentacion iCtrlPresentacion;
private JFrame frameVista = new JFrame("Camins de cerca de rellevància");
private JPanel panelContenidos = new JPanel();
private JPanel panelBotones = new JPanel();
private JButton buttonMBD = new JButton("Modificar Base de datos");
private JButton buttonRC = new JButton("Realizar Consulta");
private JButton buttonBH = new JButton("Busca Historial");
private JButton buttonSalir = new JButton("Salir");

//Modificar base de datos //
private JFrame frameVista1 = new JFrame("Opcions");
private JPanel panelContenidos1 = new JPanel();
private JPanel panelBotones1 = new JPanel();
private JButton buttonA = new JButton("Anadir");
private JButton buttonAR = new JButton("Actualizar");
private JButton buttonLH = new JButton("Limpiar Historial");
private JButton buttonE = new JButton("Eliminar");


// Anadir //
private JPanel panelAnadir = new JPanel();
private JFrame frameVistaAnadir = new JFrame("Añadir");
private CheckboxGroup Tipos = new CheckboxGroup();
private Checkbox chkPaper = new Checkbox("Paper",Tipos,true);
private Checkbox chkAuthor = new Checkbox("Author",Tipos,false);
private Checkbox chkConf = new Checkbox("Conference",Tipos,false);
private Checkbox chkTerm = new Checkbox("Term",Tipos,false);
TextField tf1 = new TextField("",20);




public VistaPrincipal() {
		
}


////////////////////////////////////// VISTA PRINCIPAL /////////////////////////////////////////
private void inicializar_frameVista() {
    // Tamanyo
    frameVista.setMinimumSize(new Dimension(700,400));
    frameVista.setPreferredSize(frameVista.getMinimumSize());
    frameVista.setResizable(false);
    // Posicion y operaciones por defecto
    frameVista.setLocationRelativeTo(null);
    frameVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Se agrega panelContenidos al contentPane (el panelContenidos se
    // podria ahorrar y trabajar directamente sobre el contentPane)
    JPanel contentPane = (JPanel) frameVista.getContentPane();
    contentPane.add(panelContenidos);
    
    //---------------------------------------//
    
	//JFrame ventana = new JFrame("MENU PRINCIPAL");
    //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
	//cambiao ventana -> frameVista
    frameVista.setLayout(layout);
  
    
    JLabel etiqueta = new JLabel("MENU PRINCIPAL");
    etiqueta.setForeground(Color.RED);
    frameVista.add(etiqueta);
 
  }



private void inicializar_panelContenidos() {
    // Layout
    panelContenidos.setLayout(new BorderLayout());
    // Paneles
    panelContenidos.add(panelBotones,BorderLayout.NORTH);
  }

private void inicializar_panelBotones() {
    // Layout
    panelBotones.setLayout(new GridLayout());
    // Componentes
    panelBotones.add(buttonMBD);
    panelBotones.add(buttonRC);
    panelBotones.add(buttonBH);
    panelBotones.add(buttonSalir);
    // Tooltips
    buttonMBD.setToolTipText("Llama al controlador de dominio con la informacion del ComboBox");
   buttonRC.setToolTipText("Abre una nueva ventana sincronizada");
    buttonBH.setToolTipText("Cambia el panel de informacion");
    buttonSalir.setToolTipText("Abre un Dialogo modal simple"); 
  }



//////////////////////////////////////VISTA MBD /////////////////////////////////////////



private void inicializar_frameMBD() {
	System.out.println("Hola\n");
	frameVista1.setMinimumSize(new Dimension(500,400));
    frameVista1.setPreferredSize(frameVista1.getMinimumSize());
    frameVista1.setResizable(false);
    // Posicion y operaciones por defecto
    frameVista1.setLocationRelativeTo(null);
    frameVista1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    // Se agrega panelContenidos al contentPane (el panelContenidos se
    // podria ahorrar y trabajar directamente sobre el contentPane)
    
    

    JPanel contentPanel = (JPanel) frameVista1.getContentPane();
    contentPanel.add(panelContenidos1);
    
    
    JLabel etiqueta1 = new JLabel("MODIFICACIONES");
    etiqueta1.setForeground(Color.GREEN);
    frameVista1.add(etiqueta1);
    
    //---------------------------------------//
	
	FlowLayout layout1 = new FlowLayout(FlowLayout.LEFT, 10, 35);
	//cambiao ventana -> frameVista
    frameVista1.setLayout(layout1);
    

}

private void inicializar_panelContenidos1() {
    // Layout
    panelContenidos1.setLayout(new BorderLayout());
    // Paneles
    panelContenidos1.add(panelBotones1,BorderLayout.NORTH);
  }

private void inicializar_panelBotones1() {
    // Layout
    panelBotones1.setLayout(new GridLayout());
    // Componentes
    panelBotones1.add(buttonA);
    panelBotones1.add(buttonAR);
    panelBotones1.add(buttonLH);
    panelBotones1.add(buttonE);
  }

public void actionPerformed_buttonA (ActionEvent event) {
	
	frameVistaAnadir.setMinimumSize(new Dimension(450,100));
	frameVistaAnadir.setPreferredSize(frameVista.getMinimumSize());
	frameVistaAnadir.setResizable(false);
	frameVistaAnadir.setLocationRelativeTo(null);
	frameVistaAnadir.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    JPanel contentPaneAnadir = (JPanel) frameVistaAnadir.getContentPane();
    contentPaneAnadir.add(panelAnadir);
    
    //frameVistaAnadir.add(panelAnadir);
	
	FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
	//cambiao ventana -> frameVista
    frameVistaAnadir.setLayout(layout);
    panelAnadir.setLayout(new FlowLayout());
	
    

   /* Checkbox chkPaper = new Checkbox("Paper",Tipos,true);
    Checkbox chkAuthor = new Checkbox("Author",Tipos,false);
    Checkbox chkConf = new Checkbox("Conference",Tipos,false);
    Checkbox chkTerm = new Checkbox("Term",Tipos,false); */

    tf1 = new TextField("Añade el valor", 20);
    tf1.setLocation(30, 30);
    panelAnadir.add(chkPaper);
    panelAnadir.add(chkAuthor);   
    panelAnadir.add(chkConf);       
    panelAnadir.add(chkTerm); 
    panelAnadir.add(tf1);

    
    frameVistaAnadir.setVisible(true);
    panelAnadir.setVisible(true);

	}

public void actionPerformed_buttonAR(ActionEvent event) {

}

public void actionPerformed_buttonLH(ActionEvent event) {

}

public void actionPerformed_buttonE(ActionEvent event) {
}

private void asignar_listenersComponentes1() {

    // Listeners para los botones

    buttonA.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonA(event);
        }
      });

    buttonAR.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonAR(event);
        }
      });

    buttonLH.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonLH(event);
        }
      });
    buttonE.addActionListener
    (new ActionListener() {
      public void actionPerformed (ActionEvent event) {
        String texto = ((JButton) event.getSource()).getText();
        System.out.println("Has clickado el boton con texto: " + texto);
        actionPerformed_buttonE(event);
      }
    });

    


  }


//////////////////////////////////////Botones /////////////////////////////////////////


public void actionPerformed_buttonMBD (ActionEvent event) {
	
	    inicializar_frameMBD();
	    inicializar_panelContenidos1();
	    inicializar_panelBotones1();
	    asignar_listenersComponentes1();
	    System.out.println
	      ("isEventDispatchThread1: " + SwingUtilities.isEventDispatchThread());
	    frameVista1.pack();
	    frameVista1.setVisible(true);
	  	
	  
  }

public void actionPerformed_buttonRC(ActionEvent event) {
	
}

public void actionPerformed_buttonBH(ActionEvent event) {
	
}

public void actionPerformed_buttonSalir(ActionEvent event) {
	System.exit(0);
}
private void asignar_listenersComponentes() {

    // Listeners para los botones

    buttonMBD.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonMBD(event);
        }
      });

    buttonRC.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonRC(event);
        }
      });

    buttonBH.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonBH(event);
        }
      });

    buttonSalir.addActionListener
      (new ActionListener() {
        public void actionPerformed (ActionEvent event) {
          String texto = ((JButton) event.getSource()).getText();
          System.out.println("Has clickado el boton con texto: " + texto);
          actionPerformed_buttonSalir(event);
        }
      });

    


  }

protected void inicializarComponentes() {
    inicializar_frameVista();
    inicializar_panelContenidos();
    inicializar_panelBotones();
    asignar_listenersComponentes();
 }
public VistaPrincipal (CtrlPresentacion pCtrlPresentacion) {
    System.out.println
      ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    iCtrlPresentacion = pCtrlPresentacion;
    inicializarComponentes();
  }

  public void hacerVisible() {
    System.out.println
      ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    frameVista.pack();
    frameVista.setVisible(true);
  }

  public void activar() {
    frameVista.setEnabled(true);
  }

  public void desactivar() {
    frameVista.setEnabled(false);
  }

	
}
