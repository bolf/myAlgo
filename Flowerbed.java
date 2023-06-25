import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Flowerbed {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("input_flowerbed.txt"));
        allLines.remove(0);
        var pairLst = allLines.stream()
                .map(s -> {
                    var arr = s.split(" ");
                    return new Pair(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));})
                .sorted(Comparator.comparing(o -> o.a))
                .collect(Collectors.toList());
        var finalLst = new ArrayList<Pair>();
        var t = pairLst.get(0);
        finalLst.add(t);
        for (int i = 1; i < pairLst.size(); i++) {
            if (pairLst.get(i).a >= t.a && pairLst.get(i).a <= t.b && pairLst.get(i).b > t.b) {
                t.b = pairLst.get(i).b;
            } else if (!(pairLst.get(i).a >= t.a && pairLst.get(i).b <= t.b)) {
                if (!finalLst.contains(t))
                    finalLst.add(t);
                t = pairLst.get(i);
            }
        }
        if (!finalLst.contains(t))
            finalLst.add(t);
        finalLst.forEach(System.out::println);
    }

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }
}
