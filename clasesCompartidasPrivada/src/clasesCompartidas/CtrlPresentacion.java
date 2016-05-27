package clasesCompartidas;
import java.util.HashMap;
import java.util.Set;

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
	private vistaBH vistaBH = null;

	


	
	public CtrlPresentacion() {
		 ctrlDominio = new CtrlDominio();
		 if (vistaPrincipal == null) {  // innecesario
			 vistaPrincipal = new VistaPrincipal(this);
		 }
	}
	
	public void inicializarPresentacion() {
		//ctrlDominio.inicializarCtrlDominio();
		vistaPrincipal.activar();
	}
	
	
	
	//----------------------Principal-A-BH--------------------------------------//

	
		public void sincronizacionPrincipal_a_BH() {
			vistaPrincipal.desactivar();
		    if (vistaBH == null){
		    	vistaBH = new vistaBH(this);
		    }
		    HashMap<String, Set<Integer>> a = ctrlDominio.actualizarhistorial();
		    vistaBH.activar(a);
		    System.out.println("Hola!\n");
		  }
		
		
		public void sincronizacionBH_a_Principal1(String s) {
			//ctrlDominio.caminopredeterminado(s);
			sincronizacionBH_a_Principal();
		}

		
		public void sincronizacionBH_a_Principal() {
			 vistaBH.desactivar();
			 vistaPrincipal.activar();
			
		}
		
	
	//----------------------RC-A-CCN--------------------------------------//

	
	public void sincronizacionRC_a_CCN() {
		vistaRC.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaCCN == null){
	    	vistaCCN = new VistaCCN(this);
	    }
	    vistaCCN.activar();
	  }
	
	public void sincronizacionCCN_a_RC1(String a, int b, int c) {
		//CtrlDominio.crearcaminonuevo(a,b,c);
		sincronizacionCCN_a_RC();	
	}
	
	public void sincronizacionCCN_a_RC() {
		 vistaCCN.desactivar();
		 vistaRC.activar();
		
	}
	
	//----------------------RC-A-CP--------------------------------------//

	
	public void sincronizacionRC_a_CP() {
		vistaRC.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaCP == null){
	    	vistaCP = new VistaCP(this);
	    }
	    vistaCP.activar();
	  }
	
	public void sincronizacionCP_a_RC1(String s) {
		ctrlDominio.caminopredeterminado(s);
		sincronizacionCP_a_RC();
	}

	
	public void sincronizacionCP_a_RC() {
		 vistaCP.desactivar();
		 vistaRC.activar();
		
	}
	
	//----------------------VistaPrincipal-A-RC--------------------------------------//

	
	public void sincronizacionVistaPrincipal_a_RC() {
		vistaPrincipal.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaRC == null){
	    	vistaRC = new VistaRC(this);
	    }
	    vistaRC.activar();
	  }
	
	public void sincronizacionRC_a_VistaPrincipal() {
		 vistaRC.desactivar();
		 vistaPrincipal.activar();
		
	}
	
	
	//----------------------MBD-A-Eliminar--------------------------------------//

	public void sincronizacionMBD_a_Eliminar(){
		vistaMBD.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaEliminar == null){
	    	vistaEliminar = new VistaEliminar(this);
	    }
	    vistaEliminar.activar();
	}
	
	public void sincronizacionEliminar_a_MBD1(int options, String n) {
		//ctrlDominio.eliminarnodoD(options,n);
		sincronizacionEliminar_a_MBD();
	}

	public void sincronizacionEliminar_a_MBD() {
		 vistaEliminar.desactivar();
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
		    vistaDI.activar();
		 
	 }
	 
	 public void sincronizacionDI_a_Anadir11(String a1, String b, String c1, String d){
		int a,c;
		if (a1 == "Paper") a = 0;
		else if(a1 == "Author") a = 1;
		else if (a1 == "Conference")a = 2;
		else a = 3;
		if (c1 == "Paper") c = 0;
		else if(c1 == "Author") c = 1;
		else if (c1 == "Conference")c = 2;
		else c = 3;
		 ctrlDominio.anadirnodoD(a, b, c, d);
		 sincronizacionDI_a_Anadir1();
	 }
	 
	 public void sincronizacionDI_a_Anadir1() {
		    // Se hace invisible la vista secundaria (podria anularse)
		    vistaDI.desactivar();
		    vistaAnadir.activar();
		  }

		//----------------------MBD-A-ANADIR1--------------------------------------//

	public void sincronizacionMBD_a_Anadir1() {
		vistaMBD.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaAnadir == null){
	    	vistaAnadir = new VistaAnadir1(this);
	    }
	    vistaAnadir.activar();
	}
	  public void sincronizacionAnadir1_a_MBD() {
		    // Se hace invisible la vista secundaria (podria anularse)
		    vistaAnadir.desactivar();
		    vistaMBD.activar();
		  }

		//----------------------VistaPrincipal-A-MBD--------------------------------------//

	  public void sincronizacionVistaPrincipal_a_MBD() {
	    vistaPrincipal.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaMBD == null)
	    	vistaMBD = new VistaMBD(this);
	    vistaMBD.activar();
	  }

	  public void sincronizacionMBD_a_Principal() {
	    // Se hace invisible la vista secundaria (podria anularse)
	    vistaMBD.desactivar();
	    vistaPrincipal.activar();
	  }
	
}
