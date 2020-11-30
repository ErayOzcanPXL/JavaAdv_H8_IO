package be.pxl.ja;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.lang.Character;

public class IOstreamsOefening1 {
    public static void main(String[] args) {
        Path path = Path.of("/home/eray/informatics/classes/2020-2021_pbtin_2/java_advanced/00_project/08_file_io/resources/code.code");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (!Character.isLowerCase(line.charAt(i)))
                        System.out.print(line.charAt(i));
                }
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
