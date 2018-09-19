package my.examples.pairwas;

public class Main {
    public static void main(String[] args){
        DefaultServlet defaultServlet = new DefaultServlet();
        Connector connector = new Connector(13000,defaultServlet);
        connector.start();

    }
}
