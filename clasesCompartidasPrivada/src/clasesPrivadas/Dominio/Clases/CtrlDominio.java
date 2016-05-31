package clasesPrivadas.Dominio.Clases;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import clasesCompartidas.EscribirObject;
import clasesCompartidas.LeerObject;
import clasesCompartidas.Pair;
import excepciones.NonExistObjectToReadException;
/**
 * @author Xavi Campos Navarro
 *
 */

public class CtrlDominio
{ 
	//LeerFichero LF = new LeerFichero();
	//Grafo gh = new Grafo();
	//ConjuntoResultados cr = new ConjuntoResultados();
	Grafo gh;
	ConjuntoResultados cr;
	CtrlHetesim ch;
	CtrlHetesim chf;

	public void limpiarhistorialD(){
		cr.vaciar_resultados();
	}
	
	public void inicializarCtrlDominio(String ruta) throws NonExistObjectToReadException, ClassNotFoundException, IOException
	{
		//Debe verificar la correcta ejecuccion.
		if(ruta != null) {
		
			LeerObject.verificarObjects();
			//No es la primera ejecuión
			this.gh = (Grafo) LeerObject.LeerObjeto(ruta);
			this.cr = new ConjuntoResultados();
			this.ch = new CtrlHetesim(gh);
			cr.anadirResultado("AP", ch.HeteSim("AP"));
			cr.anadirResultado("PA", ch.HeteSim("PA"));
			cr.anadirResultado("PC", ch.HeteSim("PC"));
			cr.anadirResultado("CP", ch.HeteSim("CP"));
			cr.anadirResultado("TP", ch.HeteSim("TP"));
			cr.anadirResultado("PT", ch.HeteSim("PT"));

		}
		else
		{
			//Es la primera ejecución
			System.out.println("Primera ejecucion en este equipo");
			this.gh = new Grafo(); //grafo heterogeneo que contiene todos los datos en memoria
			System.out.println("Inicializando conjunto resultados\n");
			this.cr = new ConjuntoResultados(); //Guarda los resultados del algoritmo HeteSim
			this.ch = new CtrlHetesim(gh);
			cr.anadirResultado("AP", ch.HeteSim("AP"));
			cr.anadirResultado("PA", ch.HeteSim("PA"));
			cr.anadirResultado("PC", ch.HeteSim("PC"));
			cr.anadirResultado("CP", ch.HeteSim("CP"));
			cr.anadirResultado("TP", ch.HeteSim("TP"));
			cr.anadirResultado("PT", ch.HeteSim("PT"));
		} 
		
	}
	
	
	public ArrayList<Pair<Double,String>> traducir(ArrayList<Pair<Double,Integer>> a,String camino){
		ArrayList<Pair<Double,String>> b = new ArrayList<Pair<Double,String>>();
		for(int i = 0; i < a.size(); i++){
			Pair<Double,Integer> aux = a.get(i);
			Pair<Double,String> aux1 = new Pair<Double,String>();
			int type1 = TypePosPath(camino, camino.length()-1);
			System.out.println("Tipo:" + type1+" ");
			String aux2 = gh.consultarNodo(type1, aux.getSecond());
			aux1.setFirst(aux.getFirst());
			aux1.setSecond(aux2);
			b.add(aux1);
		}
			return b;
	}
	
	public HashMap<String, Set<String>> traducirINTaSTRING(HashMap<String, Set<Integer>> a){
		HashMap<String, Set<String>> b = new HashMap<String,Set<String>>();
		//Set<String> a2;
		for (String j: a.keySet() ) {
			int type1 = TypePosPath(j, 0);
			Set<Integer> a1 = a.get(j);
			//PACT//
			Set<String> a3 = new HashSet<String>();
			for(int i: a1) {
				String id = gh.consultarNodo(type1, i);
				a3.add(id);
			}
			b.put(j, a3);
		}
		return b;
	}
	
	public int traducirSTRINGaINT(String id1, String camino){
			System.out.println("Camino:"+camino+"\n");
			System.out.println("IDstring:"+id1+"\n");
			int type1 = TypePosPath(camino, 0);
			System.out.println("Tipo:"+type1+"\n");
			int id = gh.consultarNodo(type1, id1);
			return id;
	}
	
	public HashMap<String, Set<String>> actualizarhistorial()
	{
		HashMap<String, Set<Integer>> a = cr.consultarResultadosParciales();
		HashMap<String, Set<String>> b = traducirINTaSTRING(a);
		return b;
	}
	
