package trabajoEspecial;

public class JuegoDeLaVida {
	// en esta clase la idea es contener los metodos de jugabilidad del tablero, y mostrar por consola la evolucion
	private Tablero tablero;
	
	public JuegoDeLaVida(Tablero t) {
		this.tablero = t;
	}
	
	public void jugarConIntervalosContinuos(){
		boolean sinCambios = false;
		
		while(!sinCambios) {
			sinCambios = tablero.nuevaGeneracion();
			System.out.println(tablero.toString()); 
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("No hubo más cambios, el juego terminó.");
 	}
	
	public void jugarConRepeticionesCalculadas(int repeticiones) {
		int i = 0;
		boolean sinCambios = false;
		
		while(i < repeticiones && sinCambios == false) {
			sinCambios = tablero.nuevaGeneracion();	
			System.out.println(tablero.toString());
			 
			if(!sinCambios) { 
				i++;
			}else{
				 System.out.println("No hubo más cambios, el juego terminó.");
			}
		}
	}
}
