package my.examples.pairwas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DefaultServlet{
    private String[] firstIndex;
    private Map<String,String> headerData = new HashMap<>();
    public DefaultServlet(){

    }

    public void service(String[] firstIndex,Map<String,String> headerData){

        this.firstIndex = firstIndex;
        this.headerData = headerData;

        System.out.println("divide start");

        String type = "/apng";
        Set<Map.Entry<String,String>> entrySet = headerData.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();

        System.out.println("firstIndex 출력 :" + this.firstIndex);

        System.out.println("before while");
        System.out.println("Connetcion의 value" + headerData.get("Connection"));

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String values = entry.getValue().toString();
            //String[] str = values.split("/");

            if(values.contains(type))   System.out.println("apng 타입 입니다.");


        }

    }
}
