package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Layka {
	double x;
	double y;
	Image img1;
	
	
	public Layka(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("layka.png");
	}
	
	public void dibujarse(Entorno entorno)
	{
			entorno.dibujarImagen(img1, this.x, this.y, 0, 0.1);
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
    
    public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	

    

}
