import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_bubble_sort.txt"));
        var arr = Arrays.stream(allLines.get(1).split(" ")).parallel().mapToInt(Integer::parseInt).toArray();
        sort(arr);
    }

    public static void sort(int[] arr) {
        var t = 0;
        var sorted = false;
        var l = arr.length-1;
        for (int count = l; !sorted && count >= 0; count--) {
            sorted = true;
            for (int i = 0; i < count; i++) {
                if (arr[i] > arr[i + 1]) {
                    t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    sorted = false;
                }
            }
            if (!sorted || count == l) {
                System.out.println(Arrays.stream(arr)
                        .parallel()
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
            }
        }
    }
}