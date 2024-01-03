public class MostWater {
    public int[] array = {1,8,6,2,5,4,8,3,7};

    void WaterContainer(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxSum = 0;
        while(left < right){
            int currentSum = Math.min(height[left],height[right]) * (right - left);
            maxSum = Math.max(maxSum, currentSum);

            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }

        System.out.println("The Max water that can be stored in Array of container is:"+maxSum);
    }

    public static void main(String[] args){
        MostWater m = new MostWater();
        m.WaterContainer(m.array);
    }
}
