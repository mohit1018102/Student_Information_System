package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Load {

	JFrame frame;
	JProgressBar load ;
	 JLabel per;
	 private JLabel label;
	 private JLabel label_1;
	 private JLabel label_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {Load window=null;
				try {
					window = new Load();
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
	public Load() {
		initialize();
		
     
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Load.class.getResource("/img/database-icon.png")));
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
	    per = new JLabel("99%");
	    per.setFont(new Font("Tahoma", Font.BOLD, 14));
		per.setForeground(Color.WHITE);
		per.setHorizontalAlignment(SwingConstants.CENTER);
		per.setBounds(280, 231, 67, 14);
		frame.getContentPane().add(per);
		
		load = new JProgressBar();
		load.setForeground(new Color(34, 139, 34));
		load.setBounds(57, 258, 516, 24);
		frame.getContentPane().add(load);
		
		JLabel lblStudentInformationSystem = new JLabel("STUDENT INFORMATION SYSTEM");
		lblStudentInformationSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStudentInformationSystem.setForeground(Color.WHITE);
		lblStudentInformationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformationSystem.setBounds(81, 32, 451, 65);
		frame.getContentPane().add(lblStudentInformationSystem);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Load.class.getResource("/img/Excel-Letter-icon.png")));
		label.setBounds(554, -100, 256, 247);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Load.class.getResource("/img/Excel-Letter-icon.png")));
		label_1.setBounds(-53, 265, 240, 155);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(Load.class.getResource("/img/database-icon.png")));
		label_2.setBounds(39, 35, 534, 247);
		frame.getContentPane().add(label_2);
		frame.setBounds(100, 100, 623, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
	
	}
}
