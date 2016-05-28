package clasesPrivadas.Dominio.Clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
author: 
*/
import clasesCompartidas.ConjuntoNodos;
import clasesCompartidas.EscribirFichero;
import clasesCompartidas.LeerFichero;
import clasesCompartidas.Pair;


/**
 * @author Domingo Jes�s de la Mata Garcia
 *
 */
public class Grafo 
{
	static final String RUTA_INICIAL = "Set1";
	static final String RUTA_ADD = "AddData";
	static final String FILTROS = "Filtros";
	
	ConjuntoNodos authors;
	ConjuntoNodos therms;
	ConjuntoNodos conferences;
	ConjuntoNodos papers;
	
	RelacionesPri PAF;
	RelacionesPri PAC;
	RelacionesPri PCF;
	RelacionesPri PCC;
	RelacionesPri PTF;
	RelacionesPri PTC;
	
	public Grafo()
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)  
		//(1 = PA, 2 = PC, 3 = PT)  
		//No estoy seguro de lo que hace el ID libre
		try 
		{
			Pair<HashMap<Integer,String>,HashMap<String,Integer>> conjunto;
			Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> relacion;
			
			//Instanciamos papers
			conjunto = LeerFichero.crear_nodo_primitivo(RUTA_INICIAL, 0);
			
			this.papers = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos autor
			conjunto = LeerFichero.crear_nodo_primitivo(RUTA_INICIAL, 1);
			
			this.authors = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos conferences
			conjunto = LeerFichero.crear_nodo_primitivo(RUTA_INICIAL, 2);
			
			this.conferences = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos terms
			conjunto = LeerFichero.crear_nodo_primitivo(RUTA_INICIAL, 3);
			
			this.therms = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos Relacion PA
			relacion = LeerFichero.crear_relacion(RUTA_INICIAL, 1);
			//Debemos encontrar una forma mejor de hacer esto
			this.PAF = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			relacion = LeerFichero.crear_relacion(RUTA_INICIAL, 1);
			this.PAC = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			//this.PAC = (RelacionesPri)PAF.clone();
			//this.PAC = new RelacionesPri(PAF);
			
			//Creo que es SUPER ineficiente
			this.PAF.ordenarArray();
			this.PAC.ordenarArray();
			
			this.PAF.normFilas();
			this.PAC.normColumnas();
			
			
			//Instanciamos Relacion PC
			relacion = LeerFichero.crear_relacion(RUTA_INICIAL, 2);
			this.PCF = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			relacion = LeerFichero.crear_relacion(RUTA_INICIAL, 2);
			this.PCC = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			//this.PCC = (RelacionesPri)PAF.clone();
			//this.PCC = new RelacionesPri(PAF);
			
			//Creo que es SUPER ineficiente
			this.PCF.ordenarArray();
			this.PCC.ordenarArray();
			
			this.PCF.normFilas();
			this.PCC.normColumnas();
			
			//Instanciamos Relacion PT
			relacion = LeerFichero.crear_relacion(RUTA_INICIAL, 3);
			this.PTF = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			relacion = LeerFichero.crear_relacion(RUTA_INICIAL, 3);
			this.PTC = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			//this.PTC = (RelacionesPri)PAF.clone();
			//this.PTC = new RelacionesPri(PAF);
			
			//Creo que es SUPER ineficiente
			this.PTF.ordenarArray();
			this.PTC.ordenarArray();
			
			this.PTF.normFilas();
			this.PTC.normColumnas();
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Grafo(Grafo g, Set<Integer> s) {
		/*s es un set que determina los filtros que se han seleccionado.
		  Contiene un conjunto de numeros entre 0 y 3 donde :
			0 - papers
			1 - authors
			2 - conferences
			3 - therms 
			*/
		try{
			//Instanciamos los nodos
			
			Set<Integer> a=new HashSet<Integer>();
			//Generamos un set con los numeros de 0 a 3
			for (int i=0; i<4; ++i){
				a.add(i);
			}
			//Tratamos primero el set de flitros
			for (int i:s){
				Set<String> r=LeerFichero.LeerFiltro(FILTROS, i);
				HashMap<Integer, String> h1 = new HashMap<Integer, String>();
				HashMap<String, Integer> h2 = new HashMap<String, Integer>();
				for (String n:r){
					h1.put(consultarNodo(i, n), n);
					h2.put(n, consultarNodo(i, n));
				}
				if (i==0) {
					this.papers=new ConjuntoNodos(h1, h2);
				}
				else if (i==1){
					this.authors=new ConjuntoNodos(h1,h2);
				}
				else if (i==2){
					this.conferences=new ConjuntoNodos(h1,h2);
				}
				else{
					this.therms=new ConjuntoNodos(h1,h2);
				}
				//Quitamos del set los casos tratados
				a.remove(i);
			}
			//El resto de casos sin tratar, los cogemos del grafo g
			for(int i:a){
				if (i==0) {
					this.papers=g.papers;
				}
				else if (i==1){
					this.authors=g.authors;
				}
				else if (i==2){
					this.conferences=g.conferences;
				}
				else{
					this.therms=g.therms;
				}
			}
			//Queda instanciar las relaciones. To be continued.
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void escribirDataSet()
	{
		//(0->P  1->A  2->C 3->T)
		EscribirFichero.ReescribirFicheroNodos(papers.devolver_conjunto(), 0);
		EscribirFichero.ReescribirFicheroNodos(authors.devolver_conjunto(), 1);
		EscribirFichero.ReescribirFicheroNodos(conferences.devolver_conjunto(), 2);
		EscribirFichero.ReescribirFicheroNodos(therms.devolver_conjunto(), 3);
	}
	
	private void escribirRelaciones()
	{
		//(0->PA  1->PC  2->PT)
		EscribirFichero.ReescribirFicheroRelaciones(PAF.getRelacionesEscritura(), 0);
		EscribirFichero.ReescribirFicheroRelaciones(PCF.getRelacionesEscritura(), 1);
		EscribirFichero.ReescribirFicheroRelaciones(PTF.getRelacionesEscritura(), 2);
	}
		
	//TODO
	//Hay que modificar implementacion
	//b indica si devuelve la matriz normalizada por filas o por columnas
	//b = true -> filas
	//b = false -> columnas
	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> getRelaciones(String rel, boolean b)
	{
		if (rel.equals("AP")){
			if (b) return this.PAF.consultar_OtherPaper();
			else return this.PAC.consultar_OtherPaper();
		}
		else if (rel.equals("PA")){
			if(b) return this.PAF.consultar_PaperOther();
			else return this.PAC.consultar_PaperOther();
		}
		else if (rel.equals("CP")){
			if (b) return this.PCF.consultar_OtherPaper();
			else return this.PCC.consultar_OtherPaper();
		}
		else if (rel.equals("PC")){
			if(b) return this.PCF.consultar_PaperOther();
			else return this.PCC.consultar_PaperOther();
		}
		else if (rel.equals("TP")){
			if (b) return this.PTF.consultar_OtherPaper();
			else return this.PTC.consultar_OtherPaper();
		}
		else
		{
			if(b) return this.PTF.consultar_PaperOther();
			else return this.PTC.consultar_PaperOther();
		}
	}
	
	public void anadirNodo(Integer type, String name)
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)
		switch(type)
		{
			case 0	:	this.papers.anadir_nodo(name);
						break;
			
			case 1	:	this.authors.anadir_nodo(name);
						break;
			
			case 2	:	this.conferences.anadir_nodo(name);
						break;
			
			case 3	:	this.therms.anadir_nodo(name);
						break;
		}
	}
	
	public int consultarNodo(String name, int type)
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)
				switch(type)
				{
					case 0	:	return this.papers.consultar_nodo(name);
					
					case 1	:	return this.authors.consultar_nodo(name);
					
					case 2	:	return this.conferences.consultar_nodo(name);
					
					case 3	:	return this.therms.consultar_nodo(name);
				}
				return 0;
	}
	
	public void anadirRelacion(int a, int b, int tipo)
	{
		 //(1 = PA, 2 = PC, 3 = PT)
		switch(tipo)
		{
			case 1	:	this.PAF.anadir_PaperOther(a, b);
						this.PAC.anadir_PaperOther(a, b);
						this.PAF.ordenarArray();
						this.PAC.ordenarArray();
						this.PAF.normFilas();
						this.PAC.normColumnas();
						break;
			
			case 2	:	this.PCF.anadir_PaperOther(a, b);
						this.PCC.anadir_PaperOther(a, b);
						this.PCF.ordenarArray();
						this.PCC.ordenarArray();
						this.PCF.normFilas();
						this.PCC.normColumnas();
						break;
			
			case 3	:	this.PTF.anadir_PaperOther(a, b);
						this.PTC.anadir_PaperOther(a, b);
						this.PTF.ordenarArray();
						this.PTC.ordenarArray();
						this.PTF.normFilas();
						this.PTC.normColumnas();
						break;
		}
	}
	
	public int consultarNodo(int type, String name)
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)
		switch(type)
		{
			case 0	:	return this.papers.consultar_nodo(name);
			
			case 1	:	return this.authors.consultar_nodo(name);
			
			case 2	:	return this.conferences.consultar_nodo(name);
			
			default	:	return this.therms.consultar_nodo(name);
		}
	}
	
	public String consultarNodo(int type, int id)
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)
		switch(type)
		{
			case 0	:	return this.papers.consultar_nodo(id);
			
			case 1	:	return this.authors.consultar_nodo(id);
			
			case 2	:	return this.conferences.consultar_nodo(id);
			
			default	:	return this.therms.consultar_nodo(id);
		}
	}
	
	public void eliminarNodo(int type, int id) throws NullPointerException
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)
		ArrayList<Pair<Integer,Double>> conjunto;
		int tam;
		switch(type)
		{
			case 0	:	//--------------------
						conjunto = this.PAF.consultar_RelacionPaper(id);
						//System.out.println("papers" + conjunto);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PAF.eliminar_PaperOther(id, conjunto.get(0).getFirst());
								this.PAC.eliminar_PaperOther(id, conjunto.get(0).getFirst());
							}
						}
						
						//TODO
						//REVISAR
						conjunto = this.PCF.consultar_RelacionPaper(id);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PCF.eliminar_PaperOther(id, conjunto.get(0).getFirst());
								this.PCC.eliminar_PaperOther(id, conjunto.get(0).getFirst());
							}
						}
						
						conjunto = this.PTF.consultar_RelacionPaper(id);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PTF.eliminar_PaperOther(id, conjunto.get(0).getFirst());
								this.PTC.eliminar_PaperOther(id, conjunto.get(0).getFirst());
							}
						}
						//TODO
						//REVISAR
						this.papers.eliminar_nodo(Integer.toString(id));
						
						//--------------------
						break;
			
			case 1	:	//--------------------
						conjunto = this.PAF.consultar_RelacionOther(id);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PAF.eliminar_PaperOther(conjunto.get(0).getFirst(), id);
								this.PAC.eliminar_PaperOther(conjunto.get(0).getFirst(), id);
							}
						}
						this.authors.eliminar_nodo(Integer.toString(id));
						//--------------------
						break;
			 
			case 2	:	//--------------------
						conjunto = this.PCF.consultar_RelacionOther(id);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PCF.eliminar_PaperOther(conjunto.get(0).getFirst(), id);
								this.PCC.eliminar_PaperOther(conjunto.get(0).getFirst(), id);
							}
						}
						this.conferences.eliminar_nodo(Integer.toString(id));
						this.PCF.pinta_matriz();
						//--------------------
						break;
			
			default	:	//--------------------
						conjunto = this.PTF.consultar_RelacionOther(id);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PTF.eliminar_PaperOther(conjunto.get(0).getFirst(), id);
								this.PTC.eliminar_PaperOther(conjunto.get(0).getFirst(), id);
							}
						}
						this.therms.eliminar_nodo(Integer.toString(id));
						//--------------------
						break;
		}
	}
	public void escribirDatos()
	{
		this.escribirDataSet();
		this.escribirRelaciones();
	}
	
	//Creo innecesario el throw
	//public void addDataGraph() throws FileNotFoundException
	public void addDataGraph()
	{
		// ruta definidia -> /AddData
		// Comprobar existencia de los ficheros
		//unir hashmaps con hashmap.putall(hashmap)
		try
		{
			LeerFichero.correcto(RUTA_ADD, RUTA_INICIAL);
			
			//(0 = P, 1 = A, 2 = C, 3 = T)  
			this.papers.joinHashMap(LeerFichero.crear_nodo_primitivo(RUTA_ADD, 0));
			this.authors.joinHashMap(LeerFichero.crear_nodo_primitivo(RUTA_ADD, 1));
			this.conferences.joinHashMap(LeerFichero.crear_nodo_primitivo(RUTA_ADD, 2));
			this.therms.joinHashMap(LeerFichero.crear_nodo_primitivo(RUTA_ADD, 3));
			
			//HAY QUE HABLAR CON PAU EL TEMA DE LAS NOMALIZACIONES
			//SOY CONSCIENTE DE QUE NO ES EFICIENTE PERO CON LE TIEMPO QUE TENEMOS VAMOS A CENTRARNOS EN TERMINAR Y LUEGO OPTIMIZAMOS
			//(1 = PA, 2 = PC, 3 = PT)  
			this.PAF.joinHashMap(LeerFichero.crear_relacion(RUTA_ADD, 1));
			this.PAC.joinHashMap(LeerFichero.crear_relacion(RUTA_ADD, 1));
			this.PAF.ordenarArray();
			this.PAC.ordenarArray();
			this.PAF.normFilas();
			this.PAC.normColumnas();
			
			this.PCF.joinHashMap(LeerFichero.crear_relacion(RUTA_ADD, 2));
			this.PCC.joinHashMap(LeerFichero.crear_relacion(RUTA_ADD, 2));
			this.PCF.ordenarArray();
			this.PCC.ordenarArray();
			this.PCF.normFilas();
			this.PCC.normColumnas();
			
			this.PTF.joinHashMap(LeerFichero.crear_relacion(RUTA_ADD, 3));
			this.PTC.joinHashMap(LeerFichero.crear_relacion(RUTA_ADD, 3));
			this.PTF.ordenarArray();
			this.PTC.ordenarArray();
			this.PTF.normFilas();
			this.PTC.normColumnas();
			
		}
		catch(Exception e)
		{
			System.out.println("Se ha producido un problema ");
		}
	}
}
