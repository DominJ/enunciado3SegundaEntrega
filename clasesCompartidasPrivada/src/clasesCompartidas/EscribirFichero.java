package clasesCompartidas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Xavi Campos Navarro
 *
 */
public class EscribirFichero {
	
	
	/*PRE: Existeix el HashMap que li passem */
	/*POST: Escibim sobre el fitxer corresponent segons el tipus el Hashmap de Relacions*/
	public static void ReescribirFicheroRelaciones(HashMap<Integer,ArrayList<Integer>> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("../Set1/paper_author.txt",false);
			else if (Tipus == 1) fw = new FileWriter("../Set1/paper_conf.txt",false);
			else  fw = new FileWriter("../Set1/paper_term.txt",false);
		    Iterator<Entry<Integer, ArrayList<Integer>>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, ArrayList<Integer>> e = it.next();
				ArrayList<Integer> b = new ArrayList<Integer>();
				int a = e.getKey();
				b = e.getValue();
				for (int j = 0; j < b.size(); j++){
					fw.write(a + "\t"+ b.get(j) + "\r\n");
				}
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Error de:"+e);
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
			System.out.println("Error de:"+e);
		}
	}

}

