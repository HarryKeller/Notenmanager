package Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.hibernate.Hibernate;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SplashScreen;

import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import Fachklassen.Lehrer;
import Fachklassen.Login;
import Persistenz.DBZugriff;
import Splashscreen.Splashscreen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Dialog_Login extends JFrame implements ActionListener, WindowListener
{

	private JPanel contentPane;
	private JPanel panel;
	private JButton button_Login;
	private JButton button_Schliessen;
	private JPanel panel_1;
	private JLabel label_Benutzername;
	private JLabel label_Passwort;
	private JTextField textField_Benutzername;
	private JPasswordField passwordField_Passwort;
	private JPanel panel_2;
	private JLabel label_Titel;
	private JSeparator separator;
	private Thread loadingthread;
	private static Splashscreen s;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{		
		s = new Splashscreen("res/loadingscreen.gif");
		
		EventQueue.invokeLater(new Runnable()
		{	
			Dialog_Login frame = null;
			public void run()
			{	
				
				try // Thanks to JTattoo @ http://www.jtattoo.net/
				{					
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");	
					frame = new Dialog_Login();
					frame.setVisible(true);									
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}		
		);
		
		
	}

	/**
	 * Create the frame.
	 */
	public Dialog_Login()
	{
		initGUI();
	}
	private void initGUI() 
	{
		addWindowListener(this);
		
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 350, 0, 0};
		gbl_contentPane.rowHeights = new int[]{10, 100, 75, 50, 10, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			panel_2 = new JPanel();
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 5);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 1;
			gbc_panel_2.gridy = 1;
			contentPane.add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0, 0};
			gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			{
				label_Titel = new JLabel("Notenmanager");
				label_Titel.setVerticalAlignment(SwingConstants.BOTTOM);
				label_Titel.setFont(new Font("Tahoma", Font.PLAIN, 36));
				label_Titel.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_label_Titel = new GridBagConstraints();
				gbc_label_Titel.fill = GridBagConstraints.BOTH;
				gbc_label_Titel.insets = new Insets(0, 0, 5, 0);
				gbc_label_Titel.gridx = 0;
				gbc_label_Titel.gridy = 0;
				panel_2.add(label_Titel, gbc_label_Titel);
			}
			{
				separator = new JSeparator();
				separator.setForeground(Color.BLACK);
				GridBagConstraints gbc_separator = new GridBagConstraints();
				gbc_separator.fill = GridBagConstraints.HORIZONTAL;
				gbc_separator.insets = new Insets(0, 0, 5, 0);
				gbc_separator.gridx = 0;
				gbc_separator.gridy = 1;
				panel_2.add(separator, gbc_separator);
			}
		}
		{
			panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = 2;
			contentPane.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				label_Benutzername = new JLabel("Benutzername");
				GridBagConstraints gbc_label_Benutzername = new GridBagConstraints();
				gbc_label_Benutzername.anchor = GridBagConstraints.EAST;
				gbc_label_Benutzername.insets = new Insets(0, 0, 5, 5);
				gbc_label_Benutzername.gridx = 0;
				gbc_label_Benutzername.gridy = 0;
				panel_1.add(label_Benutzername, gbc_label_Benutzername);
			}
			{
				textField_Benutzername = new JTextField();
				textField_Benutzername.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_textField_Benutzername = new GridBagConstraints();
				gbc_textField_Benutzername.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Benutzername.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Benutzername.gridx = 1;
				gbc_textField_Benutzername.gridy = 0;
				panel_1.add(textField_Benutzername, gbc_textField_Benutzername);
				textField_Benutzername.setColumns(10);
			}
			{
				label_Passwort = new JLabel("Passwort");
				GridBagConstraints gbc_label_Passwort = new GridBagConstraints();
				gbc_label_Passwort.anchor = GridBagConstraints.EAST;
				gbc_label_Passwort.insets = new Insets(0, 0, 0, 5);
				gbc_label_Passwort.gridx = 0;
				gbc_label_Passwort.gridy = 1;
				panel_1.add(label_Passwort, gbc_label_Passwort);
			}
			{
				passwordField_Passwort = new JPasswordField();
				passwordField_Passwort.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_passwordField_Passwort = new GridBagConstraints();
				gbc_passwordField_Passwort.fill = GridBagConstraints.HORIZONTAL;
				gbc_passwordField_Passwort.gridx = 1;
				gbc_passwordField_Passwort.gridy = 1;
				panel_1.add(passwordField_Passwort, gbc_passwordField_Passwort);
			}
		}
		{
			panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPane.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{57, 77, 0};
			gbl_panel.rowHeights = new int[]{23, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				button_Login = new JButton("Login");
				button_Login.addActionListener(this);
				GridBagConstraints gbc_button_Login = new GridBagConstraints();
				gbc_button_Login.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Login.insets = new Insets(0, 0, 0, 5);
				gbc_button_Login.gridx = 0;
				gbc_button_Login.gridy = 0;
				panel.add(button_Login, gbc_button_Login);
			}
			{
				button_Schliessen = new JButton("Schlie\u00DFen");
				button_Schliessen.addActionListener(this);
				GridBagConstraints gbc_button_Schliessen = new GridBagConstraints();
				gbc_button_Schliessen.fill = GridBagConstraints.HORIZONTAL;
				gbc_button_Schliessen.gridx = 1;
				gbc_button_Schliessen.gridy = 0;
				panel.add(button_Schliessen, gbc_button_Schliessen);
				panel.getRootPane().setDefaultButton(button_Login);
			}
		}
	}
	
	public void loginUser()
	{
		String benutzername = textField_Benutzername.getText();
		benutzername = benutzername.replaceAll("\\s+","");
		char[] password = passwordField_Passwort.getPassword();	
		String passString = new String(password);
		
		Login login = new Login();
		Lehrer lehrer = login.getLehrerZuKuerzel(benutzername);
		Lehrer l = new Lehrer(lehrer.getId());
		login = new Login(l.getId());
		
		if(benutzername.equals(l.getKuerzel()) && passString.equals(login.getPw()) && l.isArbeitetAnDieserSchule() == false)
		{
			JOptionPane.showMessageDialog(null, "Der Lehrer arbeitet nicht mehr an der Schule! Login verweigert!" , "Login verweigert!", JOptionPane.ERROR_MESSAGE);
		}
		else if(benutzername.equals(l.getKuerzel()) && passString.equals(login.getPw()) && login.isAdmin() == true)
		{
			Dialog_Klassenauswahl dlg_klassenauswahl = new Dialog_Klassenauswahl(l,true);
			dlg_klassenauswahl.setVisible(true);
			this.dispose();
		}
		else if(benutzername.equals(l.getKuerzel()) && passString.equals(login.getPw()))
		{
			Dialog_Klassenauswahl dlg_klassenauswahl = new Dialog_Klassenauswahl(l,false);
			dlg_klassenauswahl.setVisible(true);
			this.dispose();
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Das eingegebene Passwort ist falsch!" , "Login fehlgeschlagen", JOptionPane.ERROR_MESSAGE);
		}
	}
		
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(button_Login.getActionCommand())) // Abfrage auf Dr�cken des Login-Buttons "button_Login"
		{		
			try
			{
				loginUser();
			}
			catch(IndexOutOfBoundsException ex)
			{
				JOptionPane.showMessageDialog(null, "Der eingegebene Benutzername ist falsch! (Lehrerk�rzel verwenden)" , "Login fehlgeschlagen", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if(e.getActionCommand().equals(button_Schliessen.getActionCommand())) // Abfrage auf Dr�cken des Login-Buttons "button_Login"
		{
			DBZugriff.closeDB();			
			this.dispose();
		}
	}
	
	public void windowActivated(WindowEvent arg0) {
		
	}
	public void windowClosed(WindowEvent arg0) 
	{
		//DBZugriff.closeDB();
	}	
	public void windowClosing(WindowEvent arg0) {
		
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) 
	{		
		loadingthread = new Thread(new Runnable(){			
			public void run()
			{
				if(!s.isVisible())
					s.setVisible(true);
				
				DBZugriff.initDB();	
				s.dispose();
			}
				
		});	
		
		loadingthread.start();	
	}
}
