package practiceCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class HighestNumber {

    //find the highest number in list

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(11,2,5,1,8,4,3,10);
        System.out.println("Maximum number in stream::"+list.stream().max(Comparator.naturalOrder()));
        final List<Integer> limit = list.stream().sorted(Comparator.reverseOrder()).limit(2).toList();
        System.out.println(limit.get(1));

    }
}
