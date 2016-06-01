all: java.class

java.class:
	javac -target 1.8 -d ../bin/ -cp ../src/ ./clasesPrivadas/Dominio/Clases/MiPrograma.java

run:	
	java -cp ../bin/ clasesPrivadas.Dominio.Clases.MiPrograma

clean:
	rm -f ../bin/clasesPrivadas/Dominio/Clases/*.class
	rm -f ../bin/clasesCompartidas/*.class
