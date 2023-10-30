package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class CartelPerdiste {

	double x;
	double y;
	Image img1;
	
	
	public CartelPerdiste(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("perdiste-cartel.png");
	}
	
	public void dibujarse(Entorno entorno)
	{
			entorno.dibujarImagen(img1, this.x, this.y, 0, 1);
	}
}
