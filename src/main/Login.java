package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class Login {

	 public JFrame frame;
	private JTextField user;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/log.png")));
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblUserName = new JLabel("USER NAME :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setBounds(73, 97, 81, 14);
		frame.getContentPane().add(lblUserName);
		
		user = new JTextField();
		user.setBounds(73, 112, 213, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(73, 153, 81, 14);
		frame.getContentPane().add(lblPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 213, 414, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/img/tick.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname=user.getText();
				String pass=new String(password.getPassword());
				if("".equals(uname) && "".equals(pass))
				{
					JOptionPane.showMessageDialog(null,"! Enter your user name & password");
				}
				else
				{  try {
					Connect db=new Connect();
					
					db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					
					db.statement=db.con.prepareStatement("select * from member");
					
					db.result=db.statement.executeQuery();
					int flag=0;
					while(db.result.next())
					{
						if( db.result.getString(4).equals(uname) && db.result.getString(5).equals(pass) )
						{
							String type=db.result.getString(2),no=db.result.getString(3);
						    flag=1;
						   
						    frame.dispose();
						    if(type.equalsIgnoreCase("Faculty"))
						    {
						    	Assignment.Menu Ob=new Assignment.Menu(type,no);
						   
						    	Ob.frame.setVisible(true);
						    }
						    else {
						    Menu en=new Menu(type,no);
						    
							en.frmHome.setVisible(true);
						    }
							JOptionPane.showMessageDialog(null,"Access granted : welcome ");
						   
						}	  	
					}
					if(flag==0) JOptionPane.showMessageDialog(null,"!please check your username and password ");
				    }
				    catch(Exception e )
				    {
				    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				    }
				   
				}
				
					
				
					
					
					
				
			}
		});
		btnLogin.setBounds(49, 221, 107, 33);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.setIcon(new ImageIcon(Login.class.getResource("/img/reset.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.setText("");
				password.setText("");
				JOptionPane.showMessageDialog(null,"ALL CLEAR");
			
			}
		});
		btnReset.setBounds(292, 219, 107, 36);
		frame.getContentPane().add(btnReset);
		
		password = new JPasswordField();
		password.setBounds(73, 167, 213, 20);
		frame.getContentPane().add(password);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/log.png")));
	     
		label.setBounds(116, 0, 328, 271);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/img/Security-Password-2-icon.png")));
		label_1.setBounds(49, 167, 46, 20);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/img/user22.png")));
		label_2.setBounds(49, 105, 46, 27);
		frame.getContentPane().add(label_2);
	}
}
