import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sequence {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_sequence.txt"));
        var found = false;
        int j = 0;
        for (int i = 0; i < allLines.get(0).length(); i++) {
            char c = allLines.get(0).charAt(i);
            found = false;
            while (j < allLines.get(1).length()) {
                if (allLines.get(1).charAt(j) == c) {
                    found = true;
                    j++;
                    break;
                }
                j++;
            }
            if (!found) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}
