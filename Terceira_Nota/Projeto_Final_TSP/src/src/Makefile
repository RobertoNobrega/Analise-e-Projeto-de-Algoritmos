JFLAGS = -g
JC = javac
OPT = -O3
#OPT = -g
WARN = -Wall


Main: Main.class
	java Main

Main.class: Main.java
	$(JC) $(JFLAGS) Main.java

clean:
	$(RM) Main.class

clobber:
	$(RM) Main.class