	public ArrayList<Pair<Double,Integer>> consultarresultado (String nodo, String camino)
	{
		int i = traducirSTRINGaINT(nodo,camino);
		System.out.println("ResultadoNodo "+nodo + " " + camino + " \n");
		ArrayList<Pair<Double,Integer>> c = cr.getResultadoNodo(camino, i);
		return c;
		
	}
	
	public void guardar(String s) throws IOException{
		Object a = (Object)gh;
		 EscribirObject.ReescribirObject(a,s);
	}
	public void eliminarnodoD(int a, String b){
		gh.eliminarNodo(a, gh.consultarNodo(a, b));
		cr.vaciar_resultados();
		cr.anadirResultado("AP", ch.HeteSim("AP"));
		cr.anadirResultado("PA", ch.HeteSim("PA"));
		cr.anadirResultado("PC", ch.HeteSim("PC"));
		cr.anadirResultado("CP", ch.HeteSim("CP"));
		cr.anadirResultado("TP", ch.HeteSim("TP"));
		cr.anadirResultado("PT", ch.HeteSim("PT"));
	}
	
	//int a e int indican el tipo de nodo
	public void anadirnodoD(int tipo1, String nombre1, int tipo2, String nombre2)
	{
		//Con esta verificación garantizo que el tipo 1 es paper
		if(tipo1 != 0)//es paper
		{
			//Le doy la vuelta
			int tipoAux = tipo2;
			String nombreAux = nombre2;
			tipo2 = tipo1;
			nombre2 = nombre1;
			tipo1 = tipoAux;
			nombre1 =  nombreAux;
		}
		gh.anadirNodo(tipo1, nombre1);
		gh.anadirNodo(tipo2, nombre2);
		gh.anadirRelacion(gh.consultarNodo(tipo1, nombre1),gh.consultarNodo(tipo2, nombre2),tipo2);
		cr.vaciar_resultados();
		cr.anadirResultado("AP", ch.HeteSim("AP"));
		cr.anadirResultado("PA", ch.HeteSim("PA"));
		cr.anadirResultado("PC", ch.HeteSim("PC"));
		cr.anadirResultado("CP", ch.HeteSim("CP"));
		cr.anadirResultado("TP", ch.HeteSim("TP"));
		cr.anadirResultado("PT", ch.HeteSim("PT"));
	}
	
	public void crearcaminonuevo(String nodo,String camino, double men, double may,Boolean b) {
	//B = true Normal
	//B = false Vengo de filtros
	int typeb=TypePosPath(camino,0);
	int pos=gh.consultarNodo(typeb, nodo);
	if (b) cr.anadirResultado(camino, ch.HeteSim(camino, pos),pos);
	else cr.anadirResultado(camino, chf.HeteSim(camino, pos),pos);
	cr.setIntervalo(men, may);
	}
	
	public void anadirconjuntodatos(String a, int s)
	{
		//0 = P, 1 = A, 2 = C, 3 = T, 4 = PA, 5 = PC, 6 = PT, 7 = AP, 8 = AC,
		//9 = AT, 10 = CP, 11 = CA, 12 = CT, 13 = TP, 14 = TA, 15 = TC
		gh.addDataGraph();
		cr.vaciar_resultados();
		cr.anadirResultado("AP", ch.HeteSim("AP"));
		cr.anadirResultado("PA", ch.HeteSim("PA"));
		cr.anadirResultado("PC", ch.HeteSim("PC"));
		cr.anadirResultado("CP", ch.HeteSim("CP"));
		cr.anadirResultado("TP", ch.HeteSim("TP"));
		cr.anadirResultado("PT", ch.HeteSim("PT"));
	}
	
	
	private static void escribir_resultado(ArrayList<Pair <Double,Integer>> a, Grafo gh, int type) {
		System.out.println("Rank		Nodo		Relevancia");
		for (int i=0; i<a.size(); ++i) {
			Pair<Double, Integer> pa=a.get(i);
			System.out.print(i+1 +"		"+ gh.consultarNodo(type, pa.getSecond())+ "		");
			System.out.printf("%2f\n", pa.getFirst());
		}
		System.out.println();
	}
	
