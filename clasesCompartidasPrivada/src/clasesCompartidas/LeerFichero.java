package clasesCompartidas;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;




public class LeerFichero 
{
	
	//Si tipusFitxer = 1, utilitzarem el tipusNode per saber la dada primitiva (0 = P, 1 = A, 2 = C, 3 = T)  
	
	//La string archivo hay que escribirla con las barras no invertidas, sino te salta error
	//IMPORTANTE, devolver un pair con dos hashmaps: HashMap<Integer,ArrayList<Integer>>
	// HashMap<Integer,ArrayList<Integer>>
	public static Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> crear_relacion(int c) throws IOException {
		String cadena;
		//Este metodo lee el archivo
		String archivo = null;
		if (c == 1) archivo = "/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_author.txt";
		if (c == 2) archivo = "/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_conf.txt";
		if (c == 3) archivo = "/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_term.txt";
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
	    	//Primer Hashmap del pair
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
		//Cerramos el buffer
		b.close();
		
		Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> v = new Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}

	//IMPORTANTE, devolver un pair con dos hashmaps: HashMap<Integer,String>
	// HashMap<String,Integer>
	public static Pair<HashMap<Integer,String>,HashMap<String,Integer>> crear_nodo_primitivo(int c) throws IOException {
		String cadena;
		//Este metodo lee el archivo
		String archivo = null;
		if (c == 0) archivo = "C:/Users/USUARIO/Downloads/PROP/DBLP_four_area/paper.txt";
		else if (c == 1) archivo = "C:/Users/USUARIO/Downloads/PROP/DBLP_four_area/author.txt";
		else if (c == 2) archivo = "C:/Users/USUARIO/Downloads/PROP/DBLP_four_area/conf.txt";
		else archivo = "C:/Users/USUARIO/Downloads/PROP/DBLP_four_area/term.txt";
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
		//Cerramos el buffer
		b.close();
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> v = new Pair<HashMap<Integer,String>,HashMap<String,Integer>>();
		v.setFirst(m);
		v.setSecond(n);
		return v;
	}

	
	
	public static void main(String [] args) throws IOException {
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> z = crear_nodo_primitivo(1);
		//HashMap<Integer,ArrayList<Integer>> r = crear_relacion(1);
		HashMap<Integer,String> s = z.getFirst();
		HashMap<String,Integer> s1 = z.getSecond();

		//ArrayList<Integer> m = new ArrayList<Integer>();
		String m = s.get(76);
		System.out.println("Author " + m + "\t");
		Integer n = s1.get(m);
		System.out.println("ID " + n + "\n");
		//m = r.get(7632);
		 /* for (Integer number : m) {
			   System.out.println("Number0 = " + number.);
		} */
		   
	}

}
