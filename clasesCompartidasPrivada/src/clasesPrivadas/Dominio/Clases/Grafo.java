package clasesPrivadas.Dominio.Clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
			conjunto = LeerFichero.crear_nodo_primitivo(0);
			
			this.papers = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos autor
			conjunto = LeerFichero.crear_nodo_primitivo(1);
			
			this.authors = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos conferences
			conjunto = LeerFichero.crear_nodo_primitivo(2);
			
			this.conferences = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos terms
			conjunto = LeerFichero.crear_nodo_primitivo(3);
			
			this.therms = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond());
			
			//Instanciamos Relacion PA
			relacion = LeerFichero.crear_relacion(1);
			//Debemos encontrar una forma mejor de hacer esto
			this.PAF = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			relacion = LeerFichero.crear_relacion(1);
			this.PAC = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			//this.PAC = (RelacionesPri)PAF.clone();
			//this.PAC = new RelacionesPri(PAF);
			this.PAF.normFilas();
			this.PAC.normColumnas();
			
			
			//Instanciamos Relacion PC
			relacion = LeerFichero.crear_relacion(2);
			this.PCF = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			relacion = LeerFichero.crear_relacion(2);
			this.PCC = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			//this.PCC = (RelacionesPri)PAF.clone();
			//this.PCC = new RelacionesPri(PAF);
			this.PCF.normFilas();
			this.PCC.normColumnas();
			
			//Instanciamos Relacion PT
			relacion = LeerFichero.crear_relacion(3);
			this.PTF = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			relacion = LeerFichero.crear_relacion(3);
			this.PTC = new RelacionesPri(relacion.getFirst(),relacion.getSecond());
			//this.PTC = (RelacionesPri)PAF.clone();
			//this.PTC = new RelacionesPri(PAF);
			this.PTF.normFilas();
			this.PTC.normColumnas();
			
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
}
