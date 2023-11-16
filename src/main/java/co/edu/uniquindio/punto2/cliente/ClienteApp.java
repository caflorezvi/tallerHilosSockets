package co.edu.uniquindio.punto2.cliente;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Esta clase representa el cliente de la aplicación
 * que se conecta al servidor para enviarle un número
 * @author caflorezvi
 */
public class ClienteApp {

    public static void main(String[] args) {

        //Se crea el socket para conectarse al servidor en el puerto 1111
        try(Socket socket = new Socket("localhost", 1111)){

            System.out.println("Cliente conectado al servidor");

            //Se lee el número ingresado por el usuario
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese un numero: ");
            int numero = sc.nextInt();

            sc.close();

            //Se envía el número al servidor
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(numero);
            System.out.println("Numero enviado al servidor");

            //Se cierra el flujo de salida
            out.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
