package views;

import java.awt.Graphics;
import java.util.TimerTask;

import javax.swing.JDialog;
//afficher la fenetre de "Restart" et cacher celle de "End"
public class TimerT1 extends TimerTask{
	String name;
	End1 end ;
	
      public TimerT1(String name,End1 end) {
    	  
    	  this.name=name;
    	  this.end=end;
    	 
      }
	@Override
	public void run() {
		
		
		Restart R=new Restart();
		R.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		end.setVisible(false);
	
		R.setVisible(true);
		
	}

}
