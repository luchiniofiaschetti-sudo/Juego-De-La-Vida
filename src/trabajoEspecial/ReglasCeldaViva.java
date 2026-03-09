package trabajoEspecial;

public class ReglasCeldaViva extends ReglaEvolucion{

	public ReglasCeldaViva() {
	}
	
	public Celda reglas(Tablero t, int f, int c) {
		int vecinos = t.cantidadVecinosVivos(f, c);
		
		if(vecinos < 2 || vecinos > 3) {
			return new CeldaMuerta();
		}
		if(vecinos == 2 || vecinos == 3) {
			return new CeldaViva();
		}
		return new CeldaMuerta();
	}
}
