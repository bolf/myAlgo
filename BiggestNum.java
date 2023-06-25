import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_biggest_num.txt"));
        Arrays.stream(allLines.get(1).split(" "))
                .parallel()
                .sorted(getComparator().reversed())
                .forEachOrdered(System.out::print);
    }

    public static Comparator<String> getComparator() {
        return (s, s1) -> {
            var t = Integer.valueOf(s + s1);
            var t1 = Integer.valueOf(s1 + s);
            return t.compareTo(t1);
        };
    }
}
