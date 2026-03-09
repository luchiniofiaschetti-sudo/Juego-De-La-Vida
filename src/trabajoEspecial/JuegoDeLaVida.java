package trabajoEspecial;

import java.util.Timer;
import java.util.TimerTask;

public class JuegoDeLaVida {
	// en esta clase la idea es contener los metodos de jugabilidad del tablero, y mostrar por consola la evolucion
	private Tablero tablero;
	
	public JuegoDeLaVida(Tablero t) {
		this.tablero = t;
	}
	
	public void jugarConIntervalosContinuos(int tiempo) {
		final Timer t = new Timer();  // creamos objeto Timer
		long espera = tiempo*1000; // convertimos los segundos en milisegundos para implementacionTimer
		
		TimerTask tarea = new TimerTask() { // implementamos TimerStak
			int posicion = 0; // para usar como indice de conteo sobre generaciones
			public void run	() {				// con metodo correspondiente
				boolean proximaGeneracion = tablero.nuevaGeneracion();
				if(!proximaGeneracion) { // accion a ejecutar, si se cumple que hubo cambio
					System.out.println(tablero.toString()); 	//llamamos al String
					System.out.println("Proxima generacion " + "[" +posicion++ +"]" );//solamente para especificar evolucion
				}else { // si proximaGeneracion es true, significa no hubo cambios en la nueva generacion, entonces..
					System.out.println("No hubo cambios, el flujo termino");
					t.cancel();
				}
			}
		};
		t.scheduleAtFixedRate(tarea, 0, espera); // inicializamos metodo(tareaRealizar, inicializacion, tiempoRepeticion)
 	}
	
	public void jugarConRepeticionesCalculadas(int repeticiones) {
		int i = 0;
		boolean proximaGeneracion = false; //inicializamos en false, para trabajar en el while mientras no sean iguales
		
		while(i < repeticiones && proximaGeneracion == false) { // recorremos desde 0 hasta cantidad repeticiones indicadas
			
			System.out.println(tablero.toString());// mostramos tablero
			proximaGeneracion = tablero.nuevaGeneracion(); //llamamos a nueva generacion
			
			if(!proximaGeneracion) {		// si proxima generacion es false, significa que hubo cambios
				System.out.println("Proxima generacion: "+ (i+1));  
				i++;
			}else { // si nuevaGeneracion devolvio true en proximaGeneracion, no hubo cambios, corta el ciclo
				System.out.println("No hubo cambios en nueva generacion, el Juego termino");
			}
		}
	}
	
	public void jugarConTiempoRepeticiones(int tiempo, final int repeticiones) {
		final Timer t = new Timer();
		long crono = tiempo*1000;
		
		TimerTask tarea = new TimerTask() {
			int contador = 0;		// para ir sumando repeticiones y comparar con el parametro
			
			public void run () { // metodo de TimerTask
				if(contador < repeticiones) {  // si no llego al tope
					boolean proximaGeneracion = tablero.nuevaGeneracion();  // creamos nueva generacion
					if(!proximaGeneracion) { // accion a ejecutar, si no son iguales
						System.out.println(tablero.toString()); 	//llamamos al String
						System.out.println("Proxima generacion "+ contador);
						contador++;
					}else { // si no hubo cambios, son iguales el flujo corta
						System.out.println("No hubo cambios, el flujo termino");
						t.cancel(); 
					}
				}
			}
		};
		t.scheduleAtFixedRate(tarea, 0, crono); // iniciamos metodologia de Timer t.(tareaRealizar, Inicializacion, tiempoRetardo)
	};
}
