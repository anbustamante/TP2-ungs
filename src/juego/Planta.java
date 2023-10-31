package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	double x;
	double y;
	Image img1;
	boolean existe = true;
	
	public Planta(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("plantaa.png");
		this.existe = true;
	}
	
	public void dibujarse(Entorno entorno)
	{
			entorno.dibujarImagen(img1, this.x, this.y, 0, 0.08);
	}
	
	public void moverDerecha() {
        this.x += 1;
        
    }
	 public void moverIzquierda() {
	        this.x -= 1;
	       
	    }

	    public void moverArriba() {
	        this.y -= 1;
	        
	    }
	    
	    public void moverAbajo() {
	    	this.y += 1;
	       
	    }
	    
	   
}
