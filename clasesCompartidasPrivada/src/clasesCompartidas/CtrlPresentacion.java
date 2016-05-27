package clasesCompartidas;

import java.awt.event.ActionEvent;
import java.io.File;

import clasesPrivadas.Dominio.Clases.CtrlDominio;

public class CtrlPresentacion {
	private CtrlDominio ctrlDominio;
	private VistaPrincipal vistaPrincipal = null;
	private VistaMBD vistaMBD = null;
	private VistaAnadir1 vistaAnadir = null;
	private vistaDI vistaDI = null;
	//private vistaCD vistaCD = null;
	private VistaEliminar vistaEliminar = null;
	private VistaRC vistaRC = null;
	private VistaCP vistaCP = null;
	private VistaCCN vistaCCN = null;
	private FileSamplePanel a = null;
	//private VistaBH vistaBH = null;

	


	
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
	
	
	
	//----------------------RC-A-CCN--------------------------------------//

	
	public void sincronizacionRC_a_CCN() {
		vistaRC.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaCCN == null){
	    	vistaCCN = new VistaCCN(this);
	    }
	    vistaCCN.hacerVisible();
	  }
	
	public void sincronizacionCCN_a_RC1(String a, int b, int c) {
		//CtrlDominio.crearcaminonuevo(a,b,c);
		sincronizacionCCN_a_RC();	
	}
	
	public void sincronizacionCCN_a_RC() {
		 vistaCCN.hacerInvisible();
		 vistaRC.activar();
		
	}
	
	//----------------------RC-A-CP--------------------------------------//

	
	public void sincronizacionRC_a_CP() {
		vistaRC.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaCP == null){
	    	vistaCP = new VistaCP(this);
	    }
	    vistaCP.hacerVisible();
	  }
	
	public void sincronizacionCP_a_RC1(String s) {
		//CtrlDominio.caminopredeterminado(s);
		sincronizacionCP_a_RC();
	}

	
	public void sincronizacionCP_a_RC() {
		 vistaCP.hacerInvisible();
		 vistaRC.activar();
		
	}
	
	//----------------------VistaPrincipal-A-RC--------------------------------------//

	
	public void sincronizacionVistaPrincipal_a_RC() {
		vistaPrincipal.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaRC == null){
	    	vistaRC = new VistaRC(this);
	    }
	    vistaRC.hacerVisible();
	  }
	
	public void sincronizacionRC_a_VistaPrincipal() {
		 vistaRC.hacerInvisible();
		 vistaPrincipal.activar();
		
	}
	
	//----------------------VistaPrincipal-A-BH--------------------------------------//


	public void sincronizacionVistaPrincipal_a_BH(){
	  }
	
	public void sincronizacionBH_a_VistaPrincipal(int options, String n) {
		
		
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
		   if(a == null){
			   a = new FileSamplePanel(this);
		   }
		    a.activar();
	 }
	 
	 public void sincronizacionCD_a_Anadir11(String a) {
		 //iCtrlDominio.anadirconjunto(a);
		 sincronizacionCD_a_Anadir1();
	 }

	 
	 public void sincronizacionCD_a_Anadir1() {
		 a.desactivar();
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
