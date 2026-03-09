package trabajoEspecial;

public class ReglaCeldaEnferma extends ReglaEvolucion{

	public ReglaCeldaEnferma() {
	}
	
	public Celda reglas(Tablero t, int f, int c) {
			return new CeldaMuerta();
	}
}
