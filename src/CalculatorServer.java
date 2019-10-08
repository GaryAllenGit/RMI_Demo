import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


class CalculatorServer implements CalculatorInterface {

	private CalculatorServer() {
		super();
	}

	public double add(double a, double b) {
		return a + b;
	}

	public double sub(double a, double b) {
		return a - b;
	}

	public double mult(double a, double b) {
		return a * b;
	}

	public double div(double a, double b) {
		if (b == 0)
			return 0;
		else
			return a / b;
	}


	public static void main(String[] args) {
		try {
			CalculatorServer calc = new CalculatorServer();
			CalculatorInterface stub = (CalculatorInterface) UnicastRemoteObject.exportObject(calc, 0);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("Calculator", stub);

			System.out.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
