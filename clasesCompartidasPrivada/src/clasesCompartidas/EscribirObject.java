package clasesCompartidas;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;



public class EscribirObject {

	public static void ReescribirObject(Object a,String s) 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(s);
			BufferedOutputStream z = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(z);
			oos.writeObject(a);
			oos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/*public void ReescribirNodosPrimitivosObject(Object a,String) throws IOException {
		FileOutputStream fosi = new FileOutputStream("C:/Users/USUARIO/Documents/PROP def/enunciado3SegundaEntrega/clasesCompartidasPrivada/Set1/t1.tmp");
		BufferedOutputStream z = new BufferedOutputStream(fosi);
		ObjectOutputStream ooos = new ObjectOutputStream(z);
		ooos.writeObject(a);
		ooos.close();
	} */
	
	/*public void main(String [] args) throws IOException {
		Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>> a = new Pair<HashMap<Integer,ArrayList<Pair<Integer,Double>>>,HashMap<Integer,ArrayList<Pair<Integer,Double>>>>();
		a = LeerFichero.crear_relacion("Set1", 1);
		ReescribirObject1(a);
		Pair<HashMap<Integer,String>,HashMap<String,Integer>> m = LeerFichero.crear_nodo_primitivo("Set1", 1);
		ReescribirNodosPrimitivosObject(m); 
	}*/
}
