import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SwingCalculatorClient extends JFrame implements ActionListener{

	private JTextField X, Y,Z;
	private JButton Add,Sub,Mul,Div;

	private CalculatorInterface calc;


	private SwingCalculatorClient(String hostname) {

		try {
			Registry registry = LocateRegistry.getRegistry(hostname);
			calc = (CalculatorInterface) registry.lookup("Calculator");

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}

		// Now build the GUI
		Container cp = getContentPane();
		cp.setLayout (new BorderLayout (3,4));

		Add = new JButton("+");
		Sub = new JButton("-");
		Mul = new JButton("x");
		Div = new JButton("/");

		Add.addActionListener(this);
		Sub.addActionListener(this);
		Mul.addActionListener(this);
		Div.addActionListener(this);

		X = new JTextField("Input 1",12);
		Y = new JTextField("Input 2",12);
		Z = new JTextField("Result",15);

		JPanel row1 = new JPanel();
		JPanel row2 = new JPanel();
		JPanel row3 = new JPanel();

		row1.setLayout(new FlowLayout(FlowLayout.CENTER));
		row2.setLayout(new FlowLayout(FlowLayout.CENTER));
		row3.setLayout(new FlowLayout(FlowLayout.CENTER));

		cp.add("North", row1);
		cp.add("Center", row2);
		cp.add("South", row3);

		row1.add(X);
		row1.add(Y);
		row2.add(Add);
		row2.add(Sub);
		row2.add(Mul);
		row2.add(Div);
		row3.add(Z);


		// Stop java if window closed by window close icon
		addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent evt) {
				System.exit(0);
			}
		} );
	}

	// Handle interface events here
	public void actionPerformed(ActionEvent evt) {
		double x,y,z;
		String sx,sy,sz;

		Object source = evt.getSource();

		z = 0;
		sx = X.getText();
		sy = Y.getText();
		sz = "";

		try {
			x = Double.parseDouble(sx);
			y = Double.parseDouble(sy);

			if ( source == Add) {
				z = calc.add(x,y);
			} else if ( source == Sub) {
				z = calc.sub(x,y);
			} else if ( source == Mul) {
				z = calc.mult(x,y);
			} else if ( source == Div) {
				z = calc.div(x,y);
			}
			sz = String.valueOf(z);

		} catch (NumberFormatException e) {
			sz = "Not A Number Error";

		} catch (Exception e){
			sz = "Other Error";
			System.out.println("Error:");
			e.printStackTrace();

		} finally {
			Z.setText(sz);
		}
	}

	public static void main(String[] args) {
		String remoteMachine;

		if (args.length == 0)
			remoteMachine = "localhost";
		else
			remoteMachine = args[0];

		SwingCalculatorClient MyCalc = new SwingCalculatorClient(remoteMachine);

		MyCalc.setSize(350,200);
		MyCalc.setTitle("Java RMI Calculator");
		MyCalc.setVisible(true);
	}
}
