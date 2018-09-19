package my.examples.pairwas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Connector extends Thread{
    private int port;
    private Set<InetAddress> InetAddresses = new HashSet<>();
    private DefaultServlet defaultServlet;

    public Connector(int port, DefaultServlet defaultServlet){
        this.port = port;
        this.defaultServlet = defaultServlet;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);


            while (true){
                Socket socket = serverSocket.accept();
                if(InetAddresses.add(socket.getInetAddress())) {
                    Handler handler = new Handler(this, socket);
                    handler.start();
                    System.out.println("connection의 value:" + handler.getHeaderData().get("Connection"));

                }
            }


        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public DefaultServlet getDefaultServlet() {
        return defaultServlet;
    }
}
