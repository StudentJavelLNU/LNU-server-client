package se.jherrlin;

/**
 * Created by nils on 2/13/16.
 */

import java.io.*;
import java.net.*;
import se.jherrlin.Utils.*;

public class Client{
    public static void main(String[] args) {

        Socket socket = null;
        Utils utils = new Utils();
        String outgoingSentence = "Herro server";
        String incommingSentance;

        try{
            socket = new Socket("localhost", 65000);

            DataOutputStream outToServer = new DataOutputStream( socket.getOutputStream() );
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()) );

            outToServer.writeBytes(outgoingSentence+"\n");

            incommingSentance = inFromServer.readLine();

            System.out.println("From server: "+incommingSentance);

            socket.close();

        }
        catch (UnknownHostException e){
            e.printStackTrace();
            System.out.println("Shuting down");
            System.exit(1);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Shuting down");
            System.exit(1);
        }

    }
}
