package clasesPrivadas.Dominio;

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
import clasesCompartidas.Relaciones;

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
	
	Relaciones PA;
	Relaciones PC;
	Relaciones PT;
	
	public Grafo()
	{
		//(0 = P, 1 = A, 2 = C, 3 = T)  
		//(1 = PA, 2 = PC, 3 = PT)  
		//No estoy seguro de lo que hace el ID libre
		try 
		{
			Pair<HashMap<Integer,String>,HashMap<String,Integer>> conjunto;
			Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> relacion;
			int idMax;
			
			//Instanciamos papers
			conjunto = LeerFichero.crear_nodo_primitivo(0);
			idMax = LeerFichero.idMax(conjunto.getFirst());
			this.papers = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),idMax);
			
			//Instanciamos autor
			conjunto = LeerFichero.crear_nodo_primitivo(1);
			idMax = LeerFichero.idMax(conjunto.getFirst());
			this.authors = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),idMax);
			
			//Instanciamos conferences
			conjunto = LeerFichero.crear_nodo_primitivo(2);
			idMax = LeerFichero.idMax(conjunto.getFirst());
			this.conferences = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),idMax);
			
			//Instanciamos terms
			conjunto = LeerFichero.crear_nodo_primitivo(3);
			idMax = LeerFichero.idMax(conjunto.getFirst());
			this.therms = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),idMax);
			
			//Instanciamos Relacion PA
			relacion = LeerFichero.crear_relacion(1);
			this.PA = new Relaciones(relacion.getFirst(),relacion.getSecond());
			
			//Instanciamos Relacion PC
			relacion = LeerFichero.crear_relacion(2);
			this.PC = new Relaciones(relacion.getFirst(),relacion.getSecond());
			
			//Instanciamos Relacion PT
			relacion = LeerFichero.crear_relacion(3);
			this.PT = new Relaciones(relacion.getFirst(),relacion.getSecond());
			
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
		EscribirFichero.ReescribirFicheroNodos(papers.getConjuntoEscritura(), 0);
		EscribirFichero.ReescribirFicheroNodos(authors.getConjuntoEscritura(), 1);
		EscribirFichero.ReescribirFicheroNodos(conferences.getConjuntoEscritura(), 2);
		EscribirFichero.ReescribirFicheroNodos(therms.getConjuntoEscritura(), 3);
	}
	
	private void escribirRelaciones()
	{
		//(0->PA  1->PC  2->PT)
		EscribirFichero.ReescribirFicheroRelaciones(PA.getRelacionesEscritura(), 0);
		EscribirFichero.ReescribirFicheroRelaciones(PC.getRelacionesEscritura(), 1);
		EscribirFichero.ReescribirFicheroRelaciones(PT.getRelacionesEscritura(), 2);
	}
		
	public HashMap<Integer,ArrayList<Integer>> getRelaciones(String rel)
	{
		if (rel.equals("AP")){
			return this.PA.consultar_OtherPaper();
		}
		else if (rel.equals("PA")){
			return this.PA.consultar_PaperOther();
		}
		else if (rel.equals("CP")){
			return this.PC.consultar_OtherPaper();
		}
		else if (rel.equals("PC")){
			return this.PC.consultar_PaperOther();
		}
		else if (rel.equals("TP")){
			return this.PT.consultar_OtherPaper();
		}
		/*else if (rel.equals("PT")){
			return this.PT.consultar_PaperOther();
		}*/
		else
		{
			return this.PT.consultar_PaperOther();
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
		ArrayList<Integer> conjunto;
		int tam;
		switch(type)
		{
			case 0	:	//--------------------
						conjunto = this.PA.consultar_RelacionPaper(id);
						System.out.println("papers" + conjunto);
						tam = conjunto.size();
						for(int i=0; i< tam; i++)
						{
							this.PA.eliminar_PaperOther(id, conjunto.get(0));
						}
						
						conjunto = this.PC.consultar_RelacionPaper(id);
						if(conjunto != null)
						{
							tam = conjunto.size();
							for(int i=0; i< tam; i++)
							{
								this.PC.eliminar_PaperOther(id, conjunto.get(0));
							}
						}
						
						conjunto = this.PT.consultar_RelacionPaper(id);
						tam = conjunto.size();
						for(int i=0; i< tam; i++)
						{
							this.PT.eliminar_PaperOther(id, conjunto.get(0));
						}
						
						this.papers.eliminar_nodo(id);
						//--------------------
						break;
			
			case 1	:	//--------------------
						conjunto = this.PA.consultar_RelacionOther(id);
						tam = conjunto.size();
						for(int i=0; i< tam; i++)
						{
							this.PA.eliminar_PaperOther(conjunto.get(0), id);
						}
						this.authors.eliminar_nodo(id);
						//--------------------
						break;
			 
			case 2	:	//--------------------
						conjunto = this.PC.consultar_RelacionOther(id);
						tam = conjunto.size();
						for(int i=0; i< tam; i++)
						{
							this.PC.eliminar_PaperOther(conjunto.get(0), id);
						}
						this.conferences.eliminar_nodo(id);
						this.PC.pinta_matriz();
						//--------------------
						break;
			
			default	:	//--------------------
						conjunto = this.PT.consultar_RelacionOther(id);
						tam = conjunto.size();
						for(int i=0; i< tam; i++)
						{
							this.PT.eliminar_PaperOther(conjunto.get(0), id);
						}
						this.therms.eliminar_nodo(id);
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
