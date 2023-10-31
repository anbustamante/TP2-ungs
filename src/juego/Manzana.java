package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Manzana {
	double x;
	double y;
	Image imgManzana;
	Image imgCasa;
	Image imgCafe2;
	Image imgCasa2;
	double anguloManzana;
	
	public Manzana(double x, double y) {
		this.x = x;
		this.y = y;
		imgManzana = Herramientas.cargarImagen("mzncafe.png");
        imgCasa = Herramientas.cargarImagen("casa.png");
        imgCafe2 = Herramientas.cargarImagen("cafe2.png");
        imgCasa2 = Herramientas.cargarImagen("casa2.png");
		anguloManzana=0;
		
	}
	
	public void dibujarse(Entorno entorno)
	{
	    entorno.dibujarImagen(imgManzana, this.x, this.y, this.anguloManzana, 1);
	    entorno.dibujarImagen(imgCasa, this.x + 356, this.y, this.anguloManzana, 1);
	    entorno.dibujarImagen(imgCafe2, this.x + 356, this.y + 280, this.anguloManzana, 1);
	    entorno.dibujarImagen(imgCasa2, this.x , this.y + 280, this.anguloManzana, 1);
	}

	public void dibujarRectangulo(double x, double y, double ancho, double alto, double angulo, Color color)
	{
	

	}
	
}