import java.rmi.*;

public interface CalculatorInterface extends Remote{

	double add(double a, double b)  throws RemoteException;

	double sub(double a, double b)  throws RemoteException;

	double mult(double a, double b)  throws RemoteException;

	double div(double a, double b)  throws RemoteException;

}
