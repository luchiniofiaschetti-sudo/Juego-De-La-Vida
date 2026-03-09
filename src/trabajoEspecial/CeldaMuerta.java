package trabajoEspecial;

public class CeldaMuerta extends Celda{

	private char simbolo = '.';
	
	public CeldaMuerta() {
	}
	
	public boolean getVive() {
		return false;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
	public Celda proximaGeneracion(int vecinos) {
		if(vecinos == 3) {
			return new CeldaViva();
		}
		return this;
		}
}
