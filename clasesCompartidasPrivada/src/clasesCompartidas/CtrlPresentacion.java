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
	private VistaEliminar vistaEliminar = null;

	


	
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
	
	//----------------------MBD-A-Eliminar--------------------------------------//

	public void sincronizacionMBD_a_Eliminar(){
		vistaMBD.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaEliminar == null){
	    	vistaEliminar = new VistaEliminar(this);
	    }
	    vistaEliminar.hacerVisible();
	}
	public void sincronizacionEliminar_a_MBD(int options, String n) {
		ctrlDominio.eliminarnodoD(options,n);
		 vistaEliminar.hacerInvisible();
		 vistaMBD.activar();
		
	}


	
	//----------------------Anadir1-A-CD--------------------------------------//
	 public void sincronizacionAnadir1_a_CD() {
		 vistaAnadir.desactivar();
		    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
		    if (vistaCD == null){
		    	vistaCD = new vistaCD(this);
		    }
		    vistaCD.hacerVisible();
		 
	 }
	 
	 public void sincronizacionCD_a_Anadir1() {
		 vistaCD.hacerInvisible();
		 vistaAnadir.activar();
		 
	 }
	
		//----------------------Anadir1-A-DI--------------------------------------//

	 public void sincronizacionAnadir1_a_DI() {
		 vistaAnadir.desactivar();
		    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
		    if (vistaDI == null){
		    	vistaDI = new vistaDI(this);
		    }
		    vistaDI.hacerVisible();
		 
	 }
	 
	 public void sincronizacionDI_a_Anadir1() {
		    // Se hace invisible la vista secundaria (podria anularse)
		    vistaDI.hacerInvisible();
		    vistaAnadir.activar();
		  }

		//----------------------MBD-A-ANADIR1--------------------------------------//

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

		//----------------------VistaPrincipal-A-MBD--------------------------------------//

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
	    vistaPrincipal.inicializarComponentes();
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
