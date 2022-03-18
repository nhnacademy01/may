package day11.oop1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyBytes {
    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("source.txt");
             FileOutputStream out = new FileOutputStream("replica.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}


