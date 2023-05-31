//2089055 조창희, 계산기 화면 만들기 과제

package pack;

import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame{
	public MyFrame(){
		final int COLS = 5;
		final int ROWS = 5;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		
        String[] name = { 
			"Backspace", "x²", "π", "CE", "C",
			"7", "8", "9", "/", "sqrt",
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x",
			"0", "+/-", ".", "+", "="
	    };
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(ROWS,COLS,3,3));
        JTextField tf = new JTextField(35);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,30));
        tf.setText("0");
        tf.setEnabled(false);
        JButton[] btn = new JButton[name.length];
        int index=0;
        for(int i=0; i<ROWS; i++) {
        	for(int j=0; j<COLS; j++) {
            	btn[index]=new JButton(name[index]);
            	btn[index].setBackground(Color.WHITE);
            	if(index==0)
            		btn[index].setForeground(Color.GRAY);
            	if( j>=3 || index==1 || index==2 )
            		btn[index].setForeground(Color.RED);
            	if(index==name.length-1) {
            		btn[index].setBackground(Color.BLUE);
            		btn[index].setForeground(Color.WHITE);
            	}
            	panel.add(btn[index]);
            	index++;
           	}
        }
        add(tf, BorderLayout.PAGE_START);
        add(panel, BorderLayout.CENTER);
        pack();
        setTitle("Changhee's Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocation(screen.width/2-250, screen.height/2-150);
        setVisible(true);
	}
}
public class Cal {
	public static void main(String[] args) {
		new MyFrame();
	}
}
