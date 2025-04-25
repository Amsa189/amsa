package practiceCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddPartition {

    //even odd partition

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1,4,2,3,6,5,7,8);
        final Map<Boolean, List<Integer>> collect = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.partitioningBy(e -> e % 2 == 0, Collectors.toList()));
        System.out.println(collect);
    }
}
