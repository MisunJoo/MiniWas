package my.examples.mywas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in;
    private BufferedReader br;
    private String methodName;
    private String pathName;

    private Map<String, String>headerData;

    public Request(InputStream in, BufferedReader br){
        this.in = in;
        this.br = br;

        headerData = new HashMap<>(); //**왜 여기서 생성을 할까????????????

        try {

            /*요청라인 처리*/
            String firstLine = br.readLine();
            String firsts[] = firstLine.split(" ");

            //잘못된 데이터 방지. 제대로된 데이터가 왔다면, firsts.length가 3보다 큼
           if(firsts.length > 2) {
               methodName = firsts[0];
               pathName = firsts[1];
           }

           /*헤더 처리*/
            String header = null;
            while((header = br.readLine())!= null){
                if(header.equals("")) break;

                String headerKey = null;
                String headerValue = null;

                //Connection: hel: lo 인 경우 거르기
                int index1 = header.indexOf(":");

                if(index1 != -1) {
                    headerKey = header.substring(0, index1);
                    headerValue = header.substring(index1 + 1).trim();
                }
                headerData.put(headerKey, headerValue);
            }

        }catch (Exception ex){
            throw new RuntimeException("잘못된 요청 : " + ex.toString());
        }
    }

    public String getPathName() {
        return pathName;
    }

    public Map<String, String> getHeaderData() {
        return headerData;
    }
}
