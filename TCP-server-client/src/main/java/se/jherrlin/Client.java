package se.jherrlin;

/**
 * Created by nils on 2/13/16.
 */

import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 65001);

        DataOutputStream outToServer = new DataOutputStream( socket.getOutputStream() );
        DataInputStream inputStream = new DataInputStream( socket.getInputStream() );
        byte[] buf;
        outToServer.writeBytes("Herro server!");

        Thread.sleep(200);

        do {
            buf = new byte[256];
            inputStream.read(buf);
        }
        while (inputStream.available() != 0);


        System.out.println("Server responded with: "+new String(buf));
        socket.close();

    }
}
