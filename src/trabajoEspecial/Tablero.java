package trabajoEspecial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tablero {
//clase que contiene la matriz de celdas con sus metodos,
	private int filas;
	private int columnas;
	private Celda[][] tablero;
	
	public Tablero(int f, int c) {
		this.filas = f;
		this.columnas = c;
		this.tablero = new Celda[this.filas][this.columnas];   // generamos la matriz(tablero) de Celdas
	}
	
	public void cargaAleatoria() {
		for(int f = 0; f < filas; f++) {  // recorremos cada fila por todos sus columnas con los for
			for(int c = 0; c < columnas; c++) {
				Celda celda = CrearCelda.crearCeldaAleatoria(); // delegamos creacion aleatoria con CrearCelda y su metodo
 				this.agregarCelda(f, c, celda); // agregamos la celda en posicion 
			}
		}
	}
	
	public void cargarDesdeArchivo(String texto) {
		BufferedReader archivo = null; // inicializamos, para leer los datos(texto)
		
		try {
			archivo = new BufferedReader(new FileReader(texto)); // abrimos el archivo
			String lineaFC = archivo.readLine(); // lectura de primer linea, filas columnas
			String[] filaColumna = lineaFC.split(" ");
			this.filas = Integer.parseInt(filaColumna[0]);
			this.columnas = Integer.parseInt(filaColumna[1]); // guardamos cada valor obtenido del array como numero
			
			this.tablero = new Celda[filas][columnas]; // creamos el tablero con fila columna adquirida de archivo
			
			for(int f = 0; f < filas; f++) {
				String lineas = archivo.readLine(); // obtenemos cada linea
				
				for(int c = 0; c < columnas; c++) {
					char simbolo = lineas.charAt(c); //obtenemos el simbolo de cada columna
					Celda nuevaCelda = CrearCelda.crearCeldaConSimbolo(simbolo); // creamos celda con CrearCelda
					this.agregarCelda(f, c, nuevaCelda);
				}
			}
		}
		catch(IOException e) {
			System.out.println("Error en lectura de archivo " + e.getMessage());
		}																			//capturamos posibles errores
		catch(NumberFormatException e) {
			System.out.println("Error en dimensiones " + e.getMessage());
		}
		finally {
			try {
				if(archivo != null) {
					archivo.close();   // si no quedo vacio cerramos archivo
				}
			}catch(IOException e) {
				System.out.println("Error al cerrar el archivo " + e.getMessage());// capturamos error 
			}
		}
	}
	
	public boolean nuevaGeneracion() {
		Celda[][] nuevaCelda = new Celda[this.filas][this.columnas]; // creo tablero nuevo
		boolean sonIguales = true; // lo uso para luego saber si el ciclo corta o continua
		
		for(int f = 0; f < this.filas; f++) {
			for(int c = 0; c < this.columnas; c++) {			//recorre la matriz completa
					int vecinos = cantidadVecinosVivos(f, c); 		//Consulta la cantidad vecinosVivos de dicha posicion
					Celda proximaGeneracion = tablero[f][c].proximaGeneracion(vecinos);//pedimos calcule su proximaGeneracion
					nuevaCelda[f][c] = proximaGeneracion; // la agregamos a matriz auxiciliar
			}
		}
		
		for(int f = 0; f < this.filas; f++) {			// reescribimos tablero, corroborando si hay cambios
			for(int c = 0; c < this.columnas; c++) {
				if(this.tablero[f][c].getSimbolo() != nuevaCelda[f][c].getSimbolo()) { //simbolos distintos, de celda actual
					sonIguales = false; 										// y copia, sonIguales = false(hubo cambios) 
				}
					this.tablero[f][c] = nuevaCelda[f][c]; //reescribimos el tablero
			}
		}
		return sonIguales; //retorna si no hubo cambios. Lo cual cortaria el ciclo
	} 
	
	public int cantidadVecinosVivos(int fila, int columna) {   // el tablero resuelve plazas de vecinos
		int vecinos = 0;
		
			for(int f = fila-1; f <= fila+1; f++) {
				for(int c = columna-1; c <= columna+1; c++) { // recorremos toda la matriz
					if(dentroDelLimite(f, c)) {  // corroboramos que este dentro del limite
						if(!(fila == f && columna == c)  && tablero[f][c] != null) { //obviamos la propia celda y el null
							Celda celda = tablero[f][c];	
							if(celda.getVive()) {  // si es celda viva sumamos vecino
								vecinos++;
							}
						}
					
					}
				}
			}
			return vecinos;
	}
	
	public boolean dentroDelLimite(int fila, int columna) {
		return (fila >= 0 && fila < this.filas) && (columna >= 0 && columna < this.columnas);
		//metodo para corroborar estar en los limites del tablero
	}
	
	public void agregarCelda(int f, int c, Celda celda) {
		if(dentroDelLimite(f, c)){
			this.tablero[f][c] = celda;
		}else {
			System.out.println("No existe la posicion indicada");
		}
	}
	
	public String toString() { 
		StringBuilder contenedor = new StringBuilder();  // tambien podriamos solamente usar un String e ir concatenando
		
		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < this.columnas; c++) { 
				
				if (tablero[f][c] != null) { 
					contenedor.append(tablero[f][c].getSimbolo()); // agregamos simbolo y si es null dejamos espacio
				}else{ 
					contenedor.append(" ");
				 } 
			} 
			contenedor.append("\n"); // salto de línea al terminar cada fila } return sb.toString(); }
		}
		return contenedor.toString(); // creamos string
	}
	
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}	
}
