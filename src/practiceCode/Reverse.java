package practiceCode;

public class Reverse {

    void main(){
        String s= "amsa";

        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
        int[] arr={2,3,4,7,1};

    }

    void quickSort(int arr[]){
        int highIndex=arr.length - 1;
        int lowPointer = 0;

    }
}
