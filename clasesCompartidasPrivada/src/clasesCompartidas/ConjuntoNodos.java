package clasesCompartidas;

import java.util.*;

public class ConjuntoNodos 
{
	private int ID_libre; //tengo que sacar este dato del fichero inicial. //inicializar a 1 al comienzo.
	private HashMap<Integer, String > nodos;
	private HashMap<String, Integer> nombres_nodos;
	
	/*PRE: Cierto*/
	/*POST: Se crea un conjunto de nodos vacio*/
	public ConjuntoNodos() //constructor por defecto
	{
		nodos = new HashMap<Integer, String>();
		nombres_nodos = new HashMap<String, Integer>();
		ID_libre = 1;
	}
	
	/*PRE: los hashmaps no son vacios e ID_libre es un numero entero positivo.*/
	/*POST: Se crea un conjunto de nodos con los valores de los atributos indicados por los parametros.*/
	public ConjuntoNodos(HashMap<Integer, String> nodos, HashMap<String, Integer> nombres_nodos)
	{
		this.nodos = nodos;
		this.nombres_nodos = nombres_nodos;
		int aux = 0;
		for(Integer id: nodos.keySet())
		{	
			if(id > aux)
				aux = id;
		}
		this.ID_libre = aux + 1;
	}
	
	/*PRE: No existe ningun nodo con ese nombre en el grafo*/
	/*POST: Se anade el nodo con el nombre pasado por parametro al grafo*/
	public void anadir_nodo(String nombre_nodo)
	{
		if(nombres_nodos.containsKey(nombre_nodo)) //compruebas que no exista POR NOMBRE
		{
			//no se puede añadir, se envia un mensaje diciendo que ya existe.
			System.out.println("Ya existe un nodo con este nombre");
		}
		else //no existe,se añade.
		{
			int id = ID_libre;
			++ID_libre;
			nodos.put(id, nombre_nodo);
			nombres_nodos.put(nombre_nodo, id);
		}
	}
	
	
	/*PRE: El nodo identificado por id existe previamente en el grafo*/
	/*POST:El nodo identificado por id es eliminado del grafo*/
	public void eliminar_nodo(String id)
	{
		if(nombres_nodos.containsKey(id))//si existe
		{
			nodos.remove(nombres_nodos.get(id)); //lo borro de nombres_nodos
			nombres_nodos.remove(id); //lo borro de nodos
		}
		else //no existe
		{
			System.out.println("No existe ningun nodo con este nombre.");
		}

	}

	
	/*PRE:Cierto*/
	/*POST: Devuelve true si existe un nodo con el nombre pasado por parametro, false en caso contrario*/
	public boolean existe_nodo(String nombre_nodo)
	{
		boolean existe = false;
		if(nombres_nodos.containsKey(nombre_nodo)) existe = true;
		return existe;
	}
	
	/*PRE:Cierto */
	/*POST:Devuelve true si existe un nodo con el id pasado por parametro, false en caso contrario*/
	public boolean existe_nodo(int id_nodo)
	{
		boolean existe = false;
		if(nodos.containsKey(id_nodo)) existe = true;
		return existe;
	}

	/*PRE: nuevo_nombre no existe previamente en el grafo, nombre_nodo existe previamente*/
	/*POST: Se modifica el nombre del nodo con el nuevo nombre pasado por parametro.*/
	public boolean modificar_nodo(String nombre_nodo, String nuevo_nombre)
	{	
		boolean modificado = false;
		if(nombres_nodos.containsKey(nombre_nodo))
		{
			int id = nombres_nodos.get(nombre_nodo);
		
			if(!nombres_nodos.containsKey(nuevo_nombre)) //si no existe.
			{
				modificado = true;
				nodos.remove(id);//borras el nodo para agregarlo con el nuevo nombre
				nodos.put(id, nuevo_nombre);
				nombres_nodos.remove(nombre_nodo);
				nombres_nodos.put(nuevo_nombre, id);
			}
		}
		return modificado;
	}
	
	/*PRE:Cierto*/
	/*POST: Devuelve el id del nombre del nodo pasado por parametro*/
	public int consultar_nodo(String nombre_nodo)
	{
		int id = nombres_nodos.get(nombre_nodo);
		return id;
	}
	
	/*PRE:Cierto*/
	/*POST: Devuelve el nombre del id del nodo pasado por parametro*/
	public String consultar_nodo(int id_nodo)
	{
		String nombre = nodos.get(id_nodo);
		return nombre;
	}

	
	/*PRE:Cierto*/
	/*POST: Devuelve el conjunto de nodos entero del parametro implicito*/
	/*Nota: esta funcion esta pensada para pasar la informacion necesaria para poder guardar los datos en un fichero al final de la 
	 * ejecucion del programa.*/
	public HashMap<Integer, String> devolver_conjunto()
	{
		return nodos;
	}	
	
	//NO ESTOY MUY SEGURO DE SI ES COMPARTIDO PROBABLEMENTE TENGA QUE HEREDAR
		public void joinHashMap(Pair<HashMap<Integer,String>,HashMap<String,Integer>> n)
		{
			this.nodos.putAll(n.getFirst());
			this.nombres_nodos.putAll(n.getSecond());
		}
}

