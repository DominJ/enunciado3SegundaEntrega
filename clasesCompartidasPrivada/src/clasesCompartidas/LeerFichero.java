package clasesCompartidas;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;




public class LeerFichero 
{
	
	//C serveix per discriminar el tipus de relaciÃ³ amb paper, utilitzarem la c de la segÃ¼ent manera (1 = PA, 2 = PC, 3 = PT)  
	
	//Aquest metode retorna un pair amb un HashMap original de relacions a la primera posiciÃ³ i un HashMap transposat a
	// la segona posiciÃ³ de la relaciÃ³ de dos tipus de node
	public static Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> crear_relacion(int c) throws IOException {
		String cadena;
		//Aquest metode llegeix el fitxer
		Integer vb = 0;
		String archivo = null;
		if (c == 1) archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/paper_author.txt";
		else if (c == 2) archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/paper_conf.txt";
		else archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/paper_term.txt";
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
	    	System.out.println("ja hi som " + vb + "\n");
	    	codi2 = Integer.parseInt(s1);
	    	System.out.println("ja hi som aqui " + vb + "\n");
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

	//Aquest mÃ¨tode retorna un pair amb un HashMap original de node primitiu a la primera posiciÃ³ i un HashMap transposat a
	// la segona posiciÃ³. Els codis dels tipus sÃ³n (0 = P, 1 = A, 2 = C, 3 = T) 
	public static Pair<HashMap<Integer,String>,HashMap<String,Integer>> crear_nodo_primitivo(int c) throws IOException {
		String cadena;
		//Aquest mÃ¨tode llegeix el fitxer
		String archivo = null;
		if (c == 0) archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/paper.txt";
		else if (c == 1) archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/author.txt";
		else if (c == 2) archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/conf.txt";
		else archivo = "C:/Users/USUARIO/Documents/PROP 2a/Set1/term.txt";
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
	    	//IntroduÃ¯m els elements al HashMap primer
	    	m.put(codi, s1);
	        //IntroduÃ¯m els elements al HashMap segon ja invertits
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
}
