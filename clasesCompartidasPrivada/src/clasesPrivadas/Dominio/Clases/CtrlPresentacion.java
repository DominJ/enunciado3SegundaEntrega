package clasesPrivadas.Dominio.Clases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import clasesCompartidas.Pair;
import clasesPrivadas.Dominio.Clases.CtrlDominio;
import excepciones.NonExistObjectToReadException;

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
	private vistaBH vistaBH = null;
	//private vistaGuardar vistaGuardar = null;
	private FileChooserTest FCT = null;
	private VistaBH1 Consult = null;
	private VistaF F = null;
	private vistaA vistaA = null;
	private vistaCP1 vistaCP1 = null;


	


	public void limpiarhistorial(){
		ctrlDominio.limpiarhistorialD();
	}

	
	public CtrlPresentacion() {
		 ctrlDominio = new CtrlDominio();
		 if (vistaA == null) {  // innecesario
			 vistaA = new vistaA(this);
		 }
		 vistaA.activar();
	}
	
	public void inicializarPresentacion(String ruta) throws ClassNotFoundException, NonExistObjectToReadException, IOException {
		ctrlDominio.inicializarCtrlDominio(ruta);
		System.out.println("CHIVATO");
		vistaPrincipal.activar();
	}
	
	
	//------------------------------------------------------------//

	public void sincronizacionCP1_a_BH1(String nodo, String camino,double b,double c) {
		vistaCP1.desactivar();
		ArrayList<Pair<Double,Integer>> aux = ctrlDominio.consultarresultadop(nodo,camino,b,c);
	    ArrayList<Pair<Double,String>> a = ctrlDominio.traducir(aux, camino);
	    if (Consult == null) {  // innecesario
			 Consult = new VistaBH1(this);
		 }
	    Consult.activar(a);
	}
	
	//------------------------------------------------------------//
	public void  sincronizacionA_a_Principal() throws ClassNotFoundException, NonExistObjectToReadException, IOException{
		if (vistaPrincipal == null) {  // innecesario
			 vistaPrincipal = new VistaPrincipal(this);
		 }
		vistaA.desactivar();
		String ruta = null;
		inicializarPresentacion(ruta);
	}
	
	public void  sincronizacionFCT_a_Principal1(String ruta) throws ClassNotFoundException, NonExistObjectToReadException, IOException{
		if (vistaPrincipal == null) {  // innecesario
			 vistaPrincipal = new VistaPrincipal(this);
		 }
		FCT.desactivar();
		inicializarPresentacion(ruta);
	}
	
	public void sincronizacionA_a_FCT() throws ClassNotFoundException, NonExistObjectToReadException {
		vistaA.desactivar();
	    if (FCT == null){
	    	FCT = new FileChooserTest(this,false);
	    }
	    FCT.activar();
	}
	
	
	//----------------------RC-A-Filtros--------------------------------------//

	public void sincronizacionF_a_CCN(Set<Integer >c) {
		System.out.println("Hola10");
		ctrlDominio.consultarcaminofiltros(c);
		System.out.println("Hola11");
		F.desactivar();
		System.out.println("Hola12");
		if (vistaCCN == null){
	    	vistaCCN = new VistaCCN(this);
		}
		vistaCCN.activar(false);
		System.out.println("Hola13");
	}


	//----------------------RC-A-Filtros--------------------------------------//

		
	public void sincronizacionRC_a_F() {
		vistaRC.desactivar();
	    if (F == null){
	    	F = new VistaF(this);
	    }
	    F.activar();
	}
	public void sincronizacionF_a_RC() {
		F.desactivar();
		vistaRC.activar();
	}

	
	//----------------------Principal-A-Guardar--------------------------------------//

	
	public void sincronizacionPrincipal_a_Guardar() throws ClassNotFoundException, NonExistObjectToReadException {
		vistaPrincipal.desactivar();
	    if (FCT == null){
	    	FCT = new FileChooserTest(this,true);
	    }
	    FCT.activar();
	  }
	
	public void sincronizacionGuardar_a_Principal1(String s) throws IOException {
		ctrlDominio.guardar(s);
		System.exit(0);
	}

	public void sincronizacionGuardar_a_Principal() {
		vistaPrincipal.activar();
		FCT.desactivar();
	}
	
	//----------------------BH-A-BH1--------------------------------------//

	
	public void sincronizacionBH_a_BH1(ArrayList<Pair<Double,String>> aux) {
		vistaBH.desactivar();
	    if (Consult == null){
	    	Consult = new VistaBH1(this);
	    }
	    Consult.activar(aux);
	  }
	

	public void sincronizacionBH1_a_BH() {
		Consult.desactivar();
		vistaBH.activar1();
	}
	
	//----------------------Principal-A-BH--------------------------------------//

	
		public void sincronizacionPrincipal_a_BH() {
			vistaPrincipal.desactivar();
		    if (vistaBH == null){
		    	vistaBH = new vistaBH(this);
		    }
		    HashMap<String, Set<String>> a = ctrlDominio.actualizarhistorial();
		    vistaBH.activar(a);
		    System.out.println("Hola!\n");
		  }
		
		public void sincronizacionBH_a_Principal1(String s) {
			int i = 0;
			while(!(Character.isWhitespace(s.charAt(i)))) {
	    		++i;
	    	}
			System.out.println(s);
			String nodo = s.substring(0,i);
			String camino = s.substring(i+1, s.length());
			System.out.println("CTRLPRESENTACION:"+nodo);
			System.out.println(camino);
			ArrayList<Pair<Double,Integer>> aux = ctrlDominio.consultarresultado(camino,nodo);
			ArrayList<Pair<Double,String>> aux1 = ctrlDominio.traducir(aux,nodo);
			sincronizacionBH_a_BH1(aux1);
		}

		public void sincronizacionBH_a_Principal() {
			 vistaBH.desactivar();
			 vistaPrincipal.activar();
			
		}
		
		//----------------------CCN-A-BH1--------------------------------------//

		public void sincronizacionCCN_a_BH1(ArrayList<Pair<Double,Integer>> aux,String camino) {
			vistaCCN.desactivar();
		    if (Consult == null){
		    	Consult = new VistaBH1(this);
		    }
		    ArrayList<Pair<Double,String>> a = ctrlDominio.traducir(aux, camino);
		    Consult.activar(a);
		  } 
		

		public void sincronizacionBH1_a_Principal() {
			Consult.desactivar();
			vistaPrincipal.activar();
		}
		
		
		
		
	//----------------------RC-A-CCN--------------------------------------//

	
	public void sincronizacionRC_a_CCN() {
		vistaRC.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaCCN == null){
	    	vistaCCN = new VistaCCN(this);
	    }
	    vistaCCN.activar(true);
	  }
	
	public void sincronizacionCCN_a_RC1(String nodo, String camino,double b,double c,Boolean as) {
		//System.out.println("Hola");
		//System.out.println(" "+camino);
		ctrlDominio.crearcaminonuevo(nodo,camino,b,c,as);
		//System.out.println("Hola3");
		ArrayList<Pair<Double,Integer>> aux = ctrlDominio.consultarresultado(nodo,camino);
		System.out.println("Hola4");
		sincronizacionCCN_a_BH1(aux,camino);
		System.out.println("Hola5");
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
	
	public void sincronizacionCP1_a_BH1(String nodo, String camino){
		ArrayList<Pair<Double,Integer>> aux = ctrlDominio.consultarresultado(nodo,camino);
		System.out.println("Hola4");
		sincronizacionCCN_a_BH1(aux,camino);
	}
	
	public void sincronizacionCP_a_CP1(String s) {
		vistaCP.desactivar();
	    // Solo se crea una vista secundaria (podria crearse una nueva cada vez)
	    if (vistaCP1 == null){
	    	vistaCP1 = new vistaCP1(this);
	    }
	    vistaCP1.activar(s);
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
		ctrlDominio.eliminarnodoD(options,n);
		sincronizacionEliminar_a_MBD();
	}

	public void sincronizacionEliminar_a_MBD() {
		 vistaEliminar.desactivar();
		 vistaMBD.activar();
		
	}

	//----------------------Anadir1-A-CD--------------------------------------//

	 public void sincronizacionCD_a_Anadir1() {
		 ctrlDominio.anadirconjuntodatos();
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
