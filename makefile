JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

default: *.class 

clean: 
	$(RM) *.class

run:
	java Tableau

archive: 
	tar -cvz *.java *.jpeg *.pdf makefile -f ScheidelBoltenhagenPOO.tar.gz

doc:
	javadoc *.java -d Documentation