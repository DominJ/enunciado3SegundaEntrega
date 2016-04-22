package clasesCompartidas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public interface AritmeticaMatrices
{
	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b);

	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_normalizado(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b);

	public void Relacion_Dummy(HashMap<Integer,ArrayList<Pair<Integer,Double>>> M1, HashMap<Integer,ArrayList<Pair<Integer,Double>>> M2, HashMap<Integer,ArrayList<Pair<Integer,Double>>> R);

}
