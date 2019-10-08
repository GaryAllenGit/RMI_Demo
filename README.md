Java RMI (Remote Method Invocation) Demo.
Written by Gary Allen, University of Huddersfield

A Java RMI Calculator.

This demo was last updated in October 2019.


NOTE THAT THIS DEMO WILL NOT RUN INSIDE INTELLIJ.
It all builds fine but I cannot make it run.
It always throws a "class not found" error.
It must be something to do with the "java.rmi.server.codebase" property, but I cant find out how to fix it.
To make it work, do any editing inside IntelliJ (or another IDE) but compile and run the code from the command line.
Instructions for this are below.


The files:

CalculatorInterface.java - the interface defining the remote services available
CalculatorServer.java - the implementation of these remote services
CalculatorClient.java - a very simple command-line test client
SwingCalculatorClient.java - a more sophisticated SWING client


To use this demo:

1) If you need to edit the files then do so in any IDE or text editor of choice, but don't try to run it from the IDE.

2) Compile all files from the command line with:

	javac *.java
	

3) Start the rmiregistry with:

	rmiregistry &


4) Start the server with:
	java -Djava.rmi.server.codebase=file:PathToCompiledClasses/ CalculatorServer

where "PathToCompiledClasses" is the full pathname to the directory containing
the compiled version of the code, and note that the trailing "/" IS essential.
If you are following these instructions then PathToCompiledClasses will be the full path
name of the current directory where you are compiling and running this demo.

For Example:
	java -Djava.rmi.server.codebase=file:/home/scomga/RMICalculator/src/ CalculatorServer


5) In another terminal, start the client with:
	java SwingCalculatorClient

OR, if the client is running on a different machine to the server:
	java SwingCalculatorClient <hostname>

where <hostname> is replaced by the name of the machine that the server is
running on, e.g.:
	java SwingCalculatorClient lockwood


PLEASE remember to kill the server and the rmiregistry processes so as not
to leave loads of executing processes clogging up the machines.  To do
this (in the window you ran the server in):

	press "control-c" to kill the server
	type "fg" to bring the rmiregistry process to the foreground
	press "control-c" to kill the rmiregistry process

