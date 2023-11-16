package co.edu.uniquindio.punto1;

/**
 * Clase que representa la solución al punto 1 del taller de hilos y sockets
 * @author caflorezvi
 */
public class SolucionPunto1 {

/**
     * Método que se encarga de sumar dos matrices de enteros
     * @param matriz1 Matriz de enteros
     * @param matriz2 Matriz de enteros
     * @return Matriz de enteros con la suma de las matrices de entrada
     * @throws InterruptedException
     */
    public int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) throws InterruptedException{

        //Se valida que ambas matrices tengan las mismas dimensiones
        if(matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length){
            throw new RuntimeException("Las matrices no tienen las mismas dimensiones");
        }

        //Se crea la matriz resultado con las mismas dimensiones de las matrices de entrada
        int[][] matrizResultado = new int[matriz1.length][matriz1[0].length];

        //Se crean los hilos, cada uno se encargará de sumar la mitad de las filas de las matrices de entrada
        HiloMatriz hilo1 = new HiloMatriz(matriz1, matriz2, matrizResultado, 0, matriz1.length/2);
        HiloMatriz hilo2 = new HiloMatriz(matriz1, matriz2, matrizResultado, matriz1.length/2, matriz1.length);

        //Se inician los hilos
        hilo1.start();
        hilo2.start();

        //Se espera a que los hilos terminen su ejecución
        hilo1.join();
        hilo2.join();

        //Se retorna la matriz resultado
        return matrizResultado;

    }

    /**
     * Método que se encarga de imprimir una matriz de enteros
     * @param matriz Matriz de enteros
     */
    public void imprimirMatriz(int[][] matriz) {
    	for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //Se crean las matrices de prueba
        int[][] matriz1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };

        int[][] matriz2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };

        //Se crea una instancia de la clase SolucionPunto1
        SolucionPunto1 solucionPunto1 = new SolucionPunto1();

        try {
            //Se suman las matrices
            int[][] matrizResultado = solucionPunto1.sumarMatrices(matriz1, matriz2);

            //Se imprime la matriz resultado
            solucionPunto1.imprimirMatriz(matrizResultado);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
