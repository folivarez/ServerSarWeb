/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author fede
 *
 *
 */
public class lanzarSocket {

    public ArrayList<String> a_victima = null;

    public ArrayList<String> startSocket() {
        final int PUERTO = 6004;

        ServerSocket socketServer;
        Socket socket;
//        DataOutputStream salida;
        DataOutputStream salida;
        String mensajeRecibido;
        //BufferedReader entrada;
        ObjectInputStream entrada;

        try {
            socketServer = new ServerSocket(PUERTO);/* crea socketServer servidor que escuchara en puerto 6004*/

            while (true) {
                socket = new Socket();
                System.out.println("Esperando una conexión:");
                socket = socketServer.accept();
                System.out.println("ip_" + socket.getLocalAddress().toString());

//Inicia el socketServer, ahora esta esperando una conexión por parte del cliente
                System.out.println("Un cliente se ha conectado.");

//Canales de entrada y salida de datos
                //entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                entrada = new ObjectInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());
                System.out.println("Confirmando conexion al cliente....");
                salida.writeUTF("Conexión exitosa envia un mensaje :D");

                a_victima = new ArrayList<String>();
                a_victima = (ArrayList<String>) entrada.readObject();

//Recepcion de mensaje
                //mensajeRecibido = entrada.readLine();
                //System.out.println(mensajeRecibido);
                salida.writeUTF("Se recibio tu mensaje.");

                socketServer.close();//Aqui se cierra la conexión con el cliente
                salida.writeUTF("Terminando conexion...");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return a_victima;
 
    }

}
