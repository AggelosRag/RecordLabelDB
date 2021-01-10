package ApplicationGui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JFrame;

public class DBGuiLabel extends Label{
	
	public DBGuiLabel(JFrame frame,String name,int x, int y, int width, int height) {
		super(name);
		this.setBackground(Color.GRAY);
		this.setBounds(x, y, width, height);
		this.setVisible(false);
		frame.add(this);
	}
	
	public DBGuiLabel(JFrame frame,String name,int x, int y, int width, int height, Color color) {
		super(name);
		this.setBackground(color);
		this.setBounds(x, y, width, height);
		frame.add(this);
	}

}
