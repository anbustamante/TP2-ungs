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
	CartelPerdiste cartel1;
	Planta[] plantas = new Planta[4];
	Auto[] autos = new Auto[2];
	boolean hayJuego = true;
	int puntaje = 0;
	Manzana manzana;



	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Layka", 800, 600);
		fondo = new Fondo(400, 300);
		layka = new Layka(400, 550);
		rayo1 = new Rayo(-300,-300,0);
		autos[0] = new Auto(400, 275);
		autos[1] = new Auto(500, 550);
		plantas[0] = new Planta(200, 300);
		plantas[1] = new Planta(600, 20);
		plantas[2] = new Planta(30, 20);
		plantas[3] = new Planta(750, 300);
		manzana = new Manzana(217,160);
	

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
		manzana.dibujarse(entorno);


		// controles layka
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) && layka.x < 780 ){
		    layka.moverDerecha();
		} else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && layka.x > 20) {
		    layka.moverIzquierda();
		} else if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && layka.y > 20) {
		    layka.moverArriba();
		} else if (entorno.estaPresionada(entorno.TECLA_ABAJO) && layka.y < 580) {
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
		if (colision(layka.x, layka.y, plantas[0].x, plantas[0].y, 40)
				|| colision(layka.x, layka.y, autos[0].x, autos[0].y, 40)) {

			hayJuego = false;

		}
		// disparar rayo
		if (entorno.sePresiono(entorno.TECLA_ESPACIO) && !rayo1.existe) {
			rayo1 = new Rayo(layka.x, layka.y, layka.direccion);

			rayo1.dibujarse(entorno);
			rayo1.existe = true;
		}
		// continuar movimiento del rayo
		if (rayo1.existe && rayo1.tiempoDeRayo > 0) {
			 
				rayo1.dibujarse(entorno);
				rayo1.tiempoDeRayo -= 1;

				// busco colision del rayo con plantas
				for (int i = 0; i < 4; i++) {
					if (colision(rayo1.x, rayo1.y, plantas[i].x, plantas[i].y, 80)) {
						puntaje += 5;
						rayo1.existe = false;
						plantas[i].existe = false;
						plantas[i].x = -80;
						plantas[i].y = -80;
						System.out.println("colision");

					}
				}
				// logica para cuando colisiona con autos
				if (colision(rayo1.x, rayo1.y, autos[0].x, autos[0].y, 80)) {
					rayo1.existe = false;
					rayo1.x = -200;
					rayo1.y = -200;
					System.out.println("colision");
				}
			
			
		}else {
			rayo1.existe = false;
		}

	}

	public boolean colision(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
