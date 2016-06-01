package clasesPrivadas.Dominio.Clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import clasesCompartidas.Pair;

/**
 * @author Domingo Jesus de la Mata
 *
 */
public class GrafoPri extends Grafo {
	
	public GrafoPri(Grafo g, Set<Integer> s) {
		/*s es un set que determina los filtros que se han seleccionado.
		  Contiene un conjunto de numeros entre 0 y 3 donde :
			0 - papers
			1 - authors
			2 - conferences
			3 - therms 
			*/
		try{
			if (s.size()==0) {
				this.papers=g.papers;
				this.authors=g.authors;
				this.conferences=g.conferences;
				this.therms=g.therms;
			}
			else {
				//Instanciamos los nodos
				
				Set<Integer> a=new HashSet<Integer>();
				//Generamos un set con los numeros de 0 a 3
				for (int i=0; i<4; ++i){
					a.add(i);
				}
				//Tratamos primero el set de flitros
				Set<Integer> p= new HashSet<Integer>();
				for (int i:s){
					Set<String> r=LeerFichero.LeerFiltro(FILTROS, i);
					HashMap<Integer, String> h1 = new HashMap<Integer, String>();
					HashMap<String, Integer> h2 = new HashMap<String, Integer>();
					for (String n:r){
						h1.put(consultarNodo(i, n), n);
						h2.put(n, consultarNodo(i, n));
					}
					if (i==0) {
						this.papers=new ConjuntoNodosPri(h1, h2);
					}
					else if (i==1){
						this.authors=new ConjuntoNodosPri(h1,h2);
						if (!r.contains(0)){
							HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux= g.getRelaciones("AP", true);
							for (int j: h1.keySet()){
								ArrayList<Pair<Integer,Double>> ar=aux.get(j);
								if (ar!=null) for (int k=0; k<ar.size(); ++k) p.add(ar.get(k).getFirst());
							}
						}
					}
					else if (i==2){
						this.conferences=new ConjuntoNodosPri(h1,h2);
						if (!r.contains(0)){
							HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux= g.getRelaciones("CP", true);
							for (int j: h1.keySet()){
								ArrayList<Pair<Integer,Double>> ar=aux.get(j);
								if (ar!=null) for (int k=0; k<ar.size(); ++k) p.add(ar.get(k).getFirst());
							}
						}
					}
					else{
						this.therms=new ConjuntoNodosPri(h1,h2);
						if (!r.contains(0)){
							HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux= g.getRelaciones("TP", true);
							for (int j: h1.keySet()){
								ArrayList<Pair<Integer,Double>> ar=aux.get(j);
								if (ar!=null) for (int k=0; k<ar.size(); ++k) p.add(ar.get(k).getFirst());
							}
						}
					}
					//Quitamos del set los casos tratados
					a.remove(i);
				}
				if (!s.contains(0)) {
					HashMap<Integer, String> hp1 = new HashMap<Integer, String>();
					HashMap<String, Integer> hp2 = new HashMap<String, Integer>();
					for (int i:p){
						hp1.put(i,g.consultarNodo(0,i));
						hp2.put(g.consultarNodo(0,i), i);
						this.papers=new ConjuntoNodosPri(hp1, hp2);
					}
					a.remove(0);
				}
				for(int i:a){
					if (i==1){
						Set<Integer> aut= new HashSet<Integer>();
						HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux=g.getRelaciones("PA",true);
						for(int j: this.papers.devolver_conjunto().keySet()){
							System.out.print(j+ " ");
							ArrayList<Pair<Integer,Double>> ar=aux.get(j);
							if (ar!=null)for (int k=0; k<ar.size(); ++k) {
								aut.add(ar.get(k).getFirst());
								System.out.print(ar.get(k).getFirst() +" ");
							}
							System.out.println();
						}
						HashMap<Integer, String> h1 = new HashMap<Integer, String>();
						HashMap<String, Integer> h2 = new HashMap<String, Integer>();
						for (int k:aut){
							h1.put(k,g.consultarNodo(1,k));
							h2.put(g.consultarNodo(1,k), k);
							this.authors=new ConjuntoNodosPri(h1, h2);
						}
					}
					else if (i==2){
						Set<Integer> aut= new HashSet<Integer>();
						HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux=g.getRelaciones("PC",true);
						for(int j: this.papers.devolver_conjunto().keySet()){
							ArrayList<Pair<Integer,Double>> ar=aux.get(j);
							if (ar!=null) for (int k=0; k<ar.size(); ++k) aut.add(ar.get(k).getFirst());
						}
						HashMap<Integer, String> h1 = new HashMap<Integer, String>();
						HashMap<String, Integer> h2 = new HashMap<String, Integer>();
						for (int k:aut){
							h1.put(k,g.consultarNodo(2,k));
							h2.put(g.consultarNodo(2,k), k);
							this.conferences=new ConjuntoNodosPri(h1, h2);
						}
					}
					else{
						Set<Integer> aut= new HashSet<Integer>();
						HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux=g.getRelaciones("PT",true);
						for(int j: this.papers.devolver_conjunto().keySet()){
							System.out.println(j);
							ArrayList<Pair<Integer,Double>> ar=aux.get(j);
							if (ar!=null) for (int k=0; k<ar.size(); ++k) aut.add(ar.get(k).getFirst());
						}
						HashMap<Integer, String> h1 = new HashMap<Integer, String>();
						HashMap<String, Integer> h2 = new HashMap<String, Integer>();
						for (int k:aut){
							h1.put(k,g.consultarNodo(3,k));
							h2.put(g.consultarNodo(3,k), k);
							this.therms=new ConjuntoNodosPri(h1, h2);
						}
					}
				}
			}
			this.PAF=g.PAF;
			this.PAC=g.PAC;
			this.PCF=g.PCF;
			this.PCC=g.PCC;
			this.PTF=g.PTF;
			this.PTC=g.PTC;
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Se ha producido un error en la creacion de GrafoPri.");
		}
	}
	
	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> getRelaciones(String rel, boolean b)
	{
		if (rel.equals("AP")){
			if (b) {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PAF.consultar_OtherPaper();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: authors.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (papers.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
			else {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PAC.consultar_OtherPaper();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: authors.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (papers.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					h1.put(i, ar);
				}
				return h1;
			}
		}
		else if (rel.equals("PA")){
			if(b){
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PAF.consultar_PaperOther();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: papers.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (authors.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
			else {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PAC.consultar_PaperOther();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: papers.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (authors.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
		}
		else if (rel.equals("CP")){
			if (b){
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PCF.consultar_OtherPaper();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: conferences.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (papers.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
			else{
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PCC.consultar_OtherPaper();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: conferences.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (papers.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
		}
		else if (rel.equals("PC")){
			if(b){
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PCF.consultar_PaperOther();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: papers.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (conferences.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
			else {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PCC.consultar_PaperOther();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: papers.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (conferences.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
		}
		else if (rel.equals("TP")){
			if (b) {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PTF.consultar_OtherPaper();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: therms.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (papers.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
			else {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PTC.consultar_OtherPaper();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: therms.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (papers.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
		}
		else
		{
			if(b) {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PTF.consultar_PaperOther();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: papers.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (therms.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
			else {
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> aux1=this.PTC.consultar_PaperOther();
				HashMap<Integer, ArrayList<Pair<Integer,Double>>> h1=new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
				for(int i: papers.devolver_conjunto().keySet()){
					ArrayList<Pair<Integer,Double>> aa=aux1.get(i);
					ArrayList<Pair<Integer,Double>> ar=new ArrayList<Pair<Integer ,Double>>();
					for (int k=0; k<aa.size(); ++k) {
						Pair<Integer,Double> pa=aa.get(k);
						Pair<Integer,Double> pr=new Pair<Integer,Double>();
						if (therms.devolver_conjunto().containsKey(pa.getFirst())){
							pr.setFirst(pa.getFirst());
							pr.setSecond(pa.getSecond());
							ar.add(pr);
						}
					}
					if (ar.size()!=0) h1.put(i, ar);
				}
				return h1;
			}
		}
	}
	public void print(){
		System.out.println(papers.devolver_conjunto().toString());
		System.out.println(authors.devolver_conjunto().toString());
		System.out.println(conferences.devolver_conjunto().toString());
		System.out.println(therms.devolver_conjunto().toString());
	}
}
