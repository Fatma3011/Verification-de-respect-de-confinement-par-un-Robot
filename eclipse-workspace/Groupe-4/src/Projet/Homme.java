package Projet;

public class Homme extends Objet {
	  boolean motif;
		
		public Homme (int x, int y , boolean motif){
			   
		       super(x,y);
		       this.motif=motif;
		       type="homme";
		}
		public boolean getMotif() {
			return motif ;
		}
		

	}