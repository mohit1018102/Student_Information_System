package main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddStudentRecord {

	 JFrame frmAddStudent;
	 String id,name;
	 private JTextField t1;
	 private JTextField t2;
	 private JTextField t3;
	 JComboBox<Object> comboBox;
	 private JTextField batch;
	 private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentRecord window = new AddStudentRecord();
					window.frmAddStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddStudentRecord() {
		initialize();
	}
	public AddStudentRecord(String n,String id) {
		this.id=id;
		name=n;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddStudent = new JFrame();
		frmAddStudent.setTitle("ADD STUDENT");
		frmAddStudent.setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudentRecord.class.getResource("/img/add2.png")));
		frmAddStudent.setBounds(100, 100, 758, 355);
		frmAddStudent.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAddStudent.getContentPane().setLayout(null);
		frmAddStudent.setLocationRelativeTo(null);
		t1 = new JTextField();
		t1.setBounds(134, 48, 187, 20);
		frmAddStudent.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(43, 51, 46, 14);
		frmAddStudent.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("RollNo");
		lblNewLabel.setBounds(43, 89, 46, 14);
		frmAddStudent.getContentPane().add(lblNewLabel);
		
		t2 = new JTextField();
		t2.setBounds(134, 86, 186, 20);
		frmAddStudent.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(43, 125, 89, 14);
		frmAddStudent.getContentPane().add(lblFathersName);
		
		JLabel lblCourse = new JLabel("course");
		lblCourse.setBounds(43, 175, 46, 14);
		frmAddStudent.getContentPane().add(lblCourse);
		
		JLabel lblSection = new JLabel("section");
		lblSection.setBounds(268, 175, 46, 14);
		frmAddStudent.getContentPane().add(lblSection);
		
		t3 = new JTextField();
		t3.setBounds(134, 122, 187, 20);
		frmAddStudent.getContentPane().add(t3);
		t3.setColumns(10);
		
		
		
		comboBox = new JComboBox<Object>();
		
		
		
		comboBox.setBounds(134, 172, 99, 20);
		frmAddStudent.getContentPane().add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		try {
			Connect db=new Connect();
			
			db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			db.statement=db.con.prepareStatement("select * from course");
			db.result=db.statement.executeQuery();
			 while(db.result.next())
			 {
				
				 
						comboBox.addItem(""+db.result.getString(1));
				 
				   
			  }	
			 
			   	
		    }
			
		    catch(Exception e )
		    {
		    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		    
		    }
		comboBox_1.addItem("-");
		for(int i=0;i<3;i++)
		{
			comboBox_1.addItem(String.valueOf((char)('A'+i)));
		}
		comboBox_1.setBounds(324, 172, 57, 20);
		frmAddStudent.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setIcon(new ImageIcon(AddStudentRecord.class.getResource("/img/Cute-Ball-Go-icon.png")));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int b=JOptionPane.showConfirmDialog(null,"Do you want to submit");
				
				if(b==0) {
				String n,r,fn,c,sec,bat;
				n=t1.getText();
				r=t2.getText();
				fn=t3.getText();
				c=comboBox.getSelectedItem()+"";
				sec=comboBox_1.getSelectedItem()+"";
				bat=batch.getText();
				int flag=0;
				if(!r.equals(""))
				{	try {
					      Integer.parseInt(r);
				     }
				    catch(Exception e) {
					flag=1;}
				}
				
				if(flag==1)
				{
					JOptionPane.showMessageDialog(null,"VALID RANGE OF ROLLNO IS <0-9>");	
				}
				else
				if(n.equals("") || r.equals("") || fn.equals("")|| c.equals("")|| sec.equals("")|| bat.equals("")) {
					JOptionPane.showMessageDialog(null,"All fields are Mandatory to fill");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("insert into Student values(?,?,?,?,?,?,?)");
					
					pstmt.setString(1, r);
					pstmt.setString(2, n);
					pstmt.setString(3, fn);
					pstmt.setString(4, c);
					pstmt.setString(5, id);
					pstmt.setString(6, sec);
					pstmt.setString(7, bat);
					try {
					    int i=pstmt.executeUpdate();
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
		btnNewButton.setBounds(88, 274, 99, 23);
		frmAddStudent.getContentPane().add(btnNewButton);
		frmAddStudent.setResizable(false);
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(43, 219, 46, 14);
		frmAddStudent.getContentPane().add(lblBatch);
		
		batch = new JTextField();
		batch.setBounds(134, 216, 187, 20);
		frmAddStudent.getContentPane().add(batch);
		batch.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 162, 380, 2);
		frmAddStudent.getContentPane().add(separator);
		
		JLabel lblEnterTheDetail = new JLabel("Enter The Detail Of Student");
		lblEnterTheDetail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterTheDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheDetail.setBounds(43, 11, 326, 14);
		frmAddStudent.getContentPane().add(lblEnterTheDetail);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(AddStudentRecord.class.getResource("/img/ex.png")));
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				batch.setText("");
				JOptionPane.showMessageDialog(null,"All Clear");
			}
		});
		btnReset.setBounds(222, 274, 99, 23);
		frmAddStudent.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(AddStudentRecord.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu ob=new Menu(name,id);
				frmAddStudent.setVisible(false);
				ob.frmHome.setVisible(true);
			}
		});
		btnBackToHome.setBounds(706, 0, 46, 41);
		frmAddStudent.getContentPane().add(btnBackToHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddStudentRecord.class.getResource("/img/add2.png")));
		label.setBounds(511, 0, 152, 171);
		frmAddStudent.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(416, 174, 326, 145);
		frmAddStudent.getContentPane().add(scrollPane);
		
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
		scrollPane.setViewportView(table);
		
		JLabel lblCourseDetails = new JLabel("Course Details");
		lblCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourseDetails.setBounds(414, 162, 127, 14);
		frmAddStudent.getContentPane().add(lblCourseDetails);
		
	}
}
