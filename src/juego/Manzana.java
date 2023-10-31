package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Manzana {
	double x;
	double y;
	double anguloManzana;
	
	public Manzana(double x, double y) {
		this.x = x;
		this.y = y;
		anguloManzana=0;
		
	}
	
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarCirculo(this.x, this.y, 10, Color.red);
	}

	
}