package pl.com.bottega.documentmanagement.decorator;

import pl.com.bottega.documentmanagement.application.CommandFactory;
import pl.com.bottega.documentmanagement.application.ConsoleApplication;

import java.io.*;
import java.util.Collection;

/**
 * Created by bernard.boguszewski on 27.08.2016.
 */
public class CaesarConsoleApplication {

    public static void main(String[] args) throws IOException {
        try {
            OutputStream o = new FileOutputStream("D:/topsecret.txt");
            CaesarOutputStream os = new CaesarOutputStream(o, 1);
            os.write("Ala ma kota".getBytes());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            InputStream in = new FileInputStream("D:/topsecret.txt");
            in = new CaesarInputStream(in, 1);
            int c = 0;
            while((c = in.read()) != -1)
                System.out.print((char)c);




        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

}
