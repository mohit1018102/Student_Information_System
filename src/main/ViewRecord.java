package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ViewRecord {

	 public JFrame frmViewRecords;
	private JTable table;
	private JTextField searchName;
	JComboBox comboBox,year,section;
	private JTextField uno;
	String name,id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRecord window = new ViewRecord();
					window.frmViewRecords.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewRecord() {
		initialize();
	}
	public ViewRecord(String n,String i) {
		initialize();
		name=n;
		id=i;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewRecords = new JFrame();
		frmViewRecords.setResizable(false);
		frmViewRecords.setTitle("View Records");
		frmViewRecords.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewRecord.class.getResource("/img/Tablet-Chart-icon.png")));
		frmViewRecords.getContentPane().setBackground(SystemColor.activeCaption);
		frmViewRecords.setBackground(SystemColor.activeCaption);
		frmViewRecords.setBounds(100, 100, 1095, 622);
		frmViewRecords.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmViewRecords.getContentPane().setLayout(null);
		frmViewRecords.setLocationRelativeTo(null);
		JScrollPane table_1 = new JScrollPane();
		table_1.setEnabled(false);
		table_1.setBounds(10, 84, 1070, 451);
		frmViewRecords.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
		
		JButton btnSearch = new JButton("All Records");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchName.setText("");
				 Connection conn=null;
				  PreparedStatement pstmt=null;
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select * from student");
					
					
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
						
					
				}
				catch(Exception e)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
				
			}
		});
		btnSearch.setBounds(975, 39, 105, 34);
		frmViewRecords.getContentPane().add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 39, 218, 34);
		frmViewRecords.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(10, 10, 46, 14);
		panel.add(lblName);
		
		searchName = new JTextField();
		searchName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  {  String s=searchName.getText();
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select * from student where Name like '"+s+"%'");
					
					
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
						
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
			
			
		});
		
		searchName.setBounds(66, 6, 142, 22);
		panel.add(searchName);
		searchName.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				  
				  Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  {  String s=String.valueOf(comboBox.getSelectedItem());
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select * from student where course='"+s+"'");
					
					
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));	
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
			
			
		});
		comboBox.setBackground(SystemColor.inactiveCaptionBorder);
		comboBox.setBounds(415, 39, 91, 34);
		try {
			Connect db=new Connect();
			comboBox.addItem("Course");
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
		frmViewRecords.getContentPane().add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(238, 39, 167, 34);
		frmViewRecords.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUnivno = new JLabel("Univ.No");
		lblUnivno.setBounds(10, 11, 46, 14);
		panel_1.add(lblUnivno);
		
		uno = new JTextField();
		uno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  {  String s=uno.getText();
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select * from student where uno like '"+s+"%'");
					
					
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
						
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
		});
		uno.setBounds(56, 8, 101, 20);
		panel_1.add(uno);
		uno.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(516, 39, 280, 34);
		frmViewRecords.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		year = new JComboBox();
		year.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  {  String s=String.valueOf(year.getSelectedItem());
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select * from student where batch='"+s+"'");
					
					
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));	
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
			
		});
		year.setBounds(10, 11, 71, 20);
		panel_2.add(year);
		year.addItem("-");
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
		
		section = new JComboBox();
		section.setBounds(91, 11, 60, 20);
		panel_2.add(section);
		section.addItem("-");
		for(int i=0;i<3;i++)
		{
			section.addItem(String.valueOf((char)('A'+i)));
		}
		
		JButton btnYearsection = new JButton("Year &section");
		btnYearsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn=null;
				  PreparedStatement pstmt=null;
				  
				  try
				  {  String b=String.valueOf(year.getSelectedItem());
				     String s=String.valueOf(section.getSelectedItem());
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
					pstmt=conn.prepareStatement("select * from student where batch='"+b+"' and sec='"+s+"'");
					
					
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));	
					
				}
				catch(Exception e1)
				{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
				}
			}
		});
		btnYearsection.setBounds(161, 11, 115, 20);
		panel_2.add(btnYearsection);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblYear.setBounds(10, 0, 46, 8);
		panel_2.add(lblYear);
		
		JLabel lblSection = new JLabel("section");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblSection.setBounds(89, -3, 46, 14);
		panel_2.add(lblSection);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchName.setText("");
				uno.setText("");
				comboBox.setSelectedIndex(0);
				year.setSelectedIndex(0);
				section.setSelectedIndex(0);
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				while(model.getRowCount()>0)
				{  for(int i=0;i<model.getRowCount();i++)
					model.removeRow(i);
				}
				JOptionPane.showMessageDialog(null,"ALL CLEAR");
			}
		});
		btnReset.setBounds(10, 549, 89, 23);
		frmViewRecords.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(ViewRecord.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmViewRecords.setVisible(false);
				if(name.equalsIgnoreCase("Admin") || name.equalsIgnoreCase("OFFICE") )
				{Menu ob=new Menu(name,id);
				ob.frmHome.setVisible(true);
				}
				else
				{
					Assignment.Menu ob=new Assignment.Menu(name,id);
					ob.frame.setVisible(true);
				}
				
			}
		});
		btnBackToHome.setBounds(1025, 548, 55, 34);
		frmViewRecords.getContentPane().add(btnBackToHome);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					boolean b=table.print();
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
		btnPrint.setBounds(874, 39, 89, 34);
		frmViewRecords.getContentPane().add(btnPrint);
	}
}
