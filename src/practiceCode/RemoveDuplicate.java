package practiceCode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    //remove duplicate from the list

    public static void main(String args[]){
        String test = "I am removing duplicate duplicate I am";
        Set<String> distinct = Arrays.stream(test.split("\\s")).collect(Collectors.toSet());
        System.out.println(distinct);
    }
}
