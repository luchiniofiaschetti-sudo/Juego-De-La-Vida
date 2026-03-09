package trabajoEspecial;

import java.util.Scanner;

public class Jugar {
	// en esta clase concentramos la ejecucion del juego, pedimos modalidad a ejecutar
	private Scanner lector = new Scanner(System.in); 
	private Tablero tablero;
	
	public Jugar(Tablero t) {
		this.tablero = t;
	}
	
	
	public void inicializarJuego() {  // metodo para usar en el main
		int modoCarga = metodoDeCarga();
		int modoJugabilidad = metodoDeJugabilidad();
		
		this.empezar(modoCarga, modoJugabilidad);
	}
	
	//metodo que desarrolla la juhabilidad segun las opciones elegidas
	public void empezar(int carga, int juego) {
		
		try { // para capturar error al cargar archivo
			if(carga == 1) { // si es opcion 1
				System.out.println("Ingrese archivo");
				String arch = lector.next();  // capturamos la ruta del archivo 
				tablero.cargarDesdeArchivo(arch); // la delegamos a metodo de Tablero
			}else { // si es la otra opcion (2)
				System.out.println("carga aleatoria..");
				tablero.cargaAleatoria(); // delegamos a tablero
			} 
		}catch(Exception e) { // captura de error y mostrar por consola
			System.out.println("Error al cargar archivo "+ e.getMessage());
		}
		
		JuegoDeLaVida jugar = new JuegoDeLaVida(tablero); // inicializamos jugar, para llamar al metodo de uso requerido
		
		if(juego == 1) { // si es opcion uno, se juega con intervamlos
			System.out.println("Ingrese tiempo de intervalos en segundos");
			int tiempo = lector.nextInt();
			jugar.jugarConIntervalosContinuos(tiempo);
		}else if(juego == 2){ // si es metodo dos se juego con repeticiones
			System.out.println("Ingrese cantidad de repeticiones");
			int repeticiones = lector.nextInt();
			jugar.jugarConRepeticionesCalculadas(repeticiones);
		}else if(juego == 3){
			System.out.println("Ingrese  tiempo y luego repeticion, ej: 1 5");
			int tiempo = lector.nextInt();
			int repeticion = lector.nextInt();
			jugar.jugarConTiempoRepeticiones(tiempo, repeticion);
		}
	}
	
	// metodos de carga y jugabilidad, pide elegir opcion y verifica se llegue a una opcion correcta.
	public int metodoDeCarga() {
		int opcion = 0;  //donde guardamos opcion elegida por el usuario con Scanner
		
		System.out.println("Elija opcion de carga:" + "\n" + "Opcion 1: Cargar desde archivo"+"\n"+"Opcion 2: Carga aleatoria");
		opcion = lector.nextInt();
		while(opcion != 1 && opcion != 2) { // mientras no sea una opcion correcta seguimos pidiendo 
			System.out.println("Ingrese opcion valida: 1 o 2");
			opcion = lector.nextInt();
		}
		return opcion;  //retornamos opcion elegida
	}
	
	public int metodoDeJugabilidad() {
		int opcion = 0;
		
		System.out.println("Elija opcion de jugabilidad:" +"\n"+ "Opcion 1: Jugar con intervalo" +"\n"+ "Opcion 2: Jugar con repeticion"+"\n"+"Opcion 3: Jugar con interervalos y repeticion");
		opcion = lector.nextInt();
		while(opcion != 1 && opcion != 2  && opcion != 3) {
			System.out.println("Ingrese opcion valida: 1, 2 o 3");
			opcion = lector.nextInt();
		}
		return opcion;
	}
}
