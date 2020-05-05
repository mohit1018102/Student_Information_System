package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import main.Connect;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Submit {

	JFrame frame;
	private JTextField ids;
	private JTable table;
    String type,no;
    private JTable table_1;
    private JTextField name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Submit window = new Submit();
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
	public Submit() {
		initialize();
	}

	public Submit(String t,String n) {
		type=t; no=n;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Submit.class.getResource("/img/Cute-Ball-Go-icon.png")));
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 47, 384, 90);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAssigmentId = new JLabel("Assigment Id");
		lblAssigmentId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAssigmentId.setBounds(10, 11, 91, 22);
		panel.add(lblAssigmentId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.inactiveCaptionBorder);
		comboBox.setBounds(115, 13, 107, 20);
		try {
			Connect db=new Connect();
			
			db.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			db.statement=db.con.prepareStatement("select * from assignment where ID='"+no+"'");
			db.result=db.statement.executeQuery();
			 while(db.result.next())
			 {
				
				 
						comboBox.addItem(""+db.result.getString(2));
				 
				   
			  }	
			 
			   	
		    }
			
		    catch(Exception e )
		    {
		    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		    
		    }
		panel.add(comboBox);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBackground(SystemColor.inactiveCaption);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentId.setBounds(10, 57, 91, 14);
		panel.add(lblStudentId);
		
		ids = new JTextField();
		ids.setBounds(115, 55, 124, 20);
		panel.add(ids);
		ids.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String year="",section = "",course="";
				
				 int b=JOptionPane.showConfirmDialog(null,"Do you want to Add the record");
					
					if(b==0) {
						String num=comboBox.getSelectedItem().toString();
						String id=ids.getText();
						
						try {
							Integer.parseInt(id);
						}
						catch(Exception e)
						{
							id="";
						}
				
				if(id.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Student ID is mandatory & valid range is<0-9>");
				}
				else
				{
					 Connection conn=null;
					  PreparedStatement pstmt=null;
					  try
					  {
						Class.forName("com.mysql.jdbc.Driver");
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
						pstmt=conn.prepareStatement("select * from assignment where ID='"+no+"' and ANO='"+num+"'");
						
						
						ResultSet result=pstmt.executeQuery();
						while(result.next())
						{
							year=result.getString(6);
							section=result.getString(7);
							course=result.getString(8);
							
						}
						
						pstmt=conn.prepareStatement("select * from student where course='"+course+"' and sec='"+section+"' and batch='"+year+"' and uno='"+id+"'");
					
						 result=pstmt.executeQuery();
						 boolean x=false;
						while(result.next())
						{
							x=true;
						}
						if(x)
						{
							pstmt=conn.prepareStatement("insert into submit values(?,?,?)");
							pstmt.setString(1,no);
							pstmt.setString(2, num);
							pstmt.setString(3, id);
							try {
							int i=pstmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "Record  is Added successfully");
							}
							catch(Exception E)
							{
								JOptionPane.showMessageDialog(null, "Record  is Already Exist");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "This assignment is for year:"+year+" courseid:"+course+" section:"+section);
						}
				     }
					  catch(Exception e )
					    {
					    	JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
					    
					    }
				}
			    
			}
			}
		});
		btnSubmit.setBackground(SystemColor.inactiveCaptionBorder);
		btnSubmit.setBounds(267, 54, 89, 22);
		panel.add(btnSubmit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int b=JOptionPane.showConfirmDialog(null,"Do you want to delete the record");
				
				if(b==0) {
					String num=comboBox.getSelectedItem().toString();
				    String id=ids.getText();
				    
				    try
				    {
				    	Integer.parseInt(id);
				    }
				    catch(Exception e)
				    {  
				    	id="";
				    }
				    
				 
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter id number & valid range is<0-9>");
				}
				else {
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("delete from submit where A_NO=? and ID=? and S_ID=?");
					pstmt.setString(1,num);
					pstmt.setString(2,no);
					pstmt.setString(3,id);
					int i=pstmt.executeUpdate();
					
					
					if(i>0) {
						JOptionPane.showMessageDialog(null, "Record  is Removed successfully");
						DefaultTableModel model=(DefaultTableModel)table_1.getModel();
						while(model.getRowCount()>0)
						{  for(int J=0;J<model.getRowCount();J++)
							model.removeRow(J);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "This Record is not Exist(please check the  Assignment_id & Student_id)");
					}
					
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				
				}
				
			}
		}
	}
		});
		btnRemove.setBackground(SystemColor.text);
		btnRemove.setBounds(267, 12, 89, 23);
		panel.add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(404, 47, 532, 90);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Connection conn=null;
		  PreparedStatement pstmt=null;
		  
		  try
		  { 
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
			pstmt=conn.prepareStatement("select * from assignment where ID='"+no+"'");
			
			
			ResultSet rs=pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));	
			
		}
		catch(Exception e1)
		{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
		}
	
		
		JLabel lblAssignmentDetails = new JLabel("Assignment Details");
		lblAssignmentDetails.setBounds(404, 33, 111, 14);
		frame.getContentPane().add(lblAssignmentDetails);
		
		JLabel lblAddStudent = new JLabel("Add/Remove Student");
		lblAddStudent.setBounds(10, 33, 163, 14);
		frame.getContentPane().add(lblAddStudent);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 191, 926, 223);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnSubmittedRecord = new JButton("Submitted Record");
		btnSubmittedRecord.setBackground(SystemColor.text);
		btnSubmittedRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  { String num=comboBox.getSelectedItem().toString();
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select student.* from student,submit where uno=S_ID and ID='"+no+"' and A_NO='"+num+"'");
					
					
					ResultSet rs=pstmt.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));	
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
		});
		btnSubmittedRecord.setBounds(782, 165, 154, 23);
		frame.getContentPane().add(btnSubmittedRecord);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 158, 227, 30);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(10, 11, 56, 14);
		panel_1.add(lblName);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  {  String num=comboBox.getSelectedItem().toString();
				     String ns=name.getText();
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select student.* from student,submit where uno=S_ID and ID='"+no+"' and A_NO='"+num+"' and  Name like '"+ns+"%'");
					ResultSet rs=pstmt.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));	
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
		});
		name.setBounds(45, 5, 172, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(SystemColor.text);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setSelectedIndex(0);
				ids.setText("");
				name.setText("");
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				while(model.getRowCount()>0)
				{  for(int i=0;i<model.getRowCount();i++)
					model.removeRow(i);
				}
				JOptionPane.showMessageDialog(null,"ALL CLEAR !");
			}
			
		});
		btnReset.setBounds(10, 425, 122, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(Submit.class.getResource("/img/back.png")));
		btnBackToHome.setBackground(SystemColor.text);
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Menu ob=new Menu(type,no);
				ob.frame.setVisible(true);
			}
		});
		btnBackToHome.setBounds(888, 418, 48, 30);
		frame.getContentPane().add(btnBackToHome);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBackground(SystemColor.menu);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					boolean b=table_1.print();
					if(b)
					{
						JOptionPane.showMessageDialog(null,"Printing is done","",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Printing is ABORTED","",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch(PrinterException e)
				{
					JOptionPane.showMessageDialog(null,"Check your printer drivers","",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrint.setBounds(683, 165, 89, 23);
		frame.getContentPane().add(btnPrint);
		frame.setBounds(100, 100, 954, 480);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
