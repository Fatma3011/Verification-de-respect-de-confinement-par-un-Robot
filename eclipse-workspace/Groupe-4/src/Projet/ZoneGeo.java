package Projet;//contenant les classes non liées a l'interface graphique 

import java.util.Scanner;

public class ZoneGeo {
	int nL;     // nombre des lignes de la grille
	int nC;     // nombre des colonnes de la grille

	public Objet [][] grille;  // une matrice qui représente la zone géographique 
	int personne=0;
	int nonpermis=0;
	public ZoneGeo(int nL,int nC) throws ErrDimensions{
		if (nL<0 || nC<0 ) throw new ErrDimensions("le nombre des lignes et le nombre des colnnes doivent être positifs !!");
		
		else {
			this.nL=nL;
			this.nC=nC;
		
			grille = new Objet[nL][nC];
			
			
		}
	}
public 	void ajouter(Objet o)   //méthode pour ajouter un objet à la grille 
	{
		grille[o.x][o.y]=o;
		System.out.println("l'objet a été ajouté avec succès");
	}
public	void supprimer(Objet o)   //méthode pour supprimer un objet de la grille
	{
		grille[o.x][o.y]=null;
		System.out.println("l'objet a été supprimé avec succès");
		 if(o.type=="homme")
		    { personne--;
		      if(((Homme) o).getMotif()==false)
		    	  nonpermis--;
		    }
		    if(o.type=="voiture" && ((Voiture)o).getContenu()!=null)
		    	
				{ personne--;
				   if(! ((Voiture)o).getContenu().getMotif())
					   nonpermis--;
				}
		
		
	}
public	boolean EstVide(int x,int y)  // méthode qui retourne "true" si une case donnée de la grille est vide et "false" sinon  
	{
		if (grille[x][y]==null) {
			System.out.println("cette case est vide ");
			return true;
		}
		else {
			System.out.println("cette case n'est pas vide");
			return false;
		}
	}
 public void calcul() {
	 for(int i=0;i<nL;i++)
	 {
		 for(int j=0;j<nC;j++)
		 {  Objet obj=grille[i][j];
		 if(!EstVide(i,j))
		 {  if(obj.type=="homme")
		    { personne++;
		      if(((Homme) obj).getMotif()==false)
		    	  nonpermis++;
		    }
		    if(obj.type=="voiture" && ((Voiture)obj).getContenu()!=null)
		    	
				{ personne++;
				   if(! ((Voiture)obj).getContenu().getMotif())
					   nonpermis++;
				}
		     
			 
		 }
		 }
	 }
	 System.out.println("nb personne"+personne+"non permis"+nonpermis);
 }
 public int getpersonne() {
	 return personne;
 }
 public int getnonpermis() {
	 return nonpermis;
 }
	    public static void main (String[] args) throws ErrDimensions 
	{    
	    	
	    	
	    	
	    	
	    	Scanner sc = new Scanner(System.in);

	   System.out.println("saisir le nombre de ligne ");
	     int nL = sc.nextInt();


	    System.out.println("saisir le nombre de colonnes ");
	    int nC = sc.nextInt();
	   	ZoneGeo z=new ZoneGeo(nL,nC);
		z.ajouter(new Homme(1,0,false));
		z.calcul();
		System.out.println(z.getpersonne());
		System.out.println(z.getnonpermis());
		
	   	Robot r = new Robot (0,0);
		if (nL % 2 == 0) {
			int k=0;
			while (k<nL) {
				int i;
				for ( i=0; i<nC;i++) {
					 r.avancer(); 
					 if (i==nC-1) {r.SetDirection(DIRECTION.Sud);
						r.avancer();
						r.SetDirection(DIRECTION.Ouest);
						for (int j=0;j<nC;j++) {
							r.avancer();
							if (j==nC-1)
							{
								r.SetDirection(DIRECTION.Sud);
								r.avancer();
								
							}}
						 }
					 }
				
				
				
			
			
			
			
					 r.SetDirection(DIRECTION.Est);	k+=2;}
			if (k==nL) { for (int h=0;h<nC-1;h++) r.avancer();}
		                  }
		
		
		
		else  {
		
		
			int k=0;
			while (k<nL-2) {
				int i;
				for ( i=0; i<nC;i++) {
					 r.avancer(); 
					 if (i==nC-1) {r.SetDirection(DIRECTION.Sud);
						r.avancer();
						r.SetDirection(DIRECTION.Ouest);
						for (int j=0;j<nC;j++) {
							r.avancer();
							if (j==nC-1)
							{
								r.SetDirection(DIRECTION.Sud);
								r.avancer();
							
								
							}}
						 }
					 }
				
				
				
			
			
			
			
					 r.SetDirection(DIRECTION.Est);	k+=2;}r.SetDirection (DIRECTION.Sud);r.avancer();
					 for (int i=0; i<nC;i++) {
					 r.diag();
					 r.avancer();}}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		


	}
		
	}





