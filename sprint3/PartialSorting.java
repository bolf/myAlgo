package sprint3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartialSorting {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("sprint3/input_partial_sorting.txt"));
        var lst = Arrays.stream(allLines.get(1).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        var count = new int[1];
        foo(lst,0, count);
        System.out.println(count[0]);
    }

    public static void foo(List<Integer> lst, int startInd, int[] count) {
        if (startInd >= lst.size())
            return;
        var minInd = startInd;
        for (int i = startInd + 1; i < lst.size(); i++) {
            if (lst.get(i) < lst.get(minInd))
                minInd = i;
        }
        var maxVal = lst.get(startInd);
        for (int i = startInd + 1; i < minInd; i ++) {
            if (lst.get(i) >= maxVal)
                maxVal = lst.get(i);
        }
        var curMax = maxVal;
        for (int i = minInd + 1; i < lst.size(); i++) {
            if (curMax < lst.get(i))
                curMax = lst.get(i);
            if (lst.get(i) <= maxVal) {
                minInd = i;
                if (curMax > maxVal)
                    maxVal = curMax;
            }
        }
        count[0]++;
        foo(lst,minInd + 1,count);
    }
}
