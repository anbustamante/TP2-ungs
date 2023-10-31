package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Cartel {

	double x;
	double y;
	Image img1;
	Image img2;
	int tipo = 0;
	
	
	public Cartel(int x, int y,int tipo) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("perdiste-cartel.png");
		img2 = Herramientas.cargarImagen("ganaste-cartel.png");
		this.tipo = tipo;
	}
	
	public void dibujarse(Entorno entorno)
	{
		if (this.tipo == 0) {
			entorno.dibujarImagen(img1, this.x, this.y, 0, 1);
		}else if(this.tipo == 1) {
			entorno.dibujarImagen(img2, this.x, this.y, 0, 1);
		}
	}
}
