package se.jherrlin;

/**
 * Created by nils on 2/12/16.
 */

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(65001);

        while(true) {
            //When a new connection gets in create a new connection object
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket, 512);
            serverThread.start();
        }
    }
}

class ServerThread extends Thread {

    Socket socket;
    int bufsize;

    byte[] buf;
    InputStream inputStream;
    OutputStream outputStream;

    public ServerThread(Socket socket, int bufsize) {
        this.socket = socket;
        this.bufsize = bufsize;
    }

    @Override
    public void run(){
        try{
            inputStream = new DataInputStream(this.socket.getInputStream());
            outputStream = new DataOutputStream(this.socket.getOutputStream());

            Thread.sleep(200);

            do {
                buf = new byte[bufsize];
                inputStream.read(buf);

            }
            while (inputStream.available() != 0);

            System.out.println("Got from client: " + new String(buf));
            Thread.sleep(200);
            outputStream.write(trim(buf));

        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    static byte[] trim(byte[] bytes)
    {
        int i = bytes.length - 1;
        while (i >= 0 && bytes[i] == 0)
        {
            --i;
        }

        return Arrays.copyOf(bytes, i + 1);
    }
}


