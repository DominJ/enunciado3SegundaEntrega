package clasesCompartidas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;



public class Relaciones 
{
	protected HashMap<Integer, ArrayList<Pair<Integer,Double>>> paperOther;
	protected HashMap<Integer, ArrayList<Pair<Integer,Double>>> otherPaper;
	
	public Relaciones()
	{
		//contructor por defecto
		paperOther = new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
		otherPaper = new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
	}
	
	public Relaciones(HashMap<Integer, ArrayList<Pair<Integer,Double>>> relacionesIda, HashMap<Integer, ArrayList<Pair<Integer,Double>>> relacionesVuelta)
	{
		this.paperOther = relacionesIda;
		this.otherPaper = relacionesVuelta;
	}
	
	//CONSULTORAS
	public HashMap<Integer, ArrayList<Pair<Integer,Double>>> consultar_PaperOther() {
		return paperOther;
	}
	
	public HashMap<Integer, ArrayList<Pair<Integer,Double>>> consultar_OtherPaper() {
		return otherPaper;
	}
	
	//PRE: a -> id_Paper, b -> id_Other
	public Boolean existe_relacion(int a, int b) {
		if (!paperOther.containsKey(a))return false;
		else {
			for (int i = 0; i < paperOther.get(a).size(); ++i) {
				if (paperOther.get(a).get(i).getFirst() == a) return true;
			}
			return false;
		}
	}
	
	//PRE: i != NULL, i es un id de Paper
	//POST: Devuelve ArrayList con los "Others" relacionados con el Paper con id = i
	public ArrayList<Pair<Integer, Double>> consultar_RelacionPaper(Integer i) {
		if (paperOther.containsKey(i)) {
			return paperOther.get(i);
		}
		else {
			System.out.println("Caught NullPointerException: consultar_Relacion");
			return null;
		}
	}
	
	//PRE: i != NULL, i es un id de Other
	//POST: Devuelve ArrayList con los Papers relacionados con el Other con id = i
	public ArrayList<Pair<Integer,Double>> consultar_RelacionOther(Integer i) {
		try {
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
			this.paperOther.put(a, new ArrayList<Pair<Integer,Double>>());
		}
		//Añadir ordenadamente
		paperOther.get(a).add(new Pair<Integer, Double>(b,1.0));
		anadir_OtherPaper(b,a);
	}

	//Funcion privada, es llamada por anadir_PaperOther()
	//PRE: a -> id Other, b -> id Paper
	private void anadir_OtherPaper(int a, int b)
	{
		if (!this.otherPaper.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.otherPaper.put(a,new ArrayList<Pair<Integer,Double>>());
		}
		otherPaper.get(a).add(new Pair<Integer, Double>(b,1.0));
	}

  	//ELIMINAR
	//PRE: a -> id Paper, b -> id Other
	public void eliminar_PaperOther(int a, int b)
	{
		if (this.paperOther.containsKey(a)){ //borramos relación
			int index = -1;
			for (int i = 0; i < paperOther.get(a).size(); ++i){
				if (b == paperOther.get(a).get(i).getFirst()) index = i;
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
				if (b == otherPaper.get(a).get(i).getFirst()) index = i;
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
}