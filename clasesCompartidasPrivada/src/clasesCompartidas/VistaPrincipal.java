package clasesCompartidas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VistaPrincipal {
	
// Vista Principal //
private CtrlPresentacion iCtrlPresentacion;
private JFrame frameVista = new JFrame("Camins de cerca de rellevancia");
private JPanel panelContenidos = new JPanel();
private JPanel panelBotones = new JPanel();
private JButton buttonMBD = new JButton("Modificar Base de datos");
private JButton buttonRC = new JButton("Realizar Consulta");
private JButton buttonBH = new JButton("Busca Historial");
private JButton buttonSalir = new JButton("Salir");

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

private void inicializar_frameVista() {
    frameVista.setMinimumSize(new Dimension(900,400));
    frameVista.setPreferredSize(frameVista.getMinimumSize());
    frameVista.setResizable(false);
    frameVista.setLocationRelativeTo(null);
    frameVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel contentPane = (JPanel) frameVista.getContentPane();
    contentPane.add(panelContenidos);
	FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 15);
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


public void actionPerformed_buttonMBD (ActionEvent event) {
	iCtrlPresentacion.sincronizacionVistaPrincipal_a_MBD();
	  	
	  
  }

public void actionPerformed_buttonRC (ActionEvent event) {
	iCtrlPresentacion.sincronizacionVistaPrincipal_a_RC();
	  	
	  
  }


public void actionPerformed_buttonBH (ActionEvent event) {
	iCtrlPresentacion.sincronizacionPrincipal_a_BH();
  }

public void actionPerformed_buttonSalir (ActionEvent event) {
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
    activar();
	hacerVisible();
 }

public VistaPrincipal (CtrlPresentacion pCtrlPresentacion) {
    System.out.println
      ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    iCtrlPresentacion = pCtrlPresentacion;
    inicializarComponentes();
  }
}


