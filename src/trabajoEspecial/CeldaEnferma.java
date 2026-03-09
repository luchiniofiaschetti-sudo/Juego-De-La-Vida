package trabajoEspecial;

public class CeldaEnferma extends Celda{

	private char simbolo = 'e';
	
	public CeldaEnferma() {
	}
	
	public Celda proximaGeneracion(int vecinos) {
		return new CeldaMuerta();
	}
		
	public char getSimbolo() {
		return simbolo;
	}

	public boolean getVive() {
		return true;
	}
}
