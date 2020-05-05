package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import main.Connect;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class UpdateAssign {

	JFrame frame;
	private JTextField id;
	private JTextField atitle;
    String type,no;
    JDateChooser dos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAssign window = new UpdateAssign();
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
	public UpdateAssign() {
		initialize();
	}
	public UpdateAssign(String t,String n) {
		type=t;
		no=n;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateAssign.class.getResource("/img/8338-200.png")));
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 32, 365, 2);
		frame.getContentPane().add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 107, 380, 142);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAssignment = new JLabel("Assignment Title");
		lblAssignment.setBounds(21, 11, 105, 14);
		lblAssignment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblAssignment);
		
		atitle = new JTextField();
		atitle.setBounds(122, 9, 157, 20);
		panel.add(atitle);
		atitle.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=id.getText();
				String title=atitle.getText();
				//----------------updation------------
			
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE assignment SET A_NAME='"+title+"' where ANO='"+num+"' and ID='"+no+"'");
					
					
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
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(281, 8, 89, 23);
		panel.add(btnUpdate);
		
		JLabel lblAssignmentDescription = new JLabel("Assignment Description");
		lblAssignmentDescription.setBounds(21, 56, 145, 14);
		panel.add(lblAssignmentDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 81, 347, 50);
		panel.add(scrollPane);
		
		JTextArea adesc = new JTextArea();
		adesc.setRows(1);
		adesc.setLineWrap(true);
		scrollPane.setViewportView(adesc);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=id.getText();
				String desc=adesc.getText();
				//----------------updation------------
			
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE assignment SET A_DESC='"+desc+"' where ANO='"+num+"' and ID='"+no+"'");
					
					
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
		btnUpdate_1.setBackground(Color.WHITE);
		btnUpdate_1.setBounds(281, 52, 89, 23);
		panel.add(btnUpdate_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 260, 380, 134);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourse.setBounds(10, 11, 46, 14);
		
		
		panel_1.add(lblCourse);
		
		JComboBox course = new JComboBox();
		course.setBounds(52, 9, 66, 20);
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
		panel_1.add(course);
		
		JButton btnUpdate_2 = new JButton("Update");
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=id.getText();
				String c=course.getSelectedItem().toString();
				//----------------updation------------
			
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE assignment SET courseId='"+c+"' where ANO='"+num+"' and ID='"+no+"'");
					
					
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
		btnUpdate_2.setBackground(Color.WHITE);
		btnUpdate_2.setBounds(128, 8, 89, 23);
		panel_1.add(btnUpdate_2);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSection.setBounds(10, 40, 46, 14);
		panel_1.add(lblSection);
		
		JComboBox section = new JComboBox();
		section.setBounds(52, 38, 66, 20);
		section.addItem("-");
		for(int i=0;i<3;i++)
		{
			section.addItem(String.valueOf((char)('A'+i)));
		}
		panel_1.add(section);
		
		JButton btnUpdate_3 = new JButton("Update");
		btnUpdate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=id.getText();
				String sec=section.getSelectedItem().toString();
				//----------------updation------------
			
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE assignment SET section='"+sec+"' where ANO='"+num+"' and ID='"+no+"'");
					
					
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
		btnUpdate_3.setBackground(Color.WHITE);
		btnUpdate_3.setBounds(128, 37, 89, 23);
		panel_1.add(btnUpdate_3);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYear.setBounds(10, 72, 46, 14);
		
		
		panel_1.add(lblYear);
		
		JComboBox year = new JComboBox();
		year.setBounds(52, 69, 66, 20);
		try {
			Connect db=new Connect();
			
			db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			db.statement=db.con.prepareStatement("select distinct batch from student");
			db.result=db.statement.executeQuery();
			 while(db.result.next())
			 {
				
				 
						year.addItem(""+db.result.getString(1));
				 
				   
			  }	
			 
			   	
		    }
			
		    catch(Exception e )
		    {
		    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		    
		    }
		panel_1.add(year);
		
		JButton btnUpdate_4 = new JButton("Update");
		btnUpdate_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=id.getText();
				String y=year.getSelectedItem().toString();
				//----------------updation------------
			
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE assignment SET year='"+y+"' where ANO='"+num+"' and ID='"+no+"'");
					
					
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
		btnUpdate_4.setBackground(Color.WHITE);
		btnUpdate_4.setBounds(128, 68, 89, 23);
		panel_1.add(btnUpdate_4);
		
		JButton btnUpdate_5 = new JButton("Update");
		btnUpdate_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num=id.getText();
				String date=new SimpleDateFormat("yyy-MM-dd").format(dos.getDate());
				//----------------updation------------
			
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("UPDATE assignment SET Submit_Date='"+date+"' where ANO='"+num+"' and ID='"+no+"'");
					
					
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
		btnUpdate_5.setBackground(Color.WHITE);
		btnUpdate_5.setBounds(128, 100, 89, 23);
		panel_1.add(btnUpdate_5);
		
		JLabel lblDos = new JLabel("DOS");
		lblDos.setBounds(10, 104, 46, 14);
		panel_1.add(lblDos);
		
		 dos = new JDateChooser();
		dos.setBounds(52, 103, 76, 20);
		panel_1.add(dos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(10, 45, 380, 40);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAssignmentId = new JLabel("Assignment Id");
		lblAssignmentId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAssignmentId.setBounds(28, 11, 81, 14);
		panel_2.add(lblAssignmentId);
		
		id = new JTextField();
		id.setBounds(139, 9, 135, 20);
		panel_2.add(id);
		id.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(113, 12, 46, 14);
		panel_2.add(label);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				atitle.setText("");
			    adesc.setText("");
				course.setSelectedItem(0);
				year.setSelectedItem(0);
				section.setSelectedItem(0);
				 dos.setCalendar(null);
				 JOptionPane.showMessageDialog(null,"ALL CLEAR !");
			}
			
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(10, 401, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(UpdateAssign.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Menu ob=new Menu(type,no);
				ob.frame.setVisible(true);
			}
		});
		btnBackToHome.setBackground(Color.WHITE);
		btnBackToHome.setBounds(338, 401, 52, 40);
		frame.getContentPane().add(btnBackToHome);
		
		JLabel lblUpdateAssignmentEntry = new JLabel("UPDATE ASSIGNMENT ENTRY");
		lblUpdateAssignmentEntry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateAssignmentEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateAssignmentEntry.setBounds(69, 0, 245, 25);
		frame.getContentPane().add(lblUpdateAssignmentEntry);
		frame.setBounds(100, 100, 404, 474);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
