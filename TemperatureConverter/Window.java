import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{
    
    private Container pane;
    private JButton toF; 
    private JButton toC;
    private JTextField inputTemp;
    private JTextField outputTemp; //two-textfield design

    public Window(){
	this.setTitle("Temperature converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout()); //CAN BE CHANGED!

	toF = new JButton("to F");
	toC = new JButton("to C");
	inputTemp = new JTextField(5);
	outputTemp = new JTextField(5);

	toF.addActionListener(this);
	toF.setActionCommand("toF");
	toC.addActionListener(this);
	toC.setActionCommand("toC");

	inputTemp.setText("Input");
	outputTemp.setText("Output");
	
	pane.add(inputTemp);
	pane.add(toF);
	pane.add(toC);
	pane.add(outputTemp);
    }

    //implementing ActionListener interface
    public void actionPerformed(ActionEvent e){
	String cmd = e.getActionCommand();
	double temp;
	if(cmd.equals("toF")){
	    try{
		temp = Double.parseDouble(inputTemp.getText());
		outputTemp.setText("" + convertTemp.CtoF(temp));
	    }catch(NumberFormatException error){//'e' being used as the param
		System.out.println("Enter a valid number for input");
	    }	    
	}
	if(cmd.equals("toC")){
	    try{
	        temp = Double.parseDouble(inputTemp.getText());
		outputTemp.setText("" + convertTemp.FtoC(temp));
	    }catch(NumberFormatException error){
		System.out.println("Enter a valid number for input");
	    }
	}
    }
    
    //MAIN JUST INSTANTIATES AND MAKES VISIBLE
    public static void main(String[] args){
	Window g = new Window();
	g.setVisible(true);
    }
}

	
