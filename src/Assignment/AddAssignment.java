package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import main.Connect;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class AddAssignment {

	JFrame frame;
	private JTextField ano;
	private JTextField atitle;
	JComboBox year,section,cid;
	JDateChooser dos ;
	String type="",no="";
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAssignment window = new AddAssignment();
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
	public AddAssignment() {
		initialize();
	}
	public AddAssignment(String t,String n) {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddAssignment.class.getResource("/img/plus.png")));
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 850, 383);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(30, 41, 415, 177);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAssignmentno = new JLabel("Assignment_No");
		lblAssignmentno.setBounds(10, 11, 102, 14);
		lblAssignmentno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblAssignmentno);
		
		ano = new JTextField();
		ano.setBounds(105, 9, 133, 20);
		panel.add(ano);
		ano.setColumns(10);
		
		JLabel lblAssignmentTitle = new JLabel("Assignment Title");
		lblAssignmentTitle.setBounds(10, 43, 102, 14);
		lblAssignmentTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblAssignmentTitle);
		
		atitle = new JTextField();
		atitle.setBounds(105, 40, 133, 20);
		panel.add(atitle);
		atitle.setColumns(10);
		
		JLabel lblAssignmentDescription = new JLabel("Assignment Description");
		lblAssignmentDescription.setBounds(10, 79, 133, 14);
		lblAssignmentDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblAssignmentDescription);
		
		
		JLabel lblCourseid = new JLabel("Course_ID");
		lblCourseid.setBounds(247, 79, 74, 14);
		lblCourseid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblCourseid);
		
		cid = new JComboBox();
		cid.setBounds(331, 77, 74, 20);
		try {
			Connect db=new Connect();
			
			db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			db.statement=db.con.prepareStatement("select * from course");
			db.result=db.statement.executeQuery();
			 while(db.result.next())
			 {
				
				 
						cid.addItem(""+db.result.getString(1));
				 
				   
			  }	
			 
			   	
		    }
			
		    catch(Exception e )
		    {
		    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		    
		    }
		panel.add(cid);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 395, 58);
		panel.add(scrollPane);
		
		JTextArea adesc = new JTextArea();
		adesc.setLineWrap(true);
		adesc.setRows(3);
		scrollPane.setViewportView(adesc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(30, 243, 415, 45);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYear.setBounds(10, 11, 46, 14);
		panel_1.add(lblYear);
		
		year = new JComboBox();
		year.setBounds(40, 9, 78, 20);
		panel_1.add(year);
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
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(154, 12, 46, 14);
		panel_1.add(lblSection);
		
		 section = new JComboBox();
		section.setBounds(204, 9, 66, 20);
		panel_1.add(section);
		section.addItem("-");
		for(int i=0;i<3;i++)
		{
			section.addItem(String.valueOf((char)('A'+i)));
		}
		
		JLabel lblDos = new JLabel("DOS");
		lblDos.setBounds(286, 12, 46, 14);
		panel_1.add(lblDos);
		
		dos = new JDateChooser();
		dos.setBounds(314, 9, 91, 20);
		panel_1.add(dos);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.setIcon(new ImageIcon(AddAssignment.class.getResource("/img/ex.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ano.setText("");
				atitle.setText("");
			    adesc.setText("");
				cid.setSelectedItem(0);
				year.setSelectedItem(0);
				section.setSelectedItem(0);
				 dos.setCalendar(null);
				 JOptionPane.showMessageDialog(null,"ALL CLEAR !");
			}
		});
		btnReset.setBounds(108, 310, 100, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(AddAssignment.class.getResource("/img/Cute-Ball-Go-icon.png")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int ZB=JOptionPane.showConfirmDialog(null,"Do you want to Add the record");
					
					if(ZB==0) {
				String num=ano.getText();
				String title=atitle.getText();
				String desc=adesc.getText();
				String course=cid.getSelectedItem().toString();
				String y=year.getSelectedItem().toString();
				String sec=section.getSelectedItem().toString();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String date="";
				try {
				date=sdf.format(dos.getDate());
				}
				catch(Exception e)
				{
					date="";
				}
				
				if(num.equals("") || title.equals("") || desc.equals("")|| course.equals("")|| sec.equals("")|| y.equals("")||date.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("insert into assignment values(?,?,?,?,?,?,?,?)");
					
					pstmt.setString(1,no);
					pstmt.setString(2,num);
					pstmt.setString(3,title);
					pstmt.setString(4,desc);
					pstmt.setString(5,date);
					pstmt.setString(6,y);
					pstmt.setString(7,sec);
					pstmt.setString(8,course);
					try {
					    int i=pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record  is Added successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "This Record is already Exist(please check the ASSIGNMENT NO)");
					}
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			 }
			
					}}});
		btnSubmit.setBounds(258, 310, 100, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(AddAssignment.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Menu ob=new Menu(type,no);
				ob.frame.setVisible(true);
			}
			
		});
		btnBackToHome.setBounds(794, 11, 40, 34);
		frame.getContentPane().add(btnBackToHome);
		
		JLabel lblAssignmentEntry = new JLabel("Assignment Entry");
		lblAssignmentEntry.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAssignmentEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignmentEntry.setBounds(160, 11, 154, 23);
		frame.getContentPane().add(lblAssignmentEntry);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddAssignment.class.getResource("/img/plus.png")));
		label.setBounds(546, 41, 190, 177);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(467, 229, 367, 114);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		try {
			Connect db=new Connect();
			
			db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			db.statement=db.con.prepareStatement("select * from course");
			db.result=db.statement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(db.result));
			 
			   	
		    }
			
		    catch(Exception e )
		    {
		    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		    
		    }
		scrollPane_1.setViewportView(table);
		
		JLabel lblCourseDetail = new JLabel("Course Detail");
		lblCourseDetail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourseDetail.setBounds(467, 215, 91, 14);
		frame.getContentPane().add(lblCourseDetail);
	}
}
