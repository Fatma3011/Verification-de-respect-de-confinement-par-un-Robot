package views;

import java.awt.BorderLayout;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;

//classe representant les resultats du jeu 
public class Resultat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	Game game ;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_6;
	private JTextField textField_2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Resultat dialog = new Resultat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public Resultat()
	{
		initComponent() ;
	}
	public Resultat(Game game) {
		this.game=game;
		initComponent() ;
		textField.setText(  Integer.toString(game.nbpersonnes)); //nbre de personnes detectées 
		textField_1.setText(  Integer.toString(game.nbnonpermis));//nbre de celles sans permission 
		textField_2.setText("' "+game.player.name+" '"); //contenant le nom du robot 
		
	}

	private void initComponent() {
		
		setBounds(100, 100, 850, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(570, 166, 200, 226);
		lblNewLabel.setIcon(new ImageIcon(Resultat.class.getResource("/ressources/UR4B.gif")));
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(" Total number of persons :");
		lblNewLabel_2.setBounds(121, 193, 263, 20);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(439, 192, 86, 20);
		textField.setBorder(new LineBorder(new Color(128, 0, 0)));
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(439, 223, 86, 20);
		textField_1.setBorder(new LineBorder(new Color(128, 0, 0)));
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
	
		
		lblNewLabel_3 = new JLabel(" Number of persons without a certificate :");
		lblNewLabel_3.setBounds(121, 224, 308, 20);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel(" Confinement rules and preventive measures :");
		lblNewLabel_4.setBounds(121, 254, 329, 20);
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_4);
		
		JTextArea txtrVerbalScreening = new JTextArea();
		txtrVerbalScreening.setForeground(new Color(30, 144, 255));
		txtrVerbalScreening.setFont(new Font("Arial", Font.PLAIN, 14));
		txtrVerbalScreening.setWrapStyleWord(true);
		txtrVerbalScreening.setText("\r\n   * Enhanced cleaning/disinfecting and hygiene practices\r\n\r\n   * Medical isolation of confirmed and suspected cases\r\n      and quarantine of contacts\r\n\r\n   * Verbal screening and temperature check protocols for incoming\r\n      incarcerated/detained individuals, staff, and visitors");
		txtrVerbalScreening.setBounds(121, 299, 439, 157);
		txtrVerbalScreening.setBorder(new LineBorder(new Color(128, 0, 0)));
		txtrVerbalScreening.setEditable(false);
		contentPanel.add(txtrVerbalScreening);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(180, 22, 300, 87);
		lblNewLabel_5.setIcon(new ImageIcon(Resultat.class.getResource("/ressources/result.jpg")));
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				End1 E=new End1();
				E.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				setVisible(false);
				
				E.setVisible(true);
				
				
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Resultat.class.getResource("/ressources/fleche.gif")));
		lblNewLabel_1.setBounds(639, 355, 179, 200);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_6 = new JLabel("The robot");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(121, 166, 65, 14);
		contentPanel.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setEditable(false);
		textField_2.setBorder(null);
		textField_2.setForeground(new Color(128, 0, 0));
		textField_2.setBounds(190, 162, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("has detected :");
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(286, 163, 109, 20);
		contentPanel.add(lblNewLabel_7);
		
		textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setEditable(false);
		textArea.setBounds(86, 67, 549, 415);
		contentPanel.add(textArea);
		setTitle("My Gate");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Resultat.class.getResource("/ressources/icon.jpg")));
		
		
		
		
		
	}
}