package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Projet.DIRECTION;

//player est la representation du robot sur la grille
public class Player {
	
	   ArrayList<String> s; //contenant les info saisis par le joueur au debut du jeu
	   
	   //ces 4 variables indiquent le sens de l'avancement du robot durant son parcours
		protected   boolean up=false; 
		protected  boolean down=false;
		protected boolean right=false;
		protected   boolean left=false;
		
		String name;  //nom du robot
		DIRECTION currentdirection ;
		 BufferedImage img;
		String path;
	int x,y; //position du robot
	Game game;
	public Player(Game game,ArrayList<String> s)
	{ 
	 this.game=game;
	 this.s=s;
	 this.name=s.get(0);
		
	}
	
	public void render(Graphics g)
	
	{ int tile=game.tileArray[game.r.get_y()][game.r.get_x()].TileID;
	  if(Integer.parseInt((String)s.get(3))==1)
		  path="/ressources/eyer.jpg";
	  else 
		  path="/ressources/eyeo.jpg";
	 
	  //si le robot detecte un homme ,on affiche une image de "l'oeil"
	  if (tile==1 || tile==3 || tile==6 || tile==7 || tile==8)
	  {       
		 try {
			img=ImageIO.read((Ressources.class.getResource(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 g.drawImage( img,x,y,null);
		 ((Graphics2D) g).setStroke(new BasicStroke(0.0f));
		 g.setColor(Color.BLACK);
		 
		 g.drawRect(x, y,70,100);
		 if(Integer.parseInt((String)s.get(3))==1)
		 g.setColor(Color.WHITE);
		 else
		 g.setColor(new Color(77,75,88));
		
		 g.drawString("Detection", x+8,y+25);
		 
	  }
	  
	  //pour dessiner le parcours du robot avec des fléches 
	  {
		if(Integer.parseInt((String)s.get(3))==1)
		g.setColor(new Color(94,90,103));
		
		else
	     g.setColor(new Color(255,249,178));	
		 
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));
		if(up)
		{if(x-70==game.a)
		 g.drawLine(x-35, y+50, x-35, (y-100)+50);
		else
			 g.drawLine(x+35, y+50, x+35, (y-100)+50);
		}
		 
	else if(down)
		{
		g.drawLine(x+40,y-5,x+35, y);
		g.drawLine(x+30,y-5,x+35, y);
		
		
		g.drawLine(x+35, y-50, x+35, y+50);
		
		}
	else if (left)
		{    if(x!=game.a)
		    { g.drawLine(x+35,y+50,x+40, y+50-5);
		    g.drawLine(x+35,y+50,x+40, y+50+5);}
		
	
	g.drawLine(game.a+35, y+50, game.a+70*(game.TileWidth-1)+35, y+50);
		
		if(x==game.a+70)
			g.drawLine(x, y+50, x-35, y+50);	
		else if(x!=game.a)
			
		{  
			g.drawLine(x, y+50, x-70, y+50);
			
			
		}
		
		}
	else if(right)
		{
		
		
		
		g.drawLine(game.a+35, y+50, game.a+70, y+50);	
		if(x==game.a+70*(game.TileWidth-1))
		g.drawLine(x, y+50, x+35, y+50);
	    else
		{g.drawLine(x, y+50, x+70, y+50);
		g.drawLine(x+30,y-5+50,x+35, y+50);
		g.drawLine(x+30,y+5+50,x+35, y+50);
		}
		
		
		}
	else 
	{g.drawLine(x-35, y+150, x+35, y+50);
	
	  g.drawLine(x, y+100, x-10, y+2+100);
	  g.drawLine(x-1,y+10+100,x, y+100);
	
	}
		
	  }
	 if(x==game.a+(game.TileHeight-1)*70 && y==120+(game.TileWidth-1)*100  )
	 {
		 g.drawImage(game.res.mouvement[3],x,y,null);
		 g.drawImage(game.res.mouvement[11],0,0,null);
		 
	 }
		
	}
	
	//apres chaque avancement du robot , player prend la nouvelle position
	public void update()
	{    x=(game.r.get_y())*70 + game.a; 
	     y= game.r.get_x()*100 +120+game.h;
	     currentdirection=game.r.getDirection();
	    
	 
	}
}