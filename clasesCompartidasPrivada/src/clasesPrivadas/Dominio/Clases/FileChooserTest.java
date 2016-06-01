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
	private Boolean ag;
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
	 
	public void SetBooleano(Boolean a){
		ag = a;
	}
	public FileChooserTest(CtrlPresentacion pCtrlPresentacion, Boolean x) throws ClassNotFoundException, NonExistObjectToReadException {
		    iCtrlPresentacion = pCtrlPresentacion;
		    ag = x;
		    inicializarComponentes();
	}
	
  public void inicializarComponentes() throws ClassNotFoundException, NonExistObjectToReadException {
	  frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 System.exit(0);
	         }        
	      });
    frame.setSize(250, 100);
    int rVal = c.showSaveDialog(FileChooserTest.this);
    if (rVal == JFileChooser.APPROVE_OPTION) {
	  String s = c.getCurrentDirectory().toString();
	  s += "\\";
	  s += c.getSelectedFile().getName();
	  try {
		  if(!ag){
			  	desactivar();
				iCtrlPresentacion.sincronizacionFCT_a_Principal1(s);
				ag = true;
		  }
		  else iCtrlPresentacion.sincronizacionGuardar_a_Principal1(s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Se ha producido un error en la seleccion de fichero.");
	}
    }
    if (rVal == JFileChooser.CANCEL_OPTION) {
      	System.exit(0);
    }
   
  }
} 
