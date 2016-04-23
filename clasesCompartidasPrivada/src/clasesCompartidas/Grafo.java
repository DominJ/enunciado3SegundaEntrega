package clasesCompartidas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
			
			//Instanciamos papers
			conjunto = LeerFichero.crear_nodo_primitivo(0);
			this.papers = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),0);
			
			//Instanciamos autor
			conjunto = LeerFichero.crear_nodo_primitivo(1);
			this.authors = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),0);
			
			//Instanciamos conferences
			conjunto = LeerFichero.crear_nodo_primitivo(2);
			this.conferences = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),0);
			
			//Instanciamos terms
			conjunto = LeerFichero.crear_nodo_primitivo(3);
			this.therms = new ConjuntoNodos(conjunto.getFirst(),conjunto.getSecond(),0);
			
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
	
	private void leerDataSet()
	{
		
	}
	
	private void escribirDataSet()
	{
		
	}
	
	private void escribirRelaciones()
	{
		
	}
		
	public HashMap<Integer,ArrayList<Integer>> getRelaciones(String R)
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
		else if (rel.equals("PT")){
			return this.PT.consultar_PaperOther();
		}
		
	}
}
