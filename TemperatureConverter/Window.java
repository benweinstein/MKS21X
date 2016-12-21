import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    
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

	pane.add(toF);
	pane.add(toC);
	pane.add(inputTemp);
	pane.add(outputTemp);
    }


    //MAIN JUST INSTANTIATES AND MAKES VISIBLE
    public static void main(String[] args){
	Window g = new Window();
	g.setVisible(true);
    }
}

	
