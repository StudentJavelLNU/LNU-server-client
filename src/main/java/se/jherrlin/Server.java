package se.jherrlin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import org.apache.commons.cli.*;

public class Server extends Host{

    byte[] buf;

    public Server(CommandLine cmd) throws IOException {
        super(cmd);
        buf = new byte[this.bufsize];
    }

    @Override
    public void run() {

        try{
            InetAddress inetAddress = InetAddress.getByName(this.ip);
            ServerSocket serverSocket = new ServerSocket(this.port, 5, inetAddress);
            serverSocket.setReuseAddress(true);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
