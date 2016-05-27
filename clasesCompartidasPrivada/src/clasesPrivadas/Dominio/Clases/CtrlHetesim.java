package clasesPrivadas.Dominio.Clases;

import java.util.ArrayList;
import java.util.HashMap;
/*
 @author: 
*/
import java.util.Set;
import java.util.TreeSet;

import clasesCompartidas.Pair;

/**
 * @author Pablo Navarro Izquierdo
 *
 */
public class CtrlHetesim{
	Grafo g;
	public CtrlHetesim(Grafo g){
		this.g=g;
	}
	

	/*
		Pre: Num columnas de a = Num filas de b
		Post: Devuelve el producto matricial a*b
	*/
	private static HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> r = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>(); 
		for(int i: ordenarKeySet(a)) {																//Iteramos sobre el numero de filas de a
			ArrayList<Pair<Integer,Double>> rfila = new ArrayList<Pair<Integer,Double>>();
			ArrayList<Pair<Integer,Double>> afila = a.get(i);
			for (int j: ordenarKeySet(b)){															//Iteramos sobre el numero de columnas de b
				ArrayList<Pair<Integer,Double>> bfila = b.get(j);
				Pair<Integer,Double> rval = new Pair<Integer, Double>(j,(double)0);
				int z=0;																		//variable para interar sobre afila
				int y=0;																		//variable para iterar sobre bfila
				while(z< afila.size() && y < bfila.size()) {
					Pair<Integer, Double> aval=afila.get(z);									
					Pair<Integer, Double> bval=bfila.get(y);
					if(aval.getFirst().equals(bval.getFirst())) {									//En el caso que las variables apunten  al un elemento con el mismo indice
						double v=rval.getSecond();
						v+=aval.getSecond() * bval.getSecond();								//Multiplicamos sus valores y los sumamos al total
						rval.setSecond(v);							
						++z;																	//Y augmentamos las dos variables
						++y;
					}
					else if (aval.getFirst() < bval.getFirst()) ++z;							//En caso contrario, solo augmentamos la variable mas pequeÃ±a
					else ++y;
				}
				if (rval.getSecond()!= 0)rfila.add(rval);				
			}
			r.put(i, rfila);
		}
		return r;
	}
	/*
		Pre: Num columnas de a = Num filas de b
				a debe ser la matriz corespondiente al camino PL
				b debe ser la matriz correspondiente al camino PR-1
		Post Devuelve la matriz normalizada del hetesim, donde cada elemento ij corresponde a el valor hetesim del elemento i sobre el j;
	 */
	
	private static HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_norm_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> r = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>(); 
		for(int i: ordenarKeySet(a)) {																//Iteramos sobre el numero de filas de a
			ArrayList<Pair<Integer,Double>> rfila = new ArrayList<Pair<Integer,Double>>();
			ArrayList<Pair<Integer,Double>> afila = a.get(i);
			for (int j: ordenarKeySet(b)){															//Iteramos sobre el numero de columnas de b
				ArrayList<Pair<Integer,Double>> bfila = b.get(j);
				Pair<Integer,Double> rval = new Pair<Integer, Double>(j,(double)0);
				int z=0;																		//variable para interar sobre afila
				int y=0;																		//variable para iterar sobre bfila
				while(z< afila.size() && y < bfila.size()) {
					Pair<Integer, Double> aval=afila.get(z);									
					Pair<Integer, Double> bval=bfila.get(y);
					if(aval.getFirst().equals(bval.getFirst())) {									//En el caso que las variables apunten  al un elemento con el mismo indice
						double v=rval.getSecond();
						v+=aval.getSecond() * bval.getSecond();								//Multiplicamos sus valores y los sumamos al total
						rval.setSecond(v);							
						++z;																	//Y augmentamos las dos variables
						++y;
					}
					else if (aval.getFirst() < bval.getFirst()) ++z;							//En caso contrario, solo augmentamos la variable mas pequeÃ±a
					else ++y;
				}
				if (rval.getSecond()!=0) {
					double mod,  mod1=0, mod2=0;													//Ahora necesitamos dividir cada elemento por el producto de los modulos de su fila y columna respectiva
					for (int x=0; x<afila.size(); ++x){												//Calculamos el modulo de la fila
						Pair<Integer,Double> p=afila.get(x);
						double v=p.getSecond();
						mod1+=v*v;
					}
					mod1=Math.sqrt(mod1);															//Calculamos el modulo de la columna
					for (int x=0; x<bfila.size(); ++x){
						Pair<Integer,Double> p=bfila.get(x);
						double v=p.getSecond();
						mod2+=v*v;
					}
					mod2=Math.sqrt(mod2);															
					mod=mod1*mod2;
					Double d=rval.getSecond();					
					d=d/mod;																		//Y dividimos el elemento por el producto de los modulos
					rval.setSecond(d);
					rfila.add(rval);
				}
			}
			r.put(i, rfila);
		}
		return r;
	}
	
	/*
	  Pre: R es la matriz de una relaciÃƒÂ³n AB entre cualquier par de nodos
	  Post: Devuelve la matriz correspondiente a la relacion AE.
	 */
	private static Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>, HashMap<Integer,ArrayList<Pair<Integer,Double>>>> relacion_Dummy(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b){		//Obtencion de la matriz RL
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> r1 = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> r2 = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		int etiqueta=0;
		for (int id: ordenarKeySet(a)){ //iteramos sobre R
			ArrayList<Pair<Integer,Double>> afila = a.get(id); 											//fila[id] de a
			for (int j=0; j< afila.size(); ++j) {
				ArrayList<Pair<Integer,Double>> r1fila = new ArrayList<Pair<Integer,Double>>(); 			//futura fila[id] de r1
				ArrayList<Pair<Integer,Double>> r2fila = new ArrayList<Pair<Integer,Double>>(); 			//futura fila[id] de r1
				Pair<Integer,Double> p1=new Pair<Integer,Double>(id, 1.0/afila.size());
				Pair<Integer,Double> aval=afila.get(j);
				Integer pos=aval.getFirst();
				Pair<Integer,Double> p2=new Pair<Integer,Double>(pos, 1.0/b.get(pos).size());
				r1fila.add(p1);
				r2fila.add(p2);
				++etiqueta;
				r1.put(etiqueta, r1fila);
				r2.put(etiqueta, r2fila);
			}
		}
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>, HashMap<Integer,ArrayList<Pair<Integer,Double>>>> r= new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>, HashMap<Integer,ArrayList<Pair<Integer,Double>>>>(r1, r2);
		return r;
	}
	
	/*
	 Pre: path es un camino predeterminado de longitud 2
	 Post: devuelve la matriz normalizada de aplicar hete sim en el camino p. En la fila i-esima se encuentran la relevancia de el elemento j sobre i;
	 */
	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> HeteSim(String p){
		return g.getRelaciones(p, true);
	}
	
	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> HeteSim(String p, int id){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> r=new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> pl = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> pr = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> opl = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> opr = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>, HashMap<Integer,ArrayList<Pair<Integer,Double>>>> dummy = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>, HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		String path=p;
		boolean first=true;
		if (path.length()%2==0){
			path=path.substring(0, path.length()/2) + "E" + path.substring(path.length()/2);			//Si el camino es par, le anadimos el caracter 'E' en la posicion central
			if (path.length()>3){
				String rel1=path.substring((path.length()/2)-1, path.length()/2) + path.substring((path.length()/2)+ 1, (path.length()/2)+2);
				String rel2=path.substring((path.length()/2)+1, (path.length()/2)+2) + path.substring((path.length()/2)- 1, (path.length()/2));
				dummy=relacion_Dummy(g.getRelaciones(rel1,true), g.getRelaciones(rel2, true));
			}
		}
		for (int i=0; i<path.length()/2; ++i) {								//Recorremos la parte izquierda del camino
			if (first) {													//En caso de primera iteracion
				String rel=path.substring(i,i+2);							//Miramos la primera relacion;
				if (path.charAt(i+1)=='E') {
					rel=path.substring(i,i+1) + path.substring(i+2, i+3); 
					r.put(id, g.getRelaciones(rel, true).get(id));					//Si contiene el elemento E
					return r;
				}
				else pl.put(id, g.getRelaciones(rel, true).get(id));
				first=false;												//Marcamos que ya hemos completado la primera iteracion
			}
			else  {															//En una iteracion cualquiera
				String rel=path.substring(i+1,i+2) + path.substring(i,i+1);							//Miramos la relacion i-esima inversa
				if (path.charAt(i+1)=='E') opl=dummy.getFirst();								//Si contiene el elemento E
				else opl=g.getRelaciones(rel,false);
				pl=producto_mat(pl, opl);									//Hacemos el producto matricial entre los dos operandos
			}
			
		}
		first=true;
		for (int i=path.length()-1; i>=(path.length()/2)+1; --i) {			//Iteramos la parte derecha del camino desde la posicion final a la central
			if (first) {													//En caso de primera iteracion
				String rel=path.substring(i,i+1)+path.substring(i-1, i);	//Obtenemos el string de la relacion inverso de la posicion i-esima						//Si contiene el elemento E
				pr=g.getRelaciones(rel,true);							
				first=false;												//Marcamos que ya hemos completado la primera iteracion
			}
			else  {															//En una iteracion cualquiera
				String rel=path.substring(i-1, i)+path.substring(i,i+1);	//Obtenemos el string de la relacion inverso de la posicion i-esima
				if (path.charAt(i-1)=='E') opr=dummy.getSecond();					
				else opr=g.getRelaciones(rel,false);						//Y normalizamos por filas
				pr=producto_mat(pr, opr);									//Hacemos el producto matricial entre los dos operandos
			}
			
		}												//Hacemos la transpuesta de la matriz correspondiene al camino derecho
		r=producto_norm_mat(pl,pr);											//Y finalmente hacemos el producto matricial normalizado entre las dos matrices de los caminos
		
		return r;
	}
	
	private static Set<Integer> ordenarKeySet(HashMap<Integer,ArrayList<Pair<Integer,Double>>> hm)
	{	
		return new TreeSet<Integer>(hm.keySet()) ;
	}
}
