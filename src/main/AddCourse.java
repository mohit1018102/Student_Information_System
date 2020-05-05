package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class AddCourse {

	JFrame frmAddCourse;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	String name,id;
	JRadioButton r1_1;
	JRadioButton r1;
	private ButtonGroup bg=new ButtonGroup();
	private JLabel lblYears;
	private JLabel lblAddCourse;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse window = new AddCourse();
					window.frmAddCourse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddCourse() {
		initialize();
	}
	public AddCourse(String n,String ids) {
		initialize();
		name=n;
		id=ids;
		bg.add(r1);
		bg.add(r1_1);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCourse = new JFrame();
		frmAddCourse.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmAddCourse.setTitle("ADD COURSE");
		frmAddCourse.setIconImage(Toolkit.getDefaultToolkit().getImage(AddCourse.class.getResource("/img/Package-add-icon.png")));
		frmAddCourse.setResizable(false);
		frmAddCourse.setBounds(100, 100, 443, 393);
		frmAddCourse.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAddCourse.getContentPane().setLayout(null);
		frmAddCourse.setLocationRelativeTo(null);
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(AddCourse.class.getResource("/img/back.png")));
		btnBackToHome.setBackground(new Color(211, 211, 211));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu ob=new Menu(name,id);
				frmAddCourse.setVisible(false);
				ob.frmHome.setVisible(true);
			}
		});
		btnBackToHome.setBounds(367, 307, 48, 46);
		frmAddCourse.getContentPane().add(btnBackToHome);
		
		lblAddCourse = new JLabel("ADD COURSE");
		lblAddCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddCourse.setBounds(110, 11, 221, 31);
		frmAddCourse.getContentPane().add(lblAddCourse);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 414, 5);
		frmAddCourse.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 203, 414, 5);
		frmAddCourse.getContentPane().add(separator_1);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubmit.setIcon(new ImageIcon(AddCourse.class.getResource("/img/Cute-Ball-Go-icon.png")));
		btnSubmit.setBackground(new Color(211, 211, 211));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int b=JOptionPane.showConfirmDialog(null,"Do you want to submit");
				
				if(b==0) {
				String n,cid,type;
				int year;
				cid=t1.getText();
				n=t2.getText();
				try {
				year=Integer.parseInt(t3.getText());
				}
				catch(NumberFormatException e)
				{
					year=0;
				}
				if(r1.isSelected()) type="UG";
				else
					type="PG";
				
				
				//----------------insertion------------
				if(n.equals("") || cid.equals("") || type.equals("")||year==0) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("insert into course values(?,?,?,?)");
					pstmt.setString(1, cid);
					pstmt.setString(2, n);
					pstmt.setString(3, String.valueOf(year));
					pstmt.setString(4, type );
					
					try {
				     	int i=pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record  is Added successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "This Record is already Exist(please check the  Courseid)");
					}
					
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				
				}
			 }
	  }
				
				
			}
		});
		btnSubmit.setBounds(177, 161, 103, 31);
		frmAddCourse.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.setIcon(new ImageIcon(AddCourse.class.getResource("/img/ex.png")));
		btnReset.setBackground(new Color(211, 211, 211));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				r1.setSelected(true);
				JOptionPane.showMessageDialog(null,"All Clear");
			}
		});
		btnReset.setBounds(40, 312, 97, 31);
		frmAddCourse.getContentPane().add(btnReset);
		
		JLabel lblRemoveCourse = new JLabel("REMOVE COURSE");
		lblRemoveCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemoveCourse.setBounds(141, 213, 173, 14);
		frmAddCourse.getContentPane().add(lblRemoveCourse);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(26, 62, 389, 85);
		frmAddCourse.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(84, 11, 86, 20);
		panel_1.add(t1);
		t1.setColumns(10);
		
		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setBounds(10, 13, 69, 14);
		panel_1.add(lblCourseId);
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		t2 = new JTextField();
		t2.setBounds(272, 11, 98, 20);
		panel_1.add(t2);
		t2.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(180, 13, 89, 14);
		panel_1.add(lblCourseName);
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 42, 115, 20);
		panel_1.add(panel);
		panel.setBackground(SystemColor.text);
		panel.setLayout(null);
		
		 r1_1 = new JRadioButton("PG");
		 r1_1.setBounds(57, 0, 52, 18);
		 panel.add(r1_1);
		 r1_1.setBackground(SystemColor.controlLtHighlight);
		 bg.add(r1_1);
		 
		  r1 = new JRadioButton("UG");
		  r1.setBounds(0, 0, 52, 18);
		  panel.add(r1);
		  r1.setBackground(SystemColor.text);
		  bg.add(r1);
		  r1.setSelected(true);
		  
		  t3 = new JTextField();
		  t3.setBounds(271, 42, 36, 20);
		  panel_1.add(t3);
		  t3.setColumns(10);
		  
		  lblYears = new JLabel("years");
		  lblYears.setBounds(317, 42, 46, 14);
		  panel_1.add(lblYears);
		  lblYears.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  
		  JLabel lblDuration = new JLabel("Duration");
		  lblDuration.setBounds(190, 48, 57, 14);
		  panel_1.add(lblDuration);
		  lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  
		  JLabel lblType = new JLabel("Type");
		  lblType.setBounds(10, 48, 46, 14);
		  panel_1.add(lblType);
		  lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  
		  JPanel panel_2 = new JPanel();
		  panel_2.setBackground(SystemColor.inactiveCaption);
		  panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		  panel_2.setBounds(29, 238, 386, 46);
		  frmAddCourse.getContentPane().add(panel_2);
		  panel_2.setLayout(null);
		  
		  JButton btnDelete = new JButton("Delete");
		  btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		  btnDelete.setIcon(new ImageIcon(AddCourse.class.getResource("/img/cs2.png")));
		  btnDelete.setBounds(279, 8, 97, 28);
		  panel_2.add(btnDelete);
		  btnDelete.setBackground(new Color(211, 211, 211));
		  
		  t4 = new JTextField();
		  t4.setBounds(128, 12, 86, 20);
		  panel_2.add(t4);
		  t4.setColumns(10);
		  
		  JLabel lblCourseId_1 = new JLabel("Course ID");
		  lblCourseId_1.setBounds(52, 14, 66, 14);
		  panel_2.add(lblCourseId_1);
		  lblCourseId_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  
		  JLabel label = new JLabel("");
		  label.setIcon(new ImageIcon(AddCourse.class.getResource("/img/Service_icons_reimagine1.png")));
		  label.setBounds(163, 0, 281, 364);
		  frmAddCourse.getContentPane().add(label);
		  btnDelete.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
                int b=JOptionPane.showConfirmDialog(null,"Do you want to delete the record");
		  		
		  		if(b==0) {
		  		String cid=t4.getText();
		  		if(cid.equals("")) {
		  			JOptionPane.showMessageDialog(null,"Please enter the course id number");
		  		}
		  		else {
		  		  Connection conn=null;
		  		  PreparedStatement pstmt=null;
		  		try
		  		{
		  			Class.forName("com.mysql.jdbc.Driver");
		  			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
		  			pstmt=conn.prepareStatement("delete from course where courseid=?");
		  			pstmt.setString(1, cid);
		  			
		  			
		  			int i=pstmt.executeUpdate();
		  			
		  			
		  			if(i>0) {
		  				JOptionPane.showMessageDialog(null, "Record  is Removed successfully");
		  			}
		  			else
		  			{
		  				JOptionPane.showMessageDialog(null, "This Record is not Exist(please check the  Courseid)");
		  			}
		  			
		  		
		  				
		  			
		  		}
		  		catch(Exception e)
		  		{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		  		
		  		}
		  	 }
		  		
		  	}
		  }
		  	
		  	
		  });
	}
}
