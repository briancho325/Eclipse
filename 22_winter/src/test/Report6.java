package test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Report6 extends JFrame implements ActionListener{

	final int MAX_INPUT_LENGTH = 20;
	final int INPUT_MODE = 0;
	final int RESULT_MODE = 1;
	final int ERROR_MODE = 2;
	int displayMode;

	boolean clearOnNextDigit, percent;
	double lastNumber;
	String lastOperator;

	private JLabel jlbOutput;
	private JButton jbnButtons[];
	private JPanel jplMaster, jplBackSpace, jplControl;
	
	Font f12 = new Font("Times New Roman", 0, 22);
	
	
	public Report6() 
	{
		
		setBackground(Color.gray);

		jplMaster = new JPanel();

		
		jlbOutput = new JLabel("0");
		jlbOutput.setHorizontalTextPosition(JLabel.RIGHT);
		jlbOutput.setBackground(Color.WHITE);
		jlbOutput.setMinimumSize(new Dimension(100, 40));
		jlbOutput.setPreferredSize(new Dimension(100, 40));
		jlbOutput.setMaximumSize(new Dimension(100, 40));
		jlbOutput.setFont(new Font("Serif", Font.PLAIN, 30));
		jlbOutput.setOpaque(true);
		
		
		getContentPane().add(jlbOutput, BorderLayout.NORTH);

		jbnButtons = new JButton[23];

		JPanel jplButtons = new JPanel();

		for (int i=0; i<=9; i++)
		{
			jbnButtons[i] = new JButton(String.valueOf(i));
		}

		jbnButtons[10] = new JButton("+/-");
		jbnButtons[11] = new JButton(".");
		jbnButtons[12] = new JButton("=");
		jbnButtons[13] = new JButton("/");
		jbnButtons[14] = new JButton("*");
		jbnButtons[15] = new JButton("-");
		jbnButtons[16] = new JButton("+");
		jbnButtons[17] = new JButton("sqrt");
		jbnButtons[18] = new JButton("1/x");
		jbnButtons[19] = new JButton("%");
		
		
		jplBackSpace = new JPanel();
		jplBackSpace.setLayout(new GridLayout(1, 1, 2, 2));

		jbnButtons[20] = new JButton("Backspace");
		jplBackSpace.add(jbnButtons[20]);

		
		jplControl = new JPanel();
		jplControl.setLayout(new GridLayout(1, 2, 2 ,2));

		jbnButtons[21] = new JButton(" CE ");
		jbnButtons[22] = new JButton("C");

		jplControl.add(jbnButtons[21]);
		jplControl.add(jbnButtons[22]);

		for (int i=0; i<jbnButtons.length; i++)	{
			jbnButtons[i].setFont(f12);

			if (i<10)
				jbnButtons[i].setForeground(Color.blue);
				
			else
				jbnButtons[i].setForeground(Color.red);
		}
	
		jplButtons.setLayout(new GridLayout(4, 5, 2, 2));
		
		for(int i=7; i<=9; i++)		{
			jplButtons.add(jbnButtons[i]);
		}
		
		jplButtons.add(jbnButtons[13]);
		jplButtons.add(jbnButtons[17]);
		
		for(int i=4; i<=6; i++)
		{
			jplButtons.add(jbnButtons[i]);
		}
		
		jplButtons.add(jbnButtons[14]);
		jplButtons.add(jbnButtons[18]);

		for( int i=1; i<=3; i++)
		{
			jplButtons.add(jbnButtons[i]);
		}
		
		jplButtons.add(jbnButtons[15]);
		jplButtons.add(jbnButtons[19]);
		
		jplButtons.add(jbnButtons[0]);
		jplButtons.add(jbnButtons[10]);
		jplButtons.add(jbnButtons[11]);
		jplButtons.add(jbnButtons[16]);
		jplButtons.add(jbnButtons[12]);
		
		jplMaster.setLayout(new BorderLayout());
		jplMaster.add(jplBackSpace, BorderLayout.WEST); 
		jplMaster.add(jplControl, BorderLayout.EAST);
		jplMaster.add(jplButtons, BorderLayout.SOUTH);

		getContentPane().add(jplMaster, BorderLayout.SOUTH);
		requestFocus();
		
		for (int i=0; i<jbnButtons.length; i++){
			jbnButtons[i].addActionListener(this);
		}
		
		clearAll();

		addWindowListener(new WindowAdapter() {

				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		double result = 0;
	   
		for (int i=0; i<jbnButtons.length; i++)
		{
			if(e.getSource() == jbnButtons[i])
			{
				switch(i)
				{
					case 0 :
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
						addDigitToDisplay(i);
						break;

					case 10:	
						processSignChange();
						break;

					case 11:	
						addDecimalPoint();
						break;

					case 12:	
						processEquals();
						break;

					case 13:	
						processOperator("/");
						break;

					case 14:	
						processOperator("*");
						break;

					case 15:	
						processOperator("-");
						break;

					case 16:	
						processOperator("+");
						break;

					case 17:	
						if (displayMode != ERROR_MODE)
						{
							try
							{
								if (getDisplayString().indexOf("-") == 0)
									displayError("유효한 값이 아닙니다!"); 

								result = Math.sqrt(getNumberInDisplay());
								displayResult(result);
							}

							catch(Exception ex)
							{
								displayError("유효한 값이 아닙니다!");
								displayMode = ERROR_MODE;
							}
						}
						break;

					case 18:	// 1/x
						if (displayMode != ERROR_MODE){
							try
							{
								if (getNumberInDisplay() == 0)
									displayError("0으로 나눌수없습니다");
	
								result = 1 / getNumberInDisplay();
								displayResult(result);
							}
							
							catch(Exception ex)	{
								displayError("0으로 나눌수없습니");
								displayMode = ERROR_MODE;
							}
						}
						break;

					case 19:	// %
						if (displayMode != ERROR_MODE){
							try	{
								result = getNumberInDisplay() / 100;
								displayResult(result);
							}
	
							catch(Exception ex)	{
								displayError("유효한 값이아닙니다!");
								displayMode = ERROR_MODE;
							}
						}
						break;

					case 20:	
						if (displayMode != ERROR_MODE){
							setDisplayString(getDisplayString().substring(0,
										getDisplayString().length() - 1));
							
							if (getDisplayString().length() < 1)
								setDisplayString("0");
						}
						break;

					case 21:	
						clearExisting();
						break;

					case 22:
						clearAll();
						break;
				}
			}
		}
	}

	void setDisplayString(String s){
		jlbOutput.setText(s);
	}

	String getDisplayString (){
		return jlbOutput.getText();
	}

	
	void addDigitToDisplay(int digit){
		if (clearOnNextDigit)
			setDisplayString("");

		String inputString = getDisplayString();
		
		if (inputString.indexOf("0") == 0){
			inputString = inputString.substring(1);
		}

		if ((!inputString.equals("0") || digit > 0)  && inputString.length() < MAX_INPUT_LENGTH){
			setDisplayString(inputString + digit);
		}
		

		displayMode = INPUT_MODE;
		clearOnNextDigit = false;
	}

	
	void addDecimalPoint(){
		displayMode = INPUT_MODE;

		if (clearOnNextDigit)
			setDisplayString("");

		String inputString = getDisplayString();
	
		
		if (inputString.indexOf(".") < 0)
			setDisplayString(new String(inputString + "."));
	}

	
	void processSignChange(){
		if (displayMode == INPUT_MODE)
		{
			String input = getDisplayString();

			if (input.length() > 0 && !input.equals("0"))
			{
				if (input.indexOf("-") == 0)
					setDisplayString(input.substring(1));

				else
					setDisplayString("-" + input);
			}
			
		}

		else if (displayMode == RESULT_MODE)
		{
			double numberInDisplay = getNumberInDisplay();
		
			if (numberInDisplay != 0)
				displayResult(-numberInDisplay);
		}
	}

	void clearAll()	{
		setDisplayString("0");
		lastOperator = "0";
		lastNumber = 0;
		displayMode = INPUT_MODE;
		clearOnNextDigit = true;
	}

	void clearExisting(){
		setDisplayString("0");
		clearOnNextDigit = true;
		displayMode = INPUT_MODE;
	}

	double getNumberInDisplay()	{
		String input = jlbOutput.getText();
		return Double.parseDouble(input);
	}

	
	void processOperator(String op) {
		if (displayMode != ERROR_MODE)
		{
			double numberInDisplay = getNumberInDisplay();

			if (!lastOperator.equals("0"))	
			{
				try
				{
					double result = processLastOperator();
					displayResult(result);
					lastNumber = result;
				}

				catch (DivideByZeroException e)
				{
				}
			}
		
			else
			{
				lastNumber = numberInDisplay;
			}
			
			clearOnNextDigit = true;
			lastOperator = op;
		}
	}

	void processEquals(){
		double result = 0;

		if (displayMode != ERROR_MODE){
			try			
			{
				result = processLastOperator();
				displayResult(result);
			}
			
			catch (DivideByZeroException e)	{
				displayError("0���� ������ �����ϴ�!");
			}

			lastOperator = "0";
		}
	}

	
	double processLastOperator() throws DivideByZeroException {
		double result = 0;
		double numberInDisplay = getNumberInDisplay();

		if (lastOperator.equals("/"))
		{
			if (numberInDisplay == 0)
				throw (new DivideByZeroException());

			result = lastNumber / numberInDisplay;
		}
			
		if (lastOperator.equals("*"))
			result = lastNumber * numberInDisplay;

		if (lastOperator.equals("-"))
			result = lastNumber - numberInDisplay;

		if (lastOperator.equals("+"))
			result = lastNumber + numberInDisplay;

		return result;
	}

	void displayResult(double result){
		setDisplayString(Double.toString(result));
		lastNumber = result;
		displayMode = RESULT_MODE;
		clearOnNextDigit = true;
	}

	void displayError(String errorMessage){
		setDisplayString(errorMessage);
		lastNumber = 0;
		displayMode = ERROR_MODE;
		clearOnNextDigit = true;
	}

	public static void main(String args[]) {
		Report6 calci = new Report6();
		Container contentPane = calci.getContentPane();
		calci.setTitle("Java SIMPLE Calculator");
		calci.setSize(241, 217);
		calci.pack();
		calci.setLocation(400, 250);
		calci.setVisible(true);
		calci.setResizable(false);
	}
	
}

class DivideByZeroException extends Exception{
	public DivideByZeroException()
	{
		super();
	}
	
	public DivideByZeroException(String s)
	{
		super(s);
	}
}