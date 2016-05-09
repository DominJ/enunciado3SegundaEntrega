package clasesPrivadas.Dominio.Clases;

import java.util.ArrayList;
import java.util.HashMap;

import clasesCompartidas.Pair;
import clasesCompartidas.Relaciones;

public class RelacionesPri extends Relaciones 
{
	public RelacionesPri()
	{
		super();
		//contructor por defecto
		//paperOther = new HashMap<Integer, ArrayList<Integer>>();
		//otherPaper = new HashMap<Integer, ArrayList<Integer>>();
	}
	
	public RelacionesPri(HashMap<Integer, ArrayList<Pair<Integer,Double>>> relacionesIda, HashMap<Integer, ArrayList<Pair<Integer,Double>>> relacionesVuelta)
	{
		super(relacionesIda, relacionesVuelta);
		//this.paperOther = relacionesIda;
		//this.otherPaper = relacionesVuelta;
	}
	
	/*public RelacionesPri clone()
	{
		RelacionesPri c = new RelacionesPri();
		c.otherPaper = this.otherPaper.clone();
		
		
	}*/
	
	public void normFilas(){
		
	}
	
	public void normColumnas(){
		
	}
	
	public void pinta_matriz() {
		System.out.println("Relacion PaperOther:\n");
		HashMap<Integer, ArrayList<Pair<Integer, Double>>> a=this.paperOther;
		for (int i: a.keySet()) {
			ArrayList<Pair<Integer, Double>> l= a.get(i);
			System.out.print(i +": ");
			for(int j=0; j<l.size(); ++j) {
				Pair<Integer, Double> n = l.get(j);
				System.out.print(n +" "); 
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("Relacion OtherPaper:\n");
		a=this.otherPaper;
		for (int i: a.keySet()) {
			ArrayList<Pair<Integer, Double>> l= a.get(i);
			System.out.print(i +": ");
			for(int j=0; j<l.size(); ++j) {
				Pair<Integer, Double> n = l.get(j);
				System.out.print(n +" "); 
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public HashMap<Integer, ArrayList<Pair<Integer, Double>>> getRelacionesEscritura()
	{
		return paperOther;
	}
}
