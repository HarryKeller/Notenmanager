package Dialog;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistenz.DBZugriff;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class Dialog_Hauptfenster extends JFrame implements WindowListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		DBZugriff.initDB();
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Dialog_Hauptfenster frame = new Dialog_Hauptfenster();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dialog_Hauptfenster()
	{
		initGUI();
	}
	private void initGUI() 
	{
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void Login()
	{
		Dialog_Login login = new Dialog_Login();
		login.setVisible(true);
	}

	public void windowActivated(WindowEvent arg0) 
	{
	}
	public void windowClosed(WindowEvent arg0) 
	{
	}
	public void windowClosing(WindowEvent arg0) 
	{
		DBZugriff.closeDB();
	}
	public void windowDeactivated(WindowEvent arg0) 
	{
	}
	public void windowDeiconified(WindowEvent arg0) 
	{
	}
	public void windowIconified(WindowEvent arg0) 
	{
	}
	public void windowOpened(WindowEvent arg0) 
	{
	}
}
