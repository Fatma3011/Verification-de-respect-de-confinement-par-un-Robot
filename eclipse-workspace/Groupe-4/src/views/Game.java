package views;

import Projet.*;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;


import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import java.util.Timer;

import javax.swing.ImageIcon;


import javax.swing.JFrame;



public class Game extends Canvas implements Runnable {
// la classe ou le jeu essentiellement se déroule 
	
	int color; //1 si le joueur choisit de jouer avec le bleu , 2 si rouge
	boolean selection=true; //le joueur a la permission de mettre les objets ou non
	int nbpersonnes=0;
	int nbnonpermis=0;
	int permission=0; //pour l'affichage de la fenetre contenant les resultats
	
	int a ;//utilisée pour que la grille soit centrée
	int h ;//utilisée pour que la grille soit centrée
	static JFrame frame ;
	
	private static final long serialVersionUID=1L;
	
	InputHandler IH=new InputHandler(); //la classe liée aux actions vis le clavier 
	
	
	int tileSelection=0;// liée a l'image de l'objet choisi
	
	
	ZoneGeo Z; // la grille
	 Robot r ; // le robot
	 boolean motif=false; //motif indique si l'objet "Homme" a une permission de deplacement
	 
	
    
     
	 Player player ; //la representation du robot dans l'interface graphique
	
	//classe liée aux actions vis la souris
	InputHandlerMouse input;
	
	
	
	Point  MouseP=new Point(-1,-1);
	//image 
	 Ressources res;
	
	//core stuff
	BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	
	public static Boolean running=false ; //whether the game is running
	public static boolean pause=false;
	
	private static ImageIcon pauseImage=new ImageIcon(Game.class.getResource("/ressources/PAUSE1.gif"));
	private static ImageIcon plan=new ImageIcon(Game.class.getResource("/ressources/villeo.jpg"));
	
	
	public static final  String Title="My Gate";
	public static final   int width=790; //800
	public static final   int  height=650;//600
	public static final  Dimension gameDim=new Dimension(width,height);
	
	public int TileWidth= 15; //nbre de colonnes 
	public int TileHeight=10; //nbre de lignes  
	Tile tileArray [][]=new Tile[TileWidth][TileHeight];
	
	//conrols
	
	public void run() {
		while(running)
		{
			tick();
			tick1();
			
			render();
		  
			
		
		}
		
	}
	
	public synchronized void  start() {
		
		running=true;
		Thread thread=new Thread(this);
		thread.start();
		
	}
public synchronized   static void stop() {
		running=false ;
		
		//System.exit(0);
		frame.setVisible(false);
	}
 
	public Game(ArrayList<String> s) {
		//new part mouse 
		input=new InputHandlerMouse(this);
		
		
		//image 
		res=new Ressources(s);
		
		
		setMinimumSize(gameDim);   //size of frame or canvas 
		setMaximumSize(gameDim);
		setPreferredSize(gameDim);
		frame=new JFrame(Title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false); //resizebale by the user 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/ressources/icon.jpg")));
		this.addKeyListener(IH);
		
		TileWidth= Integer.parseInt((String)s.get(2));
		TileHeight= Integer.parseInt((String)s.get(1));
		color=Integer.parseInt((String)s.get(3));
	
		try {
			Z=new ZoneGeo(TileHeight,TileWidth); 
		} catch (ErrDimensions e) {

			e.printStackTrace();
		}
     a= (width-TileWidth*70)/2;
     h=(height-120-TileHeight*100)/2;
		init();
		
	    
	   
		player=new Player(this,s);
		
	
		
		requestFocus();
		
		
		
	}
	
	
	 

	public void init() {
		
		
		//initialiser la grille
		
		for(int y=0;y<TileHeight;y++)
		
		{ for(int x=0;x<TileWidth;x++)
			
			
				
			tileArray[x][y]=new Tile(x*70+a ,y*100+120+h,9,0,1); 
			
		}
		
	
	}
	




				
				
	
	

