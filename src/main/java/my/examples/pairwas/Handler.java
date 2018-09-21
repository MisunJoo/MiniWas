package my.examples.pairwas;

import java.io.*;
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

        InputStream in = null;
        OutputStream out = null;

        try{

            in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            out = socket.getOutputStream();
            PrintWriter pr = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out, pr);

            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);

        }
        catch (Exception e){ }
        finally {
            try {
                in.close();
            }catch (IOException ioe){}
            try {
                out.close();
            }catch (IOException ioe){}
        }
    }



    public String[] getFirstIndex() {
        return firstIndex;
    }

    public Map<String, String> getHeaderData() {
        return headerData;
    }
}
