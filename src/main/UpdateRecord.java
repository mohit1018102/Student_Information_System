package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class UpdateRecord {

	 JFrame frmUpdateRecord;
	private JTextField fname;
	private JTextField name;
	private JTextField rollno;
	JComboBox course,sec;
	String Name,R;
	private JTextField ba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRecord window = new UpdateRecord();
					window.frmUpdateRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateRecord() {
		initialize();
	}
	
	public UpdateRecord(String n,String i) {
		initialize();
		Name=n; R=i;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateRecord = new JFrame();
		frmUpdateRecord.setTitle("UPDATE RECORD");
		frmUpdateRecord.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateRecord.class.getResource("/img/update.png")));
		frmUpdateRecord.setResizable(false);
		frmUpdateRecord.setBounds(100, 100, 474, 367);
		frmUpdateRecord.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmUpdateRecord.getContentPane().setLayout(null);
		frmUpdateRecord.setLocationRelativeTo(null);
		fname = new JTextField();
		fname.setBounds(136, 110, 151, 20);
		frmUpdateRecord.getContentPane().add(fname);
		fname.setColumns(10);
		
		name = new JTextField();
		name.setBounds(136, 141, 151, 20);
		frmUpdateRecord.getContentPane().add(name);
		name.setColumns(10);
		
		course = new JComboBox();
		course.setBounds(136, 172, 86, 20);
		frmUpdateRecord.getContentPane().add(course);
		
		try {
			Connect db=new Connect();
			
			db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			db.statement=db.con.prepareStatement("select * from course");
			db.result=db.statement.executeQuery();
			 while(db.result.next())
			 {
				
				 
						course.addItem(""+db.result.getString(1));
				 
				   
			  }	
			 
			   	
		    }
			
		    catch(Exception e )
		    {
		    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		    
		    }
		
		 sec = new JComboBox();
		sec.setBounds(136, 203, 86, 20);
		sec.addItem("-");
		for(int i=0;i<3;i++)
		{
			sec.addItem(String.valueOf((char)('A'+i)));
		}
		frmUpdateRecord.getContentPane().add(sec);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(30, 144, 46, 14);
		frmUpdateRecord.getContentPane().add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name ");
		lblFathersName.setBounds(30, 113, 96, 14);
		frmUpdateRecord.getContentPane().add(lblFathersName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(30, 175, 46, 14);
		frmUpdateRecord.getContentPane().add(lblCourse);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(30, 206, 46, 14);
		frmUpdateRecord.getContentPane().add(lblSection);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(239, 11, 1, 183);
		frmUpdateRecord.getContentPane().add(separator);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String f=fname.getText();
				int ids=0;
				try {
				 ids=Integer.parseInt(rollno.getText());
				}
				catch(NumberFormatException e)
				{
					
					rollno.setText("");
					ids=0;
				}
				//----------------updation------------
				if(ids==0) JOptionPane.showMessageDialog(null,"Invalid number<0-9>");
				else
				if(f.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is Empty");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE student SET fname='"+f+"' where uno='"+ids+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the university Rollno");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
				
			}
				
			
		});
		btnUpdate.setBounds(317, 109, 89, 23);
		frmUpdateRecord.getContentPane().add(btnUpdate);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String n=name.getText();
				int ids=0;
				try {
				 ids=Integer.parseInt(rollno.getText());
				}
				catch(NumberFormatException e)
				{
					
					rollno.setText("");
					ids=0;
				}
				//----------------updation------------
				if(ids==0) JOptionPane.showMessageDialog(null,"Invalid number<0-9>");
				else if(n.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is empty");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE student SET Name='"+n+"' where uno='"+ids+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the university Rollno");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
				
			}
			
			
			
		});
		btnUpdate_1.setBounds(317, 140, 89, 23);
		frmUpdateRecord.getContentPane().add(btnUpdate_1);
		
		JButton btnUpdate_2 = new JButton("UPDATE");
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String c=course.getSelectedItem()+"";
				int ids=0;
				try {
				 ids=Integer.parseInt(rollno.getText());
				}
				catch(NumberFormatException e)
				{
					
					rollno.setText("");
					ids=0;
				}
				//----------------updation------------
				if(ids==0) JOptionPane.showMessageDialog(null,"Invalid number<0-9>");
				else if(c.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE student SET course='"+c+"' where uno='"+ids+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the university Rollno");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
			}
		});
		btnUpdate_2.setBounds(317, 171, 89, 23);
		frmUpdateRecord.getContentPane().add(btnUpdate_2);
		
		JButton btnUpdate_3 = new JButton("UPDATE");
		btnUpdate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=sec.getSelectedItem()+"";
				int ids=0;
				try {
				 ids=Integer.parseInt(rollno.getText());
				}
				catch(NumberFormatException e)
				{
					
					rollno.setText("");
					ids=0;
				}
				//----------------updation------------
				if(ids==0) JOptionPane.showMessageDialog(null,"Invalid number valid range is <0-9>");
				else if(s.equals("")) {
					JOptionPane.showMessageDialog(null," field is Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE student SET Name='"+s+"' where uno='"+ids+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the university Rollno");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
			}
		});
		btnUpdate_3.setBounds(317, 202, 89, 23);
		frmUpdateRecord.getContentPane().add(btnUpdate_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 85, 438, 2);
		frmUpdateRecord.getContentPane().add(separator_1);
		
		JLabel lblStudentsId = new JLabel("Student's ID");
		lblStudentsId.setBounds(88, 35, 75, 14);
		frmUpdateRecord.getContentPane().add(lblStudentsId);
		
		rollno = new JTextField();
		rollno.setBounds(179, 32, 149, 20);
		frmUpdateRecord.getContentPane().add(rollno);
		rollno.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(163, 35, 46, 14);
		frmUpdateRecord.getContentPane().add(label);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(UpdateRecord.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmUpdateRecord.dispose();
				Menu ob=new Menu(Name,R);
				ob.frmHome.setVisible(true);
			}
		});
		btnBackToHome.setBounds(412, 286, 46, 41);
		frmUpdateRecord.getContentPane().add(btnBackToHome);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(UpdateRecord.class.getResource("/img/ex.png")));
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				fname.setText("");
				rollno.setText("");
				course.setSelectedIndex(0);
				sec.setSelectedIndex(0);
				
				JOptionPane.showMessageDialog(null,"All Clear");
			}
		});
		btnReset.setBounds(10, 304, 89, 23);
		frmUpdateRecord.getContentPane().add(btnReset);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(30, 237, 46, 14);
		frmUpdateRecord.getContentPane().add(lblBatch);
		
		ba = new JTextField();
		ba.setBounds(136, 234, 122, 20);
		frmUpdateRecord.getContentPane().add(ba);
		ba.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(UpdateRecord.class.getResource("/img/update.png")));
		label_1.setBounds(199, 35, 328, 338);
		frmUpdateRecord.getContentPane().add(label_1);
		
		JButton btnUpdate_4 = new JButton("UPDATE");
		btnUpdate_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String b=ba.getText();
				int ids=0;
				try {
				 ids=Integer.parseInt(rollno.getText());
				}
				catch(NumberFormatException e)
				{
					
					rollno.setText("");
					ids=0;
				}
				//----------------updation------------
				if(ids==0) JOptionPane.showMessageDialog(null,"Invalid number<0-9>");
				else if(b.equals("")) {
					JOptionPane.showMessageDialog(null,"Field is empty");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE student SET batch='"+b+"' where uno='"+ids+"'");
					
					
					int i=pstmt.executeUpdate();
					if(i>0) {
				    JOptionPane.showMessageDialog(null, "Record  is Updated successfully");
					}
				  else
					{
						JOptionPane.showMessageDialog(null, "Record is not exist please check the university Rollno");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
				
			}
			
		});
		btnUpdate_4.setBounds(317, 233, 89, 23);
		frmUpdateRecord.getContentPane().add(btnUpdate_4);
	}
}
