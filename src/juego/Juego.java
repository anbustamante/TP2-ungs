package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;
import entorno.*;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Layka layka;
	Fondo fondo;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Layka", 800, 600);
		fondo = new Fondo(400, 300);
		layka = new Layka(400,550);
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		fondo.dibujarse(entorno);
		layka.dibujarse(entorno);
		

	    if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
	        layka.moverDerecha();
	    }

	    if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
	        layka.moverIzquierda();
	    }

	    if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
	        layka.moverArriba();
	    }

	    if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
	        layka.moverAbajo();
	    }

	    layka.dibujarse(entorno);
	    
	}

	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
