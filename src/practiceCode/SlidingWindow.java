package practiceCode;

public class SlidingWindow {

    void main(){
        int[] arr = {4,2,1,5,1,8};
        int k=3;
        //max sum sub array of length k
        System.out.println(calcMaxSumOfGivenSubArrLength(arr,k));
    }

    public static int calcMaxSumOfGivenSubArrLength(int[] arr, int k){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<arr.length;i++){
            currentSum += arr[i];
            if(i>= k-1){
                maxSum = Math.max(currentSum,maxSum);
                //delete the first element value, i=2,k=3
                currentSum = currentSum - arr[i-(k-1)];
            }
        }
        return maxSum;
    }
}
