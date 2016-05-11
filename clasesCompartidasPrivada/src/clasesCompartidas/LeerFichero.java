package clasesCompartidas;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Daniel Pulido Sánchez-Carnerero
 *
 */
public class LeerFichero 
{
	
	/*PRE: c es un integer que discrimina el tipus*/
	/*POST: Es crea un pair de dos HashMaps, amb la relacio P-NodePrimitiu al First i NodePrimitiu-P al Second*/
	public static Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> crear_relacion(int c, String ruta) throws IOException {
		String cadena;
		Integer vb = 0;
		String archivo = null;
		if (c == 4) archivo = ruta;
		else if (c == 1) archivo = "../Set1/paper_author.txt";
		else if (c == 2) archivo = "../Set1/paper_conf.txt";
		else archivo = "../Set1/paper_term.txt";
		FileReader f = new FileReader(archivo); 
		BufferedReader b = new BufferedReader(f); 
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> m = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> n = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		Integer codi,codi2,codi_antic;
		codi = codi2 = codi_antic = 0;
		Pair<Integer,Double> x = new Pair<Integer,Double>();
		Pair<Integer,Double> z = new Pair<Integer,Double>();
		Boolean primer = true;
		String s2 = new String();
		ArrayList<Pair<Integer,Double>> l = new ArrayList<Pair<Integer,Double>>();
		while(((cadena = b.readLine())!=null)){
			++vb;
	    	int i = 0;
	    	String copy = cadena;
	    	while(!(Character.isWhitespace(cadena.charAt(i)))) {
	    		++i;
	    	}
	    	String s = copy.substring(0,i);
	    	codi = Integer.parseInt(s);
	    	String s1 = copy.substring(i+1,copy.length());
	    	codi2 = Integer.parseInt(s1);
	    	if (n.get(codi2) == null) n.put(codi2, new ArrayList<Pair<Integer,Double>>());
	    	x.setFirst(codi);
	    	x.setSecond(1.0);
	    	n.get(codi2).add(x);
	    	if(primer){
	    		s2 = copy.substring(0,i);
	    		codi_antic = codi;
	    		primer = false;
	    	}
	    	if(!(s.equals(s2))){
	    		m.put(codi_antic, l);
	    		l = new ArrayList<Pair<Integer,Double>>();
	    	}
	    	z.setFirst(codi2);
	    	z.setSecond(1.0);
	    	l.add(z);
	    	codi_antic = codi;
	    	s2 = copy.substring(0,i);
		}
		m.put(codi_antic, l);
		b.close();
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> v = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}

	//(0 = P, 1 = A, 2 = C, 3 = T) 
	/*PRE: c es un integer que discrimina el tipus*/
	/*POST: Es crea un pair de dos HashMaps, amb la relacio dels dos atributs del NodePrimitiu*/
	public static Pair<HashMap<Integer,String>,HashMap<String,Integer>> crear_nodo_primitivo(int c) throws IOException {
		String cadena;
		String archivo = null;
		if (c == 0) archivo = "../Set1/paper.txt";
		else if (c == 1) archivo = "../Set1/author.txt";
		else if (c == 2) archivo = "../Set1/conf.txt";
		else archivo = "../Set1/term.txt";
		FileReader f = new FileReader(archivo); 
		BufferedReader b = new BufferedReader(f); 
		HashMap<Integer,String> m = new HashMap<Integer,String>();
		HashMap<String,Integer> n = new HashMap<String,Integer>();
		Integer codi = 0;
		while(((cadena = b.readLine())!=null)){
	    	int i = 0;
	    	String copy = cadena;
	    	while(!(Character.isWhitespace(cadena.charAt(i)))) {
	    		++i;
	    	}
	    	String s = copy.substring(0,i);
	    	codi = Integer.parseInt(s);
	    	String s1 = copy.substring(i+1,copy.length());
	    	m.put(codi, s1);
	    	n.put(s1,codi);
		}
		b.close();
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> v = new Pair<HashMap<Integer,String>,HashMap<String,Integer>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}
	
	public void main() throws IOException{
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> a = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		String h = "hahaha";
		a = crear_relacion(1,h);
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> b = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		b = a.getFirst();
		ArrayList<Pair<Integer,Double>> c = new ArrayList<Pair<Integer,Double>>();
		c = b.get(1);
	    for(int v=0;v<c.size();v++) {
	        System.out.println(c.get(v).getFirst() + " \n");
	      }
	}
	
}