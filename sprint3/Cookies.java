package sprint3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Cookies {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("sprint3/input_cookies.txt"));
        var childrenLst = Arrays.stream(allLines.get(1).split(" "))
                .parallel()
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        var cookiesMap = Arrays.stream(allLines.get(3).split(" "))
                .parallel()
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
        var count = 0;
        var keysLst = cookiesMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0, childrenLstSize = childrenLst.size(); i < childrenLstSize; i++) {
            var child = childrenLst.get(i);
            var cookie = cookiesMap.get(child);
            if (cookie != null) {
                count++;
                if (--cookie == 0) {
                    cookiesMap.remove(child);
                    keysLst.remove(child);
                } else
                    cookiesMap.put(child, cookie);
            } else {
                if (keysLst.isEmpty())
                    break;
                var key = keysLst.get(0);
                if (key > child) {
                    var ck = cookiesMap.get(key);
                    count++;
                    if (--ck == 0) {
                        cookiesMap.remove(key);
                        keysLst.remove(key);
                    } else
                        cookiesMap.put(key, ck);
                }
            }
        }
        System.out.println(count);
    }
}
