package se.jherrlin;

/**
 * Created by nils on 2/12/16.
 */

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(65000);
        Socket socket;
        InputStream inputStream;
        OutputStream outputStream;
        byte[] buf;

        while (true){
            socket = serverSocket.accept();
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            do {
                buf = new byte[1024];
                inputStream.read(buf);
            }
            while (inputStream.available() != 0);

            System.out.println("Got from client: "+ new String(buf));
        }
    }
}
