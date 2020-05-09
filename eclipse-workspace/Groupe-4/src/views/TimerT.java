package views;

import java.awt.Graphics;
import java.util.TimerTask;

import javax.swing.JDialog;

//task realiser par le timer (afficher la fenetre contenant les resultats)
public class TimerT extends TimerTask {
    
     String name;
     Game game;
     
     public TimerT(String name,Game game)
     {
    	 this.name=name;
    	 this.game=game;
     }
	@Override
	public void run() {
		
		 
			
			Resultat R=new Resultat(game);
			R.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			Game.stop();
			R.setVisible(true);
			
			
			
			
	
		
		
	}

}