package LC;

import java.util.Arrays;

public class problem2640 {
    public static void main(String[] args) {
    }

    private void LC2640() {
        //        2640. Find the Score of All Prefixes of an Array
        int [] nums = {1,1,2,4,8,16};
        long [] arr = new long[nums.length];
        int max = 0;
        for(int i = 0 ; i < nums.length; i++)  {
            max = Math.max(max, nums[i]);
            if(i == 0) {
                arr[i] = nums[i] + max;
            } else {
                arr[i] = nums[i] + max + arr[i - 1];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
