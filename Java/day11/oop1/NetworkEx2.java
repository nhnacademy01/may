package day11.oop1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx2 {
    public static void main(String[] args) throws MalformedURLException {
        NetworkEx2 ex = new NetworkEx2();
        ex.wget();
    }

    private void wget() throws MalformedURLException {
        URL url = new URL("https://nhn.com/ci/NHN_CI.zip");
        try (BufferedInputStream input = new BufferedInputStream(url.openStream());
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("nhnci.zip"))) {
            byte[] buf = new byte[1024];
            int byteSize = 0;
            while ((byteSize = input.read(buf)) > -1) {
//                System.out.println(byteSize);
                output.write(buf, 0, byteSize);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
