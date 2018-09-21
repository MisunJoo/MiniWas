package my.examples.pairwas;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {
    private OutputStream out;
    private PrintWriter pr;

    public Response(OutputStream out, PrintWriter pr){
        this.out = out;
        this.pr = pr;

    }

    public OutputStream getOut() {
        return out;
    }

    public PrintWriter getPr() {
        return pr;
    }
}
