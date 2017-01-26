package Splashscreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import java.awt.Window.Type;
import java.lang.reflect.InvocationTargetException;

public class Splashscreen extends JDialog
{
	private String filepath = null;
	private Image splashimage = null;
	private SplashPanel splashpanel = null;
	
	public Splashscreen(String filepath)
	{
		super();
		
		this.filepath = filepath;
		initGUI();
	}
	private void initGUI() {
		setUndecorated(true);
		setResizable(false);
		
		splashimage = Toolkit.getDefaultToolkit().createImage(this.filepath);
		splashpanel = new SplashPanel(splashimage);
		
		this.setSize(new Dimension(500, 500));
		this.setContentPane(splashpanel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(new Color(0,0,0,0));		
		this.setAlwaysOnTop(true);
	}	
}
