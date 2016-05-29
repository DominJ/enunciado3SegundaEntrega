package clasesPrivadas.Dominio.Clases;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileChooserTest extends JFrame {
	private CtrlPresentacion iCtrlPresentacion;
	private JFrame frame = new JFrame();

  public void activar() {
	    frame.setEnabled(true);
	    hacerVisible();
	  }

	  public void desactivar() {
	    frame.setEnabled(false);
	    hacerInvisible();
	  }
		
	 public void hacerVisible() {
	    frame.pack();
	    frame.setVisible(true);
	  }

	 public void hacerInvisible() {
	   frame.setVisible(false);
	}
	 
	public FileChooserTest(CtrlPresentacion pCtrlPresentacion) {
		    iCtrlPresentacion = pCtrlPresentacion;
		    inicializarComponentes();
	}
	
  public void inicializarComponentes() {
	  frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	       	  iCtrlPresentacion.sincronizacionGuardar_a_Principal();
	         }        
	      });
    frame.setSize(250, 100);
    System.out.println("part1\n");
	  JFileChooser c = new JFileChooser();
    int rVal = c.showSaveDialog(FileChooserTest.this);
    if (rVal == JFileChooser.APPROVE_OPTION) {
	  String s = c.getCurrentDirectory().toString();
	  s.concat("\"");
	  s += c.getSelectedFile().getName();
	  System.out.println(s);
	  iCtrlPresentacion.sincronizacionGuardar_a_Principal1(s);
    }
    if (rVal == JFileChooser.CANCEL_OPTION) {
      System.out.println("You pressed cancel\n");
  	  iCtrlPresentacion.sincronizacionGuardar_a_Principal();
    }
   
  }
} ///:~
