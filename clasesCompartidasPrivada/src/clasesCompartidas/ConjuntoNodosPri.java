package clasesCompartidas;

import java.io.Serializable;
import java.util.HashMap;

public class ConjuntoNodosPri extends ConjuntoNodos implements Serializable 
{
	public ConjuntoNodosPri()
	{
		super();
	}
	
	public ConjuntoNodosPri(HashMap<Integer, String> nodos, HashMap<String, Integer> nombres_nodos)
	{
		super(nodos, nombres_nodos);
	}
	
	public void joinHashMap(Pair<HashMap<Integer,String>,HashMap<String,Integer>> n)
	{
		this.nodos.putAll(n.getFirst());
		this.nombres_nodos.putAll(n.getSecond());
	}
}
