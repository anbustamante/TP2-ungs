package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;

import java.awt.Color;


public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Layka layka;
	Fondo fondo;
	Rayo rayo1;
	Cartel cartel1;
	Planta[] plantas = new Planta[4];
	Auto[] autos = new Auto[2];
	boolean hayJuego = true;
	int puntaje = 0;
	Manzana[] manzanas = new Manzana[4];



	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Layka", 800, 600);
		fondo = new Fondo(400, 300);
		layka = new Layka(400, 550);
		rayo1 = new Rayo(400,300,0);
		autos[0] = new Auto(400, 275);
		autos[1] = new Auto(500, 550);
		plantas[0] = new Planta(200, 300);
		plantas[1] = new Planta(600, 20);
		plantas[2] = new Planta(30, 20);
		plantas[3] = new Planta(750, 300);
		manzanas[0] = new Manzana(80,60);
		manzanas[1] = new Manzana(435,60);
		manzanas[2] = new Manzana(80,342);
		manzanas[3] = new Manzana(435, 342);

		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// dibujo fondo
		fondo.dibujarse(entorno);

		// controles layka
		if(hayJuego) {
			
			if (entorno.estaPresionada(entorno.TECLA_DERECHA) && layka.x < 780 && 
					!colisionRectangulo(layka.x+21, layka.y, manzanas[0].x, manzanas[0].y, 278,201) &&
					!colisionRectangulo(layka.x+21, layka.y, manzanas[1].x, manzanas[1].y, 278,201) &&
					!colisionRectangulo(layka.x+21, layka.y, manzanas[2].x, manzanas[2].y, 278,201) &&
					!colisionRectangulo(layka.x+21, layka.y, manzanas[3].x, manzanas[3].y, 278,201)){
			    layka.moverDerecha();
			}
			
			if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && layka.x > 20
					&& !colisionRectangulo(layka.x-21, layka.y, manzanas[0].x, manzanas[0].y, 278,201)
					&& !colisionRectangulo(layka.x-21, layka.y, manzanas[1].x, manzanas[1].y, 278,201)
					&& !colisionRectangulo(layka.x-21, layka.y, manzanas[2].x, manzanas[2].y, 278,201)
					&& !colisionRectangulo(layka.x-21, layka.y, manzanas[3].x, manzanas[3].y, 278,201)) {
			    layka.moverIzquierda();
			}
			if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && layka.y > 20
					&& !colisionRectangulo(layka.x, layka.y-21,manzanas[0].x, manzanas[0].y, 278,201)
					&& !colisionRectangulo(layka.x, layka.y-21,manzanas[1].x, manzanas[1].y, 278,201)
					&& !colisionRectangulo(layka.x, layka.y-21,manzanas[2].x, manzanas[2].y, 278,201)
					&& !colisionRectangulo(layka.x, layka.y-21,manzanas[3].x, manzanas[3].y, 278,201)) {
			    layka.moverArriba();
			}
			if (entorno.estaPresionada(entorno.TECLA_ABAJO) && layka.y < 580
					&& !colisionRectangulo(layka.x, layka.y+21, manzanas[0].x, manzanas[0].y, 278,201)
					&& !colisionRectangulo(layka.x, layka.y+21,manzanas[1].x, manzanas[1].y, 278,201)
					&& !colisionRectangulo(layka.x, layka.y+21,manzanas[2].x, manzanas[2].y, 278,201)
					&& !colisionRectangulo(layka.x, layka.y+21,manzanas[3].x, manzanas[3].y, 278,201)) {
			    layka.moverAbajo();
			}

			
			
		layka.dibujarse(entorno);
		
		
		// plantas movimientos
		// plantas que van hacia la derecha y autos
		for (int i = 0; i < 2; i++) {
			if (plantas[i].existe) {
				plantas[i].dibujarse(entorno);
				if (plantas[i].x > 800) {
					plantas[i].x = -10;
				} else {
					plantas[i].moverDerecha();
				}
			}
			autos[i].dibujarse(entorno);
			if (autos[i].x > 800) {
				autos[i].x = -10;
			} else {
				autos[i].moverDerecha();
			}

		}
		// planta que va hacia abajo
		if (plantas[2].existe) {
			plantas[2].dibujarse(entorno);
			if (plantas[2].y > 600) {
				plantas[2].y = -10;
			} else {
				plantas[2].moverAbajo();
			}
		}
		// planta que va hacia arriba
		if (plantas[3].existe) {
			plantas[3].dibujarse(entorno);
			if (plantas[3].y < 0) {
				plantas[3].y = 650;
			} else {
				plantas[3].moverArriba();
			}
		}

		// perder
		//si colisiona contra una planta = pierde
		for(int i=0;i<plantas.length;i++) {
			if (colision(layka.x, layka.y, plantas[0].x, plantas[0].y, 40)){
				cartel1 = new Cartel(400,300,0);
				cartel1.dibujarse(entorno);
				hayJuego = false;
			}
		}
		//si colisiona contra un auto = pierde
		if(colision(layka.x, layka.y, autos[0].x, autos[0].y, 40) 
				|| colision(layka.x, layka.y, autos[1].x, autos[1].y, 40)) {
			cartel1 = new Cartel(400,300,0);
			cartel1.dibujarse(entorno);
			hayJuego = false;
		}
		
		// disparar rayo
		if (entorno.sePresiono(entorno.TECLA_ESPACIO) && !rayo1.existe) {
			rayo1 = new Rayo(layka.x, layka.y, layka.direccion);
			System.out.println(rayo1);
			rayo1.dibujarse(entorno,layka.x,layka.y);
			rayo1.existe = true;
		}
		if (rayo1.existe && rayo1.tiempoDeRayo > 0) {
			rayo1.tiempoDeRayo -= 1;
			rayo1.dibujarse(entorno,layka.x,layka.y);
			
			for(int i=0; i<4;i++) {
				if(rayo1.direccion==0) {
					if(colision(layka.x, layka.y-180, plantas[i].x, plantas[i].y, 40) 
						||	colision(layka.x, layka.y-100, plantas[i].x, plantas[i].y, 40)){
						plantas[i].existe = false;
						plantas[i].x = -300;
						plantas[i].y = -300;
					}
				}else if(rayo1.direccion==1) {
					if(colision(layka.x+180, layka.y, plantas[i].x, plantas[i].y, 40) 
							||	colision(layka.x+100, layka.y, plantas[i].x, plantas[i].y, 40)){
						plantas[i].existe = false;
						plantas[i].x = -300;
						plantas[i].y = -300;
						}
				}else if(rayo1.direccion==2) {
					if(colision(layka.x, layka.y+180, plantas[i].x, plantas[i].y, 40) 
							||	colision(layka.x, layka.y+100, plantas[i].x, plantas[i].y, 40)){
						plantas[i].existe = false;	
						plantas[i].x = -300;
						plantas[i].y = -300;
						}
				}else if(rayo1.direccion==3) {
					if(colision(layka.x-180, layka.y, plantas[i].x, plantas[i].y, 40) 
							||	colision(layka.x-100, layka.y, plantas[i].x, plantas[i].y, 40)){
						plantas[i].existe = false;
						plantas[i].x = -300;
						plantas[i].y = -300;
						}
				}
			}
			
			
		}else {
			rayo1.existe = false;
		}
		
	}else {
		cartel1.dibujarse(entorno);
	}

	}

	public boolean colision(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
	}
	public boolean colisionRectangulo(double puntoX, double puntoY, double rectanguloX, double rectanguloY, double ancho, double alto) {
	    return puntoX >= rectanguloX && puntoX <= rectanguloX + ancho && puntoY >= rectanguloY && puntoY <= rectanguloY + alto;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
