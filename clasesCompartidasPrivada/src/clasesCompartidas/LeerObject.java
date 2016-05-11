package clasesCompartidas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LeerObject {

	public static void LeerRelacionesObject(Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> a) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//int x = 10000;
		//oos.writeInt(x);
		oos.writeObject(a);
		oos.close();
		FileInputStream fis = new FileInputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t.tmp");
	     ObjectInputStream ois = new ObjectInputStream(fis);
	     //Integer s = ois.readInt();
	     //System.out.println("Num: " + s + "\n");
	     Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> b = (Pair<HashMap<Integer, ArrayList<Pair<Integer, Double>>>, HashMap<Integer, ArrayList<Pair<Integer, Double>>>>) ois.readObject();
	     System.out.println("Number0 = " + b.getFirst().get(10).get(1).getFirst() + "\n");
	     ois.close();
		}
	
	public static void LeerNodosPrimitivosObject(Pair<HashMap<Integer,String>,HashMap<String,Integer>> c) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t1.tmp");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    Pair<HashMap<Integer,String>,HashMap<String,Integer>> b = (Pair<HashMap<Integer,String>,HashMap<String,Integer>>) ois.readObject();
	    System.out.println("String0 = " + b.getFirst().get(0) + "\n");
	     ois.close();
		}
}
