package Projet;

public class Homme extends Objet {
	boolean motif;
	
	Homme (int x, int y , boolean motif){
		
	       super(x,y);
	       this.motif=motif;
	       //if(motif) System.out.println("j'ai une attestation de déplacement");
	}

}
