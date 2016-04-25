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
	public static Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> crear_relacion(int c) throws IOException {
		String cadena;
		//Aquest metode llegeix el fitxer
		Integer vb = 0;
		String archivo = null;
		if (c == 1) archivo = "Set1/paper_author.txt";
		else if (c == 2) archivo = "Set1/paper_conf.txt";
		else archivo = "Set1/paper_term.txt";
		FileReader f = new FileReader(archivo); 
		BufferedReader b = new BufferedReader(f); 
		HashMap<Integer,ArrayList<Integer>> m = new HashMap<Integer,ArrayList<Integer>>();
		HashMap<Integer,ArrayList<Integer>> n = new HashMap<Integer,ArrayList<Integer>>();
		Integer codi,codi2,codi_antic;
		codi = codi2 = codi_antic = 0;
		Boolean primer = true;
		String s2 = new String();
		ArrayList<Integer> l = new ArrayList<Integer>();
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
	    	//Segon Hashmap del pair
	    	if (n.get(codi2) == null) n.put(codi2, new ArrayList<Integer>());
	    	n.get(codi2).add(codi);
	    	//Primer HashMap del pair
	    	if(primer){
	    		s2 = copy.substring(0,i);
	    		codi_antic = codi;
	    		primer = false;
	    	}
	    	if(!(s.equals(s2))){
	    		m.put(codi_antic, l);
	    		l = new ArrayList<Integer>();
	    	}
	    	l.add(codi2);
	    	codi_antic = codi;
	    	s2 = copy.substring(0,i);
		}
		m.put(codi_antic, l);
		//Tanquem el buffer
		b.close();
		//Omplim el pair amb els dos HashMaps obtinguts
		Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> v = new Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}

	//Aquest mÃƒÂ¨tode retorna un pair amb un HashMap original de node primitiu a la primera posiciÃƒÂ³ i un HashMap transposat a
	// la segona posiciÃƒÂ³. Els codis dels tipus sÃƒÂ³n (0 = P, 1 = A, 2 = C, 3 = T) 
	/*PRE: c es un integer que discrimina el tipus*/
	/*POST: Es crea un pair de dos HashMaps, amb la relacio dels dos atributs del NodePrimitiu*/
	public static Pair<HashMap<Integer,String>,HashMap<String,Integer>> crear_nodo_primitivo(int c) throws IOException {
		String cadena;
		//Aquest mÃƒÂ¨tode llegeix el fitxer
		String archivo = null;
		if (c == 0) archivo = "Set1/paper.txt";
		else if (c == 1) archivo = "Set1/author.txt";
		else if (c == 2) archivo = "Set1/conf.txt";
		else archivo = "Set1/term.txt";
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
	    	//IntroduÃƒÂ¯m els elements al HashMap primer
	    	m.put(codi, s1);
	        //IntroduÃƒÂ¯m els elements al HashMap segon ja invertits
	    	n.put(s1,codi);
		}
		//Tanquem el buffer
		b.close();
		//Omplim el pair amb els dos HashMaps obtinguts
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> v = new Pair<HashMap<Integer,String>,HashMap<String,Integer>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}
	
	/*PRE: Existeix el Hashmap que li passem*/
	/*POST: Et retorna l'id més gran disponible*/
	public static int idMax(HashMap<Integer,String> a)
	{
		int idMax = -1;
		for(int i: a.keySet() ){
			if(i > idMax)idMax = i;
		}
		return idMax;
	}
}
