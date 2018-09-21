package my.examples.mywas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//서버에 연결
public class Connector {
    private int port;

    public Connector(int port){
        this.port = port;
    }

    public void run(){
        ServerSocket serverSocket = null;

        try {
            //ServerSocket  serverSocket = new ServerSocket(port);
            serverSocket = new ServerSocket(port);

            //ServerSocket은 계속 응답을 기다림
            while(true){
              Socket socket = serverSocket.accept();
              Handler handler = new Handler(socket);
              handler.start();
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            }catch (Exception ex){ }

        }
    }



}
