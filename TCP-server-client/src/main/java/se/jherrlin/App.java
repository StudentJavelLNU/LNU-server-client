package se.jherrlin;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(30);

        ServerSocket server = new ServerSocket(5555);

        while (true){
            try{
                Socket client = server.accept();
                executor.execute(new Handler(client));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static class Handler implements Runnable{

        private Socket client;

        public Handler(Socket client){
            this.client=client;
        }

        public void run(){

        }
    }
}


