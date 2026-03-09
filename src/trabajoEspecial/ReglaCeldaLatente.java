package trabajoEspecial;

public class ReglaCeldaLatente extends ReglaEvolucion{
	
	public ReglaCeldaLatente() {
	}
	
	public Celda reglas(Tablero t, int f, int c) {
		int vecinos = t.cantidadVecinosVivos(f, c);
		
		if(vecinos == 1) {
			return new CeldaViva();
		}else {
			return new CeldaLatente();
		}
	}
}
