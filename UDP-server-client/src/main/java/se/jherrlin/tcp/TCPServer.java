package se.jherrlin.tcp;

/**
 * Created by nils on 2/12/16.
 */

import org.apache.commons.cli.CommandLine;
import se.jherrlin.model.Host;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class TCPServer extends Host{

    byte[] buf;

    public TCPServer(CommandLine cmd) {
        super(cmd);
        buf = new byte[this.bufsize];
    }

    public void run() throws Exception{

        ServerSocket serverSocket = new ServerSocket(this.port);

        while(true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket, this.bufsize);
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

            String message = "";

            do {
                buf = new byte[bufsize];
                inputStream.read(buf);
                message += new String(buf).trim();
            }
            while (inputStream.available() != 0);

            System.out.println(socket.getInetAddress()+ " says " + message + " with a length of: " + message.length());
            Thread.sleep(200);
            outputStream.write(message.getBytes());

        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}



