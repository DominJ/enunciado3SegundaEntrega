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
	
	public RelacionesPri clone()
	{
		return this.clone();
	}
	
	public void normFilas(){
		for (int idi: paperOther.keySet()) {
			ArrayList<Pair<Integer,Double>> a=paperOther.get(idi);
			for (int idj=0; idj<a.size(); ++idj) {
				Pair<Integer,Double> p = a.get(idj);
				p.setSecond(1.0/a.size());
				a.set(idj,p);
			}
		}
		for (int idi: otherPaper.keySet()) {
			ArrayList<Pair<Integer,Double>> a=otherPaper.get(idi);
			for (int idj=0; idj<a.size(); ++idj) {
				Pair<Integer,Double> p = a.get(idj);
				p.setSecond(1.0/a.size());
				a.set(idj,p);
			}
		}
	}
	
	public void normColumnas(){
		for (int idi: paperOther.keySet()) {
			ArrayList<Pair<Integer,Double>> a=paperOther.get(idi);
			for (int idj=0; idj<a.size(); ++idj) {
				Pair<Integer,Double> p = a.get(idj);
				p.setSecond(1.0/otherPaper.get(idj).size());
				a.set(idj,p);
			}
		}
		for (int idi: otherPaper.keySet()) {
			ArrayList<Pair<Integer,Double>> a=otherPaper.get(idi);
			for (int idj=0; idj<a.size(); ++idj) {
				Pair<Integer,Double> p = a.get(idj);
				p.setSecond(1.0/paperOther.get(idj).size());
				a.set(idj,p);
			}
		}
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
