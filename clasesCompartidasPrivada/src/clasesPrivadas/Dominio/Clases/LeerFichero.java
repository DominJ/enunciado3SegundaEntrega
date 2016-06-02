package clasesPrivadas.Dominio.Clases;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import clasesCompartidas.Pair;

import java.util.HashSet;
import java.util.HashMap;

/**
 * @author Daniel Pulido SÃ¡nchez-Carnerero
 *
 */
public class LeerFichero 
{
	
	/*PRE: c es un integer que discrimina el tipus*/
	/*POST: Es crea un pair de dos HashMaps, amb la relacio P-NodePrimitiu al First i NodePrimitiu-P al Second*/
	public static Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> crear_relacion(String ruta, int c) throws IOException {
		String cadena;
		//Aquest metode llegeix el fitxer
		Integer vb = 0;
		String archivo = null;
		if (c == 1){
			archivo = ruta + System.getProperty("file.separator") + "paper_author.txt";
		}
		else if (c == 2) archivo = ruta + System.getProperty("file.separator") +"paper_conf.txt";
		else archivo = ruta + System.getProperty("file.separator") +"paper_term.txt";
		FileReader f = new FileReader(archivo); 
		BufferedReader b = new BufferedReader(f); 
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> m = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		HashMap<Integer,ArrayList<Pair<Integer,Double>>> n = new HashMap<Integer,ArrayList<Pair<Integer,Double>>>();
		Integer codi,codi2,codi_antic;
		codi = codi2 = codi_antic = 0;
		Boolean primer = true;
		String s2 = new String();
		Pair<Integer,Double> x = new Pair<Integer,Double>();
		Pair<Integer,Double> x1 = new Pair<Integer,Double>();
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
	    	//Segon Hashmap del pair
	    	if (n.get(codi2) == null) n.put(codi2, new ArrayList<Pair<Integer,Double>>());
	    	//n.get(codi2).add(codi);
	    	x.setFirst(codi);
	    	x.setSecond(1.0);
	    	n.get(codi2).add(x);
	    	x = new Pair<Integer,Double>();
	    	//Primer HashMap del pair
	    	if(primer){
	    		s2 = copy.substring(0,i);
	    		codi_antic = codi;
	    		primer = false;
	    	}
	    	if(!(s.equals(s2))){
	    		m.put(codi_antic, l);
	    		l = new ArrayList<Pair<Integer,Double>>();
	    	}
	    	x1.setFirst(codi2);
	    	x1.setSecond(1.0);
	    	l.add(x1);
	    	x1 = new Pair<Integer,Double>();
	    	codi_antic = codi;
	    	s2 = copy.substring(0,i);
		}
		m.put(codi_antic, l);
		//Tanquem el buffer
		b.close();
		//Omplim el pair amb els dos HashMaps obtinguts
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> v = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}
	
	
	//Aquest mÃƒÂ¨tode retorna un pair amb un HashMap original de node primitiu a la primera posiciÃƒÂ³ i un HashMap transposat a
	// la segona posiciÃƒÂ³. Els codis dels tipus sÃƒÂ³n (0 = P, 1 = A, 2 = C, 3 = T) 
	public static Pair<HashMap<Integer,String>,HashMap<String,Integer>> crear_nodo_primitivo(String ruta, int c) throws IOException {
		String cadena;
		//Aquest mÃƒÂ¨tode llegeix el fitxer
		String archivo = null;
		if (c == 0) archivo = ruta + System.getProperty("file.separator") +"paper.txt";
		else if (c == 1) archivo = ruta + System.getProperty("file.separator") +"author.txt";
		else if (c == 2) archivo = ruta + System.getProperty("file.separator") +"conf.txt";
		else archivo = ruta + System.getProperty("file.separator") +"term.txt";
		System.out.println(archivo);
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
	
	public static Set<String> LeerFiltro(String ruta, int c)throws IOException {
		String cadena;
		String archivo = null;
		if (c == 0) archivo = ruta + System.getProperty("file.separator") +"paper.txt";
		else if (c == 1) archivo = ruta + System.getProperty("file.separator") +"author.txt";
		else if (c == 2) archivo = ruta + System.getProperty("file.separator") +"conf.txt";
		else archivo = ruta + System.getProperty("file.separator") +"term.txt";
		FileReader f = new FileReader(archivo); 
		BufferedReader b = new BufferedReader(f); 
		Set<String> r= new HashSet<String>();
		while(((cadena = b.readLine())!=null)){
	    	int i = 0;
	    	String copy = cadena;
	    	r.add(copy);
		}
		//Tanquem el buffer
		b.close();
		return r;
		
	}
	
	public static void correcto(String sDirectorio, String directorioBase) throws FileNotFoundException, IOException {  
	    //String sDirectorio = "Set1";
	    File f = new File(directorioBase);
	    File[] ficheros = f.listFiles();
	    //Boolean comp = true;
	    String aux = sDirectorio + System.getProperty("file.separator");
	    String cadena;
	    
	    for(int i = 0; i < ficheros.length; i++) {
	    	String a = ficheros[i].getName();
	    	cadena = aux+""+a;
			//System.out.println(cadena+"\n");
			//System.out.println(i+"\n");
	    	FileReader c = new FileReader(cadena); 
			BufferedReader d = new BufferedReader(c); 
			d.readLine();
			d.close();
	    }
	    //d.close();
	}
	
}
