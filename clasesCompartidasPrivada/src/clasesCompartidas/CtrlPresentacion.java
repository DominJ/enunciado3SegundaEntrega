package clasesCompartidas;

import clasesPrivadas.Dominio.Clases.CtrlDominio;

public class CtrlPresentacion {
	private CtrlDominio ctrlDominio;
	private VistaPrincipal vistaPrincipal = null;
	private VistaSecundaria vistaSecundaria = null;

	
	public CtrlPresentacion() {
		ctrlDominio = new CtrlDominio();
		vistaPrincipal = new VistaPrincipal();
	}
	public void inicializarPresentacion() {
		vistaPrincipal.inicializarComponentes();
		vistaPrincipal.hacerVisible();
	}
	
}
