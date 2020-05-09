package Projet;

import java.util.Scanner;


public class Robot extends Objet {
	
	private DIRECTION direction;
	//Robot (){super();direction =DIRECTION.Est;}
	public Robot (int x , int y) {
		super(x,y);
		direction=DIRECTION.Est;}
public 	DIRECTION getDirection	() {return direction;}
public 	void SetDirection( DIRECTION d) {direction=d;}		
public void avancer ( ) {
	 
     if (direction ==DIRECTION.Est) { y++; }
	 if (direction==DIRECTION.Ouest ) { y--; }
	 if (direction==DIRECTION.Sud) {x++; }
	 if (direction==DIRECTION.Nord) {x--;}
	 System.out.println ("les coordonnées de robot sont" +"("+x+","+y+")"+" et la direction est:"+direction );
	 
	
    
		 }

	
   public void diag () {
	  
    	  if (direction==DIRECTION.Sud) {
    	     y=y+1;
    		 x=x-1;
    	 direction= DIRECTION.Sud;
    	 System.out.println ("les coordonnées de robot sont" +"("+x+","+y+")"+" et la direction est:"+direction );}
    	  
    	  
     }
   

} 	
    	
    	
	

