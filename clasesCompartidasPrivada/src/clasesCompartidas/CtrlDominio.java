package clasesCompartidas;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import Pair.Pair;

public class CtrlDominio
{ 
	public static void main(String args[] )throws IOException
	{ 
		Grafo gh = new Grafo(); //grafo heterogeneo que contiene todos los datos en memoria
		ConjuntoResultados cr = new ConjuntoResultados(); //Guarda los resultados del algoritmo HeteSim
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

		int op;
		int op2;
		int op3;
		Scanner sc = new Scanner(System.in);
do{	
		//Menú inicial
		System.out.print("Menu principal\n" );
		System.out.print("Seleccione la operacion ha realizar:\n" );
		System.out.print("1.- Modificar base de datos\n" ); 
		System.out.print("2.- Realizar una consulta\n" ); 
		System.out.print("3.- Buscar en el historial\n" );
		System.out.print("4.- Salir\n" );
	
		//Obtenemos la opción seleccionada por el user
		op=Integer.parseInt(in.readLine());
	
		switch(op)
		{ 
		
			case 1: //Modificar la base de datos
				System.out.print("\nSeleccione la operacion de modificacion desada:\n" );
				System.out.print("1.- Anadir\n" );
				System.out.print("2.- Actualizar\n" );
				System.out.print("3.- Eliminar\n" );
				System.out.print("4.- Limpiar historial\n" );
			
			
			op2=Integer.parseInt(in.readLine());
			
			switch(op2)
			{
			
				case 1: //Modificar la base de datos - añadir
					System.out.print("\nSeleccione lo que desea anadir:\n" );
					System.out.print("1.- Dato independiente\n" );
					System.out.print("2.- Conjunto de datos(fichero adjunto)\n" );
					
					op3=Integer.parseInt(in.readLine());
				
				switch(op3)
				{
				
					case 1: //Modificar la base de datos - añadir - dato independiente
						/*
							System.out.print("\nIntroduce el dato independiente:\n" );
							Nodo n = new Nodo();
							System.out.print("Introduce el tipo de dato y su nombre:\n");
							String nombre, tipo;
							//Scanner sc = new Scanner(System.in);
							nombre = sc.toString();
							tipo = sc.toString();
							n.anadir_nombre(nombre);
							n.anadir_tipo(tipo);
							//TODO leer dato que usuario aÃ±ade al sistema
						 * */ //Reescribiendo esta parte
						
							int option;
							String name;
							System.out.println("selecciona tipo de dato:\n");
							System.out.print("1.- Paper\n" );
							System.out.print("2.- Author\n" );
							System.out.print("3.- Conference\n" );
							System.out.print("4.- Therm\n" );
							option=Integer.parseInt(in.readLine());
							System.out.print("4.- Introduce nombre del nodo\n" );
							name = in.readLine();
							gh.anadirNodo(option-1, name);
							
							break;
					
					case 2: //Modificar la base de datos - añadir - conjunto de datos
						System.out.print("\nAdjunta el fichero con el conjunto de datos:\n" );
						//TODO leer fichero que se quiere aÃ±adir
						
						break;
				}
				
				break;
				
				case 2: //Modificar la base de datos - actualizar
					//TODO actualizar el sistema con las modificaciones que pueda haber sufrido
				break;
				
				case 3: //Modificar la base de datos - eliminar
					//TODO eliminar el dato que el usuario crea conveniente
					//Habr�a que hacer una eliminacion en cascada, ojo con esto
					int option;
					String name;
					System.out.println("selecciona tipo de dato:\n");
					System.out.print("1.- Paper\n" );
					System.out.print("2.- Author\n" );
					System.out.print("3.- Conference\n" );
					System.out.print("4.- Therm\n" );
					option=Integer.parseInt(in.readLine());
					System.out.print("4.- Introduce nombre del nodo\n" );
					name = in.readLine();
					
					//System.out.println(option-1 + " " +gh.consultarNodo(option-1, name));
					try
					{
						gh.eliminarNodo(option-1, gh.consultarNodo(option-1, name));
						cr.vaciar_resultados();
					}
					catch(NullPointerException e)
					{
						System.out.println("Alguna de las relaciones esta vacia");
					}
					
				break;
				
				case 4: //Modificar la base de datos - limpiar historial
					cr.vaciar_resultados(); //Revisar esto
				break;
				//default:
			}
			break;
			
			case 2://realizar consulta
				System.out.print("1.- Elegir camino predeterminado\n" );
				System.out.print("2.- Crear un camino nuevo\n" );
				
				op3=Integer.parseInt(in.readLine());
				
				switch(op3)
				{
				
					case 1: //realizar consulta - camino predeterminado
						//TODO usuario elige un camino de la lista de caminos predetermidos
						System.out.print("Seleccion camino predeterminado:\n");
						int numpath = sc.nextInt();
						//Dejamos los precalculos para mas adelante
						
					break;
				
					case 2: //realizar consulta - camino nuevo
						//TODO usuario crea su propio camino 
						String path;
						System.out.println("Introduce path:");
						path = sc.nextLine();
						System.out.println("path leido");
						if(!cr.existeResultado(path)) //Si no est� ya almacenado se calcula y almacena
						{
							cr.anadirResultado(path, CtrlHetesim.HeteSim(path, gh));
							cr.printa_matriz1(path);
						}
					break;
				//default:
				}
			
			break;
		
			case 3://buscar en el historial
				System.out.print("Elige el camino que quieres consultar del historial:\n" );
				//TODO lista de caminos guardados y usuario elige uno y lo consulta
				Set<String> a = cr.consultarCaminosAlmacenados();
				
				//ES UNA PRUEBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
				String[] b = (String[]) a.toArray();
				for(int i= 0 ; i< b.length ; i++)
				{
					System.out.println(b[i]);
				}
				//------------
				int historialpath = sc.nextInt();
			
			break;
		//case 4://salir del programa
		//	System.exit(0); 
		}
	}while (op != 4);
}
}