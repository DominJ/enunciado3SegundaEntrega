package clasesCompartidas;

import java.util.*;

public class ConjuntoNodos 
{
	private int ID_libre; //tengo que sacar este dato del fichero inicial. //inicializar a 1 al comienzo.
	private HashMap<Integer,String> nodos;
	private HashMap<String,Integer> nombres_nodos;
	
	/*PRE: Cierto*/
	/*POST: Se crea un conjunto de nodos vacío*/
	public ConjuntoNodos() //constructor por defecto
	{
		nodos = new HashMap<Integer, String>();
		nombres_nodos = new HashMap<String, Integer>();
		ID_libre = 1;
	}
	
	/*PRE: los hashmaps no son vacíos e ID_libre es un número entero positivo.*/
	/*POST: Se crea un conjunto de nodos con los valores de los atributos indicados por los parámetros.*/
	public ConjuntoNodos(HashMap<Integer, String> nodos, HashMap<String, Integer> nombres_nodos, int ID_libre)
	{
		this.nodos = nodos;
		this.nombres_nodos = nombres_nodos;
		this.ID_libre = ID_libre;
	}
	
	/*PRE: No existe ningun nodo con ese nombre en el grafo*/
	/*POST: Se añade el nodo con el nombre pasado por parámetro al grafo*/
	public void anadir_nodo(String nombre_nodo)
	{
		if(nombres_nodos.containsKey(nombre_nodo)) //compruebas que no exista POR NOMBRE
		{
			//no se puede aÃ±adir, se envia un mensaje diciendo que ya existe.
			System.out.println("Ya existe un nodo con este nombre");
		}
		else //no existe,se aÃ±ade.
		{
			int id = ID_libre;
			++ID_libre;
			nodos.put(id, nombre_nodo);
			nombres_nodos.put(nombre_nodo, id);
		}
	}
	
	
	/*PRE: El nodo identificado por id existe previamente en el grafo*/
	/*POST:El nodo identificado por id es eliminado del grafo*/
	public void eliminar_nodo(int id)
	{
		if(nodos.containsKey(id))//si existe
		{
			nombres_nodos.remove(nodos.get(id)); //lo borro de nombres_nodos
			nodos.remove(id); //lo borro de nodos
		}
		else //no existe
		{
			System.out.println("No existe ningÃºn nodo con este nombre.");
		}

	}

	
	/*PRE:Cierto*/
	/*POST: Devuelve true si existe un nodo con el nombre pasado por parámetro, false en caso contrario*/
	public boolean existe_nodo(String nombre_nodo)
	{
		boolean existe = false;
		if(nombres_nodos.get(nombre_nodo)!= null) existe = true;
		return existe;
	}
	
	/*PRE:Cierto */
	/*POST:Devuelve true si existe un nodo con el id pasado por parámetro, false en caso contrario*/
	public boolean existe_nodo(int id_nodo)
	{
		boolean existe = false;
		if(nodos.get(id_nodo)!= null) existe = true;
		return existe;
	}

	/*PRE: nuevo_nombre no existe previamente en el grafo, nombre_nodo existe previamente*/
	/*POST: Se modifica el nombre del nodo con el nuevo nombre pasado por parámetro.*/
	public boolean modificar_nodo(String nombre_nodo, String nuevo_nombre)
	{	
		boolean modificado = false;
		Integer id = nombres_nodos.get(nombre_nodo);
		if(id != null)//si existe
		{
			if(nombres_nodos.get(nuevo_nombre) == null) //si no existe.
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
	/*POST: Devuelve el id del nombre del nodo pasado por parámetro*/
	public int consultar_nodo(String nombre_nodo)
	{
		int id = nombres_nodos.get(nombre_nodo);
		return id;
	}
	
	/*PRE:Cierto*/
	/*POST: Devuelve el nombre del id del nodo pasado por parámetro*/
	public String consultar_nodo(int id_nodo)
	{
		String nombre = nodos.get(id_nodo);
		return nombre;
	}

	
	/*PRE:Cierto*/
	/*POST: Devuelve el conjunto de nodos entero del parámetro implícito*/
	/*Nota: Ésta función está pensada para pasar la información necesaria para poder guardar los datos en un fichero al final de la 
	 * ejecución del programa.*/
	public HashMap<Integer, String> devolver_conjunto()
	{
		return nodos;
	}	
}
