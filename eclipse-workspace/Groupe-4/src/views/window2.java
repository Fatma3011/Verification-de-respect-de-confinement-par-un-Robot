package views;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.Toolkit;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//classe represantant une fenetre contenant des indications a propos le jeu 
//elle se presente lorsque le joueur clique sur "About" dans le menu 
public class window2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtrToPlayThe;

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
		setBounds(100, 100,820, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtrToPlayThe = new JTextArea();
		txtrToPlayThe.setForeground(new Color(25, 25, 112));
		txtrToPlayThe.setBackground(new Color(173, 216, 230));
		
		txtrToPlayThe.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtrToPlayThe.setBounds(0, 0, 2887, 371);
		txtrToPlayThe.setText("\r\n\r\n         To play the game you need to:\r\n\r\n        1. choose a pseudo-name for your robot.\r\n\r\n        2. specify the number of rows and columns (height and width of your geographic zone).   \r\n        (NOTICE: you can choose the color you want to play with).\r\n\r\n        3. press on the \u201Cstart\u201D button to exit the sign up window and launch the game.\r\n\r\n        4. Place as much as you want of objects displaying above.\r\n        To choose an object you can scroll your mouse\u2019s wheel and when you stop scrolling  your object is selected .\r\n        All you need to do then is to left click the case where you want to put it.\r\n        If you regret your choice and you want to delete it, you can right click on the objet already placed to remove it.\r\n\r\n        5. When you finish press the Enter key (on your keyboard) to make your robot moving. \r\n\r\n        NB : If you want to take a break you can press on the spacebar to pause the game and   then repress on it\r\n        again when you want  to return back .\r\n");
		txtrToPlayThe.setEditable(false);
		contentPanel.add(txtrToPlayThe);
	}
		
		
	

}