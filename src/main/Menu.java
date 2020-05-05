package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

public class Menu {

	 public JFrame frmHome;
	 String name="";
	 String id="";
	 JLabel l1;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu()
	{
		initialize();
	}
	public Menu(String s,String n) {  
		initialize();
		name=s;
		id=n;
		l1.setText(name+" ID:"+id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setBackground(new Color(230, 230, 250));
		frmHome.setResizable(false);
		frmHome.setTitle("HOME");
		frmHome.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/home-2-icon.png")));
		frmHome.getContentPane().setBackground(SystemColor.activeCaption);
		frmHome.setBounds(100, 100, 841, 598);
		frmHome.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		frmHome.setLocationRelativeTo(null);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 129, 424, -4);
		frmHome.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/img/add2.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudentRecord ob=new AddStudentRecord(name,id);
				frmHome.setVisible(false);
				
				ob.frmAddStudent.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(53, 89, 198, 177);
		frmHome.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteRecord ob=new DeleteRecord(name,id);
				frmHome.setVisible(false);
				ob.frmDeleteRecord.setVisible(true);
			}
		});
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(Menu.class.getResource("/img/DE2.png")));
		button.setBounds(323, 89, 198, 177);
		frmHome.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmHome.dispose();
				UpdateRecord ob=new UpdateRecord(name,id);
				ob.frmUpdateRecord.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(Menu.class.getResource("/img/UD2.png")));
		button_1.setBounds(588, 89, 203, 177);
		frmHome.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHome.setVisible(false);
				ViewRecord ob=new ViewRecord(name,id);
				ob.frmViewRecords.setVisible(true);
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setIcon(new ImageIcon(Menu.class.getResource("/img/Tablet-Chart-icon.png")));
		button_2.setBounds(53, 350, 198, 177);
		frmHome.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(name.equalsIgnoreCase("OFFICE"))
				{
				    JOptionPane.showMessageDialog(null,"This feature is not allowed(only ADMIN user can access it)");	
				}
				else {
				
				AddCourse ob=new AddCourse(name,id);
				
				frmHome.setVisible(false);
				
				ob.frmAddCourse.setVisible(true);
				}
			}
		});
		button_3.setBackground(Color.WHITE);
		button_3.setIcon(new ImageIcon(Menu.class.getResource("/img/Package-add-icon.png")));
		button_3.setBounds(323, 350, 191, 177);
		frmHome.getContentPane().add(button_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(63, 22, 155, 23);
		frmHome.getContentPane().add(panel);
		panel.setLayout(null);
		
		l1 = new JLabel("");
		l1.setBounds(10, 0, 145, 23);
		panel.add(l1);
		l1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    
	    JButton button_4 = new JButton("");
	    button_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		frmHome.setVisible(false);
	    		if(name.equalsIgnoreCase("Admin"))
	    		{
	    		UpdateId ob=new UpdateId(name,id);
	    		ob.frmUpdate.setVisible(true);
	    		}
	    		else
	    		{
	    			Updaten ob=new Updaten(name,id);
		    		ob.frmChangeUserName.setVisible(true);
	    		}
	    	}
	    });
	    button_4.setBackground(Color.WHITE);
	    button_4.setIcon(new ImageIcon(Menu.class.getResource("/img/RE2.png")));
	    button_4.setBounds(588, 350, 203, 177);
	    frmHome.getContentPane().add(button_4);
	    
	    JButton btnLogOut = new JButton("");
	    btnLogOut.setBounds(722, 11, 72, 62);
	    frmHome.getContentPane().add(btnLogOut);
	    btnLogOut.setIcon(new ImageIcon(Menu.class.getResource("/img/LO2.png")));
	    btnLogOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Login ob=new Login();
	    		frmHome.setVisible(false);
	    		
	    		JOptionPane.showMessageDialog(null,"LOG OUT.....");
                try {
                	Thread.sleep(1000);
                }
                catch(Exception e) {}
	    		ob.frame.setVisible(true);
	    	}
	    });
	    btnLogOut.setBackground(SystemColor.activeCaption);
	    
	    JButton btnRegistration = new JButton("");
	    btnRegistration.setIcon(new ImageIcon(Menu.class.getResource("/img/Actions-contact-new-icon.png")));
	    btnRegistration.setBounds(640, 11, 72, 62);
	    frmHome.getContentPane().add(btnRegistration);
	    btnRegistration.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		JOptionPane.showMessageDialog(null,name+id);
	    		frmHome.setVisible(false);
	    	    Registration r=new Registration(name,id);
	    		r.frmRegistration.setVisible(true);
	    	}
	    });
	    btnRegistration.setBackground(SystemColor.activeCaption);
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon(Menu.class.getResource("/img/user22.png")));
	    label.setBounds(37, 11, 46, 38);
	    frmHome.getContentPane().add(label);
	}
}
