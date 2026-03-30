/*Write a Java program to perform a "Search and Replace" operation on a text file. The
program should read lines from the file, find the word to search and replace with the new
word and write to a second file.Give number of replacements made*/
import java.io.*;

public class SearchReplace {
    public static void main(String[] args) throws IOException {
        String inputFile  = "input.txt";
        String outputFile = "output.txt";
        String searchWord = "java";
        String replaceWord = "Python";
        int count = 0;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String newLine = line.replace(searchWord, replaceWord);
                int lineCount = (line.length() - line.replace(searchWord, "").length())
                                / searchWord.length();
                count += lineCount;
                bw.write(newLine);
                bw.newLine();
            }
        }

        System.out.println("Search word  : " + searchWord);
        System.out.println("Replace word : " + replaceWord);
        System.out.println("Replacements : " + count);
        System.out.println("Output saved to: " + outputFile);
    }
}