package practiceCode;

import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatingChar {

    //find the first non-repeating character

    public static void main(String args[]){
        String sentence = "this is is first first this non non repeating amsa arun get";
        final Map<String, Long> collect = Arrays.stream(sentence.split("\\s")).collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        String[] arr = sentence.split("\\s");
        for(String s: arr){
            if(collect.containsKey(s)){
                if(1== collect.get(s)){
                    System.out.println("First Non Repeating char::"+s);
                    break;
                }
            }
        }

        final LinkedHashMap<String, Long> collect1 = Arrays.stream(sentence.split("\\s")).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect1.toString());
        Optional<String> firstNonRepeatWord = collect1.entrySet().stream().filter(entry->entry.getValue()==1).map(Map.Entry::getKey).findFirst();
        System.out.println("non repeating word using java 8::"+firstNonRepeatWord.get());

    }
}
