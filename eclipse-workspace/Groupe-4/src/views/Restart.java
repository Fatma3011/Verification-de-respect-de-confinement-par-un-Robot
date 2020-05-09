package views;

import java.awt.BorderLayout;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//classe representant la fenetre ou on demande au joueur si il veut commencer une nouvelle partie 
public class Restart extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Restart dialog = new Restart();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Restart() {
		initComponent();
		
	}

	private void initComponent() {
		setTitle("My Gate");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Restart.class.getResource("/ressources/icon.jpg")));
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Do you want to start a new game ?");
		lblNewLabel.setForeground(new Color(173, 216, 230));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 45));
		lblNewLabel.setBounds(45, 91, 713, 97);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				window1 wind=new window1 ();
				setVisible(false); 
				wind.setVisible(true);
			}
		});
		lblNewLabel_1.setBounds(163, 227, 152, 158);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
			}
		});
		lblNewLabel_2.setBounds(487, 227, 152, 158);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Restart.class.getResource("/ressources/YES.gif")));
		lblNewLabel_3.setBounds(0, -30, 834, 665);
		contentPanel.add(lblNewLabel_3);
		
	}
}
