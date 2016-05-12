package clasesCompartidas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class VistaSecundaria {
	
	  private CtrlPresentacion iCtrlPresentacion;

	  private JFrame frameVista = new JFrame("Vista Secundaria");
	  private JPanel panelContenidos = new JPanel();
	  private JPanel panelInformacion = new JPanel();
	  private JPanel panelBotones = new JPanel();
	  private JButton buttonLlamadaDominio = new JButton("Llamada Dominio");
	  private JButton buttonVolver = new JButton("Volver");
	  private JTextArea textareaInformacion = new JTextArea(5,25);
}
