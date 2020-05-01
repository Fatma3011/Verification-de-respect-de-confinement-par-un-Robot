package Projet;

public class ZoneGeo {
	int nL;     // nombre des lignes de la grille
	int nC;     // nombre des colonnes de la grille
	int xdp;    // l'abscisse du point de départ
	int ydp;    // l'ordonnée du point de départ 
	int xar;    // l'abscisse du point d'arrivée
	int yar;    // l'ordonnée du point de départ 
	Objet [][] grille;  // une matrice qui représente la zone géographique 
	ZoneGeo(int nL,int nC, int xdp,int ydp,int xar,int yar) throws ErrDimensions,ErrCoord,ErrEgaux{
		if (nL<0 || nC<0 ) throw new ErrDimensions("le nombre des lignes et le nombre des colnnes doivent être positifs !!");
		else if (xdp>=nC || ydp >=nL || xar>=nC || yar>=nL) throw new ErrCoord("les coordonnées des points de départ et d'arrivée doivent respecter les dimensions de la grille !!");
		else if (xdp==xar && ydp==yar) throw new ErrEgaux("le point de départ et le point d'arrivée doivent être différents !! ");
		else {
			this.nL=nL;
			this.nC=nC;
			this.xdp=xdp;
			this.ydp=ydp;
			this.xar=xar;
			this.yar=yar;
			grille = new Objet[nL][nC];
			
			
		}
	}
	void ajouter(Objet o)   //méthode pour ajouter un objet à la grille 
	{
		grille[o.x][o.y]=o;
		System.out.println("l'objet a été ajouté avec succès");
	}
	void supprimer(Objet o)   //méthode pour supprimer un objet de la grille
	{
		grille[o.x][o.y]=o;
		System.out.println("l'objet a été supprimé avec succès");
		
	}
	boolean EstVide(int x,int y)  // méthode qui retourne "true" si une case donnée de la grille est vide et "false" sinon  
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
	public static void main (String[] args) throws ErrDimensions,ErrCoord,ErrEgaux 
	{
		Objet o1=new Objet(1,2);
		Objet o2=new Objet(2,3);
		ZoneGeo z1=new ZoneGeo(5,5,4,0,4,2);
		ZoneGeo z2=new ZoneGeo(5,5,4,1,2,1);
		z1.ajouter(o1);
		z2.ajouter(o2);
		System.out.println(z1.EstVide(1, 2));
		z1.EstVide(2, 3);
	}
	
}

class ErrDimensions extends Exception
{  ErrDimensions(String s){super(s);}}
class ErrCoord extends Exception
{  ErrCoord(String s){super(s);}}
class ErrEgaux extends Exception
{ErrEgaux(String s){super(s);}}