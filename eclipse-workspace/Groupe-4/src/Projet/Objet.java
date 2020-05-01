package Projet;

public class Objet {
	int x;
	int y;
	Objet(int x,int y)   
		{	this.x=x;
			this.y=y;
		}
	int get_x () {return x;}
	int get_y() {return y;}
	void set_x (int x) {this.x=x;}
	void set_y (int y) {this.y=y;}
}
