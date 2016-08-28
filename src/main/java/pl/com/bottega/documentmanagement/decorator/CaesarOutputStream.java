package pl.com.bottega.documentmanagement.decorator;


import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by bernard.boguszewski on 27.08.2016.
 */
public class CaesarOutputStream extends OutputStream {


    private OutputStream o;
    private int key;

    public CaesarOutputStream(OutputStream o, int key) {
        this.o = o;
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        o.write(b+key);
    }

}
