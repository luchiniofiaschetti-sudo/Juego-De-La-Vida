# Juego de la Vida - TP-L 2026

Este trabajo especial consiste en crear un tablero de celdas que evoluciona segun condiciones especificas sobre sus vecinos.

---

## Clases principales

### Celda
- getEstado(), devuelve si esta viva o muerta
- getSimbolo()
- proximaGeneracion()
- Subclases: CeldaViva, CeldaEnferma, CeldaLatente, etc. (cada una con su lógica de evolución)

### Tablero
- matrizCelda
- agregarCelda()
- cantidadVecinos()
- nuevaGeneracion()
- cargarDesdeArchivo()
- cargaAleatoria()
- toString()

### CrearCelda
- crearCeldaPorSimbolo()
- crearCeldaAleatoria()

### JuegoDeLaVida
- jugarConIntervalosContinuos()
- jugarConRepeticiones()
- jugarConIntervalo_Repeticiones()

### Jugar
- opcionCarga()
- opcionJugabilidad()
- empezar()
- inicializarJuego()

### Main
- Se crea un Tablero y luego un Juego.

---

## Herramientas usadas
- TimerTask para jugabilidad con tiempo
- Scanner para ingresar valores
- BufferedReader para leer archivos .txt

---

## Extensiones posibles
1. Agregar un metodo abstracto en Celda (ejemplo: exposicionFronteriza) y en Tablero (cantidadCeldasLimitrofes) para nuevas reglas.
2. Crear nuevas subclases de Celda con su propia logica de evolución y agregarlas en CrearCelda.
3. Dentro del proyecto tenemos las clase ReglaEvolucion, las cuales no se usan actualmente pero son un enfoque para abstraer las regla de volucion.

---

## Nota de uso
Para probar el proyecto:
1. Crear un proyecto Java en Eclipse.
2. Copiar la carpeta trabajoEspecial dentro de src.
3. Copiar la carpeta ejemplos en el directorio del proyecto.
4. Ejecutar la clase Main y elegir modalidad de carga y jugabilidad. 
  Si cargamos desde archivo, colocamos la ruta al archivo deseado que estan en carpeta ejemplos 
