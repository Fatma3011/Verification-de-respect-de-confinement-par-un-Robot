package views;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//classe qui controle les evenements liés au clavier 

public class InputHandler implements KeyListener {
	Game game;
	boolean move=false; //le robot ne doit commencer son parcours que si move=true 
	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyPressed(KeyEvent e) {
		int keycode=e.getKeyCode(); //code du boutton presse 
		//quitter le jeu en cliquant sur echap 
		if(keycode== KeyEvent.VK_ESCAPE)
		{ 
			Game.stop();
		}
		
		
	  //pause et unpause the game en cliquant sur la touche espace 
		if(keycode==KeyEvent.VK_SPACE)
		{
			Game.pause=!Game.pause;
			return;
		}
		//en cliquant sur entrée le joueur ne peut plus ajouter des objets et le robot commence son parcours
		if(keycode==KeyEvent.VK_ENTER)	
		{
			move=true; 
			game.selection=false ;
		

			
			
		}
			
		
		
	}

	public void keyReleased(KeyEvent e) {
		
		
	}
	

}