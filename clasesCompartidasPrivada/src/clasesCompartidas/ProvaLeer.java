package clasesCompartidas;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ProvaLeer {
	public static void main(String [] args) throws IOException {
		// Nodos primitivos // 
		//Caso 0: Nodo paper
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> a = LeerFichero.crear_nodo_primitivo(0);
		HashMap<Integer,String> s = a.getFirst();
		HashMap<String,Integer> s1 = a.getSecond();
		String m = s.get(1);
		System.out.println("Paper ejemplo:\n");
		Integer n = s1.get(m);
		System.out.println("ID " + n + " String " + m + "\n");
		//---------------------------------------------------------------------------//
		
		//Caso 1: Nodo author
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> b = LeerFichero.crear_nodo_primitivo(1);
		HashMap<Integer,String> s2 = b.getFirst();
		HashMap<String,Integer> s3 = b.getSecond();
		m = s2.get(2);
		System.out.println("Author ejemplo:\n");
		n = s3.get(m);
		System.out.println("ID " + n + " String " + m + "\n");
		//---------------------------------------------------------------------------//

		//Caso 2: Nodo conf
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> c = LeerFichero.crear_nodo_primitivo(2);
		HashMap<Integer,String> s4 = c.getFirst();
		HashMap<String,Integer> s5 = c.getSecond();
		m = s4.get(2);
		System.out.println("Conf ejemplo:\n");
		n = s5.get(m);
		System.out.println("ID " + n + " String " + m + "\n");
		//---------------------------------------------------------------------------//

		//Caso 3: Nodo term
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> d = LeerFichero.crear_nodo_primitivo(3);
		HashMap<Integer,String> s6 = d.getFirst();
		HashMap<String,Integer> s7 = d.getSecond();
		m = s6.get(2);
		System.out.println("Term ejemplo:\n");
		n = s7.get(m);
		System.out.println("ID " + n + " String " + m + "\n");
		//---------------------------------------------------------------------------//

		
		// Relaciones entre nodos primitivos // 
		System.out.println("Relaciones\n");
		// Relación Author-Paper
		System.out.println("Author-Paper\n");
		Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> e = LeerFichero.crear_relacion(1);
		HashMap<Integer,ArrayList<Integer>> z0 = e.getFirst();
		HashMap<Integer,ArrayList<Integer>> z1 = e.getSecond();
		ArrayList<Integer> j = new ArrayList<Integer>();
		j = z0.get(2);
		for (Integer number : j) {
			   System.out.println("Number = " + number + "\n");
		} 
		j = z1.get(0);
		for (Integer number : j) {
			   System.out.println("Number1 = " + number + "\n");
		} 
		//---------------------------------------------------------------------------//
		
		// Relación Conf-Paper
		System.out.println("Conf-Paper\n");
		Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> p = LeerFichero.crear_relacion(2);
		System.out.println("Conf-Paper1\n");
		HashMap<Integer,ArrayList<Integer>> z2 = p.getFirst();
		System.out.println("Conf-Paper2\n");
		HashMap<Integer,ArrayList<Integer>> z3 = p.getSecond();
		System.out.println("Conf-Paper3\n");
		ArrayList<Integer> k = new ArrayList<Integer>();
		System.out.println("Conf-Paper4\n");
		k = z2.get(1);
		for (Integer number : k) {
			   System.out.println("Number2 = " + number + "\n");
		} 
		k = z3.get(1);
		for (Integer number : k) {
			   System.out.println("Number3 = " + number + "\n");
		} 
	    //---------------------------------------------------------------------------//
		 
		
		// Relación Term-Paper
		System.out.println("Term-Paper\n");
		Pair<HashMap<Integer,ArrayList<Integer>>,HashMap<Integer,ArrayList<Integer>>> g = LeerFichero.crear_relacion(3);
		HashMap<Integer,ArrayList<Integer>> z4 = g.getFirst();
		HashMap<Integer,ArrayList<Integer>> z5 = g.getSecond();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l = z4.get(2);
		for (Integer number : l) {
			   System.out.println("Number4 = " + number + "\n");
		} 
		l = z5.get(1);
		for (Integer number : l) {
			   System.out.println("Number5 = " + number + "\n");
		} 
		   
		   
	}
}
