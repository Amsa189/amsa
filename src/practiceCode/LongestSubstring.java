package practiceCode;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class LongestSubstring {

    void main(){
        String s = "amsaavveeni";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){

            String subStr = s.substring(i);
            System.out.println(subStr);
            map.put(subStr,subStr.length());
        }

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(findUniqueString(entry.getKey())){
                System.out.println("Found non repeatable substring::"+entry.getKey());
                break;
            }
        }
    }

    boolean findUniqueString(String inputStr){
        char[] charArr = inputStr.toCharArray();
        List<Character> charList = new ArrayList<>();
        for(char c:charArr){
            if(charList.contains(c))
            {
                return false;
            }else{
                charList.add(c);
            }
        }
        return true;
    }
}
