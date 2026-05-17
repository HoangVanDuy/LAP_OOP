package hust.soict.globalict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.txt";
        byte[] inputbytes = {0};
        long Start, End;
        try {
            inputbytes = Files.readAllBytes(Paths.get(filename));
            Start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for(byte b : inputbytes) {
                sb.append((char)b);
            }
            sb.toString();
            End = System.currentTimeMillis();
            System.out.println(End - Start);
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}

