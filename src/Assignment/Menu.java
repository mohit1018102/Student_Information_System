package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import main.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Menu {

	public JFrame frame;
     String type="",no="";
     JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		
		initialize();
	}

	   public Menu(String type,String no) {
		
		initialize();
		this.type=type;
		this.no=no;
		label.setText(type+" ID:"+no);
	  }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/home-2-icon.png")));
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 956, 583);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AddAssignment ob=new AddAssignment(type,no);
				ob.frame.setVisible(true);
			}
		});
		button.setBackground(Color.WHITE);
		button.setForeground(Color.WHITE);
		button.setIcon(new ImageIcon(Menu.class.getResource("/img/plus.png")));
		button.setBounds(89, 85, 204, 175);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Submit ob=new Submit(type,no);
				ob.frame.setVisible(true);
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setIcon(new ImageIcon(Menu.class.getResource("/img/submit-button-clipart-cursor-783380-9871712.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(377, 85, 204, 175);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				UpdateAssign ob=new UpdateAssign(type,no);
				ob.frame.setVisible(true);
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setIcon(new ImageIcon(Menu.class.getResource("/img/8338-200.png")));
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(656, 85, 204, 175);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				RemoveAssign ob=new RemoveAssign(type,no);
				ob.frame.setVisible(true);
			}
		});
		button_3.setBackground(Color.WHITE);
		button_3.setIcon(new ImageIcon(Menu.class.getResource("/img/110746-200.png")));
		button_3.setForeground(Color.WHITE);
		button_3.setBounds(89, 314, 204, 184);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ViewRecord ob=new ViewRecord(type,no);
				ob.frmViewRecords.setVisible(true);
			}
		});
		button_4.setIcon(new ImageIcon(Menu.class.getResource("/img/shopping-list_1293277.jpg")));
		button_4.setForeground(Color.WHITE);
		button_4.setBounds(377, 314, 204, 184);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Updaten ob=new Updaten(type,no);
	    		ob.frmChangeUserName.setVisible(true);
			}
		});
		button_5.setBackground(Color.WHITE);
		button_5.setIcon(new ImageIcon(Menu.class.getResource("/img/250130-200.png")));
		button_5.setForeground(Color.WHITE);
		button_5.setBounds(656, 314, 204, 184);
		frame.getContentPane().add(button_5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(52, 11, 151, 24);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(0, 0, 151, 24);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(Menu.class.getResource("/img/LO2.png")));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login ob=new Login();
	    		frame.setVisible(false);
	    		
	    		JOptionPane.showMessageDialog(null,"LOG OUT.....");
                try {
                	Thread.sleep(1000);
                }
                catch(Exception e) {}
	    		ob.frame.setVisible(true);
			}
		});
		btnLogOut.setBackground(SystemColor.inactiveCaption);
		btnLogOut.setBounds(870, 11, 60, 56);
		frame.getContentPane().add(btnLogOut);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/img/user22.png")));
		label_1.setBounds(26, 11, 46, 24);
		frame.getContentPane().add(label_1);
	}
}
