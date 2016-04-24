package clasesCompartidas;

import java.util.ArrayList;
import java.util.HashMap;
import Pair.Pair;
/*
 @author: 
*/

/**
 * @author Pablo Navarro Izquierdo
 *
 */
public class CtrlHetesim{

	public CtrlHetesim(){
		//constructura por defecto

	}
	
	/*
	Pre: a es una matriz de adyacencia de una relacion AB entre dos nodos cualquiera
	Post Devuelve la matriz a normalizada por filas
	 */
	private static HashMap<Integer,ArrayList<Pair<Integer,Double>>> normalizar_por_filas(HashMap<Integer,ArrayList<Integer>> a) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> R = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();	
		for (int id: a.keySet()){																						//Iteramos sobre a
			ArrayList<Pair<Integer,Double>> Rfila = new ArrayList<Pair<Integer,Double>>();
			ArrayList<Integer> afila = a.get(id);
			for (int j=0; j<afila.size(); ++j) {																		//Iteramos sobre la fila id de a
				int pos = afila.get(j);																			//obtenemos la posicion del j-esimo elemtno del la fila id
				double val= (double) 1/afila.size();																//Cada valor de la fila a, lo dividimos entre el numero de elementos en la fila id
				Pair<Integer,Double> Rval = new Pair<Integer,Double>(pos, val);											
				Rfila.add(Rval);																						// Y lo guardamos como el elemento R[id][pos]
			}
			R.put(id, Rfila);
		}
		return R;
		
	}
	
	/*Pre: -
	  Post: Devuelve la matriz transpuesta de a	
	 */
	
	private static HashMap<Integer,ArrayList<Pair<Integer,Double>>> transpuesta(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> R = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		int ncol=0;																				//Para empezar a transponer, necesitamos saber el numero de columnas de a			
		for(int i: a.keySet()) {																//Iteramos sobre el numero de filas de a;
			ArrayList<Pair<Integer,Double>> afila = a.get(i);
			for (int j=0; j<afila.size(); ++j){															//Iteramos sobre el numero de columnas de b
				Pair<Integer,Double> aval = afila.get(j);	
				int pos=aval.getFirst();
				if (pos > ncol) ncol=pos;														//Obtenemos numero maximo que contiene la posicon j, que es el numero de columnas
			}
		}
		for (int i=0; i<=ncol; ++i){
			ArrayList<Pair<Integer,Double>> Rfila =new ArrayList<Pair<Integer,Double>>();
			for(int idi: a.keySet()) {																//Iteramos sobre el numero de filas de a;
				ArrayList<Pair<Integer,Double>> afila = a.get(idi);
				for (int idj=0; idj<afila.size(); ++idj){															//Iteramos sobre el numero de columnas de b
					Pair<Integer,Double> aval = afila.get(idj);
					int pos=aval.getFirst();
					if (pos==i) {
						double val=aval.getSecond();
						Pair<Integer,Double> Rval = new Pair<Integer,Double>(idi,val);
						Rfila.add(Rval);
					}
				}
			}
			R.put(i,Rfila);
		}
		return R;
	}
	
	
	/*
		Pre: Num columnas de a = Num filas de b
		Post: Devuelve el producto matricial a*b
	*/
	private static HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> R = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>(); 
		HashMap<Integer,ArrayList<Pair<Integer,Double>>>b2=transpuesta(b);
		for(int i: a.keySet()) {																//Iteramos sobre el numero de filas de a
			ArrayList<Pair<Integer,Double>> Rfila = new ArrayList<Pair<Integer,Double>>();
			ArrayList<Pair<Integer,Double>> afila = a.get(i);
			for (int j: b2.keySet()){															//Iteramos sobre el numero de columnas de b
				ArrayList<Pair<Integer,Double>> b2col = b2.get(j);
				Pair<Integer,Double> Rval = new Pair<Integer, Double>(j,(double)0);
				for (int k=0;k<b2col.size(); ++k) {												//Iteramos sobre la columna j de b;
					Pair<Integer,Double> b2val=b2col.get(k);										
					int l=b2val.getFirst();														//Obtenemos el valor b[l][j];
					boolean found=false;
					for(int x=0;!found && x<afila.size(); ++x) {											//Buscamos en la fila correspondiente de a, si su indice l contiene algun valor
						Pair<Integer,Double>aval = afila.get(x);
						if (aval.getFirst()==l) {												// En caso afirmativo, sumamos a el valor de la celda final, el producto entre las dos celdas de a y b
							double d=Rval.getSecond();
							d += (aval.getSecond() * b2val.getSecond());
							Rval.setSecond(d);
							found=true;
						}
					}
				}
				if (Rval.getSecond()!= 0)Rfila.add(Rval);				
			}
			R.put(i, Rfila);
		}
		return R;
	}
	/*
		Pre: Num columnas de a = Num filas de b
				a debe ser la matriz corespondiente al camino PL
				b debe ser la matriz correspondiente al camino PR-1
		Post Devuelve la matriz normalizada del hetesim, donde cada elemento ij corresponde a el valor hetesim del elemento i sobre el j;
	 */
	
	private static HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_norm_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b) {
		HashMap<Integer,ArrayList<Pair<Integer,Double>>>b2 =transpuesta(b);
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> R = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>(); 
		for(int i: a.keySet()) {																//Iteramos sobre el numero de filas de a
			ArrayList<Pair<Integer,Double>> Rfila = new ArrayList<Pair<Integer,Double>>();
			ArrayList<Pair<Integer,Double>> afila = a.get(i);
			for (int j: b2.keySet()){															//Iteramos sobre el numero de columnas de b
				ArrayList<Pair<Integer,Double>> b2col = b2.get(j);
				Pair<Integer,Double> rVal = new Pair<Integer, Double>(j,(double)0);
				for (int k=0; k<b2col.size(); ++k) {												//Iteramos sobre la columna j de b;
					Pair<Integer,Double> b2val=b2col.get(k);										
					int l=b2val.getFirst();														//Obtenemos el valor b[l][j];
					boolean found=false;
					for(int x=0;!found && x<afila.size(); ++x) {											//Buscamos en la fila correspondiente de a, si su indice l contiene algun valor
						Pair<Integer,Double>aval = afila.get(x);
						if (aval.getFirst()==l) {												// En caso afirmativo, sumamos a el valor de la celda final, el producto entre las dos celdas de a y b
							double d=rVal.getSecond();
							d += (aval.getSecond() * b2val.getSecond());
							rVal.setSecond(d);
							found=true;
						}
					}
				}
				if (rVal.getSecond()!=0) {
					double mod,  mod1=0, mod2=0;													//Ahora necesitamos dividir cada elemento por el producto de los modulos de su fila y columna respectiva
					for (int x=0; x<afila.size(); ++x){												//Calculamos el modulo de la fila
						Pair<Integer,Double> p=afila.get(x);
						double v=p.getSecond();
						mod1+=v*v;
					}
					mod1=Math.sqrt(mod1);															//Calculamos el modulo de la columna
					for (int x=0; x<b2col.size(); ++x){
						Pair<Integer,Double> p=b2col.get(x);
						double v=p.getSecond();
						mod2+=v*v;
					}
					mod2=Math.sqrt(mod2);															
					mod=mod1*mod2;
					Double d=rVal.getSecond();					
					d=d/mod;																		//Y dividimos el elemento por el producto de los modulos
					rVal.setSecond(d);
					Rfila.add(rVal);
				}
			}
			R.put(i, Rfila);
		}
		return R;
	}
	
	/*
	  Pre: R es la matriz de una relación AB entre cualquier par de nodos
	  Post: Devuelve la matriz correspondiente a la relacion AE.
	 */
	private static HashMap<Integer,ArrayList<Integer>> Relacion_Dummy(HashMap<Integer,ArrayList<Integer>> RE){		//Obtencion de la matriz RL
		HashMap<Integer,ArrayList<Integer>> R = new HashMap<Integer,ArrayList<Integer>>();
		int etiqueta=0;
		for (int id: RE.keySet()){ //iteramos sobre R
			ArrayList<Integer> reFila = RE.get(id); 											//fila[id] de R
			ArrayList<Integer> rFila = new ArrayList<Integer>(); 			//futura fila[id] de RE
			for (int j=0; j< reFila.size(); ++j) {	
				rFila.add(etiqueta);
				++etiqueta;
			}
			R.put(id, rFila);
		}
		return R;
	}
	
	/*
	 Pre: path es un camino valido 
	 Post: devuelve la matriz normalizada de aplicar hete sim en el camino p. En la fila i-esima se encuentran la relevancia de el elemento j sobre i;
	 */
	public static HashMap<Integer,ArrayList<Pair<Integer,Double>>> HeteSim(String p, Grafo g){
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> R=new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> PL = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> PR = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> OPL = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> OPR = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		String path=p;
		boolean first=true;
		if (path.length()%2==0) path=path.substring(0, path.length()/2) + "E" + path.substring(path.length()/2);			//Si el camino es par, le añadimos el caracter 'E' en la posicion central
		for (int i=0; i<path.length()/2; ++i) {								//Recorremos la parte izquierda del camino
			if (first) {													//En caso de primera iteracion
				String rel=path.substring(i,i+2);							//Miramos la primera relacion;
				if (path.charAt(i+1)=='E') {								//Si contiene el elemento E
					rel=path.substring(i,i+1) + path.substring(i+2, i+3);									//obtenemos el string de la relacion cambiando el elemento E por el contiguo
					PL=normalizar_por_filas(Relacion_Dummy(g.getRelaciones(rel)));
				}	
				else PL=normalizar_por_filas(g.getRelaciones(rel));
				first=false;												//Marcamos que ya hemos completado la primera iteracion
			}
			else  {															//En una iteracion cualquiera
				String rel=path.substring(i,i+2);							//Miramos la relacion i-esima
				if (path.charAt(i+1)=='E') {								//Si contiene el elemento E
					rel=path.substring(i,i+1) + path.substring(i+2, i+3);								//obtenemos el string de la relacion cambiando el elemento E por el contiguo
					OPL=normalizar_por_filas(Relacion_Dummy(g.getRelaciones(rel)));							//Y normalizamos por filas
				}
				else OPL=normalizar_por_filas(g.getRelaciones(rel));
				PL=producto_mat(PL, OPL);									//Hacemos el producto matricial entre los dos operandos
			}
			
		}
		first=true;
		for (int i=path.length()-1; i>=(path.length()/2)+1; --i) {			//Iteramos la parte derecha del camino desde la posicion final a la central
			if (first) {													//En caso de primera iteracion
				String rel=path.substring(i,i+1)+path.substring(i-1, i);	//Obtenemos el string de la relacion inverso de la posicion i-esima
				if (path.charAt(i-1)=='E') {								//Si contiene el elemento E
					rel=path.substring(i,i+1)+path.substring(i-2, i-1);		//obtenemos el string de la relacion cambiando el elemento E por el contiguo
					PR=normalizar_por_filas(Relacion_Dummy(g.getRelaciones(rel)));								//Y normalizamos por filas
				}
				else  PR=normalizar_por_filas(g.getRelaciones(rel));							//Y normalizamos por filas
				first=false;												//Marcamos que ya hemos completado la primera iteracion
			}
			else  {															//En una iteracion cualquiera
				String rel=path.substring(i,i+1)+path.substring(i-1, i);	//Obtenemos el string de la relacion inverso de la posicion i-esima
				if (path.charAt(i-1)=='E') {								//Si contiene el elemento E
					rel=path.substring(i,i+1)+path.substring(i-2, i-1);			//obtenemos el string de la relacion cambiando el elemento E por el contiguo
					OPR=normalizar_por_filas(Relacion_Dummy(g.getRelaciones(rel)));								//Y normalizamos por filas
				}
				else OPR=normalizar_por_filas(g.getRelaciones(rel));						//Y normalizamos por filas
				PR=producto_mat(PR, OPR);									//Hacemos el producto matricial entre los dos operandos
			}
			
		}
		PR=transpuesta(PR);													//Hacemos la transpuesta de la matriz correspondiene al camino derecho
		R=producto_norm_mat(PL,PR);											//Y finalmente hacemos el producto matricial normalizado entre las dos matrices de los caminos
		
		return R;
	}
}
