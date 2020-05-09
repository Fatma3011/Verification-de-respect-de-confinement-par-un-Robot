package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//classe pour dessiner la grille (la grille est une association de "Tile")

public class Tile {
	int x,y; //location top-left
	int TileID=0; // numero de l'image representant l'objet
	
	Rectangle bounding;//representant une case 
	
	
	
	boolean showBorders=false ;
	int ox,oy; //original x,original y
	Game game ;
	Color colors[]= {Color.BLACK, Color.GREEN ,Color.RED, Color.CYAN ,Color.DARK_GRAY};
	int index; //indice du couleur 
	int bande=1; //1 pour objet ,2 pour le robot
	//image
	 Ressources res  ;
	public Tile(int x,int y,Game game)
	{this.ox=x;
	this.oy=y;
	this.game=game;
	}
	public Tile(int x,int y,int TileID,int ind,int bande) 
	{this.ox=x;
	this.oy=y;
	this.TileID=TileID;
	this.index=ind ;
	this.bande=bande;
	bounding=new Rectangle(x,y,70,100);
	bounding.setBounds(x, y,70,100);
	
	
	}
	
	public void tick(Game game)
	{
		this.game=game;
		x=ox;
		y=oy;
		
	}
	//image
	public void tick1(Game game) {
		this.game=game;
	}
	
	public void render(Graphics g)
	  
	{  if(bande==1)
		g.drawImage( game.res.tiles[TileID],x,y,null);
	else if (bande==2)
		g.drawImage( game.res.mouvement[TileID],x,y,null);
	
     	g.setColor(Color.GREEN);
	  
	   g.drawRect(x, y, 70, 100);
	}
	public void render1(Graphics g)
	  
	
	{//liee a l insertion d'une photo en background
	
	if(bande==1)
		g.drawImage( game.res.tiles[TileID],x,y,null);
	else if (bande==2)
		g.drawImage( game.res.mouvement[TileID],x,y,null);
	
	
	
	g.setColor(colors[index]);
	g.drawRect(x, y, 70, 100);
			
		
	if(showBorders)
	{
		g.setColor(Color.WHITE);
		g.drawRect(x,y,70,100);
	}
	
	
	
	
	
		
	
	}

}