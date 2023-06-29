import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ConferenceLovers {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_conference_lovers.txt"));
        var lim = Integer.parseInt(allLines.get(2));
        var map = Arrays.stream(allLines.get(1).split(" ")).
                map(Integer::valueOf)
                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));

        System.out.println(map.entrySet().stream()
                .map(integerLongEntry -> new int[]{integerLongEntry.getKey(), integerLongEntry.getValue().intValue()})
                .sorted(Comparator.comparingInt(o -> ((int[]) o)[1]).reversed()
                        .thenComparingInt(o -> ((int[]) o)[0]))
                .limit(lim)
                .map(o -> String.valueOf(((int[]) o)[0]))
                .collect(Collectors.joining(" ")));
    }
}
