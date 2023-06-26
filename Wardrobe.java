import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Wardrobe {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_wardrobe.txt"));
        var arr = Arrays.stream(allLines.get(1).split(" "))
                .parallel()
                .filter(s->!s.isBlank())
                .mapToInt(Integer::valueOf)
                .toArray();
        int[] matr = {0,0,0};
        for (int k : arr) {
            matr[k]++;
        }
        var sb = new StringBuilder();
        for (int i = 0; i < matr.length; i++) {
            for (int j = matr[i]; j > 0; j--) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
