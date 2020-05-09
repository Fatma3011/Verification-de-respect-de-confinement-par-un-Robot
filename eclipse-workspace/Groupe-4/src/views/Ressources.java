package views;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
//classe représentant les images utilisés pour le choix des objets et le mouvement du robot 


public class Ressources {
	// "tileMap" et "mouvementMap" 2 images sous forme de bande qu'on divise apres en des "sous images" 
	BufferedImage tileMap; //concernane les objets
	
	BufferedImage[] tiles=new BufferedImage[10];
	BufferedImage mouvementMap;//concerne le robot 
	BufferedImage[] mouvement=new BufferedImage[12];
	//essai 
	Game game ;
	String path,path1;
	
	
	String tileNames[]= {"Dog" ,"Driver","House","Employee","Car","Cat","Moto","Mom","Player","Null"};
	public Ressources(ArrayList<String> s) {
		if(Integer.parseInt((String)s.get(3))==1) //si la couleur choisie par le joueur est bleue
		{ path= "/ressources/bleuo.png";
		  path1="/ressources/r2.png";
		}
		else  //si la couleur est rouge 
		{path= "/ressources/objet.png";
		 path1="/ressources/r1.png";
		}
		
		
		
		try {
		
			tileMap=ImageIO.read((Ressources.class.getResource(path)));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		try {
			mouvementMap=ImageIO.read((Ressources.class.getResource(path1)));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		for(int i=0;i<tiles.length;i++)
		{
			tiles[i]=tileMap.getSubimage(i*70,0,70,100) ;  //i*dx,padding,dx,dy
			
			
		}
		for(int i=0;i<mouvement.length;i++)
		{
			mouvement[i]=mouvementMap.getSubimage(i*70,0,70,100) ;  //i*dx,padding,dx,dy
			
			
		}
		
		
	}

}