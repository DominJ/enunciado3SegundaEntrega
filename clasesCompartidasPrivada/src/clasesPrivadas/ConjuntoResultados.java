package clasesPrivadas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

import clasesCompartidas.Pair;

/**
 * @author Pablo Navarro Izquierdo
 *
 */

public class ConjuntoResultados {
	HashMap<String, HashMap<Integer,ArrayList<Pair<Integer,Double>>>> resultados; //Estructura donde guardamos los resultados, accedemos a un resultado poniendo el path como key
	Pair<Double,Double> IR;							//variable para filtrar resultados mediante un intervalo de relevancia
	final int max_res=20;									//Numero maximo de resultados que guardamos en el hashmap
	
	public ConjuntoResultados() {
		resultados=new HashMap<String, HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		IR= new Pair<Double,Double>((double) 0,(double)1);
	}
	
	public void setIntervalo(Double b, Double e) {
		IR.setFirst(b);
		IR.setSecond(e);
	}
	
	public boolean anadirResultado(String path, HashMap<Integer,ArrayList<Pair<Integer,Double>>> R){
		boolean b;
		if (resultados.size() >= 20) b=false;
		else {
			resultados.put(path, R);
			b=true;
		}
		return b;
	}
	
	public void vaciar_resultados(){
		resultados.clear();
	}
	
	public boolean existeResultado(String path){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> M=resultados.get(path);
		return M!=null;
	}

	//Pre: Se han anadido los filtros insertados por el usuario a la clase
	//Post: Devuelve un map ordenado preparado para imprimir, donde la key es la relevancia del nodo j, y el valor es el id de j
	public ArrayList<Pair <Double, Integer>> getResultadoNodo(String path, int id){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> M=resultados.get(path);
		ArrayList<Pair<Integer,Double>> m1= M.get(id);
		ArrayList <Pair<Double, Integer>> R = new ArrayList<Pair<Double, Integer>>();
		for(int i=0; i<m1.size(); ++i){
			Pair<Integer, Double> p = m1.get(i);
			if (p.getSecond() >=IR.getFirst() && p.getSecond() <= IR.getSecond()){
				Pair<Double, Integer> p1 = new Pair<Double, Integer>(p.getSecond(), p.getFirst());
				R.add(p1);	
			}
		}
		Collections.sort(R, new Comparator<Pair<Double, Integer>>(){

			public int compare(Pair<Double, Integer> P1, Pair<Double, Integer> P2) {
				return P2.getFirst().compareTo(P1.getFirst());
			}
			
		});
		IR.setFirst((double)0);
		IR.setSecond((double)1);
		return R;
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
		return resultados.keySet();
	}

}
