package clasesCompartidas;

import java.awt.event.ActionEvent;

import clasesPrivadas.Dominio.Clases.CtrlDominio;

public class CtrlPresentacion {
	private CtrlDominio ctrlDominio;
	private VistaPrincipal vistaPrincipal = null;
	private VistaMBD vistaMBD = null;
	private VistaAnadir1 vistaAnadir = null;
	private vistaDI vistaDI = null;
	private vistaCD vistaCD = null;


	
	public CtrlPresentacion() {
		 ctrlDominio = new CtrlDominio();
		 if (vistaPrincipal == null) {  // innecesario
			 vistaPrincipal = new VistaPrincipal(this);
		 }
	}
	
	public void inicializarPresentacion() {
		//ctrlDominio.inicializarCtrlDominio();
		vistaPrincipal.hacerVisible();
	}
	
	 public void sincronizacionAnadir1_a_CD() {
		 vistaAnadir.desactivar();
		    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
		    if (vistaCD == null){
		    	vistaCD = new vistaCD(this);
		    }
		    vistaCD.hacerVisible();
		 
	 }
	
	 public void sincronizacionAnadir1_a_DI() {
		 vistaAnadir.desactivar();
		    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
		    if (vistaDI == null){
		    	vistaDI = new vistaDI(this);
		    }
		    vistaDI.hacerVisible();
		 
	 }
	 
	 public void sincronizacionDI_a_Anadir() {
		    // Se hace invisible la vista secundaria (podria anularse)
		    vistaDI.hacerInvisible();
		    vistaAnadir.activar();
		  }

	public void sincronizacionMBD_a_Anadir1() {
		vistaMBD.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaAnadir == null){
	    	vistaAnadir = new VistaAnadir1(this);
	    }
	    vistaAnadir.hacerVisible();
	}
	  public void sincronizacionAnadir1_a_MBD() {
		    // Se hace invisible la vista secundaria (podria anularse)
		    vistaAnadir.hacerInvisible();
		    vistaMBD.activar();
		  }

	  public void sincronizacionVistaPrincipal_a_MBD() {
	    vistaPrincipal.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaMBD == null)
	    	vistaMBD = new VistaMBD(this);
	    vistaMBD.hacerVisible();
	  }

	  public void sincronizacionMBD_a_Principal() {
	    // Se hace invisible la vista secundaria (podria anularse)
	    vistaMBD.hacerInvisible();
	    vistaPrincipal.activar();
	  }

	
	
	
	public void anadirnodo(String s, String n) {
		ctrlDominio.anadirnododominio(s,n);
	}
	
	/* 
	public void actionPerformed_buttonA(ActionEvent event) {
		vA.actionPerformed_buttonA(event);
	}
*/
	
}
