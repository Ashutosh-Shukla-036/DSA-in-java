/*The below code prints the max sum of Subarray in the array and prints the subarray. */
public class MaxSum {
    int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    void MaxSubarray(int[] A) {
        int max_sum = A[0];
        int current_sum = A[0];
        int temp = 0;
        int start = 0;
        int end = 0;
        for(int i=1 ; i<A.length ; i++){
            if(current_sum < 0){
                current_sum = A[i];
                temp = i ;
            }else{
                current_sum += A[i];
            }

            if(max_sum < current_sum){
                max_sum = current_sum;
                start = temp ;
                end = i;
            }
        }

        System.out.println("Max sum is:"+max_sum);
        System.out.print("Subarray is:");
        for(int i = start ; i <= end ; i++){
            System.out.print(A[i]+" ");
        }
    }

    public static void main(String[] args){
        MaxSum m = new MaxSum();
        m.MaxSubarray(m.array);
    }
}