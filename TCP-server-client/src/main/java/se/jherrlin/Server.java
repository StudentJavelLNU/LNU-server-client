package se.jherrlin;

/**
 * Created by nils on 2/12/16.
 */
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        Utils utils = new Utils();
        String clientSentence;

        try {
            serverSocket = new ServerSocket(65000);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Shuting down");
            System.exit(1);
        }

        while (true){
            try {
                System.out.println("Waiting for client.....");
                socket = serverSocket.accept();
                System.out.println("Client have connected.");
                BufferedReader inFromClient = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
                DataOutputStream outToClient = new DataOutputStream( socket.getOutputStream() );

                clientSentence = inFromClient.readLine();

                System.out.println("Recieved: " + clientSentence);

                System.out.println("Sending back data to client");
                outToClient.writeBytes("Hi client!\n");
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Shuting down");
                System.exit(1);
            }
        }
    }
}
