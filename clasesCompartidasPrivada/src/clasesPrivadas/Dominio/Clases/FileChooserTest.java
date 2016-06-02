package clasesPrivadas.Dominio.Clases;

/**
 * @author Daniel Pulido
 *
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import excepciones.NonExistObjectToReadException;


public class FileChooserTest extends JFrame {
	private CtrlPresentacion iCtrlPresentacion;
	private JFrame frame = new JFrame();
	//ag false abrimos programa ag true guardamos al cerrar programa
	  JFileChooser c = new JFileChooser();


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
	 
	
	public FileChooserTest(CtrlPresentacion pCtrlPresentacion) throws ClassNotFoundException, NonExistObjectToReadException {
		    iCtrlPresentacion = pCtrlPresentacion;
		    inicializarComponentes();
	}
	
  public void inicializarComponentes() throws ClassNotFoundException, NonExistObjectToReadException {
	  frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        		try {
						iCtrlPresentacion.sincronizacionSalir_a_Principal1();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	         }        
	      });
    frame.setSize(250, 100);
    int rVal = c.showSaveDialog(FileChooserTest.this);
    if (rVal == JFileChooser.APPROVE_OPTION) {
	  String s = c.getCurrentDirectory().toString();
	  s += System.getProperty("file.separator");
	  s += c.getSelectedFile().getName();
	  try {
		 iCtrlPresentacion.sincronizacionExportar_a_Principal1(s);
	} catch (IOException e) {
		System.out.println("Se ha producido un error en la seleccion de fichero.");
	}
    }
    if (rVal == JFileChooser.CANCEL_OPTION) {
    	try {
			iCtrlPresentacion.sincronizacionSalir_a_Principal1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
  }
} 
