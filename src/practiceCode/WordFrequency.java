package practiceCode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {

    public static void main(String args[]){
        String line= "This is a word frequency test test word";
        final Map<String, Long> collect = Arrays.stream(line.split("\\s")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        collect.forEach((key, value) -> System.out.println(key + " count::" + value));


    }
}
