package practiceCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SecondLargestNum {

    public static void main(String args[]){
        int[] arr={2,4,3,6,9,10,7};
        final int[] array = Arrays.stream(arr).sorted().toArray();
        System.out.println(array[array.length - 2]);

    }
}
