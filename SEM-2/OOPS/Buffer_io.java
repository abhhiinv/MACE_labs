/* Write a Java program to perform a copy of a text file. The program should read the contents
of a source file, convert all the text to Uppercase, and write the result into a new destination
file. Use BufferedInputStream & BufferedOutputStream.*/

import java.io.*;

public class Buffer_io {
    public static void main(String[] args) throws IOException {
        String src  = "source.txt";
        String dest = "destination.txt";

        try (
            BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(Character.toUpperCase((char) b));
            }
            System.out.println("File copied successfully with uppercase conversion.");
            System.out.println("Source      : " + src);
            System.out.println("Destination : " + dest);
        }
    }
}