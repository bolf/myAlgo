package sprint3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HouseBuying {
    public static void main(String[] args) throws IOException {
        var allLines = Files.readAllLines(Path.of("sprint3/input_house_buying.txt"));
        var wantCount = Integer.parseInt(allLines.get(0).split(" ")[0]);
        var money = Integer.parseInt(allLines.get(0).split(" ")[1]);
        var housesPriceLst = Arrays.stream(allLines.get(1).split(" "))
                .map(Integer::parseInt)
                        .sorted().collect(Collectors.toList());
        var sum = 0;
        var count = 0;
        for (int i = 0; i < housesPriceLst.size(); i++) {
            var price = housesPriceLst.get(i);
            if (price + sum <= money) {
                count++;
                sum += price;
                if (count == wantCount) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
