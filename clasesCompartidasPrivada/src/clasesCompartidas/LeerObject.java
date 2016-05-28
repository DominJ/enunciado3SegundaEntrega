package clasesCompartidas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class LeerObject implements Serializable{

	public Object LeerObject() {
		FileInputStream fis = new FileInputStream();
		BufferedInputStream z = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(z);
	    Object a = ois.readObject();
	    return a;
		}
}
