package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//classe represantant une fenetre contenant des indications a propos le jeu 
//elle se presente lorsque le joueur clique sur "About" dans le menu 
public class window2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			window2 dialog = new window2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public window2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(window2.class.getResource("/ressources/icon.jpg")));
		setTitle("My Gate");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
	}

}