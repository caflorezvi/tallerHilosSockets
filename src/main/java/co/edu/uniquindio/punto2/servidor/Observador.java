package co.edu.uniquindio.punto2.servidor;

/**
 * Esta interfaz representa el observador que se notifica
 * cuando se acumula un número par en el servidor
 * @author caflorezvi
 */
public interface Observador {

    /**
     * Método que se ejecuta cuando se acumula un número par
     * @param numero Número par que se acumuló
     */
    void acumularNumero(int numero);

}
