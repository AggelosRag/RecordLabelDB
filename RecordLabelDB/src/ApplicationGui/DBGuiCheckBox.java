package ApplicationGui;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class DBGuiCheckBox extends JCheckBox{
	
	public DBGuiCheckBox(JFrame frame,String name,int x, int y,int width,int height,boolean visible) {
		super(name);
		this.setBounds(x,y,width,height);
		this.setVisible(visible);
		if(visible) {this.setBackground(Color.GREEN);}
		else {this.setBackground(Color.PINK);}
		
		frame.add(this);
	}

}
