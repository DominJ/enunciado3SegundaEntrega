package clasesPrivadas.Dominio.Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import clasesCompartidas.Pair;

/**
 * @author Pablo Navarro Izquierdo
 *
 */

public class ConjuntoResultados {
	HashMap<String, HashMap<Integer, ArrayList<Pair<Integer,Double>>>> resultados; //Estructura donde guardamos los resultados de un path entero, accedemos a un resultado poniendo el path como key
	HashMap<String, HashMap<Integer, ArrayList<Pair<Integer,Double>>>> resultados_parciales; //Estructura donde guardamos resultados parciales de un path
	Pair<Double,Double> IR;							//variable para filtrar resultados mediante un intervalo de relevancia
	
	public ConjuntoResultados() {
		resultados=new HashMap<String, HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		resultados_parciales= new HashMap<String, HashMap<Integer, ArrayList<Pair<Integer,Double>>>>();
		IR= new Pair<Double,Double>((double) 0,(double)1);
	}
	
	public void setIntervalo(Double b, Double e) {
		IR.setFirst(b);
		IR.setSecond(e);
	}
	
	public void anadirResultado(String path, HashMap<Integer,ArrayList<Pair<Integer,Double>>> r){
		resultados.put(path, r);
	}
	
	public void anadirResultado(String path, HashMap<Integer,ArrayList<Pair<Integer,Double>>> r, int id){
		HashMap<Integer, ArrayList<Pair<Integer,Double>>> a=resultados_parciales.get(path);
		if(a==null) a=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
		ArrayList<Pair<Integer,Double>> rfila=r.get(id);
		a.put(id, rfila);
		resultados_parciales.put(path, a);
	}
	
	public void vaciar_resultados(){
		resultados.clear();
	}
	
	public boolean existeResultado(String path){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> m=resultados.get(path);
		return m!=null;
	}
	
	public boolean existeResultado(String path, int id){
		HashMap<Integer, ArrayList<Pair<Integer,Double>>> m =resultados_parciales.get(path);
		if(m!=null){
			 ArrayList<Pair<Integer,Double>> a = m.get(id);
			 return a!=null;
		}
		return false;
	}

	//Pre: Se han anadido los filtros insertados por el usuario a la clase
	//Post: Devuelve un map ordenado preparado para imprimir, donde la key es la relevancia del nodo j, y el valor es el id de j
	public ArrayList<Pair <Double, Integer>> getResultadoNodo(String path, int id){
		ArrayList<Pair<Integer,Double>> m1;
		if (existeResultado(path)){
			HashMap<Integer,ArrayList<Pair<Integer,Double>>> m=resultados.get(path);
			m1= m.get(id);
			System.out.println("path");
		}
		else if (existeResultado(path, id)){
			HashMap<Integer,ArrayList<Pair<Integer,Double>>> m=resultados_parciales.get(path);
			m1= m.get(id);
			System.out.println("Parcial");
		}
		else {m1=new ArrayList<Pair<Integer,Double>>();System.out.println("vacio");}
		ArrayList <Pair<Double, Integer>> r = new ArrayList<Pair<Double, Integer>>();
		for(int i=0; i<m1.size(); ++i){
			Pair<Integer, Double> p = m1.get(i);
			if (p.getSecond() >=IR.getFirst() && p.getSecond() <= IR.getSecond()){
				Pair<Double, Integer> p1 = new Pair<Double, Integer>(p.getSecond(), p.getFirst());
				r.add(p1);	
			}
		}
		Collections.sort(r, new Comparator<Pair<Double, Integer>>(){

			public int compare(Pair<Double, Integer> P1, Pair<Double, Integer> P2) {
				return P2.getFirst().compareTo(P1.getFirst());
			}
			
		});
		IR.setFirst((double)0);
		IR.setSecond((double)1);
		return r;
	}
	
	public void printa_matriz1(String pa) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> a=resultados.get(pa);
		for (int i: a.keySet()) {
			ArrayList<Pair<Integer,Double>> l= a.get(i);
			System.out.print(i +": ");
			for(int j=0; j<l.size(); ++j) {
				Pair<Integer,Double> p = l.get(j);
				Integer id=p.getFirst();
				Double val=p.getSecond();
				System.out.print( "(" + id +" ->");
				System.out.printf(" "+ "%2f" +")" + " ", val); 
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public Set<String> consultarCaminosAlmacenados()
	{
		return resultados_parciales.keySet();
	}
	public HashMap<String,Set<Integer>> consultarResultadosParciales()
	{
		HashMap<String,Set<Integer>> r=new HashMap<String,Set<Integer>>();
		for(String s: resultados_parciales.keySet()){
			r.put(s, resultados_parciales.get(s).keySet());
		}
		return r;
	}
}
