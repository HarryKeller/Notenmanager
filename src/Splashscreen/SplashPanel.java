package Splashscreen;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class SplashPanel extends JPanel
{
	private Image splashimage = null;
	private SplashThread splashthread = null;
	
	public SplashPanel()
	{
		
	}
	
	public SplashPanel(Image splashscreen)
	{		
		this.splashimage = splashscreen;
		this.setSize(new Dimension(this.splashimage.getWidth(this), this.splashimage.getHeight(this)));
		this.setBackground(new Color(0,0,0,0));	
		splashthread = new SplashThread(this);
	}

	@Override
	protected void paintComponent(Graphics g)
	{		
		super.paintComponent(g);
		g.drawImage(splashimage, splashimage.getWidth(this)/2 , splashimage.getHeight(this)/3, this);
	}
	
	public boolean isThreadFinished()
	{
		return this.splashthread.isFinished();
	}
}
