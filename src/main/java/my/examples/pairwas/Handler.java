package my.examples.pairwas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Handler extends Thread {
    private Connector connector;
    private String[] firstIndex;
    private Socket socket;
    private Map<String, String> headerData = new HashMap<>();
    private String line;

    public Handler(Connector connector, Socket socket){
        this.connector = connector;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Server Start");
        BufferedReader in = null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String firstLine = in.readLine();
            firstIndex = firstLine.split("/");

            System.out.print("First Line Result : ");

            for(int i=0; i<firstIndex.length; i++)
            System.out.print(firstIndex[i]);

            System.out.println("");


            while(true){
                this.line = in.readLine();

                if(this.line.equals(""))break;

                String[] index = this.line.split(":");
                headerData.put(index[0],index[1]);

                System.out.println("Header Data Result : "+ index[0] + headerData.get(index[0]));
            }//while

            connector.getDefaultServlet().service(firstIndex,headerData);

        }
        catch (IOException ioe){ }
        finally {
            try {
                in.close();
            }
            catch (IOException io){}
        }



    }

    public String[] getFirstIndex() {
        return firstIndex;
    }

    public Map<String, String> getHeaderData() {
        return headerData;
    }
}
