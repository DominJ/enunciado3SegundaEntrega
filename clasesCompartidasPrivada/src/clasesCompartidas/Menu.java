package clasesCompartidas;
import java.io.*;
import java.lang.String;

public class Menu
{ 
	public static void main(String args[] )throws IOException{ 
		
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 

	int op;
	int op2;
	int op3;
	
	//Men� inicial
	System.out.print("Menu principal\n" );
	System.out.print("Seleccione la operación ha realizar:\n" );
	System.out.print("1.- Modificar base de datos\n" ); 
	System.out.print("2.- Realizar una consulta\n" ); 
	System.out.print("3.- Buscar en el historial\n" );
	System.out.print("4.- Salir\n" );
	
	//Obtenemos la opci�n seleccionada por el user
	op=Integer.parseInt(in.readLine());

	switch(op){ 
	
	case 1: //Modificar la base de datos
		System.out.print("\nSeleccione la operación de modificación desada:\n" );
		System.out.print("1.- Añadir\n " );
		System.out.print("2.- Actualizar\n" );
		System.out.print("3.- Eliminar\n" );
		System.out.print("4.- Limpiar historial\n" );
		
		
		op2=Integer.parseInt(in.readLine());
		
		switch(op2){
		
		case 1: //Modificar la base de datos - a�adir
			
			System.out.print("\nSeleccione lo que desea añadir:\n" );
			System.out.print("1.- Dato independiente\n" );
			System.out.print("2.- Conjunto de datos(fichero adjunto)\n" );
			
			op3=Integer.parseInt(in.readLine());
			
			switch(op3){
			
			case 1: //Modificar la base de datos - a�adir - dato independiente
				System.out.print("\nIntroduce el dato independiente:\n" );
				//TODO leer dato que usuario añade al sistema
				break;
			
			case 2: //Modificar la base de datos - a�adir - conjunto de datos
				System.out.print("\nAdjunta el fichero con el conjunto de datos:\n" );
				//TODO leer fichero que se quiere añadir
				break;
				//default:
			}
		case 2: //Modificar la base de datos - actualizar
			//TODO actualizar el sistema con las modificaciones que pueda haber sufrido
			break;
		case 3: //Modificar la base de datos - eliminar
			//TODO eliminar el dato que el usuario crea conveniente
			break;
		case 4: //Modificar la base de datos - limpiar historial
			//TODO limpiar historial de busqueda 
			break;
		//default:
		}
	case 2://realizar consulta
		System.out.print("1.- Elegir camino predeterminado\n" );
		System.out.print("2.- Crear un camino nuevo\n" );
		op3=Integer.parseInt(in.readLine());
		switch(op3){
		case 1: //realizar consulta - camino predeterminado
			//TODO usuario elige un camino de la lista de caminos predetermidos
			break;
		case 2: //realizar consulta - camino nuevo
			//TODO usuario crea su propio camino 
			break;
		//default:
		}
	case 3://buscar en el historial
		System.out.print("Elige el camino que quieres consultar del historial:\n" );
		//TODO lista de caminos guardados y usuario elige uno y lo consulta
	case 4://salir del programa
		System.exit(0); 
	}
}
}
