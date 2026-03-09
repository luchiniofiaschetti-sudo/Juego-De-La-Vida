package trabajoEspecial;

public class CeldaViva extends Celda{

	private char simbolo = 'x';
	
	public CeldaViva() {
	}
	
	public boolean getVive() {
		return true;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
	public Celda proximaGeneracion(int vecinosVivos) {
		if(vecinosVivos < 2 || vecinosVivos > 3) {
			return new CeldaMuerta();
		}
		if(vecinosVivos == 2 || vecinosVivos == 3) {
			return new CeldaViva();
		}
		return new CeldaMuerta();
	}
}
