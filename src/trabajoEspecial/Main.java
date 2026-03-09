package trabajoEspecial;

public class Main {

	public static void main(String[] args) {
		
		Tablero tablero1 = new Tablero(5, 5); 	
		Jugar juego = new Jugar(tablero1);
		juego.inicializarJuego();
	}
}
