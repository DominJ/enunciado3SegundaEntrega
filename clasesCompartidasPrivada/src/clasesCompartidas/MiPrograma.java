package clasesCompartidas;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class MiPrograma {
	public static void main (String[] args) {
		javax.swing.SwingUtilities.invokeLater (new Runnable() {
			public void run() {
					CtrlPresentacion ctrlPresentacion = new CtrlPresentacion();
					ctrlPresentacion.inicializarPresentacion();
			}
		});
	}
}


