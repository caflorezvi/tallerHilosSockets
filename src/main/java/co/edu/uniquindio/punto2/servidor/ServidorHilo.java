package co.edu.uniquindio.punto2.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Esta clase representa el hilo que atiende a cada cliente
 * que se conecta al servidor y le envía un número para
 * que sea acumulado si es par
 * @author caflorezvi
 */
public class ServidorHilo extends Thread{

    private final Observador observer;
    private final Socket socket;

    /**
     * Constructor de la clase ServidorHilo
     * @param observer Observador que se notifica cuando se acumula un número par
     * @param socket Socket por el cual se comunica con el cliente
     */
    public ServidorHilo(Observador observer, Socket socket){
        this.observer = observer;
        this.socket = socket;
    }

    @Override
    public void run() {

        try{

            //Se lee el número enviado por el cliente
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Object object = in.readObject();
            int numero = (Integer) object;

            //Se acumula el número si es par
            if(numero%2 == 0){
                //Se notifica al observador
                observer.acumularNumero(numero);
            }

            //Se cierra el flujo de entrada y el socket
            in.close();
            socket.close();

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
