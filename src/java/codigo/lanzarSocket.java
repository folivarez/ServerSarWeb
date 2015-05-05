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
public class lanzarSocket extends Thread{

    public ArrayList<String> a_victima = null;
    public Thread t_lanzarSocket = null;

    public ArrayList<String> startSocket() {
        final int PUERTO = 6004;

         Thread t_lanzarSocket = new Thread(new Runnable() {

            @Override
            public void run() {

                ServerSocket socketServer;
                Socket socket;
                DataOutputStream salida;
                ObjectInputStream entrada;

                try {
                    socketServer = new ServerSocket(PUERTO);/* crea socketServer servidor que escuchara en puerto 6004*/

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
                    
                    while (!a_victima.isEmpty()){
                          Victima victima = new Victima(a_victima);
                        
                    } 
//Recepcion de mensaje
                    salida.writeUTF("Se recibio tu mensaje.");

                    socketServer.close();//Aqui se cierra la conexión con el cliente
                    salida.writeUTF("Terminando conexion...");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         
         t_lanzarSocket.start();
         
         return a_victima;
         
         
        

    }
    
    

}
