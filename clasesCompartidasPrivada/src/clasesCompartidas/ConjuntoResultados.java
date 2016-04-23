import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import Pair.Pair;

public class ConjuntoResultados {
	HashMap<String, HashMap<Integer,ArrayList<Pair<Integer,Double>>>> Resultados; //Estructura donde guardamos los resultados, accedemos a un resultado poniendo el path como key
	Pair<Double,Double> IR;							//variable para filtrar resultados mediante un intervalo de relevancia
	final int max_res=20;									//Numero maximo de resultados que guardamos en el hashmap
	
	public ConjuntoResultados() {
		Resultados=new HashMap<String, HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		IR= new Pair<Double,Double>((double) 0, 1.01);
	}
	
	public void setIntervalo(Double b, Double e) {
		IR.setFirst(b);
		IR.setSecond(e);
	}
	
	public boolean anadirResultado(String path, HashMap<Integer,ArrayList<Pair<Integer,Double>>> R){
		boolean b;
		if (Resultados.size() >= 20) b=false;
		else {
			Resultados.put(path, R);
			b=true;
		}
		return b;
	}
	
	public void vaciar_resultados(){
		Resultados.clear();
	}
	
	public boolean existeResultado(String path){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> M=Resultados.get(path);
		return M!=null;
	}

	//Pre: Se han anadido los filtros insertados por el usuario a la clase
	//Post: Devuelve un map ordenado preparado para imprimir, donde la key es la relevancia del nodo j, y el valor es el id de j
	public ArrayList<Pair <Double, Integer>> getResultadoAutor(String path, int id){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> M=Resultados.get(path);
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
		return R;
	}

}
