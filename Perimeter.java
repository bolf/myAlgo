import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class Perimeter {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_perimeter.txt"));
        Integer[] arr = Arrays.stream(allLines.get(1).split(" "))
                .map(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] < arr[i + 1] + arr[i + 2]) {
                System.out.println(arr[i] + arr[i + 1] + arr[i + 2]);
                break;
            }
        }
    }
}
