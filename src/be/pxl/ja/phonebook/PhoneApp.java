package be.pxl.ja.phonebook;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;

public class PhoneApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SortedMap<String, Set<String>> phonebook = new TreeMap<>();
        Path path = Path.of("../../../../../resources/phonedirectory.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] lineContent = line.split(";");
                String[] phoneNumbers = Arrays.copyOfRange(lineContent, 1, lineContent.length);
                phonebook.put(lineContent[0].toLowerCase(), new HashSet<>(Arrays.asList(phoneNumbers)));
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        boolean running = true;
        while (running) {
            System.out.print("Geef een naam: ");
            String name = input.nextLine().toLowerCase();

            System.out.print("Geef een telefoonnummer: ");
            String phoneNumber = input.nextLine();

            if (phonebook.containsKey(name)) {
                if (!phonebook.get(name).add(phoneNumber))
                    throw new RuntimeException("phone number already mapped to " + name);
            } else {
                phonebook.put(name, new HashSet<>(Arrays.asList(phoneNumber)));
            }

            System.out.print("Wilt u nog namen toevoegen? (j/n) ");
            running = input.nextLine().equals("j");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            StringBuilder data = new StringBuilder();

            for (SortedMap.Entry<String, Set<String>> entry : phonebook.entrySet()) {
                data.append(entry.getKey()).append(";");
                data.append(String.join(";", entry.getValue()));
                data.append(System.getProperty("line.separator"));
            }

            writer.write(data.toString());
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        input.close();
    }
}
