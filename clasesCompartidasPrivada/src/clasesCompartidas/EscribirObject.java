package clasesCompartidas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;



public class EscribirObject implements Serializable{

	public static void ReescribirObject1(Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>, HashMap<Integer,ArrayList<Pair<Integer,Double>>>> a) throws IOException {
	FileOutputStream fos = new FileOutputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t.tmp");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	//int x = 10000;
	//oos.writeInt(x);
	oos.writeObject(a);
	oos.close();
	}
	
	public static void ReescribirNodosPrimitivosObject(Pair<HashMap<Integer,String>,HashMap<String,Integer>> ca) throws IOException {
		FileOutputStream fosi = new FileOutputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t1.tmp");
		ObjectOutputStream ooos = new ObjectOutputStream(fosi);
		ooos.writeObject(ca);
		ooos.close();
	}
	
	public static void main(String [] args) throws IOException {
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> a = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		a = LeerFichero.crear_relacion(1);
		ReescribirObject1(a);
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> m = LeerFichero.crear_nodo_primitivo(1);
		ReescribirNodosPrimitivosObject(m);
	}
}
