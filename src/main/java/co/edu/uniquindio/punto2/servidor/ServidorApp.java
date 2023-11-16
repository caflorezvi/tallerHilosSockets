package co.edu.uniquindio.punto2.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase representa el servidor de la aplicación
 * que recibe un número del cliente y lo acumula si es par
 * para luego mostrar el total acumulado hasta el momento
 * en el servidor
 * @author caflorezvi
 */
public class ServidorApp implements Observador {

    private int acumulador;

    /**
     * Método que crea el servidor y se queda esperando
     * a que se conecten los clientes
     */
    public void crearServidor(){

        //Se crea el servidor en el puerto 1111
        try (ServerSocket servidor = new ServerSocket(1111)){

            System.out.println("Servidor iniciado en el puerto 1111");

            while (true) {

                //Se aceptan las conexiones de los clientes
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado");

                //Se crea un hilo para atender a cada cliente
                new ServidorHilo(this, socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void acumularNumero(int numero) {
        this.acumulador += numero;
        System.out.println("Total acumulado hasta el momento: " + acumulador);
    }

    public static void main(String[] args) {
        new ServidorApp().crearServidor();
    }

}