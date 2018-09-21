package my.examples.pairwas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in;
    private BufferedReader br;
    private String methodName;
    private String pathName;
    private Map<String, String> headerData;


    public Request(InputStream in, BufferedReader br) {
        this.in = in;
        this.br = br;
        headerData = new HashMap<>();


        //첫 번째 줄 (request line)
        try {
            String firstLine = br.readLine();
            String first[] = firstLine.split(" ");

            if(first.length > 2){
                methodName = first[0];
                pathName = first[1];
            }

            //헤더 데이터

            String headerLine = null;

            while ( (headerLine = br.readLine()) != null) {
                if (headerLine.equals("")) break;

                int index1 = headerLine.indexOf(":");

                String headerKey = null;
                String headerValue = null;

                if(index1 != -1){
                    headerKey = headerLine.substring(0, index1);
                    headerValue = headerLine.substring(index1 +1);
                }

                headerData.put(headerKey, headerValue);

                System.out.println("Header Data Result = " + headerKey + " : " + headerValue);
            }//while
        }catch (IOException ioe){}
    }


    public String getPathName() {
        return pathName;
    }

    public Map<String, String> getHeaderData() {
        return headerData;
    }
}
