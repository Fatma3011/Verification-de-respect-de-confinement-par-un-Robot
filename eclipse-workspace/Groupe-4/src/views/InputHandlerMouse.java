package views;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


import javax.swing.JOptionPane;

import Projet.Animal;
import Projet.Homme;
import Projet.Maison;
import Projet.Objet;
import Projet.Voiture;

//classe qui controle les evenements liés à la souris
public class InputHandlerMouse implements MouseListener,MouseMotionListener,MouseWheelListener {
	
	int i,j; //numero de ligne ,numéro de colonne
	Game game;
	boolean leftButton=false; 
	boolean rightButton=false;
	
	int ret=0,ret1=0; //utilisé pour recuperer la reponse du joueur si l'objet de type"homme" a une permission de dep
	public InputHandlerMouse(Game game)
	{
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		game.addMouseWheelListener(this);
		this.game=game;
	}

	
	public void mouseClicked(MouseEvent e) {
		
		
	}
//choix des objets 
	public void mousePressed(MouseEvent e) {
	
		j=(int) Math.floor((e.getX()-game.a)/70);
		i=(int) Math.floor((e.getY()-120-game.h)/100);
		if(e.getButton()== MouseEvent.BUTTON1) 
		
			{ 
			System.out.println("mouse Location ("+i+","+j+")");
		    game.MouseP=e.getPoint();
		    leftButton=true;
		    //si le joueur choisi l'un des objets de type "homme"
		    if(game.tileSelection==3 ||game.tileSelection==6||game.tileSelection==7||game.tileSelection==8 )
				
			 {
			 ret=JOptionPane.showConfirmDialog(null,"Does he/she have a certificate of deplacement ?","Select a choice",JOptionPane.YES_NO_OPTION);
			 leftButton=false;
			

			 
			 }
		    //si le joueur choisi l'objet de type "voiture" avec un chauffeur
		    else if(game.tileSelection==1)
		
		 {
		
 ret1=JOptionPane.showConfirmDialog(null,"Does the driver have a certificate of deplacement ?","Select a choice",JOptionPane.YES_NO_OPTION);
		 
		 leftButton=false;
		 

		 
		 }
		 
		    switch(game.tileSelection)
    		{ case 0: game.Z.ajouter( new Animal(i,j));
    		           break;
    		           
    		 case 1: {game.nbpersonnes++;
    			 Voiture V=new Voiture(false,i,j);
    			      game.Z.ajouter(V );
    			 if(ret1==JOptionPane.YES_OPTION)
    			 {game.motif=true;
    				 V.setcontenu(new Homme(i,j,game.motif));}
    			 else if (ret1==JOptionPane.NO_OPTION)
    			 { game.motif=false;
    			  game.nbnonpermis++;
    				 V.setcontenu(new Homme(i,j,game.motif));}
    		 
    			 System.out.println("a la case "+i+j +"avec un motif"+ game.motif);
	           break;}
	           
    		 case 2: game.Z.ajouter( new Maison(i,j));
	           break;
	           
    		 case 3: { game.nbpersonnes++;
    		 if(ret==JOptionPane.YES_OPTION)
    		 {game.motif=true;
    		 game.Z.ajouter( new Homme(i,j,game.motif));
    		 }
    		 else if (ret==JOptionPane.NO_OPTION)
    		 { game.motif=false;
    		    game.nbnonpermis++;
    		 game.Z.ajouter( new Homme(i,j,game.motif));
    		 }
    		 System.out.println("a la case "+i+j +"avec un motif"+game.motif);
    			 
	           break;}
    		 
    		 case 4: game.Z.ajouter( new Voiture(true,i,j));
	           break;
    		 case 5: game.Z.ajouter( new Animal(i,j));
	           break;
	           
    		 case 6:{game.nbpersonnes++;
    		 if(ret==JOptionPane.YES_OPTION)
    		 { game.motif=true;
    		 game.Z.ajouter( new Homme(i,j,game.motif));
    		 }
    		 else if (ret==JOptionPane.NO_OPTION)
    		 { game.motif=false;
    		 game.nbnonpermis++;
    		 game.Z.ajouter( new Homme(i,j,game.motif));
    		 }
    		 System.out.println("a la case "+i+j +"avec un motif"+game.motif);
    			 
	           break;}
    		 
    		 
    		 case 7: {game.nbpersonnes++;
    			 if(ret==JOptionPane.YES_OPTION)
	    		 { game.motif=true;
	    		 game.Z.ajouter( new Homme(i,j,game.motif));
	    		 }
	    		 else if (ret==JOptionPane.NO_OPTION)
	    		 { game.motif=false;
	    		 game.nbnonpermis++;
	    		 game.Z.ajouter( new Homme(i,j,game.motif));
	    		 }
	    		 System.out.println("a la case "+i+j +"avec un motif"+game.motif);
	    			 
	           break;}
    		 
    		 case 8: {game.nbpersonnes++;
    			 if(ret==JOptionPane.YES_OPTION)
	    		 { game.motif=true;
	    		game. Z.ajouter( new Homme(i,j,game.motif));
	    		 
	    		 }
	    		 else if (ret==JOptionPane.NO_OPTION)
	    		 { game.motif=false;
	    		 game.nbnonpermis++;
	    		 game.Z.ajouter( new Homme(i,j,game.motif));
	    		
	    		 }
	    		
    			 System.out.println("a la case "+i+j +"avec un motif"+game.motif);
    			 
	           break;}
    		 
    		}
	  
			}
		
		   
		
 		   
		
	//button1 boutton a gauche
	//button2 scrolling de la souris
	//boutton3 boutton a droite
		if(e.getButton()== MouseEvent.BUTTON3) 
		{System.out.println("mouse Location ("+i+","+j+")");
	    game.MouseP=e.getPoint();
	    rightButton=true;
	    Objet obj=game.Z.grille[i][j];
	    if(obj.getType()=="homme") 
		{game.nbpersonnes--;
		if(! ((Homme)obj).getMotif())
               game.nbnonpermis--;
		   
		}
	else if (obj.getType()=="voiture")
	{
		if (((Voiture)obj).getContenu()!=null)
			{game.nbpersonnes--;
			   if(! ((Voiture)obj).getContenu().getMotif())
				   game.nbnonpermis--;
			}
		  
	}
  game.Z.supprimer(obj);
		
		
		
		
		
		
		} 
		
			
				
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton()== MouseEvent.BUTTON1)
			leftButton=false;
		if(e.getButton()== MouseEvent.BUTTON3) 
		{
	    rightButton=false ;}
	}

	public void mouseEntered(MouseEvent e) {
		
		
	}

	public void mouseExited(MouseEvent e) {
		
		
	}

	public void mouseDragged(MouseEvent e) {
		j=(int) Math.floor((e.getX()-game.a)/70);
		i=(int) Math.floor((e.getY()-120-game.h)/100);
		game.MouseP=e.getPoint();
				if(e.getButton()== MouseEvent.BUTTON1)
				{ leftButton=true;
				System.out.println("mouse Location ("+i+","+j+")");}

				if(e.getButton()== MouseEvent.BUTTON3) 
				{ rightButton=true;
				System.out.println("mouse Location ("+i+","+j+")");}
				
				
		
	}

	public void mouseMoved(MouseEvent e) {
		 game.MouseP=e.getPoint();
		
	}
 //utilisation de la moulette de la souris pour le choix des objets
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getScrollType()==MouseWheelEvent.WHEEL_UNIT_SCROLL && e.getWheelRotation()>0) //if scrolling up
			{if(game.tileSelection>0)
			game.tileSelection--;
			else game.tileSelection=game.res.tiles.length -1;
				
			}
		else if (e.getScrollType()==MouseWheelEvent.WHEEL_UNIT_SCROLL && e.getWheelRotation()<0)//if scrolling down
		{if(game.tileSelection<game.res.tiles.length -1)
			game.tileSelection++;
			else game.tileSelection=0;
				
			}
		
	}

}