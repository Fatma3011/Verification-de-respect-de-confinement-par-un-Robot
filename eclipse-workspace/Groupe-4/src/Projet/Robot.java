package Projet;

public class Robot extends Objet {
	private DIRECTION direction;
	Robot (int x , int y) {
		super(x,y);
		direction=DIRECTION.Est;}
		
	
	void avancer ( ) {
     if (direction ==DIRECTION.Est) x++;  
	 if (direction==DIRECTION.Ouest )  x--;
	 if (direction==DIRECTION.Sud) y++;
	 if (direction==DIRECTION.Nord) y--;
		 }

	void droite() {
		  if (direction ==DIRECTION.Est) { y++;   direction=DIRECTION.Sud;}
		  if (direction==DIRECTION.Ouest ) { y--; direction=DIRECTION.Nord;}
		  if (direction==DIRECTION.Sud)     {x--; direction=DIRECTION.Ouest;}
		  if (direction==DIRECTION.Nord) { x++;direction=DIRECTION.Est;}
	}
	 
    void gauche () {
    	 if (direction ==DIRECTION.Est) { y--;   direction=DIRECTION.Nord;}
		  if (direction==DIRECTION.Ouest ) { y++; direction=DIRECTION.Sud;}
		  if (direction==DIRECTION.Sud)     {x++; direction=DIRECTION.Est ;}
		  if (direction==DIRECTION.Nord) { x--;direction=DIRECTION.Ouest;}
    	 
    }
   
	
    public static void main (String[] args) 
    {
    	Robot [] [] tab = { new  Robot[3], new Robot [2]};
    	Robot r1= new Robot(1,2);
    	tab [1][2] =r1;
    	
    	
	
	}
    
}
	   
	
	    	
	    	
	    	
		
	



