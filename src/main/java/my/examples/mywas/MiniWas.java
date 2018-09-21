package my.examples.mywas;

public class MiniWas extends Thread{
    int port;

    public MiniWas(){
    }

    @Override
    public void run() {
        Connector connector = new Connector(8888);
        connector.run();
    }
}
