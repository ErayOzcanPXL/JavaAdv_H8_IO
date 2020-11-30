package be.pxl.ja;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.BufferedWriter;

public class FilesOefening1 {
    public static void main(String[] args) {
        SortedSet<String> sortedText = new TreeSet<>();
        Path path = Path.of("/home/eray/informatics/classes/2020-2021_pbtin_2/java_advanced/00_project/08_file_io/resources/");

        try {
            List<String> text = Files.readAllLines(path.resolve("bijlage1.txt"));
            sortedText = new TreeSet<>(text);

            //Files.deleteIfExists(path.resolve("output.txt"));
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path.resolve("output.txt"))) {
            for (String text : sortedText) {
                writer.write(text);
                writer.newLine();
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
