package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteRecord {

	JFrame frmDeleteRecord;
	private JTextField t1;
    String name,id;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRecord window = new DeleteRecord();
					window.frmDeleteRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteRecord() {
		initialize();
	}
	public DeleteRecord(String n,String id) {
		initialize();
		name=n;
		this.id=id;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteRecord = new JFrame();
		frmDeleteRecord.setTitle("DELETE RECORD");
		frmDeleteRecord.setResizable(false);
		frmDeleteRecord.setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteRecord.class.getResource("/img/d1.png")));
		frmDeleteRecord.setBounds(100, 100, 434, 215);
		frmDeleteRecord.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmDeleteRecord.getContentPane().setLayout(null);
		frmDeleteRecord.setLocationRelativeTo(null);
		JLabel lblDeleteRecord = new JLabel("DELETE RECORD");
		lblDeleteRecord.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeleteRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteRecord.setBounds(149, 11, 121, 14);
		frmDeleteRecord.getContentPane().add(lblDeleteRecord);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 31, 398, 2);
		frmDeleteRecord.getContentPane().add(separator);
		
		t1 = new JTextField();
		t1.setBounds(149, 70, 86, 20);
		frmDeleteRecord.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(52, 73, 66, 14);
		frmDeleteRecord.getContentPane().add(lblStudentId);
		
		JButton b1 = new JButton("Delete");
		b1.setHorizontalAlignment(SwingConstants.LEFT);
		b1.setIcon(new ImageIcon(DeleteRecord.class.getResource("/img/cs2.png")));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int b=JOptionPane.showConfirmDialog(null,"Do you want to delete the record");
					
					if(b==0) {
					String sid=t1.getText();
					int flag=0;
					if(!sid.equals(""))
					{
						try {
							Integer.parseInt(sid);
						}
						catch(Exception e)
						{
							flag=1;
						}
					}
					if(flag==1)
					{ JOptionPane.showMessageDialog(null,"Valid Range is <0-9>");}
					else
					if(sid.equals("")) {
						JOptionPane.showMessageDialog(null,"Please enter the Student id number");
					}
					else {
					  Connection conn=null;
					  PreparedStatement pstmt=null;
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
						pstmt=conn.prepareStatement("delete from student where uno=?");
						pstmt.setString(1,sid);
						
						
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
		b1.setBounds(92, 140, 97, 23);
		frmDeleteRecord.getContentPane().add(b1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(DeleteRecord.class.getResource("/img/ex.png")));
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");
				JOptionPane.showMessageDialog(null, "ALL CLEAR");
			}
		});
		btnReset.setBounds(222, 140, 89, 23);
		frmDeleteRecord.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(DeleteRecord.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDeleteRecord.setVisible(false);
				Menu ob=new Menu(name,id);
				ob.frmHome.setVisible(true);
				
			}
		});
		btnBackToHome.setBounds(364, 140, 54, 41);
		frmDeleteRecord.getContentPane().add(btnBackToHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeleteRecord.class.getResource("/img/DE2.png")));
		lblNewLabel.setBounds(269, 0, 161, 145);
		frmDeleteRecord.getContentPane().add(lblNewLabel);
	}

}
