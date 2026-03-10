package trabajoEspecial;

public class CrearCelda {
//clase para crear celdas, que utiliza tablero para cargarse por archivo o aleatoriamente
	final private static double PROBABILIDAD = 0.25;
	
	public static Celda crearCeldaConSimbolo(char simbolo) {
		
		switch (simbolo) { 
			case 'x' : if(Math.random() < PROBABILIDAD) { // calculo de probabilidad de que una celda viva enferme
							return new CeldaEnferma();
						}else {
							return new CeldaViva();
						}
			case 'e' : return new CeldaEnferma(); 
			case '.' : return new CeldaMuerta();
			case 'l' : return new CeldaLatente();
				default: throw new IllegalArgumentException("Error al cargar simbolo "+ simbolo);
		}
	}
	
	public static Celda crearCeldaAleatoria() {
		int probabilidad = (int) (Math.random()*4); // generamos un numero aleatorio 
		Celda nuevaCelda = new CeldaMuerta();
		
		switch(probabilidad) {  // segun el numero aleatorio la celda que se va crear 
			case 0: nuevaCelda = new CeldaViva(); break;
			case 1: nuevaCelda = new CeldaMuerta(); break;
			case 2: nuevaCelda = new CeldaEnferma(); break;
			case 3: nuevaCelda = new CeldaEnferma(); break;
		}
		return nuevaCelda; 
	}
}
