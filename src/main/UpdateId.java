package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class UpdateId {

    JFrame frmUpdate;
	private JTextField id;
	private JTextField name;
	private JTextField uname;
	JComboBox type;
	String tx,rol;
	private JPasswordField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateId window = new UpdateId();
					window.frmUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateId() {
		initialize();
	}
	
	public UpdateId(String t,String roll) {
		
		tx=t;
		rol=roll;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdate = new JFrame();
		frmUpdate.setResizable(false);
		frmUpdate.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateId.class.getResource("/img/RE2.png")));
		frmUpdate.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmUpdate.setTitle("UPDATE");
		frmUpdate.setBounds(100, 100, 420, 408);
		frmUpdate.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmUpdate.getContentPane().setLayout(null);
		frmUpdate.setLocationRelativeTo(null);
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(80, 36, 22, 14);
		frmUpdate.getContentPane().add(lblId);
		
		id = new JTextField();
		id.setBounds(128, 33, 128, 20);
		frmUpdate.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(96, 36, 22, 14);
		frmUpdate.getContentPane().add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 393, 2);
		frmUpdate.getContentPane().add(separator);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(80, 103, 46, 14);
		frmUpdate.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setBounds(129, 100, 155, 20);
		frmUpdate.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setBounds(80, 141, 46, 14);
		frmUpdate.getContentPane().add(lblType);
		
		type = new JComboBox();
		type.setBounds(129, 138, 87, 20);
		frmUpdate.getContentPane().add(type);
		type.addItem("");
		type.addItem("ADMIN");
		type.addItem("OFFICE");
		type.addItem("FACULTY");
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n=name.getText();
				String ids=id.getText();
				
					
					
				//----------------updation------------
				if(ids.equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null,"ID Field is Empty");}
				else
				if(n.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is empty!");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE member SET NAME='"+n+"' where ID='"+ids+"'");
					
					
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
		btnUpdate.setBounds(314, 99, 89, 23);
		frmUpdate.getContentPane().add(btnUpdate);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.setBackground(Color.WHITE);
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t=type.getSelectedItem().toString();
				String ids=id.getText();
				
				
				
				//----------------updation------------
				if(ids.equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null,"ID Field is Empty");}
				else
				if(t.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is empty!");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE member SET TYPE='"+t+"' where ID='"+ids+"'");
					
					
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
		btnUpdate_1.setBounds(314, 137, 89, 23);
		frmUpdate.getContentPane().add(btnUpdate_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(25, 203, 378, 104);
		frmUpdate.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(10, 22, 67, 14);
		panel.add(lblUserName);
		
		uname = new JTextField();
		uname.setBounds(87, 19, 164, 20);
		panel.add(uname);
		uname.setColumns(10);
		
		JButton btnUpdate_2 = new JButton("UPDATE");
		btnUpdate_2.setBackground(Color.WHITE);
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u=uname.getText();
				String ids=id.getText();
				
				
				
				//----------------updation------------
				if(ids.equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null,"ID Field is Empty");}
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
					pstmt=conn.prepareStatement("UPDATE member SET USER_NAME='"+u+"' where ID='"+ids+"'");
					
					
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
		btnUpdate_2.setBounds(261, 18, 100, 23);
		panel.add(btnUpdate_2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 60, 67, 14);
		panel.add(lblPassword);
		
		JButton btnUpdate_3 = new JButton("UPDATE");
		btnUpdate_3.setBackground(Color.WHITE);
		btnUpdate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char n[]=pass.getPassword();
				String password=new String(n);
				String ids=id.getText();
				
				
				
				//----------------updation------------
				if(ids.equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null,"ID Field is Empty");}
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
					pstmt=conn.prepareStatement("UPDATE member SET PASSWORD='"+password+"' where ID='"+ids+"'");
					
					
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
		btnUpdate_3.setBounds(261, 56, 100, 23);
		panel.add(btnUpdate_3);
		
		pass = new JPasswordField();
		pass.setBounds(87, 57, 164, 20);
		panel.add(pass);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				type.setSelectedIndex(0);
				id.setText("");
				uname.setText("");
				pass.setText("");
				JOptionPane.showMessageDialog(null,"ALL CLEAR!");
			}
		});
		btnReset.setBounds(25, 335, 89, 23);
		frmUpdate.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(UpdateId.class.getResource("/img/back.png")));
		btnBackToHome.setBackground(Color.WHITE);
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmUpdate.setVisible(false);
				Menu obj=new Menu(tx,rol);
				obj.frmHome.setVisible(true);
			}
		});
		btnBackToHome.setBounds(325, 323, 65, 36);
		frmUpdate.getContentPane().add(btnBackToHome);
	}
}
