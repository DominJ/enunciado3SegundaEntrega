package clasesCompartidas;

public class Nodo 
{
	private int id;
	private String nombre;
	private String tipo;
	
	public Nodo() // constructor por defecto
	{
		
	}
	
	public Nodo(String nombre) // constructor 
	{
		this.nombre = nombre;
	}
	
	public Nodo(int id, String nombre, String tipo) // constructor por defecto
	{
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public void anadir_id(int i)
	{
		this.id = i;
	}
	
	public void anadir_nombre(String s)
	{
		this.nombre = s;
	}
	
	public void anadir_tipo(String t)
	{
		this.tipo = t;
	}
	
	public int consultar_id()
	{
		return this.id;
	}
	
	public String consultar_nombre()
	{
		return this.nombre;
	}
	
	public String consultar_tipo()
	{
		return this.tipo;
	}
}
