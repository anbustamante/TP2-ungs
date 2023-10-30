package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rayo {

	double x;
	double y;
	Image rayoIzq;
	Image rayoDer;
	Image rayoArr;
	Image rayoAbj;
	int direccion = 0;
	boolean existe = false;
	int tiempoDeRayo = 20;
	
	
	
	public Rayo(double x, double y, int direccion) 
	{
		this.x = x;
		this.y = y;
		rayoIzq = Herramientas.cargarImagen("rizq.png");
		rayoDer = Herramientas.cargarImagen("rder.png");
		rayoArr = Herramientas.cargarImagen("rarriba.png");
		rayoAbj = Herramientas.cargarImagen("rabajo.png");
		this.direccion = direccion;
	}
	
	public void dibujarse(Entorno entorno)
	{
		if(direccion == 0) {
			entorno.dibujarImagen(rayoArr, this.x, this.y-300, 0, 1);
		}else if(direccion == 1) {
			entorno.dibujarImagen(rayoDer, this.x+300, this.y, 0,1);
		}else if(direccion == 2) {
			entorno.dibujarImagen(rayoAbj, this.x, this.y+300, 0, 1);
		}else if(direccion == 3) {
			entorno.dibujarImagen(rayoIzq, this.x-300, this.y, 0, 1);
		}
	}
	
	
	public void moverDerecha() {
        this.x += 3;
    }
	public void moverIzquierda() {
        this.x -= 3;
    }
    public void moverArriba() {
        this.y -= 3;    
    }
    public void moverAbajo() {
    	this.y += 3;
    }
}