	private static int TypePosPath(String path, int pos) {
		String s = path.substring(pos,pos+1);
		System.out.println("Path: "+path+"\n");

		if (s.equals("P")) {
			return 0;
		}
		else if (s.equals("A")) {
			return 1;
		}
		else if (s.equals("C")) {
			return 2;
		}
		else  {
			return 3;
		}
	}
	
	public void consultarcaminofiltros(Set<Integer>c) {
		System.out.println("Hola");
		GrafoPri gp=new GrafoPri(gh, c);	
		System.out.println("Hola1");
		chf = new CtrlHetesim(gp);
		System.out.println("Hola2");
	}

	
	public static void main(String args[] )throws IOException
	{ 
		Grafo gh = new Grafo(); //grafo heterogeneo que contiene todos los datos en memoria
		ConjuntoResultados cr = new ConjuntoResultados(); //Guarda los resultados del algoritmo HeteSim
		CtrlHetesim ch= new CtrlHetesim(gh);
		cr.anadirResultado("AP", ch.HeteSim("AP"));
		cr.anadirResultado("PA", ch.HeteSim("PA"));
		cr.anadirResultado("PC", ch.HeteSim("PC"));
		cr.anadirResultado("CP", ch.HeteSim("CP"));
		cr.anadirResultado("TP", ch.HeteSim("TP"));
		cr.anadirResultado("PT", ch.HeteSim("PT"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

		int op;
		int op2;
		int op3;
		Scanner sc = new Scanner(System.in);
do{	
		//Menu inicial
		System.out.print("Menu principal\n" );
		System.out.print("Seleccione la operacion ha realizar:\n" );
		System.out.print("1.- Modificar base de datos\n" ); 
		System.out.print("2.- Realizar una consulta\n" ); 
		System.out.print("3.- Buscar en el historial\n" );
		System.out.print("4.- Salir\n" );
		//Obtenemos la opcion seleccionada por el user
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
			
				case 1: //Modificar la base de datos - anadir
					System.out.print("\nSeleccione lo que desea anadir:\n" );
					System.out.print("1.- Dato independiente\n" );
					System.out.print("2.- Conjunto de datos(fichero adjunto)\n" );
					
					op3=Integer.parseInt(in.readLine());
				
				switch(op3)
				{
				
					case 1: //Modificar la base de datos - anadir - dato independiente
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
							//TODO leer dato que usuario anade al sistema
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
					
					case 2: //Modificar la base de datos - anadir - conjunto de datos
						System.out.print("\nAdjunta el fichero con el conjunto de datos:\n" );
						//TODO leer fichero que se quiere anadir
						
						break;
				}
				
				break;
				
				case 2: //Modificar la base de datos - actualizar
					//TODO actualizar el sistema con las modificaciones que pueda haber sufrido
				break;
				
				case 3: //Modificar la base de datos - eliminar
					//TODO eliminar el dato que el usuario crea conveniente
					//Habria que hacer una eliminacion en cascada, ojo con esto
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
				System.out.print("3.- Busqueda con filtros\n" );
				
				op3=Integer.parseInt(in.readLine());
				
				switch(op3)
				{
				
					case 1: //realizar consulta - camino predeterminado
						//TODO usuario elige un camino de la lista de caminos predetermidos
						System.out.print("Seleccion camino predeterminado:\n");
						Set<String> a = cr.consultarCaminosAlmacenados();
						System.out.println("----------");
						for(String i: a)
						{
							System.out.println(i);
						}
						System.out.println("----------\n");
						System.out.println("Introduce path:");
						String path = sc.nextLine();
						if (a.contains(path)) {
							int typeb=TypePosPath(path,0);
							System.out.print("4.- Introduce nombre del nodo\n" );
							String name = in.readLine();
							int pos=gh.consultarNodo(typeb, name);
							double x1, x2;
							System.out.println("Introduce el extremo menor del intervalo de relevancia" );
							x1=Double.parseDouble(in.readLine());
							System.out.println("Introduce el extremo mayor del intervalo de relevancia" );
							x2=Double.parseDouble(in.readLine());
							cr.setIntervalo(x1, x2);
							System.out.println("Relevancia de "+ name +" en el camino "+ path +":");
							int typee=TypePosPath(path, path.length()-1);
							escribir_resultado(cr.getResultadoNodo(path, pos), gh, typee);
						}
						else System.out.println("El camino dado no es predeterminado");
						
					break;
				
					case 2: //realizar consulta - camino nuevo
						//TODO usuario crea su propio camino 
						String path1;
						System.out.println("Introduce path:");
						path1 = sc.nextLine();
						int typeb=TypePosPath(path1,0);
						System.out.print("4.- Introduce nombre del nodo\n" );
						String name = in.readLine();
						int pos=gh.consultarNodo(typeb, name);
						cr.anadirResultado(path1, ch.HeteSim(path1, pos),pos);
						System.out.println("Introduce el extremo menor del intervalo de relevancia" );
						double x1,x2;
						x1=Double.parseDouble(in.readLine());
						System.out.println("Introduce el extremo mayor del intervalo de relevancia" );
						x2=Double.parseDouble(in.readLine());
						cr.setIntervalo(x1, x2);
						System.out.println("Relevancia de "+ name +" en el camino "+ path1 +":");
						int typee=TypePosPath(path1, path1.length()-1);
						escribir_resultado(cr.getResultadoNodo(path1, pos), gh, typee);
					break;
					
					case 3: //realizar consulta - filtro
						Set<Integer> v=new HashSet<Integer>();
						/*v.add(0);
						v.add(1);
						v.add(2);*/
						GrafoPri gp=new GrafoPri(gh, v);
						HashMap<Integer, ArrayList<Pair<Integer, Double>>> a1=gp.getRelaciones("PA", true);
						
						CtrlHetesim cp=new CtrlHetesim(gp);
						String path11;
						System.out.println("Introduce path:");
						path11 = sc.nextLine();
						int typeb1=TypePosPath(path11,0);
						System.out.print("4.- Introduce nombre del nodo\n" );
						String name1 = in.readLine();
						int pos1=gh.consultarNodo(typeb1, name1);
						cr.anadirResultado(path11, cp.HeteSim(path11, pos1),pos1);
						System.out.println("Introduce el extremo menor del intervalo de relevancia" );
						double x11,x21;
						x11=Double.parseDouble(in.readLine());
						System.out.println("Introduce el extremo mayor del intervalo de relevancia" );
						x21=Double.parseDouble(in.readLine());
						cr.setIntervalo(x11, x21);
						System.out.println("Relevancia de "+ name1 +" en el camino "+ path11 +":");
						int typee1=TypePosPath(path11, path11.length()-1);
						escribir_resultado(cr.getResultadoNodo(path11, pos1), gp, typee1);
					break;
				}
			
			break;
		
			case 3://buscar en el historial
				System.out.print("Elige el camino que quieres consultar del historial:\n" );
				//TODO lista de caminos guardados y usuario elige uno y lo consulta
				HashMap<String, Set<Integer>> a = cr.consultarResultadosParciales();
				System.out.println("----------");
				for(String i: a.keySet())
				{
					System.out.print(i);
					Set<Integer> s=a.get(i);
					Set<String> sn= new TreeSet<String>();
					for (int k: s){
						int type=TypePosPath(i,0);
						sn.add(gh.consultarNodo(type, k));
					}
					System.out.println(": "+sn.toString());
				}
				System.out.println("----------\n");
				System.out.println("Introduce path:");
				String path = sc.nextLine();
				if (a.containsKey(path)) {
					int typeb=TypePosPath(path,0);
					System.out.print("4.- Introduce nombre del nodo\n" );
					String name = in.readLine();
					int pos=gh.consultarNodo(typeb, name);
					if (a.get(path).contains(pos)){
						double x1, x2;
						System.out.println("Introduce el extremo menor del intervalo de relevancia" );
						x1=Double.parseDouble(in.readLine());
						System.out.println("Introduce el extremo mayor del intervalo de relevancia" );
						x2=Double.parseDouble(in.readLine());
						cr.setIntervalo(x1, x2);
						System.out.println("Relevancia de "+ name +" en el camino "+ path +":");
						int typee=TypePosPath(path, path.length()-1);
						escribir_resultado(cr.getResultadoNodo(path, pos), gh, typee);
					}
					else System.out.println("El nodo no esta calculado en el camino");
				}
				else System.out.println("El camino no esta en el historial");
				//------------
				
			break;
			default: System.out.println("Comando incorrecto");
			
			case 4://salir del programa
				int option;
				System.out.println("Quieres guardar los cambios de forma permanente?");
				System.out.println("1 -> Si");
				System.out.println("2 -> No");
				option=Integer.parseInt(in.readLine());
				if(option == 1) gh.escribirDatos();
				sc.close();
		}
	}while (op != 4);
}
}
