package co.edu.uniquindio.punto1;

/**
 * Esta clase representa un hilo que se encarga de sumar las filas de dos matrices
 * y guardar el resultado en una matriz resultado.
 * @author caflorezvi
 */
public class HiloMatriz extends Thread{

    private final int[][] matriz1;
    private final int[][] matriz2;
    private final int[][] matrizResultado;
    private final int filaInicial;
    private final int filaFinal;

    /**
     * Constructor de la clase HiloMatriz
     * @param matriz1 Matriz 1
     * @param matriz2 Matriz 2
     * @param matrizResultado Matriz resultado
     * @param filaInicial Fila inicial del rango de filas que se sumarán
     * @param filaFinal Fila final del rango de filas que se sumarán
     */
    public HiloMatriz(int[][] matriz1, int[][] matriz2, int[][] matrizResultado, int filaInicial, int filaFinal) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matrizResultado = matrizResultado;
        this.filaInicial = filaInicial;
        this.filaFinal = filaFinal;
    }

    @Override
    public void run() {

        // Suma de las matrices en el rango de filas asignado al hilo
        for(int i = filaInicial; i < filaFinal; i++){
            for(int j = 0; j < matriz1[0].length; j++){
                matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

    }
}
