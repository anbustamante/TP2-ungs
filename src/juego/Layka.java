package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Layka {
	double x;
	double y;
	Image img1;
	Image img2;
	int direccion = 0;
	
	/*
	 * Direccion:
	 * 0 arriba
	 * 1 derecho
	 * 2 abajo
	 * 3 izquierda
	 * 
	 * */
	public Layka(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("layka.png");
		img2 = Herramientas.cargarImagen("layka-left.png");
	}
	
	public void dibujarse(Entorno entorno)
	{
		if(this.direccion == 1) {
			entorno.dibujarImagen(img1, this.x, this.y, 0, 0.08);
		}else {
			entorno.dibujarImagen(img2, this.x, this.y, 0, 0.08);
		}
	}
	
	public void moverDerecha() {
        this.x += 3;
        this.direccion = 1;
        
    }

    public void moverIzquierda() {
        this.x -= 3;
        this.direccion = 3;
    }

    public void moverArriba() {
        this.y -= 3;
        this.direccion = 0;
    }
    
    public void moverAbajo() {
    	this.y += 3;
    	this.direccion = 2;
       
    }
    
    public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	

    

}
