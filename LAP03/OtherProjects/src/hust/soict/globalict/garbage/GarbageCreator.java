package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt";
        byte[] inputbytes = { 0 };
        long start, end;

        try {
            inputbytes = Files.readAllBytes(Paths.get(filename));
            start = System.currentTimeMillis();

            String outputString = "";
            for (byte b : inputbytes) {
                outputString += (char)b;
            }

            end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
