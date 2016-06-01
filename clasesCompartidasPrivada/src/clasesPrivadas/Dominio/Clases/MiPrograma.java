package clasesPrivadas.Dominio.Clases;
import java.io.IOException;

import clasesPrivadas.Dominio.Clases.*;
import excepciones.NonExistObjectToReadException;

/**
 * @author Xavi Campos Navarro
 *
 */
public class MiPrograma {
	public static void main (String[] args) {
		javax.swing.SwingUtilities.invokeLater (new Runnable() {
			public void run() {
				CtrlPresentacion ctrlPresentacion = new CtrlPresentacion();
				try {
					ctrlPresentacion.inicializarPresentacion();
				} catch (ClassNotFoundException | NonExistObjectToReadException | IOException e) {
					e.printStackTrace();
				}				
			} 
		});
	} 
}





