package se.jherrlin;

/**
 * Created by nils on 2/13/16.
 */

import java.io.*;
import java.net.*;

import se.jherrlin.Utils.*;

public class Client{
    public static void main(String[] args) {

        try{
            Socket socket = new Socket("localhost", 65000);

            DataOutputStream outToServer = new DataOutputStream( socket.getOutputStream() );
            outToServer.writeBytes("Herro server!\n");
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
