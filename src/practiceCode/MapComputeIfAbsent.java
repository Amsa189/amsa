package practiceCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MapComputeIfAbsent {

    public static void main(String args[]) {

    List<String> words = List.of("apple", "banana", "cherry", "apricot", "blueberry", "apple", "banana");

    Map<String, Long> groupedByInitial = new HashMap<>();

    words.stream().collect(Collectors.groupingBy(val->val, Collectors.counting()));
    System.out.println(groupedByInitial);
    }

}
