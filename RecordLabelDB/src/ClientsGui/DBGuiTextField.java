package ClientsGui;

import java.awt.Frame;
import java.awt.TextField;

import javax.swing.JFrame;

public class DBGuiTextField extends TextField{
	
	public DBGuiTextField(JFrame frame,int x, int y,int width,int height) {
		super();
		this.setBounds(x,y,width,height);
		this.setVisible(false);
		frame.add(this);
	}

}
