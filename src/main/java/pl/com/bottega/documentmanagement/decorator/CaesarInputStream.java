package pl.com.bottega.documentmanagement.decorator;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bernard.boguszewski on 27.08.2016.
 */
public class CaesarInputStream extends InputStream {

    private InputStream anyStream;
    private int key;

    public CaesarInputStream(InputStream anyStream, int key) {
        this.anyStream = anyStream;
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int r;
        while((r=anyStream.read())!= -1)
            return  r - key;
        return -1;
    }



}
