package practiceCode;

import java.util.*;
import java.util.TreeSet;

public class TestList {

    void main(){

        HashMap<String,String> map=new HashMap<>();

        LinkedHashMap<String,String> linkMap = new LinkedHashMap<>();

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(9);

        System.out.println(treeSet.headSet(5,true));
        System.out.println(109/10);


        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        ListIterator<String> itr = list.listIterator();
        while(itr.hasNext()){
            String ele = (String)itr.next();
           if("C".equals(ele)){
               itr.add("B1");
           }
        }
        System.out.println(list);
//        for(String s: list){
//            list.add("D");
//        }

        LinkedList<String> linkedList = new LinkedList<>();
    }
}
