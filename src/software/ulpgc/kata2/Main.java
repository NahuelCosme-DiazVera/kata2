package software.ulpgc.kata2;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Person> people = TsvFilePersonLoader. with("hw_25000.tsv").load();
        Map<String, Integer> histogram = new WeightHistogramCalculator(people).calculate();
        for (String key : histogram.keySet().stream().sorted().collect(toList())) {
            System.out.println(key + " " + histogram.get(key));

        }
    }
}
