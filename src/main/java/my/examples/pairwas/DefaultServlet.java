package my.examples.pairwas;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DefaultServlet{
    private Request request;
    private Response response;
    private String[] firstIndex;
    private Map<String,String> headerData = new HashMap<>();
    public DefaultServlet(){

    }

    public void service(Request request, Response response){

        this.request = request;
        this.response = response;

        //응답하기
        String webPath = request.getPathName();
        if(webPath.equals("/")){
            webPath = webPath+"index.html";
        }

        String path = "/Users/misun/tmp/www"+webPath;
        File file = new File(path);

        OutputStream out = response.getOut();
        PrintWriter pr = response.getPr();

        if(file.exists()) {
            pr.println("HTTP/1.1 200 ok");
            pr.println("Content-Type: text/html; charset=UTF-8");
            pr.println("Content-Length: " + file.length());
            pr.println("");
            pr.flush();


            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] b = new byte[1024];
                int readCount = 0;

                while ((readCount = fis.read(b)) != -1) {
                    out.write(b, 0, readCount);
                    out.flush();
                }
            } catch (IOException e) {

            } finally {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
        }else{
            pr.println("HTTP/1.1 404 notFound");
            pr.println("Content-Type: text/html; charset=UTF-8");
            pr.println("");
            pr.flush();
        }






    }
}
