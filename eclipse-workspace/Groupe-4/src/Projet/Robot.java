package Projet;

public class Robot extends Objet {
	private DIRECTION direction;
	Robot (int x , int y) {
		super(x,y);
		direction=DIRECTION.Est;}
		
	
	


	void SetDirection( DIRECTION d) {direction=d;}		
	void avancer ( ) {
     if (direction ==DIRECTION.Est) y++;;  
	 if (direction==DIRECTION.Ouest )  y--;
	 if (direction==DIRECTION.Sud) x++;
	 if (direction==DIRECTION.Nord) x--;
	 System.out.println ("les coordonnées de robot sont" +"("+x+","+y+")"+" et la direction est:"+direction );
    
		 }

	
     void diag () {
    	  if (direction==DIRECTION.Sud) {
    	     y=y-1;
    		 x=x+1;
    	 direction= DIRECTION.Sud;
    	 System.out.println ("les coordonnées de robot sont" +"("+x+","+y+")"+" et la direction est:"+direction );}
     }
   
	
    public static void main (String[] args) 
    {
    	Robot [] [] tab = { new  Robot[3], new Robot [2]};
    	Robot r1= new Robot(1,2);
    	tab [1][2] =r1;
    	
    	
	
	}
    
}
	   
	
	    	
	    	
	    	
		
	



