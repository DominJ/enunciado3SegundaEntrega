package clasesCompartidas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;



public class Relaciones 
{
	private HashMap<Integer,ArrayList<Integer>> paperOther;
	private HashMap<Integer,ArrayList<Integer>> otherPaper;
	
	public Relaciones()
	{
		//contructor por defecto
		paperOther = new HashMap<Integer, ArrayList<Integer>>();
		otherPaper = new HashMap<Integer, ArrayList<Integer>>();
	}
	
	public Relaciones(HashMap<Integer, ArrayList<Integer>> relacionesIda, HashMap<Integer, ArrayList<Integer>> relacionesVuelta)
	{
		this.paperOther = relacionesIda;
		this.otherPaper = relacionesVuelta;
	}
	
	//CONSULTORAS
	public HashMap<Integer, ArrayList<Integer>> consultar_PaperOther() {
		return paperOther;
	}
	
	public HashMap<Integer, ArrayList<Integer>> consultar_OtherPaper() {
		return otherPaper;
	}
	
	//PRE: a -> id_Paper, b -> id_Other
	public Boolean existe_relacion(int a, int b) 
	{
		if (!paperOther.containsKey(a))return false;
		else 
		{
			for (int i = 0; i < paperOther.get(a).size(); ++i) 
			{
				if (paperOther.get(a).get(i) == a) return true;
			}
			return false;
		}
	}
	
	//PRE: i != NULL, i es un id de Paper
	//POST: Devuelve ArrayList con los "Others" relacionados con el Paper con id = i
	public ArrayList<Integer> consultar_RelacionPaper(Integer i) {
		if (paperOther.containsKey(i)) 
		{
			return paperOther.get(i);
		}
		else 
		{
			System.out.println("Caught NullPointerException: consultar_Relacion");
			return null;
		}
	}
	
	//PRE: i != NULL, i es un id de Other
	//POST: Devuelve ArrayList con los Papers relacionados con el Other con id = i
	public ArrayList<Integer> consultar_RelacionOther(Integer i) {
		try 
		{
			return otherPaper.get(i);
		}
		catch (NullPointerException e) {
			System.out.println("Caught NullPointerException: consultar_Relacion " + e.getMessage());
			return null;
		} 
	}
	
	//ANADIR
	//PRE: a -> id Paper, b -> id Other
	public void anadir_PaperOther(int a, int b)
	{
		if (!this.paperOther.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.paperOther.put(a, new ArrayList<Integer>());
		}
		//Añadir ordenadamente
		paperOther.get(a).add(new Integer(b));
		anadir_OtherPaper(b,a);
	}

	//Funcion privada, es llamada por anadir_PaperOther()
	//PRE: a -> id Other, b -> id Paper
	private void anadir_OtherPaper(int a, int b)
	{
		if (!this.otherPaper.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.otherPaper.put(a,new ArrayList<Integer>());
		}
		otherPaper.get(a).add(new Integer(b));
	}

  	//ELIMINAR
	//PRE: a -> id Paper, b -> id Other
	public void eliminar_PaperOther(int a, int b)
	{
		if (this.paperOther.containsKey(a)){ //borramos relación
			int index = -1;
			for (int i = 0; i < paperOther.get(a).size(); ++i)
			{
				if (b == paperOther.get(a).get(i)) index = i;
			}
			if (index >= 0) {
				paperOther.get(a).remove(index);
				if (this.paperOther.get(a).isEmpty()){ //si no quedan más relaciones, lo borramos todo
					this.paperOther.remove(a);
				}
			}
			else System.out.println("No existe ninguna relacion");
		}
		eliminar_OtherPaper(b,a);
	}

	//Funcion privada, es llamada por eliminar_PaperOther()
	//PRE: a -> id Paper, b -> id Other
	private void eliminar_OtherPaper(int a, int b)
	{
		if (this.otherPaper.containsKey(a)){ //borramos relación
			int index = -1;
			for (int i = 0; i < otherPaper.get(a).size(); ++i){
				if (b == otherPaper.get(a).get(i)) index = i;
			}
			if (index >= 0) {
				otherPaper.get(a).remove(index);
				if (this.otherPaper.get(a).isEmpty()){ //si no quedan más relaciones, lo borramos todo
					this.otherPaper.remove(a);
				}
			}
			else System.out.println("No existe ninguna relacion");
		}
	}
	
	//PRE: datos != Null
	//POST: Anade al parametro implicito todos los datos
	public void volcar_datos(HashMap<Integer, ArrayList<Pair<Integer,Double>>> datos) {
		
		for(Entry<Integer, ArrayList<Pair<Integer, Double>>> entry : datos.entrySet()){
		    ArrayList<Pair<Integer,Double>> oth = entry.getValue();
			for (int i = 0; i < oth.size(); ++i) {
				anadir_PaperOther(entry.getKey(), oth.get(i).getFirst());
			}
		}
	}
	
	public void pinta_matriz() {
		System.out.println("Relacion PaperOther:\n");
		HashMap<Integer,ArrayList<Integer>> a=this.paperOther;
		for (int i: a.keySet()) {
			ArrayList<Integer> l= a.get(i);
			System.out.print(i +": ");
			for(int j=0; j<l.size(); ++j) {
				int n = l.get(j);
				System.out.print(n +" "); 
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("Relacion OtherPaper:\n");
		a=this.otherPaper;
		for (int i: a.keySet()) {
			ArrayList<Integer> l= a.get(i);
			System.out.print(i +": ");
			for(int j=0; j<l.size(); ++j) {
				int n = l.get(j);
				System.out.print(n +" "); 
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
