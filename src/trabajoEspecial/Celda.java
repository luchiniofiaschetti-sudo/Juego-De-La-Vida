package trabajoEspecial;

public abstract class Celda {
	// clase abstracta con metodos en comun de todas las celdas
	public abstract boolean getVive();
	public abstract char getSimbolo();
	public abstract Celda proximaGeneracion(int vecinosVivos);
}
