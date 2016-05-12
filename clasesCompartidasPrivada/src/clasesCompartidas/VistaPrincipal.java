package clasesCompartidas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class VistaPrincipal {
	
private CtrlPresentacion iCtrlPresentacion;
private JFrame frameVista = new JFrame("Vista Principal");
private JPanel panelContenidos = new JPanel();
private JPanel panelBotones = new JPanel();


public VistaPrincipal() {
		
}
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
  }



private void inicializar_panelContenidos() {
    // Layout
    panelContenidos.setLayout(new BorderLayout());
    // Paneles
    panelContenidos.add(panelBotones,BorderLayout.NORTH);
  }

protected void inicializarComponentes() {
    inicializar_frameVista();
    inicializar_panelContenidos();
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
