package trabajoEspecial;

public class ReglaCeldaMuerta extends ReglaEvolucion{
	
	public ReglaCeldaMuerta() {
	}
	
	public Celda reglas(Tablero t, int f, int c) {
		int vecinos = t.cantidadVecinosVivos(f, c);
		
		if(vecinos == 3) {
			return new CeldaViva();
		}
		return new CeldaMuerta();
	}
}
