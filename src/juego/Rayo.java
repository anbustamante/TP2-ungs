package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rayo {

	double x;
	double y;
	Image rayoImg;
	int direccion = 0;
	boolean existe = false;
	int tiempoDeRayo = 20;
	
	
	
	public Rayo(double x, double y, int direccion) 
	{
		this.direccion = direccion;
		this.x = x;
		this.y = y;
		
		rayoImg = Herramientas.cargarImagen("rhoriz2.png");
		
	}
	
	public void dibujarse(Entorno entorno, double x2, double y2)
	{
		if(direccion == 0) {			
			entorno.dibujarImagen(rayoImg, x2, y2-120, Herramientas.radianes(90), 1);
		}else if(direccion ==1) {
			entorno.dibujarImagen(rayoImg, x2+120, y2, 0, 1);
		}else if(direccion ==2) {
			entorno.dibujarImagen(rayoImg, x2, y2+120, Herramientas.radianes(270), 1);
		}else if(direccion ==3) {
			entorno.dibujarImagen(rayoImg, x2-120, y2, Herramientas.radianes(180), 1);
		}
	}
	
	
}
