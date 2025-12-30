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

    private void LC15() {
//        Code in JS 3 sum
//            let result = [];
//            nums.sort((a, b) => a - b);
//            for (let i = 0; i < nums.length - 2; i++) {
//                if (i > 0 && nums[i] === nums[i - 1]) continue;
//                let l = i + 1;
//                let r = nums.length - 1;
//                while (l < r) {
//                    let s = nums[i] + nums[l] + nums[r];
//                    if (s === 0) {
//                        result.push([nums[i], nums[l], nums[r]]);
//                        while (l < r && nums[l] === nums[l + 1]) l++;
//                        while (l < r && nums[r] === nums[r - 1]) r--;
//                        l++;
//                        r--;
//                    }
//                    else if (s < 0) {
//                        l++;
//                    }
//                    else {
//                        r--;
//                    }
//                }
//            }
//            return result;
//        };
    }
}
