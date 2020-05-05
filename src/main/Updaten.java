package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Updaten {

	 public JFrame frmChangeUserName;
	private JTextField uname;
	String type="",no="";
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updaten window = new Updaten();
					window.frmChangeUserName.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Updaten() {
		initialize();
	}
	public Updaten(String t,String n) {
		type=t; no=n;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChangeUserName = new JFrame();
		frmChangeUserName.setIconImage(Toolkit.getDefaultToolkit().getImage(Updaten.class.getResource("/img/RE2.png")));
		frmChangeUserName.setResizable(false);
		frmChangeUserName.setTitle("Change User Name and password");
		frmChangeUserName.getContentPane().setBackground(SystemColor.activeCaption);
		frmChangeUserName.setBounds(100, 100, 440, 248);
		frmChangeUserName.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmChangeUserName.getContentPane().setLayout(null);
		frmChangeUserName.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 58, 411, 95);
		frmChangeUserName.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(21, 26, 65, 14);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 54, 65, 14);
		panel.add(lblPassword);
		
		uname = new JTextField();
		uname.setBounds(107, 23, 172, 20);
		panel.add(uname);
		uname.setColumns(10);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u=uname.getText();
				//----------------updation------------
				if(no.equalsIgnoreCase("")) {System.exit(0);}
				else
				if(u.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is empty!");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE member SET USER_NAME='"+u+"' where ID='"+no+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the ID");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
			}
		});
		btnChange.setBackground(Color.WHITE);
		btnChange.setBounds(299, 22, 89, 23);
		panel.add(btnChange);
		
		JButton btnChange_1 = new JButton("Change");
		btnChange_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char n[]=pass.getPassword();
				String password=new String(n);
			
				
				
				
				//----------------updation------------
				if(no.equalsIgnoreCase("")) { System.exit(0);}
				else
				if(password.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is empty!");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE member SET PASSWORD='"+password+"' where ID='"+no+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the ID");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
			
			}
		});
		btnChange_1.setBackground(Color.WHITE);
		btnChange_1.setBounds(299, 50, 89, 23);
		panel.add(btnChange_1);
		
		pass = new JPasswordField();
		pass.setBounds(107, 51, 172, 20);
		panel.add(pass);
		
		JLabel lblChangeUsernameAnd = new JLabel("Change User_Name And Password");
		lblChangeUsernameAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeUsernameAnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChangeUsernameAnd.setBounds(78, 11, 265, 29);
		frmChangeUserName.getContentPane().add(lblChangeUsernameAnd);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 411, 2);
		frmChangeUserName.getContentPane().add(separator);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uname.setText("");
				pass.setText("");
				JOptionPane.showMessageDialog(null,"ALL CLEAR !");
			}
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(10, 175, 89, 23);
		frmChangeUserName.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(Updaten.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmChangeUserName.setVisible(false);
				if(type.equalsIgnoreCase("Admin") || type.equalsIgnoreCase("OFFICE")) {
				Menu obj=new Menu(type,no);
				obj.frmHome.setVisible(true);
				}
				else
				{
					Assignment.Menu ob=new Assignment.Menu(type,no);
					ob.frame.setVisible(true);
					
				}
			}
		});
		btnBackToHome.setBackground(Color.WHITE);
		btnBackToHome.setBounds(382, 174, 39, 34);
		frmChangeUserName.getContentPane().add(btnBackToHome);
	}
}