	public void tick() {  
		for(int x=0;x<TileWidth;x++)
		{
			for(int y=0;y<TileHeight;y++)
			{
				 tileArray[x][y].tick(this);
			}
		}
		
		
	}
	
// partie mouse 
	
	
public void tick1() {
	tileStuff();
}
private void tileStuff()
{    if(selection&&!pause)
   
	{	for(int x=0;x<TileWidth;x++)
     {
	    for(int y=0;y<TileHeight;y++)
	    {Tile tile=tileArray[x][y];
	     
	    tile.tick1(this);
	      
	    if(tile.bounding.contains(MouseP)) {
	    	tile.showBorders=true;
	    }else 
	    {
	    	tile.showBorders=false;
	    }
	    if(x==0&&y==0)
	    {
	    	 tile.bande=2;
	    	tile.index=2;
	    	 tile.TileID=10;
	    	
	    }
	   if(x==TileWidth-1&& y==TileHeight-1)
	    	
	    { 
	    	tile.index=2;
	    	
	    }
	    	
	    if(tile.bounding.contains(MouseP)&& input.leftButton)    //souris a l interieur d'un rectangle
	    {                                                         //insertion d'un objet
	    	
	    	   tile.TileID=tileSelection;
	    		
	    		
	    		
	    		
	    	}
	    	if(tile.bounding.contains(MouseP)&& input.rightButton)    //souris a l interieur d'un rectangle
	    	{   tile.bande=1;
	    		tile.TileID=9;                                        //suppression d'un objet
	    		
	    	  
	    	}
	    	
	    }
	    
		
     }}

}
public void Move(Graphics g)   //fonction qui contient le parcours du robot et son simulation dans l'interface graphique
{
	try {
		Z=new ZoneGeo(TileHeight,TileWidth); 
	} catch (ErrDimensions e) {

		e.printStackTrace();
	}
	System.out.println(TileHeight+","+TileWidth);
	
	r=new Robot(0,0);
	
	
		
		
	
	int nbL ,nbC;
	nbL=TileHeight-1;
	nbC=TileWidth-1;
	
	
	
{   if (nbL % 2 == 0) {
			
			
    	  int k=0;
			while (k<nbL) {
				int i;
				for ( i=0; i<nbC;i++) {
					 r.avancer(); 
					 player.right=true;
					 player.up=false;
					  player.down=false;
					  player.left=false;
				    player.update();
			        player.render(g);
					 
					 if (i==nbC-1) {r.SetDirection(DIRECTION.Sud);
						r.avancer();
						 player.right=false;
						 player.up=false;
						  player.down=true;
						  player.left=false;
					    player.update();
				        player.render(g);
						r.SetDirection(DIRECTION.Ouest);
						for (int j=0;j<nbC;j++) {
							r.avancer();
							 player.right=false;
							 player.up=false;
							  player.down=false;
							  player.left=true;
						    player.update();
					        player.render(g);
							if (j==nbC-1)
							{
								r.SetDirection(DIRECTION.Sud);
								r.avancer();
								 player.right=false;
								 player.up=false;
								  player.down=true;
								  player.left=false;
							    player.update();
						        player.render(g);
								
							}}
						 }
					 }
				
				
				
			
			
			
			
					 r.SetDirection(DIRECTION.Est);	k+=2;
					 
				    player.update();
			        player.render(g);
					 
			}
			if (k==nbL) { for (int h=0;h<nbC;h++) {r.avancer();
			
			 player.right=true;
			 player.up=false;
			  player.down=false;
			  player.left=false;
		    player.update();
	        player.render(g);
			
			}}
			
			
      
      
      
      
      }
		
		
		
		else  {
		
		
			int k=0;
			while (k<nbL-2) {
				int i;
				for ( i=0; i<nbC;i++) {
					r.avancer();
					
					player.right=true;
					 player.up=false;
					   player.down=false;
					   player.left=false;
					 player.update();
		             player.render(g);
					 if (i==nbC-1) {r.SetDirection(DIRECTION.Sud);
						r.avancer();
						player.down=true;
						 player.up=false;
						  player.right=false;
						  player.left=false;
						player.update();
		                player.render(g);
						r.SetDirection(DIRECTION.Ouest);
						for (int j=0;j<nbC;j++) {
							r.avancer();
							player.left=true;
							 player.up=false;
							  player.down=false;
							  player.right=false;
							 player.update();
		                     player.render(g);
							if (j==nbC-1)
							{
								r.SetDirection(DIRECTION.Sud);
								r.avancer();
								player.down=true;
								 player.up=false;
								    player.right=false;
								    player.left=false;
								player.update();
		                        player.render(g);
							
								
							}}
						 }
					 }
				
					 r.SetDirection(DIRECTION.Est);	k+=2;}
			r.SetDirection (DIRECTION.Sud);r.avancer();
						player.up=false;	
						 player.right=false;
						    player.down=true;
						    player.left=false;
					  player.update();  
		              player.render(g);
					 for (int i=0; i<nbC;i++) {
					 r.diag();
					 player.down=false;
					 player.up=false;
					 player.right=false;
					 player.left=false;
					 player.update();
		             player.render(g);
					 r.avancer();
					 
					 player.down=true;
					 player.up=false;
					player.right=false;
					player.left=false;
					 player.update();
	               	player.render(g);
					 
				 }}}


if(r.get_x()==TileHeight-1 && r.get_y()==TileWidth-1)
{ 
	 g.drawImage(res.mouvement[3],player.x,player.y,null);
	 g.setColor(Color.BLACK);
	 g.drawRect(player.x,player.y,70,100);
	 g.drawImage(res.mouvement[11],a,h+120,null);
	
	 g.drawRect(a, h+120,70,100);
	 
	 
    
 if(permission==0&& !pause)
	{TimerT task=new TimerT("task",this);
     Timer tim=new Timer();
     tim.schedule(task, 7000);
      
     
     permission++;}
	
}
 
}





	


