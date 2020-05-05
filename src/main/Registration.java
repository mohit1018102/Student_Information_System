package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JToggleButton;

import org.apache.commons.codec.binary.Base64;








public class Registration {
    
    JFrame frmRegistration;
	private JTextField id;
	private JTextField name;
	private JTextField uname;
	private JPasswordField password;
	JComboBox type;
	String na="",no="";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frmRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}
	public Registration(String s,String number) {
		
		na=s;
		no=number;
		initialize();
		
	}

	
	/**
	 * 
	 * Initialize the contents of the frame.
	 * 
	 * 
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/img/Actions-contact-new-icon.png")));
		frmRegistration.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmRegistration.setTitle("Registration");
		frmRegistration.setResizable(false);
		frmRegistration.setBounds(100, 100, 359, 367);
		frmRegistration.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		frmRegistration.setLocationRelativeTo(null);
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(74, 31, 46, 20);
		frmRegistration.getContentPane().add(lblId);
		
		id = new JTextField();
		id.setBounds(145, 31, 86, 20);
		frmRegistration.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setBackground(SystemColor.inactiveCaption);
		lblType.setBounds(74, 105, 46, 14);
		frmRegistration.getContentPane().add(lblType);
		
		type = new JComboBox();
		type.setBounds(145, 102, 120, 20);
		frmRegistration.getContentPane().add(type);

		if(na.equalsIgnoreCase("ADMIN")) { type.addItem("ADMIN");}
		type.addItem("OFFICE");
		type.addItem("FACULTY");
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(74, 68, 46, 14);
		frmRegistration.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setBounds(143, 62, 122, 20);
		frmRegistration.getContentPane().add(name);
		name.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(27, 146, 299, 101);
		frmRegistration.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(22, 23, 76, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(22, 64, 76, 14);
		panel.add(lblPassword);
		
		uname = new JTextField();
		uname.setBounds(106, 20, 158, 20);
		panel.add(uname);
		uname.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(108, 61, 156, 20);
		panel.add(password);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 269, 145, 20);
		frmRegistration.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("SUBMIT");
		panel_1.add(btnNewButton, BorderLayout.CENTER);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int b=JOptionPane.showConfirmDialog(null,"Do you want to submit");

				
				if(b==0) {
				String n,r,t,u;
				n=name.getText();
				r=id.getText();
				
				t=type.getSelectedItem()+"";
				
				u=uname.getText();
				char []p=password.getPassword();
				String pass=new String(p);
				//----------------insertion------------
				if(n.equals("") || r.equals("") || t.equals("")|| u.equals("")|| pass.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("insert into member values(?,?,?,?,?)");
					
					pstmt.setString(1, n);
					pstmt.setString(2, t);
					pstmt.setString(3, r);
					pstmt.setString(4, u);
					pstmt.setString(5, pass);
					
					try {
					    pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record  is Added successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "This Record is already Exist(please check the University Rollno)");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
			}
		}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(194, 269, 132, 20);
		frmRegistration.getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				name.setText("");
				uname.setText("");
				password.setText("");
				type.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "ALL CLEAR!");
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.menu);
		panel_2.add(btnNewButton_1, BorderLayout.CENTER);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(Registration.class.getResource("/img/back.png")));
		btnBackToHome.setBounds(257, 300, 86, 34);
		frmRegistration.getContentPane().add(btnBackToHome);
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRegistration.setVisible(false);
				Menu obj=new Menu(na,no);
				obj.frmHome.setVisible(true);
			}
		});
		btnBackToHome.setBackground(SystemColor.inactiveCaption);
	}
}
