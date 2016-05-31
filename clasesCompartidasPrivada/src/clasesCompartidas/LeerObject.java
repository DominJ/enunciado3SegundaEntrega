package clasesCompartidas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import excepciones.NonExistObjectToReadException;

import java.io.Serializable;

public class LeerObject implements Serializable{

	public static Object LeerObjeto(String ruta) throws IOException, ClassNotFoundException 
	{
		FileInputStream fis = new FileInputStream("");
		BufferedInputStream z = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(z);
	    Object a = ois.readObject();
	    return a;
	}
	
	public static void verificarObjects() throws NonExistObjectToReadException
	{
		//Verifica si es primera ejecución
		//En caso de error de lectura 
		throw new NonExistObjectToReadException("Error en la existencia o lectura del fichero Objetc");
	}
}