	public void render() {
		
		BufferStrategy bs=getBufferStrategy ();
		if(bs==null)
		{
			createBufferStrategy(3);
			return; //return to the top 
		}
		final Graphics g=bs.getDrawGraphics(); //create a context for you 
		g.drawImage(image,0,0, getWidth(),getHeight(),null);
		if(!pause)
		g.drawImage(plan.getImage(),0,0,null);
		
		  
		if(pause)
			{g.drawImage(pauseImage.getImage(),70,30,null);
			 g.setColor(new Color(0, 210, 240));
			 Font stringFont = new Font( "Bahnschrift", Font.PLAIN,30);
			 g.setFont(stringFont);
		     g.drawString("Game Paused",294,450);
			}
		else
		
{	
			
			for(int x=0;x<TileWidth;x++)
		{
			for(int y=0;y<TileHeight;y++)
			{if (tileArray[x][y].x>=0-70 &&tileArray[x][y].x<=getWidth()+70 &&tileArray[x][y].y>=0-100
			&&tileArray[x][y].y<=getHeight()+100)
				
				 tileArray[x][y].render1(g); 
			     
			}
		}
			
		 if(IH.move&&!pause)
		  Move(g);
		 
		 
		
		
         
		
		g.drawImage(res.tileMap,50,0,null); //afficher la bande des photos 
		if(color==1)
		g.setColor(Color.RED);
		else 
		g.setColor(new Color(77,75,88));
		g.drawRect(tileSelection*70+50,0,70,100);//rectangle qui indique la photo choisi
		g.setColor(Color.WHITE);
		g.drawString("Tile:"+ res.tileNames[tileSelection],50,115);}
		
		g.dispose();
		bs.show();
	
	
		
	}

	
	

		
}
