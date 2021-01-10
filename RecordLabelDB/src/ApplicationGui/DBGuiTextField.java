package ApplicationGui;

import java.awt.Frame;
import java.awt.TextField;

import javax.swing.JFrame;

public class DBGuiTextField extends TextField{
	
	public DBGuiTextField(JFrame frame,int x, int y,int width,int height,String name) {
		super(name);
		this.setBounds(x,y,width,height);
		this.setVisible(false);
		frame.add(this);
	}

}
