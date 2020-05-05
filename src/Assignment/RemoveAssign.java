package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class RemoveAssign {

	JFrame frame;
	private JTextField id;
    String type="",no="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveAssign window = new RemoveAssign();
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
	public RemoveAssign() {
		initialize();
	}
	public RemoveAssign(String t,String n) {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RemoveAssign.class.getResource("/img/110746-200.png")));
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 450, 199);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAssignmentid = new JLabel("Assignment_Id");
		lblAssignmentid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAssignmentid.setBounds(31, 70, 90, 14);
		frame.getContentPane().add(lblAssignmentid);
		
		id = new JTextField();
		id.setBounds(141, 68, 166, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblRemoveAssignment = new JLabel("Remove Assignment");
		lblRemoveAssignment.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveAssignment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRemoveAssignment.setBounds(111, 11, 215, 27);
		frame.getContentPane().add(lblRemoveAssignment);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				JOptionPane.showMessageDialog(null,"ALL CLEAR !");
			}
		});
		btnReset.setBounds(10, 136, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnBackToHome = new JButton("");
		btnBackToHome.setIcon(new ImageIcon(RemoveAssign.class.getResource("/img/back.png")));
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Menu ob=new Menu(type,no);
				ob.frame.setVisible(true);
			}
		});
		btnBackToHome.setBounds(387, 118, 47, 41);
		frame.getContentPane().add(btnBackToHome);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int b=JOptionPane.showConfirmDialog(null,"Do you want to delete the record");
					
					if(b==0) {
					String sid=id.getText();
					if(sid.equals("")) {
						JOptionPane.showMessageDialog(null,"Please enter the course id number");
					}
					else {
					  Connection conn=null;
					  PreparedStatement pstmt=null;
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
						pstmt=conn.prepareStatement("delete from assignment where ANO=? and ID=?");
						pstmt.setString(1,sid);
						pstmt.setString(2,no);
						
						int i=pstmt.executeUpdate();
						pstmt=conn.prepareStatement("delete from submit where A_NO=? and ID=?");
						pstmt.setString(1,sid);
						pstmt.setString(2,no);
						i=pstmt.executeUpdate();
						if(i>0) {
							JOptionPane.showMessageDialog(null, "Record  is Removed successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "This Record is not Exist(please check the  Assignment_id)");
						}
						
					
							
						
					}
					catch(Exception e)
					{ JOptionPane.showMessageDialog(null,"!SERVER NOT FOUND : CHECK ALL THE CONNECTIONS");
					
					}
			} 
		}
	}
}
			
		);
		btnRemove.setBounds(328, 67, 106, 23);
		frame.getContentPane().add(btnRemove);
		frame.setLocationRelativeTo(null);
	}
}
