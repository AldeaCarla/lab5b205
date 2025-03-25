import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomWordGenerator {
    public static void main(String[] args) {
        String outputFile = "outrand.txt";
        Random random = new Random();
        int wordsPerLine = 10;
        int lines = 5;
        int wordLength = 4;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < lines; i++) {
                ArrayList<String> words = new ArrayList<>();


                for (int j = 0; j < wordsPerLine; j++) {
                    StringBuilder word = new StringBuilder();
                    for (int k = 0; k < wordLength; k++) {
                        char letter = (char) ('a' + random.nextInt(26));
                        word.append(letter);
                    }
                    words.add(word.toString());
                }


                Collections.sort(words);


                writer.write(String.join(" ", words));
                writer.newLine();
            }
            System.out.println("Fișierul " + outputFile + " a fost generat cu succes!");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }
}
