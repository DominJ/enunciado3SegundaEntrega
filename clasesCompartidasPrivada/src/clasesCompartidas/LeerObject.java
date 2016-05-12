package clasesCompartidas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class LeerObject implements Serializable{

	@SuppressWarnings("unchecked")
	public static Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> LeerObject1() throws IOException {
		FileInputStream fis = new FileInputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t.tmp");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    //Integer s = ois.readInt();
	    //System.out.println("Num: " + s + "\n");
	     Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> b = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
	     try {
			b = (Pair<HashMap<Integer, ArrayList<Pair<Integer, Double>>>, HashMap<Integer, ArrayList<Pair<Integer, Double>>>>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println("Number0 = " + b.getFirst().get(10).get(1).getFirst() + "\n");
	     ois.close();
	     return b;
		}
	
	@SuppressWarnings("unchecked")
	public static Pair<HashMap<Integer,String>,HashMap<String,Integer>> LeerNodosPrimitivosObject() throws IOException {
		FileInputStream fis = new FileInputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t1.tmp");
	    ObjectInputStream ois = new ObjectInputStream(fis);
		Pair<HashMap<Integer, String>, HashMap<String, Integer>> b = new Pair<HashMap<Integer, String>, HashMap<String, Integer>>();
		try {
			b = (Pair<HashMap<Integer,String>,HashMap<String,Integer>>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("String0 = " + b.getFirst().get(10) + "\n");
	     ois.close();
	     return b;
		}
	
	public static void main(String [] args) throws IOException {
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> a = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		a =	LeerObject1();
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> m = LeerNodosPrimitivosObject();
	}
}
