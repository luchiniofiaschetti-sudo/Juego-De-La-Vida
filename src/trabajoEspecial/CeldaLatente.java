package trabajoEspecial;

public class CeldaLatente extends Celda{
	
	private char simbolo = 'l';
	
	public CeldaLatente() {
	}
	
	public Celda proximaGeneracion(int vecinos) {
		if(vecinos == 1) {
			return new CeldaViva();
		}else {
			return new CeldaLatente();
		}
	}
	
	public boolean getVive() {
		return false;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
}
