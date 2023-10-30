package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {

	double x;
	double y;
	Image img1;
	boolean seMueveHaciaLaDerecha = true;
	
	public Auto(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("auto.png");
	}
	
	public void dibujarse(Entorno entorno)
	{
			entorno.dibujarImagen(img1, this.x, this.y, 0, 0.2);
	}
	
	public void moverDerecha() {
        this.x += 2;
        
    }
	 public void moverIzquierda() {
	        this.x -= 2;
	       
	    }

	    public void moverArriba() {
	        this.y -= 2;
	        
	    }
	    
	    public void moverAbajo() {
	    	this.y += 2;
	       
	    }
}
