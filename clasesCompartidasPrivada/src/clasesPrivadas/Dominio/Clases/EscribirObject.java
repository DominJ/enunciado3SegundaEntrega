package clasesPrivadas.Dominio.Clases;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Xavi Campos Navarro
 *
 */

public class EscribirObject {

	public static void ReescribirObject(Object a,String s) 
	{
		try
		{
			System.out.println("Gu:"+s);
			FileOutputStream fos = new FileOutputStream(s);
			//BufferedOutputStream z = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
		}
		catch(Exception e)
		{
			System.out.println("Se ha producido un error en la escritura de Objeto.");
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
