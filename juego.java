public class Juego extends InterfaceJuego {
    private Entorno entorno;
    // Variables y metodos propios de cada grupo
// ...
    public Juego() {
// Inicializa el objeto entorno
        entorno = new Entorno(this, "Plantas Invasoras - Grupo 3 - v1", 800, 600);
// Inicializar lo que haga falta para el juego
// ...
// Inicia el juego
        entorno.iniciar();
    }
    public void tick() {
// Procesamiento de un instante de tiempo
// ...
    }
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
