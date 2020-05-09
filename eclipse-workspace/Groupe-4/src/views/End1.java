package views;

import java.awt.BorderLayout;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Timer;
//une classe pour representer la fin du jeu avec une petite animation 
public class End1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			End1 dialog = new End1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public End1() {
		setTitle("My Gate");
		setIconImage(Toolkit.getDefaultToolkit().getImage(End1.class.getResource("/ressources/icon.jpg")));
		  initComponent();
		  
		  
		  TimerT1 task=new TimerT1("task",this);
		     Timer tim=new Timer();
		     tim.schedule(task, 5000);
		
	}

	private void initComponent() {
		
		setBounds(100, 100, 850, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-14, 102, 474, 300);
		lblNewLabel.setIcon(new ImageIcon(End1.class.getResource("/ressources/taille.gif")));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(483, 127, 189, 290);
		lblNewLabel_1.setIcon(new ImageIcon(End1.class.getResource("/ressources/taille2.gif")));
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Be Safe!");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(651, 60, 62, 30);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(End1.class.getResource("/ressources/heart.png")));
		lblNewLabel_3.setBounds(711, 60, 25,30);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(End1.class.getResource("/ressources/mask.png")));
		lblNewLabel_4.setBounds(735, 60,30,30);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(End1.class.getResource("/ressources/bulle1.png")));
		lblNewLabel_5.setBounds(628, 26, 160,119);
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(End1.class.getResource("/ressources/planb.png")));
		lblNewLabel_6.setBounds(0, 0,834, 461);
		contentPanel.add(lblNewLabel_6);
	}

}