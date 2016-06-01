package clasesPrivadas.Dominio.Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import clasesCompartidas.Pair;

/**
 * @author Xavi Campos Navarro
 *
 */
public class EscribirFichero {
	
	
	/*PRE: Existeix el HashMap que li passem */
	/*POST: Escibim sobre el fitxer corresponent segons el tipus el Hashmap de Relacions*/
	public static void ReescribirFicheroRelaciones(HashMap<Integer,ArrayList<Pair<Integer,Double>>> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("../Set1/paper_author.txt",false);
			else if (Tipus == 1) fw = new FileWriter("../Set1/paper_conf.txt",false);
			else  fw = new FileWriter("../Set1/paper_term.txt",false);
		    Iterator<Entry<Integer, ArrayList<Pair<Integer,Double>>>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, ArrayList<Pair<Integer,Double>>> e = it.next();
				ArrayList<Pair<Integer,Double>> b = new ArrayList<Pair<Integer,Double>>();
				int a = e.getKey();
				b = e.getValue();
				for (int j = 0; j < b.size(); j++){
					fw.write(a + "\t"+ b.get(j).getFirst() + "\r\n");
				}
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Se ha producido algun tipo de error en la escritura del fichero, IOException");
		}
	}
	
	/*PRE: Existeix el HashMap que li passem */
	/*POST: Escibim sobre el fitxer corresponent segons el tipus el Hashmap de Node Primitiu*/
	public static void ReescribirFicheroNodos(HashMap<Integer,String> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("../Set1/paper.txt",false);
			else if (Tipus == 1) fw = new FileWriter("../Set1/author.txt",false);
			else if (Tipus == 2)  fw = new FileWriter("../Set1/conf.txt",false);
			else fw = new FileWriter("../Set1/term.txt",false);
		    Iterator<Entry<Integer,String>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, String> e = it.next();
				String b = new String();
				int a = e.getKey();
				b = e.getValue();
				fw.write(a + "\t"+ b + "\r\n");
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Se ha producido algun tipo de error en la escritura del fichero, IOException");
		}
	}

}

