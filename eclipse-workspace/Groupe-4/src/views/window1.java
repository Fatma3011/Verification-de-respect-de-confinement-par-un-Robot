package views; //contenant les classes liées à l'interface graphique 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class window1 extends JFrame {
//classe de la premiere fenetre ou le joueur doit entrer les informations 
	private JPanel contentPane;
	private JMenu mnNewMenu_1;
	private JMenuBar menuBar;
	private JTextField txtSignUpNow;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JMenuItem mntmNewMenuItem;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblColor;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblNewLabel_3;
	String couleur ;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	 Game g;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window1 frame = new window1();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public window1() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(window1.class.getResource("/ressources/icon.jpg")));
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("My Game");
		initComponents(); // une methode contenant toutes les composantes contenues dans la classe
		createEvents();//une methode qui indique les evenements possibles 
		
	}

	private void createEvents() {
		
		
		lblColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblColor.setToolTipText("Choose a color for your gate!");
				
			}
		});
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window2 wind=new window2 ();
				wind.setModal(true); 
				wind.setVisible(true);
			}
		});
	
	//si le joueur clique sur start ,le jeu se déclenche et les données saisis sont transferer à la classe Game
	
	
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean C=true;
				boolean R=true;
				try {
				Integer i=Integer.parseInt(textField_1.getText());}
				catch(NumberFormatException ev){
					R=false;
				}
				try {
					Integer i=Integer.parseInt(textField_2.getText());}
					catch(NumberFormatException ev){
						C=false;
					}
					
				
				
				ArrayList<String> s=new ArrayList<>();
				if (textField.getText().length()==0)
					JOptionPane.showMessageDialog(null,"please check your robot's name " );
				else if(!R)
					JOptionPane.showMessageDialog(null," Please enter only numbers for the field Rows! " );
				else if ((textField_1.getText().length()==0) || (Integer.parseInt(textField_1.getText())<=0)||(Integer.parseInt(textField_1.getText())>5))
					
				JOptionPane.showMessageDialog(null,"please check the number of rows " );
				else if(!C)
					JOptionPane.showMessageDialog(null," Please enter only numbers for the field Columns ! " );
				else if ((textField_2.getText().length()==0) || (Integer.parseInt(textField_1.getText())<=0)||(Integer.parseInt(textField_1.getText())>11))
					JOptionPane.showMessageDialog(null,"please check the number of columns " );
				else {
					if (rdbtnNewRadioButton_1.isSelected())
						{couleur="2";
						
						}
					
					if (rdbtnNewRadioButton.isSelected())
						{couleur="1";
						
						}
					
				s.add(textField.getText());
				s.add(textField_1.getText());
				s.add(textField_2.getText());
				s.add(couleur);
				
				g=new Game(s);
				g.start();
				
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setVisible(false);
				
			
				

				}
			
			  
				
			}
		});
		
//si le joueur clique sur exit 
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ret=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?");
				if(ret==JOptionPane.YES_OPTION)
				System.exit(0);
			}
		});
	//des indications pour le joueur à propos les données à saisir 
		// TODO Auto-generated method stub
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setToolTipText("Choose a name for your robot !");
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setToolTipText("Choose the number (1-5) of your Gate's rows !");
				
			}
		});	
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2 .setToolTipText("Choose the number(1-11) of your Gate's columns !");
			}
		});
		
		
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("About");
		
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSignUpNow = new JTextField();
		txtSignUpNow.setBounds(40, 0, 346, 20);
		txtSignUpNow.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtSignUpNow.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		txtSignUpNow.setBackground(Color.WHITE);
		txtSignUpNow.setEditable(false);
		txtSignUpNow.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignUpNow.setText("Sign Up Now and Let's Start !");
		contentPane.add(txtSignUpNow);
		txtSignUpNow.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Pseudo :");
		lblNewLabel_1.setBounds(215, 66, 63, 20);
		
		
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(278, 65, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Start");
		btnNewButton.setBounds(215, 205, 89, 23);
		
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(335, 205, 89, 23);
		
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Rows :");
		lblNewLabel.setBounds(215, 96, 50, 20);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Colomns :");
		lblNewLabel_2.setBounds(215, 127, 63, 19);
		
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
	
		
		textField_1.setBounds(278, 96, 119, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(278, 125, 119, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblColor = new JLabel("Color :");
		
		lblColor.setBounds(215, 154, 63, 20);
		lblColor.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		contentPane.add(lblColor);
		
		rdbtnNewRadioButton = new JRadioButton("Blue");
		
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton.setBounds(276, 152, 63, 23);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Red");
		
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1.setBounds(335, 152, 79, 23);
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		contentPane.add(rdbtnNewRadioButton_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(window1.class.getResource("/ressources/final.jpg")));
		lblNewLabel_3.setBounds(0, 2, 434, 237);
		contentPane.add(lblNewLabel_3);
		
	}
}