Java RMI (Remote Method Invocation) Demo.
Written by Gary Allen, University of Huddersfield

A Java RMI Calculator.

This demo was last updated in October 2019.


Now fixed so that it runs properly within IntelliJ


The files:

    CalculatorInterface.java - the interface defining the remote services available
    CalculatorServer.java - the implementation of these remote services
    CalculatorClient.java - a very simple command-line test client
    SwingCalculatorClient.java - a more sophisticated SWING client


To use this demo:

1) Load the project into an IDE (I recommend IntelliJ).

2) Build the project by selecting Build -> Build Project (in IntelliJ).

3) Start the rmiregistry **but set the classpath first**. You can do this in the Terminal within IntelliJ or with a separate stand alone terminal:


    CLASSPATH=<<ClassToCompiledClasses>>
    rmiregistry

where << ClassToCompiledClasses >> is the path to the built (compiled) code.  For example:

    CLASSPATH=/home/scomga/IntelliJProjects/RMI_Calculator/out/production/RMI_Calculator/
    rmiregistry

Note that the trailing "/" IS essential at the end of the pathname.

4) Run the server from IntelliJ.

5) Run the client from IntelliJ.



**NOTES**

If you want to run the code from a command line (independent of the IDE) then you need to 'cd' to the directory containing all the compiled classes and...

... set up the classpath and start the rmiregistry exactly as above, e.g.:

    CLASSPATH=/home/scomga/IntelliJProjects/RMI_Calculator/out/production/RMI_Calculator/
    rmiregistry

... start the server with:

    java CalculatorServer

... start the client with:

    java SwingCalculatorClient

**OR**, if the client is running on a different machine to the server (to prove this is properly distributed):

	java SwingCalculatorClient <hostname>

where < hostname > is replaced by the machine name or IP address of the machine that the server is running on, e.g.:

	java SwingCalculatorClient lockwood

Remember to kill the server and the rmiregistry processes so as not to leave loads of executing processes clogging up the machines.

